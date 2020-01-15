package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonEncoding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.InputAccessor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.MatchStrength;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.IOContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

public class CBORFactory
  extends JsonFactory
{
  private static final long serialVersionUID = 1L;
  public static final String FORMAT_NAME = "CBOR";
  static final int DEFAULT_CBOR_PARSER_FEATURE_FLAGS = ;
  static final int DEFAULT_CBOR_GENERATOR_FEATURE_FLAGS = CBORGenerator.Feature.collectDefaults();
  protected int _formatParserFeatures;
  protected int _formatGeneratorFeatures;
  
  public CBORFactory()
  {
    this(null);
  }
  
  public CBORFactory(ObjectCodec oc)
  {
    super(oc);
    _formatParserFeatures = DEFAULT_CBOR_PARSER_FEATURE_FLAGS;
    _formatGeneratorFeatures = DEFAULT_CBOR_GENERATOR_FEATURE_FLAGS;
  }
  
  public CBORFactory(CBORFactory src, ObjectCodec oc)
  {
    super(src, oc);
    _formatParserFeatures = _formatParserFeatures;
    _formatGeneratorFeatures = _formatGeneratorFeatures;
  }
  
  public CBORFactory copy()
  {
    _checkInvalidCopy(CBORFactory.class);
    
    return new CBORFactory(this, null);
  }
  
  protected Object readResolve()
  {
    return new CBORFactory(this, _objectCodec);
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  public String getFormatName()
  {
    return "CBOR";
  }
  
  public MatchStrength hasFormat(InputAccessor acc)
    throws IOException
  {
    return CBORParserBootstrapper.hasCBORFormat(acc);
  }
  
  public boolean canHandleBinaryNatively()
  {
    return true;
  }
  
  public Class<CBORParser.Feature> getFormatReadFeatureType()
  {
    return CBORParser.Feature.class;
  }
  
  public Class<CBORGenerator.Feature> getFormatWriteFeatureType()
  {
    return CBORGenerator.Feature.class;
  }
  
  public final CBORFactory configure(CBORParser.Feature f, boolean state)
  {
    if (state) {
      enable(f);
    } else {
      disable(f);
    }
    return this;
  }
  
  public CBORFactory enable(CBORParser.Feature f)
  {
    _formatParserFeatures |= f.getMask();
    return this;
  }
  
  public CBORFactory disable(CBORParser.Feature f)
  {
    _formatParserFeatures &= (f.getMask() ^ 0xFFFFFFFF);
    return this;
  }
  
  public final boolean isEnabled(CBORParser.Feature f)
  {
    return (_formatParserFeatures & f.getMask()) != 0;
  }
  
  public final CBORFactory configure(CBORGenerator.Feature f, boolean state)
  {
    if (state) {
      enable(f);
    } else {
      disable(f);
    }
    return this;
  }
  
  public CBORFactory enable(CBORGenerator.Feature f)
  {
    _formatGeneratorFeatures |= f.getMask();
    return this;
  }
  
  public CBORFactory disable(CBORGenerator.Feature f)
  {
    _formatGeneratorFeatures &= (f.getMask() ^ 0xFFFFFFFF);
    return this;
  }
  
  public final boolean isEnabled(CBORGenerator.Feature f)
  {
    return (_formatGeneratorFeatures & f.getMask()) != 0;
  }
  
  public CBORParser createParser(File f)
    throws IOException
  {
    return _createParser(new FileInputStream(f), _createContext(f, true));
  }
  
  public CBORParser createParser(URL url)
    throws IOException
  {
    return _createParser(_optimizedStreamFromURL(url), _createContext(url, true));
  }
  
  public CBORParser createParser(InputStream in)
    throws IOException
  {
    return _createParser(in, _createContext(in, false));
  }
  
  public CBORParser createParser(byte[] data)
    throws IOException
  {
    return _createParser(data, 0, data.length, _createContext(data, true));
  }
  
  public CBORParser createParser(byte[] data, int offset, int len)
    throws IOException
  {
    return _createParser(data, offset, len, _createContext(data, true));
  }
  
  public CBORGenerator createGenerator(OutputStream out, JsonEncoding enc)
    throws IOException
  {
    return _createCBORGenerator(_createContext(out, false), _generatorFeatures, _formatGeneratorFeatures, _objectCodec, out);
  }
  
  public CBORGenerator createGenerator(OutputStream out)
    throws IOException
  {
    return _createCBORGenerator(_createContext(out, false), _generatorFeatures, _formatGeneratorFeatures, _objectCodec, out);
  }
  
  protected IOContext _createContext(Object srcRef, boolean resourceManaged)
  {
    return super._createContext(srcRef, resourceManaged);
  }
  
  protected CBORParser _createParser(InputStream in, IOContext ctxt)
    throws IOException
  {
    return new CBORParserBootstrapper(ctxt, in).constructParser(_factoryFeatures, _parserFeatures, _formatParserFeatures, _objectCodec, _byteSymbolCanonicalizer);
  }
  
  protected JsonParser _createParser(Reader r, IOContext ctxt)
    throws IOException
  {
    return (JsonParser)_nonByteSource();
  }
  
  protected JsonParser _createParser(char[] data, int offset, int len, IOContext ctxt, boolean recyclable)
    throws IOException
  {
    return (JsonParser)_nonByteSource();
  }
  
  protected CBORParser _createParser(byte[] data, int offset, int len, IOContext ctxt)
    throws IOException
  {
    return new CBORParserBootstrapper(ctxt, data, offset, len).constructParser(_factoryFeatures, _parserFeatures, _formatParserFeatures, _objectCodec, _byteSymbolCanonicalizer);
  }
  
  protected CBORGenerator _createGenerator(Writer out, IOContext ctxt)
    throws IOException
  {
    return (CBORGenerator)_nonByteTarget();
  }
  
  protected CBORGenerator _createUTF8Generator(OutputStream out, IOContext ctxt)
    throws IOException
  {
    return _createCBORGenerator(ctxt, _generatorFeatures, _formatGeneratorFeatures, _objectCodec, out);
  }
  
  protected Writer _createWriter(OutputStream out, JsonEncoding enc, IOContext ctxt)
    throws IOException
  {
    return (Writer)_nonByteTarget();
  }
  
  private final CBORGenerator _createCBORGenerator(IOContext ctxt, int stdFeat, int formatFeat, ObjectCodec codec, OutputStream out)
    throws IOException
  {
    CBORGenerator gen = new CBORGenerator(ctxt, stdFeat, formatFeat, _objectCodec, out);
    if (CBORGenerator.Feature.WRITE_TYPE_HEADER.enabledIn(formatFeat)) {
      gen.writeTag(55799);
    }
    return gen;
  }
  
  protected <T> T _nonByteTarget()
  {
    throw new UnsupportedOperationException("Can not create generator for non-byte-based target");
  }
  
  protected <T> T _nonByteSource()
  {
    throw new UnsupportedOperationException("Can not create generator for non-byte-based source");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor.CBORFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */