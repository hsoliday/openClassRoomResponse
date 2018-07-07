import java.net.*;
import java.io.*;
import java.util.*;
public class Test
{
  public static void main(String[] args) {
    try
    {
      Scanner scan = new Scanner(System.in);
    Socket socket = new Socket("127.0.0.1", 8080);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    out.println("USER1");
    out.println("USER1");
    out.flush();
    String line,str;
    while(true)
    {
    while (!(line = in.readLine()).equals(""))
    {
        System.out.println(line);
        if(line.equals("end"))
        {
          break;
        }
    };
    out.println(scan.next());
    out.flush();
  }
  }
  catch(Exception e)
  {
  System.out.println("DAS IST NICHT GUUD");
  }
  }
}
