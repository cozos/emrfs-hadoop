package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class MultipartUploadContext
{
  private final String bucketName;
  private final String key;
  private boolean hasFinalPartBeenSeen;
  private Map<String, String> materialsDescription;
  
  protected MultipartUploadContext(String bucketName, String key)
  {
    this.bucketName = bucketName;
    this.key = key;
  }
  
  public final String getBucketName()
  {
    return bucketName;
  }
  
  public final String getKey()
  {
    return key;
  }
  
  public final boolean hasFinalPartBeenSeen()
  {
    return hasFinalPartBeenSeen;
  }
  
  public final void setHasFinalPartBeenSeen(boolean hasFinalPartBeenSeen)
  {
    this.hasFinalPartBeenSeen = hasFinalPartBeenSeen;
  }
  
  public final Map<String, String> getMaterialsDescription()
  {
    return materialsDescription;
  }
  
  public final void setMaterialsDescription(Map<String, String> materialsDescription)
  {
    this.materialsDescription = (materialsDescription == null ? null : Collections.unmodifiableMap(new HashMap(materialsDescription)));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.MultipartUploadContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */