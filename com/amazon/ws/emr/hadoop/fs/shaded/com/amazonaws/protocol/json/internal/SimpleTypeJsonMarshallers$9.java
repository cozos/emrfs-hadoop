package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

final class SimpleTypeJsonMarshallers$9
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<Boolean>
{
  SimpleTypeJsonMarshallers$9()
  {
    super(null);
  }
  
  public void marshall(Boolean val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<Boolean> marshallingInfo)
  {
    jsonGenerator.writeValue(val.booleanValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */