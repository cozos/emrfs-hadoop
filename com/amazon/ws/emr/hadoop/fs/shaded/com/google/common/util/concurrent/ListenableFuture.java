package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract interface ListenableFuture<V>
  extends Future<V>
{
  public abstract void addListener(Runnable paramRunnable, Executor paramExecutor);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */