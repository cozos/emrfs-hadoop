package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext.UnmarshallerType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.BigDecimalCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.BigIntegerCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.BooleanCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.ByteBufferCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.ByteCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.DateCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.DoubleCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.FloatCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.IntegerCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.LongCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.ShortCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.StringCborUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ImmutableMapParameter.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

@SdkInternalApi
class SdkStructuredCborFactory
{
  private static final JsonFactory CBOR_FACTORY = new CBORFactory();
  private static final Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> CBOR_SCALAR_UNMARSHALLERS = new ImmutableMapParameter.Builder()
  
    .put(String.class, SimpleTypeCborUnmarshallers.StringCborUnmarshaller.getInstance())
    .put(Double.class, SimpleTypeCborUnmarshallers.DoubleCborUnmarshaller.getInstance())
    .put(Integer.class, SimpleTypeCborUnmarshallers.IntegerCborUnmarshaller.getInstance())
    .put(BigInteger.class, SimpleTypeCborUnmarshallers.BigIntegerCborUnmarshaller.getInstance())
    .put(BigDecimal.class, SimpleTypeCborUnmarshallers.BigDecimalCborUnmarshaller.getInstance())
    .put(Boolean.class, SimpleTypeCborUnmarshallers.BooleanCborUnmarshaller.getInstance())
    .put(Float.class, SimpleTypeCborUnmarshallers.FloatCborUnmarshaller.getInstance())
    .put(Long.class, SimpleTypeCborUnmarshallers.LongCborUnmarshaller.getInstance())
    .put(Byte.class, SimpleTypeCborUnmarshallers.ByteCborUnmarshaller.getInstance())
    .put(Date.class, SimpleTypeCborUnmarshallers.DateCborUnmarshaller.getInstance())
    .put(ByteBuffer.class, SimpleTypeCborUnmarshallers.ByteBufferCborUnmarshaller.getInstance())
    .put(Short.class, SimpleTypeCborUnmarshallers.ShortCborUnmarshaller.getInstance()).build();
  public static final SdkStructuredJsonFactory SDK_CBOR_FACTORY = new SdkStructuredJsonFactoryImpl(CBOR_FACTORY, CBOR_SCALAR_UNMARSHALLERS, 
  
    Collections.emptyMap())
  {
    protected StructuredJsonGenerator createWriter(JsonFactory jsonFactory, String contentType)
    {
      return new SdkCborGenerator(jsonFactory, contentType);
    }
  };
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkStructuredCborFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */