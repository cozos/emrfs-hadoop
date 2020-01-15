package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

final class TypeAdapters$24
  extends TypeAdapter<Locale>
{
  public Locale read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    String locale = in.nextString();
    StringTokenizer tokenizer = new StringTokenizer(locale, "_");
    String language = null;
    String country = null;
    String variant = null;
    if (tokenizer.hasMoreElements()) {
      language = tokenizer.nextToken();
    }
    if (tokenizer.hasMoreElements()) {
      country = tokenizer.nextToken();
    }
    if (tokenizer.hasMoreElements()) {
      variant = tokenizer.nextToken();
    }
    if ((country == null) && (variant == null)) {
      return new Locale(language);
    }
    if (variant == null) {
      return new Locale(language, country);
    }
    return new Locale(language, country, variant);
  }
  
  public void write(JsonWriter out, Locale value)
    throws IOException
  {
    out.value(value == null ? null : value.toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.24
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */