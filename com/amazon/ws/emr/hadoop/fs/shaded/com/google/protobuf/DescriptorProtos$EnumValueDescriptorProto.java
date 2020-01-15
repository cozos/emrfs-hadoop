package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

public final class DescriptorProtos$EnumValueDescriptorProto
  extends GeneratedMessage
  implements DescriptorProtos.EnumValueDescriptorProtoOrBuilder
{
  private static final EnumValueDescriptorProto defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$EnumValueDescriptorProto(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$EnumValueDescriptorProto(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static EnumValueDescriptorProto getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public EnumValueDescriptorProto getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$EnumValueDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    initFields();
    int mutable_bitField0_ = 0;
    UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
    try
    {
      boolean done = false;
      while (!done)
      {
        int tag = input.readTag();
        switch (tag)
        {
        case 0: 
          done = true;
          break;
        default: 
          if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
            done = true;
          }
          break;
        case 10: 
          bitField0_ |= 0x1;
          name_ = input.readBytes();
          break;
        case 16: 
          bitField0_ |= 0x2;
          number_ = input.readInt32();
          break;
        case 26: 
          DescriptorProtos.EnumValueOptions.Builder subBuilder = null;
          if ((bitField0_ & 0x4) == 4) {
            subBuilder = options_.toBuilder();
          }
          options_ = ((DescriptorProtos.EnumValueOptions)input.readMessage(DescriptorProtos.EnumValueOptions.PARSER, extensionRegistry));
          if (subBuilder != null)
          {
            subBuilder.mergeFrom(options_);
            options_ = subBuilder.buildPartial();
          }
          bitField0_ |= 0x4;
        }
      }
    }
    catch (InvalidProtocolBufferException e)
    {
      throw e.setUnfinishedMessage(this);
    }
    catch (IOException e)
    {
      throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
    }
    finally
    {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$7300();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$7400().ensureFieldAccessorsInitialized(EnumValueDescriptorProto.class, Builder.class);
  }
  
  public static Parser<EnumValueDescriptorProto> PARSER = new AbstractParser()
  {
    public DescriptorProtos.EnumValueDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.EnumValueDescriptorProto(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  private Object name_;
  public static final int NUMBER_FIELD_NUMBER = 2;
  private int number_;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  private DescriptorProtos.EnumValueOptions options_;
  
  public Parser<EnumValueDescriptorProto> getParserForType()
  {
    return PARSER;
  }
  
  public boolean hasName()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public String getName()
  {
    Object ref = name_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      name_ = s;
    }
    return s;
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
  
  public boolean hasNumber()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public int getNumber()
  {
    return number_;
  }
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public DescriptorProtos.EnumValueOptions getOptions()
  {
    return options_;
  }
  
  public DescriptorProtos.EnumValueOptionsOrBuilder getOptionsOrBuilder()
  {
    return options_;
  }
  
  private void initFields()
  {
    name_ = "";
    number_ = 0;
    options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
  }
  
  private byte memoizedIsInitialized = -1;
  
  public final boolean isInitialized()
  {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) {
      return isInitialized == 1;
    }
    if ((hasOptions()) && 
      (!getOptions().isInitialized()))
    {
      memoizedIsInitialized = 0;
      return false;
    }
    memoizedIsInitialized = 1;
    return true;
  }
  
  public void writeTo(CodedOutputStream output)
    throws IOException
  {
    getSerializedSize();
    if ((bitField0_ & 0x1) == 1) {
      output.writeBytes(1, getNameBytes());
    }
    if ((bitField0_ & 0x2) == 2) {
      output.writeInt32(2, number_);
    }
    if ((bitField0_ & 0x4) == 4) {
      output.writeMessage(3, options_);
    }
    getUnknownFields().writeTo(output);
  }
  
  private int memoizedSerializedSize = -1;
  private static final long serialVersionUID = 0L;
  
  public int getSerializedSize()
  {
    int size = memoizedSerializedSize;
    if (size != -1) {
      return size;
    }
    size = 0;
    if ((bitField0_ & 0x1) == 1) {
      size += CodedOutputStream.computeBytesSize(1, getNameBytes());
    }
    if ((bitField0_ & 0x2) == 2) {
      size += CodedOutputStream.computeInt32Size(2, number_);
    }
    if ((bitField0_ & 0x4) == 4) {
      size += CodedOutputStream.computeMessageSize(3, options_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }
  
  protected Object writeReplace()
    throws ObjectStreamException
  {
    return super.writeReplace();
  }
  
  public static EnumValueDescriptorProto parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static EnumValueDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static EnumValueDescriptorProto parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static EnumValueDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static EnumValueDescriptorProto parseFrom(InputStream input)
    throws IOException
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static EnumValueDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (EnumValueDescriptorProto)PARSER.parseDelimitedFrom(input);
  }
  
  public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (EnumValueDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static EnumValueDescriptorProto parseFrom(CodedInputStream input)
    throws IOException
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static EnumValueDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (EnumValueDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$7600();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(EnumValueDescriptorProto prototype)
  {
    return newBuilder().mergeFrom(prototype);
  }
  
  public Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent)
  {
    Builder builder = new Builder(parent, null);
    return builder;
  }
  
  public static final class Builder
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
    
    private Builder()
    {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessage.BuilderParent parent)
    {
      super();
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
      name_ = name_;
      if ((from_bitField0_ & 0x2) == 2) {
        to_bitField0_ |= 0x2;
      }
      number_ = number_;
      if ((from_bitField0_ & 0x4) == 4) {
        to_bitField0_ |= 0x4;
      }
      if (optionsBuilder_ == null) {
        options_ = options_;
      } else {
        options_ = ((DescriptorProtos.EnumValueOptions)optionsBuilder_.build());
      }
      bitField0_ = to_bitField0_;
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
        name_ = name_;
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
  
  static
  {
    defaultInstance = new EnumValueDescriptorProto(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.EnumValueDescriptorProto
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */