package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

final class ValueToStringConverters$2
  implements ValueToStringConverters.ValueToString<Integer>
{
  public String convert(Integer val)
  {
    return StringUtils.fromInteger(val);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.ValueToStringConverters.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */