package org.store.kingdomsimulation;

import javafx.application.Application;
import org.store.kingdomsimulation.Strategies.FastMining;
import org.store.kingdomsimulation.Strategies.SlowMining;
import org.store.kingdomsimulation.Strategies.WoodenCoinMiningStrategy;

public class Launcher
{
  public static void main(String[] args)
  {
    GemMine mine = new GemMine();
    GemDeposit gemDeposit = new GemDeposit(10);

    GemMineWorker worker1 = new GemMineWorker("Worker 1", mine, gemDeposit, new SlowMining());
    GemMineWorker worker2 = new GemMineWorker("Worker 2", mine, gemDeposit, new FastMining());
    GemMineWorker worker3 = new GemMineWorker("Worker 3", mine, gemDeposit, new WoodenCoinMiningStrategy());

    GemTransporter transporter1 = new GemTransporter("Transporter 1", gemDeposit);
    GemTransporter transporter2 = new GemTransporter("Transporter 2", gemDeposit);

    new Thread(worker1).start();
    new Thread(worker2).start();
    new Thread(worker3).start();

    new Thread(transporter1).start();
    new Thread(transporter2).start();
  }
}
