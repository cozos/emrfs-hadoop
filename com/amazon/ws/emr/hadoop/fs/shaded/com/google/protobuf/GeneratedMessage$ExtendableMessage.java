package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class GeneratedMessage$ExtendableMessage<MessageType extends ExtendableMessage>
  extends GeneratedMessage
  implements GeneratedMessage.ExtendableMessageOrBuilder<MessageType>
{
  private final FieldSet<Descriptors.FieldDescriptor> extensions;
  
  protected GeneratedMessage$ExtendableMessage()
  {
    extensions = FieldSet.newFieldSet();
  }
  
  protected GeneratedMessage$ExtendableMessage(GeneratedMessage.ExtendableBuilder<MessageType, ?> builder)
  {
    super(builder);
    extensions = GeneratedMessage.ExtendableBuilder.access$300(builder);
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
    Map<Descriptors.FieldDescriptor, Object> result = GeneratedMessage.access$800(this);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.ExtendableMessage
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */