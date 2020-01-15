package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.CollectionToListMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.MapToMapMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ObjectToMapMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.NullableUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ObjectSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ObjectUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.S3LinkUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

class ConversionSchemas$StandardItemConverter
  implements ItemConverter
{
  private final ConversionSchemas.MarshallerSet marshallerSet;
  private final ConversionSchemas.UnmarshallerSet unmarshallerSet;
  private final S3ClientCache s3cc;
  
  public ConversionSchemas$StandardItemConverter(ConversionSchemas.MarshallerSet marshallerSet, ConversionSchemas.UnmarshallerSet unmarshallerSet, S3ClientCache s3cc)
  {
    this.marshallerSet = marshallerSet;
    this.unmarshallerSet = unmarshallerSet;
    this.s3cc = s3cc;
  }
  
  public DynamoDBMapperFieldModel getFieldModel(Method getter)
  {
    ArgumentMarshaller marshaller = getMarshaller(getter);
    DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
    if ((marshaller instanceof ArgumentMarshaller.StringAttributeMarshaller))
    {
      attributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.S;
    }
    else
    {
      DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
      if ((marshaller instanceof ArgumentMarshaller.NumberAttributeMarshaller))
      {
        attributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.N;
      }
      else
      {
        DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
        if ((marshaller instanceof ArgumentMarshaller.BinaryAttributeMarshaller))
        {
          attributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.B;
        }
        else
        {
          DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
          if ((marshaller instanceof ArgumentMarshaller.StringSetAttributeMarshaller))
          {
            attributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.SS;
          }
          else
          {
            DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
            if ((marshaller instanceof ArgumentMarshaller.NumberSetAttributeMarshaller))
            {
              attributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.NS;
            }
            else
            {
              DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
              if ((marshaller instanceof ArgumentMarshaller.BinarySetAttributeMarshaller))
              {
                attributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.BS;
              }
              else
              {
                DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
                if ((marshaller instanceof ArgumentMarshaller.BooleanAttributeMarshaller))
                {
                  attributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL;
                }
                else
                {
                  DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
                  if ((marshaller instanceof ArgumentMarshaller.ListAttributeMarshaller))
                  {
                    attributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.L;
                  }
                  else
                  {
                    DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
                    if ((marshaller instanceof ArgumentMarshaller.MapAttributeMarshaller)) {
                      attributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.M;
                    } else {
                      throw new DynamoDBMappingException("Unrecognized marshaller type for " + getter + ": " + marshaller);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
    StandardAnnotationMaps.FieldMap annotations = StandardAnnotationMaps.of(getter, null);
    DynamoDBMapperFieldModel.Builder builder = new DynamoDBMapperFieldModel.Builder(Void.TYPE, annotations);
    builder.with(attributeType);
    return builder.build();
  }
  
  public AttributeValue convert(Method getter, Object object)
  {
    if (object == null) {
      return null;
    }
    ArgumentMarshaller marshaller = getMarshaller(getter);
    return marshaller.marshall(object);
  }
  
  public Map<String, AttributeValue> convert(Object object)
  {
    if (object == null) {
      return null;
    }
    Class<Object> clazz = object.getClass();
    Map<String, AttributeValue> result = new HashMap();
    for (StandardBeanProperties.Bean<Object, Object> bean : StandardBeanProperties.of(clazz).map().values())
    {
      Object getterResult = bean.reflect().get(object);
      if (getterResult != null)
      {
        AttributeValue value = convert(bean.type().getter(), getterResult);
        if (value != null) {
          result.put(bean.properties().attributeName(), value);
        }
      }
    }
    return result;
  }
  
  private ArgumentMarshaller getMarshaller(Method getter)
  {
    ArgumentMarshaller marshaller = marshallerSet.getMarshaller(getter);
    
    marshaller = augment(getter.getGenericReturnType(), marshaller);
    
    return marshaller;
  }
  
  private ArgumentMarshaller getMemberMarshaller(Type type)
  {
    ArgumentMarshaller marshaller = marshallerSet.getMemberMarshaller(type);
    
    marshaller = augment(type, marshaller);
    
    return marshaller;
  }
  
  private ArgumentMarshaller augment(Type type, ArgumentMarshaller marshaller)
  {
    if ((marshaller instanceof CollectionToListMarshaller)) {
      return getCollectionToListMarshaller(type);
    }
    if ((marshaller instanceof MapToMapMarshaller)) {
      return getMapToMapMarshaller(type);
    }
    if ((marshaller instanceof ObjectToMapMarshaller)) {
      return getObjectToMapMarshaller(type);
    }
    return marshaller;
  }
  
  private ArgumentMarshaller getCollectionToListMarshaller(Type type)
  {
    if (!(type instanceof ParameterizedType)) {
      throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Collection type " + type + ", which is not parameterized.");
    }
    ParameterizedType ptype = (ParameterizedType)type;
    Type[] args = ptype.getActualTypeArguments();
    if ((args == null) || (args.length != 1)) {
      throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Collection type " + type + "; unexpected number of type arguments.");
    }
    ArgumentMarshaller memberMarshaller = getMemberMarshaller(args[0]);
    
    return new CollectionToListMarshaller(memberMarshaller);
  }
  
  private ArgumentMarshaller getMapToMapMarshaller(Type type)
  {
    if (!(type instanceof ParameterizedType)) {
      throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Map type " + type + ", which is not parameterized.");
    }
    ParameterizedType ptype = (ParameterizedType)type;
    Type[] args = ptype.getActualTypeArguments();
    if ((args == null) || (args.length != 2)) {
      throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Map type " + type + "; unexpected number of type arguments.");
    }
    if (args[0] != String.class) {
      throw new DynamoDBMappingException("Only Map<String, ?> is supported.");
    }
    ArgumentMarshaller memberMarshaller = getMemberMarshaller(args[1]);
    
    return new MapToMapMarshaller(memberMarshaller);
  }
  
  private ArgumentMarshaller getObjectToMapMarshaller(Type type)
  {
    Type localType = type;
    if ((localType instanceof ParameterizedType)) {
      localType = ((ParameterizedType)localType).getRawType();
    }
    if (!(localType instanceof Class)) {
      throw new DynamoDBMappingException("Cannot convert " + type + " to a class");
    }
    Class<?> clazz = (Class)localType;
    if (StandardAnnotationMaps.of(clazz).attributeType() != DynamoDBMapperFieldModel.DynamoDBAttributeType.M) {
      throw new DynamoDBMappingException("Cannot marshall type " + type + " without a custom marshaler or @DynamoDBDocument annotation.");
    }
    return new ObjectToMapMarshaller(this);
  }
  
  public Object unconvert(Method getter, Method setter, AttributeValue value)
  {
    ArgumentUnmarshaller unmarshaller = getUnmarshaller(getter, setter);
    return unmarshall(unmarshaller, setter, value);
  }
  
  public <T> T unconvert(Class<T> clazz, Map<String, AttributeValue> value)
  {
    T result = createObject(clazz);
    if ((value == null) || (value.isEmpty())) {
      return result;
    }
    for (StandardBeanProperties.Bean<T, Object> bean : StandardBeanProperties.of(clazz).map().values())
    {
      AttributeValue av = (AttributeValue)value.get(bean.properties().attributeName());
      if (av != null)
      {
        ArgumentUnmarshaller unmarshaller = getUnmarshaller(bean.type().getter(), bean.type().setter());
        Object unmarshalled = unmarshall(unmarshaller, bean.type().setter(), av);
        bean.reflect().set(result, unmarshalled);
      }
    }
    return result;
  }
  
  private ArgumentUnmarshaller getUnmarshaller(Method getter, Method setter)
  {
    ArgumentUnmarshaller unmarshaller = unmarshallerSet.getUnmarshaller(getter, setter);
    
    unmarshaller = augment(setter
      .getGenericParameterTypes()[0], unmarshaller);
    
    return new NullableUnmarshaller(unmarshaller);
  }
  
  private ArgumentUnmarshaller getMemberUnmarshaller(Type type)
  {
    ArgumentUnmarshaller unmarshaller = unmarshallerSet.getMemberUnmarshaller(type);
    
    unmarshaller = augment(type, unmarshaller);
    
    return new NullableUnmarshaller(unmarshaller);
  }
  
  private ArgumentUnmarshaller augment(Type type, ArgumentUnmarshaller unmarshaller)
  {
    if ((unmarshaller instanceof S3LinkUnmarshaller)) {
      return new S3LinkUnmarshaller(s3cc);
    }
    if ((unmarshaller instanceof ObjectSetUnmarshaller)) {
      return getObjectSetUnmarshaller(type);
    }
    if ((unmarshaller instanceof ListUnmarshaller)) {
      return getListUnmarshaller(type);
    }
    if ((unmarshaller instanceof MapUnmarshaller)) {
      return getMapUnmarshaller(type);
    }
    if ((unmarshaller instanceof ObjectUnmarshaller)) {
      return getObjectUnmarshaller(type);
    }
    return unmarshaller;
  }
  
  private ArgumentUnmarshaller getObjectSetUnmarshaller(Type type)
  {
    if (!(type instanceof ParameterizedType)) {
      throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Set type " + type + ", which is not parameterized.");
    }
    ParameterizedType ptype = (ParameterizedType)type;
    Type[] args = ptype.getActualTypeArguments();
    if ((args == null) || (args.length != 1)) {
      throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Set type " + type + "; unexpected number of type arguments.");
    }
    ArgumentUnmarshaller memberUnmarshaller = getMemberUnmarshaller(args[0]);
    
    return new ObjectSetUnmarshaller(memberUnmarshaller);
  }
  
  private ArgumentUnmarshaller getListUnmarshaller(Type type)
  {
    if (!(type instanceof ParameterizedType)) {
      throw new DynamoDBMappingException("Cannot tell what type of objects belong in the List type " + type + ", which is not parameterized.");
    }
    ParameterizedType ptype = (ParameterizedType)type;
    Type[] args = ptype.getActualTypeArguments();
    if ((args == null) || (args.length != 1)) {
      throw new DynamoDBMappingException("Cannot tell what type of objects belong in the List type " + type + "; unexpected number of type arguments.");
    }
    ArgumentUnmarshaller memberUnmarshaller = getMemberUnmarshaller(args[0]);
    
    return new ListUnmarshaller(memberUnmarshaller);
  }
  
  private ArgumentUnmarshaller getMapUnmarshaller(Type type)
  {
    if (!(type instanceof ParameterizedType)) {
      throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Map type " + type + ", which is not parameterized.");
    }
    ParameterizedType ptype = (ParameterizedType)type;
    Type[] args = ptype.getActualTypeArguments();
    if ((args == null) || (args.length != 2)) {
      throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Map type " + type + "; unexpected number of type arguments.");
    }
    if (args[0] != String.class) {
      throw new DynamoDBMappingException("Only Map<String, ?> is supported.");
    }
    ArgumentUnmarshaller memberUnmarshaller = getMemberUnmarshaller(args[1]);
    
    return new MapUnmarshaller(memberUnmarshaller);
  }
  
  private ArgumentUnmarshaller getObjectUnmarshaller(Type type)
  {
    Type localType = type;
    if ((localType instanceof ParameterizedType)) {
      localType = ((ParameterizedType)type).getRawType();
    }
    if (!(localType instanceof Class)) {
      throw new DynamoDBMappingException("Cannot convert " + type + " to a class");
    }
    Class<?> clazz = (Class)localType;
    if (StandardAnnotationMaps.of(clazz).attributeType() != DynamoDBMapperFieldModel.DynamoDBAttributeType.M) {
      throw new DynamoDBMappingException("Cannot unmarshall to type " + type + " without a custom marshaler or @DynamoDBDocument annotation.");
    }
    return new ObjectUnmarshaller(this, clazz);
  }
  
  private static Object unmarshall(ArgumentUnmarshaller unmarshaller, Method setter, AttributeValue value)
  {
    unmarshaller.typeCheck(value, setter);
    try
    {
      return unmarshaller.unmarshall(value);
    }
    catch (IllegalArgumentException e)
    {
      throw new DynamoDBMappingException("Couldn't unmarshall value " + value + " for " + setter, e);
    }
    catch (ParseException e)
    {
      throw new DynamoDBMappingException("Error attempting to parse date string " + value + " for " + setter, e);
    }
  }
  
  private static <T> T createObject(Class<T> clazz)
  {
    try
    {
      return (T)clazz.newInstance();
    }
    catch (InstantiationException e)
    {
      throw new DynamoDBMappingException("Failed to instantiate new instance of class", e);
    }
    catch (IllegalAccessException e)
    {
      throw new DynamoDBMappingException("Failed to instantiate new instance of class", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.StandardItemConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */