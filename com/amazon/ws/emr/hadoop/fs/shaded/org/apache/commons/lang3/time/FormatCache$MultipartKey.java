package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Arrays;

class FormatCache$MultipartKey
{
  private final Object[] keys;
  private int hashCode;
  
  public FormatCache$MultipartKey(Object... keys)
  {
    this.keys = keys;
  }
  
  public boolean equals(Object obj)
  {
    return Arrays.equals(keys, keys);
  }
  
  public int hashCode()
  {
    if (hashCode == 0)
    {
      int rc = 0;
      for (Object key : keys) {
        if (key != null) {
          rc = rc * 7 + key.hashCode();
        }
      }
      hashCode = rc;
    }
    return hashCode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FormatCache.MultipartKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */