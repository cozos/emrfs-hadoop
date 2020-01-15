package com.amazon.ws.emr.hadoop.fs.s3.lite;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadObjectRequest;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public abstract interface AmazonS3EncryptionLite
  extends AmazonS3Lite
{
  public abstract CompleteMultipartUploadResult uploadObject(UploadObjectRequest paramUploadObjectRequest)
    throws IOException, InterruptedException, ExecutionException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3EncryptionLite
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */