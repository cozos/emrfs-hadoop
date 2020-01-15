package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$UninterpretedOption
  extends GeneratedMessage
  implements DescriptorProtos.UninterpretedOptionOrBuilder
{
  private static final UninterpretedOption defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$UninterpretedOption(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$UninterpretedOption(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static UninterpretedOption getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public UninterpretedOption getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$UninterpretedOption(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
        case 18: 
          if ((mutable_bitField0_ & 0x1) != 1)
          {
            name_ = new ArrayList();
            mutable_bitField0_ |= 0x1;
          }
          name_.add(input.readMessage(NamePart.PARSER, extensionRegistry));
          break;
        case 26: 
          bitField0_ |= 0x1;
          identifierValue_ = input.readBytes();
          break;
        case 32: 
          bitField0_ |= 0x2;
          positiveIntValue_ = input.readUInt64();
          break;
        case 40: 
          bitField0_ |= 0x4;
          negativeIntValue_ = input.readInt64();
          break;
        case 49: 
          bitField0_ |= 0x8;
          doubleValue_ = input.readDouble();
          break;
        case 58: 
          bitField0_ |= 0x10;
          stringValue_ = input.readBytes();
          break;
        case 66: 
          bitField0_ |= 0x20;
          aggregateValue_ = input.readBytes();
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
      if ((mutable_bitField0_ & 0x1) == 1) {
        name_ = Collections.unmodifiableList(name_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$17500();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$17600().ensureFieldAccessorsInitialized(UninterpretedOption.class, Builder.class);
  }
  
  public static Parser<UninterpretedOption> PARSER = new AbstractParser()
  {
    public DescriptorProtos.UninterpretedOption parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.UninterpretedOption(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 2;
  private List<NamePart> name_;
  public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
  private Object identifierValue_;
  public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
  private long positiveIntValue_;
  public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
  private long negativeIntValue_;
  public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
  private double doubleValue_;
  public static final int STRING_VALUE_FIELD_NUMBER = 7;
  private ByteString stringValue_;
  public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
  private Object aggregateValue_;
  
  public Parser<UninterpretedOption> getParserForType()
  {
    return PARSER;
  }
  
  public static abstract interface NamePartOrBuilder
    extends MessageOrBuilder
  {
    public abstract boolean hasNamePart();
    
    public abstract String getNamePart();
    
    public abstract ByteString getNamePartBytes();
    
    public abstract boolean hasIsExtension();
    
    public abstract boolean getIsExtension();
  }
  
  public static final class NamePart
    extends GeneratedMessage
    implements DescriptorProtos.UninterpretedOption.NamePartOrBuilder
  {
    private static final NamePart defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private NamePart(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private NamePart(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static NamePart getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public NamePart getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private NamePart(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
            namePart_ = input.readBytes();
            break;
          case 16: 
            bitField0_ |= 0x2;
            isExtension_ = input.readBool();
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
      return DescriptorProtos.access$17800();
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.access$17900().ensureFieldAccessorsInitialized(NamePart.class, Builder.class);
    }
    
    public static Parser<NamePart> PARSER = new AbstractParser()
    {
      public DescriptorProtos.UninterpretedOption.NamePart parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.UninterpretedOption.NamePart(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int NAME_PART_FIELD_NUMBER = 1;
    private Object namePart_;
    public static final int IS_EXTENSION_FIELD_NUMBER = 2;
    private boolean isExtension_;
    
    public Parser<NamePart> getParserForType()
    {
      return PARSER;
    }
    
    public boolean hasNamePart()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public String getNamePart()
    {
      Object ref = namePart_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        namePart_ = s;
      }
      return s;
    }
    
    public ByteString getNamePartBytes()
    {
      Object ref = namePart_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        namePart_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasIsExtension()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public boolean getIsExtension()
    {
      return isExtension_;
    }
    
    private void initFields()
    {
      namePart_ = "";
      isExtension_ = false;
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      if (!hasNamePart())
      {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasIsExtension())
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
        output.writeBytes(1, getNamePartBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeBool(2, isExtension_);
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
        size += CodedOutputStream.computeBytesSize(1, getNamePartBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeBoolSize(2, isExtension_);
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
    
    public static NamePart parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (NamePart)PARSER.parseFrom(data);
    }
    
    public static NamePart parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (NamePart)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static NamePart parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (NamePart)PARSER.parseFrom(data);
    }
    
    public static NamePart parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (NamePart)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static NamePart parseFrom(InputStream input)
      throws IOException
    {
      return (NamePart)PARSER.parseFrom(input);
    }
    
    public static NamePart parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (NamePart)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static NamePart parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (NamePart)PARSER.parseDelimitedFrom(input);
    }
    
    public static NamePart parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (NamePart)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static NamePart parseFrom(CodedInputStream input)
      throws IOException
    {
      return (NamePart)PARSER.parseFrom(input);
    }
    
    public static NamePart parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (NamePart)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$18100();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(NamePart prototype)
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
      implements DescriptorProtos.UninterpretedOption.NamePartOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.access$17800();
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.access$17900().ensureFieldAccessorsInitialized(DescriptorProtos.UninterpretedOption.NamePart.class, Builder.class);
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
        namePart_ = "";
        bitField0_ &= 0xFFFFFFFE;
        isExtension_ = false;
        bitField0_ &= 0xFFFFFFFD;
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.access$17800();
      }
      
      public DescriptorProtos.UninterpretedOption.NamePart getDefaultInstanceForType()
      {
        return DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance();
      }
      
      public DescriptorProtos.UninterpretedOption.NamePart build()
      {
        DescriptorProtos.UninterpretedOption.NamePart result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.UninterpretedOption.NamePart buildPartial()
      {
        DescriptorProtos.UninterpretedOption.NamePart result = new DescriptorProtos.UninterpretedOption.NamePart(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        namePart_ = namePart_;
        if ((from_bitField0_ & 0x2) == 2) {
          to_bitField0_ |= 0x2;
        }
        isExtension_ = isExtension_;
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.UninterpretedOption.NamePart)) {
          return mergeFrom((DescriptorProtos.UninterpretedOption.NamePart)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.UninterpretedOption.NamePart other)
      {
        if (other == DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance()) {
          return this;
        }
        if (other.hasNamePart())
        {
          bitField0_ |= 0x1;
          namePart_ = namePart_;
          onChanged();
        }
        if (other.hasIsExtension()) {
          setIsExtension(other.getIsExtension());
        }
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        if (!hasNamePart()) {
          return false;
        }
        if (!hasIsExtension()) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.UninterpretedOption.NamePart parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.UninterpretedOption.NamePart)DescriptorProtos.UninterpretedOption.NamePart.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.UninterpretedOption.NamePart)e.getUnfinishedMessage();
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
      
      private Object namePart_ = "";
      private boolean isExtension_;
      
      public boolean hasNamePart()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public String getNamePart()
      {
        Object ref = namePart_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          namePart_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getNamePartBytes()
      {
        Object ref = namePart_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          namePart_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setNamePart(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        namePart_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearNamePart()
      {
        bitField0_ &= 0xFFFFFFFE;
        namePart_ = DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance().getNamePart();
        onChanged();
        return this;
      }
      
      public Builder setNamePartBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        namePart_ = value;
        onChanged();
        return this;
      }
      
      public boolean hasIsExtension()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public boolean getIsExtension()
      {
        return isExtension_;
      }
      
      public Builder setIsExtension(boolean value)
      {
        bitField0_ |= 0x2;
        isExtension_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearIsExtension()
      {
        bitField0_ &= 0xFFFFFFFD;
        isExtension_ = false;
        onChanged();
        return this;
      }
    }
    
    static
    {
      defaultInstance = new NamePart(true);
      defaultInstance.initFields();
    }
  }
  
  public List<NamePart> getNameList()
  {
    return name_;
  }
  
  public List<? extends NamePartOrBuilder> getNameOrBuilderList()
  {
    return name_;
  }
  
  public int getNameCount()
  {
    return name_.size();
  }
  
  public NamePart getName(int index)
  {
    return (NamePart)name_.get(index);
  }
  
  public NamePartOrBuilder getNameOrBuilder(int index)
  {
    return (NamePartOrBuilder)name_.get(index);
  }
  
  public boolean hasIdentifierValue()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public String getIdentifierValue()
  {
    Object ref = identifierValue_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      identifierValue_ = s;
    }
    return s;
  }
  
  public ByteString getIdentifierValueBytes()
  {
    Object ref = identifierValue_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      identifierValue_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public boolean hasPositiveIntValue()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public long getPositiveIntValue()
  {
    return positiveIntValue_;
  }
  
  public boolean hasNegativeIntValue()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public long getNegativeIntValue()
  {
    return negativeIntValue_;
  }
  
  public boolean hasDoubleValue()
  {
    return (bitField0_ & 0x8) == 8;
  }
  
  public double getDoubleValue()
  {
    return doubleValue_;
  }
  
  public boolean hasStringValue()
  {
    return (bitField0_ & 0x10) == 16;
  }
  
  public ByteString getStringValue()
  {
    return stringValue_;
  }
  
  public boolean hasAggregateValue()
  {
    return (bitField0_ & 0x20) == 32;
  }
  
  public String getAggregateValue()
  {
    Object ref = aggregateValue_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      aggregateValue_ = s;
    }
    return s;
  }
  
  public ByteString getAggregateValueBytes()
  {
    Object ref = aggregateValue_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      aggregateValue_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  private void initFields()
  {
    name_ = Collections.emptyList();
    identifierValue_ = "";
    positiveIntValue_ = 0L;
    negativeIntValue_ = 0L;
    doubleValue_ = 0.0D;
    stringValue_ = ByteString.EMPTY;
    aggregateValue_ = "";
  }
  
  private byte memoizedIsInitialized = -1;
  
  public final boolean isInitialized()
  {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) {
      return isInitialized == 1;
    }
    for (int i = 0; i < getNameCount(); i++) {
      if (!getName(i).isInitialized())
      {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    memoizedIsInitialized = 1;
    return true;
  }
  
  public void writeTo(CodedOutputStream output)
    throws IOException
  {
    getSerializedSize();
    for (int i = 0; i < name_.size(); i++) {
      output.writeMessage(2, (MessageLite)name_.get(i));
    }
    if ((bitField0_ & 0x1) == 1) {
      output.writeBytes(3, getIdentifierValueBytes());
    }
    if ((bitField0_ & 0x2) == 2) {
      output.writeUInt64(4, positiveIntValue_);
    }
    if ((bitField0_ & 0x4) == 4) {
      output.writeInt64(5, negativeIntValue_);
    }
    if ((bitField0_ & 0x8) == 8) {
      output.writeDouble(6, doubleValue_);
    }
    if ((bitField0_ & 0x10) == 16) {
      output.writeBytes(7, stringValue_);
    }
    if ((bitField0_ & 0x20) == 32) {
      output.writeBytes(8, getAggregateValueBytes());
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
    for (int i = 0; i < name_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(2, (MessageLite)name_.get(i));
    }
    if ((bitField0_ & 0x1) == 1) {
      size += CodedOutputStream.computeBytesSize(3, getIdentifierValueBytes());
    }
    if ((bitField0_ & 0x2) == 2) {
      size += CodedOutputStream.computeUInt64Size(4, positiveIntValue_);
    }
    if ((bitField0_ & 0x4) == 4) {
      size += CodedOutputStream.computeInt64Size(5, negativeIntValue_);
    }
    if ((bitField0_ & 0x8) == 8) {
      size += CodedOutputStream.computeDoubleSize(6, doubleValue_);
    }
    if ((bitField0_ & 0x10) == 16) {
      size += CodedOutputStream.computeBytesSize(7, stringValue_);
    }
    if ((bitField0_ & 0x20) == 32) {
      size += CodedOutputStream.computeBytesSize(8, getAggregateValueBytes());
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
  
  public static UninterpretedOption parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (UninterpretedOption)PARSER.parseFrom(data);
  }
  
  public static UninterpretedOption parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (UninterpretedOption)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static UninterpretedOption parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (UninterpretedOption)PARSER.parseFrom(data);
  }
  
  public static UninterpretedOption parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (UninterpretedOption)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static UninterpretedOption parseFrom(InputStream input)
    throws IOException
  {
    return (UninterpretedOption)PARSER.parseFrom(input);
  }
  
  public static UninterpretedOption parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (UninterpretedOption)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static UninterpretedOption parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (UninterpretedOption)PARSER.parseDelimitedFrom(input);
  }
  
  public static UninterpretedOption parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (UninterpretedOption)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static UninterpretedOption parseFrom(CodedInputStream input)
    throws IOException
  {
    return (UninterpretedOption)PARSER.parseFrom(input);
  }
  
  public static UninterpretedOption parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (UninterpretedOption)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$18700();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(UninterpretedOption prototype)
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
    implements DescriptorProtos.UninterpretedOptionOrBuilder
  {
    private int bitField0_;
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.access$17500();
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.access$17600().ensureFieldAccessorsInitialized(DescriptorProtos.UninterpretedOption.class, Builder.class);
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
        getNameFieldBuilder();
      }
    }
    
    private static Builder create()
    {
      return new Builder();
    }
    
    public Builder clear()
    {
      super.clear();
      if (nameBuilder_ == null)
      {
        name_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFFE;
      }
      else
      {
        nameBuilder_.clear();
      }
      identifierValue_ = "";
      bitField0_ &= 0xFFFFFFFD;
      positiveIntValue_ = 0L;
      bitField0_ &= 0xFFFFFFFB;
      negativeIntValue_ = 0L;
      bitField0_ &= 0xFFFFFFF7;
      doubleValue_ = 0.0D;
      bitField0_ &= 0xFFFFFFEF;
      stringValue_ = ByteString.EMPTY;
      bitField0_ &= 0xFFFFFFDF;
      aggregateValue_ = "";
      bitField0_ &= 0xFFFFFFBF;
      return this;
    }
    
    public Builder clone()
    {
      return create().mergeFrom(buildPartial());
    }
    
    public Descriptors.Descriptor getDescriptorForType()
    {
      return DescriptorProtos.access$17500();
    }
    
    public DescriptorProtos.UninterpretedOption getDefaultInstanceForType()
    {
      return DescriptorProtos.UninterpretedOption.getDefaultInstance();
    }
    
    public DescriptorProtos.UninterpretedOption build()
    {
      DescriptorProtos.UninterpretedOption result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }
    
    public DescriptorProtos.UninterpretedOption buildPartial()
    {
      DescriptorProtos.UninterpretedOption result = new DescriptorProtos.UninterpretedOption(this, null);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (nameBuilder_ == null)
      {
        if ((bitField0_ & 0x1) == 1)
        {
          name_ = Collections.unmodifiableList(name_);
          bitField0_ &= 0xFFFFFFFE;
        }
        name_ = name_;
      }
      else
      {
        name_ = nameBuilder_.build();
      }
      if ((from_bitField0_ & 0x2) == 2) {
        to_bitField0_ |= 0x1;
      }
      identifierValue_ = identifierValue_;
      if ((from_bitField0_ & 0x4) == 4) {
        to_bitField0_ |= 0x2;
      }
      positiveIntValue_ = positiveIntValue_;
      if ((from_bitField0_ & 0x8) == 8) {
        to_bitField0_ |= 0x4;
      }
      negativeIntValue_ = negativeIntValue_;
      if ((from_bitField0_ & 0x10) == 16) {
        to_bitField0_ |= 0x8;
      }
      doubleValue_ = doubleValue_;
      if ((from_bitField0_ & 0x20) == 32) {
        to_bitField0_ |= 0x10;
      }
      stringValue_ = stringValue_;
      if ((from_bitField0_ & 0x40) == 64) {
        to_bitField0_ |= 0x20;
      }
      aggregateValue_ = aggregateValue_;
      bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }
    
    public Builder mergeFrom(Message other)
    {
      if ((other instanceof DescriptorProtos.UninterpretedOption)) {
        return mergeFrom((DescriptorProtos.UninterpretedOption)other);
      }
      super.mergeFrom(other);
      return this;
    }
    
    public Builder mergeFrom(DescriptorProtos.UninterpretedOption other)
    {
      if (other == DescriptorProtos.UninterpretedOption.getDefaultInstance()) {
        return this;
      }
      if (nameBuilder_ == null)
      {
        if (!name_.isEmpty())
        {
          if (name_.isEmpty())
          {
            name_ = name_;
            bitField0_ &= 0xFFFFFFFE;
          }
          else
          {
            ensureNameIsMutable();
            name_.addAll(name_);
          }
          onChanged();
        }
      }
      else if (!name_.isEmpty()) {
        if (nameBuilder_.isEmpty())
        {
          nameBuilder_.dispose();
          nameBuilder_ = null;
          name_ = name_;
          bitField0_ &= 0xFFFFFFFE;
          nameBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getNameFieldBuilder() : null);
        }
        else
        {
          nameBuilder_.addAllMessages(name_);
        }
      }
      if (other.hasIdentifierValue())
      {
        bitField0_ |= 0x2;
        identifierValue_ = identifierValue_;
        onChanged();
      }
      if (other.hasPositiveIntValue()) {
        setPositiveIntValue(other.getPositiveIntValue());
      }
      if (other.hasNegativeIntValue()) {
        setNegativeIntValue(other.getNegativeIntValue());
      }
      if (other.hasDoubleValue()) {
        setDoubleValue(other.getDoubleValue());
      }
      if (other.hasStringValue()) {
        setStringValue(other.getStringValue());
      }
      if (other.hasAggregateValue())
      {
        bitField0_ |= 0x40;
        aggregateValue_ = aggregateValue_;
        onChanged();
      }
      mergeUnknownFields(other.getUnknownFields());
      return this;
    }
    
    public final boolean isInitialized()
    {
      for (int i = 0; i < getNameCount(); i++) {
        if (!getName(i).isInitialized()) {
          return false;
        }
      }
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      DescriptorProtos.UninterpretedOption parsedMessage = null;
      try
      {
        parsedMessage = (DescriptorProtos.UninterpretedOption)DescriptorProtos.UninterpretedOption.PARSER.parsePartialFrom(input, extensionRegistry);
      }
      catch (InvalidProtocolBufferException e)
      {
        parsedMessage = (DescriptorProtos.UninterpretedOption)e.getUnfinishedMessage();
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
    
    private List<DescriptorProtos.UninterpretedOption.NamePart> name_ = Collections.emptyList();
    private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption.NamePart, DescriptorProtos.UninterpretedOption.NamePart.Builder, DescriptorProtos.UninterpretedOption.NamePartOrBuilder> nameBuilder_;
    
    private void ensureNameIsMutable()
    {
      if ((bitField0_ & 0x1) != 1)
      {
        name_ = new ArrayList(name_);
        bitField0_ |= 0x1;
      }
    }
    
    public List<DescriptorProtos.UninterpretedOption.NamePart> getNameList()
    {
      if (nameBuilder_ == null) {
        return Collections.unmodifiableList(name_);
      }
      return nameBuilder_.getMessageList();
    }
    
    public int getNameCount()
    {
      if (nameBuilder_ == null) {
        return name_.size();
      }
      return nameBuilder_.getCount();
    }
    
    public DescriptorProtos.UninterpretedOption.NamePart getName(int index)
    {
      if (nameBuilder_ == null) {
        return (DescriptorProtos.UninterpretedOption.NamePart)name_.get(index);
      }
      return (DescriptorProtos.UninterpretedOption.NamePart)nameBuilder_.getMessage(index);
    }
    
    public Builder setName(int index, DescriptorProtos.UninterpretedOption.NamePart value)
    {
      if (nameBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNameIsMutable();
        name_.set(index, value);
        onChanged();
      }
      else
      {
        nameBuilder_.setMessage(index, value);
      }
      return this;
    }
    
    public Builder setName(int index, DescriptorProtos.UninterpretedOption.NamePart.Builder builderForValue)
    {
      if (nameBuilder_ == null)
      {
        ensureNameIsMutable();
        name_.set(index, builderForValue.build());
        onChanged();
      }
      else
      {
        nameBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addName(DescriptorProtos.UninterpretedOption.NamePart value)
    {
      if (nameBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNameIsMutable();
        name_.add(value);
        onChanged();
      }
      else
      {
        nameBuilder_.addMessage(value);
      }
      return this;
    }
    
    public Builder addName(int index, DescriptorProtos.UninterpretedOption.NamePart value)
    {
      if (nameBuilder_ == null)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNameIsMutable();
        name_.add(index, value);
        onChanged();
      }
      else
      {
        nameBuilder_.addMessage(index, value);
      }
      return this;
    }
    
    public Builder addName(DescriptorProtos.UninterpretedOption.NamePart.Builder builderForValue)
    {
      if (nameBuilder_ == null)
      {
        ensureNameIsMutable();
        name_.add(builderForValue.build());
        onChanged();
      }
      else
      {
        nameBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    
    public Builder addName(int index, DescriptorProtos.UninterpretedOption.NamePart.Builder builderForValue)
    {
      if (nameBuilder_ == null)
      {
        ensureNameIsMutable();
        name_.add(index, builderForValue.build());
        onChanged();
      }
      else
      {
        nameBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    
    public Builder addAllName(Iterable<? extends DescriptorProtos.UninterpretedOption.NamePart> values)
    {
      if (nameBuilder_ == null)
      {
        ensureNameIsMutable();
        GeneratedMessage.Builder.addAll(values, name_);
        onChanged();
      }
      else
      {
        nameBuilder_.addAllMessages(values);
      }
      return this;
    }
    
    public Builder clearName()
    {
      if (nameBuilder_ == null)
      {
        name_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFFE;
        onChanged();
      }
      else
      {
        nameBuilder_.clear();
      }
      return this;
    }
    
    public Builder removeName(int index)
    {
      if (nameBuilder_ == null)
      {
        ensureNameIsMutable();
        name_.remove(index);
        onChanged();
      }
      else
      {
        nameBuilder_.remove(index);
      }
      return this;
    }
    
    public DescriptorProtos.UninterpretedOption.NamePart.Builder getNameBuilder(int index)
    {
      return (DescriptorProtos.UninterpretedOption.NamePart.Builder)getNameFieldBuilder().getBuilder(index);
    }
    
    public DescriptorProtos.UninterpretedOption.NamePartOrBuilder getNameOrBuilder(int index)
    {
      if (nameBuilder_ == null) {
        return (DescriptorProtos.UninterpretedOption.NamePartOrBuilder)name_.get(index);
      }
      return (DescriptorProtos.UninterpretedOption.NamePartOrBuilder)nameBuilder_.getMessageOrBuilder(index);
    }
    
    public List<? extends DescriptorProtos.UninterpretedOption.NamePartOrBuilder> getNameOrBuilderList()
    {
      if (nameBuilder_ != null) {
        return nameBuilder_.getMessageOrBuilderList();
      }
      return Collections.unmodifiableList(name_);
    }
    
    public DescriptorProtos.UninterpretedOption.NamePart.Builder addNameBuilder()
    {
      return (DescriptorProtos.UninterpretedOption.NamePart.Builder)getNameFieldBuilder().addBuilder(DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance());
    }
    
    public DescriptorProtos.UninterpretedOption.NamePart.Builder addNameBuilder(int index)
    {
      return (DescriptorProtos.UninterpretedOption.NamePart.Builder)getNameFieldBuilder().addBuilder(index, DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance());
    }
    
    public List<DescriptorProtos.UninterpretedOption.NamePart.Builder> getNameBuilderList()
    {
      return getNameFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption.NamePart, DescriptorProtos.UninterpretedOption.NamePart.Builder, DescriptorProtos.UninterpretedOption.NamePartOrBuilder> getNameFieldBuilder()
    {
      if (nameBuilder_ == null)
      {
        nameBuilder_ = new RepeatedFieldBuilder(name_, (bitField0_ & 0x1) == 1, getParentForChildren(), isClean());
        
        name_ = null;
      }
      return nameBuilder_;
    }
    
    private Object identifierValue_ = "";
    private long positiveIntValue_;
    private long negativeIntValue_;
    private double doubleValue_;
    
    public boolean hasIdentifierValue()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public String getIdentifierValue()
    {
      Object ref = identifierValue_;
      if (!(ref instanceof String))
      {
        String s = ((ByteString)ref).toStringUtf8();
        
        identifierValue_ = s;
        return s;
      }
      return (String)ref;
    }
    
    public ByteString getIdentifierValueBytes()
    {
      Object ref = identifierValue_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        identifierValue_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public Builder setIdentifierValue(String value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x2;
      identifierValue_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearIdentifierValue()
    {
      bitField0_ &= 0xFFFFFFFD;
      identifierValue_ = DescriptorProtos.UninterpretedOption.getDefaultInstance().getIdentifierValue();
      onChanged();
      return this;
    }
    
    public Builder setIdentifierValueBytes(ByteString value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x2;
      identifierValue_ = value;
      onChanged();
      return this;
    }
    
    public boolean hasPositiveIntValue()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public long getPositiveIntValue()
    {
      return positiveIntValue_;
    }
    
    public Builder setPositiveIntValue(long value)
    {
      bitField0_ |= 0x4;
      positiveIntValue_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearPositiveIntValue()
    {
      bitField0_ &= 0xFFFFFFFB;
      positiveIntValue_ = 0L;
      onChanged();
      return this;
    }
    
    public boolean hasNegativeIntValue()
    {
      return (bitField0_ & 0x8) == 8;
    }
    
    public long getNegativeIntValue()
    {
      return negativeIntValue_;
    }
    
    public Builder setNegativeIntValue(long value)
    {
      bitField0_ |= 0x8;
      negativeIntValue_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearNegativeIntValue()
    {
      bitField0_ &= 0xFFFFFFF7;
      negativeIntValue_ = 0L;
      onChanged();
      return this;
    }
    
    public boolean hasDoubleValue()
    {
      return (bitField0_ & 0x10) == 16;
    }
    
    public double getDoubleValue()
    {
      return doubleValue_;
    }
    
    public Builder setDoubleValue(double value)
    {
      bitField0_ |= 0x10;
      doubleValue_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearDoubleValue()
    {
      bitField0_ &= 0xFFFFFFEF;
      doubleValue_ = 0.0D;
      onChanged();
      return this;
    }
    
    private ByteString stringValue_ = ByteString.EMPTY;
    
    public boolean hasStringValue()
    {
      return (bitField0_ & 0x20) == 32;
    }
    
    public ByteString getStringValue()
    {
      return stringValue_;
    }
    
    public Builder setStringValue(ByteString value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x20;
      stringValue_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearStringValue()
    {
      bitField0_ &= 0xFFFFFFDF;
      stringValue_ = DescriptorProtos.UninterpretedOption.getDefaultInstance().getStringValue();
      onChanged();
      return this;
    }
    
    private Object aggregateValue_ = "";
    
    public boolean hasAggregateValue()
    {
      return (bitField0_ & 0x40) == 64;
    }
    
    public String getAggregateValue()
    {
      Object ref = aggregateValue_;
      if (!(ref instanceof String))
      {
        String s = ((ByteString)ref).toStringUtf8();
        
        aggregateValue_ = s;
        return s;
      }
      return (String)ref;
    }
    
    public ByteString getAggregateValueBytes()
    {
      Object ref = aggregateValue_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        aggregateValue_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public Builder setAggregateValue(String value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x40;
      aggregateValue_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearAggregateValue()
    {
      bitField0_ &= 0xFFFFFFBF;
      aggregateValue_ = DescriptorProtos.UninterpretedOption.getDefaultInstance().getAggregateValue();
      onChanged();
      return this;
    }
    
    public Builder setAggregateValueBytes(ByteString value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x40;
      aggregateValue_ = value;
      onChanged();
      return this;
    }
  }
  
  static
  {
    defaultInstance = new UninterpretedOption(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.UninterpretedOption
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */