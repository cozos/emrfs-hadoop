package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Primitives;
import java.util.Map;
import java.util.Map.Entry;

public final class ImmutableClassToInstanceMap$Builder<B>
{
  private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder = ImmutableMap.builder();
  
  public <T extends B> Builder<B> put(Class<T> key, T value)
  {
    mapBuilder.put(key, value);
    return this;
  }
  
  public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> map)
  {
    for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet())
    {
      Class<? extends T> type = (Class)entry.getKey();
      T value = entry.getValue();
      mapBuilder.put(type, cast(type, value));
    }
    return this;
  }
  
  private static <B, T extends B> T cast(Class<T> type, B value)
  {
    return (T)Primitives.wrap(type).cast(value);
  }
  
  public ImmutableClassToInstanceMap<B> build()
  {
    return new ImmutableClassToInstanceMap(mapBuilder.build(), null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableClassToInstanceMap.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */