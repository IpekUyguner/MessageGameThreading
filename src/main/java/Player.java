import java.util.concurrent.BlockingQueue;

class Player implements Runnable
{
  protected final BlockingQueue<String> poll;
  protected static Integer turnCounter = 0;
  protected Integer numberOfMessagesSent = 0;
  public Player(BlockingQueue<String> poll)
  {
    this.poll = poll;
  }

  @Override
  public void run()
  {
    while (true)
    {
      //Play the game until 10 messages are reached.
      if(this.numberOfMessagesSent > 10) {
        break;
      }
      synchronized (poll)
      {
        //To take turn, wait until opponent send message.
        if(turnCounter%2 ==0)
        {
          String receivedMessage = receive();
          reply(receivedMessage);}
      }
    }
  }

  protected String receive()
  {
    String receivedMessage;
    try
    {
      receivedMessage = poll.take();
    }
    catch (InterruptedException interrupted)
    {
      throw new IllegalStateException("Player failed");
    }
    return receivedMessage;
  }

  /*
  * It recieve the message from other side as string and reply back
  * with appending the message by increasing number of total message.
  * */
  protected void reply(String receivedMessage)
  {
    String reply = receivedMessage + " " + (numberOfMessagesSent);
    try
    {
      this.numberOfMessagesSent += 1;
      poll.put(reply);
      turnCounter +=1;
      System.out.printf("Player %s send message %s.%n", this, reply);
      // Thread.sleep(10);
    }
    catch (InterruptedException e)
    {
      throw new IllegalStateException("Failed to send message");
    }
  }
}
