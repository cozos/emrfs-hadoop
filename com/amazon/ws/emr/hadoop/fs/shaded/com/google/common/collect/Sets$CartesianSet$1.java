package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.List;

final class Sets$CartesianSet$1
  extends ImmutableList<List<E>>
{
  Sets$CartesianSet$1(ImmutableList paramImmutableList) {}
  
  public int size()
  {
    return val$axes.size();
  }
  
  public List<E> get(int index)
  {
    return ((ImmutableSet)val$axes.get(index)).asList();
  }
  
  boolean isPartialView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.CartesianSet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */