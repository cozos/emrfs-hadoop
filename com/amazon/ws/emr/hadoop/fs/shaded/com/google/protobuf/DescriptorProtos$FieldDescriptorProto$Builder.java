package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;

public final class DescriptorProtos$FieldDescriptorProto$Builder
  extends GeneratedMessage.Builder<Builder>
  implements DescriptorProtos.FieldDescriptorProtoOrBuilder
{
  private int bitField0_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$4800();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$4900().ensureFieldAccessorsInitialized(DescriptorProtos.FieldDescriptorProto.class, Builder.class);
  }
  
  private DescriptorProtos$FieldDescriptorProto$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$FieldDescriptorProto$Builder(GeneratedMessage.BuilderParent parent)
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
    label_ = DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
    bitField0_ &= 0xFFFFFFFB;
    type_ = DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE;
    bitField0_ &= 0xFFFFFFF7;
    typeName_ = "";
    bitField0_ &= 0xFFFFFFEF;
    extendee_ = "";
    bitField0_ &= 0xFFFFFFDF;
    defaultValue_ = "";
    bitField0_ &= 0xFFFFFFBF;
    if (optionsBuilder_ == null) {
      options_ = DescriptorProtos.FieldOptions.getDefaultInstance();
    } else {
      optionsBuilder_.clear();
    }
    bitField0_ &= 0xFF7F;
    return this;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.access$4800();
  }
  
  public DescriptorProtos.FieldDescriptorProto getDefaultInstanceForType()
  {
    return DescriptorProtos.FieldDescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.FieldDescriptorProto build()
  {
    DescriptorProtos.FieldDescriptorProto result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.FieldDescriptorProto buildPartial()
  {
    DescriptorProtos.FieldDescriptorProto result = new DescriptorProtos.FieldDescriptorProto(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.FieldDescriptorProto.access$5402(result, name_);
    if ((from_bitField0_ & 0x2) == 2) {
      to_bitField0_ |= 0x2;
    }
    DescriptorProtos.FieldDescriptorProto.access$5502(result, number_);
    if ((from_bitField0_ & 0x4) == 4) {
      to_bitField0_ |= 0x4;
    }
    DescriptorProtos.FieldDescriptorProto.access$5602(result, label_);
    if ((from_bitField0_ & 0x8) == 8) {
      to_bitField0_ |= 0x8;
    }
    DescriptorProtos.FieldDescriptorProto.access$5702(result, type_);
    if ((from_bitField0_ & 0x10) == 16) {
      to_bitField0_ |= 0x10;
    }
    DescriptorProtos.FieldDescriptorProto.access$5802(result, typeName_);
    if ((from_bitField0_ & 0x20) == 32) {
      to_bitField0_ |= 0x20;
    }
    DescriptorProtos.FieldDescriptorProto.access$5902(result, extendee_);
    if ((from_bitField0_ & 0x40) == 64) {
      to_bitField0_ |= 0x40;
    }
    DescriptorProtos.FieldDescriptorProto.access$6002(result, defaultValue_);
    if ((from_bitField0_ & 0x80) == 128) {
      to_bitField0_ |= 0x80;
    }
    if (optionsBuilder_ == null) {
      DescriptorProtos.FieldDescriptorProto.access$6102(result, options_);
    } else {
      DescriptorProtos.FieldDescriptorProto.access$6102(result, (DescriptorProtos.FieldOptions)optionsBuilder_.build());
    }
    DescriptorProtos.FieldDescriptorProto.access$6202(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.FieldDescriptorProto)) {
      return mergeFrom((DescriptorProtos.FieldDescriptorProto)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.FieldDescriptorProto other)
  {
    if (other == DescriptorProtos.FieldDescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (other.hasName())
    {
      bitField0_ |= 0x1;
      name_ = DescriptorProtos.FieldDescriptorProto.access$5400(other);
      onChanged();
    }
    if (other.hasNumber()) {
      setNumber(other.getNumber());
    }
    if (other.hasLabel()) {
      setLabel(other.getLabel());
    }
    if (other.hasType()) {
      setType(other.getType());
    }
    if (other.hasTypeName())
    {
      bitField0_ |= 0x10;
      typeName_ = DescriptorProtos.FieldDescriptorProto.access$5800(other);
      onChanged();
    }
    if (other.hasExtendee())
    {
      bitField0_ |= 0x20;
      extendee_ = DescriptorProtos.FieldDescriptorProto.access$5900(other);
      onChanged();
    }
    if (other.hasDefaultValue())
    {
      bitField0_ |= 0x40;
      defaultValue_ = DescriptorProtos.FieldDescriptorProto.access$6000(other);
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
    DescriptorProtos.FieldDescriptorProto parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.FieldDescriptorProto)DescriptorProtos.FieldDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.FieldDescriptorProto)e.getUnfinishedMessage();
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
    name_ = DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getName();
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
  
  private DescriptorProtos.FieldDescriptorProto.Label label_ = DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
  
  public boolean hasLabel()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public DescriptorProtos.FieldDescriptorProto.Label getLabel()
  {
    return label_;
  }
  
  public Builder setLabel(DescriptorProtos.FieldDescriptorProto.Label value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x4;
    label_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearLabel()
  {
    bitField0_ &= 0xFFFFFFFB;
    label_ = DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
    onChanged();
    return this;
  }
  
  private DescriptorProtos.FieldDescriptorProto.Type type_ = DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE;
  
  public boolean hasType()
  {
    return (bitField0_ & 0x8) == 8;
  }
  
  public DescriptorProtos.FieldDescriptorProto.Type getType()
  {
    return type_;
  }
  
  public Builder setType(DescriptorProtos.FieldDescriptorProto.Type value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x8;
    type_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearType()
  {
    bitField0_ &= 0xFFFFFFF7;
    type_ = DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE;
    onChanged();
    return this;
  }
  
  private Object typeName_ = "";
  
  public boolean hasTypeName()
  {
    return (bitField0_ & 0x10) == 16;
  }
  
  public String getTypeName()
  {
    Object ref = typeName_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      typeName_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getTypeNameBytes()
  {
    Object ref = typeName_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      typeName_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setTypeName(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x10;
    typeName_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearTypeName()
  {
    bitField0_ &= 0xFFFFFFEF;
    typeName_ = DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getTypeName();
    onChanged();
    return this;
  }
  
  public Builder setTypeNameBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x10;
    typeName_ = value;
    onChanged();
    return this;
  }
  
  private Object extendee_ = "";
  
  public boolean hasExtendee()
  {
    return (bitField0_ & 0x20) == 32;
  }
  
  public String getExtendee()
  {
    Object ref = extendee_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      extendee_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getExtendeeBytes()
  {
    Object ref = extendee_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      extendee_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setExtendee(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x20;
    extendee_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearExtendee()
  {
    bitField0_ &= 0xFFFFFFDF;
    extendee_ = DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getExtendee();
    onChanged();
    return this;
  }
  
  public Builder setExtendeeBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x20;
    extendee_ = value;
    onChanged();
    return this;
  }
  
  private Object defaultValue_ = "";
  
  public boolean hasDefaultValue()
  {
    return (bitField0_ & 0x40) == 64;
  }
  
  public String getDefaultValue()
  {
    Object ref = defaultValue_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      defaultValue_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getDefaultValueBytes()
  {
    Object ref = defaultValue_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      defaultValue_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setDefaultValue(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x40;
    defaultValue_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearDefaultValue()
  {
    bitField0_ &= 0xFFFFFFBF;
    defaultValue_ = DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getDefaultValue();
    onChanged();
    return this;
  }
  
  public Builder setDefaultValueBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x40;
    defaultValue_ = value;
    onChanged();
    return this;
  }
  
  private DescriptorProtos.FieldOptions options_ = DescriptorProtos.FieldOptions.getDefaultInstance();
  private SingleFieldBuilder<DescriptorProtos.FieldOptions, DescriptorProtos.FieldOptions.Builder, DescriptorProtos.FieldOptionsOrBuilder> optionsBuilder_;
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x80) == 128;
  }
  
  public DescriptorProtos.FieldOptions getOptions()
  {
    if (optionsBuilder_ == null) {
      return options_;
    }
    return (DescriptorProtos.FieldOptions)optionsBuilder_.getMessage();
  }
  
  public Builder setOptions(DescriptorProtos.FieldOptions value)
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
    bitField0_ |= 0x80;
    return this;
  }
  
  public Builder setOptions(DescriptorProtos.FieldOptions.Builder builderForValue)
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
    bitField0_ |= 0x80;
    return this;
  }
  
  public Builder mergeOptions(DescriptorProtos.FieldOptions value)
  {
    if (optionsBuilder_ == null)
    {
      if (((bitField0_ & 0x80) == 128) && (options_ != DescriptorProtos.FieldOptions.getDefaultInstance())) {
        options_ = DescriptorProtos.FieldOptions.newBuilder(options_).mergeFrom(value).buildPartial();
      } else {
        options_ = value;
      }
      onChanged();
    }
    else
    {
      optionsBuilder_.mergeFrom(value);
    }
    bitField0_ |= 0x80;
    return this;
  }
  
  public Builder clearOptions()
  {
    if (optionsBuilder_ == null)
    {
      options_ = DescriptorProtos.FieldOptions.getDefaultInstance();
      onChanged();
    }
    else
    {
      optionsBuilder_.clear();
    }
    bitField0_ &= 0xFF7F;
    return this;
  }
  
  public DescriptorProtos.FieldOptions.Builder getOptionsBuilder()
  {
    bitField0_ |= 0x80;
    onChanged();
    return (DescriptorProtos.FieldOptions.Builder)getOptionsFieldBuilder().getBuilder();
  }
  
  public DescriptorProtos.FieldOptionsOrBuilder getOptionsOrBuilder()
  {
    if (optionsBuilder_ != null) {
      return (DescriptorProtos.FieldOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
    }
    return options_;
  }
  
  private SingleFieldBuilder<DescriptorProtos.FieldOptions, DescriptorProtos.FieldOptions.Builder, DescriptorProtos.FieldOptionsOrBuilder> getOptionsFieldBuilder()
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */