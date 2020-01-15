package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$FunctionComposition<A, B, C>
  implements Function<A, C>, Serializable
{
  private final Function<B, C> g;
  private final Function<A, ? extends B> f;
  private static final long serialVersionUID = 0L;
  
  public Functions$FunctionComposition(Function<B, C> g, Function<A, ? extends B> f)
  {
    this.g = ((Function)Preconditions.checkNotNull(g));
    this.f = ((Function)Preconditions.checkNotNull(f));
  }
  
  public C apply(@Nullable A a)
  {
    return (C)g.apply(f.apply(a));
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof FunctionComposition))
    {
      FunctionComposition<?, ?, ?> that = (FunctionComposition)obj;
      return (f.equals(f)) && (g.equals(g));
    }
    return false;
  }
  
  public int hashCode()
  {
    return f.hashCode() ^ g.hashCode();
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(g));String str2 = String.valueOf(String.valueOf(f));return 2 + str1.length() + str2.length() + str1 + "(" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Functions.FunctionComposition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */