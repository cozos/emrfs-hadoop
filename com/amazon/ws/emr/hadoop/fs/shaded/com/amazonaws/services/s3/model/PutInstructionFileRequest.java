package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class PutInstructionFileRequest
  extends AmazonWebServiceRequest
  implements MaterialsDescriptionProvider, EncryptionMaterialsFactory
{
  private final S3ObjectId s3ObjectId;
  private final EncryptionMaterials encryptionMaterials;
  private final Map<String, String> matDesc;
  private final String suffix;
  private CannedAccessControlList cannedAcl;
  private AccessControlList accessControlList;
  private String redirectLocation;
  private String storageClass;
  
  public PutInstructionFileRequest(S3ObjectId s3ObjectId, Map<String, String> matDesc, String suffix)
  {
    if ((s3ObjectId == null) || ((s3ObjectId instanceof InstructionFileId))) {
      throw new IllegalArgumentException("Invalid s3 object id");
    }
    if ((suffix == null) || (suffix.trim().isEmpty())) {
      throw new IllegalArgumentException("suffix must be specified");
    }
    this.s3ObjectId = s3ObjectId;
    
    Map<String, String> md = matDesc == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new HashMap(matDesc));
    this.matDesc = md;
    this.suffix = suffix;
    encryptionMaterials = null;
  }
  
  public PutInstructionFileRequest(S3ObjectId s3ObjectId, EncryptionMaterials encryptionMaterials, String suffix)
  {
    if ((s3ObjectId == null) || ((s3ObjectId instanceof InstructionFileId))) {
      throw new IllegalArgumentException("Invalid s3 object id");
    }
    if ((suffix == null) || (suffix.trim().isEmpty())) {
      throw new IllegalArgumentException("suffix must be specified");
    }
    if (encryptionMaterials == null) {
      throw new IllegalArgumentException("encryption materials must be specified");
    }
    this.s3ObjectId = s3ObjectId;
    this.suffix = suffix;
    this.encryptionMaterials = encryptionMaterials;
    matDesc = null;
  }
  
  public S3ObjectId getS3ObjectId()
  {
    return s3ObjectId;
  }
  
  public Map<String, String> getMaterialsDescription()
  {
    return matDesc == null ? encryptionMaterials
      .getMaterialsDescription() : matDesc;
  }
  
  public EncryptionMaterials getEncryptionMaterials()
  {
    return encryptionMaterials;
  }
  
  public String getSuffix()
  {
    return suffix;
  }
  
  public CannedAccessControlList getCannedAcl()
  {
    return cannedAcl;
  }
  
  public void setCannedAcl(CannedAccessControlList cannedAcl)
  {
    this.cannedAcl = cannedAcl;
  }
  
  public PutInstructionFileRequest withCannedAcl(CannedAccessControlList cannedAcl)
  {
    setCannedAcl(cannedAcl);
    return this;
  }
  
  public AccessControlList getAccessControlList()
  {
    return accessControlList;
  }
  
  public void setAccessControlList(AccessControlList accessControlList)
  {
    this.accessControlList = accessControlList;
  }
  
  public PutInstructionFileRequest withAccessControlList(AccessControlList accessControlList)
  {
    setAccessControlList(accessControlList);
    return this;
  }
  
  public String getRedirectLocation()
  {
    return redirectLocation;
  }
  
  public void setRedirectLocation(String redirectLocation)
  {
    this.redirectLocation = redirectLocation;
  }
  
  public PutInstructionFileRequest withRedirectLocation(String redirectLocation)
  {
    this.redirectLocation = redirectLocation;
    return this;
  }
  
  public String getStorageClass()
  {
    return storageClass;
  }
  
  public void setStorageClass(String storageClass)
  {
    this.storageClass = storageClass;
  }
  
  public PutInstructionFileRequest withStorageClass(String storageClass)
  {
    setStorageClass(storageClass);
    return this;
  }
  
  public void setStorageClass(StorageClass storageClass)
  {
    this.storageClass = storageClass.toString();
  }
  
  public PutInstructionFileRequest withStorageClass(StorageClass storageClass)
  {
    setStorageClass(storageClass);
    return this;
  }
  
  public PutObjectRequest createPutObjectRequest(S3Object s3Object)
  {
    if ((!s3Object.getBucketName().equals(s3ObjectId.getBucket())) || 
      (!s3Object.getKey().equals(s3ObjectId.getKey()))) {
      throw new IllegalArgumentException("s3Object passed inconsistent with the instruction file being created");
    }
    InstructionFileId ifid = s3ObjectId.instructionFileId(suffix);
    
    return 
    
      (PutObjectRequest)new PutObjectRequest(ifid.getBucket(), ifid.getKey(), redirectLocation).withAccessControlList(accessControlList).withCannedAcl(cannedAcl).withStorageClass(storageClass).withGeneralProgressListener(getGeneralProgressListener()).withRequestMetricCollector(getRequestMetricCollector());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutInstructionFileRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */