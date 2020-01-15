package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeleteObjectsRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private boolean quiet;
  private MultiFactorAuthentication mfa;
  private final List<KeyVersion> keys = new ArrayList();
  private boolean isRequesterPays;
  private boolean bypassGovernanceRetention;
  
  public DeleteObjectsRequest(String bucketName)
  {
    setBucketName(bucketName);
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public DeleteObjectsRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public MultiFactorAuthentication getMfa()
  {
    return mfa;
  }
  
  public void setMfa(MultiFactorAuthentication mfa)
  {
    this.mfa = mfa;
  }
  
  public DeleteObjectsRequest withMfa(MultiFactorAuthentication mfa)
  {
    setMfa(mfa);
    return this;
  }
  
  public void setQuiet(boolean quiet)
  {
    this.quiet = quiet;
  }
  
  public boolean getQuiet()
  {
    return quiet;
  }
  
  public DeleteObjectsRequest withQuiet(boolean quiet)
  {
    setQuiet(quiet);
    return this;
  }
  
  public void setKeys(List<KeyVersion> keys)
  {
    this.keys.clear();
    this.keys.addAll(keys);
  }
  
  public DeleteObjectsRequest withKeys(List<KeyVersion> keys)
  {
    setKeys(keys);
    return this;
  }
  
  public List<KeyVersion> getKeys()
  {
    return keys;
  }
  
  public DeleteObjectsRequest withKeys(String... keys)
  {
    List<KeyVersion> keyVersions = new ArrayList(keys.length);
    for (String key : keys) {
      keyVersions.add(new KeyVersion(key));
    }
    setKeys(keyVersions);
    return this;
  }
  
  public boolean isRequesterPays()
  {
    return isRequesterPays;
  }
  
  public void setRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
  }
  
  public DeleteObjectsRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
  
  public boolean getBypassGovernanceRetention()
  {
    return bypassGovernanceRetention;
  }
  
  public DeleteObjectsRequest withBypassGovernanceRetention(boolean bypassGovernanceRetention)
  {
    this.bypassGovernanceRetention = bypassGovernanceRetention;
    return this;
  }
  
  public void setBypassGovernanceRetention(boolean bypassGovernanceRetention)
  {
    withBypassGovernanceRetention(bypassGovernanceRetention);
  }
  
  public static class KeyVersion
    implements Serializable
  {
    private final String key;
    private final String version;
    
    public KeyVersion(String key)
    {
      this(key, null);
    }
    
    public KeyVersion(String key, String version)
    {
      this.key = key;
      this.version = version;
    }
    
    public String getKey()
    {
      return key;
    }
    
    public String getVersion()
    {
      return version;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */