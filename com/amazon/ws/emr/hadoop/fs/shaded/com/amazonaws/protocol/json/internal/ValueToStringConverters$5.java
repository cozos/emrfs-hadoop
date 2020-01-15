package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

final class ValueToStringConverters$5
  implements ValueToStringConverters.ValueToString<Float>
{
  public String convert(Float val)
  {
    return StringUtils.fromFloat(val);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.ValueToStringConverters.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */