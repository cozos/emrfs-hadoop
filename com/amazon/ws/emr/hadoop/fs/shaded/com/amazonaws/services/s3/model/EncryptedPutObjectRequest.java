package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EncryptedPutObjectRequest
  extends PutObjectRequest
  implements MaterialsDescriptionProvider, Serializable
{
  private Map<String, String> materialsDescription;
  
  public EncryptedPutObjectRequest(String bucketName, String key, File file)
  {
    super(bucketName, key, file);
  }
  
  public EncryptedPutObjectRequest(String bucketName, String key, String redirectLocation)
  {
    super(bucketName, key, redirectLocation);
  }
  
  public EncryptedPutObjectRequest(String bucketName, String key, InputStream input, ObjectMetadata metadata)
  {
    super(bucketName, key, input, metadata);
  }
  
  public Map<String, String> getMaterialsDescription()
  {
    return materialsDescription;
  }
  
  public void setMaterialsDescription(Map<String, String> materialsDescription)
  {
    this.materialsDescription = (materialsDescription == null ? null : Collections.unmodifiableMap(new HashMap(materialsDescription)));
  }
  
  public EncryptedPutObjectRequest withMaterialsDescription(Map<String, String> materialsDescription)
  {
    setMaterialsDescription(materialsDescription);
    return this;
  }
  
  public EncryptedPutObjectRequest clone()
  {
    EncryptedPutObjectRequest cloned = (EncryptedPutObjectRequest)super.clone();
    Map<String, String> materialsDescription = getMaterialsDescription();
    cloned.withMaterialsDescription(materialsDescription == null ? null : new HashMap(materialsDescription));
    
    return cloned;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptedPutObjectRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */