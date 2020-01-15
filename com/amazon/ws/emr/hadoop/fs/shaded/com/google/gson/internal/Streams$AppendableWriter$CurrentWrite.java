package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

class Streams$AppendableWriter$CurrentWrite
  implements CharSequence
{
  char[] chars;
  
  public int length()
  {
    return chars.length;
  }
  
  public char charAt(int i)
  {
    return chars[i];
  }
  
  public CharSequence subSequence(int start, int end)
  {
    return new String(chars, start, end - start);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.Streams.AppendableWriter.CurrentWrite
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */