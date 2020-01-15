package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class NumberSerializers
{
  public static void addAll(Map<String, JsonSerializer<?>> allDeserializers)
  {
    JsonSerializer<?> intS = new IntegerSerializer();
    allDeserializers.put(Integer.class.getName(), intS);
    allDeserializers.put(Integer.TYPE.getName(), intS);
    allDeserializers.put(Long.class.getName(), LongSerializer.instance);
    allDeserializers.put(Long.TYPE.getName(), LongSerializer.instance);
    allDeserializers.put(Byte.class.getName(), IntLikeSerializer.instance);
    allDeserializers.put(Byte.TYPE.getName(), IntLikeSerializer.instance);
    allDeserializers.put(Short.class.getName(), ShortSerializer.instance);
    allDeserializers.put(Short.TYPE.getName(), ShortSerializer.instance);
    
    allDeserializers.put(Float.class.getName(), FloatSerializer.instance);
    allDeserializers.put(Float.TYPE.getName(), FloatSerializer.instance);
    allDeserializers.put(Double.class.getName(), DoubleSerializer.instance);
    allDeserializers.put(Double.TYPE.getName(), DoubleSerializer.instance);
  }
  
  protected static abstract class Base<T>
    extends StdScalarSerializer<T>
    implements ContextualSerializer
  {
    protected static final Integer EMPTY_INTEGER = Integer.valueOf(0);
    protected final JsonParser.NumberType _numberType;
    protected final String _schemaType;
    protected final boolean _isInt;
    
    protected Base(Class<?> cls, JsonParser.NumberType numberType, String schemaType)
    {
      super(false);
      _numberType = numberType;
      _schemaType = schemaType;
      _isInt = ((numberType == JsonParser.NumberType.INT) || (numberType == JsonParser.NumberType.LONG) || (numberType == JsonParser.NumberType.BIG_INTEGER));
    }
    
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
      return createSchemaNode(_schemaType, true);
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
      throws JsonMappingException
    {
      if (_isInt)
      {
        JsonIntegerFormatVisitor v2 = visitor.expectIntegerFormat(typeHint);
        if (v2 != null) {
          v2.numberType(_numberType);
        }
      }
      else
      {
        JsonNumberFormatVisitor v2 = visitor.expectNumberFormat(typeHint);
        if (v2 != null) {
          v2.numberType(_numberType);
        }
      }
    }
    
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property)
      throws JsonMappingException
    {
      if (property != null)
      {
        AnnotatedMember m = property.getMember();
        if (m != null)
        {
          JsonFormat.Value format = prov.getAnnotationIntrospector().findFormat(m);
          if (format != null) {
            switch (NumberSerializers.1.$SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[format.getShape().ordinal()])
            {
            case 1: 
              return ToStringSerializer.instance;
            }
          }
        }
      }
      return this;
    }
  }
  
  @JacksonStdImpl
  public static final class ShortSerializer
    extends NumberSerializers.Base<Short>
  {
    private static final Short EMPTY = Short.valueOf();
    static final ShortSerializer instance = new ShortSerializer();
    
    public ShortSerializer()
    {
      super(JsonParser.NumberType.INT, "number");
    }
    
    public boolean isEmpty(SerializerProvider prov, Short value)
    {
      return EMPTY.equals(value);
    }
    
    public void serialize(Short value, JsonGenerator gen, SerializerProvider provider)
      throws IOException
    {
      gen.writeNumber(value.shortValue());
    }
  }
  
  @JacksonStdImpl
  public static final class IntegerSerializer
    extends NumberSerializers.Base<Object>
  {
    public IntegerSerializer()
    {
      super(JsonParser.NumberType.INT, "integer");
    }
    
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
      throws IOException
    {
      gen.writeNumber(((Integer)value).intValue());
    }
    
    public void serializeWithType(Object value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
      throws IOException
    {
      serialize(value, gen, provider);
    }
    
    public boolean isEmpty(SerializerProvider prov, Object value)
    {
      return EMPTY_INTEGER.equals(value);
    }
  }
  
  @JacksonStdImpl
  public static final class IntLikeSerializer
    extends NumberSerializers.Base<Number>
  {
    static final IntLikeSerializer instance = new IntLikeSerializer();
    
    public IntLikeSerializer()
    {
      super(JsonParser.NumberType.INT, "integer");
    }
    
    public boolean isEmpty(SerializerProvider prov, Number value)
    {
      return value.intValue() == 0;
    }
    
    public void serialize(Number value, JsonGenerator gen, SerializerProvider provider)
      throws IOException
    {
      gen.writeNumber(value.intValue());
    }
  }
  
  @JacksonStdImpl
  public static final class LongSerializer
    extends NumberSerializers.Base<Object>
  {
    private static final Long EMPTY = Long.valueOf(0L);
    static final LongSerializer instance = new LongSerializer();
    
    public LongSerializer()
    {
      super(JsonParser.NumberType.LONG, "number");
    }
    
    public boolean isEmpty(SerializerProvider prov, Object value)
    {
      return EMPTY.equals(value);
    }
    
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
      throws IOException
    {
      gen.writeNumber(((Long)value).longValue());
    }
  }
  
  @JacksonStdImpl
  public static final class FloatSerializer
    extends NumberSerializers.Base<Object>
  {
    private static final Float EMPTY = Float.valueOf(0.0F);
    static final FloatSerializer instance = new FloatSerializer();
    
    public FloatSerializer()
    {
      super(JsonParser.NumberType.FLOAT, "number");
    }
    
    public boolean isEmpty(SerializerProvider prov, Object value)
    {
      return EMPTY.equals(value);
    }
    
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
      throws IOException
    {
      gen.writeNumber(((Float)value).floatValue());
    }
  }
  
  @JacksonStdImpl
  public static final class DoubleSerializer
    extends NumberSerializers.Base<Object>
  {
    private static final Double EMPTY = Double.valueOf(0.0D);
    static final DoubleSerializer instance = new DoubleSerializer();
    
    public DoubleSerializer()
    {
      super(JsonParser.NumberType.DOUBLE, "number");
    }
    
    public boolean isEmpty(SerializerProvider prov, Object value)
    {
      return EMPTY.equals(value);
    }
    
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
      throws IOException
    {
      gen.writeNumber(((Double)value).doubleValue());
    }
    
    public void serializeWithType(Object value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
      throws IOException
    {
      serialize(value, gen, provider);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NumberSerializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */