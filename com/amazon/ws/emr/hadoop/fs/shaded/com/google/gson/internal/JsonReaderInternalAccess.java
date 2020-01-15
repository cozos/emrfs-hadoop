package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import java.io.IOException;

public abstract class JsonReaderInternalAccess
{
  public static JsonReaderInternalAccess INSTANCE;
  
  public abstract void promoteNameToValue(JsonReader paramJsonReader)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.JsonReaderInternalAccess
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */