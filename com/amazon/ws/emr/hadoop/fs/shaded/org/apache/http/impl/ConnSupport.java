package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.ConnectionConfig;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

public final class ConnSupport
{
  public static CharsetDecoder createDecoder(ConnectionConfig cconfig)
  {
    if (cconfig == null) {
      return null;
    }
    Charset charset = cconfig.getCharset();
    CodingErrorAction malformed = cconfig.getMalformedInputAction();
    CodingErrorAction unmappable = cconfig.getUnmappableInputAction();
    if (charset != null) {
      return charset.newDecoder().onMalformedInput(malformed != null ? malformed : CodingErrorAction.REPORT).onUnmappableCharacter(unmappable != null ? unmappable : CodingErrorAction.REPORT);
    }
    return null;
  }
  
  public static CharsetEncoder createEncoder(ConnectionConfig cconfig)
  {
    if (cconfig == null) {
      return null;
    }
    Charset charset = cconfig.getCharset();
    if (charset != null)
    {
      CodingErrorAction malformed = cconfig.getMalformedInputAction();
      CodingErrorAction unmappable = cconfig.getUnmappableInputAction();
      return charset.newEncoder().onMalformedInput(malformed != null ? malformed : CodingErrorAction.REPORT).onUnmappableCharacter(unmappable != null ? unmappable : CodingErrorAction.REPORT);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.ConnSupport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */