package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.consistency.ItemKeys;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import lombok.NonNull;

final class UploadObserverContexts
{
  private UploadObserverContexts()
  {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
  
  static ItemKey getItemKey(@NonNull UploadObserverContext context)
  {
    if (context == null) {
      throw new NullPointerException("context");
    }
    return ItemKeys.toItemKey(context.getBucket(), context.getKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UploadObserverContexts
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */