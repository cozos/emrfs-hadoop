package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty.Std;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.MapperFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeBindings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class BeanSerializerFactory
  extends BasicSerializerFactory
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);
  
  protected BeanSerializerFactory(SerializerFactoryConfig config)
  {
    super(config);
  }
  
  public SerializerFactory withConfig(SerializerFactoryConfig config)
  {
    if (_factoryConfig == config) {
      return this;
    }
    if (getClass() != BeanSerializerFactory.class) {
      throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions");
    }
    return new BeanSerializerFactory(config);
  }
  
  protected Iterable<Serializers> customSerializers()
  {
    return _factoryConfig.serializers();
  }
  
  public JsonSerializer<Object> createSerializer(SerializerProvider prov, JavaType origType)
    throws JsonMappingException
  {
    SerializationConfig config = prov.getConfig();
    BeanDescription beanDesc = config.introspect(origType);
    JsonSerializer<?> ser = findSerializerFromAnnotation(prov, beanDesc.getClassInfo());
    if (ser != null) {
      return ser;
    }
    JavaType type = modifyTypeByAnnotation(config, beanDesc.getClassInfo(), origType);
    boolean staticTyping;
    boolean staticTyping;
    if (type == origType)
    {
      staticTyping = false;
    }
    else
    {
      staticTyping = true;
      if (!type.hasRawClass(origType.getRawClass())) {
        beanDesc = config.introspect(type);
      }
    }
    Converter<Object, Object> conv = beanDesc.findSerializationConverter();
    if (conv == null) {
      return _createSerializer2(prov, type, beanDesc, staticTyping);
    }
    JavaType delegateType = conv.getOutputType(prov.getTypeFactory());
    if (!delegateType.hasRawClass(type.getRawClass()))
    {
      beanDesc = config.introspect(delegateType);
      
      ser = findSerializerFromAnnotation(prov, beanDesc.getClassInfo());
    }
    if ((ser == null) && (!delegateType.isJavaLangObject())) {
      ser = _createSerializer2(prov, delegateType, beanDesc, true);
    }
    return new StdDelegatingSerializer(conv, delegateType, ser);
  }
  
  protected JsonSerializer<?> _createSerializer2(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping)
    throws JsonMappingException
  {
    JsonSerializer<?> ser = null;
    SerializationConfig config = prov.getConfig();
    if (type.isContainerType())
    {
      if (!staticTyping) {
        staticTyping = usesStaticTyping(config, beanDesc, null);
      }
      ser = buildContainerSerializer(prov, type, beanDesc, staticTyping);
      if (ser != null) {
        return ser;
      }
    }
    else
    {
      for (Serializers serializers : customSerializers())
      {
        ser = serializers.findSerializer(config, type, beanDesc);
        if (ser != null) {
          break;
        }
      }
      if (ser == null) {
        ser = findSerializerByAnnotations(prov, type, beanDesc);
      }
    }
    if (ser == null)
    {
      ser = findSerializerByLookup(type, config, beanDesc, staticTyping);
      if (ser == null)
      {
        ser = findSerializerByPrimaryType(prov, type, beanDesc, staticTyping);
        if (ser == null)
        {
          ser = findBeanSerializer(prov, type, beanDesc);
          if (ser == null)
          {
            ser = findSerializerByAddonType(config, type, beanDesc, staticTyping);
            if (ser == null) {
              ser = prov.getUnknownTypeSerializer(beanDesc.getBeanClass());
            }
          }
        }
      }
    }
    if (ser != null) {
      if (_factoryConfig.hasSerializerModifiers()) {
        for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) {
          ser = mod.modifySerializer(config, beanDesc, ser);
        }
      }
    }
    return ser;
  }
  
  public JsonSerializer<Object> findBeanSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc)
    throws JsonMappingException
  {
    if (!isPotentialBeanType(type.getRawClass())) {
      if (!type.isEnumType()) {
        return null;
      }
    }
    return constructBeanSerializer(prov, beanDesc);
  }
  
  public TypeSerializer findPropertyTypeSerializer(JavaType baseType, SerializationConfig config, AnnotatedMember accessor)
    throws JsonMappingException
  {
    AnnotationIntrospector ai = config.getAnnotationIntrospector();
    TypeResolverBuilder<?> b = ai.findPropertyTypeResolver(config, accessor, baseType);
    TypeSerializer typeSer;
    TypeSerializer typeSer;
    if (b == null)
    {
      typeSer = createTypeSerializer(config, baseType);
    }
    else
    {
      Collection<NamedType> subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByClass(config, accessor, baseType);
      
      typeSer = b.buildTypeSerializer(config, baseType, subtypes);
    }
    return typeSer;
  }
  
  public TypeSerializer findPropertyContentTypeSerializer(JavaType containerType, SerializationConfig config, AnnotatedMember accessor)
    throws JsonMappingException
  {
    JavaType contentType = containerType.getContentType();
    AnnotationIntrospector ai = config.getAnnotationIntrospector();
    TypeResolverBuilder<?> b = ai.findPropertyContentTypeResolver(config, accessor, containerType);
    TypeSerializer typeSer;
    TypeSerializer typeSer;
    if (b == null)
    {
      typeSer = createTypeSerializer(config, contentType);
    }
    else
    {
      Collection<NamedType> subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByClass(config, accessor, contentType);
      
      typeSer = b.buildTypeSerializer(config, contentType, subtypes);
    }
    return typeSer;
  }
  
  protected JsonSerializer<Object> constructBeanSerializer(SerializerProvider prov, BeanDescription beanDesc)
    throws JsonMappingException
  {
    if (beanDesc.getBeanClass() == Object.class) {
      return prov.getUnknownTypeSerializer(Object.class);
    }
    SerializationConfig config = prov.getConfig();
    BeanSerializerBuilder builder = constructBeanSerializerBuilder(beanDesc);
    builder.setConfig(config);
    
    List<BeanPropertyWriter> props = findBeanProperties(prov, beanDesc, builder);
    if (props == null) {
      props = new ArrayList();
    } else {
      props = removeOverlappingTypeIds(prov, beanDesc, builder, props);
    }
    prov.getAnnotationIntrospector().findAndAddVirtualProperties(config, beanDesc.getClassInfo(), props);
    if (_factoryConfig.hasSerializerModifiers()) {
      for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) {
        props = mod.changeProperties(config, beanDesc, props);
      }
    }
    props = filterBeanProperties(config, beanDesc, props);
    if (_factoryConfig.hasSerializerModifiers()) {
      for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) {
        props = mod.orderProperties(config, beanDesc, props);
      }
    }
    builder.setObjectIdWriter(constructObjectIdHandler(prov, beanDesc, props));
    
    builder.setProperties(props);
    builder.setFilterId(findFilterId(config, beanDesc));
    
    AnnotatedMember anyGetter = beanDesc.findAnyGetter();
    if (anyGetter != null)
    {
      if (config.canOverrideAccessModifiers()) {
        anyGetter.fixAccess();
      }
      JavaType type = anyGetter.getType(beanDesc.bindingsForBeanType());
      
      boolean staticTyping = config.isEnabled(MapperFeature.USE_STATIC_TYPING);
      JavaType valueType = type.getContentType();
      TypeSerializer typeSer = createTypeSerializer(config, valueType);
      
      JsonSerializer<?> anySer = findSerializerFromAnnotation(prov, anyGetter);
      if (anySer == null) {
        anySer = MapSerializer.construct(null, type, staticTyping, typeSer, null, null, null);
      }
      PropertyName name = PropertyName.construct(anyGetter.getName());
      BeanProperty.Std anyProp = new BeanProperty.Std(name, valueType, null, beanDesc.getClassAnnotations(), anyGetter, PropertyMetadata.STD_OPTIONAL);
      
      builder.setAnyGetter(new AnyGetterWriter(anyProp, anyGetter, anySer));
    }
    processViews(config, builder);
    if (_factoryConfig.hasSerializerModifiers()) {
      for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) {
        builder = mod.updateBuilder(config, beanDesc, builder);
      }
    }
    JsonSerializer<Object> ser = builder.build();
    if (ser == null) {
      if (beanDesc.hasKnownClassAnnotations()) {
        return builder.createDummy();
      }
    }
    return ser;
  }
  
  protected ObjectIdWriter constructObjectIdHandler(SerializerProvider prov, BeanDescription beanDesc, List<BeanPropertyWriter> props)
    throws JsonMappingException
  {
    ObjectIdInfo objectIdInfo = beanDesc.getObjectIdInfo();
    if (objectIdInfo == null) {
      return null;
    }
    Class<?> implClass = objectIdInfo.getGeneratorType();
    if (implClass == ObjectIdGenerators.PropertyGenerator.class)
    {
      String propName = objectIdInfo.getPropertyName().getSimpleName();
      BeanPropertyWriter idProp = null;
      
      int i = 0;
      for (int len = props.size();; i++)
      {
        if (i == len) {
          throw new IllegalArgumentException("Invalid Object Id definition for " + beanDesc.getBeanClass().getName() + ": can not find property with name '" + propName + "'");
        }
        BeanPropertyWriter prop = (BeanPropertyWriter)props.get(i);
        if (propName.equals(prop.getName()))
        {
          idProp = prop;
          if (i <= 0) {
            break;
          }
          props.remove(i);
          props.add(0, idProp); break;
        }
      }
      JavaType idType = idProp.getType();
      ObjectIdGenerator<?> gen = new PropertyBasedObjectIdGenerator(objectIdInfo, idProp);
      
      return ObjectIdWriter.construct(idType, (PropertyName)null, gen, objectIdInfo.getAlwaysAsId());
    }
    JavaType type = prov.constructType(implClass);
    
    JavaType idType = prov.getTypeFactory().findTypeParameters(type, ObjectIdGenerator.class)[0];
    ObjectIdGenerator<?> gen = prov.objectIdGeneratorInstance(beanDesc.getClassInfo(), objectIdInfo);
    return ObjectIdWriter.construct(idType, objectIdInfo.getPropertyName(), gen, objectIdInfo.getAlwaysAsId());
  }
  
  protected BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter writer, Class<?>[] inViews)
  {
    return FilteredBeanPropertyWriter.constructViewBased(writer, inViews);
  }
  
  protected PropertyBuilder constructPropertyBuilder(SerializationConfig config, BeanDescription beanDesc)
  {
    return new PropertyBuilder(config, beanDesc);
  }
  
  protected BeanSerializerBuilder constructBeanSerializerBuilder(BeanDescription beanDesc)
  {
    return new BeanSerializerBuilder(beanDesc);
  }
  
  protected boolean isPotentialBeanType(Class<?> type)
  {
    return (ClassUtil.canBeABeanType(type) == null) && (!ClassUtil.isProxyType(type));
  }
  
  protected List<BeanPropertyWriter> findBeanProperties(SerializerProvider prov, BeanDescription beanDesc, BeanSerializerBuilder builder)
    throws JsonMappingException
  {
    List<BeanPropertyDefinition> properties = beanDesc.findProperties();
    SerializationConfig config = prov.getConfig();
    
    removeIgnorableTypes(config, beanDesc, properties);
    if (config.isEnabled(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
      removeSetterlessGetters(config, beanDesc, properties);
    }
    if (properties.isEmpty()) {
      return null;
    }
    boolean staticTyping = usesStaticTyping(config, beanDesc, null);
    PropertyBuilder pb = constructPropertyBuilder(config, beanDesc);
    
    ArrayList<BeanPropertyWriter> result = new ArrayList(properties.size());
    TypeBindings typeBind = beanDesc.bindingsForBeanType();
    for (BeanPropertyDefinition property : properties)
    {
      AnnotatedMember accessor = property.getAccessor();
      if (property.isTypeId())
      {
        if (accessor != null)
        {
          if (config.canOverrideAccessModifiers()) {
            accessor.fixAccess();
          }
          builder.setTypeId(accessor);
        }
      }
      else
      {
        AnnotationIntrospector.ReferenceProperty refType = property.findReferenceType();
        if ((refType == null) || (!refType.isBackReference())) {
          if ((accessor instanceof AnnotatedMethod)) {
            result.add(_constructWriter(prov, property, typeBind, pb, staticTyping, (AnnotatedMethod)accessor));
          } else {
            result.add(_constructWriter(prov, property, typeBind, pb, staticTyping, (AnnotatedField)accessor));
          }
        }
      }
    }
    return result;
  }
  
  protected List<BeanPropertyWriter> filterBeanProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> props)
  {
    AnnotationIntrospector intr = config.getAnnotationIntrospector();
    AnnotatedClass ac = beanDesc.getClassInfo();
    String[] ignored = intr.findPropertiesToIgnore(ac, true);
    if ((ignored != null) && (ignored.length > 0))
    {
      HashSet<String> ignoredSet = ArrayBuilders.arrayToSet(ignored);
      Iterator<BeanPropertyWriter> it = props.iterator();
      while (it.hasNext()) {
        if (ignoredSet.contains(((BeanPropertyWriter)it.next()).getName())) {
          it.remove();
        }
      }
    }
    return props;
  }
  
  protected void processViews(SerializationConfig config, BeanSerializerBuilder builder)
  {
    List<BeanPropertyWriter> props = builder.getProperties();
    boolean includeByDefault = config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
    int propCount = props.size();
    int viewsFound = 0;
    BeanPropertyWriter[] filtered = new BeanPropertyWriter[propCount];
    for (int i = 0; i < propCount; i++)
    {
      BeanPropertyWriter bpw = (BeanPropertyWriter)props.get(i);
      Class<?>[] views = bpw.getViews();
      if (views == null)
      {
        if (includeByDefault) {
          filtered[i] = bpw;
        }
      }
      else
      {
        viewsFound++;
        filtered[i] = constructFilteredBeanWriter(bpw, views);
      }
    }
    if ((includeByDefault) && (viewsFound == 0)) {
      return;
    }
    builder.setFilteredProperties(filtered);
  }
  
  protected void removeIgnorableTypes(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyDefinition> properties)
  {
    AnnotationIntrospector intr = config.getAnnotationIntrospector();
    HashMap<Class<?>, Boolean> ignores = new HashMap();
    Iterator<BeanPropertyDefinition> it = properties.iterator();
    while (it.hasNext())
    {
      BeanPropertyDefinition property = (BeanPropertyDefinition)it.next();
      AnnotatedMember accessor = property.getAccessor();
      if (accessor == null)
      {
        it.remove();
      }
      else
      {
        Class<?> type = accessor.getRawType();
        Boolean result = (Boolean)ignores.get(type);
        if (result == null)
        {
          BeanDescription desc = config.introspectClassAnnotations(type);
          AnnotatedClass ac = desc.getClassInfo();
          result = intr.isIgnorableType(ac);
          if (result == null) {
            result = Boolean.FALSE;
          }
          ignores.put(type, result);
        }
        if (result.booleanValue()) {
          it.remove();
        }
      }
    }
  }
  
  protected void removeSetterlessGetters(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyDefinition> properties)
  {
    Iterator<BeanPropertyDefinition> it = properties.iterator();
    while (it.hasNext())
    {
      BeanPropertyDefinition property = (BeanPropertyDefinition)it.next();
      if ((!property.couldDeserialize()) && (!property.isExplicitlyIncluded())) {
        it.remove();
      }
    }
  }
  
  protected List<BeanPropertyWriter> removeOverlappingTypeIds(SerializerProvider prov, BeanDescription beanDesc, BeanSerializerBuilder builder, List<BeanPropertyWriter> props)
  {
    int i = 0;
    BeanPropertyWriter bpw;
    PropertyName typePropName;
    for (int end = props.size(); i < end; i++)
    {
      bpw = (BeanPropertyWriter)props.get(i);
      TypeSerializer td = bpw.getTypeSerializer();
      if ((td != null) && (td.getTypeInclusion() == JsonTypeInfo.As.EXTERNAL_PROPERTY))
      {
        String n = td.getPropertyName();
        typePropName = PropertyName.construct(n);
        for (BeanPropertyWriter w2 : props) {
          if ((w2 != bpw) && (w2.wouldConflictWithName(typePropName)))
          {
            bpw.assignTypeSerializer(null);
            break;
          }
        }
      }
    }
    return props;
  }
  
  protected BeanPropertyWriter _constructWriter(SerializerProvider prov, BeanPropertyDefinition propDef, TypeBindings typeContext, PropertyBuilder pb, boolean staticTyping, AnnotatedMember accessor)
    throws JsonMappingException
  {
    PropertyName name = propDef.getFullName();
    if (prov.canOverrideAccessModifiers()) {
      accessor.fixAccess();
    }
    JavaType type = accessor.getType(typeContext);
    BeanProperty.Std property = new BeanProperty.Std(name, type, propDef.getWrapperName(), pb.getClassAnnotations(), accessor, propDef.getMetadata());
    
    JsonSerializer<?> annotatedSerializer = findSerializerFromAnnotation(prov, accessor);
    if ((annotatedSerializer instanceof ResolvableSerializer)) {
      ((ResolvableSerializer)annotatedSerializer).resolve(prov);
    }
    annotatedSerializer = prov.handlePrimaryContextualization(annotatedSerializer, property);
    
    TypeSerializer contentTypeSer = null;
    if ((ClassUtil.isCollectionMapOrArray(type.getRawClass())) || (type.isCollectionLikeType()) || (type.isMapLikeType())) {
      contentTypeSer = findPropertyContentTypeSerializer(type, prov.getConfig(), accessor);
    }
    TypeSerializer typeSer = findPropertyTypeSerializer(type, prov.getConfig(), accessor);
    BeanPropertyWriter pbw = pb.buildWriter(prov, propDef, type, annotatedSerializer, typeSer, contentTypeSer, accessor, staticTyping);
    
    return pbw;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanSerializerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */