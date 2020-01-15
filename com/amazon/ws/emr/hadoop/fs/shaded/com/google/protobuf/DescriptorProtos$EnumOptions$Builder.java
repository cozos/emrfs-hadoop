package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$EnumOptions$Builder
  extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.EnumOptions, Builder>
  implements DescriptorProtos.EnumOptionsOrBuilder
{
  private int bitField0_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$14500();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$14600().ensureFieldAccessorsInitialized(DescriptorProtos.EnumOptions.class, Builder.class);
  }
  
  private DescriptorProtos$EnumOptions$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$EnumOptions$Builder(GeneratedMessage.BuilderParent parent)
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
    allowAlias_ = true;
    bitField0_ &= 0xFFFFFFFE;
    if (uninterpretedOptionBuilder_ == null)
    {
      uninterpretedOption_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFD;
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
    return DescriptorProtos.access$14500();
  }
  
  public DescriptorProtos.EnumOptions getDefaultInstanceForType()
  {
    return DescriptorProtos.EnumOptions.getDefaultInstance();
  }
  
  public DescriptorProtos.EnumOptions build()
  {
    DescriptorProtos.EnumOptions result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.EnumOptions buildPartial()
  {
    DescriptorProtos.EnumOptions result = new DescriptorProtos.EnumOptions(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.EnumOptions.access$15102(result, allowAlias_);
    if (uninterpretedOptionBuilder_ == null)
    {
      if ((bitField0_ & 0x2) == 2)
      {
        uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
        bitField0_ &= 0xFFFFFFFD;
      }
      DescriptorProtos.EnumOptions.access$15202(result, uninterpretedOption_);
    }
    else
    {
      DescriptorProtos.EnumOptions.access$15202(result, uninterpretedOptionBuilder_.build());
    }
    DescriptorProtos.EnumOptions.access$15302(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.EnumOptions)) {
      return mergeFrom((DescriptorProtos.EnumOptions)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.EnumOptions other)
  {
    if (other == DescriptorProtos.EnumOptions.getDefaultInstance()) {
      return this;
    }
    if (other.hasAllowAlias()) {
      setAllowAlias(other.getAllowAlias());
    }
    if (uninterpretedOptionBuilder_ == null)
    {
      if (!DescriptorProtos.EnumOptions.access$15200(other).isEmpty())
      {
        if (uninterpretedOption_.isEmpty())
        {
          uninterpretedOption_ = DescriptorProtos.EnumOptions.access$15200(other);
          bitField0_ &= 0xFFFFFFFD;
        }
        else
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.addAll(DescriptorProtos.EnumOptions.access$15200(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.EnumOptions.access$15200(other).isEmpty()) {
      if (uninterpretedOptionBuilder_.isEmpty())
      {
        uninterpretedOptionBuilder_.dispose();
        uninterpretedOptionBuilder_ = null;
        uninterpretedOption_ = DescriptorProtos.EnumOptions.access$15200(other);
        bitField0_ &= 0xFFFFFFFD;
        uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
      }
      else
      {
        uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos.EnumOptions.access$15200(other));
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
    DescriptorProtos.EnumOptions parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.EnumOptions)DescriptorProtos.EnumOptions.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.EnumOptions)e.getUnfinishedMessage();
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
  
  private boolean allowAlias_ = true;
  
  public boolean hasAllowAlias()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public boolean getAllowAlias()
  {
    return allowAlias_;
  }
  
  public Builder setAllowAlias(boolean value)
  {
    bitField0_ |= 0x1;
    allowAlias_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearAllowAlias()
  {
    bitField0_ &= 0xFFFFFFFE;
    allowAlias_ = true;
    onChanged();
    return this;
  }
  
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
  
  private void ensureUninterpretedOptionIsMutable()
  {
    if ((bitField0_ & 0x2) != 2)
    {
      uninterpretedOption_ = new ArrayList(uninterpretedOption_);
      bitField0_ |= 0x2;
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
      bitField0_ &= 0xFFFFFFFD;
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
      uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
      
      uninterpretedOption_ = null;
    }
    return uninterpretedOptionBuilder_;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.EnumOptions.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */