package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PrimaryKey
{
  private final Map<String, KeyAttribute> components = new LinkedHashMap();
  
  public PrimaryKey() {}
  
  public PrimaryKey(KeyAttribute... components)
  {
    addComponents(components);
  }
  
  public PrimaryKey(String hashKeyName, Object hashKeyValue)
  {
    addComponent(hashKeyName, hashKeyValue);
  }
  
  public PrimaryKey(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    if (hashKeyName.equals(rangeKeyName)) {
      throw new IllegalArgumentException("hashKyeName must not be the same as the rangeKeyName");
    }
    addComponent(hashKeyName, hashKeyValue);
    addComponent(rangeKeyName, rangeKeyValue);
  }
  
  public Collection<KeyAttribute> getComponents()
  {
    return components.values();
  }
  
  public Set<String> getComponentNameSet()
  {
    return components.keySet();
  }
  
  public boolean hasComponent(String attrName)
  {
    return components.containsKey(attrName);
  }
  
  public PrimaryKey addComponents(KeyAttribute... components)
  {
    if (components != null) {
      for (KeyAttribute ka : components)
      {
        InternalUtils.rejectNullInput(ka);
        this.components.put(ka.getName(), ka);
      }
    }
    return this;
  }
  
  public PrimaryKey addComponent(String keyAttributeName, Object keyAttributeValue)
  {
    components.put(keyAttributeName, new KeyAttribute(keyAttributeName, keyAttributeValue));
    
    return this;
  }
  
  public String toString()
  {
    return String.valueOf(components);
  }
  
  public int hashCode()
  {
    return components.hashCode();
  }
  
  public boolean equals(Object in)
  {
    if ((in instanceof PrimaryKey))
    {
      PrimaryKey that = (PrimaryKey)in;
      return components.equals(components);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */