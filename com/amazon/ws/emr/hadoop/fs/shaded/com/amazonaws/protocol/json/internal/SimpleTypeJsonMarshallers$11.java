package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;
import java.nio.ByteBuffer;

final class SimpleTypeJsonMarshallers$11
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<ByteBuffer>
{
  SimpleTypeJsonMarshallers$11()
  {
    super(null);
  }
  
  public void marshall(ByteBuffer val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<ByteBuffer> marshallingInfo)
  {
    jsonGenerator.writeValue(val);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */