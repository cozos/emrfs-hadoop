package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

final class MultimapBuilder$LinkedHashSetSupplier<V>
  implements Supplier<Set<V>>, Serializable
{
  private final int expectedValuesPerKey;
  
  MultimapBuilder$LinkedHashSetSupplier(int expectedValuesPerKey)
  {
    this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
  }
  
  public Set<V> get()
  {
    return new LinkedHashSet(expectedValuesPerKey);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.LinkedHashSetSupplier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */