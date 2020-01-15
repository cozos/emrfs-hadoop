package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.MapperFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BeanDeserializerBuilder
{
  protected final BeanDescription _beanDesc;
  protected final boolean _defaultViewInclusion;
  protected final boolean _caseInsensitivePropertyComparison;
  protected final Map<String, SettableBeanProperty> _properties = new LinkedHashMap();
  protected List<ValueInjector> _injectables;
  protected HashMap<String, SettableBeanProperty> _backRefProperties;
  protected HashSet<String> _ignorableProps;
  protected ValueInstantiator _valueInstantiator;
  protected ObjectIdReader _objectIdReader;
  protected SettableAnyProperty _anySetter;
  protected boolean _ignoreAllUnknown;
  protected AnnotatedMethod _buildMethod;
  protected JsonPOJOBuilder.Value _builderConfig;
  
  public BeanDeserializerBuilder(BeanDescription beanDesc, DeserializationConfig config)
  {
    _beanDesc = beanDesc;
    _defaultViewInclusion = config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
    _caseInsensitivePropertyComparison = config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
  }
  
  protected BeanDeserializerBuilder(BeanDeserializerBuilder src)
  {
    _beanDesc = _beanDesc;
    _defaultViewInclusion = _defaultViewInclusion;
    _caseInsensitivePropertyComparison = _caseInsensitivePropertyComparison;
    
    _properties.putAll(_properties);
    _injectables = _copy(_injectables);
    _backRefProperties = _copy(_backRefProperties);
    
    _ignorableProps = _ignorableProps;
    _valueInstantiator = _valueInstantiator;
    _objectIdReader = _objectIdReader;
    
    _anySetter = _anySetter;
    _ignoreAllUnknown = _ignoreAllUnknown;
    
    _buildMethod = _buildMethod;
    _builderConfig = _builderConfig;
  }
  
  private static HashMap<String, SettableBeanProperty> _copy(HashMap<String, SettableBeanProperty> src)
  {
    return src == null ? null : new HashMap(src);
  }
  
  private static <T> List<T> _copy(List<T> src)
  {
    return src == null ? null : new ArrayList(src);
  }
  
  public void addOrReplaceProperty(SettableBeanProperty prop, boolean allowOverride)
  {
    _properties.put(prop.getName(), prop);
  }
  
  public void addProperty(SettableBeanProperty prop)
  {
    SettableBeanProperty old = (SettableBeanProperty)_properties.put(prop.getName(), prop);
    if ((old != null) && (old != prop)) {
      throw new IllegalArgumentException("Duplicate property '" + prop.getName() + "' for " + _beanDesc.getType());
    }
  }
  
  public void addBackReferenceProperty(String referenceName, SettableBeanProperty prop)
  {
    if (_backRefProperties == null) {
      _backRefProperties = new HashMap(4);
    }
    _backRefProperties.put(referenceName, prop);
    if (_properties != null) {
      _properties.remove(prop.getName());
    }
  }
  
  public void addInjectable(PropertyName propName, JavaType propType, Annotations contextAnnotations, AnnotatedMember member, Object valueId)
  {
    if (_injectables == null) {
      _injectables = new ArrayList();
    }
    _injectables.add(new ValueInjector(propName, propType, contextAnnotations, member, valueId));
  }
  
  public void addIgnorable(String propName)
  {
    if (_ignorableProps == null) {
      _ignorableProps = new HashSet();
    }
    _ignorableProps.add(propName);
  }
  
  public void addCreatorProperty(SettableBeanProperty prop)
  {
    addProperty(prop);
  }
  
  public void setAnySetter(SettableAnyProperty s)
  {
    if ((_anySetter != null) && (s != null)) {
      throw new IllegalStateException("_anySetter already set to non-null");
    }
    _anySetter = s;
  }
  
  public void setIgnoreUnknownProperties(boolean ignore)
  {
    _ignoreAllUnknown = ignore;
  }
  
  public void setValueInstantiator(ValueInstantiator inst)
  {
    _valueInstantiator = inst;
  }
  
  public void setObjectIdReader(ObjectIdReader r)
  {
    _objectIdReader = r;
  }
  
  public void setPOJOBuilder(AnnotatedMethod buildMethod, JsonPOJOBuilder.Value config)
  {
    _buildMethod = buildMethod;
    _builderConfig = config;
  }
  
  public Iterator<SettableBeanProperty> getProperties()
  {
    return _properties.values().iterator();
  }
  
  public SettableBeanProperty findProperty(PropertyName propertyName)
  {
    return (SettableBeanProperty)_properties.get(propertyName.getSimpleName());
  }
  
  public boolean hasProperty(PropertyName propertyName)
  {
    return findProperty(propertyName) != null;
  }
  
  public SettableBeanProperty removeProperty(PropertyName name)
  {
    return (SettableBeanProperty)_properties.remove(name.getSimpleName());
  }
  
  public SettableAnyProperty getAnySetter()
  {
    return _anySetter;
  }
  
  public ValueInstantiator getValueInstantiator()
  {
    return _valueInstantiator;
  }
  
  public List<ValueInjector> getInjectables()
  {
    return _injectables;
  }
  
  public ObjectIdReader getObjectIdReader()
  {
    return _objectIdReader;
  }
  
  public AnnotatedMethod getBuildMethod()
  {
    return _buildMethod;
  }
  
  public JsonPOJOBuilder.Value getBuilderConfig()
  {
    return _builderConfig;
  }
  
  public JsonDeserializer<?> build()
  {
    Collection<SettableBeanProperty> props = _properties.values();
    BeanPropertyMap propertyMap = BeanPropertyMap.construct(props, _caseInsensitivePropertyComparison);
    propertyMap.assignIndexes();
    
    boolean anyViews = !_defaultViewInclusion;
    if (!anyViews) {
      for (SettableBeanProperty prop : props) {
        if (prop.hasViews())
        {
          anyViews = true;
          break;
        }
      }
    }
    if (_objectIdReader != null)
    {
      ObjectIdValueProperty prop = new ObjectIdValueProperty(_objectIdReader, PropertyMetadata.STD_REQUIRED);
      propertyMap = propertyMap.withProperty(prop);
    }
    return new BeanDeserializer(this, _beanDesc, propertyMap, _backRefProperties, _ignorableProps, _ignoreAllUnknown, anyViews);
  }
  
  public AbstractDeserializer buildAbstract()
  {
    return new AbstractDeserializer(this, _beanDesc, _backRefProperties);
  }
  
  public JsonDeserializer<?> buildBuilderBased(JavaType valueType, String expBuildMethodName)
  {
    if (_buildMethod == null)
    {
      if (!expBuildMethodName.isEmpty()) {
        throw new IllegalArgumentException("Builder class " + _beanDesc.getBeanClass().getName() + " does not have build method (name: '" + expBuildMethodName + "')");
      }
    }
    else
    {
      Class<?> rawBuildType = _buildMethod.getRawReturnType();
      Class<?> rawValueType = valueType.getRawClass();
      if ((rawBuildType != rawValueType) && (!rawBuildType.isAssignableFrom(rawValueType)) && (!rawValueType.isAssignableFrom(rawBuildType))) {
        throw new IllegalArgumentException("Build method '" + _buildMethod.getFullName() + " has bad return type (" + rawBuildType.getName() + "), not compatible with POJO type (" + valueType.getRawClass().getName() + ")");
      }
    }
    Collection<SettableBeanProperty> props = _properties.values();
    BeanPropertyMap propertyMap = BeanPropertyMap.construct(props, _caseInsensitivePropertyComparison);
    propertyMap.assignIndexes();
    
    boolean anyViews = !_defaultViewInclusion;
    if (!anyViews) {
      for (SettableBeanProperty prop : props) {
        if (prop.hasViews())
        {
          anyViews = true;
          break;
        }
      }
    }
    if (_objectIdReader != null)
    {
      ObjectIdValueProperty prop = new ObjectIdValueProperty(_objectIdReader, PropertyMetadata.STD_REQUIRED);
      
      propertyMap = propertyMap.withProperty(prop);
    }
    return new BuilderBasedDeserializer(this, _beanDesc, propertyMap, _backRefProperties, _ignorableProps, _ignoreAllUnknown, anyViews);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */