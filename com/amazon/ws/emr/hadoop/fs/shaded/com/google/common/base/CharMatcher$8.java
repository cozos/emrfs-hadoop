package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

final class CharMatcher$8
  extends CharMatcher.FastMatcher
{
  CharMatcher$8(String x0)
  {
    super(x0);
  }
  
  public boolean matches(char c)
  {
    return false;
  }
  
  public int indexIn(CharSequence sequence)
  {
    Preconditions.checkNotNull(sequence);
    return -1;
  }
  
  public int indexIn(CharSequence sequence, int start)
  {
    int length = sequence.length();
    Preconditions.checkPositionIndex(start, length);
    return -1;
  }
  
  public int lastIndexIn(CharSequence sequence)
  {
    Preconditions.checkNotNull(sequence);
    return -1;
  }
  
  public boolean matchesAllOf(CharSequence sequence)
  {
    return sequence.length() == 0;
  }
  
  public boolean matchesNoneOf(CharSequence sequence)
  {
    Preconditions.checkNotNull(sequence);
    return true;
  }
  
  public String removeFrom(CharSequence sequence)
  {
    return sequence.toString();
  }
  
  public String replaceFrom(CharSequence sequence, char replacement)
  {
    return sequence.toString();
  }
  
  public String replaceFrom(CharSequence sequence, CharSequence replacement)
  {
    Preconditions.checkNotNull(replacement);
    return sequence.toString();
  }
  
  public String collapseFrom(CharSequence sequence, char replacement)
  {
    return sequence.toString();
  }
  
  public String trimFrom(CharSequence sequence)
  {
    return sequence.toString();
  }
  
  public String trimLeadingFrom(CharSequence sequence)
  {
    return sequence.toString();
  }
  
  public String trimTrailingFrom(CharSequence sequence)
  {
    return sequence.toString();
  }
  
  public int countIn(CharSequence sequence)
  {
    Preconditions.checkNotNull(sequence);
    return 0;
  }
  
  public CharMatcher and(CharMatcher other)
  {
    Preconditions.checkNotNull(other);
    return this;
  }
  
  public CharMatcher or(CharMatcher other)
  {
    return (CharMatcher)Preconditions.checkNotNull(other);
  }
  
  public CharMatcher negate()
  {
    return ANY;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */