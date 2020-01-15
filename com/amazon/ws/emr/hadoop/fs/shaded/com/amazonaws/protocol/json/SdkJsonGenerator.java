package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimestampFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;

@SdkInternalApi
public class SdkJsonGenerator
  implements StructuredJsonGenerator
{
  private static final int DEFAULT_BUFFER_SIZE = 1024;
  
  public static class JsonGenerationException
    extends SdkClientException
  {
    public JsonGenerationException(Throwable t)
    {
      super();
    }
  }
  
  private final ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
  private final JsonGenerator generator;
  private final String contentType;
  
  public SdkJsonGenerator(JsonFactory factory, String contentType)
  {
    try
    {
      generator = factory.createGenerator(baos);
      this.contentType = contentType;
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
  }
  
  public StructuredJsonGenerator writeStartArray()
  {
    try
    {
      generator.writeStartArray();
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeEndArray()
  {
    try
    {
      generator.writeEndArray();
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeNull()
  {
    try
    {
      generator.writeNull();
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeStartObject()
  {
    try
    {
      generator.writeStartObject();
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeEndObject()
  {
    try
    {
      generator.writeEndObject();
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeFieldName(String fieldName)
  {
    try
    {
      generator.writeFieldName(fieldName);
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeValue(String val)
  {
    try
    {
      generator.writeString(val);
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeValue(boolean bool)
  {
    try
    {
      generator.writeBoolean(bool);
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeValue(long val)
  {
    try
    {
      generator.writeNumber(val);
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeValue(double val)
  {
    try
    {
      generator.writeNumber(val);
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeValue(float val)
  {
    try
    {
      generator.writeNumber(val);
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeValue(short val)
  {
    try
    {
      generator.writeNumber(val);
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeValue(int val)
  {
    try
    {
      generator.writeNumber(val);
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeValue(ByteBuffer bytes)
  {
    try
    {
      generator.writeBinary(BinaryUtils.copyBytesFrom(bytes));
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeValue(Date date, TimestampFormat timestampFormat)
  {
    try
    {
      switch (timestampFormat)
      {
      case UNIX_TIMESTAMP_IN_MILLIS: 
        generator.writeNumber(DateUtils.formatUnixTimestampInMills(date));
        break;
      case ISO_8601: 
        generator.writeString(DateUtils.formatISO8601Date(date));
        break;
      case RFC_822: 
        generator.writeString(DateUtils.formatRFC822Date(date));
        break;
      case UNIX_TIMESTAMP: 
      default: 
        generator.writeNumber(DateUtils.formatServiceSpecificDate(date));
      }
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeValue(BigDecimal value)
  {
    try
    {
      generator.writeString(value.toString());
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  public StructuredJsonGenerator writeValue(BigInteger value)
  {
    try
    {
      generator.writeNumber(value);
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
    return this;
  }
  
  private void close()
  {
    try
    {
      generator.close();
    }
    catch (IOException e)
    {
      throw new JsonGenerationException(e);
    }
  }
  
  public byte[] getBytes()
  {
    close();
    return baos.toByteArray();
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  protected JsonGenerator getGenerator()
  {
    return generator;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkJsonGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */