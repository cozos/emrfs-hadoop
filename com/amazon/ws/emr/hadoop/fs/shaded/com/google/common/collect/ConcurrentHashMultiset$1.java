package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class ConcurrentHashMultiset$1
  extends ForwardingSet<E>
{
  ConcurrentHashMultiset$1(ConcurrentHashMultiset paramConcurrentHashMultiset, Set paramSet) {}
  
  protected Set<E> delegate()
  {
    return val$delegate;
  }
  
  public boolean contains(@Nullable Object object)
  {
    return (object != null) && (Collections2.safeContains(val$delegate, object));
  }
  
  public boolean containsAll(Collection<?> collection)
  {
    return standardContainsAll(collection);
  }
  
  public boolean remove(Object object)
  {
    return (object != null) && (Collections2.safeRemove(val$delegate, object));
  }
  
  public boolean removeAll(Collection<?> c)
  {
    return standardRemoveAll(c);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ConcurrentHashMultiset.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */