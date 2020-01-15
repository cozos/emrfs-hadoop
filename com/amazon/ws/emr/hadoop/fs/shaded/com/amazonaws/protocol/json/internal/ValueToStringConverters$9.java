package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import java.nio.charset.Charset;

final class ValueToStringConverters$9
  implements ValueToStringConverters.ValueToString<String>
{
  public String convert(String val)
  {
    return Base64.encodeAsString(val.getBytes(Charset.forName("utf-8")));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.ValueToStringConverters.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */