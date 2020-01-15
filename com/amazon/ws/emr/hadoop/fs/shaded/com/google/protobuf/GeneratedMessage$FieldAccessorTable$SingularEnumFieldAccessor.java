package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.lang.reflect.Method;

final class GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor
  extends GeneratedMessage.FieldAccessorTable.SingularFieldAccessor
{
  private Method valueOfMethod;
  private Method getValueDescriptorMethod;
  
  GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
  {
    super(descriptor, camelCaseName, messageClass, builderClass);
    
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularEnumFieldAccessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */