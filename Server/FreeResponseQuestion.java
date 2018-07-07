import java.util.List;
public class FreeResponseQuestion extends Question implements java.io.Serializable
{
  private String correct;
  public FreeResponseQuestion(String ques,String cor)
  {
    question = ques;
    correct = cor;
  }
  public List<String> outputAnswers()
  {
    return null;
  }
  public boolean isRight(String s)
  {
      if(correct.equals(s))
      {
        return true;
      }
    return false;
  }
  public boolean isMulti()
  {
    return false;
  }
}
