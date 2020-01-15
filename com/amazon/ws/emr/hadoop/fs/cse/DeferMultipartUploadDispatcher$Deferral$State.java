package com.amazon.ws.emr.hadoop.fs.cse;

 enum DeferMultipartUploadDispatcher$Deferral$State
{
  INITIALIZED,  PENDING,  RESUMING,  RESUME_FAILED,  RESUMED,  CANCELLED;
  
  private DeferMultipartUploadDispatcher$Deferral$State() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.cse.DeferMultipartUploadDispatcher.Deferral.State
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */