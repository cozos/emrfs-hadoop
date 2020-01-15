package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateSAMLProviderRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String sAMLMetadataDocument;
  private String sAMLProviderArn;
  
  public void setSAMLMetadataDocument(String sAMLMetadataDocument)
  {
    this.sAMLMetadataDocument = sAMLMetadataDocument;
  }
  
  public String getSAMLMetadataDocument()
  {
    return sAMLMetadataDocument;
  }
  
  public UpdateSAMLProviderRequest withSAMLMetadataDocument(String sAMLMetadataDocument)
  {
    setSAMLMetadataDocument(sAMLMetadataDocument);
    return this;
  }
  
  public void setSAMLProviderArn(String sAMLProviderArn)
  {
    this.sAMLProviderArn = sAMLProviderArn;
  }
  
  public String getSAMLProviderArn()
  {
    return sAMLProviderArn;
  }
  
  public UpdateSAMLProviderRequest withSAMLProviderArn(String sAMLProviderArn)
  {
    setSAMLProviderArn(sAMLProviderArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSAMLMetadataDocument() != null) {
      sb.append("SAMLMetadataDocument: ").append(getSAMLMetadataDocument()).append(",");
    }
    if (getSAMLProviderArn() != null) {
      sb.append("SAMLProviderArn: ").append(getSAMLProviderArn());
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
    if (!(obj instanceof UpdateSAMLProviderRequest)) {
      return false;
    }
    UpdateSAMLProviderRequest other = (UpdateSAMLProviderRequest)obj;
    if (((other.getSAMLMetadataDocument() == null ? 1 : 0) ^ (getSAMLMetadataDocument() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSAMLMetadataDocument() != null) && (!other.getSAMLMetadataDocument().equals(getSAMLMetadataDocument()))) {
      return false;
    }
    if (((other.getSAMLProviderArn() == null ? 1 : 0) ^ (getSAMLProviderArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSAMLProviderArn() != null) && (!other.getSAMLProviderArn().equals(getSAMLProviderArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSAMLMetadataDocument() == null ? 0 : getSAMLMetadataDocument().hashCode());
    hashCode = 31 * hashCode + (getSAMLProviderArn() == null ? 0 : getSAMLProviderArn().hashCode());
    return hashCode;
  }
  
  public UpdateSAMLProviderRequest clone()
  {
    return (UpdateSAMLProviderRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSAMLProviderRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */