package com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory;

import com.amazon.ws.emr.hadoop.fs.staging.DeferredUpload;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagedFileHandle;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.UploadMetadata;
import java.io.IOException;
import java.util.NavigableMap;
import lombok.NonNull;
import org.slf4j.Logger;

final class InMemoryStagingDirectory$InternalFileHandle
  implements StagedFileHandle
{
  private final Key key;
  
  public InMemoryStagingDirectory$InternalFileHandle(InMemoryStagingDirectory paramInMemoryStagingDirectory, Key key)
  {
    this.key = key;
  }
  
  public void complete(@NonNull UploadMetadata uploadMetadata)
    throws IOException
  {
    if (uploadMetadata == null) {
      throw new NullPointerException("uploadMetadata");
    }
    InMemoryStagingDirectory.access$000(this$0);
    DeferredUpload previousUpload = (DeferredUpload)InMemoryStagingDirectory.access$200(this$0).put(key, InMemoryStagingDirectory.access$100(this$0, uploadMetadata));
    if ((previousUpload != null) && 
      (!previousUpload.getMetadata().getUploadId().equals(uploadMetadata.getUploadId()))) {
      abortPreviousUpload(previousUpload);
    }
  }
  
  public String toString()
  {
    return String.format("Handle for '%s'", new Object[] { InMemoryStagingDirectory.access$300(this$0, key) });
  }
  
  private void abortPreviousUpload(DeferredUpload upload)
  {
    try
    {
      InMemoryStagingDirectory.access$400(this$0, key, upload.getMetadata());
    }
    catch (IOException e)
    {
      InMemoryStagingDirectory.access$500().error("Failed to abort the previous deferred upload for '{}'", 
        InMemoryStagingDirectory.access$300(this$0, key), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory.InMemoryStagingDirectory.InternalFileHandle
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */