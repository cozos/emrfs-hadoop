package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonPointer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.TreeNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Versioned;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.filter.FilteringParserDelegate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.filter.JsonPointerBasedFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.filter.TokenFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.ResolvedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.TypeReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.NullNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.SimpleType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectReader
  extends ObjectCodec
  implements Versioned, Serializable
{
  private static final long serialVersionUID = 1L;
  private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(JsonNode.class);
  protected final DeserializationConfig _config;
  protected final DefaultDeserializationContext _context;
  protected final JsonFactory _parserFactory;
  protected final boolean _unwrapRoot;
  private final TokenFilter _filter;
  protected final JavaType _valueType;
  protected final JsonDeserializer<Object> _rootDeserializer;
  protected final Object _valueToUpdate;
  protected final FormatSchema _schema;
  protected final InjectableValues _injectableValues;
  protected final DataFormatReaders _dataFormatReaders;
  protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers;
  
  protected ObjectReader(ObjectMapper mapper, DeserializationConfig config)
  {
    this(mapper, config, null, null, null, null);
  }
  
  protected ObjectReader(ObjectMapper mapper, DeserializationConfig config, JavaType valueType, Object valueToUpdate, FormatSchema schema, InjectableValues injectableValues)
  {
    _config = config;
    _context = _deserializationContext;
    _rootDeserializers = _rootDeserializers;
    _parserFactory = _jsonFactory;
    _valueType = valueType;
    _valueToUpdate = valueToUpdate;
    if ((valueToUpdate != null) && (valueType.isArrayType())) {
      throw new IllegalArgumentException("Can not update an array value");
    }
    _schema = schema;
    _injectableValues = injectableValues;
    _unwrapRoot = config.useRootWrapping();
    
    _rootDeserializer = _prefetchRootDeserializer(valueType);
    _dataFormatReaders = null;
    _filter = null;
  }
  
  protected ObjectReader(ObjectReader base, DeserializationConfig config, JavaType valueType, JsonDeserializer<Object> rootDeser, Object valueToUpdate, FormatSchema schema, InjectableValues injectableValues, DataFormatReaders dataFormatReaders)
  {
    _config = config;
    _context = _context;
    
    _rootDeserializers = _rootDeserializers;
    _parserFactory = _parserFactory;
    
    _valueType = valueType;
    _rootDeserializer = rootDeser;
    _valueToUpdate = valueToUpdate;
    if ((valueToUpdate != null) && (valueType.isArrayType())) {
      throw new IllegalArgumentException("Can not update an array value");
    }
    _schema = schema;
    _injectableValues = injectableValues;
    _unwrapRoot = config.useRootWrapping();
    _dataFormatReaders = dataFormatReaders;
    _filter = _filter;
  }
  
  protected ObjectReader(ObjectReader base, DeserializationConfig config)
  {
    _config = config;
    _context = _context;
    
    _rootDeserializers = _rootDeserializers;
    _parserFactory = _parserFactory;
    
    _valueType = _valueType;
    _rootDeserializer = _rootDeserializer;
    _valueToUpdate = _valueToUpdate;
    _schema = _schema;
    _injectableValues = _injectableValues;
    _unwrapRoot = config.useRootWrapping();
    _dataFormatReaders = _dataFormatReaders;
    _filter = _filter;
  }
  
  protected ObjectReader(ObjectReader base, JsonFactory f)
  {
    _config = _config.with(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, f.requiresPropertyOrdering());
    
    _context = _context;
    
    _rootDeserializers = _rootDeserializers;
    _parserFactory = f;
    
    _valueType = _valueType;
    _rootDeserializer = _rootDeserializer;
    _valueToUpdate = _valueToUpdate;
    _schema = _schema;
    _injectableValues = _injectableValues;
    _unwrapRoot = _unwrapRoot;
    _dataFormatReaders = _dataFormatReaders;
    _filter = _filter;
  }
  
  protected ObjectReader(ObjectReader base, TokenFilter filter)
  {
    _config = _config;
    _context = _context;
    _rootDeserializers = _rootDeserializers;
    _parserFactory = _parserFactory;
    _valueType = _valueType;
    _rootDeserializer = _rootDeserializer;
    _valueToUpdate = _valueToUpdate;
    _schema = _schema;
    _injectableValues = _injectableValues;
    _unwrapRoot = _unwrapRoot;
    _dataFormatReaders = _dataFormatReaders;
    _filter = filter;
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  protected ObjectReader _new(ObjectReader base, JsonFactory f)
  {
    return new ObjectReader(base, f);
  }
  
  protected ObjectReader _new(ObjectReader base, DeserializationConfig config)
  {
    return new ObjectReader(base, config);
  }
  
  protected ObjectReader _new(ObjectReader base, DeserializationConfig config, JavaType valueType, JsonDeserializer<Object> rootDeser, Object valueToUpdate, FormatSchema schema, InjectableValues injectableValues, DataFormatReaders dataFormatReaders)
  {
    return new ObjectReader(base, config, valueType, rootDeser, valueToUpdate, schema, injectableValues, dataFormatReaders);
  }
  
  protected <T> MappingIterator<T> _newIterator(JsonParser p, DeserializationContext ctxt, JsonDeserializer<?> deser, boolean parserManaged)
  {
    return new MappingIterator(_valueType, p, ctxt, deser, parserManaged, _valueToUpdate);
  }
  
  protected JsonToken _initForReading(JsonParser p)
    throws IOException
  {
    if (_schema != null) {
      p.setSchema(_schema);
    }
    _config.initialize(p);
    
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
  
  protected void _initForMultiRead(JsonParser p)
    throws IOException
  {
    if (_schema != null) {
      p.setSchema(_schema);
    }
    _config.initialize(p);
  }
  
  public ObjectReader with(DeserializationFeature feature)
  {
    return _with(_config.with(feature));
  }
  
  public ObjectReader with(DeserializationFeature first, DeserializationFeature... other)
  {
    return _with(_config.with(first, other));
  }
  
  public ObjectReader withFeatures(DeserializationFeature... features)
  {
    return _with(_config.withFeatures(features));
  }
  
  public ObjectReader without(DeserializationFeature feature)
  {
    return _with(_config.without(feature));
  }
  
  public ObjectReader without(DeserializationFeature first, DeserializationFeature... other)
  {
    return _with(_config.without(first, other));
  }
  
  public ObjectReader withoutFeatures(DeserializationFeature... features)
  {
    return _with(_config.withoutFeatures(features));
  }
  
  public ObjectReader with(JsonParser.Feature feature)
  {
    return _with(_config.with(feature));
  }
  
  public ObjectReader withFeatures(JsonParser.Feature... features)
  {
    return _with(_config.withFeatures(features));
  }
  
  public ObjectReader without(JsonParser.Feature feature)
  {
    return _with(_config.without(feature));
  }
  
  public ObjectReader withoutFeatures(JsonParser.Feature... features)
  {
    return _with(_config.withoutFeatures(features));
  }
  
  public ObjectReader with(DeserializationConfig config)
  {
    return _with(config);
  }
  
  public ObjectReader with(InjectableValues injectableValues)
  {
    if (_injectableValues == injectableValues) {
      return this;
    }
    return _new(this, _config, _valueType, _rootDeserializer, _valueToUpdate, _schema, injectableValues, _dataFormatReaders);
  }
  
  public ObjectReader with(JsonNodeFactory f)
  {
    return _with(_config.with(f));
  }
  
  public ObjectReader with(JsonFactory f)
  {
    if (f == _parserFactory) {
      return this;
    }
    ObjectReader r = _new(this, f);
    if (f.getCodec() == null) {
      f.setCodec(r);
    }
    return r;
  }
  
  public ObjectReader withRootName(String rootName)
  {
    return _with((DeserializationConfig)_config.withRootName(rootName));
  }
  
  public ObjectReader withRootName(PropertyName rootName)
  {
    return _with(_config.withRootName(rootName));
  }
  
  public ObjectReader withoutRootName()
  {
    return _with(_config.withRootName(PropertyName.NO_NAME));
  }
  
  public ObjectReader with(FormatSchema schema)
  {
    if (_schema == schema) {
      return this;
    }
    _verifySchemaType(schema);
    return _new(this, _config, _valueType, _rootDeserializer, _valueToUpdate, schema, _injectableValues, _dataFormatReaders);
  }
  
  public ObjectReader forType(JavaType valueType)
  {
    if ((valueType != null) && (valueType.equals(_valueType))) {
      return this;
    }
    JsonDeserializer<Object> rootDeser = _prefetchRootDeserializer(valueType);
    
    DataFormatReaders det = _dataFormatReaders;
    if (det != null) {
      det = det.withType(valueType);
    }
    return _new(this, _config, valueType, rootDeser, _valueToUpdate, _schema, _injectableValues, det);
  }
  
  public ObjectReader forType(Class<?> valueType)
  {
    return forType(_config.constructType(valueType));
  }
  
  public ObjectReader forType(TypeReference<?> valueTypeRef)
  {
    return forType(_config.getTypeFactory().constructType(valueTypeRef.getType()));
  }
  
  @Deprecated
  public ObjectReader withType(JavaType valueType)
  {
    return forType(valueType);
  }
  
  @Deprecated
  public ObjectReader withType(Class<?> valueType)
  {
    return forType(_config.constructType(valueType));
  }
  
  @Deprecated
  public ObjectReader withType(Type valueType)
  {
    return forType(_config.getTypeFactory().constructType(valueType));
  }
  
  @Deprecated
  public ObjectReader withType(TypeReference<?> valueTypeRef)
  {
    return forType(_config.getTypeFactory().constructType(valueTypeRef.getType()));
  }
  
  public ObjectReader withValueToUpdate(Object value)
  {
    if (value == _valueToUpdate) {
      return this;
    }
    if (value == null) {
      throw new IllegalArgumentException("cat not update null value");
    }
    JavaType t;
    JavaType t;
    if (_valueType == null) {
      t = _config.constructType(value.getClass());
    } else {
      t = _valueType;
    }
    return _new(this, _config, t, _rootDeserializer, value, _schema, _injectableValues, _dataFormatReaders);
  }
  
  public ObjectReader withView(Class<?> activeView)
  {
    return _with(_config.withView(activeView));
  }
  
  public ObjectReader with(Locale l)
  {
    return _with(_config.with(l));
  }
  
  public ObjectReader with(TimeZone tz)
  {
    return _with(_config.with(tz));
  }
  
  public ObjectReader withHandler(DeserializationProblemHandler h)
  {
    return _with(_config.withHandler(h));
  }
  
  public ObjectReader with(Base64Variant defaultBase64)
  {
    return _with(_config.with(defaultBase64));
  }
  
  public ObjectReader withFormatDetection(ObjectReader... readers)
  {
    return withFormatDetection(new DataFormatReaders(readers));
  }
  
  public ObjectReader withFormatDetection(DataFormatReaders readers)
  {
    return _new(this, _config, _valueType, _rootDeserializer, _valueToUpdate, _schema, _injectableValues, readers);
  }
  
  public ObjectReader with(ContextAttributes attrs)
  {
    return _with(_config.with(attrs));
  }
  
  public ObjectReader withAttributes(Map<Object, Object> attrs)
  {
    return _with((DeserializationConfig)_config.withAttributes(attrs));
  }
  
  public ObjectReader withAttribute(Object key, Object value)
  {
    return _with((DeserializationConfig)_config.withAttribute(key, value));
  }
  
  public ObjectReader withoutAttribute(Object key)
  {
    return _with((DeserializationConfig)_config.withoutAttribute(key));
  }
  
  protected ObjectReader _with(DeserializationConfig newConfig)
  {
    if (newConfig == _config) {
      return this;
    }
    ObjectReader r = _new(this, newConfig);
    if (_dataFormatReaders != null) {
      r = r.withFormatDetection(_dataFormatReaders.with(newConfig));
    }
    return r;
  }
  
  public boolean isEnabled(DeserializationFeature f)
  {
    return _config.isEnabled(f);
  }
  
  public boolean isEnabled(MapperFeature f)
  {
    return _config.isEnabled(f);
  }
  
  public boolean isEnabled(JsonParser.Feature f)
  {
    return _parserFactory.isEnabled(f);
  }
  
  public DeserializationConfig getConfig()
  {
    return _config;
  }
  
  public JsonFactory getFactory()
  {
    return _parserFactory;
  }
  
  public TypeFactory getTypeFactory()
  {
    return _config.getTypeFactory();
  }
  
  public ContextAttributes getAttributes()
  {
    return _config.getAttributes();
  }
  
  public InjectableValues getInjectableValues()
  {
    return _injectableValues;
  }
  
  public <T> T readValue(JsonParser jp)
    throws IOException, JsonProcessingException
  {
    return (T)_bind(jp, _valueToUpdate);
  }
  
  public <T> T readValue(JsonParser jp, Class<T> valueType)
    throws IOException, JsonProcessingException
  {
    return (T)forType(valueType).readValue(jp);
  }
  
  public <T> T readValue(JsonParser jp, TypeReference<?> valueTypeRef)
    throws IOException, JsonProcessingException
  {
    return (T)forType(valueTypeRef).readValue(jp);
  }
  
  public <T> T readValue(JsonParser jp, ResolvedType valueType)
    throws IOException, JsonProcessingException
  {
    return (T)forType((JavaType)valueType).readValue(jp);
  }
  
  public <T> T readValue(JsonParser jp, JavaType valueType)
    throws IOException, JsonProcessingException
  {
    return (T)forType(valueType).readValue(jp);
  }
  
  public <T> Iterator<T> readValues(JsonParser jp, Class<T> valueType)
    throws IOException, JsonProcessingException
  {
    return forType(valueType).readValues(jp);
  }
  
  public <T> Iterator<T> readValues(JsonParser jp, TypeReference<?> valueTypeRef)
    throws IOException, JsonProcessingException
  {
    return forType(valueTypeRef).readValues(jp);
  }
  
  public <T> Iterator<T> readValues(JsonParser jp, ResolvedType valueType)
    throws IOException, JsonProcessingException
  {
    return readValues(jp, (JavaType)valueType);
  }
  
  public <T> Iterator<T> readValues(JsonParser jp, JavaType valueType)
    throws IOException, JsonProcessingException
  {
    return forType(valueType).readValues(jp);
  }
  
  public JsonNode createArrayNode()
  {
    return _config.getNodeFactory().arrayNode();
  }
  
  public JsonNode createObjectNode()
  {
    return _config.getNodeFactory().objectNode();
  }
  
  public JsonParser treeAsTokens(TreeNode n)
  {
    return new TreeTraversingParser((JsonNode)n, this);
  }
  
  public <T extends TreeNode> T readTree(JsonParser jp)
    throws IOException, JsonProcessingException
  {
    return _bindAsTree(jp);
  }
  
  public void writeTree(JsonGenerator jgen, TreeNode rootNode)
  {
    throw new UnsupportedOperationException();
  }
  
  public <T> T readValue(InputStream src)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      return (T)_detectBindAndClose(_dataFormatReaders.findFormat(src), false);
    }
    return (T)_bindAndClose(_considerFilter(_parserFactory.createParser(src)));
  }
  
  public <T> T readValue(Reader src)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      _reportUndetectableSource(src);
    }
    return (T)_bindAndClose(_considerFilter(_parserFactory.createParser(src)));
  }
  
  public <T> T readValue(String src)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      _reportUndetectableSource(src);
    }
    return (T)_bindAndClose(_considerFilter(_parserFactory.createParser(src)));
  }
  
  public <T> T readValue(byte[] src)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      return (T)_detectBindAndClose(src, 0, src.length);
    }
    return (T)_bindAndClose(_considerFilter(_parserFactory.createParser(src)));
  }
  
  public <T> T readValue(byte[] src, int offset, int length)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      return (T)_detectBindAndClose(src, offset, length);
    }
    return (T)_bindAndClose(_considerFilter(_parserFactory.createParser(src, offset, length)));
  }
  
  public <T> T readValue(File src)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      return (T)_detectBindAndClose(_dataFormatReaders.findFormat(_inputStream(src)), true);
    }
    return (T)_bindAndClose(_considerFilter(_parserFactory.createParser(src)));
  }
  
  public <T> T readValue(URL src)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      return (T)_detectBindAndClose(_dataFormatReaders.findFormat(_inputStream(src)), true);
    }
    return (T)_bindAndClose(_considerFilter(_parserFactory.createParser(src)));
  }
  
  public <T> T readValue(JsonNode src)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      _reportUndetectableSource(src);
    }
    return (T)_bindAndClose(_considerFilter(treeAsTokens(src)));
  }
  
  public JsonNode readTree(InputStream in)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      return _detectBindAndCloseAsTree(in);
    }
    return _bindAndCloseAsTree(_considerFilter(_parserFactory.createParser(in)));
  }
  
  public JsonNode readTree(Reader r)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      _reportUndetectableSource(r);
    }
    return _bindAndCloseAsTree(_considerFilter(_parserFactory.createParser(r)));
  }
  
  public JsonNode readTree(String json)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      _reportUndetectableSource(json);
    }
    return _bindAndCloseAsTree(_considerFilter(_parserFactory.createParser(json)));
  }
  
  public <T> MappingIterator<T> readValues(JsonParser p)
    throws IOException, JsonProcessingException
  {
    DeserializationContext ctxt = createDeserializationContext(p);
    
    return _newIterator(p, ctxt, _findRootDeserializer(ctxt), false);
  }
  
  public <T> MappingIterator<T> readValues(InputStream src)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      return _detectBindAndReadValues(_dataFormatReaders.findFormat(src), false);
    }
    return _bindAndReadValues(_considerFilter(_parserFactory.createParser(src)));
  }
  
  public <T> MappingIterator<T> readValues(Reader src)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      _reportUndetectableSource(src);
    }
    JsonParser p = _considerFilter(_parserFactory.createParser(src));
    _initForMultiRead(p);
    p.nextToken();
    DeserializationContext ctxt = createDeserializationContext(p);
    return _newIterator(p, ctxt, _findRootDeserializer(ctxt), true);
  }
  
  public <T> MappingIterator<T> readValues(String json)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      _reportUndetectableSource(json);
    }
    JsonParser p = _considerFilter(_parserFactory.createParser(json));
    _initForMultiRead(p);
    p.nextToken();
    DeserializationContext ctxt = createDeserializationContext(p);
    return _newIterator(p, ctxt, _findRootDeserializer(ctxt), true);
  }
  
  public <T> MappingIterator<T> readValues(byte[] src, int offset, int length)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      return _detectBindAndReadValues(_dataFormatReaders.findFormat(src, offset, length), false);
    }
    return _bindAndReadValues(_considerFilter(_parserFactory.createParser(src)));
  }
  
  public final <T> MappingIterator<T> readValues(byte[] src)
    throws IOException, JsonProcessingException
  {
    return readValues(src, 0, src.length);
  }
  
  public <T> MappingIterator<T> readValues(File src)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      return _detectBindAndReadValues(_dataFormatReaders.findFormat(_inputStream(src)), false);
    }
    return _bindAndReadValues(_considerFilter(_parserFactory.createParser(src)));
  }
  
  public <T> MappingIterator<T> readValues(URL src)
    throws IOException, JsonProcessingException
  {
    if (_dataFormatReaders != null) {
      return _detectBindAndReadValues(_dataFormatReaders.findFormat(_inputStream(src)), true);
    }
    return _bindAndReadValues(_considerFilter(_parserFactory.createParser(src)));
  }
  
  public <T> T treeToValue(TreeNode n, Class<T> valueType)
    throws JsonProcessingException
  {
    try
    {
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
  
  public void writeValue(JsonGenerator gen, Object value)
    throws IOException, JsonProcessingException
  {
    throw new UnsupportedOperationException("Not implemented for ObjectReader");
  }
  
  protected Object _bind(JsonParser p, Object valueToUpdate)
    throws IOException
  {
    JsonToken t = _initForReading(p);
    Object result;
    Object result;
    if (t == JsonToken.VALUE_NULL)
    {
      Object result;
      if (valueToUpdate == null)
      {
        DeserializationContext ctxt = createDeserializationContext(p);
        result = _findRootDeserializer(ctxt).getNullValue(ctxt);
      }
      else
      {
        result = valueToUpdate;
      }
    }
    else
    {
      Object result;
      if ((t == JsonToken.END_ARRAY) || (t == JsonToken.END_OBJECT))
      {
        result = valueToUpdate;
      }
      else
      {
        DeserializationContext ctxt = createDeserializationContext(p);
        JsonDeserializer<Object> deser = _findRootDeserializer(ctxt);
        Object result;
        if (_unwrapRoot)
        {
          result = _unwrapAndDeserialize(p, ctxt, _valueType, deser);
        }
        else
        {
          Object result;
          if (valueToUpdate == null)
          {
            result = deser.deserialize(p, ctxt);
          }
          else
          {
            deser.deserialize(p, ctxt, valueToUpdate);
            result = valueToUpdate;
          }
        }
      }
    }
    p.clearCurrentToken();
    return result;
  }
  
  protected JsonParser _considerFilter(JsonParser p)
  {
    return (_filter == null) || (FilteringParserDelegate.class.isInstance(p)) ? p : new FilteringParserDelegate(p, _filter, false, false);
  }
  
  protected Object _bindAndClose(JsonParser p)
    throws IOException
  {
    try
    {
      JsonToken t = _initForReading(p);
      Object result;
      DeserializationContext ctxt;
      Object result;
      if (t == JsonToken.VALUE_NULL)
      {
        Object result;
        if (_valueToUpdate == null)
        {
          DeserializationContext ctxt = createDeserializationContext(p);
          result = _findRootDeserializer(ctxt).getNullValue(ctxt);
        }
        else
        {
          result = _valueToUpdate;
        }
      }
      else
      {
        Object result;
        if ((t == JsonToken.END_ARRAY) || (t == JsonToken.END_OBJECT))
        {
          result = _valueToUpdate;
        }
        else
        {
          ctxt = createDeserializationContext(p);
          JsonDeserializer<Object> deser = _findRootDeserializer(ctxt);
          Object result;
          if (_unwrapRoot)
          {
            result = _unwrapAndDeserialize(p, ctxt, _valueType, deser);
          }
          else
          {
            Object result;
            if (_valueToUpdate == null)
            {
              result = deser.deserialize(p, ctxt);
            }
            else
            {
              deser.deserialize(p, ctxt, _valueToUpdate);
              result = _valueToUpdate;
            }
          }
        }
      }
      return (DeserializationContext)result;
    }
    finally
    {
      try
      {
        p.close();
      }
      catch (IOException ioe) {}
    }
  }
  
  protected JsonNode _bindAndCloseAsTree(JsonParser p)
    throws IOException
  {
    try
    {
      return _bindAsTree(p);
    }
    finally
    {
      try
      {
        p.close();
      }
      catch (IOException ioe) {}
    }
  }
  
  protected JsonNode _bindAsTree(JsonParser p)
    throws IOException
  {
    JsonToken t = _initForReading(p);
    JsonNode result;
    JsonNode result;
    if ((t == JsonToken.VALUE_NULL) || (t == JsonToken.END_ARRAY) || (t == JsonToken.END_OBJECT))
    {
      result = NullNode.instance;
    }
    else
    {
      DeserializationContext ctxt = createDeserializationContext(p);
      JsonDeserializer<Object> deser = _findTreeDeserializer(ctxt);
      JsonNode result;
      if (_unwrapRoot) {
        result = (JsonNode)_unwrapAndDeserialize(p, ctxt, JSON_NODE_TYPE, deser);
      } else {
        result = (JsonNode)deser.deserialize(p, ctxt);
      }
    }
    p.clearCurrentToken();
    return result;
  }
  
  protected <T> MappingIterator<T> _bindAndReadValues(JsonParser p)
    throws IOException
  {
    _initForMultiRead(p);
    p.nextToken();
    DeserializationContext ctxt = createDeserializationContext(p);
    return _newIterator(p, ctxt, _findRootDeserializer(ctxt), true);
  }
  
  protected Object _unwrapAndDeserialize(JsonParser p, DeserializationContext ctxt, JavaType rootType, JsonDeserializer<Object> deser)
    throws IOException
  {
    PropertyName expRootName = _config.findRootName(rootType);
    
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
    Object result;
    Object result;
    if (_valueToUpdate == null)
    {
      result = deser.deserialize(p, ctxt);
    }
    else
    {
      deser.deserialize(p, ctxt, _valueToUpdate);
      result = _valueToUpdate;
    }
    if (p.nextToken() != JsonToken.END_OBJECT) {
      throw JsonMappingException.from(p, "Current token not END_OBJECT (to match wrapper object with root name '" + expSimpleName + "'), but " + p.getCurrentToken());
    }
    return result;
  }
  
  protected Object _detectBindAndClose(byte[] src, int offset, int length)
    throws IOException
  {
    DataFormatReaders.Match match = _dataFormatReaders.findFormat(src, offset, length);
    if (!match.hasMatch()) {
      _reportUnkownFormat(_dataFormatReaders, match);
    }
    JsonParser p = match.createParserWithMatch();
    return match.getReader()._bindAndClose(p);
  }
  
  protected Object _detectBindAndClose(DataFormatReaders.Match match, boolean forceClosing)
    throws IOException
  {
    if (!match.hasMatch()) {
      _reportUnkownFormat(_dataFormatReaders, match);
    }
    JsonParser p = match.createParserWithMatch();
    if (forceClosing) {
      p.enable(JsonParser.Feature.AUTO_CLOSE_SOURCE);
    }
    return match.getReader()._bindAndClose(p);
  }
  
  protected <T> MappingIterator<T> _detectBindAndReadValues(DataFormatReaders.Match match, boolean forceClosing)
    throws IOException, JsonProcessingException
  {
    if (!match.hasMatch()) {
      _reportUnkownFormat(_dataFormatReaders, match);
    }
    JsonParser p = match.createParserWithMatch();
    if (forceClosing) {
      p.enable(JsonParser.Feature.AUTO_CLOSE_SOURCE);
    }
    return match.getReader()._bindAndReadValues(p);
  }
  
  protected JsonNode _detectBindAndCloseAsTree(InputStream in)
    throws IOException
  {
    DataFormatReaders.Match match = _dataFormatReaders.findFormat(in);
    if (!match.hasMatch()) {
      _reportUnkownFormat(_dataFormatReaders, match);
    }
    JsonParser p = match.createParserWithMatch();
    p.enable(JsonParser.Feature.AUTO_CLOSE_SOURCE);
    return match.getReader()._bindAndCloseAsTree(p);
  }
  
  protected void _reportUnkownFormat(DataFormatReaders detector, DataFormatReaders.Match match)
    throws JsonProcessingException
  {
    throw new JsonParseException("Can not detect format from input, does not look like any of detectable formats " + detector.toString(), JsonLocation.NA);
  }
  
  protected void _verifySchemaType(FormatSchema schema)
  {
    if ((schema != null) && 
      (!_parserFactory.canUseSchema(schema))) {
      throw new IllegalArgumentException("Can not use FormatSchema of type " + schema.getClass().getName() + " for format " + _parserFactory.getFormatName());
    }
  }
  
  protected DefaultDeserializationContext createDeserializationContext(JsonParser p)
  {
    return _context.createInstance(_config, p, _injectableValues);
  }
  
  protected void _reportUndetectableSource(Object src)
    throws JsonProcessingException
  {
    throw new JsonParseException("Can not use source of type " + src.getClass().getName() + " with format auto-detection: must be byte- not char-based", JsonLocation.NA);
  }
  
  protected InputStream _inputStream(URL src)
    throws IOException
  {
    return src.openStream();
  }
  
  protected InputStream _inputStream(File f)
    throws IOException
  {
    return new FileInputStream(f);
  }
  
  protected JsonDeserializer<Object> _findRootDeserializer(DeserializationContext ctxt)
    throws JsonMappingException
  {
    if (_rootDeserializer != null) {
      return _rootDeserializer;
    }
    JavaType t = _valueType;
    if (t == null) {
      throw new JsonMappingException("No value type configured for ObjectReader");
    }
    JsonDeserializer<Object> deser = (JsonDeserializer)_rootDeserializers.get(t);
    if (deser != null) {
      return deser;
    }
    deser = ctxt.findRootValueDeserializer(t);
    if (deser == null) {
      throw new JsonMappingException("Can not find a deserializer for type " + t);
    }
    _rootDeserializers.put(t, deser);
    return deser;
  }
  
  protected JsonDeserializer<Object> _findTreeDeserializer(DeserializationContext ctxt)
    throws JsonMappingException
  {
    JsonDeserializer<Object> deser = (JsonDeserializer)_rootDeserializers.get(JSON_NODE_TYPE);
    if (deser == null)
    {
      deser = ctxt.findRootValueDeserializer(JSON_NODE_TYPE);
      if (deser == null) {
        throw new JsonMappingException("Can not find a deserializer for type " + JSON_NODE_TYPE);
      }
      _rootDeserializers.put(JSON_NODE_TYPE, deser);
    }
    return deser;
  }
  
  protected JsonDeserializer<Object> _prefetchRootDeserializer(JavaType valueType)
  {
    if ((valueType == null) || (!_config.isEnabled(DeserializationFeature.EAGER_DESERIALIZER_FETCH))) {
      return null;
    }
    JsonDeserializer<Object> deser = (JsonDeserializer)_rootDeserializers.get(valueType);
    if (deser == null) {
      try
      {
        DeserializationContext ctxt = createDeserializationContext(null);
        deser = ctxt.findRootValueDeserializer(valueType);
        if (deser != null) {
          _rootDeserializers.put(valueType, deser);
        }
        return deser;
      }
      catch (JsonProcessingException e) {}
    }
    return deser;
  }
  
  public ObjectReader at(String value)
  {
    return new ObjectReader(this, new JsonPointerBasedFilter(value));
  }
  
  public ObjectReader at(JsonPointer pointer)
  {
    return new ObjectReader(this, new JsonPointerBasedFilter(pointer));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */