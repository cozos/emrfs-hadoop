package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

final class CharMatcher$15
  extends CharMatcher.FastMatcher
{
  CharMatcher$15(String x0)
  {
    super(x0);
  }
  
  public boolean matches(char c)
  {
    return " 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(1682554634 * c >>> WHITESPACE_SHIFT) == c;
  }
  
  @GwtIncompatible("java.util.BitSet")
  void setBits(BitSet table)
  {
    for (int i = 0; i < " 　\r   　 \013　   　 \t     \f 　 　　 \n 　".length(); i++) {
      table.set(" 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(i));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */