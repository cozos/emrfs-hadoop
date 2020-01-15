package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$MessageOptions
  extends GeneratedMessage.ExtendableMessage<MessageOptions>
  implements DescriptorProtos.MessageOptionsOrBuilder
{
  private static final MessageOptions defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$MessageOptions(GeneratedMessage.ExtendableBuilder<MessageOptions, ?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$MessageOptions(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static MessageOptions getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public MessageOptions getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private DescriptorProtos$MessageOptions(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          messageSetWireFormat_ = input.readBool();
          break;
        case 16: 
          bitField0_ |= 0x2;
          noStandardDescriptorAccessor_ = input.readBool();
          break;
        case 7994: 
          if ((mutable_bitField0_ & 0x4) != 4)
          {
            uninterpretedOption_ = new ArrayList();
            mutable_bitField0_ |= 0x4;
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
      if ((mutable_bitField0_ & 0x4) == 4) {
        uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$12100();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$12200().ensureFieldAccessorsInitialized(MessageOptions.class, Builder.class);
  }
  
  public static Parser<MessageOptions> PARSER = new AbstractParser()
  {
    public DescriptorProtos.MessageOptions parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.MessageOptions(input, extensionRegistry, null);
    }
  };
  private int bitField0_;
  public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
  private boolean messageSetWireFormat_;
  public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
  private boolean noStandardDescriptorAccessor_;
  public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
  private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
  
  public Parser<MessageOptions> getParserForType()
  {
    return PARSER;
  }
  
  public boolean hasMessageSetWireFormat()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public boolean getMessageSetWireFormat()
  {
    return messageSetWireFormat_;
  }
  
  public boolean hasNoStandardDescriptorAccessor()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public boolean getNoStandardDescriptorAccessor()
  {
    return noStandardDescriptorAccessor_;
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
    messageSetWireFormat_ = false;
    noStandardDescriptorAccessor_ = false;
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
    
    GeneratedMessage.ExtendableMessage<MessageOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
    if ((bitField0_ & 0x1) == 1) {
      output.writeBool(1, messageSetWireFormat_);
    }
    if ((bitField0_ & 0x2) == 2) {
      output.writeBool(2, noStandardDescriptorAccessor_);
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
      size += CodedOutputStream.computeBoolSize(1, messageSetWireFormat_);
    }
    if ((bitField0_ & 0x2) == 2) {
      size += CodedOutputStream.computeBoolSize(2, noStandardDescriptorAccessor_);
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
  
  public static MessageOptions parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (MessageOptions)PARSER.parseFrom(data);
  }
  
  public static MessageOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (MessageOptions)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static MessageOptions parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (MessageOptions)PARSER.parseFrom(data);
  }
  
  public static MessageOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (MessageOptions)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static MessageOptions parseFrom(InputStream input)
    throws IOException
  {
    return (MessageOptions)PARSER.parseFrom(input);
  }
  
  public static MessageOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (MessageOptions)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static MessageOptions parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (MessageOptions)PARSER.parseDelimitedFrom(input);
  }
  
  public static MessageOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (MessageOptions)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static MessageOptions parseFrom(CodedInputStream input)
    throws IOException
  {
    return (MessageOptions)PARSER.parseFrom(input);
  }
  
  public static MessageOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (MessageOptions)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$12400();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(MessageOptions prototype)
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
      messageSetWireFormat_ = messageSetWireFormat_;
      if ((from_bitField0_ & 0x2) == 2) {
        to_bitField0_ |= 0x2;
      }
      noStandardDescriptorAccessor_ = noStandardDescriptorAccessor_;
      if (uninterpretedOptionBuilder_ == null)
      {
        if ((bitField0_ & 0x4) == 4)
        {
          uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
          bitField0_ &= 0xFFFFFFFB;
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
        if (!uninterpretedOption_.isEmpty())
        {
          if (uninterpretedOption_.isEmpty())
          {
            uninterpretedOption_ = uninterpretedOption_;
            bitField0_ &= 0xFFFFFFFB;
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
          bitField0_ &= 0xFFFFFFFB;
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
  
  static
  {
    defaultInstance = new MessageOptions(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.MessageOptions
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */