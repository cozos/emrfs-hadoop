package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
class ImmutableMapKeySet$KeySetSerializedForm<K>
  implements Serializable
{
  final ImmutableMap<K, ?> map;
  private static final long serialVersionUID = 0L;
  
  ImmutableMapKeySet$KeySetSerializedForm(ImmutableMap<K, ?> map)
  {
    this.map = map;
  }
  
  Object readResolve()
  {
    return map.keySet();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMapKeySet.KeySetSerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */