package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ItemValueConformer
  extends ValueTransformer
{
  public Object transform(Object value)
  {
    if (value == null) {
      return value;
    }
    if ((value instanceof Boolean)) {
      return value;
    }
    if ((value instanceof String)) {
      return value;
    }
    if ((value instanceof Number)) {
      return InternalUtils.toBigDecimal((Number)value);
    }
    if ((value instanceof byte[])) {
      return value;
    }
    if ((value instanceof ByteBuffer)) {
      return BinaryUtils.copyBytesFrom((ByteBuffer)value);
    }
    Set<ByteBuffer> bs;
    if ((value instanceof Set))
    {
      Set<Object> set = (Set)value;
      if (set.size() == 0) {
        return value;
      }
      Object element = set.iterator().next();
      if ((element instanceof String)) {
        return value;
      }
      if ((element instanceof BigDecimal)) {
        return value;
      }
      if ((element instanceof Number))
      {
        Set<Number> in = (Set)value;
        Set<BigDecimal> out = new LinkedHashSet(set.size());
        for (Number n : in) {
          out.add(InternalUtils.toBigDecimal(n));
        }
        return out;
      }
      if ((element instanceof byte[])) {
        return value;
      }
      if ((element instanceof ByteBuffer))
      {
        bs = (Set)value;
        Set<byte[]> out = new LinkedHashSet(bs.size());
        for (ByteBuffer bb : bs) {
          out.add(BinaryUtils.copyBytesFrom(bb));
        }
        return out;
      }
      throw new UnsupportedOperationException("element type: " + element.getClass());
    }
    if ((value instanceof List))
    {
      List<Object> in = (List)value;
      if (in.size() == 0) {
        return in;
      }
      List<Object> out = new ArrayList();
      for (Object v : in) {
        out.add(transform(v));
      }
      return out;
    }
    if ((value instanceof Map))
    {
      Map<String, Object> in = (Map)value;
      if (in.size() == 0) {
        return in;
      }
      Map<String, Object> out = new LinkedHashMap(in.size());
      for (Map.Entry<String, Object> e : in.entrySet()) {
        out.put(e.getKey(), transform(e.getValue()));
      }
      return out;
    }
    throw new UnsupportedOperationException("value type: " + value.getClass());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ItemValueConformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */