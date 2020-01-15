package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.io.IOException;
import java.io.InputStream;

public class ClasspathPropertiesFileCredentialsProvider
  implements AWSCredentialsProvider
{
  private static String DEFAULT_PROPERTIES_FILE = "AwsCredentials.properties";
  private final String credentialsFilePath;
  
  public ClasspathPropertiesFileCredentialsProvider()
  {
    this(DEFAULT_PROPERTIES_FILE);
  }
  
  public ClasspathPropertiesFileCredentialsProvider(String credentialsFilePath)
  {
    if (credentialsFilePath == null) {
      throw new IllegalArgumentException("Credentials file path cannot be null");
    }
    if (!credentialsFilePath.startsWith("/")) {
      this.credentialsFilePath = ("/" + credentialsFilePath);
    } else {
      this.credentialsFilePath = credentialsFilePath;
    }
  }
  
  public AWSCredentials getCredentials()
  {
    InputStream inputStream = getClass().getResourceAsStream(credentialsFilePath);
    if (inputStream == null) {
      throw new SdkClientException("Unable to load AWS credentials from the " + credentialsFilePath + " file on the classpath");
    }
    try
    {
      return new PropertiesCredentials(inputStream);
    }
    catch (IOException e)
    {
      throw new SdkClientException("Unable to load AWS credentials from the " + credentialsFilePath + " file on the classpath", e);
    }
  }
  
  public void refresh() {}
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + credentialsFilePath + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */