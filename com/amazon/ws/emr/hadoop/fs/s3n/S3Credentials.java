package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.net.URI;
import org.apache.hadoop.classification.InterfaceAudience.Private;
import org.apache.hadoop.classification.InterfaceStability.Unstable;
import org.apache.hadoop.conf.Configuration;

@InterfaceAudience.Private
@InterfaceStability.Unstable
public class S3Credentials
{
  private String accessKey;
  private String secretAccessKey;
  private String sessionToken;
  
  public String getAccessKey()
  {
    return accessKey;
  }
  
  public String getSecretAccessKey()
  {
    return secretAccessKey;
  }
  
  public String getSessionToken()
  {
    return sessionToken;
  }
  
  public void initialize(URI uri, Configuration conf)
  {
    if (EmrFsUtils.uriToBucket(uri) == null) {
      throw new IllegalArgumentException("Invalid hostname in URI " + uri);
    }
    String userInfo = uri.getUserInfo();
    if (userInfo != null)
    {
      int index = userInfo.indexOf(':');
      if (index != -1)
      {
        accessKey = userInfo.substring(0, index);
        secretAccessKey = userInfo.substring(index + 1);
      }
      else
      {
        accessKey = userInfo;
      }
    }
    String scheme = uri.getScheme();
    String accessKeyProperty = String.format("fs.%s.awsAccessKeyId", new Object[] { scheme });
    String secretAccessKeyProperty = String.format("fs.%s.awsSecretAccessKey", new Object[] { scheme });
    String sessionTokenProperty = String.format("fs.%s.awsSessionToken", new Object[] { scheme });
    if (accessKey == null) {
      accessKey = conf.get(accessKeyProperty);
    }
    if (secretAccessKey == null) {
      secretAccessKey = conf.get(secretAccessKeyProperty);
    }
    if (sessionToken == null) {
      sessionToken = conf.get(sessionTokenProperty);
    }
    if ((accessKey == null) && (secretAccessKey == null)) {
      throw new IllegalArgumentException("AWS Access Key ID and Secret Access Key must be specified as the username or password (respectively) of a " + scheme + " URL, or by setting the " + accessKeyProperty + " or " + secretAccessKeyProperty + " properties (respectively).");
    }
    if (accessKey == null) {
      throw new IllegalArgumentException("AWS Access Key ID must be specified as the username of a " + scheme + " URL, or by setting the " + accessKeyProperty + " property.");
    }
    if (secretAccessKey == null) {
      throw new IllegalArgumentException("AWS Secret Access Key must be specified as the password of a " + scheme + " URL, or by setting the " + secretAccessKeyProperty + " property.");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.S3Credentials
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */