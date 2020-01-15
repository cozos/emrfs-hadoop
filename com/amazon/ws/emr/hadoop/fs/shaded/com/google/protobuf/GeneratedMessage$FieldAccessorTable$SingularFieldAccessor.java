package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.lang.reflect.Method;

class GeneratedMessage$FieldAccessorTable$SingularFieldAccessor
  implements GeneratedMessage.FieldAccessorTable.FieldAccessor
{
  protected final Class<?> type;
  protected final Method getMethod;
  protected final Method getMethodBuilder;
  protected final Method setMethod;
  protected final Method hasMethod;
  protected final Method hasMethodBuilder;
  protected final Method clearMethod;
  
  GeneratedMessage$FieldAccessorTable$SingularFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */