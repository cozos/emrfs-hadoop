package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;

@GwtCompatible(serializable=true)
final class NaturalOrdering
  extends Ordering<Comparable>
  implements Serializable
{
  static final NaturalOrdering INSTANCE = new NaturalOrdering();
  private static final long serialVersionUID = 0L;
  
  public int compare(Comparable left, Comparable right)
  {
    Preconditions.checkNotNull(left);
    Preconditions.checkNotNull(right);
    return left.compareTo(right);
  }
  
  public <S extends Comparable> Ordering<S> reverse()
  {
    return ReverseNaturalOrdering.INSTANCE;
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public String toString()
  {
    return "Ordering.natural()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.NaturalOrdering
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */