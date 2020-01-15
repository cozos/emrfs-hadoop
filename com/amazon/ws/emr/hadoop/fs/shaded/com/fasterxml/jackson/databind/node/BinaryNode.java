package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variants;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Arrays;

public class BinaryNode
  extends ValueNode
{
  static final BinaryNode EMPTY_BINARY_NODE = new BinaryNode(new byte[0]);
  protected final byte[] _data;
  
  public BinaryNode(byte[] data)
  {
    _data = data;
  }
  
  public BinaryNode(byte[] data, int offset, int length)
  {
    if ((offset == 0) && (length == data.length))
    {
      _data = data;
    }
    else
    {
      _data = new byte[length];
      System.arraycopy(data, offset, _data, 0, length);
    }
  }
  
  public static BinaryNode valueOf(byte[] data)
  {
    if (data == null) {
      return null;
    }
    if (data.length == 0) {
      return EMPTY_BINARY_NODE;
    }
    return new BinaryNode(data);
  }
  
  public static BinaryNode valueOf(byte[] data, int offset, int length)
  {
    if (data == null) {
      return null;
    }
    if (length == 0) {
      return EMPTY_BINARY_NODE;
    }
    return new BinaryNode(data, offset, length);
  }
  
  public JsonNodeType getNodeType()
  {
    return JsonNodeType.BINARY;
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_EMBEDDED_OBJECT;
  }
  
  public byte[] binaryValue()
  {
    return _data;
  }
  
  public String asText()
  {
    return Base64Variants.getDefaultVariant().encode(_data, false);
  }
  
  public final void serialize(JsonGenerator jg, SerializerProvider provider)
    throws IOException, JsonProcessingException
  {
    jg.writeBinary(provider.getConfig().getBase64Variant(), _data, 0, _data.length);
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (!(o instanceof BinaryNode)) {
      return false;
    }
    return Arrays.equals(_data, _data);
  }
  
  public int hashCode()
  {
    return _data == null ? -1 : _data.length;
  }
  
  public String toString()
  {
    return Base64Variants.getDefaultVariant().encode(_data, true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.BinaryNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */