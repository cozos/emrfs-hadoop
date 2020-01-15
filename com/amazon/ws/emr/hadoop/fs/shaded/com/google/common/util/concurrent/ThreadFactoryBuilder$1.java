package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class ThreadFactoryBuilder$1
  implements ThreadFactory
{
  ThreadFactoryBuilder$1(ThreadFactory paramThreadFactory, String paramString, AtomicLong paramAtomicLong, Boolean paramBoolean, Integer paramInteger, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {}
  
  public Thread newThread(Runnable runnable)
  {
    Thread thread = val$backingThreadFactory.newThread(runnable);
    if (val$nameFormat != null) {
      thread.setName(String.format(val$nameFormat, new Object[] { Long.valueOf(val$count.getAndIncrement()) }));
    }
    if (val$daemon != null) {
      thread.setDaemon(val$daemon.booleanValue());
    }
    if (val$priority != null) {
      thread.setPriority(val$priority.intValue());
    }
    if (val$uncaughtExceptionHandler != null) {
      thread.setUncaughtExceptionHandler(val$uncaughtExceptionHandler);
    }
    return thread;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ThreadFactoryBuilder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */