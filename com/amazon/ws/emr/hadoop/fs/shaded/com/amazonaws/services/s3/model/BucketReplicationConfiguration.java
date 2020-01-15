package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BucketReplicationConfiguration
  implements Serializable
{
  private String roleARN;
  private Map<String, ReplicationRule> rules = new HashMap();
  
  public String getRoleARN()
  {
    return roleARN;
  }
  
  public void setRoleARN(String roleARN)
  {
    this.roleARN = roleARN;
  }
  
  public BucketReplicationConfiguration withRoleARN(String roleARN)
  {
    setRoleARN(roleARN);
    return this;
  }
  
  public Map<String, ReplicationRule> getRules()
  {
    return rules;
  }
  
  public ReplicationRule getRule(String id)
  {
    return (ReplicationRule)rules.get(id);
  }
  
  public void setRules(Map<String, ReplicationRule> rules)
  {
    if (rules == null) {
      throw new IllegalArgumentException("Replication rules cannot be null");
    }
    this.rules = new HashMap(rules);
  }
  
  public BucketReplicationConfiguration withRules(Map<String, ReplicationRule> rules)
  {
    setRules(rules);
    return this;
  }
  
  public BucketReplicationConfiguration addRule(String id, ReplicationRule rule)
  {
    if ((id == null) || (id.trim().isEmpty())) {
      throw new IllegalArgumentException("Rule id cannot be null or empty.");
    }
    if (rule == null) {
      throw new IllegalArgumentException("Replication rule cannot be null");
    }
    rules.put(id, rule);
    return this;
  }
  
  public BucketReplicationConfiguration removeRule(String id)
  {
    rules.remove(id);
    return this;
  }
  
  public String toString()
  {
    return Jackson.toJsonString(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketReplicationConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */