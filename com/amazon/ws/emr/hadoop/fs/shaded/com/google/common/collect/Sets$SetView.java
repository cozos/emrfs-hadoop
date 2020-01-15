package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractSet;
import java.util.Set;

public abstract class Sets$SetView<E>
  extends AbstractSet<E>
{
  public ImmutableSet<E> immutableCopy()
  {
    return ImmutableSet.copyOf(this);
  }
  
  public <S extends Set<E>> S copyInto(S set)
  {
    set.addAll(this);
    return set;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.SetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */