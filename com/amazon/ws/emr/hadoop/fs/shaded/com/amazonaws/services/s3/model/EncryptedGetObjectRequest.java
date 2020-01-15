package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Map;

public class EncryptedGetObjectRequest
  extends GetObjectRequest
  implements Serializable
{
  private ExtraMaterialsDescription supplemental = ExtraMaterialsDescription.NONE;
  private String instructionFileSuffix;
  private boolean keyWrapExpected;
  
  public EncryptedGetObjectRequest(String bucketName, String key)
  {
    this(bucketName, key, null);
  }
  
  public EncryptedGetObjectRequest(String bucketName, String key, String versionId)
  {
    super(bucketName, key, versionId);
    setKey(key);
    setVersionId(versionId);
  }
  
  public EncryptedGetObjectRequest(S3ObjectId s3ObjectId)
  {
    super(s3ObjectId);
  }
  
  public EncryptedGetObjectRequest(String bucketName, String key, boolean isRequesterPays)
  {
    super(bucketName, key, isRequesterPays);
  }
  
  public ExtraMaterialsDescription getExtraMaterialDescription()
  {
    return supplemental;
  }
  
  public void setExtraMaterialDescription(ExtraMaterialsDescription supplemental)
  {
    this.supplemental = (supplemental == null ? ExtraMaterialsDescription.NONE : supplemental);
  }
  
  public EncryptedGetObjectRequest withExtraMaterialsDescription(ExtraMaterialsDescription supplemental)
  {
    setExtraMaterialDescription(supplemental);
    return this;
  }
  
  public EncryptedGetObjectRequest withExtraMaterialsDescription(Map<String, String> supplemental)
  {
    setExtraMaterialDescription(supplemental == null ? null : new ExtraMaterialsDescription(supplemental));
    
    return this;
  }
  
  public String getInstructionFileSuffix()
  {
    return instructionFileSuffix;
  }
  
  public void setInstructionFileSuffix(String instructionFileSuffix)
  {
    this.instructionFileSuffix = instructionFileSuffix;
  }
  
  public EncryptedGetObjectRequest withInstructionFileSuffix(String instructionFileSuffix)
  {
    this.instructionFileSuffix = instructionFileSuffix;
    return this;
  }
  
  public boolean isKeyWrapExpected()
  {
    return keyWrapExpected;
  }
  
  public void setKeyWrapExpected(boolean keyWrapExpected)
  {
    this.keyWrapExpected = keyWrapExpected;
  }
  
  public EncryptedGetObjectRequest withKeyWrapExpected(boolean keyWrapExpected)
  {
    this.keyWrapExpected = keyWrapExpected;
    return this;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EncryptedGetObjectRequest)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    EncryptedGetObjectRequest that = (EncryptedGetObjectRequest)o;
    if (keyWrapExpected != that.isKeyWrapExpected()) {
      return false;
    }
    if (supplemental != null ? !supplemental.equals(supplemental) : supplemental != null) {
      return false;
    }
    return that.getInstructionFileSuffix() == null ? true : getInstructionFileSuffix() != null ? getInstructionFileSuffix().equals(that.getInstructionFileSuffix()) : false;
  }
  
  public int hashCode()
  {
    int prime = 31;
    
    int result = super.hashCode();
    result = prime * result + (supplemental != null ? supplemental.hashCode() : 0);
    result = prime * result + (getInstructionFileSuffix() != null ? getInstructionFileSuffix().hashCode() : 0);
    result = prime * result + (isKeyWrapExpected() ? 1 : 0);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptedGetObjectRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */