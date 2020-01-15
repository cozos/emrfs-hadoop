package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable=true)
final class UsingToStringOrdering
  extends Ordering<Object>
  implements Serializable
{
  static final UsingToStringOrdering INSTANCE = new UsingToStringOrdering();
  private static final long serialVersionUID = 0L;
  
  public int compare(Object left, Object right)
  {
    return left.toString().compareTo(right.toString());
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public String toString()
  {
    return "Ordering.usingToString()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.UsingToStringOrdering
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */