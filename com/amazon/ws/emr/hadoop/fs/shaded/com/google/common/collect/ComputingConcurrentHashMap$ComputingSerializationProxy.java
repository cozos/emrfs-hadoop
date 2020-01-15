package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentMap;

final class ComputingConcurrentHashMap$ComputingSerializationProxy<K, V>
  extends MapMakerInternalMap.AbstractSerializationProxy<K, V>
{
  final Function<? super K, ? extends V> computingFunction;
  private static final long serialVersionUID = 4L;
  
  ComputingConcurrentHashMap$ComputingSerializationProxy(MapMakerInternalMap.Strength keyStrength, MapMakerInternalMap.Strength valueStrength, Equivalence<Object> keyEquivalence, Equivalence<Object> valueEquivalence, long expireAfterWriteNanos, long expireAfterAccessNanos, int maximumSize, int concurrencyLevel, MapMaker.RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> delegate, Function<? super K, ? extends V> computingFunction)
  {
    super(keyStrength, valueStrength, keyEquivalence, valueEquivalence, expireAfterWriteNanos, expireAfterAccessNanos, maximumSize, concurrencyLevel, removalListener, delegate);
    
    this.computingFunction = computingFunction;
  }
  
  private void writeObject(ObjectOutputStream out)
    throws IOException
  {
    out.defaultWriteObject();
    writeMapTo(out);
  }
  
  private void readObject(ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    in.defaultReadObject();
    MapMaker mapMaker = readMapMaker(in);
    delegate = mapMaker.makeComputingMap(computingFunction);
    readEntries(in);
  }
  
  Object readResolve()
  {
    return delegate;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ComputingConcurrentHashMap.ComputingSerializationProxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */