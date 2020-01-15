package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PersistableTransfer;

public class S3ProgressListenerChain
  extends ProgressListenerChain
  implements S3ProgressListener
{
  public S3ProgressListenerChain(ProgressListener... listeners)
  {
    super(listeners);
  }
  
  public void onPersistableTransfer(PersistableTransfer persistableTransfer)
  {
    for (ProgressListener listener : getListeners()) {
      if ((listener instanceof S3ProgressListener))
      {
        S3ProgressListener s3listener = (S3ProgressListener)listener;
        s3listener.onPersistableTransfer(persistableTransfer);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.S3ProgressListenerChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */