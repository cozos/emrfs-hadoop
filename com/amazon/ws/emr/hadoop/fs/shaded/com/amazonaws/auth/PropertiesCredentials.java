package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazonaws.auth.AWSCredentials;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCredentials
  implements AWSCredentials
{
  private final String accessKey;
  private final String secretAccessKey;
  
  public PropertiesCredentials(File file)
    throws FileNotFoundException, IOException, IllegalArgumentException
  {
    if (!file.exists()) {
      throw new FileNotFoundException("File doesn't exist:  " + file.getAbsolutePath());
    }
    FileInputStream stream = new FileInputStream(file);
    try
    {
      Properties accountProperties = new Properties();
      accountProperties.load(stream);
      if ((accountProperties.getProperty("accessKey") == null) || 
        (accountProperties.getProperty("secretKey") == null)) {
        throw new IllegalArgumentException("The specified file (" + file.getAbsolutePath() + ") doesn't contain the expected properties 'accessKey' and 'secretKey'.");
      }
      accessKey = accountProperties.getProperty("accessKey");
      secretAccessKey = accountProperties.getProperty("secretKey"); return;
    }
    finally
    {
      try
      {
        stream.close();
      }
      catch (IOException localIOException1) {}
    }
  }
  
  public PropertiesCredentials(InputStream inputStream)
    throws IOException
  {
    Properties accountProperties = new Properties();
    try
    {
      accountProperties.load(inputStream);
      try
      {
        inputStream.close();
      }
      catch (Exception localException) {}
      if (accountProperties.getProperty("accessKey") == null) {
        break label60;
      }
    }
    finally
    {
      try
      {
        inputStream.close();
      }
      catch (Exception localException1) {}
    }
    if (accountProperties.getProperty("secretKey") == null) {
      label60:
      throw new IllegalArgumentException("The specified properties data doesn't contain the expected properties 'accessKey' and 'secretKey'.");
    }
    accessKey = accountProperties.getProperty("accessKey");
    secretAccessKey = accountProperties.getProperty("secretKey");
  }
  
  public String getAWSAccessKeyId()
  {
    return accessKey;
  }
  
  public String getAWSSecretKey()
  {
    return secretAccessKey;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.PropertiesCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */