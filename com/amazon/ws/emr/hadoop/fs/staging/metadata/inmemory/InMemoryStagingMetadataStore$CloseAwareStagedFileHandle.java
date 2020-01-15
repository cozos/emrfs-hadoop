package com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory;

import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagedFileHandle;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.UploadMetadata;
import java.io.IOException;

final class InMemoryStagingMetadataStore$CloseAwareStagedFileHandle
  implements StagedFileHandle
{
  private final StagedFileHandle delegate;
  
  public InMemoryStagingMetadataStore$CloseAwareStagedFileHandle(InMemoryStagingMetadataStore paramInMemoryStagingMetadataStore, StagedFileHandle delegate)
  {
    this.delegate = delegate;
  }
  
  public void complete(UploadMetadata uploadMetadata)
    throws IOException
  {
    InMemoryStagingMetadataStore.access$000(this$0);
    delegate.complete(uploadMetadata);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory.InMemoryStagingMetadataStore.CloseAwareStagedFileHandle
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */