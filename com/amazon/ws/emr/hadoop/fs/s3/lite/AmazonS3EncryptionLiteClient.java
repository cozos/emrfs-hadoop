package com.amazon.ws.emr.hadoop.fs.s3.lite;

import com.amazon.ws.emr.hadoop.fs.exception.RuntimeExecutionException;
import com.amazon.ws.emr.hadoop.fs.exception.RuntimeIOException;
import com.amazon.ws.emr.hadoop.fs.exception.RuntimeInterruptedException;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.UploadObjectCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.executor.S3Executor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadObjectRequest;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class AmazonS3EncryptionLiteClient
  extends AmazonS3LiteClient<AmazonS3EncryptionClient>
  implements AmazonS3EncryptionLite
{
  AmazonS3EncryptionLiteClient(S3Executor<AmazonS3EncryptionClient> executor)
  {
    super(executor);
  }
  
  public CompleteMultipartUploadResult uploadObject(UploadObjectRequest request)
    throws IOException, InterruptedException, ExecutionException
  {
    try
    {
      return (CompleteMultipartUploadResult)invoke(new UploadObjectCall(request));
    }
    catch (RuntimeIOException e)
    {
      throw e.getCause();
    }
    catch (RuntimeInterruptedException e)
    {
      throw e.getCause();
    }
    catch (RuntimeExecutionException e)
    {
      throw e.getCause();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3EncryptionLiteClient
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */