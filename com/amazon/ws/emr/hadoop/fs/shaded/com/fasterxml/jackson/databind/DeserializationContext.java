package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.Annotated;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.LinkedNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DeserializationContext
  extends DatabindContext
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private static final int MAX_ERROR_STR_LEN = 500;
  protected final DeserializerCache _cache;
  protected final DeserializerFactory _factory;
  protected final DeserializationConfig _config;
  protected final int _featureFlags;
  protected final Class<?> _view;
  protected transient JsonParser _parser;
  protected final InjectableValues _injectableValues;
  protected transient ArrayBuilders _arrayBuilders;
  protected transient ObjectBuffer _objectBuffer;
  protected transient DateFormat _dateFormat;
  protected transient ContextAttributes _attributes;
  protected LinkedNode<JavaType> _currentType;
  
  protected DeserializationContext(DeserializerFactory df)
  {
    this(df, null);
  }
  
  protected DeserializationContext(DeserializerFactory df, DeserializerCache cache)
  {
    if (df == null) {
      throw new IllegalArgumentException("Can not pass null DeserializerFactory");
    }
    _factory = df;
    _cache = (cache == null ? new DeserializerCache() : cache);
    
    _featureFlags = 0;
    _config = null;
    _injectableValues = null;
    _view = null;
    _attributes = null;
  }
  
  protected DeserializationContext(DeserializationContext src, DeserializerFactory factory)
  {
    _cache = _cache;
    _factory = factory;
    
    _config = _config;
    _featureFlags = _featureFlags;
    _view = _view;
    _parser = _parser;
    _injectableValues = _injectableValues;
    _attributes = _attributes;
  }
  
  protected DeserializationContext(DeserializationContext src, DeserializationConfig config, JsonParser p, InjectableValues injectableValues)
  {
    _cache = _cache;
    _factory = _factory;
    
    _config = config;
    _featureFlags = config.getDeserializationFeatures();
    _view = config.getActiveView();
    _parser = p;
    _injectableValues = injectableValues;
    _attributes = config.getAttributes();
  }
  
  protected DeserializationContext(DeserializationContext src)
  {
    _cache = new DeserializerCache();
    _factory = _factory;
    
    _config = _config;
    _featureFlags = _featureFlags;
    _view = _view;
    _injectableValues = null;
  }
  
  public DeserializationConfig getConfig()
  {
    return _config;
  }
  
  public final Class<?> getActiveView()
  {
    return _view;
  }
  
  public final AnnotationIntrospector getAnnotationIntrospector()
  {
    return _config.getAnnotationIntrospector();
  }
  
  public final TypeFactory getTypeFactory()
  {
    return _config.getTypeFactory();
  }
  
  public Locale getLocale()
  {
    return _config.getLocale();
  }
  
  public TimeZone getTimeZone()
  {
    return _config.getTimeZone();
  }
  
  public Object getAttribute(Object key)
  {
    return _attributes.getAttribute(key);
  }
  
  public DeserializationContext setAttribute(Object key, Object value)
  {
    _attributes = _attributes.withPerCallAttribute(key, value);
    return this;
  }
  
  public JavaType getContextualType()
  {
    return _currentType == null ? null : (JavaType)_currentType.value();
  }
  
  public DeserializerFactory getFactory()
  {
    return _factory;
  }
  
  public final boolean isEnabled(DeserializationFeature feat)
  {
    return (_featureFlags & feat.getMask()) != 0;
  }
  
  public final int getDeserializationFeatures()
  {
    return _featureFlags;
  }
  
  public final boolean hasDeserializationFeatures(int featureMask)
  {
    return (_featureFlags & featureMask) == featureMask;
  }
  
  public final boolean hasSomeOfFeatures(int featureMask)
  {
    return (_featureFlags & featureMask) != 0;
  }
  
  public final JsonParser getParser()
  {
    return _parser;
  }
  
  public final Object findInjectableValue(Object valueId, BeanProperty forProperty, Object beanInstance)
  {
    if (_injectableValues == null) {
      throw new IllegalStateException("No 'injectableValues' configured, can not inject value with id [" + valueId + "]");
    }
    return _injectableValues.findInjectableValue(valueId, this, forProperty, beanInstance);
  }
  
  public final Base64Variant getBase64Variant()
  {
    return _config.getBase64Variant();
  }
  
  public final JsonNodeFactory getNodeFactory()
  {
    return _config.getNodeFactory();
  }
  
  @Deprecated
  public boolean hasValueDeserializerFor(JavaType type)
  {
    return hasValueDeserializerFor(type, null);
  }
  
  public boolean hasValueDeserializerFor(JavaType type, AtomicReference<Throwable> cause)
  {
    try
    {
      return _cache.hasValueDeserializerFor(this, _factory, type);
    }
    catch (JsonMappingException e)
    {
      if (cause != null) {
        cause.set(e);
      }
    }
    catch (RuntimeException e)
    {
      if (cause == null) {
        throw e;
      }
      cause.set(e);
    }
    return false;
  }
  
  public final JsonDeserializer<Object> findContextualValueDeserializer(JavaType type, BeanProperty prop)
    throws JsonMappingException
  {
    JsonDeserializer<Object> deser = _cache.findValueDeserializer(this, _factory, type);
    if (deser != null) {
      deser = handleSecondaryContextualization(deser, prop, type);
    }
    return deser;
  }
  
  public final JsonDeserializer<Object> findNonContextualValueDeserializer(JavaType type)
    throws JsonMappingException
  {
    return _cache.findValueDeserializer(this, _factory, type);
  }
  
  public final JsonDeserializer<Object> findRootValueDeserializer(JavaType type)
    throws JsonMappingException
  {
    JsonDeserializer<Object> deser = _cache.findValueDeserializer(this, _factory, type);
    if (deser == null) {
      return null;
    }
    deser = handleSecondaryContextualization(deser, null, type);
    TypeDeserializer typeDeser = _factory.findTypeDeserializer(_config, type);
    if (typeDeser != null)
    {
      typeDeser = typeDeser.forProperty(null);
      return new TypeWrappedDeserializer(typeDeser, deser);
    }
    return deser;
  }
  
  public final KeyDeserializer findKeyDeserializer(JavaType keyType, BeanProperty prop)
    throws JsonMappingException
  {
    KeyDeserializer kd = _cache.findKeyDeserializer(this, _factory, keyType);
    if ((kd instanceof ContextualKeyDeserializer)) {
      kd = ((ContextualKeyDeserializer)kd).createContextual(this, prop);
    }
    return kd;
  }
  
  public abstract ReadableObjectId findObjectId(Object paramObject, ObjectIdGenerator<?> paramObjectIdGenerator, ObjectIdResolver paramObjectIdResolver);
  
  @Deprecated
  public abstract ReadableObjectId findObjectId(Object paramObject, ObjectIdGenerator<?> paramObjectIdGenerator);
  
  public abstract void checkUnresolvedObjectId()
    throws UnresolvedForwardReference;
  
  public final JavaType constructType(Class<?> cls)
  {
    return _config.constructType(cls);
  }
  
  public Class<?> findClass(String className)
    throws ClassNotFoundException
  {
    return getTypeFactory().findClass(className);
  }
  
  public final ObjectBuffer leaseObjectBuffer()
  {
    ObjectBuffer buf = _objectBuffer;
    if (buf == null) {
      buf = new ObjectBuffer();
    } else {
      _objectBuffer = null;
    }
    return buf;
  }
  
  public final void returnObjectBuffer(ObjectBuffer buf)
  {
    if ((_objectBuffer == null) || (buf.initialCapacity() >= _objectBuffer.initialCapacity())) {
      _objectBuffer = buf;
    }
  }
  
  public final ArrayBuilders getArrayBuilders()
  {
    if (_arrayBuilders == null) {
      _arrayBuilders = new ArrayBuilders();
    }
    return _arrayBuilders;
  }
  
  public abstract JsonDeserializer<Object> deserializerInstance(Annotated paramAnnotated, Object paramObject)
    throws JsonMappingException;
  
  public abstract KeyDeserializer keyDeserializerInstance(Annotated paramAnnotated, Object paramObject)
    throws JsonMappingException;
  
  public JsonDeserializer<?> handlePrimaryContextualization(JsonDeserializer<?> deser, BeanProperty prop, JavaType type)
    throws JsonMappingException
  {
    if ((deser instanceof ContextualDeserializer))
    {
      _currentType = new LinkedNode(type, _currentType);
      try
      {
        deser = ((ContextualDeserializer)deser).createContextual(this, prop);
      }
      finally
      {
        _currentType = _currentType.next();
      }
    }
    return deser;
  }
  
  public JsonDeserializer<?> handleSecondaryContextualization(JsonDeserializer<?> deser, BeanProperty prop, JavaType type)
    throws JsonMappingException
  {
    if ((deser instanceof ContextualDeserializer))
    {
      _currentType = new LinkedNode(type, _currentType);
      try
      {
        deser = ((ContextualDeserializer)deser).createContextual(this, prop);
      }
      finally
      {
        _currentType = _currentType.next();
      }
    }
    return deser;
  }
  
  @Deprecated
  public JsonDeserializer<?> handlePrimaryContextualization(JsonDeserializer<?> deser, BeanProperty prop)
    throws JsonMappingException
  {
    return handlePrimaryContextualization(deser, prop, TypeFactory.unknownType());
  }
  
  @Deprecated
  public JsonDeserializer<?> handleSecondaryContextualization(JsonDeserializer<?> deser, BeanProperty prop)
    throws JsonMappingException
  {
    if ((deser instanceof ContextualDeserializer)) {
      deser = ((ContextualDeserializer)deser).createContextual(this, prop);
    }
    return deser;
  }
  
  public Date parseDate(String dateStr)
    throws IllegalArgumentException
  {
    try
    {
      DateFormat df = getDateFormat();
      return df.parse(dateStr);
    }
    catch (ParseException e)
    {
      throw new IllegalArgumentException(String.format("Failed to parse Date value '%s': %s", new Object[] { dateStr, e.getMessage() }));
    }
  }
  
  public Calendar constructCalendar(Date d)
  {
    Calendar c = Calendar.getInstance(getTimeZone());
    c.setTime(d);
    return c;
  }
  
  public <T> T readValue(JsonParser p, Class<T> type)
    throws IOException
  {
    return (T)readValue(p, getTypeFactory().constructType(type));
  }
  
  public <T> T readValue(JsonParser p, JavaType type)
    throws IOException
  {
    JsonDeserializer<Object> deser = findRootValueDeserializer(type);
    if (deser == null) {
      throw mappingException("Could not find JsonDeserializer for type %s", new Object[] { type });
    }
    return (T)deser.deserialize(p, this);
  }
  
  public <T> T readPropertyValue(JsonParser p, BeanProperty prop, Class<T> type)
    throws IOException
  {
    return (T)readPropertyValue(p, prop, getTypeFactory().constructType(type));
  }
  
  public <T> T readPropertyValue(JsonParser p, BeanProperty prop, JavaType type)
    throws IOException
  {
    JsonDeserializer<Object> deser = findContextualValueDeserializer(type, prop);
    if (deser == null)
    {
      String propName = "'" + prop.getName() + "'";
      throw mappingException("Could not find JsonDeserializer for type %s (via property %s)", new Object[] { type, propName });
    }
    return (T)deser.deserialize(p, this);
  }
  
  public boolean handleUnknownProperty(JsonParser p, JsonDeserializer<?> deser, Object instanceOrClass, String propName)
    throws IOException, JsonProcessingException
  {
    LinkedNode<DeserializationProblemHandler> h = _config.getProblemHandlers();
    if (h != null) {
      while (h != null)
      {
        if (((DeserializationProblemHandler)h.value()).handleUnknownProperty(this, p, deser, instanceOrClass, propName)) {
          return true;
        }
        h = h.next();
      }
    }
    return false;
  }
  
  public void reportUnknownProperty(Object instanceOrClass, String fieldName, JsonDeserializer<?> deser)
    throws JsonMappingException
  {
    if (!isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
      return;
    }
    Collection<Object> propIds = deser == null ? null : deser.getKnownPropertyNames();
    throw UnrecognizedPropertyException.from(_parser, instanceOrClass, fieldName, propIds);
  }
  
  public JsonMappingException mappingException(Class<?> targetClass)
  {
    return mappingException(targetClass, _parser.getCurrentToken());
  }
  
  public JsonMappingException mappingException(Class<?> targetClass, JsonToken token)
  {
    return JsonMappingException.from(_parser, String.format("Can not deserialize instance of %s out of %s token", new Object[] { _calcName(targetClass), token }));
  }
  
  public JsonMappingException mappingException(String message)
  {
    return JsonMappingException.from(getParser(), message);
  }
  
  public JsonMappingException mappingException(String msgTemplate, Object... args)
  {
    String message = String.format(msgTemplate, args);
    return JsonMappingException.from(getParser(), message);
  }
  
  public JsonMappingException instantiationException(Class<?> instClass, Throwable t)
  {
    return JsonMappingException.from(_parser, String.format("Can not construct instance of %s, problem: %s", new Object[] { instClass.getName(), t.getMessage() }), t);
  }
  
  public JsonMappingException instantiationException(Class<?> instClass, String msg)
  {
    return JsonMappingException.from(_parser, String.format("Can not construct instance of %s, problem: %s", new Object[] { instClass.getName(), msg }));
  }
  
  public JsonMappingException weirdStringException(String value, Class<?> instClass, String msg)
  {
    return InvalidFormatException.from(_parser, String.format("Can not construct instance of %s from String value '%s': %s", new Object[] { instClass.getName(), _desc(value), msg }), value, instClass);
  }
  
  public JsonMappingException weirdNumberException(Number value, Class<?> instClass, String msg)
  {
    return InvalidFormatException.from(_parser, String.format("Can not construct instance of %s from number value (%s): %s", new Object[] { instClass.getName(), String.valueOf(value), msg }), null, instClass);
  }
  
  public JsonMappingException weirdKeyException(Class<?> keyClass, String keyValue, String msg)
  {
    return InvalidFormatException.from(_parser, String.format("Can not construct Map key of type %s from String \"%s\": %s", new Object[] { keyClass.getName(), _desc(keyValue), msg }), keyValue, keyClass);
  }
  
  public JsonMappingException wrongTokenException(JsonParser p, JsonToken expToken, String msg0)
  {
    String msg = String.format("Unexpected token (%s), expected %s", new Object[] { p.getCurrentToken(), expToken });
    if (msg0 != null) {
      msg = msg + ": " + msg0;
    }
    return JsonMappingException.from(p, msg);
  }
  
  @Deprecated
  public JsonMappingException unknownTypeException(JavaType type, String id)
  {
    return JsonMappingException.from(_parser, "Could not resolve type id '" + id + "' into a subtype of " + type);
  }
  
  public JsonMappingException unknownTypeException(JavaType type, String id, String extraDesc)
  {
    String msg = "Could not resolve type id '" + id + "' into a subtype of " + type;
    if (extraDesc != null) {
      msg = msg + ": " + extraDesc;
    }
    return JsonMappingException.from(_parser, msg);
  }
  
  public JsonMappingException endOfInputException(Class<?> instClass)
  {
    return JsonMappingException.from(_parser, "Unexpected end-of-input when trying to deserialize a " + instClass.getName());
  }
  
  protected DateFormat getDateFormat()
  {
    if (_dateFormat != null) {
      return _dateFormat;
    }
    DateFormat df = _config.getDateFormat();
    _dateFormat = (df = (DateFormat)df.clone());
    return df;
  }
  
  protected String determineClassName(Object instance)
  {
    return ClassUtil.getClassDescription(instance);
  }
  
  protected String _calcName(Class<?> cls)
  {
    if (cls.isArray()) {
      return _calcName(cls.getComponentType()) + "[]";
    }
    return cls.getName();
  }
  
  protected String _valueDesc()
  {
    try
    {
      return _desc(_parser.getText());
    }
    catch (Exception e) {}
    return "[N/A]";
  }
  
  protected String _desc(String desc)
  {
    if (desc.length() > 500) {
      desc = desc.substring(0, 500) + "]...[" + desc.substring(desc.length() - 500);
    }
    return desc;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */