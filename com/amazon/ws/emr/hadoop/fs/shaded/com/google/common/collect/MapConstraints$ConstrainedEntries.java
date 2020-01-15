package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedEntries<K, V>
  extends ForwardingCollection<Map.Entry<K, V>>
{
  final MapConstraint<? super K, ? super V> constraint;
  final Collection<Map.Entry<K, V>> entries;
  
  MapConstraints$ConstrainedEntries(Collection<Map.Entry<K, V>> entries, MapConstraint<? super K, ? super V> constraint)
  {
    this.entries = entries;
    this.constraint = constraint;
  }
  
  protected Collection<Map.Entry<K, V>> delegate()
  {
    return entries;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    final Iterator<Map.Entry<K, V>> iterator = entries.iterator();
    new ForwardingIterator()
    {
      public Map.Entry<K, V> next()
      {
        return MapConstraints.access$500((Map.Entry)iterator.next(), constraint);
      }
      
      protected Iterator<Map.Entry<K, V>> delegate()
      {
        return iterator;
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
  
  public boolean contains(Object o)
  {
    return Maps.containsEntryImpl(delegate(), o);
  }
  
  public boolean containsAll(Collection<?> c)
  {
    return standardContainsAll(c);
  }
  
  public boolean remove(Object o)
  {
    return Maps.removeEntryImpl(delegate(), o);
  }
  
  public boolean removeAll(Collection<?> c)
  {
    return standardRemoveAll(c);
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return standardRetainAll(c);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedEntries
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */