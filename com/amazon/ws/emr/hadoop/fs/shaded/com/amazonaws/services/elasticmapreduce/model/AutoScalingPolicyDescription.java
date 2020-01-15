package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AutoScalingPolicyDescriptionMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class AutoScalingPolicyDescription
  implements Serializable, Cloneable, StructuredPojo
{
  private AutoScalingPolicyStatus status;
  private ScalingConstraints constraints;
  private SdkInternalList<ScalingRule> rules;
  
  public void setStatus(AutoScalingPolicyStatus status)
  {
    this.status = status;
  }
  
  public AutoScalingPolicyStatus getStatus()
  {
    return status;
  }
  
  public AutoScalingPolicyDescription withStatus(AutoScalingPolicyStatus status)
  {
    setStatus(status);
    return this;
  }
  
  public void setConstraints(ScalingConstraints constraints)
  {
    this.constraints = constraints;
  }
  
  public ScalingConstraints getConstraints()
  {
    return constraints;
  }
  
  public AutoScalingPolicyDescription withConstraints(ScalingConstraints constraints)
  {
    setConstraints(constraints);
    return this;
  }
  
  public List<ScalingRule> getRules()
  {
    if (rules == null) {
      rules = new SdkInternalList();
    }
    return rules;
  }
  
  public void setRules(Collection<ScalingRule> rules)
  {
    if (rules == null)
    {
      this.rules = null;
      return;
    }
    this.rules = new SdkInternalList(rules);
  }
  
  public AutoScalingPolicyDescription withRules(ScalingRule... rules)
  {
    if (this.rules == null) {
      setRules(new SdkInternalList(rules.length));
    }
    for (ScalingRule ele : rules) {
      this.rules.add(ele);
    }
    return this;
  }
  
  public AutoScalingPolicyDescription withRules(Collection<ScalingRule> rules)
  {
    setRules(rules);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus()).append(",");
    }
    if (getConstraints() != null) {
      sb.append("Constraints: ").append(getConstraints()).append(",");
    }
    if (getRules() != null) {
      sb.append("Rules: ").append(getRules());
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
    if (!(obj instanceof AutoScalingPolicyDescription)) {
      return false;
    }
    AutoScalingPolicyDescription other = (AutoScalingPolicyDescription)obj;
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    if (((other.getConstraints() == null ? 1 : 0) ^ (getConstraints() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConstraints() != null) && (!other.getConstraints().equals(getConstraints()))) {
      return false;
    }
    if (((other.getRules() == null ? 1 : 0) ^ (getRules() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRules() != null) && (!other.getRules().equals(getRules()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getConstraints() == null ? 0 : getConstraints().hashCode());
    hashCode = 31 * hashCode + (getRules() == null ? 0 : getRules().hashCode());
    return hashCode;
  }
  
  public AutoScalingPolicyDescription clone()
  {
    try
    {
      return (AutoScalingPolicyDescription)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    AutoScalingPolicyDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AutoScalingPolicyDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */