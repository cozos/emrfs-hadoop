package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol;

public final class MarshallingInfo$Builder<T>
{
  private final MarshallingType<T> marshallingType;
  private String marshallLocationName;
  private MarshallLocation marshallLocation;
  private boolean isExplicitPayloadMember;
  private boolean isBinary;
  private DefaultValueSupplier<T> defaultValueSupplier;
  private String timestampFormat;
  
  private MarshallingInfo$Builder(MarshallingType<T> marshallingType)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */