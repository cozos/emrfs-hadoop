package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import java.util.List;

final class QueryParamMarshallers$2
  implements JsonMarshaller<List>
{
  public void marshall(List list, JsonMarshallerContext context, MarshallingInfo<List> marshallingInfo)
  {
    for (Object listVal : list) {
      context.marshall(MarshallLocation.QUERY_PARAM, listVal, marshallingInfo);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.QueryParamMarshallers.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */