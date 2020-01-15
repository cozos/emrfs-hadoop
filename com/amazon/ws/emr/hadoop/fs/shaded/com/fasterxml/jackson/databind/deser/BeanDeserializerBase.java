package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty.Std;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.InnerClassProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ManagedReferenceProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ClassKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BeanDeserializerBase
  extends StdDeserializer<Object>
  implements ContextualDeserializer, ResolvableDeserializer, Serializable
{
  private static final long serialVersionUID = 1L;
  protected static final PropertyName TEMP_PROPERTY_NAME = new PropertyName("#temporary-name");
  private final transient Annotations _classAnnotations;
  protected final JavaType _beanType;
  protected final JsonFormat.Shape _serializationShape;
  protected final ValueInstantiator _valueInstantiator;
  protected JsonDeserializer<Object> _delegateDeserializer;
  protected PropertyBasedCreator _propertyBasedCreator;
  protected boolean _nonStandardCreation;
  protected boolean _vanillaProcessing;
  protected final BeanPropertyMap _beanProperties;
  protected final ValueInjector[] _injectables;
  protected SettableAnyProperty _anySetter;
  protected final HashSet<String> _ignorableProps;
  protected final boolean _ignoreAllUnknown;
  protected final boolean _needViewProcesing;
  protected final Map<String, SettableBeanProperty> _backRefs;
  protected transient HashMap<ClassKey, JsonDeserializer<Object>> _subDeserializers;
  protected UnwrappedPropertyHandler _unwrappedPropertyHandler;
  protected ExternalTypeHandler _externalTypeIdHandler;
  protected final ObjectIdReader _objectIdReader;
  
  protected BeanDeserializerBase(BeanDeserializerBuilder builder, BeanDescription beanDesc, BeanPropertyMap properties, Map<String, SettableBeanProperty> backRefs, HashSet<String> ignorableProps, boolean ignoreAllUnknown, boolean hasViews)
  {
    super(beanDesc.getType());
    
    AnnotatedClass ac = beanDesc.getClassInfo();
    _classAnnotations = ac.getAnnotations();
    _beanType = beanDesc.getType();
    _valueInstantiator = builder.getValueInstantiator();
    
    _beanProperties = properties;
    _backRefs = backRefs;
    _ignorableProps = ignorableProps;
    _ignoreAllUnknown = ignoreAllUnknown;
    
    _anySetter = builder.getAnySetter();
    List<ValueInjector> injectables = builder.getInjectables();
    _injectables = ((injectables == null) || (injectables.isEmpty()) ? null : (ValueInjector[])injectables.toArray(new ValueInjector[injectables.size()]));
    
    _objectIdReader = builder.getObjectIdReader();
    _nonStandardCreation = ((_unwrappedPropertyHandler != null) || (_valueInstantiator.canCreateUsingDelegate()) || (_valueInstantiator.canCreateFromObjectWith()) || (!_valueInstantiator.canCreateUsingDefault()));
    
    JsonFormat.Value format = beanDesc.findExpectedFormat(null);
    _serializationShape = (format == null ? null : format.getShape());
    
    _needViewProcesing = hasViews;
    _vanillaProcessing = ((!_nonStandardCreation) && (_injectables == null) && (!_needViewProcesing) && (_objectIdReader == null));
  }
  
  protected BeanDeserializerBase(BeanDeserializerBase src)
  {
    this(src, _ignoreAllUnknown);
  }
  
  protected BeanDeserializerBase(BeanDeserializerBase src, boolean ignoreAllUnknown)
  {
    super(_beanType);
    
    _classAnnotations = _classAnnotations;
    _beanType = _beanType;
    
    _valueInstantiator = _valueInstantiator;
    _delegateDeserializer = _delegateDeserializer;
    _propertyBasedCreator = _propertyBasedCreator;
    
    _beanProperties = _beanProperties;
    _backRefs = _backRefs;
    _ignorableProps = _ignorableProps;
    _ignoreAllUnknown = ignoreAllUnknown;
    _anySetter = _anySetter;
    _injectables = _injectables;
    _objectIdReader = _objectIdReader;
    
    _nonStandardCreation = _nonStandardCreation;
    _unwrappedPropertyHandler = _unwrappedPropertyHandler;
    _needViewProcesing = _needViewProcesing;
    _serializationShape = _serializationShape;
    
    _vanillaProcessing = _vanillaProcessing;
  }
  
  protected BeanDeserializerBase(BeanDeserializerBase src, NameTransformer unwrapper)
  {
    super(_beanType);
    
    _classAnnotations = _classAnnotations;
    _beanType = _beanType;
    
    _valueInstantiator = _valueInstantiator;
    _delegateDeserializer = _delegateDeserializer;
    _propertyBasedCreator = _propertyBasedCreator;
    
    _backRefs = _backRefs;
    _ignorableProps = _ignorableProps;
    _ignoreAllUnknown = ((unwrapper != null) || (_ignoreAllUnknown));
    _anySetter = _anySetter;
    _injectables = _injectables;
    _objectIdReader = _objectIdReader;
    
    _nonStandardCreation = _nonStandardCreation;
    UnwrappedPropertyHandler uph = _unwrappedPropertyHandler;
    if (unwrapper != null)
    {
      if (uph != null) {
        uph = uph.renameAll(unwrapper);
      }
      _beanProperties = _beanProperties.renameAll(unwrapper);
    }
    else
    {
      _beanProperties = _beanProperties;
    }
    _unwrappedPropertyHandler = uph;
    _needViewProcesing = _needViewProcesing;
    _serializationShape = _serializationShape;
    
    _vanillaProcessing = false;
  }
  
  public BeanDeserializerBase(BeanDeserializerBase src, ObjectIdReader oir)
  {
    super(_beanType);
    
    _classAnnotations = _classAnnotations;
    _beanType = _beanType;
    
    _valueInstantiator = _valueInstantiator;
    _delegateDeserializer = _delegateDeserializer;
    _propertyBasedCreator = _propertyBasedCreator;
    
    _backRefs = _backRefs;
    _ignorableProps = _ignorableProps;
    _ignoreAllUnknown = _ignoreAllUnknown;
    _anySetter = _anySetter;
    _injectables = _injectables;
    
    _nonStandardCreation = _nonStandardCreation;
    _unwrappedPropertyHandler = _unwrappedPropertyHandler;
    _needViewProcesing = _needViewProcesing;
    _serializationShape = _serializationShape;
    
    _objectIdReader = oir;
    if (oir == null)
    {
      _beanProperties = _beanProperties;
      _vanillaProcessing = _vanillaProcessing;
    }
    else
    {
      ObjectIdValueProperty idProp = new ObjectIdValueProperty(oir, PropertyMetadata.STD_REQUIRED);
      _beanProperties = _beanProperties.withProperty(idProp);
      _vanillaProcessing = false;
    }
  }
  
  public BeanDeserializerBase(BeanDeserializerBase src, HashSet<String> ignorableProps)
  {
    super(_beanType);
    
    _classAnnotations = _classAnnotations;
    _beanType = _beanType;
    
    _valueInstantiator = _valueInstantiator;
    _delegateDeserializer = _delegateDeserializer;
    _propertyBasedCreator = _propertyBasedCreator;
    
    _backRefs = _backRefs;
    _ignorableProps = ignorableProps;
    _ignoreAllUnknown = _ignoreAllUnknown;
    _anySetter = _anySetter;
    _injectables = _injectables;
    
    _nonStandardCreation = _nonStandardCreation;
    _unwrappedPropertyHandler = _unwrappedPropertyHandler;
    _needViewProcesing = _needViewProcesing;
    _serializationShape = _serializationShape;
    
    _vanillaProcessing = _vanillaProcessing;
    _objectIdReader = _objectIdReader;
    _beanProperties = _beanProperties;
  }
  
  public abstract JsonDeserializer<Object> unwrappingDeserializer(NameTransformer paramNameTransformer);
  
  public abstract BeanDeserializerBase withObjectIdReader(ObjectIdReader paramObjectIdReader);
  
  public abstract BeanDeserializerBase withIgnorableProperties(HashSet<String> paramHashSet);
  
  protected abstract BeanDeserializerBase asArrayDeserializer();
  
  public void resolve(DeserializationContext ctxt)
    throws JsonMappingException
  {
    ExternalTypeHandler.Builder extTypes = null;
    SettableBeanProperty[] creatorProps;
    if (_valueInstantiator.canCreateFromObjectWith())
    {
      SettableBeanProperty[] creatorProps = _valueInstantiator.getFromObjectArguments(ctxt.getConfig());
      for (SettableBeanProperty prop : creatorProps) {
        if (prop.hasValueTypeDeserializer())
        {
          TypeDeserializer typeDeser = prop.getValueTypeDeserializer();
          if (typeDeser.getTypeInclusion() == JsonTypeInfo.As.EXTERNAL_PROPERTY)
          {
            if (extTypes == null) {
              extTypes = new ExternalTypeHandler.Builder();
            }
            extTypes.addExternal(prop, typeDeser);
          }
        }
      }
    }
    else
    {
      creatorProps = null;
    }
    UnwrappedPropertyHandler unwrapped = null;
    for (SettableBeanProperty origProp : _beanProperties)
    {
      SettableBeanProperty prop = origProp;
      if (!prop.hasValueDeserializer())
      {
        JsonDeserializer<?> deser = findConvertingDeserializer(ctxt, prop);
        if (deser == null) {
          deser = findDeserializer(ctxt, prop.getType(), prop);
        }
        prop = prop.withValueDeserializer(deser);
      }
      else
      {
        JsonDeserializer<Object> deser = prop.getValueDeserializer();
        
        JsonDeserializer<?> cd = ctxt.handlePrimaryContextualization(deser, prop, prop.getType());
        if (cd != deser) {
          prop = prop.withValueDeserializer(cd);
        }
      }
      prop = _resolveManagedReferenceProperty(ctxt, prop);
      if (!(prop instanceof ManagedReferenceProperty)) {
        prop = _resolvedObjectIdProperty(ctxt, prop);
      }
      SettableBeanProperty u = _resolveUnwrappedProperty(ctxt, prop);
      if (u != null)
      {
        prop = u;
        if (unwrapped == null) {
          unwrapped = new UnwrappedPropertyHandler();
        }
        unwrapped.addProperty(prop);
        
        _beanProperties.remove(prop);
      }
      else
      {
        prop = _resolveInnerClassValuedProperty(ctxt, prop);
        if (prop != origProp)
        {
          _beanProperties.replace(prop);
          if (creatorProps != null)
          {
            int i = 0;
            for (int len = creatorProps.length; i < len; i++) {
              if (creatorProps[i] == origProp)
              {
                creatorProps[i] = prop;
                break;
              }
            }
          }
        }
        if (prop.hasValueTypeDeserializer())
        {
          TypeDeserializer typeDeser = prop.getValueTypeDeserializer();
          if (typeDeser.getTypeInclusion() == JsonTypeInfo.As.EXTERNAL_PROPERTY)
          {
            if (extTypes == null) {
              extTypes = new ExternalTypeHandler.Builder();
            }
            extTypes.addExternal(prop, typeDeser);
            
            _beanProperties.remove(prop);
          }
        }
      }
    }
    if ((_anySetter != null) && (!_anySetter.hasValueDeserializer())) {
      _anySetter = _anySetter.withValueDeserializer(findDeserializer(ctxt, _anySetter.getType(), _anySetter.getProperty()));
    }
    if (_valueInstantiator.canCreateUsingDelegate())
    {
      JavaType delegateType = _valueInstantiator.getDelegateType(ctxt.getConfig());
      if (delegateType == null) {
        throw new IllegalArgumentException("Invalid delegate-creator definition for " + _beanType + ": value instantiator (" + _valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
      }
      AnnotatedWithParams delegateCreator = _valueInstantiator.getDelegateCreator();
      
      BeanProperty.Std property = new BeanProperty.Std(TEMP_PROPERTY_NAME, delegateType, null, _classAnnotations, delegateCreator, PropertyMetadata.STD_OPTIONAL);
      
      TypeDeserializer td = (TypeDeserializer)delegateType.getTypeHandler();
      if (td == null) {
        td = ctxt.getConfig().findTypeDeserializer(delegateType);
      }
      JsonDeserializer<Object> dd = findDeserializer(ctxt, delegateType, property);
      if (td != null)
      {
        td = td.forProperty(property);
        dd = new TypeWrappedDeserializer(td, dd);
      }
      _delegateDeserializer = dd;
    }
    if (creatorProps != null) {
      _propertyBasedCreator = PropertyBasedCreator.construct(ctxt, _valueInstantiator, creatorProps);
    }
    if (extTypes != null)
    {
      _externalTypeIdHandler = extTypes.build();
      
      _nonStandardCreation = true;
    }
    _unwrappedPropertyHandler = unwrapped;
    if (unwrapped != null) {
      _nonStandardCreation = true;
    }
    _vanillaProcessing = ((_vanillaProcessing) && (!_nonStandardCreation));
  }
  
  protected JsonDeserializer<Object> findConvertingDeserializer(DeserializationContext ctxt, SettableBeanProperty prop)
    throws JsonMappingException
  {
    AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
    if (intr != null)
    {
      Object convDef = intr.findDeserializationConverter(prop.getMember());
      if (convDef != null)
      {
        Converter<Object, Object> conv = ctxt.converterInstance(prop.getMember(), convDef);
        JavaType delegateType = conv.getInputType(ctxt.getTypeFactory());
        JsonDeserializer<?> ser = ctxt.findContextualValueDeserializer(delegateType, prop);
        return new StdDelegatingDeserializer(conv, delegateType, ser);
      }
    }
    return null;
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    ObjectIdReader oir = _objectIdReader;
    
    AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
    AnnotatedMember accessor = (property == null) || (intr == null) ? null : property.getMember();
    if ((accessor != null) && (intr != null))
    {
      ObjectIdInfo objectIdInfo = intr.findObjectIdInfo(accessor);
      if (objectIdInfo != null)
      {
        objectIdInfo = intr.findObjectReferenceInfo(accessor, objectIdInfo);
        
        Class<?> implClass = objectIdInfo.getGeneratorType();
        
        ObjectIdResolver resolver = ctxt.objectIdResolverInstance(accessor, objectIdInfo);
        ObjectIdGenerator<?> idGen;
        JavaType idType;
        SettableBeanProperty idProp;
        ObjectIdGenerator<?> idGen;
        if (implClass == ObjectIdGenerators.PropertyGenerator.class)
        {
          PropertyName propName = objectIdInfo.getPropertyName();
          SettableBeanProperty idProp = findProperty(propName);
          if (idProp == null) {
            throw new IllegalArgumentException("Invalid Object Id definition for " + handledType().getName() + ": can not find property with name '" + propName + "'");
          }
          JavaType idType = idProp.getType();
          idGen = new PropertyBasedObjectIdGenerator(objectIdInfo.getScope());
        }
        else
        {
          JavaType type = ctxt.constructType(implClass);
          idType = ctxt.getTypeFactory().findTypeParameters(type, ObjectIdGenerator.class)[0];
          idProp = null;
          idGen = ctxt.objectIdGeneratorInstance(accessor, objectIdInfo);
        }
        JsonDeserializer<?> deser = ctxt.findRootValueDeserializer(idType);
        oir = ObjectIdReader.construct(idType, objectIdInfo.getPropertyName(), idGen, deser, idProp, resolver);
      }
    }
    BeanDeserializerBase contextual = this;
    if ((oir != null) && (oir != _objectIdReader)) {
      contextual = contextual.withObjectIdReader(oir);
    }
    if (accessor != null)
    {
      String[] ignorals = intr.findPropertiesToIgnore(accessor, false);
      if ((ignorals != null) && (ignorals.length != 0))
      {
        HashSet<String> newIgnored = ArrayBuilders.setAndArray(_ignorableProps, ignorals);
        contextual = contextual.withIgnorableProperties(newIgnored);
      }
    }
    JsonFormat.Shape shape = null;
    if (accessor != null)
    {
      JsonFormat.Value format = intr.findFormat(accessor);
      if (format != null) {
        shape = format.getShape();
      }
    }
    if (shape == null) {
      shape = _serializationShape;
    }
    if (shape == JsonFormat.Shape.ARRAY) {
      contextual = contextual.asArrayDeserializer();
    }
    return contextual;
  }
  
  protected SettableBeanProperty _resolveManagedReferenceProperty(DeserializationContext ctxt, SettableBeanProperty prop)
  {
    String refName = prop.getManagedReferenceName();
    if (refName == null) {
      return prop;
    }
    JsonDeserializer<?> valueDeser = prop.getValueDeserializer();
    SettableBeanProperty backProp = valueDeser.findBackReference(refName);
    if (backProp == null) {
      throw new IllegalArgumentException("Can not handle managed/back reference '" + refName + "': no back reference property found from type " + prop.getType());
    }
    JavaType referredType = _beanType;
    JavaType backRefType = backProp.getType();
    boolean isContainer = prop.getType().isContainerType();
    if (!backRefType.getRawClass().isAssignableFrom(referredType.getRawClass())) {
      throw new IllegalArgumentException("Can not handle managed/back reference '" + refName + "': back reference type (" + backRefType.getRawClass().getName() + ") not compatible with managed type (" + referredType.getRawClass().getName() + ")");
    }
    return new ManagedReferenceProperty(prop, refName, backProp, _classAnnotations, isContainer);
  }
  
  protected SettableBeanProperty _resolvedObjectIdProperty(DeserializationContext ctxt, SettableBeanProperty prop)
  {
    ObjectIdInfo objectIdInfo = prop.getObjectIdInfo();
    JsonDeserializer<Object> valueDeser = prop.getValueDeserializer();
    ObjectIdReader objectIdReader = valueDeser.getObjectIdReader();
    if ((objectIdInfo == null) && (objectIdReader == null)) {
      return prop;
    }
    return new ObjectIdReferenceProperty(prop, objectIdInfo);
  }
  
  protected SettableBeanProperty _resolveUnwrappedProperty(DeserializationContext ctxt, SettableBeanProperty prop)
  {
    AnnotatedMember am = prop.getMember();
    if (am != null)
    {
      NameTransformer unwrapper = ctxt.getAnnotationIntrospector().findUnwrappingNameTransformer(am);
      if (unwrapper != null)
      {
        JsonDeserializer<Object> orig = prop.getValueDeserializer();
        JsonDeserializer<Object> unwrapping = orig.unwrappingDeserializer(unwrapper);
        if ((unwrapping != orig) && (unwrapping != null)) {
          return prop.withValueDeserializer(unwrapping);
        }
      }
    }
    return null;
  }
  
  protected SettableBeanProperty _resolveInnerClassValuedProperty(DeserializationContext ctxt, SettableBeanProperty prop)
  {
    JsonDeserializer<Object> deser = prop.getValueDeserializer();
    if ((deser instanceof BeanDeserializerBase))
    {
      BeanDeserializerBase bd = (BeanDeserializerBase)deser;
      ValueInstantiator vi = bd.getValueInstantiator();
      if (!vi.canCreateUsingDefault())
      {
        Class<?> valueClass = prop.getType().getRawClass();
        Class<?> enclosing = ClassUtil.getOuterClass(valueClass);
        if ((enclosing != null) && (enclosing == _beanType.getRawClass())) {
          for (Constructor<?> ctor : valueClass.getConstructors())
          {
            Class<?>[] paramTypes = ctor.getParameterTypes();
            if ((paramTypes.length == 1) && (paramTypes[0] == enclosing))
            {
              if (ctxt.getConfig().canOverrideAccessModifiers()) {
                ClassUtil.checkAndFixAccess(ctor);
              }
              return new InnerClassProperty(prop, ctor);
            }
          }
        }
      }
    }
    return prop;
  }
  
  public boolean isCachable()
  {
    return true;
  }
  
  public Class<?> handledType()
  {
    return _beanType.getRawClass();
  }
  
  public ObjectIdReader getObjectIdReader()
  {
    return _objectIdReader;
  }
  
  public boolean hasProperty(String propertyName)
  {
    return _beanProperties.find(propertyName) != null;
  }
  
  public boolean hasViews()
  {
    return _needViewProcesing;
  }
  
  public int getPropertyCount()
  {
    return _beanProperties.size();
  }
  
  public Collection<Object> getKnownPropertyNames()
  {
    ArrayList<Object> names = new ArrayList();
    for (SettableBeanProperty prop : _beanProperties) {
      names.add(prop.getName());
    }
    return names;
  }
  
  @Deprecated
  public final Class<?> getBeanClass()
  {
    return _beanType.getRawClass();
  }
  
  public JavaType getValueType()
  {
    return _beanType;
  }
  
  public Iterator<SettableBeanProperty> properties()
  {
    if (_beanProperties == null) {
      throw new IllegalStateException("Can only call after BeanDeserializer has been resolved");
    }
    return _beanProperties.iterator();
  }
  
  public Iterator<SettableBeanProperty> creatorProperties()
  {
    if (_propertyBasedCreator == null) {
      return Collections.emptyList().iterator();
    }
    return _propertyBasedCreator.properties().iterator();
  }
  
  public SettableBeanProperty findProperty(PropertyName propertyName)
  {
    return findProperty(propertyName.getSimpleName());
  }
  
  public SettableBeanProperty findProperty(String propertyName)
  {
    SettableBeanProperty prop = _beanProperties == null ? null : _beanProperties.find(propertyName);
    if ((prop == null) && (_propertyBasedCreator != null)) {
      prop = _propertyBasedCreator.findCreatorProperty(propertyName);
    }
    return prop;
  }
  
  public SettableBeanProperty findProperty(int propertyIndex)
  {
    SettableBeanProperty prop = _beanProperties == null ? null : _beanProperties.find(propertyIndex);
    if ((prop == null) && (_propertyBasedCreator != null)) {
      prop = _propertyBasedCreator.findCreatorProperty(propertyIndex);
    }
    return prop;
  }
  
  public SettableBeanProperty findBackReference(String logicalName)
  {
    if (_backRefs == null) {
      return null;
    }
    return (SettableBeanProperty)_backRefs.get(logicalName);
  }
  
  public ValueInstantiator getValueInstantiator()
  {
    return _valueInstantiator;
  }
  
  public void replaceProperty(SettableBeanProperty original, SettableBeanProperty replacement)
  {
    _beanProperties.replace(replacement);
  }
  
  public abstract Object deserializeFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException;
  
  public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    if (_objectIdReader != null)
    {
      if (p.canReadObjectId())
      {
        Object id = p.getObjectId();
        if (id != null)
        {
          Object ob = typeDeserializer.deserializeTypedFromObject(p, ctxt);
          return _handleTypedObjectId(p, ctxt, ob, id);
        }
      }
      JsonToken t = p.getCurrentToken();
      if (t != null)
      {
        if (t.isScalarValue()) {
          return deserializeFromObjectId(p, ctxt);
        }
        if (t == JsonToken.START_OBJECT) {
          t = p.nextToken();
        }
        if ((t == JsonToken.FIELD_NAME) && (_objectIdReader.maySerializeAsObject()) && (_objectIdReader.isValidReferencePropertyName(p.getCurrentName(), p))) {
          return deserializeFromObjectId(p, ctxt);
        }
      }
    }
    return typeDeserializer.deserializeTypedFromObject(p, ctxt);
  }
  
  protected Object _handleTypedObjectId(JsonParser jp, DeserializationContext ctxt, Object pojo, Object rawId)
    throws IOException
  {
    JsonDeserializer<Object> idDeser = _objectIdReader.getDeserializer();
    Object id;
    Object id;
    if (idDeser.handledType() == rawId.getClass()) {
      id = rawId;
    } else {
      id = _convertObjectId(jp, ctxt, rawId, idDeser);
    }
    ReadableObjectId roid = ctxt.findObjectId(id, _objectIdReader.generator, _objectIdReader.resolver);
    roid.bindItem(pojo);
    
    SettableBeanProperty idProp = _objectIdReader.idProperty;
    if (idProp != null) {
      return idProp.setAndReturn(pojo, id);
    }
    return pojo;
  }
  
  protected Object _convertObjectId(JsonParser p, DeserializationContext ctxt, Object rawId, JsonDeserializer<Object> idDeser)
    throws IOException
  {
    TokenBuffer buf = new TokenBuffer(p, ctxt);
    if ((rawId instanceof String)) {
      buf.writeString((String)rawId);
    } else if ((rawId instanceof Long)) {
      buf.writeNumber(((Long)rawId).longValue());
    } else if ((rawId instanceof Integer)) {
      buf.writeNumber(((Integer)rawId).intValue());
    } else {
      buf.writeObject(rawId);
    }
    JsonParser bufParser = buf.asParser();
    bufParser.nextToken();
    return idDeser.deserialize(bufParser, ctxt);
  }
  
  protected Object deserializeWithObjectId(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return deserializeFromObject(jp, ctxt);
  }
  
  protected Object deserializeFromObjectId(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    Object id = _objectIdReader.readObjectReference(jp, ctxt);
    ReadableObjectId roid = ctxt.findObjectId(id, _objectIdReader.generator, _objectIdReader.resolver);
    
    Object pojo = roid.resolve();
    if (pojo == null) {
      throw new UnresolvedForwardReference("Could not resolve Object Id [" + id + "] (for " + _beanType + ").", jp.getCurrentLocation(), roid);
    }
    return pojo;
  }
  
  protected Object deserializeFromObjectUsingNonDefault(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(jp, ctxt));
    }
    if (_propertyBasedCreator != null) {
      return _deserializeUsingPropertyBased(jp, ctxt);
    }
    if (_beanType.isAbstract()) {
      throw JsonMappingException.from(jp, "Can not instantiate abstract type " + _beanType + " (need to add/enable type information?)");
    }
    throw JsonMappingException.from(jp, "No suitable constructor found for type " + _beanType + ": can not instantiate from JSON object (missing default constructor or creator, or perhaps need to add/enable type information?)");
  }
  
  protected abstract Object _deserializeUsingPropertyBased(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException;
  
  public Object deserializeFromNumber(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (_objectIdReader != null) {
      return deserializeFromObjectId(jp, ctxt);
    }
    switch (jp.getNumberType())
    {
    case INT: 
      if ((_delegateDeserializer != null) && 
        (!_valueInstantiator.canCreateFromInt()))
      {
        Object bean = _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(jp, ctxt));
        if (_injectables != null) {
          injectValues(ctxt, bean);
        }
        return bean;
      }
      return _valueInstantiator.createFromInt(ctxt, jp.getIntValue());
    case LONG: 
      if ((_delegateDeserializer != null) && 
        (!_valueInstantiator.canCreateFromInt()))
      {
        Object bean = _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(jp, ctxt));
        if (_injectables != null) {
          injectValues(ctxt, bean);
        }
        return bean;
      }
      return _valueInstantiator.createFromLong(ctxt, jp.getLongValue());
    }
    if (_delegateDeserializer != null)
    {
      Object bean = _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(jp, ctxt));
      if (_injectables != null) {
        injectValues(ctxt, bean);
      }
      return bean;
    }
    throw ctxt.instantiationException(handledType(), "no suitable creator method found to deserialize from JSON integer number");
  }
  
  public Object deserializeFromString(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (_objectIdReader != null) {
      return deserializeFromObjectId(p, ctxt);
    }
    if ((_delegateDeserializer != null) && 
      (!_valueInstantiator.canCreateFromString()))
    {
      Object bean = _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(p, ctxt));
      if (_injectables != null) {
        injectValues(ctxt, bean);
      }
      return bean;
    }
    return _valueInstantiator.createFromString(ctxt, p.getText());
  }
  
  public Object deserializeFromDouble(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    switch (p.getNumberType())
    {
    case FLOAT: 
    case DOUBLE: 
      if ((_delegateDeserializer != null) && 
        (!_valueInstantiator.canCreateFromDouble()))
      {
        Object bean = _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(p, ctxt));
        if (_injectables != null) {
          injectValues(ctxt, bean);
        }
        return bean;
      }
      return _valueInstantiator.createFromDouble(ctxt, p.getDoubleValue());
    }
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(p, ctxt));
    }
    throw ctxt.instantiationException(handledType(), "no suitable creator method found to deserialize from JSON floating-point number");
  }
  
  public Object deserializeFromBoolean(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if ((_delegateDeserializer != null) && 
      (!_valueInstantiator.canCreateFromBoolean()))
    {
      Object bean = _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(p, ctxt));
      if (_injectables != null) {
        injectValues(ctxt, bean);
      }
      return bean;
    }
    boolean value = p.getCurrentToken() == JsonToken.VALUE_TRUE;
    return _valueInstantiator.createFromBoolean(ctxt, value);
  }
  
  public Object deserializeFromArray(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (_delegateDeserializer != null) {
      try
      {
        Object bean = _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(p, ctxt));
        if (_injectables != null) {
          injectValues(ctxt, bean);
        }
        return bean;
      }
      catch (Exception e)
      {
        wrapInstantiationProblem(e, ctxt);
      }
    }
    if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS))
    {
      JsonToken t = p.nextToken();
      if ((t == JsonToken.END_ARRAY) && (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT))) {
        return null;
      }
      Object value = deserialize(p, ctxt);
      if (p.nextToken() != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + _valueClass.getName() + "' value but there was more than a single value in the array");
      }
      return value;
    }
    if (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT))
    {
      JsonToken t = p.nextToken();
      if (t == JsonToken.END_ARRAY) {
        return null;
      }
      throw ctxt.mappingException(handledType(), JsonToken.START_ARRAY);
    }
    throw ctxt.mappingException(handledType());
  }
  
  public Object deserializeFromEmbedded(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (_objectIdReader != null) {
      return deserializeFromObjectId(jp, ctxt);
    }
    return jp.getEmbeddedObject();
  }
  
  protected void injectValues(DeserializationContext ctxt, Object bean)
    throws IOException, JsonProcessingException
  {
    for (ValueInjector injector : _injectables) {
      injector.inject(ctxt, bean);
    }
  }
  
  protected Object handleUnknownProperties(DeserializationContext ctxt, Object bean, TokenBuffer unknownTokens)
    throws IOException, JsonProcessingException
  {
    unknownTokens.writeEndObject();
    
    JsonParser bufferParser = unknownTokens.asParser();
    while (bufferParser.nextToken() != JsonToken.END_OBJECT)
    {
      String propName = bufferParser.getCurrentName();
      
      bufferParser.nextToken();
      handleUnknownProperty(bufferParser, ctxt, bean, propName);
    }
    return bean;
  }
  
  protected void handleUnknownVanilla(JsonParser jp, DeserializationContext ctxt, Object bean, String propName)
    throws IOException, JsonProcessingException
  {
    if ((_ignorableProps != null) && (_ignorableProps.contains(propName))) {
      handleIgnoredProperty(jp, ctxt, bean, propName);
    } else if (_anySetter != null) {
      try
      {
        _anySetter.deserializeAndSet(jp, ctxt, bean, propName);
      }
      catch (Exception e)
      {
        wrapAndThrow(e, bean, propName, ctxt);
      }
    } else {
      handleUnknownProperty(jp, ctxt, bean, propName);
    }
  }
  
  protected void handleUnknownProperty(JsonParser jp, DeserializationContext ctxt, Object beanOrClass, String propName)
    throws IOException, JsonProcessingException
  {
    if (_ignoreAllUnknown)
    {
      jp.skipChildren();
      return;
    }
    if ((_ignorableProps != null) && (_ignorableProps.contains(propName))) {
      handleIgnoredProperty(jp, ctxt, beanOrClass, propName);
    }
    super.handleUnknownProperty(jp, ctxt, beanOrClass, propName);
  }
  
  protected void handleIgnoredProperty(JsonParser jp, DeserializationContext ctxt, Object beanOrClass, String propName)
    throws IOException, JsonProcessingException
  {
    if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)) {
      throw IgnoredPropertyException.from(jp, beanOrClass, propName, getKnownPropertyNames());
    }
    jp.skipChildren();
  }
  
  protected Object handlePolymorphic(JsonParser jp, DeserializationContext ctxt, Object bean, TokenBuffer unknownTokens)
    throws IOException, JsonProcessingException
  {
    JsonDeserializer<Object> subDeser = _findSubclassDeserializer(ctxt, bean, unknownTokens);
    if (subDeser != null)
    {
      if (unknownTokens != null)
      {
        unknownTokens.writeEndObject();
        JsonParser p2 = unknownTokens.asParser();
        p2.nextToken();
        bean = subDeser.deserialize(p2, ctxt, bean);
      }
      if (jp != null) {
        bean = subDeser.deserialize(jp, ctxt, bean);
      }
      return bean;
    }
    if (unknownTokens != null) {
      bean = handleUnknownProperties(ctxt, bean, unknownTokens);
    }
    if (jp != null) {
      bean = deserialize(jp, ctxt, bean);
    }
    return bean;
  }
  
  protected JsonDeserializer<Object> _findSubclassDeserializer(DeserializationContext ctxt, Object bean, TokenBuffer unknownTokens)
    throws IOException, JsonProcessingException
  {
    synchronized (this)
    {
      subDeser = _subDeserializers == null ? null : (JsonDeserializer)_subDeserializers.get(new ClassKey(bean.getClass()));
    }
    if (subDeser != null) {
      return subDeser;
    }
    JavaType type = ctxt.constructType(bean.getClass());
    
    JsonDeserializer<Object> subDeser = ctxt.findRootValueDeserializer(type);
    if (subDeser != null) {
      synchronized (this)
      {
        if (_subDeserializers == null) {
          _subDeserializers = new HashMap();
        }
        _subDeserializers.put(new ClassKey(bean.getClass()), subDeser);
      }
    }
    return subDeser;
  }
  
  public void wrapAndThrow(Throwable t, Object bean, String fieldName, DeserializationContext ctxt)
    throws IOException
  {
    throw JsonMappingException.wrapWithPath(throwOrReturnThrowable(t, ctxt), bean, fieldName);
  }
  
  @Deprecated
  public void wrapAndThrow(Throwable t, Object bean, int index, DeserializationContext ctxt)
    throws IOException
  {
    throw JsonMappingException.wrapWithPath(throwOrReturnThrowable(t, ctxt), bean, index);
  }
  
  private Throwable throwOrReturnThrowable(Throwable t, DeserializationContext ctxt)
    throws IOException
  {
    while (((t instanceof InvocationTargetException)) && (t.getCause() != null)) {
      t = t.getCause();
    }
    if ((t instanceof Error)) {
      throw ((Error)t);
    }
    boolean wrap = (ctxt == null) || (ctxt.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS));
    if ((t instanceof IOException))
    {
      if ((!wrap) || (!(t instanceof JsonProcessingException))) {
        throw ((IOException)t);
      }
    }
    else if ((!wrap) && 
      ((t instanceof RuntimeException))) {
      throw ((RuntimeException)t);
    }
    return t;
  }
  
  protected void wrapInstantiationProblem(Throwable t, DeserializationContext ctxt)
    throws IOException
  {
    while (((t instanceof InvocationTargetException)) && (t.getCause() != null)) {
      t = t.getCause();
    }
    if ((t instanceof Error)) {
      throw ((Error)t);
    }
    boolean wrap = (ctxt == null) || (ctxt.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS));
    if ((t instanceof IOException)) {
      throw ((IOException)t);
    }
    if ((!wrap) && 
      ((t instanceof RuntimeException))) {
      throw ((RuntimeException)t);
    }
    throw ctxt.instantiationException(_beanType.getRawClass(), t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BeanDeserializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */