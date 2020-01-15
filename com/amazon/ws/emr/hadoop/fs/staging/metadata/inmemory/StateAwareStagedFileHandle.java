package com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory;

import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagedFileHandle;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.UploadMetadata;
import java.io.IOException;
import lombok.NonNull;

final class StateAwareStagedFileHandle
  implements StagedFileHandle
{
  @NonNull
  private final StagedFileHandle fileHandle;
  
  public StateAwareStagedFileHandle(@NonNull StagedFileHandle fileHandle)
  {
    if (fileHandle == null) {
      throw new NullPointerException("fileHandle");
    }
    this.fileHandle = fileHandle;
  }
  
  private State state = State.PENDING;
  
  private static enum State
  {
    PENDING,  COMPLETED,  IN_ERROR;
    
    private State() {}
  }
  
  public void complete(@NonNull UploadMetadata uploadMetadata)
    throws IOException
  {
    if (uploadMetadata == null) {
      throw new NullPointerException("uploadMetadata");
    }
    checkPending();
    try
    {
      fileHandle.complete(uploadMetadata);
      state = State.COMPLETED;
    }
    catch (IOException|RuntimeException e)
    {
      state = State.IN_ERROR;
      throw e;
    }
  }
  
  private void checkPending()
    throws IOException
  {
    if (state != State.PENDING) {
      throw new IOException(String.format("%s must be %s but is %s", new Object[] { fileHandle, State.PENDING, state }));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory.StateAwareStagedFileHandle
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */