package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.base.GeneratorBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharacterEscapes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.IOContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

public abstract class JsonGeneratorImpl
  extends GeneratorBase
{
  protected static final int[] sOutputEscapes = ;
  protected final IOContext _ioContext;
  protected int[] _outputEscapes = sOutputEscapes;
  protected int _maximumNonEscapedChar;
  protected CharacterEscapes _characterEscapes;
  protected SerializableString _rootValueSeparator = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
  
  public JsonGeneratorImpl(IOContext ctxt, int features, ObjectCodec codec)
  {
    super(features, codec);
    _ioContext = ctxt;
    if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
      setHighestNonEscapedChar(127);
    }
  }
  
  public JsonGenerator setHighestNonEscapedChar(int charCode)
  {
    _maximumNonEscapedChar = (charCode < 0 ? 0 : charCode);
    return this;
  }
  
  public int getHighestEscapedChar()
  {
    return _maximumNonEscapedChar;
  }
  
  public JsonGenerator setCharacterEscapes(CharacterEscapes esc)
  {
    _characterEscapes = esc;
    if (esc == null) {
      _outputEscapes = sOutputEscapes;
    } else {
      _outputEscapes = esc.getEscapeCodesForAscii();
    }
    return this;
  }
  
  public CharacterEscapes getCharacterEscapes()
  {
    return _characterEscapes;
  }
  
  public JsonGenerator setRootValueSeparator(SerializableString sep)
  {
    _rootValueSeparator = sep;
    return this;
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public final void writeStringField(String fieldName, String value)
    throws IOException
  {
    writeFieldName(fieldName);
    writeString(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.JsonGeneratorImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */