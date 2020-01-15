package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.lang.reflect.Method;
import java.util.List;

class GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor
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
  
  GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */