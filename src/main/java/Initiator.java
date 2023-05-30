import java.util.concurrent.BlockingQueue;

/*
* This class extends from Player class where run function is overridden.
* */
class Initiator extends Player {
  private static final String INIT_MESSAGE = "initiating";

  public Initiator(BlockingQueue<String> poll) {
    super(poll);
  }

  /*Initiator starts the game and wait for reply. Every time it gets reply,
  * it answers until 10 messages are reached. */
  @Override
  public void run() {
    try {
      poll.put(INIT_MESSAGE);
    } catch (InterruptedException e) {
      throw new IllegalStateException("Failed to sent message", e);
    }
    System.out.printf("Player 1 send %s.%n", INIT_MESSAGE);
    while (true) {
      if (numberOfMessagesSent > 10) {
        break;
      }
      synchronized (poll) {
        if (turnCounter % 2 == 1) {
          String receivedMessage = receive();
          reply(receivedMessage);
        }
      }
    }
  }
}
