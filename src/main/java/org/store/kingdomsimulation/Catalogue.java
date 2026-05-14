package org.store.kingdomsimulation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Catalogue
{
  private static Catalogue instance;
  private List<String> logs;

  private Catalogue(){
    logs = new ArrayList<>();
  }

  public static synchronized Catalogue getInstance(){
    if(instance == null){
      instance = new Catalogue();
    }
    return instance;
  }
  public synchronized void log(String message){
    logs.add(message);
    System.out.println(message);
  }

}
