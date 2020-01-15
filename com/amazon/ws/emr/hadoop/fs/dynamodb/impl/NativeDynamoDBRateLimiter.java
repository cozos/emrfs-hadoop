package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Charsets;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.RateLimiter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.StopWatch;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NativeDynamoDBRateLimiter
{
  private static final Logger LOG = LoggerFactory.getLogger(NativeDynamoDBRateLimiter.class);
  private final double readPermitsPerSecond;
  private final double writePermitsPerSecond;
  private final RateLimiter readRateLimiter;
  private final RateLimiter writeRateLimiter;
  private final AtomicInteger readPermitDebt = new AtomicInteger(0);
  private final AtomicInteger writePermitDebt = new AtomicInteger(0);
  private final long readPermitTimeout;
  private final long writePermitTimeout;
  private static final int BYTES_PER_READ_CAPACITY_UNIT = 4096;
  private static final int BYTES_PER_WRITE_CAPACITY_UNIT = 1024;
  private final int THROTTLING_LOGGING_THRESHOLD = 1000;
  
  static enum RateLimiterType
  {
    READ,  WRITE;
    
    private RateLimiterType() {}
  }
  
  public NativeDynamoDBRateLimiter()
  {
    this(-1.0D, -1.0D);
  }
  
  public NativeDynamoDBRateLimiter(double readPermitsPerSecond, double writePermitsPerSecond)
  {
    this(readPermitsPerSecond, writePermitsPerSecond, 2147483647L, 2147483647L);
  }
  
  public NativeDynamoDBRateLimiter(double readPermitsPerSecond, double writePermitsPerSecond, long readPermitTimeout, long writePermitTimeout)
  {
    this.readPermitsPerSecond = readPermitsPerSecond;
    this.writePermitsPerSecond = writePermitsPerSecond;
    this.readPermitTimeout = readPermitTimeout;
    this.writePermitTimeout = writePermitTimeout;
    readRateLimiter = (this.readPermitsPerSecond > 0.0D ? RateLimiter.create(readPermitsPerSecond) : null);
    writeRateLimiter = (this.writePermitsPerSecond > 0.0D ? RateLimiter.create(writePermitsPerSecond) : null);
  }
  
  private void tryAcquire(RateLimiter rateLimiter, RateLimiterType type, int permits, long timeout, TimeUnit unit)
  {
    StopWatch stopwatch = new StopWatch();
    stopwatch.start();
    boolean acquired = rateLimiter.tryAcquire(permits, timeout, unit);
    stopwatch.stop();
    long elapsed = stopwatch.getTime();
    if (acquired)
    {
      LOG.debug("Acquired {} {} permits in {} {}", new Object[] { Integer.valueOf(permits), type, Long.valueOf(elapsed), TimeUnit.MILLISECONDS });
    }
    else
    {
      RuntimeException e = new RuntimeException(String.format("Timeout (%d %s) waiting for %d %s permits", new Object[] { Long.valueOf(timeout), unit, Integer.valueOf(permits), type }));
      throw e;
    }
  }
  
  public void beforeRead()
  {
    if (readRateLimiter != null)
    {
      int readPermits = readPermitDebt.getAndSet(-1) + 1;
      if (readPermits > 0) {
        tryAcquire(readRateLimiter, RateLimiterType.READ, readPermits, readPermitTimeout, TimeUnit.MILLISECONDS);
      } else {
        readPermitDebt.getAndAdd(readPermits);
      }
    }
  }
  
  private int getConsumedCapacity(ConsumedCapacity consumedCapacity)
  {
    if (consumedCapacity == null) {
      return 0;
    }
    return (int)Math.ceil(consumedCapacity.getCapacityUnits().doubleValue());
  }
  
  public double getReadPermitsPerSecond()
  {
    return readPermitsPerSecond;
  }
  
  public double getWritePermitsPerSecond()
  {
    return writePermitsPerSecond;
  }
  
  public void afterRead(ConsumedCapacity consumedReadCapacity)
  {
    afterRead(getConsumedCapacity(consumedReadCapacity));
  }
  
  public void afterRead(int consumedReadPermits)
  {
    readPermitDebt.addAndGet(consumedReadPermits);
  }
  
  public void beforeWrite(Map<String, AttributeValue> itemToWrite)
  {
    if (writeRateLimiter != null)
    {
      int estimatedWriteCapacity = estimateWriteCapacity(itemToWrite);
      int writePermits = writePermitDebt.getAndSet(0 - estimatedWriteCapacity) + estimatedWriteCapacity;
      if (writePermits > 0) {
        tryAcquire(writeRateLimiter, RateLimiterType.WRITE, writePermits, writePermitTimeout, TimeUnit.MILLISECONDS);
      } else {
        writePermitDebt.getAndAdd(writePermits);
      }
    }
  }
  
  public void afterWrite(ConsumedCapacity consumedWriteCapacity)
  {
    afterWrite(getConsumedCapacity(consumedWriteCapacity));
  }
  
  public void afterWrite(Collection<ConsumedCapacity> consumedWriteCapacities)
  {
    for (ConsumedCapacity c : consumedWriteCapacities) {
      afterWrite(getConsumedCapacity(c));
    }
  }
  
  public void afterWrite(int consumedWritePermits)
  {
    writePermitDebt.addAndGet(consumedWritePermits);
  }
  
  private int estimateReadCapacity(Map<String, AttributeValue> item)
  {
    double itemSize = estimateItemSize(item);
    return new Double(Math.ceil(itemSize / 4096.0D)).intValue();
  }
  
  private int estimateWriteCapacity(Map<String, AttributeValue> item)
  {
    double itemSize = estimateItemSize(item);
    return new Double(Math.ceil(itemSize / 1024.0D)).intValue();
  }
  
  private double estimateItemSize(Map<String, AttributeValue> item)
  {
    if ((item == null) || (item.isEmpty())) {
      return 1.0D;
    }
    double bytes = 0.0D;
    for (Map.Entry<String, AttributeValue> entry : item.entrySet())
    {
      bytes += ((String)entry.getKey()).getBytes(Charsets.UTF_8).length;
      if (((AttributeValue)entry.getValue()).getB() != null) {
        bytes += ((AttributeValue)entry.getValue()).getB().remaining();
      } else if (((AttributeValue)entry.getValue()).getS() != null) {
        bytes += ((AttributeValue)entry.getValue()).getS().getBytes(Charsets.UTF_8).length;
      } else if (((AttributeValue)entry.getValue()).getN() != null) {
        bytes += ((AttributeValue)entry.getValue()).getN().getBytes(Charsets.UTF_8).length;
      } else if ((((AttributeValue)entry.getValue()).getBS() != null) && (!((AttributeValue)entry.getValue()).getBS().isEmpty())) {
        for (ByteBuffer b : ((AttributeValue)entry.getValue()).getBS()) {
          bytes += b.remaining();
        }
      } else if ((((AttributeValue)entry.getValue()).getSS() != null) && (!((AttributeValue)entry.getValue()).getSS().isEmpty())) {
        for (String s : ((AttributeValue)entry.getValue()).getSS()) {
          bytes += s.getBytes(Charsets.UTF_8).length;
        }
      } else if ((((AttributeValue)entry.getValue()).getNS() != null) && (!((AttributeValue)entry.getValue()).getNS().isEmpty())) {
        for (String n : ((AttributeValue)entry.getValue()).getNS()) {
          bytes += n.getBytes(Charsets.UTF_8).length;
        }
      }
    }
    return bytes;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBRateLimiter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */