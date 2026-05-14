package org.store.kingdomsimulation.Strategies;

import org.store.kingdomsimulation.GemMine;
import org.store.kingdomsimulation.Gems.Gem;

public class FastMining implements MiningStrategy
{

  @Override public Gem mine(GemMine mine)
  {
    return mine.getRandomGem();
  }

  @Override public int getMiningTime()
  {
    return 1000;
  }
}
