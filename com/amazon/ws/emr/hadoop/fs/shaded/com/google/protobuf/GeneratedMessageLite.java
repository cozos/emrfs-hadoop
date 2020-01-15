package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class GeneratedMessageLite
  extends AbstractMessageLite
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  protected GeneratedMessageLite() {}
  
  protected GeneratedMessageLite(Builder builder) {}
  
  public Parser<? extends MessageLite> getParserForType()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag)
    throws IOException
  {
    return input.skipField(tag);
  }
  
  protected void makeExtensionsImmutable() {}
  
  public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder>
    extends AbstractMessageLite.Builder<BuilderType>
  {
    public BuilderType clear()
    {
      return this;
    }
    
    public BuilderType clone()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    public abstract BuilderType mergeFrom(MessageType paramMessageType);
    
    public abstract MessageType getDefaultInstanceForType();
    
    protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag)
      throws IOException
    {
      return input.skipField(tag);
    }
  }
  
  public static abstract interface ExtendableMessageOrBuilder<MessageType extends GeneratedMessageLite.ExtendableMessage>
    extends MessageLiteOrBuilder
  {
    public abstract <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension);
    
    public abstract <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension);
    
    public abstract <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension);
    
    public abstract <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt);
  }
  
  public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>>
    extends GeneratedMessageLite
    implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType>
  {
    private final FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions;
    
    protected ExtendableMessage()
    {
      extensions = FieldSet.newFieldSet();
    }
    
    protected ExtendableMessage(GeneratedMessageLite.ExtendableBuilder<MessageType, ?> builder)
    {
      extensions = builder.buildExtensions();
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
      return extensions.hasField(descriptor);
    }
    
    public final <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension)
    {
      verifyExtensionContainingType(extension);
      return extensions.getRepeatedFieldCount(descriptor);
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension)
    {
      verifyExtensionContainingType(extension);
      Object value = extensions.getField(descriptor);
      if (value == null) {
        return (Type)defaultValue;
      }
      return (Type)value;
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, int index)
    {
      verifyExtensionContainingType(extension);
      return (Type)extensions.getRepeatedField(descriptor, index);
    }
    
    protected boolean extensionsAreInitialized()
    {
      return extensions.isInitialized();
    }
    
    protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag)
      throws IOException
    {
      return GeneratedMessageLite.parseUnknownField(extensions, getDefaultInstanceForType(), input, extensionRegistry, tag);
    }
    
    protected void makeExtensionsImmutable()
    {
      extensions.makeImmutable();
    }
    
    protected class ExtensionWriter
    {
      private final Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter = extensions.iterator();
      private Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next;
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
        while ((next != null) && (((GeneratedMessageLite.ExtensionDescriptor)next.getKey()).getNumber() < end))
        {
          GeneratedMessageLite.ExtensionDescriptor extension = (GeneratedMessageLite.ExtensionDescriptor)next.getKey();
          if ((messageSetWireFormat) && (extension.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!extension.isRepeated())) {
            output.writeMessageSetExtension(extension.getNumber(), (MessageLite)next.getValue());
          } else {
            FieldSet.writeField(extension, next.getValue(), output);
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
  }
  
  public static abstract class ExtendableBuilder<MessageType extends GeneratedMessageLite.ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>>
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
      return extensions.hasField(descriptor);
    }
    
    public final <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension)
    {
      verifyExtensionContainingType(extension);
      return extensions.getRepeatedFieldCount(descriptor);
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension)
    {
      verifyExtensionContainingType(extension);
      Object value = extensions.getField(descriptor);
      if (value == null) {
        return (Type)defaultValue;
      }
      return (Type)value;
    }
    
    public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, int index)
    {
      verifyExtensionContainingType(extension);
      return (Type)extensions.getRepeatedField(descriptor, index);
    }
    
    public BuilderType clone()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    public final <Type> BuilderType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension, Type value)
    {
      verifyExtensionContainingType(extension);
      ensureExtensionsIsMutable();
      extensions.setField(descriptor, value);
      return this;
    }
    
    public final <Type> BuilderType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, int index, Type value)
    {
      verifyExtensionContainingType(extension);
      ensureExtensionsIsMutable();
      extensions.setRepeatedField(descriptor, index, value);
      return this;
    }
    
    public final <Type> BuilderType addExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, Type value)
    {
      verifyExtensionContainingType(extension);
      ensureExtensionsIsMutable();
      extensions.addRepeatedField(descriptor, value);
      return this;
    }
    
    public final <Type> BuilderType clearExtension(GeneratedMessageLite.GeneratedExtension<MessageType, ?> extension)
    {
      verifyExtensionContainingType(extension);
      ensureExtensionsIsMutable();
      extensions.clearField(descriptor);
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
      return GeneratedMessageLite.parseUnknownField(extensions, getDefaultInstanceForType(), input, extensionRegistry, tag);
    }
    
    protected final void mergeExtensionFields(MessageType other)
    {
      ensureExtensionsIsMutable();
      extensions.mergeFrom(GeneratedMessageLite.ExtendableMessage.access$400(other));
    }
  }
  
  private static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> extensions, MessageType defaultInstance, CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag)
    throws IOException
  {
    int wireType = WireFormat.getTagWireType(tag);
    int fieldNumber = WireFormat.getTagFieldNumber(tag);
    
    GeneratedExtension<MessageType, ?> extension = extensionRegistry.findLiteExtensionByNumber(defaultInstance, fieldNumber);
    
    boolean unknown = false;
    boolean packed = false;
    if (extension == null) {
      unknown = true;
    } else if (wireType == FieldSet.getWireFormatForFieldType(descriptor.getLiteType(), false)) {
      packed = false;
    } else if ((access$100isRepeated) && (access$100type.isPackable()) && (wireType == FieldSet.getWireFormatForFieldType(descriptor.getLiteType(), true))) {
      packed = true;
    } else {
      unknown = true;
    }
    if (unknown) {
      return input.skipField(tag);
    }
    if (packed)
    {
      int length = input.readRawVarint32();
      int limit = input.pushLimit(length);
      if (descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
        while (input.getBytesUntilLimit() > 0)
        {
          int rawValue = input.readEnum();
          Object value = descriptor.getEnumType().findValueByNumber(rawValue);
          if (value == null) {
            return true;
          }
          extensions.addRepeatedField(descriptor, value);
        }
      }
      while (input.getBytesUntilLimit() > 0)
      {
        Object value = FieldSet.readPrimitiveField(input, descriptor.getLiteType());
        
        extensions.addRepeatedField(descriptor, value);
      }
      input.popLimit(limit);
    }
    else
    {
      Object value;
      switch (descriptor.getLiteJavaType())
      {
      case MESSAGE: 
        MessageLite.Builder subBuilder = null;
        if (!descriptor.isRepeated())
        {
          MessageLite existingValue = (MessageLite)extensions.getField(descriptor);
          if (existingValue != null) {
            subBuilder = existingValue.toBuilder();
          }
        }
        if (subBuilder == null) {
          subBuilder = messageDefaultInstance.newBuilderForType();
        }
        if (descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
          input.readGroup(extension.getNumber(), subBuilder, extensionRegistry);
        } else {
          input.readMessage(subBuilder, extensionRegistry);
        }
        value = subBuilder.build();
        break;
      case ENUM: 
        int rawValue = input.readEnum();
        value = descriptor.getEnumType().findValueByNumber(rawValue);
        if (value == null) {
          return true;
        }
        break;
      default: 
        value = FieldSet.readPrimitiveField(input, descriptor.getLiteType());
      }
      if (descriptor.isRepeated()) {
        extensions.addRepeatedField(descriptor, value);
      } else {
        extensions.setField(descriptor, value);
      }
    }
    return true;
  }
  
  public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingTypeDefaultInstance, Type defaultValue, MessageLite messageDefaultInstance, Internal.EnumLiteMap<?> enumTypeMap, int number, WireFormat.FieldType type)
  {
    return new GeneratedExtension(containingTypeDefaultInstance, defaultValue, messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, false, false, null), null);
  }
  
  public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingTypeDefaultInstance, MessageLite messageDefaultInstance, Internal.EnumLiteMap<?> enumTypeMap, int number, WireFormat.FieldType type, boolean isPacked)
  {
    Type emptyList = Collections.emptyList();
    return new GeneratedExtension(containingTypeDefaultInstance, emptyList, messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, true, isPacked, null), null);
  }
  
  private static final class ExtensionDescriptor
    implements FieldSet.FieldDescriptorLite<ExtensionDescriptor>
  {
    private final Internal.EnumLiteMap<?> enumTypeMap;
    private final int number;
    private final WireFormat.FieldType type;
    private final boolean isRepeated;
    private final boolean isPacked;
    
    private ExtensionDescriptor(Internal.EnumLiteMap<?> enumTypeMap, int number, WireFormat.FieldType type, boolean isRepeated, boolean isPacked)
    {
      this.enumTypeMap = enumTypeMap;
      this.number = number;
      this.type = type;
      this.isRepeated = isRepeated;
      this.isPacked = isPacked;
    }
    
    public int getNumber()
    {
      return number;
    }
    
    public WireFormat.FieldType getLiteType()
    {
      return type;
    }
    
    public WireFormat.JavaType getLiteJavaType()
    {
      return type.getJavaType();
    }
    
    public boolean isRepeated()
    {
      return isRepeated;
    }
    
    public boolean isPacked()
    {
      return isPacked;
    }
    
    public Internal.EnumLiteMap<?> getEnumType()
    {
      return enumTypeMap;
    }
    
    public MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from)
    {
      return ((GeneratedMessageLite.Builder)to).mergeFrom((GeneratedMessageLite)from);
    }
    
    public int compareTo(ExtensionDescriptor other)
    {
      return number - number;
    }
  }
  
  public static final class GeneratedExtension<ContainingType extends MessageLite, Type>
  {
    private final ContainingType containingTypeDefaultInstance;
    private final Type defaultValue;
    private final MessageLite messageDefaultInstance;
    private final GeneratedMessageLite.ExtensionDescriptor descriptor;
    
    private GeneratedExtension(ContainingType containingTypeDefaultInstance, Type defaultValue, MessageLite messageDefaultInstance, GeneratedMessageLite.ExtensionDescriptor descriptor)
    {
      if (containingTypeDefaultInstance == null) {
        throw new IllegalArgumentException("Null containingTypeDefaultInstance");
      }
      if ((descriptor.getLiteType() == WireFormat.FieldType.MESSAGE) && (messageDefaultInstance == null)) {
        throw new IllegalArgumentException("Null messageDefaultInstance");
      }
      this.containingTypeDefaultInstance = containingTypeDefaultInstance;
      this.defaultValue = defaultValue;
      this.messageDefaultInstance = messageDefaultInstance;
      this.descriptor = descriptor;
    }
    
    public ContainingType getContainingTypeDefaultInstance()
    {
      return containingTypeDefaultInstance;
    }
    
    public int getNumber()
    {
      return descriptor.getNumber();
    }
    
    public MessageLite getMessageDefaultInstance()
    {
      return messageDefaultInstance;
    }
  }
  
  static final class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private String messageClassName;
    private byte[] asBytes;
    
    SerializedForm(MessageLite regularForm)
    {
      messageClassName = regularForm.getClass().getName();
      asBytes = regularForm.toByteArray();
    }
    
    protected Object readResolve()
      throws ObjectStreamException
    {
      try
      {
        Class messageClass = Class.forName(messageClassName);
        Method newBuilder = messageClass.getMethod("newBuilder", new Class[0]);
        MessageLite.Builder builder = (MessageLite.Builder)newBuilder.invoke(null, new Object[0]);
        
        builder.mergeFrom(asBytes);
        return builder.buildPartial();
      }
      catch (ClassNotFoundException e)
      {
        throw new RuntimeException("Unable to find proto buffer class", e);
      }
      catch (NoSuchMethodException e)
      {
        throw new RuntimeException("Unable to find newBuilder method", e);
      }
      catch (IllegalAccessException e)
      {
        throw new RuntimeException("Unable to call newBuilder method", e);
      }
      catch (InvocationTargetException e)
      {
        throw new RuntimeException("Error calling newBuilder", e.getCause());
      }
      catch (InvalidProtocolBufferException e)
      {
        throw new RuntimeException("Unable to understand proto buffer", e);
      }
    }
  }
  
  protected Object writeReplace()
    throws ObjectStreamException
  {
    return new SerializedForm(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessageLite
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */