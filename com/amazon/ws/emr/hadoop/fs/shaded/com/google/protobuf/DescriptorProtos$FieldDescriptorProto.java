package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.List;

public final class DescriptorProtos$FieldDescriptorProto
  extends GeneratedMessage
  implements DescriptorProtos.FieldDescriptorProtoOrBuilder
{
  private static final FieldDescriptorProto defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$FieldDescriptorProto(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$FieldDescriptorProto(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static FieldDescriptorProto getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public FieldDescriptorProto getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$FieldDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          bitField0_ |= 0x20;
          extendee_ = input.readBytes();
          break;
        case 24: 
          bitField0_ |= 0x2;
          number_ = input.readInt32();
          break;
        case 32: 
          int rawValue = input.readEnum();
          Label value = Label.valueOf(rawValue);
          if (value == null)
          {
            unknownFields.mergeVarintField(4, rawValue);
          }
          else
          {
            bitField0_ |= 0x4;
            label_ = value;
          }
          break;
        case 40: 
          int rawValue = input.readEnum();
          Type value = Type.valueOf(rawValue);
          if (value == null)
          {
            unknownFields.mergeVarintField(5, rawValue);
          }
          else
          {
            bitField0_ |= 0x8;
            type_ = value;
          }
          break;
        case 50: 
          bitField0_ |= 0x10;
          typeName_ = input.readBytes();
          break;
        case 58: 
          bitField0_ |= 0x40;
          defaultValue_ = input.readBytes();
          break;
        case 66: 
          DescriptorProtos.FieldOptions.Builder subBuilder = null;
          if ((bitField0_ & 0x80) == 128) {
            subBuilder = options_.toBuilder();
          }
          options_ = ((DescriptorProtos.FieldOptions)input.readMessage(DescriptorProtos.FieldOptions.PARSER, extensionRegistry));
          if (subBuilder != null)
          {
            subBuilder.mergeFrom(options_);
            options_ = subBuilder.buildPartial();
          }
          bitField0_ |= 0x80;
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
    return DescriptorProtos.access$4800();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$4900().ensureFieldAccessorsInitialized(FieldDescriptorProto.class, Builder.class);
  }
  
  public static Parser<FieldDescriptorProto> PARSER = new AbstractParser()
  {
    public DescriptorProtos.FieldDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.FieldDescriptorProto(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  private Object name_;
  public static final int NUMBER_FIELD_NUMBER = 3;
  private int number_;
  public static final int LABEL_FIELD_NUMBER = 4;
  private Label label_;
  public static final int TYPE_FIELD_NUMBER = 5;
  private Type type_;
  public static final int TYPE_NAME_FIELD_NUMBER = 6;
  private Object typeName_;
  public static final int EXTENDEE_FIELD_NUMBER = 2;
  private Object extendee_;
  public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
  private Object defaultValue_;
  public static final int OPTIONS_FIELD_NUMBER = 8;
  private DescriptorProtos.FieldOptions options_;
  
  public Parser<FieldDescriptorProto> getParserForType()
  {
    return PARSER;
  }
  
  public static enum Type
    implements ProtocolMessageEnum
  {
    TYPE_DOUBLE(0, 1),  TYPE_FLOAT(1, 2),  TYPE_INT64(2, 3),  TYPE_UINT64(3, 4),  TYPE_INT32(4, 5),  TYPE_FIXED64(5, 6),  TYPE_FIXED32(6, 7),  TYPE_BOOL(7, 8),  TYPE_STRING(8, 9),  TYPE_GROUP(9, 10),  TYPE_MESSAGE(10, 11),  TYPE_BYTES(11, 12),  TYPE_UINT32(12, 13),  TYPE_ENUM(13, 14),  TYPE_SFIXED32(14, 15),  TYPE_SFIXED64(15, 16),  TYPE_SINT32(16, 17),  TYPE_SINT64(17, 18);
    
    public static final int TYPE_DOUBLE_VALUE = 1;
    public static final int TYPE_FLOAT_VALUE = 2;
    public static final int TYPE_INT64_VALUE = 3;
    public static final int TYPE_UINT64_VALUE = 4;
    public static final int TYPE_INT32_VALUE = 5;
    public static final int TYPE_FIXED64_VALUE = 6;
    public static final int TYPE_FIXED32_VALUE = 7;
    public static final int TYPE_BOOL_VALUE = 8;
    public static final int TYPE_STRING_VALUE = 9;
    public static final int TYPE_GROUP_VALUE = 10;
    public static final int TYPE_MESSAGE_VALUE = 11;
    public static final int TYPE_BYTES_VALUE = 12;
    public static final int TYPE_UINT32_VALUE = 13;
    public static final int TYPE_ENUM_VALUE = 14;
    public static final int TYPE_SFIXED32_VALUE = 15;
    public static final int TYPE_SFIXED64_VALUE = 16;
    public static final int TYPE_SINT32_VALUE = 17;
    public static final int TYPE_SINT64_VALUE = 18;
    
    public final int getNumber()
    {
      return value;
    }
    
    public static Type valueOf(int value)
    {
      switch (value)
      {
      case 1: 
        return TYPE_DOUBLE;
      case 2: 
        return TYPE_FLOAT;
      case 3: 
        return TYPE_INT64;
      case 4: 
        return TYPE_UINT64;
      case 5: 
        return TYPE_INT32;
      case 6: 
        return TYPE_FIXED64;
      case 7: 
        return TYPE_FIXED32;
      case 8: 
        return TYPE_BOOL;
      case 9: 
        return TYPE_STRING;
      case 10: 
        return TYPE_GROUP;
      case 11: 
        return TYPE_MESSAGE;
      case 12: 
        return TYPE_BYTES;
      case 13: 
        return TYPE_UINT32;
      case 14: 
        return TYPE_ENUM;
      case 15: 
        return TYPE_SFIXED32;
      case 16: 
        return TYPE_SFIXED64;
      case 17: 
        return TYPE_SINT32;
      case 18: 
        return TYPE_SINT64;
      }
      return null;
    }
    
    public static Internal.EnumLiteMap<Type> internalGetValueMap()
    {
      return internalValueMap;
    }
    
    private static Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap()
    {
      public DescriptorProtos.FieldDescriptorProto.Type findValueByNumber(int number)
      {
        return DescriptorProtos.FieldDescriptorProto.Type.valueOf(number);
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
      return (Descriptors.EnumDescriptor)DescriptorProtos.FieldDescriptorProto.getDescriptor().getEnumTypes().get(0);
    }
    
    private static final Type[] VALUES = values();
    private final int index;
    private final int value;
    
    public static Type valueOf(Descriptors.EnumValueDescriptor desc)
    {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }
    
    private Type(int index, int value)
    {
      this.index = index;
      this.value = value;
    }
  }
  
  public static enum Label
    implements ProtocolMessageEnum
  {
    LABEL_OPTIONAL(0, 1),  LABEL_REQUIRED(1, 2),  LABEL_REPEATED(2, 3);
    
    public static final int LABEL_OPTIONAL_VALUE = 1;
    public static final int LABEL_REQUIRED_VALUE = 2;
    public static final int LABEL_REPEATED_VALUE = 3;
    
    public final int getNumber()
    {
      return value;
    }
    
    public static Label valueOf(int value)
    {
      switch (value)
      {
      case 1: 
        return LABEL_OPTIONAL;
      case 2: 
        return LABEL_REQUIRED;
      case 3: 
        return LABEL_REPEATED;
      }
      return null;
    }
    
    public static Internal.EnumLiteMap<Label> internalGetValueMap()
    {
      return internalValueMap;
    }
    
    private static Internal.EnumLiteMap<Label> internalValueMap = new Internal.EnumLiteMap()
    {
      public DescriptorProtos.FieldDescriptorProto.Label findValueByNumber(int number)
      {
        return DescriptorProtos.FieldDescriptorProto.Label.valueOf(number);
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
      return (Descriptors.EnumDescriptor)DescriptorProtos.FieldDescriptorProto.getDescriptor().getEnumTypes().get(1);
    }
    
    private static final Label[] VALUES = values();
    private final int index;
    private final int value;
    
    public static Label valueOf(Descriptors.EnumValueDescriptor desc)
    {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }
    
    private Label(int index, int value)
    {
      this.index = index;
      this.value = value;
    }
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
  
  public boolean hasLabel()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public Label getLabel()
  {
    return label_;
  }
  
  public boolean hasType()
  {
    return (bitField0_ & 0x8) == 8;
  }
  
  public Type getType()
  {
    return type_;
  }
  
  public boolean hasTypeName()
  {
    return (bitField0_ & 0x10) == 16;
  }
  
  public String getTypeName()
  {
    Object ref = typeName_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      typeName_ = s;
    }
    return s;
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
  
  public boolean hasExtendee()
  {
    return (bitField0_ & 0x20) == 32;
  }
  
  public String getExtendee()
  {
    Object ref = extendee_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      extendee_ = s;
    }
    return s;
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
  
  public boolean hasDefaultValue()
  {
    return (bitField0_ & 0x40) == 64;
  }
  
  public String getDefaultValue()
  {
    Object ref = defaultValue_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      defaultValue_ = s;
    }
    return s;
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
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x80) == 128;
  }
  
  public DescriptorProtos.FieldOptions getOptions()
  {
    return options_;
  }
  
  public DescriptorProtos.FieldOptionsOrBuilder getOptionsOrBuilder()
  {
    return options_;
  }
  
  private void initFields()
  {
    name_ = "";
    number_ = 0;
    label_ = Label.LABEL_OPTIONAL;
    type_ = Type.TYPE_DOUBLE;
    typeName_ = "";
    extendee_ = "";
    defaultValue_ = "";
    options_ = DescriptorProtos.FieldOptions.getDefaultInstance();
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
    if ((bitField0_ & 0x20) == 32) {
      output.writeBytes(2, getExtendeeBytes());
    }
    if ((bitField0_ & 0x2) == 2) {
      output.writeInt32(3, number_);
    }
    if ((bitField0_ & 0x4) == 4) {
      output.writeEnum(4, label_.getNumber());
    }
    if ((bitField0_ & 0x8) == 8) {
      output.writeEnum(5, type_.getNumber());
    }
    if ((bitField0_ & 0x10) == 16) {
      output.writeBytes(6, getTypeNameBytes());
    }
    if ((bitField0_ & 0x40) == 64) {
      output.writeBytes(7, getDefaultValueBytes());
    }
    if ((bitField0_ & 0x80) == 128) {
      output.writeMessage(8, options_);
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
    if ((bitField0_ & 0x20) == 32) {
      size += CodedOutputStream.computeBytesSize(2, getExtendeeBytes());
    }
    if ((bitField0_ & 0x2) == 2) {
      size += CodedOutputStream.computeInt32Size(3, number_);
    }
    if ((bitField0_ & 0x4) == 4) {
      size += CodedOutputStream.computeEnumSize(4, label_.getNumber());
    }
    if ((bitField0_ & 0x8) == 8) {
      size += CodedOutputStream.computeEnumSize(5, type_.getNumber());
    }
    if ((bitField0_ & 0x10) == 16) {
      size += CodedOutputStream.computeBytesSize(6, getTypeNameBytes());
    }
    if ((bitField0_ & 0x40) == 64) {
      size += CodedOutputStream.computeBytesSize(7, getDefaultValueBytes());
    }
    if ((bitField0_ & 0x80) == 128) {
      size += CodedOutputStream.computeMessageSize(8, options_);
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
  
  public static FieldDescriptorProto parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (FieldDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static FieldDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (FieldDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static FieldDescriptorProto parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (FieldDescriptorProto)PARSER.parseFrom(data);
  }
  
  public static FieldDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (FieldDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static FieldDescriptorProto parseFrom(InputStream input)
    throws IOException
  {
    return (FieldDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static FieldDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FieldDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static FieldDescriptorProto parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (FieldDescriptorProto)PARSER.parseDelimitedFrom(input);
  }
  
  public static FieldDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FieldDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static FieldDescriptorProto parseFrom(CodedInputStream input)
    throws IOException
  {
    return (FieldDescriptorProto)PARSER.parseFrom(input);
  }
  
  public static FieldDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FieldDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$5100();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(FieldDescriptorProto prototype)
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
      name_ = name_;
      if ((from_bitField0_ & 0x2) == 2) {
        to_bitField0_ |= 0x2;
      }
      number_ = number_;
      if ((from_bitField0_ & 0x4) == 4) {
        to_bitField0_ |= 0x4;
      }
      label_ = label_;
      if ((from_bitField0_ & 0x8) == 8) {
        to_bitField0_ |= 0x8;
      }
      type_ = type_;
      if ((from_bitField0_ & 0x10) == 16) {
        to_bitField0_ |= 0x10;
      }
      typeName_ = typeName_;
      if ((from_bitField0_ & 0x20) == 32) {
        to_bitField0_ |= 0x20;
      }
      extendee_ = extendee_;
      if ((from_bitField0_ & 0x40) == 64) {
        to_bitField0_ |= 0x40;
      }
      defaultValue_ = defaultValue_;
      if ((from_bitField0_ & 0x80) == 128) {
        to_bitField0_ |= 0x80;
      }
      if (optionsBuilder_ == null) {
        options_ = options_;
      } else {
        options_ = ((DescriptorProtos.FieldOptions)optionsBuilder_.build());
      }
      bitField0_ = to_bitField0_;
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
        name_ = name_;
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
        typeName_ = typeName_;
        onChanged();
      }
      if (other.hasExtendee())
      {
        bitField0_ |= 0x20;
        extendee_ = extendee_;
        onChanged();
      }
      if (other.hasDefaultValue())
      {
        bitField0_ |= 0x40;
        defaultValue_ = defaultValue_;
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
  
  static
  {
    defaultInstance = new FieldDescriptorProto(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FieldDescriptorProto
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */