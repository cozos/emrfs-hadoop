package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileOptions$Builder
  extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.FileOptions, Builder>
  implements DescriptorProtos.FileOptionsOrBuilder
{
  private int bitField0_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$10400();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$10500().ensureFieldAccessorsInitialized(DescriptorProtos.FileOptions.class, Builder.class);
  }
  
  private DescriptorProtos$FileOptions$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$FileOptions$Builder(GeneratedMessage.BuilderParent parent)
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
    javaPackage_ = "";
    bitField0_ &= 0xFFFFFFFE;
    javaOuterClassname_ = "";
    bitField0_ &= 0xFFFFFFFD;
    javaMultipleFiles_ = false;
    bitField0_ &= 0xFFFFFFFB;
    javaGenerateEqualsAndHash_ = false;
    bitField0_ &= 0xFFFFFFF7;
    optimizeFor_ = DescriptorProtos.FileOptions.OptimizeMode.SPEED;
    bitField0_ &= 0xFFFFFFEF;
    goPackage_ = "";
    bitField0_ &= 0xFFFFFFDF;
    ccGenericServices_ = false;
    bitField0_ &= 0xFFFFFFBF;
    javaGenericServices_ = false;
    bitField0_ &= 0xFF7F;
    pyGenericServices_ = false;
    bitField0_ &= 0xFEFF;
    if (uninterpretedOptionBuilder_ == null)
    {
      uninterpretedOption_ = Collections.emptyList();
      bitField0_ &= 0xFDFF;
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
    return DescriptorProtos.access$10400();
  }
  
  public DescriptorProtos.FileOptions getDefaultInstanceForType()
  {
    return DescriptorProtos.FileOptions.getDefaultInstance();
  }
  
  public DescriptorProtos.FileOptions build()
  {
    DescriptorProtos.FileOptions result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.FileOptions buildPartial()
  {
    DescriptorProtos.FileOptions result = new DescriptorProtos.FileOptions(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.FileOptions.access$11002(result, javaPackage_);
    if ((from_bitField0_ & 0x2) == 2) {
      to_bitField0_ |= 0x2;
    }
    DescriptorProtos.FileOptions.access$11102(result, javaOuterClassname_);
    if ((from_bitField0_ & 0x4) == 4) {
      to_bitField0_ |= 0x4;
    }
    DescriptorProtos.FileOptions.access$11202(result, javaMultipleFiles_);
    if ((from_bitField0_ & 0x8) == 8) {
      to_bitField0_ |= 0x8;
    }
    DescriptorProtos.FileOptions.access$11302(result, javaGenerateEqualsAndHash_);
    if ((from_bitField0_ & 0x10) == 16) {
      to_bitField0_ |= 0x10;
    }
    DescriptorProtos.FileOptions.access$11402(result, optimizeFor_);
    if ((from_bitField0_ & 0x20) == 32) {
      to_bitField0_ |= 0x20;
    }
    DescriptorProtos.FileOptions.access$11502(result, goPackage_);
    if ((from_bitField0_ & 0x40) == 64) {
      to_bitField0_ |= 0x40;
    }
    DescriptorProtos.FileOptions.access$11602(result, ccGenericServices_);
    if ((from_bitField0_ & 0x80) == 128) {
      to_bitField0_ |= 0x80;
    }
    DescriptorProtos.FileOptions.access$11702(result, javaGenericServices_);
    if ((from_bitField0_ & 0x100) == 256) {
      to_bitField0_ |= 0x100;
    }
    DescriptorProtos.FileOptions.access$11802(result, pyGenericServices_);
    if (uninterpretedOptionBuilder_ == null)
    {
      if ((bitField0_ & 0x200) == 512)
      {
        uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
        bitField0_ &= 0xFDFF;
      }
      DescriptorProtos.FileOptions.access$11902(result, uninterpretedOption_);
    }
    else
    {
      DescriptorProtos.FileOptions.access$11902(result, uninterpretedOptionBuilder_.build());
    }
    DescriptorProtos.FileOptions.access$12002(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.FileOptions)) {
      return mergeFrom((DescriptorProtos.FileOptions)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.FileOptions other)
  {
    if (other == DescriptorProtos.FileOptions.getDefaultInstance()) {
      return this;
    }
    if (other.hasJavaPackage())
    {
      bitField0_ |= 0x1;
      javaPackage_ = DescriptorProtos.FileOptions.access$11000(other);
      onChanged();
    }
    if (other.hasJavaOuterClassname())
    {
      bitField0_ |= 0x2;
      javaOuterClassname_ = DescriptorProtos.FileOptions.access$11100(other);
      onChanged();
    }
    if (other.hasJavaMultipleFiles()) {
      setJavaMultipleFiles(other.getJavaMultipleFiles());
    }
    if (other.hasJavaGenerateEqualsAndHash()) {
      setJavaGenerateEqualsAndHash(other.getJavaGenerateEqualsAndHash());
    }
    if (other.hasOptimizeFor()) {
      setOptimizeFor(other.getOptimizeFor());
    }
    if (other.hasGoPackage())
    {
      bitField0_ |= 0x20;
      goPackage_ = DescriptorProtos.FileOptions.access$11500(other);
      onChanged();
    }
    if (other.hasCcGenericServices()) {
      setCcGenericServices(other.getCcGenericServices());
    }
    if (other.hasJavaGenericServices()) {
      setJavaGenericServices(other.getJavaGenericServices());
    }
    if (other.hasPyGenericServices()) {
      setPyGenericServices(other.getPyGenericServices());
    }
    if (uninterpretedOptionBuilder_ == null)
    {
      if (!DescriptorProtos.FileOptions.access$11900(other).isEmpty())
      {
        if (uninterpretedOption_.isEmpty())
        {
          uninterpretedOption_ = DescriptorProtos.FileOptions.access$11900(other);
          bitField0_ &= 0xFDFF;
        }
        else
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.addAll(DescriptorProtos.FileOptions.access$11900(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileOptions.access$11900(other).isEmpty()) {
      if (uninterpretedOptionBuilder_.isEmpty())
      {
        uninterpretedOptionBuilder_.dispose();
        uninterpretedOptionBuilder_ = null;
        uninterpretedOption_ = DescriptorProtos.FileOptions.access$11900(other);
        bitField0_ &= 0xFDFF;
        uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
      }
      else
      {
        uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos.FileOptions.access$11900(other));
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
    DescriptorProtos.FileOptions parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.FileOptions)DescriptorProtos.FileOptions.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.FileOptions)e.getUnfinishedMessage();
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
  
  private Object javaPackage_ = "";
  
  public boolean hasJavaPackage()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public String getJavaPackage()
  {
    Object ref = javaPackage_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      javaPackage_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getJavaPackageBytes()
  {
    Object ref = javaPackage_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      javaPackage_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setJavaPackage(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x1;
    javaPackage_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearJavaPackage()
  {
    bitField0_ &= 0xFFFFFFFE;
    javaPackage_ = DescriptorProtos.FileOptions.getDefaultInstance().getJavaPackage();
    onChanged();
    return this;
  }
  
  public Builder setJavaPackageBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x1;
    javaPackage_ = value;
    onChanged();
    return this;
  }
  
  private Object javaOuterClassname_ = "";
  private boolean javaMultipleFiles_;
  private boolean javaGenerateEqualsAndHash_;
  
  public boolean hasJavaOuterClassname()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public String getJavaOuterClassname()
  {
    Object ref = javaOuterClassname_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      javaOuterClassname_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getJavaOuterClassnameBytes()
  {
    Object ref = javaOuterClassname_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      javaOuterClassname_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setJavaOuterClassname(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x2;
    javaOuterClassname_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearJavaOuterClassname()
  {
    bitField0_ &= 0xFFFFFFFD;
    javaOuterClassname_ = DescriptorProtos.FileOptions.getDefaultInstance().getJavaOuterClassname();
    onChanged();
    return this;
  }
  
  public Builder setJavaOuterClassnameBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x2;
    javaOuterClassname_ = value;
    onChanged();
    return this;
  }
  
  public boolean hasJavaMultipleFiles()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public boolean getJavaMultipleFiles()
  {
    return javaMultipleFiles_;
  }
  
  public Builder setJavaMultipleFiles(boolean value)
  {
    bitField0_ |= 0x4;
    javaMultipleFiles_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearJavaMultipleFiles()
  {
    bitField0_ &= 0xFFFFFFFB;
    javaMultipleFiles_ = false;
    onChanged();
    return this;
  }
  
  public boolean hasJavaGenerateEqualsAndHash()
  {
    return (bitField0_ & 0x8) == 8;
  }
  
  public boolean getJavaGenerateEqualsAndHash()
  {
    return javaGenerateEqualsAndHash_;
  }
  
  public Builder setJavaGenerateEqualsAndHash(boolean value)
  {
    bitField0_ |= 0x8;
    javaGenerateEqualsAndHash_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearJavaGenerateEqualsAndHash()
  {
    bitField0_ &= 0xFFFFFFF7;
    javaGenerateEqualsAndHash_ = false;
    onChanged();
    return this;
  }
  
  private DescriptorProtos.FileOptions.OptimizeMode optimizeFor_ = DescriptorProtos.FileOptions.OptimizeMode.SPEED;
  
  public boolean hasOptimizeFor()
  {
    return (bitField0_ & 0x10) == 16;
  }
  
  public DescriptorProtos.FileOptions.OptimizeMode getOptimizeFor()
  {
    return optimizeFor_;
  }
  
  public Builder setOptimizeFor(DescriptorProtos.FileOptions.OptimizeMode value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x10;
    optimizeFor_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearOptimizeFor()
  {
    bitField0_ &= 0xFFFFFFEF;
    optimizeFor_ = DescriptorProtos.FileOptions.OptimizeMode.SPEED;
    onChanged();
    return this;
  }
  
  private Object goPackage_ = "";
  private boolean ccGenericServices_;
  private boolean javaGenericServices_;
  private boolean pyGenericServices_;
  
  public boolean hasGoPackage()
  {
    return (bitField0_ & 0x20) == 32;
  }
  
  public String getGoPackage()
  {
    Object ref = goPackage_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      goPackage_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getGoPackageBytes()
  {
    Object ref = goPackage_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      goPackage_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setGoPackage(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x20;
    goPackage_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearGoPackage()
  {
    bitField0_ &= 0xFFFFFFDF;
    goPackage_ = DescriptorProtos.FileOptions.getDefaultInstance().getGoPackage();
    onChanged();
    return this;
  }
  
  public Builder setGoPackageBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x20;
    goPackage_ = value;
    onChanged();
    return this;
  }
  
  public boolean hasCcGenericServices()
  {
    return (bitField0_ & 0x40) == 64;
  }
  
  public boolean getCcGenericServices()
  {
    return ccGenericServices_;
  }
  
  public Builder setCcGenericServices(boolean value)
  {
    bitField0_ |= 0x40;
    ccGenericServices_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearCcGenericServices()
  {
    bitField0_ &= 0xFFFFFFBF;
    ccGenericServices_ = false;
    onChanged();
    return this;
  }
  
  public boolean hasJavaGenericServices()
  {
    return (bitField0_ & 0x80) == 128;
  }
  
  public boolean getJavaGenericServices()
  {
    return javaGenericServices_;
  }
  
  public Builder setJavaGenericServices(boolean value)
  {
    bitField0_ |= 0x80;
    javaGenericServices_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearJavaGenericServices()
  {
    bitField0_ &= 0xFF7F;
    javaGenericServices_ = false;
    onChanged();
    return this;
  }
  
  public boolean hasPyGenericServices()
  {
    return (bitField0_ & 0x100) == 256;
  }
  
  public boolean getPyGenericServices()
  {
    return pyGenericServices_;
  }
  
  public Builder setPyGenericServices(boolean value)
  {
    bitField0_ |= 0x100;
    pyGenericServices_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearPyGenericServices()
  {
    bitField0_ &= 0xFEFF;
    pyGenericServices_ = false;
    onChanged();
    return this;
  }
  
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
  
  private void ensureUninterpretedOptionIsMutable()
  {
    if ((bitField0_ & 0x200) != 512)
    {
      uninterpretedOption_ = new ArrayList(uninterpretedOption_);
      bitField0_ |= 0x200;
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
      bitField0_ &= 0xFDFF;
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
      uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x200) == 512, getParentForChildren(), isClean());
      
      uninterpretedOption_ = null;
    }
    return uninterpretedOptionBuilder_;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FileOptions.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */