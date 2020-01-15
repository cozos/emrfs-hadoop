package com.amazon.ws.emr.hadoop.fs.consistency.concurrent;

import com.amazon.ws.emr.hadoop.fs.consistency.Entities;
import com.amazon.ws.emr.hadoop.fs.consistency.ItemKeys;
import com.amazon.ws.emr.hadoop.fs.consistency.exception.UnknownMetadataStateException;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStore;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import lombok.NonNull;

final class CheckMetadataConcurrentWriteHandler
  implements ConcurrentWriteHandler
{
  @NonNull
  private final EntityStore<Entity> entityStore;
  @NonNull
  private final ConcurrentWriteHandler fallbackHandler;
  
  public CheckMetadataConcurrentWriteHandler(@NonNull EntityStore<Entity> entityStore, @NonNull ConcurrentWriteHandler fallbackHandler)
  {
    if (entityStore == null) {
      throw new NullPointerException("entityStore");
    }
    if (fallbackHandler == null) {
      throw new NullPointerException("fallbackHandler");
    }
    this.entityStore = entityStore;this.fallbackHandler = fallbackHandler;
  }
  
  public void handle(Entity entity, EntityStoreException cause)
    throws IOException
  {
    ConcurrentWrites.checkCausedByConcurrentWrite(cause);
    ItemKey itemKey = entity.getItemKey();
    boolean isDirectory = Entities.isDirectory(entity);
    if (!doesMetadataMatchWhatWasWritten(itemKey, isDirectory, cause)) {
      fallbackHandler.handle(entity, cause);
    }
  }
  
  private boolean doesMetadataMatchWhatWasWritten(ItemKey itemKey, boolean isDirectory, EntityStoreException cause)
    throws IOException
  {
    try
    {
      Entity conflictingEntity = entityStore.retrieve(itemKey);
      if (conflictingEntity == null) {
        throw newUnknownMetadataStateException(itemKey, cause);
      }
      return Entities.isExistentWithIsDirectory(conflictingEntity, isDirectory);
    }
    catch (InvalidProtocolBufferException|RuntimeException e)
    {
      IOException toThrow = newCheckMetadataException(itemKey, e);
      toThrow.addSuppressed(cause);
      throw toThrow;
    }
  }
  
  private static UnknownMetadataStateException newUnknownMetadataStateException(ItemKey itemKey, Throwable cause)
  {
    return new UnknownMetadataStateException(String.format("Metadata at '%s' is in unknown state, retrieved entity from concurrent write is absent", new Object[] {
    
      ItemKeys.toPathString(itemKey) }), cause);
  }
  
  private static IOException newCheckMetadataException(ItemKey itemKey, Throwable cause)
  {
    return new IOException(String.format("Failed to check metadata at '%s' when handling failure caused by concurrent write", new Object[] {
    
      ItemKeys.toPathString(itemKey) }), cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.concurrent.CheckMetadataConcurrentWriteHandler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */