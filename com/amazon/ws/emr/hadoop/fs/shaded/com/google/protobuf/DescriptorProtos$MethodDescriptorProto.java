package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

public final class DescriptorProtos$MethodDescriptorProto
  extends GeneratedMessage
  implements DescriptorProtos.MethodDescriptorProtoOrBuilder
{
  private static final MethodDescriptorProto defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$MethodDescriptorProto(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$MethodDescriptorProto(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static MethodDescriptorProto getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public MethodDescriptorProto getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$MethodDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
        case 18: 
          bitField0_ |= 0x2;
          inputType_ = input.readBytes();
          break;
        case 26: 
          bitField0_ |= 0x4;
          outputType_ = input.readBytes();
          break;
        case 34: 
          DescriptorProtos.MethodOptions.Builder subBuilder = null;
          if ((bitField0_ & 0x8) == 8) {
            subBuilder = options_.toBuilder();
          }
          options_ = ((DescriptorProtos.MethodOptions)input.readMessage(DescriptorProtos.MethodOptions.PARSER, extensionRegistry));
          if (subBuilder != null)
          {
            subBuilder.mergeFrom(options_);
            options_ = subBuilder.buildPartial();
          }
          bitField0_ |= 0x8;
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
    return DescriptorProtos.access$9300();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$9400().ensureFieldAccessorsInitialized(MethodDescriptorProto.class, Builder.class);
  }
  
  public static Parser<MethodDescriptorProto> PARSER = new AbstractParser()
  {
    public DescriptorProtos.MethodDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.MethodDescriptorProto(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  private Object name_;
  public static final int INPUT_TYPE_FIELD_NUMBER = 2;
  private Object inputType_;
  public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
  private Object outputType_;
  public static final int OPTIONS_FIELD_NUMBER = 4;
  private DescriptorProtos.MethodOptions options_;
  
  public Parser<MethodDescriptorProto> getParserForType()
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
  
  public boolean hasInputType()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public String getInputType()
  {
    Object ref = inputType_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      inputType_ = s;
    }
    return s;
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
  
  public boolean hasOutputType()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public String getOutputType()
  {
    Object ref = outputType_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      outputType_ = s;
    }
    return s;
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
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x8) == 8;
  }
  
  public DescriptorProtos.MethodOptions getOptions()
  {
    return options_;
  }
  
  public DescriptorProtos.MethodOptionsOrBuilder getOptionsOrBuilder()
  {
    return options_;
  }
  
  private void initFields()
  {
    name_ = "";
    inputType_ = "";
    outputType_ = "";
    options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
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
      output.writeBytes(2, getInputTypeBytes());
    }
    if ((bitField0_ & 0x4) == 4) {
      output.writeBytes(3, getOutputTypeBytes());
    }
    if ((bitField0_ & 0x8) == 8) {
      output.writeMessage(4, options_);
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
      size += CodedOutputStream.computeBytesSize(2, getInputTypeBytes());
    }
    if ((bitField0_ & 0x4) == 4) {
      size += CodedOutputStream.computeBytesSize(3, getOutputTypeBytes());
    }
    if ((bitField0_ & 0x8) == 8) {
      size += CodedOutputStream.computeMessageSize(4, options_);
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
  
  public static MethodDescriptorProto parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (MethodDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static MethodDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (MethodDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static MethodDescriptorProto parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (MethodDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static MethodDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (MethodDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static MethodDescriptorProto parseFrom(InputStream input)
    throws IOException
  {
    return (MethodDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static MethodDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (MethodDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static MethodDescriptorProto parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (MethodDescriptorProto)PARSER.parseDelimitedFrom(input);
  }
  
  public static MethodDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (MethodDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static MethodDescriptorProto parseFrom(CodedInputStream input)
    throws IOException
  {
    return (MethodDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static MethodDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (MethodDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$9600();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(MethodDescriptorProto prototype)
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
      name_ = name_;
      if ((from_bitField0_ & 0x2) == 2) {
        to_bitField0_ |= 0x2;
      }
      inputType_ = inputType_;
      if ((from_bitField0_ & 0x4) == 4) {
        to_bitField0_ |= 0x4;
      }
      outputType_ = outputType_;
      if ((from_bitField0_ & 0x8) == 8) {
        to_bitField0_ |= 0x8;
      }
      if (optionsBuilder_ == null) {
        options_ = options_;
      } else {
        options_ = ((DescriptorProtos.MethodOptions)optionsBuilder_.build());
      }
      bitField0_ = to_bitField0_;
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
        name_ = name_;
        onChanged();
      }
      if (other.hasInputType())
      {
        bitField0_ |= 0x2;
        inputType_ = inputType_;
        onChanged();
      }
      if (other.hasOutputType())
      {
        bitField0_ |= 0x4;
        outputType_ = outputType_;
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
  
  static
  {
    defaultInstance = new MethodDescriptorProto(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.MethodDescriptorProto
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */