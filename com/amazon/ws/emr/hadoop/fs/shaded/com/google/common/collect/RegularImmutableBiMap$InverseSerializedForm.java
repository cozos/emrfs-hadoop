package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;

class RegularImmutableBiMap$InverseSerializedForm<K, V>
  implements Serializable
{
  private final ImmutableBiMap<K, V> forward;
  private static final long serialVersionUID = 1L;
  
  RegularImmutableBiMap$InverseSerializedForm(ImmutableBiMap<K, V> forward)
  {
    this.forward = forward;
  }
  
  Object readResolve()
  {
    return forward.inverse();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableBiMap.InverseSerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */