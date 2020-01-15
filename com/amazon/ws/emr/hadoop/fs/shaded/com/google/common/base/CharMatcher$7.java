package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.util.Arrays;

final class CharMatcher$7
  extends CharMatcher.FastMatcher
{
  CharMatcher$7(String x0)
  {
    super(x0);
  }
  
  public boolean matches(char c)
  {
    return true;
  }
  
  public int indexIn(CharSequence sequence)
  {
    return sequence.length() == 0 ? -1 : 0;
  }
  
  public int indexIn(CharSequence sequence, int start)
  {
    int length = sequence.length();
    Preconditions.checkPositionIndex(start, length);
    return start == length ? -1 : start;
  }
  
  public int lastIndexIn(CharSequence sequence)
  {
    return sequence.length() - 1;
  }
  
  public boolean matchesAllOf(CharSequence sequence)
  {
    Preconditions.checkNotNull(sequence);
    return true;
  }
  
  public boolean matchesNoneOf(CharSequence sequence)
  {
    return sequence.length() == 0;
  }
  
  public String removeFrom(CharSequence sequence)
  {
    Preconditions.checkNotNull(sequence);
    return "";
  }
  
  public String replaceFrom(CharSequence sequence, char replacement)
  {
    char[] array = new char[sequence.length()];
    Arrays.fill(array, replacement);
    return new String(array);
  }
  
  public String replaceFrom(CharSequence sequence, CharSequence replacement)
  {
    StringBuilder retval = new StringBuilder(sequence.length() * replacement.length());
    for (int i = 0; i < sequence.length(); i++) {
      retval.append(replacement);
    }
    return retval.toString();
  }
  
  public String collapseFrom(CharSequence sequence, char replacement)
  {
    return sequence.length() == 0 ? "" : String.valueOf(replacement);
  }
  
  public String trimFrom(CharSequence sequence)
  {
    Preconditions.checkNotNull(sequence);
    return "";
  }
  
  public int countIn(CharSequence sequence)
  {
    return sequence.length();
  }
  
  public CharMatcher and(CharMatcher other)
  {
    return (CharMatcher)Preconditions.checkNotNull(other);
  }
  
  public CharMatcher or(CharMatcher other)
  {
    Preconditions.checkNotNull(other);
    return this;
  }
  
  public CharMatcher negate()
  {
    return NONE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */