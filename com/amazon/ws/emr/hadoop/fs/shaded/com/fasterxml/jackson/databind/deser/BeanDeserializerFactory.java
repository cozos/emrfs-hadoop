package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty.Std;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.MapperFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.NoClassDefFoundDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeBindings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BeanDeserializerFactory
  extends BasicDeserializerFactory
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private static final Class<?>[] INIT_CAUSE_PARAMS = { Throwable.class };
  private static final Class<?>[] NO_VIEWS = new Class[0];
  private static final Set<String> DEFAULT_NO_DESER_CLASS_NAMES;
  
  static
  {
    Set<String> s = new HashSet();
    
    s.add("com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.collections.functors.InvokerTransformer");
    s.add("com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.collections.functors.InstantiateTransformer");
    s.add("com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.collections4.functors.InvokerTransformer");
    s.add("com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.collections4.functors.InstantiateTransformer");
    s.add("org.codehaus.groovy.runtime.ConvertedClosure");
    s.add("org.codehaus.groovy.runtime.MethodClosure");
    s.add("org.springframework.beans.factory.ObjectFactory");
    s.add("com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl");
    
    s.add("java.util.logging.FileHandler");
    s.add("java.rmi.server.UnicastRemoteObject");
    
    s.add("org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor");
    s.add("org.springframework.beans.factory.config.PropertyPathFactoryBean");
    s.add("com.mchange.v2.c3p0.JndiRefForwardingDataSource");
    s.add("com.mchange.v2.c3p0.WrapperConnectionPoolDataSource");
    
    s.add("org.slf4j.ext.EventData");
    s.add("flex.messaging.util.concurrent.AsynchBeansWorkManagerExecutor");
    s.add("com.sun.deploy.security.ruleset.DRSHelper");
    s.add("org.apache.axis2.jaxws.spi.handler.HandlerResolverImpl");
    
    DEFAULT_NO_DESER_CLASS_NAMES = Collections.unmodifiableSet(s);
  }
  
  private Set<String> _cfgIllegalClassNames = DEFAULT_NO_DESER_CLASS_NAMES;
  public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(new DeserializerFactoryConfig());
  
  public BeanDeserializerFactory(DeserializerFactoryConfig config)
  {
    super(config);
  }
  
  public DeserializerFactory withConfig(DeserializerFactoryConfig config)
  {
    if (_factoryConfig == config) {
      return this;
    }
    if (getClass() != BeanDeserializerFactory.class) {
      throw new IllegalStateException("Subtype of BeanDeserializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with " + "additional deserializer definitions");
    }
    return new BeanDeserializerFactory(config);
  }
  
  public JsonDeserializer<Object> createBeanDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc)
    throws JsonMappingException
  {
    DeserializationConfig config = ctxt.getConfig();
    
    JsonDeserializer<Object> custom = _findCustomBeanDeserializer(type, config, beanDesc);
    if (custom != null) {
      return custom;
    }
    if (type.isThrowable()) {
      return buildThrowableDeserializer(ctxt, type, beanDesc);
    }
    if (type.isAbstract())
    {
      JavaType concreteType = materializeAbstractType(ctxt, type, beanDesc);
      if (concreteType != null)
      {
        beanDesc = config.introspect(concreteType);
        return buildBeanDeserializer(ctxt, concreteType, beanDesc);
      }
    }
    JsonDeserializer<Object> deser = findStdDeserializer(ctxt, type, beanDesc);
    if (deser != null) {
      return deser;
    }
    if (!isPotentialBeanType(type.getRawClass())) {
      return null;
    }
    checkIllegalTypes(ctxt, type, beanDesc);
    
    return buildBeanDeserializer(ctxt, type, beanDesc);
  }
  
  public JsonDeserializer<Object> createBuilderBasedDeserializer(DeserializationContext ctxt, JavaType valueType, BeanDescription beanDesc, Class<?> builderClass)
    throws JsonMappingException
  {
    JavaType builderType = ctxt.constructType(builderClass);
    BeanDescription builderDesc = ctxt.getConfig().introspectForBuilder(builderType);
    return buildBuilderBasedDeserializer(ctxt, valueType, builderDesc);
  }
  
  protected JsonDeserializer<?> findStdDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc)
    throws JsonMappingException
  {
    JsonDeserializer<?> deser = findDefaultDeserializer(ctxt, type, beanDesc);
    if ((deser != null) && 
      (_factoryConfig.hasDeserializerModifiers())) {
      for (BeanDeserializerModifier mod : _factoryConfig.deserializerModifiers()) {
        deser = mod.modifyDeserializer(ctxt.getConfig(), beanDesc, deser);
      }
    }
    return deser;
  }
  
  protected JavaType materializeAbstractType(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc)
    throws JsonMappingException
  {
    JavaType abstractType = beanDesc.getType();
    for (AbstractTypeResolver r : _factoryConfig.abstractTypeResolvers())
    {
      JavaType concrete = r.resolveAbstractType(ctxt.getConfig(), abstractType);
      if (concrete != null) {
        return concrete;
      }
    }
    return null;
  }
  
  public JsonDeserializer<Object> buildBeanDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc)
    throws JsonMappingException
  {
    ValueInstantiator valueInstantiator;
    try
    {
      valueInstantiator = findValueInstantiator(ctxt, beanDesc);
    }
    catch (NoClassDefFoundError error)
    {
      return new NoClassDefFoundDeserializer(error);
    }
    BeanDeserializerBuilder builder = constructBeanDeserializerBuilder(ctxt, beanDesc);
    builder.setValueInstantiator(valueInstantiator);
    
    addBeanProps(ctxt, beanDesc, builder);
    addObjectIdReader(ctxt, beanDesc, builder);
    
    addReferenceProperties(ctxt, beanDesc, builder);
    addInjectables(ctxt, beanDesc, builder);
    
    DeserializationConfig config = ctxt.getConfig();
    if (_factoryConfig.hasDeserializerModifiers()) {
      for (BeanDeserializerModifier mod : _factoryConfig.deserializerModifiers()) {
        builder = mod.updateBuilder(config, beanDesc, builder);
      }
    }
    JsonDeserializer<?> deserializer;
    JsonDeserializer<?> deserializer;
    if ((type.isAbstract()) && (!valueInstantiator.canInstantiate())) {
      deserializer = builder.buildAbstract();
    } else {
      deserializer = builder.build();
    }
    if (_factoryConfig.hasDeserializerModifiers()) {
      for (BeanDeserializerModifier mod : _factoryConfig.deserializerModifiers()) {
        deserializer = mod.modifyDeserializer(config, beanDesc, deserializer);
      }
    }
    return deserializer;
  }
  
  protected JsonDeserializer<Object> buildBuilderBasedDeserializer(DeserializationContext ctxt, JavaType valueType, BeanDescription builderDesc)
    throws JsonMappingException
  {
    ValueInstantiator valueInstantiator = findValueInstantiator(ctxt, builderDesc);
    DeserializationConfig config = ctxt.getConfig();
    BeanDeserializerBuilder builder = constructBeanDeserializerBuilder(ctxt, builderDesc);
    builder.setValueInstantiator(valueInstantiator);
    
    addBeanProps(ctxt, builderDesc, builder);
    addObjectIdReader(ctxt, builderDesc, builder);
    
    addReferenceProperties(ctxt, builderDesc, builder);
    addInjectables(ctxt, builderDesc, builder);
    
    JsonPOJOBuilder.Value builderConfig = builderDesc.findPOJOBuilderConfig();
    String buildMethodName = builderConfig == null ? "build" : buildMethodName;
    
    AnnotatedMethod buildMethod = builderDesc.findMethod(buildMethodName, null);
    if ((buildMethod != null) && 
      (config.canOverrideAccessModifiers())) {
      ClassUtil.checkAndFixAccess(buildMethod.getMember());
    }
    builder.setPOJOBuilder(buildMethod, builderConfig);
    if (_factoryConfig.hasDeserializerModifiers()) {
      for (BeanDeserializerModifier mod : _factoryConfig.deserializerModifiers()) {
        builder = mod.updateBuilder(config, builderDesc, builder);
      }
    }
    JsonDeserializer<?> deserializer = builder.buildBuilderBased(valueType, buildMethodName);
    if (_factoryConfig.hasDeserializerModifiers()) {
      for (BeanDeserializerModifier mod : _factoryConfig.deserializerModifiers()) {
        deserializer = mod.modifyDeserializer(config, builderDesc, deserializer);
      }
    }
    return deserializer;
  }
  
  protected void addObjectIdReader(DeserializationContext ctxt, BeanDescription beanDesc, BeanDeserializerBuilder builder)
    throws JsonMappingException
  {
    ObjectIdInfo objectIdInfo = beanDesc.getObjectIdInfo();
    if (objectIdInfo == null) {
      return;
    }
    Class<?> implClass = objectIdInfo.getGeneratorType();
    
    ObjectIdResolver resolver = ctxt.objectIdResolverInstance(beanDesc.getClassInfo(), objectIdInfo);
    ObjectIdGenerator<?> gen;
    JavaType idType;
    SettableBeanProperty idProp;
    ObjectIdGenerator<?> gen;
    if (implClass == ObjectIdGenerators.PropertyGenerator.class)
    {
      PropertyName propName = objectIdInfo.getPropertyName();
      SettableBeanProperty idProp = builder.findProperty(propName);
      if (idProp == null) {
        throw new IllegalArgumentException("Invalid Object Id definition for " + beanDesc.getBeanClass().getName() + ": can not find property with name '" + propName + "'");
      }
      JavaType idType = idProp.getType();
      gen = new PropertyBasedObjectIdGenerator(objectIdInfo.getScope());
    }
    else
    {
      JavaType type = ctxt.constructType(implClass);
      idType = ctxt.getTypeFactory().findTypeParameters(type, ObjectIdGenerator.class)[0];
      idProp = null;
      gen = ctxt.objectIdGeneratorInstance(beanDesc.getClassInfo(), objectIdInfo);
    }
    JsonDeserializer<?> deser = ctxt.findRootValueDeserializer(idType);
    builder.setObjectIdReader(ObjectIdReader.construct(idType, objectIdInfo.getPropertyName(), gen, deser, idProp, resolver));
  }
  
  public JsonDeserializer<Object> buildThrowableDeserializer(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc)
    throws JsonMappingException
  {
    DeserializationConfig config = ctxt.getConfig();
    
    BeanDeserializerBuilder builder = constructBeanDeserializerBuilder(ctxt, beanDesc);
    builder.setValueInstantiator(findValueInstantiator(ctxt, beanDesc));
    
    addBeanProps(ctxt, beanDesc, builder);
    
    AnnotatedMethod am = beanDesc.findMethod("initCause", INIT_CAUSE_PARAMS);
    if (am != null)
    {
      SimpleBeanPropertyDefinition propDef = SimpleBeanPropertyDefinition.construct(ctxt.getConfig(), am, new PropertyName("cause"));
      
      SettableBeanProperty prop = constructSettableProperty(ctxt, beanDesc, propDef, am.getGenericParameterType(0));
      if (prop != null) {
        builder.addOrReplaceProperty(prop, true);
      }
    }
    builder.addIgnorable("localizedMessage");
    
    builder.addIgnorable("suppressed");
    
    builder.addIgnorable("message");
    if (_factoryConfig.hasDeserializerModifiers()) {
      for (BeanDeserializerModifier mod : _factoryConfig.deserializerModifiers()) {
        builder = mod.updateBuilder(config, beanDesc, builder);
      }
    }
    JsonDeserializer<?> deserializer = builder.build();
    if ((deserializer instanceof BeanDeserializer)) {
      deserializer = new ThrowableDeserializer((BeanDeserializer)deserializer);
    }
    if (_factoryConfig.hasDeserializerModifiers()) {
      for (BeanDeserializerModifier mod : _factoryConfig.deserializerModifiers()) {
        deserializer = mod.modifyDeserializer(config, beanDesc, deserializer);
      }
    }
    return deserializer;
  }
  
  protected BeanDeserializerBuilder constructBeanDeserializerBuilder(DeserializationContext ctxt, BeanDescription beanDesc)
  {
    return new BeanDeserializerBuilder(beanDesc, ctxt.getConfig());
  }
  
  protected void addBeanProps(DeserializationContext ctxt, BeanDescription beanDesc, BeanDeserializerBuilder builder)
    throws JsonMappingException
  {
    SettableBeanProperty[] creatorProps = builder.getValueInstantiator().getFromObjectArguments(ctxt.getConfig());
    
    boolean isConcrete = !beanDesc.getType().isAbstract();
    
    AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
    boolean ignoreAny = false;
    
    Boolean B = intr.findIgnoreUnknownProperties(beanDesc.getClassInfo());
    if (B != null)
    {
      ignoreAny = B.booleanValue();
      builder.setIgnoreUnknownProperties(ignoreAny);
    }
    Set<String> ignored = ArrayBuilders.arrayToSet(intr.findPropertiesToIgnore(beanDesc.getClassInfo(), false));
    for (String propName : ignored) {
      builder.addIgnorable(propName);
    }
    AnnotatedMethod anySetter = beanDesc.findAnySetter();
    if (anySetter != null) {
      builder.setAnySetter(constructAnySetter(ctxt, beanDesc, anySetter));
    }
    if (anySetter == null)
    {
      Collection<String> ignored2 = beanDesc.getIgnoredPropertyNames();
      if (ignored2 != null) {
        for (String propName : ignored2) {
          builder.addIgnorable(propName);
        }
      }
    }
    boolean useGettersAsSetters = (ctxt.isEnabled(MapperFeature.USE_GETTERS_AS_SETTERS)) && (ctxt.isEnabled(MapperFeature.AUTO_DETECT_GETTERS));
    
    List<BeanPropertyDefinition> propDefs = filterBeanProps(ctxt, beanDesc, builder, beanDesc.findProperties(), ignored);
    if (_factoryConfig.hasDeserializerModifiers()) {
      for (BeanDeserializerModifier mod : _factoryConfig.deserializerModifiers()) {
        propDefs = mod.updateProperties(ctxt.getConfig(), beanDesc, propDefs);
      }
    }
    for (BeanPropertyDefinition propDef : propDefs)
    {
      SettableBeanProperty prop = null;
      if (propDef.hasSetter())
      {
        Type propertyType = propDef.getSetter().getGenericParameterType(0);
        prop = constructSettableProperty(ctxt, beanDesc, propDef, propertyType);
      }
      else if (propDef.hasField())
      {
        Type propertyType = propDef.getField().getGenericType();
        prop = constructSettableProperty(ctxt, beanDesc, propDef, propertyType);
      }
      else if ((useGettersAsSetters) && (propDef.hasGetter()))
      {
        AnnotatedMethod getter = propDef.getGetter();
        
        Class<?> rawPropertyType = getter.getRawType();
        if ((Collection.class.isAssignableFrom(rawPropertyType)) || (Map.class.isAssignableFrom(rawPropertyType))) {
          prop = constructSetterlessProperty(ctxt, beanDesc, propDef);
        }
      }
      if ((isConcrete) && (propDef.hasConstructorParameter()))
      {
        String name = propDef.getName();
        CreatorProperty cprop = null;
        if (creatorProps != null) {
          for (SettableBeanProperty cp : creatorProps) {
            if ((name.equals(cp.getName())) && ((cp instanceof CreatorProperty)))
            {
              cprop = (CreatorProperty)cp;
              break;
            }
          }
        }
        if (cprop == null) {
          throw ctxt.mappingException("Could not find creator property with name '%s' (in class %s)", new Object[] { name, beanDesc.getBeanClass().getName() });
        }
        if (prop != null) {
          cprop.setFallbackSetter(prop);
        }
        prop = cprop;
        builder.addCreatorProperty(cprop);
      }
      else if (prop != null)
      {
        Class<?>[] views = propDef.findViews();
        if (views == null) {
          if (!ctxt.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
            views = NO_VIEWS;
          }
        }
        prop.setViews(views);
        builder.addProperty(prop);
      }
    }
  }
  
  protected List<BeanPropertyDefinition> filterBeanProps(DeserializationContext ctxt, BeanDescription beanDesc, BeanDeserializerBuilder builder, List<BeanPropertyDefinition> propDefsIn, Set<String> ignored)
    throws JsonMappingException
  {
    ArrayList<BeanPropertyDefinition> result = new ArrayList(Math.max(4, propDefsIn.size()));
    
    HashMap<Class<?>, Boolean> ignoredTypes = new HashMap();
    for (BeanPropertyDefinition property : propDefsIn)
    {
      String name = property.getName();
      if (!ignored.contains(name))
      {
        if (!property.hasConstructorParameter())
        {
          Class<?> rawPropertyType = null;
          if (property.hasSetter()) {
            rawPropertyType = property.getSetter().getRawParameterType(0);
          } else if (property.hasField()) {
            rawPropertyType = property.getField().getRawType();
          }
          if ((rawPropertyType != null) && (isIgnorableType(ctxt.getConfig(), beanDesc, rawPropertyType, ignoredTypes)))
          {
            builder.addIgnorable(name);
            continue;
          }
        }
        result.add(property);
      }
    }
    return result;
  }
  
  protected void addReferenceProperties(DeserializationContext ctxt, BeanDescription beanDesc, BeanDeserializerBuilder builder)
    throws JsonMappingException
  {
    Map<String, AnnotatedMember> refs = beanDesc.findBackReferenceProperties();
    if (refs != null) {
      for (Map.Entry<String, AnnotatedMember> en : refs.entrySet())
      {
        String name = (String)en.getKey();
        AnnotatedMember m = (AnnotatedMember)en.getValue();
        Type genericType;
        Type genericType;
        if ((m instanceof AnnotatedMethod)) {
          genericType = ((AnnotatedMethod)m).getGenericParameterType(0);
        } else {
          genericType = m.getRawType();
        }
        SimpleBeanPropertyDefinition propDef = SimpleBeanPropertyDefinition.construct(ctxt.getConfig(), m);
        
        builder.addBackReferenceProperty(name, constructSettableProperty(ctxt, beanDesc, propDef, genericType));
      }
    }
  }
  
  protected void addInjectables(DeserializationContext ctxt, BeanDescription beanDesc, BeanDeserializerBuilder builder)
    throws JsonMappingException
  {
    Map<Object, AnnotatedMember> raw = beanDesc.findInjectables();
    boolean fixAccess;
    if (raw != null)
    {
      fixAccess = ctxt.canOverrideAccessModifiers();
      for (Map.Entry<Object, AnnotatedMember> entry : raw.entrySet())
      {
        AnnotatedMember m = (AnnotatedMember)entry.getValue();
        if (fixAccess) {
          m.fixAccess();
        }
        builder.addInjectable(PropertyName.construct(m.getName()), beanDesc.resolveType(m.getGenericType()), beanDesc.getClassAnnotations(), m, entry.getKey());
      }
    }
  }
  
  protected SettableAnyProperty constructAnySetter(DeserializationContext ctxt, BeanDescription beanDesc, AnnotatedMethod setter)
    throws JsonMappingException
  {
    if (ctxt.canOverrideAccessModifiers()) {
      setter.fixAccess();
    }
    JavaType type = beanDesc.bindingsForBeanType().resolveType(setter.getGenericParameterType(1));
    BeanProperty.Std property = new BeanProperty.Std(PropertyName.construct(setter.getName()), type, null, beanDesc.getClassAnnotations(), setter, PropertyMetadata.STD_OPTIONAL);
    
    type = resolveType(ctxt, beanDesc, type, setter);
    
    JsonDeserializer<Object> deser = findDeserializerFromAnnotation(ctxt, setter);
    
    type = modifyTypeByAnnotation(ctxt, setter, type);
    if (deser == null) {
      deser = (JsonDeserializer)type.getValueHandler();
    }
    TypeDeserializer typeDeser = (TypeDeserializer)type.getTypeHandler();
    return new SettableAnyProperty(property, setter, type, deser, typeDeser);
  }
  
  protected SettableBeanProperty constructSettableProperty(DeserializationContext ctxt, BeanDescription beanDesc, BeanPropertyDefinition propDef, Type jdkType)
    throws JsonMappingException
  {
    AnnotatedMember mutator = propDef.getNonConstructorMutator();
    if (ctxt.canOverrideAccessModifiers()) {
      mutator.fixAccess();
    }
    JavaType t0 = beanDesc.resolveType(jdkType);
    
    BeanProperty.Std property = new BeanProperty.Std(propDef.getFullName(), t0, propDef.getWrapperName(), beanDesc.getClassAnnotations(), mutator, propDef.getMetadata());
    
    JavaType type = resolveType(ctxt, beanDesc, t0, mutator);
    if (type != t0) {
      property = property.withType(type);
    }
    JsonDeserializer<Object> propDeser = findDeserializerFromAnnotation(ctxt, mutator);
    type = modifyTypeByAnnotation(ctxt, mutator, type);
    TypeDeserializer typeDeser = (TypeDeserializer)type.getTypeHandler();
    SettableBeanProperty prop;
    SettableBeanProperty prop;
    if ((mutator instanceof AnnotatedMethod)) {
      prop = new MethodProperty(propDef, type, typeDeser, beanDesc.getClassAnnotations(), (AnnotatedMethod)mutator);
    } else {
      prop = new FieldProperty(propDef, type, typeDeser, beanDesc.getClassAnnotations(), (AnnotatedField)mutator);
    }
    if (propDeser != null) {
      prop = prop.withValueDeserializer(propDeser);
    }
    AnnotationIntrospector.ReferenceProperty ref = propDef.findReferenceType();
    if ((ref != null) && (ref.isManagedReference())) {
      prop.setManagedReferenceName(ref.getName());
    }
    ObjectIdInfo objectIdInfo = propDef.findObjectIdInfo();
    if (objectIdInfo != null) {
      prop.setObjectIdInfo(objectIdInfo);
    }
    return prop;
  }
  
  protected SettableBeanProperty constructSetterlessProperty(DeserializationContext ctxt, BeanDescription beanDesc, BeanPropertyDefinition propDef)
    throws JsonMappingException
  {
    AnnotatedMethod getter = propDef.getGetter();
    if (ctxt.canOverrideAccessModifiers()) {
      getter.fixAccess();
    }
    JavaType type = getter.getType(beanDesc.bindingsForBeanType());
    
    JsonDeserializer<Object> propDeser = findDeserializerFromAnnotation(ctxt, getter);
    type = modifyTypeByAnnotation(ctxt, getter, type);
    
    type = resolveType(ctxt, beanDesc, type, getter);
    TypeDeserializer typeDeser = (TypeDeserializer)type.getTypeHandler();
    SettableBeanProperty prop = new SetterlessProperty(propDef, type, typeDeser, beanDesc.getClassAnnotations(), getter);
    if (propDeser != null) {
      prop = prop.withValueDeserializer(propDeser);
    }
    return prop;
  }
  
  protected boolean isPotentialBeanType(Class<?> type)
  {
    String typeStr = ClassUtil.canBeABeanType(type);
    if (typeStr != null) {
      throw new IllegalArgumentException("Can not deserialize Class " + type.getName() + " (of type " + typeStr + ") as a Bean");
    }
    if (ClassUtil.isProxyType(type)) {
      throw new IllegalArgumentException("Can not deserialize Proxy class " + type.getName() + " as a Bean");
    }
    typeStr = ClassUtil.isLocalType(type, true);
    if (typeStr != null) {
      throw new IllegalArgumentException("Can not deserialize Class " + type.getName() + " (of type " + typeStr + ") as a Bean");
    }
    return true;
  }
  
  protected boolean isIgnorableType(DeserializationConfig config, BeanDescription beanDesc, Class<?> type, Map<Class<?>, Boolean> ignoredTypes)
  {
    Boolean status = (Boolean)ignoredTypes.get(type);
    if (status != null) {
      return status.booleanValue();
    }
    BeanDescription desc = config.introspectClassAnnotations(type);
    status = config.getAnnotationIntrospector().isIgnorableType(desc.getClassInfo());
    
    return status == null ? false : status.booleanValue();
  }
  
  private void checkIllegalTypes(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc)
    throws JsonMappingException
  {
    String full = type.getRawClass().getName();
    if (_cfgIllegalClassNames.contains(full))
    {
      String message = String.format("Illegal type (%s) to deserialize: prevented for security reasons", new Object[] { full });
      
      throw ctxt.mappingException("Invalid type definition for type %s: %s", new Object[] { beanDesc, message });
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BeanDeserializerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */