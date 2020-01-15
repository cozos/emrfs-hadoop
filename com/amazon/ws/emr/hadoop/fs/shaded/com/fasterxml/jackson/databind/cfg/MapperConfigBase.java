package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.PropertyAccessor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.MapperFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.RootNameLookup;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public abstract class MapperConfigBase<CFG extends ConfigFeature, T extends MapperConfigBase<CFG, T>>
  extends MapperConfig<T>
  implements Serializable
{
  private static final int DEFAULT_MAPPER_FEATURES = collectFeatureDefaults(MapperFeature.class);
  protected final SimpleMixInResolver _mixIns;
  protected final SubtypeResolver _subtypeResolver;
  protected final PropertyName _rootName;
  protected final Class<?> _view;
  protected final ContextAttributes _attributes;
  protected final RootNameLookup _rootNames;
  
  protected MapperConfigBase(BaseSettings base, SubtypeResolver str, SimpleMixInResolver mixins, RootNameLookup rootNames)
  {
    super(base, DEFAULT_MAPPER_FEATURES);
    _mixIns = mixins;
    _subtypeResolver = str;
    _rootNames = rootNames;
    _rootName = null;
    _view = null;
    
    _attributes = ContextAttributes.getEmpty();
  }
  
  protected MapperConfigBase(MapperConfigBase<CFG, T> src)
  {
    super(src);
    _mixIns = _mixIns;
    _subtypeResolver = _subtypeResolver;
    _rootNames = _rootNames;
    _rootName = _rootName;
    _view = _view;
    _attributes = _attributes;
  }
  
  protected MapperConfigBase(MapperConfigBase<CFG, T> src, BaseSettings base)
  {
    super(src, base);
    _mixIns = _mixIns;
    _subtypeResolver = _subtypeResolver;
    _rootNames = _rootNames;
    _rootName = _rootName;
    _view = _view;
    _attributes = _attributes;
  }
  
  protected MapperConfigBase(MapperConfigBase<CFG, T> src, int mapperFeatures)
  {
    super(src, mapperFeatures);
    _mixIns = _mixIns;
    _subtypeResolver = _subtypeResolver;
    _rootNames = _rootNames;
    _rootName = _rootName;
    _view = _view;
    _attributes = _attributes;
  }
  
  protected MapperConfigBase(MapperConfigBase<CFG, T> src, SubtypeResolver str)
  {
    super(src);
    _mixIns = _mixIns;
    _subtypeResolver = str;
    _rootNames = _rootNames;
    _rootName = _rootName;
    _view = _view;
    _attributes = _attributes;
  }
  
  protected MapperConfigBase(MapperConfigBase<CFG, T> src, PropertyName rootName)
  {
    super(src);
    _mixIns = _mixIns;
    _subtypeResolver = _subtypeResolver;
    _rootNames = _rootNames;
    _rootName = rootName;
    _view = _view;
    _attributes = _attributes;
  }
  
  protected MapperConfigBase(MapperConfigBase<CFG, T> src, Class<?> view)
  {
    super(src);
    _mixIns = _mixIns;
    _subtypeResolver = _subtypeResolver;
    _rootNames = _rootNames;
    _rootName = _rootName;
    _view = view;
    _attributes = _attributes;
  }
  
  protected MapperConfigBase(MapperConfigBase<CFG, T> src, SimpleMixInResolver mixins)
  {
    super(src);
    _mixIns = mixins;
    _subtypeResolver = _subtypeResolver;
    _rootNames = _rootNames;
    _rootName = _rootName;
    _view = _view;
    _attributes = _attributes;
  }
  
  protected MapperConfigBase(MapperConfigBase<CFG, T> src, ContextAttributes attr)
  {
    super(src);
    _mixIns = _mixIns;
    _subtypeResolver = _subtypeResolver;
    _rootNames = _rootNames;
    _rootName = _rootName;
    _view = _view;
    _attributes = attr;
  }
  
  protected MapperConfigBase(MapperConfigBase<CFG, T> src, SimpleMixInResolver mixins, RootNameLookup rootNames)
  {
    super(src);
    _mixIns = mixins;
    _subtypeResolver = _subtypeResolver;
    _rootNames = rootNames;
    _rootName = _rootName;
    _view = _view;
    _attributes = _attributes;
  }
  
  public abstract T with(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract T withAppendedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract T withInsertedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract T with(ClassIntrospector paramClassIntrospector);
  
  public abstract T with(DateFormat paramDateFormat);
  
  public abstract T with(HandlerInstantiator paramHandlerInstantiator);
  
  public abstract T with(PropertyNamingStrategy paramPropertyNamingStrategy);
  
  public abstract T withRootName(PropertyName paramPropertyName);
  
  public T withRootName(String rootName)
  {
    if (rootName == null) {
      return withRootName((PropertyName)null);
    }
    return withRootName(PropertyName.construct(rootName));
  }
  
  public abstract T with(SubtypeResolver paramSubtypeResolver);
  
  public abstract T with(TypeFactory paramTypeFactory);
  
  public abstract T with(TypeResolverBuilder<?> paramTypeResolverBuilder);
  
  public abstract T withView(Class<?> paramClass);
  
  public abstract T with(VisibilityChecker<?> paramVisibilityChecker);
  
  public abstract T withVisibility(PropertyAccessor paramPropertyAccessor, JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T with(Locale paramLocale);
  
  public abstract T with(TimeZone paramTimeZone);
  
  public abstract T with(Base64Variant paramBase64Variant);
  
  public abstract T with(ContextAttributes paramContextAttributes);
  
  public T withAttributes(Map<Object, Object> attributes)
  {
    return with(getAttributes().withSharedAttributes(attributes));
  }
  
  public T withAttribute(Object key, Object value)
  {
    return with(getAttributes().withSharedAttribute(key, value));
  }
  
  public T withoutAttribute(Object key)
  {
    return with(getAttributes().withoutSharedAttribute(key));
  }
  
  public final SubtypeResolver getSubtypeResolver()
  {
    return _subtypeResolver;
  }
  
  @Deprecated
  public final String getRootName()
  {
    return _rootName == null ? null : _rootName.getSimpleName();
  }
  
  public final PropertyName getFullRootName()
  {
    return _rootName;
  }
  
  public final Class<?> getActiveView()
  {
    return _view;
  }
  
  public final ContextAttributes getAttributes()
  {
    return _attributes;
  }
  
  public PropertyName findRootName(JavaType rootType)
  {
    if (_rootName != null) {
      return _rootName;
    }
    return _rootNames.findRootName(rootType, this);
  }
  
  public PropertyName findRootName(Class<?> rawRootType)
  {
    if (_rootName != null) {
      return _rootName;
    }
    return _rootNames.findRootName(rawRootType, this);
  }
  
  public final Class<?> findMixInClassFor(Class<?> cls)
  {
    return _mixIns.findMixInClassFor(cls);
  }
  
  public ClassIntrospector.MixInResolver copy()
  {
    throw new UnsupportedOperationException();
  }
  
  public final int mixInCount()
  {
    return _mixIns.localSize();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfigBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */