package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import java.util.HashMap;
import java.util.Map;

public class ImmutableMapParameter$Builder<K, V>
{
  private final Map<K, V> entries;
  
  public ImmutableMapParameter$Builder()
  {
    entries = new HashMap();
  }
  
  public Builder<K, V> put(K key, V value)
  {
    ImmutableMapParameter.access$000(entries, key, value);
    return this;
  }
  
  public ImmutableMapParameter<K, V> build()
  {
    HashMap<K, V> builtMap = new HashMap();
    builtMap.putAll(entries);
    return new ImmutableMapParameter(builtMap, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ImmutableMapParameter.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */