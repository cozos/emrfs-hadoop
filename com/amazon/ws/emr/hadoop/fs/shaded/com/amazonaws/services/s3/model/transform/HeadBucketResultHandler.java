package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.AbstractS3ResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.HeadBucketResult;
import java.util.Map;

public class HeadBucketResultHandler
  extends AbstractS3ResponseHandler<HeadBucketResult>
{
  public AmazonWebServiceResponse<HeadBucketResult> handle(HttpResponse response)
    throws Exception
  {
    AmazonWebServiceResponse<HeadBucketResult> awsResponse = new AmazonWebServiceResponse();
    HeadBucketResult result = new HeadBucketResult();
    result.setBucketRegion((String)response.getHeaders().get("x-amz-bucket-region"));
    awsResponse.setResult(result);
    
    return awsResponse;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.HeadBucketResultHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */