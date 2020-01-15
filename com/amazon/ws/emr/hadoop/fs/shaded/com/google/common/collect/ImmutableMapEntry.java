package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

@GwtIncompatible("unnecessary")
abstract class ImmutableMapEntry<K, V>
  extends ImmutableEntry<K, V>
{
  ImmutableMapEntry(K key, V value)
  {
    super(key, value);
    CollectPreconditions.checkEntryNotNull(key, value);
  }
  
  ImmutableMapEntry(ImmutableMapEntry<K, V> contents)
  {
    super(contents.getKey(), contents.getValue());
  }
  
  @Nullable
  abstract ImmutableMapEntry<K, V> getNextInKeyBucket();
  
  @Nullable
  abstract ImmutableMapEntry<K, V> getNextInValueBucket();
  
  static final class TerminalEntry<K, V>
    extends ImmutableMapEntry<K, V>
  {
    TerminalEntry(ImmutableMapEntry<K, V> contents)
    {
      super();
    }
    
    TerminalEntry(K key, V value)
    {
      super(value);
    }
    
    @Nullable
    ImmutableMapEntry<K, V> getNextInKeyBucket()
    {
      return null;
    }
    
    @Nullable
    ImmutableMapEntry<K, V> getNextInValueBucket()
    {
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMapEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */