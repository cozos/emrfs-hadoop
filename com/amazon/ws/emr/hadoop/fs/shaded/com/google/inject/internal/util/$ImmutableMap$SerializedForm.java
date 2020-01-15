package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.Serializable;
import java.util.Map.Entry;

class $ImmutableMap$SerializedForm
  implements Serializable
{
  final Object[] keys;
  final Object[] values;
  private static final long serialVersionUID = 0L;
  
  $ImmutableMap$SerializedForm(.ImmutableMap<?, ?> map)
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
    .ImmutableMap.Builder<Object, Object> builder = new .ImmutableMap.Builder();
    for (int i = 0; i < keys.length; i++) {
      builder.put(keys[i], values[i]);
    }
    return builder.build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.SerializedForm
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */