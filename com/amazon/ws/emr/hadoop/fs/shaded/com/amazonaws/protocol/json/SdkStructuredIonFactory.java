package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.CompositeErrorCodeParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.ErrorCodeParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.IonErrorCodeParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.JsonErrorCodeParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.BigDecimalIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.BigIntegerIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.BooleanIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.ByteBufferIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.ByteIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.DateIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.DoubleIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.FloatIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.IntegerIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.LongIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.ShortIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.StringIonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ImmutableMapParameter.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import software.amazon.ion.IonSystem;
import software.amazon.ion.system.IonBinaryWriterBuilder;
import software.amazon.ion.system.IonSystemBuilder;
import software.amazon.ion.system.IonTextWriterBuilder;
import software.amazon.ion.system.IonWriterBuilder;

@SdkInternalApi
class SdkStructuredIonFactory
  extends SdkStructuredJsonFactoryImpl
{
  private static final IonSystem ION_SYSTEM = IonSystemBuilder.standard().build();
  private static final JsonFactory JSON_FACTORY = new IonFactory(ION_SYSTEM);
  private static final Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> UNMARSHALLERS = new ImmutableMapParameter.Builder()
  
    .put(BigDecimal.class, SimpleTypeIonUnmarshallers.BigDecimalIonUnmarshaller.getInstance())
    .put(BigInteger.class, SimpleTypeIonUnmarshallers.BigIntegerIonUnmarshaller.getInstance())
    .put(Boolean.class, SimpleTypeIonUnmarshallers.BooleanIonUnmarshaller.getInstance())
    .put(ByteBuffer.class, SimpleTypeIonUnmarshallers.ByteBufferIonUnmarshaller.getInstance())
    .put(Byte.class, SimpleTypeIonUnmarshallers.ByteIonUnmarshaller.getInstance())
    .put(Date.class, SimpleTypeIonUnmarshallers.DateIonUnmarshaller.getInstance())
    .put(Double.class, SimpleTypeIonUnmarshallers.DoubleIonUnmarshaller.getInstance())
    .put(Float.class, SimpleTypeIonUnmarshallers.FloatIonUnmarshaller.getInstance())
    .put(Integer.class, SimpleTypeIonUnmarshallers.IntegerIonUnmarshaller.getInstance())
    .put(Long.class, SimpleTypeIonUnmarshallers.LongIonUnmarshaller.getInstance())
    .put(Short.class, SimpleTypeIonUnmarshallers.ShortIonUnmarshaller.getInstance())
    .put(String.class, SimpleTypeIonUnmarshallers.StringIonUnmarshaller.getInstance())
    .build();
  private static final IonBinaryWriterBuilder BINARY_WRITER_BUILDER = IonBinaryWriterBuilder.standard().immutable();
  private static final IonTextWriterBuilder TEXT_WRITER_BUILDER = IonTextWriterBuilder.standard().immutable();
  public static final SdkStructuredIonFactory SDK_ION_BINARY_FACTORY = new SdkStructuredIonFactory(BINARY_WRITER_BUILDER);
  public static final SdkStructuredIonFactory SDK_ION_TEXT_FACTORY = new SdkStructuredIonFactory(TEXT_WRITER_BUILDER);
  private final IonWriterBuilder builder;
  
  private SdkStructuredIonFactory(IonWriterBuilder builder)
  {
    super(JSON_FACTORY, UNMARSHALLERS, 
      Collections.emptyMap());
    this.builder = builder;
  }
  
  protected StructuredJsonGenerator createWriter(JsonFactory jsonFactory, String contentType)
  {
    return SdkIonGenerator.create(builder, contentType);
  }
  
  protected ErrorCodeParser getErrorCodeParser(String customErrorCodeFieldName)
  {
    return new CompositeErrorCodeParser(new ErrorCodeParser[] { new IonErrorCodeParser(ION_SYSTEM), new JsonErrorCodeParser(customErrorCodeFieldName) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkStructuredIonFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */