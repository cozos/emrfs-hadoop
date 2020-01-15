package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class PutMetricDataRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String namespace;
  private SdkInternalList<MetricDatum> metricData;
  
  public void setNamespace(String namespace)
  {
    this.namespace = namespace;
  }
  
  public String getNamespace()
  {
    return namespace;
  }
  
  public PutMetricDataRequest withNamespace(String namespace)
  {
    setNamespace(namespace);
    return this;
  }
  
  public List<MetricDatum> getMetricData()
  {
    if (metricData == null) {
      metricData = new SdkInternalList();
    }
    return metricData;
  }
  
  public void setMetricData(Collection<MetricDatum> metricData)
  {
    if (metricData == null)
    {
      this.metricData = null;
      return;
    }
    this.metricData = new SdkInternalList(metricData);
  }
  
  public PutMetricDataRequest withMetricData(MetricDatum... metricData)
  {
    if (this.metricData == null) {
      setMetricData(new SdkInternalList(metricData.length));
    }
    for (MetricDatum ele : metricData) {
      this.metricData.add(ele);
    }
    return this;
  }
  
  public PutMetricDataRequest withMetricData(Collection<MetricDatum> metricData)
  {
    setMetricData(metricData);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getNamespace() != null) {
      sb.append("Namespace: ").append(getNamespace()).append(",");
    }
    if (getMetricData() != null) {
      sb.append("MetricData: ").append(getMetricData());
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
    if (!(obj instanceof PutMetricDataRequest)) {
      return false;
    }
    PutMetricDataRequest other = (PutMetricDataRequest)obj;
    if (((other.getNamespace() == null ? 1 : 0) ^ (getNamespace() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNamespace() != null) && (!other.getNamespace().equals(getNamespace()))) {
      return false;
    }
    if (((other.getMetricData() == null ? 1 : 0) ^ (getMetricData() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetricData() != null) && (!other.getMetricData().equals(getMetricData()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getNamespace() == null ? 0 : getNamespace().hashCode());
    hashCode = 31 * hashCode + (getMetricData() == null ? 0 : getMetricData().hashCode());
    return hashCode;
  }
  
  public PutMetricDataRequest clone()
  {
    return (PutMetricDataRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricDataRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */