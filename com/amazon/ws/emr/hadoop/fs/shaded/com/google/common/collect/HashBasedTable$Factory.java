package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Map;

class HashBasedTable$Factory<C, V>
  implements Supplier<Map<C, V>>, Serializable
{
  final int expectedSize;
  private static final long serialVersionUID = 0L;
  
  HashBasedTable$Factory(int expectedSize)
  {
    this.expectedSize = expectedSize;
  }
  
  public Map<C, V> get()
  {
    return Maps.newHashMapWithExpectedSize(expectedSize);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.HashBasedTable.Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */