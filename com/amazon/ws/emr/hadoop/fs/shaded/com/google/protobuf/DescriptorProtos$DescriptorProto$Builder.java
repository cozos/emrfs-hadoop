package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$DescriptorProto$Builder
  extends GeneratedMessage.Builder<Builder>
  implements DescriptorProtos.DescriptorProtoOrBuilder
{
  private int bitField0_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$2500();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$2600().ensureFieldAccessorsInitialized(DescriptorProtos.DescriptorProto.class, Builder.class);
  }
  
  private DescriptorProtos$DescriptorProto$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$DescriptorProto$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
    maybeForceBuilderInitialization();
  }
  
  private void maybeForceBuilderInitialization()
  {
    if (GeneratedMessage.alwaysUseFieldBuilders)
    {
      getFieldFieldBuilder();
      getExtensionFieldBuilder();
      getNestedTypeFieldBuilder();
      getEnumTypeFieldBuilder();
      getExtensionRangeFieldBuilder();
      getOptionsFieldBuilder();
    }
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  public Builder clear()
  {
    super.clear();
    name_ = "";
    bitField0_ &= 0xFFFFFFFE;
    if (fieldBuilder_ == null)
    {
      field_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFD;
    }
    else
    {
      fieldBuilder_.clear();
    }
    if (extensionBuilder_ == null)
    {
      extension_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFB;
    }
    else
    {
      extensionBuilder_.clear();
    }
    if (nestedTypeBuilder_ == null)
    {
      nestedType_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFF7;
    }
    else
    {
      nestedTypeBuilder_.clear();
    }
    if (enumTypeBuilder_ == null)
    {
      enumType_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFEF;
    }
    else
    {
      enumTypeBuilder_.clear();
    }
    if (extensionRangeBuilder_ == null)
    {
      extensionRange_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFDF;
    }
    else
    {
      extensionRangeBuilder_.clear();
    }
    if (optionsBuilder_ == null) {
      options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
    } else {
      optionsBuilder_.clear();
    }
    bitField0_ &= 0xFFFFFFBF;
    return this;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.access$2500();
  }
  
  public DescriptorProtos.DescriptorProto getDefaultInstanceForType()
  {
    return DescriptorProtos.DescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.DescriptorProto build()
  {
    DescriptorProtos.DescriptorProto result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.DescriptorProto buildPartial()
  {
    DescriptorProtos.DescriptorProto result = new DescriptorProtos.DescriptorProto(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.DescriptorProto.access$4002(result, name_);
    if (fieldBuilder_ == null)
    {
      if ((bitField0_ & 0x2) == 2)
      {
        field_ = Collections.unmodifiableList(field_);
        bitField0_ &= 0xFFFFFFFD;
      }
      DescriptorProtos.DescriptorProto.access$4102(result, field_);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$4102(result, fieldBuilder_.build());
    }
    if (extensionBuilder_ == null)
    {
      if ((bitField0_ & 0x4) == 4)
      {
        extension_ = Collections.unmodifiableList(extension_);
        bitField0_ &= 0xFFFFFFFB;
      }
      DescriptorProtos.DescriptorProto.access$4202(result, extension_);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$4202(result, extensionBuilder_.build());
    }
    if (nestedTypeBuilder_ == null)
    {
      if ((bitField0_ & 0x8) == 8)
      {
        nestedType_ = Collections.unmodifiableList(nestedType_);
        bitField0_ &= 0xFFFFFFF7;
      }
      DescriptorProtos.DescriptorProto.access$4302(result, nestedType_);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$4302(result, nestedTypeBuilder_.build());
    }
    if (enumTypeBuilder_ == null)
    {
      if ((bitField0_ & 0x10) == 16)
      {
        enumType_ = Collections.unmodifiableList(enumType_);
        bitField0_ &= 0xFFFFFFEF;
      }
      DescriptorProtos.DescriptorProto.access$4402(result, enumType_);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$4402(result, enumTypeBuilder_.build());
    }
    if (extensionRangeBuilder_ == null)
    {
      if ((bitField0_ & 0x20) == 32)
      {
        extensionRange_ = Collections.unmodifiableList(extensionRange_);
        bitField0_ &= 0xFFFFFFDF;
      }
      DescriptorProtos.DescriptorProto.access$4502(result, extensionRange_);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$4502(result, extensionRangeBuilder_.build());
    }
    if ((from_bitField0_ & 0x40) == 64) {
      to_bitField0_ |= 0x2;
    }
    if (optionsBuilder_ == null) {
      DescriptorProtos.DescriptorProto.access$4602(result, options_);
    } else {
      DescriptorProtos.DescriptorProto.access$4602(result, (DescriptorProtos.MessageOptions)optionsBuilder_.build());
    }
    DescriptorProtos.DescriptorProto.access$4702(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.DescriptorProto)) {
      return mergeFrom((DescriptorProtos.DescriptorProto)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.DescriptorProto other)
  {
    if (other == DescriptorProtos.DescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (other.hasName())
    {
      bitField0_ |= 0x1;
      name_ = DescriptorProtos.DescriptorProto.access$4000(other);
      onChanged();
    }
    if (fieldBuilder_ == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$4100(other).isEmpty())
      {
        if (field_.isEmpty())
        {
          field_ = DescriptorProtos.DescriptorProto.access$4100(other);
          bitField0_ &= 0xFFFFFFFD;
        }
        else
        {
          ensureFieldIsMutable();
          field_.addAll(DescriptorProtos.DescriptorProto.access$4100(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$4100(other).isEmpty()) {
      if (fieldBuilder_.isEmpty())
      {
        fieldBuilder_.dispose();
        fieldBuilder_ = null;
        field_ = DescriptorProtos.DescriptorProto.access$4100(other);
        bitField0_ &= 0xFFFFFFFD;
        fieldBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getFieldFieldBuilder() : null);
      }
      else
      {
        fieldBuilder_.addAllMessages(DescriptorProtos.DescriptorProto.access$4100(other));
      }
    }
    if (extensionBuilder_ == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$4200(other).isEmpty())
      {
        if (extension_.isEmpty())
        {
          extension_ = DescriptorProtos.DescriptorProto.access$4200(other);
          bitField0_ &= 0xFFFFFFFB;
        }
        else
        {
          ensureExtensionIsMutable();
          extension_.addAll(DescriptorProtos.DescriptorProto.access$4200(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$4200(other).isEmpty()) {
      if (extensionBuilder_.isEmpty())
      {
        extensionBuilder_.dispose();
        extensionBuilder_ = null;
        extension_ = DescriptorProtos.DescriptorProto.access$4200(other);
        bitField0_ &= 0xFFFFFFFB;
        extensionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getExtensionFieldBuilder() : null);
      }
      else
      {
        extensionBuilder_.addAllMessages(DescriptorProtos.DescriptorProto.access$4200(other));
      }
    }
    if (nestedTypeBuilder_ == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$4300(other).isEmpty())
      {
        if (nestedType_.isEmpty())
        {
          nestedType_ = DescriptorProtos.DescriptorProto.access$4300(other);
          bitField0_ &= 0xFFFFFFF7;
        }
        else
        {
          ensureNestedTypeIsMutable();
          nestedType_.addAll(DescriptorProtos.DescriptorProto.access$4300(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$4300(other).isEmpty()) {
      if (nestedTypeBuilder_.isEmpty())
      {
        nestedTypeBuilder_.dispose();
        nestedTypeBuilder_ = null;
        nestedType_ = DescriptorProtos.DescriptorProto.access$4300(other);
        bitField0_ &= 0xFFFFFFF7;
        nestedTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getNestedTypeFieldBuilder() : null);
      }
      else
      {
        nestedTypeBuilder_.addAllMessages(DescriptorProtos.DescriptorProto.access$4300(other));
      }
    }
    if (enumTypeBuilder_ == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$4400(other).isEmpty())
      {
        if (enumType_.isEmpty())
        {
          enumType_ = DescriptorProtos.DescriptorProto.access$4400(other);
          bitField0_ &= 0xFFFFFFEF;
        }
        else
        {
          ensureEnumTypeIsMutable();
          enumType_.addAll(DescriptorProtos.DescriptorProto.access$4400(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$4400(other).isEmpty()) {
      if (enumTypeBuilder_.isEmpty())
      {
        enumTypeBuilder_.dispose();
        enumTypeBuilder_ = null;
        enumType_ = DescriptorProtos.DescriptorProto.access$4400(other);
        bitField0_ &= 0xFFFFFFEF;
        enumTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getEnumTypeFieldBuilder() : null);
      }
      else
      {
        enumTypeBuilder_.addAllMessages(DescriptorProtos.DescriptorProto.access$4400(other));
      }
    }
    if (extensionRangeBuilder_ == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$4500(other).isEmpty())
      {
        if (extensionRange_.isEmpty())
        {
          extensionRange_ = DescriptorProtos.DescriptorProto.access$4500(other);
          bitField0_ &= 0xFFFFFFDF;
        }
        else
        {
          ensureExtensionRangeIsMutable();
          extensionRange_.addAll(DescriptorProtos.DescriptorProto.access$4500(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$4500(other).isEmpty()) {
      if (extensionRangeBuilder_.isEmpty())
      {
        extensionRangeBuilder_.dispose();
        extensionRangeBuilder_ = null;
        extensionRange_ = DescriptorProtos.DescriptorProto.access$4500(other);
        bitField0_ &= 0xFFFFFFDF;
        extensionRangeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getExtensionRangeFieldBuilder() : null);
      }
      else
      {
        extensionRangeBuilder_.addAllMessages(DescriptorProtos.DescriptorProto.access$4500(other));
      }
    }
    if (other.hasOptions()) {
      mergeOptions(other.getOptions());
    }
    mergeUnknownFields(other.getUnknownFields());
    return this;
  }
  
  public final boolean isInitialized()
  {
    for (int i = 0; i < getFieldCount(); i++) {
      if (!getField(i).isInitialized()) {
        return false;
      }
    }
    for (int i = 0; i < getExtensionCount(); i++) {
      if (!getExtension(i).isInitialized()) {
        return false;
      }
    }
    for (int i = 0; i < getNestedTypeCount(); i++) {
      if (!getNestedType(i).isInitialized()) {
        return false;
      }
    }
    for (int i = 0; i < getEnumTypeCount(); i++) {
      if (!getEnumType(i).isInitialized()) {
        return false;
      }
    }
    if ((hasOptions()) && 
      (!getOptions().isInitialized())) {
      return false;
    }
    return true;
  }
  
  public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    DescriptorProtos.DescriptorProto parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.DescriptorProto)DescriptorProtos.DescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.DescriptorProto)e.getUnfinishedMessage();
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
  
  private Object name_ = "";
  
  public boolean hasName()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public String getName()
  {
    Object ref = name_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      name_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getNameBytes()
  {
    Object ref = name_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      name_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setName(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x1;
    name_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearName()
  {
    bitField0_ &= 0xFFFFFFFE;
    name_ = DescriptorProtos.DescriptorProto.getDefaultInstance().getName();
    onChanged();
    return this;
  }
  
  public Builder setNameBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x1;
    name_ = value;
    onChanged();
    return this;
  }
  
  private List<DescriptorProtos.FieldDescriptorProto> field_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> fieldBuilder_;
  
  private void ensureFieldIsMutable()
  {
    if ((bitField0_ & 0x2) != 2)
    {
      field_ = new ArrayList(field_);
      bitField0_ |= 0x2;
    }
  }
  
  public List<DescriptorProtos.FieldDescriptorProto> getFieldList()
  {
    if (fieldBuilder_ == null) {
      return Collections.unmodifiableList(field_);
    }
    return fieldBuilder_.getMessageList();
  }
  
  public int getFieldCount()
  {
    if (fieldBuilder_ == null) {
      return field_.size();
    }
    return fieldBuilder_.getCount();
  }
  
  public DescriptorProtos.FieldDescriptorProto getField(int index)
  {
    if (fieldBuilder_ == null) {
      return (DescriptorProtos.FieldDescriptorProto)field_.get(index);
    }
    return (DescriptorProtos.FieldDescriptorProto)fieldBuilder_.getMessage(index);
  }
  
  public Builder setField(int index, DescriptorProtos.FieldDescriptorProto value)
  {
    if (fieldBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureFieldIsMutable();
      field_.set(index, value);
      onChanged();
    }
    else
    {
      fieldBuilder_.setMessage(index, value);
    }
    return this;
  }
  
  public Builder setField(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
  {
    if (fieldBuilder_ == null)
    {
      ensureFieldIsMutable();
      field_.set(index, builderForValue.build());
      onChanged();
    }
    else
    {
      fieldBuilder_.setMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addField(DescriptorProtos.FieldDescriptorProto value)
  {
    if (fieldBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureFieldIsMutable();
      field_.add(value);
      onChanged();
    }
    else
    {
      fieldBuilder_.addMessage(value);
    }
    return this;
  }
  
  public Builder addField(int index, DescriptorProtos.FieldDescriptorProto value)
  {
    if (fieldBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureFieldIsMutable();
      field_.add(index, value);
      onChanged();
    }
    else
    {
      fieldBuilder_.addMessage(index, value);
    }
    return this;
  }
  
  public Builder addField(DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
  {
    if (fieldBuilder_ == null)
    {
      ensureFieldIsMutable();
      field_.add(builderForValue.build());
      onChanged();
    }
    else
    {
      fieldBuilder_.addMessage(builderForValue.build());
    }
    return this;
  }
  
  public Builder addField(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
  {
    if (fieldBuilder_ == null)
    {
      ensureFieldIsMutable();
      field_.add(index, builderForValue.build());
      onChanged();
    }
    else
    {
      fieldBuilder_.addMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addAllField(Iterable<? extends DescriptorProtos.FieldDescriptorProto> values)
  {
    if (fieldBuilder_ == null)
    {
      ensureFieldIsMutable();
      GeneratedMessage.Builder.addAll(values, field_);
      onChanged();
    }
    else
    {
      fieldBuilder_.addAllMessages(values);
    }
    return this;
  }
  
  public Builder clearField()
  {
    if (fieldBuilder_ == null)
    {
      field_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFD;
      onChanged();
    }
    else
    {
      fieldBuilder_.clear();
    }
    return this;
  }
  
  public Builder removeField(int index)
  {
    if (fieldBuilder_ == null)
    {
      ensureFieldIsMutable();
      field_.remove(index);
      onChanged();
    }
    else
    {
      fieldBuilder_.remove(index);
    }
    return this;
  }
  
  public DescriptorProtos.FieldDescriptorProto.Builder getFieldBuilder(int index)
  {
    return (DescriptorProtos.FieldDescriptorProto.Builder)getFieldFieldBuilder().getBuilder(index);
  }
  
  public DescriptorProtos.FieldDescriptorProtoOrBuilder getFieldOrBuilder(int index)
  {
    if (fieldBuilder_ == null) {
      return (DescriptorProtos.FieldDescriptorProtoOrBuilder)field_.get(index);
    }
    return (DescriptorProtos.FieldDescriptorProtoOrBuilder)fieldBuilder_.getMessageOrBuilder(index);
  }
  
  public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getFieldOrBuilderList()
  {
    if (fieldBuilder_ != null) {
      return fieldBuilder_.getMessageOrBuilderList();
    }
    return Collections.unmodifiableList(field_);
  }
  
  public DescriptorProtos.FieldDescriptorProto.Builder addFieldBuilder()
  {
    return (DescriptorProtos.FieldDescriptorProto.Builder)getFieldFieldBuilder().addBuilder(DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
  }
  
  public DescriptorProtos.FieldDescriptorProto.Builder addFieldBuilder(int index)
  {
    return (DescriptorProtos.FieldDescriptorProto.Builder)getFieldFieldBuilder().addBuilder(index, DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
  }
  
  public List<DescriptorProtos.FieldDescriptorProto.Builder> getFieldBuilderList()
  {
    return getFieldFieldBuilder().getBuilderList();
  }
  
  private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> getFieldFieldBuilder()
  {
    if (fieldBuilder_ == null)
    {
      fieldBuilder_ = new RepeatedFieldBuilder(field_, (bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
      
      field_ = null;
    }
    return fieldBuilder_;
  }
  
  private List<DescriptorProtos.FieldDescriptorProto> extension_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> extensionBuilder_;
  
  private void ensureExtensionIsMutable()
  {
    if ((bitField0_ & 0x4) != 4)
    {
      extension_ = new ArrayList(extension_);
      bitField0_ |= 0x4;
    }
  }
  
  public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
  {
    if (extensionBuilder_ == null) {
      return Collections.unmodifiableList(extension_);
    }
    return extensionBuilder_.getMessageList();
  }
  
  public int getExtensionCount()
  {
    if (extensionBuilder_ == null) {
      return extension_.size();
    }
    return extensionBuilder_.getCount();
  }
  
  public DescriptorProtos.FieldDescriptorProto getExtension(int index)
  {
    if (extensionBuilder_ == null) {
      return (DescriptorProtos.FieldDescriptorProto)extension_.get(index);
    }
    return (DescriptorProtos.FieldDescriptorProto)extensionBuilder_.getMessage(index);
  }
  
  public Builder setExtension(int index, DescriptorProtos.FieldDescriptorProto value)
  {
    if (extensionBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureExtensionIsMutable();
      extension_.set(index, value);
      onChanged();
    }
    else
    {
      extensionBuilder_.setMessage(index, value);
    }
    return this;
  }
  
  public Builder setExtension(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
  {
    if (extensionBuilder_ == null)
    {
      ensureExtensionIsMutable();
      extension_.set(index, builderForValue.build());
      onChanged();
    }
    else
    {
      extensionBuilder_.setMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addExtension(DescriptorProtos.FieldDescriptorProto value)
  {
    if (extensionBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureExtensionIsMutable();
      extension_.add(value);
      onChanged();
    }
    else
    {
      extensionBuilder_.addMessage(value);
    }
    return this;
  }
  
  public Builder addExtension(int index, DescriptorProtos.FieldDescriptorProto value)
  {
    if (extensionBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureExtensionIsMutable();
      extension_.add(index, value);
      onChanged();
    }
    else
    {
      extensionBuilder_.addMessage(index, value);
    }
    return this;
  }
  
  public Builder addExtension(DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
  {
    if (extensionBuilder_ == null)
    {
      ensureExtensionIsMutable();
      extension_.add(builderForValue.build());
      onChanged();
    }
    else
    {
      extensionBuilder_.addMessage(builderForValue.build());
    }
    return this;
  }
  
  public Builder addExtension(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
  {
    if (extensionBuilder_ == null)
    {
      ensureExtensionIsMutable();
      extension_.add(index, builderForValue.build());
      onChanged();
    }
    else
    {
      extensionBuilder_.addMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addAllExtension(Iterable<? extends DescriptorProtos.FieldDescriptorProto> values)
  {
    if (extensionBuilder_ == null)
    {
      ensureExtensionIsMutable();
      GeneratedMessage.Builder.addAll(values, extension_);
      onChanged();
    }
    else
    {
      extensionBuilder_.addAllMessages(values);
    }
    return this;
  }
  
  public Builder clearExtension()
  {
    if (extensionBuilder_ == null)
    {
      extension_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFB;
      onChanged();
    }
    else
    {
      extensionBuilder_.clear();
    }
    return this;
  }
  
  public Builder removeExtension(int index)
  {
    if (extensionBuilder_ == null)
    {
      ensureExtensionIsMutable();
      extension_.remove(index);
      onChanged();
    }
    else
    {
      extensionBuilder_.remove(index);
    }
    return this;
  }
  
  public DescriptorProtos.FieldDescriptorProto.Builder getExtensionBuilder(int index)
  {
    return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().getBuilder(index);
  }
  
  public DescriptorProtos.FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index)
  {
    if (extensionBuilder_ == null) {
      return (DescriptorProtos.FieldDescriptorProtoOrBuilder)extension_.get(index);
    }
    return (DescriptorProtos.FieldDescriptorProtoOrBuilder)extensionBuilder_.getMessageOrBuilder(index);
  }
  
  public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList()
  {
    if (extensionBuilder_ != null) {
      return extensionBuilder_.getMessageOrBuilderList();
    }
    return Collections.unmodifiableList(extension_);
  }
  
  public DescriptorProtos.FieldDescriptorProto.Builder addExtensionBuilder()
  {
    return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().addBuilder(DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
  }
  
  public DescriptorProtos.FieldDescriptorProto.Builder addExtensionBuilder(int index)
  {
    return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().addBuilder(index, DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
  }
  
  public List<DescriptorProtos.FieldDescriptorProto.Builder> getExtensionBuilderList()
  {
    return getExtensionFieldBuilder().getBuilderList();
  }
  
  private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionFieldBuilder()
  {
    if (extensionBuilder_ == null)
    {
      extensionBuilder_ = new RepeatedFieldBuilder(extension_, (bitField0_ & 0x4) == 4, getParentForChildren(), isClean());
      
      extension_ = null;
    }
    return extensionBuilder_;
  }
  
  private List<DescriptorProtos.DescriptorProto> nestedType_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto, Builder, DescriptorProtos.DescriptorProtoOrBuilder> nestedTypeBuilder_;
  
  private void ensureNestedTypeIsMutable()
  {
    if ((bitField0_ & 0x8) != 8)
    {
      nestedType_ = new ArrayList(nestedType_);
      bitField0_ |= 0x8;
    }
  }
  
  public List<DescriptorProtos.DescriptorProto> getNestedTypeList()
  {
    if (nestedTypeBuilder_ == null) {
      return Collections.unmodifiableList(nestedType_);
    }
    return nestedTypeBuilder_.getMessageList();
  }
  
  public int getNestedTypeCount()
  {
    if (nestedTypeBuilder_ == null) {
      return nestedType_.size();
    }
    return nestedTypeBuilder_.getCount();
  }
  
  public DescriptorProtos.DescriptorProto getNestedType(int index)
  {
    if (nestedTypeBuilder_ == null) {
      return (DescriptorProtos.DescriptorProto)nestedType_.get(index);
    }
    return (DescriptorProtos.DescriptorProto)nestedTypeBuilder_.getMessage(index);
  }
  
  public Builder setNestedType(int index, DescriptorProtos.DescriptorProto value)
  {
    if (nestedTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureNestedTypeIsMutable();
      nestedType_.set(index, value);
      onChanged();
    }
    else
    {
      nestedTypeBuilder_.setMessage(index, value);
    }
    return this;
  }
  
  public Builder setNestedType(int index, Builder builderForValue)
  {
    if (nestedTypeBuilder_ == null)
    {
      ensureNestedTypeIsMutable();
      nestedType_.set(index, builderForValue.build());
      onChanged();
    }
    else
    {
      nestedTypeBuilder_.setMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addNestedType(DescriptorProtos.DescriptorProto value)
  {
    if (nestedTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureNestedTypeIsMutable();
      nestedType_.add(value);
      onChanged();
    }
    else
    {
      nestedTypeBuilder_.addMessage(value);
    }
    return this;
  }
  
  public Builder addNestedType(int index, DescriptorProtos.DescriptorProto value)
  {
    if (nestedTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureNestedTypeIsMutable();
      nestedType_.add(index, value);
      onChanged();
    }
    else
    {
      nestedTypeBuilder_.addMessage(index, value);
    }
    return this;
  }
  
  public Builder addNestedType(Builder builderForValue)
  {
    if (nestedTypeBuilder_ == null)
    {
      ensureNestedTypeIsMutable();
      nestedType_.add(builderForValue.build());
      onChanged();
    }
    else
    {
      nestedTypeBuilder_.addMessage(builderForValue.build());
    }
    return this;
  }
  
  public Builder addNestedType(int index, Builder builderForValue)
  {
    if (nestedTypeBuilder_ == null)
    {
      ensureNestedTypeIsMutable();
      nestedType_.add(index, builderForValue.build());
      onChanged();
    }
    else
    {
      nestedTypeBuilder_.addMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addAllNestedType(Iterable<? extends DescriptorProtos.DescriptorProto> values)
  {
    if (nestedTypeBuilder_ == null)
    {
      ensureNestedTypeIsMutable();
      GeneratedMessage.Builder.addAll(values, nestedType_);
      onChanged();
    }
    else
    {
      nestedTypeBuilder_.addAllMessages(values);
    }
    return this;
  }
  
  public Builder clearNestedType()
  {
    if (nestedTypeBuilder_ == null)
    {
      nestedType_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFF7;
      onChanged();
    }
    else
    {
      nestedTypeBuilder_.clear();
    }
    return this;
  }
  
  public Builder removeNestedType(int index)
  {
    if (nestedTypeBuilder_ == null)
    {
      ensureNestedTypeIsMutable();
      nestedType_.remove(index);
      onChanged();
    }
    else
    {
      nestedTypeBuilder_.remove(index);
    }
    return this;
  }
  
  public Builder getNestedTypeBuilder(int index)
  {
    return (Builder)getNestedTypeFieldBuilder().getBuilder(index);
  }
  
  public DescriptorProtos.DescriptorProtoOrBuilder getNestedTypeOrBuilder(int index)
  {
    if (nestedTypeBuilder_ == null) {
      return (DescriptorProtos.DescriptorProtoOrBuilder)nestedType_.get(index);
    }
    return (DescriptorProtos.DescriptorProtoOrBuilder)nestedTypeBuilder_.getMessageOrBuilder(index);
  }
  
  public List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getNestedTypeOrBuilderList()
  {
    if (nestedTypeBuilder_ != null) {
      return nestedTypeBuilder_.getMessageOrBuilderList();
    }
    return Collections.unmodifiableList(nestedType_);
  }
  
  public Builder addNestedTypeBuilder()
  {
    return (Builder)getNestedTypeFieldBuilder().addBuilder(DescriptorProtos.DescriptorProto.getDefaultInstance());
  }
  
  public Builder addNestedTypeBuilder(int index)
  {
    return (Builder)getNestedTypeFieldBuilder().addBuilder(index, DescriptorProtos.DescriptorProto.getDefaultInstance());
  }
  
  public List<Builder> getNestedTypeBuilderList()
  {
    return getNestedTypeFieldBuilder().getBuilderList();
  }
  
  private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto, Builder, DescriptorProtos.DescriptorProtoOrBuilder> getNestedTypeFieldBuilder()
  {
    if (nestedTypeBuilder_ == null)
    {
      nestedTypeBuilder_ = new RepeatedFieldBuilder(nestedType_, (bitField0_ & 0x8) == 8, getParentForChildren(), isClean());
      
      nestedType_ = null;
    }
    return nestedTypeBuilder_;
  }
  
  private List<DescriptorProtos.EnumDescriptorProto> enumType_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> enumTypeBuilder_;
  
  private void ensureEnumTypeIsMutable()
  {
    if ((bitField0_ & 0x10) != 16)
    {
      enumType_ = new ArrayList(enumType_);
      bitField0_ |= 0x10;
    }
  }
  
  public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
  {
    if (enumTypeBuilder_ == null) {
      return Collections.unmodifiableList(enumType_);
    }
    return enumTypeBuilder_.getMessageList();
  }
  
  public int getEnumTypeCount()
  {
    if (enumTypeBuilder_ == null) {
      return enumType_.size();
    }
    return enumTypeBuilder_.getCount();
  }
  
  public DescriptorProtos.EnumDescriptorProto getEnumType(int index)
  {
    if (enumTypeBuilder_ == null) {
      return (DescriptorProtos.EnumDescriptorProto)enumType_.get(index);
    }
    return (DescriptorProtos.EnumDescriptorProto)enumTypeBuilder_.getMessage(index);
  }
  
  public Builder setEnumType(int index, DescriptorProtos.EnumDescriptorProto value)
  {
    if (enumTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureEnumTypeIsMutable();
      enumType_.set(index, value);
      onChanged();
    }
    else
    {
      enumTypeBuilder_.setMessage(index, value);
    }
    return this;
  }
  
  public Builder setEnumType(int index, DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
  {
    if (enumTypeBuilder_ == null)
    {
      ensureEnumTypeIsMutable();
      enumType_.set(index, builderForValue.build());
      onChanged();
    }
    else
    {
      enumTypeBuilder_.setMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addEnumType(DescriptorProtos.EnumDescriptorProto value)
  {
    if (enumTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureEnumTypeIsMutable();
      enumType_.add(value);
      onChanged();
    }
    else
    {
      enumTypeBuilder_.addMessage(value);
    }
    return this;
  }
  
  public Builder addEnumType(int index, DescriptorProtos.EnumDescriptorProto value)
  {
    if (enumTypeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureEnumTypeIsMutable();
      enumType_.add(index, value);
      onChanged();
    }
    else
    {
      enumTypeBuilder_.addMessage(index, value);
    }
    return this;
  }
  
  public Builder addEnumType(DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
  {
    if (enumTypeBuilder_ == null)
    {
      ensureEnumTypeIsMutable();
      enumType_.add(builderForValue.build());
      onChanged();
    }
    else
    {
      enumTypeBuilder_.addMessage(builderForValue.build());
    }
    return this;
  }
  
  public Builder addEnumType(int index, DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
  {
    if (enumTypeBuilder_ == null)
    {
      ensureEnumTypeIsMutable();
      enumType_.add(index, builderForValue.build());
      onChanged();
    }
    else
    {
      enumTypeBuilder_.addMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addAllEnumType(Iterable<? extends DescriptorProtos.EnumDescriptorProto> values)
  {
    if (enumTypeBuilder_ == null)
    {
      ensureEnumTypeIsMutable();
      GeneratedMessage.Builder.addAll(values, enumType_);
      onChanged();
    }
    else
    {
      enumTypeBuilder_.addAllMessages(values);
    }
    return this;
  }
  
  public Builder clearEnumType()
  {
    if (enumTypeBuilder_ == null)
    {
      enumType_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFEF;
      onChanged();
    }
    else
    {
      enumTypeBuilder_.clear();
    }
    return this;
  }
  
  public Builder removeEnumType(int index)
  {
    if (enumTypeBuilder_ == null)
    {
      ensureEnumTypeIsMutable();
      enumType_.remove(index);
      onChanged();
    }
    else
    {
      enumTypeBuilder_.remove(index);
    }
    return this;
  }
  
  public DescriptorProtos.EnumDescriptorProto.Builder getEnumTypeBuilder(int index)
  {
    return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().getBuilder(index);
  }
  
  public DescriptorProtos.EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index)
  {
    if (enumTypeBuilder_ == null) {
      return (DescriptorProtos.EnumDescriptorProtoOrBuilder)enumType_.get(index);
    }
    return (DescriptorProtos.EnumDescriptorProtoOrBuilder)enumTypeBuilder_.getMessageOrBuilder(index);
  }
  
  public List<? extends DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList()
  {
    if (enumTypeBuilder_ != null) {
      return enumTypeBuilder_.getMessageOrBuilderList();
    }
    return Collections.unmodifiableList(enumType_);
  }
  
  public DescriptorProtos.EnumDescriptorProto.Builder addEnumTypeBuilder()
  {
    return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().addBuilder(DescriptorProtos.EnumDescriptorProto.getDefaultInstance());
  }
  
  public DescriptorProtos.EnumDescriptorProto.Builder addEnumTypeBuilder(int index)
  {
    return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().addBuilder(index, DescriptorProtos.EnumDescriptorProto.getDefaultInstance());
  }
  
  public List<DescriptorProtos.EnumDescriptorProto.Builder> getEnumTypeBuilderList()
  {
    return getEnumTypeFieldBuilder().getBuilderList();
  }
  
  private RepeatedFieldBuilder<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeFieldBuilder()
  {
    if (enumTypeBuilder_ == null)
    {
      enumTypeBuilder_ = new RepeatedFieldBuilder(enumType_, (bitField0_ & 0x10) == 16, getParentForChildren(), isClean());
      
      enumType_ = null;
    }
    return enumTypeBuilder_;
  }
  
  private List<DescriptorProtos.DescriptorProto.ExtensionRange> extensionRange_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto.ExtensionRange, DescriptorProtos.DescriptorProto.ExtensionRange.Builder, DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> extensionRangeBuilder_;
  
  private void ensureExtensionRangeIsMutable()
  {
    if ((bitField0_ & 0x20) != 32)
    {
      extensionRange_ = new ArrayList(extensionRange_);
      bitField0_ |= 0x20;
    }
  }
  
  public List<DescriptorProtos.DescriptorProto.ExtensionRange> getExtensionRangeList()
  {
    if (extensionRangeBuilder_ == null) {
      return Collections.unmodifiableList(extensionRange_);
    }
    return extensionRangeBuilder_.getMessageList();
  }
  
  public int getExtensionRangeCount()
  {
    if (extensionRangeBuilder_ == null) {
      return extensionRange_.size();
    }
    return extensionRangeBuilder_.getCount();
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRange getExtensionRange(int index)
  {
    if (extensionRangeBuilder_ == null) {
      return (DescriptorProtos.DescriptorProto.ExtensionRange)extensionRange_.get(index);
    }
    return (DescriptorProtos.DescriptorProto.ExtensionRange)extensionRangeBuilder_.getMessage(index);
  }
  
  public Builder setExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange value)
  {
    if (extensionRangeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureExtensionRangeIsMutable();
      extensionRange_.set(index, value);
      onChanged();
    }
    else
    {
      extensionRangeBuilder_.setMessage(index, value);
    }
    return this;
  }
  
  public Builder setExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange.Builder builderForValue)
  {
    if (extensionRangeBuilder_ == null)
    {
      ensureExtensionRangeIsMutable();
      extensionRange_.set(index, builderForValue.build());
      onChanged();
    }
    else
    {
      extensionRangeBuilder_.setMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange value)
  {
    if (extensionRangeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureExtensionRangeIsMutable();
      extensionRange_.add(value);
      onChanged();
    }
    else
    {
      extensionRangeBuilder_.addMessage(value);
    }
    return this;
  }
  
  public Builder addExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange value)
  {
    if (extensionRangeBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureExtensionRangeIsMutable();
      extensionRange_.add(index, value);
      onChanged();
    }
    else
    {
      extensionRangeBuilder_.addMessage(index, value);
    }
    return this;
  }
  
  public Builder addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.Builder builderForValue)
  {
    if (extensionRangeBuilder_ == null)
    {
      ensureExtensionRangeIsMutable();
      extensionRange_.add(builderForValue.build());
      onChanged();
    }
    else
    {
      extensionRangeBuilder_.addMessage(builderForValue.build());
    }
    return this;
  }
  
  public Builder addExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange.Builder builderForValue)
  {
    if (extensionRangeBuilder_ == null)
    {
      ensureExtensionRangeIsMutable();
      extensionRange_.add(index, builderForValue.build());
      onChanged();
    }
    else
    {
      extensionRangeBuilder_.addMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addAllExtensionRange(Iterable<? extends DescriptorProtos.DescriptorProto.ExtensionRange> values)
  {
    if (extensionRangeBuilder_ == null)
    {
      ensureExtensionRangeIsMutable();
      GeneratedMessage.Builder.addAll(values, extensionRange_);
      onChanged();
    }
    else
    {
      extensionRangeBuilder_.addAllMessages(values);
    }
    return this;
  }
  
  public Builder clearExtensionRange()
  {
    if (extensionRangeBuilder_ == null)
    {
      extensionRange_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFDF;
      onChanged();
    }
    else
    {
      extensionRangeBuilder_.clear();
    }
    return this;
  }
  
  public Builder removeExtensionRange(int index)
  {
    if (extensionRangeBuilder_ == null)
    {
      ensureExtensionRangeIsMutable();
      extensionRange_.remove(index);
      onChanged();
    }
    else
    {
      extensionRangeBuilder_.remove(index);
    }
    return this;
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRange.Builder getExtensionRangeBuilder(int index)
  {
    return (DescriptorProtos.DescriptorProto.ExtensionRange.Builder)getExtensionRangeFieldBuilder().getBuilder(index);
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int index)
  {
    if (extensionRangeBuilder_ == null) {
      return (DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder)extensionRange_.get(index);
    }
    return (DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder)extensionRangeBuilder_.getMessageOrBuilder(index);
  }
  
  public List<? extends DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList()
  {
    if (extensionRangeBuilder_ != null) {
      return extensionRangeBuilder_.getMessageOrBuilderList();
    }
    return Collections.unmodifiableList(extensionRange_);
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRange.Builder addExtensionRangeBuilder()
  {
    return (DescriptorProtos.DescriptorProto.ExtensionRange.Builder)getExtensionRangeFieldBuilder().addBuilder(DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance());
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRange.Builder addExtensionRangeBuilder(int index)
  {
    return (DescriptorProtos.DescriptorProto.ExtensionRange.Builder)getExtensionRangeFieldBuilder().addBuilder(index, DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance());
  }
  
  public List<DescriptorProtos.DescriptorProto.ExtensionRange.Builder> getExtensionRangeBuilderList()
  {
    return getExtensionRangeFieldBuilder().getBuilderList();
  }
  
  private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto.ExtensionRange, DescriptorProtos.DescriptorProto.ExtensionRange.Builder, DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> getExtensionRangeFieldBuilder()
  {
    if (extensionRangeBuilder_ == null)
    {
      extensionRangeBuilder_ = new RepeatedFieldBuilder(extensionRange_, (bitField0_ & 0x20) == 32, getParentForChildren(), isClean());
      
      extensionRange_ = null;
    }
    return extensionRangeBuilder_;
  }
  
  private DescriptorProtos.MessageOptions options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
  private SingleFieldBuilder<DescriptorProtos.MessageOptions, DescriptorProtos.MessageOptions.Builder, DescriptorProtos.MessageOptionsOrBuilder> optionsBuilder_;
  
  public boolean hasOptions()
  {
    return (bitField0_ & 0x40) == 64;
  }
  
  public DescriptorProtos.MessageOptions getOptions()
  {
    if (optionsBuilder_ == null) {
      return options_;
    }
    return (DescriptorProtos.MessageOptions)optionsBuilder_.getMessage();
  }
  
  public Builder setOptions(DescriptorProtos.MessageOptions value)
  {
    if (optionsBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      options_ = value;
      onChanged();
    }
    else
    {
      optionsBuilder_.setMessage(value);
    }
    bitField0_ |= 0x40;
    return this;
  }
  
  public Builder setOptions(DescriptorProtos.MessageOptions.Builder builderForValue)
  {
    if (optionsBuilder_ == null)
    {
      options_ = builderForValue.build();
      onChanged();
    }
    else
    {
      optionsBuilder_.setMessage(builderForValue.build());
    }
    bitField0_ |= 0x40;
    return this;
  }
  
  public Builder mergeOptions(DescriptorProtos.MessageOptions value)
  {
    if (optionsBuilder_ == null)
    {
      if (((bitField0_ & 0x40) == 64) && (options_ != DescriptorProtos.MessageOptions.getDefaultInstance())) {
        options_ = DescriptorProtos.MessageOptions.newBuilder(options_).mergeFrom(value).buildPartial();
      } else {
        options_ = value;
      }
      onChanged();
    }
    else
    {
      optionsBuilder_.mergeFrom(value);
    }
    bitField0_ |= 0x40;
    return this;
  }
  
  public Builder clearOptions()
  {
    if (optionsBuilder_ == null)
    {
      options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
      onChanged();
    }
    else
    {
      optionsBuilder_.clear();
    }
    bitField0_ &= 0xFFFFFFBF;
    return this;
  }
  
  public DescriptorProtos.MessageOptions.Builder getOptionsBuilder()
  {
    bitField0_ |= 0x40;
    onChanged();
    return (DescriptorProtos.MessageOptions.Builder)getOptionsFieldBuilder().getBuilder();
  }
  
  public DescriptorProtos.MessageOptionsOrBuilder getOptionsOrBuilder()
  {
    if (optionsBuilder_ != null) {
      return (DescriptorProtos.MessageOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
    }
    return options_;
  }
  
  private SingleFieldBuilder<DescriptorProtos.MessageOptions, DescriptorProtos.MessageOptions.Builder, DescriptorProtos.MessageOptionsOrBuilder> getOptionsFieldBuilder()
  {
    if (optionsBuilder_ == null)
    {
      optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
      
      options_ = null;
    }
    return optionsBuilder_;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.DescriptorProto.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */