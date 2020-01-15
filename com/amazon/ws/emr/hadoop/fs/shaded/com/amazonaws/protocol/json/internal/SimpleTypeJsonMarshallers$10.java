package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimestampFormat;
import java.util.Date;

final class SimpleTypeJsonMarshallers$10
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<Date>
{
  SimpleTypeJsonMarshallers$10()
  {
    super(null);
  }
  
  public void marshall(Date val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<Date> marshallingInfo)
  {
    TimestampFormat timestampFormat = TimestampFormat.UNIX_TIMESTAMP;
    if ((marshallingInfo != null) && (marshallingInfo.timestampFormat() != null)) {
      timestampFormat = marshallingInfo.timestampFormat();
    }
    jsonGenerator.writeValue(val, timestampFormat);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */