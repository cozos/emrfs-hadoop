package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language;

class ColognePhonetic$CologneOutputBuffer
  extends ColognePhonetic.CologneBuffer
{
  public ColognePhonetic$CologneOutputBuffer(ColognePhonetic paramColognePhonetic, int buffSize)
  {
    super(paramColognePhonetic, buffSize);
  }
  
  public void addRight(char chr)
  {
    data[length] = chr;
    length += 1;
  }
  
  protected char[] copyData(int start, int length)
  {
    char[] newData = new char[length];
    System.arraycopy(data, start, newData, 0, length);
    return newData;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.ColognePhonetic.CologneOutputBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */