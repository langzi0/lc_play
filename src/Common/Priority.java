package Common;

/**
 * @author
 * @since 10/4/15
 */
public class Priority {

  public Integer Yymmdd;
  public Integer Seq;
  public Category Cat;
  public Integer getDaySeq(){return Yymmdd* 100 + Seq;}
  public Priority(Integer yymmdd, Integer seq, Category cat)
{
  Yymmdd = yymmdd;
  Seq = seq;
  Cat = cat;
}
}
