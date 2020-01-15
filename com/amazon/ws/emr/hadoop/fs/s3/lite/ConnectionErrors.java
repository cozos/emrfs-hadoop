package com.amazon.ws.emr.hadoop.fs.s3.lite;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.InterruptedIOException;
import javax.annotation.Nullable;
import lombok.NonNull;

public final class ConnectionErrors
{
  private ConnectionErrors()
  {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
  
  public static boolean isCausedByInterruptedIOException(@NonNull Throwable throwable)
  {
    if (throwable == null) {
      throw new NullPointerException("throwable");
    }
    if (isInterruptedIOException(throwable)) {
      return true;
    }
    Throwable rootCause = ExceptionUtils.getRootCause(throwable);
    return isInterruptedIOException(rootCause);
  }
  
  private static boolean isInterruptedIOException(@Nullable Throwable throwable)
  {
    return throwable instanceof InterruptedIOException;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.ConnectionErrors
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */