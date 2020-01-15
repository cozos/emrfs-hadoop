package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

final class Futures$2
  implements AsyncFunction<I, O>
{
  Futures$2(Function paramFunction) {}
  
  public ListenableFuture<O> apply(I input)
  {
    O output = val$function.apply(input);
    return Futures.immediateFuture(output);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */