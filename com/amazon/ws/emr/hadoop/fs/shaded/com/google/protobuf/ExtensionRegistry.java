package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ExtensionRegistry
  extends ExtensionRegistryLite
{
  private final Map<String, ExtensionInfo> extensionsByName;
  private final Map<DescriptorIntPair, ExtensionInfo> extensionsByNumber;
  
  public static ExtensionRegistry newInstance()
  {
    return new ExtensionRegistry();
  }
  
  public static ExtensionRegistry getEmptyRegistry()
  {
    return EMPTY;
  }
  
  public ExtensionRegistry getUnmodifiable()
  {
    return new ExtensionRegistry(this);
  }
  
  public static final class ExtensionInfo
  {
    public final Descriptors.FieldDescriptor descriptor;
    public final Message defaultInstance;
    
    private ExtensionInfo(Descriptors.FieldDescriptor descriptor)
    {
      this.descriptor = descriptor;
      defaultInstance = null;
    }
    
    private ExtensionInfo(Descriptors.FieldDescriptor descriptor, Message defaultInstance)
    {
      this.descriptor = descriptor;
      this.defaultInstance = defaultInstance;
    }
  }
  
  public ExtensionInfo findExtensionByName(String fullName)
  {
    return (ExtensionInfo)extensionsByName.get(fullName);
  }
  
  public ExtensionInfo findExtensionByNumber(Descriptors.Descriptor containingType, int fieldNumber)
  {
    return (ExtensionInfo)extensionsByNumber.get(new DescriptorIntPair(containingType, fieldNumber));
  }
  
  public void add(GeneratedMessage.GeneratedExtension<?, ?> extension)
  {
    if (extension.getDescriptor().getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
    {
      if (extension.getMessageDefaultInstance() == null) {
        throw new IllegalStateException("Registered message-type extension had null default instance: " + extension.getDescriptor().getFullName());
      }
      add(new ExtensionInfo(extension.getDescriptor(), extension.getMessageDefaultInstance(), null));
    }
    else
    {
      add(new ExtensionInfo(extension.getDescriptor(), null, null));
    }
  }
  
  public void add(Descriptors.FieldDescriptor type)
  {
    if (type.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
      throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
    }
    add(new ExtensionInfo(type, null, null));
  }
  
  public void add(Descriptors.FieldDescriptor type, Message defaultInstance)
  {
    if (type.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
      throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
    }
    add(new ExtensionInfo(type, defaultInstance, null));
  }
  
  private ExtensionRegistry()
  {
    extensionsByName = new HashMap();
    extensionsByNumber = new HashMap();
  }
  
  private ExtensionRegistry(ExtensionRegistry other)
  {
    super(other);
    extensionsByName = Collections.unmodifiableMap(extensionsByName);
    extensionsByNumber = Collections.unmodifiableMap(extensionsByNumber);
  }
  
  private ExtensionRegistry(boolean empty)
  {
    super(ExtensionRegistryLite.getEmptyRegistry());
    extensionsByName = Collections.emptyMap();
    extensionsByNumber = Collections.emptyMap();
  }
  
  private static final ExtensionRegistry EMPTY = new ExtensionRegistry(true);
  
  private void add(ExtensionInfo extension)
  {
    if (!descriptor.isExtension()) {
      throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
    }
    extensionsByName.put(descriptor.getFullName(), extension);
    extensionsByNumber.put(new DescriptorIntPair(descriptor.getContainingType(), descriptor.getNumber()), extension);
    
    Descriptors.FieldDescriptor field = descriptor;
    if ((field.getContainingType().getOptions().getMessageSetWireFormat()) && (field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) && (field.isOptional()) && (field.getExtensionScope() == field.getMessageType())) {
      extensionsByName.put(field.getMessageType().getFullName(), extension);
    }
  }
  
  private static final class DescriptorIntPair
  {
    private final Descriptors.Descriptor descriptor;
    private final int number;
    
    DescriptorIntPair(Descriptors.Descriptor descriptor, int number)
    {
      this.descriptor = descriptor;
      this.number = number;
    }
    
    public int hashCode()
    {
      return descriptor.hashCode() * 65535 + number;
    }
    
    public boolean equals(Object obj)
    {
      if (!(obj instanceof DescriptorIntPair)) {
        return false;
      }
      DescriptorIntPair other = (DescriptorIntPair)obj;
      return (descriptor == descriptor) && (number == number);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ExtensionRegistry
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */