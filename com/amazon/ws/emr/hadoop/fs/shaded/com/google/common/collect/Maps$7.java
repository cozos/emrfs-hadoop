package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

final class Maps$7
  implements Maps.EntryTransformer<K, V1, V2>
{
  Maps$7(Function paramFunction) {}
  
  public V2 transformEntry(K key, V1 value)
  {
    return (V2)val$function.apply(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */