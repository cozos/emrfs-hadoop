package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

class Funnels$SequentialFunnel<E>
  implements Funnel<Iterable<? extends E>>, Serializable
{
  private final Funnel<E> elementFunnel;
  
  Funnels$SequentialFunnel(Funnel<E> elementFunnel)
  {
    this.elementFunnel = ((Funnel)Preconditions.checkNotNull(elementFunnel));
  }
  
  public void funnel(Iterable<? extends E> from, PrimitiveSink into)
  {
    for (E e : from) {
      elementFunnel.funnel(e, into);
    }
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(elementFunnel));return 26 + str.length() + "Funnels.sequentialFunnel(" + str + ")";
  }
  
  public boolean equals(@Nullable Object o)
  {
    if ((o instanceof SequentialFunnel))
    {
      SequentialFunnel<?> funnel = (SequentialFunnel)o;
      return elementFunnel.equals(elementFunnel);
    }
    return false;
  }
  
  public int hashCode()
  {
    return SequentialFunnel.class.hashCode() ^ elementFunnel.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Funnels.SequentialFunnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */