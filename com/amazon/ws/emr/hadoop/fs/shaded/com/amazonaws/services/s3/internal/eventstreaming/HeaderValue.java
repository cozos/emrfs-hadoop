package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public abstract class HeaderValue
{
  public static HeaderValue fromBoolean(boolean value)
  {
    return new BooleanValue(value, null);
  }
  
  public static HeaderValue fromByte(byte value)
  {
    return new ByteValue(value, null);
  }
  
  public static HeaderValue fromShort(short value)
  {
    return new ShortValue(value, null);
  }
  
  public static HeaderValue fromInteger(int value)
  {
    return new IntegerValue(value, null);
  }
  
  public static HeaderValue fromLong(long value)
  {
    return new LongValue(value, null);
  }
  
  public static HeaderValue fromByteArray(byte[] bytes)
  {
    return new ByteArrayValue(bytes, null);
  }
  
  public static HeaderValue fromByteBuffer(ByteBuffer buf)
  {
    buf = buf.duplicate();
    byte[] bytes = new byte[buf.remaining()];
    buf.get(bytes);
    return fromByteArray(bytes);
  }
  
  public static HeaderValue fromString(String string)
  {
    return new StringValue(string, null);
  }
  
  public static HeaderValue fromTimestamp(DateTime value)
  {
    return new TimestampValue(value, null);
  }
  
  public static HeaderValue fromDate(Date value)
  {
    return new TimestampValue(new DateTime(value), null);
  }
  
  public static HeaderValue fromUuid(UUID value)
  {
    return new UuidValue(value, null);
  }
  
  public abstract HeaderType getType();
  
  public boolean getBoolean()
  {
    throw new IllegalStateException();
  }
  
  public byte getByte()
  {
    throw new IllegalStateException("Expected byte, but type was " + getType().name());
  }
  
  public short getShort()
  {
    throw new IllegalStateException("Expected short, but type was " + getType().name());
  }
  
  public int getInteger()
  {
    throw new IllegalStateException("Expected integer, but type was " + getType().name());
  }
  
  public long getLong()
  {
    throw new IllegalStateException("Expected long, but type was " + getType().name());
  }
  
  public byte[] getByteArray()
  {
    throw new IllegalStateException();
  }
  
  public final ByteBuffer getByteBuffer()
  {
    return ByteBuffer.wrap(getByteArray());
  }
  
  public String getString()
  {
    throw new IllegalStateException();
  }
  
  public DateTime getTimestamp()
  {
    throw new IllegalStateException("Expected timestamp, but type was " + getType().name());
  }
  
  public Date getDate()
  {
    return getTimestamp().toDate();
  }
  
  public UUID getUuid()
  {
    throw new IllegalStateException("Expected UUID, but type was " + getType().name());
  }
  
  void encode(DataOutputStream dos)
    throws IOException
  {
    dos.writeByte(getTypeheaderTypeId);
    encodeValue(dos);
  }
  
  abstract void encodeValue(DataOutputStream paramDataOutputStream)
    throws IOException;
  
  static HeaderValue decode(ByteBuffer buf)
  {
    HeaderType type = HeaderType.fromTypeId(buf.get());
    switch (type)
    {
    case TRUE: 
      return new BooleanValue(true, null);
    case FALSE: 
      return new BooleanValue(false, null);
    case BYTE: 
      return new ByteValue(buf.get(), null);
    case SHORT: 
      return new ShortValue(buf.getShort(), null);
    case INTEGER: 
      return fromInteger(buf.getInt());
    case LONG: 
      return new LongValue(buf.getLong(), null);
    case BYTE_ARRAY: 
      return fromByteArray(Utils.readBytes(buf));
    case STRING: 
      return fromString(Utils.readString(buf));
    case TIMESTAMP: 
      return TimestampValue.decode(buf);
    case UUID: 
      return UuidValue.decode(buf);
    }
    throw new IllegalStateException();
  }
  
  private static final class BooleanValue
    extends HeaderValue
  {
    private final boolean value;
    
    private BooleanValue(boolean value)
    {
      this.value = value;
    }
    
    public HeaderType getType()
    {
      if (value) {
        return HeaderType.TRUE;
      }
      return HeaderType.FALSE;
    }
    
    public boolean getBoolean()
    {
      return value;
    }
    
    void encodeValue(DataOutputStream dos) {}
    
    public boolean equals(Object o)
    {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      BooleanValue that = (BooleanValue)o;
      
      return value == value;
    }
    
    public int hashCode()
    {
      if (value) {
        return 1;
      }
      return 0;
    }
    
    public String toString()
    {
      return String.valueOf(value);
    }
  }
  
  private static final class ByteValue
    extends HeaderValue
  {
    private final byte value;
    
    private ByteValue(byte value)
    {
      this.value = value;
    }
    
    public HeaderType getType()
    {
      return HeaderType.BYTE;
    }
    
    public byte getByte()
    {
      return value;
    }
    
    void encodeValue(DataOutputStream dos) {}
    
    public boolean equals(Object o)
    {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      ByteValue that = (ByteValue)o;
      
      return value == value;
    }
    
    public int hashCode()
    {
      return value;
    }
    
    public String toString()
    {
      return String.valueOf(value);
    }
  }
  
  private static final class ShortValue
    extends HeaderValue
  {
    private final short value;
    
    private ShortValue(short value)
    {
      this.value = value;
    }
    
    public HeaderType getType()
    {
      return HeaderType.SHORT;
    }
    
    public short getShort()
    {
      return value;
    }
    
    void encodeValue(DataOutputStream dos) {}
    
    public boolean equals(Object o)
    {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      ShortValue that = (ShortValue)o;
      
      return value == value;
    }
    
    public int hashCode()
    {
      return value;
    }
    
    public String toString()
    {
      return String.valueOf(value);
    }
  }
  
  private static final class IntegerValue
    extends HeaderValue
  {
    private final int value;
    
    private IntegerValue(int value)
    {
      this.value = value;
    }
    
    public HeaderType getType()
    {
      return HeaderType.INTEGER;
    }
    
    public int getInteger()
    {
      return value;
    }
    
    void encodeValue(DataOutputStream dos)
      throws IOException
    {
      dos.writeInt(value);
    }
    
    public boolean equals(Object o)
    {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      IntegerValue that = (IntegerValue)o;
      
      return value == value;
    }
    
    public int hashCode()
    {
      return value;
    }
    
    public String toString()
    {
      return String.valueOf(value);
    }
  }
  
  private static final class LongValue
    extends HeaderValue
  {
    private final long value;
    
    private LongValue(long value)
    {
      this.value = value;
    }
    
    public HeaderType getType()
    {
      return HeaderType.LONG;
    }
    
    public long getLong()
    {
      return value;
    }
    
    void encodeValue(DataOutputStream dos)
      throws IOException
    {
      dos.writeLong(value);
    }
    
    public boolean equals(Object o)
    {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      LongValue longValue = (LongValue)o;
      
      return value == value;
    }
    
    public int hashCode()
    {
      return (int)(value ^ value >>> 32);
    }
    
    public String toString()
    {
      return String.valueOf(value);
    }
  }
  
  private static final class ByteArrayValue
    extends HeaderValue
  {
    private final byte[] value;
    
    private ByteArrayValue(byte[] value)
    {
      this.value = ((byte[])ValidationUtils.assertNotNull(value, "value"));
    }
    
    public HeaderType getType()
    {
      return HeaderType.BYTE_ARRAY;
    }
    
    public byte[] getByteArray()
    {
      return value;
    }
    
    void encodeValue(DataOutputStream dos)
      throws IOException
    {
      Utils.writeBytes(dos, value);
    }
    
    public boolean equals(Object o)
    {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      ByteArrayValue that = (ByteArrayValue)o;
      
      return Arrays.equals(value, value);
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(value);
    }
    
    public String toString()
    {
      return Base64.encodeAsString(value);
    }
  }
  
  private static final class StringValue
    extends HeaderValue
  {
    private final String value;
    
    private StringValue(String value)
    {
      this.value = ((String)ValidationUtils.assertNotNull(value, "value"));
    }
    
    public HeaderType getType()
    {
      return HeaderType.STRING;
    }
    
    public String getString()
    {
      return value;
    }
    
    void encodeValue(DataOutputStream dos)
      throws IOException
    {
      Utils.writeString(dos, value);
    }
    
    public boolean equals(Object o)
    {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      StringValue that = (StringValue)o;
      
      return value.equals(value);
    }
    
    public int hashCode()
    {
      return value.hashCode();
    }
    
    public String toString()
    {
      return '"' + value + '"';
    }
  }
  
  private static final class TimestampValue
    extends HeaderValue
  {
    private final DateTime value;
    
    private TimestampValue(DateTime value)
    {
      this.value = ((DateTime)ValidationUtils.assertNotNull(value, "value"));
    }
    
    static TimestampValue decode(ByteBuffer buf)
    {
      long epochMillis = buf.getLong();
      return new TimestampValue(new DateTime(epochMillis));
    }
    
    public HeaderType getType()
    {
      return HeaderType.TIMESTAMP;
    }
    
    public DateTime getTimestamp()
    {
      return value;
    }
    
    void encodeValue(DataOutputStream dos)
      throws IOException
    {
      dos.writeLong(value.getMillis());
    }
    
    public boolean equals(Object o)
    {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      TimestampValue that = (TimestampValue)o;
      
      return value.equals(value);
    }
    
    public int hashCode()
    {
      return value.hashCode();
    }
    
    public String toString()
    {
      return value.toString();
    }
  }
  
  private static final class UuidValue
    extends HeaderValue
  {
    private final UUID value;
    
    private UuidValue(UUID value)
    {
      this.value = ((UUID)ValidationUtils.assertNotNull(value, "value"));
    }
    
    static UuidValue decode(ByteBuffer buf)
    {
      long msb = buf.getLong();
      long lsb = buf.getLong();
      return new UuidValue(new UUID(msb, lsb));
    }
    
    public HeaderType getType()
    {
      return HeaderType.UUID;
    }
    
    public UUID getUuid()
    {
      return value;
    }
    
    void encodeValue(DataOutputStream dos)
      throws IOException
    {
      dos.writeLong(value.getMostSignificantBits());
      dos.writeLong(value.getLeastSignificantBits());
    }
    
    public boolean equals(Object o)
    {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      UuidValue uuidValue = (UuidValue)o;
      
      return value.equals(value);
    }
    
    public int hashCode()
    {
      return value.hashCode();
    }
    
    public String toString()
    {
      return value.toString();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.HeaderValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */