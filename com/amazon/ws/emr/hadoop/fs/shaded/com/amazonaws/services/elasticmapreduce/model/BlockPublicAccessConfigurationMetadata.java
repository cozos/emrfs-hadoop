package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.BlockPublicAccessConfigurationMetadataMarshaller;
import java.io.Serializable;
import java.util.Date;

public class BlockPublicAccessConfigurationMetadata
  implements Serializable, Cloneable, StructuredPojo
{
  private Date creationDateTime;
  private String createdByArn;
  
  public void setCreationDateTime(Date creationDateTime)
  {
    this.creationDateTime = creationDateTime;
  }
  
  public Date getCreationDateTime()
  {
    return creationDateTime;
  }
  
  public BlockPublicAccessConfigurationMetadata withCreationDateTime(Date creationDateTime)
  {
    setCreationDateTime(creationDateTime);
    return this;
  }
  
  public void setCreatedByArn(String createdByArn)
  {
    this.createdByArn = createdByArn;
  }
  
  public String getCreatedByArn()
  {
    return createdByArn;
  }
  
  public BlockPublicAccessConfigurationMetadata withCreatedByArn(String createdByArn)
  {
    setCreatedByArn(createdByArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCreationDateTime() != null) {
      sb.append("CreationDateTime: ").append(getCreationDateTime()).append(",");
    }
    if (getCreatedByArn() != null) {
      sb.append("CreatedByArn: ").append(getCreatedByArn());
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
    if (!(obj instanceof BlockPublicAccessConfigurationMetadata)) {
      return false;
    }
    BlockPublicAccessConfigurationMetadata other = (BlockPublicAccessConfigurationMetadata)obj;
    if (((other.getCreationDateTime() == null ? 1 : 0) ^ (getCreationDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationDateTime() != null) && (!other.getCreationDateTime().equals(getCreationDateTime()))) {
      return false;
    }
    if (((other.getCreatedByArn() == null ? 1 : 0) ^ (getCreatedByArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreatedByArn() != null) && (!other.getCreatedByArn().equals(getCreatedByArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCreationDateTime() == null ? 0 : getCreationDateTime().hashCode());
    hashCode = 31 * hashCode + (getCreatedByArn() == null ? 0 : getCreatedByArn().hashCode());
    return hashCode;
  }
  
  public BlockPublicAccessConfigurationMetadata clone()
  {
    try
    {
      return (BlockPublicAccessConfigurationMetadata)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    BlockPublicAccessConfigurationMetadataMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BlockPublicAccessConfigurationMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */