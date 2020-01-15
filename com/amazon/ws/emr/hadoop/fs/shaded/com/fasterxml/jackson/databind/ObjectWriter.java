package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonEncoding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.PrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Versioned;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharacterEscapes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.SerializedString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.TypeReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.Instantiatable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.FilterProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public class ObjectWriter
  implements Versioned, Serializable
{
  private static final long serialVersionUID = 1L;
  protected static final PrettyPrinter NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
  protected final SerializationConfig _config;
  protected final DefaultSerializerProvider _serializerProvider;
  protected final SerializerFactory _serializerFactory;
  protected final JsonFactory _generatorFactory;
  protected final GeneratorSettings _generatorSettings;
  protected final Prefetch _prefetch;
  
  protected ObjectWriter(ObjectMapper mapper, SerializationConfig config, JavaType rootType, PrettyPrinter pp)
  {
    _config = config;
    _serializerProvider = _serializerProvider;
    _serializerFactory = _serializerFactory;
    _generatorFactory = _jsonFactory;
    _generatorSettings = (pp == null ? GeneratorSettings.empty : new GeneratorSettings(pp, null, null, null));
    if ((rootType == null) || (rootType.hasRawClass(Object.class)))
    {
      _prefetch = Prefetch.empty;
    }
    else
    {
      rootType = rootType.withStaticTyping();
      _prefetch = Prefetch.empty.forRootType(this, rootType);
    }
  }
  
  protected ObjectWriter(ObjectMapper mapper, SerializationConfig config)
  {
    _config = config;
    _serializerProvider = _serializerProvider;
    _serializerFactory = _serializerFactory;
    _generatorFactory = _jsonFactory;
    
    _generatorSettings = GeneratorSettings.empty;
    _prefetch = Prefetch.empty;
  }
  
  protected ObjectWriter(ObjectMapper mapper, SerializationConfig config, FormatSchema s)
  {
    _config = config;
    
    _serializerProvider = _serializerProvider;
    _serializerFactory = _serializerFactory;
    _generatorFactory = _jsonFactory;
    
    _generatorSettings = (s == null ? GeneratorSettings.empty : new GeneratorSettings(null, s, null, null));
    
    _prefetch = Prefetch.empty;
  }
  
  protected ObjectWriter(ObjectWriter base, SerializationConfig config, GeneratorSettings genSettings, Prefetch prefetch)
  {
    _config = config;
    
    _serializerProvider = _serializerProvider;
    _serializerFactory = _serializerFactory;
    _generatorFactory = _generatorFactory;
    
    _generatorSettings = genSettings;
    _prefetch = prefetch;
  }
  
  protected ObjectWriter(ObjectWriter base, SerializationConfig config)
  {
    _config = config;
    
    _serializerProvider = _serializerProvider;
    _serializerFactory = _serializerFactory;
    _generatorFactory = _generatorFactory;
    
    _generatorSettings = _generatorSettings;
    _prefetch = _prefetch;
  }
  
  protected ObjectWriter(ObjectWriter base, JsonFactory f)
  {
    _config = _config.with(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, f.requiresPropertyOrdering());
    
    _serializerProvider = _serializerProvider;
    _serializerFactory = _serializerFactory;
    _generatorFactory = _generatorFactory;
    
    _generatorSettings = _generatorSettings;
    _prefetch = _prefetch;
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  protected ObjectWriter _new(ObjectWriter base, JsonFactory f)
  {
    return new ObjectWriter(base, f);
  }
  
  protected ObjectWriter _new(ObjectWriter base, SerializationConfig config)
  {
    return new ObjectWriter(base, config);
  }
  
  protected ObjectWriter _new(GeneratorSettings genSettings, Prefetch prefetch)
  {
    return new ObjectWriter(this, _config, genSettings, prefetch);
  }
  
  protected SequenceWriter _newSequenceWriter(boolean wrapInArray, JsonGenerator gen, boolean managedInput)
    throws IOException
  {
    _configureGenerator(gen);
    return new SequenceWriter(_serializerProvider(), gen, managedInput, _prefetch).init(wrapInArray);
  }
  
  public ObjectWriter with(SerializationFeature feature)
  {
    SerializationConfig newConfig = _config.with(feature);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter with(SerializationFeature first, SerializationFeature... other)
  {
    SerializationConfig newConfig = _config.with(first, other);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter withFeatures(SerializationFeature... features)
  {
    SerializationConfig newConfig = _config.withFeatures(features);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter without(SerializationFeature feature)
  {
    SerializationConfig newConfig = _config.without(feature);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter without(SerializationFeature first, SerializationFeature... other)
  {
    SerializationConfig newConfig = _config.without(first, other);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter withoutFeatures(SerializationFeature... features)
  {
    SerializationConfig newConfig = _config.withoutFeatures(features);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter with(JsonGenerator.Feature feature)
  {
    SerializationConfig newConfig = _config.with(feature);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter withFeatures(JsonGenerator.Feature... features)
  {
    SerializationConfig newConfig = _config.withFeatures(features);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter without(JsonGenerator.Feature feature)
  {
    SerializationConfig newConfig = _config.without(feature);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter withoutFeatures(JsonGenerator.Feature... features)
  {
    SerializationConfig newConfig = _config.withoutFeatures(features);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter forType(JavaType rootType)
  {
    Prefetch pf = _prefetch.forRootType(this, rootType);
    return pf == _prefetch ? this : _new(_generatorSettings, pf);
  }
  
  public ObjectWriter forType(Class<?> rootType)
  {
    if (rootType == Object.class) {
      return forType((JavaType)null);
    }
    return forType(_config.constructType(rootType));
  }
  
  public ObjectWriter forType(TypeReference<?> rootType)
  {
    return forType(_config.getTypeFactory().constructType(rootType.getType()));
  }
  
  @Deprecated
  public ObjectWriter withType(JavaType rootType)
  {
    return forType(rootType);
  }
  
  @Deprecated
  public ObjectWriter withType(Class<?> rootType)
  {
    return forType(rootType);
  }
  
  @Deprecated
  public ObjectWriter withType(TypeReference<?> rootType)
  {
    return forType(rootType);
  }
  
  public ObjectWriter with(DateFormat df)
  {
    SerializationConfig newConfig = _config.with(df);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter withDefaultPrettyPrinter()
  {
    return with(_config.getDefaultPrettyPrinter());
  }
  
  public ObjectWriter with(FilterProvider filterProvider)
  {
    return filterProvider == _config.getFilterProvider() ? this : _new(this, _config.withFilters(filterProvider));
  }
  
  public ObjectWriter with(PrettyPrinter pp)
  {
    GeneratorSettings genSet = _generatorSettings.with(pp);
    if (genSet == _generatorSettings) {
      return this;
    }
    return _new(genSet, _prefetch);
  }
  
  public ObjectWriter withRootName(String rootName)
  {
    SerializationConfig newConfig = (SerializationConfig)_config.withRootName(rootName);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter withRootName(PropertyName rootName)
  {
    SerializationConfig newConfig = _config.withRootName(rootName);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter withoutRootName()
  {
    SerializationConfig newConfig = _config.withRootName(PropertyName.NO_NAME);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter with(FormatSchema schema)
  {
    GeneratorSettings genSet = _generatorSettings.with(schema);
    if (genSet == _generatorSettings) {
      return this;
    }
    _verifySchemaType(schema);
    return _new(genSet, _prefetch);
  }
  
  @Deprecated
  public ObjectWriter withSchema(FormatSchema schema)
  {
    return with(schema);
  }
  
  public ObjectWriter withView(Class<?> view)
  {
    SerializationConfig newConfig = _config.withView(view);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter with(Locale l)
  {
    SerializationConfig newConfig = _config.with(l);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter with(TimeZone tz)
  {
    SerializationConfig newConfig = _config.with(tz);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter with(Base64Variant b64variant)
  {
    SerializationConfig newConfig = _config.with(b64variant);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter with(CharacterEscapes escapes)
  {
    GeneratorSettings genSet = _generatorSettings.with(escapes);
    if (genSet == _generatorSettings) {
      return this;
    }
    return _new(genSet, _prefetch);
  }
  
  public ObjectWriter with(JsonFactory f)
  {
    return f == _generatorFactory ? this : _new(this, f);
  }
  
  public ObjectWriter with(ContextAttributes attrs)
  {
    SerializationConfig newConfig = _config.with(attrs);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter withAttributes(Map<Object, Object> attrs)
  {
    SerializationConfig newConfig = (SerializationConfig)_config.withAttributes(attrs);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter withAttribute(Object key, Object value)
  {
    SerializationConfig newConfig = (SerializationConfig)_config.withAttribute(key, value);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter withoutAttribute(Object key)
  {
    SerializationConfig newConfig = (SerializationConfig)_config.withoutAttribute(key);
    return newConfig == _config ? this : _new(this, newConfig);
  }
  
  public ObjectWriter withRootValueSeparator(String sep)
  {
    GeneratorSettings genSet = _generatorSettings.withRootValueSeparator(sep);
    if (genSet == _generatorSettings) {
      return this;
    }
    return _new(genSet, _prefetch);
  }
  
  public ObjectWriter withRootValueSeparator(SerializableString sep)
  {
    GeneratorSettings genSet = _generatorSettings.withRootValueSeparator(sep);
    if (genSet == _generatorSettings) {
      return this;
    }
    return _new(genSet, _prefetch);
  }
  
  public SequenceWriter writeValues(File out)
    throws IOException
  {
    return _newSequenceWriter(false, _generatorFactory.createGenerator(out, JsonEncoding.UTF8), true);
  }
  
  public SequenceWriter writeValues(JsonGenerator gen)
    throws IOException
  {
    _configureGenerator(gen);
    return _newSequenceWriter(false, gen, false);
  }
  
  public SequenceWriter writeValues(Writer out)
    throws IOException
  {
    return _newSequenceWriter(false, _generatorFactory.createGenerator(out), true);
  }
  
  public SequenceWriter writeValues(OutputStream out)
    throws IOException
  {
    return _newSequenceWriter(false, _generatorFactory.createGenerator(out, JsonEncoding.UTF8), true);
  }
  
  public SequenceWriter writeValuesAsArray(File out)
    throws IOException
  {
    return _newSequenceWriter(true, _generatorFactory.createGenerator(out, JsonEncoding.UTF8), true);
  }
  
  public SequenceWriter writeValuesAsArray(JsonGenerator gen)
    throws IOException
  {
    return _newSequenceWriter(true, gen, false);
  }
  
  public SequenceWriter writeValuesAsArray(Writer out)
    throws IOException
  {
    return _newSequenceWriter(true, _generatorFactory.createGenerator(out), true);
  }
  
  public SequenceWriter writeValuesAsArray(OutputStream out)
    throws IOException
  {
    return _newSequenceWriter(true, _generatorFactory.createGenerator(out, JsonEncoding.UTF8), true);
  }
  
  public boolean isEnabled(SerializationFeature f)
  {
    return _config.isEnabled(f);
  }
  
  public boolean isEnabled(MapperFeature f)
  {
    return _config.isEnabled(f);
  }
  
  public boolean isEnabled(JsonParser.Feature f)
  {
    return _generatorFactory.isEnabled(f);
  }
  
  public SerializationConfig getConfig()
  {
    return _config;
  }
  
  public JsonFactory getFactory()
  {
    return _generatorFactory;
  }
  
  public TypeFactory getTypeFactory()
  {
    return _config.getTypeFactory();
  }
  
  public boolean hasPrefetchedSerializer()
  {
    return _prefetch.hasSerializer();
  }
  
  public ContextAttributes getAttributes()
  {
    return _config.getAttributes();
  }
  
  public void writeValue(JsonGenerator gen, Object value)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    _configureGenerator(gen);
    if ((_config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)) && ((value instanceof Closeable)))
    {
      Closeable toClose = (Closeable)value;
      try
      {
        _prefetch.serialize(gen, value, _serializerProvider());
        if (_config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
          gen.flush();
        }
        Closeable tmpToClose = toClose;
        toClose = null;
        tmpToClose.close();
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
    _prefetch.serialize(gen, value, _serializerProvider());
    if (_config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
      gen.flush();
    }
  }
  
  public void writeValue(File resultFile, Object value)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    _configAndWriteValue(_generatorFactory.createGenerator(resultFile, JsonEncoding.UTF8), value);
  }
  
  public void writeValue(OutputStream out, Object value)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    _configAndWriteValue(_generatorFactory.createGenerator(out, JsonEncoding.UTF8), value);
  }
  
  public void writeValue(Writer w, Object value)
    throws IOException, JsonGenerationException, JsonMappingException
  {
    _configAndWriteValue(_generatorFactory.createGenerator(w), value);
  }
  
  public String writeValueAsString(Object value)
    throws JsonProcessingException
  {
    SegmentedStringWriter sw = new SegmentedStringWriter(_generatorFactory._getBufferRecycler());
    try
    {
      _configAndWriteValue(_generatorFactory.createGenerator(sw), value);
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
    ByteArrayBuilder bb = new ByteArrayBuilder(_generatorFactory._getBufferRecycler());
    try
    {
      _configAndWriteValue(_generatorFactory.createGenerator(bb, JsonEncoding.UTF8), value);
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
  
  public void acceptJsonFormatVisitor(JavaType type, JsonFormatVisitorWrapper visitor)
    throws JsonMappingException
  {
    if (type == null) {
      throw new IllegalArgumentException("type must be provided");
    }
    _serializerProvider().acceptJsonFormatVisitor(type, visitor);
  }
  
  public void acceptJsonFormatVisitor(Class<?> rawType, JsonFormatVisitorWrapper visitor)
    throws JsonMappingException
  {
    acceptJsonFormatVisitor(_config.constructType(rawType), visitor);
  }
  
  public boolean canSerialize(Class<?> type)
  {
    return _serializerProvider().hasSerializerFor(type, null);
  }
  
  public boolean canSerialize(Class<?> type, AtomicReference<Throwable> cause)
  {
    return _serializerProvider().hasSerializerFor(type, cause);
  }
  
  protected DefaultSerializerProvider _serializerProvider()
  {
    return _serializerProvider.createInstance(_config, _serializerFactory);
  }
  
  protected void _verifySchemaType(FormatSchema schema)
  {
    if ((schema != null) && 
      (!_generatorFactory.canUseSchema(schema))) {
      throw new IllegalArgumentException("Can not use FormatSchema of type " + schema.getClass().getName() + " for format " + _generatorFactory.getFormatName());
    }
  }
  
  protected final void _configAndWriteValue(JsonGenerator gen, Object value)
    throws IOException
  {
    _configureGenerator(gen);
    if ((_config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)) && ((value instanceof Closeable)))
    {
      _writeCloseable(gen, value);
      return;
    }
    boolean closed = false;
    try
    {
      _prefetch.serialize(gen, value, _serializerProvider());
      closed = true;
      gen.close(); return;
    }
    finally
    {
      if (!closed)
      {
        gen.disable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
        try
        {
          gen.close();
        }
        catch (IOException ioe) {}
      }
    }
  }
  
  private final void _writeCloseable(JsonGenerator gen, Object value)
    throws IOException
  {
    Closeable toClose = (Closeable)value;
    try
    {
      _prefetch.serialize(gen, value, _serializerProvider());
      JsonGenerator tmpGen = gen;
      gen = null;
      tmpGen.close();
      Closeable tmpToClose = toClose;
      toClose = null;
      tmpToClose.close(); return;
    }
    finally
    {
      if (gen != null)
      {
        gen.disable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
        try
        {
          gen.close();
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
  
  protected final void _configureGenerator(JsonGenerator gen)
  {
    _config.initialize(gen);
    _generatorSettings.initialize(gen);
  }
  
  public static final class GeneratorSettings
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public static final GeneratorSettings empty = new GeneratorSettings(null, null, null, null);
    public final PrettyPrinter prettyPrinter;
    public final FormatSchema schema;
    public final CharacterEscapes characterEscapes;
    public final SerializableString rootValueSeparator;
    
    public GeneratorSettings(PrettyPrinter pp, FormatSchema sch, CharacterEscapes esc, SerializableString rootSep)
    {
      prettyPrinter = pp;
      schema = sch;
      characterEscapes = esc;
      rootValueSeparator = rootSep;
    }
    
    public GeneratorSettings with(PrettyPrinter pp)
    {
      if (pp == null) {
        pp = ObjectWriter.NULL_PRETTY_PRINTER;
      }
      return pp == prettyPrinter ? this : new GeneratorSettings(pp, schema, characterEscapes, rootValueSeparator);
    }
    
    public GeneratorSettings with(FormatSchema sch)
    {
      return schema == sch ? this : new GeneratorSettings(prettyPrinter, sch, characterEscapes, rootValueSeparator);
    }
    
    public GeneratorSettings with(CharacterEscapes esc)
    {
      return characterEscapes == esc ? this : new GeneratorSettings(prettyPrinter, schema, esc, rootValueSeparator);
    }
    
    public GeneratorSettings withRootValueSeparator(String sep)
    {
      if (sep == null)
      {
        if (rootValueSeparator == null) {
          return this;
        }
      }
      else if (sep.equals(rootValueSeparator)) {
        return this;
      }
      return new GeneratorSettings(prettyPrinter, schema, characterEscapes, sep == null ? null : new SerializedString(sep));
    }
    
    public GeneratorSettings withRootValueSeparator(SerializableString sep)
    {
      if (sep == null)
      {
        if (rootValueSeparator == null) {
          return this;
        }
      }
      else if ((rootValueSeparator != null) && (sep.getValue().equals(rootValueSeparator.getValue()))) {
        return this;
      }
      return new GeneratorSettings(prettyPrinter, schema, characterEscapes, sep);
    }
    
    public void initialize(JsonGenerator gen)
    {
      PrettyPrinter pp = prettyPrinter;
      if (prettyPrinter != null) {
        if (pp == ObjectWriter.NULL_PRETTY_PRINTER)
        {
          gen.setPrettyPrinter(null);
        }
        else
        {
          if ((pp instanceof Instantiatable)) {
            pp = (PrettyPrinter)((Instantiatable)pp).createInstance();
          }
          gen.setPrettyPrinter(pp);
        }
      }
      if (characterEscapes != null) {
        gen.setCharacterEscapes(characterEscapes);
      }
      if (schema != null) {
        gen.setSchema(schema);
      }
      if (rootValueSeparator != null) {
        gen.setRootValueSeparator(rootValueSeparator);
      }
    }
  }
  
  public static final class Prefetch
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public static final Prefetch empty = new Prefetch(null, null, null);
    private final JavaType rootType;
    private final JsonSerializer<Object> valueSerializer;
    private final TypeSerializer typeSerializer;
    
    private Prefetch(JavaType rootT, JsonSerializer<Object> ser, TypeSerializer typeSer)
    {
      rootType = rootT;
      valueSerializer = ser;
      typeSerializer = typeSer;
    }
    
    public Prefetch forRootType(ObjectWriter parent, JavaType newType)
    {
      boolean noType = (newType == null) || (newType.isJavaLangObject());
      if (noType)
      {
        if ((rootType == null) || (valueSerializer == null)) {
          return this;
        }
        return new Prefetch(null, null, typeSerializer);
      }
      if (newType.equals(rootType)) {
        return this;
      }
      if (parent.isEnabled(SerializationFeature.EAGER_SERIALIZER_FETCH))
      {
        DefaultSerializerProvider prov = parent._serializerProvider();
        try
        {
          JsonSerializer<Object> ser = prov.findTypedValueSerializer(newType, true, null);
          if ((ser instanceof TypeWrappedSerializer)) {
            return new Prefetch(newType, null, ((TypeWrappedSerializer)ser).typeSerializer());
          }
          return new Prefetch(newType, ser, null);
        }
        catch (JsonProcessingException e) {}
      }
      return new Prefetch(null, null, typeSerializer);
    }
    
    public final JsonSerializer<Object> getValueSerializer()
    {
      return valueSerializer;
    }
    
    public final TypeSerializer getTypeSerializer()
    {
      return typeSerializer;
    }
    
    public boolean hasSerializer()
    {
      return (valueSerializer != null) || (typeSerializer != null);
    }
    
    public void serialize(JsonGenerator gen, Object value, DefaultSerializerProvider prov)
      throws IOException
    {
      if (typeSerializer != null)
      {
        prov.serializePolymorphic(gen, value, rootType, valueSerializer, typeSerializer);
        return;
      }
      if (valueSerializer != null)
      {
        prov.serializeValue(gen, value, rootType, valueSerializer);
        return;
      }
      prov.serializeValue(gen, value);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */