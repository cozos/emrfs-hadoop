package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.PrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.TreeNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.DupDetector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.JsonWriteContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;
import java.io.InputStream;

public abstract class GeneratorBase
  extends JsonGenerator
{
  public static final int SURR1_FIRST = 55296;
  public static final int SURR1_LAST = 56319;
  public static final int SURR2_FIRST = 56320;
  public static final int SURR2_LAST = 57343;
  protected static final int DERIVED_FEATURES_MASK = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.getMask() | JsonGenerator.Feature.ESCAPE_NON_ASCII.getMask() | JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.getMask();
  protected final String WRITE_BINARY = "write a binary value";
  protected final String WRITE_BOOLEAN = "write a boolean value";
  protected final String WRITE_NULL = "write a null";
  protected final String WRITE_NUMBER = "write a number";
  protected final String WRITE_RAW = "write a raw (unencoded) value";
  protected final String WRITE_STRING = "write a string";
  protected ObjectCodec _objectCodec;
  protected int _features;
  protected boolean _cfgNumbersAsStrings;
  protected JsonWriteContext _writeContext;
  protected boolean _closed;
  
  protected GeneratorBase(int features, ObjectCodec codec)
  {
    _features = features;
    _objectCodec = codec;
    DupDetector dups = JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(features) ? DupDetector.rootDetector(this) : null;
    
    _writeContext = JsonWriteContext.createRootContext(dups);
    _cfgNumbersAsStrings = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(features);
  }
  
  protected GeneratorBase(int features, ObjectCodec codec, JsonWriteContext ctxt)
  {
    _features = features;
    _objectCodec = codec;
    _writeContext = ctxt;
    _cfgNumbersAsStrings = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(features);
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public Object getCurrentValue()
  {
    return _writeContext.getCurrentValue();
  }
  
  public void setCurrentValue(Object v)
  {
    _writeContext.setCurrentValue(v);
  }
  
  public final boolean isEnabled(JsonGenerator.Feature f)
  {
    return (_features & f.getMask()) != 0;
  }
  
  public int getFeatureMask()
  {
    return _features;
  }
  
  public JsonGenerator enable(JsonGenerator.Feature f)
  {
    int mask = f.getMask();
    _features |= mask;
    if ((mask & DERIVED_FEATURES_MASK) != 0) {
      if (f == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS) {
        _cfgNumbersAsStrings = true;
      } else if (f == JsonGenerator.Feature.ESCAPE_NON_ASCII) {
        setHighestNonEscapedChar(127);
      } else if ((f == JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION) && 
        (_writeContext.getDupDetector() == null)) {
        _writeContext = _writeContext.withDupDetector(DupDetector.rootDetector(this));
      }
    }
    return this;
  }
  
  public JsonGenerator disable(JsonGenerator.Feature f)
  {
    int mask = f.getMask();
    _features &= (mask ^ 0xFFFFFFFF);
    if ((mask & DERIVED_FEATURES_MASK) != 0) {
      if (f == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS) {
        _cfgNumbersAsStrings = false;
      } else if (f == JsonGenerator.Feature.ESCAPE_NON_ASCII) {
        setHighestNonEscapedChar(0);
      } else if (f == JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION) {
        _writeContext = _writeContext.withDupDetector(null);
      }
    }
    return this;
  }
  
  public JsonGenerator setFeatureMask(int newMask)
  {
    int changed = newMask ^ _features;
    _features = newMask;
    if ((changed & DERIVED_FEATURES_MASK) != 0)
    {
      _cfgNumbersAsStrings = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(newMask);
      if (JsonGenerator.Feature.ESCAPE_NON_ASCII.enabledIn(changed)) {
        if (JsonGenerator.Feature.ESCAPE_NON_ASCII.enabledIn(newMask)) {
          setHighestNonEscapedChar(127);
        } else {
          setHighestNonEscapedChar(0);
        }
      }
      if (JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(changed)) {
        if (JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(newMask))
        {
          if (_writeContext.getDupDetector() == null) {
            _writeContext = _writeContext.withDupDetector(DupDetector.rootDetector(this));
          }
        }
        else {
          _writeContext = _writeContext.withDupDetector(null);
        }
      }
    }
    return this;
  }
  
  public JsonGenerator useDefaultPrettyPrinter()
  {
    if (getPrettyPrinter() != null) {
      return this;
    }
    return setPrettyPrinter(_constructDefaultPrettyPrinter());
  }
  
  public JsonGenerator setCodec(ObjectCodec oc)
  {
    _objectCodec = oc;
    return this;
  }
  
  public final ObjectCodec getCodec()
  {
    return _objectCodec;
  }
  
  public final JsonWriteContext getOutputContext()
  {
    return _writeContext;
  }
  
  public void writeFieldName(SerializableString name)
    throws IOException
  {
    writeFieldName(name.getValue());
  }
  
  public void writeString(SerializableString text)
    throws IOException
  {
    writeString(text.getValue());
  }
  
  public void writeRawValue(String text)
    throws IOException
  {
    _verifyValueWrite("write raw value");
    writeRaw(text);
  }
  
  public void writeRawValue(String text, int offset, int len)
    throws IOException
  {
    _verifyValueWrite("write raw value");
    writeRaw(text, offset, len);
  }
  
  public void writeRawValue(char[] text, int offset, int len)
    throws IOException
  {
    _verifyValueWrite("write raw value");
    writeRaw(text, offset, len);
  }
  
  public void writeRawValue(SerializableString text)
    throws IOException
  {
    _verifyValueWrite("write raw value");
    writeRaw(text);
  }
  
  public int writeBinary(Base64Variant b64variant, InputStream data, int dataLength)
    throws IOException
  {
    _reportUnsupportedOperation();
    return 0;
  }
  
  public void writeObject(Object value)
    throws IOException
  {
    if (value == null)
    {
      writeNull();
    }
    else
    {
      if (_objectCodec != null)
      {
        _objectCodec.writeValue(this, value);
        return;
      }
      _writeSimpleObject(value);
    }
  }
  
  public void writeTree(TreeNode rootNode)
    throws IOException
  {
    if (rootNode == null)
    {
      writeNull();
    }
    else
    {
      if (_objectCodec == null) {
        throw new IllegalStateException("No ObjectCodec defined");
      }
      _objectCodec.writeValue(this, rootNode);
    }
  }
  
  public abstract void flush()
    throws IOException;
  
  public void close()
    throws IOException
  {
    _closed = true;
  }
  
  public boolean isClosed()
  {
    return _closed;
  }
  
  protected abstract void _releaseBuffers();
  
  protected abstract void _verifyValueWrite(String paramString)
    throws IOException;
  
  protected PrettyPrinter _constructDefaultPrettyPrinter()
  {
    return new DefaultPrettyPrinter();
  }
  
  protected final int _decodeSurrogate(int surr1, int surr2)
    throws IOException
  {
    if ((surr2 < 56320) || (surr2 > 57343))
    {
      String msg = "Incomplete surrogate pair: first char 0x" + Integer.toHexString(surr1) + ", second 0x" + Integer.toHexString(surr2);
      _reportError(msg);
    }
    int c = 65536 + (surr1 - 55296 << 10) + (surr2 - 56320);
    return c;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.base.GeneratorBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */