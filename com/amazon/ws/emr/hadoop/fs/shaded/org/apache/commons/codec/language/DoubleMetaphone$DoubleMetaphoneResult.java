package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language;

public class DoubleMetaphone$DoubleMetaphoneResult
{
  private final StringBuilder primary = new StringBuilder(this$0.getMaxCodeLen());
  private final StringBuilder alternate = new StringBuilder(this$0.getMaxCodeLen());
  private final int maxLength;
  
  public DoubleMetaphone$DoubleMetaphoneResult(DoubleMetaphone paramDoubleMetaphone, int maxLength)
  {
    this.maxLength = maxLength;
  }
  
  public void append(char value)
  {
    appendPrimary(value);
    appendAlternate(value);
  }
  
  public void append(char primary, char alternate)
  {
    appendPrimary(primary);
    appendAlternate(alternate);
  }
  
  public void appendPrimary(char value)
  {
    if (primary.length() < maxLength) {
      primary.append(value);
    }
  }
  
  public void appendAlternate(char value)
  {
    if (alternate.length() < maxLength) {
      alternate.append(value);
    }
  }
  
  public void append(String value)
  {
    appendPrimary(value);
    appendAlternate(value);
  }
  
  public void append(String primary, String alternate)
  {
    appendPrimary(primary);
    appendAlternate(alternate);
  }
  
  public void appendPrimary(String value)
  {
    int addChars = maxLength - primary.length();
    if (value.length() <= addChars) {
      primary.append(value);
    } else {
      primary.append(value.substring(0, addChars));
    }
  }
  
  public void appendAlternate(String value)
  {
    int addChars = maxLength - alternate.length();
    if (value.length() <= addChars) {
      alternate.append(value);
    } else {
      alternate.append(value.substring(0, addChars));
    }
  }
  
  public String getPrimary()
  {
    return primary.toString();
  }
  
  public String getAlternate()
  {
    return alternate.toString();
  }
  
  public boolean isComplete()
  {
    return (primary.length() >= maxLength) && (alternate.length() >= maxLength);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */