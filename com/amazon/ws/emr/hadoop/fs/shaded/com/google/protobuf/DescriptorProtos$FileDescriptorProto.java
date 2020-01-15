package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileDescriptorProto
  extends GeneratedMessage
  implements DescriptorProtos.FileDescriptorProtoOrBuilder
{
  private static final FileDescriptorProto defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$FileDescriptorProto(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$FileDescriptorProto(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static FileDescriptorProto getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public FileDescriptorProto getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$FileDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          package_ = input.readBytes();
          break;
        case 26: 
          if ((mutable_bitField0_ & 0x4) != 4)
          {
            dependency_ = new LazyStringArrayList();
            mutable_bitField0_ |= 0x4;
          }
          dependency_.add(input.readBytes());
          break;
        case 34: 
          if ((mutable_bitField0_ & 0x20) != 32)
          {
            messageType_ = new ArrayList();
            mutable_bitField0_ |= 0x20;
          }
          messageType_.add(input.readMessage(DescriptorProtos.DescriptorProto.PARSER, extensionRegistry));
          break;
        case 42: 
          if ((mutable_bitField0_ & 0x40) != 64)
          {
            enumType_ = new ArrayList();
            mutable_bitField0_ |= 0x40;
          }
          enumType_.add(input.readMessage(DescriptorProtos.EnumDescriptorProto.PARSER, extensionRegistry));
          break;
        case 50: 
          if ((mutable_bitField0_ & 0x80) != 128)
          {
            service_ = new ArrayList();
            mutable_bitField0_ |= 0x80;
          }
          service_.add(input.readMessage(DescriptorProtos.ServiceDescriptorProto.PARSER, extensionRegistry));
          break;
        case 58: 
          if ((mutable_bitField0_ & 0x100) != 256)
          {
            extension_ = new ArrayList();
            mutable_bitField0_ |= 0x100;
          }
          extension_.add(input.readMessage(DescriptorProtos.FieldDescriptorProto.PARSER, extensionRegistry));
          break;
        case 66: 
          DescriptorProtos.FileOptions.Builder subBuilder = null;
          if ((bitField0_ & 0x4) == 4) {
            subBuilder = options_.toBuilder();
          }
          options_ = ((DescriptorProtos.FileOptions)input.readMessage(DescriptorProtos.FileOptions.PARSER, extensionRegistry));
          if (subBuilder != null)
          {
            subBuilder.mergeFrom(options_);
            options_ = subBuilder.buildPartial();
          }
          bitField0_ |= 0x4;
          break;
        case 74: 
          DescriptorProtos.SourceCodeInfo.Builder subBuilder = null;
          if ((bitField0_ & 0x8) == 8) {
            subBuilder = sourceCodeInfo_.toBuilder();
          }
          sourceCodeInfo_ = ((DescriptorProtos.SourceCodeInfo)input.readMessage(DescriptorProtos.SourceCodeInfo.PARSER, extensionRegistry));
          if (subBuilder != null)
          {
            subBuilder.mergeFrom(sourceCodeInfo_);
            sourceCodeInfo_ = subBuilder.buildPartial();
          }
          bitField0_ |= 0x8;
          break;
        case 80: 
          if ((mutable_bitField0_ & 0x8) != 8)
          {
            publicDependency_ = new ArrayList();
            mutable_bitField0_ |= 0x8;
          }
          publicDependency_.add(Integer.valueOf(input.readInt32()));
          break;
        case 82: 
          int length = input.readRawVarint32();
          int limit = input.pushLimit(length);
          if (((mutable_bitField0_ & 0x8) != 8) && (input.getBytesUntilLimit() > 0))
          {
            publicDependency_ = new ArrayList();
            mutable_bitField0_ |= 0x8;
          }
          while (input.getBytesUntilLimit() > 0) {
            publicDependency_.add(Integer.valueOf(input.readInt32()));
          }
          input.popLimit(limit);
          break;
        case 88: 
          if ((mutable_bitField0_ & 0x10) != 16)
          {
            weakDependency_ = new ArrayList();
            mutable_bitField0_ |= 0x10;
          }
          weakDependency_.add(Integer.valueOf(input.readInt32()));
          break;
        case 90: 
          int length = input.readRawVarint32();
          int limit = input.pushLimit(length);
          if (((mutable_bitField0_ & 0x10) != 16) && (input.getBytesUntilLimit() > 0))
          {
            weakDependency_ = new ArrayList();
            mutable_bitField0_ |= 0x10;
          }
          while (input.getBytesUntilLimit() > 0) {
            weakDependency_.add(Integer.valueOf(input.readInt32()));
          }
          input.popLimit(limit);
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
      if ((mutable_bitField0_ & 0x4) == 4) {
        dependency_ = new UnmodifiableLazyStringList(dependency_);
      }
      if ((mutable_bitField0_ & 0x20) == 32) {
        messageType_ = Collections.unmodifiableList(messageType_);
      }
      if ((mutable_bitField0_ & 0x40) == 64) {
        enumType_ = Collections.unmodifiableList(enumType_);
      }
      if ((mutable_bitField0_ & 0x80) == 128) {
        service_ = Collections.unmodifiableList(service_);
      }
      if ((mutable_bitField0_ & 0x100) == 256) {
        extension_ = Collections.unmodifiableList(extension_);
      }
      if ((mutable_bitField0_ & 0x8) == 8) {
        publicDependency_ = Collections.unmodifiableList(publicDependency_);
      }
      if ((mutable_bitField0_ & 0x10) == 16) {
        weakDependency_ = Collections.unmodifiableList(weakDependency_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$700();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$800().ensureFieldAccessorsInitialized(FileDescriptorProto.class, Builder.class);
  }
  
  public static Parser<FileDescriptorProto> PARSER = new AbstractParser()
  {
    public DescriptorProtos.FileDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.FileDescriptorProto(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  private Object name_;
  public static final int PACKAGE_FIELD_NUMBER = 2;
  private Object package_;
  public static final int DEPENDENCY_FIELD_NUMBER = 3;
  private LazyStringList dependency_;
  public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
  private List<Integer> publicDependency_;
  public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
  private List<Integer> weakDependency_;
  public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
  private List<DescriptorProtos.DescriptorProto> messageType_;
  public static final int ENUM_TYPE_FIELD_NUMBER = 5;
  private List<DescriptorProtos.EnumDescriptorProto> enumType_;
  public static final int SERVICE_FIELD_NUMBER = 6;
  private List<DescriptorProtos.ServiceDescriptorProto> service_;
  public static final int EXTENSION_FIELD_NUMBER = 7;
  private List<DescriptorProtos.FieldDescriptorProto> extension_;
  public static final int OPTIONS_FIELD_NUMBER = 8;
  private DescriptorProtos.FileOptions options_;
  public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
  private DescriptorProtos.SourceCodeInfo sourceCodeInfo_;
  
  public Parser<FileDescriptorProto> getParserForType()
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
  
  public boolean hasPackage()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public String getPackage()
  {
    Object ref = package_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      package_ = s;
    }
    return s;
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
  
  public List<String> getDependencyList()
  {
    return dependency_;
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
  
  public List<Integer> getPublicDependencyList()
  {
    return publicDependency_;
  }
  
  public int getPublicDependencyCount()
  {
    return publicDependency_.size();
  }
  
  public int getPublicDependency(int index)
  {
    return ((Integer)publicDependency_.get(index)).intValue();
  }
  
  public List<Integer> getWeakDependencyList()
  {
    return weakDependency_;
  }
  
  public int getWeakDependencyCount()
  {
    return weakDependency_.size();
  }
  
  public int getWeakDependency(int index)
  {
    return ((Integer)weakDependency_.get(index)).intValue();
  }
  
  public List<DescriptorProtos.DescriptorProto> getMessageTypeList()
  {
    return messageType_;
  }
  
  public List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getMessageTypeOrBuilderList()
  {
    return messageType_;
  }
  
  public int getMessageTypeCount()
  {
    return messageType_.size();
  }
  
  public DescriptorProtos.DescriptorProto getMessageType(int index)
  {
    return (DescriptorProtos.DescriptorProto)messageType_.get(index);
  }
  
  public DescriptorProtos.DescriptorProtoOrBuilder getMessageTypeOrBuilder(int index)
  {
    return (DescriptorProtos.DescriptorProtoOrBuilder)messageType_.get(index);
  }
  
  public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
  {
    return enumType_;
  }
  
  public List<? extends DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList()
  {
    return enumType_;
  }
  
  public int getEnumTypeCount()
  {
    return enumType_.size();
  }
  
  public DescriptorProtos.EnumDescriptorProto getEnumType(int index)
  {
    return (DescriptorProtos.EnumDescriptorProto)enumType_.get(index);
  }
  
  public DescriptorProtos.EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index)
  {
    return (DescriptorProtos.EnumDescriptorProtoOrBuilder)enumType_.get(index);
  }
  
  public List<DescriptorProtos.ServiceDescriptorProto> getServiceList()
  {
    return service_;
  }
  
  public List<? extends DescriptorProtos.ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList()
  {
    return service_;
  }
  
  public int getServiceCount()
  {
    return service_.size();
  }
  
  public DescriptorProtos.ServiceDescriptorProto getService(int index)
  {
    return (DescriptorProtos.ServiceDescriptorProto)service_.get(index);
  }
  
  public DescriptorProtos.ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int index)
  {
    return (DescriptorProtos.ServiceDescriptorProtoOrBuilder)service_.get(index);
  }
  
  public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
  {
    return extension_;
  }
  
  public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList()
  {
    return extension_;
  }
  
  public int getExtensionCount()
  {
    return extension_.size();
  }
  
  public DescriptorProtos.FieldDescriptorProto getExtension(int index)
  {
    return (DescriptorProtos.FieldDescriptorProto)extension_.get(index);
  }
  
  public DescriptorProtos.FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index)
  {
    return (DescriptorProtos.FieldDescriptorProtoOrBuilder)extension_.get(index);
  }
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public DescriptorProtos.FileOptions getOptions()
  {
    return options_;
  }
  
  public DescriptorProtos.FileOptionsOrBuilder getOptionsOrBuilder()
  {
    return options_;
  }
  
  public boolean hasSourceCodeInfo()
  {
    return (bitField0_ & 0x8) == 8;
  }
  
  public DescriptorProtos.SourceCodeInfo getSourceCodeInfo()
  {
    return sourceCodeInfo_;
  }
  
  public DescriptorProtos.SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder()
  {
    return sourceCodeInfo_;
  }
  
  private void initFields()
  {
    name_ = "";
    package_ = "";
    dependency_ = LazyStringArrayList.EMPTY;
    publicDependency_ = Collections.emptyList();
    weakDependency_ = Collections.emptyList();
    messageType_ = Collections.emptyList();
    enumType_ = Collections.emptyList();
    service_ = Collections.emptyList();
    extension_ = Collections.emptyList();
    options_ = DescriptorProtos.FileOptions.getDefaultInstance();
    sourceCodeInfo_ = DescriptorProtos.SourceCodeInfo.getDefaultInstance();
  }
  
  private byte memoizedIsInitialized = -1;
  
  public final boolean isInitialized()
  {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) {
      return isInitialized == 1;
    }
    for (int i = 0; i < getMessageTypeCount(); i++) {
      if (!getMessageType(i).isInitialized())
      {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    for (int i = 0; i < getEnumTypeCount(); i++) {
      if (!getEnumType(i).isInitialized())
      {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    for (int i = 0; i < getServiceCount(); i++) {
      if (!getService(i).isInitialized())
      {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    for (int i = 0; i < getExtensionCount(); i++) {
      if (!getExtension(i).isInitialized())
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
    if ((bitField0_ & 0x2) == 2) {
      output.writeBytes(2, getPackageBytes());
    }
    for (int i = 0; i < dependency_.size(); i++) {
      output.writeBytes(3, dependency_.getByteString(i));
    }
    for (int i = 0; i < messageType_.size(); i++) {
      output.writeMessage(4, (MessageLite)messageType_.get(i));
    }
    for (int i = 0; i < enumType_.size(); i++) {
      output.writeMessage(5, (MessageLite)enumType_.get(i));
    }
    for (int i = 0; i < service_.size(); i++) {
      output.writeMessage(6, (MessageLite)service_.get(i));
    }
    for (int i = 0; i < extension_.size(); i++) {
      output.writeMessage(7, (MessageLite)extension_.get(i));
    }
    if ((bitField0_ & 0x4) == 4) {
      output.writeMessage(8, options_);
    }
    if ((bitField0_ & 0x8) == 8) {
      output.writeMessage(9, sourceCodeInfo_);
    }
    for (int i = 0; i < publicDependency_.size(); i++) {
      output.writeInt32(10, ((Integer)publicDependency_.get(i)).intValue());
    }
    for (int i = 0; i < weakDependency_.size(); i++) {
      output.writeInt32(11, ((Integer)weakDependency_.get(i)).intValue());
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
      size += CodedOutputStream.computeBytesSize(2, getPackageBytes());
    }
    int dataSize = 0;
    for (int i = 0; i < dependency_.size(); i++) {
      dataSize += CodedOutputStream.computeBytesSizeNoTag(dependency_.getByteString(i));
    }
    size += dataSize;
    size += 1 * getDependencyList().size();
    for (int i = 0; i < messageType_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(4, (MessageLite)messageType_.get(i));
    }
    for (int i = 0; i < enumType_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(5, (MessageLite)enumType_.get(i));
    }
    for (int i = 0; i < service_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(6, (MessageLite)service_.get(i));
    }
    for (int i = 0; i < extension_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(7, (MessageLite)extension_.get(i));
    }
    if ((bitField0_ & 0x4) == 4) {
      size += CodedOutputStream.computeMessageSize(8, options_);
    }
    if ((bitField0_ & 0x8) == 8) {
      size += CodedOutputStream.computeMessageSize(9, sourceCodeInfo_);
    }
    int dataSize = 0;
    for (int i = 0; i < publicDependency_.size(); i++) {
      dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)publicDependency_.get(i)).intValue());
    }
    size += dataSize;
    size += 1 * getPublicDependencyList().size();
    
    int dataSize = 0;
    for (int i = 0; i < weakDependency_.size(); i++) {
      dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)weakDependency_.get(i)).intValue());
    }
    size += dataSize;
    size += 1 * getWeakDependencyList().size();
    
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }
  
  protected Object writeReplace()
    throws ObjectStreamException
  {
    return super.writeReplace();
  }
  
  public static FileDescriptorProto parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (FileDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static FileDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (FileDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static FileDescriptorProto parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (FileDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static FileDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (FileDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static FileDescriptorProto parseFrom(InputStream input)
    throws IOException
  {
    return (FileDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static FileDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FileDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static FileDescriptorProto parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (FileDescriptorProto)PARSER.parseDelimitedFrom(input);
  }
  
  public static FileDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FileDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static FileDescriptorProto parseFrom(CodedInputStream input)
    throws IOException
  {
    return (FileDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static FileDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FileDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$1000();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(FileDescriptorProto prototype)
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
      name_ = name_;
      if ((from_bitField0_ & 0x2) == 2) {
        to_bitField0_ |= 0x2;
      }
      package_ = package_;
      if ((bitField0_ & 0x4) == 4)
      {
        dependency_ = new UnmodifiableLazyStringList(dependency_);
        
        bitField0_ &= 0xFFFFFFFB;
      }
      dependency_ = dependency_;
      if ((bitField0_ & 0x8) == 8)
      {
        publicDependency_ = Collections.unmodifiableList(publicDependency_);
        bitField0_ &= 0xFFFFFFF7;
      }
      publicDependency_ = publicDependency_;
      if ((bitField0_ & 0x10) == 16)
      {
        weakDependency_ = Collections.unmodifiableList(weakDependency_);
        bitField0_ &= 0xFFFFFFEF;
      }
      weakDependency_ = weakDependency_;
      if (messageTypeBuilder_ == null)
      {
        if ((bitField0_ & 0x20) == 32)
        {
          messageType_ = Collections.unmodifiableList(messageType_);
          bitField0_ &= 0xFFFFFFDF;
        }
        messageType_ = messageType_;
      }
      else
      {
        messageType_ = messageTypeBuilder_.build();
      }
      if (enumTypeBuilder_ == null)
      {
        if ((bitField0_ & 0x40) == 64)
        {
          enumType_ = Collections.unmodifiableList(enumType_);
          bitField0_ &= 0xFFFFFFBF;
        }
        enumType_ = enumType_;
      }
      else
      {
        enumType_ = enumTypeBuilder_.build();
      }
      if (serviceBuilder_ == null)
      {
        if ((bitField0_ & 0x80) == 128)
        {
          service_ = Collections.unmodifiableList(service_);
          bitField0_ &= 0xFF7F;
        }
        service_ = service_;
      }
      else
      {
        service_ = serviceBuilder_.build();
      }
      if (extensionBuilder_ == null)
      {
        if ((bitField0_ & 0x100) == 256)
        {
          extension_ = Collections.unmodifiableList(extension_);
          bitField0_ &= 0xFEFF;
        }
        extension_ = extension_;
      }
      else
      {
        extension_ = extensionBuilder_.build();
      }
      if ((from_bitField0_ & 0x200) == 512) {
        to_bitField0_ |= 0x4;
      }
      if (optionsBuilder_ == null) {
        options_ = options_;
      } else {
        options_ = ((DescriptorProtos.FileOptions)optionsBuilder_.build());
      }
      if ((from_bitField0_ & 0x400) == 1024) {
        to_bitField0_ |= 0x8;
      }
      if (sourceCodeInfoBuilder_ == null) {
        sourceCodeInfo_ = sourceCodeInfo_;
      } else {
        sourceCodeInfo_ = ((DescriptorProtos.SourceCodeInfo)sourceCodeInfoBuilder_.build());
      }
      bitField0_ = to_bitField0_;
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
        name_ = name_;
        onChanged();
      }
      if (other.hasPackage())
      {
        bitField0_ |= 0x2;
        package_ = package_;
        onChanged();
      }
      if (!dependency_.isEmpty())
      {
        if (dependency_.isEmpty())
        {
          dependency_ = dependency_;
          bitField0_ &= 0xFFFFFFFB;
        }
        else
        {
          ensureDependencyIsMutable();
          dependency_.addAll(dependency_);
        }
        onChanged();
      }
      if (!publicDependency_.isEmpty())
      {
        if (publicDependency_.isEmpty())
        {
          publicDependency_ = publicDependency_;
          bitField0_ &= 0xFFFFFFF7;
        }
        else
        {
          ensurePublicDependencyIsMutable();
          publicDependency_.addAll(publicDependency_);
        }
        onChanged();
      }
      if (!weakDependency_.isEmpty())
      {
        if (weakDependency_.isEmpty())
        {
          weakDependency_ = weakDependency_;
          bitField0_ &= 0xFFFFFFEF;
        }
        else
        {
          ensureWeakDependencyIsMutable();
          weakDependency_.addAll(weakDependency_);
        }
        onChanged();
      }
      if (messageTypeBuilder_ == null)
      {
        if (!messageType_.isEmpty())
        {
          if (messageType_.isEmpty())
          {
            messageType_ = messageType_;
            bitField0_ &= 0xFFFFFFDF;
          }
          else
          {
            ensureMessageTypeIsMutable();
            messageType_.addAll(messageType_);
          }
          onChanged();
        }
      }
      else if (!messageType_.isEmpty()) {
        if (messageTypeBuilder_.isEmpty())
        {
          messageTypeBuilder_.dispose();
          messageTypeBuilder_ = null;
          messageType_ = messageType_;
          bitField0_ &= 0xFFFFFFDF;
          messageTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getMessageTypeFieldBuilder() : null);
        }
        else
        {
          messageTypeBuilder_.addAllMessages(messageType_);
        }
      }
      if (enumTypeBuilder_ == null)
      {
        if (!enumType_.isEmpty())
        {
          if (enumType_.isEmpty())
          {
            enumType_ = enumType_;
            bitField0_ &= 0xFFFFFFBF;
          }
          else
          {
            ensureEnumTypeIsMutable();
            enumType_.addAll(enumType_);
          }
          onChanged();
        }
      }
      else if (!enumType_.isEmpty()) {
        if (enumTypeBuilder_.isEmpty())
        {
          enumTypeBuilder_.dispose();
          enumTypeBuilder_ = null;
          enumType_ = enumType_;
          bitField0_ &= 0xFFFFFFBF;
          enumTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getEnumTypeFieldBuilder() : null);
        }
        else
        {
          enumTypeBuilder_.addAllMessages(enumType_);
        }
      }
      if (serviceBuilder_ == null)
      {
        if (!service_.isEmpty())
        {
          if (service_.isEmpty())
          {
            service_ = service_;
            bitField0_ &= 0xFF7F;
          }
          else
          {
            ensureServiceIsMutable();
            service_.addAll(service_);
          }
          onChanged();
        }
      }
      else if (!service_.isEmpty()) {
        if (serviceBuilder_.isEmpty())
        {
          serviceBuilder_.dispose();
          serviceBuilder_ = null;
          service_ = service_;
          bitField0_ &= 0xFF7F;
          serviceBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getServiceFieldBuilder() : null);
        }
        else
        {
          serviceBuilder_.addAllMessages(service_);
        }
      }
      if (extensionBuilder_ == null)
      {
        if (!extension_.isEmpty())
        {
          if (extension_.isEmpty())
          {
            extension_ = extension_;
            bitField0_ &= 0xFEFF;
          }
          else
          {
            ensureExtensionIsMutable();
            extension_.addAll(extension_);
          }
          onChanged();
        }
      }
      else if (!extension_.isEmpty()) {
        if (extensionBuilder_.isEmpty())
        {
          extensionBuilder_.dispose();
          extensionBuilder_ = null;
          extension_ = extension_;
          bitField0_ &= 0xFEFF;
          extensionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getExtensionFieldBuilder() : null);
        }
        else
        {
          extensionBuilder_.addAllMessages(extension_);
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
  
  static
  {
    defaultInstance = new FileDescriptorProto(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FileDescriptorProto
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */