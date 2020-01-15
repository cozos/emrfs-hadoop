package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbstractS3ResponseHandler<T>
  implements HttpResponseHandler<AmazonWebServiceResponse<T>>
{
  private static final Log log = LogFactory.getLog(S3MetadataResponseHandler.class);
  private static final Set<String> ignoredHeaders = new HashSet();
  
  static
  {
    ignoredHeaders.add("Date");
    ignoredHeaders.add("Server");
    ignoredHeaders.add("x-amz-request-id");
    ignoredHeaders.add("x-amz-id-2");
    ignoredHeaders.add("X-Amz-Cf-Id");
    ignoredHeaders.add("Connection");
  }
  
  public boolean needsConnectionLeftOpen()
  {
    return false;
  }
  
  protected AmazonWebServiceResponse<T> parseResponseMetadata(HttpResponse response)
  {
    AmazonWebServiceResponse<T> awsResponse = new AmazonWebServiceResponse();
    String awsRequestId = (String)response.getHeaders().get("x-amz-request-id");
    String hostId = (String)response.getHeaders().get("x-amz-id-2");
    String cloudFrontId = (String)response.getHeaders().get("X-Amz-Cf-Id");
    
    Map<String, String> metadataMap = new HashMap();
    metadataMap.put("AWS_REQUEST_ID", awsRequestId);
    metadataMap.put("HOST_ID", hostId);
    metadataMap.put("CLOUD_FRONT_ID", cloudFrontId);
    awsResponse.setResponseMetadata(new S3ResponseMetadata(metadataMap));
    
    return awsResponse;
  }
  
  protected void populateObjectMetadata(HttpResponse response, ObjectMetadata metadata)
  {
    for (Map.Entry<String, String> header : response.getHeaders().entrySet())
    {
      String key = (String)header.getKey();
      if (StringUtils.beginsWithIgnoreCase(key, "x-amz-meta-"))
      {
        key = key.substring("x-amz-meta-".length());
        metadata.addUserMetadata(key, (String)header.getValue());
      }
      else if (!ignoredHeaders.contains(key))
      {
        if (key.equalsIgnoreCase("Last-Modified"))
        {
          try
          {
            metadata.setHeader(key, ServiceUtils.parseRfc822Date((String)header.getValue()));
          }
          catch (Exception pe)
          {
            log.warn("Unable to parse last modified date: " + (String)header.getValue(), pe);
          }
        }
        else if (key.equalsIgnoreCase("Content-Length"))
        {
          try
          {
            metadata.setHeader(key, Long.valueOf(Long.parseLong((String)header.getValue())));
          }
          catch (NumberFormatException nfe)
          {
            throw new SdkClientException("Unable to parse content length. Header 'Content-Length' has corrupted data" + nfe.getMessage(), nfe);
          }
        }
        else if (key.equalsIgnoreCase("ETag"))
        {
          metadata.setHeader(key, ServiceUtils.removeQuotes((String)header.getValue()));
        }
        else if (key.equalsIgnoreCase("Expires"))
        {
          metadata.setHeader("Expires", header.getValue());
          try
          {
            metadata.setHttpExpiresDate(DateUtils.parseRFC822Date((String)header.getValue()));
          }
          catch (Exception pe)
          {
            log.warn("Unable to parse http expiration date: " + (String)header.getValue(), pe);
          }
        }
        else if (key.equalsIgnoreCase("x-amz-expiration"))
        {
          new ObjectExpirationHeaderHandler().handle(metadata, response);
        }
        else if (key.equalsIgnoreCase("x-amz-restore"))
        {
          new ObjectRestoreHeaderHandler().handle(metadata, response);
        }
        else if (key.equalsIgnoreCase("x-amz-request-charged"))
        {
          new S3RequesterChargedHeaderHandler().handle(metadata, response);
        }
        else if (key.equalsIgnoreCase("x-amz-mp-parts-count"))
        {
          try
          {
            metadata.setHeader(key, Integer.valueOf(Integer.parseInt((String)header.getValue())));
          }
          catch (NumberFormatException nfe)
          {
            throw new SdkClientException("Unable to parse part count. Header x-amz-mp-parts-count has corrupted data" + nfe.getMessage(), nfe);
          }
        }
        else
        {
          metadata.setHeader(key, header.getValue());
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.AbstractS3ResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */