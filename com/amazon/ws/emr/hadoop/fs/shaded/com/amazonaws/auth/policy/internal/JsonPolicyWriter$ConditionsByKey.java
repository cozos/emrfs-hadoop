package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class JsonPolicyWriter$ConditionsByKey
{
  private Map<String, List<String>> conditionsByKey;
  
  public JsonPolicyWriter$ConditionsByKey()
  {
    conditionsByKey = new LinkedHashMap();
  }
  
  public Map<String, List<String>> getConditionsByKey()
  {
    return conditionsByKey;
  }
  
  public void setConditionsByKey(Map<String, List<String>> conditionsByKey)
  {
    this.conditionsByKey = conditionsByKey;
  }
  
  public boolean containsKey(String key)
  {
    return conditionsByKey.containsKey(key);
  }
  
  public List<String> getConditionsByKey(String key)
  {
    return (List)conditionsByKey.get(key);
  }
  
  public Set<String> keySet()
  {
    return conditionsByKey.keySet();
  }
  
  public void addValuesToKey(String key, List<String> values)
  {
    List<String> conditionValues = getConditionsByKey(key);
    if (conditionValues == null) {
      conditionsByKey.put(key, new ArrayList(values));
    } else {
      conditionValues.addAll(values);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.internal.JsonPolicyWriter.ConditionsByKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */