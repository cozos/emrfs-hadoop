package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import javax.annotation.Nullable;

final class Maps$8
  implements Function<V1, V2>
{
  Maps$8(Maps.EntryTransformer paramEntryTransformer, Object paramObject) {}
  
  public V2 apply(@Nullable V1 v1)
  {
    return (V2)val$transformer.transformEntry(val$key, v1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */