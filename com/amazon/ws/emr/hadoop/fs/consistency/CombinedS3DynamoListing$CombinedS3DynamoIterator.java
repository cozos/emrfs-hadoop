package com.amazon.ws.emr.hadoop.fs.consistency;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Pair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Triple;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class CombinedS3DynamoListing$CombinedS3DynamoIterator
  extends AbstractIterator<Triple<S3ObjectSummary, String, Entity>>
{
  private Iterator<Pair<S3ObjectSummary, String>> s3ObjectIterator;
  private Iterator<Entity> entityIterator;
  private Pair<S3ObjectSummary, String> curS3Value = null;
  private Entity curEntityValue = null;
  private final Set<String> usedFolderNames = new HashSet();
  
  CombinedS3DynamoListing$CombinedS3DynamoIterator(Iterator<Pair<S3ObjectSummary, String>> s3ObjectIterator, Iterator<Entity> entityIterator)
  {
    this.s3ObjectIterator = s3ObjectIterator;
    this.entityIterator = entityIterator;
  }
  
  private boolean shouldSkipS3()
  {
    if (curS3Value == null) {
      return false;
    }
    if ((curS3Value.getLeft() != null) && (((S3ObjectSummary)curS3Value.getLeft()).getKey().endsWith("/"))) {
      return true;
    }
    String s3Prefix = extractS3Prefix();
    return usedFolderNames.contains(s3Prefix);
  }
  
  private String extractS3Prefix()
  {
    String s3Prefix = curS3Value.getLeft() == null ? (String)curS3Value.getRight() : ((S3ObjectSummary)curS3Value.getLeft()).getKey();
    if (s3Prefix.endsWith("_$folder$")) {
      s3Prefix = s3Prefix.substring(0, s3Prefix.length() - "_$folder$".length()) + "/";
    }
    return s3Prefix;
  }
  
  private boolean s3ValueRepresentsFolder()
  {
    if (curS3Value.getLeft() == null) {
      return curS3Value.getRight() != null;
    }
    if (((S3ObjectSummary)curS3Value.getLeft()).getKey().endsWith("_$folder$")) {
      return true;
    }
    return false;
  }
  
  protected Triple<S3ObjectSummary, String, Entity> computeNext()
  {
    if ((curS3Value == null) && 
      (s3ObjectIterator.hasNext()))
    {
      curS3Value = ((Pair)s3ObjectIterator.next());
      while (shouldSkipS3())
      {
        curS3Value = null;
        if (s3ObjectIterator.hasNext()) {
          curS3Value = ((Pair)s3ObjectIterator.next());
        }
      }
    }
    if ((curEntityValue == null) && 
      (entityIterator.hasNext())) {
      curEntityValue = ((Entity)entityIterator.next());
    }
    if ((curS3Value == null) && (curEntityValue == null)) {
      return (Triple)endOfData();
    }
    Triple<S3ObjectSummary, String, Entity> triple;
    if (curS3Value == null)
    {
      Triple<S3ObjectSummary, String, Entity> triple = Triple.of(null, null, curEntityValue);
      curEntityValue = null;
    }
    else if (curEntityValue == null)
    {
      String s3Prefix = extractS3Prefix();
      if (s3ValueRepresentsFolder()) {
        usedFolderNames.add(s3Prefix);
      }
      Triple<S3ObjectSummary, String, Entity> triple = Triple.of(curS3Value.getLeft(), curS3Value.getRight(), null);
      curS3Value = null;
    }
    else
    {
      String s3Prefix = extractS3Prefix();
      if (s3ValueRepresentsFolder()) {
        usedFolderNames.add(s3Prefix);
      }
      String entityPrefix = curEntityValue.getItemKey().getHashKey() + "/" + curEntityValue.getItemKey().getRangeKey();
      String entityPrefixWithoutBucket = entityPrefix.substring(entityPrefix.indexOf("/", 1) + 1);
      int cmp = entityPrefixWithoutBucket.compareTo(s3Prefix);
      if (cmp < 0)
      {
        Triple<S3ObjectSummary, String, Entity> triple = Triple.of(null, null, curEntityValue);
        curEntityValue = null;
      }
      else if (cmp == 0)
      {
        Triple<S3ObjectSummary, String, Entity> triple = Triple.of(curS3Value.getLeft(), curS3Value.getRight(), curEntityValue);
        curS3Value = null;
        curEntityValue = null;
      }
      else
      {
        triple = Triple.of(curS3Value.getLeft(), curS3Value.getRight(), null);
        curS3Value = null;
      }
    }
    return triple;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.CombinedS3DynamoListing.CombinedS3DynamoIterator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */