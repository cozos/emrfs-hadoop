package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FieldOptions
  extends GeneratedMessage.ExtendableMessage<FieldOptions>
  implements DescriptorProtos.FieldOptionsOrBuilder
{
  private static final FieldOptions defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$FieldOptions(GeneratedMessage.ExtendableBuilder<FieldOptions, ?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$FieldOptions(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static FieldOptions getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public FieldOptions getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$FieldOptions(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
        case 8: 
          int rawValue = input.readEnum();
          CType value = CType.valueOf(rawValue);
          if (value == null)
          {
            unknownFields.mergeVarintField(1, rawValue);
          }
          else
          {
            bitField0_ |= 0x1;
            ctype_ = value;
          }
          break;
        case 16: 
          bitField0_ |= 0x2;
          packed_ = input.readBool();
          break;
        case 24: 
          bitField0_ |= 0x8;
          deprecated_ = input.readBool();
          break;
        case 40: 
          bitField0_ |= 0x4;
          lazy_ = input.readBool();
          break;
        case 74: 
          bitField0_ |= 0x10;
          experimentalMapKey_ = input.readBytes();
          break;
        case 80: 
          bitField0_ |= 0x20;
          weak_ = input.readBool();
          break;
        case 7994: 
          if ((mutable_bitField0_ & 0x40) != 64)
          {
            uninterpretedOption_ = new ArrayList();
            mutable_bitField0_ |= 0x40;
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
      if ((mutable_bitField0_ & 0x40) == 64) {
        uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$13100();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$13200().ensureFieldAccessorsInitialized(FieldOptions.class, Builder.class);
  }
  
  public static Parser<FieldOptions> PARSER = new AbstractParser()
  {
    public DescriptorProtos.FieldOptions parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.FieldOptions(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int CTYPE_FIELD_NUMBER = 1;
  private CType ctype_;
  public static final int PACKED_FIELD_NUMBER = 2;
  private boolean packed_;
  public static final int LAZY_FIELD_NUMBER = 5;
  private boolean lazy_;
  public static final int DEPRECATED_FIELD_NUMBER = 3;
  private boolean deprecated_;
  public static final int EXPERIMENTAL_MAP_KEY_FIELD_NUMBER = 9;
  private Object experimentalMapKey_;
  public static final int WEAK_FIELD_NUMBER = 10;
  private boolean weak_;
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  
  public Parser<FieldOptions> getParserForType()
  {
    return PARSER;
  }
  
  public static enum CType
    implements ProtocolMessageEnum
  {
    STRING(0, 0),  CORD(1, 1),  STRING_PIECE(2, 2);
    
    public static final int STRING_VALUE = 0;
    public static final int CORD_VALUE = 1;
    public static final int STRING_PIECE_VALUE = 2;
    
    public final int getNumber()
    {
      return value;
    }
    
    public static CType valueOf(int value)
    {
      switch (value)
      {
      case 0: 
        return STRING;
      case 1: 
        return CORD;
      case 2: 
        return STRING_PIECE;
      }
      return null;
    }
    
    public static Internal.EnumLiteMap<CType> internalGetValueMap()
    {
      return internalValueMap;
    }
    
    private static Internal.EnumLiteMap<CType> internalValueMap = new Internal.EnumLiteMap()
    {
      public DescriptorProtos.FieldOptions.CType findValueByNumber(int number)
      {
        return DescriptorProtos.FieldOptions.CType.valueOf(number);
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
      return (Descriptors.EnumDescriptor)DescriptorProtos.FieldOptions.getDescriptor().getEnumTypes().get(0);
    }
    
    private static final CType[] VALUES = values();
    private final int index;
    private final int value;
    
    public static CType valueOf(Descriptors.EnumValueDescriptor desc)
    {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }
    
    private CType(int index, int value)
    {
      this.index = index;
      this.value = value;
    }
  }
  
  public boolean hasCtype()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public CType getCtype()
  {
    return ctype_;
  }
  
  public boolean hasPacked()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public boolean getPacked()
  {
    return packed_;
  }
  
  public boolean hasLazy()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public boolean getLazy()
  {
    return lazy_;
  }
  
  public boolean hasDeprecated()
  {
    return (bitField0_ & 0x8) == 8;
  }
  
  public boolean getDeprecated()
  {
    return deprecated_;
  }
  
  public boolean hasExperimentalMapKey()
  {
    return (bitField0_ & 0x10) == 16;
  }
  
  public String getExperimentalMapKey()
  {
    Object ref = experimentalMapKey_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      experimentalMapKey_ = s;
    }
    return s;
  }
  
  public ByteString getExperimentalMapKeyBytes()
  {
    Object ref = experimentalMapKey_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      experimentalMapKey_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public boolean hasWeak()
  {
    return (bitField0_ & 0x20) == 32;
  }
  
  public boolean getWeak()
  {
    return weak_;
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
    ctype_ = CType.STRING;
    packed_ = false;
    lazy_ = false;
    deprecated_ = false;
    experimentalMapKey_ = "";
    weak_ = false;
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
    
    GeneratedMessage.ExtendableMessage<FieldOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
    if ((bitField0_ & 0x1) == 1) {
      output.writeEnum(1, ctype_.getNumber());
    }
    if ((bitField0_ & 0x2) == 2) {
      output.writeBool(2, packed_);
    }
    if ((bitField0_ & 0x8) == 8) {
      output.writeBool(3, deprecated_);
    }
    if ((bitField0_ & 0x4) == 4) {
      output.writeBool(5, lazy_);
    }
    if ((bitField0_ & 0x10) == 16) {
      output.writeBytes(9, getExperimentalMapKeyBytes());
    }
    if ((bitField0_ & 0x20) == 32) {
      output.writeBool(10, weak_);
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
      size += CodedOutputStream.computeEnumSize(1, ctype_.getNumber());
    }
    if ((bitField0_ & 0x2) == 2) {
      size += CodedOutputStream.computeBoolSize(2, packed_);
    }
    if ((bitField0_ & 0x8) == 8) {
      size += CodedOutputStream.computeBoolSize(3, deprecated_);
    }
    if ((bitField0_ & 0x4) == 4) {
      size += CodedOutputStream.computeBoolSize(5, lazy_);
    }
    if ((bitField0_ & 0x10) == 16) {
      size += CodedOutputStream.computeBytesSize(9, getExperimentalMapKeyBytes());
    }
    if ((bitField0_ & 0x20) == 32) {
      size += CodedOutputStream.computeBoolSize(10, weak_);
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
  
  public static FieldOptions parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (FieldOptions)PARSER.parseFrom(data);
  }
  
  public static FieldOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (FieldOptions)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static FieldOptions parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (FieldOptions)PARSER.parseFrom(data);
  }
  
  public static FieldOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (FieldOptions)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static FieldOptions parseFrom(InputStream input)
    throws IOException
  {
    return (FieldOptions)PARSER.parseFrom(input);
  }
  
  public static FieldOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FieldOptions)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static FieldOptions parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (FieldOptions)PARSER.parseDelimitedFrom(input);
  }
  
  public static FieldOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FieldOptions)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static FieldOptions parseFrom(CodedInputStream input)
    throws IOException
  {
    return (FieldOptions)PARSER.parseFrom(input);
  }
  
  public static FieldOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FieldOptions)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$13400();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(FieldOptions prototype)
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
    extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.FieldOptions, Builder>
    implements DescriptorProtos.FieldOptionsOrBuilder
  {
    private int bitField0_;
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.access$13100();
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.access$13200().ensureFieldAccessorsInitialized(DescriptorProtos.FieldOptions.class, Builder.class);
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
      ctype_ = DescriptorProtos.FieldOptions.CType.STRING;
      bitField0_ &= 0xFFFFFFFE;
      packed_ = false;
      bitField0_ &= 0xFFFFFFFD;
      lazy_ = false;
      bitField0_ &= 0xFFFFFFFB;
      deprecated_ = false;
      bitField0_ &= 0xFFFFFFF7;
      experimentalMapKey_ = "";
      bitField0_ &= 0xFFFFFFEF;
      weak_ = false;
      bitField0_ &= 0xFFFFFFDF;
      if (uninterpretedOptionBuilder_ == null)
      {
        uninterpretedOption_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFBF;
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
      return DescriptorProtos.access$13100();
    }
    
    public DescriptorProtos.FieldOptions getDefaultInstanceForType()
    {
      return DescriptorProtos.FieldOptions.getDefaultInstance();
    }
    
    public DescriptorProtos.FieldOptions build()
    {
      DescriptorProtos.FieldOptions result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }
    
    public DescriptorProtos.FieldOptions buildPartial()
    {
      DescriptorProtos.FieldOptions result = new DescriptorProtos.FieldOptions(this, null);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if ((from_bitField0_ & 0x1) == 1) {
        to_bitField0_ |= 0x1;
      }
      ctype_ = ctype_;
      if ((from_bitField0_ & 0x2) == 2) {
        to_bitField0_ |= 0x2;
      }
      packed_ = packed_;
      if ((from_bitField0_ & 0x4) == 4) {
        to_bitField0_ |= 0x4;
      }
      lazy_ = lazy_;
      if ((from_bitField0_ & 0x8) == 8) {
        to_bitField0_ |= 0x8;
      }
      deprecated_ = deprecated_;
      if ((from_bitField0_ & 0x10) == 16) {
        to_bitField0_ |= 0x10;
      }
      experimentalMapKey_ = experimentalMapKey_;
      if ((from_bitField0_ & 0x20) == 32) {
        to_bitField0_ |= 0x20;
      }
      weak_ = weak_;
      if (uninterpretedOptionBuilder_ == null)
      {
        if ((bitField0_ & 0x40) == 64)
        {
          uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
          bitField0_ &= 0xFFFFFFBF;
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
      if ((other instanceof DescriptorProtos.FieldOptions)) {
        return mergeFrom((DescriptorProtos.FieldOptions)other);
      }
      super.mergeFrom(other);
      return this;
    }
    
    public Builder mergeFrom(DescriptorProtos.FieldOptions other)
    {
      if (other == DescriptorProtos.FieldOptions.getDefaultInstance()) {
        return this;
      }
      if (other.hasCtype()) {
        setCtype(other.getCtype());
      }
      if (other.hasPacked()) {
        setPacked(other.getPacked());
      }
      if (other.hasLazy()) {
        setLazy(other.getLazy());
      }
      if (other.hasDeprecated()) {
        setDeprecated(other.getDeprecated());
      }
      if (other.hasExperimentalMapKey())
      {
        bitField0_ |= 0x10;
        experimentalMapKey_ = experimentalMapKey_;
        onChanged();
      }
      if (other.hasWeak()) {
        setWeak(other.getWeak());
      }
      if (uninterpretedOptionBuilder_ == null)
      {
        if (!uninterpretedOption_.isEmpty())
        {
          if (uninterpretedOption_.isEmpty())
          {
            uninterpretedOption_ = uninterpretedOption_;
            bitField0_ &= 0xFFFFFFBF;
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
          bitField0_ &= 0xFFFFFFBF;
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
      DescriptorProtos.FieldOptions parsedMessage = null;
      try
      {
        parsedMessage = (DescriptorProtos.FieldOptions)DescriptorProtos.FieldOptions.PARSER.parsePartialFrom(input, extensionRegistry);
      }
      catch (InvalidProtocolBufferException e)
      {
        parsedMessage = (DescriptorProtos.FieldOptions)e.getUnfinishedMessage();
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
    
    private DescriptorProtos.FieldOptions.CType ctype_ = DescriptorProtos.FieldOptions.CType.STRING;
    private boolean packed_;
    private boolean lazy_;
    private boolean deprecated_;
    
    public boolean hasCtype()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public DescriptorProtos.FieldOptions.CType getCtype()
    {
      return ctype_;
    }
    
    public Builder setCtype(DescriptorProtos.FieldOptions.CType value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x1;
      ctype_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearCtype()
    {
      bitField0_ &= 0xFFFFFFFE;
      ctype_ = DescriptorProtos.FieldOptions.CType.STRING;
      onChanged();
      return this;
    }
    
    public boolean hasPacked()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public boolean getPacked()
    {
      return packed_;
    }
    
    public Builder setPacked(boolean value)
    {
      bitField0_ |= 0x2;
      packed_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearPacked()
    {
      bitField0_ &= 0xFFFFFFFD;
      packed_ = false;
      onChanged();
      return this;
    }
    
    public boolean hasLazy()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public boolean getLazy()
    {
      return lazy_;
    }
    
    public Builder setLazy(boolean value)
    {
      bitField0_ |= 0x4;
      lazy_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearLazy()
    {
      bitField0_ &= 0xFFFFFFFB;
      lazy_ = false;
      onChanged();
      return this;
    }
    
    public boolean hasDeprecated()
    {
      return (bitField0_ & 0x8) == 8;
    }
    
    public boolean getDeprecated()
    {
      return deprecated_;
    }
    
    public Builder setDeprecated(boolean value)
    {
      bitField0_ |= 0x8;
      deprecated_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearDeprecated()
    {
      bitField0_ &= 0xFFFFFFF7;
      deprecated_ = false;
      onChanged();
      return this;
    }
    
    private Object experimentalMapKey_ = "";
    private boolean weak_;
    
    public boolean hasExperimentalMapKey()
    {
      return (bitField0_ & 0x10) == 16;
    }
    
    public String getExperimentalMapKey()
    {
      Object ref = experimentalMapKey_;
      if (!(ref instanceof String))
      {
        String s = ((ByteString)ref).toStringUtf8();
        
        experimentalMapKey_ = s;
        return s;
      }
      return (String)ref;
    }
    
    public ByteString getExperimentalMapKeyBytes()
    {
      Object ref = experimentalMapKey_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        experimentalMapKey_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public Builder setExperimentalMapKey(String value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x10;
      experimentalMapKey_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearExperimentalMapKey()
    {
      bitField0_ &= 0xFFFFFFEF;
      experimentalMapKey_ = DescriptorProtos.FieldOptions.getDefaultInstance().getExperimentalMapKey();
      onChanged();
      return this;
    }
    
    public Builder setExperimentalMapKeyBytes(ByteString value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x10;
      experimentalMapKey_ = value;
      onChanged();
      return this;
    }
    
    public boolean hasWeak()
    {
      return (bitField0_ & 0x20) == 32;
    }
    
    public boolean getWeak()
    {
      return weak_;
    }
    
    public Builder setWeak(boolean value)
    {
      bitField0_ |= 0x20;
      weak_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearWeak()
    {
      bitField0_ &= 0xFFFFFFDF;
      weak_ = false;
      onChanged();
      return this;
    }
    
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
    private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
    
    private void ensureUninterpretedOptionIsMutable()
    {
      if ((bitField0_ & 0x40) != 64)
      {
        uninterpretedOption_ = new ArrayList(uninterpretedOption_);
        bitField0_ |= 0x40;
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
        bitField0_ &= 0xFFFFFFBF;
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
        uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x40) == 64, getParentForChildren(), isClean());
        
        uninterpretedOption_ = null;
      }
      return uninterpretedOptionBuilder_;
    }
  }
  
  static
  {
    defaultInstance = new FieldOptions(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FieldOptions
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */