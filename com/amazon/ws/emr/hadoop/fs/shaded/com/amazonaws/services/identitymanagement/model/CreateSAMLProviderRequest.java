package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreateSAMLProviderRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String sAMLMetadataDocument;
  private String name;
  
  public void setSAMLMetadataDocument(String sAMLMetadataDocument)
  {
    this.sAMLMetadataDocument = sAMLMetadataDocument;
  }
  
  public String getSAMLMetadataDocument()
  {
    return sAMLMetadataDocument;
  }
  
  public CreateSAMLProviderRequest withSAMLMetadataDocument(String sAMLMetadataDocument)
  {
    setSAMLMetadataDocument(sAMLMetadataDocument);
    return this;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public CreateSAMLProviderRequest withName(String name)
  {
    setName(name);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSAMLMetadataDocument() != null) {
      sb.append("SAMLMetadataDocument: ").append(getSAMLMetadataDocument()).append(",");
    }
    if (getName() != null) {
      sb.append("Name: ").append(getName());
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
    if (!(obj instanceof CreateSAMLProviderRequest)) {
      return false;
    }
    CreateSAMLProviderRequest other = (CreateSAMLProviderRequest)obj;
    if (((other.getSAMLMetadataDocument() == null ? 1 : 0) ^ (getSAMLMetadataDocument() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSAMLMetadataDocument() != null) && (!other.getSAMLMetadataDocument().equals(getSAMLMetadataDocument()))) {
      return false;
    }
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSAMLMetadataDocument() == null ? 0 : getSAMLMetadataDocument().hashCode());
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    return hashCode;
  }
  
  public CreateSAMLProviderRequest clone()
  {
    return (CreateSAMLProviderRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateSAMLProviderRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */