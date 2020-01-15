package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap.Builder;

@Beta
public final class ImmutableTypeToInstanceMap$Builder<B>
{
  private final ImmutableMap.Builder<TypeToken<? extends B>, B> mapBuilder = ImmutableMap.builder();
  
  public <T extends B> Builder<B> put(Class<T> key, T value)
  {
    mapBuilder.put(TypeToken.of(key), value);
    return this;
  }
  
  public <T extends B> Builder<B> put(TypeToken<T> key, T value)
  {
    mapBuilder.put(key.rejectTypeVariables(), value);
    return this;
  }
  
  public ImmutableTypeToInstanceMap<B> build()
  {
    return new ImmutableTypeToInstanceMap(mapBuilder.build(), null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.ImmutableTypeToInstanceMap.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */