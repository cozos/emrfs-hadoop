package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class SerializedString
  implements SerializableString, Serializable
{
  protected final String _value;
  protected byte[] _quotedUTF8Ref;
  protected byte[] _unquotedUTF8Ref;
  protected char[] _quotedChars;
  protected transient String _jdkSerializeValue;
  
  public SerializedString(String v)
  {
    if (v == null) {
      throw new IllegalStateException("Null String illegal for SerializedString");
    }
    _value = v;
  }
  
  private void readObject(ObjectInputStream in)
    throws IOException
  {
    _jdkSerializeValue = in.readUTF();
  }
  
  private void writeObject(ObjectOutputStream out)
    throws IOException
  {
    out.writeUTF(_value);
  }
  
  protected Object readResolve()
  {
    return new SerializedString(_jdkSerializeValue);
  }
  
  public final String getValue()
  {
    return _value;
  }
  
  public final int charLength()
  {
    return _value.length();
  }
  
  public final char[] asQuotedChars()
  {
    char[] result = _quotedChars;
    if (result == null)
    {
      result = JsonStringEncoder.getInstance().quoteAsString(_value);
      _quotedChars = result;
    }
    return result;
  }
  
  public final byte[] asUnquotedUTF8()
  {
    byte[] result = _unquotedUTF8Ref;
    if (result == null)
    {
      result = JsonStringEncoder.getInstance().encodeAsUTF8(_value);
      _unquotedUTF8Ref = result;
    }
    return result;
  }
  
  public final byte[] asQuotedUTF8()
  {
    byte[] result = _quotedUTF8Ref;
    if (result == null)
    {
      result = JsonStringEncoder.getInstance().quoteAsUTF8(_value);
      _quotedUTF8Ref = result;
    }
    return result;
  }
  
  public int appendQuotedUTF8(byte[] buffer, int offset)
  {
    byte[] result = _quotedUTF8Ref;
    if (result == null)
    {
      result = JsonStringEncoder.getInstance().quoteAsUTF8(_value);
      _quotedUTF8Ref = result;
    }
    int length = result.length;
    if (offset + length > buffer.length) {
      return -1;
    }
    System.arraycopy(result, 0, buffer, offset, length);
    return length;
  }
  
  public int appendQuoted(char[] buffer, int offset)
  {
    char[] result = _quotedChars;
    if (result == null)
    {
      result = JsonStringEncoder.getInstance().quoteAsString(_value);
      _quotedChars = result;
    }
    int length = result.length;
    if (offset + length > buffer.length) {
      return -1;
    }
    System.arraycopy(result, 0, buffer, offset, length);
    return length;
  }
  
  public int appendUnquotedUTF8(byte[] buffer, int offset)
  {
    byte[] result = _unquotedUTF8Ref;
    if (result == null)
    {
      result = JsonStringEncoder.getInstance().encodeAsUTF8(_value);
      _unquotedUTF8Ref = result;
    }
    int length = result.length;
    if (offset + length > buffer.length) {
      return -1;
    }
    System.arraycopy(result, 0, buffer, offset, length);
    return length;
  }
  
  public int appendUnquoted(char[] buffer, int offset)
  {
    String str = _value;
    int length = str.length();
    if (offset + length > buffer.length) {
      return -1;
    }
    str.getChars(0, length, buffer, offset);
    return length;
  }
  
  public int writeQuotedUTF8(OutputStream out)
    throws IOException
  {
    byte[] result = _quotedUTF8Ref;
    if (result == null)
    {
      result = JsonStringEncoder.getInstance().quoteAsUTF8(_value);
      _quotedUTF8Ref = result;
    }
    int length = result.length;
    out.write(result, 0, length);
    return length;
  }
  
  public int writeUnquotedUTF8(OutputStream out)
    throws IOException
  {
    byte[] result = _unquotedUTF8Ref;
    if (result == null)
    {
      result = JsonStringEncoder.getInstance().encodeAsUTF8(_value);
      _unquotedUTF8Ref = result;
    }
    int length = result.length;
    out.write(result, 0, length);
    return length;
  }
  
  public int putQuotedUTF8(ByteBuffer buffer)
  {
    byte[] result = _quotedUTF8Ref;
    if (result == null)
    {
      result = JsonStringEncoder.getInstance().quoteAsUTF8(_value);
      _quotedUTF8Ref = result;
    }
    int length = result.length;
    if (length > buffer.remaining()) {
      return -1;
    }
    buffer.put(result, 0, length);
    return length;
  }
  
  public int putUnquotedUTF8(ByteBuffer buffer)
  {
    byte[] result = _unquotedUTF8Ref;
    if (result == null)
    {
      result = JsonStringEncoder.getInstance().encodeAsUTF8(_value);
      _unquotedUTF8Ref = result;
    }
    int length = result.length;
    if (length > buffer.remaining()) {
      return -1;
    }
    buffer.put(result, 0, length);
    return length;
  }
  
  public final String toString()
  {
    return _value;
  }
  
  public final int hashCode()
  {
    return _value.hashCode();
  }
  
  public final boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if ((o == null) || (o.getClass() != getClass())) {
      return false;
    }
    SerializedString other = (SerializedString)o;
    return _value.equals(_value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.SerializedString
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */