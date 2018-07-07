import java.util.List;
public class MultipleChoiceQuestion extends Question implements java.io.Serializable
{
  private List<String> answers;
  private String correct;
  public MultipleChoiceQuestion(List<String> ans,String ques,String cor)
  {
    answers = ans;
    question = ques;
    correct = cor;
  }
  public boolean isCorrect(String s)
  {
    if(s.equals(correct))
    {
      return true;
    }
    return false;
  }
  public boolean isMulti()
  {
    return true;
  }
  public List<String> outputAnswers()
  {
    return answers;
  }
  public boolean isRight(String s)
  {
    if(answers.contains(s))
    {
      if(correct.equals(s))
      {
        return true;
      }
    }
    return false;
  }
}
