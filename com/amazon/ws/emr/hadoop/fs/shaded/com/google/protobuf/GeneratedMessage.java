package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public abstract class GeneratedMessage
  extends AbstractMessage
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected static boolean alwaysUseFieldBuilders = false;
  
  protected GeneratedMessage() {}
  
  protected GeneratedMessage(Builder<?> builder) {}
  
  public Parser<? extends Message> getParserForType()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  static void enableAlwaysUseFieldBuildersForTesting()
  {
    alwaysUseFieldBuilders = true;
  }
  
  protected abstract FieldAccessorTable internalGetFieldAccessorTable();
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return internalGetFieldAccessorTabledescriptor;
  }
  
  private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable()
  {
    TreeMap<Descriptors.FieldDescriptor, Object> result = new TreeMap();
    
    Descriptors.Descriptor descriptor = internalGetFieldAccessorTabledescriptor;
    for (Descriptors.FieldDescriptor field : descriptor.getFields()) {
      if (field.isRepeated())
      {
        List<?> value = (List)getField(field);
        if (!value.isEmpty()) {
          result.put(field, value);
        }
      }
      else if (hasField(field))
      {
        result.put(field, getField(field));
      }
    }
    return result;
  }
  
  public boolean isInitialized()
  {
    for (Descriptors.FieldDescriptor field : getDescriptorForType().getFields())
    {
      if ((field.isRequired()) && 
        (!hasField(field))) {
        return false;
      }
      if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        if (field.isRepeated())
        {
          List<Message> messageList = (List)getField(field);
          for (Message element : messageList) {
            if (!element.isInitialized()) {
              return false;
            }
          }
        }
        else if ((hasField(field)) && (!((Message)getField(field)).isInitialized()))
        {
          return false;
        }
      }
    }
    return true;
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    return Collections.unmodifiableMap(getAllFieldsMutable());
  }
  
  public boolean hasField(Descriptors.FieldDescriptor field)
  {
    return internalGetFieldAccessorTable().getField(field).has(this);
  }
  
  public Object getField(Descriptors.FieldDescriptor field)
  {
    return internalGetFieldAccessorTable().getField(field).get(this);
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor field)
  {
    return internalGetFieldAccessorTable().getField(field).getRepeatedCount(this);
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor field, int index)
  {
    return internalGetFieldAccessorTable().getField(field).getRepeated(this, index);
  }
  
  public UnknownFieldSet getUnknownFields()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag)
    throws IOException
  {
    return unknownFields.mergeFieldFrom(tag, input);
  }
  
  protected void makeExtensionsImmutable() {}
  
  protected abstract Message.Builder newBuilderForType(BuilderParent paramBuilderParent);
  
  protected static abstract interface BuilderParent
  {
    public abstract void markDirty();
  }
  
  public static abstract class Builder<BuilderType extends Builder>
    extends AbstractMessage.Builder<BuilderType>
  {
    private GeneratedMessage.BuilderParent builderParent;
    private Builder<BuilderType>.BuilderParentImpl meAsParent;
    private boolean isClean;
    private UnknownFieldSet unknownFields = UnknownFieldSet.getDefaultInstance();
    
    protected Builder()
    {
      this(null);
    }
    
    protected Builder(GeneratedMessage.BuilderParent builderParent)
    {
      this.builderParent = builderParent;
    }
    
    void dispose()
    {
      builderParent = null;
    }
    
    protected void onBuilt()
    {
      if (builderParent != null) {
        markClean();
      }
    }
    
    protected void markClean()
    {
      isClean = true;
    }
    
    protected boolean isClean()
    {
      return isClean;
    }
    
    public BuilderType clone()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    public BuilderType clear()
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
      onChanged();
      return this;
    }
    
    protected abstract GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable();
    
    public Descriptors.Descriptor getDescriptorForType()
    {
      return internalGetFieldAccessorTabledescriptor;
    }
    
    public Map<Descriptors.FieldDescriptor, Object> getAllFields()
    {
      return Collections.unmodifiableMap(getAllFieldsMutable());
    }
    
    private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable()
    {
      TreeMap<Descriptors.FieldDescriptor, Object> result = new TreeMap();
      
      Descriptors.Descriptor descriptor = internalGetFieldAccessorTabledescriptor;
      for (Descriptors.FieldDescriptor field : descriptor.getFields()) {
        if (field.isRepeated())
        {
          List value = (List)getField(field);
          if (!value.isEmpty()) {
            result.put(field, value);
          }
        }
        else if (hasField(field))
        {
          result.put(field, getField(field));
        }
      }
      return result;
    }
    
    public Message.Builder newBuilderForField(Descriptors.FieldDescriptor field)
    {
      return internalGetFieldAccessorTable().getField(field).newBuilder();
    }
    
    public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor field)
    {
      return internalGetFieldAccessorTable().getField(field).getBuilder(this);
    }
    
    public boolean hasField(Descriptors.FieldDescriptor field)
    {
      return internalGetFieldAccessorTable().getField(field).has(this);
    }
    
    public Object getField(Descriptors.FieldDescriptor field)
    {
      Object object = internalGetFieldAccessorTable().getField(field).get(this);
      if (field.isRepeated()) {
        return Collections.unmodifiableList((List)object);
      }
      return object;
    }
    
    public BuilderType setField(Descriptors.FieldDescriptor field, Object value)
    {
      internalGetFieldAccessorTable().getField(field).set(this, value);
      return this;
    }
    
    public BuilderType clearField(Descriptors.FieldDescriptor field)
    {
      internalGetFieldAccessorTable().getField(field).clear(this);
      return this;
    }
    
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor field)
    {
      return internalGetFieldAccessorTable().getField(field).getRepeatedCount(this);
    }
    
    public Object getRepeatedField(Descriptors.FieldDescriptor field, int index)
    {
      return internalGetFieldAccessorTable().getField(field).getRepeated(this, index);
    }
    
    public BuilderType setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value)
    {
      internalGetFieldAccessorTable().getField(field).setRepeated(this, index, value);
      
      return this;
    }
    
    public BuilderType addRepeatedField(Descriptors.FieldDescriptor field, Object value)
    {
      internalGetFieldAccessorTable().getField(field).addRepeated(this, value);
      return this;
    }
    
    public final BuilderType setUnknownFields(UnknownFieldSet unknownFields)
    {
      this.unknownFields = unknownFields;
      onChanged();
      return this;
    }
    
    public final BuilderType mergeUnknownFields(UnknownFieldSet unknownFields)
    {
      this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFields).build();
      
      onChanged();
      return this;
    }
    
    public boolean isInitialized()
    {
      for (Descriptors.FieldDescriptor field : getDescriptorForType().getFields())
      {
        if ((field.isRequired()) && 
          (!hasField(field))) {
          return false;
        }
        if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          if (field.isRepeated())
          {
            List<Message> messageList = (List)getField(field);
            for (Message element : messageList) {
              if (!element.isInitialized()) {
                return false;
              }
            }
          }
          else if ((hasField(field)) && (!((Message)getField(field)).isInitialized()))
          {
            return false;
          }
        }
      }
      return true;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag)
      throws IOException
    {
      return unknownFields.mergeFieldFrom(tag, input);
    }
    
    private class BuilderParentImpl
      implements GeneratedMessage.BuilderParent
    {
      private BuilderParentImpl() {}
      
      public void markDirty()
      {
        onChanged();
      }
    }
    
    protected GeneratedMessage.BuilderParent getParentForChildren()
    {
      if (meAsParent == null) {
        meAsParent = new BuilderParentImpl(null);
      }
      return meAsParent;
    }
    
    protected final void onChanged()
    {
      if ((isClean) && (builderParent != null))
      {
        builderParent.markDirty();
        
        isClean = false;
      }
    }
  }
  
  public static abstract interface ExtendableMessageOrBuilder<MessageType extends GeneratedMessage.ExtendableMessage>
    extends MessageOrBuilder
  {
    public abstract <Type> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> paramGeneratedExtension);
    
    public abstract <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension);
    
    public abstract <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> paramGeneratedExtension);
    
    public abstract <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt);
  }
  
  public static abstract class ExtendableMessage<MessageType extends ExtendableMessage>
    extends GeneratedMessage
    implements GeneratedMessage.ExtendableMessageOrBuilder<MessageType>
  {
    private final FieldSet<Descriptors.FieldDescriptor> extensions;
    
    protected ExtendableMessage()
    {
      extensions = FieldSet.newFieldSet();
    }
    
    protected ExtendableMessage(GeneratedMessage.ExtendableBuilder<MessageType, ?> builder)
    {
      super();
      extensions = builder.buildExtensions();
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
        return (Type)extension.fromReflectionType(descriptor.getDefaultValue());
      }
      return (Type)extension.fromReflectionType(value);
    }
    
    public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> extension, int index)
    {
      verifyExtensionContainingType(extension);
      Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
      return (Type)extension.singularFromReflectionType(extensions.getRepeatedField(descriptor, index));
    }
    
    protected boolean extensionsAreInitialized()
    {
      return extensions.isInitialized();
    }
    
    public boolean isInitialized()
    {
      return (super.isInitialized()) && (extensionsAreInitialized());
    }
    
    protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag)
      throws IOException
    {
      return AbstractMessage.Builder.mergeFieldFrom(input, unknownFields, extensionRegistry, getDescriptorForType(), null, extensions, tag);
    }
    
    protected void makeExtensionsImmutable()
    {
      extensions.makeImmutable();
    }
    
    protected class ExtensionWriter
    {
      private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter = extensions.iterator();
      private Map.Entry<Descriptors.FieldDescriptor, Object> next;
      private final boolean messageSetWireFormat;
      
      private ExtensionWriter(boolean messageSetWireFormat)
      {
        if (iter.hasNext()) {
          next = ((Map.Entry)iter.next());
        }
        this.messageSetWireFormat = messageSetWireFormat;
      }
      
      public void writeUntil(int end, CodedOutputStream output)
        throws IOException
      {
        while ((next != null) && (((Descriptors.FieldDescriptor)next.getKey()).getNumber() < end))
        {
          Descriptors.FieldDescriptor descriptor = (Descriptors.FieldDescriptor)next.getKey();
          if ((messageSetWireFormat) && (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!descriptor.isRepeated()))
          {
            if ((next instanceof LazyField.LazyEntry)) {
              output.writeRawMessageSetExtension(descriptor.getNumber(), ((LazyField.LazyEntry)next).getField().toByteString());
            } else {
              output.writeMessageSetExtension(descriptor.getNumber(), (Message)next.getValue());
            }
          }
          else {
            FieldSet.writeField(descriptor, next.getValue(), output);
          }
          if (iter.hasNext()) {
            next = ((Map.Entry)iter.next());
          } else {
            next = null;
          }
        }
      }
    }
    
    protected ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter()
    {
      return new ExtensionWriter(false, null);
    }
    
    protected ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter()
    {
      return new ExtensionWriter(true, null);
    }
    
    protected int extensionsSerializedSize()
    {
      return extensions.getSerializedSize();
    }
    
    protected int extensionsSerializedSizeAsMessageSet()
    {
      return extensions.getMessageSetSerializedSize();
    }
    
    protected Map<Descriptors.FieldDescriptor, Object> getExtensionFields()
    {
      return extensions.getAllFields();
    }
    
    public Map<Descriptors.FieldDescriptor, Object> getAllFields()
    {
      Map<Descriptors.FieldDescriptor, Object> result = super.getAllFieldsMutable();
      result.putAll(getExtensionFields());
      return Collections.unmodifiableMap(result);
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
    
    private void verifyContainingType(Descriptors.FieldDescriptor field)
    {
      if (field.getContainingType() != getDescriptorForType()) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
  }
  
  public static abstract class ExtendableBuilder<MessageType extends GeneratedMessage.ExtendableMessage, BuilderType extends ExtendableBuilder>
    extends GeneratedMessage.Builder<BuilderType>
    implements GeneratedMessage.ExtendableMessageOrBuilder<MessageType>
  {
    private FieldSet<Descriptors.FieldDescriptor> extensions = FieldSet.emptySet();
    
    protected ExtendableBuilder() {}
    
    protected ExtendableBuilder(GeneratedMessage.BuilderParent parent)
    {
      super();
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
        return (Type)extension.fromReflectionType(descriptor.getDefaultValue());
      }
      return (Type)extension.fromReflectionType(value);
    }
    
    public final <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> extension, int index)
    {
      verifyExtensionContainingType(extension);
      Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
      return (Type)extension.singularFromReflectionType(extensions.getRepeatedField(descriptor, index));
    }
    
    public final <Type> BuilderType setExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> extension, Type value)
    {
      verifyExtensionContainingType(extension);
      ensureExtensionsIsMutable();
      Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
      extensions.setField(descriptor, extension.toReflectionType(value));
      onChanged();
      return this;
    }
    
    public final <Type> BuilderType setExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> extension, int index, Type value)
    {
      verifyExtensionContainingType(extension);
      ensureExtensionsIsMutable();
      Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
      extensions.setRepeatedField(descriptor, index, extension.singularToReflectionType(value));
      
      onChanged();
      return this;
    }
    
    public final <Type> BuilderType addExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> extension, Type value)
    {
      verifyExtensionContainingType(extension);
      ensureExtensionsIsMutable();
      Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
      extensions.addRepeatedField(descriptor, extension.singularToReflectionType(value));
      
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
  
  public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(Message scope, final int descriptorIndex, Class singularType, Message defaultInstance)
  {
    new GeneratedExtension(new ExtensionDescriptorRetriever()
    {
      public Descriptors.FieldDescriptor getDescriptor()
      {
        return (Descriptors.FieldDescriptor)val$scope.getDescriptorForType().getExtensions().get(descriptorIndex);
      }
    }, singularType, defaultInstance, null);
  }
  
  public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(Class singularType, Message defaultInstance)
  {
    return new GeneratedExtension(null, singularType, defaultInstance, null);
  }
  
  private static abstract interface ExtensionDescriptorRetriever
  {
    public abstract Descriptors.FieldDescriptor getDescriptor();
  }
  
  public static final class GeneratedExtension<ContainingType extends Message, Type>
  {
    private GeneratedMessage.ExtensionDescriptorRetriever descriptorRetriever;
    private final Class singularType;
    private final Message messageDefaultInstance;
    private final Method enumValueOf;
    private final Method enumGetValueDescriptor;
    
    private GeneratedExtension(GeneratedMessage.ExtensionDescriptorRetriever descriptorRetriever, Class singularType, Message messageDefaultInstance)
    {
      if ((Message.class.isAssignableFrom(singularType)) && (!singularType.isInstance(messageDefaultInstance))) {
        throw new IllegalArgumentException("Bad messageDefaultInstance for " + singularType.getName());
      }
      this.descriptorRetriever = descriptorRetriever;
      this.singularType = singularType;
      this.messageDefaultInstance = messageDefaultInstance;
      if (ProtocolMessageEnum.class.isAssignableFrom(singularType))
      {
        enumValueOf = GeneratedMessage.getMethodOrDie(singularType, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
        
        enumGetValueDescriptor = GeneratedMessage.getMethodOrDie(singularType, "getValueDescriptor", new Class[0]);
      }
      else
      {
        enumValueOf = null;
        enumGetValueDescriptor = null;
      }
    }
    
    public void internalInit(final Descriptors.FieldDescriptor descriptor)
    {
      if (descriptorRetriever != null) {
        throw new IllegalStateException("Already initialized.");
      }
      descriptorRetriever = new GeneratedMessage.ExtensionDescriptorRetriever()
      {
        public Descriptors.FieldDescriptor getDescriptor()
        {
          return descriptor;
        }
      };
    }
    
    public Descriptors.FieldDescriptor getDescriptor()
    {
      if (descriptorRetriever == null) {
        throw new IllegalStateException("getDescriptor() called before internalInit()");
      }
      return descriptorRetriever.getDescriptor();
    }
    
    public Message getMessageDefaultInstance()
    {
      return messageDefaultInstance;
    }
    
    private Object fromReflectionType(Object value)
    {
      Descriptors.FieldDescriptor descriptor = getDescriptor();
      if (descriptor.isRepeated())
      {
        if ((descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) || (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM))
        {
          List result = new ArrayList();
          for (Object element : (List)value) {
            result.add(singularFromReflectionType(element));
          }
          return result;
        }
        return value;
      }
      return singularFromReflectionType(value);
    }
    
    private Object singularFromReflectionType(Object value)
    {
      Descriptors.FieldDescriptor descriptor = getDescriptor();
      switch (GeneratedMessage.2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[descriptor.getJavaType().ordinal()])
      {
      case 1: 
        if (singularType.isInstance(value)) {
          return value;
        }
        return messageDefaultInstance.newBuilderForType().mergeFrom((Message)value).build();
      case 2: 
        return GeneratedMessage.invokeOrDie(enumValueOf, null, new Object[] { (Descriptors.EnumValueDescriptor)value });
      }
      return value;
    }
    
    private Object toReflectionType(Object value)
    {
      Descriptors.FieldDescriptor descriptor = getDescriptor();
      if (descriptor.isRepeated())
      {
        if (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM)
        {
          List result = new ArrayList();
          for (Object element : (List)value) {
            result.add(singularToReflectionType(element));
          }
          return result;
        }
        return value;
      }
      return singularToReflectionType(value);
    }
    
    private Object singularToReflectionType(Object value)
    {
      Descriptors.FieldDescriptor descriptor = getDescriptor();
      switch (GeneratedMessage.2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[descriptor.getJavaType().ordinal()])
      {
      case 2: 
        return GeneratedMessage.invokeOrDie(enumGetValueDescriptor, value, new Object[0]);
      }
      return value;
    }
  }
  
  private static Method getMethodOrDie(Class clazz, String name, Class... params)
  {
    try
    {
      return clazz.getMethod(name, params);
    }
    catch (NoSuchMethodException e)
    {
      throw new RuntimeException("Generated message class \"" + clazz.getName() + "\" missing method \"" + name + "\".", e);
    }
  }
  
  private static Object invokeOrDie(Method method, Object object, Object... params)
  {
    try
    {
      return method.invoke(object, params);
    }
    catch (IllegalAccessException e)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    }
    catch (InvocationTargetException e)
    {
      Throwable cause = e.getCause();
      if ((cause instanceof RuntimeException)) {
        throw ((RuntimeException)cause);
      }
      if ((cause instanceof Error)) {
        throw ((Error)cause);
      }
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
    }
  }
  
  public static final class FieldAccessorTable
  {
    private final Descriptors.Descriptor descriptor;
    private final FieldAccessor[] fields;
    private String[] camelCaseNames;
    private volatile boolean initialized;
    
    public FieldAccessorTable(Descriptors.Descriptor descriptor, String[] camelCaseNames, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
    {
      this(descriptor, camelCaseNames);
      ensureFieldAccessorsInitialized(messageClass, builderClass);
    }
    
    public FieldAccessorTable(Descriptors.Descriptor descriptor, String[] camelCaseNames)
    {
      this.descriptor = descriptor;
      this.camelCaseNames = camelCaseNames;
      fields = new FieldAccessor[descriptor.getFields().size()];
      initialized = false;
    }
    
    public FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
    {
      if (initialized) {
        return this;
      }
      synchronized (this)
      {
        if (initialized) {
          return this;
        }
        for (int i = 0; i < fields.length; i++)
        {
          Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)descriptor.getFields().get(i);
          if (field.isRepeated())
          {
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
              fields[i] = new RepeatedMessageFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
            } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
              fields[i] = new RepeatedEnumFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
            } else {
              fields[i] = new RepeatedFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
            }
          }
          else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            fields[i] = new SingularMessageFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
          } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
            fields[i] = new SingularEnumFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
          } else {
            fields[i] = new SingularFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
          }
        }
        initialized = true;
        camelCaseNames = null;
        return this;
      }
    }
    
    private FieldAccessor getField(Descriptors.FieldDescriptor field)
    {
      if (field.getContainingType() != descriptor) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
      if (field.isExtension()) {
        throw new IllegalArgumentException("This type does not have extensions.");
      }
      return fields[field.getIndex()];
    }
    
    private static abstract interface FieldAccessor
    {
      public abstract Object get(GeneratedMessage paramGeneratedMessage);
      
      public abstract Object get(GeneratedMessage.Builder paramBuilder);
      
      public abstract void set(GeneratedMessage.Builder paramBuilder, Object paramObject);
      
      public abstract Object getRepeated(GeneratedMessage paramGeneratedMessage, int paramInt);
      
      public abstract Object getRepeated(GeneratedMessage.Builder paramBuilder, int paramInt);
      
      public abstract void setRepeated(GeneratedMessage.Builder paramBuilder, int paramInt, Object paramObject);
      
      public abstract void addRepeated(GeneratedMessage.Builder paramBuilder, Object paramObject);
      
      public abstract boolean has(GeneratedMessage paramGeneratedMessage);
      
      public abstract boolean has(GeneratedMessage.Builder paramBuilder);
      
      public abstract int getRepeatedCount(GeneratedMessage paramGeneratedMessage);
      
      public abstract int getRepeatedCount(GeneratedMessage.Builder paramBuilder);
      
      public abstract void clear(GeneratedMessage.Builder paramBuilder);
      
      public abstract Message.Builder newBuilder();
      
      public abstract Message.Builder getBuilder(GeneratedMessage.Builder paramBuilder);
    }
    
    private static class SingularFieldAccessor
      implements GeneratedMessage.FieldAccessorTable.FieldAccessor
    {
      protected final Class<?> type;
      protected final Method getMethod;
      protected final Method getMethodBuilder;
      protected final Method setMethod;
      protected final Method hasMethod;
      protected final Method hasMethodBuilder;
      protected final Method clearMethod;
      
      SingularFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
      {
        getMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName, new Class[0]);
        getMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName, new Class[0]);
        type = getMethod.getReturnType();
        setMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName, new Class[] { type });
        hasMethod = GeneratedMessage.getMethodOrDie(messageClass, "has" + camelCaseName, new Class[0]);
        
        hasMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "has" + camelCaseName, new Class[0]);
        
        clearMethod = GeneratedMessage.getMethodOrDie(builderClass, "clear" + camelCaseName, new Class[0]);
      }
      
      public Object get(GeneratedMessage message)
      {
        return GeneratedMessage.invokeOrDie(getMethod, message, new Object[0]);
      }
      
      public Object get(GeneratedMessage.Builder builder)
      {
        return GeneratedMessage.invokeOrDie(getMethodBuilder, builder, new Object[0]);
      }
      
      public void set(GeneratedMessage.Builder builder, Object value)
      {
        GeneratedMessage.invokeOrDie(setMethod, builder, new Object[] { value });
      }
      
      public Object getRepeated(GeneratedMessage message, int index)
      {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
      }
      
      public Object getRepeated(GeneratedMessage.Builder builder, int index)
      {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
      }
      
      public void setRepeated(GeneratedMessage.Builder builder, int index, Object value)
      {
        throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
      }
      
      public void addRepeated(GeneratedMessage.Builder builder, Object value)
      {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
      }
      
      public boolean has(GeneratedMessage message)
      {
        return ((Boolean)GeneratedMessage.invokeOrDie(hasMethod, message, new Object[0])).booleanValue();
      }
      
      public boolean has(GeneratedMessage.Builder builder)
      {
        return ((Boolean)GeneratedMessage.invokeOrDie(hasMethodBuilder, builder, new Object[0])).booleanValue();
      }
      
      public int getRepeatedCount(GeneratedMessage message)
      {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
      }
      
      public int getRepeatedCount(GeneratedMessage.Builder builder)
      {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
      }
      
      public void clear(GeneratedMessage.Builder builder)
      {
        GeneratedMessage.invokeOrDie(clearMethod, builder, new Object[0]);
      }
      
      public Message.Builder newBuilder()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public Message.Builder getBuilder(GeneratedMessage.Builder builder)
      {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
      }
    }
    
    private static class RepeatedFieldAccessor
      implements GeneratedMessage.FieldAccessorTable.FieldAccessor
    {
      protected final Class type;
      protected final Method getMethod;
      protected final Method getMethodBuilder;
      protected final Method getRepeatedMethod;
      protected final Method getRepeatedMethodBuilder;
      protected final Method setRepeatedMethod;
      protected final Method addRepeatedMethod;
      protected final Method getCountMethod;
      protected final Method getCountMethodBuilder;
      protected final Method clearMethod;
      
      RepeatedFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
      {
        getMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "List", new Class[0]);
        
        getMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "List", new Class[0]);
        
        getRepeatedMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName, new Class[] { Integer.TYPE });
        
        getRepeatedMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName, new Class[] { Integer.TYPE });
        
        type = getRepeatedMethod.getReturnType();
        setRepeatedMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName, new Class[] { Integer.TYPE, type });
        
        addRepeatedMethod = GeneratedMessage.getMethodOrDie(builderClass, "add" + camelCaseName, new Class[] { type });
        
        getCountMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "Count", new Class[0]);
        
        getCountMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "Count", new Class[0]);
        
        clearMethod = GeneratedMessage.getMethodOrDie(builderClass, "clear" + camelCaseName, new Class[0]);
      }
      
      public Object get(GeneratedMessage message)
      {
        return GeneratedMessage.invokeOrDie(getMethod, message, new Object[0]);
      }
      
      public Object get(GeneratedMessage.Builder builder)
      {
        return GeneratedMessage.invokeOrDie(getMethodBuilder, builder, new Object[0]);
      }
      
      public void set(GeneratedMessage.Builder builder, Object value)
      {
        clear(builder);
        for (Object element : (List)value) {
          addRepeated(builder, element);
        }
      }
      
      public Object getRepeated(GeneratedMessage message, int index)
      {
        return GeneratedMessage.invokeOrDie(getRepeatedMethod, message, new Object[] { Integer.valueOf(index) });
      }
      
      public Object getRepeated(GeneratedMessage.Builder builder, int index)
      {
        return GeneratedMessage.invokeOrDie(getRepeatedMethodBuilder, builder, new Object[] { Integer.valueOf(index) });
      }
      
      public void setRepeated(GeneratedMessage.Builder builder, int index, Object value)
      {
        GeneratedMessage.invokeOrDie(setRepeatedMethod, builder, new Object[] { Integer.valueOf(index), value });
      }
      
      public void addRepeated(GeneratedMessage.Builder builder, Object value)
      {
        GeneratedMessage.invokeOrDie(addRepeatedMethod, builder, new Object[] { value });
      }
      
      public boolean has(GeneratedMessage message)
      {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }
      
      public boolean has(GeneratedMessage.Builder builder)
      {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }
      
      public int getRepeatedCount(GeneratedMessage message)
      {
        return ((Integer)GeneratedMessage.invokeOrDie(getCountMethod, message, new Object[0])).intValue();
      }
      
      public int getRepeatedCount(GeneratedMessage.Builder builder)
      {
        return ((Integer)GeneratedMessage.invokeOrDie(getCountMethodBuilder, builder, new Object[0])).intValue();
      }
      
      public void clear(GeneratedMessage.Builder builder)
      {
        GeneratedMessage.invokeOrDie(clearMethod, builder, new Object[0]);
      }
      
      public Message.Builder newBuilder()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public Message.Builder getBuilder(GeneratedMessage.Builder builder)
      {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
      }
    }
    
    private static final class SingularEnumFieldAccessor
      extends GeneratedMessage.FieldAccessorTable.SingularFieldAccessor
    {
      private Method valueOfMethod;
      private Method getValueDescriptorMethod;
      
      SingularEnumFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
      {
        super(camelCaseName, messageClass, builderClass);
        
        valueOfMethod = GeneratedMessage.getMethodOrDie(type, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
        
        getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(type, "getValueDescriptor", new Class[0]);
      }
      
      public Object get(GeneratedMessage message)
      {
        return GeneratedMessage.invokeOrDie(getValueDescriptorMethod, super.get(message), new Object[0]);
      }
      
      public Object get(GeneratedMessage.Builder builder)
      {
        return GeneratedMessage.invokeOrDie(getValueDescriptorMethod, super.get(builder), new Object[0]);
      }
      
      public void set(GeneratedMessage.Builder builder, Object value)
      {
        super.set(builder, GeneratedMessage.invokeOrDie(valueOfMethod, null, new Object[] { value }));
      }
    }
    
    private static final class RepeatedEnumFieldAccessor
      extends GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor
    {
      private final Method valueOfMethod;
      private final Method getValueDescriptorMethod;
      
      RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
      {
        super(camelCaseName, messageClass, builderClass);
        
        valueOfMethod = GeneratedMessage.getMethodOrDie(type, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
        
        getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(type, "getValueDescriptor", new Class[0]);
      }
      
      public Object get(GeneratedMessage message)
      {
        List newList = new ArrayList();
        for (Object element : (List)super.get(message)) {
          newList.add(GeneratedMessage.invokeOrDie(getValueDescriptorMethod, element, new Object[0]));
        }
        return Collections.unmodifiableList(newList);
      }
      
      public Object get(GeneratedMessage.Builder builder)
      {
        List newList = new ArrayList();
        for (Object element : (List)super.get(builder)) {
          newList.add(GeneratedMessage.invokeOrDie(getValueDescriptorMethod, element, new Object[0]));
        }
        return Collections.unmodifiableList(newList);
      }
      
      public Object getRepeated(GeneratedMessage message, int index)
      {
        return GeneratedMessage.invokeOrDie(getValueDescriptorMethod, super.getRepeated(message, index), new Object[0]);
      }
      
      public Object getRepeated(GeneratedMessage.Builder builder, int index)
      {
        return GeneratedMessage.invokeOrDie(getValueDescriptorMethod, super.getRepeated(builder, index), new Object[0]);
      }
      
      public void setRepeated(GeneratedMessage.Builder builder, int index, Object value)
      {
        super.setRepeated(builder, index, GeneratedMessage.invokeOrDie(valueOfMethod, null, new Object[] { value }));
      }
      
      public void addRepeated(GeneratedMessage.Builder builder, Object value)
      {
        super.addRepeated(builder, GeneratedMessage.invokeOrDie(valueOfMethod, null, new Object[] { value }));
      }
    }
    
    private static final class SingularMessageFieldAccessor
      extends GeneratedMessage.FieldAccessorTable.SingularFieldAccessor
    {
      private final Method newBuilderMethod;
      private final Method getBuilderMethodBuilder;
      
      SingularMessageFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
      {
        super(camelCaseName, messageClass, builderClass);
        
        newBuilderMethod = GeneratedMessage.getMethodOrDie(type, "newBuilder", new Class[0]);
        getBuilderMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "Builder", new Class[0]);
      }
      
      private Object coerceType(Object value)
      {
        if (type.isInstance(value)) {
          return value;
        }
        return ((Message.Builder)GeneratedMessage.invokeOrDie(newBuilderMethod, null, new Object[0])).mergeFrom((Message)value).buildPartial();
      }
      
      public void set(GeneratedMessage.Builder builder, Object value)
      {
        super.set(builder, coerceType(value));
      }
      
      public Message.Builder newBuilder()
      {
        return (Message.Builder)GeneratedMessage.invokeOrDie(newBuilderMethod, null, new Object[0]);
      }
      
      public Message.Builder getBuilder(GeneratedMessage.Builder builder)
      {
        return (Message.Builder)GeneratedMessage.invokeOrDie(getBuilderMethodBuilder, builder, new Object[0]);
      }
    }
    
    private static final class RepeatedMessageFieldAccessor
      extends GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor
    {
      private final Method newBuilderMethod;
      
      RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
      {
        super(camelCaseName, messageClass, builderClass);
        
        newBuilderMethod = GeneratedMessage.getMethodOrDie(type, "newBuilder", new Class[0]);
      }
      
      private Object coerceType(Object value)
      {
        if (type.isInstance(value)) {
          return value;
        }
        return ((Message.Builder)GeneratedMessage.invokeOrDie(newBuilderMethod, null, new Object[0])).mergeFrom((Message)value).build();
      }
      
      public void setRepeated(GeneratedMessage.Builder builder, int index, Object value)
      {
        super.setRepeated(builder, index, coerceType(value));
      }
      
      public void addRepeated(GeneratedMessage.Builder builder, Object value)
      {
        super.addRepeated(builder, coerceType(value));
      }
      
      public Message.Builder newBuilder()
      {
        return (Message.Builder)GeneratedMessage.invokeOrDie(newBuilderMethod, null, new Object[0]);
      }
    }
  }
  
  protected Object writeReplace()
    throws ObjectStreamException
  {
    return new GeneratedMessageLite.SerializedForm(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */