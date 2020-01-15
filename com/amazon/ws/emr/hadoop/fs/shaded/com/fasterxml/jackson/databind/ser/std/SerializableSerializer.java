package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

@JacksonStdImpl
public class SerializableSerializer
  extends StdSerializer<JsonSerializable>
{
  public static final SerializableSerializer instance = new SerializableSerializer();
  private static final AtomicReference<ObjectMapper> _mapperReference = new AtomicReference();
  
  protected SerializableSerializer()
  {
    super(JsonSerializable.class);
  }
  
  public boolean isEmpty(SerializerProvider serializers, JsonSerializable value)
  {
    if ((value instanceof JsonSerializable.Base)) {
      return ((JsonSerializable.Base)value).isEmpty(serializers);
    }
    return false;
  }
  
  public void serialize(JsonSerializable value, JsonGenerator gen, SerializerProvider serializers)
    throws IOException
  {
    value.serialize(gen, serializers);
  }
  
  public final void serializeWithType(JsonSerializable value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer)
    throws IOException
  {
    value.serializeWithType(gen, serializers, typeSer);
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    throws JsonMappingException
  {
    ObjectNode objectNode = createObjectNode();
    String schemaType = "any";
    String objectProperties = null;
    String itemDefinition = null;
    if (typeHint != null)
    {
      Class<?> rawClass = TypeFactory.rawClass(typeHint);
      if (rawClass.isAnnotationPresent(JsonSerializableSchema.class))
      {
        JsonSerializableSchema schemaInfo = (JsonSerializableSchema)rawClass.getAnnotation(JsonSerializableSchema.class);
        schemaType = schemaInfo.schemaType();
        if (!"##irrelevant".equals(schemaInfo.schemaObjectPropertiesDefinition())) {
          objectProperties = schemaInfo.schemaObjectPropertiesDefinition();
        }
        if (!"##irrelevant".equals(schemaInfo.schemaItemDefinition())) {
          itemDefinition = schemaInfo.schemaItemDefinition();
        }
      }
    }
    objectNode.put("type", schemaType);
    if (objectProperties != null) {
      try
      {
        objectNode.set("properties", _getObjectMapper().readTree(objectProperties));
      }
      catch (IOException e)
      {
        throw new JsonMappingException("Failed to parse @JsonSerializableSchema.schemaObjectPropertiesDefinition value");
      }
    }
    if (itemDefinition != null) {
      try
      {
        objectNode.set("items", _getObjectMapper().readTree(itemDefinition));
      }
      catch (IOException e)
      {
        throw new JsonMappingException("Failed to parse @JsonSerializableSchema.schemaItemDefinition value");
      }
    }
    return objectNode;
  }
  
  private static final synchronized ObjectMapper _getObjectMapper()
  {
    ObjectMapper mapper = (ObjectMapper)_mapperReference.get();
    if (mapper == null)
    {
      mapper = new ObjectMapper();
      _mapperReference.set(mapper);
    }
    return mapper;
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    visitor.expectAnyFormat(typeHint);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.SerializableSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */