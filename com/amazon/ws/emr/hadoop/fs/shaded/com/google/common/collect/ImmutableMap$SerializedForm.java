package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;
import java.util.Map.Entry;

class ImmutableMap$SerializedForm
  implements Serializable
{
  private final Object[] keys;
  private final Object[] values;
  private static final long serialVersionUID = 0L;
  
  ImmutableMap$SerializedForm(ImmutableMap<?, ?> map)
  {
    keys = new Object[map.size()];
    values = new Object[map.size()];
    int i = 0;
    for (Map.Entry<?, ?> entry : map.entrySet())
    {
      keys[i] = entry.getKey();
      values[i] = entry.getValue();
      i++;
    }
  }
  
  Object readResolve()
  {
    ImmutableMap.Builder<Object, Object> builder = new ImmutableMap.Builder();
    return createMap(builder);
  }
  
  Object createMap(ImmutableMap.Builder<Object, Object> builder)
  {
    for (int i = 0; i < keys.length; i++) {
      builder.put(keys[i], values[i]);
    }
    return builder.build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */