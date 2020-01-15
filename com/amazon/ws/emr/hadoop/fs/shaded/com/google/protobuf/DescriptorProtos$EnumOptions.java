package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$EnumOptions
  extends GeneratedMessage.ExtendableMessage<EnumOptions>
  implements DescriptorProtos.EnumOptionsOrBuilder
{
  private static final EnumOptions defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$EnumOptions(GeneratedMessage.ExtendableBuilder<EnumOptions, ?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$EnumOptions(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static EnumOptions getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public EnumOptions getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$EnumOptions(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
        case 16: 
          bitField0_ |= 0x1;
          allowAlias_ = input.readBool();
          break;
        case 7994: 
          if ((mutable_bitField0_ & 0x2) != 2)
          {
            uninterpretedOption_ = new ArrayList();
            mutable_bitField0_ |= 0x2;
          }
          uninterpretedOption_.add(input.readMessage(DescriptorProtos.UninterpretedOption.PARSER, extensionRegistry));
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
      if ((mutable_bitField0_ & 0x2) == 2) {
        uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$14500();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$14600().ensureFieldAccessorsInitialized(EnumOptions.class, Builder.class);
  }
  
  public static Parser<EnumOptions> PARSER = new AbstractParser()
  {
    public DescriptorProtos.EnumOptions parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.EnumOptions(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
  private boolean allowAlias_;
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  
  public Parser<EnumOptions> getParserForType()
  {
    return PARSER;
  }
  
  public boolean hasAllowAlias()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public boolean getAllowAlias()
  {
    return allowAlias_;
  }
  
  public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
  {
    return uninterpretedOption_;
  }
  
  public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
  {
    return uninterpretedOption_;
  }
  
  public int getUninterpretedOptionCount()
  {
    return uninterpretedOption_.size();
  }
  
  public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
  {
    return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
  }
  
  public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
  {
    return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
  }
  
  private void initFields()
  {
    allowAlias_ = true;
    uninterpretedOption_ = Collections.emptyList();
  }
  
  private byte memoizedIsInitialized = -1;
  
  public final boolean isInitialized()
  {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) {
      return isInitialized == 1;
    }
    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
      if (!getUninterpretedOption(i).isInitialized())
      {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    if (!extensionsAreInitialized())
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
    
    GeneratedMessage.ExtendableMessage<EnumOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
    if ((bitField0_ & 0x1) == 1) {
      output.writeBool(2, allowAlias_);
    }
    for (int i = 0; i < uninterpretedOption_.size(); i++) {
      output.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
    }
    extensionWriter.writeUntil(536870912, output);
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
      size += CodedOutputStream.computeBoolSize(2, allowAlias_);
    }
    for (int i = 0; i < uninterpretedOption_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
    }
    size += extensionsSerializedSize();
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }
  
  protected Object writeReplace()
    throws ObjectStreamException
  {
    return super.writeReplace();
  }
  
  public static EnumOptions parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (EnumOptions)PARSER.parseFrom(data);
  }
  
  public static EnumOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (EnumOptions)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static EnumOptions parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (EnumOptions)PARSER.parseFrom(data);
  }
  
  public static EnumOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (EnumOptions)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static EnumOptions parseFrom(InputStream input)
    throws IOException
  {
    return (EnumOptions)PARSER.parseFrom(input);
  }
  
  public static EnumOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (EnumOptions)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static EnumOptions parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (EnumOptions)PARSER.parseDelimitedFrom(input);
  }
  
  public static EnumOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (EnumOptions)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static EnumOptions parseFrom(CodedInputStream input)
    throws IOException
  {
    return (EnumOptions)PARSER.parseFrom(input);
  }
  
  public static EnumOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (EnumOptions)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$14800();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(EnumOptions prototype)
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
      allowAlias_ = allowAlias_;
      if (uninterpretedOptionBuilder_ == null)
      {
        if ((bitField0_ & 0x2) == 2)
        {
          uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
          bitField0_ &= 0xFFFFFFFD;
        }
        uninterpretedOption_ = uninterpretedOption_;
      }
      else
      {
        uninterpretedOption_ = uninterpretedOptionBuilder_.build();
      }
      bitField0_ = to_bitField0_;
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
        if (!uninterpretedOption_.isEmpty())
        {
          if (uninterpretedOption_.isEmpty())
          {
            uninterpretedOption_ = uninterpretedOption_;
            bitField0_ &= 0xFFFFFFFD;
          }
          else
          {
            ensureUninterpretedOptionIsMutable();
            uninterpretedOption_.addAll(uninterpretedOption_);
          }
          onChanged();
        }
      }
      else if (!uninterpretedOption_.isEmpty()) {
        if (uninterpretedOptionBuilder_.isEmpty())
        {
          uninterpretedOptionBuilder_.dispose();
          uninterpretedOptionBuilder_ = null;
          uninterpretedOption_ = uninterpretedOption_;
          bitField0_ &= 0xFFFFFFFD;
          uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
        }
        else
        {
          uninterpretedOptionBuilder_.addAllMessages(uninterpretedOption_);
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
  
  static
  {
    defaultInstance = new EnumOptions(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.EnumOptions
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */