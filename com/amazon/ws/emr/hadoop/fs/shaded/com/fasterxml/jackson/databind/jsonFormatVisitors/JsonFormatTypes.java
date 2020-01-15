package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

public enum JsonFormatTypes
{
  STRING,  NUMBER,  INTEGER,  BOOLEAN,  OBJECT,  ARRAY,  NULL,  ANY;
  
  private static final Map<String, JsonFormatTypes> _byLCName;
  
  static
  {
    _byLCName = new HashMap();
    for (JsonFormatTypes t : values()) {
      _byLCName.put(t.name().toLowerCase(), t);
    }
  }
  
  @JsonValue
  public String value()
  {
    return name().toLowerCase();
  }
  
  @JsonCreator
  public static JsonFormatTypes forValue(String s)
  {
    return (JsonFormatTypes)_byLCName.get(s);
  }
  
  private JsonFormatTypes() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */