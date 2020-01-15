package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileDescriptorProto$Builder
  extends GeneratedMessage.Builder<Builder>
  implements DescriptorProtos.FileDescriptorProtoOrBuilder
{
  private int bitField0_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$700();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$800().ensureFieldAccessorsInitialized(DescriptorProtos.FileDescriptorProto.class, Builder.class);
  }
  
  private DescriptorProtos$FileDescriptorProto$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$FileDescriptorProto$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
    maybeForceBuilderInitialization();
  }
  
  private void maybeForceBuilderInitialization()
  {
    if (GeneratedMessage.alwaysUseFieldBuilders)
    {
      getMessageTypeFieldBuilder();
      getEnumTypeFieldBuilder();
      getServiceFieldBuilder();
      getExtensionFieldBuilder();
      getOptionsFieldBuilder();
      getSourceCodeInfoFieldBuilder();
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
    package_ = "";
    bitField0_ &= 0xFFFFFFFD;
    dependency_ = LazyStringArrayList.EMPTY;
    bitField0_ &= 0xFFFFFFFB;
    publicDependency_ = Collections.emptyList();
    bitField0_ &= 0xFFFFFFF7;
    weakDependency_ = Collections.emptyList();
    bitField0_ &= 0xFFFFFFEF;
    if (messageTypeBuilder_ == null)
    {
      messageType_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFDF;
    }
    else
    {
      messageTypeBuilder_.clear();
    }
    if (enumTypeBuilder_ == null)
    {
      enumType_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFBF;
    }
    else
    {
      enumTypeBuilder_.clear();
    }
    if (serviceBuilder_ == null)
    {
      service_ = Collections.emptyList();
      bitField0_ &= 0xFF7F;
    }
    else
    {
      serviceBuilder_.clear();
    }
    if (extensionBuilder_ == null)
    {
      extension_ = Collections.emptyList();
      bitField0_ &= 0xFEFF;
    }
    else
    {
      extensionBuilder_.clear();
    }
    if (optionsBuilder_ == null) {
      options_ = DescriptorProtos.FileOptions.getDefaultInstance();
    } else {
      optionsBuilder_.clear();
    }
    bitField0_ &= 0xFDFF;
    if (sourceCodeInfoBuilder_ == null) {
      sourceCodeInfo_ = DescriptorProtos.SourceCodeInfo.getDefaultInstance();
    } else {
      sourceCodeInfoBuilder_.clear();
    }
    bitField0_ &= 0xFBFF;
    return this;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.access$700();
  }
  
  public DescriptorProtos.FileDescriptorProto getDefaultInstanceForType()
  {
    return DescriptorProtos.FileDescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.FileDescriptorProto build()
  {
    DescriptorProtos.FileDescriptorProto result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.FileDescriptorProto buildPartial()
  {
    DescriptorProtos.FileDescriptorProto result = new DescriptorProtos.FileDescriptorProto(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.FileDescriptorProto.access$1302(result, name_);
    if ((from_bitField0_ & 0x2) == 2) {
      to_bitField0_ |= 0x2;
    }
    DescriptorProtos.FileDescriptorProto.access$1402(result, package_);
    if ((bitField0_ & 0x4) == 4)
    {
      dependency_ = new UnmodifiableLazyStringList(dependency_);
      
      bitField0_ &= 0xFFFFFFFB;
    }
    DescriptorProtos.FileDescriptorProto.access$1502(result, dependency_);
    if ((bitField0_ & 0x8) == 8)
    {
      publicDependency_ = Collections.unmodifiableList(publicDependency_);
      bitField0_ &= 0xFFFFFFF7;
    }
    DescriptorProtos.FileDescriptorProto.access$1602(result, publicDependency_);
    if ((bitField0_ & 0x10) == 16)
    {
      weakDependency_ = Collections.unmodifiableList(weakDependency_);
      bitField0_ &= 0xFFFFFFEF;
    }
    DescriptorProtos.FileDescriptorProto.access$1702(result, weakDependency_);
    if (messageTypeBuilder_ == null)
    {
      if ((bitField0_ & 0x20) == 32)
      {
        messageType_ = Collections.unmodifiableList(messageType_);
        bitField0_ &= 0xFFFFFFDF;
      }
      DescriptorProtos.FileDescriptorProto.access$1802(result, messageType_);
    }
    else
    {
      DescriptorProtos.FileDescriptorProto.access$1802(result, messageTypeBuilder_.build());
    }
    if (enumTypeBuilder_ == null)
    {
      if ((bitField0_ & 0x40) == 64)
      {
        enumType_ = Collections.unmodifiableList(enumType_);
        bitField0_ &= 0xFFFFFFBF;
      }
      DescriptorProtos.FileDescriptorProto.access$1902(result, enumType_);
    }
    else
    {
      DescriptorProtos.FileDescriptorProto.access$1902(result, enumTypeBuilder_.build());
    }
    if (serviceBuilder_ == null)
    {
      if ((bitField0_ & 0x80) == 128)
      {
        service_ = Collections.unmodifiableList(service_);
        bitField0_ &= 0xFF7F;
      }
      DescriptorProtos.FileDescriptorProto.access$2002(result, service_);
    }
    else
    {
      DescriptorProtos.FileDescriptorProto.access$2002(result, serviceBuilder_.build());
    }
    if (extensionBuilder_ == null)
    {
      if ((bitField0_ & 0x100) == 256)
      {
        extension_ = Collections.unmodifiableList(extension_);
        bitField0_ &= 0xFEFF;
      }
      DescriptorProtos.FileDescriptorProto.access$2102(result, extension_);
    }
    else
    {
      DescriptorProtos.FileDescriptorProto.access$2102(result, extensionBuilder_.build());
    }
    if ((from_bitField0_ & 0x200) == 512) {
      to_bitField0_ |= 0x4;
    }
    if (optionsBuilder_ == null) {
      DescriptorProtos.FileDescriptorProto.access$2202(result, options_);
    } else {
      DescriptorProtos.FileDescriptorProto.access$2202(result, (DescriptorProtos.FileOptions)optionsBuilder_.build());
    }
    if ((from_bitField0_ & 0x400) == 1024) {
      to_bitField0_ |= 0x8;
    }
    if (sourceCodeInfoBuilder_ == null) {
      DescriptorProtos.FileDescriptorProto.access$2302(result, sourceCodeInfo_);
    } else {
      DescriptorProtos.FileDescriptorProto.access$2302(result, (DescriptorProtos.SourceCodeInfo)sourceCodeInfoBuilder_.build());
    }
    DescriptorProtos.FileDescriptorProto.access$2402(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.FileDescriptorProto)) {
      return mergeFrom((DescriptorProtos.FileDescriptorProto)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.FileDescriptorProto other)
  {
    if (other == DescriptorProtos.FileDescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (other.hasName())
    {
      bitField0_ |= 0x1;
      name_ = DescriptorProtos.FileDescriptorProto.access$1300(other);
      onChanged();
    }
    if (other.hasPackage())
    {
      bitField0_ |= 0x2;
      package_ = DescriptorProtos.FileDescriptorProto.access$1400(other);
      onChanged();
    }
    if (!DescriptorProtos.FileDescriptorProto.access$1500(other).isEmpty())
    {
      if (dependency_.isEmpty())
      {
        dependency_ = DescriptorProtos.FileDescriptorProto.access$1500(other);
        bitField0_ &= 0xFFFFFFFB;
      }
      else
      {
        ensureDependencyIsMutable();
        dependency_.addAll(DescriptorProtos.FileDescriptorProto.access$1500(other));
      }
      onChanged();
    }
    if (!DescriptorProtos.FileDescriptorProto.access$1600(other).isEmpty())
    {
      if (publicDependency_.isEmpty())
      {
        publicDependency_ = DescriptorProtos.FileDescriptorProto.access$1600(other);
        bitField0_ &= 0xFFFFFFF7;
      }
      else
      {
        ensurePublicDependencyIsMutable();
        publicDependency_.addAll(DescriptorProtos.FileDescriptorProto.access$1600(other));
      }
      onChanged();
    }
    if (!DescriptorProtos.FileDescriptorProto.access$1700(other).isEmpty())
    {
      if (weakDependency_.isEmpty())
      {
        weakDependency_ = DescriptorProtos.FileDescriptorProto.access$1700(other);
        bitField0_ &= 0xFFFFFFEF;
      }
      else
      {
        ensureWeakDependencyIsMutable();
        weakDependency_.addAll(DescriptorProtos.FileDescriptorProto.access$1700(other));
      }
      onChanged();
    }
    if (messageTypeBuilder_ == null)
    {
      if (!DescriptorProtos.FileDescriptorProto.access$1800(other).isEmpty())
      {
        if (messageType_.isEmpty())
        {
          messageType_ = DescriptorProtos.FileDescriptorProto.access$1800(other);
          bitField0_ &= 0xFFFFFFDF;
        }
        else
        {
          ensureMessageTypeIsMutable();
          messageType_.addAll(DescriptorProtos.FileDescriptorProto.access$1800(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileDescriptorProto.access$1800(other).isEmpty()) {
      if (messageTypeBuilder_.isEmpty())
      {
        messageTypeBuilder_.dispose();
        messageTypeBuilder_ = null;
        messageType_ = DescriptorProtos.FileDescriptorProto.access$1800(other);
        bitField0_ &= 0xFFFFFFDF;
        messageTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getMessageTypeFieldBuilder() : null);
      }
      else
      {
        messageTypeBuilder_.addAllMessages(DescriptorProtos.FileDescriptorProto.access$1800(other));
      }
    }
    if (enumTypeBuilder_ == null)
    {
      if (!DescriptorProtos.FileDescriptorProto.access$1900(other).isEmpty())
      {
        if (enumType_.isEmpty())
        {
          enumType_ = DescriptorProtos.FileDescriptorProto.access$1900(other);
          bitField0_ &= 0xFFFFFFBF;
        }
        else
        {
          ensureEnumTypeIsMutable();
          enumType_.addAll(DescriptorProtos.FileDescriptorProto.access$1900(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileDescriptorProto.access$1900(other).isEmpty()) {
      if (enumTypeBuilder_.isEmpty())
      {
        enumTypeBuilder_.dispose();
        enumTypeBuilder_ = null;
        enumType_ = DescriptorProtos.FileDescriptorProto.access$1900(other);
        bitField0_ &= 0xFFFFFFBF;
        enumTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getEnumTypeFieldBuilder() : null);
      }
      else
      {
        enumTypeBuilder_.addAllMessages(DescriptorProtos.FileDescriptorProto.access$1900(other));
      }
    }
    if (serviceBuilder_ == null)
    {
      if (!DescriptorProtos.FileDescriptorProto.access$2000(other).isEmpty())
      {
        if (service_.isEmpty())
        {
          service_ = DescriptorProtos.FileDescriptorProto.access$2000(other);
          bitField0_ &= 0xFF7F;
        }
        else
        {
          ensureServiceIsMutable();
          service_.addAll(DescriptorProtos.FileDescriptorProto.access$2000(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileDescriptorProto.access$2000(other).isEmpty()) {
      if (serviceBuilder_.isEmpty())
      {
        serviceBuilder_.dispose();
        serviceBuilder_ = null;
        service_ = DescriptorProtos.FileDescriptorProto.access$2000(other);
        bitField0_ &= 0xFF7F;
        serviceBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getServiceFieldBuilder() : null);
      }
      else
      {
        serviceBuilder_.addAllMessages(DescriptorProtos.FileDescriptorProto.access$2000(other));
      }
    }
    if (extensionBuilder_ == null)
    {
      if (!DescriptorProtos.FileDescriptorProto.access$2100(other).isEmpty())
      {
        if (extension_.isEmpty())
        {
          extension_ = DescriptorProtos.FileDescriptorProto.access$2100(other);
          bitField0_ &= 0xFEFF;
        }
        else
        {
          ensureExtensionIsMutable();
          extension_.addAll(DescriptorProtos.FileDescriptorProto.access$2100(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileDescriptorProto.access$2100(other).isEmpty()) {
      if (extensionBuilder_.isEmpty())
      {
        extensionBuilder_.dispose();
        extensionBuilder_ = null;
        extension_ = DescriptorProtos.FileDescriptorProto.access$2100(other);
        bitField0_ &= 0xFEFF;
        extensionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getExtensionFieldBuilder() : null);
      }
      else
      {
        extensionBuilder_.addAllMessages(DescriptorProtos.FileDescriptorProto.access$2100(other));
      }
    }
    if (other.hasOptions()) {
      mergeOptions(other.getOptions());
    }
    if (other.hasSourceCodeInfo()) {
      mergeSourceCodeInfo(other.getSourceCodeInfo());
    }
    mergeUnknownFields(other.getUnknownFields());
    return this;
  }
  
  public final boolean isInitialized()
  {
    for (int i = 0; i < getMessageTypeCount(); i++) {
      if (!getMessageType(i).isInitialized()) {
        return false;
      }
    }
    for (int i = 0; i < getEnumTypeCount(); i++) {
      if (!getEnumType(i).isInitialized()) {
        return false;
      }
    }
    for (int i = 0; i < getServiceCount(); i++) {
      if (!getService(i).isInitialized()) {
        return false;
      }
    }
    for (int i = 0; i < getExtensionCount(); i++) {
      if (!getExtension(i).isInitialized()) {
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
    DescriptorProtos.FileDescriptorProto parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.FileDescriptorProto)DescriptorProtos.FileDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.FileDescriptorProto)e.getUnfinishedMessage();
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
    name_ = DescriptorProtos.FileDescriptorProto.getDefaultInstance().getName();
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
  
  private Object package_ = "";
  
  public boolean hasPackage()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public String getPackage()
  {
    Object ref = package_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      package_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getPackageBytes()
  {
    Object ref = package_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      package_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setPackage(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x2;
    package_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearPackage()
  {
    bitField0_ &= 0xFFFFFFFD;
    package_ = DescriptorProtos.FileDescriptorProto.getDefaultInstance().getPackage();
    onChanged();
    return this;
  }
  
  public Builder setPackageBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x2;
    package_ = value;
    onChanged();
    return this;
  }
  
  private LazyStringList dependency_ = LazyStringArrayList.EMPTY;
  
  private void ensureDependencyIsMutable()
  {
    if ((bitField0_ & 0x4) != 4)
    {
      dependency_ = new LazyStringArrayList(dependency_);
      bitField0_ |= 0x4;
    }
  }
  
  public List<String> getDependencyList()
  {
    return Collections.unmodifiableList(dependency_);
  }
  
  public int getDependencyCount()
  {
    return dependency_.size();
  }
  
  public String getDependency(int index)
  {
    return (String)dependency_.get(index);
  }
  
  public ByteString getDependencyBytes(int index)
  {
    return dependency_.getByteString(index);
  }
  
  public Builder setDependency(int index, String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureDependencyIsMutable();
    dependency_.set(index, value);
    onChanged();
    return this;
  }
  
  public Builder addDependency(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureDependencyIsMutable();
    dependency_.add(value);
    onChanged();
    return this;
  }
  
  public Builder addAllDependency(Iterable<String> values)
  {
    ensureDependencyIsMutable();
    GeneratedMessage.Builder.addAll(values, dependency_);
    onChanged();
    return this;
  }
  
  public Builder clearDependency()
  {
    dependency_ = LazyStringArrayList.EMPTY;
    bitField0_ &= 0xFFFFFFFB;
    onChanged();
    return this;
  }
  
  public Builder addDependencyBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    ensureDependencyIsMutable();
    dependency_.add(value);
    onChanged();
    return this;
  }
  
  private List<Integer> publicDependency_ = Collections.emptyList();
  
  private void ensurePublicDependencyIsMutable()
  {
    if ((bitField0_ & 0x8) != 8)
    {
      publicDependency_ = new ArrayList(publicDependency_);
      bitField0_ |= 0x8;
    }
  }
  
  public List<Integer> getPublicDependencyList()
  {
    return Collections.unmodifiableList(publicDependency_);
  }
  
  public int getPublicDependencyCount()
  {
    return publicDependency_.size();
  }
  
  public int getPublicDependency(int index)
  {
    return ((Integer)publicDependency_.get(index)).intValue();
  }
  
  public Builder setPublicDependency(int index, int value)
  {
    ensurePublicDependencyIsMutable();
    publicDependency_.set(index, Integer.valueOf(value));
    onChanged();
    return this;
  }
  
  public Builder addPublicDependency(int value)
  {
    ensurePublicDependencyIsMutable();
    publicDependency_.add(Integer.valueOf(value));
    onChanged();
    return this;
  }
  
  public Builder addAllPublicDependency(Iterable<? extends Integer> values)
  {
    ensurePublicDependencyIsMutable();
    GeneratedMessage.Builder.addAll(values, publicDependency_);
    onChanged();
    return this;
  }
  
  public Builder clearPublicDependency()
  {
    publicDependency_ = Collections.emptyList();
    bitField0_ &= 0xFFFFFFF7;
    onChanged();
    return this;
  }
  
  private List<Integer> weakDependency_ = Collections.emptyList();
  
  private void ensureWeakDependencyIsMutable()
  {
    if ((bitField0_ & 0x10) != 16)
    {
      weakDependency_ = new ArrayList(weakDependency_);
      bitField0_ |= 0x10;
    }
  }
  
  public List<Integer> getWeakDependencyList()
  {
    return Collections.unmodifiableList(weakDependency_);
  }
  
  public int getWeakDependencyCount()
  {
    return weakDependency_.size();
  }
  
  public int getWeakDependency(int index)
  {
    return ((Integer)weakDependency_.get(index)).intValue();
  }
  
  public Builder setWeakDependency(int index, int value)
  {
    ensureWeakDependencyIsMutable();
    weakDependency_.set(index, Integer.valueOf(value));
    onChanged();
    return this;
  }
  
  public Builder addWeakDependency(int value)
  {
    ensureWeakDependencyIsMutable();
    weakDependency_.add(Integer.valueOf(value));
    onChanged();
    return this;
  }
  
  public Builder addAllWeakDependency(Iterable<? extends Integer> values)
  {
    ensureWeakDependencyIsMutable();
    GeneratedMessage.Builder.addAll(values, weakDependency_);
    onChanged();
    return this;
  }
  
  public Builder clearWeakDependency()
  {
    weakDependency_ = Collections.emptyList();
    bitField0_ &= 0xFFFFFFEF;
    onChanged();
    return this;
  }
  
  private List<DescriptorProtos.DescriptorProto> messageType_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto, DescriptorProtos.DescriptorProto.Builder, DescriptorProtos.DescriptorProtoOrBuilder> messageTypeBuilder_;
  
  private void ensureMessageTypeIsMutable()
  {
    if ((bitField0_ & 0x20) != 32)
    {
      messageType_ = new ArrayList(messageType_);
      bitField0_ |= 0x20;
    }
  }
  
  public List<DescriptorProtos.DescriptorProto> getMessageTypeList()
  {
    if (messageTypeBuilder_ == null) {
      return Collections.unmodifiableList(messageType_);
    }
    return messageTypeBuilder_.getMessageList();
  }
  
  public int getMessageTypeCount()
  {
    if (messageTypeBuilder_ == null) {
      return messageType_.size();
    }
    return messageTypeBuilder_.getCount();
  }
  
  public DescriptorProtos.DescriptorProto getMessageType(int index)
  {
    if (messageTypeBuilder_ == null) {
      return (DescriptorProtos.DescriptorProto)messageType_.get(index);
    }
    return (DescriptorProtos.DescriptorProto)messageTypeBuilder_.getMessage(index);
  }
  
  public Builder setMessageType(int index, DescriptorProtos.DescriptorProto value)
  {
    if (messageTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureMessageTypeIsMutable();
      messageType_.set(index, value);
      onChanged();
    }
    else
    {
      messageTypeBuilder_.setMessage(index, value);
    }
    return this;
  }
  
  public Builder setMessageType(int index, DescriptorProtos.DescriptorProto.Builder builderForValue)
  {
    if (messageTypeBuilder_ == null)
    {
      ensureMessageTypeIsMutable();
      messageType_.set(index, builderForValue.build());
      onChanged();
    }
    else
    {
      messageTypeBuilder_.setMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addMessageType(DescriptorProtos.DescriptorProto value)
  {
    if (messageTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureMessageTypeIsMutable();
      messageType_.add(value);
      onChanged();
    }
    else
    {
      messageTypeBuilder_.addMessage(value);
    }
    return this;
  }
  
  public Builder addMessageType(int index, DescriptorProtos.DescriptorProto value)
  {
    if (messageTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureMessageTypeIsMutable();
      messageType_.add(index, value);
      onChanged();
    }
    else
    {
      messageTypeBuilder_.addMessage(index, value);
    }
    return this;
  }
  
  public Builder addMessageType(DescriptorProtos.DescriptorProto.Builder builderForValue)
  {
    if (messageTypeBuilder_ == null)
    {
      ensureMessageTypeIsMutable();
      messageType_.add(builderForValue.build());
      onChanged();
    }
    else
    {
      messageTypeBuilder_.addMessage(builderForValue.build());
    }
    return this;
  }
  
  public Builder addMessageType(int index, DescriptorProtos.DescriptorProto.Builder builderForValue)
  {
    if (messageTypeBuilder_ == null)
    {
      ensureMessageTypeIsMutable();
      messageType_.add(index, builderForValue.build());
      onChanged();
    }
    else
    {
      messageTypeBuilder_.addMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addAllMessageType(Iterable<? extends DescriptorProtos.DescriptorProto> values)
  {
    if (messageTypeBuilder_ == null)
    {
      ensureMessageTypeIsMutable();
      GeneratedMessage.Builder.addAll(values, messageType_);
      onChanged();
    }
    else
    {
      messageTypeBuilder_.addAllMessages(values);
    }
    return this;
  }
  
  public Builder clearMessageType()
  {
    if (messageTypeBuilder_ == null)
    {
      messageType_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFDF;
      onChanged();
    }
    else
    {
      messageTypeBuilder_.clear();
    }
    return this;
  }
  
  public Builder removeMessageType(int index)
  {
    if (messageTypeBuilder_ == null)
    {
      ensureMessageTypeIsMutable();
      messageType_.remove(index);
      onChanged();
    }
    else
    {
      messageTypeBuilder_.remove(index);
    }
    return this;
  }
  
  public DescriptorProtos.DescriptorProto.Builder getMessageTypeBuilder(int index)
  {
    return (DescriptorProtos.DescriptorProto.Builder)getMessageTypeFieldBuilder().getBuilder(index);
  }
  
  public DescriptorProtos.DescriptorProtoOrBuilder getMessageTypeOrBuilder(int index)
  {
    if (messageTypeBuilder_ == null) {
      return (DescriptorProtos.DescriptorProtoOrBuilder)messageType_.get(index);
    }
    return (DescriptorProtos.DescriptorProtoOrBuilder)messageTypeBuilder_.getMessageOrBuilder(index);
  }
  
  public List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getMessageTypeOrBuilderList()
  {
    if (messageTypeBuilder_ != null) {
      return messageTypeBuilder_.getMessageOrBuilderList();
    }
    return Collections.unmodifiableList(messageType_);
  }
  
  public DescriptorProtos.DescriptorProto.Builder addMessageTypeBuilder()
  {
    return (DescriptorProtos.DescriptorProto.Builder)getMessageTypeFieldBuilder().addBuilder(DescriptorProtos.DescriptorProto.getDefaultInstance());
  }
  
  public DescriptorProtos.DescriptorProto.Builder addMessageTypeBuilder(int index)
  {
    return (DescriptorProtos.DescriptorProto.Builder)getMessageTypeFieldBuilder().addBuilder(index, DescriptorProtos.DescriptorProto.getDefaultInstance());
  }
  
  public List<DescriptorProtos.DescriptorProto.Builder> getMessageTypeBuilderList()
  {
    return getMessageTypeFieldBuilder().getBuilderList();
  }
  
  private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto, DescriptorProtos.DescriptorProto.Builder, DescriptorProtos.DescriptorProtoOrBuilder> getMessageTypeFieldBuilder()
  {
    if (messageTypeBuilder_ == null)
    {
      messageTypeBuilder_ = new RepeatedFieldBuilder(messageType_, (bitField0_ & 0x20) == 32, getParentForChildren(), isClean());
      
      messageType_ = null;
    }
    return messageTypeBuilder_;
  }
  
  private List<DescriptorProtos.EnumDescriptorProto> enumType_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> enumTypeBuilder_;
  
  private void ensureEnumTypeIsMutable()
  {
    if ((bitField0_ & 0x40) != 64)
    {
      enumType_ = new ArrayList(enumType_);
      bitField0_ |= 0x40;
    }
  }
  
  public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
  {
    if (enumTypeBuilder_ == null) {
      return Collections.unmodifiableList(enumType_);
    }
    return enumTypeBuilder_.getMessageList();
  }
  
  public int getEnumTypeCount()
  {
    if (enumTypeBuilder_ == null) {
      return enumType_.size();
    }
    return enumTypeBuilder_.getCount();
  }
  
  public DescriptorProtos.EnumDescriptorProto getEnumType(int index)
  {
    if (enumTypeBuilder_ == null) {
      return (DescriptorProtos.EnumDescriptorProto)enumType_.get(index);
    }
    return (DescriptorProtos.EnumDescriptorProto)enumTypeBuilder_.getMessage(index);
  }
  
  public Builder setEnumType(int index, DescriptorProtos.EnumDescriptorProto value)
  {
    if (enumTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureEnumTypeIsMutable();
      enumType_.set(index, value);
      onChanged();
    }
    else
    {
      enumTypeBuilder_.setMessage(index, value);
    }
    return this;
  }
  
  public Builder setEnumType(int index, DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
  {
    if (enumTypeBuilder_ == null)
    {
      ensureEnumTypeIsMutable();
      enumType_.set(index, builderForValue.build());
      onChanged();
    }
    else
    {
      enumTypeBuilder_.setMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addEnumType(DescriptorProtos.EnumDescriptorProto value)
  {
    if (enumTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureEnumTypeIsMutable();
      enumType_.add(value);
      onChanged();
    }
    else
    {
      enumTypeBuilder_.addMessage(value);
    }
    return this;
  }
  
  public Builder addEnumType(int index, DescriptorProtos.EnumDescriptorProto value)
  {
    if (enumTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureEnumTypeIsMutable();
      enumType_.add(index, value);
      onChanged();
    }
    else
    {
      enumTypeBuilder_.addMessage(index, value);
    }
    return this;
  }
  
  public Builder addEnumType(DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
  {
    if (enumTypeBuilder_ == null)
    {
      ensureEnumTypeIsMutable();
      enumType_.add(builderForValue.build());
      onChanged();
    }
    else
    {
      enumTypeBuilder_.addMessage(builderForValue.build());
    }
    return this;
  }
  
  public Builder addEnumType(int index, DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
  {
    if (enumTypeBuilder_ == null)
    {
      ensureEnumTypeIsMutable();
      enumType_.add(index, builderForValue.build());
      onChanged();
    }
    else
    {
      enumTypeBuilder_.addMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addAllEnumType(Iterable<? extends DescriptorProtos.EnumDescriptorProto> values)
  {
    if (enumTypeBuilder_ == null)
    {
      ensureEnumTypeIsMutable();
      GeneratedMessage.Builder.addAll(values, enumType_);
      onChanged();
    }
    else
    {
      enumTypeBuilder_.addAllMessages(values);
    }
    return this;
  }
  
  public Builder clearEnumType()
  {
    if (enumTypeBuilder_ == null)
    {
      enumType_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFBF;
      onChanged();
    }
    else
    {
      enumTypeBuilder_.clear();
    }
    return this;
  }
  
  public Builder removeEnumType(int index)
  {
    if (enumTypeBuilder_ == null)
    {
      ensureEnumTypeIsMutable();
      enumType_.remove(index);
      onChanged();
    }
    else
    {
      enumTypeBuilder_.remove(index);
    }
    return this;
  }
  
  public DescriptorProtos.EnumDescriptorProto.Builder getEnumTypeBuilder(int index)
  {
    return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().getBuilder(index);
  }
  
  public DescriptorProtos.EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index)
  {
    if (enumTypeBuilder_ == null) {
      return (DescriptorProtos.EnumDescriptorProtoOrBuilder)enumType_.get(index);
    }
    return (DescriptorProtos.EnumDescriptorProtoOrBuilder)enumTypeBuilder_.getMessageOrBuilder(index);
  }
  
  public List<? extends DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList()
  {
    if (enumTypeBuilder_ != null) {
      return enumTypeBuilder_.getMessageOrBuilderList();
    }
    return Collections.unmodifiableList(enumType_);
  }
  
  public DescriptorProtos.EnumDescriptorProto.Builder addEnumTypeBuilder()
  {
    return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().addBuilder(DescriptorProtos.EnumDescriptorProto.getDefaultInstance());
  }
  
  public DescriptorProtos.EnumDescriptorProto.Builder addEnumTypeBuilder(int index)
  {
    return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().addBuilder(index, DescriptorProtos.EnumDescriptorProto.getDefaultInstance());
  }
  
  public List<DescriptorProtos.EnumDescriptorProto.Builder> getEnumTypeBuilderList()
  {
    return getEnumTypeFieldBuilder().getBuilderList();
  }
  
  private RepeatedFieldBuilder<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeFieldBuilder()
  {
    if (enumTypeBuilder_ == null)
    {
      enumTypeBuilder_ = new RepeatedFieldBuilder(enumType_, (bitField0_ & 0x40) == 64, getParentForChildren(), isClean());
      
      enumType_ = null;
    }
    return enumTypeBuilder_;
  }
  
  private List<DescriptorProtos.ServiceDescriptorProto> service_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.ServiceDescriptorProto, DescriptorProtos.ServiceDescriptorProto.Builder, DescriptorProtos.ServiceDescriptorProtoOrBuilder> serviceBuilder_;
  
  private void ensureServiceIsMutable()
  {
    if ((bitField0_ & 0x80) != 128)
    {
      service_ = new ArrayList(service_);
      bitField0_ |= 0x80;
    }
  }
  
  public List<DescriptorProtos.ServiceDescriptorProto> getServiceList()
  {
    if (serviceBuilder_ == null) {
      return Collections.unmodifiableList(service_);
    }
    return serviceBuilder_.getMessageList();
  }
  
  public int getServiceCount()
  {
    if (serviceBuilder_ == null) {
      return service_.size();
    }
    return serviceBuilder_.getCount();
  }
  
  public DescriptorProtos.ServiceDescriptorProto getService(int index)
  {
    if (serviceBuilder_ == null) {
      return (DescriptorProtos.ServiceDescriptorProto)service_.get(index);
    }
    return (DescriptorProtos.ServiceDescriptorProto)serviceBuilder_.getMessage(index);
  }
  
  public Builder setService(int index, DescriptorProtos.ServiceDescriptorProto value)
  {
    if (serviceBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureServiceIsMutable();
      service_.set(index, value);
      onChanged();
    }
    else
    {
      serviceBuilder_.setMessage(index, value);
    }
    return this;
  }
  
  public Builder setService(int index, DescriptorProtos.ServiceDescriptorProto.Builder builderForValue)
  {
    if (serviceBuilder_ == null)
    {
      ensureServiceIsMutable();
      service_.set(index, builderForValue.build());
      onChanged();
    }
    else
    {
      serviceBuilder_.setMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addService(DescriptorProtos.ServiceDescriptorProto value)
  {
    if (serviceBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureServiceIsMutable();
      service_.add(value);
      onChanged();
    }
    else
    {
      serviceBuilder_.addMessage(value);
    }
    return this;
  }
  
  public Builder addService(int index, DescriptorProtos.ServiceDescriptorProto value)
  {
    if (serviceBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureServiceIsMutable();
      service_.add(index, value);
      onChanged();
    }
    else
    {
      serviceBuilder_.addMessage(index, value);
    }
    return this;
  }
  
  public Builder addService(DescriptorProtos.ServiceDescriptorProto.Builder builderForValue)
  {
    if (serviceBuilder_ == null)
    {
      ensureServiceIsMutable();
      service_.add(builderForValue.build());
      onChanged();
    }
    else
    {
      serviceBuilder_.addMessage(builderForValue.build());
    }
    return this;
  }
  
  public Builder addService(int index, DescriptorProtos.ServiceDescriptorProto.Builder builderForValue)
  {
    if (serviceBuilder_ == null)
    {
      ensureServiceIsMutable();
      service_.add(index, builderForValue.build());
      onChanged();
    }
    else
    {
      serviceBuilder_.addMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addAllService(Iterable<? extends DescriptorProtos.ServiceDescriptorProto> values)
  {
    if (serviceBuilder_ == null)
    {
      ensureServiceIsMutable();
      GeneratedMessage.Builder.addAll(values, service_);
      onChanged();
    }
    else
    {
      serviceBuilder_.addAllMessages(values);
    }
    return this;
  }
  
  public Builder clearService()
  {
    if (serviceBuilder_ == null)
    {
      service_ = Collections.emptyList();
      bitField0_ &= 0xFF7F;
      onChanged();
    }
    else
    {
      serviceBuilder_.clear();
    }
    return this;
  }
  
  public Builder removeService(int index)
  {
    if (serviceBuilder_ == null)
    {
      ensureServiceIsMutable();
      service_.remove(index);
      onChanged();
    }
    else
    {
      serviceBuilder_.remove(index);
    }
    return this;
  }
  
  public DescriptorProtos.ServiceDescriptorProto.Builder getServiceBuilder(int index)
  {
    return (DescriptorProtos.ServiceDescriptorProto.Builder)getServiceFieldBuilder().getBuilder(index);
  }
  
  public DescriptorProtos.ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int index)
  {
    if (serviceBuilder_ == null) {
      return (DescriptorProtos.ServiceDescriptorProtoOrBuilder)service_.get(index);
    }
    return (DescriptorProtos.ServiceDescriptorProtoOrBuilder)serviceBuilder_.getMessageOrBuilder(index);
  }
  
  public List<? extends DescriptorProtos.ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList()
  {
    if (serviceBuilder_ != null) {
      return serviceBuilder_.getMessageOrBuilderList();
    }
    return Collections.unmodifiableList(service_);
  }
  
  public DescriptorProtos.ServiceDescriptorProto.Builder addServiceBuilder()
  {
    return (DescriptorProtos.ServiceDescriptorProto.Builder)getServiceFieldBuilder().addBuilder(DescriptorProtos.ServiceDescriptorProto.getDefaultInstance());
  }
  
  public DescriptorProtos.ServiceDescriptorProto.Builder addServiceBuilder(int index)
  {
    return (DescriptorProtos.ServiceDescriptorProto.Builder)getServiceFieldBuilder().addBuilder(index, DescriptorProtos.ServiceDescriptorProto.getDefaultInstance());
  }
  
  public List<DescriptorProtos.ServiceDescriptorProto.Builder> getServiceBuilderList()
  {
    return getServiceFieldBuilder().getBuilderList();
  }
  
  private RepeatedFieldBuilder<DescriptorProtos.ServiceDescriptorProto, DescriptorProtos.ServiceDescriptorProto.Builder, DescriptorProtos.ServiceDescriptorProtoOrBuilder> getServiceFieldBuilder()
  {
    if (serviceBuilder_ == null)
    {
      serviceBuilder_ = new RepeatedFieldBuilder(service_, (bitField0_ & 0x80) == 128, getParentForChildren(), isClean());
      
      service_ = null;
    }
    return serviceBuilder_;
  }
  
  private List<DescriptorProtos.FieldDescriptorProto> extension_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> extensionBuilder_;
  
  private void ensureExtensionIsMutable()
  {
    if ((bitField0_ & 0x100) != 256)
    {
      extension_ = new ArrayList(extension_);
      bitField0_ |= 0x100;
    }
  }
  
  public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
  {
    if (extensionBuilder_ == null) {
      return Collections.unmodifiableList(extension_);
    }
    return extensionBuilder_.getMessageList();
  }
  
  public int getExtensionCount()
  {
    if (extensionBuilder_ == null) {
      return extension_.size();
    }
    return extensionBuilder_.getCount();
  }
  
  public DescriptorProtos.FieldDescriptorProto getExtension(int index)
  {
    if (extensionBuilder_ == null) {
      return (DescriptorProtos.FieldDescriptorProto)extension_.get(index);
    }
    return (DescriptorProtos.FieldDescriptorProto)extensionBuilder_.getMessage(index);
  }
  
  public Builder setExtension(int index, DescriptorProtos.FieldDescriptorProto value)
  {
    if (extensionBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureExtensionIsMutable();
      extension_.set(index, value);
      onChanged();
    }
    else
    {
      extensionBuilder_.setMessage(index, value);
    }
    return this;
  }
  
  public Builder setExtension(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
  {
    if (extensionBuilder_ == null)
    {
      ensureExtensionIsMutable();
      extension_.set(index, builderForValue.build());
      onChanged();
    }
    else
    {
      extensionBuilder_.setMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addExtension(DescriptorProtos.FieldDescriptorProto value)
  {
    if (extensionBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureExtensionIsMutable();
      extension_.add(value);
      onChanged();
    }
    else
    {
      extensionBuilder_.addMessage(value);
    }
    return this;
  }
  
  public Builder addExtension(int index, DescriptorProtos.FieldDescriptorProto value)
  {
    if (extensionBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureExtensionIsMutable();
      extension_.add(index, value);
      onChanged();
    }
    else
    {
      extensionBuilder_.addMessage(index, value);
    }
    return this;
  }
  
  public Builder addExtension(DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
  {
    if (extensionBuilder_ == null)
    {
      ensureExtensionIsMutable();
      extension_.add(builderForValue.build());
      onChanged();
    }
    else
    {
      extensionBuilder_.addMessage(builderForValue.build());
    }
    return this;
  }
  
  public Builder addExtension(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
  {
    if (extensionBuilder_ == null)
    {
      ensureExtensionIsMutable();
      extension_.add(index, builderForValue.build());
      onChanged();
    }
    else
    {
      extensionBuilder_.addMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addAllExtension(Iterable<? extends DescriptorProtos.FieldDescriptorProto> values)
  {
    if (extensionBuilder_ == null)
    {
      ensureExtensionIsMutable();
      GeneratedMessage.Builder.addAll(values, extension_);
      onChanged();
    }
    else
    {
      extensionBuilder_.addAllMessages(values);
    }
    return this;
  }
  
  public Builder clearExtension()
  {
    if (extensionBuilder_ == null)
    {
      extension_ = Collections.emptyList();
      bitField0_ &= 0xFEFF;
      onChanged();
    }
    else
    {
      extensionBuilder_.clear();
    }
    return this;
  }
  
  public Builder removeExtension(int index)
  {
    if (extensionBuilder_ == null)
    {
      ensureExtensionIsMutable();
      extension_.remove(index);
      onChanged();
    }
    else
    {
      extensionBuilder_.remove(index);
    }
    return this;
  }
  
  public DescriptorProtos.FieldDescriptorProto.Builder getExtensionBuilder(int index)
  {
    return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().getBuilder(index);
  }
  
  public DescriptorProtos.FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index)
  {
    if (extensionBuilder_ == null) {
      return (DescriptorProtos.FieldDescriptorProtoOrBuilder)extension_.get(index);
    }
    return (DescriptorProtos.FieldDescriptorProtoOrBuilder)extensionBuilder_.getMessageOrBuilder(index);
  }
  
  public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList()
  {
    if (extensionBuilder_ != null) {
      return extensionBuilder_.getMessageOrBuilderList();
    }
    return Collections.unmodifiableList(extension_);
  }
  
  public DescriptorProtos.FieldDescriptorProto.Builder addExtensionBuilder()
  {
    return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().addBuilder(DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
  }
  
  public DescriptorProtos.FieldDescriptorProto.Builder addExtensionBuilder(int index)
  {
    return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().addBuilder(index, DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
  }
  
  public List<DescriptorProtos.FieldDescriptorProto.Builder> getExtensionBuilderList()
  {
    return getExtensionFieldBuilder().getBuilderList();
  }
  
  private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionFieldBuilder()
  {
    if (extensionBuilder_ == null)
    {
      extensionBuilder_ = new RepeatedFieldBuilder(extension_, (bitField0_ & 0x100) == 256, getParentForChildren(), isClean());
      
      extension_ = null;
    }
    return extensionBuilder_;
  }
  
  private DescriptorProtos.FileOptions options_ = DescriptorProtos.FileOptions.getDefaultInstance();
  private SingleFieldBuilder<DescriptorProtos.FileOptions, DescriptorProtos.FileOptions.Builder, DescriptorProtos.FileOptionsOrBuilder> optionsBuilder_;
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x200) == 512;
  }
  
  public DescriptorProtos.FileOptions getOptions()
  {
    if (optionsBuilder_ == null) {
      return options_;
    }
    return (DescriptorProtos.FileOptions)optionsBuilder_.getMessage();
  }
  
  public Builder setOptions(DescriptorProtos.FileOptions value)
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
    bitField0_ |= 0x200;
    return this;
  }
  
  public Builder setOptions(DescriptorProtos.FileOptions.Builder builderForValue)
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
    bitField0_ |= 0x200;
    return this;
  }
  
  public Builder mergeOptions(DescriptorProtos.FileOptions value)
  {
    if (optionsBuilder_ == null)
    {
      if (((bitField0_ & 0x200) == 512) && (options_ != DescriptorProtos.FileOptions.getDefaultInstance())) {
        options_ = DescriptorProtos.FileOptions.newBuilder(options_).mergeFrom(value).buildPartial();
      } else {
        options_ = value;
      }
      onChanged();
    }
    else
    {
      optionsBuilder_.mergeFrom(value);
    }
    bitField0_ |= 0x200;
    return this;
  }
  
  public Builder clearOptions()
  {
    if (optionsBuilder_ == null)
    {
      options_ = DescriptorProtos.FileOptions.getDefaultInstance();
      onChanged();
    }
    else
    {
      optionsBuilder_.clear();
    }
    bitField0_ &= 0xFDFF;
    return this;
  }
  
  public DescriptorProtos.FileOptions.Builder getOptionsBuilder()
  {
    bitField0_ |= 0x200;
    onChanged();
    return (DescriptorProtos.FileOptions.Builder)getOptionsFieldBuilder().getBuilder();
  }
  
  public DescriptorProtos.FileOptionsOrBuilder getOptionsOrBuilder()
  {
    if (optionsBuilder_ != null) {
      return (DescriptorProtos.FileOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
    }
    return options_;
  }
  
  private SingleFieldBuilder<DescriptorProtos.FileOptions, DescriptorProtos.FileOptions.Builder, DescriptorProtos.FileOptionsOrBuilder> getOptionsFieldBuilder()
  {
    if (optionsBuilder_ == null)
    {
      optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
      
      options_ = null;
    }
    return optionsBuilder_;
  }
  
  private DescriptorProtos.SourceCodeInfo sourceCodeInfo_ = DescriptorProtos.SourceCodeInfo.getDefaultInstance();
  private SingleFieldBuilder<DescriptorProtos.SourceCodeInfo, DescriptorProtos.SourceCodeInfo.Builder, DescriptorProtos.SourceCodeInfoOrBuilder> sourceCodeInfoBuilder_;
  
  public boolean hasSourceCodeInfo()
  {
    return (bitField0_ & 0x400) == 1024;
  }
  
  public DescriptorProtos.SourceCodeInfo getSourceCodeInfo()
  {
    if (sourceCodeInfoBuilder_ == null) {
      return sourceCodeInfo_;
    }
    return (DescriptorProtos.SourceCodeInfo)sourceCodeInfoBuilder_.getMessage();
  }
  
  public Builder setSourceCodeInfo(DescriptorProtos.SourceCodeInfo value)
  {
    if (sourceCodeInfoBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      sourceCodeInfo_ = value;
      onChanged();
    }
    else
    {
      sourceCodeInfoBuilder_.setMessage(value);
    }
    bitField0_ |= 0x400;
    return this;
  }
  
  public Builder setSourceCodeInfo(DescriptorProtos.SourceCodeInfo.Builder builderForValue)
  {
    if (sourceCodeInfoBuilder_ == null)
    {
      sourceCodeInfo_ = builderForValue.build();
      onChanged();
    }
    else
    {
      sourceCodeInfoBuilder_.setMessage(builderForValue.build());
    }
    bitField0_ |= 0x400;
    return this;
  }
  
  public Builder mergeSourceCodeInfo(DescriptorProtos.SourceCodeInfo value)
  {
    if (sourceCodeInfoBuilder_ == null)
    {
      if (((bitField0_ & 0x400) == 1024) && (sourceCodeInfo_ != DescriptorProtos.SourceCodeInfo.getDefaultInstance())) {
        sourceCodeInfo_ = DescriptorProtos.SourceCodeInfo.newBuilder(sourceCodeInfo_).mergeFrom(value).buildPartial();
      } else {
        sourceCodeInfo_ = value;
      }
      onChanged();
    }
    else
    {
      sourceCodeInfoBuilder_.mergeFrom(value);
    }
    bitField0_ |= 0x400;
    return this;
  }
  
  public Builder clearSourceCodeInfo()
  {
    if (sourceCodeInfoBuilder_ == null)
    {
      sourceCodeInfo_ = DescriptorProtos.SourceCodeInfo.getDefaultInstance();
      onChanged();
    }
    else
    {
      sourceCodeInfoBuilder_.clear();
    }
    bitField0_ &= 0xFBFF;
    return this;
  }
  
  public DescriptorProtos.SourceCodeInfo.Builder getSourceCodeInfoBuilder()
  {
    bitField0_ |= 0x400;
    onChanged();
    return (DescriptorProtos.SourceCodeInfo.Builder)getSourceCodeInfoFieldBuilder().getBuilder();
  }
  
  public DescriptorProtos.SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder()
  {
    if (sourceCodeInfoBuilder_ != null) {
      return (DescriptorProtos.SourceCodeInfoOrBuilder)sourceCodeInfoBuilder_.getMessageOrBuilder();
    }
    return sourceCodeInfo_;
  }
  
  private SingleFieldBuilder<DescriptorProtos.SourceCodeInfo, DescriptorProtos.SourceCodeInfo.Builder, DescriptorProtos.SourceCodeInfoOrBuilder> getSourceCodeInfoFieldBuilder()
  {
    if (sourceCodeInfoBuilder_ == null)
    {
      sourceCodeInfoBuilder_ = new SingleFieldBuilder(sourceCodeInfo_, getParentForChildren(), isClean());
      
      sourceCodeInfo_ = null;
    }
    return sourceCodeInfoBuilder_;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */