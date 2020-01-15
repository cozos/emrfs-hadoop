package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.AbstractSet;
import java.util.Iterator;

final class $CustomConcurrentHashMap$Impl$KeySet
  extends AbstractSet<K>
{
  $CustomConcurrentHashMap$Impl$KeySet(.CustomConcurrentHashMap.Impl paramImpl) {}
  
  public Iterator<K> iterator()
  {
    return new .CustomConcurrentHashMap.Impl.KeyIterator(this$0);
  }
  
  public int size()
  {
    return this$0.size();
  }
  
  public boolean isEmpty()
  {
    return this$0.isEmpty();
  }
  
  public boolean contains(Object o)
  {
    return this$0.containsKey(o);
  }
  
  public boolean remove(Object o)
  {
    return this$0.remove(o) != null;
  }
  
  public void clear()
  {
    this$0.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Impl.KeySet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */