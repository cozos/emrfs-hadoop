package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.consistency.Entities;
import com.amazon.ws.emr.hadoop.fs.consistency.ItemKeys;
import com.amazon.ws.emr.hadoop.fs.consistency.concurrent.ConcurrencyToken;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStore;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import java.io.IOException;
import javax.annotation.Nullable;
import lombok.NonNull;

public final class DefaultConcurrencyTokenResolver
  implements ConcurrencyTokenResolver
{
  @NonNull
  private final EntityStore<Entity> entityStore;
  
  public DefaultConcurrencyTokenResolver(@NonNull EntityStore<Entity> entityStore)
  {
    if (entityStore == null) {
      throw new NullPointerException("entityStore");
    }
    this.entityStore = entityStore;
  }
  
  public ConcurrencyToken resolve(UploadObserverContext context)
    throws IOException
  {
    ConcurrencyToken token = getConcurrencyTokenFromContext(context);
    return token != null ? token : getNewConcurrencyToken(context);
  }
  
  private ConcurrencyToken getConcurrencyTokenFromContext(UploadObserverContext context)
  {
    ExtraUploadMetadata metadata = context.getExtraUploadMetadata();
    return metadata.getConcurrencyToken();
  }
  
  private ConcurrencyToken getNewConcurrencyToken(UploadObserverContext context)
    throws IOException
  {
    ItemKey itemKey = UploadObserverContexts.getItemKey(context);
    Entity entity = entityStore.retrieve(itemKey);
    checkNotDirectory(entity);
    return ConcurrencyToken.of(entity);
  }
  
  private void checkNotDirectory(@Nullable Entity entity)
    throws IOException
  {
    if (Entities.isDirectory(entity)) {
      throw new IOException(String.format("Metadata at '%s' is for an existent directory", new Object[] {
        ItemKeys.toPathString(entity.getItemKey()) }));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.DefaultConcurrencyTokenResolver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */