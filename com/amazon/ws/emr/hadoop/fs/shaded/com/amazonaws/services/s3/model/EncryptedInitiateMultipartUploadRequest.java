package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EncryptedInitiateMultipartUploadRequest
  extends InitiateMultipartUploadRequest
  implements MaterialsDescriptionProvider, Serializable
{
  private Map<String, String> materialsDescription;
  private boolean createEncryptionMaterial = true;
  
  public EncryptedInitiateMultipartUploadRequest(String bucketName, String key)
  {
    super(bucketName, key);
  }
  
  public EncryptedInitiateMultipartUploadRequest(String bucketName, String key, ObjectMetadata objectMetadata)
  {
    super(bucketName, key, objectMetadata);
  }
  
  public Map<String, String> getMaterialsDescription()
  {
    return materialsDescription;
  }
  
  public void setMaterialsDescription(Map<String, String> materialsDescription)
  {
    this.materialsDescription = (materialsDescription == null ? null : Collections.unmodifiableMap(new HashMap(materialsDescription)));
  }
  
  public EncryptedInitiateMultipartUploadRequest withMaterialsDescription(Map<String, String> materialsDescription)
  {
    setMaterialsDescription(materialsDescription);
    return this;
  }
  
  public boolean isCreateEncryptionMaterial()
  {
    return createEncryptionMaterial;
  }
  
  public void setCreateEncryptionMaterial(boolean createEncryptionMaterial)
  {
    this.createEncryptionMaterial = createEncryptionMaterial;
  }
  
  public EncryptedInitiateMultipartUploadRequest withCreateEncryptionMaterial(boolean createEncryptionMaterial)
  {
    this.createEncryptionMaterial = createEncryptionMaterial;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptedInitiateMultipartUploadRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */