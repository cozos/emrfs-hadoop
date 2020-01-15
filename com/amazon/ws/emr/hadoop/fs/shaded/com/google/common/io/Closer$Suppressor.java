package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;

@VisibleForTesting
abstract interface Closer$Suppressor
{
  public abstract void suppress(Closeable paramCloseable, Throwable paramThrowable1, Throwable paramThrowable2);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.Closer.Suppressor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */