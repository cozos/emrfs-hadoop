package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;

class Multimaps$CustomSortedSetMultimap<K, V>
  extends AbstractSortedSetMultimap<K, V>
{
  transient Supplier<? extends SortedSet<V>> factory;
  transient Comparator<? super V> valueComparator;
  @GwtIncompatible("not needed in emulated source")
  private static final long serialVersionUID = 0L;
  
  Multimaps$CustomSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> factory)
  {
    super(map);
    this.factory = ((Supplier)Preconditions.checkNotNull(factory));
    valueComparator = ((SortedSet)factory.get()).comparator();
  }
  
  protected SortedSet<V> createCollection()
  {
    return (SortedSet)factory.get();
  }
  
  public Comparator<? super V> valueComparator()
  {
    return valueComparator;
  }
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private void writeObject(ObjectOutputStream stream)
    throws IOException
  {
    stream.defaultWriteObject();
    stream.writeObject(factory);
    stream.writeObject(backingMap());
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private void readObject(ObjectInputStream stream)
    throws IOException, ClassNotFoundException
  {
    stream.defaultReadObject();
    factory = ((Supplier)stream.readObject());
    valueComparator = ((SortedSet)factory.get()).comparator();
    Map<K, Collection<V>> map = (Map)stream.readObject();
    setMap(map);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.CustomSortedSetMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */