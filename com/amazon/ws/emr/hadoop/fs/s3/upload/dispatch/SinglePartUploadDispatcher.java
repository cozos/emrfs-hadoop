package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import java.io.IOException;

public abstract interface SinglePartUploadDispatcher
{
  public abstract void create(ObjectCreationEvent paramObjectCreationEvent)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.SinglePartUploadDispatcher
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */