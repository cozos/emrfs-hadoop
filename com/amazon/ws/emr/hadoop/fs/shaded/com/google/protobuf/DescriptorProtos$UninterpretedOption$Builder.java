package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$UninterpretedOption$Builder
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
  
  private DescriptorProtos$UninterpretedOption$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$UninterpretedOption$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
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
      DescriptorProtos.UninterpretedOption.access$19002(result, name_);
    }
    else
    {
      DescriptorProtos.UninterpretedOption.access$19002(result, nameBuilder_.build());
    }
    if ((from_bitField0_ & 0x2) == 2) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.UninterpretedOption.access$19102(result, identifierValue_);
    if ((from_bitField0_ & 0x4) == 4) {
      to_bitField0_ |= 0x2;
    }
    DescriptorProtos.UninterpretedOption.access$19202(result, positiveIntValue_);
    if ((from_bitField0_ & 0x8) == 8) {
      to_bitField0_ |= 0x4;
    }
    DescriptorProtos.UninterpretedOption.access$19302(result, negativeIntValue_);
    if ((from_bitField0_ & 0x10) == 16) {
      to_bitField0_ |= 0x8;
    }
    DescriptorProtos.UninterpretedOption.access$19402(result, doubleValue_);
    if ((from_bitField0_ & 0x20) == 32) {
      to_bitField0_ |= 0x10;
    }
    DescriptorProtos.UninterpretedOption.access$19502(result, stringValue_);
    if ((from_bitField0_ & 0x40) == 64) {
      to_bitField0_ |= 0x20;
    }
    DescriptorProtos.UninterpretedOption.access$19602(result, aggregateValue_);
    DescriptorProtos.UninterpretedOption.access$19702(result, to_bitField0_);
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
      if (!DescriptorProtos.UninterpretedOption.access$19000(other).isEmpty())
      {
        if (name_.isEmpty())
        {
          name_ = DescriptorProtos.UninterpretedOption.access$19000(other);
          bitField0_ &= 0xFFFFFFFE;
        }
        else
        {
          ensureNameIsMutable();
          name_.addAll(DescriptorProtos.UninterpretedOption.access$19000(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.UninterpretedOption.access$19000(other).isEmpty()) {
      if (nameBuilder_.isEmpty())
      {
        nameBuilder_.dispose();
        nameBuilder_ = null;
        name_ = DescriptorProtos.UninterpretedOption.access$19000(other);
        bitField0_ &= 0xFFFFFFFE;
        nameBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getNameFieldBuilder() : null);
      }
      else
      {
        nameBuilder_.addAllMessages(DescriptorProtos.UninterpretedOption.access$19000(other));
      }
    }
    if (other.hasIdentifierValue())
    {
      bitField0_ |= 0x2;
      identifierValue_ = DescriptorProtos.UninterpretedOption.access$19100(other);
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
      aggregateValue_ = DescriptorProtos.UninterpretedOption.access$19600(other);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.UninterpretedOption.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */