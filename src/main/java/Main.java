import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
This project are for communication two players over synronized queue. It starts with
the first player message and continue until each player send 10 messages consecutively.
 */
public class Main
{

  private static final int MAX_MESSAGES= 1;
  public static void main(String[] args)
  {
    BlockingQueue<String> poll = new ArrayBlockingQueue<>(MAX_MESSAGES);
    //Create threads for each player
    Initiator firstPlayer = new Initiator(poll);
    Player secondPlayer = new Player(poll);
    new Thread(secondPlayer).start();
    new Thread(firstPlayer).start();
  }

}

