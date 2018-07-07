import java.io.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;
public class Server implements Runnable
{
  List<ClientThread> list;
  boolean b;
  public void end()
  {
    b=false;
    for(ClientThread t: list)
    {
      t.end();
    }
  }
  public void run()
  {
    b= true;
    list = new ArrayList<ClientThread>();
    try
    {
        ServerSocket ss= new ServerSocket(8080);
        while(b)
        {
          ClientThread g = new ClientThread(ss.accept());
          Thread conn = new Thread(g);
          list.add(g);
          conn.start();
        }
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }
  public void broadcastQuestion(Question q)
  {
    for(ClientThread t :list)
    {
      t.broadcast(q);
    }
  }
  public void pollAnswers(double i)
  {
    try
    {
    FileWriter fileWriter = new FileWriter("outFile.txt");
    PrintWriter printWriter = new PrintWriter(fileWriter);
    for(ClientThread t :list)
    {
      printWriter.printf("%s:%2.1f%n",t.getCredentials().userName,(((double)t.getCount())/i)*100.0);
    }
    printWriter.close();
    }
    catch(Exception e)
    {

    }

  }

}
