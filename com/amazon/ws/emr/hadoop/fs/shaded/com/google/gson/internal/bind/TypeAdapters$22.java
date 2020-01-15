package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

final class TypeAdapters$22
  implements TypeAdapterFactory
{
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken)
  {
    if (typeToken.getRawType() != Timestamp.class) {
      return null;
    }
    final TypeAdapter<Date> dateTypeAdapter = gson.getAdapter(Date.class);
    new TypeAdapter()
    {
      public Timestamp read(JsonReader in)
        throws IOException
      {
        Date date = (Date)dateTypeAdapter.read(in);
        return date != null ? new Timestamp(date.getTime()) : null;
      }
      
      public void write(JsonWriter out, Timestamp value)
        throws IOException
      {
        dateTypeAdapter.write(out, value);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.22
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */