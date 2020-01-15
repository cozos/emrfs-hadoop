package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class TagSet
  implements Serializable
{
  private Map<String, String> tags;
  
  public TagSet()
  {
    tags = new LinkedHashMap(1);
  }
  
  public TagSet(Map<String, String> tags)
  {
    this.tags = new LinkedHashMap(1);
    this.tags.putAll(tags);
  }
  
  public String getTag(String key)
  {
    return (String)tags.get(key);
  }
  
  public void setTag(String key, String value)
  {
    tags.put(key, value);
  }
  
  public Map<String, String> getAllTags()
  {
    return tags;
  }
  
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("{");
    sb.append("Tags: " + getAllTags());
    sb.append("}");
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.TagSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */