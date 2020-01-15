package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

class ConversionSchemas$AbstractMarshallerSet
  implements ConversionSchemas.MarshallerSet
{
  private final List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers;
  private final List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers;
  
  public ConversionSchemas$AbstractMarshallerSet(List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers, List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers)
  {
    this.marshallers = marshallers;
    this.setMarshallers = setMarshallers;
  }
  
  public ArgumentMarshaller getMarshaller(Method getter)
  {
    Class<?> returnType = getter.getReturnType();
    if (Set.class.isAssignableFrom(returnType))
    {
      Class<?> memberType = ConversionSchemas.access$2000(getter.getGenericReturnType());
      
      return getSet(getter, memberType);
    }
    return getScalar(getter, returnType);
  }
  
  public ArgumentMarshaller getMemberMarshaller(Type memberType)
  {
    Class<?> clazz = ConversionSchemas.access$2100(memberType);
    if (Set.class.isAssignableFrom(clazz))
    {
      Class<?> setMemberType = ConversionSchemas.access$2000(memberType);
      return getSet(null, setMemberType);
    }
    return getScalar(null, clazz);
  }
  
  private ArgumentMarshaller getScalar(Method getter, Class<?> type)
  {
    ArgumentMarshaller marshaller = (ArgumentMarshaller)ConversionSchemas.access$2200(type, marshallers);
    if (marshaller == null)
    {
      String className = "?";
      String methodName = "?";
      if (getter != null)
      {
        className = getter.getDeclaringClass().toString();
        methodName = getter.getName();
      }
      throw new DynamoDBMappingException("Cannot marshall return type " + type + " of method " + className + "." + methodName + " without a custom marshaler.");
    }
    return marshaller;
  }
  
  private ArgumentMarshaller getSet(Method getter, Class<?> memberType)
  {
    ArgumentMarshaller marshaller = (ArgumentMarshaller)ConversionSchemas.access$2200(memberType, setMarshallers);
    if (marshaller == null)
    {
      String className = "?";
      String methodName = "?";
      if (getter != null)
      {
        className = getter.getDeclaringClass().toString();
        methodName = getter.getName();
      }
      throw new DynamoDBMappingException("Cannot marshall return type Set<" + memberType + "> of method " + className + "." + methodName + " without a custom marshaller.");
    }
    return marshaller;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.AbstractMarshallerSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */