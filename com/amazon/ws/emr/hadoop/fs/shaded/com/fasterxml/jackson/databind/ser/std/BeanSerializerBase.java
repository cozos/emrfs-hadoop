package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class BeanSerializerBase
  extends StdSerializer<Object>
  implements ContextualSerializer, ResolvableSerializer, JsonFormatVisitable, SchemaAware
{
  protected static final PropertyName NAME_FOR_OBJECT_REF = new PropertyName("#object-ref");
  protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
  protected final BeanPropertyWriter[] _props;
  protected final BeanPropertyWriter[] _filteredProps;
  protected final AnyGetterWriter _anyGetterWriter;
  protected final Object _propertyFilterId;
  protected final AnnotatedMember _typeId;
  protected final ObjectIdWriter _objectIdWriter;
  protected final JsonFormat.Shape _serializationShape;
  
  protected BeanSerializerBase(JavaType type, BeanSerializerBuilder builder, BeanPropertyWriter[] properties, BeanPropertyWriter[] filteredProperties)
  {
    super(type);
    _props = properties;
    _filteredProps = filteredProperties;
    if (builder == null)
    {
      _typeId = null;
      _anyGetterWriter = null;
      _propertyFilterId = null;
      _objectIdWriter = null;
      _serializationShape = null;
    }
    else
    {
      _typeId = builder.getTypeId();
      _anyGetterWriter = builder.getAnyGetter();
      _propertyFilterId = builder.getFilterId();
      _objectIdWriter = builder.getObjectIdWriter();
      JsonFormat.Value format = builder.getBeanDescription().findExpectedFormat(null);
      _serializationShape = (format == null ? null : format.getShape());
    }
  }
  
  public BeanSerializerBase(BeanSerializerBase src, BeanPropertyWriter[] properties, BeanPropertyWriter[] filteredProperties)
  {
    super(_handledType);
    _props = properties;
    _filteredProps = filteredProperties;
    
    _typeId = _typeId;
    _anyGetterWriter = _anyGetterWriter;
    _objectIdWriter = _objectIdWriter;
    _propertyFilterId = _propertyFilterId;
    _serializationShape = _serializationShape;
  }
  
  protected BeanSerializerBase(BeanSerializerBase src, ObjectIdWriter objectIdWriter)
  {
    this(src, objectIdWriter, _propertyFilterId);
  }
  
  protected BeanSerializerBase(BeanSerializerBase src, ObjectIdWriter objectIdWriter, Object filterId)
  {
    super(_handledType);
    _props = _props;
    _filteredProps = _filteredProps;
    
    _typeId = _typeId;
    _anyGetterWriter = _anyGetterWriter;
    _objectIdWriter = objectIdWriter;
    _propertyFilterId = filterId;
    _serializationShape = _serializationShape;
  }
  
  protected BeanSerializerBase(BeanSerializerBase src, String[] toIgnore)
  {
    super(_handledType);
    
    HashSet<String> ignoredSet = ArrayBuilders.arrayToSet(toIgnore);
    BeanPropertyWriter[] propsIn = _props;
    BeanPropertyWriter[] fpropsIn = _filteredProps;
    int len = propsIn.length;
    
    ArrayList<BeanPropertyWriter> propsOut = new ArrayList(len);
    ArrayList<BeanPropertyWriter> fpropsOut = fpropsIn == null ? null : new ArrayList(len);
    for (int i = 0; i < len; i++)
    {
      BeanPropertyWriter bpw = propsIn[i];
      if (!ignoredSet.contains(bpw.getName()))
      {
        propsOut.add(bpw);
        if (fpropsIn != null) {
          fpropsOut.add(fpropsIn[i]);
        }
      }
    }
    _props = ((BeanPropertyWriter[])propsOut.toArray(new BeanPropertyWriter[propsOut.size()]));
    _filteredProps = (fpropsOut == null ? null : (BeanPropertyWriter[])fpropsOut.toArray(new BeanPropertyWriter[fpropsOut.size()]));
    
    _typeId = _typeId;
    _anyGetterWriter = _anyGetterWriter;
    _objectIdWriter = _objectIdWriter;
    _propertyFilterId = _propertyFilterId;
    _serializationShape = _serializationShape;
  }
  
  public abstract BeanSerializerBase withObjectIdWriter(ObjectIdWriter paramObjectIdWriter);
  
  protected abstract BeanSerializerBase withIgnorals(String[] paramArrayOfString);
  
  protected abstract BeanSerializerBase asArraySerializer();
  
  public abstract BeanSerializerBase withFilterId(Object paramObject);
  
  protected BeanSerializerBase(BeanSerializerBase src)
  {
    this(src, _props, _filteredProps);
  }
  
  protected BeanSerializerBase(BeanSerializerBase src, NameTransformer unwrapper)
  {
    this(src, rename(_props, unwrapper), rename(_filteredProps, unwrapper));
  }
  
  private static final BeanPropertyWriter[] rename(BeanPropertyWriter[] props, NameTransformer transformer)
  {
    if ((props == null) || (props.length == 0) || (transformer == null) || (transformer == NameTransformer.NOP)) {
      return props;
    }
    int len = props.length;
    BeanPropertyWriter[] result = new BeanPropertyWriter[len];
    for (int i = 0; i < len; i++)
    {
      BeanPropertyWriter bpw = props[i];
      if (bpw != null) {
        result[i] = bpw.rename(transformer);
      }
    }
    return result;
  }
  
  public void resolve(SerializerProvider provider)
    throws JsonMappingException
  {
    int filteredCount = _filteredProps == null ? 0 : _filteredProps.length;
    int i = 0;
    for (int len = _props.length; i < len; i++)
    {
      BeanPropertyWriter prop = _props[i];
      if ((!prop.willSuppressNulls()) && (!prop.hasNullSerializer()))
      {
        JsonSerializer<Object> nullSer = provider.findNullValueSerializer(prop);
        if (nullSer != null)
        {
          prop.assignNullSerializer(nullSer);
          if (i < filteredCount)
          {
            BeanPropertyWriter w2 = _filteredProps[i];
            if (w2 != null) {
              w2.assignNullSerializer(nullSer);
            }
          }
        }
      }
      if (!prop.hasSerializer())
      {
        JsonSerializer<Object> ser = findConvertingSerializer(provider, prop);
        if (ser == null)
        {
          JavaType type = prop.getSerializationType();
          if (type == null)
          {
            type = provider.constructType(prop.getGenericPropertyType());
            if (!type.isFinal())
            {
              if ((!type.isContainerType()) && (type.containedTypeCount() <= 0)) {
                continue;
              }
              prop.setNonTrivialBaseType(type); continue;
            }
          }
          ser = provider.findValueSerializer(type, prop);
          if (type.isContainerType())
          {
            TypeSerializer typeSer = (TypeSerializer)type.getContentType().getTypeHandler();
            if (typeSer != null) {
              if ((ser instanceof ContainerSerializer))
              {
                JsonSerializer<Object> ser2 = ((ContainerSerializer)ser).withValueTypeSerializer(typeSer);
                ser = ser2;
              }
            }
          }
        }
        prop.assignSerializer(ser);
        if (i < filteredCount)
        {
          BeanPropertyWriter w2 = _filteredProps[i];
          if (w2 != null) {
            w2.assignSerializer(ser);
          }
        }
      }
    }
    if (_anyGetterWriter != null) {
      _anyGetterWriter.resolve(provider);
    }
  }
  
  protected JsonSerializer<Object> findConvertingSerializer(SerializerProvider provider, BeanPropertyWriter prop)
    throws JsonMappingException
  {
    AnnotationIntrospector intr = provider.getAnnotationIntrospector();
    if (intr != null)
    {
      AnnotatedMember m = prop.getMember();
      if (m != null)
      {
        Object convDef = intr.findSerializationConverter(m);
        if (convDef != null)
        {
          Converter<Object, Object> conv = provider.converterInstance(prop.getMember(), convDef);
          JavaType delegateType = conv.getOutputType(provider.getTypeFactory());
          
          JsonSerializer<?> ser = delegateType.isJavaLangObject() ? null : provider.findValueSerializer(delegateType, prop);
          
          return new StdDelegatingSerializer(conv, delegateType, ser);
        }
      }
    }
    return null;
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    AnnotationIntrospector intr = provider.getAnnotationIntrospector();
    AnnotatedMember accessor = (property == null) || (intr == null) ? null : property.getMember();
    
    SerializationConfig config = provider.getConfig();
    
    JsonFormat.Shape shape = null;
    if (accessor != null)
    {
      JsonFormat.Value format = intr.findFormat(accessor);
      if (format != null)
      {
        shape = format.getShape();
        if ((shape != _serializationShape) && 
          (_handledType.isEnum())) {
          switch (shape)
          {
          case STRING: 
          case NUMBER: 
          case NUMBER_INT: 
            BeanDescription desc = config.introspectClassAnnotations(_handledType);
            JsonSerializer<?> ser = EnumSerializer.construct(_handledType, provider.getConfig(), desc, format);
            
            return provider.handlePrimaryContextualization(ser, property);
          }
        }
      }
    }
    ObjectIdWriter oiw = _objectIdWriter;
    String[] ignorals = null;
    Object newFilterId = null;
    if (accessor != null)
    {
      ignorals = intr.findPropertiesToIgnore(accessor, true);
      ObjectIdInfo objectIdInfo = intr.findObjectIdInfo(accessor);
      if (objectIdInfo == null)
      {
        if (oiw != null)
        {
          objectIdInfo = intr.findObjectReferenceInfo(accessor, new ObjectIdInfo(NAME_FOR_OBJECT_REF, null, null, null));
          
          oiw = _objectIdWriter.withAlwaysAsId(objectIdInfo.getAlwaysAsId());
        }
      }
      else
      {
        objectIdInfo = intr.findObjectReferenceInfo(accessor, objectIdInfo);
        
        Class<?> implClass = objectIdInfo.getGeneratorType();
        JavaType type = provider.constructType(implClass);
        JavaType idType = provider.getTypeFactory().findTypeParameters(type, ObjectIdGenerator.class)[0];
        if (implClass == ObjectIdGenerators.PropertyGenerator.class)
        {
          String propName = objectIdInfo.getPropertyName().getSimpleName();
          BeanPropertyWriter idProp = null;
          
          int i = 0;
          for (int len = _props.length;; i++)
          {
            if (i == len) {
              throw new IllegalArgumentException("Invalid Object Id definition for " + _handledType.getName() + ": can not find property with name '" + propName + "'");
            }
            BeanPropertyWriter prop = _props[i];
            if (propName.equals(prop.getName()))
            {
              idProp = prop;
              if (i <= 0) {
                break;
              }
              System.arraycopy(_props, 0, _props, 1, i);
              _props[0] = idProp;
              if (_filteredProps == null) {
                break;
              }
              BeanPropertyWriter fp = _filteredProps[i];
              System.arraycopy(_filteredProps, 0, _filteredProps, 1, i);
              _filteredProps[0] = fp;
              break;
            }
          }
          idType = idProp.getType();
          ObjectIdGenerator<?> gen = new PropertyBasedObjectIdGenerator(objectIdInfo, idProp);
          oiw = ObjectIdWriter.construct(idType, (PropertyName)null, gen, objectIdInfo.getAlwaysAsId());
        }
        else
        {
          ObjectIdGenerator<?> gen = provider.objectIdGeneratorInstance(accessor, objectIdInfo);
          oiw = ObjectIdWriter.construct(idType, objectIdInfo.getPropertyName(), gen, objectIdInfo.getAlwaysAsId());
        }
      }
      Object filterId = intr.findFilterId(accessor);
      if (filterId != null) {
        if ((_propertyFilterId == null) || (!filterId.equals(_propertyFilterId))) {
          newFilterId = filterId;
        }
      }
    }
    BeanSerializerBase contextual = this;
    if (oiw != null)
    {
      JsonSerializer<?> ser = provider.findValueSerializer(idType, property);
      oiw = oiw.withSerializer(ser);
      if (oiw != _objectIdWriter) {
        contextual = contextual.withObjectIdWriter(oiw);
      }
    }
    if ((ignorals != null) && (ignorals.length != 0)) {
      contextual = contextual.withIgnorals(ignorals);
    }
    if (newFilterId != null) {
      contextual = contextual.withFilterId(newFilterId);
    }
    if (shape == null) {
      shape = _serializationShape;
    }
    if (shape == JsonFormat.Shape.ARRAY) {
      return contextual.asArraySerializer();
    }
    return contextual;
  }
  
  public Iterator<PropertyWriter> properties()
  {
    return Arrays.asList(_props).iterator();
  }
  
  public boolean usesObjectId()
  {
    return _objectIdWriter != null;
  }
  
  public abstract void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException;
  
  public void serializeWithType(Object bean, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    if (_objectIdWriter != null)
    {
      gen.setCurrentValue(bean);
      _serializeWithObjectId(bean, gen, provider, typeSer);
      return;
    }
    String typeStr = _typeId == null ? null : _customTypeId(bean);
    if (typeStr == null) {
      typeSer.writeTypePrefixForObject(bean, gen);
    } else {
      typeSer.writeCustomTypePrefixForObject(bean, gen, typeStr);
    }
    gen.setCurrentValue(bean);
    if (_propertyFilterId != null) {
      serializeFieldsFiltered(bean, gen, provider);
    } else {
      serializeFields(bean, gen, provider);
    }
    if (typeStr == null) {
      typeSer.writeTypeSuffixForObject(bean, gen);
    } else {
      typeSer.writeCustomTypeSuffixForObject(bean, gen, typeStr);
    }
  }
  
  protected final void _serializeWithObjectId(Object bean, JsonGenerator gen, SerializerProvider provider, boolean startEndObject)
    throws IOException
  {
    ObjectIdWriter w = _objectIdWriter;
    WritableObjectId objectId = provider.findObjectId(bean, generator);
    if (objectId.writeAsId(gen, provider, w)) {
      return;
    }
    Object id = objectId.generateId(bean);
    if (alwaysAsId)
    {
      serializer.serialize(id, gen, provider);
      return;
    }
    if (startEndObject) {
      gen.writeStartObject();
    }
    objectId.writeAsField(gen, provider, w);
    if (_propertyFilterId != null) {
      serializeFieldsFiltered(bean, gen, provider);
    } else {
      serializeFields(bean, gen, provider);
    }
    if (startEndObject) {
      gen.writeEndObject();
    }
  }
  
  protected final void _serializeWithObjectId(Object bean, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    ObjectIdWriter w = _objectIdWriter;
    WritableObjectId objectId = provider.findObjectId(bean, generator);
    if (objectId.writeAsId(gen, provider, w)) {
      return;
    }
    Object id = objectId.generateId(bean);
    if (alwaysAsId)
    {
      serializer.serialize(id, gen, provider);
      return;
    }
    _serializeObjectId(bean, gen, provider, typeSer, objectId);
  }
  
  protected void _serializeObjectId(Object bean, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer, WritableObjectId objectId)
    throws IOException
  {
    ObjectIdWriter w = _objectIdWriter;
    String typeStr = _typeId == null ? null : _customTypeId(bean);
    if (typeStr == null) {
      typeSer.writeTypePrefixForObject(bean, gen);
    } else {
      typeSer.writeCustomTypePrefixForObject(bean, gen, typeStr);
    }
    objectId.writeAsField(gen, provider, w);
    if (_propertyFilterId != null) {
      serializeFieldsFiltered(bean, gen, provider);
    } else {
      serializeFields(bean, gen, provider);
    }
    if (typeStr == null) {
      typeSer.writeTypeSuffixForObject(bean, gen);
    } else {
      typeSer.writeCustomTypeSuffixForObject(bean, gen, typeStr);
    }
  }
  
  protected final String _customTypeId(Object bean)
  {
    Object typeId = _typeId.getValue(bean);
    if (typeId == null) {
      return "";
    }
    return (typeId instanceof String) ? (String)typeId : typeId.toString();
  }
  
  protected void serializeFields(Object bean, JsonGenerator gen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    BeanPropertyWriter[] props;
    BeanPropertyWriter[] props;
    if ((_filteredProps != null) && (provider.getActiveView() != null)) {
      props = _filteredProps;
    } else {
      props = _props;
    }
    int i = 0;
    try
    {
      for (int len = props.length; i < len; i++)
      {
        BeanPropertyWriter prop = props[i];
        if (prop != null) {
          prop.serializeAsField(bean, gen, provider);
        }
      }
      if (_anyGetterWriter != null) {
        _anyGetterWriter.getAndSerialize(bean, gen, provider);
      }
    }
    catch (Exception e)
    {
      String name = i == props.length ? "[anySetter]" : props[i].getName();
      wrapAndThrow(provider, e, bean, name);
    }
    catch (StackOverflowError e)
    {
      JsonMappingException mapE = new JsonMappingException("Infinite recursion (StackOverflowError)", e);
      String name = i == props.length ? "[anySetter]" : props[i].getName();
      mapE.prependPath(new JsonMappingException.Reference(bean, name));
      throw mapE;
    }
  }
  
  protected void serializeFieldsFiltered(Object bean, JsonGenerator gen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    BeanPropertyWriter[] props;
    BeanPropertyWriter[] props;
    if ((_filteredProps != null) && (provider.getActiveView() != null)) {
      props = _filteredProps;
    } else {
      props = _props;
    }
    PropertyFilter filter = findPropertyFilter(provider, _propertyFilterId, bean);
    if (filter == null)
    {
      serializeFields(bean, gen, provider);
      return;
    }
    int i = 0;
    try
    {
      for (int len = props.length; i < len; i++)
      {
        BeanPropertyWriter prop = props[i];
        if (prop != null) {
          filter.serializeAsField(bean, gen, provider, prop);
        }
      }
      if (_anyGetterWriter != null) {
        _anyGetterWriter.getAndFilter(bean, gen, provider, filter);
      }
    }
    catch (Exception e)
    {
      String name = i == props.length ? "[anySetter]" : props[i].getName();
      wrapAndThrow(provider, e, bean, name);
    }
    catch (StackOverflowError e)
    {
      JsonMappingException mapE = new JsonMappingException("Infinite recursion (StackOverflowError)", e);
      String name = i == props.length ? "[anySetter]" : props[i].getName();
      mapE.prependPath(new JsonMappingException.Reference(bean, name));
      throw mapE;
    }
  }
  
  @Deprecated
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    throws JsonMappingException
  {
    ObjectNode o = createSchemaNode("object", true);
    
    JsonSerializableSchema ann = (JsonSerializableSchema)_handledType.getAnnotation(JsonSerializableSchema.class);
    if (ann != null)
    {
      String id = ann.id();
      if ((id != null) && (id.length() > 0)) {
        o.put("id", id);
      }
    }
    ObjectNode propertiesNode = o.objectNode();
    PropertyFilter filter;
    PropertyFilter filter;
    if (_propertyFilterId != null) {
      filter = findPropertyFilter(provider, _propertyFilterId, null);
    } else {
      filter = null;
    }
    for (int i = 0; i < _props.length; i++)
    {
      BeanPropertyWriter prop = _props[i];
      if (filter == null) {
        prop.depositSchemaProperty(propertiesNode, provider);
      } else {
        filter.depositSchemaProperty(prop, propertiesNode, provider);
      }
    }
    o.set("properties", propertiesNode);
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
    if (_propertyFilterId != null)
    {
      PropertyFilter filter = findPropertyFilter(visitor.getProvider(), _propertyFilterId, null);
      for (int i = 0; i < _props.length; i++) {
        filter.depositSchemaProperty(_props[i], objectVisitor, visitor.getProvider());
      }
    }
    else
    {
      for (int i = 0; i < _props.length; i++) {
        _props[i].depositSchemaProperty(objectVisitor);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */