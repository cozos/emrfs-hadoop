package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedAsMapEntries<K, V>
  extends ForwardingSet<Map.Entry<K, Collection<V>>>
{
  private final MapConstraint<? super K, ? super V> constraint;
  private final Set<Map.Entry<K, Collection<V>>> entries;
  
  MapConstraints$ConstrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> entries, MapConstraint<? super K, ? super V> constraint)
  {
    this.entries = entries;
    this.constraint = constraint;
  }
  
  protected Set<Map.Entry<K, Collection<V>>> delegate()
  {
    return entries;
  }
  
  public Iterator<Map.Entry<K, Collection<V>>> iterator()
  {
    final Iterator<Map.Entry<K, Collection<V>>> iterator = entries.iterator();
    new ForwardingIterator()
    {
      public Map.Entry<K, Collection<V>> next()
      {
        return MapConstraints.access$700((Map.Entry)iterator.next(), constraint);
      }
      
      protected Iterator<Map.Entry<K, Collection<V>>> delegate()
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
  
  public boolean equals(@Nullable Object object)
  {
    return standardEquals(object);
  }
  
  public int hashCode()
  {
    return standardHashCode();
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedAsMapEntries
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */