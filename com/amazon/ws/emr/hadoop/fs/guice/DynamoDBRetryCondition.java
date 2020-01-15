package com.amazon.ws.emr.hadoop.fs.guice;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBEntityStore;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreException;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreExceptionCode;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.RetriableEntityStoreException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedRetryPolicies.SDKDefaultRetryCondition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Pair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamoDBRetryCondition
  extends PredefinedRetryPolicies.SDKDefaultRetryCondition
{
  private static final Logger LOG = LoggerFactory.getLogger(DynamoDBRetryCondition.class);
  private final int UPDATE_THROUGHPUT_TIMEOUT_SECONDS = 300;
  private final String ENTITYSTORE_TAG_UPDATE_LOCK = "UpdateLock";
  private NativeDynamoDBEntityStore nativeDynamoDBEntityStore;
  private AtomicBoolean updating;
  private int maxErrorRetry;
  private long maxRead;
  private long maxWrite;
  private double factor;
  private String owner;
  private boolean autoIncrease;
  private AtomicLong throttled;
  
  public DynamoDBRetryCondition(AmazonDynamoDB dynamoDB, String tableName, int maxErrorRetry, boolean autoIncrease, boolean etagVerification, long maxRead, long maxWrite, double factor)
  {
    this.autoIncrease = autoIncrease;
    this.maxErrorRetry = maxErrorRetry;
    throttled = new AtomicLong(0L);
    if (autoIncrease)
    {
      updating = new AtomicBoolean(false);
      
      nativeDynamoDBEntityStore = new NativeDynamoDBEntityStore(dynamoDB).withAutoCreateTable(false).withTableName(tableName).withConditionalUpdate(true).withPrefetching(false).withEtagVerification(etagVerification);
      nativeDynamoDBEntityStore.initialize();
      this.maxRead = maxRead;
      this.maxWrite = maxWrite;
      this.factor = (1.0D + factor);
      try
      {
        owner = (Inet4Address.getLocalHost().getHostName() + "-");
      }
      catch (UnknownHostException e)
      {
        owner = "";
      }
      owner += UUID.randomUUID().toString();
    }
    else
    {
      LOG.debug("Throughput auto-increase is disabled.");
    }
  }
  
  static class UpdateLock
  {
    String owner;
    boolean completed;
    long timeout;
    
    UpdateLock(String owner, boolean completed, long timeout)
    {
      this.owner = owner;
      this.completed = completed;
      this.timeout = timeout;
    }
    
    byte[] toByteArray()
    {
      return new Gson().toJson(this).getBytes();
    }
    
    static UpdateLock fromByteArray(byte[] bytes)
    {
      return (UpdateLock)new Gson().fromJson(new String(bytes), UpdateLock.class);
    }
  }
  
  private void sleep(int seconds)
  {
    try
    {
      TimeUnit.SECONDS.sleep(seconds);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  static enum DynamoDBOpType
  {
    READ,  WRITE,  OTHER;
    
    private DynamoDBOpType() {}
  }
  
  private DynamoDBOpType getDynamoDBOpType(AmazonWebServiceRequest request)
  {
    if (((request instanceof BatchGetItemRequest)) || ((request instanceof GetItemRequest)) || ((request instanceof QueryRequest)) || ((request instanceof ScanRequest))) {
      return DynamoDBOpType.READ;
    }
    if (((request instanceof BatchWriteItemRequest)) || ((request instanceof DeleteItemRequest)) || ((request instanceof PutItemRequest)) || ((request instanceof UpdateItemRequest))) {
      return DynamoDBOpType.WRITE;
    }
    return DynamoDBOpType.OTHER;
  }
  
  public boolean lockBeforeIncrease()
  {
    long timeout = DateTime.now().plusSeconds(300).getMillis();
    UpdateLock newUpdateLock = new UpdateLock(owner, false, timeout);
    ItemKey itemKey = new ItemKey("MultiKeyStoreTag", "UpdateLock");
    try
    {
      Entity entity = nativeDynamoDBEntityStore.retrieve(itemKey);
      if (entity == null)
      {
        nativeDynamoDBEntityStore.create(new Entity(itemKey, newUpdateLock.toByteArray()));
        return true;
      }
      UpdateLock currentUpdateLock = UpdateLock.fromByteArray(entity.getPayload());
      if ((completed) || 
        (DateTime.now().getMillis() > timeout) || 
        (owner.equals(owner)))
      {
        nativeDynamoDBEntityStore.update(entity.withPayload(newUpdateLock.toByteArray()));
        return true;
      }
      return false;
    }
    catch (EntityStoreException e)
    {
      if ((e.getEntityStoreExceptionCode() == EntityStoreExceptionCode.ALREADY_EXISTS) || 
        (e.getEntityStoreExceptionCode() == EntityStoreExceptionCode.STALE_ENTITY))
      {
        LOG.debug("Throughput is being updated by another thread.");
        return false;
      }
      throw e;
    }
    catch (RetriableEntityStoreException e) {}
    return false;
  }
  
  public boolean unlockAfterIncrease()
  {
    ItemKey itemKey = new ItemKey("MultiKeyStoreTag", "UpdateLock");
    try
    {
      Entity entity = nativeDynamoDBEntityStore.retrieve(itemKey);
      if (entity == null)
      {
        LOG.warn("Lock item has been deleted from DynamoDB unexpectedly");
        return true;
      }
      UpdateLock currentUpdateLock = UpdateLock.fromByteArray(entity.getPayload());
      if (owner.equals(owner))
      {
        nativeDynamoDBEntityStore.delete(entity);
        return true;
      }
      LOG.warn("Throughput is being updated by another thread {}, possibly due to timeout.", owner);
      return true;
    }
    catch (EntityStoreException e)
    {
      if (e.getEntityStoreExceptionCode() == EntityStoreExceptionCode.STALE_ENTITY)
      {
        LOG.warn("Throughput is being updated by another thread.");
        return true;
      }
      throw e;
    }
    catch (RetriableEntityStoreException e) {}
    return false;
  }
  
  private void autoIncrease(DynamoDBOpType opType)
  {
    if (!updating.getAndSet(true))
    {
      Pair<Long, Long> throughputSettings = nativeDynamoDBEntityStore.getProvisionedThroughput();
      if (throughputSettings != null)
      {
        long targetWrite;
        long targetRead;
        long targetWrite;
        if (opType == DynamoDBOpType.READ)
        {
          long targetRead = Math.min((((Long)throughputSettings.getLeft()).longValue() * factor), maxRead);
          targetWrite = ((Long)throughputSettings.getRight()).longValue();
        }
        else
        {
          targetRead = ((Long)throughputSettings.getLeft()).longValue();
          targetWrite = Math.min((((Long)throughputSettings.getRight()).longValue() * factor), maxWrite);
        }
        LOG.info("Trying to increase provisioned throughput to READ: {}, WRITE: {}.", Long.valueOf(targetRead), Long.valueOf(targetWrite));
      }
      else
      {
        LOG.debug("Provisioned throughput is being increased by another thread, try later.");
        updating.set(false); return;
      }
      long targetWrite;
      long targetRead;
      DateTime timeout = DateTime.now().plusSeconds(300);
      int attempts = 10;
      while (DateTime.now().isBefore(timeout)) {
        try
        {
          if (!lockBeforeIncrease())
          {
            LOG.debug("Cannot acquire lock, try later");
            sleep(3);
          }
          else
          {
            throughputSettings = nativeDynamoDBEntityStore.getProvisionedThroughput();
            if (throughputSettings == null)
            {
              sleep(3);
            }
            else
            {
              boolean shouldUpdate = false;
              if (((Long)throughputSettings.getLeft()).longValue() < targetRead) {
                shouldUpdate = true;
              } else {
                targetRead = ((Long)throughputSettings.getLeft()).longValue();
              }
              if (((Long)throughputSettings.getRight()).longValue() < targetWrite) {
                shouldUpdate = true;
              } else {
                targetWrite = ((Long)throughputSettings.getRight()).longValue();
              }
              if (shouldUpdate)
              {
                nativeDynamoDBEntityStore.setReadCapacityUnits(Long.valueOf(targetRead));
                nativeDynamoDBEntityStore.setWriteCapacityUnits(Long.valueOf(targetWrite));
                nativeDynamoDBEntityStore.updateProvisionedThroughput();
                LOG.info("Provisioned throughput for table {} is now READ: {}, WRITE: {}", new Object[] {nativeDynamoDBEntityStore
                  .getTableName(), nativeDynamoDBEntityStore
                  .getReadCapacityUnits(), nativeDynamoDBEntityStore
                  .getWriteCapacityUnits() });
              }
              else
              {
                LOG.info("Throughput has been increased to the desired value by another thread, no need to update again");
              }
              unlockAfterIncrease();
            }
          }
        }
        catch (AmazonClientException e)
        {
          LOG.error("Error while updating provisioned throughput", e.getMessage());
          attempts--;
          if (attempts <= 0)
          {
            updating.set(false);
            throw e;
          }
        }
      }
      updating.set(false);
    }
    else
    {
      DateTime timeout = DateTime.now().plusSeconds(300);
      while (updating.get())
      {
        sleep(1);
        if (DateTime.now().isAfter(timeout))
        {
          LOG.warn("Timeout waiting for throughput to be updated");
          updating.set(false);
        }
      }
    }
  }
  
  private boolean shouldIncrease(int retriesAttempted)
  {
    return (updating.get()) || (retriesAttempted >= maxErrorRetry);
  }
  
  private boolean shouldLog(int retriesAttempted)
  {
    return (throttled.getAndIncrement() % 100L == 0L) || (retriesAttempted >= maxErrorRetry);
  }
  
  public boolean shouldRetry(AmazonWebServiceRequest originalRequest, AmazonClientException exception, int retriesAttempted)
  {
    if (exception.getClass().equals(ProvisionedThroughputExceededException.class))
    {
      if (shouldLog(retriesAttempted)) {
        LOG.info("Metadata access attempt {} failed due to {} on {}: {}", new Object[] {
          Integer.valueOf(retriesAttempted), exception
          .getClass().getSimpleName(), originalRequest
          .getClass().getSimpleName(), originalRequest });
      }
      if (!autoIncrease) {
        return true;
      }
      DynamoDBOpType opType = getDynamoDBOpType(originalRequest);
      if (((opType == DynamoDBOpType.READ) && (nativeDynamoDBEntityStore.getReadCapacityUnits().longValue() >= maxRead)) || ((opType == DynamoDBOpType.WRITE) && 
        (nativeDynamoDBEntityStore.getWriteCapacityUnits().longValue() >= maxWrite)) || (opType == DynamoDBOpType.OTHER)) {
        return true;
      }
      if (shouldIncrease(retriesAttempted)) {
        autoIncrease(opType);
      }
      return true;
    }
    return retriesAttempted >= maxErrorRetry ? false : super.shouldRetry(originalRequest, exception, retriesAttempted);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.guice.DynamoDBRetryCondition
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */