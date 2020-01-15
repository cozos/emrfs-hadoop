package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.DeliveryMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferProgressUpdatingListener;

final class MultipleFileTransferProgressUpdatingListener
  extends TransferProgressUpdatingListener
  implements DeliveryMode
{
  private final ProgressListenerChain progressListenerChain;
  
  public MultipleFileTransferProgressUpdatingListener(TransferProgress transferProgress, ProgressListenerChain progressListenerChain)
  {
    super(transferProgress);
    this.progressListenerChain = progressListenerChain;
  }
  
  public void progressChanged(ProgressEvent progressEvent)
  {
    super.progressChanged(progressEvent);
    progressListenerChain.progressChanged(progressEvent);
  }
  
  public boolean isSyncCallSafe()
  {
    return (progressListenerChain == null) || 
      (progressListenerChain.isSyncCallSafe());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.MultipleFileTransferProgressUpdatingListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */