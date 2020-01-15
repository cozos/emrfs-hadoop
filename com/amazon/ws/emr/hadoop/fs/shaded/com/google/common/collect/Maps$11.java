package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Map.Entry;

final class Maps$11
  implements Function<Map.Entry<K, V1>, Map.Entry<K, V2>>
{
  Maps$11(Maps.EntryTransformer paramEntryTransformer) {}
  
  public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry)
  {
    return Maps.transformEntry(val$transformer, entry);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */