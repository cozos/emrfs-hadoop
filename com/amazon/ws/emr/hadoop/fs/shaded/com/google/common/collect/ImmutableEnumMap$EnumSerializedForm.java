package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;
import java.util.EnumMap;

class ImmutableEnumMap$EnumSerializedForm<K extends Enum<K>, V>
  implements Serializable
{
  final EnumMap<K, V> delegate;
  private static final long serialVersionUID = 0L;
  
  ImmutableEnumMap$EnumSerializedForm(EnumMap<K, V> delegate)
  {
    this.delegate = delegate;
  }
  
  Object readResolve()
  {
    return new ImmutableEnumMap(delegate, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableEnumMap.EnumSerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */