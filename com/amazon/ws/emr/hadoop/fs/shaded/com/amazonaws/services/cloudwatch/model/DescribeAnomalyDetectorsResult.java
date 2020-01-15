package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DescribeAnomalyDetectorsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<AnomalyDetector> anomalyDetectors;
  private String nextToken;
  
  public List<AnomalyDetector> getAnomalyDetectors()
  {
    if (anomalyDetectors == null) {
      anomalyDetectors = new SdkInternalList();
    }
    return anomalyDetectors;
  }
  
  public void setAnomalyDetectors(Collection<AnomalyDetector> anomalyDetectors)
  {
    if (anomalyDetectors == null)
    {
      this.anomalyDetectors = null;
      return;
    }
    this.anomalyDetectors = new SdkInternalList(anomalyDetectors);
  }
  
  public DescribeAnomalyDetectorsResult withAnomalyDetectors(AnomalyDetector... anomalyDetectors)
  {
    if (this.anomalyDetectors == null) {
      setAnomalyDetectors(new SdkInternalList(anomalyDetectors.length));
    }
    for (AnomalyDetector ele : anomalyDetectors) {
      this.anomalyDetectors.add(ele);
    }
    return this;
  }
  
  public DescribeAnomalyDetectorsResult withAnomalyDetectors(Collection<AnomalyDetector> anomalyDetectors)
  {
    setAnomalyDetectors(anomalyDetectors);
    return this;
  }
  
  public void setNextToken(String nextToken)
  {
    this.nextToken = nextToken;
  }
  
  public String getNextToken()
  {
    return nextToken;
  }
  
  public DescribeAnomalyDetectorsResult withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAnomalyDetectors() != null) {
      sb.append("AnomalyDetectors: ").append(getAnomalyDetectors()).append(",");
    }
    if (getNextToken() != null) {
      sb.append("NextToken: ").append(getNextToken());
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
    if (!(obj instanceof DescribeAnomalyDetectorsResult)) {
      return false;
    }
    DescribeAnomalyDetectorsResult other = (DescribeAnomalyDetectorsResult)obj;
    if (((other.getAnomalyDetectors() == null ? 1 : 0) ^ (getAnomalyDetectors() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAnomalyDetectors() != null) && (!other.getAnomalyDetectors().equals(getAnomalyDetectors()))) {
      return false;
    }
    if (((other.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNextToken() != null) && (!other.getNextToken().equals(getNextToken()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAnomalyDetectors() == null ? 0 : getAnomalyDetectors().hashCode());
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    return hashCode;
  }
  
  public DescribeAnomalyDetectorsResult clone()
  {
    try
    {
      return (DescribeAnomalyDetectorsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAnomalyDetectorsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */