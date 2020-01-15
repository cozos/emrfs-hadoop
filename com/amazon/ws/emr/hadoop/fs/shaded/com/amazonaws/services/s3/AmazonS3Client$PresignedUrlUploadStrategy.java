package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.NoOpSignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3MetadataResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.UploadObjectStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlUploadResult;
import java.net.URL;

class AmazonS3Client$PresignedUrlUploadStrategy
  implements UploadObjectStrategy<PresignedUrlUploadRequest, PresignedUrlUploadResult>
{
  private final URL url;
  
  private AmazonS3Client$PresignedUrlUploadStrategy(AmazonS3Client paramAmazonS3Client, URL url)
  {
    this.url = url;
  }
  
  public ObjectMetadata invokeServiceCall(Request<PresignedUrlUploadRequest> request)
  {
    return 
    
      (ObjectMetadata)AmazonS3Client.access$700(this$0).execute(request, new S3MetadataResponseHandler(), this$0.errorResponseHandler, AmazonS3Client.access$500(this$0, AmazonWebServiceRequest.NOOP, new NoOpSignerProvider()), AmazonS3Client.access$600(this$0, request)).getAwsResponse();
  }
  
  public PresignedUrlUploadResult createResult(ObjectMetadata metadata, String contentMd5)
  {
    return AmazonS3Client.access$800(this$0, metadata, contentMd5);
  }
  
  public String md5ValidationErrorSuffix()
  {
    return ", object presigned url: " + url;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client.PresignedUrlUploadStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */