package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class GeneratedMessage$GeneratedExtension<ContainingType extends Message, Type>
{
  private GeneratedMessage.ExtensionDescriptorRetriever descriptorRetriever;
  private final Class singularType;
  private final Message messageDefaultInstance;
  private final Method enumValueOf;
  private final Method enumGetValueDescriptor;
  
  private GeneratedMessage$GeneratedExtension(GeneratedMessage.ExtensionDescriptorRetriever descriptorRetriever, Class singularType, Message messageDefaultInstance)
  {
    if ((Message.class.isAssignableFrom(singularType)) && (!singularType.isInstance(messageDefaultInstance))) {
      throw new IllegalArgumentException("Bad messageDefaultInstance for " + singularType.getName());
    }
    this.descriptorRetriever = descriptorRetriever;
    this.singularType = singularType;
    this.messageDefaultInstance = messageDefaultInstance;
    if (ProtocolMessageEnum.class.isAssignableFrom(singularType))
    {
      enumValueOf = GeneratedMessage.access$1300(singularType, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
      
      enumGetValueDescriptor = GeneratedMessage.access$1300(singularType, "getValueDescriptor", new Class[0]);
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
      return GeneratedMessage.access$1400(enumValueOf, null, new Object[] { (Descriptors.EnumValueDescriptor)value });
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
      return GeneratedMessage.access$1400(enumGetValueDescriptor, value, new Object[0]);
    }
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.GeneratedExtension
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */