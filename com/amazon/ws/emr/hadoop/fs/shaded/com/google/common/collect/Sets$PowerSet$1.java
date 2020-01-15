package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Set;

class Sets$PowerSet$1
  extends AbstractIndexedListIterator<Set<E>>
{
  Sets$PowerSet$1(Sets.PowerSet paramPowerSet, int x0)
  {
    super(x0);
  }
  
  protected Set<E> get(int setBits)
  {
    return new Sets.SubSet(this$0.inputSet, setBits);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.PowerSet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */