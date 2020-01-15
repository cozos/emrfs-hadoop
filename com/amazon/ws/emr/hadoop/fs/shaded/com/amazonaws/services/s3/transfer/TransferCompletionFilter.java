package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;

final class TransferCompletionFilter
  implements ProgressEventFilter
{
  public ProgressEvent filter(ProgressEvent progressEvent)
  {
    return progressEvent.getEventType() == ProgressEventType.TRANSFER_COMPLETED_EVENT ? null : progressEvent;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferCompletionFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */