package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

final class Futures$8
  implements Futures.FutureCombiner<V, List<V>>
{
  public List<V> combine(List<Optional<V>> values)
  {
    List<V> result = Lists.newArrayList();
    for (Optional<V> element : values) {
      result.add(element != null ? element.orNull() : null);
    }
    return Collections.unmodifiableList(result);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */