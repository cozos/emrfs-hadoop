package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.Date;

final class ValueToStringConverters$8
  implements ValueToStringConverters.ValueToString<Date>
{
  public String convert(Date val)
  {
    return StringUtils.fromDate(val);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.ValueToStringConverters.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */