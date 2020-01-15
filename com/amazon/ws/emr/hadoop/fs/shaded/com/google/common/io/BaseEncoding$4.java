package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.IOException;

final class BaseEncoding$4
  implements GwtWorkarounds.CharOutput
{
  int charsUntilSeparator = val$afterEveryChars;
  
  BaseEncoding$4(int paramInt, String paramString, GwtWorkarounds.CharOutput paramCharOutput) {}
  
  public void write(char c)
    throws IOException
  {
    if (charsUntilSeparator == 0)
    {
      for (int i = 0; i < val$separator.length(); i++) {
        val$delegate.write(val$separator.charAt(i));
      }
      charsUntilSeparator = val$afterEveryChars;
    }
    val$delegate.write(c);
    charsUntilSeparator -= 1;
  }
  
  public void flush()
    throws IOException
  {
    val$delegate.flush();
  }
  
  public void close()
    throws IOException
  {
    val$delegate.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.BaseEncoding.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */