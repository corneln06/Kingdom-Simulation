package org.store.kingdomsimulation;

import org.store.kingdomsimulation.Gems.Gem;
import org.store.kingdomsimulation.Strategies.MiningStrategy;

public class GemMineWorker implements Runnable
{
  private String name;
  private GemMine gemMine;
  private GemDeposit gemDeposit;
  private MiningStrategy miningStrategy;

  public GemMineWorker(String name, GemMine gemMine, GemDeposit gemDeposit, MiningStrategy miningStrategy){
    this.name = name;
    this.gemMine = gemMine;
    this.gemDeposit = gemDeposit;
    this.miningStrategy = miningStrategy;
  }


  @Override public void run()
  {
    while(true){
      Gem gem = miningStrategy.mine(gemMine);

      Catalogue.getInstance().log(name + " added " + gem.getName() + " into stash");
      gemDeposit.put(gem);

      try
      {
        Thread.sleep(
            miningStrategy.getMiningTime()
        );
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
