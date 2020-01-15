package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

public final class DescriptorProtos$DescriptorProto$ExtensionRange
  extends GeneratedMessage
  implements DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
{
  private static final ExtensionRange defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$DescriptorProto$ExtensionRange(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$DescriptorProto$ExtensionRange(boolean noInit)
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
  
  private DescriptorProtos$DescriptorProto$ExtensionRange(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */