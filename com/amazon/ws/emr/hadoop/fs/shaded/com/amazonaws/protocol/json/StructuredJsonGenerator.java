package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimestampFormat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;

@SdkProtectedApi
public abstract interface StructuredJsonGenerator
{
  public static final StructuredJsonGenerator NO_OP = new StructuredJsonGenerator()
  {
    private final byte[] EMPTY_BYTES = new byte[0];
    
    public StructuredJsonGenerator writeStartArray()
    {
      return this;
    }
    
    public StructuredJsonGenerator writeEndArray()
    {
      return this;
    }
    
    public StructuredJsonGenerator writeNull()
    {
      return this;
    }
    
    public StructuredJsonGenerator writeStartObject()
    {
      return this;
    }
    
    public StructuredJsonGenerator writeEndObject()
    {
      return this;
    }
    
    public StructuredJsonGenerator writeFieldName(String fieldName)
    {
      return this;
    }
    
    public StructuredJsonGenerator writeValue(String val)
    {
      return this;
    }
    
    public StructuredJsonGenerator writeValue(boolean bool)
    {
      return this;
    }
    
    public StructuredJsonGenerator writeValue(long val)
    {
      return this;
    }
    
    public StructuredJsonGenerator writeValue(double val)
    {
      return this;
    }
    
    public StructuredJsonGenerator writeValue(float val)
    {
      return this;
    }
    
    public StructuredJsonGenerator writeValue(short val)
    {
      return this;
    }
    
    public StructuredJsonGenerator writeValue(int val)
    {
      return this;
    }
    
    public StructuredJsonGenerator writeValue(ByteBuffer bytes)
    {
      return this;
    }
    
    public StructuredJsonGenerator writeValue(Date date, TimestampFormat timestampFormat)
    {
      return this;
    }
    
    public StructuredJsonGenerator writeValue(BigDecimal value)
    {
      return this;
    }
    
    public StructuredJsonGenerator writeValue(BigInteger value)
    {
      return this;
    }
    
    public byte[] getBytes()
    {
      return EMPTY_BYTES;
    }
    
    public String getContentType()
    {
      return null;
    }
  };
  
  public abstract StructuredJsonGenerator writeStartArray();
  
  public abstract StructuredJsonGenerator writeEndArray();
  
  public abstract StructuredJsonGenerator writeNull();
  
  public abstract StructuredJsonGenerator writeStartObject();
  
  public abstract StructuredJsonGenerator writeEndObject();
  
  public abstract StructuredJsonGenerator writeFieldName(String paramString);
  
  public abstract StructuredJsonGenerator writeValue(String paramString);
  
  public abstract StructuredJsonGenerator writeValue(boolean paramBoolean);
  
  public abstract StructuredJsonGenerator writeValue(long paramLong);
  
  public abstract StructuredJsonGenerator writeValue(double paramDouble);
  
  public abstract StructuredJsonGenerator writeValue(float paramFloat);
  
  public abstract StructuredJsonGenerator writeValue(short paramShort);
  
  public abstract StructuredJsonGenerator writeValue(int paramInt);
  
  public abstract StructuredJsonGenerator writeValue(ByteBuffer paramByteBuffer);
  
  public abstract StructuredJsonGenerator writeValue(Date paramDate, TimestampFormat paramTimestampFormat);
  
  public abstract StructuredJsonGenerator writeValue(BigDecimal paramBigDecimal);
  
  public abstract StructuredJsonGenerator writeValue(BigInteger paramBigInteger);
  
  public abstract byte[] getBytes();
  
  @Deprecated
  public abstract String getContentType();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */