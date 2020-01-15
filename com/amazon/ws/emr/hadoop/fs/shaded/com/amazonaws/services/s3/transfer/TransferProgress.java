package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

public final class TransferProgress
{
  private static final Log log = LogFactory.getLog(TransferProgress.class);
  private volatile long bytesTransferred = 0L;
  private volatile long totalBytesToTransfer = -1L;
  
  /**
   * @deprecated
   */
  public long getBytesTransfered()
  {
    return getBytesTransferred();
  }
  
  public long getBytesTransferred()
  {
    return bytesTransferred;
  }
  
  public long getTotalBytesToTransfer()
  {
    return totalBytesToTransfer;
  }
  
  @Deprecated
  public synchronized double getPercentTransfered()
  {
    return getPercentTransferred();
  }
  
  public synchronized double getPercentTransferred()
  {
    if (getBytesTransferred() < 0L) {
      return 0.0D;
    }
    return totalBytesToTransfer < 0L ? -1.0D : bytesTransferred / totalBytesToTransfer * 100.0D;
  }
  
  public synchronized void updateProgress(long bytes)
  {
    bytesTransferred += bytes;
    if ((totalBytesToTransfer > -1L) && (bytesTransferred > totalBytesToTransfer))
    {
      bytesTransferred = totalBytesToTransfer;
      if (log.isDebugEnabled()) {
        log.debug("Number of bytes transfered is more than the actual total bytes to transfer. Total number of bytes to Transfer : " + totalBytesToTransfer + ". Bytes Transferred : " + (bytesTransferred + bytes));
      }
    }
  }
  
  public void setTotalBytesToTransfer(long totalBytesToTransfer)
  {
    this.totalBytesToTransfer = totalBytesToTransfer;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */