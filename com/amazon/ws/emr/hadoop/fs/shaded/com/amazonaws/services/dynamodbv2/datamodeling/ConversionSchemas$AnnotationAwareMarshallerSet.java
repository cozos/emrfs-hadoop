package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.BooleanToBooleanMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.CustomMarshaller;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

class ConversionSchemas$AnnotationAwareMarshallerSet
  implements ConversionSchemas.MarshallerSet
{
  private final ConversionSchemas.MarshallerSet wrapped;
  
  public ConversionSchemas$AnnotationAwareMarshallerSet(ConversionSchemas.MarshallerSet wrapped)
  {
    this.wrapped = wrapped;
  }
  
  public ArgumentMarshaller getMarshaller(Method getter)
  {
    StandardAnnotationMaps.FieldMap<?> annotations = StandardAnnotationMaps.of(getter, null);
    DynamoDBMarshalling marshalling = (DynamoDBMarshalling)annotations.actualOf(DynamoDBMarshalling.class);
    if (marshalling != null) {
      return new CustomMarshaller(marshalling.marshallerClass());
    }
    if (annotations.actualOf(DynamoDBNativeBoolean.class) != null) {
      return BooleanToBooleanMarshaller.instance();
    }
    return wrapped.getMarshaller(getter);
  }
  
  public ArgumentMarshaller getMemberMarshaller(Type memberType)
  {
    return wrapped.getMemberMarshaller(memberType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.AnnotationAwareMarshallerSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */