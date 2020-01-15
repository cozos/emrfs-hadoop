package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer.None;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.Annotated;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DefaultSerializerProvider
  extends SerializerProvider
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected transient Map<Object, WritableObjectId> _seenObjectIds;
  protected transient ArrayList<ObjectIdGenerator<?>> _objectIdGenerators;
  
  protected DefaultSerializerProvider() {}
  
  protected DefaultSerializerProvider(SerializerProvider src, SerializationConfig config, SerializerFactory f)
  {
    super(src, config, f);
  }
  
  protected DefaultSerializerProvider(DefaultSerializerProvider src)
  {
    super(src);
  }
  
  public DefaultSerializerProvider copy()
  {
    throw new IllegalStateException("DefaultSerializerProvider sub-class not overriding copy()");
  }
  
  public abstract DefaultSerializerProvider createInstance(SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory);
  
  public void serializeValue(JsonGenerator gen, Object value)
    throws IOException
  {
    if (value == null)
    {
      _serializeNull(gen);
      return;
    }
    Class<?> cls = value.getClass();
    
    JsonSerializer<Object> ser = findTypedValueSerializer(cls, true, null);
    
    PropertyName rootName = _config.getFullRootName();
    boolean wrap;
    if (rootName == null)
    {
      boolean wrap = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
      if (wrap)
      {
        gen.writeStartObject();
        PropertyName pname = _config.findRootName(value.getClass());
        gen.writeFieldName(pname.simpleAsEncoded(_config));
      }
    }
    else
    {
      boolean wrap;
      if (rootName.isEmpty())
      {
        wrap = false;
      }
      else
      {
        wrap = true;
        gen.writeStartObject();
        gen.writeFieldName(rootName.getSimpleName());
      }
    }
    try
    {
      ser.serialize(value, gen, this);
      if (wrap) {
        gen.writeEndObject();
      }
    }
    catch (IOException ioe)
    {
      throw ioe;
    }
    catch (Exception e)
    {
      String msg = e.getMessage();
      if (msg == null) {
        msg = "[no message for " + e.getClass().getName() + "]";
      }
      throw new JsonMappingException(msg, e);
    }
  }
  
  public void serializeValue(JsonGenerator gen, Object value, JavaType rootType)
    throws IOException
  {
    if (value == null)
    {
      _serializeNull(gen);
      return;
    }
    if (!rootType.getRawClass().isAssignableFrom(value.getClass())) {
      _reportIncompatibleRootType(value, rootType);
    }
    JsonSerializer<Object> ser = findTypedValueSerializer(rootType, true, null);
    
    PropertyName rootName = _config.getFullRootName();
    boolean wrap;
    if (rootName == null)
    {
      boolean wrap = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
      if (wrap)
      {
        gen.writeStartObject();
        PropertyName pname = _config.findRootName(value.getClass());
        gen.writeFieldName(pname.simpleAsEncoded(_config));
      }
    }
    else
    {
      boolean wrap;
      if (rootName.isEmpty())
      {
        wrap = false;
      }
      else
      {
        wrap = true;
        gen.writeStartObject();
        gen.writeFieldName(rootName.getSimpleName());
      }
    }
    try
    {
      ser.serialize(value, gen, this);
      if (wrap) {
        gen.writeEndObject();
      }
    }
    catch (IOException ioe)
    {
      throw ioe;
    }
    catch (Exception e)
    {
      String msg = e.getMessage();
      if (msg == null) {
        msg = "[no message for " + e.getClass().getName() + "]";
      }
      throw new JsonMappingException(msg, e);
    }
  }
  
  public void serializeValue(JsonGenerator gen, Object value, JavaType rootType, JsonSerializer<Object> ser)
    throws IOException
  {
    if (value == null)
    {
      _serializeNull(gen);
      return;
    }
    if ((rootType != null) && (!rootType.getRawClass().isAssignableFrom(value.getClass()))) {
      _reportIncompatibleRootType(value, rootType);
    }
    if (ser == null) {
      ser = findTypedValueSerializer(rootType, true, null);
    }
    PropertyName rootName = _config.getFullRootName();
    boolean wrap;
    if (rootName == null)
    {
      boolean wrap = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
      if (wrap)
      {
        gen.writeStartObject();
        PropertyName pname = rootType == null ? _config.findRootName(value.getClass()) : _config.findRootName(rootType);
        
        gen.writeFieldName(pname.simpleAsEncoded(_config));
      }
    }
    else
    {
      boolean wrap;
      if (rootName.isEmpty())
      {
        wrap = false;
      }
      else
      {
        wrap = true;
        gen.writeStartObject();
        gen.writeFieldName(rootName.getSimpleName());
      }
    }
    try
    {
      ser.serialize(value, gen, this);
      if (wrap) {
        gen.writeEndObject();
      }
    }
    catch (IOException ioe)
    {
      throw ioe;
    }
    catch (Exception e)
    {
      String msg = e.getMessage();
      if (msg == null) {
        msg = "[no message for " + e.getClass().getName() + "]";
      }
      throw new JsonMappingException(msg, e);
    }
  }
  
  public void serializePolymorphic(JsonGenerator gen, Object value, JavaType rootType, JsonSerializer<Object> valueSer, TypeSerializer typeSer)
    throws IOException
  {
    if (value == null)
    {
      _serializeNull(gen);
      return;
    }
    if ((rootType != null) && (!rootType.getRawClass().isAssignableFrom(value.getClass()))) {
      _reportIncompatibleRootType(value, rootType);
    }
    if (valueSer == null) {
      if ((rootType != null) && (rootType.isContainerType())) {
        valueSer = findValueSerializer(rootType, null);
      } else {
        valueSer = findValueSerializer(value.getClass(), null);
      }
    }
    PropertyName rootName = _config.getFullRootName();
    boolean wrap;
    if (rootName == null)
    {
      boolean wrap = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
      if (wrap)
      {
        gen.writeStartObject();
        PropertyName pname = _config.findRootName(value.getClass());
        gen.writeFieldName(pname.simpleAsEncoded(_config));
      }
    }
    else
    {
      boolean wrap;
      if (rootName.isEmpty())
      {
        wrap = false;
      }
      else
      {
        wrap = true;
        gen.writeStartObject();
        gen.writeFieldName(rootName.getSimpleName());
      }
    }
    try
    {
      valueSer.serializeWithType(value, gen, this, typeSer);
      if (wrap) {
        gen.writeEndObject();
      }
    }
    catch (IOException ioe)
    {
      throw ioe;
    }
    catch (Exception e)
    {
      String msg = e.getMessage();
      if (msg == null) {
        msg = "[no message for " + e.getClass().getName() + "]";
      }
      throw new JsonMappingException(msg, e);
    }
  }
  
  @Deprecated
  public void serializePolymorphic(JsonGenerator gen, Object value, TypeSerializer typeSer)
    throws IOException
  {
    JavaType t = value == null ? null : _config.constructType(value.getClass());
    serializePolymorphic(gen, value, t, null, typeSer);
  }
  
  protected void _serializeNull(JsonGenerator gen)
    throws IOException
  {
    JsonSerializer<Object> ser = getDefaultNullValueSerializer();
    try
    {
      ser.serialize(null, gen, this);
    }
    catch (IOException ioe)
    {
      throw ioe;
    }
    catch (Exception e)
    {
      String msg = e.getMessage();
      if (msg == null) {
        msg = "[no message for " + e.getClass().getName() + "]";
      }
      throw new JsonMappingException(msg, e);
    }
  }
  
  @Deprecated
  public JsonSchema generateJsonSchema(Class<?> type)
    throws JsonMappingException
  {
    if (type == null) {
      throw new IllegalArgumentException("A class must be provided");
    }
    JsonSerializer<Object> ser = findValueSerializer(type, null);
    JsonNode schemaNode = (ser instanceof SchemaAware) ? ((SchemaAware)ser).getSchema(this, null) : JsonSchema.getDefaultSchemaNode();
    if (!(schemaNode instanceof ObjectNode)) {
      throw new IllegalArgumentException("Class " + type.getName() + " would not be serialized as a JSON object and therefore has no schema");
    }
    return new JsonSchema((ObjectNode)schemaNode);
  }
  
  public void acceptJsonFormatVisitor(JavaType javaType, JsonFormatVisitorWrapper visitor)
    throws JsonMappingException
  {
    if (javaType == null) {
      throw new IllegalArgumentException("A class must be provided");
    }
    visitor.setProvider(this);
    findValueSerializer(javaType, null).acceptJsonFormatVisitor(visitor, javaType);
  }
  
  public boolean hasSerializerFor(Class<?> cls, AtomicReference<Throwable> cause)
  {
    try
    {
      JsonSerializer<?> ser = _findExplicitUntypedSerializer(cls);
      return ser != null;
    }
    catch (JsonMappingException e)
    {
      if (cause != null) {
        cause.set(e);
      }
    }
    catch (RuntimeException e)
    {
      if (cause == null) {
        throw e;
      }
      cause.set(e);
    }
    return false;
  }
  
  public int cachedSerializersCount()
  {
    return _serializerCache.size();
  }
  
  public void flushCachedSerializers()
  {
    _serializerCache.flush();
  }
  
  public WritableObjectId findObjectId(Object forPojo, ObjectIdGenerator<?> generatorType)
  {
    if (_seenObjectIds == null)
    {
      _seenObjectIds = _createObjectIdMap();
    }
    else
    {
      WritableObjectId oid = (WritableObjectId)_seenObjectIds.get(forPojo);
      if (oid != null) {
        return oid;
      }
    }
    ObjectIdGenerator<?> generator = null;
    if (_objectIdGenerators == null)
    {
      _objectIdGenerators = new ArrayList(8);
    }
    else
    {
      int i = 0;
      for (int len = _objectIdGenerators.size(); i < len; i++)
      {
        ObjectIdGenerator<?> gen = (ObjectIdGenerator)_objectIdGenerators.get(i);
        if (gen.canUseFor(generatorType))
        {
          generator = gen;
          break;
        }
      }
    }
    if (generator == null)
    {
      generator = generatorType.newForSerialization(this);
      _objectIdGenerators.add(generator);
    }
    WritableObjectId oid = new WritableObjectId(generator);
    _seenObjectIds.put(forPojo, oid);
    return oid;
  }
  
  protected Map<Object, WritableObjectId> _createObjectIdMap()
  {
    if (isEnabled(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID)) {
      return new HashMap();
    }
    return new IdentityHashMap();
  }
  
  public JsonSerializer<Object> serializerInstance(Annotated annotated, Object serDef)
    throws JsonMappingException
  {
    if (serDef == null) {
      return null;
    }
    JsonSerializer<?> ser;
    JsonSerializer<?> ser;
    if ((serDef instanceof JsonSerializer))
    {
      ser = (JsonSerializer)serDef;
    }
    else
    {
      if (!(serDef instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector returned serializer definition of type " + serDef.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
      }
      Class<?> serClass = (Class)serDef;
      if ((serClass == JsonSerializer.None.class) || (ClassUtil.isBogusClass(serClass))) {
        return null;
      }
      if (!JsonSerializer.class.isAssignableFrom(serClass)) {
        throw new IllegalStateException("AnnotationIntrospector returned Class " + serClass.getName() + "; expected Class<JsonSerializer>");
      }
      HandlerInstantiator hi = _config.getHandlerInstantiator();
      ser = hi == null ? null : hi.serializerInstance(_config, annotated, serClass);
      if (ser == null) {
        ser = (JsonSerializer)ClassUtil.createInstance(serClass, _config.canOverrideAccessModifiers());
      }
    }
    return _handleResolvable(ser);
  }
  
  public static final class Impl
    extends DefaultSerializerProvider
  {
    private static final long serialVersionUID = 1L;
    
    public Impl() {}
    
    public Impl(Impl src)
    {
      super();
    }
    
    protected Impl(SerializerProvider src, SerializationConfig config, SerializerFactory f)
    {
      super(config, f);
    }
    
    public DefaultSerializerProvider copy()
    {
      if (getClass() != Impl.class) {
        return super.copy();
      }
      return new Impl(this);
    }
    
    public Impl createInstance(SerializationConfig config, SerializerFactory jsf)
    {
      return new Impl(this, config, jsf);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.DefaultSerializerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */