package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonPointer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.TreeNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.JsonNodeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.MissingNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.EmptyIterator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class JsonNode
  extends JsonSerializable.Base
  implements TreeNode, Iterable<JsonNode>
{
  public abstract <T extends JsonNode> T deepCopy();
  
  public int size()
  {
    return 0;
  }
  
  public final boolean isValueNode()
  {
    switch (getNodeType())
    {
    case ARRAY: 
    case OBJECT: 
    case MISSING: 
      return false;
    }
    return true;
  }
  
  public final boolean isContainerNode()
  {
    JsonNodeType type = getNodeType();
    return (type == JsonNodeType.OBJECT) || (type == JsonNodeType.ARRAY);
  }
  
  public final boolean isMissingNode()
  {
    return getNodeType() == JsonNodeType.MISSING;
  }
  
  public final boolean isArray()
  {
    return getNodeType() == JsonNodeType.ARRAY;
  }
  
  public final boolean isObject()
  {
    return getNodeType() == JsonNodeType.OBJECT;
  }
  
  public abstract JsonNode get(int paramInt);
  
  public JsonNode get(String fieldName)
  {
    return null;
  }
  
  public abstract JsonNode path(String paramString);
  
  public abstract JsonNode path(int paramInt);
  
  public Iterator<String> fieldNames()
  {
    return EmptyIterator.instance();
  }
  
  public final JsonNode at(JsonPointer ptr)
  {
    if (ptr.matches()) {
      return this;
    }
    JsonNode n = _at(ptr);
    if (n == null) {
      return MissingNode.getInstance();
    }
    return n.at(ptr.tail());
  }
  
  public final JsonNode at(String jsonPtrExpr)
  {
    return at(JsonPointer.compile(jsonPtrExpr));
  }
  
  protected abstract JsonNode _at(JsonPointer paramJsonPointer);
  
  public abstract JsonNodeType getNodeType();
  
  public final boolean isPojo()
  {
    return getNodeType() == JsonNodeType.POJO;
  }
  
  public final boolean isNumber()
  {
    return getNodeType() == JsonNodeType.NUMBER;
  }
  
  public boolean isIntegralNumber()
  {
    return false;
  }
  
  public boolean isFloatingPointNumber()
  {
    return false;
  }
  
  public boolean isShort()
  {
    return false;
  }
  
  public boolean isInt()
  {
    return false;
  }
  
  public boolean isLong()
  {
    return false;
  }
  
  public boolean isFloat()
  {
    return false;
  }
  
  public boolean isDouble()
  {
    return false;
  }
  
  public boolean isBigDecimal()
  {
    return false;
  }
  
  public boolean isBigInteger()
  {
    return false;
  }
  
  public final boolean isTextual()
  {
    return getNodeType() == JsonNodeType.STRING;
  }
  
  public final boolean isBoolean()
  {
    return getNodeType() == JsonNodeType.BOOLEAN;
  }
  
  public final boolean isNull()
  {
    return getNodeType() == JsonNodeType.NULL;
  }
  
  public final boolean isBinary()
  {
    return getNodeType() == JsonNodeType.BINARY;
  }
  
  public boolean canConvertToInt()
  {
    return false;
  }
  
  public boolean canConvertToLong()
  {
    return false;
  }
  
  public String textValue()
  {
    return null;
  }
  
  public byte[] binaryValue()
    throws IOException
  {
    return null;
  }
  
  public boolean booleanValue()
  {
    return false;
  }
  
  public Number numberValue()
  {
    return null;
  }
  
  public short shortValue()
  {
    return 0;
  }
  
  public int intValue()
  {
    return 0;
  }
  
  public long longValue()
  {
    return 0L;
  }
  
  public float floatValue()
  {
    return 0.0F;
  }
  
  public double doubleValue()
  {
    return 0.0D;
  }
  
  public BigDecimal decimalValue()
  {
    return BigDecimal.ZERO;
  }
  
  public BigInteger bigIntegerValue()
  {
    return BigInteger.ZERO;
  }
  
  public abstract String asText();
  
  public String asText(String defaultValue)
  {
    String str = asText();
    return str == null ? defaultValue : str;
  }
  
  public int asInt()
  {
    return asInt(0);
  }
  
  public int asInt(int defaultValue)
  {
    return defaultValue;
  }
  
  public long asLong()
  {
    return asLong(0L);
  }
  
  public long asLong(long defaultValue)
  {
    return defaultValue;
  }
  
  public double asDouble()
  {
    return asDouble(0.0D);
  }
  
  public double asDouble(double defaultValue)
  {
    return defaultValue;
  }
  
  public boolean asBoolean()
  {
    return asBoolean(false);
  }
  
  public boolean asBoolean(boolean defaultValue)
  {
    return defaultValue;
  }
  
  public boolean has(String fieldName)
  {
    return get(fieldName) != null;
  }
  
  public boolean has(int index)
  {
    return get(index) != null;
  }
  
  public boolean hasNonNull(String fieldName)
  {
    JsonNode n = get(fieldName);
    return (n != null) && (!n.isNull());
  }
  
  public boolean hasNonNull(int index)
  {
    JsonNode n = get(index);
    return (n != null) && (!n.isNull());
  }
  
  public final Iterator<JsonNode> iterator()
  {
    return elements();
  }
  
  public Iterator<JsonNode> elements()
  {
    return EmptyIterator.instance();
  }
  
  public Iterator<Map.Entry<String, JsonNode>> fields()
  {
    return EmptyIterator.instance();
  }
  
  public abstract JsonNode findValue(String paramString);
  
  public final List<JsonNode> findValues(String fieldName)
  {
    List<JsonNode> result = findValues(fieldName, null);
    if (result == null) {
      return Collections.emptyList();
    }
    return result;
  }
  
  public final List<String> findValuesAsText(String fieldName)
  {
    List<String> result = findValuesAsText(fieldName, null);
    if (result == null) {
      return Collections.emptyList();
    }
    return result;
  }
  
  public abstract JsonNode findPath(String paramString);
  
  public abstract JsonNode findParent(String paramString);
  
  public final List<JsonNode> findParents(String fieldName)
  {
    List<JsonNode> result = findParents(fieldName, null);
    if (result == null) {
      return Collections.emptyList();
    }
    return result;
  }
  
  public abstract List<JsonNode> findValues(String paramString, List<JsonNode> paramList);
  
  public abstract List<String> findValuesAsText(String paramString, List<String> paramList);
  
  public abstract List<JsonNode> findParents(String paramString, List<JsonNode> paramList);
  
  public JsonNode with(String propertyName)
  {
    throw new UnsupportedOperationException("JsonNode not of type ObjectNode (but " + getClass().getName() + "), can not call with() on it");
  }
  
  public JsonNode withArray(String propertyName)
  {
    throw new UnsupportedOperationException("JsonNode not of type ObjectNode (but " + getClass().getName() + "), can not call withArray() on it");
  }
  
  public boolean equals(Comparator<JsonNode> comparator, JsonNode other)
  {
    return comparator.compare(this, other) == 0;
  }
  
  public abstract String toString();
  
  public abstract boolean equals(Object paramObject);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */