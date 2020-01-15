package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.lang.reflect.Method;

final class GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor
  extends GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor
{
  private final Method newBuilderMethod;
  
  GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
  {
    super(descriptor, camelCaseName, messageClass, builderClass);
    
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedMessageFieldAccessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */