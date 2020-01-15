package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

class JsonUnmarshallerContextImpl$JsonFieldTokenPair
{
  private final String field;
  private final JsonToken jsonToken;
  
  public JsonUnmarshallerContextImpl$JsonFieldTokenPair(String fieldString, JsonToken token)
  {
    field = fieldString;
    jsonToken = token;
  }
  
  public String getField()
  {
    return field;
  }
  
  public JsonToken getToken()
  {
    return jsonToken;
  }
  
  public String toString()
  {
    return field + ": " + jsonToken.asString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContextImpl.JsonFieldTokenPair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */