package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

class MediaType$2
  implements Function<String, String>
{
  MediaType$2(MediaType paramMediaType) {}
  
  public String apply(String value)
  {
    return MediaType.access$000().matchesAllOf(value) ? value : MediaType.access$100(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net.MediaType.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */