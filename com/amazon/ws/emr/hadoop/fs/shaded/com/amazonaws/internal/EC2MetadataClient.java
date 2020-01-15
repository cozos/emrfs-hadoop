package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.VersionInfoUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Deprecated
public class EC2MetadataClient
{
  private static final String EC2_METADATA_SERVICE_URL = "http://169.254.169.254";
  public static final String SECURITY_CREDENTIALS_RESOURCE = "/latest/meta-data/iam/security-credentials/";
  private static final Log log = LogFactory.getLog(EC2MetadataClient.class);
  private static final String USER_AGENT = String.format("aws-sdk-java/%s", new Object[] { VersionInfoUtils.getVersion() });
  
  public String getDefaultCredentials()
    throws IOException
  {
    String securityCredentialsList = readResource("/latest/meta-data/iam/security-credentials/");
    
    securityCredentialsList = securityCredentialsList.trim();
    String[] securityCredentials = securityCredentialsList.split("\n");
    if (securityCredentials.length == 0) {
      return null;
    }
    String securityCredentialsName = securityCredentials[0];
    
    return readResource("/latest/meta-data/iam/security-credentials/" + securityCredentialsName);
  }
  
  public String readResource(String resourcePath)
    throws IOException, SdkClientException
  {
    URL url = getEc2MetadataServiceUrlForResource(resourcePath);
    log.debug("Connecting to EC2 instance metadata service at URL: " + url.toString());
    
    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
    connection.setConnectTimeout(2000);
    connection.setReadTimeout(5000);
    connection.setRequestMethod("GET");
    connection.setDoOutput(true);
    connection.addRequestProperty("User-Agent", USER_AGENT);
    connection.connect();
    
    return readResponse(connection);
  }
  
  private String readResponse(HttpURLConnection connection)
    throws IOException
  {
    if (connection.getResponseCode() == 404) {
      throw new SdkClientException("The requested metadata is not found at " + connection.getURL());
    }
    InputStream inputStream = connection.getInputStream();
    try
    {
      StringBuilder buffer = new StringBuilder();
      int c;
      for (;;)
      {
        c = inputStream.read();
        if (c == -1) {
          break;
        }
        buffer.append((char)c);
      }
      return buffer.toString();
    }
    finally
    {
      inputStream.close();
    }
  }
  
  private URL getEc2MetadataServiceUrlForResource(String resourcePath)
    throws IOException
  {
    String endpoint = "http://169.254.169.254";
    if (System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.ec2MetadataServiceEndpointOverride") != null) {
      endpoint = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.ec2MetadataServiceEndpointOverride");
    }
    return new URL(endpoint + resourcePath);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.EC2MetadataClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */