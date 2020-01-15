package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy;

import java.util.Arrays;
import java.util.List;

public class Condition
{
  protected String type;
  protected String conditionKey;
  protected List<String> values;
  
  public String getType()
  {
    return type;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public String getConditionKey()
  {
    return conditionKey;
  }
  
  public void setConditionKey(String conditionKey)
  {
    this.conditionKey = conditionKey;
  }
  
  public List<String> getValues()
  {
    return values;
  }
  
  public void setValues(List<String> values)
  {
    this.values = values;
  }
  
  public Condition withType(String type)
  {
    setType(type);
    return this;
  }
  
  public Condition withConditionKey(String key)
  {
    setConditionKey(key);
    return this;
  }
  
  public Condition withValues(String... values)
  {
    setValues(Arrays.asList(values));
    return this;
  }
  
  public Condition withValues(List<String> values)
  {
    setValues(values);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Condition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */