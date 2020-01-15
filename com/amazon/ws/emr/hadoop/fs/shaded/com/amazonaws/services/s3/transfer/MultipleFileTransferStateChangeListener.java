package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.MultipleFileTransfer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferMonitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferStateChangeListener;
import java.util.concurrent.CountDownLatch;

final class MultipleFileTransferStateChangeListener
  implements TransferStateChangeListener
{
  private final CountDownLatch latch;
  private final MultipleFileTransfer<?> multipleFileTransfer;
  
  public MultipleFileTransferStateChangeListener(CountDownLatch latch, MultipleFileTransfer<?> multipleFileTransfer)
  {
    this.latch = latch;
    this.multipleFileTransfer = multipleFileTransfer;
  }
  
  public void transferStateChanged(Transfer upload, Transfer.TransferState state)
  {
    try
    {
      latch.await();
    }
    catch (InterruptedException e)
    {
      throw new SdkClientException("Couldn't wait for all downloads to be queued");
    }
    synchronized (multipleFileTransfer)
    {
      if ((multipleFileTransfer.getState() == state) || (multipleFileTransfer.isDone())) {
        return;
      }
      if (state == Transfer.TransferState.InProgress) {
        multipleFileTransfer.setState(state);
      } else if (multipleFileTransfer.getMonitor().isDone()) {
        multipleFileTransfer.collateFinalState();
      } else {
        multipleFileTransfer.setState(Transfer.TransferState.InProgress);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.MultipleFileTransferStateChangeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */