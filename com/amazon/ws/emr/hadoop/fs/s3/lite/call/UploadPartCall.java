package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import java.io.InputStream;

public final class UploadPartCall
  extends AbstractUploadingS3Call<UploadPartResult, UploadPartRequest, AmazonS3>
{
  public UploadPartCall(UploadPartRequest request)
  {
    super(request);
  }
  
  protected String getBucketName(UploadPartRequest request)
  {
    return request.getBucketName();
  }
  
  protected InputStream getInputStream(UploadPartRequest request)
  {
    return request.getInputStream();
  }
  
  protected UploadPartRequest cloneWithInputStream(UploadPartRequest request, InputStream inputStream)
  {
    UploadPartRequest newRequest = (UploadPartRequest)request.clone();
    return newRequest.withInputStream(inputStream);
  }
  
  protected UploadPartResult performCall(AmazonS3 client, UploadPartRequest request)
  {
    return client.uploadPart(request);
  }
  
  protected String getKey(UploadPartRequest request)
  {
    return request.getKey();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.UploadPartCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */