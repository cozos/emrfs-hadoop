package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

public final class DescriptorProtos$UninterpretedOption$NamePart
  extends GeneratedMessage
  implements DescriptorProtos.UninterpretedOption.NamePartOrBuilder
{
  private static final NamePart defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$UninterpretedOption$NamePart(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$UninterpretedOption$NamePart(boolean noInit)
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
  
  private DescriptorProtos$UninterpretedOption$NamePart(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePart
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */