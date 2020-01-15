package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimestampFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;

public class SimpleTypeStaxUnmarshallers
{
  private static Log log = LogFactory.getLog(SimpleTypeStaxUnmarshallers.class);
  
  public static class StringStaxUnmarshaller
    implements Unmarshaller<String, StaxUnmarshallerContext>
  {
    public String unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      return unmarshallerContext.readText();
    }
    
    private static final StringStaxUnmarshaller instance = new StringStaxUnmarshaller();
    
    public static StringStaxUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class BigDecimalStaxUnmarshaller
    implements Unmarshaller<BigDecimal, StaxUnmarshallerContext>
  {
    public BigDecimal unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String s = unmarshallerContext.readText();
      return s == null ? null : new BigDecimal(s);
    }
    
    private static final BigDecimalStaxUnmarshaller instance = new BigDecimalStaxUnmarshaller();
    
    public static BigDecimalStaxUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class BigIntegerStaxUnmarshaller
    implements Unmarshaller<BigInteger, StaxUnmarshallerContext>
  {
    public BigInteger unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String s = unmarshallerContext.readText();
      return s == null ? null : new BigInteger(s);
    }
    
    private static final BigIntegerStaxUnmarshaller instance = new BigIntegerStaxUnmarshaller();
    
    public static BigIntegerStaxUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class DoubleStaxUnmarshaller
    implements Unmarshaller<Double, StaxUnmarshallerContext>
  {
    public Double unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String doubleString = unmarshallerContext.readText();
      return doubleString == null ? null : Double.valueOf(Double.parseDouble(doubleString));
    }
    
    private static final DoubleStaxUnmarshaller instance = new DoubleStaxUnmarshaller();
    
    public static DoubleStaxUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class IntegerStaxUnmarshaller
    implements Unmarshaller<Integer, StaxUnmarshallerContext>
  {
    public Integer unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String intString = unmarshallerContext.readText();
      return intString == null ? null : Integer.valueOf(Integer.parseInt(intString));
    }
    
    private static final IntegerStaxUnmarshaller instance = new IntegerStaxUnmarshaller();
    
    public static IntegerStaxUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class BooleanStaxUnmarshaller
    implements Unmarshaller<Boolean, StaxUnmarshallerContext>
  {
    public Boolean unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String booleanString = unmarshallerContext.readText();
      return booleanString == null ? null : Boolean.valueOf(Boolean.parseBoolean(booleanString));
    }
    
    private static final BooleanStaxUnmarshaller instance = new BooleanStaxUnmarshaller();
    
    public static BooleanStaxUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class FloatStaxUnmarshaller
    implements Unmarshaller<Float, StaxUnmarshallerContext>
  {
    public Float unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String floatString = unmarshallerContext.readText();
      return floatString == null ? null : Float.valueOf(floatString);
    }
    
    private static final FloatStaxUnmarshaller instance = new FloatStaxUnmarshaller();
    
    public static FloatStaxUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class LongStaxUnmarshaller
    implements Unmarshaller<Long, StaxUnmarshallerContext>
  {
    public Long unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String longString = unmarshallerContext.readText();
      return longString == null ? null : Long.valueOf(Long.parseLong(longString));
    }
    
    private static final LongStaxUnmarshaller instance = new LongStaxUnmarshaller();
    
    public static LongStaxUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class ByteStaxUnmarshaller
    implements Unmarshaller<Byte, StaxUnmarshallerContext>
  {
    public Byte unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String byteString = unmarshallerContext.readText();
      return byteString == null ? null : Byte.valueOf(byteString);
    }
    
    private static final ByteStaxUnmarshaller instance = new ByteStaxUnmarshaller();
    
    public static ByteStaxUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class DateStaxUnmarshallerFactory
    implements Unmarshaller<Date, StaxUnmarshallerContext>
  {
    private final String dateFormatType;
    
    private DateStaxUnmarshallerFactory(String dateFormatType)
    {
      this.dateFormatType = dateFormatType;
    }
    
    public Date unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String dateString = unmarshallerContext.readText();
      if (dateString == null) {
        return null;
      }
      try
      {
        if (TimestampFormat.RFC_822.getFormat().equals(dateFormatType)) {
          return DateUtils.parseRFC822Date(dateString);
        }
        if (TimestampFormat.UNIX_TIMESTAMP.getFormat().equals(dateFormatType)) {
          return DateUtils.parseServiceSpecificDate(dateString);
        }
        return DateUtils.parseISO8601Date(dateString);
      }
      catch (Exception e)
      {
        SimpleTypeStaxUnmarshallers.log.warn("Unable to parse date '" + dateString + "':  " + e.getMessage(), e);
      }
      return null;
    }
    
    public static DateStaxUnmarshallerFactory getInstance(String dateFormatType)
    {
      return new DateStaxUnmarshallerFactory(dateFormatType);
    }
  }
  
  public static class DateStaxUnmarshaller
    implements Unmarshaller<Date, StaxUnmarshallerContext>
  {
    public Date unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String dateString = unmarshallerContext.readText();
      if (dateString == null) {
        return null;
      }
      try
      {
        return DateUtils.parseISO8601Date(dateString);
      }
      catch (Exception e)
      {
        SimpleTypeStaxUnmarshallers.log.warn("Unable to parse date '" + dateString + "':  " + e.getMessage(), e);
      }
      return null;
    }
    
    private static final DateStaxUnmarshaller instance = new DateStaxUnmarshaller();
    
    public static DateStaxUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class ByteBufferStaxUnmarshaller
    implements Unmarshaller<ByteBuffer, StaxUnmarshallerContext>
  {
    public ByteBuffer unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String base64EncodedString = unmarshallerContext.readText();
      byte[] decodedBytes = Base64.decode(base64EncodedString);
      return ByteBuffer.wrap(decodedBytes);
    }
    
    private static final ByteBufferStaxUnmarshaller instance = new ByteBufferStaxUnmarshaller();
    
    public static ByteBufferStaxUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class CharacterJsonUnmarshaller
    implements Unmarshaller<Character, StaxUnmarshallerContext>
  {
    public Character unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String charString = unmarshallerContext.readText();
      if (charString == null) {
        return null;
      }
      charString = charString.trim();
      if ((charString.isEmpty()) || (charString.length() > 1)) {
        throw new SdkClientException("'" + charString + "' cannot be converted to Character");
      }
      return Character.valueOf(charString.charAt(0));
    }
    
    private static final CharacterJsonUnmarshaller instance = new CharacterJsonUnmarshaller();
    
    public static CharacterJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class ShortJsonUnmarshaller
    implements Unmarshaller<Short, StaxUnmarshallerContext>
  {
    public Short unmarshall(StaxUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String shortString = unmarshallerContext.readText();
      return shortString == null ? null : Short.valueOf(shortString);
    }
    
    private static final ShortJsonUnmarshaller instance = new ShortJsonUnmarshaller();
    
    public static ShortJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */