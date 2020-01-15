package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonArray;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonNull;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonObject;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonPrimitive;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.LazilyParsedNumber;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Map.Entry;

final class TypeAdapters$25
  extends TypeAdapter<JsonElement>
{
  public JsonElement read(JsonReader in)
    throws IOException
  {
    switch (TypeAdapters.32.$SwitchMap$com$google$gson$stream$JsonToken[in.peek().ordinal()])
    {
    case 3: 
      return new JsonPrimitive(in.nextString());
    case 1: 
      String number = in.nextString();
      return new JsonPrimitive(new LazilyParsedNumber(number));
    case 2: 
      return new JsonPrimitive(Boolean.valueOf(in.nextBoolean()));
    case 4: 
      in.nextNull();
      return JsonNull.INSTANCE;
    case 5: 
      JsonArray array = new JsonArray();
      in.beginArray();
      while (in.hasNext()) {
        array.add(read(in));
      }
      in.endArray();
      return array;
    case 6: 
      JsonObject object = new JsonObject();
      in.beginObject();
      while (in.hasNext()) {
        object.add(in.nextName(), read(in));
      }
      in.endObject();
      return object;
    }
    throw new IllegalArgumentException();
  }
  
  public void write(JsonWriter out, JsonElement value)
    throws IOException
  {
    if ((value == null) || (value.isJsonNull()))
    {
      out.nullValue();
    }
    else if (value.isJsonPrimitive())
    {
      JsonPrimitive primitive = value.getAsJsonPrimitive();
      if (primitive.isNumber()) {
        out.value(primitive.getAsNumber());
      } else if (primitive.isBoolean()) {
        out.value(primitive.getAsBoolean());
      } else {
        out.value(primitive.getAsString());
      }
    }
    else if (value.isJsonArray())
    {
      out.beginArray();
      for (JsonElement e : value.getAsJsonArray()) {
        write(out, e);
      }
      out.endArray();
    }
    else if (value.isJsonObject())
    {
      out.beginObject();
      for (Map.Entry<String, JsonElement> e : value.getAsJsonObject().entrySet())
      {
        out.name((String)e.getKey());
        write(out, (JsonElement)e.getValue());
      }
      out.endObject();
    }
    else
    {
      throw new IllegalArgumentException("Couldn't write " + value.getClass());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.25
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */