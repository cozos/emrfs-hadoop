package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.AbstractCollection;
import java.util.Iterator;

final class $CustomConcurrentHashMap$Impl$Values
  extends AbstractCollection<V>
{
  $CustomConcurrentHashMap$Impl$Values(.CustomConcurrentHashMap.Impl paramImpl) {}
  
  public Iterator<V> iterator()
  {
    return new .CustomConcurrentHashMap.Impl.ValueIterator(this$0);
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
    return this$0.containsValue(o);
  }
  
  public void clear()
  {
    this$0.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Impl.Values
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */