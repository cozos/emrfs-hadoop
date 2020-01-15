package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

final class SimpleTypeJsonMarshallers$4
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<Long>
{
  SimpleTypeJsonMarshallers$4()
  {
    super(null);
  }
  
  public void marshall(Long val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<Long> marshallingInfo)
  {
    jsonGenerator.writeValue(val.longValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */