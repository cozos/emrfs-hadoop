package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class EnvironmentVariableCredentialsProvider
  implements AWSCredentialsProvider
{
  public AWSCredentials getCredentials()
  {
    String accessKey = System.getenv("AWS_ACCESS_KEY_ID");
    if (accessKey == null) {
      accessKey = System.getenv("AWS_ACCESS_KEY");
    }
    String secretKey = System.getenv("AWS_SECRET_KEY");
    if (secretKey == null) {
      secretKey = System.getenv("AWS_SECRET_ACCESS_KEY");
    }
    accessKey = StringUtils.trim(accessKey);
    secretKey = StringUtils.trim(secretKey);
    String sessionToken = StringUtils.trim(System.getenv("AWS_SESSION_TOKEN"));
    if ((StringUtils.isNullOrEmpty(accessKey)) || (StringUtils.isNullOrEmpty(secretKey))) {
      throw new SdkClientException("Unable to load AWS credentials from environment variables (AWS_ACCESS_KEY_ID (or AWS_ACCESS_KEY) and AWS_SECRET_KEY (or AWS_SECRET_ACCESS_KEY))");
    }
    return sessionToken == null ? new BasicAWSCredentials(accessKey, secretKey) : new BasicSessionCredentials(accessKey, secretKey, sessionToken);
  }
  
  public void refresh() {}
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.EnvironmentVariableCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */