package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.io.IOException;

public final class DateTimeJsonSerializer
  extends JsonSerializer<DateTime>
{
  public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    jgen.writeString(DateUtils.formatISO8601Date(value));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.DateTimeJsonSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */