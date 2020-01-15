package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.exception.RuntimeExecutionException;
import com.amazon.ws.emr.hadoop.fs.exception.RuntimeIOException;
import com.amazon.ws.emr.hadoop.fs.exception.RuntimeInterruptedException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadObjectRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public final class UploadObjectCall
  extends AbstractUploadingS3Call<CompleteMultipartUploadResult, UploadObjectRequest, AmazonS3EncryptionClient>
{
  public UploadObjectCall(UploadObjectRequest request)
  {
    super(request);
  }
  
  protected String getBucketName(UploadObjectRequest request)
  {
    return request.getBucketName();
  }
  
  protected InputStream getInputStream(UploadObjectRequest request)
  {
    return request.getInputStream();
  }
  
  protected UploadObjectRequest cloneWithInputStream(UploadObjectRequest request, InputStream inputStream)
  {
    return (UploadObjectRequest)request.clone().withInputStream(inputStream);
  }
  
  protected CompleteMultipartUploadResult performCall(AmazonS3EncryptionClient client, UploadObjectRequest request)
  {
    try
    {
      return client.uploadObject(request);
    }
    catch (IOException e)
    {
      throw new RuntimeIOException(e);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeInterruptedException(e);
    }
    catch (ExecutionException e)
    {
      throw new RuntimeExecutionException(e);
    }
  }
  
  protected String getKey(UploadObjectRequest request)
  {
    return request.getKey();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.UploadObjectCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */