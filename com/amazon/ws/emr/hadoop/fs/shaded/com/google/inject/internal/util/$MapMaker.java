package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public final class $MapMaker
{
  private Strength keyStrength = Strength.STRONG;
  private Strength valueStrength = Strength.STRONG;
  private long expirationNanos = 0L;
  private boolean useCustomMap;
  private final .CustomConcurrentHashMap.Builder builder = new .CustomConcurrentHashMap.Builder();
  
  public MapMaker initialCapacity(int initialCapacity)
  {
    builder.initialCapacity(initialCapacity);
    return this;
  }
  
  public MapMaker loadFactor(float loadFactor)
  {
    builder.loadFactor(loadFactor);
    return this;
  }
  
  public MapMaker concurrencyLevel(int concurrencyLevel)
  {
    builder.concurrencyLevel(concurrencyLevel);
    return this;
  }
  
  public MapMaker weakKeys()
  {
    return setKeyStrength(Strength.WEAK);
  }
  
  public MapMaker softKeys()
  {
    return setKeyStrength(Strength.SOFT);
  }
  
  private MapMaker setKeyStrength(Strength strength)
  {
    if (keyStrength != Strength.STRONG) {
      throw new IllegalStateException("Key strength was already set to " + keyStrength + ".");
    }
    keyStrength = strength;
    useCustomMap = true;
    return this;
  }
  
  public MapMaker weakValues()
  {
    return setValueStrength(Strength.WEAK);
  }
  
  public MapMaker softValues()
  {
    return setValueStrength(Strength.SOFT);
  }
  
  private MapMaker setValueStrength(Strength strength)
  {
    if (valueStrength != Strength.STRONG) {
      throw new IllegalStateException("Value strength was already set to " + valueStrength + ".");
    }
    valueStrength = strength;
    useCustomMap = true;
    return this;
  }
  
  public MapMaker expiration(long duration, TimeUnit unit)
  {
    if (expirationNanos != 0L) {
      throw new IllegalStateException("expiration time of " + expirationNanos + " ns was already set");
    }
    if (duration <= 0L) {
      throw new IllegalArgumentException("invalid duration: " + duration);
    }
    expirationNanos = unit.toNanos(duration);
    useCustomMap = true;
    return this;
  }
  
  public <K, V> ConcurrentMap<K, V> makeMap()
  {
    return useCustomMap ? StrategyImplmap : new ConcurrentHashMap(builder.initialCapacity, builder.loadFactor, builder.concurrencyLevel);
  }
  
  public <K, V> ConcurrentMap<K, V> makeComputingMap(.Function<? super K, ? extends V> computer)
  {
    return StrategyImplmap;
  }
  
  private static abstract enum Strength
  {
    WEAK,  SOFT,  STRONG;
    
    private Strength() {}
    
    abstract boolean equal(Object paramObject1, Object paramObject2);
    
    abstract int hash(Object paramObject);
    
    abstract <K, V> .MapMaker.ValueReference<K, V> referenceValue(.MapMaker.ReferenceEntry<K, V> paramReferenceEntry, V paramV);
    
    abstract <K, V> .MapMaker.ReferenceEntry<K, V> newEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> paramInternals, K paramK, int paramInt, .MapMaker.ReferenceEntry<K, V> paramReferenceEntry);
    
    abstract <K, V> .MapMaker.ReferenceEntry<K, V> copyEntry(K paramK, .MapMaker.ReferenceEntry<K, V> paramReferenceEntry1, .MapMaker.ReferenceEntry<K, V> paramReferenceEntry2);
  }
  
  private static class StrategyImpl<K, V>
    implements Serializable, .CustomConcurrentHashMap.ComputingStrategy<K, V, .MapMaker.ReferenceEntry<K, V>>
  {
    final .MapMaker.Strength keyStrength;
    final .MapMaker.Strength valueStrength;
    final ConcurrentMap<K, V> map;
    final long expirationNanos;
    .CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals;
    private static final long serialVersionUID = 0L;
    
    StrategyImpl(.MapMaker maker)
    {
      keyStrength = keyStrength;
      valueStrength = valueStrength;
      expirationNanos = expirationNanos;
      
      map = builder.buildMap(this);
    }
    
    StrategyImpl(.MapMaker maker, .Function<? super K, ? extends V> computer)
    {
      keyStrength = keyStrength;
      valueStrength = valueStrength;
      expirationNanos = expirationNanos;
      
      map = builder.buildComputingMap(this, computer);
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
      if (valueReference == .MapMaker.COMPUTING)
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
      if (valueReference == .MapMaker.COMPUTING) {
        synchronized (entry)
        {
          while ((valueReference = entry.getValueReference()) == .MapMaker.COMPUTING) {
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
      boolean notifyOthers = entry.getValueReference() == .MapMaker.COMPUTING;
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
  
  private static final ValueReference<Object, Object> COMPUTING = new ValueReference()
  {
    public Object get()
    {
      return null;
    }
    
    public .MapMaker.ValueReference<Object, Object> copyFor(.MapMaker.ReferenceEntry<Object, Object> entry)
    {
      throw new AssertionError();
    }
    
    public Object waitForValue()
    {
      throw new AssertionError();
    }
  };
  
  private static <K, V> ValueReference<K, V> computing()
  {
    return COMPUTING;
  }
  
  private static abstract interface ValueReference<K, V>
  {
    public abstract V get();
    
    public abstract ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> paramReferenceEntry);
    
    public abstract V waitForValue()
      throws InterruptedException;
  }
  
  private static class NullOutputExceptionReference<K, V>
    implements .MapMaker.ValueReference<K, V>
  {
    final String message;
    
    NullOutputExceptionReference(String message)
    {
      this.message = message;
    }
    
    public V get()
    {
      return null;
    }
    
    public .MapMaker.ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> entry)
    {
      return this;
    }
    
    public V waitForValue()
    {
      throw new .NullOutputException(message);
    }
  }
  
  private static class ComputationExceptionReference<K, V>
    implements .MapMaker.ValueReference<K, V>
  {
    final Throwable t;
    
    ComputationExceptionReference(Throwable t)
    {
      this.t = t;
    }
    
    public V get()
    {
      return null;
    }
    
    public .MapMaker.ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> entry)
    {
      return this;
    }
    
    public V waitForValue()
    {
      throw new .AsynchronousComputationException(t);
    }
  }
  
  private static class QueueHolder
  {
    static final .FinalizableReferenceQueue queue = new .FinalizableReferenceQueue();
  }
  
  private static abstract interface ReferenceEntry<K, V>
  {
    public abstract .MapMaker.ValueReference<K, V> getValueReference();
    
    public abstract void setValueReference(.MapMaker.ValueReference<K, V> paramValueReference);
    
    public abstract void valueReclaimed();
    
    public abstract ReferenceEntry<K, V> getNext();
    
    public abstract int getHash();
    
    public abstract K getKey();
  }
  
  private static class StrongEntry<K, V>
    implements .MapMaker.ReferenceEntry<K, V>
  {
    final K key;
    final .CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals;
    final int hash;
    
    StrongEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals, K key, int hash)
    {
      this.internals = internals;
      this.key = key;
      this.hash = hash;
    }
    
    public K getKey()
    {
      return (K)key;
    }
    
    volatile .MapMaker.ValueReference<K, V> valueReference = .MapMaker.access$600();
    
    public .MapMaker.ValueReference<K, V> getValueReference()
    {
      return valueReference;
    }
    
    public void setValueReference(.MapMaker.ValueReference<K, V> valueReference)
    {
      this.valueReference = valueReference;
    }
    
    public void valueReclaimed()
    {
      internals.removeEntry(this, null);
    }
    
    public .MapMaker.ReferenceEntry<K, V> getNext()
    {
      return null;
    }
    
    public int getHash()
    {
      return hash;
    }
  }
  
  private static class LinkedStrongEntry<K, V>
    extends .MapMaker.StrongEntry<K, V>
  {
    final .MapMaker.ReferenceEntry<K, V> next;
    
    LinkedStrongEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals, K key, int hash, .MapMaker.ReferenceEntry<K, V> next)
    {
      super(key, hash);
      this.next = next;
    }
    
    public .MapMaker.ReferenceEntry<K, V> getNext()
    {
      return next;
    }
  }
  
  private static class SoftEntry<K, V>
    extends .FinalizableSoftReference<K>
    implements .MapMaker.ReferenceEntry<K, V>
  {
    final .CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals;
    final int hash;
    
    SoftEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals, K key, int hash)
    {
      super(.MapMaker.QueueHolder.queue);
      this.internals = internals;
      this.hash = hash;
    }
    
    public K getKey()
    {
      return (K)get();
    }
    
    public void finalizeReferent()
    {
      internals.removeEntry(this);
    }
    
    volatile .MapMaker.ValueReference<K, V> valueReference = .MapMaker.access$600();
    
    public .MapMaker.ValueReference<K, V> getValueReference()
    {
      return valueReference;
    }
    
    public void setValueReference(.MapMaker.ValueReference<K, V> valueReference)
    {
      this.valueReference = valueReference;
    }
    
    public void valueReclaimed()
    {
      internals.removeEntry(this, null);
    }
    
    public .MapMaker.ReferenceEntry<K, V> getNext()
    {
      return null;
    }
    
    public int getHash()
    {
      return hash;
    }
  }
  
  private static class LinkedSoftEntry<K, V>
    extends .MapMaker.SoftEntry<K, V>
  {
    final .MapMaker.ReferenceEntry<K, V> next;
    
    LinkedSoftEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals, K key, int hash, .MapMaker.ReferenceEntry<K, V> next)
    {
      super(key, hash);
      this.next = next;
    }
    
    public .MapMaker.ReferenceEntry<K, V> getNext()
    {
      return next;
    }
  }
  
  private static class WeakEntry<K, V>
    extends .FinalizableWeakReference<K>
    implements .MapMaker.ReferenceEntry<K, V>
  {
    final .CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals;
    final int hash;
    
    WeakEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals, K key, int hash)
    {
      super(.MapMaker.QueueHolder.queue);
      this.internals = internals;
      this.hash = hash;
    }
    
    public K getKey()
    {
      return (K)get();
    }
    
    public void finalizeReferent()
    {
      internals.removeEntry(this);
    }
    
    volatile .MapMaker.ValueReference<K, V> valueReference = .MapMaker.access$600();
    
    public .MapMaker.ValueReference<K, V> getValueReference()
    {
      return valueReference;
    }
    
    public void setValueReference(.MapMaker.ValueReference<K, V> valueReference)
    {
      this.valueReference = valueReference;
    }
    
    public void valueReclaimed()
    {
      internals.removeEntry(this, null);
    }
    
    public .MapMaker.ReferenceEntry<K, V> getNext()
    {
      return null;
    }
    
    public int getHash()
    {
      return hash;
    }
  }
  
  private static class LinkedWeakEntry<K, V>
    extends .MapMaker.WeakEntry<K, V>
  {
    final .MapMaker.ReferenceEntry<K, V> next;
    
    LinkedWeakEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals, K key, int hash, .MapMaker.ReferenceEntry<K, V> next)
    {
      super(key, hash);
      this.next = next;
    }
    
    public .MapMaker.ReferenceEntry<K, V> getNext()
    {
      return next;
    }
  }
  
  private static class WeakValueReference<K, V>
    extends .FinalizableWeakReference<V>
    implements .MapMaker.ValueReference<K, V>
  {
    final .MapMaker.ReferenceEntry<K, V> entry;
    
    WeakValueReference(V referent, .MapMaker.ReferenceEntry<K, V> entry)
    {
      super(.MapMaker.QueueHolder.queue);
      this.entry = entry;
    }
    
    public void finalizeReferent()
    {
      entry.valueReclaimed();
    }
    
    public .MapMaker.ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> entry)
    {
      return new WeakValueReference(get(), entry);
    }
    
    public V waitForValue()
      throws InterruptedException
    {
      return (V)get();
    }
  }
  
  private static class SoftValueReference<K, V>
    extends .FinalizableSoftReference<V>
    implements .MapMaker.ValueReference<K, V>
  {
    final .MapMaker.ReferenceEntry<K, V> entry;
    
    SoftValueReference(V referent, .MapMaker.ReferenceEntry<K, V> entry)
    {
      super(.MapMaker.QueueHolder.queue);
      this.entry = entry;
    }
    
    public void finalizeReferent()
    {
      entry.valueReclaimed();
    }
    
    public .MapMaker.ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> entry)
    {
      return new SoftValueReference(get(), entry);
    }
    
    public V waitForValue()
    {
      return (V)get();
    }
  }
  
  private static class StrongValueReference<K, V>
    implements .MapMaker.ValueReference<K, V>
  {
    final V referent;
    
    StrongValueReference(V referent)
    {
      this.referent = referent;
    }
    
    public V get()
    {
      return (V)referent;
    }
    
    public .MapMaker.ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> entry)
    {
      return this;
    }
    
    public V waitForValue()
    {
      return (V)get();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */