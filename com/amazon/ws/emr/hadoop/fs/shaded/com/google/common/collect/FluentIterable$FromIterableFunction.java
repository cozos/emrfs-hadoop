package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

class FluentIterable$FromIterableFunction<E>
  implements Function<Iterable<E>, FluentIterable<E>>
{
  public FluentIterable<E> apply(Iterable<E> fromObject)
  {
    return FluentIterable.from(fromObject);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FluentIterable.FromIterableFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */