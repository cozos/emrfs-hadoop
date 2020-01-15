package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

final class ValueToStringConverters$3
  implements ValueToStringConverters.ValueToString<Long>
{
  public String convert(Long val)
  {
    return StringUtils.fromLong(val);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.ValueToStringConverters.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */