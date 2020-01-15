package com.amazon.ws.emr.hadoop.fs.consistency;

import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile;
import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.State;
import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.s3.S3ObjectListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.MutablePair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Pair;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import org.slf4j.Logger;

class ConsistencyCheckerS3FileSystem$ListStatusWorker
  implements Callable<Void>
{
  String startKey;
  String endKey;
  boolean includeDeleted;
  boolean throwOnDirectoryMismatch;
  Map<ItemKey, MutablePair<Entity, Boolean>> entities;
  S3ObjectListing s3ObjectListing;
  SortedSet<FileStatusExt> results;
  
  ConsistencyCheckerS3FileSystem$ListStatusWorker(String this$0, boolean prefix, boolean includeDeleted, Map<ItemKey, MutablePair<Entity, Boolean>> throwOnDirectoryMismatch, SortedSet<FileStatusExt> entities)
  {
    this(this$0, prefix, null, null, includeDeleted, throwOnDirectoryMismatch, entities, results);
  }
  
  ConsistencyCheckerS3FileSystem$ListStatusWorker(String this$0, String prefix, String startKey, boolean endKey, boolean includeDeleted, Map<ItemKey, MutablePair<Entity, Boolean>> throwOnDirectoryMismatch, SortedSet<FileStatusExt> entities)
  {
    if (!Strings.isNullOrEmpty(prefix)) {
      if (prefix.equals("/")) {
        prefix = "";
      } else {
        prefix = prefix + "/";
      }
    }
    this.startKey = (prefix + startKey);
    this.endKey = (prefix + endKey);
    this.includeDeleted = includeDeleted;
    this.throwOnDirectoryMismatch = throwOnDirectoryMismatch;
    this.entities = entities;
    this.results = results;
    
    ListObjectsV2Request listObjectsRequest = new ListObjectsV2Request().withBucketName(ConsistencyCheckerS3FileSystem.access$100(this$0)).withPrefix(prefix).withDelimiter("/").withStartAfter(startKey);
    s3ObjectListing = new S3ObjectListing(ConsistencyCheckerS3FileSystem.access$200(this$0), listObjectsRequest, endKey);
  }
  
  public Void call()
    throws FileDirectoryMismatchException
  {
    for (Pair<S3ObjectSummary, String> p : s3ObjectListing)
    {
      FileStatusExt newFileStatus;
      if ((p.getLeft() == null) || (((S3ObjectSummary)p.getLeft()).getKey().endsWith("_$folder$")))
      {
        String s3Prefix;
        if (p.getLeft() == null)
        {
          String s3Prefix = (String)p.getRight();
          if (s3Prefix.endsWith("/")) {
            s3Prefix = s3Prefix.substring(0, s3Prefix.length() - 1);
          }
        }
        else
        {
          s3Prefix = ((S3ObjectSummary)p.getLeft()).getKey().substring(0, ((S3ObjectSummary)p.getLeft()).getKey().length() - "_$folder$".length());
        }
        if (s3Prefix.equals("")) {
          continue;
        }
        MutablePair<Entity, Boolean> entity = (MutablePair)entities.get(ItemKeys.toItemKey(ConsistencyCheckerS3FileSystem.access$100(this$0), s3Prefix));
        FileStatusExt newFileStatus;
        FileStatusExt newFileStatus;
        if (entity != null)
        {
          if (!((Boolean)entity.getValue()).booleanValue()) {
            entity.setValue(Boolean.valueOf(true));
          } else {
            entities.remove(((Entity)entity.getKey()).getItemKey());
          }
          newFileStatus = ConsistencyCheckerS3FileSystem.access$300(this$0, s3Prefix, (Entity)entity.getLeft());
        }
        else
        {
          newFileStatus = ConsistencyCheckerS3FileSystem.access$300(this$0, s3Prefix, null);
        }
      }
      else
      {
        if (((S3ObjectSummary)p.getLeft()).getKey().endsWith("/"))
        {
          ConsistencyCheckerS3FileSystem.access$400().info("Skipping s3 object ending with slash: '{}'", ((S3ObjectSummary)p.getLeft()).getKey());
          continue;
        }
        if (CSEUtils.isInstructionFile(((S3ObjectSummary)p.getLeft()).getKey()))
        {
          ConsistencyCheckerS3FileSystem.access$400().info("Skipping instruction file: '{}'", ((S3ObjectSummary)p.getLeft()).getKey());
          continue;
        }
        MutablePair<Entity, Boolean> entity = (MutablePair)entities.remove(
          ItemKeys.toItemKey(ConsistencyCheckerS3FileSystem.access$100(this$0), ((S3ObjectSummary)p.getLeft()).getKey()));
        FileStatusExt newFileStatus;
        if (entity != null) {
          newFileStatus = ConsistencyCheckerS3FileSystem.access$500(this$0, (S3ObjectSummary)p.getLeft(), (Entity)entity.getLeft(), true);
        } else {
          newFileStatus = ConsistencyCheckerS3FileSystem.access$500(this$0, (S3ObjectSummary)p.getLeft(), null, true);
        }
      }
      if ((includeDeleted) || (!newFileStatus.getMetadataEntryExists()) || (newFileStatus.getMetadataFile().getState() != EmrFsStore.MetadataFile.State.DELETED))
      {
        ConsistencyCheckerS3FileSystem.access$600(this$0, newFileStatus, throwOnDirectoryMismatch);
        results.add(newFileStatus);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.ConsistencyCheckerS3FileSystem.ListStatusWorker
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */