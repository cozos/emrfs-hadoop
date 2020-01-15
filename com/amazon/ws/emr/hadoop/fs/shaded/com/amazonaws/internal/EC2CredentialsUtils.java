package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.CredentialsEndpointRetryParameters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.CredentialsEndpointRetryParameters.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.CredentialsEndpointRetryPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.VersionInfoUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@SdkInternalApi
public final class EC2CredentialsUtils
{
  private static final Log LOG = LogFactory.getLog(EC2CredentialsUtils.class);
  private static EC2CredentialsUtils instance;
  private final ConnectionUtils connectionUtils;
  private static final String USER_AGENT = VersionInfoUtils.getUserAgent();
  
  private EC2CredentialsUtils()
  {
    this(ConnectionUtils.getInstance());
  }
  
  EC2CredentialsUtils(ConnectionUtils connectionUtils)
  {
    this.connectionUtils = connectionUtils;
  }
  
  public static EC2CredentialsUtils getInstance()
  {
    if (instance == null) {
      instance = new EC2CredentialsUtils();
    }
    return instance;
  }
  
  public String readResource(URI endpoint)
    throws IOException
  {
    return readResource(endpoint, CredentialsEndpointRetryPolicy.NO_RETRY, null);
  }
  
  public String readResource(URI endpoint, CredentialsEndpointRetryPolicy retryPolicy, Map<String, String> headers)
    throws IOException
  {
    int retriesAttempted = 0;
    InputStream inputStream = null;
    
    headers = addDefaultHeaders(headers);
    for (;;)
    {
      try
      {
        HttpURLConnection connection = connectionUtils.connectToEndpoint(endpoint, headers);
        
        int statusCode = connection.getResponseCode();
        if (statusCode == 200)
        {
          inputStream = connection.getInputStream();
          return IOUtils.toString(inputStream);
        }
        if (statusCode == 404) {
          throw new SdkClientException("The requested metadata is not found at " + connection.getURL());
        }
        if (!retryPolicy.shouldRetry(retriesAttempted++, CredentialsEndpointRetryParameters.builder().withStatusCode(Integer.valueOf(statusCode)).build()))
        {
          inputStream = connection.getErrorStream();
          handleErrorResponse(inputStream, statusCode, connection.getResponseMessage());
        }
      }
      catch (IOException ioException)
      {
        if (!retryPolicy.shouldRetry(retriesAttempted++, CredentialsEndpointRetryParameters.builder().withException(ioException).build())) {
          throw ioException;
        }
        LOG.debug("An IOException occured when connecting to service endpoint: " + endpoint + "\n Retrying to connect again.");
      }
      finally
      {
        IOUtils.closeQuietly(inputStream, LOG);
      }
    }
  }
  
  private Map<String, String> addDefaultHeaders(Map<String, String> headers)
  {
    HashMap<String, String> map = new HashMap();
    if (headers != null) {
      map.putAll(headers);
    }
    putIfAbsent(map, "User-Agent", USER_AGENT);
    putIfAbsent(map, "Accept", "*/*");
    putIfAbsent(map, "Connection", "keep-alive");
    return map;
  }
  
  private <K, V> void putIfAbsent(Map<K, V> map, K key, V value)
  {
    if (map.get(key) == null) {
      map.put(key, value);
    }
  }
  
  private void handleErrorResponse(InputStream errorStream, int statusCode, String responseMessage)
    throws IOException
  {
    String errorCode = null;
    if (errorStream != null)
    {
      String errorResponse = IOUtils.toString(errorStream);
      try
      {
        JsonNode node = Jackson.jsonNodeOf(errorResponse);
        JsonNode code = node.get("code");
        JsonNode message = node.get("message");
        if ((code != null) && (message != null))
        {
          errorCode = code.asText();
          responseMessage = message.asText();
        }
      }
      catch (Exception exception)
      {
        LOG.debug("Unable to parse error stream");
      }
    }
    AmazonServiceException ase = new AmazonServiceException(responseMessage);
    ase.setStatusCode(statusCode);
    ase.setErrorCode(errorCode);
    throw ase;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.EC2CredentialsUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */