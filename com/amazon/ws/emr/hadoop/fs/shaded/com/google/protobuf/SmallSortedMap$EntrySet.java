package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class SmallSortedMap$EntrySet
  extends AbstractSet<Map.Entry<K, V>>
{
  private SmallSortedMap$EntrySet(SmallSortedMap paramSmallSortedMap) {}
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new SmallSortedMap.EntryIterator(this$0, null);
  }
  
  public int size()
  {
    return this$0.size();
  }
  
  public boolean contains(Object o)
  {
    Map.Entry<K, V> entry = (Map.Entry)o;
    V existing = this$0.get(entry.getKey());
    V value = entry.getValue();
    return (existing == value) || ((existing != null) && (existing.equals(value)));
  }
  
  public boolean add(Map.Entry<K, V> entry)
  {
    if (!contains(entry))
    {
      this$0.put((Comparable)entry.getKey(), entry.getValue());
      return true;
    }
    return false;
  }
  
  public boolean remove(Object o)
  {
    Map.Entry<K, V> entry = (Map.Entry)o;
    if (contains(entry))
    {
      this$0.remove(entry.getKey());
      return true;
    }
    return false;
  }
  
  public void clear()
  {
    this$0.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.SmallSortedMap.EntrySet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */