package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class DataFormatDetector
{
  public static final int DEFAULT_MAX_INPUT_LOOKAHEAD = 64;
  protected final JsonFactory[] _detectors;
  protected final MatchStrength _optimalMatch;
  protected final MatchStrength _minimalMatch;
  protected final int _maxInputLookahead;
  
  public DataFormatDetector(JsonFactory... detectors)
  {
    this(detectors, MatchStrength.SOLID_MATCH, MatchStrength.WEAK_MATCH, 64);
  }
  
  public DataFormatDetector(Collection<JsonFactory> detectors)
  {
    this((JsonFactory[])detectors.toArray(new JsonFactory[detectors.size()]));
  }
  
  public DataFormatDetector withOptimalMatch(MatchStrength optMatch)
  {
    if (optMatch == _optimalMatch) {
      return this;
    }
    return new DataFormatDetector(_detectors, optMatch, _minimalMatch, _maxInputLookahead);
  }
  
  public DataFormatDetector withMinimalMatch(MatchStrength minMatch)
  {
    if (minMatch == _minimalMatch) {
      return this;
    }
    return new DataFormatDetector(_detectors, _optimalMatch, minMatch, _maxInputLookahead);
  }
  
  public DataFormatDetector withMaxInputLookahead(int lookaheadBytes)
  {
    if (lookaheadBytes == _maxInputLookahead) {
      return this;
    }
    return new DataFormatDetector(_detectors, _optimalMatch, _minimalMatch, lookaheadBytes);
  }
  
  private DataFormatDetector(JsonFactory[] detectors, MatchStrength optMatch, MatchStrength minMatch, int maxInputLookahead)
  {
    _detectors = detectors;
    _optimalMatch = optMatch;
    _minimalMatch = minMatch;
    _maxInputLookahead = maxInputLookahead;
  }
  
  public DataFormatMatcher findFormat(InputStream in)
    throws IOException
  {
    return _findFormat(new InputAccessor.Std(in, new byte[_maxInputLookahead]));
  }
  
  public DataFormatMatcher findFormat(byte[] fullInputData)
    throws IOException
  {
    return _findFormat(new InputAccessor.Std(fullInputData));
  }
  
  public DataFormatMatcher findFormat(byte[] fullInputData, int offset, int len)
    throws IOException
  {
    return _findFormat(new InputAccessor.Std(fullInputData, offset, len));
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    int len = _detectors.length;
    if (len > 0)
    {
      sb.append(_detectors[0].getFormatName());
      for (int i = 1; i < len; i++)
      {
        sb.append(", ");
        sb.append(_detectors[i].getFormatName());
      }
    }
    sb.append(']');
    return sb.toString();
  }
  
  private DataFormatMatcher _findFormat(InputAccessor.Std acc)
    throws IOException
  {
    JsonFactory bestMatch = null;
    MatchStrength bestMatchStrength = null;
    for (JsonFactory f : _detectors)
    {
      acc.reset();
      MatchStrength strength = f.hasFormat(acc);
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.DataFormatDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */