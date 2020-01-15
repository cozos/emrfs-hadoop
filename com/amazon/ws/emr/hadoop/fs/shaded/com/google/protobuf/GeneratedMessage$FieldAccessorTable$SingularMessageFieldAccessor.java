package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.lang.reflect.Method;

final class GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor
  extends GeneratedMessage.FieldAccessorTable.SingularFieldAccessor
{
  private final Method newBuilderMethod;
  private final Method getBuilderMethodBuilder;
  
  GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
  {
    super(descriptor, camelCaseName, messageClass, builderClass);
    
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularMessageFieldAccessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */