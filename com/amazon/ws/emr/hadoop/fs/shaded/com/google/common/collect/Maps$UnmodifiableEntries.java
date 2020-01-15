package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class Maps$UnmodifiableEntries<K, V>
  extends ForwardingCollection<Map.Entry<K, V>>
{
  private final Collection<Map.Entry<K, V>> entries;
  
  Maps$UnmodifiableEntries(Collection<Map.Entry<K, V>> entries)
  {
    this.entries = entries;
  }
  
  protected Collection<Map.Entry<K, V>> delegate()
  {
    return entries;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    final Iterator<Map.Entry<K, V>> delegate = super.iterator();
    new UnmodifiableIterator()
    {
      public boolean hasNext()
      {
        return delegate.hasNext();
      }
      
      public Map.Entry<K, V> next()
      {
        return Maps.unmodifiableEntry((Map.Entry)delegate.next());
      }
    };
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.UnmodifiableEntries
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */