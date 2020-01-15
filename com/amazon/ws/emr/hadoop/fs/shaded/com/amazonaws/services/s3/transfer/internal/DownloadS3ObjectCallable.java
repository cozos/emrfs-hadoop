package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.Callable;

@SdkInternalApi
public class DownloadS3ObjectCallable
  implements Callable<Long>
{
  private static final Log LOG = LogFactory.getLog(DownloadS3ObjectCallable.class);
  private static final int BUFFER_SIZE = 2097152;
  private final Callable<S3Object> serviceCall;
  private final File destinationFile;
  private final long position;
  
  public DownloadS3ObjectCallable(Callable<S3Object> serviceCall, File destinationFile, long position)
  {
    this.serviceCall = serviceCall;
    this.destinationFile = destinationFile;
    this.position = position;
  }
  
  public Long call()
    throws Exception
  {
    RandomAccessFile randomAccessFile = new RandomAccessFile(destinationFile, "rw");
    FileChannel channel = randomAccessFile.getChannel();
    channel.position(position);
    S3ObjectInputStream objectContent = null;
    try
    {
      S3Object object = (S3Object)serviceCall.call();
      
      objectContent = object.getObjectContent();
      
      byte[] buffer = new byte[2097152];
      
      ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
      int bytesRead;
      while ((bytesRead = objectContent.read(buffer)) > -1)
      {
        byteBuffer.limit(bytesRead);
        while (byteBuffer.hasRemaining()) {
          channel.write(byteBuffer);
        }
        byteBuffer.clear();
      }
      filePosition = channel.position();
    }
    finally
    {
      long filePosition;
      IOUtils.closeQuietly(objectContent, LOG);
      IOUtils.closeQuietly(randomAccessFile, LOG);
      IOUtils.closeQuietly(channel, LOG);
    }
    long filePosition;
    return Long.valueOf(filePosition);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.DownloadS3ObjectCallable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */