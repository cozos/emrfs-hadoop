package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

final class AwsSdkMetrics$1
  implements AWSCredentialsProvider
{
  AwsSdkMetrics$1(PropertiesCredentials paramPropertiesCredentials) {}
  
  public void refresh() {}
  
  public AWSCredentials getCredentials()
  {
    return val$cred;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.AwsSdkMetrics.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */