package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.SerializedString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanPropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

@JacksonStdImpl
public class BeanPropertyWriter
  extends PropertyWriter
  implements BeanProperty, Serializable
{
  private static final long serialVersionUID = 4603296144163950020L;
  public static final Object MARKER_FOR_EMPTY = JsonInclude.Include.NON_EMPTY;
  protected static final JsonFormat.Value NO_FORMAT = new JsonFormat.Value();
  protected final SerializedString _name;
  protected final PropertyName _wrapperName;
  protected final JavaType _declaredType;
  protected final JavaType _cfgSerializationType;
  protected JavaType _nonTrivialBaseType;
  protected final transient Annotations _contextAnnotations;
  protected final PropertyMetadata _metadata;
  protected transient JsonFormat.Value _format;
  protected final AnnotatedMember _member;
  protected transient Method _accessorMethod;
  protected transient Field _field;
  protected JsonSerializer<Object> _serializer;
  protected JsonSerializer<Object> _nullSerializer;
  protected TypeSerializer _typeSerializer;
  protected transient PropertySerializerMap _dynamicSerializers;
  protected final boolean _suppressNulls;
  protected final Object _suppressableValue;
  protected final Class<?>[] _includeInViews;
  protected transient HashMap<Object, Object> _internalSettings;
  
  public BeanPropertyWriter(BeanPropertyDefinition propDef, AnnotatedMember member, Annotations contextAnnotations, JavaType declaredType, JsonSerializer<?> ser, TypeSerializer typeSer, JavaType serType, boolean suppressNulls, Object suppressableValue)
  {
    _member = member;
    _contextAnnotations = contextAnnotations;
    
    _name = new SerializedString(propDef.getName());
    _wrapperName = propDef.getWrapperName();
    _metadata = propDef.getMetadata();
    _includeInViews = propDef.findViews();
    
    _declaredType = declaredType;
    _serializer = ser;
    _dynamicSerializers = (ser == null ? PropertySerializerMap.emptyForProperties() : null);
    _typeSerializer = typeSer;
    _cfgSerializationType = serType;
    if ((member instanceof AnnotatedField))
    {
      _accessorMethod = null;
      _field = ((Field)member.getMember());
    }
    else if ((member instanceof AnnotatedMethod))
    {
      _accessorMethod = ((Method)member.getMember());
      _field = null;
    }
    else
    {
      _accessorMethod = null;
      _field = null;
    }
    _suppressNulls = suppressNulls;
    _suppressableValue = suppressableValue;
    
    _nullSerializer = null;
  }
  
  protected BeanPropertyWriter()
  {
    _member = null;
    _contextAnnotations = null;
    
    _name = null;
    _wrapperName = null;
    _metadata = null;
    _includeInViews = null;
    
    _declaredType = null;
    _serializer = null;
    _dynamicSerializers = null;
    _typeSerializer = null;
    _cfgSerializationType = null;
    
    _accessorMethod = null;
    _field = null;
    _suppressNulls = false;
    _suppressableValue = null;
    
    _nullSerializer = null;
  }
  
  protected BeanPropertyWriter(BeanPropertyWriter base)
  {
    this(base, _name);
  }
  
  protected BeanPropertyWriter(BeanPropertyWriter base, PropertyName name)
  {
    _name = new SerializedString(name.getSimpleName());
    _wrapperName = _wrapperName;
    
    _contextAnnotations = _contextAnnotations;
    _declaredType = _declaredType;
    
    _member = _member;
    _accessorMethod = _accessorMethod;
    _field = _field;
    
    _serializer = _serializer;
    _nullSerializer = _nullSerializer;
    if (_internalSettings != null) {
      _internalSettings = new HashMap(_internalSettings);
    }
    _cfgSerializationType = _cfgSerializationType;
    _dynamicSerializers = _dynamicSerializers;
    _suppressNulls = _suppressNulls;
    _suppressableValue = _suppressableValue;
    _includeInViews = _includeInViews;
    _typeSerializer = _typeSerializer;
    _nonTrivialBaseType = _nonTrivialBaseType;
    _metadata = _metadata;
  }
  
  protected BeanPropertyWriter(BeanPropertyWriter base, SerializedString name)
  {
    _name = name;
    _wrapperName = _wrapperName;
    
    _member = _member;
    _contextAnnotations = _contextAnnotations;
    _declaredType = _declaredType;
    _accessorMethod = _accessorMethod;
    _field = _field;
    _serializer = _serializer;
    _nullSerializer = _nullSerializer;
    if (_internalSettings != null) {
      _internalSettings = new HashMap(_internalSettings);
    }
    _cfgSerializationType = _cfgSerializationType;
    _dynamicSerializers = _dynamicSerializers;
    _suppressNulls = _suppressNulls;
    _suppressableValue = _suppressableValue;
    _includeInViews = _includeInViews;
    _typeSerializer = _typeSerializer;
    _nonTrivialBaseType = _nonTrivialBaseType;
    _metadata = _metadata;
  }
  
  public BeanPropertyWriter rename(NameTransformer transformer)
  {
    String newName = transformer.transform(_name.getValue());
    if (newName.equals(_name.toString())) {
      return this;
    }
    return _new(PropertyName.construct(newName));
  }
  
  protected BeanPropertyWriter _new(PropertyName newName)
  {
    return new BeanPropertyWriter(this, newName);
  }
  
  public void assignTypeSerializer(TypeSerializer typeSer)
  {
    _typeSerializer = typeSer;
  }
  
  public void assignSerializer(JsonSerializer<Object> ser)
  {
    if ((_serializer != null) && (_serializer != ser)) {
      throw new IllegalStateException("Can not override serializer");
    }
    _serializer = ser;
  }
  
  public void assignNullSerializer(JsonSerializer<Object> nullSer)
  {
    if ((_nullSerializer != null) && (_nullSerializer != nullSer)) {
      throw new IllegalStateException("Can not override null serializer");
    }
    _nullSerializer = nullSer;
  }
  
  public BeanPropertyWriter unwrappingWriter(NameTransformer unwrapper)
  {
    return new UnwrappingBeanPropertyWriter(this, unwrapper);
  }
  
  public void setNonTrivialBaseType(JavaType t)
  {
    _nonTrivialBaseType = t;
  }
  
  Object readResolve()
  {
    if ((_member instanceof AnnotatedField))
    {
      _accessorMethod = null;
      _field = ((Field)_member.getMember());
    }
    else if ((_member instanceof AnnotatedMethod))
    {
      _accessorMethod = ((Method)_member.getMember());
      _field = null;
    }
    if (_serializer == null) {
      _dynamicSerializers = PropertySerializerMap.emptyForProperties();
    }
    return this;
  }
  
  public String getName()
  {
    return _name.getValue();
  }
  
  public PropertyName getFullName()
  {
    return new PropertyName(_name.getValue());
  }
  
  public JavaType getType()
  {
    return _declaredType;
  }
  
  public PropertyName getWrapperName()
  {
    return _wrapperName;
  }
  
  public boolean isRequired()
  {
    return _metadata.isRequired();
  }
  
  public PropertyMetadata getMetadata()
  {
    return _metadata;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return _member == null ? null : _member.getAnnotation(acls);
  }
  
  public <A extends Annotation> A getContextAnnotation(Class<A> acls)
  {
    return _contextAnnotations == null ? null : _contextAnnotations.get(acls);
  }
  
  public JsonFormat.Value findFormatOverrides(AnnotationIntrospector intr)
  {
    JsonFormat.Value f = _format;
    if (f == null)
    {
      f = (intr == null) || (_member == null) ? null : intr.findFormat(_member);
      
      _format = (f == null ? NO_FORMAT : f);
    }
    return f == NO_FORMAT ? null : f;
  }
  
  public AnnotatedMember getMember()
  {
    return _member;
  }
  
  protected void _depositSchemaProperty(ObjectNode propertiesNode, JsonNode schemaNode)
  {
    propertiesNode.set(getName(), schemaNode);
  }
  
  public boolean isVirtual()
  {
    return false;
  }
  
  public Object getInternalSetting(Object key)
  {
    return _internalSettings == null ? null : _internalSettings.get(key);
  }
  
  public Object setInternalSetting(Object key, Object value)
  {
    if (_internalSettings == null) {
      _internalSettings = new HashMap();
    }
    return _internalSettings.put(key, value);
  }
  
  public Object removeInternalSetting(Object key)
  {
    Object removed = null;
    if (_internalSettings != null)
    {
      removed = _internalSettings.remove(key);
      if (_internalSettings.size() == 0) {
        _internalSettings = null;
      }
    }
    return removed;
  }
  
  public SerializableString getSerializedName()
  {
    return _name;
  }
  
  public boolean hasSerializer()
  {
    return _serializer != null;
  }
  
  public boolean hasNullSerializer()
  {
    return _nullSerializer != null;
  }
  
  public TypeSerializer getTypeSerializer()
  {
    return _typeSerializer;
  }
  
  public boolean isUnwrapping()
  {
    return false;
  }
  
  public boolean willSuppressNulls()
  {
    return _suppressNulls;
  }
  
  public boolean wouldConflictWithName(PropertyName name)
  {
    if (_wrapperName != null) {
      return _wrapperName.equals(name);
    }
    return (name.hasSimpleName(_name.getValue())) && (!name.hasNamespace());
  }
  
  public JsonSerializer<Object> getSerializer()
  {
    return _serializer;
  }
  
  public JavaType getSerializationType()
  {
    return _cfgSerializationType;
  }
  
  public Class<?> getRawSerializationType()
  {
    return _cfgSerializationType == null ? null : _cfgSerializationType.getRawClass();
  }
  
  public Class<?> getPropertyType()
  {
    return _accessorMethod != null ? _accessorMethod.getReturnType() : _field.getType();
  }
  
  public Type getGenericPropertyType()
  {
    if (_accessorMethod != null) {
      return _accessorMethod.getGenericReturnType();
    }
    if (_field != null) {
      return _field.getGenericType();
    }
    return null;
  }
  
  public Class<?>[] getViews()
  {
    return _includeInViews;
  }
  
  public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov)
    throws Exception
  {
    Object value = _accessorMethod == null ? _field.get(bean) : _accessorMethod.invoke(bean, new Object[0]);
    if (value == null)
    {
      if (_nullSerializer != null)
      {
        gen.writeFieldName(_name);
        _nullSerializer.serialize(null, gen, prov);
      }
      return;
    }
    JsonSerializer<Object> ser = _serializer;
    if (ser == null)
    {
      Class<?> cls = value.getClass();
      PropertySerializerMap m = _dynamicSerializers;
      ser = m.serializerFor(cls);
      if (ser == null) {
        ser = _findAndAddDynamic(m, cls, prov);
      }
    }
    if (_suppressableValue != null) {
      if (MARKER_FOR_EMPTY == _suppressableValue)
      {
        if (!ser.isEmpty(prov, value)) {}
      }
      else if (_suppressableValue.equals(value)) {
        return;
      }
    }
    if (value == bean) {
      if (_handleSelfReference(bean, gen, prov, ser)) {
        return;
      }
    }
    gen.writeFieldName(_name);
    if (_typeSerializer == null) {
      ser.serialize(value, gen, prov);
    } else {
      ser.serializeWithType(value, gen, prov, _typeSerializer);
    }
  }
  
  public void serializeAsOmittedField(Object bean, JsonGenerator gen, SerializerProvider prov)
    throws Exception
  {
    if (!gen.canOmitFields()) {
      gen.writeOmittedField(_name.getValue());
    }
  }
  
  public void serializeAsElement(Object bean, JsonGenerator gen, SerializerProvider prov)
    throws Exception
  {
    Object value = _accessorMethod == null ? _field.get(bean) : _accessorMethod.invoke(bean, new Object[0]);
    if (value == null)
    {
      if (_nullSerializer != null) {
        _nullSerializer.serialize(null, gen, prov);
      } else {
        gen.writeNull();
      }
      return;
    }
    JsonSerializer<Object> ser = _serializer;
    if (ser == null)
    {
      Class<?> cls = value.getClass();
      PropertySerializerMap map = _dynamicSerializers;
      ser = map.serializerFor(cls);
      if (ser == null) {
        ser = _findAndAddDynamic(map, cls, prov);
      }
    }
    if (_suppressableValue != null) {
      if (MARKER_FOR_EMPTY == _suppressableValue)
      {
        if (ser.isEmpty(prov, value)) {
          serializeAsPlaceholder(bean, gen, prov);
        }
      }
      else if (_suppressableValue.equals(value))
      {
        serializeAsPlaceholder(bean, gen, prov);
        return;
      }
    }
    if ((value == bean) && 
      (_handleSelfReference(bean, gen, prov, ser))) {
      return;
    }
    if (_typeSerializer == null) {
      ser.serialize(value, gen, prov);
    } else {
      ser.serializeWithType(value, gen, prov, _typeSerializer);
    }
  }
  
  public void serializeAsPlaceholder(Object bean, JsonGenerator gen, SerializerProvider prov)
    throws Exception
  {
    if (_nullSerializer != null) {
      _nullSerializer.serialize(null, gen, prov);
    } else {
      gen.writeNull();
    }
  }
  
  public void depositSchemaProperty(JsonObjectFormatVisitor v)
    throws JsonMappingException
  {
    if (v != null) {
      if (isRequired()) {
        v.property(this);
      } else {
        v.optionalProperty(this);
      }
    }
  }
  
  @Deprecated
  public void depositSchemaProperty(ObjectNode propertiesNode, SerializerProvider provider)
    throws JsonMappingException
  {
    JavaType propType = getSerializationType();
    
    Type hint = propType == null ? getGenericPropertyType() : propType.getRawClass();
    
    JsonSerializer<Object> ser = getSerializer();
    if (ser == null) {
      ser = provider.findValueSerializer(getType(), this);
    }
    boolean isOptional = !isRequired();
    JsonNode schemaNode;
    JsonNode schemaNode;
    if ((ser instanceof SchemaAware)) {
      schemaNode = ((SchemaAware)ser).getSchema(provider, hint, isOptional);
    } else {
      schemaNode = JsonSchema.getDefaultSchemaNode();
    }
    _depositSchemaProperty(propertiesNode, schemaNode);
  }
  
  protected JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap map, Class<?> type, SerializerProvider provider)
    throws JsonMappingException
  {
    PropertySerializerMap.SerializerAndMapResult result;
    PropertySerializerMap.SerializerAndMapResult result;
    if (_nonTrivialBaseType != null)
    {
      JavaType t = provider.constructSpecializedType(_nonTrivialBaseType, type);
      result = map.findAndAddPrimarySerializer(t, provider, this);
    }
    else
    {
      result = map.findAndAddPrimarySerializer(type, provider, this);
    }
    if (map != map) {
      _dynamicSerializers = map;
    }
    return serializer;
  }
  
  public final Object get(Object bean)
    throws Exception
  {
    return _accessorMethod == null ? _field.get(bean) : _accessorMethod.invoke(bean, new Object[0]);
  }
  
  protected boolean _handleSelfReference(Object bean, JsonGenerator gen, SerializerProvider prov, JsonSerializer<?> ser)
    throws JsonMappingException
  {
    if ((prov.isEnabled(SerializationFeature.FAIL_ON_SELF_REFERENCES)) && (!ser.usesObjectId())) {
      if ((ser instanceof BeanSerializerBase)) {
        throw new JsonMappingException("Direct self-reference leading to cycle");
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder(40);
    sb.append("property '").append(getName()).append("' (");
    if (_accessorMethod != null) {
      sb.append("via method ").append(_accessorMethod.getDeclaringClass().getName()).append("#").append(_accessorMethod.getName());
    } else if (_field != null) {
      sb.append("field \"").append(_field.getDeclaringClass().getName()).append("#").append(_field.getName());
    } else {
      sb.append("virtual");
    }
    if (_serializer == null) {
      sb.append(", no static serializer");
    } else {
      sb.append(", static serializer of type " + _serializer.getClass().getName());
    }
    sb.append(')');
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanPropertyWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */