package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;
import java.util.Map;
import java.util.Map.Entry;

final class SimpleTypeJsonMarshallers$14
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<Map>
{
  SimpleTypeJsonMarshallers$14()
  {
    super(null);
  }
  
  public void marshall(Map map, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<Map> mapMarshallingInfo)
  {
    jsonGenerator.writeStartObject();
    for (Map.Entry<String, ?> entry : map.entrySet()) {
      if (entry.getValue() != null)
      {
        Object value = entry.getValue();
        jsonGenerator.writeFieldName((String)entry.getKey());
        context.marshall(MarshallLocation.PAYLOAD, value);
      }
    }
    jsonGenerator.writeEndObject();
  }
  
  protected boolean shouldEmit(Map map)
  {
    return (!map.isEmpty()) || (!(map instanceof SdkInternalMap)) || (!((SdkInternalMap)map).isAutoConstruct());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */