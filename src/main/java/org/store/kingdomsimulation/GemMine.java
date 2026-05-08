package org.store.kingdomsimulation;

import org.store.kingdomsimulation.Gems.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GemMine
{
  private Map<String, Gem> gemTypes = new HashMap<>();

  public GemMine(){
    gemTypes.put("Diamond", new Diamond());
    gemTypes.put("Cow", new Cow());
    gemTypes.put("Gold Nugget", new Cow());
    gemTypes.put("Jewel", new Jewel());
    gemTypes.put("Wooden Coin", new WoodenCoin());
    gemTypes.put("Ruby", new Ruby());
  }

  public Gem getGem(String type)
  {
    return gemTypes.get(type);
  }

}
