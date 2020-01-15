package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.Set;

final class MultimapBuilder$EnumSetSupplier<V extends Enum<V>>
  implements Supplier<Set<V>>, Serializable
{
  private final Class<V> clazz;
  
  MultimapBuilder$EnumSetSupplier(Class<V> clazz)
  {
    this.clazz = ((Class)Preconditions.checkNotNull(clazz));
  }
  
  public Set<V> get()
  {
    return EnumSet.noneOf(clazz);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.EnumSetSupplier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */