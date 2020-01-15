package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor
  extends GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor
{
  private final Method valueOfMethod;
  private final Method getValueDescriptorMethod;
  
  GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends GeneratedMessage.Builder> builderClass)
  {
    super(descriptor, camelCaseName, messageClass, builderClass);
    
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedEnumFieldAccessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */