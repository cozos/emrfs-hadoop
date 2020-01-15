package com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.MultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingRoot;

abstract interface StagingDirectoryFactory
{
  public abstract StagingDirectory create(StagingRoot paramStagingRoot, MultipartUploadDispatcher paramMultipartUploadDispatcher);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory.StagingDirectoryFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */