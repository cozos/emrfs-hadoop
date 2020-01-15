package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import java.util.Map;

public class S3ObjectResponseHandler
  extends AbstractS3ResponseHandler<S3Object>
{
  public AmazonWebServiceResponse<S3Object> handle(HttpResponse response)
    throws Exception
  {
    S3Object object = new S3Object();
    AmazonWebServiceResponse<S3Object> awsResponse = parseResponseMetadata(response);
    if (response.getHeaders().get("x-amz-website-redirect-location") != null) {
      object.setRedirectLocation((String)response.getHeaders().get("x-amz-website-redirect-location"));
    }
    if (response.getHeaders().get("x-amz-request-charged") != null) {
      object.setRequesterCharged(true);
    }
    if (response.getHeaders().get("x-amz-tagging-count") != null) {
      object.setTaggingCount(Integer.valueOf(Integer.parseInt((String)response.getHeaders().get("x-amz-tagging-count"))));
    }
    ObjectMetadata metadata = object.getObjectMetadata();
    populateObjectMetadata(response, metadata);
    
    object.setObjectContent(new S3ObjectInputStream(response.getContent(), response.getHttpRequest()));
    
    awsResponse.setResult(object);
    return awsResponse;
  }
  
  public boolean needsConnectionLeftOpen()
  {
    return true;
  }
  
  private long getContentLength(HttpResponse response)
  {
    String contentLength = response.getHeader("Content-Length");
    if (contentLength == null) {
      return -1L;
    }
    return Long.parseLong(response.getHeader("Content-Length"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3ObjectResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */