package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

final class Escapers$1
  extends CharEscaper
{
  public String escape(String string)
  {
    return (String)Preconditions.checkNotNull(string);
  }
  
  protected char[] escape(char c)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.Escapers.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */