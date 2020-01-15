package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class BoundedLinkedHashMap<K, V>
  extends LinkedHashMap<K, V>
{
  private static final long serialVersionUID = 1L;
  private final int maxSize;
  
  BoundedLinkedHashMap(int maxSize)
  {
    this.maxSize = maxSize;
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
  {
    return size() > maxSize;
  }
  
  int getMaxSize()
  {
    return maxSize;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.BoundedLinkedHashMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */