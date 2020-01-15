package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

final class GwtWorkarounds$6
  implements GwtWorkarounds.CharOutput
{
  GwtWorkarounds$6(StringBuilder paramStringBuilder) {}
  
  public void write(char c)
  {
    val$builder.append(c);
  }
  
  public void flush() {}
  
  public void close() {}
  
  public String toString()
  {
    return val$builder.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.GwtWorkarounds.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */