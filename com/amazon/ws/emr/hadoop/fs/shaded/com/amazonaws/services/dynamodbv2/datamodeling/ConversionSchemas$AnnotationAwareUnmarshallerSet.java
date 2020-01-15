package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.CustomUnmarshaller;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

class ConversionSchemas$AnnotationAwareUnmarshallerSet
  implements ConversionSchemas.UnmarshallerSet
{
  private final ConversionSchemas.UnmarshallerSet wrapped;
  
  public ConversionSchemas$AnnotationAwareUnmarshallerSet(ConversionSchemas.UnmarshallerSet wrapped)
  {
    this.wrapped = wrapped;
  }
  
  public ArgumentUnmarshaller getUnmarshaller(Method getter, Method setter)
  {
    StandardAnnotationMaps.FieldMap<?> annotations = StandardAnnotationMaps.of(getter, null);
    DynamoDBMarshalling marshalling = (DynamoDBMarshalling)annotations.actualOf(DynamoDBMarshalling.class);
    if (marshalling != null) {
      return new CustomUnmarshaller(getter.getReturnType(), marshalling.marshallerClass());
    }
    return wrapped.getUnmarshaller(getter, setter);
  }
  
  public ArgumentUnmarshaller getMemberUnmarshaller(Type c)
  {
    return wrapped.getMemberUnmarshaller(c);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.AnnotationAwareUnmarshallerSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */