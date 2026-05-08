package org.store.kingdomsimulation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Catalogue
{
  private static Catalogue instance;
  private List<String> logs;

  public Catalogue(){
    logs = new ArrayList<>();
  }

  public static Catalogue getInstance(){
    if(instance == null){
      instance = new Catalogue();
    }
    return instance;
  }
  public void log(String message){
    logs.add(message);
    System.out.println(message);
  }

}
