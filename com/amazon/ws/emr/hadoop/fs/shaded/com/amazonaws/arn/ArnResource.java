package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

public class ArnResource
{
  private final String resourceType;
  private final String resource;
  private final String qualifier;
  
  private ArnResource(Builder b)
  {
    resourceType = resourceType;
    resource = ValidationUtils.assertStringNotEmpty(resource, "resource");
    qualifier = qualifier;
  }
  
  public String getResourceType()
  {
    return resourceType;
  }
  
  public String getResource()
  {
    return resource;
  }
  
  public String getQualifier()
  {
    return qualifier;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static ArnResource fromString(String resource)
  {
    Character splitter = StringUtils.findFirstOccurrence(resource, new char[] { ':', '/' });
    if (splitter == null) {
      return builder().withResource(resource).build();
    }
    int resourceTypeColonIndex = resource.indexOf(splitter.charValue());
    
    Builder builder = builder().withResourceType(resource.substring(0, resourceTypeColonIndex));
    int resourceColonIndex = resource.indexOf(splitter.charValue(), resourceTypeColonIndex);
    int qualifierColonIndex = resource.indexOf(splitter.charValue(), resourceColonIndex + 1);
    if (qualifierColonIndex < 0)
    {
      builder.withResource(resource.substring(resourceTypeColonIndex + 1));
    }
    else
    {
      builder.withResource(resource.substring(resourceTypeColonIndex + 1, qualifierColonIndex));
      builder.withQualifier(resource.substring(qualifierColonIndex + 1));
    }
    return builder.build();
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append(resourceType);
    sb.append(":");
    sb.append(resource);
    sb.append(":");
    sb.append(qualifier);
    return sb.toString();
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    ArnResource that = (ArnResource)o;
    if (resourceType != null ? !resourceType.equals(resourceType) : resourceType != null) {
      return false;
    }
    if (!resource.equals(resource)) {
      return false;
    }
    return qualifier == null ? true : qualifier != null ? qualifier.equals(qualifier) : false;
  }
  
  public int hashCode()
  {
    int result = resourceType != null ? resourceType.hashCode() : 0;
    result = 31 * result + resource.hashCode();
    result = 31 * result + (qualifier != null ? qualifier.hashCode() : 0);
    return result;
  }
  
  public static final class Builder
  {
    private String resourceType;
    private String resource;
    private String qualifier;
    
    public void setResourceType(String resourceType)
    {
      this.resourceType = resourceType;
    }
    
    public Builder withResourceType(String resourceType)
    {
      setResourceType(resourceType);
      return this;
    }
    
    public void setResource(String resource)
    {
      this.resource = resource;
    }
    
    public Builder withResource(String resource)
    {
      setResource(resource);
      return this;
    }
    
    public void setQualifier(String qualifier)
    {
      this.qualifier = qualifier;
    }
    
    public Builder withQualifier(String qualifier)
    {
      setQualifier(qualifier);
      return this;
    }
    
    public ArnResource build()
    {
      return new ArnResource(this, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn.ArnResource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */