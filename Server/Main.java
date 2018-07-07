import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame
{
  Server s;
  JButton createQuestion;
  JButton sendQuestion;
  JButton pollAnswer;
  FreeResponseQuestion q;
  double count;
  public Main()
  {
    super("openClassRoom Server");
    count = 0;
    setSize(640,480);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    s =new Server();
    setLayout( new FlowLayout() );
    createQuestion = new JButton("Create a Question");
    sendQuestion =  new JButton("Send a Question");
    pollAnswer = new JButton("Get Answers");
    createQuestion.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {
      GenerateQuestion g = new GenerateQuestion();
      while(!g.hasQuestion())
      {
      }
    }});
    sendQuestion.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {
      QuestionReader g = new QuestionReader();
      while(!g.hasQuestion())
      {
      }
      s.broadcastQuestion(g.q);
      count++;
    }});
    pollAnswer.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {
      s.pollAnswers(count);
    }});
    add(createQuestion);
    add(sendQuestion);
    add(pollAnswer);
    Thread k = new Thread(s);
    k.start();
    setVisible(true);
  }
  public static void main(String[] args)
  {
  Main main = new Main();
  }
}
