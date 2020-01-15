package com.amazon.ws.emr.hadoop.fs.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lombok.NonNull;

public final class ExceptionCollector
{
  private final List<Exception> exceptions = new ArrayList();
  
  public void add(@NonNull Exception exception)
  {
    if (exception == null) {
      throw new NullPointerException("exception");
    }
    exceptions.add(exception);
  }
  
  public <X extends Throwable> void throwIfNotEmpty(@NonNull Supplier<X> exceptionToThrow)
    throws Throwable
  {
    if (exceptionToThrow == null) {
      throw new NullPointerException("exceptionToThrow");
    }
    if (exceptions.isEmpty()) {
      return;
    }
    X toThrow = (Throwable)exceptionToThrow.get();
    toThrow.initCause(assembleSingleExceptionFromCollected());
    throw toThrow;
  }
  
  public <X extends Throwable> void rethrowIfNotEmpty(@NonNull Class<X> declaredType)
    throws Throwable
  {
    if (declaredType == null) {
      throw new NullPointerException("declaredType");
    }
    if (exceptions.isEmpty()) {
      return;
    }
    Exception exception = assembleSingleExceptionFromCollected();
    Throwables.propagateIfPossible(exception, declaredType);
    throw new RuntimeException(exception);
  }
  
  private Exception assembleSingleExceptionFromCollected()
  {
    Exception cause = (Exception)exceptions.get(0);
    for (Exception toSuppress : exceptions.subList(1, exceptions.size())) {
      cause.addSuppressed(toSuppress);
    }
    return cause;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.ExceptionCollector
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */