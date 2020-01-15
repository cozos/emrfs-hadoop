package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$MessageOptions$Builder
  extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.MessageOptions, Builder>
  implements DescriptorProtos.MessageOptionsOrBuilder
{
  private int bitField0_;
  private boolean messageSetWireFormat_;
  private boolean noStandardDescriptorAccessor_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$12100();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$12200().ensureFieldAccessorsInitialized(DescriptorProtos.MessageOptions.class, Builder.class);
  }
  
  private DescriptorProtos$MessageOptions$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$MessageOptions$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
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
    messageSetWireFormat_ = false;
    bitField0_ &= 0xFFFFFFFE;
    noStandardDescriptorAccessor_ = false;
    bitField0_ &= 0xFFFFFFFD;
    if (uninterpretedOptionBuilder_ == null)
    {
      uninterpretedOption_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFB;
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
    return DescriptorProtos.access$12100();
  }
  
  public DescriptorProtos.MessageOptions getDefaultInstanceForType()
  {
    return DescriptorProtos.MessageOptions.getDefaultInstance();
  }
  
  public DescriptorProtos.MessageOptions build()
  {
    DescriptorProtos.MessageOptions result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.MessageOptions buildPartial()
  {
    DescriptorProtos.MessageOptions result = new DescriptorProtos.MessageOptions(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.MessageOptions.access$12702(result, messageSetWireFormat_);
    if ((from_bitField0_ & 0x2) == 2) {
      to_bitField0_ |= 0x2;
    }
    DescriptorProtos.MessageOptions.access$12802(result, noStandardDescriptorAccessor_);
    if (uninterpretedOptionBuilder_ == null)
    {
      if ((bitField0_ & 0x4) == 4)
      {
        uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
        bitField0_ &= 0xFFFFFFFB;
      }
      DescriptorProtos.MessageOptions.access$12902(result, uninterpretedOption_);
    }
    else
    {
      DescriptorProtos.MessageOptions.access$12902(result, uninterpretedOptionBuilder_.build());
    }
    DescriptorProtos.MessageOptions.access$13002(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.MessageOptions)) {
      return mergeFrom((DescriptorProtos.MessageOptions)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.MessageOptions other)
  {
    if (other == DescriptorProtos.MessageOptions.getDefaultInstance()) {
      return this;
    }
    if (other.hasMessageSetWireFormat()) {
      setMessageSetWireFormat(other.getMessageSetWireFormat());
    }
    if (other.hasNoStandardDescriptorAccessor()) {
      setNoStandardDescriptorAccessor(other.getNoStandardDescriptorAccessor());
    }
    if (uninterpretedOptionBuilder_ == null)
    {
      if (!DescriptorProtos.MessageOptions.access$12900(other).isEmpty())
      {
        if (uninterpretedOption_.isEmpty())
        {
          uninterpretedOption_ = DescriptorProtos.MessageOptions.access$12900(other);
          bitField0_ &= 0xFFFFFFFB;
        }
        else
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.addAll(DescriptorProtos.MessageOptions.access$12900(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.MessageOptions.access$12900(other).isEmpty()) {
      if (uninterpretedOptionBuilder_.isEmpty())
      {
        uninterpretedOptionBuilder_.dispose();
        uninterpretedOptionBuilder_ = null;
        uninterpretedOption_ = DescriptorProtos.MessageOptions.access$12900(other);
        bitField0_ &= 0xFFFFFFFB;
        uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
      }
      else
      {
        uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos.MessageOptions.access$12900(other));
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
    DescriptorProtos.MessageOptions parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.MessageOptions)DescriptorProtos.MessageOptions.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.MessageOptions)e.getUnfinishedMessage();
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
  
  public boolean hasMessageSetWireFormat()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public boolean getMessageSetWireFormat()
  {
    return messageSetWireFormat_;
  }
  
  public Builder setMessageSetWireFormat(boolean value)
  {
    bitField0_ |= 0x1;
    messageSetWireFormat_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearMessageSetWireFormat()
  {
    bitField0_ &= 0xFFFFFFFE;
    messageSetWireFormat_ = false;
    onChanged();
    return this;
  }
  
  public boolean hasNoStandardDescriptorAccessor()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public boolean getNoStandardDescriptorAccessor()
  {
    return noStandardDescriptorAccessor_;
  }
  
  public Builder setNoStandardDescriptorAccessor(boolean value)
  {
    bitField0_ |= 0x2;
    noStandardDescriptorAccessor_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearNoStandardDescriptorAccessor()
  {
    bitField0_ &= 0xFFFFFFFD;
    noStandardDescriptorAccessor_ = false;
    onChanged();
    return this;
  }
  
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
  
  private void ensureUninterpretedOptionIsMutable()
  {
    if ((bitField0_ & 0x4) != 4)
    {
      uninterpretedOption_ = new ArrayList(uninterpretedOption_);
      bitField0_ |= 0x4;
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
      bitField0_ &= 0xFFFFFFFB;
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
      uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x4) == 4, getParentForChildren(), isClean());
      
      uninterpretedOption_ = null;
    }
    return uninterpretedOptionBuilder_;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.MessageOptions.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */