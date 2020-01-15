package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class TypeAdapters$23
  extends TypeAdapter<Calendar>
{
  private static final String YEAR = "year";
  private static final String MONTH = "month";
  private static final String DAY_OF_MONTH = "dayOfMonth";
  private static final String HOUR_OF_DAY = "hourOfDay";
  private static final String MINUTE = "minute";
  private static final String SECOND = "second";
  
  public Calendar read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    in.beginObject();
    int year = 0;
    int month = 0;
    int dayOfMonth = 0;
    int hourOfDay = 0;
    int minute = 0;
    int second = 0;
    while (in.peek() != JsonToken.END_OBJECT)
    {
      String name = in.nextName();
      int value = in.nextInt();
      if ("year".equals(name)) {
        year = value;
      } else if ("month".equals(name)) {
        month = value;
      } else if ("dayOfMonth".equals(name)) {
        dayOfMonth = value;
      } else if ("hourOfDay".equals(name)) {
        hourOfDay = value;
      } else if ("minute".equals(name)) {
        minute = value;
      } else if ("second".equals(name)) {
        second = value;
      }
    }
    in.endObject();
    return new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
  }
  
  public void write(JsonWriter out, Calendar value)
    throws IOException
  {
    if (value == null)
    {
      out.nullValue();
      return;
    }
    out.beginObject();
    out.name("year");
    out.value(value.get(1));
    out.name("month");
    out.value(value.get(2));
    out.name("dayOfMonth");
    out.value(value.get(5));
    out.name("hourOfDay");
    out.value(value.get(11));
    out.name("minute");
    out.value(value.get(12));
    out.name("second");
    out.value(value.get(13));
    out.endObject();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.23
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */