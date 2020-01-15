package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext.UnmarshallerType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.BigDecimalJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.BigIntegerJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.ByteJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.CharacterJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.FloatJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.JsonValueStringUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.ShortJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ImmutableMapParameter.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Map;

@SdkProtectedApi
public class SdkStructuredPlainJsonFactory
{
  public static final JsonFactory JSON_FACTORY = new JsonFactory();
  @SdkTestInternalApi
  public static final Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> JSON_SCALAR_UNMARSHALLERS = new ImmutableMapParameter.Builder()
  
    .put(String.class, SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance())
    .put(Double.class, SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller.getInstance())
    .put(Integer.class, SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance())
    .put(BigInteger.class, SimpleTypeJsonUnmarshallers.BigIntegerJsonUnmarshaller.getInstance())
    .put(BigDecimal.class, SimpleTypeJsonUnmarshallers.BigDecimalJsonUnmarshaller.getInstance())
    .put(Boolean.class, SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance())
    .put(Float.class, SimpleTypeJsonUnmarshallers.FloatJsonUnmarshaller.getInstance())
    .put(Long.class, SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance())
    .put(Byte.class, SimpleTypeJsonUnmarshallers.ByteJsonUnmarshaller.getInstance())
    .put(Date.class, SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance())
    .put(ByteBuffer.class, SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance())
    .put(Character.class, SimpleTypeJsonUnmarshallers.CharacterJsonUnmarshaller.getInstance())
    .put(Short.class, SimpleTypeJsonUnmarshallers.ShortJsonUnmarshaller.getInstance()).build();
  @SdkTestInternalApi
  public static final Map<JsonUnmarshallerContext.UnmarshallerType, Unmarshaller<?, JsonUnmarshallerContext>> JSON_CUSTOM_TYPE_UNMARSHALLERS = new ImmutableMapParameter.Builder()
  
    .put(JsonUnmarshallerContext.UnmarshallerType.JSON_VALUE, SimpleTypeJsonUnmarshallers.JsonValueStringUnmarshaller.getInstance())
    .build();
  public static final SdkStructuredJsonFactory SDK_JSON_FACTORY = new SdkStructuredJsonFactoryImpl(JSON_FACTORY, JSON_SCALAR_UNMARSHALLERS, JSON_CUSTOM_TYPE_UNMARSHALLERS)
  {
    protected StructuredJsonGenerator createWriter(JsonFactory jsonFactory, String contentType)
    {
      return new SdkJsonGenerator(jsonFactory, contentType);
    }
  };
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkStructuredPlainJsonFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */