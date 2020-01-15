package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MultipleFileTransfer<T extends Transfer>
  extends AbstractTransfer
{
  protected final Collection<? extends T> subTransfers;
  private AtomicBoolean subTransferStarted = new AtomicBoolean(false);
  
  MultipleFileTransfer(String description, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, Collection<? extends T> subTransfers)
  {
    super(description, transferProgress, progressListenerChain);
    this.subTransfers = subTransfers;
  }
  
  public void collateFinalState()
  {
    boolean seenCanceled = false;
    for (T download : subTransfers)
    {
      if (download.getState() == Transfer.TransferState.Failed)
      {
        setState(Transfer.TransferState.Failed);
        return;
      }
      if (download.getState() == Transfer.TransferState.Canceled) {
        seenCanceled = true;
      }
    }
    if (seenCanceled) {
      setState(Transfer.TransferState.Canceled);
    } else {
      setState(Transfer.TransferState.Completed);
    }
  }
  
  public void setState(Transfer.TransferState state)
  {
    super.setState(state);
    switch (state)
    {
    case Waiting: 
      fireProgressEvent(ProgressEventType.TRANSFER_PREPARING_EVENT);
      break;
    case InProgress: 
      if (subTransferStarted.compareAndSet(false, true)) {
        fireProgressEvent(ProgressEventType.TRANSFER_STARTED_EVENT);
      }
      break;
    case Completed: 
      fireProgressEvent(ProgressEventType.TRANSFER_COMPLETED_EVENT);
      break;
    case Canceled: 
      fireProgressEvent(ProgressEventType.TRANSFER_CANCELED_EVENT);
      break;
    case Failed: 
      fireProgressEvent(ProgressEventType.TRANSFER_FAILED_EVENT);
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.MultipleFileTransfer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */