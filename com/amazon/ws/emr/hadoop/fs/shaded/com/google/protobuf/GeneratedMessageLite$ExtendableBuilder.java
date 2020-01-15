package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.List;

public abstract class GeneratedMessageLite$ExtendableBuilder<MessageType extends GeneratedMessageLite.ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>>
  extends GeneratedMessageLite.Builder<MessageType, BuilderType>
  implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType>
{
  private FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions = FieldSet.emptySet();
  private boolean extensionsIsMutable;
  
  public BuilderType clear()
  {
    extensions.clear();
    extensionsIsMutable = false;
    return (ExtendableBuilder)super.clear();
  }
  
  private void ensureExtensionsIsMutable()
  {
    if (!extensionsIsMutable)
    {
      extensions = extensions.clone();
      extensionsIsMutable = true;
    }
  }
  
  private FieldSet<GeneratedMessageLite.ExtensionDescriptor> buildExtensions()
  {
    extensions.makeImmutable();
    extensionsIsMutable = false;
    return extensions;
  }
  
  private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType, ?> extension)
  {
    if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
      throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }
  }
  
  public final <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension)
  {
    verifyExtensionContainingType(extension);
    return extensions.hasField(GeneratedMessageLite.GeneratedExtension.access$100(extension));
  }
  
  public final <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension)
  {
    verifyExtensionContainingType(extension);
    return extensions.getRepeatedFieldCount(GeneratedMessageLite.GeneratedExtension.access$100(extension));
  }
  
  public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension)
  {
    verifyExtensionContainingType(extension);
    Object value = extensions.getField(GeneratedMessageLite.GeneratedExtension.access$100(extension));
    if (value == null) {
      return (Type)GeneratedMessageLite.GeneratedExtension.access$200(extension);
    }
    return (Type)value;
  }
  
  public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, int index)
  {
    verifyExtensionContainingType(extension);
    return (Type)extensions.getRepeatedField(GeneratedMessageLite.GeneratedExtension.access$100(extension), index);
  }
  
  public BuilderType clone()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public final <Type> BuilderType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension, Type value)
  {
    verifyExtensionContainingType(extension);
    ensureExtensionsIsMutable();
    extensions.setField(GeneratedMessageLite.GeneratedExtension.access$100(extension), value);
    return this;
  }
  
  public final <Type> BuilderType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, int index, Type value)
  {
    verifyExtensionContainingType(extension);
    ensureExtensionsIsMutable();
    extensions.setRepeatedField(GeneratedMessageLite.GeneratedExtension.access$100(extension), index, value);
    return this;
  }
  
  public final <Type> BuilderType addExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, Type value)
  {
    verifyExtensionContainingType(extension);
    ensureExtensionsIsMutable();
    extensions.addRepeatedField(GeneratedMessageLite.GeneratedExtension.access$100(extension), value);
    return this;
  }
  
  public final <Type> BuilderType clearExtension(GeneratedMessageLite.GeneratedExtension<MessageType, ?> extension)
  {
    verifyExtensionContainingType(extension);
    ensureExtensionsIsMutable();
    extensions.clearField(GeneratedMessageLite.GeneratedExtension.access$100(extension));
    return this;
  }
  
  protected boolean extensionsAreInitialized()
  {
    return extensions.isInitialized();
  }
  
  protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag)
    throws IOException
  {
    ensureExtensionsIsMutable();
    return GeneratedMessageLite.access$300(extensions, getDefaultInstanceForType(), input, extensionRegistry, tag);
  }
  
  protected final void mergeExtensionFields(MessageType other)
  {
    ensureExtensionsIsMutable();
    extensions.mergeFrom(GeneratedMessageLite.ExtendableMessage.access$400(other));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessageLite.ExtendableBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */