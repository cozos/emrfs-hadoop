package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagedFileHandle;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.UploadMetadata;
import java.io.IOException;
import lombok.NonNull;

public final class StagingMultipartUploadDispatcher
  implements MultipartUploadDispatcher
{
  @NonNull
  private final StagedFileHandle stagedFileHandle;
  @NonNull
  private final MultipartUploadDispatcher fallbackDispatcher;
  
  public StagingMultipartUploadDispatcher(@NonNull StagedFileHandle stagedFileHandle, @NonNull MultipartUploadDispatcher fallbackDispatcher)
  {
    if (stagedFileHandle == null) {
      throw new NullPointerException("stagedFileHandle");
    }
    if (fallbackDispatcher == null) {
      throw new NullPointerException("fallbackDispatcher");
    }
    this.stagedFileHandle = stagedFileHandle;this.fallbackDispatcher = fallbackDispatcher;
  }
  
  public void complete(CompleteMultipartUploadEvent event)
    throws IOException
  {
    validateNoConcurrencyToken(event);
    stagedFileHandle.complete(UploadMetadata.of(event
      .getUploadId(), event
      .getPartETags(), event
      .getTotalLength().longValue()));
  }
  
  public void abort(AbortMultipartUploadEvent event)
    throws IOException
  {
    fallbackDispatcher.abort(event);
  }
  
  private void validateNoConcurrencyToken(CompleteMultipartUploadEvent event)
  {
    ExtraUploadMetadata extraUploadMetadata = event.getExtraUploadMetadata();
    Preconditions.checkArgument(extraUploadMetadata.getConcurrencyToken() == null, "Expected event not to contain a ConcurrencyToken");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.StagingMultipartUploadDispatcher
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */