package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.FileLocks;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@SdkInternalApi
public class CompleteMultipartDownload
  implements Callable<File>
{
  private final List<Future<Long>> partFiles;
  private final File destinationFile;
  private final DownloadImpl download;
  private Integer currentPartNumber;
  
  public CompleteMultipartDownload(List<Future<Long>> files, File destinationFile, DownloadImpl download, Integer currentPartNumber)
  {
    partFiles = files;
    this.destinationFile = destinationFile;
    this.download = download;
    this.currentPartNumber = currentPartNumber;
  }
  
  public File call()
    throws Exception
  {
    try
    {
      long filePosition;
      Integer localInteger1;
      for (Iterator localIterator = partFiles.iterator(); localIterator.hasNext(); download.updatePersistableTransfer(localInteger1, Long.valueOf(filePosition)))
      {
        Future<Long> file = (Future)localIterator.next();
        filePosition = ((Long)file.get()).longValue();
        localInteger1 = currentPartNumber;Integer localInteger2 = currentPartNumber = Integer.valueOf(currentPartNumber.intValue() + 1);
      }
      download.setState(Transfer.TransferState.Completed);
    }
    finally
    {
      FileLocks.unlock(destinationFile);
    }
    return destinationFile;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CompleteMultipartDownload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */