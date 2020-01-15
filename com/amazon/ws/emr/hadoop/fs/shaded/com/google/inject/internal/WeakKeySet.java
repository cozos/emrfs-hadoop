package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Maps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Sets;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..SourceProvider;
import java.util.Map;
import java.util.Set;

final class WeakKeySet
{
  private Map<String, Set<Object>> backingSet;
  
  public void add(Key<?> key, Object source)
  {
    if (backingSet == null) {
      backingSet = .Maps.newHashMap();
    }
    if (((source instanceof Class)) || (source == .SourceProvider.UNKNOWN_SOURCE)) {
      source = null;
    }
    String k = key.toString();
    Set<Object> sources = (Set)backingSet.get(k);
    if (sources == null)
    {
      sources = .Sets.newLinkedHashSet();
      backingSet.put(k, sources);
    }
    sources.add(Errors.convert(source));
  }
  
  public boolean contains(Key<?> key)
  {
    return (backingSet != null) && (backingSet.containsKey(key.toString()));
  }
  
  public Set<Object> getSources(Key<?> key)
  {
    return (Set)backingSet.get(key.toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.WeakKeySet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */