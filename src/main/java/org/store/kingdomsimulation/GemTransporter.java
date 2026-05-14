package org.store.kingdomsimulation;

import org.store.kingdomsimulation.Gems.Gem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GemTransporter implements Runnable
{
  private String name;
  private GemDeposit gemDeposit;
  private Random random;

  public GemTransporter(String name, GemDeposit gemDeposit){
    this.name = name;
    this.gemDeposit = gemDeposit;
    this.random = new Random();
  }


  @Override public void run()
  {
    while (true){
      int target =  random.nextInt(151) + 50;
      int total = 0;
      List<Gem> stash = new ArrayList<>();

      Catalogue.getInstance().log(name + " wants to transport gems worth at least " + target);

      while (total < target){
        Gem gem = gemDeposit.take();
        stash.add(gem);

        total+= gem.getValue();

        Catalogue.getInstance().log(name + " picked up " + gem.getName()+ ". Current value: " + total);
      }
      Catalogue.getInstance().log(name + " transported gems worth " + total);
      stash.clear();

      try
      {
        Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}
