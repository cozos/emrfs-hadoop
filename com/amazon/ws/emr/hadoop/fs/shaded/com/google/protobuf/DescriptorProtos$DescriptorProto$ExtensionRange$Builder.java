package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;

public final class DescriptorProtos$DescriptorProto$ExtensionRange$Builder
  extends GeneratedMessage.Builder<Builder>
  implements DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
{
  private int bitField0_;
  private int start_;
  private int end_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$2800();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$2900().ensureFieldAccessorsInitialized(DescriptorProtos.DescriptorProto.ExtensionRange.class, Builder.class);
  }
  
  private DescriptorProtos$DescriptorProto$ExtensionRange$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$DescriptorProto$ExtensionRange$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
    maybeForceBuilderInitialization();
  }
  
  private void maybeForceBuilderInitialization()
  {
    if (GeneratedMessage.alwaysUseFieldBuilders) {}
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  public Builder clear()
  {
    super.clear();
    start_ = 0;
    bitField0_ &= 0xFFFFFFFE;
    end_ = 0;
    bitField0_ &= 0xFFFFFFFD;
    return this;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.access$2800();
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRange getDefaultInstanceForType()
  {
    return DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance();
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRange build()
  {
    DescriptorProtos.DescriptorProto.ExtensionRange result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRange buildPartial()
  {
    DescriptorProtos.DescriptorProto.ExtensionRange result = new DescriptorProtos.DescriptorProto.ExtensionRange(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.DescriptorProto.ExtensionRange.access$3402(result, start_);
    if ((from_bitField0_ & 0x2) == 2) {
      to_bitField0_ |= 0x2;
    }
    DescriptorProtos.DescriptorProto.ExtensionRange.access$3502(result, end_);
    DescriptorProtos.DescriptorProto.ExtensionRange.access$3602(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.DescriptorProto.ExtensionRange)) {
      return mergeFrom((DescriptorProtos.DescriptorProto.ExtensionRange)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.DescriptorProto.ExtensionRange other)
  {
    if (other == DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance()) {
      return this;
    }
    if (other.hasStart()) {
      setStart(other.getStart());
    }
    if (other.hasEnd()) {
      setEnd(other.getEnd());
    }
    mergeUnknownFields(other.getUnknownFields());
    return this;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    DescriptorProtos.DescriptorProto.ExtensionRange parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.DescriptorProto.ExtensionRange)DescriptorProtos.DescriptorProto.ExtensionRange.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.DescriptorProto.ExtensionRange)e.getUnfinishedMessage();
      throw e;
    }
    finally
    {
      if (parsedMessage != null) {
        mergeFrom(parsedMessage);
      }
    }
    return this;
  }
  
  public boolean hasStart()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public int getStart()
  {
    return start_;
  }
  
  public Builder setStart(int value)
  {
    bitField0_ |= 0x1;
    start_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearStart()
  {
    bitField0_ &= 0xFFFFFFFE;
    start_ = 0;
    onChanged();
    return this;
  }
  
  public boolean hasEnd()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public int getEnd()
  {
    return end_;
  }
  
  public Builder setEnd(int value)
  {
    bitField0_ |= 0x2;
    end_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearEnd()
  {
    bitField0_ &= 0xFFFFFFFD;
    end_ = 0;
    onChanged();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */