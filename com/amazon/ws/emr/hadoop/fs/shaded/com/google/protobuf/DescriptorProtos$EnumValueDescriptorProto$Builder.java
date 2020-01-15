package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;

public final class DescriptorProtos$EnumValueDescriptorProto$Builder
  extends GeneratedMessage.Builder<Builder>
  implements DescriptorProtos.EnumValueDescriptorProtoOrBuilder
{
  private int bitField0_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$7300();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$7400().ensureFieldAccessorsInitialized(DescriptorProtos.EnumValueDescriptorProto.class, Builder.class);
  }
  
  private DescriptorProtos$EnumValueDescriptorProto$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$EnumValueDescriptorProto$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
    maybeForceBuilderInitialization();
  }
  
  private void maybeForceBuilderInitialization()
  {
    if (GeneratedMessage.alwaysUseFieldBuilders) {
      getOptionsFieldBuilder();
    }
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  public Builder clear()
  {
    super.clear();
    name_ = "";
    bitField0_ &= 0xFFFFFFFE;
    number_ = 0;
    bitField0_ &= 0xFFFFFFFD;
    if (optionsBuilder_ == null) {
      options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
    } else {
      optionsBuilder_.clear();
    }
    bitField0_ &= 0xFFFFFFFB;
    return this;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.access$7300();
  }
  
  public DescriptorProtos.EnumValueDescriptorProto getDefaultInstanceForType()
  {
    return DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.EnumValueDescriptorProto build()
  {
    DescriptorProtos.EnumValueDescriptorProto result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.EnumValueDescriptorProto buildPartial()
  {
    DescriptorProtos.EnumValueDescriptorProto result = new DescriptorProtos.EnumValueDescriptorProto(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.EnumValueDescriptorProto.access$7902(result, name_);
    if ((from_bitField0_ & 0x2) == 2) {
      to_bitField0_ |= 0x2;
    }
    DescriptorProtos.EnumValueDescriptorProto.access$8002(result, number_);
    if ((from_bitField0_ & 0x4) == 4) {
      to_bitField0_ |= 0x4;
    }
    if (optionsBuilder_ == null) {
      DescriptorProtos.EnumValueDescriptorProto.access$8102(result, options_);
    } else {
      DescriptorProtos.EnumValueDescriptorProto.access$8102(result, (DescriptorProtos.EnumValueOptions)optionsBuilder_.build());
    }
    DescriptorProtos.EnumValueDescriptorProto.access$8202(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.EnumValueDescriptorProto)) {
      return mergeFrom((DescriptorProtos.EnumValueDescriptorProto)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.EnumValueDescriptorProto other)
  {
    if (other == DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (other.hasName())
    {
      bitField0_ |= 0x1;
      name_ = DescriptorProtos.EnumValueDescriptorProto.access$7900(other);
      onChanged();
    }
    if (other.hasNumber()) {
      setNumber(other.getNumber());
    }
    if (other.hasOptions()) {
      mergeOptions(other.getOptions());
    }
    mergeUnknownFields(other.getUnknownFields());
    return this;
  }
  
  public final boolean isInitialized()
  {
    if ((hasOptions()) && 
      (!getOptions().isInitialized())) {
      return false;
    }
    return true;
  }
  
  public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    DescriptorProtos.EnumValueDescriptorProto parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.EnumValueDescriptorProto)DescriptorProtos.EnumValueDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.EnumValueDescriptorProto)e.getUnfinishedMessage();
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
  
  private Object name_ = "";
  private int number_;
  
  public boolean hasName()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public String getName()
  {
    Object ref = name_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      name_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getNameBytes()
  {
    Object ref = name_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      name_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setName(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x1;
    name_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearName()
  {
    bitField0_ &= 0xFFFFFFFE;
    name_ = DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance().getName();
    onChanged();
    return this;
  }
  
  public Builder setNameBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x1;
    name_ = value;
    onChanged();
    return this;
  }
  
  public boolean hasNumber()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public int getNumber()
  {
    return number_;
  }
  
  public Builder setNumber(int value)
  {
    bitField0_ |= 0x2;
    number_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearNumber()
  {
    bitField0_ &= 0xFFFFFFFD;
    number_ = 0;
    onChanged();
    return this;
  }
  
  private DescriptorProtos.EnumValueOptions options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
  private SingleFieldBuilder<DescriptorProtos.EnumValueOptions, DescriptorProtos.EnumValueOptions.Builder, DescriptorProtos.EnumValueOptionsOrBuilder> optionsBuilder_;
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public DescriptorProtos.EnumValueOptions getOptions()
  {
    if (optionsBuilder_ == null) {
      return options_;
    }
    return (DescriptorProtos.EnumValueOptions)optionsBuilder_.getMessage();
  }
  
  public Builder setOptions(DescriptorProtos.EnumValueOptions value)
  {
    if (optionsBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      options_ = value;
      onChanged();
    }
    else
    {
      optionsBuilder_.setMessage(value);
    }
    bitField0_ |= 0x4;
    return this;
  }
  
  public Builder setOptions(DescriptorProtos.EnumValueOptions.Builder builderForValue)
  {
    if (optionsBuilder_ == null)
    {
      options_ = builderForValue.build();
      onChanged();
    }
    else
    {
      optionsBuilder_.setMessage(builderForValue.build());
    }
    bitField0_ |= 0x4;
    return this;
  }
  
  public Builder mergeOptions(DescriptorProtos.EnumValueOptions value)
  {
    if (optionsBuilder_ == null)
    {
      if (((bitField0_ & 0x4) == 4) && (options_ != DescriptorProtos.EnumValueOptions.getDefaultInstance())) {
        options_ = DescriptorProtos.EnumValueOptions.newBuilder(options_).mergeFrom(value).buildPartial();
      } else {
        options_ = value;
      }
      onChanged();
    }
    else
    {
      optionsBuilder_.mergeFrom(value);
    }
    bitField0_ |= 0x4;
    return this;
  }
  
  public Builder clearOptions()
  {
    if (optionsBuilder_ == null)
    {
      options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
      onChanged();
    }
    else
    {
      optionsBuilder_.clear();
    }
    bitField0_ &= 0xFFFFFFFB;
    return this;
  }
  
  public DescriptorProtos.EnumValueOptions.Builder getOptionsBuilder()
  {
    bitField0_ |= 0x4;
    onChanged();
    return (DescriptorProtos.EnumValueOptions.Builder)getOptionsFieldBuilder().getBuilder();
  }
  
  public DescriptorProtos.EnumValueOptionsOrBuilder getOptionsOrBuilder()
  {
    if (optionsBuilder_ != null) {
      return (DescriptorProtos.EnumValueOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
    }
    return options_;
  }
  
  private SingleFieldBuilder<DescriptorProtos.EnumValueOptions, DescriptorProtos.EnumValueOptions.Builder, DescriptorProtos.EnumValueOptionsOrBuilder> getOptionsFieldBuilder()
  {
    if (optionsBuilder_ == null)
    {
      optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
      
      options_ = null;
    }
    return optionsBuilder_;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.EnumValueDescriptorProto.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */