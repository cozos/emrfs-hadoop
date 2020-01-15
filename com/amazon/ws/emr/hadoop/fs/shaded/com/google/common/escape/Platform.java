package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated=true)
final class Platform
{
  static char[] charBufferFromThreadLocal()
  {
    return (char[])DEST_TL.get();
  }
  
  private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal()
  {
    protected char[] initialValue()
    {
      return new char['Ѐ'];
    }
  };
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.Platform
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */