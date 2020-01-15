package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Pair;
import java.util.Comparator;

class S3ObjectIterator$1
  implements Comparator<Pair<S3ObjectSummary, String>>
{
  S3ObjectIterator$1(S3ObjectIterator this$0) {}
  
  public int compare(Pair<S3ObjectSummary, String> o1, Pair<S3ObjectSummary, String> o2)
  {
    if (o1.getLeft() == null)
    {
      if (o2.getLeft() == null) {
        return ((String)o1.getRight()).compareTo((String)o2.getRight());
      }
      return ((String)o1.getRight()).compareTo(((S3ObjectSummary)o2.getLeft()).getKey());
    }
    if (o2.getLeft() == null) {
      return ((S3ObjectSummary)o1.getLeft()).getKey().compareTo((String)o2.getRight());
    }
    return ((S3ObjectSummary)o1.getKey()).getKey().compareTo(((S3ObjectSummary)o2.getLeft()).getKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3ObjectIterator.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */