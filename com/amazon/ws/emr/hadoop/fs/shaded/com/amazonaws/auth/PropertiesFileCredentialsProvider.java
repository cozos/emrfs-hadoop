package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.io.File;
import java.io.IOException;

public class PropertiesFileCredentialsProvider
  implements AWSCredentialsProvider
{
  private final String credentialsFilePath;
  
  public PropertiesFileCredentialsProvider(String credentialsFilePath)
  {
    if (credentialsFilePath == null) {
      throw new IllegalArgumentException("Credentials file path cannot be null");
    }
    this.credentialsFilePath = credentialsFilePath;
  }
  
  public AWSCredentials getCredentials()
  {
    try
    {
      return new PropertiesCredentials(new File(credentialsFilePath));
    }
    catch (IOException e)
    {
      throw new SdkClientException("Unable to load AWS credentials from the " + credentialsFilePath + " file", e);
    }
  }
  
  public void refresh() {}
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + credentialsFilePath + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.PropertiesFileCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */