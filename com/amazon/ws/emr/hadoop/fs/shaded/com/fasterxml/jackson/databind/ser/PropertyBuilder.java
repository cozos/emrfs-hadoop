package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.Annotated;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;

public class PropertyBuilder
{
  protected final SerializationConfig _config;
  protected final BeanDescription _beanDesc;
  protected final JsonInclude.Include _defaultInclusion;
  protected final AnnotationIntrospector _annotationIntrospector;
  protected Object _defaultBean;
  
  public PropertyBuilder(SerializationConfig config, BeanDescription beanDesc)
  {
    _config = config;
    _beanDesc = beanDesc;
    _defaultInclusion = beanDesc.findSerializationInclusion(config.getSerializationInclusion());
    _annotationIntrospector = _config.getAnnotationIntrospector();
  }
  
  public Annotations getClassAnnotations()
  {
    return _beanDesc.getClassAnnotations();
  }
  
  protected BeanPropertyWriter buildWriter(SerializerProvider prov, BeanPropertyDefinition propDef, JavaType declaredType, JsonSerializer<?> ser, TypeSerializer typeSer, TypeSerializer contentTypeSer, AnnotatedMember am, boolean defaultUseStaticTyping)
    throws JsonMappingException
  {
    JavaType serializationType = findSerializationType(am, defaultUseStaticTyping, declaredType);
    if (contentTypeSer != null)
    {
      if (serializationType == null) {
        serializationType = declaredType;
      }
      JavaType ct = serializationType.getContentType();
      if (ct == null) {
        throw new IllegalStateException("Problem trying to create BeanPropertyWriter for property '" + propDef.getName() + "' (of type " + _beanDesc.getType() + "); serialization type " + serializationType + " has no content");
      }
      serializationType = serializationType.withContentTypeHandler(contentTypeSer);
      ct = serializationType.getContentType();
    }
    Object valueToSuppress = null;
    boolean suppressNulls = false;
    
    JsonInclude.Include inclusion = propDef.findInclusion();
    if ((inclusion == null) || (inclusion == JsonInclude.Include.USE_DEFAULTS))
    {
      inclusion = _defaultInclusion;
      if (inclusion == null) {
        inclusion = JsonInclude.Include.ALWAYS;
      }
    }
    switch (inclusion)
    {
    case NON_DEFAULT: 
      valueToSuppress = getDefaultValue(propDef.getName(), am);
      if (valueToSuppress == null) {
        suppressNulls = true;
      } else if (valueToSuppress.getClass().isArray()) {
        valueToSuppress = ArrayBuilders.getArrayComparator(valueToSuppress);
      }
      break;
    case NON_ABSENT: 
      suppressNulls = true;
      if (declaredType.isReferenceType()) {
        valueToSuppress = BeanPropertyWriter.MARKER_FOR_EMPTY;
      }
      break;
    case NON_EMPTY: 
      suppressNulls = true;
      
      valueToSuppress = BeanPropertyWriter.MARKER_FOR_EMPTY;
      break;
    case NON_NULL: 
      suppressNulls = true;
    case ALWAYS: 
    default: 
      if ((declaredType.isContainerType()) && (!_config.isEnabled(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS))) {
        valueToSuppress = BeanPropertyWriter.MARKER_FOR_EMPTY;
      }
      break;
    }
    BeanPropertyWriter bpw = new BeanPropertyWriter(propDef, am, _beanDesc.getClassAnnotations(), declaredType, ser, typeSer, serializationType, suppressNulls, valueToSuppress);
    
    Object serDef = _annotationIntrospector.findNullSerializer(am);
    if (serDef != null) {
      bpw.assignNullSerializer(prov.serializerInstance(am, serDef));
    }
    NameTransformer unwrapper = _annotationIntrospector.findUnwrappingNameTransformer(am);
    if (unwrapper != null) {
      bpw = bpw.unwrappingWriter(unwrapper);
    }
    return bpw;
  }
  
  protected JavaType findSerializationType(Annotated a, boolean useStaticTyping, JavaType declaredType)
  {
    Class<?> serClass = _annotationIntrospector.findSerializationType(a);
    if (serClass != null)
    {
      Class<?> rawDeclared = declaredType.getRawClass();
      if (serClass.isAssignableFrom(rawDeclared))
      {
        declaredType = declaredType.widenBy(serClass);
      }
      else
      {
        if (!rawDeclared.isAssignableFrom(serClass)) {
          throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + a.getName() + "': class " + serClass.getName() + " not a super-type of (declared) class " + rawDeclared.getName());
        }
        declaredType = _config.constructSpecializedType(declaredType, serClass);
      }
      useStaticTyping = true;
    }
    JavaType secondary = BasicSerializerFactory.modifySecondaryTypesByAnnotation(_config, a, declaredType);
    if (secondary != declaredType)
    {
      useStaticTyping = true;
      declaredType = secondary;
    }
    JsonSerialize.Typing typing = _annotationIntrospector.findSerializationTyping(a);
    if ((typing != null) && (typing != JsonSerialize.Typing.DEFAULT_TYPING)) {
      useStaticTyping = typing == JsonSerialize.Typing.STATIC;
    }
    return useStaticTyping ? declaredType : null;
  }
  
  protected Object getDefaultBean()
  {
    if (_defaultBean == null)
    {
      _defaultBean = _beanDesc.instantiateBean(_config.canOverrideAccessModifiers());
      if (_defaultBean == null)
      {
        Class<?> cls = _beanDesc.getClassInfo().getAnnotated();
        throw new IllegalArgumentException("Class " + cls.getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation");
      }
    }
    return _defaultBean;
  }
  
  protected Object getDefaultValue(String name, AnnotatedMember member)
  {
    Object defaultBean = getDefaultBean();
    try
    {
      return member.getValue(defaultBean);
    }
    catch (Exception e)
    {
      return _throwWrapped(e, name, defaultBean);
    }
  }
  
  protected Object _throwWrapped(Exception e, String propName, Object defaultBean)
  {
    Throwable t = e;
    while (t.getCause() != null) {
      t = t.getCause();
    }
    if ((t instanceof Error)) {
      throw ((Error)t);
    }
    if ((t instanceof RuntimeException)) {
      throw ((RuntimeException)t);
    }
    throw new IllegalArgumentException("Failed to get property '" + propName + "' of default " + defaultBean.getClass().getName() + " instance");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */