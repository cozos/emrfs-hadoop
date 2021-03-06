package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$SourceCodeInfo$Location
  extends GeneratedMessage
  implements DescriptorProtos.SourceCodeInfo.LocationOrBuilder
{
  private static final Location defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$SourceCodeInfo$Location(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$SourceCodeInfo$Location(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static Location getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public Location getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$SourceCodeInfo$Location(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          if ((mutable_bitField0_ & 0x1) != 1)
          {
            path_ = new ArrayList();
            mutable_bitField0_ |= 0x1;
          }
          path_.add(Integer.valueOf(input.readInt32()));
          break;
        case 10: 
          int length = input.readRawVarint32();
          int limit = input.pushLimit(length);
          if (((mutable_bitField0_ & 0x1) != 1) && (input.getBytesUntilLimit() > 0))
          {
            path_ = new ArrayList();
            mutable_bitField0_ |= 0x1;
          }
          while (input.getBytesUntilLimit() > 0) {
            path_.add(Integer.valueOf(input.readInt32()));
          }
          input.popLimit(limit);
          break;
        case 16: 
          if ((mutable_bitField0_ & 0x2) != 2)
          {
            span_ = new ArrayList();
            mutable_bitField0_ |= 0x2;
          }
          span_.add(Integer.valueOf(input.readInt32()));
          break;
        case 18: 
          int length = input.readRawVarint32();
          int limit = input.pushLimit(length);
          if (((mutable_bitField0_ & 0x2) != 2) && (input.getBytesUntilLimit() > 0))
          {
            span_ = new ArrayList();
            mutable_bitField0_ |= 0x2;
          }
          while (input.getBytesUntilLimit() > 0) {
            span_.add(Integer.valueOf(input.readInt32()));
          }
          input.popLimit(limit);
          break;
        case 26: 
          bitField0_ |= 0x1;
          leadingComments_ = input.readBytes();
          break;
        case 34: 
          bitField0_ |= 0x2;
          trailingComments_ = input.readBytes();
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
        path_ = Collections.unmodifiableList(path_);
      }
      if ((mutable_bitField0_ & 0x2) == 2) {
        span_ = Collections.unmodifiableList(span_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$20100();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$20200().ensureFieldAccessorsInitialized(Location.class, Builder.class);
  }
  
  public static Parser<Location> PARSER = new AbstractParser()
  {
    public DescriptorProtos.SourceCodeInfo.Location parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.SourceCodeInfo.Location(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int PATH_FIELD_NUMBER = 1;
  private List<Integer> path_;
  
  public Parser<Location> getParserForType()
  {
    return PARSER;
  }
  
  public List<Integer> getPathList()
  {
    return path_;
  }
  
  public int getPathCount()
  {
    return path_.size();
  }
  
  public int getPath(int index)
  {
    return ((Integer)path_.get(index)).intValue();
  }
  
  private int pathMemoizedSerializedSize = -1;
  public static final int SPAN_FIELD_NUMBER = 2;
  private List<Integer> span_;
  
  public List<Integer> getSpanList()
  {
    return span_;
  }
  
  public int getSpanCount()
  {
    return span_.size();
  }
  
  public int getSpan(int index)
  {
    return ((Integer)span_.get(index)).intValue();
  }
  
  private int spanMemoizedSerializedSize = -1;
  public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
  private Object leadingComments_;
  public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
  private Object trailingComments_;
  
  public boolean hasLeadingComments()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public String getLeadingComments()
  {
    Object ref = leadingComments_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      leadingComments_ = s;
    }
    return s;
  }
  
  public ByteString getLeadingCommentsBytes()
  {
    Object ref = leadingComments_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      leadingComments_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public boolean hasTrailingComments()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public String getTrailingComments()
  {
    Object ref = trailingComments_;
    if ((ref instanceof String)) {
      return (String)ref;
    }
    ByteString bs = (ByteString)ref;
    
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      trailingComments_ = s;
    }
    return s;
  }
  
  public ByteString getTrailingCommentsBytes()
  {
    Object ref = trailingComments_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      trailingComments_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  private void initFields()
  {
    path_ = Collections.emptyList();
    span_ = Collections.emptyList();
    leadingComments_ = "";
    trailingComments_ = "";
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
    if (getPathList().size() > 0)
    {
      output.writeRawVarint32(10);
      output.writeRawVarint32(pathMemoizedSerializedSize);
    }
    for (int i = 0; i < path_.size(); i++) {
      output.writeInt32NoTag(((Integer)path_.get(i)).intValue());
    }
    if (getSpanList().size() > 0)
    {
      output.writeRawVarint32(18);
      output.writeRawVarint32(spanMemoizedSerializedSize);
    }
    for (int i = 0; i < span_.size(); i++) {
      output.writeInt32NoTag(((Integer)span_.get(i)).intValue());
    }
    if ((bitField0_ & 0x1) == 1) {
      output.writeBytes(3, getLeadingCommentsBytes());
    }
    if ((bitField0_ & 0x2) == 2) {
      output.writeBytes(4, getTrailingCommentsBytes());
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
    
    int dataSize = 0;
    for (int i = 0; i < path_.size(); i++) {
      dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)path_.get(i)).intValue());
    }
    size += dataSize;
    if (!getPathList().isEmpty())
    {
      size++;
      size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
    }
    pathMemoizedSerializedSize = dataSize;
    
    int dataSize = 0;
    for (int i = 0; i < span_.size(); i++) {
      dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)span_.get(i)).intValue());
    }
    size += dataSize;
    if (!getSpanList().isEmpty())
    {
      size++;
      size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
    }
    spanMemoizedSerializedSize = dataSize;
    if ((bitField0_ & 0x1) == 1) {
      size += CodedOutputStream.computeBytesSize(3, getLeadingCommentsBytes());
    }
    if ((bitField0_ & 0x2) == 2) {
      size += CodedOutputStream.computeBytesSize(4, getTrailingCommentsBytes());
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
  
  public static Location parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (Location)PARSER.parseFrom(data);
  }
  
  public static Location parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (Location)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static Location parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (Location)PARSER.parseFrom(data);
  }
  
  public static Location parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (Location)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static Location parseFrom(InputStream input)
    throws IOException
  {
    return (Location)PARSER.parseFrom(input);
  }
  
  public static Location parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (Location)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Location parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (Location)PARSER.parseDelimitedFrom(input);
  }
  
  public static Location parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (Location)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static Location parseFrom(CodedInputStream input)
    throws IOException
  {
    return (Location)PARSER.parseFrom(input);
  }
  
  public static Location parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (Location)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$20400();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(Location prototype)
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
    implements DescriptorProtos.SourceCodeInfo.LocationOrBuilder
  {
    private int bitField0_;
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.access$20100();
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.access$20200().ensureFieldAccessorsInitialized(DescriptorProtos.SourceCodeInfo.Location.class, Builder.class);
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
      path_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFE;
      span_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFD;
      leadingComments_ = "";
      bitField0_ &= 0xFFFFFFFB;
      trailingComments_ = "";
      bitField0_ &= 0xFFFFFFF7;
      return this;
    }
    
    public Builder clone()
    {
      return create().mergeFrom(buildPartial());
    }
    
    public Descriptors.Descriptor getDescriptorForType()
    {
      return DescriptorProtos.access$20100();
    }
    
    public DescriptorProtos.SourceCodeInfo.Location getDefaultInstanceForType()
    {
      return DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance();
    }
    
    public DescriptorProtos.SourceCodeInfo.Location build()
    {
      DescriptorProtos.SourceCodeInfo.Location result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }
    
    public DescriptorProtos.SourceCodeInfo.Location buildPartial()
    {
      DescriptorProtos.SourceCodeInfo.Location result = new DescriptorProtos.SourceCodeInfo.Location(this, null);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if ((bitField0_ & 0x1) == 1)
      {
        path_ = Collections.unmodifiableList(path_);
        bitField0_ &= 0xFFFFFFFE;
      }
      path_ = path_;
      if ((bitField0_ & 0x2) == 2)
      {
        span_ = Collections.unmodifiableList(span_);
        bitField0_ &= 0xFFFFFFFD;
      }
      span_ = span_;
      if ((from_bitField0_ & 0x4) == 4) {
        to_bitField0_ |= 0x1;
      }
      leadingComments_ = leadingComments_;
      if ((from_bitField0_ & 0x8) == 8) {
        to_bitField0_ |= 0x2;
      }
      trailingComments_ = trailingComments_;
      bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }
    
    public Builder mergeFrom(Message other)
    {
      if ((other instanceof DescriptorProtos.SourceCodeInfo.Location)) {
        return mergeFrom((DescriptorProtos.SourceCodeInfo.Location)other);
      }
      super.mergeFrom(other);
      return this;
    }
    
    public Builder mergeFrom(DescriptorProtos.SourceCodeInfo.Location other)
    {
      if (other == DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance()) {
        return this;
      }
      if (!path_.isEmpty())
      {
        if (path_.isEmpty())
        {
          path_ = path_;
          bitField0_ &= 0xFFFFFFFE;
        }
        else
        {
          ensurePathIsMutable();
          path_.addAll(path_);
        }
        onChanged();
      }
      if (!span_.isEmpty())
      {
        if (span_.isEmpty())
        {
          span_ = span_;
          bitField0_ &= 0xFFFFFFFD;
        }
        else
        {
          ensureSpanIsMutable();
          span_.addAll(span_);
        }
        onChanged();
      }
      if (other.hasLeadingComments())
      {
        bitField0_ |= 0x4;
        leadingComments_ = leadingComments_;
        onChanged();
      }
      if (other.hasTrailingComments())
      {
        bitField0_ |= 0x8;
        trailingComments_ = trailingComments_;
        onChanged();
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
      DescriptorProtos.SourceCodeInfo.Location parsedMessage = null;
      try
      {
        parsedMessage = (DescriptorProtos.SourceCodeInfo.Location)DescriptorProtos.SourceCodeInfo.Location.PARSER.parsePartialFrom(input, extensionRegistry);
      }
      catch (InvalidProtocolBufferException e)
      {
        parsedMessage = (DescriptorProtos.SourceCodeInfo.Location)e.getUnfinishedMessage();
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
    
    private List<Integer> path_ = Collections.emptyList();
    
    private void ensurePathIsMutable()
    {
      if ((bitField0_ & 0x1) != 1)
      {
        path_ = new ArrayList(path_);
        bitField0_ |= 0x1;
      }
    }
    
    public List<Integer> getPathList()
    {
      return Collections.unmodifiableList(path_);
    }
    
    public int getPathCount()
    {
      return path_.size();
    }
    
    public int getPath(int index)
    {
      return ((Integer)path_.get(index)).intValue();
    }
    
    public Builder setPath(int index, int value)
    {
      ensurePathIsMutable();
      path_.set(index, Integer.valueOf(value));
      onChanged();
      return this;
    }
    
    public Builder addPath(int value)
    {
      ensurePathIsMutable();
      path_.add(Integer.valueOf(value));
      onChanged();
      return this;
    }
    
    public Builder addAllPath(Iterable<? extends Integer> values)
    {
      ensurePathIsMutable();
      GeneratedMessage.Builder.addAll(values, path_);
      onChanged();
      return this;
    }
    
    public Builder clearPath()
    {
      path_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFE;
      onChanged();
      return this;
    }
    
    private List<Integer> span_ = Collections.emptyList();
    
    private void ensureSpanIsMutable()
    {
      if ((bitField0_ & 0x2) != 2)
      {
        span_ = new ArrayList(span_);
        bitField0_ |= 0x2;
      }
    }
    
    public List<Integer> getSpanList()
    {
      return Collections.unmodifiableList(span_);
    }
    
    public int getSpanCount()
    {
      return span_.size();
    }
    
    public int getSpan(int index)
    {
      return ((Integer)span_.get(index)).intValue();
    }
    
    public Builder setSpan(int index, int value)
    {
      ensureSpanIsMutable();
      span_.set(index, Integer.valueOf(value));
      onChanged();
      return this;
    }
    
    public Builder addSpan(int value)
    {
      ensureSpanIsMutable();
      span_.add(Integer.valueOf(value));
      onChanged();
      return this;
    }
    
    public Builder addAllSpan(Iterable<? extends Integer> values)
    {
      ensureSpanIsMutable();
      GeneratedMessage.Builder.addAll(values, span_);
      onChanged();
      return this;
    }
    
    public Builder clearSpan()
    {
      span_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFD;
      onChanged();
      return this;
    }
    
    private Object leadingComments_ = "";
    
    public boolean hasLeadingComments()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public String getLeadingComments()
    {
      Object ref = leadingComments_;
      if (!(ref instanceof String))
      {
        String s = ((ByteString)ref).toStringUtf8();
        
        leadingComments_ = s;
        return s;
      }
      return (String)ref;
    }
    
    public ByteString getLeadingCommentsBytes()
    {
      Object ref = leadingComments_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        leadingComments_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public Builder setLeadingComments(String value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x4;
      leadingComments_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearLeadingComments()
    {
      bitField0_ &= 0xFFFFFFFB;
      leadingComments_ = DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance().getLeadingComments();
      onChanged();
      return this;
    }
    
    public Builder setLeadingCommentsBytes(ByteString value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x4;
      leadingComments_ = value;
      onChanged();
      return this;
    }
    
    private Object trailingComments_ = "";
    
    public boolean hasTrailingComments()
    {
      return (bitField0_ & 0x8) == 8;
    }
    
    public String getTrailingComments()
    {
      Object ref = trailingComments_;
      if (!(ref instanceof String))
      {
        String s = ((ByteString)ref).toStringUtf8();
        
        trailingComments_ = s;
        return s;
      }
      return (String)ref;
    }
    
    public ByteString getTrailingCommentsBytes()
    {
      Object ref = trailingComments_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        trailingComments_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public Builder setTrailingComments(String value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x8;
      trailingComments_ = value;
      onChanged();
      return this;
    }
    
    public Builder clearTrailingComments()
    {
      bitField0_ &= 0xFFFFFFF7;
      trailingComments_ = DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance().getTrailingComments();
      onChanged();
      return this;
    }
    
    public Builder setTrailingCommentsBytes(ByteString value)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x8;
      trailingComments_ = value;
      onChanged();
      return this;
    }
  }
  
  static
  {
    defaultInstance = new Location(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */