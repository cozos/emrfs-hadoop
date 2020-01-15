package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

final class SimpleTypeJsonMarshallers$1
  implements JsonMarshaller<Void>
{
  public void marshall(Void val, JsonMarshallerContext context, MarshallingInfo<Void> marshallingInfo)
  {
    if ((marshallingInfo == null) || (marshallingInfo.marshallLocationName() == null)) {
      context.jsonGenerator().writeNull();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */