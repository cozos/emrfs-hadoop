package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.InputAccessor.Std;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.MatchStrength;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.MergedStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class DataFormatReaders
{
  public static final int DEFAULT_MAX_INPUT_LOOKAHEAD = 64;
  protected final ObjectReader[] _readers;
  protected final MatchStrength _optimalMatch;
  protected final MatchStrength _minimalMatch;
  protected final int _maxInputLookahead;
  
  public DataFormatReaders(ObjectReader... detectors)
  {
    this(detectors, MatchStrength.SOLID_MATCH, MatchStrength.WEAK_MATCH, 64);
  }
  
  public DataFormatReaders(Collection<ObjectReader> detectors)
  {
    this((ObjectReader[])detectors.toArray(new ObjectReader[detectors.size()]));
  }
  
  private DataFormatReaders(ObjectReader[] detectors, MatchStrength optMatch, MatchStrength minMatch, int maxInputLookahead)
  {
    _readers = detectors;
    _optimalMatch = optMatch;
    _minimalMatch = minMatch;
    _maxInputLookahead = maxInputLookahead;
  }
  
  public DataFormatReaders withOptimalMatch(MatchStrength optMatch)
  {
    if (optMatch == _optimalMatch) {
      return this;
    }
    return new DataFormatReaders(_readers, optMatch, _minimalMatch, _maxInputLookahead);
  }
  
  public DataFormatReaders withMinimalMatch(MatchStrength minMatch)
  {
    if (minMatch == _minimalMatch) {
      return this;
    }
    return new DataFormatReaders(_readers, _optimalMatch, minMatch, _maxInputLookahead);
  }
  
  public DataFormatReaders with(ObjectReader[] readers)
  {
    return new DataFormatReaders(readers, _optimalMatch, _minimalMatch, _maxInputLookahead);
  }
  
  public DataFormatReaders withMaxInputLookahead(int lookaheadBytes)
  {
    if (lookaheadBytes == _maxInputLookahead) {
      return this;
    }
    return new DataFormatReaders(_readers, _optimalMatch, _minimalMatch, lookaheadBytes);
  }
  
  public DataFormatReaders with(DeserializationConfig config)
  {
    int len = _readers.length;
    ObjectReader[] r = new ObjectReader[len];
    for (int i = 0; i < len; i++) {
      r[i] = _readers[i].with(config);
    }
    return new DataFormatReaders(r, _optimalMatch, _minimalMatch, _maxInputLookahead);
  }
  
  public DataFormatReaders withType(JavaType type)
  {
    int len = _readers.length;
    ObjectReader[] r = new ObjectReader[len];
    for (int i = 0; i < len; i++) {
      r[i] = _readers[i].forType(type);
    }
    return new DataFormatReaders(r, _optimalMatch, _minimalMatch, _maxInputLookahead);
  }
  
  public Match findFormat(InputStream in)
    throws IOException
  {
    return _findFormat(new AccessorForReader(in, new byte[_maxInputLookahead]));
  }
  
  public Match findFormat(byte[] fullInputData)
    throws IOException
  {
    return _findFormat(new AccessorForReader(fullInputData));
  }
  
  public Match findFormat(byte[] fullInputData, int offset, int len)
    throws IOException
  {
    return _findFormat(new AccessorForReader(fullInputData, offset, len));
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    int len = _readers.length;
    if (len > 0)
    {
      sb.append(_readers[0].getFactory().getFormatName());
      for (int i = 1; i < len; i++)
      {
        sb.append(", ");
        sb.append(_readers[i].getFactory().getFormatName());
      }
    }
    sb.append(']');
    return sb.toString();
  }
  
  private Match _findFormat(AccessorForReader acc)
    throws IOException
  {
    ObjectReader bestMatch = null;
    MatchStrength bestMatchStrength = null;
    for (ObjectReader f : _readers)
    {
      acc.reset();
      MatchStrength strength = f.getFactory().hasFormat(acc);
      if ((strength != null) && (strength.ordinal() >= _minimalMatch.ordinal())) {
        if ((bestMatch == null) || 
          (bestMatchStrength.ordinal() < strength.ordinal()))
        {
          bestMatch = f;
          bestMatchStrength = strength;
          if (strength.ordinal() >= _optimalMatch.ordinal()) {
            break;
          }
        }
      }
    }
    return acc.createMatcher(bestMatch, bestMatchStrength);
  }
  
  protected class AccessorForReader
    extends InputAccessor.Std
  {
    public AccessorForReader(InputStream in, byte[] buffer)
    {
      super(buffer);
    }
    
    public AccessorForReader(byte[] inputDocument)
    {
      super();
    }
    
    public AccessorForReader(byte[] inputDocument, int start, int len)
    {
      super(start, len);
    }
    
    public DataFormatReaders.Match createMatcher(ObjectReader match, MatchStrength matchStrength)
    {
      return new DataFormatReaders.Match(_in, _buffer, _bufferedStart, _bufferedEnd - _bufferedStart, match, matchStrength);
    }
  }
  
  public static class Match
  {
    protected final InputStream _originalStream;
    protected final byte[] _bufferedData;
    protected final int _bufferedStart;
    protected final int _bufferedLength;
    protected final ObjectReader _match;
    protected final MatchStrength _matchStrength;
    
    protected Match(InputStream in, byte[] buffered, int bufferedStart, int bufferedLength, ObjectReader match, MatchStrength strength)
    {
      _originalStream = in;
      _bufferedData = buffered;
      _bufferedStart = bufferedStart;
      _bufferedLength = bufferedLength;
      _match = match;
      _matchStrength = strength;
    }
    
    public boolean hasMatch()
    {
      return _match != null;
    }
    
    public MatchStrength getMatchStrength()
    {
      return _matchStrength == null ? MatchStrength.INCONCLUSIVE : _matchStrength;
    }
    
    public ObjectReader getReader()
    {
      return _match;
    }
    
    public String getMatchedFormatName()
    {
      return _match.getFactory().getFormatName();
    }
    
    public JsonParser createParserWithMatch()
      throws IOException
    {
      if (_match == null) {
        return null;
      }
      JsonFactory jf = _match.getFactory();
      if (_originalStream == null) {
        return jf.createParser(_bufferedData, _bufferedStart, _bufferedLength);
      }
      return jf.createParser(getDataStream());
    }
    
    public InputStream getDataStream()
    {
      if (_originalStream == null) {
        return new ByteArrayInputStream(_bufferedData, _bufferedStart, _bufferedLength);
      }
      return new MergedStream(null, _originalStream, _bufferedData, _bufferedStart, _bufferedLength);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DataFormatReaders
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */