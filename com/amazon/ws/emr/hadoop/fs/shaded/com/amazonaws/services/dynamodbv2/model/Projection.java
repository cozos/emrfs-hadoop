package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ProjectionMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Projection
  implements Serializable, Cloneable, StructuredPojo
{
  private String projectionType;
  private List<String> nonKeyAttributes;
  
  public void setProjectionType(String projectionType)
  {
    this.projectionType = projectionType;
  }
  
  public String getProjectionType()
  {
    return projectionType;
  }
  
  public Projection withProjectionType(String projectionType)
  {
    setProjectionType(projectionType);
    return this;
  }
  
  public void setProjectionType(ProjectionType projectionType)
  {
    withProjectionType(projectionType);
  }
  
  public Projection withProjectionType(ProjectionType projectionType)
  {
    this.projectionType = projectionType.toString();
    return this;
  }
  
  public List<String> getNonKeyAttributes()
  {
    return nonKeyAttributes;
  }
  
  public void setNonKeyAttributes(Collection<String> nonKeyAttributes)
  {
    if (nonKeyAttributes == null)
    {
      this.nonKeyAttributes = null;
      return;
    }
    this.nonKeyAttributes = new ArrayList(nonKeyAttributes);
  }
  
  public Projection withNonKeyAttributes(String... nonKeyAttributes)
  {
    if (this.nonKeyAttributes == null) {
      setNonKeyAttributes(new ArrayList(nonKeyAttributes.length));
    }
    for (String ele : nonKeyAttributes) {
      this.nonKeyAttributes.add(ele);
    }
    return this;
  }
  
  public Projection withNonKeyAttributes(Collection<String> nonKeyAttributes)
  {
    setNonKeyAttributes(nonKeyAttributes);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getProjectionType() != null) {
      sb.append("ProjectionType: ").append(getProjectionType()).append(",");
    }
    if (getNonKeyAttributes() != null) {
      sb.append("NonKeyAttributes: ").append(getNonKeyAttributes());
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
    if (!(obj instanceof Projection)) {
      return false;
    }
    Projection other = (Projection)obj;
    if (((other.getProjectionType() == null ? 1 : 0) ^ (getProjectionType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProjectionType() != null) && (!other.getProjectionType().equals(getProjectionType()))) {
      return false;
    }
    if (((other.getNonKeyAttributes() == null ? 1 : 0) ^ (getNonKeyAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNonKeyAttributes() != null) && (!other.getNonKeyAttributes().equals(getNonKeyAttributes()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getProjectionType() == null ? 0 : getProjectionType().hashCode());
    hashCode = 31 * hashCode + (getNonKeyAttributes() == null ? 0 : getNonKeyAttributes().hashCode());
    return hashCode;
  }
  
  public Projection clone()
  {
    try
    {
      return (Projection)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ProjectionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Projection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */