package com.amazon.ws.emr.hadoop.fs.consistency;

import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile;
import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.State;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStore;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.InvalidProtocolBufferException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeletionTTLUtils
{
  private static final int PROGRESS_MESSAGE_ROW_COUNT = 10000;
  private static final Logger LOG = LoggerFactory.getLogger(DeletionTTLUtils.class);
  
  public static boolean hasInvalidTTLField(EntityStore<Entity> entityStore)
    throws InvalidProtocolBufferException
  {
    boolean hasValidationError = false;
    int count = 0;
    for (Entity entity : entityStore.dump())
    {
      count++;
      EmrFsStore.MetadataFile metadataFile = EmrFsStore.MetadataFile.parseFrom(entity.getPayload());
      if (metadataFile == null)
      {
        String message = "MISSING METAFILE: HashKey: " + entity.getItemKey().getHashKey() + " RangeKey:" + entity.getItemKey().getRangeKey();
        LOG.warn(message);
        hasValidationError = true;
      }
      else
      {
        Long timeStamp = entity.getDeletionTTL();
        if (metadataFile.getState() == EmrFsStore.MetadataFile.State.DELETED)
        {
          if (isTTLEmpty(timeStamp))
          {
            String message = "MISSING TTL FIELD: HashKey: " + entity.getItemKey().getHashKey() + " RangeKey:" + entity.getItemKey().getRangeKey();
            hasValidationError = true;
            LOG.error(message);
          }
        }
        else if (!isTTLEmpty(timeStamp))
        {
          String message = "HAS UNEXPECTED TTL FIELD: HashKey: " + entity.getItemKey().getHashKey() + " RangeKey:" + entity.getItemKey().getRangeKey();
          hasValidationError = true;
          LOG.error(message);
        }
        if (count % 10000 == 0) {
          LOG.info("Progress: Total Items Verified: {}", Integer.valueOf(count));
        }
      }
    }
    LOG.info("Validated {} items for proper TTL Values. Table Name: {}", Integer.valueOf(count), entityStore.getTableName());
    return hasValidationError;
  }
  
  public static void populateTTL(EntityStore<Entity> entityStore, long timeToExpireInSeconds)
    throws InvalidProtocolBufferException
  {
    int updateCount = 0;
    int readCount = 0;
    for (Entity entity : entityStore.dump())
    {
      EmrFsStore.MetadataFile metadataFile = EmrFsStore.MetadataFile.parseFrom(entity.getPayload());
      if (metadataFile == null)
      {
        String message = "MISSING METAFILE: HashKey: " + entity.getItemKey().getHashKey() + " RangeKey:" + entity.getItemKey().getRangeKey();
        LOG.warn(message);
      }
      else
      {
        Long timeStamp = entity.getDeletionTTL();
        if ((metadataFile.getState() == EmrFsStore.MetadataFile.State.DELETED) && 
          (isTTLEmpty(timeStamp)))
        {
          updateCount++;
          entity.setDeletionTTL(DateTime.now().getMillis() / 1000L + timeToExpireInSeconds);
          entityStore.update(entity);
        }
        readCount++;
        if (readCount % 10000 == 0) {
          LOG.info("Progress: Total Items Read: {}, Total Updated items: {}", Integer.valueOf(readCount), Integer.valueOf(updateCount));
        }
      }
    }
    LOG.info("Completed: Read {} entries and populated {} entries with TTL Values. Table Name: {}", new Object[] {
      Integer.valueOf(readCount), Integer.valueOf(updateCount), entityStore.getTableName() });
  }
  
  public static boolean isTTLEmpty(Long timeStamp)
  {
    return (timeStamp == null) || (timeStamp.longValue() == 0L);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.DeletionTTLUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */