package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileOptions
  extends GeneratedMessage.ExtendableMessage<FileOptions>
  implements DescriptorProtos.FileOptionsOrBuilder
{
  private static final FileOptions defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$FileOptions(GeneratedMessage.ExtendableBuilder<FileOptions, ?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$FileOptions(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static FileOptions getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public FileOptions getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$FileOptions(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          javaPackage_ = input.readBytes();
          break;
        case 66: 
          bitField0_ |= 0x2;
          javaOuterClassname_ = input.readBytes();
          break;
        case 72: 
          int rawValue = input.readEnum();
          OptimizeMode value = OptimizeMode.valueOf(rawValue);
          if (value == null)
          {
            unknownFields.mergeVarintField(9, rawValue);
          }
          else
          {
            bitField0_ |= 0x10;
            optimizeFor_ = value;
          }
          break;
        case 80: 
          bitField0_ |= 0x4;
          javaMultipleFiles_ = input.readBool();
          break;
        case 90: 
          bitField0_ |= 0x20;
          goPackage_ = input.readBytes();
          break;
        case 128: 
          bitField0_ |= 0x40;
          ccGenericServices_ = input.readBool();
          break;
        case 136: 
          bitField0_ |= 0x80;
          javaGenericServices_ = input.readBool();
          break;
        case 144: 
          bitField0_ |= 0x100;
          pyGenericServices_ = input.readBool();
          break;
        case 160: 
          bitField0_ |= 0x8;
          javaGenerateEqualsAndHash_ = input.readBool();
          break;
        case 7994: 
          if ((mutable_bitField0_ & 0x200) != 512)
          {
            uninterpretedOption_ = new ArrayList();
            mutable_bitField0_ |= 0x200;
          }
          uninterpretedOption_.add(input.readMessage(DescriptorProtos.UninterpretedOption.PARSER, extensionRegistry));
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
      if ((mutable_bitField0_ & 0x200) == 512) {
        uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$10400();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$10500().ensureFieldAccessorsInitialized(FileOptions.class, Builder.class);
  }
  
  public static Parser<FileOptions> PARSER = new AbstractParser()
  {
    public DescriptorProtos.FileOptions parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.FileOptions(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
  private Object javaPackage_;
  public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
  private Object javaOuterClassname_;
  public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
  private boolean javaMultipleFiles_;
  public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
  private boolean javaGenerateEqualsAndHash_;
  public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
  private OptimizeMode optimizeFor_;
  public static final int GO_PACKAGE_FIELD_NUMBER = 11;
  private Object goPackage_;
  public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
  private boolean ccGenericServices_;
  public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
  private boolean javaGenericServices_;
  public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
  private boolean pyGenericServices_;
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  
  public Parser<FileOptions> getParserForType()
  {
    return PARSER;
  }
  
  public static enum OptimizeMode
    implements ProtocolMessageEnum
  {
    SPEED(0, 1),  CODE_SIZE(1, 2),  LITE_RUNTIME(2, 3);
    
    public static final int SPEED_VALUE = 1;
    public static final int CODE_SIZE_VALUE = 2;
    public static final int LITE_RUNTIME_VALUE = 3;
    
    public final int getNumber()
    {
      return value;
    }
    
    public static OptimizeMode valueOf(int value)
    {
      switch (value)
      {
      case 1: 
        return SPEED;
      case 2: 
        return CODE_SIZE;
      case 3: 
        return LITE_RUNTIME;
      }
      return null;
    }
    
    public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap()
    {
      return internalValueMap;
    }
    
    private static Internal.EnumLiteMap<OptimizeMode> internalValueMap = new Internal.EnumLiteMap()
    {
      public DescriptorProtos.FileOptions.OptimizeMode findValueByNumber(int number)
      {
        return DescriptorProtos.FileOptions.OptimizeMode.valueOf(number);
      }
    };
    
    public final Descriptors.EnumValueDescriptor getValueDescriptor()
    {
      return (Descriptors.EnumValueDescriptor)getDescriptor().getValues().get(index);
    }
    
    public final Descriptors.EnumDescriptor getDescriptorForType()
    {
      return getDescriptor();
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor()
    {
      return (Descriptors.EnumDescriptor)DescriptorProtos.FileOptions.getDescriptor().getEnumTypes().get(0);
    }
    
    private static final OptimizeMode[] VALUES = values();
    private final int index;
    private final int value;
    
    public static OptimizeMode valueOf(Descriptors.EnumValueDescriptor desc)
    {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }
    
    private OptimizeMode(int index, int value)
    {
      this.index = index;
      this.value = value;
    }
  }
  
  public boolean hasJavaPackage()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public String getJavaPackage()
  {
    Object ref = javaPackage_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      javaPackage_ = s;
    }
    return s;
  }
  
  public ByteString getJavaPackageBytes()
  {
    Object ref = javaPackage_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      javaPackage_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public boolean hasJavaOuterClassname()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public String getJavaOuterClassname()
  {
    Object ref = javaOuterClassname_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      javaOuterClassname_ = s;
    }
    return s;
  }
  
  public ByteString getJavaOuterClassnameBytes()
  {
    Object ref = javaOuterClassname_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      javaOuterClassname_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public boolean hasJavaMultipleFiles()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public boolean getJavaMultipleFiles()
  {
    return javaMultipleFiles_;
  }
  
  public boolean hasJavaGenerateEqualsAndHash()
  {
    return (bitField0_ & 0x8) == 8;
  }
  
  public boolean getJavaGenerateEqualsAndHash()
  {
    return javaGenerateEqualsAndHash_;
  }
  
  public boolean hasOptimizeFor()
  {
    return (bitField0_ & 0x10) == 16;
  }
  
  public OptimizeMode getOptimizeFor()
  {
    return optimizeFor_;
  }
  
  public boolean hasGoPackage()
  {
    return (bitField0_ & 0x20) == 32;
  }
  
  public String getGoPackage()
  {
    Object ref = goPackage_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      goPackage_ = s;
    }
    return s;
  }
  
  public ByteString getGoPackageBytes()
  {
    Object ref = goPackage_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      goPackage_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public boolean hasCcGenericServices()
  {
    return (bitField0_ & 0x40) == 64;
  }
  
  public boolean getCcGenericServices()
  {
    return ccGenericServices_;
  }
  
  public boolean hasJavaGenericServices()
  {
    return (bitField0_ & 0x80) == 128;
  }
  
  public boolean getJavaGenericServices()
  {
    return javaGenericServices_;
  }
  
  public boolean hasPyGenericServices()
  {
    return (bitField0_ & 0x100) == 256;
  }
  
  public boolean getPyGenericServices()
  {
    return pyGenericServices_;
  }
  
  public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
  {
    return uninterpretedOption_;
  }
  
  public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
  {
    return uninterpretedOption_;
  }
  
  public int getUninterpretedOptionCount()
  {
    return uninterpretedOption_.size();
  }
  
  public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
  {
    return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
  }
  
  public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
  {
    return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
  }
  
  private void initFields()
  {
    javaPackage_ = "";
    javaOuterClassname_ = "";
    javaMultipleFiles_ = false;
    javaGenerateEqualsAndHash_ = false;
    optimizeFor_ = OptimizeMode.SPEED;
    goPackage_ = "";
    ccGenericServices_ = false;
    javaGenericServices_ = false;
    pyGenericServices_ = false;
    uninterpretedOption_ = Collections.emptyList();
  }
  
  private byte memoizedIsInitialized = -1;
  
  public final boolean isInitialized()
  {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) {
      return isInitialized == 1;
    }
    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
      if (!getUninterpretedOption(i).isInitialized())
      {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    if (!extensionsAreInitialized())
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
    
    GeneratedMessage.ExtendableMessage<FileOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
    if ((bitField0_ & 0x1) == 1) {
      output.writeBytes(1, getJavaPackageBytes());
    }
    if ((bitField0_ & 0x2) == 2) {
      output.writeBytes(8, getJavaOuterClassnameBytes());
    }
    if ((bitField0_ & 0x10) == 16) {
      output.writeEnum(9, optimizeFor_.getNumber());
    }
    if ((bitField0_ & 0x4) == 4) {
      output.writeBool(10, javaMultipleFiles_);
    }
    if ((bitField0_ & 0x20) == 32) {
      output.writeBytes(11, getGoPackageBytes());
    }
    if ((bitField0_ & 0x40) == 64) {
      output.writeBool(16, ccGenericServices_);
    }
    if ((bitField0_ & 0x80) == 128) {
      output.writeBool(17, javaGenericServices_);
    }
    if ((bitField0_ & 0x100) == 256) {
      output.writeBool(18, pyGenericServices_);
    }
    if ((bitField0_ & 0x8) == 8) {
      output.writeBool(20, javaGenerateEqualsAndHash_);
    }
    for (int i = 0; i < uninterpretedOption_.size(); i++) {
      output.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
    }
    extensionWriter.writeUntil(536870912, output);
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
      size += CodedOutputStream.computeBytesSize(1, getJavaPackageBytes());
    }
    if ((bitField0_ & 0x2) == 2) {
      size += CodedOutputStream.computeBytesSize(8, getJavaOuterClassnameBytes());
    }
    if ((bitField0_ & 0x10) == 16) {
      size += CodedOutputStream.computeEnumSize(9, optimizeFor_.getNumber());
    }
    if ((bitField0_ & 0x4) == 4) {
      size += CodedOutputStream.computeBoolSize(10, javaMultipleFiles_);
    }
    if ((bitField0_ & 0x20) == 32) {
      size += CodedOutputStream.computeBytesSize(11, getGoPackageBytes());
    }
    if ((bitField0_ & 0x40) == 64) {
      size += CodedOutputStream.computeBoolSize(16, ccGenericServices_);
    }
    if ((bitField0_ & 0x80) == 128) {
      size += CodedOutputStream.computeBoolSize(17, javaGenericServices_);
    }
    if ((bitField0_ & 0x100) == 256) {
      size += CodedOutputStream.computeBoolSize(18, pyGenericServices_);
    }
    if ((bitField0_ & 0x8) == 8) {
      size += CodedOutputStream.computeBoolSize(20, javaGenerateEqualsAndHash_);
    }
    for (int i = 0; i < uninterpretedOption_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
    }
    size += extensionsSerializedSize();
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }
  
  protected Object writeReplace()
    throws ObjectStreamException
  {
    return super.writeReplace();
  }
  
  public static FileOptions parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (FileOptions)PARSER.parseFrom(data);
  }
  
  public static FileOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (FileOptions)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static FileOptions parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (FileOptions)PARSER.parseFrom(data);
  }
  
  public static FileOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (FileOptions)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static FileOptions parseFrom(InputStream input)
    throws IOException
  {
    return (FileOptions)PARSER.parseFrom(input);
  }
  
  public static FileOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FileOptions)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static FileOptions parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (FileOptions)PARSER.parseDelimitedFrom(input);
  }
  
  public static FileOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FileOptions)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static FileOptions parseFrom(CodedInputStream input)
    throws IOException
  {
    return (FileOptions)PARSER.parseFrom(input);
  }
  
  public static FileOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FileOptions)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$10700();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(FileOptions prototype)
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
    extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.FileOptions, Builder>
    implements DescriptorProtos.FileOptionsOrBuilder
  {
    private int bitField0_;
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.access$10400();
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.access$10500().ensureFieldAccessorsInitialized(DescriptorProtos.FileOptions.class, Builder.class);
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
        getUninterpretedOptionFieldBuilder();
      }
    }
    
    private static Builder create()
    {
      return new Builder();
    }
    
    public Builder clear()
    {
      super.clear();
      javaPackage_ = "";
      bitField0_ &= 0xFFFFFFFE;
      javaOuterClassname_ = "";
      bitField0_ &= 0xFFFFFFFD;
      javaMultipleFiles_ = false;
      bitField0_ &= 0xFFFFFFFB;
      javaGenerateEqualsAndHash_ = false;
      bitField0_ &= 0xFFFFFFF7;
      optimizeFor_ = DescriptorProtos.FileOptions.OptimizeMode.SPEED;
      bitField0_ &= 0xFFFFFFEF;
      goPackage_ = "";
      bitField0_ &= 0xFFFFFFDF;
      ccGenericServices_ = false;
      bitField0_ &= 0xFFFFFFBF;
      javaGenericServices_ = false;
      bitField0_ &= 0xFF7F;
      pyGenericServices_ = false;
      bitField0_ &= 0xFEFF;
      if (uninterpretedOptionBuilder_ == null)
      {
        uninterpretedOption_ = Collections.emptyList();
        bitField0_ &= 0xFDFF;
      }
      else
      {
        uninterpretedOptionBuilder_.clear();
      }
      return this;
    }
    
    public Builder clone()
    {
      return create().mergeFrom(buildPartial());
    }
    
    public Descriptors.Descriptor getDescriptorForType()
    {
      return DescriptorProtos.access$10400();
    }
    
    public DescriptorProtos.FileOptions getDefaultInstanceForType()
    {
      return DescriptorProtos.FileOptions.getDefaultInstance();
    }
    
    public DescriptorProtos.FileOptions build()
    {
      DescriptorProtos.FileOptions result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }
    
    public DescriptorProtos.FileOptions buildPartial()
    {
      DescriptorProtos.FileOptions result = new DescriptorProtos.FileOptions(this, null);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if ((from_bitField0_ & 0x1) == 1) {
        to_bitField0_ |= 0x1;
      }
      javaPackage_ = javaPackage_;
      if ((from_bitField0_ & 0x2) == 2) {
        to_bitField0_ |= 0x2;
      }
      javaOuterClassname_ = javaOuterClassname_;
      if ((from_bitField0_ & 0x4) == 4) {
        to_bitField0_ |= 0x4;
      }
      javaMultipleFiles_ = javaMultipleFiles_;
      if ((from_bitField0_ & 0x8) == 8) {
        to_bitField0_ |= 0x8;
      }
      javaGenerateEqualsAndHash_ = javaGenerateEqualsAndHash_;
      if ((from_bitField0_ & 0x10) == 16) {
        to_bitField0_ |= 0x10;
      }
      optimizeFor_ = optimizeFor_;
      if ((from_bitField0_ & 0x20) == 32) {
        to_bitField0_ |= 0x20;
      }
      goPackage_ = goPackage_;
      if ((from_bitField0_ & 0x40) == 64) {
        to_bitField0_ |= 0x40;
      }
      ccGenericServices_ = ccGenericServices_;
      if ((from_bitField0_ & 0x80) == 128) {
        to_bitField0_ |= 0x80;
      }
      javaGenericServices_ = javaGenericServices_;
      if ((from_bitField0_ & 0x100) == 256) {
        to_bitField0_ |= 0x100;
      }
      pyGenericServices_ = pyGenericServices_;
      if (uninterpretedOptionBuilder_ == null)
      {
        if ((bitField0_ & 0x200) == 512)
        {
          uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
          bitField0_ &= 0xFDFF;
        }
        uninterpretedOption_ = uninterpretedOption_;
      }
      else
      {
        uninterpretedOption_ = uninterpretedOptionBuilder_.build();
      }
      bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }
    
    public Builder mergeFrom(Message other)
    {
      if ((other instanceof DescriptorProtos.FileOptions)) {
        return mergeFrom((DescriptorProtos.FileOptions)other);
      }
      super.mergeFrom(other);
      return this;
    }
    
    public Builder mergeFrom(DescriptorProtos.FileOptions other)
    {
      if (other == DescriptorProtos.FileOptions.getDefaultInstance()) {
        return this;
      }
      if (other.hasJavaPackage())
      {
        bitField0_ |= 0x1;
        javaPackage_ = javaPackage_;
        onChanged();
      }
      if (other.hasJavaOuterClassname())
      {
        bitField0_ |= 0x2;
        javaOuterClassname_ = javaOuterClassname_;
        onChanged();
      }
      if (other.hasJavaMultipleFiles()) {
        setJavaMultipleFiles(other.getJavaMultipleFiles());
      }
      if (other.hasJavaGenerateEqualsAndHash()) {
        setJavaGenerateEqualsAndHash(other.getJavaGenerateEqualsAndHash());
      }
      if (other.hasOptimizeFor()) {
        setOptimizeFor(other.getOptimizeFor());
      }
      if (other.hasGoPackage())
      {
        bitField0_ |= 0x20;
        goPackage_ = goPackage_;
        onChanged();
      }
      if (other.hasCcGenericServices()) {
        setCcGenericServices(other.getCcGenericServices());
      }
      if (other.hasJavaGenericServices()) {
        setJavaGenericServices(other.getJavaGenericServices());
      }
      if (other.hasPyGenericServices()) {
        setPyGenericServices(other.getPyGenericServices());
      }
      if (uninterpretedOptionBuilder_ == null)
      {
        if (!uninterpretedOption_.isEmpty())
        {
          if (uninterpretedOption_.isEmpty())
          {
            uninterpretedOption_ = uninterpretedOption_;
            bitField0_ &= 0xFDFF;
          }
          else
          {
            ensureUninterpretedOptionIsMutable();
            uninterpretedOption_.addAll(uninterpretedOption_);
          }
          onChanged();
        }
      }
      else if (!uninterpretedOption_.isEmpty()) {
        if (uninterpretedOptionBuilder_.isEmpty())
        {
          uninterpretedOptionBuilder_.dispose();
          uninterpretedOptionBuilder_ = null;
          uninterpretedOption_ = uninterpretedOption_;
          bitField0_ &= 0xFDFF;
          uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
        }
        else
        {
          uninterpretedOptionBuilder_.addAllMessages(uninterpretedOption_);
        }
      }
      mergeExtensionFields(other);
      mergeUnknownFields(other.getUnknownFields());
      return this;
    }
    
    public final boolean isInitialized()
    {
      for (int i = 0; i < getUninterpretedOptionCount(); i++) {
        if (!getUninterpretedOption(i).isInitialized()) {
          return false;
        }
      }
      if (!extensionsAreInitialized()) {
        return false;
      }
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      DescriptorProtos.FileOptions parsedMessage = null;
      try
      {
        parsedMessage = (DescriptorProtos.FileOptions)DescriptorProtos.FileOptions.PARSER.parsePartialFrom(input, extensionRegistry);
      }
      catch (InvalidProtocolBufferException e)
      {
        parsedMessage = (DescriptorProtos.FileOptions)e.getUnfinishedMessage();
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
    
    private Object javaPackage_ = "";
    
    public boolean hasJavaPackage()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public String getJavaPackage()
    {
      Object ref = javaPackage_;
      if (!(ref instanceof String))
      {
        String s = ((ByteString)ref).toStringUtf8();
        
        javaPackage_ = s;
        return s;
      }
      return (String)ref;
    }
    
    public ByteString getJavaPackageBytes()
    {
      Object ref = javaPackage_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        javaPackage_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public Builder setJavaPackage(String value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x1;
      javaPackage_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearJavaPackage()
    {
      bitField0_ &= 0xFFFFFFFE;
      javaPackage_ = DescriptorProtos.FileOptions.getDefaultInstance().getJavaPackage();
      onChanged();
      return this;
    }
    
    public Builder setJavaPackageBytes(ByteString value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x1;
      javaPackage_ = value;
      onChanged();
      return this;
    }
    
    private Object javaOuterClassname_ = "";
    private boolean javaMultipleFiles_;
    private boolean javaGenerateEqualsAndHash_;
    
    public boolean hasJavaOuterClassname()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public String getJavaOuterClassname()
    {
      Object ref = javaOuterClassname_;
      if (!(ref instanceof String))
      {
        String s = ((ByteString)ref).toStringUtf8();
        
        javaOuterClassname_ = s;
        return s;
      }
      return (String)ref;
    }
    
    public ByteString getJavaOuterClassnameBytes()
    {
      Object ref = javaOuterClassname_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        javaOuterClassname_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public Builder setJavaOuterClassname(String value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x2;
      javaOuterClassname_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearJavaOuterClassname()
    {
      bitField0_ &= 0xFFFFFFFD;
      javaOuterClassname_ = DescriptorProtos.FileOptions.getDefaultInstance().getJavaOuterClassname();
      onChanged();
      return this;
    }
    
    public Builder setJavaOuterClassnameBytes(ByteString value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x2;
      javaOuterClassname_ = value;
      onChanged();
      return this;
    }
    
    public boolean hasJavaMultipleFiles()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public boolean getJavaMultipleFiles()
    {
      return javaMultipleFiles_;
    }
    
    public Builder setJavaMultipleFiles(boolean value)
    {
      bitField0_ |= 0x4;
      javaMultipleFiles_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearJavaMultipleFiles()
    {
      bitField0_ &= 0xFFFFFFFB;
      javaMultipleFiles_ = false;
      onChanged();
      return this;
    }
    
    public boolean hasJavaGenerateEqualsAndHash()
    {
      return (bitField0_ & 0x8) == 8;
    }
    
    public boolean getJavaGenerateEqualsAndHash()
    {
      return javaGenerateEqualsAndHash_;
    }
    
    public Builder setJavaGenerateEqualsAndHash(boolean value)
    {
      bitField0_ |= 0x8;
      javaGenerateEqualsAndHash_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearJavaGenerateEqualsAndHash()
    {
      bitField0_ &= 0xFFFFFFF7;
      javaGenerateEqualsAndHash_ = false;
      onChanged();
      return this;
    }
    
    private DescriptorProtos.FileOptions.OptimizeMode optimizeFor_ = DescriptorProtos.FileOptions.OptimizeMode.SPEED;
    
    public boolean hasOptimizeFor()
    {
      return (bitField0_ & 0x10) == 16;
    }
    
    public DescriptorProtos.FileOptions.OptimizeMode getOptimizeFor()
    {
      return optimizeFor_;
    }
    
    public Builder setOptimizeFor(DescriptorProtos.FileOptions.OptimizeMode value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x10;
      optimizeFor_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearOptimizeFor()
    {
      bitField0_ &= 0xFFFFFFEF;
      optimizeFor_ = DescriptorProtos.FileOptions.OptimizeMode.SPEED;
      onChanged();
      return this;
    }
    
    private Object goPackage_ = "";
    private boolean ccGenericServices_;
    private boolean javaGenericServices_;
    private boolean pyGenericServices_;
    
    public boolean hasGoPackage()
    {
      return (bitField0_ & 0x20) == 32;
    }
    
    public String getGoPackage()
    {
      Object ref = goPackage_;
      if (!(ref instanceof String))
      {
        String s = ((ByteString)ref).toStringUtf8();
        
        goPackage_ = s;
        return s;
      }
      return (String)ref;
    }
    
    public ByteString getGoPackageBytes()
    {
      Object ref = goPackage_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        goPackage_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public Builder setGoPackage(String value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x20;
      goPackage_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearGoPackage()
    {
      bitField0_ &= 0xFFFFFFDF;
      goPackage_ = DescriptorProtos.FileOptions.getDefaultInstance().getGoPackage();
      onChanged();
      return this;
    }
    
    public Builder setGoPackageBytes(ByteString value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x20;
      goPackage_ = value;
      onChanged();
      return this;
    }
    
    public boolean hasCcGenericServices()
    {
      return (bitField0_ & 0x40) == 64;
    }
    
    public boolean getCcGenericServices()
    {
      return ccGenericServices_;
    }
    
    public Builder setCcGenericServices(boolean value)
    {
      bitField0_ |= 0x40;
      ccGenericServices_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearCcGenericServices()
    {
      bitField0_ &= 0xFFFFFFBF;
      ccGenericServices_ = false;
      onChanged();
      return this;
    }
    
    public boolean hasJavaGenericServices()
    {
      return (bitField0_ & 0x80) == 128;
    }
    
    public boolean getJavaGenericServices()
    {
      return javaGenericServices_;
    }
    
    public Builder setJavaGenericServices(boolean value)
    {
      bitField0_ |= 0x80;
      javaGenericServices_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearJavaGenericServices()
    {
      bitField0_ &= 0xFF7F;
      javaGenericServices_ = false;
      onChanged();
      return this;
    }
    
    public boolean hasPyGenericServices()
    {
      return (bitField0_ & 0x100) == 256;
    }
    
    public boolean getPyGenericServices()
    {
      return pyGenericServices_;
    }
    
    public Builder setPyGenericServices(boolean value)
    {
      bitField0_ |= 0x100;
      pyGenericServices_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearPyGenericServices()
    {
      bitField0_ &= 0xFEFF;
      pyGenericServices_ = false;
      onChanged();
      return this;
    }
    
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
    private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
    
    private void ensureUninterpretedOptionIsMutable()
    {
      if ((bitField0_ & 0x200) != 512)
      {
        uninterpretedOption_ = new ArrayList(uninterpretedOption_);
        bitField0_ |= 0x200;
      }
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      if (uninterpretedOptionBuilder_ == null) {
        return Collections.unmodifiableList(uninterpretedOption_);
      }
      return uninterpretedOptionBuilder_.getMessageList();
    }
    
    public int getUninterpretedOptionCount()
    {
      if (uninterpretedOptionBuilder_ == null) {
        return uninterpretedOption_.size();
      }
      return uninterpretedOptionBuilder_.getCount();
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
    {
      if (uninterpretedOptionBuilder_ == null) {
        return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
      }
      return (DescriptorProtos.UninterpretedOption)uninterpretedOptionBuilder_.getMessage(index);
    }
    
    public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
    {
      if (uninterpretedOptionBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUninterpretedOptionIsMutable();
        uninterpretedOption_.set(index, value);
        onChanged();
      }
      else
      {
        uninterpretedOptionBuilder_.setMessage(index, value);
      }
      return this;
    }
    
    public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
    {
      if (uninterpretedOptionBuilder_ == null)
      {
        ensureUninterpretedOptionIsMutable();
        uninterpretedOption_.set(index, builderForValue.build());
        onChanged();
      }
      else
      {
        uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption value)
    {
      if (uninterpretedOptionBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUninterpretedOptionIsMutable();
        uninterpretedOption_.add(value);
        onChanged();
      }
      else
      {
        uninterpretedOptionBuilder_.addMessage(value);
      }
      return this;
    }
    
    public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
    {
      if (uninterpretedOptionBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUninterpretedOptionIsMutable();
        uninterpretedOption_.add(index, value);
        onChanged();
      }
      else
      {
        uninterpretedOptionBuilder_.addMessage(index, value);
      }
      return this;
    }
    
    public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder builderForValue)
    {
      if (uninterpretedOptionBuilder_ == null)
      {
        ensureUninterpretedOptionIsMutable();
        uninterpretedOption_.add(builderForValue.build());
        onChanged();
      }
      else
      {
        uninterpretedOptionBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    
    public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
    {
      if (uninterpretedOptionBuilder_ == null)
      {
        ensureUninterpretedOptionIsMutable();
        uninterpretedOption_.add(index, builderForValue.build());
        onChanged();
      }
      else
      {
        uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> values)
    {
      if (uninterpretedOptionBuilder_ == null)
      {
        ensureUninterpretedOptionIsMutable();
        GeneratedMessage.ExtendableBuilder.addAll(values, uninterpretedOption_);
        onChanged();
      }
      else
      {
        uninterpretedOptionBuilder_.addAllMessages(values);
      }
      return this;
    }
    
    public Builder clearUninterpretedOption()
    {
      if (uninterpretedOptionBuilder_ == null)
      {
        uninterpretedOption_ = Collections.emptyList();
        bitField0_ &= 0xFDFF;
        onChanged();
      }
      else
      {
        uninterpretedOptionBuilder_.clear();
      }
      return this;
    }
    
    public Builder removeUninterpretedOption(int index)
    {
      if (uninterpretedOptionBuilder_ == null)
      {
        ensureUninterpretedOptionIsMutable();
        uninterpretedOption_.remove(index);
        onChanged();
      }
      else
      {
        uninterpretedOptionBuilder_.remove(index);
      }
      return this;
    }
    
    public DescriptorProtos.UninterpretedOption.Builder getUninterpretedOptionBuilder(int index)
    {
      return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().getBuilder(index);
    }
    
    public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
    {
      if (uninterpretedOptionBuilder_ == null) {
        return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
      }
      return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOptionBuilder_.getMessageOrBuilder(index);
    }
    
    public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
    {
      if (uninterpretedOptionBuilder_ != null) {
        return uninterpretedOptionBuilder_.getMessageOrBuilderList();
      }
      return Collections.unmodifiableList(uninterpretedOption_);
    }
    
    public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder()
    {
      return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos.UninterpretedOption.getDefaultInstance());
    }
    
    public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder(int index)
    {
      return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(index, DescriptorProtos.UninterpretedOption.getDefaultInstance());
    }
    
    public List<DescriptorProtos.UninterpretedOption.Builder> getUninterpretedOptionBuilderList()
    {
      return getUninterpretedOptionFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder()
    {
      if (uninterpretedOptionBuilder_ == null)
      {
        uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x200) == 512, getParentForChildren(), isClean());
        
        uninterpretedOption_ = null;
      }
      return uninterpretedOptionBuilder_;
    }
  }
  
  static
  {
    defaultInstance = new FileOptions(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FileOptions
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */