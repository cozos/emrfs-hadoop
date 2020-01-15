package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Map.Entry;

final class Maps$9
  implements Function<Map.Entry<K, V1>, V2>
{
  Maps$9(Maps.EntryTransformer paramEntryTransformer) {}
  
  public V2 apply(Map.Entry<K, V1> entry)
  {
    return (V2)val$transformer.transformEntry(entry.getKey(), entry.getValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */