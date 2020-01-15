package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language;

class ColognePhonetic$CologneInputBuffer
  extends ColognePhonetic.CologneBuffer
{
  public ColognePhonetic$CologneInputBuffer(ColognePhonetic paramColognePhonetic, char[] data)
  {
    super(paramColognePhonetic, data);
  }
  
  public void addLeft(char ch)
  {
    length += 1;
    data[getNextPos()] = ch;
  }
  
  protected char[] copyData(int start, int length)
  {
    char[] newData = new char[length];
    System.arraycopy(data, data.length - this.length + start, newData, 0, length);
    return newData;
  }
  
  public char getNextChar()
  {
    return data[getNextPos()];
  }
  
  protected int getNextPos()
  {
    return data.length - length;
  }
  
  public char removeNext()
  {
    char ch = getNextChar();
    length -= 1;
    return ch;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.ColognePhonetic.CologneInputBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */