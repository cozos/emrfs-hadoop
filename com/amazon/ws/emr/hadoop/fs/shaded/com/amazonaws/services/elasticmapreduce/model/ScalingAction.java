package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScalingActionMarshaller;
import java.io.Serializable;

public class ScalingAction
  implements Serializable, Cloneable, StructuredPojo
{
  private String market;
  private SimpleScalingPolicyConfiguration simpleScalingPolicyConfiguration;
  
  public void setMarket(String market)
  {
    this.market = market;
  }
  
  public String getMarket()
  {
    return market;
  }
  
  public ScalingAction withMarket(String market)
  {
    setMarket(market);
    return this;
  }
  
  public void setMarket(MarketType market)
  {
    withMarket(market);
  }
  
  public ScalingAction withMarket(MarketType market)
  {
    this.market = market.toString();
    return this;
  }
  
  public void setSimpleScalingPolicyConfiguration(SimpleScalingPolicyConfiguration simpleScalingPolicyConfiguration)
  {
    this.simpleScalingPolicyConfiguration = simpleScalingPolicyConfiguration;
  }
  
  public SimpleScalingPolicyConfiguration getSimpleScalingPolicyConfiguration()
  {
    return simpleScalingPolicyConfiguration;
  }
  
  public ScalingAction withSimpleScalingPolicyConfiguration(SimpleScalingPolicyConfiguration simpleScalingPolicyConfiguration)
  {
    setSimpleScalingPolicyConfiguration(simpleScalingPolicyConfiguration);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMarket() != null) {
      sb.append("Market: ").append(getMarket()).append(",");
    }
    if (getSimpleScalingPolicyConfiguration() != null) {
      sb.append("SimpleScalingPolicyConfiguration: ").append(getSimpleScalingPolicyConfiguration());
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
    if (!(obj instanceof ScalingAction)) {
      return false;
    }
    ScalingAction other = (ScalingAction)obj;
    if (((other.getMarket() == null ? 1 : 0) ^ (getMarket() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarket() != null) && (!other.getMarket().equals(getMarket()))) {
      return false;
    }
    if (((other.getSimpleScalingPolicyConfiguration() == null ? 1 : 0) ^ (getSimpleScalingPolicyConfiguration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSimpleScalingPolicyConfiguration() != null) && 
      (!other.getSimpleScalingPolicyConfiguration().equals(getSimpleScalingPolicyConfiguration()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMarket() == null ? 0 : getMarket().hashCode());
    hashCode = 31 * hashCode + (getSimpleScalingPolicyConfiguration() == null ? 0 : getSimpleScalingPolicyConfiguration().hashCode());
    return hashCode;
  }
  
  public ScalingAction clone()
  {
    try
    {
      return (ScalingAction)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ScalingActionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScalingAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */