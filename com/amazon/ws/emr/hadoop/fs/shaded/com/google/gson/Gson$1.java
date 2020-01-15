package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import java.lang.reflect.Type;

class Gson$1
  implements JsonDeserializationContext
{
  Gson$1(Gson paramGson) {}
  
  public <T> T deserialize(JsonElement json, Type typeOfT)
    throws JsonParseException
  {
    return (T)this$0.fromJson(json, typeOfT);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */