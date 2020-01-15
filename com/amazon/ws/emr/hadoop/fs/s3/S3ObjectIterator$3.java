package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Pair;

class S3ObjectIterator$3
  implements Function<String, Pair<S3ObjectSummary, String>>
{
  S3ObjectIterator$3(S3ObjectIterator this$0) {}
  
  public Pair<S3ObjectSummary, String> apply(String prefix)
  {
    return Pair.of(null, prefix);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3ObjectIterator.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */