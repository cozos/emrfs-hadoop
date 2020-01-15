package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.BlockPublicAccessConfigurationMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class BlockPublicAccessConfiguration
  implements Serializable, Cloneable, StructuredPojo
{
  private Boolean blockPublicSecurityGroupRules;
  private SdkInternalList<PortRange> permittedPublicSecurityGroupRuleRanges;
  
  public void setBlockPublicSecurityGroupRules(Boolean blockPublicSecurityGroupRules)
  {
    this.blockPublicSecurityGroupRules = blockPublicSecurityGroupRules;
  }
  
  public Boolean getBlockPublicSecurityGroupRules()
  {
    return blockPublicSecurityGroupRules;
  }
  
  public BlockPublicAccessConfiguration withBlockPublicSecurityGroupRules(Boolean blockPublicSecurityGroupRules)
  {
    setBlockPublicSecurityGroupRules(blockPublicSecurityGroupRules);
    return this;
  }
  
  public Boolean isBlockPublicSecurityGroupRules()
  {
    return blockPublicSecurityGroupRules;
  }
  
  public List<PortRange> getPermittedPublicSecurityGroupRuleRanges()
  {
    if (permittedPublicSecurityGroupRuleRanges == null) {
      permittedPublicSecurityGroupRuleRanges = new SdkInternalList();
    }
    return permittedPublicSecurityGroupRuleRanges;
  }
  
  public void setPermittedPublicSecurityGroupRuleRanges(Collection<PortRange> permittedPublicSecurityGroupRuleRanges)
  {
    if (permittedPublicSecurityGroupRuleRanges == null)
    {
      this.permittedPublicSecurityGroupRuleRanges = null;
      return;
    }
    this.permittedPublicSecurityGroupRuleRanges = new SdkInternalList(permittedPublicSecurityGroupRuleRanges);
  }
  
  public BlockPublicAccessConfiguration withPermittedPublicSecurityGroupRuleRanges(PortRange... permittedPublicSecurityGroupRuleRanges)
  {
    if (this.permittedPublicSecurityGroupRuleRanges == null) {
      setPermittedPublicSecurityGroupRuleRanges(new SdkInternalList(permittedPublicSecurityGroupRuleRanges.length));
    }
    for (PortRange ele : permittedPublicSecurityGroupRuleRanges) {
      this.permittedPublicSecurityGroupRuleRanges.add(ele);
    }
    return this;
  }
  
  public BlockPublicAccessConfiguration withPermittedPublicSecurityGroupRuleRanges(Collection<PortRange> permittedPublicSecurityGroupRuleRanges)
  {
    setPermittedPublicSecurityGroupRuleRanges(permittedPublicSecurityGroupRuleRanges);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBlockPublicSecurityGroupRules() != null) {
      sb.append("BlockPublicSecurityGroupRules: ").append(getBlockPublicSecurityGroupRules()).append(",");
    }
    if (getPermittedPublicSecurityGroupRuleRanges() != null) {
      sb.append("PermittedPublicSecurityGroupRuleRanges: ").append(getPermittedPublicSecurityGroupRuleRanges());
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
    if (!(obj instanceof BlockPublicAccessConfiguration)) {
      return false;
    }
    BlockPublicAccessConfiguration other = (BlockPublicAccessConfiguration)obj;
    if (((other.getBlockPublicSecurityGroupRules() == null ? 1 : 0) ^ (getBlockPublicSecurityGroupRules() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBlockPublicSecurityGroupRules() != null) && 
      (!other.getBlockPublicSecurityGroupRules().equals(getBlockPublicSecurityGroupRules()))) {
      return false;
    }
    if (((other.getPermittedPublicSecurityGroupRuleRanges() == null ? 1 : 0) ^ (getPermittedPublicSecurityGroupRuleRanges() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPermittedPublicSecurityGroupRuleRanges() != null) && 
      (!other.getPermittedPublicSecurityGroupRuleRanges().equals(getPermittedPublicSecurityGroupRuleRanges()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBlockPublicSecurityGroupRules() == null ? 0 : getBlockPublicSecurityGroupRules().hashCode());
    hashCode = 31 * hashCode + (getPermittedPublicSecurityGroupRuleRanges() == null ? 0 : getPermittedPublicSecurityGroupRuleRanges().hashCode());
    return hashCode;
  }
  
  public BlockPublicAccessConfiguration clone()
  {
    try
    {
      return (BlockPublicAccessConfiguration)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    BlockPublicAccessConfigurationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BlockPublicAccessConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */