package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.MatchStrength;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.MergedStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataFormatReaders$Match
{
  protected final InputStream _originalStream;
  protected final byte[] _bufferedData;
  protected final int _bufferedStart;
  protected final int _bufferedLength;
  protected final ObjectReader _match;
  protected final MatchStrength _matchStrength;
  
  protected DataFormatReaders$Match(InputStream in, byte[] buffered, int bufferedStart, int bufferedLength, ObjectReader match, MatchStrength strength)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DataFormatReaders.Match
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */