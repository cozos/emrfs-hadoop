package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

final class SubstitutionContext
{
  private final Map<String, Integer> nameToToken = new LinkedHashMap();
  private final Map<Object, Integer> valueToToken = new LinkedHashMap();
  
  String nameTokenFor(String name)
  {
    Integer token = (Integer)nameToToken.get(name);
    if (token == null)
    {
      token = Integer.valueOf(nameToToken.size());
      nameToToken.put(name, token);
    }
    return "#" + token;
  }
  
  String valueTokenFor(Object value)
  {
    Integer token = (Integer)valueToToken.get(value);
    if (token == null)
    {
      token = Integer.valueOf(valueToToken.size());
      valueToToken.put(value, token);
    }
    return ":" + token;
  }
  
  Map<String, String> getNameMap()
  {
    if (nameToToken.size() == 0) {
      return null;
    }
    Map<String, String> out = new LinkedHashMap();
    for (Map.Entry<String, Integer> e : nameToToken.entrySet()) {
      out.put("#" + e.getValue(), e.getKey());
    }
    return out;
  }
  
  Map<String, Object> getValueMap()
  {
    if (valueToToken.size() == 0) {
      return null;
    }
    Map<String, Object> out = new LinkedHashMap();
    for (Map.Entry<Object, Integer> e : valueToToken.entrySet()) {
      out.put(":" + e.getValue(), e.getKey());
    }
    return out;
  }
  
  int numNameTokens()
  {
    return nameToToken.size();
  }
  
  int numValueTokens()
  {
    return valueToToken.size();
  }
  
  String getNameByToken(int token)
  {
    for (Map.Entry<String, Integer> e : nameToToken.entrySet()) {
      if (((Integer)e.getValue()).intValue() == token) {
        return (String)e.getKey();
      }
    }
    return null;
  }
  
  Object getValueByToken(int token)
  {
    for (Map.Entry<Object, Integer> e : valueToToken.entrySet()) {
      if (((Integer)e.getValue()).intValue() == token) {
        return e.getKey();
      }
    }
    return null;
  }
  
  public String toString()
  {
    return 
      "name-tokens: " + nameToToken.toString() + "\nvalue-tokens: " + valueToToken.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.SubstitutionContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */