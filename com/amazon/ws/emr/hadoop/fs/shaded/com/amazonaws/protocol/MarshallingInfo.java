package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimestampFormat;

@SdkProtectedApi
public class MarshallingInfo<T>
{
  private final MarshallingType<T> marshallingType;
  private final String marshallLocationName;
  private final MarshallLocation marshallLocation;
  private final boolean isExplicitPayloadMember;
  private final boolean isBinary;
  private final DefaultValueSupplier<T> defaultValueSupplier;
  private final TimestampFormat timestampFormat;
  
  private MarshallingInfo(Builder<T> builder)
  {
    marshallingType = marshallingType;
    marshallLocationName = marshallLocationName;
    marshallLocation = marshallLocation;
    isExplicitPayloadMember = isExplicitPayloadMember;
    isBinary = isBinary;
    defaultValueSupplier = defaultValueSupplier;
    timestampFormat = TimestampFormat.fromValue(timestampFormat);
  }
  
  public MarshallingType<T> marshallingType()
  {
    return marshallingType;
  }
  
  public String marshallLocationName()
  {
    return marshallLocationName;
  }
  
  public MarshallLocation marshallLocation()
  {
    return marshallLocation;
  }
  
  public boolean isExplicitPayloadMember()
  {
    return isExplicitPayloadMember;
  }
  
  public boolean isBinary()
  {
    return isBinary;
  }
  
  public DefaultValueSupplier<T> defaultValueSupplier()
  {
    return defaultValueSupplier;
  }
  
  public TimestampFormat timestampFormat()
  {
    return timestampFormat;
  }
  
  public static <T> Builder<T> builder(MarshallingType<T> marshallingType)
  {
    return new Builder(marshallingType, null);
  }
  
  public static final class Builder<T>
  {
    private final MarshallingType<T> marshallingType;
    private String marshallLocationName;
    private MarshallLocation marshallLocation;
    private boolean isExplicitPayloadMember;
    private boolean isBinary;
    private DefaultValueSupplier<T> defaultValueSupplier;
    private String timestampFormat;
    
    private Builder(MarshallingType<T> marshallingType)
    {
      this.marshallingType = marshallingType;
    }
    
    public Builder<T> marshallLocationName(String marshallLocationName)
    {
      this.marshallLocationName = marshallLocationName;
      return this;
    }
    
    public Builder<T> marshallLocation(MarshallLocation marshallLocation)
    {
      this.marshallLocation = marshallLocation;
      return this;
    }
    
    public Builder<T> isExplicitPayloadMember(boolean isExplicitPayloadMember)
    {
      this.isExplicitPayloadMember = isExplicitPayloadMember;
      return this;
    }
    
    public Builder<T> isBinary(boolean isBinary)
    {
      this.isBinary = isBinary;
      return this;
    }
    
    public Builder<T> defaultValueSupplier(DefaultValueSupplier<T> defaultValueSupplier)
    {
      this.defaultValueSupplier = defaultValueSupplier;
      return this;
    }
    
    public Builder<T> timestampFormat(String timestampFormat)
    {
      this.timestampFormat = timestampFormat;
      return this;
    }
    
    public MarshallingInfo<T> build()
    {
      return new MarshallingInfo(this, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */