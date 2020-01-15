package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;

final class Equivalence$Identity
  extends Equivalence<Object>
  implements Serializable
{
  static final Identity INSTANCE = new Identity();
  private static final long serialVersionUID = 1L;
  
  protected boolean doEquivalent(Object a, Object b)
  {
    return false;
  }
  
  protected int doHash(Object o)
  {
    return System.identityHashCode(o);
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence.Identity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */