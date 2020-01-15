package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import java.util.Map;
import java.util.Map.Entry;

final class QueryParamMarshallers$3
  implements JsonMarshaller<Map>
{
  public void marshall(Map val, JsonMarshallerContext context, MarshallingInfo<Map> mapMarshallingInfo)
  {
    for (Map.Entry<String, ?> mapEntry : val.entrySet()) {
      context.marshall(MarshallLocation.QUERY_PARAM, mapEntry.getValue(), (String)mapEntry.getKey());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.QueryParamMarshallers.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */