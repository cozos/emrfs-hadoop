package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SourceTableFeatureDetailsMarshaller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SourceTableFeatureDetails
  implements Serializable, Cloneable, StructuredPojo
{
  private List<LocalSecondaryIndexInfo> localSecondaryIndexes;
  private List<GlobalSecondaryIndexInfo> globalSecondaryIndexes;
  private StreamSpecification streamDescription;
  private TimeToLiveDescription timeToLiveDescription;
  private SSEDescription sSEDescription;
  
  public List<LocalSecondaryIndexInfo> getLocalSecondaryIndexes()
  {
    return localSecondaryIndexes;
  }
  
  public void setLocalSecondaryIndexes(Collection<LocalSecondaryIndexInfo> localSecondaryIndexes)
  {
    if (localSecondaryIndexes == null)
    {
      this.localSecondaryIndexes = null;
      return;
    }
    this.localSecondaryIndexes = new ArrayList(localSecondaryIndexes);
  }
  
  public SourceTableFeatureDetails withLocalSecondaryIndexes(LocalSecondaryIndexInfo... localSecondaryIndexes)
  {
    if (this.localSecondaryIndexes == null) {
      setLocalSecondaryIndexes(new ArrayList(localSecondaryIndexes.length));
    }
    for (LocalSecondaryIndexInfo ele : localSecondaryIndexes) {
      this.localSecondaryIndexes.add(ele);
    }
    return this;
  }
  
  public SourceTableFeatureDetails withLocalSecondaryIndexes(Collection<LocalSecondaryIndexInfo> localSecondaryIndexes)
  {
    setLocalSecondaryIndexes(localSecondaryIndexes);
    return this;
  }
  
  public List<GlobalSecondaryIndexInfo> getGlobalSecondaryIndexes()
  {
    return globalSecondaryIndexes;
  }
  
  public void setGlobalSecondaryIndexes(Collection<GlobalSecondaryIndexInfo> globalSecondaryIndexes)
  {
    if (globalSecondaryIndexes == null)
    {
      this.globalSecondaryIndexes = null;
      return;
    }
    this.globalSecondaryIndexes = new ArrayList(globalSecondaryIndexes);
  }
  
  public SourceTableFeatureDetails withGlobalSecondaryIndexes(GlobalSecondaryIndexInfo... globalSecondaryIndexes)
  {
    if (this.globalSecondaryIndexes == null) {
      setGlobalSecondaryIndexes(new ArrayList(globalSecondaryIndexes.length));
    }
    for (GlobalSecondaryIndexInfo ele : globalSecondaryIndexes) {
      this.globalSecondaryIndexes.add(ele);
    }
    return this;
  }
  
  public SourceTableFeatureDetails withGlobalSecondaryIndexes(Collection<GlobalSecondaryIndexInfo> globalSecondaryIndexes)
  {
    setGlobalSecondaryIndexes(globalSecondaryIndexes);
    return this;
  }
  
  public void setStreamDescription(StreamSpecification streamDescription)
  {
    this.streamDescription = streamDescription;
  }
  
  public StreamSpecification getStreamDescription()
  {
    return streamDescription;
  }
  
  public SourceTableFeatureDetails withStreamDescription(StreamSpecification streamDescription)
  {
    setStreamDescription(streamDescription);
    return this;
  }
  
  public void setTimeToLiveDescription(TimeToLiveDescription timeToLiveDescription)
  {
    this.timeToLiveDescription = timeToLiveDescription;
  }
  
  public TimeToLiveDescription getTimeToLiveDescription()
  {
    return timeToLiveDescription;
  }
  
  public SourceTableFeatureDetails withTimeToLiveDescription(TimeToLiveDescription timeToLiveDescription)
  {
    setTimeToLiveDescription(timeToLiveDescription);
    return this;
  }
  
  public void setSSEDescription(SSEDescription sSEDescription)
  {
    this.sSEDescription = sSEDescription;
  }
  
  public SSEDescription getSSEDescription()
  {
    return sSEDescription;
  }
  
  public SourceTableFeatureDetails withSSEDescription(SSEDescription sSEDescription)
  {
    setSSEDescription(sSEDescription);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getLocalSecondaryIndexes() != null) {
      sb.append("LocalSecondaryIndexes: ").append(getLocalSecondaryIndexes()).append(",");
    }
    if (getGlobalSecondaryIndexes() != null) {
      sb.append("GlobalSecondaryIndexes: ").append(getGlobalSecondaryIndexes()).append(",");
    }
    if (getStreamDescription() != null) {
      sb.append("StreamDescription: ").append(getStreamDescription()).append(",");
    }
    if (getTimeToLiveDescription() != null) {
      sb.append("TimeToLiveDescription: ").append(getTimeToLiveDescription()).append(",");
    }
    if (getSSEDescription() != null) {
      sb.append("SSEDescription: ").append(getSSEDescription());
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
    if (!(obj instanceof SourceTableFeatureDetails)) {
      return false;
    }
    SourceTableFeatureDetails other = (SourceTableFeatureDetails)obj;
    if (((other.getLocalSecondaryIndexes() == null ? 1 : 0) ^ (getLocalSecondaryIndexes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLocalSecondaryIndexes() != null) && (!other.getLocalSecondaryIndexes().equals(getLocalSecondaryIndexes()))) {
      return false;
    }
    if (((other.getGlobalSecondaryIndexes() == null ? 1 : 0) ^ (getGlobalSecondaryIndexes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalSecondaryIndexes() != null) && (!other.getGlobalSecondaryIndexes().equals(getGlobalSecondaryIndexes()))) {
      return false;
    }
    if (((other.getStreamDescription() == null ? 1 : 0) ^ (getStreamDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamDescription() != null) && (!other.getStreamDescription().equals(getStreamDescription()))) {
      return false;
    }
    if (((other.getTimeToLiveDescription() == null ? 1 : 0) ^ (getTimeToLiveDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimeToLiveDescription() != null) && (!other.getTimeToLiveDescription().equals(getTimeToLiveDescription()))) {
      return false;
    }
    if (((other.getSSEDescription() == null ? 1 : 0) ^ (getSSEDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSEDescription() != null) && (!other.getSSEDescription().equals(getSSEDescription()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getLocalSecondaryIndexes() == null ? 0 : getLocalSecondaryIndexes().hashCode());
    hashCode = 31 * hashCode + (getGlobalSecondaryIndexes() == null ? 0 : getGlobalSecondaryIndexes().hashCode());
    hashCode = 31 * hashCode + (getStreamDescription() == null ? 0 : getStreamDescription().hashCode());
    hashCode = 31 * hashCode + (getTimeToLiveDescription() == null ? 0 : getTimeToLiveDescription().hashCode());
    hashCode = 31 * hashCode + (getSSEDescription() == null ? 0 : getSSEDescription().hashCode());
    return hashCode;
  }
  
  public SourceTableFeatureDetails clone()
  {
    try
    {
      return (SourceTableFeatureDetails)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    SourceTableFeatureDetailsMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SourceTableFeatureDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */