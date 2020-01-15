package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.List;

public class ListUnmarshaller<T>
  implements Unmarshaller<List<T>, JsonUnmarshallerContext>
{
  private final Unmarshaller<T, JsonUnmarshallerContext> itemUnmarshaller;
  
  public ListUnmarshaller(Unmarshaller<T, JsonUnmarshallerContext> itemUnmarshaller)
  {
    this.itemUnmarshaller = itemUnmarshaller;
  }
  
  public List<T> unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    if (context.isInsideResponseHeader()) {
      return unmarshallResponseHeaderToList(context);
    }
    return unmarshallJsonToList(context);
  }
  
  private List<T> unmarshallResponseHeaderToList(JsonUnmarshallerContext context)
    throws Exception
  {
    String headerValue = context.readText();
    
    List<T> list = new ArrayList();
    
    String[] headerValues = headerValue.split("[,]");
    for (final String headerVal : headerValues) {
      list.add(itemUnmarshaller.unmarshall(new JsonUnmarshallerContext()
      {
        public String readText()
        {
          return headerVal;
        }
      }));
    }
    return list;
  }
  
  private List<T> unmarshallJsonToList(JsonUnmarshallerContext context)
    throws Exception
  {
    List<T> list = new ArrayList();
    if (context.getCurrentToken() == JsonToken.VALUE_NULL) {
      return null;
    }
    for (;;)
    {
      JsonToken token = context.nextToken();
      if (token == null) {
        return list;
      }
      if (token == JsonToken.END_ARRAY) {
        return list;
      }
      list.add(itemUnmarshaller.unmarshall(context));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */