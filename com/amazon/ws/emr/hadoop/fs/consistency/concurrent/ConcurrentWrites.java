package com.amazon.ws.emr.hadoop.fs.consistency.concurrent;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStore;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreException;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreExceptionCode;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import lombok.NonNull;

public final class ConcurrentWrites
{
  private ConcurrentWrites()
  {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
  
  public static boolean isCausedByConcurrentWrite(@NonNull EntityStoreException exception)
  {
    if (exception == null) {
      throw new NullPointerException("exception");
    }
    EntityStoreExceptionCode code = exception.getEntityStoreExceptionCode();
    return (code == EntityStoreExceptionCode.ALREADY_EXISTS) || (code == EntityStoreExceptionCode.STALE_ENTITY);
  }
  
  public static void checkCausedByConcurrentWrite(EntityStoreException exception)
  {
    Preconditions.checkArgument(isCausedByConcurrentWrite(exception), "Exception (code: %s) was not due to concurrent write: %s", new Object[] {exception
    
      .getEntityStoreExceptionCode(), exception });
  }
  
  public static ConcurrentWriteHandler defaultHandler(EntityStore<Entity> entityStore, AmazonS3Lite s3)
  {
    ConcurrentWriteHandler fallbackHandler = new RollbackConcurrentWriteHandler(s3);
    return new CheckMetadataConcurrentWriteHandler(entityStore, fallbackHandler);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.concurrent.ConcurrentWrites
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */