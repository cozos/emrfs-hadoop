package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ObjectSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ObjectUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.S3LinkUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ShortSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ShortUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.StringSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.StringUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.UUIDSetUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.UUIDUnmarshaller;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

class ConversionSchemas$StandardUnmarshallerSet
  implements ConversionSchemas.UnmarshallerSet
{
  private final List<ConversionSchemas.Pair<ArgumentUnmarshaller>> unmarshallers;
  private final List<ConversionSchemas.Pair<ArgumentUnmarshaller>> setUnmarshallers;
  
  public ConversionSchemas$StandardUnmarshallerSet()
  {
    this(unmarshallers(), setUnmarshallers());
  }
  
  public ConversionSchemas$StandardUnmarshallerSet(List<ConversionSchemas.Pair<ArgumentUnmarshaller>> unmarshallers, List<ConversionSchemas.Pair<ArgumentUnmarshaller>> setUnmarshallers)
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
      paramType = ConversionSchemas.access$2000(setter
        .getGenericParameterTypes()[0]);
      
      return getSet(setter, paramType);
    }
    return getScalar(setter, paramType);
  }
  
  public ArgumentUnmarshaller getMemberUnmarshaller(Type memberType)
  {
    Class<?> clazz = ConversionSchemas.access$2100(memberType);
    if (Set.class.isAssignableFrom(clazz))
    {
      Class<?> setMemberType = ConversionSchemas.access$2000(memberType);
      return getSet(null, setMemberType);
    }
    return getScalar(null, clazz);
  }
  
  private ArgumentUnmarshaller getSet(Method setter, Class<?> paramType)
  {
    ArgumentUnmarshaller unmarshaller = (ArgumentUnmarshaller)ConversionSchemas.access$2200(paramType, setUnmarshallers);
    
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
    ArgumentUnmarshaller unmarshaller = (ArgumentUnmarshaller)ConversionSchemas.access$2200(type, unmarshallers);
    
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.StandardUnmarshallerSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */