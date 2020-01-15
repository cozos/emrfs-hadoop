package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

class TypeAdapters$22$1
  extends TypeAdapter<Timestamp>
{
  TypeAdapters$22$1(TypeAdapters.22 param22, TypeAdapter paramTypeAdapter) {}
  
  public Timestamp read(JsonReader in)
    throws IOException
  {
    Date date = (Date)val$dateTypeAdapter.read(in);
    return date != null ? new Timestamp(date.getTime()) : null;
  }
  
  public void write(JsonWriter out, Timestamp value)
    throws IOException
  {
    val$dateTypeAdapter.write(out, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.22.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */