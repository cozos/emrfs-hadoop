package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.net;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.Charsets;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.DecoderException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.EncoderException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.StringDecoder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.StringEncoder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class BCodec
  extends RFC1522Codec
  implements StringEncoder, StringDecoder
{
  private final Charset charset;
  
  public BCodec()
  {
    this(Charsets.UTF_8);
  }
  
  public BCodec(Charset charset)
  {
    this.charset = charset;
  }
  
  public BCodec(String charsetName)
  {
    this(Charset.forName(charsetName));
  }
  
  protected String getEncoding()
  {
    return "B";
  }
  
  protected byte[] doEncoding(byte[] bytes)
  {
    if (bytes == null) {
      return null;
    }
    return Base64.encodeBase64(bytes);
  }
  
  protected byte[] doDecoding(byte[] bytes)
  {
    if (bytes == null) {
      return null;
    }
    return Base64.decodeBase64(bytes);
  }
  
  public String encode(String value, Charset charset)
    throws EncoderException
  {
    if (value == null) {
      return null;
    }
    return encodeText(value, charset);
  }
  
  public String encode(String value, String charset)
    throws EncoderException
  {
    if (value == null) {
      return null;
    }
    try
    {
      return encodeText(value, charset);
    }
    catch (UnsupportedEncodingException e)
    {
      throw new EncoderException(e.getMessage(), e);
    }
  }
  
  public String encode(String value)
    throws EncoderException
  {
    if (value == null) {
      return null;
    }
    return encode(value, getCharset());
  }
  
  public String decode(String value)
    throws DecoderException
  {
    if (value == null) {
      return null;
    }
    try
    {
      return decodeText(value);
    }
    catch (UnsupportedEncodingException e)
    {
      throw new DecoderException(e.getMessage(), e);
    }
  }
  
  public Object encode(Object value)
    throws EncoderException
  {
    if (value == null) {
      return null;
    }
    if ((value instanceof String)) {
      return encode((String)value);
    }
    throw new EncoderException("Objects of type " + value.getClass().getName() + " cannot be encoded using BCodec");
  }
  
  public Object decode(Object value)
    throws DecoderException
  {
    if (value == null) {
      return null;
    }
    if ((value instanceof String)) {
      return decode((String)value);
    }
    throw new DecoderException("Objects of type " + value.getClass().getName() + " cannot be decoded using BCodec");
  }
  
  public Charset getCharset()
  {
    return charset;
  }
  
  public String getDefaultCharset()
  {
    return charset.name();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.net.BCodec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */