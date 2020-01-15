package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;
import java.util.List;

final class SimpleTypeJsonMarshallers$13
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<List>
{
  SimpleTypeJsonMarshallers$13()
  {
    super(null);
  }
  
  public void marshall(List list, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<List> marshallingInfo)
  {
    jsonGenerator.writeStartArray();
    for (Object listValue : list) {
      context.marshall(MarshallLocation.PAYLOAD, listValue);
    }
    jsonGenerator.writeEndArray();
  }
  
  protected boolean shouldEmit(List list)
  {
    return (!list.isEmpty()) || (!(list instanceof SdkInternalList)) || (!((SdkInternalList)list).isAutoConstruct());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */