package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScalingTriggerMarshaller;
import java.io.Serializable;

public class ScalingTrigger
  implements Serializable, Cloneable, StructuredPojo
{
  private CloudWatchAlarmDefinition cloudWatchAlarmDefinition;
  
  public void setCloudWatchAlarmDefinition(CloudWatchAlarmDefinition cloudWatchAlarmDefinition)
  {
    this.cloudWatchAlarmDefinition = cloudWatchAlarmDefinition;
  }
  
  public CloudWatchAlarmDefinition getCloudWatchAlarmDefinition()
  {
    return cloudWatchAlarmDefinition;
  }
  
  public ScalingTrigger withCloudWatchAlarmDefinition(CloudWatchAlarmDefinition cloudWatchAlarmDefinition)
  {
    setCloudWatchAlarmDefinition(cloudWatchAlarmDefinition);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCloudWatchAlarmDefinition() != null) {
      sb.append("CloudWatchAlarmDefinition: ").append(getCloudWatchAlarmDefinition());
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
    if (!(obj instanceof ScalingTrigger)) {
      return false;
    }
    ScalingTrigger other = (ScalingTrigger)obj;
    if (((other.getCloudWatchAlarmDefinition() == null ? 1 : 0) ^ (getCloudWatchAlarmDefinition() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCloudWatchAlarmDefinition() != null) && (!other.getCloudWatchAlarmDefinition().equals(getCloudWatchAlarmDefinition()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCloudWatchAlarmDefinition() == null ? 0 : getCloudWatchAlarmDefinition().hashCode());
    return hashCode;
  }
  
  public ScalingTrigger clone()
  {
    try
    {
      return (ScalingTrigger)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ScalingTriggerMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScalingTrigger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */