package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import java.io.InputStream;

public final class PutObjectCall
  extends AbstractUploadingS3Call<PutObjectResult, PutObjectRequest, AmazonS3>
{
  public PutObjectCall(PutObjectRequest request)
  {
    super(request);
  }
  
  public String getBucketName(PutObjectRequest request)
  {
    return request.getBucketName();
  }
  
  protected InputStream getInputStream(PutObjectRequest request)
  {
    return request.getInputStream();
  }
  
  protected PutObjectRequest cloneWithInputStream(PutObjectRequest request, InputStream inputStream)
  {
    return request.clone().withInputStream(inputStream);
  }
  
  protected PutObjectResult performCall(AmazonS3 client, PutObjectRequest request)
  {
    return client.putObject(request);
  }
  
  protected String getKey(PutObjectRequest request)
  {
    return request.getKey();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.PutObjectCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */