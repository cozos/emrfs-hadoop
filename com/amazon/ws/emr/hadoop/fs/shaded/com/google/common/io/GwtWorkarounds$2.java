package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

final class GwtWorkarounds$2
  implements GwtWorkarounds.CharInput
{
  int index = 0;
  
  GwtWorkarounds$2(CharSequence paramCharSequence) {}
  
  public int read()
  {
    if (index < val$chars.length()) {
      return val$chars.charAt(index++);
    }
    return -1;
  }
  
  public void close()
  {
    index = val$chars.length();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.GwtWorkarounds.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */