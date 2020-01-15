package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$EnumDescriptorProto
  extends GeneratedMessage
  implements DescriptorProtos.EnumDescriptorProtoOrBuilder
{
  private static final EnumDescriptorProto defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$EnumDescriptorProto(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$EnumDescriptorProto(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static EnumDescriptorProto getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public EnumDescriptorProto getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$EnumDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
            value_ = new ArrayList();
            mutable_bitField0_ |= 0x2;
          }
          value_.add(input.readMessage(DescriptorProtos.EnumValueDescriptorProto.PARSER, extensionRegistry));
          break;
        case 26: 
          DescriptorProtos.EnumOptions.Builder subBuilder = null;
          if ((bitField0_ & 0x2) == 2) {
            subBuilder = options_.toBuilder();
          }
          options_ = ((DescriptorProtos.EnumOptions)input.readMessage(DescriptorProtos.EnumOptions.PARSER, extensionRegistry));
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
        value_ = Collections.unmodifiableList(value_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$6300();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$6400().ensureFieldAccessorsInitialized(EnumDescriptorProto.class, Builder.class);
  }
  
  public static Parser<EnumDescriptorProto> PARSER = new AbstractParser()
  {
    public DescriptorProtos.EnumDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.EnumDescriptorProto(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  private Object name_;
  public static final int VALUE_FIELD_NUMBER = 2;
  private List<DescriptorProtos.EnumValueDescriptorProto> value_;
  public static final int OPTIONS_FIELD_NUMBER = 3;
  private DescriptorProtos.EnumOptions options_;
  
  public Parser<EnumDescriptorProto> getParserForType()
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
  
  public List<DescriptorProtos.EnumValueDescriptorProto> getValueList()
  {
    return value_;
  }
  
  public List<? extends DescriptorProtos.EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList()
  {
    return value_;
  }
  
  public int getValueCount()
  {
    return value_.size();
  }
  
  public DescriptorProtos.EnumValueDescriptorProto getValue(int index)
  {
    return (DescriptorProtos.EnumValueDescriptorProto)value_.get(index);
  }
  
  public DescriptorProtos.EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int index)
  {
    return (DescriptorProtos.EnumValueDescriptorProtoOrBuilder)value_.get(index);
  }
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public DescriptorProtos.EnumOptions getOptions()
  {
    return options_;
  }
  
  public DescriptorProtos.EnumOptionsOrBuilder getOptionsOrBuilder()
  {
    return options_;
  }
  
  private void initFields()
  {
    name_ = "";
    value_ = Collections.emptyList();
    options_ = DescriptorProtos.EnumOptions.getDefaultInstance();
  }
  
  private byte memoizedIsInitialized = -1;
  
  public final boolean isInitialized()
  {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) {
      return isInitialized == 1;
    }
    for (int i = 0; i < getValueCount(); i++) {
      if (!getValue(i).isInitialized())
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
    for (int i = 0; i < value_.size(); i++) {
      output.writeMessage(2, (MessageLite)value_.get(i));
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
    for (int i = 0; i < value_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(2, (MessageLite)value_.get(i));
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
  
  public static EnumDescriptorProto parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (EnumDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static EnumDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (EnumDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static EnumDescriptorProto parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (EnumDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static EnumDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (EnumDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static EnumDescriptorProto parseFrom(InputStream input)
    throws IOException
  {
    return (EnumDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static EnumDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (EnumDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static EnumDescriptorProto parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (EnumDescriptorProto)PARSER.parseDelimitedFrom(input);
  }
  
  public static EnumDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (EnumDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static EnumDescriptorProto parseFrom(CodedInputStream input)
    throws IOException
  {
    return (EnumDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static EnumDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (EnumDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$6600();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(EnumDescriptorProto prototype)
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
    implements DescriptorProtos.EnumDescriptorProtoOrBuilder
  {
    private int bitField0_;
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.access$6300();
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.access$6400().ensureFieldAccessorsInitialized(DescriptorProtos.EnumDescriptorProto.class, Builder.class);
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
        getValueFieldBuilder();
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
      if (valueBuilder_ == null)
      {
        value_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFFD;
      }
      else
      {
        valueBuilder_.clear();
      }
      if (optionsBuilder_ == null) {
        options_ = DescriptorProtos.EnumOptions.getDefaultInstance();
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
      return DescriptorProtos.access$6300();
    }
    
    public DescriptorProtos.EnumDescriptorProto getDefaultInstanceForType()
    {
      return DescriptorProtos.EnumDescriptorProto.getDefaultInstance();
    }
    
    public DescriptorProtos.EnumDescriptorProto build()
    {
      DescriptorProtos.EnumDescriptorProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }
    
    public DescriptorProtos.EnumDescriptorProto buildPartial()
    {
      DescriptorProtos.EnumDescriptorProto result = new DescriptorProtos.EnumDescriptorProto(this, null);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if ((from_bitField0_ & 0x1) == 1) {
        to_bitField0_ |= 0x1;
      }
      name_ = name_;
      if (valueBuilder_ == null)
      {
        if ((bitField0_ & 0x2) == 2)
        {
          value_ = Collections.unmodifiableList(value_);
          bitField0_ &= 0xFFFFFFFD;
        }
        value_ = value_;
      }
      else
      {
        value_ = valueBuilder_.build();
      }
      if ((from_bitField0_ & 0x4) == 4) {
        to_bitField0_ |= 0x2;
      }
      if (optionsBuilder_ == null) {
        options_ = options_;
      } else {
        options_ = ((DescriptorProtos.EnumOptions)optionsBuilder_.build());
      }
      bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }
    
    public Builder mergeFrom(Message other)
    {
      if ((other instanceof DescriptorProtos.EnumDescriptorProto)) {
        return mergeFrom((DescriptorProtos.EnumDescriptorProto)other);
      }
      super.mergeFrom(other);
      return this;
    }
    
    public Builder mergeFrom(DescriptorProtos.EnumDescriptorProto other)
    {
      if (other == DescriptorProtos.EnumDescriptorProto.getDefaultInstance()) {
        return this;
      }
      if (other.hasName())
      {
        bitField0_ |= 0x1;
        name_ = name_;
        onChanged();
      }
      if (valueBuilder_ == null)
      {
        if (!value_.isEmpty())
        {
          if (value_.isEmpty())
          {
            value_ = value_;
            bitField0_ &= 0xFFFFFFFD;
          }
          else
          {
            ensureValueIsMutable();
            value_.addAll(value_);
          }
          onChanged();
        }
      }
      else if (!value_.isEmpty()) {
        if (valueBuilder_.isEmpty())
        {
          valueBuilder_.dispose();
          valueBuilder_ = null;
          value_ = value_;
          bitField0_ &= 0xFFFFFFFD;
          valueBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getValueFieldBuilder() : null);
        }
        else
        {
          valueBuilder_.addAllMessages(value_);
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
      for (int i = 0; i < getValueCount(); i++) {
        if (!getValue(i).isInitialized()) {
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
      DescriptorProtos.EnumDescriptorProto parsedMessage = null;
      try
      {
        parsedMessage = (DescriptorProtos.EnumDescriptorProto)DescriptorProtos.EnumDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
      }
      catch (InvalidProtocolBufferException e)
      {
        parsedMessage = (DescriptorProtos.EnumDescriptorProto)e.getUnfinishedMessage();
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
      name_ = DescriptorProtos.EnumDescriptorProto.getDefaultInstance().getName();
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
    
    private List<DescriptorProtos.EnumValueDescriptorProto> value_ = Collections.emptyList();
    private RepeatedFieldBuilder<DescriptorProtos.EnumValueDescriptorProto, DescriptorProtos.EnumValueDescriptorProto.Builder, DescriptorProtos.EnumValueDescriptorProtoOrBuilder> valueBuilder_;
    
    private void ensureValueIsMutable()
    {
      if ((bitField0_ & 0x2) != 2)
      {
        value_ = new ArrayList(value_);
        bitField0_ |= 0x2;
      }
    }
    
    public List<DescriptorProtos.EnumValueDescriptorProto> getValueList()
    {
      if (valueBuilder_ == null) {
        return Collections.unmodifiableList(value_);
      }
      return valueBuilder_.getMessageList();
    }
    
    public int getValueCount()
    {
      if (valueBuilder_ == null) {
        return value_.size();
      }
      return valueBuilder_.getCount();
    }
    
    public DescriptorProtos.EnumValueDescriptorProto getValue(int index)
    {
      if (valueBuilder_ == null) {
        return (DescriptorProtos.EnumValueDescriptorProto)value_.get(index);
      }
      return (DescriptorProtos.EnumValueDescriptorProto)valueBuilder_.getMessage(index);
    }
    
    public Builder setValue(int index, DescriptorProtos.EnumValueDescriptorProto value)
    {
      if (valueBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValueIsMutable();
        value_.set(index, value);
        onChanged();
      }
      else
      {
        valueBuilder_.setMessage(index, value);
      }
      return this;
    }
    
    public Builder setValue(int index, DescriptorProtos.EnumValueDescriptorProto.Builder builderForValue)
    {
      if (valueBuilder_ == null)
      {
        ensureValueIsMutable();
        value_.set(index, builderForValue.build());
        onChanged();
      }
      else
      {
        valueBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addValue(DescriptorProtos.EnumValueDescriptorProto value)
    {
      if (valueBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValueIsMutable();
        value_.add(value);
        onChanged();
      }
      else
      {
        valueBuilder_.addMessage(value);
      }
      return this;
    }
    
    public Builder addValue(int index, DescriptorProtos.EnumValueDescriptorProto value)
    {
      if (valueBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValueIsMutable();
        value_.add(index, value);
        onChanged();
      }
      else
      {
        valueBuilder_.addMessage(index, value);
      }
      return this;
    }
    
    public Builder addValue(DescriptorProtos.EnumValueDescriptorProto.Builder builderForValue)
    {
      if (valueBuilder_ == null)
      {
        ensureValueIsMutable();
        value_.add(builderForValue.build());
        onChanged();
      }
      else
      {
        valueBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    
    public Builder addValue(int index, DescriptorProtos.EnumValueDescriptorProto.Builder builderForValue)
    {
      if (valueBuilder_ == null)
      {
        ensureValueIsMutable();
        value_.add(index, builderForValue.build());
        onChanged();
      }
      else
      {
        valueBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addAllValue(Iterable<? extends DescriptorProtos.EnumValueDescriptorProto> values)
    {
      if (valueBuilder_ == null)
      {
        ensureValueIsMutable();
        GeneratedMessage.Builder.addAll(values, value_);
        onChanged();
      }
      else
      {
        valueBuilder_.addAllMessages(values);
      }
      return this;
    }
    
    public Builder clearValue()
    {
      if (valueBuilder_ == null)
      {
        value_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFFD;
        onChanged();
      }
      else
      {
        valueBuilder_.clear();
      }
      return this;
    }
    
    public Builder removeValue(int index)
    {
      if (valueBuilder_ == null)
      {
        ensureValueIsMutable();
        value_.remove(index);
        onChanged();
      }
      else
      {
        valueBuilder_.remove(index);
      }
      return this;
    }
    
    public DescriptorProtos.EnumValueDescriptorProto.Builder getValueBuilder(int index)
    {
      return (DescriptorProtos.EnumValueDescriptorProto.Builder)getValueFieldBuilder().getBuilder(index);
    }
    
    public DescriptorProtos.EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int index)
    {
      if (valueBuilder_ == null) {
        return (DescriptorProtos.EnumValueDescriptorProtoOrBuilder)value_.get(index);
      }
      return (DescriptorProtos.EnumValueDescriptorProtoOrBuilder)valueBuilder_.getMessageOrBuilder(index);
    }
    
    public List<? extends DescriptorProtos.EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList()
    {
      if (valueBuilder_ != null) {
        return valueBuilder_.getMessageOrBuilderList();
      }
      return Collections.unmodifiableList(value_);
    }
    
    public DescriptorProtos.EnumValueDescriptorProto.Builder addValueBuilder()
    {
      return (DescriptorProtos.EnumValueDescriptorProto.Builder)getValueFieldBuilder().addBuilder(DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos.EnumValueDescriptorProto.Builder addValueBuilder(int index)
    {
      return (DescriptorProtos.EnumValueDescriptorProto.Builder)getValueFieldBuilder().addBuilder(index, DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance());
    }
    
    public List<DescriptorProtos.EnumValueDescriptorProto.Builder> getValueBuilderList()
    {
      return getValueFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder<DescriptorProtos.EnumValueDescriptorProto, DescriptorProtos.EnumValueDescriptorProto.Builder, DescriptorProtos.EnumValueDescriptorProtoOrBuilder> getValueFieldBuilder()
    {
      if (valueBuilder_ == null)
      {
        valueBuilder_ = new RepeatedFieldBuilder(value_, (bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
        
        value_ = null;
      }
      return valueBuilder_;
    }
    
    private DescriptorProtos.EnumOptions options_ = DescriptorProtos.EnumOptions.getDefaultInstance();
    private SingleFieldBuilder<DescriptorProtos.EnumOptions, DescriptorProtos.EnumOptions.Builder, DescriptorProtos.EnumOptionsOrBuilder> optionsBuilder_;
    
    public boolean hasOptions()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public DescriptorProtos.EnumOptions getOptions()
    {
      if (optionsBuilder_ == null) {
        return options_;
      }
      return (DescriptorProtos.EnumOptions)optionsBuilder_.getMessage();
    }
    
    public Builder setOptions(DescriptorProtos.EnumOptions value)
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
    
    public Builder setOptions(DescriptorProtos.EnumOptions.Builder builderForValue)
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
    
    public Builder mergeOptions(DescriptorProtos.EnumOptions value)
    {
      if (optionsBuilder_ == null)
      {
        if (((bitField0_ & 0x4) == 4) && (options_ != DescriptorProtos.EnumOptions.getDefaultInstance())) {
          options_ = DescriptorProtos.EnumOptions.newBuilder(options_).mergeFrom(value).buildPartial();
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
        options_ = DescriptorProtos.EnumOptions.getDefaultInstance();
        onChanged();
      }
      else
      {
        optionsBuilder_.clear();
      }
      bitField0_ &= 0xFFFFFFFB;
      return this;
    }
    
    public DescriptorProtos.EnumOptions.Builder getOptionsBuilder()
    {
      bitField0_ |= 0x4;
      onChanged();
      return (DescriptorProtos.EnumOptions.Builder)getOptionsFieldBuilder().getBuilder();
    }
    
    public DescriptorProtos.EnumOptionsOrBuilder getOptionsOrBuilder()
    {
      if (optionsBuilder_ != null) {
        return (DescriptorProtos.EnumOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
      }
      return options_;
    }
    
    private SingleFieldBuilder<DescriptorProtos.EnumOptions, DescriptorProtos.EnumOptions.Builder, DescriptorProtos.EnumOptionsOrBuilder> getOptionsFieldBuilder()
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
    defaultInstance = new EnumDescriptorProto(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.EnumDescriptorProto
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */