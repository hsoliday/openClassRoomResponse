import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class QuestionReader
{
  Question q;
  boolean flag;
	public QuestionReader()
  {
    flag = false;
		JFileChooser fc = new JFileChooser();
		int returnValue = fc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION)
    {
			File file = fc.getSelectedFile();
      try
      {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        q = (Question)ois.readObject();
      }
      catch(Exception e)
      {
        System.out.println("ERROR READING FILE");
      }
		}
    System.out.println("END");
    flag =true;
  }
  public boolean hasQuestion()
  {
    return flag;
  }
}
