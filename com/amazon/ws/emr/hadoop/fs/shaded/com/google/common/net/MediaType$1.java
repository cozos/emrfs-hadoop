package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMultiset;
import java.util.Collection;

class MediaType$1
  implements Function<Collection<String>, ImmutableMultiset<String>>
{
  MediaType$1(MediaType paramMediaType) {}
  
  public ImmutableMultiset<String> apply(Collection<String> input)
  {
    return ImmutableMultiset.copyOf(input);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net.MediaType.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */