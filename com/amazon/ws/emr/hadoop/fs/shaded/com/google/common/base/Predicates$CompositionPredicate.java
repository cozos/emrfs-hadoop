package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$CompositionPredicate<A, B>
  implements Predicate<A>, Serializable
{
  final Predicate<B> p;
  final Function<A, ? extends B> f;
  private static final long serialVersionUID = 0L;
  
  private Predicates$CompositionPredicate(Predicate<B> p, Function<A, ? extends B> f)
  {
    this.p = ((Predicate)Preconditions.checkNotNull(p));
    this.f = ((Function)Preconditions.checkNotNull(f));
  }
  
  public boolean apply(@Nullable A a)
  {
    return p.apply(f.apply(a));
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof CompositionPredicate))
    {
      CompositionPredicate<?, ?> that = (CompositionPredicate)obj;
      return (f.equals(f)) && (p.equals(p));
    }
    return false;
  }
  
  public int hashCode()
  {
    return f.hashCode() ^ p.hashCode();
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(p.toString()));String str2 = String.valueOf(String.valueOf(f.toString()));return 2 + str1.length() + str2.length() + str1 + "(" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.CompositionPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */