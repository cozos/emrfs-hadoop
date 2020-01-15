package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;

public class S3MetadataResponseHandler
  extends AbstractS3ResponseHandler<ObjectMetadata>
{
  public AmazonWebServiceResponse<ObjectMetadata> handle(HttpResponse response)
    throws Exception
  {
    ObjectMetadata metadata = new ObjectMetadata();
    populateObjectMetadata(response, metadata);
    
    AmazonWebServiceResponse<ObjectMetadata> awsResponse = parseResponseMetadata(response);
    awsResponse.setResult(metadata);
    return awsResponse;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3MetadataResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */