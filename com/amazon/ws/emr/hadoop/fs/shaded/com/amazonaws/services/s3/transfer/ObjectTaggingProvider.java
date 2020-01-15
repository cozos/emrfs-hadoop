package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectTagging;

public abstract interface ObjectTaggingProvider
{
  public abstract ObjectTagging provideObjectTags(UploadContext paramUploadContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.ObjectTaggingProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */