package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FieldOptions$Builder
  extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.FieldOptions, Builder>
  implements DescriptorProtos.FieldOptionsOrBuilder
{
  private int bitField0_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$13100();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$13200().ensureFieldAccessorsInitialized(DescriptorProtos.FieldOptions.class, Builder.class);
  }
  
  private DescriptorProtos$FieldOptions$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$FieldOptions$Builder(GeneratedMessage.BuilderParent parent)
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
    ctype_ = DescriptorProtos.FieldOptions.CType.STRING;
    bitField0_ &= 0xFFFFFFFE;
    packed_ = false;
    bitField0_ &= 0xFFFFFFFD;
    lazy_ = false;
    bitField0_ &= 0xFFFFFFFB;
    deprecated_ = false;
    bitField0_ &= 0xFFFFFFF7;
    experimentalMapKey_ = "";
    bitField0_ &= 0xFFFFFFEF;
    weak_ = false;
    bitField0_ &= 0xFFFFFFDF;
    if (uninterpretedOptionBuilder_ == null)
    {
      uninterpretedOption_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFBF;
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
    return DescriptorProtos.access$13100();
  }
  
  public DescriptorProtos.FieldOptions getDefaultInstanceForType()
  {
    return DescriptorProtos.FieldOptions.getDefaultInstance();
  }
  
  public DescriptorProtos.FieldOptions build()
  {
    DescriptorProtos.FieldOptions result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.FieldOptions buildPartial()
  {
    DescriptorProtos.FieldOptions result = new DescriptorProtos.FieldOptions(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.FieldOptions.access$13702(result, ctype_);
    if ((from_bitField0_ & 0x2) == 2) {
      to_bitField0_ |= 0x2;
    }
    DescriptorProtos.FieldOptions.access$13802(result, packed_);
    if ((from_bitField0_ & 0x4) == 4) {
      to_bitField0_ |= 0x4;
    }
    DescriptorProtos.FieldOptions.access$13902(result, lazy_);
    if ((from_bitField0_ & 0x8) == 8) {
      to_bitField0_ |= 0x8;
    }
    DescriptorProtos.FieldOptions.access$14002(result, deprecated_);
    if ((from_bitField0_ & 0x10) == 16) {
      to_bitField0_ |= 0x10;
    }
    DescriptorProtos.FieldOptions.access$14102(result, experimentalMapKey_);
    if ((from_bitField0_ & 0x20) == 32) {
      to_bitField0_ |= 0x20;
    }
    DescriptorProtos.FieldOptions.access$14202(result, weak_);
    if (uninterpretedOptionBuilder_ == null)
    {
      if ((bitField0_ & 0x40) == 64)
      {
        uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
        bitField0_ &= 0xFFFFFFBF;
      }
      DescriptorProtos.FieldOptions.access$14302(result, uninterpretedOption_);
    }
    else
    {
      DescriptorProtos.FieldOptions.access$14302(result, uninterpretedOptionBuilder_.build());
    }
    DescriptorProtos.FieldOptions.access$14402(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.FieldOptions)) {
      return mergeFrom((DescriptorProtos.FieldOptions)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.FieldOptions other)
  {
    if (other == DescriptorProtos.FieldOptions.getDefaultInstance()) {
      return this;
    }
    if (other.hasCtype()) {
      setCtype(other.getCtype());
    }
    if (other.hasPacked()) {
      setPacked(other.getPacked());
    }
    if (other.hasLazy()) {
      setLazy(other.getLazy());
    }
    if (other.hasDeprecated()) {
      setDeprecated(other.getDeprecated());
    }
    if (other.hasExperimentalMapKey())
    {
      bitField0_ |= 0x10;
      experimentalMapKey_ = DescriptorProtos.FieldOptions.access$14100(other);
      onChanged();
    }
    if (other.hasWeak()) {
      setWeak(other.getWeak());
    }
    if (uninterpretedOptionBuilder_ == null)
    {
      if (!DescriptorProtos.FieldOptions.access$14300(other).isEmpty())
      {
        if (uninterpretedOption_.isEmpty())
        {
          uninterpretedOption_ = DescriptorProtos.FieldOptions.access$14300(other);
          bitField0_ &= 0xFFFFFFBF;
        }
        else
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.addAll(DescriptorProtos.FieldOptions.access$14300(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FieldOptions.access$14300(other).isEmpty()) {
      if (uninterpretedOptionBuilder_.isEmpty())
      {
        uninterpretedOptionBuilder_.dispose();
        uninterpretedOptionBuilder_ = null;
        uninterpretedOption_ = DescriptorProtos.FieldOptions.access$14300(other);
        bitField0_ &= 0xFFFFFFBF;
        uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
      }
      else
      {
        uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos.FieldOptions.access$14300(other));
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
    DescriptorProtos.FieldOptions parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.FieldOptions)DescriptorProtos.FieldOptions.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.FieldOptions)e.getUnfinishedMessage();
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
  
  private DescriptorProtos.FieldOptions.CType ctype_ = DescriptorProtos.FieldOptions.CType.STRING;
  private boolean packed_;
  private boolean lazy_;
  private boolean deprecated_;
  
  public boolean hasCtype()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public DescriptorProtos.FieldOptions.CType getCtype()
  {
    return ctype_;
  }
  
  public Builder setCtype(DescriptorProtos.FieldOptions.CType value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x1;
    ctype_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearCtype()
  {
    bitField0_ &= 0xFFFFFFFE;
    ctype_ = DescriptorProtos.FieldOptions.CType.STRING;
    onChanged();
    return this;
  }
  
  public boolean hasPacked()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public boolean getPacked()
  {
    return packed_;
  }
  
  public Builder setPacked(boolean value)
  {
    bitField0_ |= 0x2;
    packed_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearPacked()
  {
    bitField0_ &= 0xFFFFFFFD;
    packed_ = false;
    onChanged();
    return this;
  }
  
  public boolean hasLazy()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public boolean getLazy()
  {
    return lazy_;
  }
  
  public Builder setLazy(boolean value)
  {
    bitField0_ |= 0x4;
    lazy_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearLazy()
  {
    bitField0_ &= 0xFFFFFFFB;
    lazy_ = false;
    onChanged();
    return this;
  }
  
  public boolean hasDeprecated()
  {
    return (bitField0_ & 0x8) == 8;
  }
  
  public boolean getDeprecated()
  {
    return deprecated_;
  }
  
  public Builder setDeprecated(boolean value)
  {
    bitField0_ |= 0x8;
    deprecated_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearDeprecated()
  {
    bitField0_ &= 0xFFFFFFF7;
    deprecated_ = false;
    onChanged();
    return this;
  }
  
  private Object experimentalMapKey_ = "";
  private boolean weak_;
  
  public boolean hasExperimentalMapKey()
  {
    return (bitField0_ & 0x10) == 16;
  }
  
  public String getExperimentalMapKey()
  {
    Object ref = experimentalMapKey_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      experimentalMapKey_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getExperimentalMapKeyBytes()
  {
    Object ref = experimentalMapKey_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      experimentalMapKey_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setExperimentalMapKey(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x10;
    experimentalMapKey_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearExperimentalMapKey()
  {
    bitField0_ &= 0xFFFFFFEF;
    experimentalMapKey_ = DescriptorProtos.FieldOptions.getDefaultInstance().getExperimentalMapKey();
    onChanged();
    return this;
  }
  
  public Builder setExperimentalMapKeyBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x10;
    experimentalMapKey_ = value;
    onChanged();
    return this;
  }
  
  public boolean hasWeak()
  {
    return (bitField0_ & 0x20) == 32;
  }
  
  public boolean getWeak()
  {
    return weak_;
  }
  
  public Builder setWeak(boolean value)
  {
    bitField0_ |= 0x20;
    weak_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearWeak()
  {
    bitField0_ &= 0xFFFFFFDF;
    weak_ = false;
    onChanged();
    return this;
  }
  
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
  
  private void ensureUninterpretedOptionIsMutable()
  {
    if ((bitField0_ & 0x40) != 64)
    {
      uninterpretedOption_ = new ArrayList(uninterpretedOption_);
      bitField0_ |= 0x40;
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
      bitField0_ &= 0xFFFFFFBF;
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
      uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x40) == 64, getParentForChildren(), isClean());
      
      uninterpretedOption_ = null;
    }
    return uninterpretedOptionBuilder_;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FieldOptions.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */