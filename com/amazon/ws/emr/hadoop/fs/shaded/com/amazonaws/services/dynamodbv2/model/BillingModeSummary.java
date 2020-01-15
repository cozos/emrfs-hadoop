package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BillingModeSummaryMarshaller;
import java.io.Serializable;
import java.util.Date;

public class BillingModeSummary
  implements Serializable, Cloneable, StructuredPojo
{
  private String billingMode;
  private Date lastUpdateToPayPerRequestDateTime;
  
  public void setBillingMode(String billingMode)
  {
    this.billingMode = billingMode;
  }
  
  public String getBillingMode()
  {
    return billingMode;
  }
  
  public BillingModeSummary withBillingMode(String billingMode)
  {
    setBillingMode(billingMode);
    return this;
  }
  
  public BillingModeSummary withBillingMode(BillingMode billingMode)
  {
    this.billingMode = billingMode.toString();
    return this;
  }
  
  public void setLastUpdateToPayPerRequestDateTime(Date lastUpdateToPayPerRequestDateTime)
  {
    this.lastUpdateToPayPerRequestDateTime = lastUpdateToPayPerRequestDateTime;
  }
  
  public Date getLastUpdateToPayPerRequestDateTime()
  {
    return lastUpdateToPayPerRequestDateTime;
  }
  
  public BillingModeSummary withLastUpdateToPayPerRequestDateTime(Date lastUpdateToPayPerRequestDateTime)
  {
    setLastUpdateToPayPerRequestDateTime(lastUpdateToPayPerRequestDateTime);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBillingMode() != null) {
      sb.append("BillingMode: ").append(getBillingMode()).append(",");
    }
    if (getLastUpdateToPayPerRequestDateTime() != null) {
      sb.append("LastUpdateToPayPerRequestDateTime: ").append(getLastUpdateToPayPerRequestDateTime());
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
    if (!(obj instanceof BillingModeSummary)) {
      return false;
    }
    BillingModeSummary other = (BillingModeSummary)obj;
    if (((other.getBillingMode() == null ? 1 : 0) ^ (getBillingMode() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBillingMode() != null) && (!other.getBillingMode().equals(getBillingMode()))) {
      return false;
    }
    if (((other.getLastUpdateToPayPerRequestDateTime() == null ? 1 : 0) ^ (getLastUpdateToPayPerRequestDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastUpdateToPayPerRequestDateTime() != null) && 
      (!other.getLastUpdateToPayPerRequestDateTime().equals(getLastUpdateToPayPerRequestDateTime()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBillingMode() == null ? 0 : getBillingMode().hashCode());
    hashCode = 31 * hashCode + (getLastUpdateToPayPerRequestDateTime() == null ? 0 : getLastUpdateToPayPerRequestDateTime().hashCode());
    return hashCode;
  }
  
  public BillingModeSummary clone()
  {
    try
    {
      return (BillingModeSummary)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    BillingModeSummaryMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BillingModeSummary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */