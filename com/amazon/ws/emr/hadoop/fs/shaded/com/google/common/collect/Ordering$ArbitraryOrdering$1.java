package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.concurrent.atomic.AtomicInteger;

class Ordering$ArbitraryOrdering$1
  implements Function<Object, Integer>
{
  final AtomicInteger counter = new AtomicInteger(0);
  
  Ordering$ArbitraryOrdering$1(Ordering.ArbitraryOrdering paramArbitraryOrdering) {}
  
  public Integer apply(Object from)
  {
    return Integer.valueOf(counter.getAndIncrement());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Ordering.ArbitraryOrdering.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */