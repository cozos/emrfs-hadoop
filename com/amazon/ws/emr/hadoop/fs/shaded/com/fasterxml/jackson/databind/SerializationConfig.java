package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.PropertyAccessor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.PrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.Instantiatable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.FilterProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.RootNameLookup;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class SerializationConfig
  extends MapperConfigBase<SerializationFeature, SerializationConfig>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected static final PrettyPrinter DEFAULT_PRETTY_PRINTER = new DefaultPrettyPrinter();
  protected final int _serFeatures;
  protected JsonInclude.Include _serializationInclusion = null;
  protected final FilterProvider _filterProvider;
  protected final PrettyPrinter _defaultPrettyPrinter;
  protected final int _generatorFeatures;
  protected final int _generatorFeaturesToChange;
  
  public SerializationConfig(BaseSettings base, SubtypeResolver str, SimpleMixInResolver mixins, RootNameLookup rootNames)
  {
    super(base, str, mixins, rootNames);
    _serFeatures = collectFeatureDefaults(SerializationFeature.class);
    _filterProvider = null;
    _defaultPrettyPrinter = DEFAULT_PRETTY_PRINTER;
    _generatorFeatures = 0;
    _generatorFeaturesToChange = 0;
  }
  
  private SerializationConfig(SerializationConfig src, SubtypeResolver str)
  {
    super(src, str);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  private SerializationConfig(SerializationConfig src, int mapperFeatures, int serFeatures, int generatorFeatures, int generatorFeatureMask)
  {
    super(src, mapperFeatures);
    _serFeatures = serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = generatorFeatures;
    _generatorFeaturesToChange = generatorFeatureMask;
  }
  
  private SerializationConfig(SerializationConfig src, BaseSettings base)
  {
    super(src, base);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  private SerializationConfig(SerializationConfig src, FilterProvider filters)
  {
    super(src);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = filters;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  private SerializationConfig(SerializationConfig src, Class<?> view)
  {
    super(src, view);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  private SerializationConfig(SerializationConfig src, JsonInclude.Include incl)
  {
    super(src);
    _serFeatures = _serFeatures;
    _serializationInclusion = incl;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  private SerializationConfig(SerializationConfig src, PropertyName rootName)
  {
    super(src, rootName);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  protected SerializationConfig(SerializationConfig src, ContextAttributes attrs)
  {
    super(src, attrs);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  protected SerializationConfig(SerializationConfig src, SimpleMixInResolver mixins)
  {
    super(src, mixins);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  protected SerializationConfig(SerializationConfig src, PrettyPrinter defaultPP)
  {
    super(src);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = defaultPP;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  protected SerializationConfig(SerializationConfig src, SimpleMixInResolver mixins, RootNameLookup rootNames)
  {
    super(src, mixins, rootNames);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  public SerializationConfig with(MapperFeature... features)
  {
    int newMapperFlags = _mapperFeatures;
    for (MapperFeature f : features) {
      newMapperFlags |= f.getMask();
    }
    return newMapperFlags == _mapperFeatures ? this : new SerializationConfig(this, newMapperFlags, _serFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig without(MapperFeature... features)
  {
    int newMapperFlags = _mapperFeatures;
    for (MapperFeature f : features) {
      newMapperFlags &= (f.getMask() ^ 0xFFFFFFFF);
    }
    return newMapperFlags == _mapperFeatures ? this : new SerializationConfig(this, newMapperFlags, _serFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig with(MapperFeature feature, boolean state)
  {
    int newMapperFlags;
    int newMapperFlags;
    if (state) {
      newMapperFlags = _mapperFeatures | feature.getMask();
    } else {
      newMapperFlags = _mapperFeatures & (feature.getMask() ^ 0xFFFFFFFF);
    }
    return newMapperFlags == _mapperFeatures ? this : new SerializationConfig(this, newMapperFlags, _serFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig with(AnnotationIntrospector ai)
  {
    return _withBase(_base.withAnnotationIntrospector(ai));
  }
  
  public SerializationConfig withAppendedAnnotationIntrospector(AnnotationIntrospector ai)
  {
    return _withBase(_base.withAppendedAnnotationIntrospector(ai));
  }
  
  public SerializationConfig withInsertedAnnotationIntrospector(AnnotationIntrospector ai)
  {
    return _withBase(_base.withInsertedAnnotationIntrospector(ai));
  }
  
  public SerializationConfig with(ClassIntrospector ci)
  {
    return _withBase(_base.withClassIntrospector(ci));
  }
  
  public SerializationConfig with(DateFormat df)
  {
    SerializationConfig cfg = new SerializationConfig(this, _base.withDateFormat(df));
    if (df == null) {
      cfg = cfg.with(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    } else {
      cfg = cfg.without(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    return cfg;
  }
  
  public SerializationConfig with(HandlerInstantiator hi)
  {
    return _withBase(_base.withHandlerInstantiator(hi));
  }
  
  public SerializationConfig with(PropertyNamingStrategy pns)
  {
    return _withBase(_base.withPropertyNamingStrategy(pns));
  }
  
  public SerializationConfig withRootName(PropertyName rootName)
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
    return new SerializationConfig(this, rootName);
  }
  
  public SerializationConfig with(SubtypeResolver str)
  {
    return str == _subtypeResolver ? this : new SerializationConfig(this, str);
  }
  
  public SerializationConfig with(TypeFactory tf)
  {
    return _withBase(_base.withTypeFactory(tf));
  }
  
  public SerializationConfig with(TypeResolverBuilder<?> trb)
  {
    return _withBase(_base.withTypeResolverBuilder(trb));
  }
  
  public SerializationConfig withView(Class<?> view)
  {
    return _view == view ? this : new SerializationConfig(this, view);
  }
  
  public SerializationConfig with(VisibilityChecker<?> vc)
  {
    return _withBase(_base.withVisibilityChecker(vc));
  }
  
  public SerializationConfig withVisibility(PropertyAccessor forMethod, JsonAutoDetect.Visibility visibility)
  {
    return _withBase(_base.withVisibility(forMethod, visibility));
  }
  
  public SerializationConfig with(Locale l)
  {
    return _withBase(_base.with(l));
  }
  
  public SerializationConfig with(TimeZone tz)
  {
    return _withBase(_base.with(tz));
  }
  
  public SerializationConfig with(Base64Variant base64)
  {
    return _withBase(_base.with(base64));
  }
  
  public SerializationConfig with(ContextAttributes attrs)
  {
    return attrs == _attributes ? this : new SerializationConfig(this, attrs);
  }
  
  private final SerializationConfig _withBase(BaseSettings newBase)
  {
    return _base == newBase ? this : new SerializationConfig(this, newBase);
  }
  
  public SerializationConfig with(SerializationFeature feature)
  {
    int newSerFeatures = _serFeatures | feature.getMask();
    return newSerFeatures == _serFeatures ? this : new SerializationConfig(this, _mapperFeatures, newSerFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig with(SerializationFeature first, SerializationFeature... features)
  {
    int newSerFeatures = _serFeatures | first.getMask();
    for (SerializationFeature f : features) {
      newSerFeatures |= f.getMask();
    }
    return newSerFeatures == _serFeatures ? this : new SerializationConfig(this, _mapperFeatures, newSerFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig withFeatures(SerializationFeature... features)
  {
    int newSerFeatures = _serFeatures;
    for (SerializationFeature f : features) {
      newSerFeatures |= f.getMask();
    }
    return newSerFeatures == _serFeatures ? this : new SerializationConfig(this, _mapperFeatures, newSerFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig without(SerializationFeature feature)
  {
    int newSerFeatures = _serFeatures & (feature.getMask() ^ 0xFFFFFFFF);
    return newSerFeatures == _serFeatures ? this : new SerializationConfig(this, _mapperFeatures, newSerFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig without(SerializationFeature first, SerializationFeature... features)
  {
    int newSerFeatures = _serFeatures & (first.getMask() ^ 0xFFFFFFFF);
    for (SerializationFeature f : features) {
      newSerFeatures &= (f.getMask() ^ 0xFFFFFFFF);
    }
    return newSerFeatures == _serFeatures ? this : new SerializationConfig(this, _mapperFeatures, newSerFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig withoutFeatures(SerializationFeature... features)
  {
    int newSerFeatures = _serFeatures;
    for (SerializationFeature f : features) {
      newSerFeatures &= (f.getMask() ^ 0xFFFFFFFF);
    }
    return newSerFeatures == _serFeatures ? this : new SerializationConfig(this, _mapperFeatures, newSerFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig with(JsonGenerator.Feature feature)
  {
    int newSet = _generatorFeatures | feature.getMask();
    int newMask = _generatorFeaturesToChange | feature.getMask();
    return (_generatorFeatures == newSet) && (_generatorFeaturesToChange == newMask) ? this : new SerializationConfig(this, _mapperFeatures, _serFeatures, newSet, newMask);
  }
  
  public SerializationConfig withFeatures(JsonGenerator.Feature... features)
  {
    int newSet = _generatorFeatures;
    int newMask = _generatorFeaturesToChange;
    for (JsonGenerator.Feature f : features)
    {
      int mask = f.getMask();
      newSet |= mask;
      newMask |= mask;
    }
    return (_generatorFeatures == newSet) && (_generatorFeaturesToChange == newMask) ? this : new SerializationConfig(this, _mapperFeatures, _serFeatures, newSet, newMask);
  }
  
  public SerializationConfig without(JsonGenerator.Feature feature)
  {
    int newSet = _generatorFeatures & (feature.getMask() ^ 0xFFFFFFFF);
    int newMask = _generatorFeaturesToChange | feature.getMask();
    return (_generatorFeatures == newSet) && (_generatorFeaturesToChange == newMask) ? this : new SerializationConfig(this, _mapperFeatures, _serFeatures, newSet, newMask);
  }
  
  public SerializationConfig withoutFeatures(JsonGenerator.Feature... features)
  {
    int newSet = _generatorFeatures;
    int newMask = _generatorFeaturesToChange;
    for (JsonGenerator.Feature f : features)
    {
      int mask = f.getMask();
      newSet &= (mask ^ 0xFFFFFFFF);
      newMask |= mask;
    }
    return (_generatorFeatures == newSet) && (_generatorFeaturesToChange == newMask) ? this : new SerializationConfig(this, _mapperFeatures, _serFeatures, newSet, newMask);
  }
  
  public SerializationConfig withFilters(FilterProvider filterProvider)
  {
    return filterProvider == _filterProvider ? this : new SerializationConfig(this, filterProvider);
  }
  
  public SerializationConfig withSerializationInclusion(JsonInclude.Include incl)
  {
    return _serializationInclusion == incl ? this : new SerializationConfig(this, incl);
  }
  
  public SerializationConfig withDefaultPrettyPrinter(PrettyPrinter pp)
  {
    return _defaultPrettyPrinter == pp ? this : new SerializationConfig(this, pp);
  }
  
  public PrettyPrinter constructDefaultPrettyPrinter()
  {
    PrettyPrinter pp = _defaultPrettyPrinter;
    if ((pp instanceof Instantiatable)) {
      pp = (PrettyPrinter)((Instantiatable)pp).createInstance();
    }
    return pp;
  }
  
  public void initialize(JsonGenerator g)
  {
    if (SerializationFeature.INDENT_OUTPUT.enabledIn(_serFeatures)) {
      if (g.getPrettyPrinter() == null)
      {
        PrettyPrinter pp = constructDefaultPrettyPrinter();
        if (pp != null) {
          g.setPrettyPrinter(pp);
        }
      }
    }
    boolean useBigDec = SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN.enabledIn(_serFeatures);
    if ((_generatorFeaturesToChange != 0) || (useBigDec))
    {
      int orig = g.getFeatureMask();
      int newFlags = orig & (_generatorFeaturesToChange ^ 0xFFFFFFFF) | _generatorFeatures;
      if (useBigDec) {
        newFlags |= JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN.getMask();
      }
      if (orig != newFlags) {
        g.setFeatureMask(newFlags);
      }
    }
  }
  
  public boolean useRootWrapping()
  {
    if (_rootName != null) {
      return !_rootName.isEmpty();
    }
    return isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
  }
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    if (isEnabled(MapperFeature.USE_ANNOTATIONS)) {
      return super.getAnnotationIntrospector();
    }
    return AnnotationIntrospector.nopInstance();
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
    if (!isEnabled(MapperFeature.AUTO_DETECT_GETTERS)) {
      vchecker = vchecker.withGetterVisibility(JsonAutoDetect.Visibility.NONE);
    }
    if (!isEnabled(MapperFeature.AUTO_DETECT_IS_GETTERS)) {
      vchecker = vchecker.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);
    }
    if (!isEnabled(MapperFeature.AUTO_DETECT_FIELDS)) {
      vchecker = vchecker.withFieldVisibility(JsonAutoDetect.Visibility.NONE);
    }
    return vchecker;
  }
  
  public final boolean isEnabled(SerializationFeature f)
  {
    return (_serFeatures & f.getMask()) != 0;
  }
  
  public final boolean isEnabled(JsonGenerator.Feature f, JsonFactory factory)
  {
    int mask = f.getMask();
    if ((_generatorFeaturesToChange & mask) != 0) {
      return (_generatorFeatures & f.getMask()) != 0;
    }
    return factory.isEnabled(f);
  }
  
  public final boolean hasSerializationFeatures(int featureMask)
  {
    return (_serFeatures & featureMask) == featureMask;
  }
  
  public final int getSerializationFeatures()
  {
    return _serFeatures;
  }
  
  public JsonInclude.Include getSerializationInclusion()
  {
    if (_serializationInclusion != null) {
      return _serializationInclusion;
    }
    return JsonInclude.Include.ALWAYS;
  }
  
  public FilterProvider getFilterProvider()
  {
    return _filterProvider;
  }
  
  public PrettyPrinter getDefaultPrettyPrinter()
  {
    return _defaultPrettyPrinter;
  }
  
  public <T extends BeanDescription> T introspect(JavaType type)
  {
    return getClassIntrospector().forSerialization(this, type, this);
  }
  
  public String toString()
  {
    return "[SerializationConfig: flags=0x" + Integer.toHexString(_serFeatures) + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */