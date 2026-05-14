package org.store.kingdomsimulation.Strategies;

import org.store.kingdomsimulation.GemMine;
import org.store.kingdomsimulation.Gems.Gem;

public interface MiningStrategy
{
  Gem mine(GemMine mine);
  int getMiningTime();
}
