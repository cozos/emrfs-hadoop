package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.InputStream;
import java.util.Map;

public class S3XmlResponseHandler<T>
  extends AbstractS3ResponseHandler<T>
{
  private Unmarshaller<T, InputStream> responseUnmarshaller;
  private static final Log log = LogFactory.getLog("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.request");
  private Map<String, String> responseHeaders;
  
  public S3XmlResponseHandler(Unmarshaller<T, InputStream> responseUnmarshaller)
  {
    this.responseUnmarshaller = responseUnmarshaller;
  }
  
  public AmazonWebServiceResponse<T> handle(HttpResponse response)
    throws Exception
  {
    AmazonWebServiceResponse<T> awsResponse = parseResponseMetadata(response);
    responseHeaders = response.getHeaders();
    if (responseUnmarshaller != null)
    {
      log.trace("Beginning to parse service response XML");
      T result = responseUnmarshaller.unmarshall(response.getContent());
      log.trace("Done parsing service response XML");
      awsResponse.setResult(result);
    }
    return awsResponse;
  }
  
  public Map<String, String> getResponseHeaders()
  {
    return responseHeaders;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3XmlResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */