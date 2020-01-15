package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher;
import java.io.IOException;

final class BaseEncoding$3
  implements GwtWorkarounds.CharInput
{
  BaseEncoding$3(GwtWorkarounds.CharInput paramCharInput, CharMatcher paramCharMatcher) {}
  
  public int read()
    throws IOException
  {
    int readChar;
    do
    {
      readChar = val$delegate.read();
    } while ((readChar != -1) && (val$toIgnore.matches((char)readChar)));
    return readChar;
  }
  
  public void close()
    throws IOException
  {
    val$delegate.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.BaseEncoding.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */