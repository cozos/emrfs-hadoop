package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Collection;

class Multimaps$UnmodifiableMultimap$1
  implements Function<Collection<V>, Collection<V>>
{
  Multimaps$UnmodifiableMultimap$1(Multimaps.UnmodifiableMultimap paramUnmodifiableMultimap) {}
  
  public Collection<V> apply(Collection<V> collection)
  {
    return Multimaps.access$000(collection);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.UnmodifiableMultimap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */