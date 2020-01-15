package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.PropertyAccessor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.LinkedNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.RootNameLookup;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

public final class DeserializationConfig
  extends MapperConfigBase<DeserializationFeature, DeserializationConfig>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final int _deserFeatures;
  protected final LinkedNode<DeserializationProblemHandler> _problemHandlers;
  protected final JsonNodeFactory _nodeFactory;
  protected final int _parserFeatures;
  protected final int _parserFeaturesToChange;
  
  public DeserializationConfig(BaseSettings base, SubtypeResolver str, SimpleMixInResolver mixins, RootNameLookup rootNames)
  {
    super(base, str, mixins, rootNames);
    _deserFeatures = collectFeatureDefaults(DeserializationFeature.class);
    _nodeFactory = JsonNodeFactory.instance;
    _problemHandlers = null;
    _parserFeatures = 0;
    _parserFeaturesToChange = 0;
  }
  
  private DeserializationConfig(DeserializationConfig src, int mapperFeatures, int deserFeatures, int parserFeatures, int parserFeatureMask)
  {
    super(src, mapperFeatures);
    _deserFeatures = deserFeatures;
    _nodeFactory = _nodeFactory;
    _problemHandlers = _problemHandlers;
    _parserFeatures = parserFeatures;
    _parserFeaturesToChange = parserFeatureMask;
  }
  
  private DeserializationConfig(DeserializationConfig src, SubtypeResolver str)
  {
    super(src, str);
    _deserFeatures = _deserFeatures;
    _nodeFactory = _nodeFactory;
    _problemHandlers = _problemHandlers;
    _parserFeatures = _parserFeatures;
    _parserFeaturesToChange = _parserFeaturesToChange;
  }
  
  private DeserializationConfig(DeserializationConfig src, BaseSettings base)
  {
    super(src, base);
    _deserFeatures = _deserFeatures;
    _nodeFactory = _nodeFactory;
    _problemHandlers = _problemHandlers;
    _parserFeatures = _parserFeatures;
    _parserFeaturesToChange = _parserFeaturesToChange;
  }
  
  private DeserializationConfig(DeserializationConfig src, JsonNodeFactory f)
  {
    super(src);
    _deserFeatures = _deserFeatures;
    _problemHandlers = _problemHandlers;
    _nodeFactory = f;
    _parserFeatures = _parserFeatures;
    _parserFeaturesToChange = _parserFeaturesToChange;
  }
  
  private DeserializationConfig(DeserializationConfig src, LinkedNode<DeserializationProblemHandler> problemHandlers)
  {
    super(src);
    _deserFeatures = _deserFeatures;
    _problemHandlers = problemHandlers;
    _nodeFactory = _nodeFactory;
    _parserFeatures = _parserFeatures;
    _parserFeaturesToChange = _parserFeaturesToChange;
  }
  
  private DeserializationConfig(DeserializationConfig src, PropertyName rootName)
  {
    super(src, rootName);
    _deserFeatures = _deserFeatures;
    _problemHandlers = _problemHandlers;
    _nodeFactory = _nodeFactory;
    _parserFeatures = _parserFeatures;
    _parserFeaturesToChange = _parserFeaturesToChange;
  }
  
  private DeserializationConfig(DeserializationConfig src, Class<?> view)
  {
    super(src, view);
    _deserFeatures = _deserFeatures;
    _problemHandlers = _problemHandlers;
    _nodeFactory = _nodeFactory;
    _parserFeatures = _parserFeatures;
    _parserFeaturesToChange = _parserFeaturesToChange;
  }
  
  protected DeserializationConfig(DeserializationConfig src, ContextAttributes attrs)
  {
    super(src, attrs);
    _deserFeatures = _deserFeatures;
    _problemHandlers = _problemHandlers;
    _nodeFactory = _nodeFactory;
    _parserFeatures = _parserFeatures;
    _parserFeaturesToChange = _parserFeaturesToChange;
  }
  
  protected DeserializationConfig(DeserializationConfig src, SimpleMixInResolver mixins)
  {
    super(src, mixins);
    _deserFeatures = _deserFeatures;
    _problemHandlers = _problemHandlers;
    _nodeFactory = _nodeFactory;
    _parserFeatures = _parserFeatures;
    _parserFeaturesToChange = _parserFeaturesToChange;
  }
  
  protected DeserializationConfig(DeserializationConfig src, SimpleMixInResolver mixins, RootNameLookup rootNames)
  {
    super(src, mixins, rootNames);
    _deserFeatures = _deserFeatures;
    _problemHandlers = _problemHandlers;
    _nodeFactory = _nodeFactory;
    _parserFeatures = _parserFeatures;
    _parserFeaturesToChange = _parserFeaturesToChange;
  }
  
  protected BaseSettings getBaseSettings()
  {
    return _base;
  }
  
  public DeserializationConfig with(MapperFeature... features)
  {
    int newMapperFlags = _mapperFeatures;
    for (MapperFeature f : features) {
      newMapperFlags |= f.getMask();
    }
    return newMapperFlags == _mapperFeatures ? this : new DeserializationConfig(this, newMapperFlags, _deserFeatures, _parserFeatures, _parserFeaturesToChange);
  }
  
  public DeserializationConfig without(MapperFeature... features)
  {
    int newMapperFlags = _mapperFeatures;
    for (MapperFeature f : features) {
      newMapperFlags &= (f.getMask() ^ 0xFFFFFFFF);
    }
    return newMapperFlags == _mapperFeatures ? this : new DeserializationConfig(this, newMapperFlags, _deserFeatures, _parserFeatures, _parserFeaturesToChange);
  }
  
  public DeserializationConfig with(MapperFeature feature, boolean state)
  {
    int newMapperFlags;
    int newMapperFlags;
    if (state) {
      newMapperFlags = _mapperFeatures | feature.getMask();
    } else {
      newMapperFlags = _mapperFeatures & (feature.getMask() ^ 0xFFFFFFFF);
    }
    return newMapperFlags == _mapperFeatures ? this : new DeserializationConfig(this, newMapperFlags, _deserFeatures, _parserFeatures, _parserFeaturesToChange);
  }
  
  public DeserializationConfig with(ClassIntrospector ci)
  {
    return _withBase(_base.withClassIntrospector(ci));
  }
  
  public DeserializationConfig with(AnnotationIntrospector ai)
  {
    return _withBase(_base.withAnnotationIntrospector(ai));
  }
  
  public DeserializationConfig with(VisibilityChecker<?> vc)
  {
    return _withBase(_base.withVisibilityChecker(vc));
  }
  
  public DeserializationConfig withVisibility(PropertyAccessor forMethod, JsonAutoDetect.Visibility visibility)
  {
    return _withBase(_base.withVisibility(forMethod, visibility));
  }
  
  public DeserializationConfig with(TypeResolverBuilder<?> trb)
  {
    return _withBase(_base.withTypeResolverBuilder(trb));
  }
  
  public DeserializationConfig with(SubtypeResolver str)
  {
    return _subtypeResolver == str ? this : new DeserializationConfig(this, str);
  }
  
  public DeserializationConfig with(PropertyNamingStrategy pns)
  {
    return _withBase(_base.withPropertyNamingStrategy(pns));
  }
  
  public DeserializationConfig withRootName(PropertyName rootName)
  {
    if (rootName == null)
    {
      if (_rootName == null) {
        return this;
      }
    }
    else if (rootName.equals(_rootName)) {
      return this;
    }
    return new DeserializationConfig(this, rootName);
  }
  
  public DeserializationConfig with(TypeFactory tf)
  {
    return _withBase(_base.withTypeFactory(tf));
  }
  
  public DeserializationConfig with(DateFormat df)
  {
    return _withBase(_base.withDateFormat(df));
  }
  
  public DeserializationConfig with(HandlerInstantiator hi)
  {
    return _withBase(_base.withHandlerInstantiator(hi));
  }
  
  public DeserializationConfig withInsertedAnnotationIntrospector(AnnotationIntrospector ai)
  {
    return _withBase(_base.withInsertedAnnotationIntrospector(ai));
  }
  
  public DeserializationConfig withAppendedAnnotationIntrospector(AnnotationIntrospector ai)
  {
    return _withBase(_base.withAppendedAnnotationIntrospector(ai));
  }
  
  public DeserializationConfig withView(Class<?> view)
  {
    return _view == view ? this : new DeserializationConfig(this, view);
  }
  
  public DeserializationConfig with(Locale l)
  {
    return _withBase(_base.with(l));
  }
  
  public DeserializationConfig with(TimeZone tz)
  {
    return _withBase(_base.with(tz));
  }
  
  public DeserializationConfig with(Base64Variant base64)
  {
    return _withBase(_base.with(base64));
  }
  
  public DeserializationConfig with(ContextAttributes attrs)
  {
    return attrs == _attributes ? this : new DeserializationConfig(this, attrs);
  }
  
  private final DeserializationConfig _withBase(BaseSettings newBase)
  {
    return _base == newBase ? this : new DeserializationConfig(this, newBase);
  }
  
  public DeserializationConfig with(DeserializationFeature feature)
  {
    int newDeserFeatures = _deserFeatures | feature.getMask();
    return newDeserFeatures == _deserFeatures ? this : new DeserializationConfig(this, _mapperFeatures, newDeserFeatures, _parserFeatures, _parserFeaturesToChange);
  }
  
  public DeserializationConfig with(DeserializationFeature first, DeserializationFeature... features)
  {
    int newDeserFeatures = _deserFeatures | first.getMask();
    for (DeserializationFeature f : features) {
      newDeserFeatures |= f.getMask();
    }
    return newDeserFeatures == _deserFeatures ? this : new DeserializationConfig(this, _mapperFeatures, newDeserFeatures, _parserFeatures, _parserFeaturesToChange);
  }
  
  public DeserializationConfig withFeatures(DeserializationFeature... features)
  {
    int newDeserFeatures = _deserFeatures;
    for (DeserializationFeature f : features) {
      newDeserFeatures |= f.getMask();
    }
    return newDeserFeatures == _deserFeatures ? this : new DeserializationConfig(this, _mapperFeatures, newDeserFeatures, _parserFeatures, _parserFeaturesToChange);
  }
  
  public DeserializationConfig without(DeserializationFeature feature)
  {
    int newDeserFeatures = _deserFeatures & (feature.getMask() ^ 0xFFFFFFFF);
    return newDeserFeatures == _deserFeatures ? this : new DeserializationConfig(this, _mapperFeatures, newDeserFeatures, _parserFeatures, _parserFeaturesToChange);
  }
  
  public DeserializationConfig without(DeserializationFeature first, DeserializationFeature... features)
  {
    int newDeserFeatures = _deserFeatures & (first.getMask() ^ 0xFFFFFFFF);
    for (DeserializationFeature f : features) {
      newDeserFeatures &= (f.getMask() ^ 0xFFFFFFFF);
    }
    return newDeserFeatures == _deserFeatures ? this : new DeserializationConfig(this, _mapperFeatures, newDeserFeatures, _parserFeatures, _parserFeaturesToChange);
  }
  
  public DeserializationConfig withoutFeatures(DeserializationFeature... features)
  {
    int newDeserFeatures = _deserFeatures;
    for (DeserializationFeature f : features) {
      newDeserFeatures &= (f.getMask() ^ 0xFFFFFFFF);
    }
    return newDeserFeatures == _deserFeatures ? this : new DeserializationConfig(this, _mapperFeatures, newDeserFeatures, _parserFeatures, _parserFeaturesToChange);
  }
  
  public DeserializationConfig with(JsonParser.Feature feature)
  {
    int newSet = _parserFeatures | feature.getMask();
    int newMask = _parserFeaturesToChange | feature.getMask();
    return (_parserFeatures == newSet) && (_parserFeaturesToChange == newMask) ? this : new DeserializationConfig(this, _mapperFeatures, _deserFeatures, newSet, newMask);
  }
  
  public DeserializationConfig withFeatures(JsonParser.Feature... features)
  {
    int newSet = _parserFeatures;
    int newMask = _parserFeaturesToChange;
    for (JsonParser.Feature f : features)
    {
      int mask = f.getMask();
      newSet |= mask;
      newMask |= mask;
    }
    return (_parserFeatures == newSet) && (_parserFeaturesToChange == newMask) ? this : new DeserializationConfig(this, _mapperFeatures, _deserFeatures, newSet, newMask);
  }
  
  public DeserializationConfig without(JsonParser.Feature feature)
  {
    int newSet = _parserFeatures & (feature.getMask() ^ 0xFFFFFFFF);
    int newMask = _parserFeaturesToChange | feature.getMask();
    return (_parserFeatures == newSet) && (_parserFeaturesToChange == newMask) ? this : new DeserializationConfig(this, _mapperFeatures, _deserFeatures, newSet, newMask);
  }
  
  public DeserializationConfig withoutFeatures(JsonParser.Feature... features)
  {
    int newSet = _parserFeatures;
    int newMask = _parserFeaturesToChange;
    for (JsonParser.Feature f : features)
    {
      int mask = f.getMask();
      newSet &= (mask ^ 0xFFFFFFFF);
      newMask |= mask;
    }
    return (_parserFeatures == newSet) && (_parserFeaturesToChange == newMask) ? this : new DeserializationConfig(this, _mapperFeatures, _deserFeatures, newSet, newMask);
  }
  
  public DeserializationConfig with(JsonNodeFactory f)
  {
    if (_nodeFactory == f) {
      return this;
    }
    return new DeserializationConfig(this, f);
  }
  
  public DeserializationConfig withHandler(DeserializationProblemHandler h)
  {
    if (LinkedNode.contains(_problemHandlers, h)) {
      return this;
    }
    return new DeserializationConfig(this, new LinkedNode(h, _problemHandlers));
  }
  
  public DeserializationConfig withNoProblemHandlers()
  {
    if (_problemHandlers == null) {
      return this;
    }
    return new DeserializationConfig(this, (LinkedNode)null);
  }
  
  public void initialize(JsonParser p)
  {
    if (_parserFeaturesToChange != 0)
    {
      int orig = p.getFeatureMask();
      int newFlags = orig & (_parserFeaturesToChange ^ 0xFFFFFFFF) | _parserFeatures;
      if (orig != newFlags) {
        p.setFeatureMask(newFlags);
      }
    }
  }
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    if (isEnabled(MapperFeature.USE_ANNOTATIONS)) {
      return super.getAnnotationIntrospector();
    }
    return NopAnnotationIntrospector.instance;
  }
  
  public boolean useRootWrapping()
  {
    if (_rootName != null) {
      return !_rootName.isEmpty();
    }
    return isEnabled(DeserializationFeature.UNWRAP_ROOT_VALUE);
  }
  
  public BeanDescription introspectClassAnnotations(JavaType type)
  {
    return getClassIntrospector().forClassAnnotations(this, type, this);
  }
  
  public BeanDescription introspectDirectClassAnnotations(JavaType type)
  {
    return getClassIntrospector().forDirectClassAnnotations(this, type, this);
  }
  
  public VisibilityChecker<?> getDefaultVisibilityChecker()
  {
    VisibilityChecker<?> vchecker = super.getDefaultVisibilityChecker();
    if (!isEnabled(MapperFeature.AUTO_DETECT_SETTERS)) {
      vchecker = vchecker.withSetterVisibility(JsonAutoDetect.Visibility.NONE);
    }
    if (!isEnabled(MapperFeature.AUTO_DETECT_CREATORS)) {
      vchecker = vchecker.withCreatorVisibility(JsonAutoDetect.Visibility.NONE);
    }
    if (!isEnabled(MapperFeature.AUTO_DETECT_FIELDS)) {
      vchecker = vchecker.withFieldVisibility(JsonAutoDetect.Visibility.NONE);
    }
    return vchecker;
  }
  
  public final boolean isEnabled(DeserializationFeature f)
  {
    return (_deserFeatures & f.getMask()) != 0;
  }
  
  public final boolean isEnabled(JsonParser.Feature f, JsonFactory factory)
  {
    int mask = f.getMask();
    if ((_parserFeaturesToChange & mask) != 0) {
      return (_parserFeatures & f.getMask()) != 0;
    }
    return factory.isEnabled(f);
  }
  
  public final boolean hasDeserializationFeatures(int featureMask)
  {
    return (_deserFeatures & featureMask) == featureMask;
  }
  
  public final boolean hasSomeOfFeatures(int featureMask)
  {
    return (_deserFeatures & featureMask) != 0;
  }
  
  public final int getDeserializationFeatures()
  {
    return _deserFeatures;
  }
  
  public LinkedNode<DeserializationProblemHandler> getProblemHandlers()
  {
    return _problemHandlers;
  }
  
  public final JsonNodeFactory getNodeFactory()
  {
    return _nodeFactory;
  }
  
  public <T extends BeanDescription> T introspect(JavaType type)
  {
    return getClassIntrospector().forDeserialization(this, type, this);
  }
  
  public <T extends BeanDescription> T introspectForCreation(JavaType type)
  {
    return getClassIntrospector().forCreation(this, type, this);
  }
  
  public <T extends BeanDescription> T introspectForBuilder(JavaType type)
  {
    return getClassIntrospector().forDeserializationWithBuilder(this, type, this);
  }
  
  public TypeDeserializer findTypeDeserializer(JavaType baseType)
    throws JsonMappingException
  {
    BeanDescription bean = introspectClassAnnotations(baseType.getRawClass());
    AnnotatedClass ac = bean.getClassInfo();
    TypeResolverBuilder<?> b = getAnnotationIntrospector().findTypeResolver(this, ac, baseType);
    
    Collection<NamedType> subtypes = null;
    if (b == null)
    {
      b = getDefaultTyper(baseType);
      if (b == null) {
        return null;
      }
    }
    else
    {
      subtypes = getSubtypeResolver().collectAndResolveSubtypesByTypeId(this, ac);
    }
    return b.buildTypeDeserializer(this, baseType, subtypes);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */