package kea.gust;

import java.util.Random;

public class Octopus extends Animal {
  static final Random random = new Random();
  static int squidCounter = 1;
  static final int min = 1;
  static final int max = 10;
  static final GameOfOctopus gameThread = new GameOfOctopus();

  public static int getSquidCounter() {
    return squidCounter;
  }
  public void makeDoActivity(String squidName) {

    for (;;) {
      //Pause for 4 seconds Yep
      try {
        String activity = selectActivity();
        System.out.printf("%-10s" +"%s",squidName+": ",activity+"\n");
        GameOfOctopus gameThread = new GameOfOctopus();
        if (activity.substring(0,4).equals("Mate")) {
          gameThread.start();
          squidCounter++;
        }
        if (activity.substring(0,3).equals("Die")) {
          gameThread.interrupt();
          squidCounter--;
          System.out.println("One Squid just died - Population: "+ squidCounter);
          break;
        }

        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

  public String selectActivity() {
    String activity;

    int activityNumber = random.nextInt(max)+min;

    switch (activityNumber) {
      case 1: activity = "Eat"+eat();
        break;
      case 2: activity = "Mate"+mate();
        break;
      case 4: activity = "Sleep"+sleep();
        break;
      case 5:
      case 6:
        activity = "Inc"+specialMove();
        break;
      case 7: activity = "Hide"+danger();
        break;
      case 8: //If statement for a greater chance to keep the population alive.
        if (squidCounter<=1) {
          activity = move();
        } else {
          activity = "Die" + die();
        }
        break;
      default: activity = "Move"+move();
    }

    return activity;
  }
//Thank you https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java/20536597 :)
  public static String generateSquidName() {
    String chars = "AEIOUK";
    StringBuilder squidName = new StringBuilder();
    Random random = new Random();
    while (squidName.length() < 7) { // length of the random string.
      int index = (int) (random.nextFloat() * chars.length());
      squidName.append(chars.charAt(index));
    }

    String completeName = squidName.substring(0,1)+squidName.substring(1, random.nextInt(6)+2).toLowerCase();
    return completeName.toString();
  }

  @Override
  public String move() {
    return "\n" +
            "       .'.\n" +
            "      .'-'.\n" +
            "   .  (  O O)\n" +
            "   \\_ ` _,   _\n" +
            "-.___'.)  ( ,-'\n" +
            "     '-.O.'-..-..\n" +
            " ./\\/\\/ | \\_.-._\n" +
            "        ;   ;\n" +
            "     ._/\n";
  }

  @Override
  public String eat() {
    return "\n" +
            "       .'.\n" +
            "      .'-'.\n" +
            "  .  (  ^ ^)   <=< \n" +
            "   \\_ `  _,<=<   _\n" +
            "'-.._'.) ( .---´  <=<\n" +
            "     '-.O.'-__.__\n" +
            " ./\\/\\/ | \\_.-._\n" +
            "        ;\n" +
            "     ._/\n";
  }

  @Override
  public String mate() {
    return "\n" +
            "   .    .'.\n" +
            "       .'-'.\n" +
            "  .   (  ♥ ♥)\n" +
            "   \\_ `  _,    _.\n" +
            "'-.__'.)  ( ,-'¨  \n" +
            "     '-.O.'-..--__.\n" +
            " ./\\/\\/ | \\_\n" +
            "      __;  :    ¨'-._\n" +
            "   ._/  \n";
  }

  @Override
  public String sleep() {
    return "\n" +
            "       .'.    z \n" +
            "      .'-'. z   \n" +
            "  .  (  - -)   \n" +
            "   \\_ `  _,   _\n" +
            "-.___'.) ( ,-'\n" +
            "     '-.O.'-..-..\n" +
            " ._.-._/ | \\_.-._\n" +
            "        ;  ;\n" +
            "     ._/\n";
  }

  @Override
  public String specialMove() {
    return "\n" +
            "        .'.\n" +
            "       .'-'.\n" +
            "  _   (  * *)\n" +
            "  \\__ `  _,   _\n" +
            "\\.___'.)  (,-'\n" +
            ". '  '-.O.'-..-..  ', .\n" +
            " ./\\/\\/ | \\_.-._  ' ' .\n" +
            "  _-;¨'.;  :.'\\;-_  .  ' \n" +
            "  ,':_/;´.´-¨;', ... \n";
  }


  @Override
  public String danger() {
    return "\n" +
            "       .'.\n" +
            "      .'-'.\n" +
            "   . (  ! !)\n" +
            "   \\_ `  _,  _\n" +
            "  '._'.) ( ,-'\n" +
            "     '-.O.'-..\n" +
            "   ./\\/ | \\_.-'\n" +
            "        ;  ;\n" +
            "       \\.\n";
  }

  @Override
  public String die() {
    return  "\n" +
            "   .    .'.    .\n" +
            "  .    .'-'.     .\n" +
            "      (  x X)\n" +
            "   _- `  _,   _\n" +
            "  ___'.)  ( '-,\n" +
            "'¨  _.-.O.'-...._\n" +
            "    /\\/ | \\_._._\n" +
            "  ./    ;\n" +
            "     ._/\n";
  }

}