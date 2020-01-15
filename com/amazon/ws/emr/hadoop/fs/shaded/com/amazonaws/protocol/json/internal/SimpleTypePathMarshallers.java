package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.PathMarshallers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.PathMarshallers.PathMarshaller;

@SdkInternalApi
public class SimpleTypePathMarshallers
{
  public static final JsonMarshaller<String> STRING = new SimplePathMarshaller(ValueToStringConverters.FROM_STRING, PathMarshallers.NON_GREEDY, null);
  public static final JsonMarshaller<Integer> INTEGER = new SimplePathMarshaller(ValueToStringConverters.FROM_INTEGER, PathMarshallers.NON_GREEDY, null);
  public static final JsonMarshaller<Long> LONG = new SimplePathMarshaller(ValueToStringConverters.FROM_LONG, PathMarshallers.NON_GREEDY, null);
  public static final JsonMarshaller<String> GREEDY_STRING = new SimplePathMarshaller(ValueToStringConverters.FROM_STRING, PathMarshallers.GREEDY, null);
  public static final JsonMarshaller<Void> NULL = new JsonMarshaller()
  {
    public void marshall(Void val, JsonMarshallerContext context, MarshallingInfo<Void> marshallingInfo)
    {
      throw new IllegalArgumentException(String.format("Parameter '%s' must not be null", new Object[] { marshallingInfo.marshallLocationName() }));
    }
  };
  
  private static class SimplePathMarshaller<T>
    implements JsonMarshaller<T>
  {
    private final ValueToStringConverters.ValueToString<T> converter;
    private final PathMarshallers.PathMarshaller pathMarshaller;
    
    private SimplePathMarshaller(ValueToStringConverters.ValueToString<T> converter, PathMarshallers.PathMarshaller pathMarshaller)
    {
      this.converter = converter;
      this.pathMarshaller = pathMarshaller;
    }
    
    public void marshall(T val, JsonMarshallerContext context, MarshallingInfo<T> marshallingInfo)
    {
      context.request().setResourcePath(pathMarshaller
        .marshall(context.request().getResourcePath(), marshallingInfo.marshallLocationName(), converter
        .convert(val)));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypePathMarshallers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */