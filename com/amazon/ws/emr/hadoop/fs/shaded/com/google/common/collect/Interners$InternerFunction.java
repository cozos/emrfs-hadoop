package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

class Interners$InternerFunction<E>
  implements Function<E, E>
{
  private final Interner<E> interner;
  
  public Interners$InternerFunction(Interner<E> interner)
  {
    this.interner = interner;
  }
  
  public E apply(E input)
  {
    return (E)interner.intern(input);
  }
  
  public int hashCode()
  {
    return interner.hashCode();
  }
  
  public boolean equals(Object other)
  {
    if ((other instanceof InternerFunction))
    {
      InternerFunction<?> that = (InternerFunction)other;
      return interner.equals(interner);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Interners.InternerFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */