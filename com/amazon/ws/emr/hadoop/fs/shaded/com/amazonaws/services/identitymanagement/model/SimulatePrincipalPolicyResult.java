package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class SimulatePrincipalPolicyResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<EvaluationResult> evaluationResults;
  private Boolean isTruncated;
  private String marker;
  
  public List<EvaluationResult> getEvaluationResults()
  {
    if (evaluationResults == null) {
      evaluationResults = new SdkInternalList();
    }
    return evaluationResults;
  }
  
  public void setEvaluationResults(Collection<EvaluationResult> evaluationResults)
  {
    if (evaluationResults == null)
    {
      this.evaluationResults = null;
      return;
    }
    this.evaluationResults = new SdkInternalList(evaluationResults);
  }
  
  public SimulatePrincipalPolicyResult withEvaluationResults(EvaluationResult... evaluationResults)
  {
    if (this.evaluationResults == null) {
      setEvaluationResults(new SdkInternalList(evaluationResults.length));
    }
    for (EvaluationResult ele : evaluationResults) {
      this.evaluationResults.add(ele);
    }
    return this;
  }
  
  public SimulatePrincipalPolicyResult withEvaluationResults(Collection<EvaluationResult> evaluationResults)
  {
    setEvaluationResults(evaluationResults);
    return this;
  }
  
  public void setIsTruncated(Boolean isTruncated)
  {
    this.isTruncated = isTruncated;
  }
  
  public Boolean getIsTruncated()
  {
    return isTruncated;
  }
  
  public SimulatePrincipalPolicyResult withIsTruncated(Boolean isTruncated)
  {
    setIsTruncated(isTruncated);
    return this;
  }
  
  public Boolean isTruncated()
  {
    return isTruncated;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public SimulatePrincipalPolicyResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEvaluationResults() != null) {
      sb.append("EvaluationResults: ").append(getEvaluationResults()).append(",");
    }
    if (getIsTruncated() != null) {
      sb.append("IsTruncated: ").append(getIsTruncated()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker());
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
    if (!(obj instanceof SimulatePrincipalPolicyResult)) {
      return false;
    }
    SimulatePrincipalPolicyResult other = (SimulatePrincipalPolicyResult)obj;
    if (((other.getEvaluationResults() == null ? 1 : 0) ^ (getEvaluationResults() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEvaluationResults() != null) && (!other.getEvaluationResults().equals(getEvaluationResults()))) {
      return false;
    }
    if (((other.getIsTruncated() == null ? 1 : 0) ^ (getIsTruncated() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIsTruncated() != null) && (!other.getIsTruncated().equals(getIsTruncated()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEvaluationResults() == null ? 0 : getEvaluationResults().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public SimulatePrincipalPolicyResult clone()
  {
    try
    {
      return (SimulatePrincipalPolicyResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SimulatePrincipalPolicyResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */