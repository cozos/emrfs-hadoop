package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import java.lang.reflect.Type;

public abstract interface JsonDeserializationContext
{
  public abstract <T> T deserialize(JsonElement paramJsonElement, Type paramType)
    throws JsonParseException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonDeserializationContext
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */