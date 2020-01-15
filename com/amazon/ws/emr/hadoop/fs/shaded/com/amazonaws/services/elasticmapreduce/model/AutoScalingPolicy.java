package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AutoScalingPolicyMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class AutoScalingPolicy
  implements Serializable, Cloneable, StructuredPojo
{
  private ScalingConstraints constraints;
  private SdkInternalList<ScalingRule> rules;
  
  public void setConstraints(ScalingConstraints constraints)
  {
    this.constraints = constraints;
  }
  
  public ScalingConstraints getConstraints()
  {
    return constraints;
  }
  
  public AutoScalingPolicy withConstraints(ScalingConstraints constraints)
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
  
  public AutoScalingPolicy withRules(ScalingRule... rules)
  {
    if (this.rules == null) {
      setRules(new SdkInternalList(rules.length));
    }
    for (ScalingRule ele : rules) {
      this.rules.add(ele);
    }
    return this;
  }
  
  public AutoScalingPolicy withRules(Collection<ScalingRule> rules)
  {
    setRules(rules);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(obj instanceof AutoScalingPolicy)) {
      return false;
    }
    AutoScalingPolicy other = (AutoScalingPolicy)obj;
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
    
    hashCode = 31 * hashCode + (getConstraints() == null ? 0 : getConstraints().hashCode());
    hashCode = 31 * hashCode + (getRules() == null ? 0 : getRules().hashCode());
    return hashCode;
  }
  
  public AutoScalingPolicy clone()
  {
    try
    {
      return (AutoScalingPolicy)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    AutoScalingPolicyMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AutoScalingPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */