package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
class ImmutableMapValues$SerializedForm<V>
  implements Serializable
{
  final ImmutableMap<?, V> map;
  private static final long serialVersionUID = 0L;
  
  ImmutableMapValues$SerializedForm(ImmutableMap<?, V> map)
  {
    this.map = map;
  }
  
  Object readResolve()
  {
    return map.values();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMapValues.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */