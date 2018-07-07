import java.io.*;
import java.net.*;
import java.util.List;
public class ClientThread implements Runnable
{
  private BufferedReader in;
  private PrintWriter out;
  private boolean exit;
  private Socket socket;
  private int correctcount;
  private Credentials data;
  public ClientThread(Socket socket)
  {
    this.socket = socket;
    exit = false;
    correctcount =0;
    System.out.println("Connected");
  }
  public Credentials getCredentials()
  {
    return data;
  }
  public void end()
  {
    try
    {
    in.close();
    out.close();
    socket.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  public int getCount()
  {
    return correctcount;
  }
  public void run()
  {
    try
    {
       in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
       out= new PrintWriter(socket.getOutputStream(), true);
       data = new Credentials();
       data.userName = in.readLine();
       data.passWord = in.readLine();
    }
    catch (Exception e)
    {
      //e.printStackTrace();
    }
  }
  public void waitForResponse(Question q)
  {
    try
    {
      String line,str;
      while (!(line = in.readLine()).equals(""))
      {
        if(q.isCorrect(line))
        {
          correctcount++;
          break;
        }
        else
        {
          break;
        }
      }    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  public void broadcast(Question q)
  {
    out.println("question");
    out.println(q.getQuestion());
    List<String> j = q.outputAnswers();
    if(j!=null)
    {
      for(String s:j)
      {
        out.println(s);
      }
    }
    out.println("end");
    out.flush();
    waitForResponse(q);
  }
}
