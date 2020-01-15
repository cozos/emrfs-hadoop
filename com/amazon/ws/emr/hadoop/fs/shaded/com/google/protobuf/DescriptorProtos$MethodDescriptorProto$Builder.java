package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;

public final class DescriptorProtos$MethodDescriptorProto$Builder
  extends GeneratedMessage.Builder<Builder>
  implements DescriptorProtos.MethodDescriptorProtoOrBuilder
{
  private int bitField0_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$9300();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$9400().ensureFieldAccessorsInitialized(DescriptorProtos.MethodDescriptorProto.class, Builder.class);
  }
  
  private DescriptorProtos$MethodDescriptorProto$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$MethodDescriptorProto$Builder(GeneratedMessage.BuilderParent parent)
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
    inputType_ = "";
    bitField0_ &= 0xFFFFFFFD;
    outputType_ = "";
    bitField0_ &= 0xFFFFFFFB;
    if (optionsBuilder_ == null) {
      options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
    } else {
      optionsBuilder_.clear();
    }
    bitField0_ &= 0xFFFFFFF7;
    return this;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.access$9300();
  }
  
  public DescriptorProtos.MethodDescriptorProto getDefaultInstanceForType()
  {
    return DescriptorProtos.MethodDescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.MethodDescriptorProto build()
  {
    DescriptorProtos.MethodDescriptorProto result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.MethodDescriptorProto buildPartial()
  {
    DescriptorProtos.MethodDescriptorProto result = new DescriptorProtos.MethodDescriptorProto(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.MethodDescriptorProto.access$9902(result, name_);
    if ((from_bitField0_ & 0x2) == 2) {
      to_bitField0_ |= 0x2;
    }
    DescriptorProtos.MethodDescriptorProto.access$10002(result, inputType_);
    if ((from_bitField0_ & 0x4) == 4) {
      to_bitField0_ |= 0x4;
    }
    DescriptorProtos.MethodDescriptorProto.access$10102(result, outputType_);
    if ((from_bitField0_ & 0x8) == 8) {
      to_bitField0_ |= 0x8;
    }
    if (optionsBuilder_ == null) {
      DescriptorProtos.MethodDescriptorProto.access$10202(result, options_);
    } else {
      DescriptorProtos.MethodDescriptorProto.access$10202(result, (DescriptorProtos.MethodOptions)optionsBuilder_.build());
    }
    DescriptorProtos.MethodDescriptorProto.access$10302(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.MethodDescriptorProto)) {
      return mergeFrom((DescriptorProtos.MethodDescriptorProto)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.MethodDescriptorProto other)
  {
    if (other == DescriptorProtos.MethodDescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (other.hasName())
    {
      bitField0_ |= 0x1;
      name_ = DescriptorProtos.MethodDescriptorProto.access$9900(other);
      onChanged();
    }
    if (other.hasInputType())
    {
      bitField0_ |= 0x2;
      inputType_ = DescriptorProtos.MethodDescriptorProto.access$10000(other);
      onChanged();
    }
    if (other.hasOutputType())
    {
      bitField0_ |= 0x4;
      outputType_ = DescriptorProtos.MethodDescriptorProto.access$10100(other);
      onChanged();
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
    DescriptorProtos.MethodDescriptorProto parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.MethodDescriptorProto)DescriptorProtos.MethodDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.MethodDescriptorProto)e.getUnfinishedMessage();
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
    name_ = DescriptorProtos.MethodDescriptorProto.getDefaultInstance().getName();
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
  
  private Object inputType_ = "";
  
  public boolean hasInputType()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public String getInputType()
  {
    Object ref = inputType_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      inputType_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getInputTypeBytes()
  {
    Object ref = inputType_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      inputType_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setInputType(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x2;
    inputType_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearInputType()
  {
    bitField0_ &= 0xFFFFFFFD;
    inputType_ = DescriptorProtos.MethodDescriptorProto.getDefaultInstance().getInputType();
    onChanged();
    return this;
  }
  
  public Builder setInputTypeBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x2;
    inputType_ = value;
    onChanged();
    return this;
  }
  
  private Object outputType_ = "";
  
  public boolean hasOutputType()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public String getOutputType()
  {
    Object ref = outputType_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      outputType_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getOutputTypeBytes()
  {
    Object ref = outputType_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      outputType_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setOutputType(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x4;
    outputType_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearOutputType()
  {
    bitField0_ &= 0xFFFFFFFB;
    outputType_ = DescriptorProtos.MethodDescriptorProto.getDefaultInstance().getOutputType();
    onChanged();
    return this;
  }
  
  public Builder setOutputTypeBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x4;
    outputType_ = value;
    onChanged();
    return this;
  }
  
  private DescriptorProtos.MethodOptions options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
  private SingleFieldBuilder<DescriptorProtos.MethodOptions, DescriptorProtos.MethodOptions.Builder, DescriptorProtos.MethodOptionsOrBuilder> optionsBuilder_;
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x8) == 8;
  }
  
  public DescriptorProtos.MethodOptions getOptions()
  {
    if (optionsBuilder_ == null) {
      return options_;
    }
    return (DescriptorProtos.MethodOptions)optionsBuilder_.getMessage();
  }
  
  public Builder setOptions(DescriptorProtos.MethodOptions value)
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
    bitField0_ |= 0x8;
    return this;
  }
  
  public Builder setOptions(DescriptorProtos.MethodOptions.Builder builderForValue)
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
    bitField0_ |= 0x8;
    return this;
  }
  
  public Builder mergeOptions(DescriptorProtos.MethodOptions value)
  {
    if (optionsBuilder_ == null)
    {
      if (((bitField0_ & 0x8) == 8) && (options_ != DescriptorProtos.MethodOptions.getDefaultInstance())) {
        options_ = DescriptorProtos.MethodOptions.newBuilder(options_).mergeFrom(value).buildPartial();
      } else {
        options_ = value;
      }
      onChanged();
    }
    else
    {
      optionsBuilder_.mergeFrom(value);
    }
    bitField0_ |= 0x8;
    return this;
  }
  
  public Builder clearOptions()
  {
    if (optionsBuilder_ == null)
    {
      options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
      onChanged();
    }
    else
    {
      optionsBuilder_.clear();
    }
    bitField0_ &= 0xFFFFFFF7;
    return this;
  }
  
  public DescriptorProtos.MethodOptions.Builder getOptionsBuilder()
  {
    bitField0_ |= 0x8;
    onChanged();
    return (DescriptorProtos.MethodOptions.Builder)getOptionsFieldBuilder().getBuilder();
  }
  
  public DescriptorProtos.MethodOptionsOrBuilder getOptionsOrBuilder()
  {
    if (optionsBuilder_ != null) {
      return (DescriptorProtos.MethodOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
    }
    return options_;
  }
  
  private SingleFieldBuilder<DescriptorProtos.MethodOptions, DescriptorProtos.MethodOptions.Builder, DescriptorProtos.MethodOptionsOrBuilder> getOptionsFieldBuilder()
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.MethodDescriptorProto.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */