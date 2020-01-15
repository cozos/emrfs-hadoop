package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ItemValueConformer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValueMap
  extends FluentHashMap<String, Object>
{
  private static final long serialVersionUID = 1L;
  private static final ItemValueConformer valueConformer = new ItemValueConformer();
  
  public ValueMap withString(String key, String val)
  {
    super.put(key, val);
    return this;
  }
  
  public ValueMap withNumber(String key, BigDecimal val)
  {
    super.put(key, val);
    return this;
  }
  
  public ValueMap withNumber(String key, Number val)
  {
    super.put(key, InternalUtils.toBigDecimal(val));
    return this;
  }
  
  public ValueMap withInt(String key, int val)
  {
    return withNumber(key, Integer.valueOf(val));
  }
  
  public ValueMap withLong(String key, long val)
  {
    return withNumber(key, Long.valueOf(val));
  }
  
  public ValueMap withBinary(String key, byte[] val)
  {
    super.put(key, val);
    return this;
  }
  
  public ValueMap withStringSet(String key, Set<String> val)
  {
    super.put(key, val);
    return this;
  }
  
  public ValueMap withStringSet(String key, String... val)
  {
    super.put(key, new LinkedHashSet(Arrays.asList(val)));
    return this;
  }
  
  public ValueMap withNumberSet(String key, Set<BigDecimal> val)
  {
    super.put(key, val);
    return this;
  }
  
  public ValueMap withNumberSet(String key, BigDecimal... val)
  {
    super.put(key, new LinkedHashSet(Arrays.asList(val)));
    return this;
  }
  
  public ValueMap withNumberSet(String key, Number... val)
  {
    super.put(key, InternalUtils.toBigDecimalSet(val));
    return this;
  }
  
  public ValueMap withBinarySet(String key, Set<byte[]> val)
  {
    super.put(key, val);
    return this;
  }
  
  public ValueMap withBinarySet(String key, byte[]... val)
  {
    super.put(key, new LinkedHashSet(Arrays.asList(val)));
    return this;
  }
  
  public ValueMap withList(String key, List<?> val)
  {
    super.put(key, val == null ? null : new ArrayList(val));
    return this;
  }
  
  public ValueMap withList(String key, Object... vals)
  {
    super.put(key, vals == null ? null : new ArrayList(
      Arrays.asList(vals)));
    return this;
  }
  
  public ValueMap withMap(String key, Map<String, ?> val)
  {
    super.put(key, val);
    return this;
  }
  
  public ValueMap withBoolean(String key, boolean val)
  {
    super.put(key, Boolean.valueOf(val));
    return this;
  }
  
  public ValueMap withNull(String key)
  {
    super.put(key, null);
    return this;
  }
  
  public ValueMap withJSON(String key, String jsonValue)
  {
    super.put(key, valueConformer.transform(Jackson.fromJsonString(jsonValue, Object.class)));
    return this;
  }
  
  public ValueMap with(String key, Object val)
  {
    if (val == this) {
      throw new IllegalArgumentException("Self reference is not allowed");
    }
    super.put(key, val);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils.ValueMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */