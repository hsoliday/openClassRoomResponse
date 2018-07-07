import java.util.List;
public class Question
{
  protected String question;
  public Question(){}
  public boolean isCorrect(String s){return false;}
  public List<String> outputAnswers(){ return null;}
  public String getQuestion()
  {
    return question;
  }
}
