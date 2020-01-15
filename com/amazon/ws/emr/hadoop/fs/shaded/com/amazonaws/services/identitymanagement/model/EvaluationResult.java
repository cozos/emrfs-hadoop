package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class EvaluationResult
  implements Serializable, Cloneable
{
  private String evalActionName;
  private String evalResourceName;
  private String evalDecision;
  private SdkInternalList<Statement> matchedStatements;
  private SdkInternalList<String> missingContextValues;
  private OrganizationsDecisionDetail organizationsDecisionDetail;
  private SdkInternalMap<String, String> evalDecisionDetails;
  private SdkInternalList<ResourceSpecificResult> resourceSpecificResults;
  
  public void setEvalActionName(String evalActionName)
  {
    this.evalActionName = evalActionName;
  }
  
  public String getEvalActionName()
  {
    return evalActionName;
  }
  
  public EvaluationResult withEvalActionName(String evalActionName)
  {
    setEvalActionName(evalActionName);
    return this;
  }
  
  public void setEvalResourceName(String evalResourceName)
  {
    this.evalResourceName = evalResourceName;
  }
  
  public String getEvalResourceName()
  {
    return evalResourceName;
  }
  
  public EvaluationResult withEvalResourceName(String evalResourceName)
  {
    setEvalResourceName(evalResourceName);
    return this;
  }
  
  public void setEvalDecision(String evalDecision)
  {
    this.evalDecision = evalDecision;
  }
  
  public String getEvalDecision()
  {
    return evalDecision;
  }
  
  public EvaluationResult withEvalDecision(String evalDecision)
  {
    setEvalDecision(evalDecision);
    return this;
  }
  
  public void setEvalDecision(PolicyEvaluationDecisionType evalDecision)
  {
    withEvalDecision(evalDecision);
  }
  
  public EvaluationResult withEvalDecision(PolicyEvaluationDecisionType evalDecision)
  {
    this.evalDecision = evalDecision.toString();
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
  
  public EvaluationResult withMatchedStatements(Statement... matchedStatements)
  {
    if (this.matchedStatements == null) {
      setMatchedStatements(new SdkInternalList(matchedStatements.length));
    }
    for (Statement ele : matchedStatements) {
      this.matchedStatements.add(ele);
    }
    return this;
  }
  
  public EvaluationResult withMatchedStatements(Collection<Statement> matchedStatements)
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
  
  public EvaluationResult withMissingContextValues(String... missingContextValues)
  {
    if (this.missingContextValues == null) {
      setMissingContextValues(new SdkInternalList(missingContextValues.length));
    }
    for (String ele : missingContextValues) {
      this.missingContextValues.add(ele);
    }
    return this;
  }
  
  public EvaluationResult withMissingContextValues(Collection<String> missingContextValues)
  {
    setMissingContextValues(missingContextValues);
    return this;
  }
  
  public void setOrganizationsDecisionDetail(OrganizationsDecisionDetail organizationsDecisionDetail)
  {
    this.organizationsDecisionDetail = organizationsDecisionDetail;
  }
  
  public OrganizationsDecisionDetail getOrganizationsDecisionDetail()
  {
    return organizationsDecisionDetail;
  }
  
  public EvaluationResult withOrganizationsDecisionDetail(OrganizationsDecisionDetail organizationsDecisionDetail)
  {
    setOrganizationsDecisionDetail(organizationsDecisionDetail);
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
  
  public EvaluationResult withEvalDecisionDetails(Map<String, String> evalDecisionDetails)
  {
    setEvalDecisionDetails(evalDecisionDetails);
    return this;
  }
  
  public EvaluationResult addEvalDecisionDetailsEntry(String key, String value)
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
  
  public EvaluationResult clearEvalDecisionDetailsEntries()
  {
    evalDecisionDetails = null;
    return this;
  }
  
  public List<ResourceSpecificResult> getResourceSpecificResults()
  {
    if (resourceSpecificResults == null) {
      resourceSpecificResults = new SdkInternalList();
    }
    return resourceSpecificResults;
  }
  
  public void setResourceSpecificResults(Collection<ResourceSpecificResult> resourceSpecificResults)
  {
    if (resourceSpecificResults == null)
    {
      this.resourceSpecificResults = null;
      return;
    }
    this.resourceSpecificResults = new SdkInternalList(resourceSpecificResults);
  }
  
  public EvaluationResult withResourceSpecificResults(ResourceSpecificResult... resourceSpecificResults)
  {
    if (this.resourceSpecificResults == null) {
      setResourceSpecificResults(new SdkInternalList(resourceSpecificResults.length));
    }
    for (ResourceSpecificResult ele : resourceSpecificResults) {
      this.resourceSpecificResults.add(ele);
    }
    return this;
  }
  
  public EvaluationResult withResourceSpecificResults(Collection<ResourceSpecificResult> resourceSpecificResults)
  {
    setResourceSpecificResults(resourceSpecificResults);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEvalActionName() != null) {
      sb.append("EvalActionName: ").append(getEvalActionName()).append(",");
    }
    if (getEvalResourceName() != null) {
      sb.append("EvalResourceName: ").append(getEvalResourceName()).append(",");
    }
    if (getEvalDecision() != null) {
      sb.append("EvalDecision: ").append(getEvalDecision()).append(",");
    }
    if (getMatchedStatements() != null) {
      sb.append("MatchedStatements: ").append(getMatchedStatements()).append(",");
    }
    if (getMissingContextValues() != null) {
      sb.append("MissingContextValues: ").append(getMissingContextValues()).append(",");
    }
    if (getOrganizationsDecisionDetail() != null) {
      sb.append("OrganizationsDecisionDetail: ").append(getOrganizationsDecisionDetail()).append(",");
    }
    if (getEvalDecisionDetails() != null) {
      sb.append("EvalDecisionDetails: ").append(getEvalDecisionDetails()).append(",");
    }
    if (getResourceSpecificResults() != null) {
      sb.append("ResourceSpecificResults: ").append(getResourceSpecificResults());
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
    if (!(obj instanceof EvaluationResult)) {
      return false;
    }
    EvaluationResult other = (EvaluationResult)obj;
    if (((other.getEvalActionName() == null ? 1 : 0) ^ (getEvalActionName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEvalActionName() != null) && (!other.getEvalActionName().equals(getEvalActionName()))) {
      return false;
    }
    if (((other.getEvalResourceName() == null ? 1 : 0) ^ (getEvalResourceName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEvalResourceName() != null) && (!other.getEvalResourceName().equals(getEvalResourceName()))) {
      return false;
    }
    if (((other.getEvalDecision() == null ? 1 : 0) ^ (getEvalDecision() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEvalDecision() != null) && (!other.getEvalDecision().equals(getEvalDecision()))) {
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
    if (((other.getOrganizationsDecisionDetail() == null ? 1 : 0) ^ (getOrganizationsDecisionDetail() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOrganizationsDecisionDetail() != null) && (!other.getOrganizationsDecisionDetail().equals(getOrganizationsDecisionDetail()))) {
      return false;
    }
    if (((other.getEvalDecisionDetails() == null ? 1 : 0) ^ (getEvalDecisionDetails() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEvalDecisionDetails() != null) && (!other.getEvalDecisionDetails().equals(getEvalDecisionDetails()))) {
      return false;
    }
    if (((other.getResourceSpecificResults() == null ? 1 : 0) ^ (getResourceSpecificResults() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceSpecificResults() != null) && (!other.getResourceSpecificResults().equals(getResourceSpecificResults()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEvalActionName() == null ? 0 : getEvalActionName().hashCode());
    hashCode = 31 * hashCode + (getEvalResourceName() == null ? 0 : getEvalResourceName().hashCode());
    hashCode = 31 * hashCode + (getEvalDecision() == null ? 0 : getEvalDecision().hashCode());
    hashCode = 31 * hashCode + (getMatchedStatements() == null ? 0 : getMatchedStatements().hashCode());
    hashCode = 31 * hashCode + (getMissingContextValues() == null ? 0 : getMissingContextValues().hashCode());
    hashCode = 31 * hashCode + (getOrganizationsDecisionDetail() == null ? 0 : getOrganizationsDecisionDetail().hashCode());
    hashCode = 31 * hashCode + (getEvalDecisionDetails() == null ? 0 : getEvalDecisionDetails().hashCode());
    hashCode = 31 * hashCode + (getResourceSpecificResults() == null ? 0 : getResourceSpecificResults().hashCode());
    return hashCode;
  }
  
  public EvaluationResult clone()
  {
    try
    {
      return (EvaluationResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EvaluationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */