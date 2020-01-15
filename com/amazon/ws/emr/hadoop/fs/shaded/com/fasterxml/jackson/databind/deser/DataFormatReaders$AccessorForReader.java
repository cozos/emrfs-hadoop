package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.InputAccessor.Std;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.MatchStrength;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectReader;
import java.io.InputStream;

public class DataFormatReaders$AccessorForReader
  extends InputAccessor.Std
{
  public DataFormatReaders$AccessorForReader(DataFormatReaders paramDataFormatReaders, InputStream in, byte[] buffer)
  {
    super(in, buffer);
  }
  
  public DataFormatReaders$AccessorForReader(DataFormatReaders paramDataFormatReaders, byte[] inputDocument)
  {
    super(inputDocument);
  }
  
  public DataFormatReaders$AccessorForReader(DataFormatReaders paramDataFormatReaders, byte[] inputDocument, int start, int len)
  {
    super(inputDocument, start, len);
  }
  
  public DataFormatReaders.Match createMatcher(ObjectReader match, MatchStrength matchStrength)
  {
    return new DataFormatReaders.Match(_in, _buffer, _bufferedStart, _bufferedEnd - _bufferedStart, match, matchStrength);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DataFormatReaders.AccessorForReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */