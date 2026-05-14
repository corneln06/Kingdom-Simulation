package org.store.kingdomsimulation;

import org.store.kingdomsimulation.Gems.Gem;

import java.util.ArrayList;

public class GemDeposit
{
  private MyArrayList<Gem> gems;
  private int capacity;

  public GemDeposit(int capacity){
    this.capacity = capacity;
    gems = new MyArrayList<>();
  }
  public synchronized void put(Gem gem){
    while (gems.size() >= capacity){
      try{
        Catalogue.getInstance().log("Worker is waiting. Capacity full.");
        wait();
      }
      catch (Exception e)
      {
        throw new RuntimeException(e);
      }
    }
    gems.add(gem);
    Catalogue.getInstance().log(gem.getName() +" added to the stash with value of " + gem.getValue());
    notifyAll();
  }
  public synchronized Gem take(){
    while(gems.isEmpty()){
      try
      {
        Catalogue.getInstance().log("Transporter is waiting. Gem Deposit is empty.");
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    Gem gem = gems.remove(0);
    Catalogue.getInstance().log(gem.getName() + "was removed from the queue");
    notifyAll();

    return gem;
  }
}
