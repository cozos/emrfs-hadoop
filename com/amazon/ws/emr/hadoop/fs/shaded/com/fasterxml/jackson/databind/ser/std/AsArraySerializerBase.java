package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import java.io.IOException;
import java.lang.reflect.Type;

public abstract class AsArraySerializerBase<T>
  extends ContainerSerializer<T>
  implements ContextualSerializer
{
  protected final JavaType _elementType;
  protected final BeanProperty _property;
  protected final boolean _staticTyping;
  protected final Boolean _unwrapSingle;
  protected final TypeSerializer _valueTypeSerializer;
  protected final JsonSerializer<Object> _elementSerializer;
  protected PropertySerializerMap _dynamicSerializers;
  
  protected AsArraySerializerBase(Class<?> cls, JavaType et, boolean staticTyping, TypeSerializer vts, JsonSerializer<Object> elementSerializer)
  {
    super(cls, false);
    _elementType = et;
    
    _staticTyping = ((staticTyping) || ((et != null) && (et.isFinal())));
    _valueTypeSerializer = vts;
    _property = null;
    _elementSerializer = elementSerializer;
    _dynamicSerializers = PropertySerializerMap.emptyForProperties();
    _unwrapSingle = null;
  }
  
  @Deprecated
  protected AsArraySerializerBase(Class<?> cls, JavaType et, boolean staticTyping, TypeSerializer vts, BeanProperty property, JsonSerializer<Object> elementSerializer)
  {
    super(cls, false);
    _elementType = et;
    
    _staticTyping = ((staticTyping) || ((et != null) && (et.isFinal())));
    _valueTypeSerializer = vts;
    _property = property;
    _elementSerializer = elementSerializer;
    _dynamicSerializers = PropertySerializerMap.emptyForProperties();
    _unwrapSingle = null;
  }
  
  protected AsArraySerializerBase(AsArraySerializerBase<?> src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> elementSerializer, Boolean unwrapSingle)
  {
    super(src);
    _elementType = _elementType;
    _staticTyping = _staticTyping;
    _valueTypeSerializer = vts;
    _property = property;
    _elementSerializer = elementSerializer;
    _dynamicSerializers = _dynamicSerializers;
    _unwrapSingle = unwrapSingle;
  }
  
  @Deprecated
  protected AsArraySerializerBase(AsArraySerializerBase<?> src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> elementSerializer)
  {
    this(src, property, vts, elementSerializer, _unwrapSingle);
  }
  
  @Deprecated
  public final AsArraySerializerBase<T> withResolved(BeanProperty property, TypeSerializer vts, JsonSerializer<?> elementSerializer)
  {
    return withResolved(property, vts, elementSerializer, _unwrapSingle);
  }
  
  public abstract AsArraySerializerBase<T> withResolved(BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer, Boolean paramBoolean);
  
  public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    TypeSerializer typeSer = _valueTypeSerializer;
    if (typeSer != null) {
      typeSer = typeSer.forProperty(property);
    }
    JsonSerializer<?> ser = null;
    Boolean unwrapSingle = null;
    if (property != null)
    {
      AnnotationIntrospector intr = provider.getAnnotationIntrospector();
      AnnotatedMember m = property.getMember();
      if (m != null)
      {
        Object serDef = intr.findContentSerializer(m);
        if (serDef != null) {
          ser = provider.serializerInstance(m, serDef);
        }
      }
      JsonFormat.Value format = property.findFormatOverrides(intr);
      if (format != null) {
        unwrapSingle = format.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
      }
    }
    if (ser == null) {
      ser = _elementSerializer;
    }
    ser = findConvertingContentSerializer(provider, property, ser);
    if (ser == null)
    {
      if (_elementType != null) {
        if (((_staticTyping) && (_elementType.getRawClass() != Object.class)) || (hasContentTypeAnnotation(provider, property))) {
          ser = provider.findValueSerializer(_elementType, property);
        }
      }
    }
    else {
      ser = provider.handleSecondaryContextualization(ser, property);
    }
    if ((ser != _elementSerializer) || (property != _property) || (_valueTypeSerializer != typeSer) || (_unwrapSingle != unwrapSingle)) {
      return withResolved(property, typeSer, ser, unwrapSingle);
    }
    return this;
  }
  
  public JavaType getContentType()
  {
    return _elementType;
  }
  
  public JsonSerializer<?> getContentSerializer()
  {
    return _elementSerializer;
  }
  
  public void serialize(T value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    if ((provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && (hasSingleElement(value)))
    {
      serializeContents(value, gen, provider);
      return;
    }
    gen.writeStartArray();
    
    gen.setCurrentValue(value);
    serializeContents(value, gen, provider);
    gen.writeEndArray();
  }
  
  public void serializeWithType(T value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    typeSer.writeTypePrefixForArray(value, gen);
    
    gen.setCurrentValue(value);
    serializeContents(value, gen, provider);
    typeSer.writeTypeSuffixForArray(value, gen);
  }
  
  protected abstract void serializeContents(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException;
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    throws JsonMappingException
  {
    ObjectNode o = createSchemaNode("array", true);
    JavaType contentType = _elementType;
    if (contentType != null)
    {
      JsonNode schemaNode = null;
      if (contentType.getRawClass() != Object.class)
      {
        JsonSerializer<Object> ser = provider.findValueSerializer(contentType, _property);
        if ((ser instanceof SchemaAware)) {
          schemaNode = ((SchemaAware)ser).getSchema(provider, null);
        }
      }
      if (schemaNode == null) {
        schemaNode = JsonSchema.getDefaultSchemaNode();
      }
      o.set("items", schemaNode);
    }
    return o;
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    JsonArrayFormatVisitor arrayVisitor = visitor == null ? null : visitor.expectArrayFormat(typeHint);
    if (arrayVisitor != null)
    {
      JsonSerializer<?> valueSer = _elementSerializer;
      if (valueSer == null) {
        valueSer = visitor.getProvider().findValueSerializer(_elementType, _property);
      }
      arrayVisitor.itemsFormat(valueSer, _elementType);
    }
  }
  
  protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap map, Class<?> type, SerializerProvider provider)
    throws JsonMappingException
  {
    PropertySerializerMap.SerializerAndMapResult result = map.findAndAddSecondarySerializer(type, provider, _property);
    if (map != map) {
      _dynamicSerializers = map;
    }
    return serializer;
  }
  
  protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap map, JavaType type, SerializerProvider provider)
    throws JsonMappingException
  {
    PropertySerializerMap.SerializerAndMapResult result = map.findAndAddSecondarySerializer(type, provider, _property);
    if (map != map) {
      _dynamicSerializers = map;
    }
    return serializer;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */