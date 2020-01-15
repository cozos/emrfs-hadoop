package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

 enum LongSerializationPolicy$2
{
  LongSerializationPolicy$2()
  {
    super(paramString, paramInt, null);
  }
  
  public JsonElement serialize(Long value)
  {
    return new JsonPrimitive(String.valueOf(value));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.LongSerializationPolicy.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */