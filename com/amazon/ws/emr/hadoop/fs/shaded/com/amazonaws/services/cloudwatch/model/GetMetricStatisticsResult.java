package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GetMetricStatisticsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String label;
  private SdkInternalList<Datapoint> datapoints;
  
  public void setLabel(String label)
  {
    this.label = label;
  }
  
  public String getLabel()
  {
    return label;
  }
  
  public GetMetricStatisticsResult withLabel(String label)
  {
    setLabel(label);
    return this;
  }
  
  public List<Datapoint> getDatapoints()
  {
    if (datapoints == null) {
      datapoints = new SdkInternalList();
    }
    return datapoints;
  }
  
  public void setDatapoints(Collection<Datapoint> datapoints)
  {
    if (datapoints == null)
    {
      this.datapoints = null;
      return;
    }
    this.datapoints = new SdkInternalList(datapoints);
  }
  
  public GetMetricStatisticsResult withDatapoints(Datapoint... datapoints)
  {
    if (this.datapoints == null) {
      setDatapoints(new SdkInternalList(datapoints.length));
    }
    for (Datapoint ele : datapoints) {
      this.datapoints.add(ele);
    }
    return this;
  }
  
  public GetMetricStatisticsResult withDatapoints(Collection<Datapoint> datapoints)
  {
    setDatapoints(datapoints);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getLabel() != null) {
      sb.append("Label: ").append(getLabel()).append(",");
    }
    if (getDatapoints() != null) {
      sb.append("Datapoints: ").append(getDatapoints());
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
    if (!(obj instanceof GetMetricStatisticsResult)) {
      return false;
    }
    GetMetricStatisticsResult other = (GetMetricStatisticsResult)obj;
    if (((other.getLabel() == null ? 1 : 0) ^ (getLabel() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLabel() != null) && (!other.getLabel().equals(getLabel()))) {
      return false;
    }
    if (((other.getDatapoints() == null ? 1 : 0) ^ (getDatapoints() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDatapoints() != null) && (!other.getDatapoints().equals(getDatapoints()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getLabel() == null ? 0 : getLabel().hashCode());
    hashCode = 31 * hashCode + (getDatapoints() == null ? 0 : getDatapoints().hashCode());
    return hashCode;
  }
  
  public GetMetricStatisticsResult clone()
  {
    try
    {
      return (GetMetricStatisticsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */