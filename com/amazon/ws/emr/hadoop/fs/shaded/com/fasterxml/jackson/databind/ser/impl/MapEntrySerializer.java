package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

@JacksonStdImpl
public class MapEntrySerializer
  extends ContainerSerializer<Map.Entry<?, ?>>
  implements ContextualSerializer
{
  protected final BeanProperty _property;
  protected final boolean _valueTypeIsStatic;
  protected final JavaType _entryType;
  protected final JavaType _keyType;
  protected final JavaType _valueType;
  protected JsonSerializer<Object> _keySerializer;
  protected JsonSerializer<Object> _valueSerializer;
  protected final TypeSerializer _valueTypeSerializer;
  protected PropertySerializerMap _dynamicValueSerializers;
  
  public MapEntrySerializer(JavaType type, JavaType keyType, JavaType valueType, boolean staticTyping, TypeSerializer vts, BeanProperty property)
  {
    super(type);
    _entryType = type;
    _keyType = keyType;
    _valueType = valueType;
    _valueTypeIsStatic = staticTyping;
    _valueTypeSerializer = vts;
    _property = property;
    _dynamicValueSerializers = PropertySerializerMap.emptyForProperties();
  }
  
  protected MapEntrySerializer(MapEntrySerializer src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> keySer, JsonSerializer<?> valueSer)
  {
    super(Map.class, false);
    _entryType = _entryType;
    _keyType = _keyType;
    _valueType = _valueType;
    _valueTypeIsStatic = _valueTypeIsStatic;
    _valueTypeSerializer = _valueTypeSerializer;
    _keySerializer = keySer;
    _valueSerializer = valueSer;
    _dynamicValueSerializers = _dynamicValueSerializers;
    _property = _property;
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
  {
    return new MapEntrySerializer(this, _property, vts, _keySerializer, _valueSerializer);
  }
  
  public MapEntrySerializer withResolved(BeanProperty property, JsonSerializer<?> keySerializer, JsonSerializer<?> valueSerializer)
  {
    return new MapEntrySerializer(this, property, _valueTypeSerializer, keySerializer, valueSerializer);
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<?> ser = null;
    JsonSerializer<?> keySer = null;
    AnnotationIntrospector intr = provider.getAnnotationIntrospector();
    AnnotatedMember propertyAcc = property == null ? null : property.getMember();
    if ((propertyAcc != null) && (intr != null))
    {
      Object serDef = intr.findKeySerializer(propertyAcc);
      if (serDef != null) {
        keySer = provider.serializerInstance(propertyAcc, serDef);
      }
      serDef = intr.findContentSerializer(propertyAcc);
      if (serDef != null) {
        ser = provider.serializerInstance(propertyAcc, serDef);
      }
    }
    if (ser == null) {
      ser = _valueSerializer;
    }
    ser = findConvertingContentSerializer(provider, property, ser);
    if (ser == null)
    {
      if (((_valueTypeIsStatic) && (_valueType.getRawClass() != Object.class)) || (hasContentTypeAnnotation(provider, property))) {
        ser = provider.findValueSerializer(_valueType, property);
      }
    }
    else {
      ser = provider.handleSecondaryContextualization(ser, property);
    }
    if (keySer == null) {
      keySer = _keySerializer;
    }
    if (keySer == null) {
      keySer = provider.findKeySerializer(_keyType, property);
    } else {
      keySer = provider.handleSecondaryContextualization(keySer, property);
    }
    MapEntrySerializer mser = withResolved(property, keySer, ser);
    
    return mser;
  }
  
  public JavaType getContentType()
  {
    return _valueType;
  }
  
  public JsonSerializer<?> getContentSerializer()
  {
    return _valueSerializer;
  }
  
  public boolean hasSingleElement(Map.Entry<?, ?> value)
  {
    return true;
  }
  
  public boolean isEmpty(SerializerProvider prov, Map.Entry<?, ?> value)
  {
    return value == null;
  }
  
  public void serialize(Map.Entry<?, ?> value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    gen.writeStartObject();
    
    gen.setCurrentValue(value);
    if (_valueSerializer != null) {
      serializeUsing(value, gen, provider, _valueSerializer);
    } else {
      serializeDynamic(value, gen, provider);
    }
    gen.writeEndObject();
  }
  
  public void serializeWithType(Map.Entry<?, ?> value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    typeSer.writeTypePrefixForObject(value, gen);
    
    gen.setCurrentValue(value);
    if (_valueSerializer != null) {
      serializeUsing(value, gen, provider, _valueSerializer);
    } else {
      serializeDynamic(value, gen, provider);
    }
    typeSer.writeTypeSuffixForObject(value, gen);
  }
  
  protected void serializeDynamic(Map.Entry<?, ?> value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    JsonSerializer<Object> keySerializer = _keySerializer;
    boolean skipNulls = !provider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES);
    TypeSerializer vts = _valueTypeSerializer;
    
    PropertySerializerMap serializers = _dynamicValueSerializers;
    
    Object valueElem = value.getValue();
    Object keyElem = value.getKey();
    if (keyElem == null)
    {
      provider.findNullKeySerializer(_keyType, _property).serialize(null, jgen, provider);
    }
    else
    {
      if ((skipNulls) && (valueElem == null)) {
        return;
      }
      keySerializer.serialize(keyElem, jgen, provider);
    }
    if (valueElem == null)
    {
      provider.defaultSerializeNull(jgen);
    }
    else
    {
      Class<?> cc = valueElem.getClass();
      JsonSerializer<Object> ser = serializers.serializerFor(cc);
      if (ser == null)
      {
        if (_valueType.hasGenericTypes()) {
          ser = _findAndAddDynamic(serializers, provider.constructSpecializedType(_valueType, cc), provider);
        } else {
          ser = _findAndAddDynamic(serializers, cc, provider);
        }
        serializers = _dynamicValueSerializers;
      }
      try
      {
        if (vts == null) {
          ser.serialize(valueElem, jgen, provider);
        } else {
          ser.serializeWithType(valueElem, jgen, provider, vts);
        }
      }
      catch (Exception e)
      {
        String keyDesc = "" + keyElem;
        wrapAndThrow(provider, e, value, keyDesc);
      }
    }
  }
  
  protected void serializeUsing(Map.Entry<?, ?> value, JsonGenerator jgen, SerializerProvider provider, JsonSerializer<Object> ser)
    throws IOException, JsonGenerationException
  {
    JsonSerializer<Object> keySerializer = _keySerializer;
    TypeSerializer vts = _valueTypeSerializer;
    boolean skipNulls = !provider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES);
    
    Object valueElem = value.getValue();
    Object keyElem = value.getKey();
    if (keyElem == null)
    {
      provider.findNullKeySerializer(_keyType, _property).serialize(null, jgen, provider);
    }
    else
    {
      if ((skipNulls) && (valueElem == null)) {
        return;
      }
      keySerializer.serialize(keyElem, jgen, provider);
    }
    if (valueElem == null) {
      provider.defaultSerializeNull(jgen);
    } else {
      try
      {
        if (vts == null) {
          ser.serialize(valueElem, jgen, provider);
        } else {
          ser.serializeWithType(valueElem, jgen, provider, vts);
        }
      }
      catch (Exception e)
      {
        String keyDesc = "" + keyElem;
        wrapAndThrow(provider, e, value, keyDesc);
      }
    }
  }
  
  protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap map, Class<?> type, SerializerProvider provider)
    throws JsonMappingException
  {
    PropertySerializerMap.SerializerAndMapResult result = map.findAndAddSecondarySerializer(type, provider, _property);
    if (map != map) {
      _dynamicValueSerializers = map;
    }
    return serializer;
  }
  
  protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap map, JavaType type, SerializerProvider provider)
    throws JsonMappingException
  {
    PropertySerializerMap.SerializerAndMapResult result = map.findAndAddSecondarySerializer(type, provider, _property);
    if (map != map) {
      _dynamicValueSerializers = map;
    }
    return serializer;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */