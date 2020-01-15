package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.EnumValues;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.Map.Entry;

@JacksonStdImpl
@Deprecated
public class EnumMapSerializer
  extends ContainerSerializer<EnumMap<? extends Enum<?>, ?>>
  implements ContextualSerializer
{
  protected final boolean _staticTyping;
  protected final BeanProperty _property;
  protected final EnumValues _keyEnums;
  protected final JavaType _valueType;
  protected final JsonSerializer<Object> _valueSerializer;
  protected final TypeSerializer _valueTypeSerializer;
  
  public EnumMapSerializer(JavaType valueType, boolean staticTyping, EnumValues keyEnums, TypeSerializer vts, JsonSerializer<Object> valueSerializer)
  {
    super(EnumMap.class, false);
    _property = null;
    _staticTyping = ((staticTyping) || ((valueType != null) && (valueType.isFinal())));
    _valueType = valueType;
    _keyEnums = keyEnums;
    _valueTypeSerializer = vts;
    _valueSerializer = valueSerializer;
  }
  
  public EnumMapSerializer(EnumMapSerializer src, BeanProperty property, JsonSerializer<?> ser)
  {
    super(src);
    _property = property;
    _staticTyping = _staticTyping;
    _valueType = _valueType;
    _keyEnums = _keyEnums;
    _valueTypeSerializer = _valueTypeSerializer;
    _valueSerializer = ser;
  }
  
  public EnumMapSerializer _withValueTypeSerializer(TypeSerializer vts)
  {
    return new EnumMapSerializer(_valueType, _staticTyping, _keyEnums, vts, _valueSerializer);
  }
  
  public EnumMapSerializer withValueSerializer(BeanProperty prop, JsonSerializer<?> ser)
  {
    if ((_property == prop) && (ser == _valueSerializer)) {
      return this;
    }
    return new EnumMapSerializer(this, prop, ser);
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<?> ser = null;
    if (property != null)
    {
      AnnotatedMember m = property.getMember();
      if (m != null)
      {
        Object serDef = provider.getAnnotationIntrospector().findContentSerializer(m);
        if (serDef != null) {
          ser = provider.serializerInstance(m, serDef);
        }
      }
    }
    if (ser == null) {
      ser = _valueSerializer;
    }
    ser = findConvertingContentSerializer(provider, property, ser);
    if (ser == null)
    {
      if (_staticTyping) {
        return withValueSerializer(property, provider.findValueSerializer(_valueType, property));
      }
    }
    else {
      ser = provider.handleSecondaryContextualization(ser, property);
    }
    if (ser != _valueSerializer) {
      return withValueSerializer(property, ser);
    }
    return this;
  }
  
  public JavaType getContentType()
  {
    return _valueType;
  }
  
  public JsonSerializer<?> getContentSerializer()
  {
    return _valueSerializer;
  }
  
  public boolean isEmpty(SerializerProvider prov, EnumMap<? extends Enum<?>, ?> value)
  {
    return (value == null) || (value.isEmpty());
  }
  
  public boolean hasSingleElement(EnumMap<? extends Enum<?>, ?> value)
  {
    return value.size() == 1;
  }
  
  public void serialize(EnumMap<? extends Enum<?>, ?> value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    jgen.writeStartObject();
    if (!value.isEmpty()) {
      serializeContents(value, jgen, provider);
    }
    jgen.writeEndObject();
  }
  
  public void serializeWithType(EnumMap<? extends Enum<?>, ?> value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException, JsonGenerationException
  {
    typeSer.writeTypePrefixForObject(value, jgen);
    if (!value.isEmpty()) {
      serializeContents(value, jgen, provider);
    }
    typeSer.writeTypeSuffixForObject(value, jgen);
  }
  
  protected void serializeContents(EnumMap<? extends Enum<?>, ?> value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    if (_valueSerializer != null)
    {
      serializeContentsUsing(value, jgen, provider, _valueSerializer);
      return;
    }
    JsonSerializer<Object> prevSerializer = null;
    Class<?> prevClass = null;
    EnumValues keyEnums = _keyEnums;
    boolean skipNulls = !provider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES);
    boolean useToString = provider.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    TypeSerializer vts = _valueTypeSerializer;
    for (Map.Entry<? extends Enum<?>, ?> entry : value.entrySet())
    {
      Object valueElem = entry.getValue();
      if ((!skipNulls) || (valueElem != null))
      {
        Enum<?> key = (Enum)entry.getKey();
        if (useToString)
        {
          jgen.writeFieldName(key.toString());
        }
        else
        {
          if (keyEnums == null)
          {
            StdSerializer<?> ser = (StdSerializer)provider.findValueSerializer(key.getDeclaringClass(), _property);
            
            keyEnums = ((EnumSerializer)ser).getEnumValues();
          }
          jgen.writeFieldName(keyEnums.serializedValueFor(key));
        }
        if (valueElem == null)
        {
          provider.defaultSerializeNull(jgen);
        }
        else
        {
          Class<?> cc = valueElem.getClass();
          JsonSerializer<Object> currSerializer;
          JsonSerializer<Object> currSerializer;
          if (cc == prevClass)
          {
            currSerializer = prevSerializer;
          }
          else
          {
            currSerializer = provider.findValueSerializer(cc, _property);
            prevSerializer = currSerializer;
            prevClass = cc;
          }
          try
          {
            if (vts == null) {
              currSerializer.serialize(valueElem, jgen, provider);
            } else {
              currSerializer.serializeWithType(valueElem, jgen, provider, vts);
            }
          }
          catch (Exception e)
          {
            wrapAndThrow(provider, e, value, ((Enum)entry.getKey()).name());
          }
        }
      }
    }
  }
  
  protected void serializeContentsUsing(EnumMap<? extends Enum<?>, ?> value, JsonGenerator jgen, SerializerProvider provider, JsonSerializer<Object> valueSer)
    throws IOException, JsonGenerationException
  {
    EnumValues keyEnums = _keyEnums;
    boolean skipNulls = !provider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES);
    boolean useToString = provider.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    TypeSerializer vts = _valueTypeSerializer;
    for (Map.Entry<? extends Enum<?>, ?> entry : value.entrySet())
    {
      Object valueElem = entry.getValue();
      if ((!skipNulls) || (valueElem != null))
      {
        Enum<?> key = (Enum)entry.getKey();
        if (useToString)
        {
          jgen.writeFieldName(key.toString());
        }
        else
        {
          if (keyEnums == null)
          {
            StdSerializer<?> ser = (StdSerializer)provider.findValueSerializer(key.getDeclaringClass(), _property);
            
            keyEnums = ((EnumSerializer)ser).getEnumValues();
          }
          jgen.writeFieldName(keyEnums.serializedValueFor(key));
        }
        if (valueElem == null) {
          provider.defaultSerializeNull(jgen);
        } else {
          try
          {
            if (vts == null) {
              valueSer.serialize(valueElem, jgen, provider);
            } else {
              valueSer.serializeWithType(valueElem, jgen, provider, vts);
            }
          }
          catch (Exception e)
          {
            wrapAndThrow(provider, e, value, ((Enum)entry.getKey()).name());
          }
        }
      }
    }
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    throws JsonMappingException
  {
    ObjectNode o = createSchemaNode("object", true);
    if ((typeHint instanceof ParameterizedType))
    {
      Type[] typeArgs = ((ParameterizedType)typeHint).getActualTypeArguments();
      if (typeArgs.length == 2)
      {
        JavaType enumType = provider.constructType(typeArgs[0]);
        JavaType valueType = provider.constructType(typeArgs[1]);
        ObjectNode propsNode = JsonNodeFactory.instance.objectNode();
        Class<Enum<?>> enumClass = enumType.getRawClass();
        for (Enum<?> enumValue : (Enum[])enumClass.getEnumConstants())
        {
          JsonSerializer<Object> ser = provider.findValueSerializer(valueType.getRawClass(), _property);
          JsonNode schemaNode = (ser instanceof SchemaAware) ? ((SchemaAware)ser).getSchema(provider, null) : JsonSchema.getDefaultSchemaNode();
          
          propsNode.set(provider.getConfig().getAnnotationIntrospector().findEnumValue(enumValue), schemaNode);
        }
        o.set("properties", propsNode);
      }
    }
    return o;
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    if (visitor == null) {
      return;
    }
    JsonObjectFormatVisitor objectVisitor = visitor.expectObjectFormat(typeHint);
    if (objectVisitor == null) {
      return;
    }
    JavaType valueType = typeHint.containedType(1);
    JsonSerializer<Object> ser = _valueSerializer;
    if ((ser == null) && (valueType != null)) {
      ser = visitor.getProvider().findValueSerializer(valueType, _property);
    }
    if (valueType == null) {
      valueType = visitor.getProvider().constructType(Object.class);
    }
    EnumValues keyEnums = _keyEnums;
    if (keyEnums == null)
    {
      JavaType enumType = typeHint.containedType(0);
      if (enumType == null) {
        throw new IllegalStateException("Can not resolve Enum type of EnumMap: " + typeHint);
      }
      JsonSerializer<?> enumSer = visitor.getProvider().findValueSerializer(enumType, _property);
      if (!(enumSer instanceof EnumSerializer)) {
        throw new IllegalStateException("Can not resolve Enum type of EnumMap: " + typeHint);
      }
      keyEnums = ((EnumSerializer)enumSer).getEnumValues();
    }
    for (Map.Entry<?, SerializableString> entry : keyEnums.internalMap().entrySet())
    {
      String name = ((SerializableString)entry.getValue()).getValue();
      if (ser == null) {
        ser = visitor.getProvider().findValueSerializer(entry.getKey().getClass(), _property);
      }
      objectVisitor.property(name, ser, valueType);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.EnumMapSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */