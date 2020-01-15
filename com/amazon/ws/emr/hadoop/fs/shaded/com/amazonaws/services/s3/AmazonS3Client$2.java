package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher;
import java.io.InputStream;

class AmazonS3Client$2
  extends ProgressInputStream
{
  AmazonS3Client$2(AmazonS3Client this$0, InputStream x0, ProgressListener x1)
  {
    super(x0, x1);
  }
  
  protected void onEOF()
  {
    SDKProgressPublisher.publishProgress(getListener(), ProgressEventType.TRANSFER_COMPLETED_EVENT);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */