package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
class ImmutableMapEntrySet$EntrySetSerializedForm<K, V>
  implements Serializable
{
  final ImmutableMap<K, V> map;
  private static final long serialVersionUID = 0L;
  
  ImmutableMapEntrySet$EntrySetSerializedForm(ImmutableMap<K, V> map)
  {
    this.map = map;
  }
  
  Object readResolve()
  {
    return map.entrySet();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMapEntrySet.EntrySetSerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */