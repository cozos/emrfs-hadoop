package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$SourceCodeInfo$Location$Builder
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
  
  private DescriptorProtos$SourceCodeInfo$Location$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$SourceCodeInfo$Location$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
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
    DescriptorProtos.SourceCodeInfo.Location.access$20702(result, path_);
    if ((bitField0_ & 0x2) == 2)
    {
      span_ = Collections.unmodifiableList(span_);
      bitField0_ &= 0xFFFFFFFD;
    }
    DescriptorProtos.SourceCodeInfo.Location.access$20802(result, span_);
    if ((from_bitField0_ & 0x4) == 4) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.SourceCodeInfo.Location.access$20902(result, leadingComments_);
    if ((from_bitField0_ & 0x8) == 8) {
      to_bitField0_ |= 0x2;
    }
    DescriptorProtos.SourceCodeInfo.Location.access$21002(result, trailingComments_);
    DescriptorProtos.SourceCodeInfo.Location.access$21102(result, to_bitField0_);
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
    if (!DescriptorProtos.SourceCodeInfo.Location.access$20700(other).isEmpty())
    {
      if (path_.isEmpty())
      {
        path_ = DescriptorProtos.SourceCodeInfo.Location.access$20700(other);
        bitField0_ &= 0xFFFFFFFE;
      }
      else
      {
        ensurePathIsMutable();
        path_.addAll(DescriptorProtos.SourceCodeInfo.Location.access$20700(other));
      }
      onChanged();
    }
    if (!DescriptorProtos.SourceCodeInfo.Location.access$20800(other).isEmpty())
    {
      if (span_.isEmpty())
      {
        span_ = DescriptorProtos.SourceCodeInfo.Location.access$20800(other);
        bitField0_ &= 0xFFFFFFFD;
      }
      else
      {
        ensureSpanIsMutable();
        span_.addAll(DescriptorProtos.SourceCodeInfo.Location.access$20800(other));
      }
      onChanged();
    }
    if (other.hasLeadingComments())
    {
      bitField0_ |= 0x4;
      leadingComments_ = DescriptorProtos.SourceCodeInfo.Location.access$20900(other);
      onChanged();
    }
    if (other.hasTrailingComments())
    {
      bitField0_ |= 0x8;
      trailingComments_ = DescriptorProtos.SourceCodeInfo.Location.access$21000(other);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */