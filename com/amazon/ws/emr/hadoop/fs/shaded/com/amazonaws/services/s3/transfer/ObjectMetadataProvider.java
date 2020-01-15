package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import java.io.File;

public abstract interface ObjectMetadataProvider
{
  public abstract void provideObjectMetadata(File paramFile, ObjectMetadata paramObjectMetadata);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.ObjectMetadataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */