package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;

public class SimpleTypeIonUnmarshallers
{
  public static class StringIonUnmarshaller
    implements Unmarshaller<String, JsonUnmarshallerContext>
  {
    public String unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return context.readText();
    }
    
    private static final StringIonUnmarshaller instance = new StringIonUnmarshaller();
    
    public static StringIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class DoubleIonUnmarshaller
    implements Unmarshaller<Double, JsonUnmarshallerContext>
  {
    public Double unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return Double.valueOf(context.getJsonParser().getDoubleValue());
    }
    
    private static final DoubleIonUnmarshaller instance = new DoubleIonUnmarshaller();
    
    public static DoubleIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class IntegerIonUnmarshaller
    implements Unmarshaller<Integer, JsonUnmarshallerContext>
  {
    public Integer unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return Integer.valueOf(context.getJsonParser().getIntValue());
    }
    
    private static final IntegerIonUnmarshaller instance = new IntegerIonUnmarshaller();
    
    public static IntegerIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class BigIntegerIonUnmarshaller
    implements Unmarshaller<BigInteger, JsonUnmarshallerContext>
  {
    public BigInteger unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return context.getJsonParser().getBigIntegerValue();
    }
    
    private static final BigIntegerIonUnmarshaller instance = new BigIntegerIonUnmarshaller();
    
    public static BigIntegerIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class BigDecimalIonUnmarshaller
    implements Unmarshaller<BigDecimal, JsonUnmarshallerContext>
  {
    public BigDecimal unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return context.getJsonParser().getDecimalValue();
    }
    
    private static final BigDecimalIonUnmarshaller instance = new BigDecimalIonUnmarshaller();
    
    public static BigDecimalIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class BooleanIonUnmarshaller
    implements Unmarshaller<Boolean, JsonUnmarshallerContext>
  {
    public Boolean unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return Boolean.valueOf(context.getJsonParser().getBooleanValue());
    }
    
    private static final BooleanIonUnmarshaller instance = new BooleanIonUnmarshaller();
    
    public static BooleanIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class FloatIonUnmarshaller
    implements Unmarshaller<Float, JsonUnmarshallerContext>
  {
    public Float unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return Float.valueOf(context.getJsonParser().getFloatValue());
    }
    
    private static final FloatIonUnmarshaller instance = new FloatIonUnmarshaller();
    
    public static FloatIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class LongIonUnmarshaller
    implements Unmarshaller<Long, JsonUnmarshallerContext>
  {
    public Long unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return Long.valueOf(context.getJsonParser().getLongValue());
    }
    
    private static final LongIonUnmarshaller instance = new LongIonUnmarshaller();
    
    public static LongIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class ByteIonUnmarshaller
    implements Unmarshaller<Byte, JsonUnmarshallerContext>
  {
    public Byte unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return Byte.valueOf(context.getJsonParser().getByteValue());
    }
    
    private static final ByteIonUnmarshaller instance = new ByteIonUnmarshaller();
    
    public static ByteIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class DateIonUnmarshaller
    implements Unmarshaller<Date, JsonUnmarshallerContext>
  {
    public Date unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return (Date)context.getJsonParser().getEmbeddedObject();
    }
    
    private static final DateIonUnmarshaller instance = new DateIonUnmarshaller();
    
    public static DateIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class ByteBufferIonUnmarshaller
    implements Unmarshaller<ByteBuffer, JsonUnmarshallerContext>
  {
    public ByteBuffer unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return (ByteBuffer)context.getJsonParser().getEmbeddedObject();
    }
    
    private static final ByteBufferIonUnmarshaller instance = new ByteBufferIonUnmarshaller();
    
    public static ByteBufferIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class ShortIonUnmarshaller
    implements Unmarshaller<Short, JsonUnmarshallerContext>
  {
    public Short unmarshall(JsonUnmarshallerContext context)
      throws Exception
    {
      return Short.valueOf(context.getJsonParser().getShortValue());
    }
    
    private static final ShortIonUnmarshaller instance = new ShortIonUnmarshaller();
    
    public static ShortIonUnmarshaller getInstance()
    {
      return instance;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */