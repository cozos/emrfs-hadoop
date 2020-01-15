package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class MutableTypeToInstanceMap$UnmodifiableEntry$1
  extends ForwardingSet<Map.Entry<K, V>>
{
  MutableTypeToInstanceMap$UnmodifiableEntry$1(Set paramSet) {}
  
  protected Set<Map.Entry<K, V>> delegate()
  {
    return val$entries;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return MutableTypeToInstanceMap.UnmodifiableEntry.access$000(super.iterator());
  }
  
  public Object[] toArray()
  {
    return standardToArray();
  }
  
  public <T> T[] toArray(T[] array)
  {
    return standardToArray(array);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */