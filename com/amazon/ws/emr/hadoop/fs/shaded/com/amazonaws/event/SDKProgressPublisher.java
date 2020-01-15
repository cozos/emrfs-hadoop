package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class SDKProgressPublisher
{
  private static volatile Future<?> latestFutureTask;
  
  public static Future<?> publishProgress(ProgressListener listener, ProgressEventType type)
  {
    if ((listener == ProgressListener.NOOP) || (listener == null) || (type == null)) {
      return null;
    }
    return deliverEvent(listener, new ProgressEvent(type));
  }
  
  private static Future<?> deliverEvent(ProgressListener listener, final ProgressEvent event)
  {
    if ((listener instanceof DeliveryMode))
    {
      DeliveryMode mode = (DeliveryMode)listener;
      if (mode.isSyncCallSafe()) {
        return quietlyCallListener(listener, event);
      }
    }
     = LazyHolder.executor.submit(new Runnable()
    {
      public void run()
      {
        val$listener.progressChanged(event);
      }
    });
  }
  
  private static Future<?> quietlyCallListener(ProgressListener listener, ProgressEvent event)
  {
    try
    {
      listener.progressChanged(event);
    }
    catch (Throwable t)
    {
      LogFactory.getLog(SDKProgressPublisher.class).debug("Failure from the event listener", t);
    }
    return null;
  }
  
  public static Future<?> publishRequestContentLength(ProgressListener listener, long bytes)
  {
    return publishByteCountEvent(listener, ProgressEventType.REQUEST_CONTENT_LENGTH_EVENT, bytes);
  }
  
  public static Future<?> publishResponseContentLength(ProgressListener listener, long bytes)
  {
    return publishByteCountEvent(listener, ProgressEventType.RESPONSE_CONTENT_LENGTH_EVENT, bytes);
  }
  
  public static Future<?> publishRequestBytesTransferred(ProgressListener listener, long bytes)
  {
    return publishByteCountEvent(listener, ProgressEventType.REQUEST_BYTE_TRANSFER_EVENT, bytes);
  }
  
  public static Future<?> publishResponseBytesTransferred(ProgressListener listener, long bytes)
  {
    return publishByteCountEvent(listener, ProgressEventType.RESPONSE_BYTE_TRANSFER_EVENT, bytes);
  }
  
  private static Future<?> publishByteCountEvent(ProgressListener listener, ProgressEventType type, long bytes)
  {
    if ((listener == ProgressListener.NOOP) || (listener == null) || (bytes <= 0L)) {
      return null;
    }
    return deliverEvent(listener, new ProgressEvent(type, bytes));
  }
  
  public static Future<?> publishRequestReset(ProgressListener listener, long bytesReset)
  {
    return publishResetEvent(listener, ProgressEventType.HTTP_REQUEST_CONTENT_RESET_EVENT, bytesReset);
  }
  
  public static Future<?> publishResponseReset(ProgressListener listener, long bytesReset)
  {
    return publishResetEvent(listener, ProgressEventType.HTTP_RESPONSE_CONTENT_RESET_EVENT, bytesReset);
  }
  
  public static Future<?> publishResponseBytesDiscarded(ProgressListener listener, long bytesDiscarded)
  {
    return publishResetEvent(listener, ProgressEventType.RESPONSE_BYTE_DISCARD_EVENT, bytesDiscarded);
  }
  
  private static Future<?> publishResetEvent(ProgressListener listener, ProgressEventType resetEventType, long bytesReset)
  {
    if (bytesReset <= 0L) {
      return null;
    }
    if ((listener == ProgressListener.NOOP) || (listener == null)) {
      return null;
    }
    return deliverEvent(listener, new ProgressEvent(resetEventType, bytesReset));
  }
  
  protected static ExecutorService getExecutorService()
  {
    return LazyHolder.executor;
  }
  
  protected static Future<?> setLatestFutureTask(Future<?> f)
  {
    latestFutureTask = f;return f;
  }
  
  @Deprecated
  public static void waitTillCompletion()
    throws InterruptedException, ExecutionException
  {
    if (latestFutureTask != null) {
      latestFutureTask.get();
    }
  }
  
  private static final class LazyHolder
  {
    private static final ExecutorService executor = ;
    
    private static ExecutorService createNewExecutorService()
    {
      Executors.newSingleThreadExecutor(new ThreadFactory()
      {
        public Thread newThread(Runnable r)
        {
          Thread t = new Thread(r);
          t.setName("java-sdk-progress-listener-callback-thread");
          t.setDaemon(true);
          return t;
        }
      });
    }
  }
  
  public static void shutdown(boolean now)
  {
    if (now) {
      LazyHolder.executor.shutdownNow();
    } else {
      LazyHolder.executor.shutdown();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */