package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.DeliveryMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PersistableTransfer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class S3ProgressPublisher
  extends SDKProgressPublisher
{
  public static Future<?> publishTransferPersistable(ProgressListener listener, PersistableTransfer persistableTransfer)
  {
    if ((persistableTransfer == null) || (!(listener instanceof S3ProgressListener))) {
      return null;
    }
    S3ProgressListener s3listener = (S3ProgressListener)listener;
    return deliverEvent(s3listener, persistableTransfer);
  }
  
  private static Future<?> deliverEvent(S3ProgressListener listener, final PersistableTransfer persistableTransfer)
  {
    if ((listener instanceof DeliveryMode))
    {
      DeliveryMode mode = (DeliveryMode)listener;
      if (mode.isSyncCallSafe()) {
        return quietlyCallListener(listener, persistableTransfer);
      }
    }
    setLatestFutureTask(getExecutorService().submit(new Runnable()
    {
      public void run()
      {
        val$listener.onPersistableTransfer(persistableTransfer);
      }
    }));
  }
  
  private static Future<?> quietlyCallListener(S3ProgressListener listener, PersistableTransfer persistableTransfer)
  {
    try
    {
      listener.onPersistableTransfer(persistableTransfer);
    }
    catch (Throwable t)
    {
      LogFactory.getLog(S3ProgressPublisher.class).debug("Failure from the event listener", t);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.S3ProgressPublisher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */