package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.List;

class ConcurrentHashMultiset$EntrySet
  extends AbstractMultiset<E>.EntrySet
{
  private ConcurrentHashMultiset$EntrySet(ConcurrentHashMultiset paramConcurrentHashMultiset)
  {
    super(paramConcurrentHashMultiset);
  }
  
  ConcurrentHashMultiset<E> multiset()
  {
    return this$0;
  }
  
  public Object[] toArray()
  {
    return snapshot().toArray();
  }
  
  public <T> T[] toArray(T[] array)
  {
    return snapshot().toArray(array);
  }
  
  private List<Multiset.Entry<E>> snapshot()
  {
    List<Multiset.Entry<E>> list = Lists.newArrayListWithExpectedSize(size());
    
    Iterators.addAll(list, iterator());
    return list;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ConcurrentHashMultiset.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */