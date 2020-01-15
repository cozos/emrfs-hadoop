package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ResourceSpecificResult
  implements Serializable, Cloneable
{
  private String evalResourceName;
  private String evalResourceDecision;
  private SdkInternalList<Statement> matchedStatements;
  private SdkInternalList<String> missingContextValues;
  private SdkInternalMap<String, String> evalDecisionDetails;
  
  public void setEvalResourceName(String evalResourceName)
  {
    this.evalResourceName = evalResourceName;
  }
  
  public String getEvalResourceName()
  {
    return evalResourceName;
  }
  
  public ResourceSpecificResult withEvalResourceName(String evalResourceName)
  {
    setEvalResourceName(evalResourceName);
    return this;
  }
  
  public void setEvalResourceDecision(String evalResourceDecision)
  {
    this.evalResourceDecision = evalResourceDecision;
  }
  
  public String getEvalResourceDecision()
  {
    return evalResourceDecision;
  }
  
  public ResourceSpecificResult withEvalResourceDecision(String evalResourceDecision)
  {
    setEvalResourceDecision(evalResourceDecision);
    return this;
  }
  
  public void setEvalResourceDecision(PolicyEvaluationDecisionType evalResourceDecision)
  {
    withEvalResourceDecision(evalResourceDecision);
  }
  
  public ResourceSpecificResult withEvalResourceDecision(PolicyEvaluationDecisionType evalResourceDecision)
  {
    this.evalResourceDecision = evalResourceDecision.toString();
    return this;
  }
  
  public List<Statement> getMatchedStatements()
  {
    if (matchedStatements == null) {
      matchedStatements = new SdkInternalList();
    }
    return matchedStatements;
  }
  
  public void setMatchedStatements(Collection<Statement> matchedStatements)
  {
    if (matchedStatements == null)
    {
      this.matchedStatements = null;
      return;
    }
    this.matchedStatements = new SdkInternalList(matchedStatements);
  }
  
  public ResourceSpecificResult withMatchedStatements(Statement... matchedStatements)
  {
    if (this.matchedStatements == null) {
      setMatchedStatements(new SdkInternalList(matchedStatements.length));
    }
    for (Statement ele : matchedStatements) {
      this.matchedStatements.add(ele);
    }
    return this;
  }
  
  public ResourceSpecificResult withMatchedStatements(Collection<Statement> matchedStatements)
  {
    setMatchedStatements(matchedStatements);
    return this;
  }
  
  public List<String> getMissingContextValues()
  {
    if (missingContextValues == null) {
      missingContextValues = new SdkInternalList();
    }
    return missingContextValues;
  }
  
  public void setMissingContextValues(Collection<String> missingContextValues)
  {
    if (missingContextValues == null)
    {
      this.missingContextValues = null;
      return;
    }
    this.missingContextValues = new SdkInternalList(missingContextValues);
  }
  
  public ResourceSpecificResult withMissingContextValues(String... missingContextValues)
  {
    if (this.missingContextValues == null) {
      setMissingContextValues(new SdkInternalList(missingContextValues.length));
    }
    for (String ele : missingContextValues) {
      this.missingContextValues.add(ele);
    }
    return this;
  }
  
  public ResourceSpecificResult withMissingContextValues(Collection<String> missingContextValues)
  {
    setMissingContextValues(missingContextValues);
    return this;
  }
  
  public Map<String, String> getEvalDecisionDetails()
  {
    if (evalDecisionDetails == null) {
      evalDecisionDetails = new SdkInternalMap();
    }
    return evalDecisionDetails;
  }
  
  public void setEvalDecisionDetails(Map<String, String> evalDecisionDetails)
  {
    this.evalDecisionDetails = (evalDecisionDetails == null ? null : new SdkInternalMap(evalDecisionDetails));
  }
  
  public ResourceSpecificResult withEvalDecisionDetails(Map<String, String> evalDecisionDetails)
  {
    setEvalDecisionDetails(evalDecisionDetails);
    return this;
  }
  
  public ResourceSpecificResult addEvalDecisionDetailsEntry(String key, String value)
  {
    if (null == evalDecisionDetails) {
      evalDecisionDetails = new SdkInternalMap();
    }
    if (evalDecisionDetails.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    evalDecisionDetails.put(key, value);
    return this;
  }
  
  public ResourceSpecificResult clearEvalDecisionDetailsEntries()
  {
    evalDecisionDetails = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEvalResourceName() != null) {
      sb.append("EvalResourceName: ").append(getEvalResourceName()).append(",");
    }
    if (getEvalResourceDecision() != null) {
      sb.append("EvalResourceDecision: ").append(getEvalResourceDecision()).append(",");
    }
    if (getMatchedStatements() != null) {
      sb.append("MatchedStatements: ").append(getMatchedStatements()).append(",");
    }
    if (getMissingContextValues() != null) {
      sb.append("MissingContextValues: ").append(getMissingContextValues()).append(",");
    }
    if (getEvalDecisionDetails() != null) {
      sb.append("EvalDecisionDetails: ").append(getEvalDecisionDetails());
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
    if (!(obj instanceof ResourceSpecificResult)) {
      return false;
    }
    ResourceSpecificResult other = (ResourceSpecificResult)obj;
    if (((other.getEvalResourceName() == null ? 1 : 0) ^ (getEvalResourceName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEvalResourceName() != null) && (!other.getEvalResourceName().equals(getEvalResourceName()))) {
      return false;
    }
    if (((other.getEvalResourceDecision() == null ? 1 : 0) ^ (getEvalResourceDecision() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEvalResourceDecision() != null) && (!other.getEvalResourceDecision().equals(getEvalResourceDecision()))) {
      return false;
    }
    if (((other.getMatchedStatements() == null ? 1 : 0) ^ (getMatchedStatements() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMatchedStatements() != null) && (!other.getMatchedStatements().equals(getMatchedStatements()))) {
      return false;
    }
    if (((other.getMissingContextValues() == null ? 1 : 0) ^ (getMissingContextValues() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMissingContextValues() != null) && (!other.getMissingContextValues().equals(getMissingContextValues()))) {
      return false;
    }
    if (((other.getEvalDecisionDetails() == null ? 1 : 0) ^ (getEvalDecisionDetails() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEvalDecisionDetails() != null) && (!other.getEvalDecisionDetails().equals(getEvalDecisionDetails()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEvalResourceName() == null ? 0 : getEvalResourceName().hashCode());
    hashCode = 31 * hashCode + (getEvalResourceDecision() == null ? 0 : getEvalResourceDecision().hashCode());
    hashCode = 31 * hashCode + (getMatchedStatements() == null ? 0 : getMatchedStatements().hashCode());
    hashCode = 31 * hashCode + (getMissingContextValues() == null ? 0 : getMissingContextValues().hashCode());
    hashCode = 31 * hashCode + (getEvalDecisionDetails() == null ? 0 : getEvalDecisionDetails().hashCode());
    return hashCode;
  }
  
  public ResourceSpecificResult clone()
  {
    try
    {
      return (ResourceSpecificResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResourceSpecificResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */