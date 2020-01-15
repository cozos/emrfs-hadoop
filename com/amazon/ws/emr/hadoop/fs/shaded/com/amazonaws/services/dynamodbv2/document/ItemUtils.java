package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.Filter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ItemUtils
{
  public static Item toItem(Map<String, AttributeValue> item)
  {
    if (item == null) {
      return null;
    }
    return Item.fromMap(toSimpleMapValue(item));
  }
  
  public static List<Item> toItemList(List<Map<String, AttributeValue>> items)
  {
    if (items == null) {
      return Collections.emptyList();
    }
    List<Item> result = new ArrayList(items.size());
    for (Map<String, AttributeValue> item : items) {
      result.add(toItem(item));
    }
    return result;
  }
  
  public static Map<String, AttributeValue> toAttributeValues(Item item)
  {
    if (item == null) {
      return null;
    }
    Map<String, AttributeValue> result = new LinkedHashMap();
    for (Map.Entry<String, Object> entry : item.attributes()) {
      result.put(entry.getKey(), toAttributeValue(entry.getValue()));
    }
    return result;
  }
  
  public static Map<String, AttributeValue> fromSimpleMap(Map<String, Object> map)
  {
    if (map == null) {
      return null;
    }
    Map<String, AttributeValue> result = new LinkedHashMap();
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      result.put(entry.getKey(), toAttributeValue(entry.getValue()));
    }
    return result;
  }
  
  public static Map<String, AttributeValueUpdate> toAttributeValueUpdate(List<AttributeUpdate> attributesToUpdate)
  {
    if (attributesToUpdate == null) {
      return null;
    }
    Map<String, AttributeValueUpdate> result = new LinkedHashMap();
    for (AttributeUpdate attribute : attributesToUpdate)
    {
      AttributeValueUpdate attributeToUpdate = new AttributeValueUpdate().withAction(attribute.getAction());
      if (attribute.getValue() != null) {
        attributeToUpdate.withValue(toAttributeValue(attribute
          .getValue()));
      } else if (attribute.getAttributeValues() != null) {
        attributeToUpdate.withValue(toAttributeValue(attribute
          .getAttributeValues()));
      }
      result.put(attribute.getAttributeName(), attributeToUpdate);
    }
    return result;
  }
  
  public static AttributeValue toAttributeValue(Object value)
  {
    AttributeValue result = new AttributeValue();
    if (value == null) {
      return result.withNULL(Boolean.TRUE);
    }
    if ((value instanceof Boolean)) {
      return result.withBOOL((Boolean)value);
    }
    if ((value instanceof String)) {
      return result.withS((String)value);
    }
    if ((value instanceof BigDecimal))
    {
      BigDecimal bd = (BigDecimal)value;
      return result.withN(bd.toPlainString());
    }
    if ((value instanceof Number)) {
      return result.withN(value.toString());
    }
    if ((value instanceof byte[])) {
      return result.withB(ByteBuffer.wrap((byte[])value));
    }
    if ((value instanceof ByteBuffer)) {
      return result.withB((ByteBuffer)value);
    }
    Set<ByteBuffer> bs;
    if ((value instanceof Set))
    {
      Set<Object> set = (Set)value;
      if (set.size() == 0)
      {
        result.setSS(new LinkedHashSet());
        return result;
      }
      Object element = set.iterator().next();
      if ((element instanceof String))
      {
        Set<String> ss = (Set)value;
        result.setSS(new ArrayList(ss));
      }
      else if ((element instanceof Number))
      {
        Set<Number> in = (Set)value;
        List<String> out = new ArrayList(set.size());
        for (Number n : in)
        {
          BigDecimal bd = InternalUtils.toBigDecimal(n);
          out.add(bd.toPlainString());
        }
        result.setNS(out);
      }
      else if ((element instanceof byte[]))
      {
        Set<byte[]> in = (Set)value;
        List<ByteBuffer> out = new ArrayList(set.size());
        for (byte[] buf : in) {
          out.add(ByteBuffer.wrap(buf));
        }
        result.setBS(out);
      }
      else if ((element instanceof ByteBuffer))
      {
        bs = (Set)value;
        result.setBS(bs);
      }
      else
      {
        throw new UnsupportedOperationException("element type: " + element.getClass());
      }
    }
    else
    {
      List<AttributeValue> out;
      if ((value instanceof List))
      {
        List<Object> in = (List)value;
        out = new ArrayList();
        for (Object v : in) {
          out.add(toAttributeValue(v));
        }
        result.setL(out);
      }
      else if ((value instanceof Map))
      {
        Map<String, Object> in = (Map)value;
        if (in.size() > 0) {
          for (Map.Entry<String, Object> e : in.entrySet()) {
            result.addMEntry((String)e.getKey(), toAttributeValue(e.getValue()));
          }
        } else {
          result.setM(new LinkedHashMap());
        }
      }
      else
      {
        throw new UnsupportedOperationException("value type: " + value.getClass());
      }
    }
    return result;
  }
  
  public static List<Object> toSimpleList(List<AttributeValue> attrValues)
  {
    if (attrValues == null) {
      return null;
    }
    List<Object> result = new ArrayList(attrValues.size());
    for (AttributeValue attrValue : attrValues)
    {
      Object value = toSimpleValue(attrValue);
      result.add(value);
    }
    return result;
  }
  
  public static <T> List<T> toSimpleListValue(List<AttributeValue> values)
  {
    if (values == null) {
      return null;
    }
    List<T> result = new ArrayList(values.size());
    for (AttributeValue v : values)
    {
      T t = toSimpleValue(v);
      result.add(t);
    }
    return result;
  }
  
  public static <T> Map<String, T> toSimpleMapValue(Map<String, AttributeValue> values)
  {
    if (values == null) {
      return null;
    }
    Map<String, T> result = new LinkedHashMap(values.size());
    for (Map.Entry<String, AttributeValue> entry : values.entrySet())
    {
      T t = toSimpleValue((AttributeValue)entry.getValue());
      result.put(entry.getKey(), t);
    }
    return result;
  }
  
  public static String valToString(Object val)
  {
    if ((val instanceof BigDecimal))
    {
      BigDecimal bd = (BigDecimal)val;
      return bd.toPlainString();
    }
    if (val == null) {
      return null;
    }
    if (((val instanceof String)) || ((val instanceof Boolean)) || ((val instanceof Number))) {
      return val.toString();
    }
    throw new IncompatibleTypeException("Cannot convert " + val.getClass() + " into a string");
  }
  
  public static <T> T toSimpleValue(AttributeValue value)
  {
    if (value == null) {
      return null;
    }
    if (Boolean.TRUE.equals(value.getNULL())) {
      return null;
    }
    if (Boolean.FALSE.equals(value.getNULL())) {
      throw new UnsupportedOperationException("False-NULL is not supported in DynamoDB");
    }
    if (value.getBOOL() != null)
    {
      T t = value.getBOOL();
      return t;
    }
    if (value.getS() != null)
    {
      T t = value.getS();
      return t;
    }
    if (value.getN() != null)
    {
      T t = new BigDecimal(value.getN());
      return t;
    }
    if (value.getB() != null)
    {
      T t = BinaryUtils.copyAllBytesFrom(value.getB());
      return t;
    }
    if (value.getSS() != null)
    {
      T t = new LinkedHashSet(value.getSS());
      return t;
    }
    Object t;
    if (value.getNS() != null)
    {
      Set<BigDecimal> set = new LinkedHashSet(value.getNS().size());
      for (String s : value.getNS()) {
        set.add(new BigDecimal(s));
      }
      t = set;
      return (T)t;
    }
    if (value.getBS() != null)
    {
      Set<byte[]> set = new LinkedHashSet(value.getBS().size());
      for (t = value.getBS().iterator(); ((Iterator)t).hasNext();)
      {
        ByteBuffer bb = (ByteBuffer)((Iterator)t).next();
        set.add(BinaryUtils.copyAllBytesFrom(bb));
      }
      Object t = set;
      return (T)t;
    }
    if (value.getL() != null)
    {
      T t = toSimpleList(value.getL());
      return t;
    }
    if (value.getM() != null)
    {
      T t = toSimpleMapValue(value.getM());
      return t;
    }
    throw new IllegalArgumentException("Attribute value must not be empty: " + value);
  }
  
  public static Integer minimum(Integer one, Integer two)
  {
    if (one == null) {
      return two;
    }
    if (two == null) {
      return one;
    }
    if (one.intValue() < two.intValue()) {
      return one;
    }
    return two;
  }
  
  public static Map<String, ExpectedAttributeValue> toExpectedAttributeValueMap(Collection<Expected> expectedSet)
  {
    if (expectedSet == null) {
      return null;
    }
    Map<String, ExpectedAttributeValue> expectedMap = new LinkedHashMap();
    for (Expected expected : expectedSet)
    {
      String attr = expected.getAttribute();
      Object[] values = expected.getValues();
      ExpectedAttributeValue eav = new ExpectedAttributeValue();
      if (values != null) {
        if (values.length > 0)
        {
          AttributeValue[] avs = InternalUtils.toAttributeValues(values);
          eav.withAttributeValueList(avs);
        }
        else
        {
          throw new IllegalStateException("Bug!");
        }
      }
      ComparisonOperator op = expected.getComparisonOperator();
      if (op == null) {
        throw new IllegalArgumentException("Comparison operator for attribute " + expected.getAttribute() + " must be specified");
      }
      eav.withComparisonOperator(op);
      expectedMap.put(attr, eav);
    }
    if (expectedSet.size() != expectedMap.size()) {
      throw new IllegalArgumentException("duplicates attribute names not allowed in input");
    }
    return Collections.unmodifiableMap(expectedMap);
  }
  
  public static Map<String, Condition> toAttributeConditionMap(Collection<? extends Filter<?>> filters)
  {
    if (filters == null) {
      return null;
    }
    Map<String, Condition> conditionMap = new LinkedHashMap();
    for (Filter<?> filter : filters)
    {
      String attr = filter.getAttribute();
      Object[] values = filter.getValues();
      Condition condition = new Condition();
      if (values != null) {
        if (values.length > 0)
        {
          AttributeValue[] avs = InternalUtils.toAttributeValues(values);
          condition.withAttributeValueList(avs);
        }
        else
        {
          throw new IllegalStateException("Bug!");
        }
      }
      ComparisonOperator op = filter.getComparisonOperator();
      if (op == null) {
        throw new IllegalArgumentException("Comparison operator for attribute " + filter.getAttribute() + " must be specified");
      }
      condition.withComparisonOperator(op);
      conditionMap.put(attr, condition);
    }
    if (filters.size() != conditionMap.size()) {
      throw new IllegalArgumentException("duplicates attribute names not allowed in input");
    }
    return Collections.unmodifiableMap(conditionMap);
  }
  
  public static AttributeValue[] toAttributeValues(Object[] values)
  {
    AttributeValue[] attrValues = new AttributeValue[values.length];
    for (int i = 0; i < values.length; i++) {
      attrValues[i] = InternalUtils.toAttributeValue(values[i]);
    }
    return attrValues;
  }
  
  public static Map<String, AttributeValue> toAttributeValueMap(Collection<KeyAttribute> primaryKey)
  {
    if (primaryKey == null) {
      return null;
    }
    Map<String, AttributeValue> keys = new LinkedHashMap();
    for (KeyAttribute keyAttr : primaryKey) {
      keys.put(keyAttr.getName(), 
        InternalUtils.toAttributeValue(keyAttr.getValue()));
    }
    return Collections.unmodifiableMap(keys);
  }
  
  public static Map<String, AttributeValue> toAttributeValueMap(PrimaryKey primaryKey)
  {
    if (primaryKey == null) {
      return null;
    }
    return toAttributeValueMap(primaryKey.getComponents());
  }
  
  public static Map<String, AttributeValue> toAttributeValueMap(KeyAttribute... primaryKey)
  {
    if (primaryKey == null) {
      return null;
    }
    return toAttributeValueMap(Arrays.asList(primaryKey));
  }
  
  public static BigDecimal toBigDecimal(Number n)
  {
    if ((n instanceof BigDecimal)) {
      return (BigDecimal)n;
    }
    return new BigDecimal(n.toString());
  }
  
  public static Set<BigDecimal> toBigDecimalSet(Number... val)
  {
    Set<BigDecimal> set = new LinkedHashSet(val.length);
    for (Number n : val) {
      set.add(InternalUtils.toBigDecimal(n));
    }
    return set;
  }
  
  public static Set<BigDecimal> toBigDecimalSet(Set<Number> vals)
  {
    Set<BigDecimal> set = new LinkedHashSet(vals.size());
    for (Number n : vals) {
      set.add(InternalUtils.toBigDecimal(n));
    }
    return set;
  }
  
  public static void checkInvalidAttrName(String attrName)
  {
    if ((attrName == null) || (attrName.trim().length() == 0)) {
      throw new IllegalArgumentException("Attribute name must not be null or empty");
    }
  }
  
  public static void checkInvalidAttribute(String attrName, Object val)
  {
    checkInvalidAttrName(attrName);
    ValidationUtils.assertNotNull(val, attrName);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ItemUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */