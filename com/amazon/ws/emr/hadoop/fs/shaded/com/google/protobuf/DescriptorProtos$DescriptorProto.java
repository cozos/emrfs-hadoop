package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$DescriptorProto
  extends GeneratedMessage
  implements DescriptorProtos.DescriptorProtoOrBuilder
{
  private static final DescriptorProto defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$DescriptorProto(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$DescriptorProto(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static DescriptorProto getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public DescriptorProto getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$DescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
            field_ = new ArrayList();
            mutable_bitField0_ |= 0x2;
          }
          field_.add(input.readMessage(DescriptorProtos.FieldDescriptorProto.PARSER, extensionRegistry));
          break;
        case 26: 
          if ((mutable_bitField0_ & 0x8) != 8)
          {
            nestedType_ = new ArrayList();
            mutable_bitField0_ |= 0x8;
          }
          nestedType_.add(input.readMessage(PARSER, extensionRegistry));
          break;
        case 34: 
          if ((mutable_bitField0_ & 0x10) != 16)
          {
            enumType_ = new ArrayList();
            mutable_bitField0_ |= 0x10;
          }
          enumType_.add(input.readMessage(DescriptorProtos.EnumDescriptorProto.PARSER, extensionRegistry));
          break;
        case 42: 
          if ((mutable_bitField0_ & 0x20) != 32)
          {
            extensionRange_ = new ArrayList();
            mutable_bitField0_ |= 0x20;
          }
          extensionRange_.add(input.readMessage(ExtensionRange.PARSER, extensionRegistry));
          break;
        case 50: 
          if ((mutable_bitField0_ & 0x4) != 4)
          {
            extension_ = new ArrayList();
            mutable_bitField0_ |= 0x4;
          }
          extension_.add(input.readMessage(DescriptorProtos.FieldDescriptorProto.PARSER, extensionRegistry));
          break;
        case 58: 
          DescriptorProtos.MessageOptions.Builder subBuilder = null;
          if ((bitField0_ & 0x2) == 2) {
            subBuilder = options_.toBuilder();
          }
          options_ = ((DescriptorProtos.MessageOptions)input.readMessage(DescriptorProtos.MessageOptions.PARSER, extensionRegistry));
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
        field_ = Collections.unmodifiableList(field_);
      }
      if ((mutable_bitField0_ & 0x8) == 8) {
        nestedType_ = Collections.unmodifiableList(nestedType_);
      }
      if ((mutable_bitField0_ & 0x10) == 16) {
        enumType_ = Collections.unmodifiableList(enumType_);
      }
      if ((mutable_bitField0_ & 0x20) == 32) {
        extensionRange_ = Collections.unmodifiableList(extensionRange_);
      }
      if ((mutable_bitField0_ & 0x4) == 4) {
        extension_ = Collections.unmodifiableList(extension_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$2500();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$2600().ensureFieldAccessorsInitialized(DescriptorProto.class, Builder.class);
  }
  
  public static Parser<DescriptorProto> PARSER = new AbstractParser()
  {
    public DescriptorProtos.DescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.DescriptorProto(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  private Object name_;
  public static final int FIELD_FIELD_NUMBER = 2;
  private List<DescriptorProtos.FieldDescriptorProto> field_;
  public static final int EXTENSION_FIELD_NUMBER = 6;
  private List<DescriptorProtos.FieldDescriptorProto> extension_;
  public static final int NESTED_TYPE_FIELD_NUMBER = 3;
  private List<DescriptorProto> nestedType_;
  public static final int ENUM_TYPE_FIELD_NUMBER = 4;
  private List<DescriptorProtos.EnumDescriptorProto> enumType_;
  public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
  private List<ExtensionRange> extensionRange_;
  public static final int OPTIONS_FIELD_NUMBER = 7;
  private DescriptorProtos.MessageOptions options_;
  
  public Parser<DescriptorProto> getParserForType()
  {
    return PARSER;
  }
  
  public static abstract interface ExtensionRangeOrBuilder
    extends MessageOrBuilder
  {
    public abstract boolean hasStart();
    
    public abstract int getStart();
    
    public abstract boolean hasEnd();
    
    public abstract int getEnd();
  }
  
  public static final class ExtensionRange
    extends GeneratedMessage
    implements DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
  {
    private static final ExtensionRange defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private ExtensionRange(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private ExtensionRange(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static ExtensionRange getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public ExtensionRange getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private ExtensionRange(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
            bitField0_ |= 0x1;
            start_ = input.readInt32();
            break;
          case 16: 
            bitField0_ |= 0x2;
            end_ = input.readInt32();
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
      return DescriptorProtos.access$2800();
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.access$2900().ensureFieldAccessorsInitialized(ExtensionRange.class, Builder.class);
    }
    
    public static Parser<ExtensionRange> PARSER = new AbstractParser()
    {
      public DescriptorProtos.DescriptorProto.ExtensionRange parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.DescriptorProto.ExtensionRange(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int START_FIELD_NUMBER = 1;
    private int start_;
    public static final int END_FIELD_NUMBER = 2;
    private int end_;
    
    public Parser<ExtensionRange> getParserForType()
    {
      return PARSER;
    }
    
    public boolean hasStart()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public int getStart()
    {
      return start_;
    }
    
    public boolean hasEnd()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public int getEnd()
    {
      return end_;
    }
    
    private void initFields()
    {
      start_ = 0;
      end_ = 0;
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(CodedOutputStream output)
      throws IOException
    {
      getSerializedSize();
      if ((bitField0_ & 0x1) == 1) {
        output.writeInt32(1, start_);
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeInt32(2, end_);
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
        size += CodedOutputStream.computeInt32Size(1, start_);
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeInt32Size(2, end_);
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
    
    public static ExtensionRange parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (ExtensionRange)PARSER.parseFrom(data);
    }
    
    public static ExtensionRange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (ExtensionRange)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static ExtensionRange parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (ExtensionRange)PARSER.parseFrom(data);
    }
    
    public static ExtensionRange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (ExtensionRange)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static ExtensionRange parseFrom(InputStream input)
      throws IOException
    {
      return (ExtensionRange)PARSER.parseFrom(input);
    }
    
    public static ExtensionRange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (ExtensionRange)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static ExtensionRange parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (ExtensionRange)PARSER.parseDelimitedFrom(input);
    }
    
    public static ExtensionRange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (ExtensionRange)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static ExtensionRange parseFrom(CodedInputStream input)
      throws IOException
    {
      return (ExtensionRange)PARSER.parseFrom(input);
    }
    
    public static ExtensionRange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (ExtensionRange)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$3100();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(ExtensionRange prototype)
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
      implements DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
    {
      private int bitField0_;
      private int start_;
      private int end_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.access$2800();
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.access$2900().ensureFieldAccessorsInitialized(DescriptorProtos.DescriptorProto.ExtensionRange.class, Builder.class);
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
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        start_ = 0;
        bitField0_ &= 0xFFFFFFFE;
        end_ = 0;
        bitField0_ &= 0xFFFFFFFD;
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.access$2800();
      }
      
      public DescriptorProtos.DescriptorProto.ExtensionRange getDefaultInstanceForType()
      {
        return DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance();
      }
      
      public DescriptorProtos.DescriptorProto.ExtensionRange build()
      {
        DescriptorProtos.DescriptorProto.ExtensionRange result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.DescriptorProto.ExtensionRange buildPartial()
      {
        DescriptorProtos.DescriptorProto.ExtensionRange result = new DescriptorProtos.DescriptorProto.ExtensionRange(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        start_ = start_;
        if ((from_bitField0_ & 0x2) == 2) {
          to_bitField0_ |= 0x2;
        }
        end_ = end_;
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.DescriptorProto.ExtensionRange)) {
          return mergeFrom((DescriptorProtos.DescriptorProto.ExtensionRange)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.DescriptorProto.ExtensionRange other)
      {
        if (other == DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance()) {
          return this;
        }
        if (other.hasStart()) {
          setStart(other.getStart());
        }
        if (other.hasEnd()) {
          setEnd(other.getEnd());
        }
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.DescriptorProto.ExtensionRange parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.DescriptorProto.ExtensionRange)DescriptorProtos.DescriptorProto.ExtensionRange.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.DescriptorProto.ExtensionRange)e.getUnfinishedMessage();
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
      
      public boolean hasStart()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public int getStart()
      {
        return start_;
      }
      
      public Builder setStart(int value)
      {
        bitField0_ |= 0x1;
        start_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearStart()
      {
        bitField0_ &= 0xFFFFFFFE;
        start_ = 0;
        onChanged();
        return this;
      }
      
      public boolean hasEnd()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public int getEnd()
      {
        return end_;
      }
      
      public Builder setEnd(int value)
      {
        bitField0_ |= 0x2;
        end_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearEnd()
      {
        bitField0_ &= 0xFFFFFFFD;
        end_ = 0;
        onChanged();
        return this;
      }
    }
    
    static
    {
      defaultInstance = new ExtensionRange(true);
      defaultInstance.initFields();
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
  
  public List<DescriptorProtos.FieldDescriptorProto> getFieldList()
  {
    return field_;
  }
  
  public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getFieldOrBuilderList()
  {
    return field_;
  }
  
  public int getFieldCount()
  {
    return field_.size();
  }
  
  public DescriptorProtos.FieldDescriptorProto getField(int index)
  {
    return (DescriptorProtos.FieldDescriptorProto)field_.get(index);
  }
  
  public DescriptorProtos.FieldDescriptorProtoOrBuilder getFieldOrBuilder(int index)
  {
    return (DescriptorProtos.FieldDescriptorProtoOrBuilder)field_.get(index);
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
  
  public List<DescriptorProto> getNestedTypeList()
  {
    return nestedType_;
  }
  
  public List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getNestedTypeOrBuilderList()
  {
    return nestedType_;
  }
  
  public int getNestedTypeCount()
  {
    return nestedType_.size();
  }
  
  public DescriptorProto getNestedType(int index)
  {
    return (DescriptorProto)nestedType_.get(index);
  }
  
  public DescriptorProtos.DescriptorProtoOrBuilder getNestedTypeOrBuilder(int index)
  {
    return (DescriptorProtos.DescriptorProtoOrBuilder)nestedType_.get(index);
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
  
  public List<ExtensionRange> getExtensionRangeList()
  {
    return extensionRange_;
  }
  
  public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList()
  {
    return extensionRange_;
  }
  
  public int getExtensionRangeCount()
  {
    return extensionRange_.size();
  }
  
  public ExtensionRange getExtensionRange(int index)
  {
    return (ExtensionRange)extensionRange_.get(index);
  }
  
  public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int index)
  {
    return (ExtensionRangeOrBuilder)extensionRange_.get(index);
  }
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public DescriptorProtos.MessageOptions getOptions()
  {
    return options_;
  }
  
  public DescriptorProtos.MessageOptionsOrBuilder getOptionsOrBuilder()
  {
    return options_;
  }
  
  private void initFields()
  {
    name_ = "";
    field_ = Collections.emptyList();
    extension_ = Collections.emptyList();
    nestedType_ = Collections.emptyList();
    enumType_ = Collections.emptyList();
    extensionRange_ = Collections.emptyList();
    options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
  }
  
  private byte memoizedIsInitialized = -1;
  
  public final boolean isInitialized()
  {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) {
      return isInitialized == 1;
    }
    for (int i = 0; i < getFieldCount(); i++) {
      if (!getField(i).isInitialized())
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
    for (int i = 0; i < getNestedTypeCount(); i++) {
      if (!getNestedType(i).isInitialized())
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
    for (int i = 0; i < field_.size(); i++) {
      output.writeMessage(2, (MessageLite)field_.get(i));
    }
    for (int i = 0; i < nestedType_.size(); i++) {
      output.writeMessage(3, (MessageLite)nestedType_.get(i));
    }
    for (int i = 0; i < enumType_.size(); i++) {
      output.writeMessage(4, (MessageLite)enumType_.get(i));
    }
    for (int i = 0; i < extensionRange_.size(); i++) {
      output.writeMessage(5, (MessageLite)extensionRange_.get(i));
    }
    for (int i = 0; i < extension_.size(); i++) {
      output.writeMessage(6, (MessageLite)extension_.get(i));
    }
    if ((bitField0_ & 0x2) == 2) {
      output.writeMessage(7, options_);
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
    for (int i = 0; i < field_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(2, (MessageLite)field_.get(i));
    }
    for (int i = 0; i < nestedType_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(3, (MessageLite)nestedType_.get(i));
    }
    for (int i = 0; i < enumType_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(4, (MessageLite)enumType_.get(i));
    }
    for (int i = 0; i < extensionRange_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(5, (MessageLite)extensionRange_.get(i));
    }
    for (int i = 0; i < extension_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(6, (MessageLite)extension_.get(i));
    }
    if ((bitField0_ & 0x2) == 2) {
      size += CodedOutputStream.computeMessageSize(7, options_);
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
  
  public static DescriptorProto parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (DescriptorProto)PARSER.parseFrom(data);
  }
  
  public static DescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (DescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static DescriptorProto parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (DescriptorProto)PARSER.parseFrom(data);
  }
  
  public static DescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (DescriptorProto)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static DescriptorProto parseFrom(InputStream input)
    throws IOException
  {
    return (DescriptorProto)PARSER.parseFrom(input);
  }
  
  public static DescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (DescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static DescriptorProto parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (DescriptorProto)PARSER.parseDelimitedFrom(input);
  }
  
  public static DescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (DescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static DescriptorProto parseFrom(CodedInputStream input)
    throws IOException
  {
    return (DescriptorProto)PARSER.parseFrom(input);
  }
  
  public static DescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (DescriptorProto)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$3700();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(DescriptorProto prototype)
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
    implements DescriptorProtos.DescriptorProtoOrBuilder
  {
    private int bitField0_;
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.access$2500();
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.access$2600().ensureFieldAccessorsInitialized(DescriptorProtos.DescriptorProto.class, Builder.class);
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
        getFieldFieldBuilder();
        getExtensionFieldBuilder();
        getNestedTypeFieldBuilder();
        getEnumTypeFieldBuilder();
        getExtensionRangeFieldBuilder();
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
      if (fieldBuilder_ == null)
      {
        field_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFFD;
      }
      else
      {
        fieldBuilder_.clear();
      }
      if (extensionBuilder_ == null)
      {
        extension_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFFB;
      }
      else
      {
        extensionBuilder_.clear();
      }
      if (nestedTypeBuilder_ == null)
      {
        nestedType_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFF7;
      }
      else
      {
        nestedTypeBuilder_.clear();
      }
      if (enumTypeBuilder_ == null)
      {
        enumType_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFEF;
      }
      else
      {
        enumTypeBuilder_.clear();
      }
      if (extensionRangeBuilder_ == null)
      {
        extensionRange_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFDF;
      }
      else
      {
        extensionRangeBuilder_.clear();
      }
      if (optionsBuilder_ == null) {
        options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
      } else {
        optionsBuilder_.clear();
      }
      bitField0_ &= 0xFFFFFFBF;
      return this;
    }
    
    public Builder clone()
    {
      return create().mergeFrom(buildPartial());
    }
    
    public Descriptors.Descriptor getDescriptorForType()
    {
      return DescriptorProtos.access$2500();
    }
    
    public DescriptorProtos.DescriptorProto getDefaultInstanceForType()
    {
      return DescriptorProtos.DescriptorProto.getDefaultInstance();
    }
    
    public DescriptorProtos.DescriptorProto build()
    {
      DescriptorProtos.DescriptorProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }
    
    public DescriptorProtos.DescriptorProto buildPartial()
    {
      DescriptorProtos.DescriptorProto result = new DescriptorProtos.DescriptorProto(this, null);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if ((from_bitField0_ & 0x1) == 1) {
        to_bitField0_ |= 0x1;
      }
      name_ = name_;
      if (fieldBuilder_ == null)
      {
        if ((bitField0_ & 0x2) == 2)
        {
          field_ = Collections.unmodifiableList(field_);
          bitField0_ &= 0xFFFFFFFD;
        }
        field_ = field_;
      }
      else
      {
        field_ = fieldBuilder_.build();
      }
      if (extensionBuilder_ == null)
      {
        if ((bitField0_ & 0x4) == 4)
        {
          extension_ = Collections.unmodifiableList(extension_);
          bitField0_ &= 0xFFFFFFFB;
        }
        extension_ = extension_;
      }
      else
      {
        extension_ = extensionBuilder_.build();
      }
      if (nestedTypeBuilder_ == null)
      {
        if ((bitField0_ & 0x8) == 8)
        {
          nestedType_ = Collections.unmodifiableList(nestedType_);
          bitField0_ &= 0xFFFFFFF7;
        }
        nestedType_ = nestedType_;
      }
      else
      {
        nestedType_ = nestedTypeBuilder_.build();
      }
      if (enumTypeBuilder_ == null)
      {
        if ((bitField0_ & 0x10) == 16)
        {
          enumType_ = Collections.unmodifiableList(enumType_);
          bitField0_ &= 0xFFFFFFEF;
        }
        enumType_ = enumType_;
      }
      else
      {
        enumType_ = enumTypeBuilder_.build();
      }
      if (extensionRangeBuilder_ == null)
      {
        if ((bitField0_ & 0x20) == 32)
        {
          extensionRange_ = Collections.unmodifiableList(extensionRange_);
          bitField0_ &= 0xFFFFFFDF;
        }
        extensionRange_ = extensionRange_;
      }
      else
      {
        extensionRange_ = extensionRangeBuilder_.build();
      }
      if ((from_bitField0_ & 0x40) == 64) {
        to_bitField0_ |= 0x2;
      }
      if (optionsBuilder_ == null) {
        options_ = options_;
      } else {
        options_ = ((DescriptorProtos.MessageOptions)optionsBuilder_.build());
      }
      bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }
    
    public Builder mergeFrom(Message other)
    {
      if ((other instanceof DescriptorProtos.DescriptorProto)) {
        return mergeFrom((DescriptorProtos.DescriptorProto)other);
      }
      super.mergeFrom(other);
      return this;
    }
    
    public Builder mergeFrom(DescriptorProtos.DescriptorProto other)
    {
      if (other == DescriptorProtos.DescriptorProto.getDefaultInstance()) {
        return this;
      }
      if (other.hasName())
      {
        bitField0_ |= 0x1;
        name_ = name_;
        onChanged();
      }
      if (fieldBuilder_ == null)
      {
        if (!field_.isEmpty())
        {
          if (field_.isEmpty())
          {
            field_ = field_;
            bitField0_ &= 0xFFFFFFFD;
          }
          else
          {
            ensureFieldIsMutable();
            field_.addAll(field_);
          }
          onChanged();
        }
      }
      else if (!field_.isEmpty()) {
        if (fieldBuilder_.isEmpty())
        {
          fieldBuilder_.dispose();
          fieldBuilder_ = null;
          field_ = field_;
          bitField0_ &= 0xFFFFFFFD;
          fieldBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getFieldFieldBuilder() : null);
        }
        else
        {
          fieldBuilder_.addAllMessages(field_);
        }
      }
      if (extensionBuilder_ == null)
      {
        if (!extension_.isEmpty())
        {
          if (extension_.isEmpty())
          {
            extension_ = extension_;
            bitField0_ &= 0xFFFFFFFB;
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
          bitField0_ &= 0xFFFFFFFB;
          extensionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getExtensionFieldBuilder() : null);
        }
        else
        {
          extensionBuilder_.addAllMessages(extension_);
        }
      }
      if (nestedTypeBuilder_ == null)
      {
        if (!nestedType_.isEmpty())
        {
          if (nestedType_.isEmpty())
          {
            nestedType_ = nestedType_;
            bitField0_ &= 0xFFFFFFF7;
          }
          else
          {
            ensureNestedTypeIsMutable();
            nestedType_.addAll(nestedType_);
          }
          onChanged();
        }
      }
      else if (!nestedType_.isEmpty()) {
        if (nestedTypeBuilder_.isEmpty())
        {
          nestedTypeBuilder_.dispose();
          nestedTypeBuilder_ = null;
          nestedType_ = nestedType_;
          bitField0_ &= 0xFFFFFFF7;
          nestedTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getNestedTypeFieldBuilder() : null);
        }
        else
        {
          nestedTypeBuilder_.addAllMessages(nestedType_);
        }
      }
      if (enumTypeBuilder_ == null)
      {
        if (!enumType_.isEmpty())
        {
          if (enumType_.isEmpty())
          {
            enumType_ = enumType_;
            bitField0_ &= 0xFFFFFFEF;
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
          bitField0_ &= 0xFFFFFFEF;
          enumTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getEnumTypeFieldBuilder() : null);
        }
        else
        {
          enumTypeBuilder_.addAllMessages(enumType_);
        }
      }
      if (extensionRangeBuilder_ == null)
      {
        if (!extensionRange_.isEmpty())
        {
          if (extensionRange_.isEmpty())
          {
            extensionRange_ = extensionRange_;
            bitField0_ &= 0xFFFFFFDF;
          }
          else
          {
            ensureExtensionRangeIsMutable();
            extensionRange_.addAll(extensionRange_);
          }
          onChanged();
        }
      }
      else if (!extensionRange_.isEmpty()) {
        if (extensionRangeBuilder_.isEmpty())
        {
          extensionRangeBuilder_.dispose();
          extensionRangeBuilder_ = null;
          extensionRange_ = extensionRange_;
          bitField0_ &= 0xFFFFFFDF;
          extensionRangeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getExtensionRangeFieldBuilder() : null);
        }
        else
        {
          extensionRangeBuilder_.addAllMessages(extensionRange_);
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
      for (int i = 0; i < getFieldCount(); i++) {
        if (!getField(i).isInitialized()) {
          return false;
        }
      }
      for (int i = 0; i < getExtensionCount(); i++) {
        if (!getExtension(i).isInitialized()) {
          return false;
        }
      }
      for (int i = 0; i < getNestedTypeCount(); i++) {
        if (!getNestedType(i).isInitialized()) {
          return false;
        }
      }
      for (int i = 0; i < getEnumTypeCount(); i++) {
        if (!getEnumType(i).isInitialized()) {
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
      DescriptorProtos.DescriptorProto parsedMessage = null;
      try
      {
        parsedMessage = (DescriptorProtos.DescriptorProto)DescriptorProtos.DescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
      }
      catch (InvalidProtocolBufferException e)
      {
        parsedMessage = (DescriptorProtos.DescriptorProto)e.getUnfinishedMessage();
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
      name_ = DescriptorProtos.DescriptorProto.getDefaultInstance().getName();
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
    
    private List<DescriptorProtos.FieldDescriptorProto> field_ = Collections.emptyList();
    private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> fieldBuilder_;
    
    private void ensureFieldIsMutable()
    {
      if ((bitField0_ & 0x2) != 2)
      {
        field_ = new ArrayList(field_);
        bitField0_ |= 0x2;
      }
    }
    
    public List<DescriptorProtos.FieldDescriptorProto> getFieldList()
    {
      if (fieldBuilder_ == null) {
        return Collections.unmodifiableList(field_);
      }
      return fieldBuilder_.getMessageList();
    }
    
    public int getFieldCount()
    {
      if (fieldBuilder_ == null) {
        return field_.size();
      }
      return fieldBuilder_.getCount();
    }
    
    public DescriptorProtos.FieldDescriptorProto getField(int index)
    {
      if (fieldBuilder_ == null) {
        return (DescriptorProtos.FieldDescriptorProto)field_.get(index);
      }
      return (DescriptorProtos.FieldDescriptorProto)fieldBuilder_.getMessage(index);
    }
    
    public Builder setField(int index, DescriptorProtos.FieldDescriptorProto value)
    {
      if (fieldBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFieldIsMutable();
        field_.set(index, value);
        onChanged();
      }
      else
      {
        fieldBuilder_.setMessage(index, value);
      }
      return this;
    }
    
    public Builder setField(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
    {
      if (fieldBuilder_ == null)
      {
        ensureFieldIsMutable();
        field_.set(index, builderForValue.build());
        onChanged();
      }
      else
      {
        fieldBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addField(DescriptorProtos.FieldDescriptorProto value)
    {
      if (fieldBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFieldIsMutable();
        field_.add(value);
        onChanged();
      }
      else
      {
        fieldBuilder_.addMessage(value);
      }
      return this;
    }
    
    public Builder addField(int index, DescriptorProtos.FieldDescriptorProto value)
    {
      if (fieldBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFieldIsMutable();
        field_.add(index, value);
        onChanged();
      }
      else
      {
        fieldBuilder_.addMessage(index, value);
      }
      return this;
    }
    
    public Builder addField(DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
    {
      if (fieldBuilder_ == null)
      {
        ensureFieldIsMutable();
        field_.add(builderForValue.build());
        onChanged();
      }
      else
      {
        fieldBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    
    public Builder addField(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
    {
      if (fieldBuilder_ == null)
      {
        ensureFieldIsMutable();
        field_.add(index, builderForValue.build());
        onChanged();
      }
      else
      {
        fieldBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addAllField(Iterable<? extends DescriptorProtos.FieldDescriptorProto> values)
    {
      if (fieldBuilder_ == null)
      {
        ensureFieldIsMutable();
        GeneratedMessage.Builder.addAll(values, field_);
        onChanged();
      }
      else
      {
        fieldBuilder_.addAllMessages(values);
      }
      return this;
    }
    
    public Builder clearField()
    {
      if (fieldBuilder_ == null)
      {
        field_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFFD;
        onChanged();
      }
      else
      {
        fieldBuilder_.clear();
      }
      return this;
    }
    
    public Builder removeField(int index)
    {
      if (fieldBuilder_ == null)
      {
        ensureFieldIsMutable();
        field_.remove(index);
        onChanged();
      }
      else
      {
        fieldBuilder_.remove(index);
      }
      return this;
    }
    
    public DescriptorProtos.FieldDescriptorProto.Builder getFieldBuilder(int index)
    {
      return (DescriptorProtos.FieldDescriptorProto.Builder)getFieldFieldBuilder().getBuilder(index);
    }
    
    public DescriptorProtos.FieldDescriptorProtoOrBuilder getFieldOrBuilder(int index)
    {
      if (fieldBuilder_ == null) {
        return (DescriptorProtos.FieldDescriptorProtoOrBuilder)field_.get(index);
      }
      return (DescriptorProtos.FieldDescriptorProtoOrBuilder)fieldBuilder_.getMessageOrBuilder(index);
    }
    
    public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getFieldOrBuilderList()
    {
      if (fieldBuilder_ != null) {
        return fieldBuilder_.getMessageOrBuilderList();
      }
      return Collections.unmodifiableList(field_);
    }
    
    public DescriptorProtos.FieldDescriptorProto.Builder addFieldBuilder()
    {
      return (DescriptorProtos.FieldDescriptorProto.Builder)getFieldFieldBuilder().addBuilder(DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos.FieldDescriptorProto.Builder addFieldBuilder(int index)
    {
      return (DescriptorProtos.FieldDescriptorProto.Builder)getFieldFieldBuilder().addBuilder(index, DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
    }
    
    public List<DescriptorProtos.FieldDescriptorProto.Builder> getFieldBuilderList()
    {
      return getFieldFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> getFieldFieldBuilder()
    {
      if (fieldBuilder_ == null)
      {
        fieldBuilder_ = new RepeatedFieldBuilder(field_, (bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
        
        field_ = null;
      }
      return fieldBuilder_;
    }
    
    private List<DescriptorProtos.FieldDescriptorProto> extension_ = Collections.emptyList();
    private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> extensionBuilder_;
    
    private void ensureExtensionIsMutable()
    {
      if ((bitField0_ & 0x4) != 4)
      {
        extension_ = new ArrayList(extension_);
        bitField0_ |= 0x4;
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
        bitField0_ &= 0xFFFFFFFB;
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
        extensionBuilder_ = new RepeatedFieldBuilder(extension_, (bitField0_ & 0x4) == 4, getParentForChildren(), isClean());
        
        extension_ = null;
      }
      return extensionBuilder_;
    }
    
    private List<DescriptorProtos.DescriptorProto> nestedType_ = Collections.emptyList();
    private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto, Builder, DescriptorProtos.DescriptorProtoOrBuilder> nestedTypeBuilder_;
    
    private void ensureNestedTypeIsMutable()
    {
      if ((bitField0_ & 0x8) != 8)
      {
        nestedType_ = new ArrayList(nestedType_);
        bitField0_ |= 0x8;
      }
    }
    
    public List<DescriptorProtos.DescriptorProto> getNestedTypeList()
    {
      if (nestedTypeBuilder_ == null) {
        return Collections.unmodifiableList(nestedType_);
      }
      return nestedTypeBuilder_.getMessageList();
    }
    
    public int getNestedTypeCount()
    {
      if (nestedTypeBuilder_ == null) {
        return nestedType_.size();
      }
      return nestedTypeBuilder_.getCount();
    }
    
    public DescriptorProtos.DescriptorProto getNestedType(int index)
    {
      if (nestedTypeBuilder_ == null) {
        return (DescriptorProtos.DescriptorProto)nestedType_.get(index);
      }
      return (DescriptorProtos.DescriptorProto)nestedTypeBuilder_.getMessage(index);
    }
    
    public Builder setNestedType(int index, DescriptorProtos.DescriptorProto value)
    {
      if (nestedTypeBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNestedTypeIsMutable();
        nestedType_.set(index, value);
        onChanged();
      }
      else
      {
        nestedTypeBuilder_.setMessage(index, value);
      }
      return this;
    }
    
    public Builder setNestedType(int index, Builder builderForValue)
    {
      if (nestedTypeBuilder_ == null)
      {
        ensureNestedTypeIsMutable();
        nestedType_.set(index, builderForValue.build());
        onChanged();
      }
      else
      {
        nestedTypeBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addNestedType(DescriptorProtos.DescriptorProto value)
    {
      if (nestedTypeBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNestedTypeIsMutable();
        nestedType_.add(value);
        onChanged();
      }
      else
      {
        nestedTypeBuilder_.addMessage(value);
      }
      return this;
    }
    
    public Builder addNestedType(int index, DescriptorProtos.DescriptorProto value)
    {
      if (nestedTypeBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNestedTypeIsMutable();
        nestedType_.add(index, value);
        onChanged();
      }
      else
      {
        nestedTypeBuilder_.addMessage(index, value);
      }
      return this;
    }
    
    public Builder addNestedType(Builder builderForValue)
    {
      if (nestedTypeBuilder_ == null)
      {
        ensureNestedTypeIsMutable();
        nestedType_.add(builderForValue.build());
        onChanged();
      }
      else
      {
        nestedTypeBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    
    public Builder addNestedType(int index, Builder builderForValue)
    {
      if (nestedTypeBuilder_ == null)
      {
        ensureNestedTypeIsMutable();
        nestedType_.add(index, builderForValue.build());
        onChanged();
      }
      else
      {
        nestedTypeBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addAllNestedType(Iterable<? extends DescriptorProtos.DescriptorProto> values)
    {
      if (nestedTypeBuilder_ == null)
      {
        ensureNestedTypeIsMutable();
        GeneratedMessage.Builder.addAll(values, nestedType_);
        onChanged();
      }
      else
      {
        nestedTypeBuilder_.addAllMessages(values);
      }
      return this;
    }
    
    public Builder clearNestedType()
    {
      if (nestedTypeBuilder_ == null)
      {
        nestedType_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFF7;
        onChanged();
      }
      else
      {
        nestedTypeBuilder_.clear();
      }
      return this;
    }
    
    public Builder removeNestedType(int index)
    {
      if (nestedTypeBuilder_ == null)
      {
        ensureNestedTypeIsMutable();
        nestedType_.remove(index);
        onChanged();
      }
      else
      {
        nestedTypeBuilder_.remove(index);
      }
      return this;
    }
    
    public Builder getNestedTypeBuilder(int index)
    {
      return (Builder)getNestedTypeFieldBuilder().getBuilder(index);
    }
    
    public DescriptorProtos.DescriptorProtoOrBuilder getNestedTypeOrBuilder(int index)
    {
      if (nestedTypeBuilder_ == null) {
        return (DescriptorProtos.DescriptorProtoOrBuilder)nestedType_.get(index);
      }
      return (DescriptorProtos.DescriptorProtoOrBuilder)nestedTypeBuilder_.getMessageOrBuilder(index);
    }
    
    public List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getNestedTypeOrBuilderList()
    {
      if (nestedTypeBuilder_ != null) {
        return nestedTypeBuilder_.getMessageOrBuilderList();
      }
      return Collections.unmodifiableList(nestedType_);
    }
    
    public Builder addNestedTypeBuilder()
    {
      return (Builder)getNestedTypeFieldBuilder().addBuilder(DescriptorProtos.DescriptorProto.getDefaultInstance());
    }
    
    public Builder addNestedTypeBuilder(int index)
    {
      return (Builder)getNestedTypeFieldBuilder().addBuilder(index, DescriptorProtos.DescriptorProto.getDefaultInstance());
    }
    
    public List<Builder> getNestedTypeBuilderList()
    {
      return getNestedTypeFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto, Builder, DescriptorProtos.DescriptorProtoOrBuilder> getNestedTypeFieldBuilder()
    {
      if (nestedTypeBuilder_ == null)
      {
        nestedTypeBuilder_ = new RepeatedFieldBuilder(nestedType_, (bitField0_ & 0x8) == 8, getParentForChildren(), isClean());
        
        nestedType_ = null;
      }
      return nestedTypeBuilder_;
    }
    
    private List<DescriptorProtos.EnumDescriptorProto> enumType_ = Collections.emptyList();
    private RepeatedFieldBuilder<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> enumTypeBuilder_;
    
    private void ensureEnumTypeIsMutable()
    {
      if ((bitField0_ & 0x10) != 16)
      {
        enumType_ = new ArrayList(enumType_);
        bitField0_ |= 0x10;
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
        bitField0_ &= 0xFFFFFFEF;
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
        enumTypeBuilder_ = new RepeatedFieldBuilder(enumType_, (bitField0_ & 0x10) == 16, getParentForChildren(), isClean());
        
        enumType_ = null;
      }
      return enumTypeBuilder_;
    }
    
    private List<DescriptorProtos.DescriptorProto.ExtensionRange> extensionRange_ = Collections.emptyList();
    private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto.ExtensionRange, DescriptorProtos.DescriptorProto.ExtensionRange.Builder, DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> extensionRangeBuilder_;
    
    private void ensureExtensionRangeIsMutable()
    {
      if ((bitField0_ & 0x20) != 32)
      {
        extensionRange_ = new ArrayList(extensionRange_);
        bitField0_ |= 0x20;
      }
    }
    
    public List<DescriptorProtos.DescriptorProto.ExtensionRange> getExtensionRangeList()
    {
      if (extensionRangeBuilder_ == null) {
        return Collections.unmodifiableList(extensionRange_);
      }
      return extensionRangeBuilder_.getMessageList();
    }
    
    public int getExtensionRangeCount()
    {
      if (extensionRangeBuilder_ == null) {
        return extensionRange_.size();
      }
      return extensionRangeBuilder_.getCount();
    }
    
    public DescriptorProtos.DescriptorProto.ExtensionRange getExtensionRange(int index)
    {
      if (extensionRangeBuilder_ == null) {
        return (DescriptorProtos.DescriptorProto.ExtensionRange)extensionRange_.get(index);
      }
      return (DescriptorProtos.DescriptorProto.ExtensionRange)extensionRangeBuilder_.getMessage(index);
    }
    
    public Builder setExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange value)
    {
      if (extensionRangeBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExtensionRangeIsMutable();
        extensionRange_.set(index, value);
        onChanged();
      }
      else
      {
        extensionRangeBuilder_.setMessage(index, value);
      }
      return this;
    }
    
    public Builder setExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange.Builder builderForValue)
    {
      if (extensionRangeBuilder_ == null)
      {
        ensureExtensionRangeIsMutable();
        extensionRange_.set(index, builderForValue.build());
        onChanged();
      }
      else
      {
        extensionRangeBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange value)
    {
      if (extensionRangeBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExtensionRangeIsMutable();
        extensionRange_.add(value);
        onChanged();
      }
      else
      {
        extensionRangeBuilder_.addMessage(value);
      }
      return this;
    }
    
    public Builder addExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange value)
    {
      if (extensionRangeBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExtensionRangeIsMutable();
        extensionRange_.add(index, value);
        onChanged();
      }
      else
      {
        extensionRangeBuilder_.addMessage(index, value);
      }
      return this;
    }
    
    public Builder addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.Builder builderForValue)
    {
      if (extensionRangeBuilder_ == null)
      {
        ensureExtensionRangeIsMutable();
        extensionRange_.add(builderForValue.build());
        onChanged();
      }
      else
      {
        extensionRangeBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    
    public Builder addExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange.Builder builderForValue)
    {
      if (extensionRangeBuilder_ == null)
      {
        ensureExtensionRangeIsMutable();
        extensionRange_.add(index, builderForValue.build());
        onChanged();
      }
      else
      {
        extensionRangeBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addAllExtensionRange(Iterable<? extends DescriptorProtos.DescriptorProto.ExtensionRange> values)
    {
      if (extensionRangeBuilder_ == null)
      {
        ensureExtensionRangeIsMutable();
        GeneratedMessage.Builder.addAll(values, extensionRange_);
        onChanged();
      }
      else
      {
        extensionRangeBuilder_.addAllMessages(values);
      }
      return this;
    }
    
    public Builder clearExtensionRange()
    {
      if (extensionRangeBuilder_ == null)
      {
        extensionRange_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFDF;
        onChanged();
      }
      else
      {
        extensionRangeBuilder_.clear();
      }
      return this;
    }
    
    public Builder removeExtensionRange(int index)
    {
      if (extensionRangeBuilder_ == null)
      {
        ensureExtensionRangeIsMutable();
        extensionRange_.remove(index);
        onChanged();
      }
      else
      {
        extensionRangeBuilder_.remove(index);
      }
      return this;
    }
    
    public DescriptorProtos.DescriptorProto.ExtensionRange.Builder getExtensionRangeBuilder(int index)
    {
      return (DescriptorProtos.DescriptorProto.ExtensionRange.Builder)getExtensionRangeFieldBuilder().getBuilder(index);
    }
    
    public DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int index)
    {
      if (extensionRangeBuilder_ == null) {
        return (DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder)extensionRange_.get(index);
      }
      return (DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder)extensionRangeBuilder_.getMessageOrBuilder(index);
    }
    
    public List<? extends DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList()
    {
      if (extensionRangeBuilder_ != null) {
        return extensionRangeBuilder_.getMessageOrBuilderList();
      }
      return Collections.unmodifiableList(extensionRange_);
    }
    
    public DescriptorProtos.DescriptorProto.ExtensionRange.Builder addExtensionRangeBuilder()
    {
      return (DescriptorProtos.DescriptorProto.ExtensionRange.Builder)getExtensionRangeFieldBuilder().addBuilder(DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance());
    }
    
    public DescriptorProtos.DescriptorProto.ExtensionRange.Builder addExtensionRangeBuilder(int index)
    {
      return (DescriptorProtos.DescriptorProto.ExtensionRange.Builder)getExtensionRangeFieldBuilder().addBuilder(index, DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance());
    }
    
    public List<DescriptorProtos.DescriptorProto.ExtensionRange.Builder> getExtensionRangeBuilderList()
    {
      return getExtensionRangeFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto.ExtensionRange, DescriptorProtos.DescriptorProto.ExtensionRange.Builder, DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> getExtensionRangeFieldBuilder()
    {
      if (extensionRangeBuilder_ == null)
      {
        extensionRangeBuilder_ = new RepeatedFieldBuilder(extensionRange_, (bitField0_ & 0x20) == 32, getParentForChildren(), isClean());
        
        extensionRange_ = null;
      }
      return extensionRangeBuilder_;
    }
    
    private DescriptorProtos.MessageOptions options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
    private SingleFieldBuilder<DescriptorProtos.MessageOptions, DescriptorProtos.MessageOptions.Builder, DescriptorProtos.MessageOptionsOrBuilder> optionsBuilder_;
    
    public boolean hasOptions()
    {
      return (bitField0_ & 0x40) == 64;
    }
    
    public DescriptorProtos.MessageOptions getOptions()
    {
      if (optionsBuilder_ == null) {
        return options_;
      }
      return (DescriptorProtos.MessageOptions)optionsBuilder_.getMessage();
    }
    
    public Builder setOptions(DescriptorProtos.MessageOptions value)
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
      bitField0_ |= 0x40;
      return this;
    }
    
    public Builder setOptions(DescriptorProtos.MessageOptions.Builder builderForValue)
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
      bitField0_ |= 0x40;
      return this;
    }
    
    public Builder mergeOptions(DescriptorProtos.MessageOptions value)
    {
      if (optionsBuilder_ == null)
      {
        if (((bitField0_ & 0x40) == 64) && (options_ != DescriptorProtos.MessageOptions.getDefaultInstance())) {
          options_ = DescriptorProtos.MessageOptions.newBuilder(options_).mergeFrom(value).buildPartial();
        } else {
          options_ = value;
        }
        onChanged();
      }
      else
      {
        optionsBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x40;
      return this;
    }
    
    public Builder clearOptions()
    {
      if (optionsBuilder_ == null)
      {
        options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
        onChanged();
      }
      else
      {
        optionsBuilder_.clear();
      }
      bitField0_ &= 0xFFFFFFBF;
      return this;
    }
    
    public DescriptorProtos.MessageOptions.Builder getOptionsBuilder()
    {
      bitField0_ |= 0x40;
      onChanged();
      return (DescriptorProtos.MessageOptions.Builder)getOptionsFieldBuilder().getBuilder();
    }
    
    public DescriptorProtos.MessageOptionsOrBuilder getOptionsOrBuilder()
    {
      if (optionsBuilder_ != null) {
        return (DescriptorProtos.MessageOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
      }
      return options_;
    }
    
    private SingleFieldBuilder<DescriptorProtos.MessageOptions, DescriptorProtos.MessageOptions.Builder, DescriptorProtos.MessageOptionsOrBuilder> getOptionsFieldBuilder()
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
    defaultInstance = new DescriptorProto(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.DescriptorProto
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */