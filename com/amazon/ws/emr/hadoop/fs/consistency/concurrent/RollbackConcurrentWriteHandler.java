package com.amazon.ws.emr.hadoop.fs.consistency.concurrent;

import com.amazon.ws.emr.hadoop.fs.consistency.Entities;
import com.amazon.ws.emr.hadoop.fs.consistency.ItemKeys;
import com.amazon.ws.emr.hadoop.fs.consistency.exception.ConcurrentWriteException;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreException;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import java.io.IOException;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class RollbackConcurrentWriteHandler
  implements ConcurrentWriteHandler
{
  private static final Logger logger = LoggerFactory.getLogger(RollbackConcurrentWriteHandler.class);
  private static final String DIRECTORY_WRITE_TYPE = "directory";
  private static final String FILE_WRITE_TYPE = "file";
  @NonNull
  private final AmazonS3Lite s3;
  
  public RollbackConcurrentWriteHandler(@NonNull AmazonS3Lite s3)
  {
    if (s3 == null) {
      throw new NullPointerException("s3");
    }
    this.s3 = s3;
  }
  
  public void handle(Entity entity, EntityStoreException cause)
    throws IOException
  {
    ConcurrentWrites.checkCausedByConcurrentWrite(cause);
    ItemKey itemKey = entity.getItemKey();
    boolean isDirectory = Entities.isDirectory(entity);
    ConcurrentWriteException toThrow = newConcurrentWriteException(itemKey, isDirectory, cause);
    try
    {
      rollbackUpload(itemKey, isDirectory);
    }
    catch (AmazonClientException e)
    {
      logger.warn("Unable to delete orphan S3 object '{}'.", ItemKeys.toPathString(itemKey), e);
      toThrow.addSuppressed(e);
    }
    throw toThrow;
  }
  
  private void rollbackUpload(ItemKey itemKey, boolean isDirectory)
  {
    logger.warn("Rolling back {} write at {} due to concurrent write", 
      getWriteType(isDirectory), ItemKeys.toPathString(itemKey));
    
    String bucket = ItemKeys.getBucket(itemKey);
    String key = ItemKeys.getS3KeyFromMetadata(itemKey, isDirectory);
    s3.deleteObject(bucket, key);
  }
  
  private static ConcurrentWriteException newConcurrentWriteException(ItemKey itemKey, boolean isDirectory, Throwable cause)
  {
    return new ConcurrentWriteException(String.format("Unable to create %1$s due to concurrent write, %1$s potentially corrupted at '%2$s'", new Object[] {
    
      getWriteType(isDirectory), ItemKeys.toPathString(itemKey) }), cause);
  }
  
  private static String getWriteType(boolean isDirectory)
  {
    return isDirectory ? "directory" : "file";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.concurrent.RollbackConcurrentWriteHandler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */