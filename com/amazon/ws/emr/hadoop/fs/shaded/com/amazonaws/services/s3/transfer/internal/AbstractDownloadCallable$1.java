package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.AbortableTransfer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;

class AbstractDownloadCallable$1
  implements Runnable
{
  AbstractDownloadCallable$1(AbstractDownloadCallable this$0) {}
  
  public void run()
  {
    try
    {
      if (AbstractDownloadCallable.access$000(this$0).getState() != Transfer.TransferState.Completed) {
        AbstractDownloadCallable.access$000(this$0).abort();
      }
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to abort download after timeout", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.AbstractDownloadCallable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */