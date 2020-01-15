package com.amazon.ws.emr.hadoop.fs.consistency.concurrent;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreException;
import java.io.IOException;

public abstract interface ConcurrentWriteHandler
{
  public abstract void handle(Entity paramEntity, EntityStoreException paramEntityStoreException)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.concurrent.ConcurrentWriteHandler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */