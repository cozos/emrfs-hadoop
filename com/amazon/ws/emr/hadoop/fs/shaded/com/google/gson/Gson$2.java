package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import java.lang.reflect.Type;

class Gson$2
  implements JsonSerializationContext
{
  Gson$2(Gson paramGson) {}
  
  public JsonElement serialize(Object src)
  {
    return this$0.toJsonTree(src);
  }
  
  public JsonElement serialize(Object src, Type typeOfSrc)
  {
    return this$0.toJsonTree(src, typeOfSrc);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */