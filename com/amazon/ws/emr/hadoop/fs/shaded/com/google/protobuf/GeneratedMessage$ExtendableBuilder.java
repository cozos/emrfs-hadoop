package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class GeneratedMessage$ExtendableBuilder<MessageType extends GeneratedMessage.ExtendableMessage, BuilderType extends ExtendableBuilder>
  extends GeneratedMessage.Builder<BuilderType>
  implements GeneratedMessage.ExtendableMessageOrBuilder<MessageType>
{
  private FieldSet<Descriptors.FieldDescriptor> extensions = FieldSet.emptySet();
  
  protected GeneratedMessage$ExtendableBuilder() {}
  
  protected GeneratedMessage$ExtendableBuilder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
  }
  
  public BuilderType clear()
  {
    extensions = FieldSet.emptySet();
    return (ExtendableBuilder)super.clear();
  }
  
  public BuilderType clone()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  private void ensureExtensionsIsMutable()
  {
    if (extensions.isImmutable()) {
      extensions = extensions.clone();
    }
  }
  
  private void verifyExtensionContainingType(GeneratedMessage.GeneratedExtension<MessageType, ?> extension)
  {
    if (extension.getDescriptor().getContainingType() != getDescriptorForType()) {
      throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
    }
  }
  
  public final <Type> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> extension)
  {
    verifyExtensionContainingType(extension);
    return extensions.hasField(extension.getDescriptor());
  }
  
  public final <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> extension)
  {
    verifyExtensionContainingType(extension);
    Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
    return extensions.getRepeatedFieldCount(descriptor);
  }
  
  public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> extension)
  {
    verifyExtensionContainingType(extension);
    Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
    Object value = extensions.getField(descriptor);
    if (value == null)
    {
      if (descriptor.isRepeated()) {
        return Collections.emptyList();
      }
      if (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        return extension.getMessageDefaultInstance();
      }
      return (Type)GeneratedMessage.GeneratedExtension.access$400(extension, descriptor.getDefaultValue());
    }
    return (Type)GeneratedMessage.GeneratedExtension.access$400(extension, value);
  }
  
  public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> extension, int index)
  {
    verifyExtensionContainingType(extension);
    Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
    return (Type)GeneratedMessage.GeneratedExtension.access$500(extension, extensions.getRepeatedField(descriptor, index));
  }
  
  public final <Type> BuilderType setExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> extension, Type value)
  {
    verifyExtensionContainingType(extension);
    ensureExtensionsIsMutable();
    Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
    extensions.setField(descriptor, GeneratedMessage.GeneratedExtension.access$900(extension, value));
    onChanged();
    return this;
  }
  
  public final <Type> BuilderType setExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> extension, int index, Type value)
  {
    verifyExtensionContainingType(extension);
    ensureExtensionsIsMutable();
    Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
    extensions.setRepeatedField(descriptor, index, GeneratedMessage.GeneratedExtension.access$1000(extension, value));
    
    onChanged();
    return this;
  }
  
  public final <Type> BuilderType addExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> extension, Type value)
  {
    verifyExtensionContainingType(extension);
    ensureExtensionsIsMutable();
    Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
    extensions.addRepeatedField(descriptor, GeneratedMessage.GeneratedExtension.access$1000(extension, value));
    
    onChanged();
    return this;
  }
  
  public final <Type> BuilderType clearExtension(GeneratedMessage.GeneratedExtension<MessageType, ?> extension)
  {
    verifyExtensionContainingType(extension);
    ensureExtensionsIsMutable();
    extensions.clearField(extension.getDescriptor());
    onChanged();
    return this;
  }
  
  protected boolean extensionsAreInitialized()
  {
    return extensions.isInitialized();
  }
  
  private FieldSet<Descriptors.FieldDescriptor> buildExtensions()
  {
    extensions.makeImmutable();
    return extensions;
  }
  
  public boolean isInitialized()
  {
    return (super.isInitialized()) && (extensionsAreInitialized());
  }
  
  protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag)
    throws IOException
  {
    return AbstractMessage.Builder.mergeFieldFrom(input, unknownFields, extensionRegistry, getDescriptorForType(), this, null, tag);
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    Map<Descriptors.FieldDescriptor, Object> result = GeneratedMessage.Builder.access$1100(this);
    result.putAll(extensions.getAllFields());
    return Collections.unmodifiableMap(result);
  }
  
  public Object getField(Descriptors.FieldDescriptor field)
  {
    if (field.isExtension())
    {
      verifyContainingType(field);
      Object value = extensions.getField(field);
      if (value == null)
      {
        if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          return DynamicMessage.getDefaultInstance(field.getMessageType());
        }
        return field.getDefaultValue();
      }
      return value;
    }
    return super.getField(field);
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor field)
  {
    if (field.isExtension())
    {
      verifyContainingType(field);
      return extensions.getRepeatedFieldCount(field);
    }
    return super.getRepeatedFieldCount(field);
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor field, int index)
  {
    if (field.isExtension())
    {
      verifyContainingType(field);
      return extensions.getRepeatedField(field, index);
    }
    return super.getRepeatedField(field, index);
  }
  
  public boolean hasField(Descriptors.FieldDescriptor field)
  {
    if (field.isExtension())
    {
      verifyContainingType(field);
      return extensions.hasField(field);
    }
    return super.hasField(field);
  }
  
  public BuilderType setField(Descriptors.FieldDescriptor field, Object value)
  {
    if (field.isExtension())
    {
      verifyContainingType(field);
      ensureExtensionsIsMutable();
      extensions.setField(field, value);
      onChanged();
      return this;
    }
    return (ExtendableBuilder)super.setField(field, value);
  }
  
  public BuilderType clearField(Descriptors.FieldDescriptor field)
  {
    if (field.isExtension())
    {
      verifyContainingType(field);
      ensureExtensionsIsMutable();
      extensions.clearField(field);
      onChanged();
      return this;
    }
    return (ExtendableBuilder)super.clearField(field);
  }
  
  public BuilderType setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value)
  {
    if (field.isExtension())
    {
      verifyContainingType(field);
      ensureExtensionsIsMutable();
      extensions.setRepeatedField(field, index, value);
      onChanged();
      return this;
    }
    return (ExtendableBuilder)super.setRepeatedField(field, index, value);
  }
  
  public BuilderType addRepeatedField(Descriptors.FieldDescriptor field, Object value)
  {
    if (field.isExtension())
    {
      verifyContainingType(field);
      ensureExtensionsIsMutable();
      extensions.addRepeatedField(field, value);
      onChanged();
      return this;
    }
    return (ExtendableBuilder)super.addRepeatedField(field, value);
  }
  
  protected final void mergeExtensionFields(GeneratedMessage.ExtendableMessage other)
  {
    ensureExtensionsIsMutable();
    extensions.mergeFrom(GeneratedMessage.ExtendableMessage.access$600(other));
    onChanged();
  }
  
  private void verifyContainingType(Descriptors.FieldDescriptor field)
  {
    if (field.getContainingType() != getDescriptorForType()) {
      throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.ExtendableBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */