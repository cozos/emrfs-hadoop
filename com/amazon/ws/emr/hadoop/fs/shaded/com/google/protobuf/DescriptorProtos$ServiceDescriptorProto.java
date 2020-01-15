package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$ServiceDescriptorProto
  extends GeneratedMessage
  implements DescriptorProtos.ServiceDescriptorProtoOrBuilder
{
  private static final ServiceDescriptorProto defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$ServiceDescriptorProto(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$ServiceDescriptorProto(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static ServiceDescriptorProto getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public ServiceDescriptorProto getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$ServiceDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          if ((mutable_bitField0_ & 0x2) != 2)
          {
            method_ = new ArrayList();
            mutable_bitField0_ |= 0x2;
          }
          method_.add(input.readMessage(DescriptorProtos.MethodDescriptorProto.PARSER, extensionRegistry));
          break;
        case 26: 
          DescriptorProtos.ServiceOptions.Builder subBuilder = null;
          if ((bitField0_ & 0x2) == 2) {
            subBuilder = options_.toBuilder();
          }
          options_ = ((DescriptorProtos.ServiceOptions)input.readMessage(DescriptorProtos.ServiceOptions.PARSER, extensionRegistry));
          if (subBuilder != null)
          {
            subBuilder.mergeFrom(options_);
            options_ = subBuilder.buildPartial();
          }
          bitField0_ |= 0x2;
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
      if ((mutable_bitField0_ & 0x2) == 2) {
        method_ = Collections.unmodifiableList(method_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$8300();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$8400().ensureFieldAccessorsInitialized(ServiceDescriptorProto.class, Builder.class);
  }
  
  public static Parser<ServiceDescriptorProto> PARSER = new AbstractParser()
  {
    public DescriptorProtos.ServiceDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.ServiceDescriptorProto(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  private Object name_;
  public static final int METHOD_FIELD_NUMBER = 2;
  private List<DescriptorProtos.MethodDescriptorProto> method_;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  private DescriptorProtos.ServiceOptions options_;
  
  public Parser<ServiceDescriptorProto> getParserForType()
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
  
  public List<DescriptorProtos.MethodDescriptorProto> getMethodList()
  {
    return method_;
  }
  
  public List<? extends DescriptorProtos.MethodDescriptorProtoOrBuilder> getMethodOrBuilderList()
  {
    return method_;
  }
  
  public int getMethodCount()
  {
    return method_.size();
  }
  
  public DescriptorProtos.MethodDescriptorProto getMethod(int index)
  {
    return (DescriptorProtos.MethodDescriptorProto)method_.get(index);
  }
  
  public DescriptorProtos.MethodDescriptorProtoOrBuilder getMethodOrBuilder(int index)
  {
    return (DescriptorProtos.MethodDescriptorProtoOrBuilder)method_.get(index);
  }
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public DescriptorProtos.ServiceOptions getOptions()
  {
    return options_;
  }
  
  public DescriptorProtos.ServiceOptionsOrBuilder getOptionsOrBuilder()
  {
    return options_;
  }
  
  private void initFields()
  {
    name_ = "";
    method_ = Collections.emptyList();
    options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
  }
  
  private byte memoizedIsInitialized = -1;
  
  public final boolean isInitialized()
  {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) {
      return isInitialized == 1;
    }
    for (int i = 0; i < getMethodCount(); i++) {
      if (!getMethod(i).isInitialized())
      {
        memoizedIsInitialized = 0;
        return false;
      }
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
    for (int i = 0; i < method_.size(); i++) {
      output.writeMessage(2, (MessageLite)method_.get(i));
    }
    if ((bitField0_ & 0x2) == 2) {
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
    for (int i = 0; i < method_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(2, (MessageLite)method_.get(i));
    }
    if ((bitField0_ & 0x2) == 2) {
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
  
  public static ServiceDescriptorProto parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static ServiceDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static ServiceDescriptorProto parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static ServiceDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static ServiceDescriptorProto parseFrom(InputStream input)
    throws IOException
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static ServiceDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static ServiceDescriptorProto parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (ServiceDescriptorProto)PARSER.parseDelimitedFrom(input);
  }
  
  public static ServiceDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (ServiceDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static ServiceDescriptorProto parseFrom(CodedInputStream input)
    throws IOException
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static ServiceDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (ServiceDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$8600();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(ServiceDescriptorProto prototype)
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
    implements DescriptorProtos.ServiceDescriptorProtoOrBuilder
  {
    private int bitField0_;
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.access$8300();
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.access$8400().ensureFieldAccessorsInitialized(DescriptorProtos.ServiceDescriptorProto.class, Builder.class);
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
      if (GeneratedMessage.alwaysUseFieldBuilders)
      {
        getMethodFieldBuilder();
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
      if (methodBuilder_ == null)
      {
        method_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFFD;
      }
      else
      {
        methodBuilder_.clear();
      }
      if (optionsBuilder_ == null) {
        options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
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
      return DescriptorProtos.access$8300();
    }
    
    public DescriptorProtos.ServiceDescriptorProto getDefaultInstanceForType()
    {
      return DescriptorProtos.ServiceDescriptorProto.getDefaultInstance();
    }
    
    public DescriptorProtos.ServiceDescriptorProto build()
    {
      DescriptorProtos.ServiceDescriptorProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }
    
    public DescriptorProtos.ServiceDescriptorProto buildPartial()
    {
      DescriptorProtos.ServiceDescriptorProto result = new DescriptorProtos.ServiceDescriptorProto(this, null);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if ((from_bitField0_ & 0x1) == 1) {
        to_bitField0_ |= 0x1;
      }
      name_ = name_;
      if (methodBuilder_ == null)
      {
        if ((bitField0_ & 0x2) == 2)
        {
          method_ = Collections.unmodifiableList(method_);
          bitField0_ &= 0xFFFFFFFD;
        }
        method_ = method_;
      }
      else
      {
        method_ = methodBuilder_.build();
      }
      if ((from_bitField0_ & 0x4) == 4) {
        to_bitField0_ |= 0x2;
      }
      if (optionsBuilder_ == null) {
        options_ = options_;
      } else {
        options_ = ((DescriptorProtos.ServiceOptions)optionsBuilder_.build());
      }
      bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }
    
    public Builder mergeFrom(Message other)
    {
      if ((other instanceof DescriptorProtos.ServiceDescriptorProto)) {
        return mergeFrom((DescriptorProtos.ServiceDescriptorProto)other);
      }
      super.mergeFrom(other);
      return this;
    }
    
    public Builder mergeFrom(DescriptorProtos.ServiceDescriptorProto other)
    {
      if (other == DescriptorProtos.ServiceDescriptorProto.getDefaultInstance()) {
        return this;
      }
      if (other.hasName())
      {
        bitField0_ |= 0x1;
        name_ = name_;
        onChanged();
      }
      if (methodBuilder_ == null)
      {
        if (!method_.isEmpty())
        {
          if (method_.isEmpty())
          {
            method_ = method_;
            bitField0_ &= 0xFFFFFFFD;
          }
          else
          {
            ensureMethodIsMutable();
            method_.addAll(method_);
          }
          onChanged();
        }
      }
      else if (!method_.isEmpty()) {
        if (methodBuilder_.isEmpty())
        {
          methodBuilder_.dispose();
          methodBuilder_ = null;
          method_ = method_;
          bitField0_ &= 0xFFFFFFFD;
          methodBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getMethodFieldBuilder() : null);
        }
        else
        {
          methodBuilder_.addAllMessages(method_);
        }
      }
      if (other.hasOptions()) {
        mergeOptions(other.getOptions());
      }
      mergeUnknownFields(other.getUnknownFields());
      return this;
    }
    
    public final boolean isInitialized()
    {
      for (int i = 0; i < getMethodCount(); i++) {
        if (!getMethod(i).isInitialized()) {
          return false;
        }
      }
      if ((hasOptions()) && 
        (!getOptions().isInitialized())) {
        return false;
      }
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      DescriptorProtos.ServiceDescriptorProto parsedMessage = null;
      try
      {
        parsedMessage = (DescriptorProtos.ServiceDescriptorProto)DescriptorProtos.ServiceDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
      }
      catch (InvalidProtocolBufferException e)
      {
        parsedMessage = (DescriptorProtos.ServiceDescriptorProto)e.getUnfinishedMessage();
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
      name_ = DescriptorProtos.ServiceDescriptorProto.getDefaultInstance().getName();
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
    
    private List<DescriptorProtos.MethodDescriptorProto> method_ = Collections.emptyList();
    private RepeatedFieldBuilder<DescriptorProtos.MethodDescriptorProto, DescriptorProtos.MethodDescriptorProto.Builder, DescriptorProtos.MethodDescriptorProtoOrBuilder> methodBuilder_;
    
    private void ensureMethodIsMutable()
    {
      if ((bitField0_ & 0x2) != 2)
      {
        method_ = new ArrayList(method_);
        bitField0_ |= 0x2;
      }
    }
    
    public List<DescriptorProtos.MethodDescriptorProto> getMethodList()
    {
      if (methodBuilder_ == null) {
        return Collections.unmodifiableList(method_);
      }
      return methodBuilder_.getMessageList();
    }
    
    public int getMethodCount()
    {
      if (methodBuilder_ == null) {
        return method_.size();
      }
      return methodBuilder_.getCount();
    }
    
    public DescriptorProtos.MethodDescriptorProto getMethod(int index)
    {
      if (methodBuilder_ == null) {
        return (DescriptorProtos.MethodDescriptorProto)method_.get(index);
      }
      return (DescriptorProtos.MethodDescriptorProto)methodBuilder_.getMessage(index);
    }
    
    public Builder setMethod(int index, DescriptorProtos.MethodDescriptorProto value)
    {
      if (methodBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMethodIsMutable();
        method_.set(index, value);
        onChanged();
      }
      else
      {
        methodBuilder_.setMessage(index, value);
      }
      return this;
    }
    
    public Builder setMethod(int index, DescriptorProtos.MethodDescriptorProto.Builder builderForValue)
    {
      if (methodBuilder_ == null)
      {
        ensureMethodIsMutable();
        method_.set(index, builderForValue.build());
        onChanged();
      }
      else
      {
        methodBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addMethod(DescriptorProtos.MethodDescriptorProto value)
    {
      if (methodBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMethodIsMutable();
        method_.add(value);
        onChanged();
      }
      else
      {
        methodBuilder_.addMessage(value);
      }
      return this;
    }
    
    public Builder addMethod(int index, DescriptorProtos.MethodDescriptorProto value)
    {
      if (methodBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMethodIsMutable();
        method_.add(index, value);
        onChanged();
      }
      else
      {
        methodBuilder_.addMessage(index, value);
      }
      return this;
    }
    
    public Builder addMethod(DescriptorProtos.MethodDescriptorProto.Builder builderForValue)
    {
      if (methodBuilder_ == null)
      {
        ensureMethodIsMutable();
        method_.add(builderForValue.build());
        onChanged();
      }
      else
      {
        methodBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    
    public Builder addMethod(int index, DescriptorProtos.MethodDescriptorProto.Builder builderForValue)
    {
      if (methodBuilder_ == null)
      {
        ensureMethodIsMutable();
        method_.add(index, builderForValue.build());
        onChanged();
      }
      else
      {
        methodBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addAllMethod(Iterable<? extends DescriptorProtos.MethodDescriptorProto> values)
    {
      if (methodBuilder_ == null)
      {
        ensureMethodIsMutable();
        GeneratedMessage.Builder.addAll(values, method_);
        onChanged();
      }
      else
      {
        methodBuilder_.addAllMessages(values);
      }
      return this;
    }
    
    public Builder clearMethod()
    {
      if (methodBuilder_ == null)
      {
        method_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFFD;
        onChanged();
      }
      else
      {
        methodBuilder_.clear();
      }
      return this;
    }
    
    public Builder removeMethod(int index)
    {
      if (methodBuilder_ == null)
      {
        ensureMethodIsMutable();
        method_.remove(index);
        onChanged();
      }
      else
      {
        methodBuilder_.remove(index);
      }
      return this;
    }
    
    public DescriptorProtos.MethodDescriptorProto.Builder getMethodBuilder(int index)
    {
      return (DescriptorProtos.MethodDescriptorProto.Builder)getMethodFieldBuilder().getBuilder(index);
    }
    
    public DescriptorProtos.MethodDescriptorProtoOrBuilder getMethodOrBuilder(int index)
    {
      if (methodBuilder_ == null) {
        return (DescriptorProtos.MethodDescriptorProtoOrBuilder)method_.get(index);
      }
      return (DescriptorProtos.MethodDescriptorProtoOrBuilder)methodBuilder_.getMessageOrBuilder(index);
    }
    
    public List<? extends DescriptorProtos.MethodDescriptorProtoOrBuilder> getMethodOrBuilderList()
    {
      if (methodBuilder_ != null) {
        return methodBuilder_.getMessageOrBuilderList();
      }
      return Collections.unmodifiableList(method_);
    }
    
    public DescriptorProtos.MethodDescriptorProto.Builder addMethodBuilder()
    {
      return (DescriptorProtos.MethodDescriptorProto.Builder)getMethodFieldBuilder().addBuilder(DescriptorProtos.MethodDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos.MethodDescriptorProto.Builder addMethodBuilder(int index)
    {
      return (DescriptorProtos.MethodDescriptorProto.Builder)getMethodFieldBuilder().addBuilder(index, DescriptorProtos.MethodDescriptorProto.getDefaultInstance());
    }
    
    public List<DescriptorProtos.MethodDescriptorProto.Builder> getMethodBuilderList()
    {
      return getMethodFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder<DescriptorProtos.MethodDescriptorProto, DescriptorProtos.MethodDescriptorProto.Builder, DescriptorProtos.MethodDescriptorProtoOrBuilder> getMethodFieldBuilder()
    {
      if (methodBuilder_ == null)
      {
        methodBuilder_ = new RepeatedFieldBuilder(method_, (bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
        
        method_ = null;
      }
      return methodBuilder_;
    }
    
    private DescriptorProtos.ServiceOptions options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
    private SingleFieldBuilder<DescriptorProtos.ServiceOptions, DescriptorProtos.ServiceOptions.Builder, DescriptorProtos.ServiceOptionsOrBuilder> optionsBuilder_;
    
    public boolean hasOptions()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public DescriptorProtos.ServiceOptions getOptions()
    {
      if (optionsBuilder_ == null) {
        return options_;
      }
      return (DescriptorProtos.ServiceOptions)optionsBuilder_.getMessage();
    }
    
    public Builder setOptions(DescriptorProtos.ServiceOptions value)
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
    
    public Builder setOptions(DescriptorProtos.ServiceOptions.Builder builderForValue)
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
    
    public Builder mergeOptions(DescriptorProtos.ServiceOptions value)
    {
      if (optionsBuilder_ == null)
      {
        if (((bitField0_ & 0x4) == 4) && (options_ != DescriptorProtos.ServiceOptions.getDefaultInstance())) {
          options_ = DescriptorProtos.ServiceOptions.newBuilder(options_).mergeFrom(value).buildPartial();
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
        options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
        onChanged();
      }
      else
      {
        optionsBuilder_.clear();
      }
      bitField0_ &= 0xFFFFFFFB;
      return this;
    }
    
    public DescriptorProtos.ServiceOptions.Builder getOptionsBuilder()
    {
      bitField0_ |= 0x4;
      onChanged();
      return (DescriptorProtos.ServiceOptions.Builder)getOptionsFieldBuilder().getBuilder();
    }
    
    public DescriptorProtos.ServiceOptionsOrBuilder getOptionsOrBuilder()
    {
      if (optionsBuilder_ != null) {
        return (DescriptorProtos.ServiceOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
      }
      return options_;
    }
    
    private SingleFieldBuilder<DescriptorProtos.ServiceOptions, DescriptorProtos.ServiceOptions.Builder, DescriptorProtos.ServiceOptionsOrBuilder> getOptionsFieldBuilder()
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
    defaultInstance = new ServiceDescriptorProto(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.ServiceDescriptorProto
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */