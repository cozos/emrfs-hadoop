package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class StdArraySerializers
{
  protected static final HashMap<String, JsonSerializer<?>> _arraySerializers = new HashMap();
  
  static
  {
    _arraySerializers.put(boolean[].class.getName(), new BooleanArraySerializer());
    _arraySerializers.put(byte[].class.getName(), new ByteArraySerializer());
    _arraySerializers.put(char[].class.getName(), new CharArraySerializer());
    _arraySerializers.put(short[].class.getName(), new ShortArraySerializer());
    _arraySerializers.put(int[].class.getName(), new IntArraySerializer());
    _arraySerializers.put(long[].class.getName(), new LongArraySerializer());
    _arraySerializers.put(float[].class.getName(), new FloatArraySerializer());
    _arraySerializers.put(double[].class.getName(), new DoubleArraySerializer());
  }
  
  public static JsonSerializer<?> findStandardImpl(Class<?> cls)
  {
    return (JsonSerializer)_arraySerializers.get(cls.getName());
  }
  
  protected static abstract class TypedPrimitiveArraySerializer<T>
    extends ArraySerializerBase<T>
  {
    protected final TypeSerializer _valueTypeSerializer;
    
    protected TypedPrimitiveArraySerializer(Class<T> cls)
    {
      super();
      _valueTypeSerializer = null;
    }
    
    protected TypedPrimitiveArraySerializer(TypedPrimitiveArraySerializer<T> src, BeanProperty prop, TypeSerializer vts, Boolean unwrapSingle)
    {
      super(prop, unwrapSingle);
      _valueTypeSerializer = vts;
    }
  }
  
  @JacksonStdImpl
  public static class BooleanArraySerializer
    extends ArraySerializerBase<boolean[]>
  {
    private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Boolean.class);
    
    public BooleanArraySerializer()
    {
      super();
    }
    
    protected BooleanArraySerializer(BooleanArraySerializer src, BeanProperty prop, Boolean unwrapSingle)
    {
      super(prop, unwrapSingle);
    }
    
    public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle)
    {
      return new BooleanArraySerializer(this, prop, unwrapSingle);
    }
    
    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
    {
      return this;
    }
    
    public JavaType getContentType()
    {
      return VALUE_TYPE;
    }
    
    public JsonSerializer<?> getContentSerializer()
    {
      return null;
    }
    
    public boolean isEmpty(SerializerProvider prov, boolean[] value)
    {
      return (value == null) || (value.length == 0);
    }
    
    public boolean hasSingleElement(boolean[] value)
    {
      return value.length == 1;
    }
    
    public final void serialize(boolean[] value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException
    {
      int len = value.length;
      if ((len == 1) && (
        ((_unwrapSingle == null) && (provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
      {
        serializeContents(value, jgen, provider);
        return;
      }
      jgen.writeStartArray(len);
      serializeContents(value, jgen, provider);
      jgen.writeEndArray();
    }
    
    public void serializeContents(boolean[] value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonGenerationException
    {
      int i = 0;
      for (int len = value.length; i < len; i++) {
        jgen.writeBoolean(value[i]);
      }
    }
    
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
      ObjectNode o = createSchemaNode("array", true);
      o.set("items", createSchemaNode("boolean"));
      return o;
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
      throws JsonMappingException
    {
      if (visitor != null)
      {
        JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint);
        if (v2 != null) {
          v2.itemsFormat(JsonFormatTypes.BOOLEAN);
        }
      }
    }
  }
  
  @Deprecated
  @JacksonStdImpl
  public static class ByteArraySerializer
    extends ByteArraySerializer
  {}
  
  @JacksonStdImpl
  public static class ShortArraySerializer
    extends StdArraySerializers.TypedPrimitiveArraySerializer<short[]>
  {
    private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Short.TYPE);
    
    public ShortArraySerializer()
    {
      super();
    }
    
    public ShortArraySerializer(ShortArraySerializer src, BeanProperty prop, TypeSerializer vts, Boolean unwrapSingle)
    {
      super(prop, vts, unwrapSingle);
    }
    
    public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle)
    {
      return new ShortArraySerializer(this, prop, _valueTypeSerializer, unwrapSingle);
    }
    
    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
    {
      return new ShortArraySerializer(this, _property, vts, _unwrapSingle);
    }
    
    public JavaType getContentType()
    {
      return VALUE_TYPE;
    }
    
    public JsonSerializer<?> getContentSerializer()
    {
      return null;
    }
    
    public boolean isEmpty(SerializerProvider prov, short[] value)
    {
      return (value == null) || (value.length == 0);
    }
    
    public boolean hasSingleElement(short[] value)
    {
      return value.length == 1;
    }
    
    public final void serialize(short[] value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException
    {
      int len = value.length;
      if ((len == 1) && (
        ((_unwrapSingle == null) && (provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
      {
        serializeContents(value, jgen, provider);
        return;
      }
      jgen.writeStartArray(len);
      serializeContents(value, jgen, provider);
      jgen.writeEndArray();
    }
    
    public void serializeContents(short[] value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonGenerationException
    {
      if (_valueTypeSerializer != null)
      {
        int i = 0;
        for (int len = value.length; i < len; i++)
        {
          _valueTypeSerializer.writeTypePrefixForScalar(null, jgen, Short.TYPE);
          jgen.writeNumber(value[i]);
          _valueTypeSerializer.writeTypeSuffixForScalar(null, jgen);
        }
        return;
      }
      int i = 0;
      for (int len = value.length; i < len; i++) {
        jgen.writeNumber(value[i]);
      }
    }
    
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
      ObjectNode o = createSchemaNode("array", true);
      return o.set("items", createSchemaNode("integer"));
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
      throws JsonMappingException
    {
      if (visitor != null)
      {
        JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint);
        if (v2 != null) {
          v2.itemsFormat(JsonFormatTypes.INTEGER);
        }
      }
    }
  }
  
  @JacksonStdImpl
  public static class CharArraySerializer
    extends StdSerializer<char[]>
  {
    public CharArraySerializer()
    {
      super();
    }
    
    public boolean isEmpty(SerializerProvider prov, char[] value)
    {
      return (value == null) || (value.length == 0);
    }
    
    public void serialize(char[] value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonGenerationException
    {
      if (provider.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS))
      {
        jgen.writeStartArray(value.length);
        _writeArrayContents(jgen, value);
        jgen.writeEndArray();
      }
      else
      {
        jgen.writeString(value, 0, value.length);
      }
    }
    
    public void serializeWithType(char[] value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
      throws IOException, JsonGenerationException
    {
      if (provider.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS))
      {
        typeSer.writeTypePrefixForArray(value, jgen);
        _writeArrayContents(jgen, value);
        typeSer.writeTypeSuffixForArray(value, jgen);
      }
      else
      {
        typeSer.writeTypePrefixForScalar(value, jgen);
        jgen.writeString(value, 0, value.length);
        typeSer.writeTypeSuffixForScalar(value, jgen);
      }
    }
    
    private final void _writeArrayContents(JsonGenerator jgen, char[] value)
      throws IOException, JsonGenerationException
    {
      int i = 0;
      for (int len = value.length; i < len; i++) {
        jgen.writeString(value, i, 1);
      }
    }
    
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
      ObjectNode o = createSchemaNode("array", true);
      ObjectNode itemSchema = createSchemaNode("string");
      itemSchema.put("type", "string");
      return o.set("items", itemSchema);
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
      throws JsonMappingException
    {
      if (visitor != null)
      {
        JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint);
        if (v2 != null) {
          v2.itemsFormat(JsonFormatTypes.STRING);
        }
      }
    }
  }
  
  @JacksonStdImpl
  public static class IntArraySerializer
    extends ArraySerializerBase<int[]>
  {
    private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Integer.TYPE);
    
    public IntArraySerializer()
    {
      super();
    }
    
    protected IntArraySerializer(IntArraySerializer src, BeanProperty prop, Boolean unwrapSingle)
    {
      super(prop, unwrapSingle);
    }
    
    public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle)
    {
      return new IntArraySerializer(this, prop, unwrapSingle);
    }
    
    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
    {
      return this;
    }
    
    public JavaType getContentType()
    {
      return VALUE_TYPE;
    }
    
    public JsonSerializer<?> getContentSerializer()
    {
      return null;
    }
    
    public boolean isEmpty(SerializerProvider prov, int[] value)
    {
      return (value == null) || (value.length == 0);
    }
    
    public boolean hasSingleElement(int[] value)
    {
      return value.length == 1;
    }
    
    public final void serialize(int[] value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException
    {
      int len = value.length;
      if ((len == 1) && (
        ((_unwrapSingle == null) && (provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
      {
        serializeContents(value, jgen, provider);
        return;
      }
      jgen.writeStartArray(len);
      serializeContents(value, jgen, provider);
      jgen.writeEndArray();
    }
    
    public void serializeContents(int[] value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException
    {
      int i = 0;
      for (int len = value.length; i < len; i++) {
        jgen.writeNumber(value[i]);
      }
    }
    
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
      return createSchemaNode("array", true).set("items", createSchemaNode("integer"));
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
      throws JsonMappingException
    {
      if (visitor != null)
      {
        JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint);
        if (v2 != null) {
          v2.itemsFormat(JsonFormatTypes.INTEGER);
        }
      }
    }
  }
  
  @JacksonStdImpl
  public static class LongArraySerializer
    extends StdArraySerializers.TypedPrimitiveArraySerializer<long[]>
  {
    private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Long.TYPE);
    
    public LongArraySerializer()
    {
      super();
    }
    
    public LongArraySerializer(LongArraySerializer src, BeanProperty prop, TypeSerializer vts, Boolean unwrapSingle)
    {
      super(prop, vts, unwrapSingle);
    }
    
    public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle)
    {
      return new LongArraySerializer(this, prop, _valueTypeSerializer, unwrapSingle);
    }
    
    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
    {
      return new LongArraySerializer(this, _property, vts, _unwrapSingle);
    }
    
    public JavaType getContentType()
    {
      return VALUE_TYPE;
    }
    
    public JsonSerializer<?> getContentSerializer()
    {
      return null;
    }
    
    public boolean isEmpty(SerializerProvider prov, long[] value)
    {
      return (value == null) || (value.length == 0);
    }
    
    public boolean hasSingleElement(long[] value)
    {
      return value.length == 1;
    }
    
    public final void serialize(long[] value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException
    {
      int len = value.length;
      if ((len == 1) && (
        ((_unwrapSingle == null) && (provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
      {
        serializeContents(value, jgen, provider);
        return;
      }
      jgen.writeStartArray(len);
      serializeContents(value, jgen, provider);
      jgen.writeEndArray();
    }
    
    public void serializeContents(long[] value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException
    {
      if (_valueTypeSerializer != null)
      {
        int i = 0;
        for (int len = value.length; i < len; i++)
        {
          _valueTypeSerializer.writeTypePrefixForScalar(null, jgen, Long.TYPE);
          jgen.writeNumber(value[i]);
          _valueTypeSerializer.writeTypeSuffixForScalar(null, jgen);
        }
        return;
      }
      int i = 0;
      for (int len = value.length; i < len; i++) {
        jgen.writeNumber(value[i]);
      }
    }
    
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
      return createSchemaNode("array", true).set("items", createSchemaNode("number", true));
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
      throws JsonMappingException
    {
      if (visitor != null)
      {
        JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint);
        if (v2 != null) {
          v2.itemsFormat(JsonFormatTypes.NUMBER);
        }
      }
    }
  }
  
  @JacksonStdImpl
  public static class FloatArraySerializer
    extends StdArraySerializers.TypedPrimitiveArraySerializer<float[]>
  {
    private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Float.TYPE);
    
    public FloatArraySerializer()
    {
      super();
    }
    
    public FloatArraySerializer(FloatArraySerializer src, BeanProperty prop, TypeSerializer vts, Boolean unwrapSingle)
    {
      super(prop, vts, unwrapSingle);
    }
    
    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
    {
      return new FloatArraySerializer(this, _property, vts, _unwrapSingle);
    }
    
    public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle)
    {
      return new FloatArraySerializer(this, prop, _valueTypeSerializer, unwrapSingle);
    }
    
    public JavaType getContentType()
    {
      return VALUE_TYPE;
    }
    
    public JsonSerializer<?> getContentSerializer()
    {
      return null;
    }
    
    public boolean isEmpty(SerializerProvider prov, float[] value)
    {
      return (value == null) || (value.length == 0);
    }
    
    public boolean hasSingleElement(float[] value)
    {
      return value.length == 1;
    }
    
    public final void serialize(float[] value, JsonGenerator gen, SerializerProvider provider)
      throws IOException
    {
      int len = value.length;
      if ((len == 1) && (
        ((_unwrapSingle == null) && (provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
      {
        serializeContents(value, gen, provider);
        return;
      }
      gen.writeStartArray(len);
      serializeContents(value, gen, provider);
      gen.writeEndArray();
    }
    
    public void serializeContents(float[] value, JsonGenerator gen, SerializerProvider provider)
      throws IOException, JsonGenerationException
    {
      if (_valueTypeSerializer != null)
      {
        int i = 0;
        for (int len = value.length; i < len; i++)
        {
          _valueTypeSerializer.writeTypePrefixForScalar(null, gen, Float.TYPE);
          gen.writeNumber(value[i]);
          _valueTypeSerializer.writeTypeSuffixForScalar(null, gen);
        }
        return;
      }
      int i = 0;
      for (int len = value.length; i < len; i++) {
        gen.writeNumber(value[i]);
      }
    }
    
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
      return createSchemaNode("array", true).set("items", createSchemaNode("number"));
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
      throws JsonMappingException
    {
      if (visitor != null)
      {
        JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint);
        if (v2 != null) {
          v2.itemsFormat(JsonFormatTypes.NUMBER);
        }
      }
    }
  }
  
  @JacksonStdImpl
  public static class DoubleArraySerializer
    extends ArraySerializerBase<double[]>
  {
    private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Double.TYPE);
    
    public DoubleArraySerializer()
    {
      super();
    }
    
    protected DoubleArraySerializer(DoubleArraySerializer src, BeanProperty prop, Boolean unwrapSingle)
    {
      super(prop, unwrapSingle);
    }
    
    public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle)
    {
      return new DoubleArraySerializer(this, prop, unwrapSingle);
    }
    
    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
    {
      return this;
    }
    
    public JavaType getContentType()
    {
      return VALUE_TYPE;
    }
    
    public JsonSerializer<?> getContentSerializer()
    {
      return null;
    }
    
    public boolean isEmpty(SerializerProvider prov, double[] value)
    {
      return (value == null) || (value.length == 0);
    }
    
    public boolean hasSingleElement(double[] value)
    {
      return value.length == 1;
    }
    
    public final void serialize(double[] value, JsonGenerator gen, SerializerProvider provider)
      throws IOException
    {
      int len = value.length;
      if ((len == 1) && (
        ((_unwrapSingle == null) && (provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
      {
        serializeContents(value, gen, provider);
        return;
      }
      gen.writeStartArray(len);
      serializeContents(value, gen, provider);
      gen.writeEndArray();
    }
    
    public void serializeContents(double[] value, JsonGenerator gen, SerializerProvider provider)
      throws IOException
    {
      int i = 0;
      for (int len = value.length; i < len; i++) {
        gen.writeNumber(value[i]);
      }
    }
    
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
      return createSchemaNode("array", true).set("items", createSchemaNode("number"));
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
      throws JsonMappingException
    {
      if (visitor != null)
      {
        JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint);
        if (v2 != null) {
          v2.itemsFormat(JsonFormatTypes.NUMBER);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdArraySerializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */