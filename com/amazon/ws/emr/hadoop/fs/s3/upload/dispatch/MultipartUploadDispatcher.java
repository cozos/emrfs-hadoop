package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import java.io.IOException;

public abstract interface MultipartUploadDispatcher
{
  public abstract void complete(CompleteMultipartUploadEvent paramCompleteMultipartUploadEvent)
    throws IOException;
  
  public abstract void abort(AbortMultipartUploadEvent paramAbortMultipartUploadEvent)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.MultipartUploadDispatcher
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */