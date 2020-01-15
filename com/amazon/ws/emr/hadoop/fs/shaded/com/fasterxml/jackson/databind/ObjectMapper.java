package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.PropertyAccessor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variants;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonEncoding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.PrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.TreeNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Versioned;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharacterEscapes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.ResolvedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.TypeReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.Deserializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ArrayNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.NullNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.FilterProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.Serializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.SimpleType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeModifier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.RootNameLookup;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.StdDateFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class ObjectMapper
  extends ObjectCodec
  implements Versioned, Serializable
{
  private static final long serialVersionUID = 1L;
  
  public static enum DefaultTyping
  {
    JAVA_LANG_OBJECT,  OBJECT_AND_NON_CONCRETE,  NON_CONCRETE_AND_ARRAYS,  NON_FINAL;
    
    private DefaultTyping() {}
  }
  
  public static class DefaultTypeResolverBuilder
    extends StdTypeResolverBuilder
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected final ObjectMapper.DefaultTyping _appliesFor;
    
    public DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping t)
    {
      _appliesFor = t;
    }
    
    public TypeDeserializer buildTypeDeserializer(DeserializationConfig config, JavaType baseType, Collection<NamedType> subtypes)
    {
      return useForType(baseType) ? super.buildTypeDeserializer(config, baseType, subtypes) : null;
    }
    
    public TypeSerializer buildTypeSerializer(SerializationConfig config, JavaType baseType, Collection<NamedType> subtypes)
    {
      return useForType(baseType) ? super.buildTypeSerializer(config, baseType, subtypes) : null;
    }
    
    public boolean useForType(JavaType t)
    {
      switch (ObjectMapper.2.$SwitchMap$com$fasterxml$jackson$databind$ObjectMapper$DefaultTyping[_appliesFor.ordinal()])
      {
      case 1: 
        while (t.isArrayType()) {
          t = t.getContentType();
        }
      case 2: 
        return (t.isJavaLangObject()) || ((!t.isConcrete()) && (!TreeNode.class.isAssignableFrom(t.getRawClass())));
      case 3: 
        while (t.isArrayType()) {
          t = t.getContentType();
        }
        return (!t.isFinal()) && (!TreeNode.class.isAssignableFrom(t.getRawClass()));
      }
      return t.isJavaLangObject();
    }
  }
  
  private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(JsonNode.class);
  protected static final AnnotationIntrospector DEFAULT_ANNOTATION_INTROSPECTOR = new JacksonAnnotationIntrospector();
  protected static final VisibilityChecker<?> STD_VISIBILITY_CHECKER = VisibilityChecker.Std.defaultInstance();
  @Deprecated
  protected static final PrettyPrinter _defaultPrettyPrinter = new DefaultPrettyPrinter();
  protected static final BaseSettings DEFAULT_BASE = new BaseSettings(null, DEFAULT_ANNOTATION_INTROSPECTOR, STD_VISIBILITY_CHECKER, null, TypeFactory.defaultInstance(), null, StdDateFormat.instance, null, Locale.getDefault(), null, Base64Variants.getDefaultVariant());
  protected final JsonFactory _jsonFactory;
  protected TypeFactory _typeFactory;
  protected InjectableValues _injectableValues;
  protected SubtypeResolver _subtypeResolver;
  protected SimpleMixInResolver _mixIns;
  protected SerializationConfig _serializationConfig;
  protected DefaultSerializerProvider _serializerProvider;
  protected SerializerFactory _serializerFactory;
  protected DeserializationConfig _deserializationConfig;
  protected DefaultDeserializationContext _deserializationContext;
  protected Set<Object> _registeredModuleTypes;
  protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers = new ConcurrentHashMap(64, 0.6F, 2);
  
  public ObjectMapper()
  {
    this(null, null, null);
  }
  
  public ObjectMapper(JsonFactory jf)
  {
    this(jf, null, null);
  }
  
  protected ObjectMapper(ObjectMapper src)
  {
    _jsonFactory = _jsonFactory.copy();
    _jsonFactory.setCodec(this);
    _subtypeResolver = _subtypeResolver;
    _typeFactory = _typeFactory;
    _injectableValues = _injectableValues;
    
    SimpleMixInResolver mixins = _mixIns.copy();
    _mixIns = mixins;
    RootNameLookup rootNames = new RootNameLookup();
    _serializationConfig = new SerializationConfig(_serializationConfig, mixins, rootNames);
    _deserializationConfig = new DeserializationConfig(_deserializationConfig, mixins, rootNames);
    _serializerProvider = _serializerProvider.copy();
    _deserializationContext = _deserializationContext.copy();
    
    _serializerFactory = _serializerFactory;
    
    Set<Object> reg = _registeredModuleTypes;
    if (reg == null) {
      _registeredModuleTypes = null;
    } else {
      _registeredModuleTypes = new LinkedHashSet(reg);
    }
  }
  
  public ObjectMapper(JsonFactory jf, DefaultSerializerProvider sp, DefaultDeserializationContext dc)
  {
    if (jf == null)
    {
      _jsonFactory = new MappingJsonFactory(this);
    }
    else
    {
      _jsonFactory = jf;
      if (jf.getCodec() == null) {
        _jsonFactory.setCodec(this);
      }
    }
    _subtypeResolver = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    
    _typeFactory = TypeFactory.defaultInstance();
    
    SimpleMixInResolver mixins = new SimpleMixInResolver(null);
    _mixIns = mixins;
    
    BaseSettings base = DEFAULT_BASE.withClassIntrospector(defaultClassIntrospector());
    _serializationConfig = new SerializationConfig(base, _subtypeResolver, mixins, rootNames);
    
    _deserializationConfig = new DeserializationConfig(base, _subtypeResolver, mixins, rootNames);
    
    boolean needOrder = _jsonFactory.requiresPropertyOrdering();
    if ((needOrder ^ _serializationConfig.isEnabled(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY))) {
      configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, needOrder);
    }
    _serializerProvider = (sp == null ? new DefaultSerializerProvider.Impl() : sp);
    _deserializationContext = (dc == null ? new DefaultDeserializationContext.Impl(BeanDeserializerFactory.instance) : dc);
    
    _serializerFactory = BeanSerializerFactory.instance;
  }
  
  protected ClassIntrospector defaultClassIntrospector()
  {
    return new BasicClassIntrospector();
  }
  
  public ObjectMapper copy()
  {
    _checkInvalidCopy(ObjectMapper.class);
    return new ObjectMapper(this);
  }
  
  protected void _checkInvalidCopy(Class<?> exp)
  {
    if (getClass() != exp) {
      throw new IllegalStateException("Failed copy(): " + getClass().getName() + " (version: " + version() + ") does not override copy(); it has to");
    }
  }
  
  protected ObjectReader _newReader(DeserializationConfig config)
  {
    return new ObjectReader(this, config);
  }
  
  protected ObjectReader _newReader(DeserializationConfig config, JavaType valueType, Object valueToUpdate, FormatSchema schema, InjectableValues injectableValues)
  {
    return new ObjectReader(this, config, valueType, valueToUpdate, schema, injectableValues);
  }
  
  protected ObjectWriter _newWriter(SerializationConfig config)
  {
    return new ObjectWriter(this, config);
  }
  
  protected ObjectWriter _newWriter(SerializationConfig config, FormatSchema schema)
  {
    return new ObjectWriter(this, config, schema);
  }
  
  protected ObjectWriter _newWriter(SerializationConfig config, JavaType rootType, PrettyPrinter pp)
  {
    return new ObjectWriter(this, config, rootType, pp);
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  public ObjectMapper registerModule(Module module)
  {
    if (isEnabled(MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS))
    {
      Object typeId = module.getTypeId();
      if (typeId != null)
      {
        if (_registeredModuleTypes == null) {
          _registeredModuleTypes = new LinkedHashSet();
        }
        if (!_registeredModuleTypes.add(typeId)) {
          return this;
        }
      }
    }
    String name = module.getModuleName();
    if (name == null) {
      throw new IllegalArgumentException("Module without defined name");
    }
    Version version = module.version();
    if (version == null) {
      throw new IllegalArgumentException("Module without defined version");
    }
    final ObjectMapper mapper = this;
    
    module.setupModule(new Module.SetupContext()
    {
      public Version getMapperVersion()
      {
        return version();
      }
      
      public <C extends ObjectCodec> C getOwner()
      {
        return mapper;
      }
      
      public TypeFactory getTypeFactory()
      {
        return _typeFactory;
      }
      
      public boolean isEnabled(MapperFeature f)
      {
        return mapper.isEnabled(f);
      }
      
      public boolean isEnabled(DeserializationFeature f)
      {
        return mapper.isEnabled(f);
      }
      
      public boolean isEnabled(SerializationFeature f)
      {
        return mapper.isEnabled(f);
      }
      
      public boolean isEnabled(JsonFactory.Feature f)
      {
        return mapper.isEnabled(f);
      }
      
      public boolean isEnabled(JsonParser.Feature f)
      {
        return mapper.isEnabled(f);
      }
      
      public boolean isEnabled(JsonGenerator.Feature f)
      {
        return mapper.isEnabled(f);
      }
      
      public void addDeserializers(Deserializers d)
      {
        DeserializerFactory df = mapper_deserializationContext._factory.withAdditionalDeserializers(d);
        mapper_deserializationContext = mapper_deserializationContext.with(df);
      }
      
      public void addKeyDeserializers(KeyDeserializers d)
      {
        DeserializerFactory df = mapper_deserializationContext._factory.withAdditionalKeyDeserializers(d);
        mapper_deserializationContext = mapper_deserializationContext.with(df);
      }
      
      public void addBeanDeserializerModifier(BeanDeserializerModifier modifier)
      {
        DeserializerFactory df = mapper_deserializationContext._factory.withDeserializerModifier(modifier);
        mapper_deserializationContext = mapper_deserializationContext.with(df);
      }
      
      public void addSerializers(Serializers s)
      {
        mapper_serializerFactory = mapper_serializerFactory.withAdditionalSerializers(s);
      }
      
      public void addKeySerializers(Serializers s)
      {
        mapper_serializerFactory = mapper_serializerFactory.withAdditionalKeySerializers(s);
      }
      
      public void addBeanSerializerModifier(BeanSerializerModifier modifier)
      {
        mapper_serializerFactory = mapper_serializerFactory.withSerializerModifier(modifier);
      }
      
      public void addAbstractTypeResolver(AbstractTypeResolver resolver)
      {
        DeserializerFactory df = mapper_deserializationContext._factory.withAbstractTypeResolver(resolver);
        mapper_deserializationContext = mapper_deserializationContext.with(df);
      }
      
      public void addTypeModifier(TypeModifier modifier)
      {
        TypeFactory f = mapper_typeFactory;
        f = f.withModifier(modifier);
        mapper.setTypeFactory(f);
      }
      
      public void addValueInstantiators(ValueInstantiators instantiators)
      {
        DeserializerFactory df = mapper_deserializationContext._factory.withValueInstantiators(instantiators);
        mapper_deserializationContext = mapper_deserializationContext.with(df);
      }
      
      public void setClassIntrospector(ClassIntrospector ci)
      {
        mapper_deserializationConfig = mapper_deserializationConfig.with(ci);
        mapper_serializationConfig = mapper_serializationConfig.with(ci);
      }
      
      public void insertAnnotationIntrospector(AnnotationIntrospector ai)
      {
        mapper_deserializationConfig = mapper_deserializationConfig.withInsertedAnnotationIntrospector(ai);
        mapper_serializationConfig = mapper_serializationConfig.withInsertedAnnotationIntrospector(ai);
      }
      
      public void appendAnnotationIntrospector(AnnotationIntrospector ai)
      {
        mapper_deserializationConfig = mapper_deserializationConfig.withAppendedAnnotationIntrospector(ai);
        mapper_serializationConfig = mapper_serializationConfig.withAppendedAnnotationIntrospector(ai);
      }
      
      public void registerSubtypes(Class<?>... subtypes)
      {
        mapper.registerSubtypes(subtypes);
      }
      
      public void registerSubtypes(NamedType... subtypes)
      {
        mapper.registerSubtypes(subtypes);
      }
      
      public void setMixInAnnotations(Class<?> target, Class<?> mixinSource)
      {
        mapper.addMixIn(target, mixinSource);
      }
      
      public void addDeserializationProblemHandler(DeserializationProblemHandler handler)
      {
        mapper.addHandler(handler);
      }
      
      public void setNamingStrategy(PropertyNamingStrategy naming)
      {
        mapper.setPropertyNamingStrategy(naming);
      }
    });
    return this;
  }
  
  public ObjectMapper registerModules(Module... modules)
  {
    for (Module module : modules) {
      registerModule(module);
    }
    return this;
  }
  
  public ObjectMapper registerModules(Iterable<Module> modules)
  {
    for (Module module : modules) {
      registerModule(module);
    }
    return this;
  }
  
  public static List<Module> findModules()
  {
    return findModules(null);
  }
  
  public static List<Module> findModules(ClassLoader classLoader)
  {
    ArrayList<Module> modules = new ArrayList();
    ServiceLoader<Module> loader = classLoader == null ? ServiceLoader.load(Module.class) : ServiceLoader.load(Module.class, classLoader);
    for (Module module : loader) {
      modules.add(module);
    }
    return modules;
  }
  
  public ObjectMapper findAndRegisterModules()
  {
    return registerModules(findModules());
  }
  
  public SerializationConfig getSerializationConfig()
  {
    return _serializationConfig;
  }
  
  public DeserializationConfig getDeserializationConfig()
  {
    return _deserializationConfig;
  }
  
  public DeserializationContext getDeserializationContext()
  {
    return _deserializationContext;
  }
  
  public ObjectMapper setSerializerFactory(SerializerFactory f)
  {
    _serializerFactory = f;
    return this;
  }
  
  public SerializerFactory getSerializerFactory()
  {
    return _serializerFactory;
  }
  
  public ObjectMapper setSerializerProvider(DefaultSerializerProvider p)
  {
    _serializerProvider = p;
    return this;
  }
  
  public SerializerProvider getSerializerProvider()
  {
    return _serializerProvider;
  }
  
  public ObjectMapper setMixIns(Map<Class<?>, Class<?>> sourceMixins)
  {
    _mixIns.setLocalDefinitions(sourceMixins);
    return this;
  }
  
  public ObjectMapper addMixIn(Class<?> target, Class<?> mixinSource)
  {
    _mixIns.addLocalDefinition(target, mixinSource);
    return this;
  }
  
  public ObjectMapper setMixInResolver(ClassIntrospector.MixInResolver resolver)
  {
    SimpleMixInResolver r = _mixIns.withOverrides(resolver);
    if (r != _mixIns)
    {
      _mixIns = r;
      _deserializationConfig = new DeserializationConfig(_deserializationConfig, r);
      _serializationConfig = new SerializationConfig(_serializationConfig, r);
    }
    return this;
  }
  
  public Class<?> findMixInClassFor(Class<?> cls)
  {
    return _mixIns.findMixInClassFor(cls);
  }
  
  public int mixInCount()
  {
    return _mixIns.localSize();
  }
  
  @Deprecated
  public void setMixInAnnotations(Map<Class<?>, Class<?>> sourceMixins)
  {
    setMixIns(sourceMixins);
  }
  
  @Deprecated
  public final void addMixInAnnotations(Class<?> target, Class<?> mixinSource)
  {
    addMixIn(target, mixinSource);
  }
  
  public VisibilityChecker<?> getVisibilityChecker()
  {
    return _serializationConfig.getDefaultVisibilityChecker();
  }
  
  @Deprecated
  public void setVisibilityChecker(VisibilityChecker<?> vc)
  {
    setVisibility(vc);
  }
  
  public ObjectMapper setVisibility(VisibilityChecker<?> vc)
  {
    _deserializationConfig = _deserializationConfig.with(vc);
    _serializationConfig = _serializationConfig.with(vc);
    return this;
  }
  
  public ObjectMapper setVisibility(PropertyAccessor forMethod, JsonAutoDetect.Visibility visibility)
  {
    _deserializationConfig = _deserializationConfig.withVisibility(forMethod, visibility);
    _serializationConfig = _serializationConfig.withVisibility(forMethod, visibility);
    return this;
  }
  
  public SubtypeResolver getSubtypeResolver()
  {
    return _subtypeResolver;
  }
  
  public ObjectMapper setSubtypeResolver(SubtypeResolver str)
  {
    _subtypeResolver = str;
    _deserializationConfig = _deserializationConfig.with(str);
    _serializationConfig = _serializationConfig.with(str);
    return this;
  }
  
  public ObjectMapper setAnnotationIntrospector(AnnotationIntrospector ai)
  {
    _serializationConfig = _serializationConfig.with(ai);
    _deserializationConfig = _deserializationConfig.with(ai);
    return this;
  }
  
  public ObjectMapper setAnnotationIntrospectors(AnnotationIntrospector serializerAI, AnnotationIntrospector deserializerAI)
  {
    _serializationConfig = _serializationConfig.with(serializerAI);
    _deserializationConfig = _deserializationConfig.with(deserializerAI);
    return this;
  }
  
  public ObjectMapper setPropertyNamingStrategy(PropertyNamingStrategy s)
  {
    _serializationConfig = _serializationConfig.with(s);
    _deserializationConfig = _deserializationConfig.with(s);
    return this;
  }
  
  public PropertyNamingStrategy getPropertyNamingStrategy()
  {
    return _serializationConfig.getPropertyNamingStrategy();
  }
  
  public ObjectMapper setSerializationInclusion(JsonInclude.Include incl)
  {
    _serializationConfig = _serializationConfig.withSerializationInclusion(incl);
    return this;
  }
  
  public ObjectMapper setDefaultPrettyPrinter(PrettyPrinter pp)
  {
    _serializationConfig = _serializationConfig.withDefaultPrettyPrinter(pp);
    return this;
  }
  
  public ObjectMapper enableDefaultTyping()
  {
    return enableDefaultTyping(DefaultTyping.OBJECT_AND_NON_CONCRETE);
  }
  
  public ObjectMapper enableDefaultTyping(DefaultTyping dti)
  {
    return enableDefaultTyping(dti, JsonTypeInfo.As.WRAPPER_ARRAY);
  }
  
  public ObjectMapper enableDefaultTyping(DefaultTyping applicability, JsonTypeInfo.As includeAs)
  {
    if (includeAs == JsonTypeInfo.As.EXTERNAL_PROPERTY) {
      throw new IllegalArgumentException("Can not use includeAs of " + includeAs);
    }
    TypeResolverBuilder<?> typer = new DefaultTypeResolverBuilder(applicability);
    
    typer = typer.init(JsonTypeInfo.Id.CLASS, null);
    typer = typer.inclusion(includeAs);
    return setDefaultTyping(typer);
  }
  
  public ObjectMapper enableDefaultTypingAsProperty(DefaultTyping applicability, String propertyName)
  {
    TypeResolverBuilder<?> typer = new DefaultTypeResolverBuilder(applicability);
    
    typer = typer.init(JsonTypeInfo.Id.CLASS, null);
    typer = typer.inclusion(JsonTypeInfo.As.PROPERTY);
    typer = typer.typeProperty(propertyName);
    return setDefaultTyping(typer);
  }
  
  public ObjectMapper disableDefaultTyping()
  {
    return setDefaultTyping(null);
  }
  
  public ObjectMapper setDefaultTyping(TypeResolverBuilder<?> typer)
  {
    _deserializationConfig = _deserializationConfig.with(typer);
    _serializationConfig = _serializationConfig.with(typer);
    return this;
  }
  
  public void registerSubtypes(Class<?>... classes)
  {
    getSubtypeResolver().registerSubtypes(classes);
  }
  
  public void registerSubtypes(NamedType... types)
  {
    getSubtypeResolver().registerSubtypes(types);
  }
  
  public TypeFactory getTypeFactory()
  {
    return _typeFactory;
  }
  
  public ObjectMapper setTypeFactory(TypeFactory f)
  {
    _typeFactory = f;
    _deserializationConfig = _deserializationConfig.with(f);
    _serializationConfig = _serializationConfig.with(f);
    return this;
  }
  
  public JavaType constructType(Type t)
  {
    return _typeFactory.constructType(t);
  }
  
  public JsonNodeFactory getNodeFactory()
  {
    return _deserializationConfig.getNodeFactory();
  }
  
  public ObjectMapper setNodeFactory(JsonNodeFactory f)
  {
    _deserializationConfig = _deserializationConfig.with(f);
    return this;
  }
  
  public ObjectMapper addHandler(DeserializationProblemHandler h)
  {
    _deserializationConfig = _deserializationConfig.withHandler(h);
    return this;
  }
  
  public ObjectMapper clearProblemHandlers()
  {
    _deserializationConfig = _deserializationConfig.withNoProblemHandlers();
    return this;
  }
  
  public ObjectMapper setConfig(DeserializationConfig config)
  {
    _deserializationConfig = config;
    return this;
  }
  
  @Deprecated
  public void setFilters(FilterProvider filterProvider)
  {
    _serializationConfig = _serializationConfig.withFilters(filterProvider);
  }
  
  public ObjectMapper setFilterProvider(FilterProvider filterProvider)
  {
    _serializationConfig = _serializationConfig.withFilters(filterProvider);
    return this;
  }
  
  public ObjectMapper setBase64Variant(Base64Variant v)
  {
    _serializationConfig = _serializationConfig.with(v);
    _deserializationConfig = _deserializationConfig.with(v);
    return this;
  }
  
  public ObjectMapper setConfig(SerializationConfig config)
  {
    _serializationConfig = config;
    return this;
  }
  
  public JsonFactory getFactory()
  {
    return _jsonFactory;
  }
  
  @Deprecated
  public JsonFactory getJsonFactory()
  {
    return getFactory();
  }
  
  public ObjectMapper setDateFormat(DateFormat dateFormat)
  {
    _deserializationConfig = _deserializationConfig.with(dateFormat);
    _serializationConfig = _serializationConfig.with(dateFormat);
    return this;
  }
  
  public DateFormat getDateFormat()
  {
    return _serializationConfig.getDateFormat();
  }
  
  public Object setHandlerInstantiator(HandlerInstantiator hi)
  {
    _deserializationConfig = _deserializationConfig.with(hi);
    _serializationConfig = _serializationConfig.with(hi);
    return this;
  }
  
  public ObjectMapper setInjectableValues(InjectableValues injectableValues)
  {
    _injectableValues = injectableValues;
    return this;
  }
  
  public InjectableValues getInjectableValues()
  {
    return _injectableValues;
  }
  
  public ObjectMapper setLocale(Locale l)
  {
    _deserializationConfig = _deserializationConfig.with(l);
    _serializationConfig = _serializationConfig.with(l);
    return this;
  }
  
  public ObjectMapper setTimeZone(TimeZone tz)
  {
    _deserializationConfig = _deserializationConfig.with(tz);
    _serializationConfig = _serializationConfig.with(tz);
    return this;
  }
  
  public boolean isEnabled(MapperFeature f)
  {
    return _serializationConfig.isEnabled(f);
  }
  
  public ObjectMapper configure(MapperFeature f, boolean state)
  {
    _serializationConfig = (state ? _serializationConfig.with(new MapperFeature[] { f }) : _serializationConfig.without(new MapperFeature[] { f }));
    
    _deserializationConfig = (state ? _deserializationConfig.with(new MapperFeature[] { f }) : _deserializationConfig.without(new MapperFeature[] { f }));
    
    return this;
  }
  
  public ObjectMapper enable(MapperFeature... f)
  {
    _deserializationConfig = _deserializationConfig.with(f);
    _serializationConfig = _serializationConfig.with(f);
    return this;
  }
  
  public ObjectMapper disable(MapperFeature... f)
  {
    _deserializationConfig = _deserializationConfig.without(f);
    _serializationConfig = _serializationConfig.without(f);
    return this;
  }
  
  public boolean isEnabled(SerializationFeature f)
  {
    return _serializationConfig.isEnabled(f);
  }
  
  public ObjectMapper configure(SerializationFeature f, boolean state)
  {
    _serializationConfig = (state ? _serializationConfig.with(f) : _serializationConfig.without(f));
    
    return this;
  }
  
  public ObjectMapper enable(SerializationFeature f)
  {
    _serializationConfig = _serializationConfig.with(f);
    return this;
  }
  
  public ObjectMapper enable(SerializationFeature first, SerializationFeature... f)
  {
    _serializationConfig = _serializationConfig.with(first, f);
    return this;
  }
  
  public ObjectMapper disable(SerializationFeature f)
  {
    _serializationConfig = _serializationConfig.without(f);
    return this;
  }
  
  public ObjectMapper disable(SerializationFeature first, SerializationFeature... f)
  {
    _serializationConfig = _serializationConfig.without(first, f);
    return this;
  }
  
  public boolean isEnabled(DeserializationFeature f)
  {
    return _deserializationConfig.isEnabled(f);
  }
  
  public ObjectMapper configure(DeserializationFeature f, boolean state)
  {
    _deserializationConfig = (state ? _deserializationConfig.with(f) : _deserializationConfig.without(f));
    
    return this;
  }
  
  public ObjectMapper enable(DeserializationFeature feature)
  {
    _deserializationConfig = _deserializationConfig.with(feature);
    return this;
  }
  
  public ObjectMapper enable(DeserializationFeature first, DeserializationFeature... f)
  {
    _deserializationConfig = _deserializationConfig.with(first, f);
    return this;
  }
  
  public ObjectMapper disable(DeserializationFeature feature)
  {
    _deserializationConfig = _deserializationConfig.without(feature);
    return this;
  }
  
  public ObjectMapper disable(DeserializationFeature first, DeserializationFeature... f)
  {
    _deserializationConfig = _deserializationConfig.without(first, f);
    return this;
  }
  
  public boolean isEnabled(JsonParser.Feature f)
  {
    return _deserializationConfig.isEnabled(f, _jsonFactory);
  }
  
  public ObjectMapper configure(JsonParser.Feature f, boolean state)
  {
    _jsonFactory.configure(f, state);
    return this;
  }
  
  public ObjectMapper enable(JsonParser.Feature... features)
  {
    for (JsonParser.Feature f : features) {
      _jsonFactory.enable(f);
    }
    return this;
  }
  
  public ObjectMapper disable(JsonParser.Feature... features)
  {
    for (JsonParser.Feature f : features) {
      _jsonFactory.disable(f);
    }
    return this;
  }
  
  public boolean isEnabled(JsonGenerator.Feature f)
  {
    return _serializationConfig.isEnabled(f, _jsonFactory);
  }
  
  public ObjectMapper configure(JsonGenerator.Feature f, boolean state)
  {
    _jsonFactory.configure(f, state);
    return this;
  }
  
  public ObjectMapper enable(JsonGenerator.Feature... features)
  {
    for (JsonGenerator.Feature f : features) {
      _jsonFactory.enable(f);
    }
    return this;
  }
  
  public ObjectMapper disable(JsonGenerator.Feature... features)
  {
    for (JsonGenerator.Feature f : features) {
      _jsonFactory.disable(f);
    }
    return this;
  }
  
  public boolean isEnabled(JsonFactory.Feature f)
  {
    return _jsonFactory.isEnabled(f);
  }
  
  public <T> T readValue(JsonParser jp, Class<T> valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readValue(getDeserializationConfig(), jp, _typeFactory.constructType(valueType));
  }
  
  public <T> T readValue(JsonParser jp, TypeReference<?> valueTypeRef)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readValue(getDeserializationConfig(), jp, _typeFactory.constructType(valueTypeRef));
  }
  
  public final <T> T readValue(JsonParser jp, ResolvedType valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readValue(getDeserializationConfig(), jp, (JavaType)valueType);
  }
  
  public <T> T readValue(JsonParser jp, JavaType valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readValue(getDeserializationConfig(), jp, valueType);
  }
  
  public <T extends TreeNode> T readTree(JsonParser jp)
    throws IOException, JsonProcessingException
  {
    DeserializationConfig cfg = getDeserializationConfig();
    JsonToken t = jp.getCurrentToken();
    if (t == null)
    {
      t = jp.nextToken();
      if (t == null) {
        return null;
      }
    }
    JsonNode n = (JsonNode)_readValue(cfg, jp, JSON_NODE_TYPE);
    if (n == null) {
      n = getNodeFactory().nullNode();
    }
    T result = n;
    return result;
  }
  
  public <T> MappingIterator<T> readValues(JsonParser jp, ResolvedType valueType)
    throws IOException, JsonProcessingException
  {
    return readValues(jp, (JavaType)valueType);
  }
  
  public <T> MappingIterator<T> readValues(JsonParser jp, JavaType valueType)
    throws IOException, JsonProcessingException
  {
    DeserializationConfig config = getDeserializationConfig();
    DeserializationContext ctxt = createDeserializationContext(jp, config);
    JsonDeserializer<?> deser = _findRootDeserializer(ctxt, valueType);
    
    return new MappingIterator(valueType, jp, ctxt, deser, false, null);
  }
  
  public <T> MappingIterator<T> readValues(JsonParser jp, Class<T> valueType)
    throws IOException, JsonProcessingException
  {
    return readValues(jp, _typeFactory.constructType(valueType));
  }
  
  public <T> MappingIterator<T> readValues(JsonParser jp, TypeReference<?> valueTypeRef)
    throws IOException, JsonProcessingException
  {
    return readValues(jp, _typeFactory.constructType(valueTypeRef));
  }
  
  public JsonNode readTree(InputStream in)
    throws IOException, JsonProcessingException
  {
    JsonNode n = (JsonNode)_readMapAndClose(_jsonFactory.createParser(in), JSON_NODE_TYPE);
    return n == null ? NullNode.instance : n;
  }
  
  public JsonNode readTree(Reader r)
    throws IOException, JsonProcessingException
  {
    JsonNode n = (JsonNode)_readMapAndClose(_jsonFactory.createParser(r), JSON_NODE_TYPE);
    return n == null ? NullNode.instance : n;
  }
  
  public JsonNode readTree(String content)
    throws IOException, JsonProcessingException
  {
    JsonNode n = (JsonNode)_readMapAndClose(_jsonFactory.createParser(content), JSON_NODE_TYPE);
    return n == null ? NullNode.instance : n;
  }
  
  public JsonNode readTree(byte[] content)
    throws IOException, JsonProcessingException
  {
    JsonNode n = (JsonNode)_readMapAndClose(_jsonFactory.createParser(content), JSON_NODE_TYPE);
    return n == null ? NullNode.instance : n;
  }
  
  public JsonNode readTree(File file)
    throws IOException, JsonProcessingException
  {
    JsonNode n = (JsonNode)_readMapAndClose(_jsonFactory.createParser(file), JSON_NODE_TYPE);
    return n == null ? NullNode.instance : n;
  }
  
  public JsonNode readTree(URL source)
    throws IOException, JsonProcessingException
  {
    JsonNode n = (JsonNode)_readMapAndClose(_jsonFactory.createParser(source), JSON_NODE_TYPE);
    return n == null ? NullNode.instance : n;
  }
  
  public void writeValue(JsonGenerator g, Object value)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    SerializationConfig config = getSerializationConfig();
    if ((config.isEnabled(SerializationFeature.INDENT_OUTPUT)) && 
      (g.getPrettyPrinter() == null)) {
      g.setPrettyPrinter(config.constructDefaultPrettyPrinter());
    }
    if ((config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)) && ((value instanceof Closeable)))
    {
      _writeCloseableValue(g, value, config);
    }
    else
    {
      _serializerProvider(config).serializeValue(g, value);
      if (config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
        g.flush();
      }
    }
  }
  
  public void writeTree(JsonGenerator jgen, TreeNode rootNode)
    throws IOException, JsonProcessingException
  {
    SerializationConfig config = getSerializationConfig();
    _serializerProvider(config).serializeValue(jgen, rootNode);
    if (config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
      jgen.flush();
    }
  }
  
  public void writeTree(JsonGenerator jgen, JsonNode rootNode)
    throws IOException, JsonProcessingException
  {
    SerializationConfig config = getSerializationConfig();
    _serializerProvider(config).serializeValue(jgen, rootNode);
    if (config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
      jgen.flush();
    }
  }
  
  public ObjectNode createObjectNode()
  {
    return _deserializationConfig.getNodeFactory().objectNode();
  }
  
  public ArrayNode createArrayNode()
  {
    return _deserializationConfig.getNodeFactory().arrayNode();
  }
  
  public JsonParser treeAsTokens(TreeNode n)
  {
    return new TreeTraversingParser((JsonNode)n, this);
  }
  
  public <T> T treeToValue(TreeNode n, Class<T> valueType)
    throws JsonProcessingException
  {
    try
    {
      if ((valueType != Object.class) && (valueType.isAssignableFrom(n.getClass()))) {
        return n;
      }
      return (T)readValue(treeAsTokens(n), valueType);
    }
    catch (JsonProcessingException e)
    {
      throw e;
    }
    catch (IOException e)
    {
      throw new IllegalArgumentException(e.getMessage(), e);
    }
  }
  
  public <T extends JsonNode> T valueToTree(Object fromValue)
    throws IllegalArgumentException
  {
    if (fromValue == null) {
      return null;
    }
    TokenBuffer buf = new TokenBuffer(this, false);
    if (isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
      buf = buf.forceUseOfBigDecimal(true);
    }
    JsonNode result;
    try
    {
      writeValue(buf, fromValue);
      JsonParser jp = buf.asParser();
      result = (JsonNode)readTree(jp);
      jp.close();
    }
    catch (IOException e)
    {
      throw new IllegalArgumentException(e.getMessage(), e);
    }
    return result;
  }
  
  public boolean canSerialize(Class<?> type)
  {
    return _serializerProvider(getSerializationConfig()).hasSerializerFor(type, null);
  }
  
  public boolean canSerialize(Class<?> type, AtomicReference<Throwable> cause)
  {
    return _serializerProvider(getSerializationConfig()).hasSerializerFor(type, cause);
  }
  
  public boolean canDeserialize(JavaType type)
  {
    return createDeserializationContext(null, getDeserializationConfig()).hasValueDeserializerFor(type, null);
  }
  
  public boolean canDeserialize(JavaType type, AtomicReference<Throwable> cause)
  {
    return createDeserializationContext(null, getDeserializationConfig()).hasValueDeserializerFor(type, cause);
  }
  
  public <T> T readValue(File src, Class<T> valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), _typeFactory.constructType(valueType));
  }
  
  public <T> T readValue(File src, TypeReference valueTypeRef)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), _typeFactory.constructType(valueTypeRef));
  }
  
  public <T> T readValue(File src, JavaType valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), valueType);
  }
  
  public <T> T readValue(URL src, Class<T> valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), _typeFactory.constructType(valueType));
  }
  
  public <T> T readValue(URL src, TypeReference valueTypeRef)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), _typeFactory.constructType(valueTypeRef));
  }
  
  public <T> T readValue(URL src, JavaType valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), valueType);
  }
  
  public <T> T readValue(String content, Class<T> valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(content), _typeFactory.constructType(valueType));
  }
  
  public <T> T readValue(String content, TypeReference valueTypeRef)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(content), _typeFactory.constructType(valueTypeRef));
  }
  
  public <T> T readValue(String content, JavaType valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(content), valueType);
  }
  
  public <T> T readValue(Reader src, Class<T> valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), _typeFactory.constructType(valueType));
  }
  
  public <T> T readValue(Reader src, TypeReference valueTypeRef)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), _typeFactory.constructType(valueTypeRef));
  }
  
  public <T> T readValue(Reader src, JavaType valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), valueType);
  }
  
  public <T> T readValue(InputStream src, Class<T> valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), _typeFactory.constructType(valueType));
  }
  
  public <T> T readValue(InputStream src, TypeReference valueTypeRef)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), _typeFactory.constructType(valueTypeRef));
  }
  
  public <T> T readValue(InputStream src, JavaType valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), valueType);
  }
  
  public <T> T readValue(byte[] src, Class<T> valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), _typeFactory.constructType(valueType));
  }
  
  public <T> T readValue(byte[] src, int offset, int len, Class<T> valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src, offset, len), _typeFactory.constructType(valueType));
  }
  
  public <T> T readValue(byte[] src, TypeReference valueTypeRef)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), _typeFactory.constructType(valueTypeRef));
  }
  
  public <T> T readValue(byte[] src, int offset, int len, TypeReference valueTypeRef)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src, offset, len), _typeFactory.constructType(valueTypeRef));
  }
  
  public <T> T readValue(byte[] src, JavaType valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src), valueType);
  }
  
  public <T> T readValue(byte[] src, int offset, int len, JavaType valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    return (T)_readMapAndClose(_jsonFactory.createParser(src, offset, len), valueType);
  }
  
  public void writeValue(File resultFile, Object value)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    _configAndWriteValue(_jsonFactory.createGenerator(resultFile, JsonEncoding.UTF8), value);
  }
  
  public void writeValue(OutputStream out, Object value)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    _configAndWriteValue(_jsonFactory.createGenerator(out, JsonEncoding.UTF8), value);
  }
  
  public void writeValue(Writer w, Object value)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    _configAndWriteValue(_jsonFactory.createGenerator(w), value);
  }
  
  public String writeValueAsString(Object value)
    throws JsonProcessingException
  {
    SegmentedStringWriter sw = new SegmentedStringWriter(_jsonFactory._getBufferRecycler());
    try
    {
      _configAndWriteValue(_jsonFactory.createGenerator(sw), value);
    }
    catch (JsonProcessingException e)
    {
      throw e;
    }
    catch (IOException e)
    {
      throw JsonMappingException.fromUnexpectedIOE(e);
    }
    return sw.getAndClear();
  }
  
  public byte[] writeValueAsBytes(Object value)
    throws JsonProcessingException
  {
    ByteArrayBuilder bb = new ByteArrayBuilder(_jsonFactory._getBufferRecycler());
    try
    {
      _configAndWriteValue(_jsonFactory.createGenerator(bb, JsonEncoding.UTF8), value);
    }
    catch (JsonProcessingException e)
    {
      throw e;
    }
    catch (IOException e)
    {
      throw JsonMappingException.fromUnexpectedIOE(e);
    }
    byte[] result = bb.toByteArray();
    bb.release();
    return result;
  }
  
  public ObjectWriter writer()
  {
    return _newWriter(getSerializationConfig());
  }
  
  public ObjectWriter writer(SerializationFeature feature)
  {
    return _newWriter(getSerializationConfig().with(feature));
  }
  
  public ObjectWriter writer(SerializationFeature first, SerializationFeature... other)
  {
    return _newWriter(getSerializationConfig().with(first, other));
  }
  
  public ObjectWriter writer(DateFormat df)
  {
    return _newWriter(getSerializationConfig().with(df));
  }
  
  public ObjectWriter writerWithView(Class<?> serializationView)
  {
    return _newWriter(getSerializationConfig().withView(serializationView));
  }
  
  public ObjectWriter writerFor(Class<?> rootType)
  {
    return _newWriter(getSerializationConfig(), rootType == null ? null : _typeFactory.constructType(rootType), null);
  }
  
  public ObjectWriter writerFor(TypeReference<?> rootType)
  {
    return _newWriter(getSerializationConfig(), rootType == null ? null : _typeFactory.constructType(rootType), null);
  }
  
  public ObjectWriter writerFor(JavaType rootType)
  {
    return _newWriter(getSerializationConfig(), rootType, null);
  }
  
  public ObjectWriter writer(PrettyPrinter pp)
  {
    if (pp == null) {
      pp = ObjectWriter.NULL_PRETTY_PRINTER;
    }
    return _newWriter(getSerializationConfig(), null, pp);
  }
  
  public ObjectWriter writerWithDefaultPrettyPrinter()
  {
    SerializationConfig config = getSerializationConfig();
    return _newWriter(config, null, config.getDefaultPrettyPrinter());
  }
  
  public ObjectWriter writer(FilterProvider filterProvider)
  {
    return _newWriter(getSerializationConfig().withFilters(filterProvider));
  }
  
  public ObjectWriter writer(FormatSchema schema)
  {
    _verifySchemaType(schema);
    return _newWriter(getSerializationConfig(), schema);
  }
  
  public ObjectWriter writer(Base64Variant defaultBase64)
  {
    return _newWriter(getSerializationConfig().with(defaultBase64));
  }
  
  public ObjectWriter writer(CharacterEscapes escapes)
  {
    return _newWriter(getSerializationConfig()).with(escapes);
  }
  
  public ObjectWriter writer(ContextAttributes attrs)
  {
    return _newWriter(getSerializationConfig().with(attrs));
  }
  
  @Deprecated
  public ObjectWriter writerWithType(Class<?> rootType)
  {
    return _newWriter(getSerializationConfig(), rootType == null ? null : _typeFactory.constructType(rootType), null);
  }
  
  @Deprecated
  public ObjectWriter writerWithType(TypeReference<?> rootType)
  {
    return _newWriter(getSerializationConfig(), rootType == null ? null : _typeFactory.constructType(rootType), null);
  }
  
  @Deprecated
  public ObjectWriter writerWithType(JavaType rootType)
  {
    return _newWriter(getSerializationConfig(), rootType, null);
  }
  
  public ObjectReader reader()
  {
    return _newReader(getDeserializationConfig()).with(_injectableValues);
  }
  
  public ObjectReader reader(DeserializationFeature feature)
  {
    return _newReader(getDeserializationConfig().with(feature));
  }
  
  public ObjectReader reader(DeserializationFeature first, DeserializationFeature... other)
  {
    return _newReader(getDeserializationConfig().with(first, other));
  }
  
  public ObjectReader readerForUpdating(Object valueToUpdate)
  {
    JavaType t = _typeFactory.constructType(valueToUpdate.getClass());
    return _newReader(getDeserializationConfig(), t, valueToUpdate, null, _injectableValues);
  }
  
  public ObjectReader readerFor(JavaType type)
  {
    return _newReader(getDeserializationConfig(), type, null, null, _injectableValues);
  }
  
  public ObjectReader readerFor(Class<?> type)
  {
    return _newReader(getDeserializationConfig(), _typeFactory.constructType(type), null, null, _injectableValues);
  }
  
  public ObjectReader readerFor(TypeReference<?> type)
  {
    return _newReader(getDeserializationConfig(), _typeFactory.constructType(type), null, null, _injectableValues);
  }
  
  public ObjectReader reader(JsonNodeFactory f)
  {
    return _newReader(getDeserializationConfig()).with(f);
  }
  
  public ObjectReader reader(FormatSchema schema)
  {
    _verifySchemaType(schema);
    return _newReader(getDeserializationConfig(), null, null, schema, _injectableValues);
  }
  
  public ObjectReader reader(InjectableValues injectableValues)
  {
    return _newReader(getDeserializationConfig(), null, null, null, injectableValues);
  }
  
  public ObjectReader readerWithView(Class<?> view)
  {
    return _newReader(getDeserializationConfig().withView(view));
  }
  
  public ObjectReader reader(Base64Variant defaultBase64)
  {
    return _newReader(getDeserializationConfig().with(defaultBase64));
  }
  
  public ObjectReader reader(ContextAttributes attrs)
  {
    return _newReader(getDeserializationConfig().with(attrs));
  }
  
  @Deprecated
  public ObjectReader reader(JavaType type)
  {
    return _newReader(getDeserializationConfig(), type, null, null, _injectableValues);
  }
  
  @Deprecated
  public ObjectReader reader(Class<?> type)
  {
    return _newReader(getDeserializationConfig(), _typeFactory.constructType(type), null, null, _injectableValues);
  }
  
  @Deprecated
  public ObjectReader reader(TypeReference<?> type)
  {
    return _newReader(getDeserializationConfig(), _typeFactory.constructType(type), null, null, _injectableValues);
  }
  
  public <T> T convertValue(Object fromValue, Class<T> toValueType)
    throws IllegalArgumentException
  {
    if (fromValue == null) {
      return null;
    }
    return (T)_convert(fromValue, _typeFactory.constructType(toValueType));
  }
  
  public <T> T convertValue(Object fromValue, TypeReference<?> toValueTypeRef)
    throws IllegalArgumentException
  {
    return (T)convertValue(fromValue, _typeFactory.constructType(toValueTypeRef));
  }
  
  public <T> T convertValue(Object fromValue, JavaType toValueType)
    throws IllegalArgumentException
  {
    if (fromValue == null) {
      return null;
    }
    return (T)_convert(fromValue, toValueType);
  }
  
  protected Object _convert(Object fromValue, JavaType toValueType)
    throws IllegalArgumentException
  {
    Class<?> targetType = toValueType.getRawClass();
    if ((targetType != Object.class) && (!toValueType.hasGenericTypes()) && (targetType.isAssignableFrom(fromValue.getClass()))) {
      return fromValue;
    }
    TokenBuffer buf = new TokenBuffer(this, false);
    if (isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
      buf = buf.forceUseOfBigDecimal(true);
    }
    try
    {
      SerializationConfig config = getSerializationConfig().without(SerializationFeature.WRAP_ROOT_VALUE);
      
      _serializerProvider(config).serializeValue(buf, fromValue);
      
      JsonParser jp = buf.asParser();
      
      DeserializationConfig deserConfig = getDeserializationConfig();
      JsonToken t = _initForReading(jp);
      Object result;
      Object result;
      if (t == JsonToken.VALUE_NULL)
      {
        DeserializationContext ctxt = createDeserializationContext(jp, deserConfig);
        result = _findRootDeserializer(ctxt, toValueType).getNullValue(ctxt);
      }
      else
      {
        Object result;
        if ((t == JsonToken.END_ARRAY) || (t == JsonToken.END_OBJECT))
        {
          result = null;
        }
        else
        {
          DeserializationContext ctxt = createDeserializationContext(jp, deserConfig);
          JsonDeserializer<Object> deser = _findRootDeserializer(ctxt, toValueType);
          
          result = deser.deserialize(jp, ctxt);
        }
      }
      jp.close();
      return result;
    }
    catch (IOException e)
    {
      throw new IllegalArgumentException(e.getMessage(), e);
    }
  }
  
  @Deprecated
  public JsonSchema generateJsonSchema(Class<?> t)
    throws JsonMappingException
  {
    return _serializerProvider(getSerializationConfig()).generateJsonSchema(t);
  }
  
  public void acceptJsonFormatVisitor(Class<?> type, JsonFormatVisitorWrapper visitor)
    throws JsonMappingException
  {
    acceptJsonFormatVisitor(_typeFactory.constructType(type), visitor);
  }
  
  public void acceptJsonFormatVisitor(JavaType type, JsonFormatVisitorWrapper visitor)
    throws JsonMappingException
  {
    if (type == null) {
      throw new IllegalArgumentException("type must be provided");
    }
    _serializerProvider(getSerializationConfig()).acceptJsonFormatVisitor(type, visitor);
  }
  
  protected DefaultSerializerProvider _serializerProvider(SerializationConfig config)
  {
    return _serializerProvider.createInstance(config, _serializerFactory);
  }
  
  @Deprecated
  protected PrettyPrinter _defaultPrettyPrinter()
  {
    return _serializationConfig.constructDefaultPrettyPrinter();
  }
  
  protected final void _configAndWriteValue(JsonGenerator g, Object value)
    throws IOException
  {
    SerializationConfig cfg = getSerializationConfig();
    cfg.initialize(g);
    if ((cfg.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)) && ((value instanceof Closeable)))
    {
      _configAndWriteCloseable(g, value, cfg);
      return;
    }
    boolean closed = false;
    try
    {
      _serializerProvider(cfg).serializeValue(g, value);
      closed = true;
      g.close(); return;
    }
    finally
    {
      if (!closed)
      {
        g.disable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
        try
        {
          g.close();
        }
        catch (IOException ioe) {}
      }
    }
  }
  
  protected final void _configAndWriteValue(JsonGenerator g, Object value, Class<?> viewClass)
    throws IOException
  {
    SerializationConfig cfg = getSerializationConfig().withView(viewClass);
    cfg.initialize(g);
    if ((cfg.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)) && ((value instanceof Closeable)))
    {
      _configAndWriteCloseable(g, value, cfg);
      return;
    }
    boolean closed = false;
    try
    {
      _serializerProvider(cfg).serializeValue(g, value);
      closed = true;
      g.close(); return;
    }
    finally
    {
      if (!closed)
      {
        g.disable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
        try
        {
          g.close();
        }
        catch (IOException ioe) {}
      }
    }
  }
  
  private final void _configAndWriteCloseable(JsonGenerator g, Object value, SerializationConfig cfg)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    Closeable toClose = (Closeable)value;
    try
    {
      _serializerProvider(cfg).serializeValue(g, value);
      JsonGenerator tmpGen = g;
      g = null;
      tmpGen.close();
      Closeable tmpToClose = toClose;
      toClose = null;
      tmpToClose.close(); return;
    }
    finally
    {
      if (g != null)
      {
        g.disable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
        try
        {
          g.close();
        }
        catch (IOException ioe) {}
      }
      if (toClose != null) {
        try
        {
          toClose.close();
        }
        catch (IOException ioe) {}
      }
    }
  }
  
  private final void _writeCloseableValue(JsonGenerator g, Object value, SerializationConfig cfg)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    Closeable toClose = (Closeable)value;
    try
    {
      _serializerProvider(cfg).serializeValue(g, value);
      if (cfg.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
        g.flush();
      }
      Closeable tmpToClose = toClose;
      toClose = null;
      tmpToClose.close(); return;
    }
    finally
    {
      if (toClose != null) {
        try
        {
          toClose.close();
        }
        catch (IOException ioe) {}
      }
    }
  }
  
  protected DefaultDeserializationContext createDeserializationContext(JsonParser jp, DeserializationConfig cfg)
  {
    return _deserializationContext.createInstance(cfg, jp, _injectableValues);
  }
  
  protected Object _readValue(DeserializationConfig cfg, JsonParser jp, JavaType valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    JsonToken t = _initForReading(jp);
    Object result;
    Object result;
    if (t == JsonToken.VALUE_NULL)
    {
      DeserializationContext ctxt = createDeserializationContext(jp, cfg);
      result = _findRootDeserializer(ctxt, valueType).getNullValue(ctxt);
    }
    else
    {
      Object result;
      if ((t == JsonToken.END_ARRAY) || (t == JsonToken.END_OBJECT))
      {
        result = null;
      }
      else
      {
        DeserializationContext ctxt = createDeserializationContext(jp, cfg);
        JsonDeserializer<Object> deser = _findRootDeserializer(ctxt, valueType);
        Object result;
        if (cfg.useRootWrapping()) {
          result = _unwrapAndDeserialize(jp, ctxt, cfg, valueType, deser);
        } else {
          result = deser.deserialize(jp, ctxt);
        }
      }
    }
    jp.clearCurrentToken();
    return result;
  }
  
  protected Object _readMapAndClose(JsonParser jp, JavaType valueType)
    throws IOException, JsonParseException, JsonMappingException
  {
    try
    {
      JsonToken t = _initForReading(jp);
      Object result;
      DeserializationConfig cfg;
      Object result;
      if (t == JsonToken.VALUE_NULL)
      {
        DeserializationContext ctxt = createDeserializationContext(jp, getDeserializationConfig());
        
        result = _findRootDeserializer(ctxt, valueType).getNullValue(ctxt);
      }
      else
      {
        Object result;
        if ((t == JsonToken.END_ARRAY) || (t == JsonToken.END_OBJECT))
        {
          result = null;
        }
        else
        {
          cfg = getDeserializationConfig();
          DeserializationContext ctxt = createDeserializationContext(jp, cfg);
          JsonDeserializer<Object> deser = _findRootDeserializer(ctxt, valueType);
          Object result;
          if (cfg.useRootWrapping()) {
            result = _unwrapAndDeserialize(jp, ctxt, cfg, valueType, deser);
          } else {
            result = deser.deserialize(jp, ctxt);
          }
          ctxt.checkUnresolvedObjectId();
        }
      }
      jp.clearCurrentToken();
      return (DeserializationConfig)result;
    }
    finally
    {
      try
      {
        jp.close();
      }
      catch (IOException ioe) {}
    }
  }
  
  protected JsonToken _initForReading(JsonParser p)
    throws IOException
  {
    _deserializationConfig.initialize(p);
    
    JsonToken t = p.getCurrentToken();
    if (t == null)
    {
      t = p.nextToken();
      if (t == null) {
        throw JsonMappingException.from(p, "No content to map due to end-of-input");
      }
    }
    return t;
  }
  
  protected Object _unwrapAndDeserialize(JsonParser p, DeserializationContext ctxt, DeserializationConfig config, JavaType rootType, JsonDeserializer<Object> deser)
    throws IOException
  {
    PropertyName expRootName = config.findRootName(rootType);
    
    String expSimpleName = expRootName.getSimpleName();
    if (p.getCurrentToken() != JsonToken.START_OBJECT) {
      throw JsonMappingException.from(p, "Current token not START_OBJECT (needed to unwrap root name '" + expSimpleName + "'), but " + p.getCurrentToken());
    }
    if (p.nextToken() != JsonToken.FIELD_NAME) {
      throw JsonMappingException.from(p, "Current token not FIELD_NAME (to contain expected root name '" + expSimpleName + "'), but " + p.getCurrentToken());
    }
    String actualName = p.getCurrentName();
    if (!expSimpleName.equals(actualName)) {
      throw JsonMappingException.from(p, "Root name '" + actualName + "' does not match expected ('" + expSimpleName + "') for type " + rootType);
    }
    p.nextToken();
    Object result = deser.deserialize(p, ctxt);
    if (p.nextToken() != JsonToken.END_OBJECT) {
      throw JsonMappingException.from(p, "Current token not END_OBJECT (to match wrapper object with root name '" + expSimpleName + "'), but " + p.getCurrentToken());
    }
    return result;
  }
  
  protected JsonDeserializer<Object> _findRootDeserializer(DeserializationContext ctxt, JavaType valueType)
    throws JsonMappingException
  {
    JsonDeserializer<Object> deser = (JsonDeserializer)_rootDeserializers.get(valueType);
    if (deser != null) {
      return deser;
    }
    deser = ctxt.findRootValueDeserializer(valueType);
    if (deser == null) {
      throw new JsonMappingException("Can not find a deserializer for type " + valueType);
    }
    _rootDeserializers.put(valueType, deser);
    return deser;
  }
  
  protected void _verifySchemaType(FormatSchema schema)
  {
    if ((schema != null) && 
      (!_jsonFactory.canUseSchema(schema))) {
      throw new IllegalArgumentException("Can not use FormatSchema of type " + schema.getClass().getName() + " for format " + _jsonFactory.getFormatName());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */