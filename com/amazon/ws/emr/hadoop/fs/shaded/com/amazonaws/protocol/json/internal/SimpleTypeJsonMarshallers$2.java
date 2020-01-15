package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

final class SimpleTypeJsonMarshallers$2
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<String>
{
  SimpleTypeJsonMarshallers$2()
  {
    super(null);
  }
  
  public void marshall(String val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<String> marshallingInfo)
  {
    jsonGenerator.writeValue(val);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */