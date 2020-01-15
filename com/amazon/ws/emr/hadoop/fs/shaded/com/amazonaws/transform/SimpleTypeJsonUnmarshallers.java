package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimestampFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Date;

public class SimpleTypeJsonUnmarshallers
{
  public static class StringJsonUnmarshaller
    implements Unmarshaller<String, JsonUnmarshallerContext>
  {
    public String unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      return unmarshallerContext.readText();
    }
    
    private static final StringJsonUnmarshaller instance = new StringJsonUnmarshaller();
    
    public static StringJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class JsonValueStringUnmarshaller
    extends SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller
  {
    public String unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String stringValue = super.unmarshall(unmarshallerContext);
      return !unmarshallerContext.isInsideResponseHeader() ? stringValue : new String(
      
        Base64.decode(stringValue), Charset.forName("utf-8"));
    }
    
    private static final JsonValueStringUnmarshaller INSTANCE = new JsonValueStringUnmarshaller();
    
    public static JsonValueStringUnmarshaller getInstance()
    {
      return INSTANCE;
    }
  }
  
  public static class DoubleJsonUnmarshaller
    implements Unmarshaller<Double, JsonUnmarshallerContext>
  {
    public Double unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String doubleString = unmarshallerContext.readText();
      return doubleString == null ? null : Double.valueOf(Double.parseDouble(doubleString));
    }
    
    private static final DoubleJsonUnmarshaller instance = new DoubleJsonUnmarshaller();
    
    public static DoubleJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class IntegerJsonUnmarshaller
    implements Unmarshaller<Integer, JsonUnmarshallerContext>
  {
    public Integer unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String intString = unmarshallerContext.readText();
      return intString == null ? null : Integer.valueOf(Integer.parseInt(intString));
    }
    
    private static final IntegerJsonUnmarshaller instance = new IntegerJsonUnmarshaller();
    
    public static IntegerJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class BigIntegerJsonUnmarshaller
    implements Unmarshaller<BigInteger, JsonUnmarshallerContext>
  {
    public BigInteger unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String intString = unmarshallerContext.readText();
      return intString == null ? null : new BigInteger(intString);
    }
    
    private static final BigIntegerJsonUnmarshaller instance = new BigIntegerJsonUnmarshaller();
    
    public static BigIntegerJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class BigDecimalJsonUnmarshaller
    implements Unmarshaller<BigDecimal, JsonUnmarshallerContext>
  {
    public BigDecimal unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String s = unmarshallerContext.readText();
      return s == null ? null : new BigDecimal(s);
    }
    
    private static final BigDecimalJsonUnmarshaller instance = new BigDecimalJsonUnmarshaller();
    
    public static BigDecimalJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class BooleanJsonUnmarshaller
    implements Unmarshaller<Boolean, JsonUnmarshallerContext>
  {
    public Boolean unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String booleanString = unmarshallerContext.readText();
      return booleanString == null ? null : Boolean.valueOf(Boolean.parseBoolean(booleanString));
    }
    
    private static final BooleanJsonUnmarshaller instance = new BooleanJsonUnmarshaller();
    
    public static BooleanJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class FloatJsonUnmarshaller
    implements Unmarshaller<Float, JsonUnmarshallerContext>
  {
    public Float unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String floatString = unmarshallerContext.readText();
      return floatString == null ? null : Float.valueOf(floatString);
    }
    
    private static final FloatJsonUnmarshaller instance = new FloatJsonUnmarshaller();
    
    public static FloatJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class LongJsonUnmarshaller
    implements Unmarshaller<Long, JsonUnmarshallerContext>
  {
    public Long unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String longString = unmarshallerContext.readText();
      return longString == null ? null : Long.valueOf(Long.parseLong(longString));
    }
    
    private static final LongJsonUnmarshaller instance = new LongJsonUnmarshaller();
    
    public static LongJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class ByteJsonUnmarshaller
    implements Unmarshaller<Byte, JsonUnmarshallerContext>
  {
    public Byte unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String byteString = unmarshallerContext.readText();
      return byteString == null ? null : Byte.valueOf(byteString);
    }
    
    private static final ByteJsonUnmarshaller instance = new ByteJsonUnmarshaller();
    
    public static ByteJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class DateJsonUnmarshaller
    implements Unmarshaller<Date, JsonUnmarshallerContext>
  {
    public Date unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      if (unmarshallerContext.getCurrentToken() == JsonToken.VALUE_STRING) {
        return DateUtils.parseISO8601Date(unmarshallerContext.readText());
      }
      return DateUtils.parseServiceSpecificDate(unmarshallerContext.readText());
    }
    
    private static final DateJsonUnmarshaller instance = new DateJsonUnmarshaller();
    
    public static DateJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class DateJsonUnmarshallerFactory
    implements Unmarshaller<Date, JsonUnmarshallerContext>
  {
    private final String dateFormatType;
    
    private DateJsonUnmarshallerFactory(String dateFormatType)
    {
      this.dateFormatType = dateFormatType;
    }
    
    public Date unmarshall(JsonUnmarshallerContext unmarshallerContext)
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
        if (TimestampFormat.UNIX_TIMESTAMP_IN_MILLIS.getFormat().equals(dateFormatType)) {
          return DateUtils.parseUnixTimestampInMillis(dateString);
        }
        return DateUtils.parseISO8601Date(dateString);
      }
      catch (Exception exception) {}
      return SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(unmarshallerContext);
    }
    
    public static DateJsonUnmarshallerFactory getInstance(String dateFormatType)
    {
      return new DateJsonUnmarshallerFactory(dateFormatType);
    }
  }
  
  public static class ByteBufferJsonUnmarshaller
    implements Unmarshaller<ByteBuffer, JsonUnmarshallerContext>
  {
    public ByteBuffer unmarshall(JsonUnmarshallerContext unmarshallerContext)
      throws Exception
    {
      String base64EncodedString = unmarshallerContext.readText();
      if (base64EncodedString == null) {
        return null;
      }
      byte[] decodedBytes = Base64.decode(base64EncodedString);
      return ByteBuffer.wrap(decodedBytes);
    }
    
    private static final ByteBufferJsonUnmarshaller instance = new ByteBufferJsonUnmarshaller();
    
    public static ByteBufferJsonUnmarshaller getInstance()
    {
      return instance;
    }
  }
  
  public static class CharacterJsonUnmarshaller
    implements Unmarshaller<Character, JsonUnmarshallerContext>
  {
    public Character unmarshall(JsonUnmarshallerContext unmarshallerContext)
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
    implements Unmarshaller<Short, JsonUnmarshallerContext>
  {
    public Short unmarshall(JsonUnmarshallerContext unmarshallerContext)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */