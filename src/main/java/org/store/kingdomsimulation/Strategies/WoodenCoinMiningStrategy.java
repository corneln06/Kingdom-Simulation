package org.store.kingdomsimulation.Strategies;

import org.store.kingdomsimulation.GemMine;
import org.store.kingdomsimulation.Gems.Gem;

public class WoodenCoinMiningStrategy implements MiningStrategy
{
  @Override public Gem mine(GemMine mine)
  {
    return mine.getGem("Diamond");
  }

  @Override public int getMiningTime()
  {
    return 2000;
  }
}
