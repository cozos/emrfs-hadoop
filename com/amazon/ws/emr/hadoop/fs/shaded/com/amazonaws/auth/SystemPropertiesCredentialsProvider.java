package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class SystemPropertiesCredentialsProvider
  implements AWSCredentialsProvider
{
  public AWSCredentials getCredentials()
  {
    String accessKey = StringUtils.trim(System.getProperty("aws.accessKeyId"));
    String secretKey = StringUtils.trim(System.getProperty("aws.secretKey"));
    String sessionToken = StringUtils.trim(System.getProperty("aws.sessionToken"));
    if ((StringUtils.isNullOrEmpty(accessKey)) || (StringUtils.isNullOrEmpty(secretKey))) {
      throw new SdkClientException("Unable to load AWS credentials from Java system properties (aws.accessKeyId and aws.secretKey)");
    }
    if (StringUtils.isNullOrEmpty(sessionToken)) {
      return new BasicAWSCredentials(accessKey, secretKey);
    }
    return new BasicSessionCredentials(accessKey, secretKey, sessionToken);
  }
  
  public void refresh() {}
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SystemPropertiesCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */