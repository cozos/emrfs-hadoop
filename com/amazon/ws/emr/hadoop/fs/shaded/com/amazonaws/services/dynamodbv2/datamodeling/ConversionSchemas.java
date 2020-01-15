package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.BooleanSetToNumberSetMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.BooleanToBooleanMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.BooleanToNumberMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ByteArraySetToBinarySetMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ByteArrayToBinaryMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ByteBufferSetToBinarySetMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ByteBufferToBinaryMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.CalendarSetToStringSetMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.CalendarToStringMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.CollectionToListMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.CustomMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.DateSetToStringSetMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.DateToStringMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.MapToMapMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.NumberSetToNumberSetMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.NumberToNumberMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ObjectSetToStringSetMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ObjectToMapMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ObjectToStringMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.S3LinkToStringMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.StringSetToStringSetMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.StringToStringMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.UUIDSetToStringSetMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.BigDecimalSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.BigDecimalUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.BigIntegerSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.BigIntegerUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.BooleanSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.BooleanUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ByteArraySetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ByteArrayUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ByteBufferSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ByteBufferUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ByteSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ByteUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.CalendarSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.CalendarUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.CustomUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.DateSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.DateUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.DoubleSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.DoubleUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.FloatSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.FloatUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.IntegerSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.IntegerUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.LongSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.LongUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.NullableUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ObjectSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ObjectUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.S3LinkUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ShortSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ShortUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.StringSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.StringUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.UUIDSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.UUIDUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class ConversionSchemas
{
  private static final Log LOGGER = LogFactory.getLog(ConversionSchemas.class);
  public static final ConversionSchema V1 = v1Builder("V1ConversionSchema").build();
  public static final ConversionSchema V2_COMPATIBLE = v2CompatibleBuilder("V2CompatibleConversionSchema")
    .build();
  public static final ConversionSchema V2 = v2Builder("V2ConversionSchema").build();
  static final ConversionSchema DEFAULT = V2_COMPATIBLE;
  
  public static Builder v1Builder(String name)
  {
    return new Builder(name, V1MarshallerSet.access$000(), V1MarshallerSet.access$100(), 
      StandardUnmarshallerSet.access$200(), 
      StandardUnmarshallerSet.access$300());
  }
  
  public static Builder v2CompatibleBuilder(String name)
  {
    return new Builder(name, V2CompatibleMarshallerSet.access$400(), 
      V2CompatibleMarshallerSet.access$500(), 
      StandardUnmarshallerSet.access$200(), 
      StandardUnmarshallerSet.access$300());
  }
  
  public static Builder v2Builder(String name)
  {
    return new Builder(name, V2MarshallerSet.access$600(), V2MarshallerSet.access$700(), 
      StandardUnmarshallerSet.access$200(), 
      StandardUnmarshallerSet.access$300());
  }
  
  public static class Builder
  {
    private final String name;
    private final List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers;
    private final List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers;
    private final List<ConversionSchemas.Pair<ArgumentUnmarshaller>> unmarshallers;
    private final List<ConversionSchemas.Pair<ArgumentUnmarshaller>> setUnmarshallers;
    
    Builder(String name, List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers, List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers, List<ConversionSchemas.Pair<ArgumentUnmarshaller>> unmarshallers, List<ConversionSchemas.Pair<ArgumentUnmarshaller>> setUnmarshallers)
    {
      this.name = name;
      this.marshallers = marshallers;
      this.setMarshallers = setMarshallers;
      this.unmarshallers = unmarshallers;
      this.setUnmarshallers = setUnmarshallers;
    }
    
    public Builder addFirstType(Class<?> clazz, ArgumentMarshaller marshaller, ArgumentUnmarshaller unmarshaller)
    {
      marshallers.add(0, ConversionSchemas.Pair.of(clazz, marshaller));
      unmarshallers.add(0, ConversionSchemas.Pair.of(clazz, unmarshaller));
      return this;
    }
    
    public Builder addFirstSetType(Class<?> clazz, ArgumentMarshaller marshaller, ArgumentUnmarshaller unmarshaller)
    {
      setMarshallers.add(0, ConversionSchemas.Pair.of(clazz, marshaller));
      setUnmarshallers.add(0, ConversionSchemas.Pair.of(clazz, unmarshaller));
      return this;
    }
    
    public ConversionSchema build()
    {
      return new ConversionSchemas.StandardConversionSchema(name, new ConversionSchemas.AbstractMarshallerSet(marshallers, setMarshallers), new ConversionSchemas.StandardUnmarshallerSet(unmarshallers, setUnmarshallers));
    }
  }
  
  static class StandardConversionSchema
    implements ConversionSchema
  {
    private final String name;
    private final ConversionSchemas.MarshallerSet marshallers;
    private final ConversionSchemas.UnmarshallerSet unmarshallers;
    
    public StandardConversionSchema(String name, ConversionSchemas.MarshallerSet marshallers, ConversionSchemas.UnmarshallerSet unmarshallers)
    {
      this.name = name;
      this.marshallers = new ConversionSchemas.CachingMarshallerSet(new ConversionSchemas.AnnotationAwareMarshallerSet(marshallers));
      
      this.unmarshallers = new ConversionSchemas.CachingUnmarshallerSet(new ConversionSchemas.AnnotationAwareUnmarshallerSet(unmarshallers));
    }
    
    public ItemConverter getConverter(ConversionSchema.Dependencies dependencies)
    {
      S3ClientCache s3cc = (S3ClientCache)dependencies.get(S3ClientCache.class);
      
      return new ConversionSchemas.StandardItemConverter(marshallers, unmarshallers, s3cc);
    }
    
    public String toString()
    {
      return name;
    }
  }
  
  static class StandardItemConverter
    implements ItemConverter
  {
    private final ConversionSchemas.MarshallerSet marshallerSet;
    private final ConversionSchemas.UnmarshallerSet unmarshallerSet;
    private final S3ClientCache s3cc;
    
    public StandardItemConverter(ConversionSchemas.MarshallerSet marshallerSet, ConversionSchemas.UnmarshallerSet unmarshallerSet, S3ClientCache s3cc)
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
  
  static abstract interface MarshallerSet
  {
    public abstract ArgumentMarshaller getMarshaller(Method paramMethod);
    
    public abstract ArgumentMarshaller getMemberMarshaller(Type paramType);
  }
  
  static abstract interface UnmarshallerSet
  {
    public abstract ArgumentUnmarshaller getUnmarshaller(Method paramMethod1, Method paramMethod2);
    
    public abstract ArgumentUnmarshaller getMemberUnmarshaller(Type paramType);
  }
  
  static final class V2MarshallerSet
  {
    private static List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers()
    {
      List<ConversionSchemas.Pair<ArgumentMarshaller>> list = new ArrayList();
      
      ConversionSchemas.addStandardDateMarshallers(list);
      ConversionSchemas.addV2BooleanMarshallers(list);
      ConversionSchemas.addStandardNumberMarshallers(list);
      ConversionSchemas.addStandardStringMarshallers(list);
      ConversionSchemas.addStandardBinaryMarshallers(list);
      ConversionSchemas.addStandardS3LinkMarshallers(list);
      
      list.add(ConversionSchemas.Pair.of(List.class, CollectionToListMarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Map.class, MapToMapMarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Object.class, ObjectToMapMarshaller.instance()));
      
      return list;
    }
    
    private static List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers()
    {
      List<ConversionSchemas.Pair<ArgumentMarshaller>> list = new ArrayList();
      
      ConversionSchemas.addStandardDateSetMarshallers(list);
      ConversionSchemas.addStandardNumberSetMarshallers(list);
      ConversionSchemas.addStandardStringSetMarshallers(list);
      ConversionSchemas.addStandardBinarySetMarshallers(list);
      
      list.add(ConversionSchemas.Pair.of(Object.class, 
      
        CollectionToListMarshaller.instance()));
      
      return list;
    }
  }
  
  static final class V2CompatibleMarshallerSet
  {
    private static List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers()
    {
      List<ConversionSchemas.Pair<ArgumentMarshaller>> list = new ArrayList();
      
      ConversionSchemas.addStandardDateMarshallers(list);
      ConversionSchemas.addV1BooleanMarshallers(list);
      ConversionSchemas.addStandardNumberMarshallers(list);
      ConversionSchemas.addStandardStringMarshallers(list);
      ConversionSchemas.addStandardBinaryMarshallers(list);
      ConversionSchemas.addStandardS3LinkMarshallers(list);
      
      list.add(ConversionSchemas.Pair.of(List.class, CollectionToListMarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Map.class, MapToMapMarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Object.class, ObjectToMapMarshaller.instance()));
      
      return list;
    }
    
    private static List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers()
    {
      List<ConversionSchemas.Pair<ArgumentMarshaller>> list = new ArrayList();
      
      ConversionSchemas.addStandardDateSetMarshallers(list);
      ConversionSchemas.addV1BooleanSetMarshallers(list);
      ConversionSchemas.addStandardNumberSetMarshallers(list);
      ConversionSchemas.addStandardStringSetMarshallers(list);
      ConversionSchemas.addStandardBinarySetMarshallers(list);
      
      list.add(ConversionSchemas.Pair.of(Object.class, ObjectSetToStringSetMarshaller.instance()));
      
      return list;
    }
  }
  
  static final class V1MarshallerSet
  {
    private static List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers()
    {
      List<ConversionSchemas.Pair<ArgumentMarshaller>> list = new ArrayList();
      
      ConversionSchemas.addStandardDateMarshallers(list);
      ConversionSchemas.addV1BooleanMarshallers(list);
      ConversionSchemas.addStandardNumberMarshallers(list);
      ConversionSchemas.addStandardStringMarshallers(list);
      ConversionSchemas.addStandardBinaryMarshallers(list);
      ConversionSchemas.addStandardS3LinkMarshallers(list);
      
      return list;
    }
    
    private static List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers()
    {
      List<ConversionSchemas.Pair<ArgumentMarshaller>> list = new ArrayList();
      
      ConversionSchemas.addStandardDateSetMarshallers(list);
      ConversionSchemas.addV1BooleanSetMarshallers(list);
      ConversionSchemas.addStandardNumberSetMarshallers(list);
      ConversionSchemas.addStandardStringSetMarshallers(list);
      ConversionSchemas.addStandardBinarySetMarshallers(list);
      
      list.add(ConversionSchemas.Pair.of(Object.class, 
        ObjectSetToStringSetMarshaller.instance()));
      
      return list;
    }
  }
  
  private static void addStandardDateMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(Date.class, 
      DateToStringMarshaller.instance()));
    list.add(Pair.of(Calendar.class, 
      CalendarToStringMarshaller.instance()));
  }
  
  private static void addV1BooleanMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(Boolean.class, 
      BooleanToNumberMarshaller.instance()));
    list.add(Pair.of(Boolean.TYPE, 
      BooleanToNumberMarshaller.instance()));
  }
  
  private static void addV2BooleanMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(Boolean.class, 
      BooleanToBooleanMarshaller.instance()));
    list.add(Pair.of(Boolean.TYPE, 
      BooleanToBooleanMarshaller.instance()));
  }
  
  private static void addStandardNumberMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(Number.class, 
      NumberToNumberMarshaller.instance()));
    list.add(Pair.of(Byte.TYPE, 
      NumberToNumberMarshaller.instance()));
    list.add(Pair.of(Short.TYPE, 
      NumberToNumberMarshaller.instance()));
    list.add(Pair.of(Integer.TYPE, 
      NumberToNumberMarshaller.instance()));
    list.add(Pair.of(Long.TYPE, 
      NumberToNumberMarshaller.instance()));
    list.add(Pair.of(Float.TYPE, 
      NumberToNumberMarshaller.instance()));
    list.add(Pair.of(Double.TYPE, 
      NumberToNumberMarshaller.instance()));
  }
  
  private static void addStandardStringMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(String.class, 
      StringToStringMarshaller.instance()));
    
    list.add(Pair.of(UUID.class, 
      ObjectToStringMarshaller.instance()));
  }
  
  private static void addStandardBinaryMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(ByteBuffer.class, 
      ByteBufferToBinaryMarshaller.instance()));
    list.add(Pair.of(byte[].class, 
      ByteArrayToBinaryMarshaller.instance()));
  }
  
  private static void addStandardS3LinkMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(S3Link.class, 
      S3LinkToStringMarshaller.instance()));
  }
  
  private static void addStandardDateSetMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(Date.class, 
      DateSetToStringSetMarshaller.instance()));
    list.add(Pair.of(Calendar.class, 
      CalendarSetToStringSetMarshaller.instance()));
  }
  
  private static void addStandardNumberSetMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(Number.class, 
      NumberSetToNumberSetMarshaller.instance()));
    list.add(Pair.of(Byte.TYPE, 
      NumberSetToNumberSetMarshaller.instance()));
    list.add(Pair.of(Short.TYPE, 
      NumberSetToNumberSetMarshaller.instance()));
    list.add(Pair.of(Integer.TYPE, 
      NumberSetToNumberSetMarshaller.instance()));
    list.add(Pair.of(Long.TYPE, 
      NumberSetToNumberSetMarshaller.instance()));
    list.add(Pair.of(Float.TYPE, 
      NumberSetToNumberSetMarshaller.instance()));
    list.add(Pair.of(Double.TYPE, 
      NumberSetToNumberSetMarshaller.instance()));
  }
  
  private static void addStandardStringSetMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(String.class, 
      StringSetToStringSetMarshaller.instance()));
    
    list.add(Pair.of(UUID.class, 
      UUIDSetToStringSetMarshaller.instance()));
  }
  
  private static void addStandardBinarySetMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(ByteBuffer.class, 
      ByteBufferSetToBinarySetMarshaller.instance()));
    list.add(Pair.of(byte[].class, 
      ByteArraySetToBinarySetMarshaller.instance()));
  }
  
  private static void addV1BooleanSetMarshallers(List<Pair<ArgumentMarshaller>> list)
  {
    list.add(Pair.of(Boolean.class, 
      BooleanSetToNumberSetMarshaller.instance()));
    list.add(Pair.of(Boolean.TYPE, 
      BooleanSetToNumberSetMarshaller.instance()));
  }
  
  private static class AbstractMarshallerSet
    implements ConversionSchemas.MarshallerSet
  {
    private final List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers;
    private final List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers;
    
    public AbstractMarshallerSet(List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers, List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers)
    {
      this.marshallers = marshallers;
      this.setMarshallers = setMarshallers;
    }
    
    public ArgumentMarshaller getMarshaller(Method getter)
    {
      Class<?> returnType = getter.getReturnType();
      if (Set.class.isAssignableFrom(returnType))
      {
        Class<?> memberType = ConversionSchemas.unwrapGenericSetParam(getter.getGenericReturnType());
        
        return getSet(getter, memberType);
      }
      return getScalar(getter, returnType);
    }
    
    public ArgumentMarshaller getMemberMarshaller(Type memberType)
    {
      Class<?> clazz = ConversionSchemas.resolveClass(memberType);
      if (Set.class.isAssignableFrom(clazz))
      {
        Class<?> setMemberType = ConversionSchemas.unwrapGenericSetParam(memberType);
        return getSet(null, setMemberType);
      }
      return getScalar(null, clazz);
    }
    
    private ArgumentMarshaller getScalar(Method getter, Class<?> type)
    {
      ArgumentMarshaller marshaller = (ArgumentMarshaller)ConversionSchemas.find(type, marshallers);
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
      ArgumentMarshaller marshaller = (ArgumentMarshaller)ConversionSchemas.find(memberType, setMarshallers);
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
  
  static class StandardUnmarshallerSet
    implements ConversionSchemas.UnmarshallerSet
  {
    private final List<ConversionSchemas.Pair<ArgumentUnmarshaller>> unmarshallers;
    private final List<ConversionSchemas.Pair<ArgumentUnmarshaller>> setUnmarshallers;
    
    public StandardUnmarshallerSet()
    {
      this(unmarshallers(), setUnmarshallers());
    }
    
    public StandardUnmarshallerSet(List<ConversionSchemas.Pair<ArgumentUnmarshaller>> unmarshallers, List<ConversionSchemas.Pair<ArgumentUnmarshaller>> setUnmarshallers)
    {
      this.unmarshallers = unmarshallers;
      this.setUnmarshallers = setUnmarshallers;
    }
    
    private static List<ConversionSchemas.Pair<ArgumentUnmarshaller>> unmarshallers()
    {
      List<ConversionSchemas.Pair<ArgumentUnmarshaller>> list = new ArrayList();
      
      list.add(ConversionSchemas.Pair.of(Double.TYPE, DoubleUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Double.class, DoubleUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(BigDecimal.class, 
        BigDecimalUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(BigInteger.class, 
        BigIntegerUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Integer.TYPE, IntegerUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Integer.class, IntegerUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Float.TYPE, FloatUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Float.class, FloatUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Byte.TYPE, ByteUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Byte.class, ByteUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Long.TYPE, LongUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Long.class, LongUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Short.TYPE, ShortUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Short.class, ShortUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Boolean.TYPE, BooleanUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Boolean.class, BooleanUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Date.class, DateUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Calendar.class, CalendarUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(ByteBuffer.class, 
        ByteBufferUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(byte[].class, 
        ByteArrayUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(S3Link.class, S3LinkUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(UUID.class, UUIDUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(String.class, StringUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(List.class, ListUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Map.class, MapUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Object.class, ObjectUnmarshaller.instance()));
      
      return list;
    }
    
    private static List<ConversionSchemas.Pair<ArgumentUnmarshaller>> setUnmarshallers()
    {
      List<ConversionSchemas.Pair<ArgumentUnmarshaller>> list = new ArrayList();
      
      list.add(ConversionSchemas.Pair.of(Double.TYPE, DoubleSetUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Double.class, DoubleSetUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(BigDecimal.class, 
        BigDecimalSetUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(BigInteger.class, 
        BigIntegerSetUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Integer.TYPE, IntegerSetUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Integer.class, IntegerSetUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Float.TYPE, FloatSetUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Float.class, FloatSetUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Byte.TYPE, ByteSetUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Byte.class, ByteSetUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Long.TYPE, LongSetUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Long.class, LongSetUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Short.TYPE, ShortSetUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Short.class, ShortSetUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Boolean.TYPE, BooleanSetUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Boolean.class, BooleanSetUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Date.class, DateSetUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(Calendar.class, 
        CalendarSetUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(ByteBuffer.class, 
        ByteBufferSetUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(byte[].class, 
        ByteArraySetUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(UUID.class, UUIDSetUnmarshaller.instance()));
      list.add(ConversionSchemas.Pair.of(String.class, StringSetUnmarshaller.instance()));
      
      list.add(ConversionSchemas.Pair.of(Object.class, ObjectSetUnmarshaller.instance()));
      
      return list;
    }
    
    public ArgumentUnmarshaller getUnmarshaller(Method getter, Method setter)
    {
      if (setter.getParameterTypes().length != 1) {
        throw new DynamoDBMappingException("Expected exactly one agument to " + setter);
      }
      Class<?> paramType = setter.getParameterTypes()[0];
      if (Set.class.isAssignableFrom(paramType))
      {
        paramType = ConversionSchemas.unwrapGenericSetParam(setter
          .getGenericParameterTypes()[0]);
        
        return getSet(setter, paramType);
      }
      return getScalar(setter, paramType);
    }
    
    public ArgumentUnmarshaller getMemberUnmarshaller(Type memberType)
    {
      Class<?> clazz = ConversionSchemas.resolveClass(memberType);
      if (Set.class.isAssignableFrom(clazz))
      {
        Class<?> setMemberType = ConversionSchemas.unwrapGenericSetParam(memberType);
        return getSet(null, setMemberType);
      }
      return getScalar(null, clazz);
    }
    
    private ArgumentUnmarshaller getSet(Method setter, Class<?> paramType)
    {
      ArgumentUnmarshaller unmarshaller = (ArgumentUnmarshaller)ConversionSchemas.find(paramType, setUnmarshallers);
      
      String className = "?";
      String methodName = "?";
      if (setter != null)
      {
        className = setter.getDeclaringClass().toString();
        methodName = setter.getName();
      }
      if (unmarshaller == null) {
        throw new DynamoDBMappingException("Cannot unmarshall to parameter type Set<" + paramType + "> of method " + className + "." + methodName + " without a custom unmarshaler.");
      }
      return unmarshaller;
    }
    
    private ArgumentUnmarshaller getScalar(Method setter, Class<?> type)
    {
      ArgumentUnmarshaller unmarshaller = (ArgumentUnmarshaller)ConversionSchemas.find(type, unmarshallers);
      
      String className = "?";
      String methodName = "?";
      if (setter != null)
      {
        className = setter.getDeclaringClass().toString();
        methodName = setter.getName();
      }
      if (unmarshaller == null) {
        throw new DynamoDBMappingException("Cannot unmarshall to parameter type " + type + "of method " + className + "." + methodName + " without a custom unmarshaler.");
      }
      return unmarshaller;
    }
  }
  
  private static Class<?> unwrapGenericSetParam(Type setType)
  {
    if (!(setType instanceof ParameterizedType))
    {
      LOGGER.warn("Set type " + setType + " is not a ParameterizedType, using default marshaler and unmarshaler!");
      
      return Object.class;
    }
    ParameterizedType ptype = (ParameterizedType)setType;
    Type[] arguments = ptype.getActualTypeArguments();
    if (arguments.length != 1)
    {
      LOGGER.warn("Set type " + setType + " does not have exactly one type argument, using default marshaler and unmarshaler!");
      
      return Object.class;
    }
    if (arguments[0].toString().equals("byte[]")) {
      return byte[].class;
    }
    return (Class)arguments[0];
  }
  
  private static Class<?> resolveClass(Type type)
  {
    Type localType = type;
    if ((localType instanceof ParameterizedType)) {
      localType = ((ParameterizedType)type).getRawType();
    }
    if (!(localType instanceof Class)) {
      throw new DynamoDBMappingException("Cannot resolve class for type " + type);
    }
    return (Class)localType;
  }
  
  private static <T> T find(Class<?> needle, List<Pair<T>> haystack)
  {
    for (Pair<? extends T> pair : haystack) {
      if (key.isAssignableFrom(needle)) {
        return (T)value;
      }
    }
    return null;
  }
  
  private static class Pair<T>
  {
    public final Class<?> key;
    public final T value;
    
    public static Pair<ArgumentMarshaller> of(Class<?> key, ArgumentMarshaller value)
    {
      return new Pair(key, value);
    }
    
    public static Pair<ArgumentUnmarshaller> of(Class<?> key, ArgumentUnmarshaller value)
    {
      return new Pair(key, value);
    }
    
    private Pair(Class<?> key, T value)
    {
      this.key = key;
      this.value = value;
    }
  }
  
  static class AnnotationAwareMarshallerSet
    implements ConversionSchemas.MarshallerSet
  {
    private final ConversionSchemas.MarshallerSet wrapped;
    
    public AnnotationAwareMarshallerSet(ConversionSchemas.MarshallerSet wrapped)
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
  
  static class AnnotationAwareUnmarshallerSet
    implements ConversionSchemas.UnmarshallerSet
  {
    private final ConversionSchemas.UnmarshallerSet wrapped;
    
    public AnnotationAwareUnmarshallerSet(ConversionSchemas.UnmarshallerSet wrapped)
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
  
  static class CachingMarshallerSet
    implements ConversionSchemas.MarshallerSet
  {
    private final Map<Method, ArgumentMarshaller> cache = new HashMap();
    private final Map<Type, ArgumentMarshaller> memberCache = new HashMap();
    private final ConversionSchemas.MarshallerSet wrapped;
    
    public CachingMarshallerSet(ConversionSchemas.MarshallerSet wrapped)
    {
      this.wrapped = wrapped;
    }
    
    public ArgumentMarshaller getMarshaller(Method getter)
    {
      synchronized (cache)
      {
        ArgumentMarshaller marshaler = (ArgumentMarshaller)cache.get(getter);
        if (marshaler != null) {
          return marshaler;
        }
        marshaler = wrapped.getMarshaller(getter);
        cache.put(getter, marshaler);
        return marshaler;
      }
    }
    
    public ArgumentMarshaller getMemberMarshaller(Type memberType)
    {
      synchronized (memberCache)
      {
        ArgumentMarshaller marshaller = (ArgumentMarshaller)memberCache.get(memberType);
        if (marshaller != null) {
          return marshaller;
        }
        marshaller = wrapped.getMemberMarshaller(memberType);
        memberCache.put(memberType, marshaller);
        return marshaller;
      }
    }
  }
  
  static class CachingUnmarshallerSet
    implements ConversionSchemas.UnmarshallerSet
  {
    private final Map<Method, ArgumentUnmarshaller> cache = new HashMap();
    private final Map<Type, ArgumentUnmarshaller> memberCache = new HashMap();
    private final ConversionSchemas.UnmarshallerSet wrapped;
    
    public CachingUnmarshallerSet(ConversionSchemas.UnmarshallerSet wrapped)
    {
      this.wrapped = wrapped;
    }
    
    public ArgumentUnmarshaller getUnmarshaller(Method getter, Method setter)
    {
      synchronized (cache)
      {
        ArgumentUnmarshaller unmarshaler = (ArgumentUnmarshaller)cache.get(getter);
        if (unmarshaler != null) {
          return unmarshaler;
        }
        unmarshaler = wrapped.getUnmarshaller(getter, setter);
        cache.put(getter, unmarshaler);
        return unmarshaler;
      }
    }
    
    public ArgumentUnmarshaller getMemberUnmarshaller(Type memberType)
    {
      synchronized (memberCache)
      {
        ArgumentUnmarshaller unmarshaller = (ArgumentUnmarshaller)memberCache.get(memberType);
        if (unmarshaller != null) {
          return unmarshaller;
        }
        unmarshaller = wrapped.getMemberUnmarshaller(memberType);
        memberCache.put(memberType, unmarshaller);
        return unmarshaller;
      }
    }
  }
  
  static class ItemConverterRuleFactory<V>
    implements StandardModelFactories.RuleFactory<V>
  {
    private final StandardModelFactories.RuleFactory<V> typeConverters;
    private final ItemConverter converter;
    private final boolean customSchema;
    
    ItemConverterRuleFactory(DynamoDBMapperConfig config, S3Link.Factory s3Links, StandardModelFactories.RuleFactory<V> typeConverters)
    {
      ConversionSchema.Dependencies depends = new ConversionSchema.Dependencies().with(S3ClientCache.class, s3Links.getS3ClientCache());
      ConversionSchema schema = config.getConversionSchema();
      
      customSchema = ((schema != ConversionSchemas.V1) && (schema != ConversionSchemas.V2_COMPATIBLE) && (schema != ConversionSchemas.V2));
      converter = schema.getConverter(depends);
      this.typeConverters = typeConverters;
    }
    
    public StandardModelFactories.Rule<V> getRule(ConvertibleType<V> type)
    {
      if ((customSchema) && (type.typeConverter() == null)) {
        return new ItemConverterRule(type, null);
      }
      return typeConverters.getRule(type);
    }
    
    private final class ItemConverterRule<V>
      implements StandardModelFactories.Rule<V>, DynamoDBTypeConverter<AttributeValue, V>
    {
      private final ConvertibleType<V> type;
      
      private ItemConverterRule()
      {
        this.type = type;
      }
      
      public boolean isAssignableFrom(ConvertibleType<?> type)
      {
        return true;
      }
      
      public DynamoDBTypeConverter<AttributeValue, V> newConverter(ConvertibleType<V> type)
      {
        return this;
      }
      
      public DynamoDBMapperFieldModel.DynamoDBAttributeType getAttributeType()
      {
        try
        {
          return converter.getFieldModel(type.getter()).attributeType();
        }
        catch (DynamoDBMappingException localDynamoDBMappingException) {}
        return DynamoDBMapperFieldModel.DynamoDBAttributeType.NULL;
      }
      
      public AttributeValue convert(V object)
      {
        return converter.convert(type.getter(), object);
      }
      
      public V unconvert(AttributeValue object)
      {
        return (V)converter.unconvert(type.getter(), type.setter(), object);
      }
    }
  }
  
  ConversionSchemas()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */