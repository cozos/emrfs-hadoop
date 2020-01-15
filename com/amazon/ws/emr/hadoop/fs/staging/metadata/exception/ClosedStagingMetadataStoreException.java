package com.amazon.ws.emr.hadoop.fs.staging.metadata.exception;

import java.io.IOException;

public class ClosedStagingMetadataStoreException
  extends IOException
{
  public ClosedStagingMetadataStoreException()
  {
    super("Staging metadata store is closed");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.exception.ClosedStagingMetadataStoreException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */