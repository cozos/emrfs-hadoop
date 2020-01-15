package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

final class SimpleTypeJsonMarshallers$5
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<Short>
{
  SimpleTypeJsonMarshallers$5()
  {
    super(null);
  }
  
  public void marshall(Short val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<Short> marshallingInfo)
  {
    jsonGenerator.writeValue(val.shortValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */