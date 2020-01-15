package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GeneratedMessage$FieldAccessorTable
{
  private final Descriptors.Descriptor descriptor;
  private final FieldAccessor[] fields;
  private String[] camelCaseNames;
  private volatile boolean initialized;
  
  public GeneratedMessage$FieldAccessorTable(Descriptors.Descriptor descriptor, String[] camelCaseNames, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
  {
    this(descriptor, camelCaseNames);
    ensureFieldAccessorsInitialized(messageClass, builderClass);
  }
  
  public GeneratedMessage$FieldAccessorTable(Descriptors.Descriptor descriptor, String[] camelCaseNames)
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
      getMethod = GeneratedMessage.access$1300(messageClass, "get" + camelCaseName, new Class[0]);
      getMethodBuilder = GeneratedMessage.access$1300(builderClass, "get" + camelCaseName, new Class[0]);
      type = getMethod.getReturnType();
      setMethod = GeneratedMessage.access$1300(builderClass, "set" + camelCaseName, new Class[] { type });
      hasMethod = GeneratedMessage.access$1300(messageClass, "has" + camelCaseName, new Class[0]);
      
      hasMethodBuilder = GeneratedMessage.access$1300(builderClass, "has" + camelCaseName, new Class[0]);
      
      clearMethod = GeneratedMessage.access$1300(builderClass, "clear" + camelCaseName, new Class[0]);
    }
    
    public Object get(GeneratedMessage message)
    {
      return GeneratedMessage.access$1400(getMethod, message, new Object[0]);
    }
    
    public Object get(GeneratedMessage.Builder builder)
    {
      return GeneratedMessage.access$1400(getMethodBuilder, builder, new Object[0]);
    }
    
    public void set(GeneratedMessage.Builder builder, Object value)
    {
      GeneratedMessage.access$1400(setMethod, builder, new Object[] { value });
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
      return ((Boolean)GeneratedMessage.access$1400(hasMethod, message, new Object[0])).booleanValue();
    }
    
    public boolean has(GeneratedMessage.Builder builder)
    {
      return ((Boolean)GeneratedMessage.access$1400(hasMethodBuilder, builder, new Object[0])).booleanValue();
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
      GeneratedMessage.access$1400(clearMethod, builder, new Object[0]);
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
      getMethod = GeneratedMessage.access$1300(messageClass, "get" + camelCaseName + "List", new Class[0]);
      
      getMethodBuilder = GeneratedMessage.access$1300(builderClass, "get" + camelCaseName + "List", new Class[0]);
      
      getRepeatedMethod = GeneratedMessage.access$1300(messageClass, "get" + camelCaseName, new Class[] { Integer.TYPE });
      
      getRepeatedMethodBuilder = GeneratedMessage.access$1300(builderClass, "get" + camelCaseName, new Class[] { Integer.TYPE });
      
      type = getRepeatedMethod.getReturnType();
      setRepeatedMethod = GeneratedMessage.access$1300(builderClass, "set" + camelCaseName, new Class[] { Integer.TYPE, type });
      
      addRepeatedMethod = GeneratedMessage.access$1300(builderClass, "add" + camelCaseName, new Class[] { type });
      
      getCountMethod = GeneratedMessage.access$1300(messageClass, "get" + camelCaseName + "Count", new Class[0]);
      
      getCountMethodBuilder = GeneratedMessage.access$1300(builderClass, "get" + camelCaseName + "Count", new Class[0]);
      
      clearMethod = GeneratedMessage.access$1300(builderClass, "clear" + camelCaseName, new Class[0]);
    }
    
    public Object get(GeneratedMessage message)
    {
      return GeneratedMessage.access$1400(getMethod, message, new Object[0]);
    }
    
    public Object get(GeneratedMessage.Builder builder)
    {
      return GeneratedMessage.access$1400(getMethodBuilder, builder, new Object[0]);
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
      return GeneratedMessage.access$1400(getRepeatedMethod, message, new Object[] { Integer.valueOf(index) });
    }
    
    public Object getRepeated(GeneratedMessage.Builder builder, int index)
    {
      return GeneratedMessage.access$1400(getRepeatedMethodBuilder, builder, new Object[] { Integer.valueOf(index) });
    }
    
    public void setRepeated(GeneratedMessage.Builder builder, int index, Object value)
    {
      GeneratedMessage.access$1400(setRepeatedMethod, builder, new Object[] { Integer.valueOf(index), value });
    }
    
    public void addRepeated(GeneratedMessage.Builder builder, Object value)
    {
      GeneratedMessage.access$1400(addRepeatedMethod, builder, new Object[] { value });
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
      return ((Integer)GeneratedMessage.access$1400(getCountMethod, message, new Object[0])).intValue();
    }
    
    public int getRepeatedCount(GeneratedMessage.Builder builder)
    {
      return ((Integer)GeneratedMessage.access$1400(getCountMethodBuilder, builder, new Object[0])).intValue();
    }
    
    public void clear(GeneratedMessage.Builder builder)
    {
      GeneratedMessage.access$1400(clearMethod, builder, new Object[0]);
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
      
      valueOfMethod = GeneratedMessage.access$1300(type, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
      
      getValueDescriptorMethod = GeneratedMessage.access$1300(type, "getValueDescriptor", new Class[0]);
    }
    
    public Object get(GeneratedMessage message)
    {
      return GeneratedMessage.access$1400(getValueDescriptorMethod, super.get(message), new Object[0]);
    }
    
    public Object get(GeneratedMessage.Builder builder)
    {
      return GeneratedMessage.access$1400(getValueDescriptorMethod, super.get(builder), new Object[0]);
    }
    
    public void set(GeneratedMessage.Builder builder, Object value)
    {
      super.set(builder, GeneratedMessage.access$1400(valueOfMethod, null, new Object[] { value }));
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
      
      valueOfMethod = GeneratedMessage.access$1300(type, "valueOf", new Class[] { Descriptors.EnumValueDescriptor.class });
      
      getValueDescriptorMethod = GeneratedMessage.access$1300(type, "getValueDescriptor", new Class[0]);
    }
    
    public Object get(GeneratedMessage message)
    {
      List newList = new ArrayList();
      for (Object element : (List)super.get(message)) {
        newList.add(GeneratedMessage.access$1400(getValueDescriptorMethod, element, new Object[0]));
      }
      return Collections.unmodifiableList(newList);
    }
    
    public Object get(GeneratedMessage.Builder builder)
    {
      List newList = new ArrayList();
      for (Object element : (List)super.get(builder)) {
        newList.add(GeneratedMessage.access$1400(getValueDescriptorMethod, element, new Object[0]));
      }
      return Collections.unmodifiableList(newList);
    }
    
    public Object getRepeated(GeneratedMessage message, int index)
    {
      return GeneratedMessage.access$1400(getValueDescriptorMethod, super.getRepeated(message, index), new Object[0]);
    }
    
    public Object getRepeated(GeneratedMessage.Builder builder, int index)
    {
      return GeneratedMessage.access$1400(getValueDescriptorMethod, super.getRepeated(builder, index), new Object[0]);
    }
    
    public void setRepeated(GeneratedMessage.Builder builder, int index, Object value)
    {
      super.setRepeated(builder, index, GeneratedMessage.access$1400(valueOfMethod, null, new Object[] { value }));
    }
    
    public void addRepeated(GeneratedMessage.Builder builder, Object value)
    {
      super.addRepeated(builder, GeneratedMessage.access$1400(valueOfMethod, null, new Object[] { value }));
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
      
      newBuilderMethod = GeneratedMessage.access$1300(type, "newBuilder", new Class[0]);
      getBuilderMethodBuilder = GeneratedMessage.access$1300(builderClass, "get" + camelCaseName + "Builder", new Class[0]);
    }
    
    private Object coerceType(Object value)
    {
      if (type.isInstance(value)) {
        return value;
      }
      return ((Message.Builder)GeneratedMessage.access$1400(newBuilderMethod, null, new Object[0])).mergeFrom((Message)value).buildPartial();
    }
    
    public void set(GeneratedMessage.Builder builder, Object value)
    {
      super.set(builder, coerceType(value));
    }
    
    public Message.Builder newBuilder()
    {
      return (Message.Builder)GeneratedMessage.access$1400(newBuilderMethod, null, new Object[0]);
    }
    
    public Message.Builder getBuilder(GeneratedMessage.Builder builder)
    {
      return (Message.Builder)GeneratedMessage.access$1400(getBuilderMethodBuilder, builder, new Object[0]);
    }
  }
  
  private static final class RepeatedMessageFieldAccessor
    extends GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor
  {
    private final Method newBuilderMethod;
    
    RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
    {
      super(camelCaseName, messageClass, builderClass);
      
      newBuilderMethod = GeneratedMessage.access$1300(type, "newBuilder", new Class[0]);
    }
    
    private Object coerceType(Object value)
    {
      if (type.isInstance(value)) {
        return value;
      }
      return ((Message.Builder)GeneratedMessage.access$1400(newBuilderMethod, null, new Object[0])).mergeFrom((Message)value).build();
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
      return (Message.Builder)GeneratedMessage.access$1400(newBuilderMethod, null, new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.FieldAccessorTable
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */