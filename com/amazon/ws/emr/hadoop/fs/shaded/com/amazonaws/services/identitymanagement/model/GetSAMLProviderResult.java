package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.Date;

public class GetSAMLProviderResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String sAMLMetadataDocument;
  private Date createDate;
  private Date validUntil;
  
  public void setSAMLMetadataDocument(String sAMLMetadataDocument)
  {
    this.sAMLMetadataDocument = sAMLMetadataDocument;
  }
  
  public String getSAMLMetadataDocument()
  {
    return sAMLMetadataDocument;
  }
  
  public GetSAMLProviderResult withSAMLMetadataDocument(String sAMLMetadataDocument)
  {
    setSAMLMetadataDocument(sAMLMetadataDocument);
    return this;
  }
  
  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }
  
  public Date getCreateDate()
  {
    return createDate;
  }
  
  public GetSAMLProviderResult withCreateDate(Date createDate)
  {
    setCreateDate(createDate);
    return this;
  }
  
  public void setValidUntil(Date validUntil)
  {
    this.validUntil = validUntil;
  }
  
  public Date getValidUntil()
  {
    return validUntil;
  }
  
  public GetSAMLProviderResult withValidUntil(Date validUntil)
  {
    setValidUntil(validUntil);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSAMLMetadataDocument() != null) {
      sb.append("SAMLMetadataDocument: ").append(getSAMLMetadataDocument()).append(",");
    }
    if (getCreateDate() != null) {
      sb.append("CreateDate: ").append(getCreateDate()).append(",");
    }
    if (getValidUntil() != null) {
      sb.append("ValidUntil: ").append(getValidUntil());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof GetSAMLProviderResult)) {
      return false;
    }
    GetSAMLProviderResult other = (GetSAMLProviderResult)obj;
    if (((other.getSAMLMetadataDocument() == null ? 1 : 0) ^ (getSAMLMetadataDocument() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSAMLMetadataDocument() != null) && (!other.getSAMLMetadataDocument().equals(getSAMLMetadataDocument()))) {
      return false;
    }
    if (((other.getCreateDate() == null ? 1 : 0) ^ (getCreateDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreateDate() != null) && (!other.getCreateDate().equals(getCreateDate()))) {
      return false;
    }
    if (((other.getValidUntil() == null ? 1 : 0) ^ (getValidUntil() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getValidUntil() != null) && (!other.getValidUntil().equals(getValidUntil()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSAMLMetadataDocument() == null ? 0 : getSAMLMetadataDocument().hashCode());
    hashCode = 31 * hashCode + (getCreateDate() == null ? 0 : getCreateDate().hashCode());
    hashCode = 31 * hashCode + (getValidUntil() == null ? 0 : getValidUntil().hashCode());
    return hashCode;
  }
  
  public GetSAMLProviderResult clone()
  {
    try
    {
      return (GetSAMLProviderResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSAMLProviderResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */