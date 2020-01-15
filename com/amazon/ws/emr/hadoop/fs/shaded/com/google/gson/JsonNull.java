package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

public final class JsonNull
  extends JsonElement
{
  public static final JsonNull INSTANCE = new JsonNull();
  
  JsonNull deepCopy()
  {
    return INSTANCE;
  }
  
  public int hashCode()
  {
    return JsonNull.class.hashCode();
  }
  
  public boolean equals(Object other)
  {
    return (this == other) || ((other instanceof JsonNull));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonNull
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */