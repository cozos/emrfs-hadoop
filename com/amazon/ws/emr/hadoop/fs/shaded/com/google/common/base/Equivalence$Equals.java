package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;

final class Equivalence$Equals
  extends Equivalence<Object>
  implements Serializable
{
  static final Equals INSTANCE = new Equals();
  private static final long serialVersionUID = 1L;
  
  protected boolean doEquivalent(Object a, Object b)
  {
    return a.equals(b);
  }
  
  protected int doHash(Object o)
  {
    return o.hashCode();
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence.Equals
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */