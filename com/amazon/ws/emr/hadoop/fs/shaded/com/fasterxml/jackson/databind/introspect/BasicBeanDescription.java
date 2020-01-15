package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeBindings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter.None;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BasicBeanDescription
  extends BeanDescription
{
  protected final POJOPropertiesCollector _propCollector;
  protected final MapperConfig<?> _config;
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final AnnotatedClass _classInfo;
  protected TypeBindings _bindings;
  protected List<BeanPropertyDefinition> _properties;
  protected ObjectIdInfo _objectIdInfo;
  
  protected BasicBeanDescription(POJOPropertiesCollector coll, JavaType type, AnnotatedClass classDef)
  {
    super(type);
    _propCollector = coll;
    _config = coll.getConfig();
    _annotationIntrospector = (_config == null ? null : _config.getAnnotationIntrospector());
    _classInfo = classDef;
  }
  
  protected BasicBeanDescription(MapperConfig<?> config, JavaType type, AnnotatedClass classDef, List<BeanPropertyDefinition> props)
  {
    super(type);
    _propCollector = null;
    _config = config;
    _annotationIntrospector = (_config == null ? null : _config.getAnnotationIntrospector());
    _classInfo = classDef;
    _properties = props;
  }
  
  protected BasicBeanDescription(POJOPropertiesCollector coll)
  {
    this(coll, coll.getType(), coll.getClassDef());
    _objectIdInfo = coll.getObjectIdInfo();
  }
  
  public static BasicBeanDescription forDeserialization(POJOPropertiesCollector coll)
  {
    return new BasicBeanDescription(coll);
  }
  
  public static BasicBeanDescription forSerialization(POJOPropertiesCollector coll)
  {
    return new BasicBeanDescription(coll);
  }
  
  public static BasicBeanDescription forOtherUse(MapperConfig<?> config, JavaType type, AnnotatedClass ac)
  {
    return new BasicBeanDescription(config, type, ac, Collections.emptyList());
  }
  
  protected List<BeanPropertyDefinition> _properties()
  {
    if (_properties == null) {
      _properties = _propCollector.getProperties();
    }
    return _properties;
  }
  
  public boolean removeProperty(String propName)
  {
    Iterator<BeanPropertyDefinition> it = _properties().iterator();
    while (it.hasNext())
    {
      BeanPropertyDefinition prop = (BeanPropertyDefinition)it.next();
      if (prop.getName().equals(propName))
      {
        it.remove();
        return true;
      }
    }
    return false;
  }
  
  public boolean addProperty(BeanPropertyDefinition def)
  {
    if (hasProperty(def.getFullName())) {
      return false;
    }
    _properties().add(def);
    return true;
  }
  
  public boolean hasProperty(PropertyName name)
  {
    return findProperty(name) != null;
  }
  
  public BeanPropertyDefinition findProperty(PropertyName name)
  {
    for (BeanPropertyDefinition prop : _properties()) {
      if (prop.hasName(name)) {
        return prop;
      }
    }
    return null;
  }
  
  public AnnotatedClass getClassInfo()
  {
    return _classInfo;
  }
  
  public ObjectIdInfo getObjectIdInfo()
  {
    return _objectIdInfo;
  }
  
  public List<BeanPropertyDefinition> findProperties()
  {
    return _properties();
  }
  
  public AnnotatedMethod findJsonValueMethod()
  {
    return _propCollector == null ? null : _propCollector.getJsonValueMethod();
  }
  
  public Set<String> getIgnoredPropertyNames()
  {
    Set<String> ign = _propCollector == null ? null : _propCollector.getIgnoredPropertyNames();
    if (ign == null) {
      return Collections.emptySet();
    }
    return ign;
  }
  
  public boolean hasKnownClassAnnotations()
  {
    return _classInfo.hasAnnotations();
  }
  
  public Annotations getClassAnnotations()
  {
    return _classInfo.getAnnotations();
  }
  
  public TypeBindings bindingsForBeanType()
  {
    if (_bindings == null) {
      _bindings = new TypeBindings(_config.getTypeFactory(), _type);
    }
    return _bindings;
  }
  
  public JavaType resolveType(Type jdkType)
  {
    if (jdkType == null) {
      return null;
    }
    return bindingsForBeanType().resolveType(jdkType);
  }
  
  public AnnotatedConstructor findDefaultConstructor()
  {
    return _classInfo.getDefaultConstructor();
  }
  
  public AnnotatedMethod findAnySetter()
    throws IllegalArgumentException
  {
    AnnotatedMethod anySetter = _propCollector == null ? null : _propCollector.getAnySetterMethod();
    if (anySetter != null)
    {
      Class<?> type = anySetter.getRawParameterType(0);
      if ((type != String.class) && (type != Object.class)) {
        throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + anySetter.getName() + "(): first argument not of type String or Object, but " + type.getName());
      }
    }
    return anySetter;
  }
  
  public Map<Object, AnnotatedMember> findInjectables()
  {
    if (_propCollector != null) {
      return _propCollector.getInjectables();
    }
    return Collections.emptyMap();
  }
  
  public List<AnnotatedConstructor> getConstructors()
  {
    return _classInfo.getConstructors();
  }
  
  public Object instantiateBean(boolean fixAccess)
  {
    AnnotatedConstructor ac = _classInfo.getDefaultConstructor();
    if (ac == null) {
      return null;
    }
    if (fixAccess) {
      ac.fixAccess();
    }
    try
    {
      return ac.getAnnotated().newInstance(new Object[0]);
    }
    catch (Exception e)
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
      throw new IllegalArgumentException("Failed to instantiate bean of type " + _classInfo.getAnnotated().getName() + ": (" + t.getClass().getName() + ") " + t.getMessage(), t);
    }
  }
  
  public AnnotatedMethod findMethod(String name, Class<?>[] paramTypes)
  {
    return _classInfo.findMethod(name, paramTypes);
  }
  
  public JsonFormat.Value findExpectedFormat(JsonFormat.Value defValue)
  {
    if (_annotationIntrospector != null)
    {
      JsonFormat.Value v = _annotationIntrospector.findFormat(_classInfo);
      if (v != null) {
        return v;
      }
    }
    return defValue;
  }
  
  public Converter<Object, Object> findSerializationConverter()
  {
    if (_annotationIntrospector == null) {
      return null;
    }
    return _createConverter(_annotationIntrospector.findSerializationConverter(_classInfo));
  }
  
  public JsonInclude.Include findSerializationInclusion(JsonInclude.Include defValue)
  {
    if (_annotationIntrospector == null) {
      return defValue;
    }
    return _annotationIntrospector.findSerializationInclusion(_classInfo, defValue);
  }
  
  public JsonInclude.Include findSerializationInclusionForContent(JsonInclude.Include defValue)
  {
    if (_annotationIntrospector == null) {
      return defValue;
    }
    return _annotationIntrospector.findSerializationInclusionForContent(_classInfo, defValue);
  }
  
  public AnnotatedMember findAnyGetter()
    throws IllegalArgumentException
  {
    AnnotatedMember anyGetter = _propCollector == null ? null : _propCollector.getAnyGetter();
    if (anyGetter != null)
    {
      Class<?> type = anyGetter.getRawType();
      if (!Map.class.isAssignableFrom(type)) {
        throw new IllegalArgumentException("Invalid 'any-getter' annotation on method " + anyGetter.getName() + "(): return type is not instance of java.util.Map");
      }
    }
    return anyGetter;
  }
  
  public Map<String, AnnotatedMember> findBackReferenceProperties()
  {
    HashMap<String, AnnotatedMember> result = null;
    for (BeanPropertyDefinition property : _properties())
    {
      AnnotatedMember am = property.getMutator();
      if (am != null)
      {
        AnnotationIntrospector.ReferenceProperty refDef = _annotationIntrospector.findReferenceType(am);
        if ((refDef != null) && (refDef.isBackReference()))
        {
          if (result == null) {
            result = new HashMap();
          }
          String refName = refDef.getName();
          if (result.put(refName, am) != null) {
            throw new IllegalArgumentException("Multiple back-reference properties with name '" + refName + "'");
          }
        }
      }
    }
    return result;
  }
  
  public List<AnnotatedMethod> getFactoryMethods()
  {
    List<AnnotatedMethod> candidates = _classInfo.getStaticMethods();
    if (candidates.isEmpty()) {
      return candidates;
    }
    ArrayList<AnnotatedMethod> result = new ArrayList();
    for (AnnotatedMethod am : candidates) {
      if (isFactoryMethod(am)) {
        result.add(am);
      }
    }
    return result;
  }
  
  public Constructor<?> findSingleArgConstructor(Class<?>... argTypes)
  {
    for (AnnotatedConstructor ac : _classInfo.getConstructors()) {
      if (ac.getParameterCount() == 1)
      {
        Class<?> actArg = ac.getRawParameterType(0);
        for (Class<?> expArg : argTypes) {
          if (expArg == actArg) {
            return ac.getAnnotated();
          }
        }
      }
    }
    return null;
  }
  
  public Method findFactoryMethod(Class<?>... expArgTypes)
  {
    for (AnnotatedMethod am : _classInfo.getStaticMethods()) {
      if (isFactoryMethod(am))
      {
        Class<?> actualArgType = am.getRawParameterType(0);
        for (Class<?> expArgType : expArgTypes) {
          if (actualArgType.isAssignableFrom(expArgType)) {
            return am.getAnnotated();
          }
        }
      }
    }
    return null;
  }
  
  protected boolean isFactoryMethod(AnnotatedMethod am)
  {
    Class<?> rt = am.getRawReturnType();
    if (!getBeanClass().isAssignableFrom(rt)) {
      return false;
    }
    if (_annotationIntrospector.hasCreatorAnnotation(am)) {
      return true;
    }
    String name = am.getName();
    if ("valueOf".equals(name)) {
      return true;
    }
    if (("fromString".equals(name)) && 
      (1 == am.getParameterCount()))
    {
      Class<?> cls = am.getRawParameterType(0);
      if ((cls == String.class) || (CharSequence.class.isAssignableFrom(cls))) {
        return true;
      }
    }
    return false;
  }
  
  @Deprecated
  public List<String> findCreatorPropertyNames()
  {
    List<PropertyName> params = findCreatorParameterNames();
    if (params.isEmpty()) {
      return Collections.emptyList();
    }
    List<String> result = new ArrayList(params.size());
    for (PropertyName name : params) {
      result.add(name.getSimpleName());
    }
    return result;
  }
  
  @Deprecated
  public List<PropertyName> findCreatorParameterNames()
  {
    for (int i = 0; i < 2; i++)
    {
      List<? extends AnnotatedWithParams> l = i == 0 ? getConstructors() : getFactoryMethods();
      for (AnnotatedWithParams creator : l)
      {
        int argCount = creator.getParameterCount();
        if (argCount >= 1)
        {
          PropertyName name = _findCreatorPropertyName(creator.getParameter(0));
          if ((name != null) && (!name.isEmpty()))
          {
            List<PropertyName> names = new ArrayList();
            names.add(name);
            for (int p = 1; p < argCount; p++)
            {
              name = _findCreatorPropertyName(creator.getParameter(p));
              names.add(name);
            }
            return names;
          }
        }
      }
    }
    return Collections.emptyList();
  }
  
  protected PropertyName _findCreatorPropertyName(AnnotatedParameter param)
  {
    PropertyName name = _annotationIntrospector.findNameForDeserialization(param);
    if ((name == null) || (name.isEmpty()))
    {
      String str = _annotationIntrospector.findImplicitPropertyName(param);
      if ((str != null) && (!str.isEmpty())) {
        name = PropertyName.construct(str);
      }
    }
    return name;
  }
  
  public Class<?> findPOJOBuilder()
  {
    return _annotationIntrospector == null ? null : _annotationIntrospector.findPOJOBuilder(_classInfo);
  }
  
  public JsonPOJOBuilder.Value findPOJOBuilderConfig()
  {
    return _annotationIntrospector == null ? null : _annotationIntrospector.findPOJOBuilderConfig(_classInfo);
  }
  
  public Converter<Object, Object> findDeserializationConverter()
  {
    if (_annotationIntrospector == null) {
      return null;
    }
    return _createConverter(_annotationIntrospector.findDeserializationConverter(_classInfo));
  }
  
  public LinkedHashMap<String, AnnotatedField> _findPropertyFields(Collection<String> ignoredProperties, boolean forSerialization)
  {
    LinkedHashMap<String, AnnotatedField> results = new LinkedHashMap();
    for (BeanPropertyDefinition property : _properties())
    {
      AnnotatedField f = property.getField();
      if (f != null)
      {
        String name = property.getName();
        if ((ignoredProperties == null) || 
          (!ignoredProperties.contains(name))) {
          results.put(name, f);
        }
      }
    }
    return results;
  }
  
  public Converter<Object, Object> _createConverter(Object converterDef)
  {
    if (converterDef == null) {
      return null;
    }
    if ((converterDef instanceof Converter)) {
      return (Converter)converterDef;
    }
    if (!(converterDef instanceof Class)) {
      throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + converterDef.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }
    Class<?> converterClass = (Class)converterDef;
    if ((converterClass == Converter.None.class) || (ClassUtil.isBogusClass(converterClass))) {
      return null;
    }
    if (!Converter.class.isAssignableFrom(converterClass)) {
      throw new IllegalStateException("AnnotationIntrospector returned Class " + converterClass.getName() + "; expected Class<Converter>");
    }
    HandlerInstantiator hi = _config.getHandlerInstantiator();
    Converter<?, ?> conv = hi == null ? null : hi.converterInstance(_config, _classInfo, converterClass);
    if (conv == null) {
      conv = (Converter)ClassUtil.createInstance(converterClass, _config.canOverrideAccessModifiers());
    }
    return conv;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BasicBeanDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */