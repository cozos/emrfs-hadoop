package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;

@SdkInternalApi
public abstract interface TransferStateChangeListener
{
  public abstract void transferStateChanged(Transfer paramTransfer, Transfer.TransferState paramTransferState);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferStateChangeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */