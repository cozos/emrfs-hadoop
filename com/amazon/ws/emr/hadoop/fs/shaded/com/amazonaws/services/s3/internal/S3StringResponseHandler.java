package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.io.InputStream;

public class S3StringResponseHandler
  extends AbstractS3ResponseHandler<String>
{
  public AmazonWebServiceResponse<String> handle(HttpResponse response)
    throws Exception
  {
    AmazonWebServiceResponse<String> awsResponse = parseResponseMetadata(response);
    
    byte[] buffer = new byte['Ѐ'];
    StringBuilder builder = new StringBuilder();
    InputStream content = response.getContent();
    int bytesRead;
    while ((bytesRead = content.read(buffer)) > 0) {
      builder.append(new String(buffer, 0, bytesRead, StringUtils.UTF8));
    }
    awsResponse.setResult(builder.toString());
    
    return awsResponse;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3StringResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */