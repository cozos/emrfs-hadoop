package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Pair;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S3ObjectIterator
  extends AbstractIterator<Pair<S3ObjectSummary, String>>
{
  private static final Logger LOG = LoggerFactory.getLogger(S3ObjectIterator.class);
  private ListObjectsV2Request request;
  private final AmazonS3Lite s3;
  private Iterator<Pair<S3ObjectSummary, String>> iterator = null;
  private String inclusiveEndKey;
  Function<Pair<S3ObjectSummary, String>, Pair<S3ObjectSummary, String>> s3ObjectSummaryTransformer;
  Function<Pair<S3ObjectSummary, String>, Pair<S3ObjectSummary, String>> commonPrefixTransformer;
  
  public S3ObjectIterator(AmazonS3Lite s3, ListObjectsV2Request listObjectsRequest, Function<Pair<S3ObjectSummary, String>, Pair<S3ObjectSummary, String>> s3ObjectSummaryTransformer, Function<Pair<S3ObjectSummary, String>, Pair<S3ObjectSummary, String>> commonPrefixTransformer, String inclusiveEndKey)
  {
    this.s3 = s3;
    request = ((ListObjectsV2Request)listObjectsRequest.clone());
    this.s3ObjectSummaryTransformer = s3ObjectSummaryTransformer;
    this.commonPrefixTransformer = commonPrefixTransformer;
    this.inclusiveEndKey = inclusiveEndKey;
  }
  
  protected Pair<S3ObjectSummary, String> computeNext()
  {
    for (;;)
    {
      if ((iterator != null) && (iterator.hasNext()))
      {
        Pair<S3ObjectSummary, String> ret = (Pair)iterator.next();
        if (inclusiveEndKey != null)
        {
          String key = ret.getLeft() != null ? ((S3ObjectSummary)ret.getLeft()).getKey() : (String)ret.getRight();
          if (key.compareTo(inclusiveEndKey) > 0) {
            return (Pair)endOfData();
          }
        }
        return ret;
      }
      if (request == null) {
        return (Pair)endOfData();
      }
      ListObjectsV2Result result = s3.listObjectsV2(request);
      if (result.isTruncated()) {
        request.setContinuationToken(result.getNextContinuationToken());
      } else {
        request = null;
      }
      iterator = getIteratorForResult(result);
    }
  }
  
  private Iterator<Pair<S3ObjectSummary, String>> getIteratorForResult(ListObjectsV2Result result)
  {
    Comparator comparator = new Comparator()
    {
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
    };
    List<Iterator<Pair<S3ObjectSummary, String>>> iterators = Lists.newArrayList();
    List<S3ObjectSummary> objectSummaries = result.getObjectSummaries();
    Iterator<Pair<S3ObjectSummary, String>> files = null;
    if ((objectSummaries != null) && (!objectSummaries.isEmpty()))
    {
      files = Iterators.transform(objectSummaries.iterator(), new Function()
      {
        public Pair<S3ObjectSummary, String> apply(S3ObjectSummary objectSummary)
        {
          return Pair.of(objectSummary, null);
        }
      });
      if (s3ObjectSummaryTransformer != null)
      {
        files = Iterators.transform(files, s3ObjectSummaryTransformer);
        List<Pair<S3ObjectSummary, String>> list = Lists.newArrayList(files);
        Collections.sort(list, comparator);
        files = list.iterator();
      }
      iterators.add(files);
    }
    List<String> commonPrefixes = result.getCommonPrefixes();
    if ((commonPrefixes != null) && (!commonPrefixes.isEmpty()))
    {
      files = Iterators.transform(commonPrefixes.iterator(), new Function()
      {
        public Pair<S3ObjectSummary, String> apply(String prefix)
        {
          return Pair.of(null, prefix);
        }
      });
      if (commonPrefixTransformer != null)
      {
        files = Iterators.transform(files, commonPrefixTransformer);
        List<Pair<S3ObjectSummary, String>> list = Lists.newArrayList(files);
        Collections.sort(list, comparator);
        files = list.iterator();
      }
      iterators.add(files);
    }
    return Iterators.mergeSorted(iterators, comparator);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3ObjectIterator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */