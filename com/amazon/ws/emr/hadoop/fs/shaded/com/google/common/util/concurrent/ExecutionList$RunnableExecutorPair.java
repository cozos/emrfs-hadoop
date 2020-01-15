package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class ExecutionList$RunnableExecutorPair
{
  final Runnable runnable;
  final Executor executor;
  @Nullable
  RunnableExecutorPair next;
  
  ExecutionList$RunnableExecutorPair(Runnable runnable, Executor executor, RunnableExecutorPair next)
  {
    this.runnable = runnable;
    this.executor = executor;
    this.next = next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ExecutionList.RunnableExecutorPair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */