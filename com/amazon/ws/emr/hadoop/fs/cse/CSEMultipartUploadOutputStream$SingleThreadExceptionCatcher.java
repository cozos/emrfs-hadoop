package com.amazon.ws.emr.hadoop.fs.cse;

final class CSEMultipartUploadOutputStream$SingleThreadExceptionCatcher
  implements Thread.UncaughtExceptionHandler
{
  private Throwable throwable;
  
  public void uncaughtException(Thread thread, Throwable exception)
  {
    if ((throwable != null) && (throwable != exception)) {
      exception.addSuppressed(throwable);
    }
    throwable = exception;
  }
  
  public Throwable getThrowable()
  {
    return throwable;
  }
  
  private boolean isEmpty()
  {
    return throwable == null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.cse.CSEMultipartUploadOutputStream.SingleThreadExceptionCatcher
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */