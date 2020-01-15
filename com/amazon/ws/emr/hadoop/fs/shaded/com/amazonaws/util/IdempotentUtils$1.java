package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.DefaultValueSupplier;
import java.util.UUID;

final class IdempotentUtils$1
  implements DefaultValueSupplier<String>
{
  public String get()
  {
    return UUID.randomUUID().toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IdempotentUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */