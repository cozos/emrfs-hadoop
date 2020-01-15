package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$ServiceDescriptorProto$Builder
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
  
  private DescriptorProtos$ServiceDescriptorProto$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$ServiceDescriptorProto$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
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
    DescriptorProtos.ServiceDescriptorProto.access$8902(result, name_);
    if (methodBuilder_ == null)
    {
      if ((bitField0_ & 0x2) == 2)
      {
        method_ = Collections.unmodifiableList(method_);
        bitField0_ &= 0xFFFFFFFD;
      }
      DescriptorProtos.ServiceDescriptorProto.access$9002(result, method_);
    }
    else
    {
      DescriptorProtos.ServiceDescriptorProto.access$9002(result, methodBuilder_.build());
    }
    if ((from_bitField0_ & 0x4) == 4) {
      to_bitField0_ |= 0x2;
    }
    if (optionsBuilder_ == null) {
      DescriptorProtos.ServiceDescriptorProto.access$9102(result, options_);
    } else {
      DescriptorProtos.ServiceDescriptorProto.access$9102(result, (DescriptorProtos.ServiceOptions)optionsBuilder_.build());
    }
    DescriptorProtos.ServiceDescriptorProto.access$9202(result, to_bitField0_);
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
      name_ = DescriptorProtos.ServiceDescriptorProto.access$8900(other);
      onChanged();
    }
    if (methodBuilder_ == null)
    {
      if (!DescriptorProtos.ServiceDescriptorProto.access$9000(other).isEmpty())
      {
        if (method_.isEmpty())
        {
          method_ = DescriptorProtos.ServiceDescriptorProto.access$9000(other);
          bitField0_ &= 0xFFFFFFFD;
        }
        else
        {
          ensureMethodIsMutable();
          method_.addAll(DescriptorProtos.ServiceDescriptorProto.access$9000(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.ServiceDescriptorProto.access$9000(other).isEmpty()) {
      if (methodBuilder_.isEmpty())
      {
        methodBuilder_.dispose();
        methodBuilder_ = null;
        method_ = DescriptorProtos.ServiceDescriptorProto.access$9000(other);
        bitField0_ &= 0xFFFFFFFD;
        methodBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getMethodFieldBuilder() : null);
      }
      else
      {
        methodBuilder_.addAllMessages(DescriptorProtos.ServiceDescriptorProto.access$9000(other));
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.ServiceDescriptorProto.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */