package kea.gust;

public class GameOfOctopus extends Thread {


  @Override
  public void run() {
    System.out.println("New Squid added - Population: " + Octopus.getSquidCounter());
    Octopus otto = new Octopus();
    otto.gameThread.setName(otto.generateSquidName());
    otto.makeDoActivity(otto.gameThread.getName());
  }



}
