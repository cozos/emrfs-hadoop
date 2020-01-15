package com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory;

import com.amazon.ws.emr.hadoop.fs.staging.path.StagingRoot;
import org.apache.hadoop.fs.staging.StagingDirectoryNotFoundException;

class DeletedStagingDirectoryException
  extends StagingDirectoryNotFoundException
{
  DeletedStagingDirectoryException(StagingRoot root)
  {
    super(root.getOutputPath(), root.getStageName());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory.DeletedStagingDirectoryException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */