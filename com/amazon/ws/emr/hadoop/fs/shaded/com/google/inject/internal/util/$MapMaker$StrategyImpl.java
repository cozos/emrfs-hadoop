package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

class $MapMaker$StrategyImpl<K, V>
  implements Serializable, .CustomConcurrentHashMap.ComputingStrategy<K, V, .MapMaker.ReferenceEntry<K, V>>
{
  final .MapMaker.Strength keyStrength;
  final .MapMaker.Strength valueStrength;
  final ConcurrentMap<K, V> map;
  final long expirationNanos;
  .CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals;
  private static final long serialVersionUID = 0L;
  
  $MapMaker$StrategyImpl(.MapMaker maker)
  {
    keyStrength = .MapMaker.access$100(maker);
    valueStrength = .MapMaker.access$200(maker);
    expirationNanos = .MapMaker.access$300(maker);
    
    map = .MapMaker.access$400(maker).buildMap(this);
  }
  
  $MapMaker$StrategyImpl(.MapMaker maker, .Function<? super K, ? extends V> computer)
  {
    keyStrength = .MapMaker.access$100(maker);
    valueStrength = .MapMaker.access$200(maker);
    expirationNanos = .MapMaker.access$300(maker);
    
    map = .MapMaker.access$400(maker).buildComputingMap(this, computer);
  }
  
  public void setValue(.MapMaker.ReferenceEntry<K, V> entry, V value)
  {
    setValueReference(entry, valueStrength.referenceValue(entry, value));
    if (expirationNanos > 0L) {
      scheduleRemoval(entry.getKey(), value);
    }
  }
  
  void scheduleRemoval(K key, V value)
  {
    final WeakReference<K> keyReference = new WeakReference(key);
    final WeakReference<V> valueReference = new WeakReference(value);
    .ExpirationTimer.instance.schedule(new TimerTask()
    {
      public void run()
      {
        K key = keyReference.get();
        if (key != null) {
          map.remove(key, valueReference.get());
        }
      }
    }, TimeUnit.NANOSECONDS.toMillis(expirationNanos));
  }
  
  public boolean equalKeys(K a, Object b)
  {
    return keyStrength.equal(a, b);
  }
  
  public boolean equalValues(V a, Object b)
  {
    return valueStrength.equal(a, b);
  }
  
  public int hashKey(Object key)
  {
    return keyStrength.hash(key);
  }
  
  public K getKey(.MapMaker.ReferenceEntry<K, V> entry)
  {
    return (K)entry.getKey();
  }
  
  public int getHash(.MapMaker.ReferenceEntry entry)
  {
    return entry.getHash();
  }
  
  public .MapMaker.ReferenceEntry<K, V> newEntry(K key, int hash, .MapMaker.ReferenceEntry<K, V> next)
  {
    return keyStrength.newEntry(internals, key, hash, next);
  }
  
  public .MapMaker.ReferenceEntry<K, V> copyEntry(K key, .MapMaker.ReferenceEntry<K, V> original, .MapMaker.ReferenceEntry<K, V> newNext)
  {
    .MapMaker.ValueReference<K, V> valueReference = original.getValueReference();
    if (valueReference == .MapMaker.access$500())
    {
      .MapMaker.ReferenceEntry<K, V> newEntry = newEntry(key, original.getHash(), newNext);
      
      newEntry.setValueReference(new FutureValueReference(original, newEntry));
      
      return newEntry;
    }
    .MapMaker.ReferenceEntry<K, V> newEntry = newEntry(key, original.getHash(), newNext);
    
    newEntry.setValueReference(valueReference.copyFor(newEntry));
    return newEntry;
  }
  
  public V waitForValue(.MapMaker.ReferenceEntry<K, V> entry)
    throws InterruptedException
  {
    .MapMaker.ValueReference<K, V> valueReference = entry.getValueReference();
    if (valueReference == .MapMaker.access$500()) {
      synchronized (entry)
      {
        while ((valueReference = entry.getValueReference()) == .MapMaker.access$500()) {
          entry.wait();
        }
      }
    }
    return (V)valueReference.waitForValue();
  }
  
  public V getValue(.MapMaker.ReferenceEntry<K, V> entry)
  {
    .MapMaker.ValueReference<K, V> valueReference = entry.getValueReference();
    return (V)valueReference.get();
  }
  
  public V compute(K key, .MapMaker.ReferenceEntry<K, V> entry, .Function<? super K, ? extends V> computer)
  {
    V value;
    try
    {
      value = computer.apply(key);
    }
    catch (Throwable t)
    {
      setValueReference(entry, new .MapMaker.ComputationExceptionReference(t));
      
      throw new .ComputationException(t);
    }
    if (value == null)
    {
      String message = computer + " returned null for key " + key + ".";
      
      setValueReference(entry, new .MapMaker.NullOutputExceptionReference(message));
      
      throw new .NullOutputException(message);
    }
    setValue(entry, value);
    
    return value;
  }
  
  void setValueReference(.MapMaker.ReferenceEntry<K, V> entry, .MapMaker.ValueReference<K, V> valueReference)
  {
    boolean notifyOthers = entry.getValueReference() == .MapMaker.access$500();
    entry.setValueReference(valueReference);
    if (notifyOthers) {
      synchronized (entry)
      {
        entry.notifyAll();
      }
    }
  }
  
  private class FutureValueReference
    implements .MapMaker.ValueReference<K, V>
  {
    final .MapMaker.ReferenceEntry<K, V> original;
    final .MapMaker.ReferenceEntry<K, V> newEntry;
    
    FutureValueReference(.MapMaker.ReferenceEntry<K, V> original)
    {
      this.original = original;
      this.newEntry = newEntry;
    }
    
    public V get()
    {
      boolean success = false;
      try
      {
        V value = original.getValueReference().get();
        success = true;
        return value;
      }
      finally
      {
        if (!success) {
          removeEntry();
        }
      }
    }
    
    public .MapMaker.ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> entry)
    {
      return new FutureValueReference(.MapMaker.StrategyImpl.this, original, entry);
    }
    
    public V waitForValue()
      throws InterruptedException
    {
      boolean success = false;
      try
      {
        V value = waitForValue(original);
        success = true;
        return value;
      }
      finally
      {
        if (!success) {
          removeEntry();
        }
      }
    }
    
    void removeEntry()
    {
      internals.removeEntry(newEntry);
    }
  }
  
  public .MapMaker.ReferenceEntry<K, V> getNext(.MapMaker.ReferenceEntry<K, V> entry)
  {
    return entry.getNext();
  }
  
  public void setInternals(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals)
  {
    this.internals = internals;
  }
  
  private void writeObject(ObjectOutputStream out)
    throws IOException
  {
    out.writeObject(keyStrength);
    out.writeObject(valueStrength);
    out.writeLong(expirationNanos);
    
    out.writeObject(internals);
    out.writeObject(map);
  }
  
  private static class Fields
  {
    static final Field keyStrength = findField("keyStrength");
    static final Field valueStrength = findField("valueStrength");
    static final Field expirationNanos = findField("expirationNanos");
    static final Field internals = findField("internals");
    static final Field map = findField("map");
    
    static Field findField(String name)
    {
      try
      {
        Field f = .MapMaker.StrategyImpl.class.getDeclaredField(name);
        f.setAccessible(true);
        return f;
      }
      catch (NoSuchFieldException e)
      {
        throw new AssertionError(e);
      }
    }
  }
  
  private void readObject(ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    try
    {
      Fields.keyStrength.set(this, in.readObject());
      Fields.valueStrength.set(this, in.readObject());
      Fields.expirationNanos.set(this, Long.valueOf(in.readLong()));
      Fields.internals.set(this, in.readObject());
      Fields.map.set(this, in.readObject());
    }
    catch (IllegalAccessException e)
    {
      throw new AssertionError(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.StrategyImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */