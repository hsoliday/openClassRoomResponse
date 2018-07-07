import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class GenerateQuestion extends JFrame
{
  public Question q;
  static boolean b;
  public GenerateQuestion()
  {
    super("Create Question");
    b= true;
    setSize(640,480);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setLayout(new FlowLayout());
    JTextField question = new JTextField(20);
    JTextField answer = new JTextField(20);
    JTextField answer2 = new JTextField(20);
    JTextField answer3 = new JTextField(20);
    JTextField answer4 = new JTextField(20);
    JTextField questionName = new JTextField(20);
    JButton create = new JButton("Create");
    add(questionName);
    add(question);
    add(answer);
    add(answer2);
    add(answer3);
    add(answer4);
    add(create);
    questionName.setText("Question name");
    question.setText("Question");
    answer.setText("Right Answer");
    answer2.setText("answers");
    answer3.setText("answers");
    answer4.setText("answers");
    create.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {
      if(answer2.getText().equals(""))
      {
        q = new FreeResponseQuestion(question.getText(),answer.getText());
      }
      else
      {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add(answer.getText());
        arr.add(answer2.getText());
        arr.add(answer3.getText());
        arr.add(answer4.getText());
        q = new MultipleChoiceQuestion(arr,question.getText(),answer.getText());
      }
      try
      {
        FileOutputStream fos = new FileOutputStream(questionName.getText()+".question");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(q);
        oos.close();
        fos.close();
      }
      catch(IOException ex)
      {
      }
      dispose();
    }});
    setVisible(true);
  }
  public boolean hasQuestion()
  {
    return q==null;
  }
}
