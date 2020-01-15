package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

final class CharSource$EmptyCharSource
  extends CharSource.CharSequenceCharSource
{
  private static final EmptyCharSource INSTANCE = new EmptyCharSource();
  
  private CharSource$EmptyCharSource()
  {
    super("");
  }
  
  public String toString()
  {
    return "CharSource.empty()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.CharSource.EmptyCharSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */