package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.io.Serializable;

@Immutable
public class S3ObjectId
  implements Serializable
{
  private final String bucket;
  private final String key;
  private final String versionId;
  
  public S3ObjectId(String bucket, String key)
  {
    this(bucket, key, null);
  }
  
  public S3ObjectId(String bucket, String key, String versionId)
  {
    if ((bucket == null) || (key == null)) {
      throw new IllegalArgumentException("bucket and key must be specified");
    }
    this.bucket = bucket;
    this.key = key;
    this.versionId = versionId;
  }
  
  public S3ObjectId(S3ObjectIdBuilder builder)
  {
    bucket = builder.getBucket();
    key = builder.getKey();
    versionId = builder.getVersionId();
  }
  
  public String getBucket()
  {
    return bucket;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public InstructionFileId instructionFileId()
  {
    return instructionFileId(null);
  }
  
  public InstructionFileId instructionFileId(String suffix)
  {
    String ifileKey = key + ".";
    ifileKey = ifileKey + ((suffix == null) || (suffix.trim().length() == 0) ? "instruction" : suffix);
    
    return new InstructionFileId(bucket, ifileKey, versionId);
  }
  
  public String toString()
  {
    return "bucket: " + bucket + ", key: " + key + ", versionId: " + versionId;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */