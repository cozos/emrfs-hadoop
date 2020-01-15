package com.amazon.ws.emr.hadoop.fs.staging.metadata;

import java.io.IOException;

public abstract interface StagedFileHandle
{
  public abstract void complete(UploadMetadata paramUploadMetadata)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.StagedFileHandle
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */