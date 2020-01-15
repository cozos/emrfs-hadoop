package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile;
import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.Builder;
import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.State;
import com.amazon.ws.emr.hadoop.fs.consistency.ItemKeys;
import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStore;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreException;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreExceptionCode;
import java.io.IOException;
import lombok.NonNull;

public class CopyMetadataObserver
  implements UploadObserver
{
  @NonNull
  private final EntityStore<Entity> entityStore;
  
  public CopyMetadataObserver(@NonNull EntityStore<Entity> entityStore)
  {
    if (entityStore == null) {
      throw new NullPointerException("entityStore");
    }
    this.entityStore = entityStore;
  }
  
  public void afterUploadCompletion(UploadObserverContext context)
    throws IOException
  {
    if (!CSEUtils.isInstructionFile(context.getKey())) {
      createMetadata(context);
    }
  }
  
  private void createMetadata(UploadObserverContext context)
    throws IOException
  {
    EmrFsStore.MetadataFile metadataFile = EmrFsStore.MetadataFile.newBuilder().setIsDirectory(false).setState(EmrFsStore.MetadataFile.State.PUT).setVersion(1).build();
    String etag = (String)context.getStore().get(UploadObserverContext.ETAG_VERIFICATION_KEY);
    ItemKey itemKey = ItemKeys.toItemKey(context.getBucket(), context.getKey());
    try
    {
      entityStore.create(new Entity(itemKey, metadataFile.toByteArray()).withEtag(etag));
    }
    catch (EntityStoreException e)
    {
      handleEntityStoreCreateException(e, itemKey, metadataFile, etag);
    }
  }
  
  private void handleEntityStoreCreateException(EntityStoreException e, ItemKey itemKey, EmrFsStore.MetadataFile metadata, String etag)
    throws IOException
  {
    if ((e.getEntityStoreExceptionCode() == EntityStoreExceptionCode.ALREADY_EXISTS) || 
      (e.getEntityStoreExceptionCode() == EntityStoreExceptionCode.STALE_ENTITY))
    {
      Entity entity = entityStore.retrieve(itemKey);
      EmrFsStore.MetadataFile currentMetadata = EmrFsStore.MetadataFile.parseFrom(entity.getPayload());
      if (currentMetadata.getState() == EmrFsStore.MetadataFile.State.DELETED)
      {
        entity.setDeletionTTL(0L);
        entity.setPayload(metadata.toByteArray());
        entity.setEtag(etag);
        try
        {
          entityStore.update(entity);
          return;
        }
        catch (EntityStoreException ex)
        {
          if (ex.getEntityStoreExceptionCode() == EntityStoreExceptionCode.STALE_ENTITY) {
            return;
          }
          e = ex;
        }
      }
    }
    throw new IOException(e);
  }
  
  public void beforeUploadCompletion(UploadObserverContext context)
    throws IOException
  {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.CopyMetadataObserver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */