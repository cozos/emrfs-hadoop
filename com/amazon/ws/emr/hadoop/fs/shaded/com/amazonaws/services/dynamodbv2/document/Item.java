package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ItemValueConformer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Item
{
  private static final String DUPLICATE_VALUES_FOUND_IN_INPUT = "Duplicate values found in input";
  private final Map<String, Object> attributes = new LinkedHashMap();
  private static final ItemValueConformer valueConformer = new ItemValueConformer();
  
  public boolean isNull(String attrName)
  {
    return (attributes.containsKey(attrName)) && 
      (attributes.get(attrName) == null);
  }
  
  public boolean isPresent(String attrName)
  {
    return attributes.containsKey(attrName);
  }
  
  public String getString(String attrName)
  {
    Object val = attributes.get(attrName);
    return InternalUtils.valToString(val);
  }
  
  public Item withString(String attrName, String val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    attributes.put(attrName, val);
    return this;
  }
  
  public BigDecimal getNumber(String attrName)
  {
    Object val = attributes.get(attrName);
    return toBigDecimal(val);
  }
  
  private BigDecimal toBigDecimal(Object val)
  {
    if (val == null) {
      return null;
    }
    return (val instanceof BigDecimal) ? (BigDecimal)val : new BigDecimal(val
    
      .toString());
  }
  
  public BigInteger getBigInteger(String attrName)
  {
    BigDecimal bd = getNumber(attrName);
    return bd == null ? null : bd.toBigInteger();
  }
  
  public short getShort(String attrName)
  {
    BigDecimal bd = getNumber(attrName);
    if (bd == null) {
      throw new NumberFormatException("value of " + attrName + " is null");
    }
    return bd.shortValue();
  }
  
  public int getInt(String attrName)
  {
    BigDecimal bd = getNumber(attrName);
    if (bd == null) {
      throw new NumberFormatException("value of " + attrName + " is null");
    }
    return bd.intValue();
  }
  
  public long getLong(String attrName)
  {
    BigDecimal bd = getNumber(attrName);
    if (bd == null) {
      throw new NumberFormatException("value of " + attrName + " is null");
    }
    return bd.longValue();
  }
  
  public float getFloat(String attrName)
  {
    BigDecimal bd = getNumber(attrName);
    if (bd == null) {
      throw new NumberFormatException("value of " + attrName + " is null");
    }
    return bd.floatValue();
  }
  
  public double getDouble(String attrName)
  {
    BigDecimal bd = getNumber(attrName);
    if (bd == null) {
      throw new NumberFormatException("value of " + attrName + " is null");
    }
    return bd.doubleValue();
  }
  
  public Item withNumber(String attrName, BigDecimal val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    attributes.put(attrName, val);
    return this;
  }
  
  public Item withNumber(String attrName, Number val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    attributes.put(attrName, toBigDecimal(val));
    return this;
  }
  
  public Item withInt(String attrName, int val)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    return withNumber(attrName, Integer.valueOf(val));
  }
  
  public Item withBigInteger(String attrName, BigInteger val)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    return withNumber(attrName, val);
  }
  
  public Item withShort(String attrName, short val)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    return withNumber(attrName, Short.valueOf(val));
  }
  
  public Item withFloat(String attrName, float val)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    return withNumber(attrName, Float.valueOf(val));
  }
  
  public Item withDouble(String attrName, double val)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    return withNumber(attrName, Double.valueOf(val));
  }
  
  public Item withLong(String attrName, long val)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    return withNumber(attrName, Long.valueOf(val));
  }
  
  public byte[] getBinary(String attrName)
  {
    Object val = attributes.get(attrName);
    return toByteArray(val);
  }
  
  public ByteBuffer getByteBuffer(String attrName)
  {
    Object val = attributes.get(attrName);
    return toByteBuffer(val);
  }
  
  private byte[] toByteArray(Object val)
  {
    if (val == null) {
      return null;
    }
    if ((val instanceof byte[])) {
      return (byte[])val;
    }
    if ((val instanceof ByteBuffer)) {
      return BinaryUtils.copyAllBytesFrom((ByteBuffer)val);
    }
    throw new IncompatibleTypeException(val.getClass() + " cannot be converted into a byte array");
  }
  
  private ByteBuffer toByteBuffer(Object val)
  {
    if (val == null) {
      return null;
    }
    if ((val instanceof byte[])) {
      return ByteBuffer.wrap((byte[])val);
    }
    if ((val instanceof ByteBuffer)) {
      return (ByteBuffer)val;
    }
    throw new IncompatibleTypeException(val.getClass() + " cannot be converted into a ByteBuffer");
  }
  
  public Item withBinary(String attrName, byte[] val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    attributes.put(attrName, val);
    return this;
  }
  
  public Item withBinary(String attrName, ByteBuffer val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    
    attributes.put(attrName, BinaryUtils.copyBytesFrom(val));
    return this;
  }
  
  public Set<String> getStringSet(String attrName)
  {
    Object val = attributes.get(attrName);
    if (val == null) {
      return null;
    }
    Set<String> stringSet = new LinkedHashSet();
    if ((val instanceof Collection))
    {
      Collection<?> col = (Collection)val;
      if (col.size() == 0) {
        return stringSet;
      }
      for (Object element : col)
      {
        String s = element == null ? null : InternalUtils.valToString(element);
        if (!stringSet.add(s)) {
          throw new IncompatibleTypeException(val.getClass() + " cannot be converted into a set of strings because of duplicate elements");
        }
      }
      return stringSet;
    }
    stringSet.add(InternalUtils.valToString(val));
    return stringSet;
  }
  
  public Item withStringSet(String attrName, Set<String> val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    attributes.put(attrName, val);
    return this;
  }
  
  public Item withStringSet(String attrName, String... val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    Set<String> strSet = new LinkedHashSet(Arrays.asList(val));
    if (strSet.size() != val.length) {
      throw new IllegalArgumentException("Duplicate values found in input");
    }
    attributes.put(attrName, strSet);
    return this;
  }
  
  public Set<BigDecimal> getNumberSet(String attrName)
  {
    Object val = attributes.get(attrName);
    if (val == null) {
      return null;
    }
    Set<BigDecimal> numSet = new LinkedHashSet();
    if ((val instanceof Collection))
    {
      Collection<?> col = (Collection)val;
      if (col.size() == 0) {
        return numSet;
      }
      for (Object element : col)
      {
        BigDecimal bd = toBigDecimal(element);
        if (!numSet.add(bd)) {
          throw new IncompatibleTypeException(val.getClass() + " cannot be converted into a set of BigDecimal's because of duplicate elements");
        }
      }
      return numSet;
    }
    if ((val instanceof BigDecimal))
    {
      numSet.add((BigDecimal)val);
      return numSet;
    }
    numSet.add(new BigDecimal(val.toString()));
    return numSet;
  }
  
  public Item withBigDecimalSet(String attrName, Set<BigDecimal> val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    attributes.put(attrName, val);
    return this;
  }
  
  public Item withBigDecimalSet(String attrName, BigDecimal... vals)
  {
    InternalUtils.checkInvalidAttribute(attrName, vals);
    Set<BigDecimal> set = new LinkedHashSet(Arrays.asList(vals));
    if (set.size() != vals.length) {
      throw new IllegalArgumentException("Duplicate values found in input");
    }
    attributes.put(attrName, set);
    return this;
  }
  
  public Item withNumberSet(String attrName, Number... vals)
  {
    InternalUtils.checkInvalidAttribute(attrName, vals);
    Set<BigDecimal> set = InternalUtils.toBigDecimalSet(vals);
    if (set.size() != vals.length) {
      throw new IllegalArgumentException("Duplicate values found in input");
    }
    return withBigDecimalSet(attrName, set);
  }
  
  public Item withNumberSet(String attrName, Set<Number> vals)
  {
    InternalUtils.checkInvalidAttribute(attrName, vals);
    Set<BigDecimal> set = InternalUtils.toBigDecimalSet(vals);
    if (set.size() != vals.size()) {
      throw new IllegalArgumentException("Duplicate values found in input");
    }
    return withBigDecimalSet(attrName, set);
  }
  
  public Set<byte[]> getBinarySet(String attrName)
  {
    Object val = attributes.get(attrName);
    if (val == null) {
      return null;
    }
    Set<byte[]> binarySet = new LinkedHashSet();
    if ((val instanceof Collection))
    {
      Collection<?> col = (Collection)val;
      if (col.size() == 0) {
        return binarySet;
      }
      for (Object element : col)
      {
        byte[] ba = toByteArray(element);
        if (!binarySet.add(ba)) {
          throw new IncompatibleTypeException(val.getClass() + " cannot be converted into a set of byte arrays because of duplicate elements");
        }
      }
      return binarySet;
    }
    if ((val instanceof byte[]))
    {
      binarySet.add((byte[])val);
      return binarySet;
    }
    if ((val instanceof ByteBuffer))
    {
      ByteBuffer bb = (ByteBuffer)val;
      binarySet.add(BinaryUtils.copyAllBytesFrom(bb));
      return binarySet;
    }
    throw new IncompatibleTypeException(val.getClass() + " cannot be converted into a set of byte arrays");
  }
  
  public Set<ByteBuffer> getByteBufferSet(String attrName)
  {
    Object val = attributes.get(attrName);
    if (val == null) {
      return null;
    }
    Set<ByteBuffer> binarySet = new LinkedHashSet();
    if ((val instanceof Collection))
    {
      Collection<?> col = (Collection)val;
      if (col.size() == 0) {
        return binarySet;
      }
      for (Object element : col)
      {
        ByteBuffer ba = toByteBuffer(element);
        if (!binarySet.add(ba)) {
          throw new IncompatibleTypeException(val.getClass() + " cannot be converted into a set of ByteBuffer because of duplicate elements");
        }
      }
      return binarySet;
    }
    if ((val instanceof ByteBuffer))
    {
      binarySet.add((ByteBuffer)val);
      return binarySet;
    }
    if ((val instanceof byte[]))
    {
      binarySet.add(ByteBuffer.wrap((byte[])val));
      return binarySet;
    }
    throw new IncompatibleTypeException(val.getClass() + " cannot be converted into a set of ByteBuffer");
  }
  
  public Item withBinarySet(String attrName, Set<byte[]> val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    attributes.put(attrName, val);
    return this;
  }
  
  public Item withByteBufferSet(String attrName, Set<ByteBuffer> val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    
    Set<byte[]> set = new LinkedHashSet(val.size());
    for (ByteBuffer bb : val) {
      set.add(BinaryUtils.copyBytesFrom(bb));
    }
    attributes.put(attrName, set);
    return this;
  }
  
  public Item withBinarySet(String attrName, byte[]... vals)
  {
    InternalUtils.checkInvalidAttribute(attrName, vals);
    Set<byte[]> set = new LinkedHashSet(Arrays.asList(vals));
    if (set.size() != vals.length) {
      throw new IllegalArgumentException("Duplicate values found in input");
    }
    attributes.put(attrName, set);
    return this;
  }
  
  public Item withBinarySet(String attrName, ByteBuffer... vals)
  {
    InternalUtils.checkInvalidAttribute(attrName, vals);
    
    Set<byte[]> set = new LinkedHashSet(vals.length);
    for (ByteBuffer bb : vals) {
      set.add(BinaryUtils.copyBytesFrom(bb));
    }
    if (set.size() != vals.length) {
      throw new IllegalArgumentException("Duplicate values found in input");
    }
    attributes.put(attrName, set);
    return this;
  }
  
  public <T> List<T> getList(String attrName)
  {
    Object val = attributes.get(attrName);
    if (val == null) {
      return null;
    }
    if ((val instanceof List))
    {
      List<T> ret = (List)val;
      return ret;
    }
    List<T> list = new ArrayList();
    if ((val instanceof Collection))
    {
      Collection<?> col = (Collection)val;
      for (Object element : col)
      {
        T t = (T)element;
        list.add(t);
      }
      return list;
    }
    T t = (T)val;
    list.add(t);
    return list;
  }
  
  public Item withList(String attrName, List<?> val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    attributes.put(attrName, valueConformer.transform(val));
    return this;
  }
  
  public Item withList(String attrName, Object... vals)
  {
    InternalUtils.checkInvalidAttribute(attrName, vals);
    List<Object> list_in = Arrays.asList(vals);
    attributes.put(attrName, valueConformer.transform(list_in));
    return this;
  }
  
  public <T> Map<String, T> getMap(String attrName)
  {
    return (Map)attributes.get(attrName);
  }
  
  public <T extends Number> Map<String, T> getMapOfNumbers(String attrName, Class<T> valueType)
  {
    if ((valueType == Short.class) || (valueType == Integer.class) || (valueType == Long.class) || (valueType == Float.class) || (valueType == Double.class) || (valueType == Number.class) || (valueType == BigDecimal.class) || (valueType == BigInteger.class))
    {
      Map<String, BigDecimal> src = (Map)attributes.get(attrName);
      if (src == null) {
        return null;
      }
      Map<String, T> dst = new LinkedHashMap(src.size());
      for (Map.Entry<String, BigDecimal> e : src.entrySet())
      {
        String key = (String)e.getKey();
        BigDecimal val = (BigDecimal)e.getValue();
        if (val == null) {
          dst.put(key, null);
        } else if (valueType == Short.class) {
          dst.put(key, Short.valueOf(val.shortValue()));
        } else if (valueType == Integer.class) {
          dst.put(key, Integer.valueOf(val.intValue()));
        } else if (valueType == Long.class) {
          dst.put(key, Long.valueOf(val.longValue()));
        } else if (valueType == Float.class) {
          dst.put(key, Float.valueOf(val.floatValue()));
        } else if (valueType == Double.class) {
          dst.put(key, Double.valueOf(val.doubleValue()));
        } else if ((valueType == BigDecimal.class) || (valueType == Number.class)) {
          dst.put(key, val);
        } else if (valueType == BigInteger.class) {
          dst.put(key, val.toBigInteger());
        }
      }
      return dst;
    }
    throw new UnsupportedOperationException("Value type " + valueType + " is not currently supported");
  }
  
  public Map<String, Object> getRawMap(String attrName)
  {
    return (Map)attributes.get(attrName);
  }
  
  public Item withMap(String attrName, Map<String, ?> val)
  {
    InternalUtils.checkInvalidAttribute(attrName, val);
    attributes.put(attrName, valueConformer.transform(val));
    return this;
  }
  
  public Item withJSON(String attrName, String json)
  {
    InternalUtils.checkInvalidAttribute(attrName, json);
    attributes.put(attrName, valueConformer
      .transform(Jackson.fromJsonString(json, Object.class)));
    return this;
  }
  
  public String getJSON(String attrName)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    Object val = attributes.get(attrName);
    return val == null ? null : Jackson.toJsonString(val);
  }
  
  public String getJSONPretty(String attrName)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    Object val = attributes.get(attrName);
    return val == null ? null : Jackson.toJsonPrettyString(val);
  }
  
  public Boolean getBOOL(String attrName)
  {
    Object val = attributes.get(attrName);
    if ((val instanceof Boolean)) {
      return (Boolean)val;
    }
    if ((val instanceof String))
    {
      if ("1".equals(val)) {
        return Boolean.valueOf(true);
      }
      if ("0".equals(val)) {
        return Boolean.valueOf(false);
      }
      return Boolean.valueOf((String)val);
    }
    throw new IncompatibleTypeException("Value of attribute " + attrName + " of type " + getTypeOf(attrName) + " cannot be converted into a boolean value");
  }
  
  public boolean getBoolean(String attrName)
  {
    Boolean b = getBOOL(attrName);
    return b.booleanValue();
  }
  
  public Item withBoolean(String attrName, boolean val)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    attributes.put(attrName, Boolean.valueOf(val));
    return this;
  }
  
  public Item withNull(String attrName)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    attributes.put(attrName, null);
    return this;
  }
  
  public Item with(String attrName, Object val)
  {
    if (val == null) {
      return withNull(attrName);
    }
    if ((val instanceof String)) {
      return withString(attrName, (String)val);
    }
    if ((val instanceof Number)) {
      return withNumber(attrName, (Number)val);
    }
    if ((val instanceof byte[])) {
      return withBinary(attrName, (byte[])val);
    }
    if ((val instanceof ByteBuffer)) {
      return withBinary(attrName, (ByteBuffer)val);
    }
    if ((val instanceof Boolean)) {
      return withBoolean(attrName, ((Boolean)val).booleanValue());
    }
    if ((val instanceof List)) {
      return withList(attrName, (List)val);
    }
    if ((val instanceof Map))
    {
      Map<String, ?> map = (Map)val;
      return withMap(attrName, map);
    }
    if ((val instanceof Set))
    {
      Set<?> set = (Set)val;
      if (set.size() == 0)
      {
        Set<String> ss = (Set)val;
        return withStringSet(attrName, ss);
      }
      Object representative = null;
      for (Object o : set) {
        if (o != null) {
          representative = o;
        }
      }
      if ((representative == null) || ((representative instanceof String)))
      {
        Object ss = (Set)val;
        return withStringSet(attrName, (Set)ss);
      }
      if ((representative instanceof Number))
      {
        Object ns = (Set)val;
        return withNumberSet(attrName, (Set)ns);
      }
      if ((representative instanceof byte[]))
      {
        Object bs = (Set)val;
        return withBinarySet(attrName, (Set)bs);
      }
      if ((representative instanceof ByteBuffer))
      {
        Object bs = (Set)val;
        return withByteBufferSet(attrName, (Set)bs);
      }
      throw new UnsupportedOperationException("Set of " + representative.getClass() + " is not currently supported");
    }
    throw new UnsupportedOperationException("Input type " + val.getClass() + " is not currently supported");
  }
  
  public Item withPrimaryKey(PrimaryKey primaryKey)
  {
    InternalUtils.rejectNullValue(primaryKey);
    if (primaryKey.getComponents().size() == 0) {
      throw new IllegalArgumentException("primary key must not be empty");
    }
    for (KeyAttribute ka : primaryKey.getComponents()) {
      with(ka.getName(), ka.getValue());
    }
    return this;
  }
  
  public Item withPrimaryKey(String hashKeyName, Object hashKeyValue)
  {
    return withKeyComponent(hashKeyName, hashKeyValue);
  }
  
  public Item withPrimaryKey(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    return 
      withKeyComponent(hashKeyName, hashKeyValue).withKeyComponent(rangeKeyName, rangeKeyValue);
  }
  
  public Item withKeyComponents(KeyAttribute... components)
  {
    InternalUtils.rejectNullOrEmptyInput(components);
    for (KeyAttribute ka : components)
    {
      InternalUtils.rejectNullValue(ka);
      with(ka.getName(), ka.getValue());
    }
    return this;
  }
  
  public Item withKeyComponent(String keyAttrName, Object keyAttrValue)
  {
    return with(keyAttrName, keyAttrValue);
  }
  
  public Object get(String attrName)
  {
    return attributes.get(attrName);
  }
  
  public Class<?> getTypeOf(String attrName)
  {
    Object val = attributes.get(attrName);
    return val == null ? null : val.getClass();
  }
  
  public Item removeAttribute(String attrName)
  {
    InternalUtils.checkInvalidAttrName(attrName);
    attributes.remove(attrName);
    return this;
  }
  
  public Iterable<Map.Entry<String, Object>> attributes()
  {
    return new LinkedHashMap(attributes).entrySet();
  }
  
  public boolean hasAttribute(String attrName)
  {
    return attributes.containsKey(attrName);
  }
  
  public Map<String, Object> asMap()
  {
    return new LinkedHashMap(attributes);
  }
  
  public int numberOfAttributes()
  {
    return attributes.size();
  }
  
  public static Item fromMap(Map<String, Object> attributes)
  {
    if (attributes == null) {
      return null;
    }
    Item item = new Item();
    for (Map.Entry<String, Object> e : attributes.entrySet()) {
      item.with((String)e.getKey(), e.getValue());
    }
    return item;
  }
  
  public static Item fromJSON(String json)
  {
    if (json == null) {
      return null;
    }
    Map<String, Object> map = (Map)valueConformer.transform(Jackson.fromJsonString(json, Map.class));
    return fromMap(map);
  }
  
  public String toJSON()
  {
    return Jackson.toJsonString(attributes);
  }
  
  public Item base64Decode(String... binaryAttrNames)
  {
    InternalUtils.rejectNullInput(binaryAttrNames);
    Iterator localIterator;
    String b64;
    for (String attrName : binaryAttrNames)
    {
      InternalUtils.checkInvalidAttrName(attrName);
      if (String.class == getTypeOf(attrName))
      {
        String b64 = getString(attrName);
        Base64.decode(b64);
      }
      else
      {
        Set<String> b64s = getStringSet(attrName);
        for (localIterator = b64s.iterator(); localIterator.hasNext();)
        {
          b64 = (String)localIterator.next();
          Base64.decode(b64);
        }
      }
    }
    for (String attrName : binaryAttrNames) {
      if (String.class == getTypeOf(attrName))
      {
        String b64 = getString(attrName);
        byte[] bytes = Base64.decode(b64);
        withBinary(attrName, bytes);
      }
      else
      {
        Set<String> b64s = getStringSet(attrName);
        Object binarySet = new LinkedHashSet(b64s.size());
        for (String b64 : b64s) {
          ((Set)binarySet).add(Base64.decode(b64));
        }
        withBinarySet(attrName, (Set)binarySet);
      }
    }
    return this;
  }
  
  public Item convertListsToSets(String... listAttrNames)
  {
    InternalUtils.rejectNullInput(listAttrNames);
    Object e;
    for (String attrName : listAttrNames)
    {
      InternalUtils.checkInvalidAttrName(attrName);
      List<?> list;
      Iterator localIterator;
      if (List.class.isAssignableFrom(getTypeOf(attrName)))
      {
        list = getList(attrName);
        if (list != null) {
          for (localIterator = list.iterator(); localIterator.hasNext();)
          {
            e = localIterator.next();
            if ((e instanceof String))
            {
              Set<String> ss = getStringSet(attrName);
              if (list.size() != ss.size()) {
                throw new IllegalArgumentException("List cannot be converted to Set due to duplicate elements");
              }
            }
            else if ((e instanceof Number))
            {
              Set<BigDecimal> ss = getNumberSet(attrName);
              if (list.size() != ss.size()) {
                throw new IllegalArgumentException("List cannot be converted to Set due to duplicate elements");
              }
            }
            else if ((e instanceof byte[]))
            {
              Set<byte[]> ss = getBinarySet(attrName);
              if (list.size() != ss.size()) {
                throw new IllegalArgumentException("List cannot be converted to Set due to duplicate elements");
              }
            }
          }
        }
      }
      else
      {
        throw new IllegalArgumentException("Attribute " + attrName + " is not a list");
      }
    }
    for (String attrName : listAttrNames)
    {
      InternalUtils.checkInvalidAttrName(attrName);
      List<?> list = getList(attrName);
      if (list != null)
      {
        boolean converted = false;
        for (e = list.iterator(); ((Iterator)e).hasNext();)
        {
          Object e = ((Iterator)e).next();
          if ((e instanceof String))
          {
            Set<String> set = getStringSet(attrName);
            withStringSet(attrName, set);
            converted = true;
            break;
          }
          if ((e instanceof Number))
          {
            Set<BigDecimal> set = getNumberSet(attrName);
            withBigDecimalSet(attrName, set);
            converted = true;
            break;
          }
          if ((e instanceof byte[]))
          {
            Set<byte[]> set = getBinarySet(attrName);
            withBinarySet(attrName, set);
            converted = true;
            break;
          }
        }
        if (!converted)
        {
          Set<String> set = getStringSet(attrName);
          withStringSet(attrName, set);
        }
      }
    }
    return this;
  }
  
  public String toJSONPretty()
  {
    return Jackson.toJsonPrettyString(attributes);
  }
  
  public String toString()
  {
    return "{ Item: " + attributes.toString() + " }";
  }
  
  public int hashCode()
  {
    return attributes.hashCode();
  }
  
  public boolean equals(Object in)
  {
    if ((in instanceof Item))
    {
      Item that = (Item)in;
      return attributes.equals(attributes);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */