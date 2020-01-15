package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

final class ValueToStringConverters$6
  implements ValueToStringConverters.ValueToString<Double>
{
  public String convert(Double val)
  {
    return StringUtils.fromDouble(val);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.ValueToStringConverters.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */