package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

class LazyField$LazyIterator<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> iterator;
  
  public LazyField$LazyIterator(Iterator<Map.Entry<K, Object>> iterator)
  {
    this.iterator = iterator;
  }
  
  public boolean hasNext()
  {
    return iterator.hasNext();
  }
  
  public Map.Entry<K, Object> next()
  {
    Map.Entry<K, ?> entry = (Map.Entry)iterator.next();
    if ((entry.getValue() instanceof LazyField)) {
      return new LazyField.LazyEntry(entry, null);
    }
    return entry;
  }
  
  public void remove()
  {
    iterator.remove();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.LazyField.LazyIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */