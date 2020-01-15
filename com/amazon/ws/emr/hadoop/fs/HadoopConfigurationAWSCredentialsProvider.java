package com.amazon.ws.emr.hadoop.fs;

import com.amazon.ws.emr.hadoop.fs.s3n.S3Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.BasicAWSCredentials;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.BasicSessionCredentials;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HadoopConfigurationAWSCredentialsProvider
  implements AWSCredentialsProvider
{
  private static final Logger logger = LoggerFactory.getLogger(HadoopConfigurationAWSCredentialsProvider.class);
  public static final String AWS_ACCESS_KEY_ID_PROPERTY = "fs.%s.awsAccessKeyId";
  public static final String AWS_SECRET_ACCESS_KEY_PROPERTY = "fs.%s.awsSecretAccessKey";
  public static final String AWS_SESSION_TOKEN_PROPERTY = "fs.%s.awsSessionToken";
  private AWSCredentials awsCredentials;
  
  public HadoopConfigurationAWSCredentialsProvider(Configuration configuration, String scheme)
  {
    this(configuration, 
      String.format("fs.%s.awsAccessKeyId", new Object[] { scheme }), 
      String.format("fs.%s.awsSecretAccessKey", new Object[] { scheme }), 
      String.format("fs.%s.awsSessionToken", new Object[] { scheme }));
  }
  
  public HadoopConfigurationAWSCredentialsProvider(Configuration configuration, URI uri)
  {
    try
    {
      S3Credentials s3Credentials = new S3Credentials();
      s3Credentials.initialize(uri, configuration);
      
      awsCredentials = createCredentials(s3Credentials.getAccessKey(), s3Credentials
        .getSecretAccessKey(), s3Credentials
        .getSessionToken());
    }
    catch (IllegalArgumentException ex)
    {
      logger.debug("Couldn't extract aws credentials from either uri {} or hadoop configuration.", uri);
    }
  }
  
  public HadoopConfigurationAWSCredentialsProvider(Configuration configuration, String accessKeyProperty, String secretKeyProperty)
  {
    this(configuration, accessKeyProperty, secretKeyProperty, null);
  }
  
  public HadoopConfigurationAWSCredentialsProvider(Configuration configuration, String accessKeyProperty, String secretKeyProperty, String sessionTokenProperty)
  {
    String accessKey = configuration.get(accessKeyProperty, null);
    String secretKey = configuration.get(secretKeyProperty, null);
    
    String sessionToken = sessionTokenProperty == null ? null : configuration.get(sessionTokenProperty, null);
    if ((Strings.isNullOrEmpty(accessKey)) && (Strings.isNullOrEmpty(secretKey))) {
      logger.debug("AWS access key and secret key should be specified in the Hadoop configuration using the keys {} and {}.", accessKeyProperty, secretKeyProperty);
    } else if (Strings.isNullOrEmpty(accessKey)) {
      logger.debug("AWS access key should be specified in the Hadoop configuration using the key {} ", accessKeyProperty);
    } else if (Strings.isNullOrEmpty(secretKey)) {
      logger.debug("AWS secret key should be specified in the Hadoop configuration using the key {} ", secretKeyProperty);
    } else {
      awsCredentials = createCredentials(accessKey, secretKey, sessionToken);
    }
  }
  
  public AWSCredentials getCredentials()
  {
    return awsCredentials;
  }
  
  public void refresh() {}
  
  private static AWSCredentials createCredentials(String accessKey, String secretKey, String sessionToken)
  {
    return sessionToken == null ? new BasicAWSCredentials(accessKey, secretKey) : new BasicSessionCredentials(accessKey, secretKey, sessionToken);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.HadoopConfigurationAWSCredentialsProvider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */