package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Pair;
import java.util.Iterator;

public class S3ObjectListing
  implements Iterable<Pair<S3ObjectSummary, String>>
{
  private final ListObjectsV2Request request;
  private final AmazonS3Lite s3;
  Function<Pair<S3ObjectSummary, String>, Pair<S3ObjectSummary, String>> s3ObjectSummaryTransformer;
  Function<Pair<S3ObjectSummary, String>, Pair<S3ObjectSummary, String>> commonPrefixTransformer;
  private final String inclusiveEndKey;
  
  public S3ObjectListing(AmazonS3Lite s3, ListObjectsV2Request request)
  {
    this(s3, request, null, null, null);
  }
  
  public S3ObjectListing(AmazonS3Lite s3, ListObjectsV2Request request, String inclusiveEndKey)
  {
    this(s3, request, null, null, inclusiveEndKey);
  }
  
  public S3ObjectListing(AmazonS3Lite s3, ListObjectsV2Request request, Function<Pair<S3ObjectSummary, String>, Pair<S3ObjectSummary, String>> s3ObjectSummaryTransformer, Function<Pair<S3ObjectSummary, String>, Pair<S3ObjectSummary, String>> commonPrefixTransformer, String inclusiveEndKey)
  {
    this.s3 = s3;
    this.request = request;
    this.s3ObjectSummaryTransformer = s3ObjectSummaryTransformer;
    this.commonPrefixTransformer = commonPrefixTransformer;
    this.inclusiveEndKey = inclusiveEndKey;
  }
  
  public Iterator<Pair<S3ObjectSummary, String>> iterator()
  {
    S3ObjectIterator iterator = new S3ObjectIterator(s3, request, s3ObjectSummaryTransformer, commonPrefixTransformer, inclusiveEndKey);
    
    return iterator;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3ObjectListing
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */