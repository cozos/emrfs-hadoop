package com.amazon.ws.emr.hadoop.fs.s3.lite;

import com.amazon.ws.emr.hadoop.fs.consistency.exception.ConsistencyException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import org.apache.hadoop.fs.Path;

public abstract interface ConsistencyExceptionThrowableObjectMetadataRetriever
{
  public abstract ObjectMetadata get(Path paramPath)
    throws ConsistencyException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.ConsistencyExceptionThrowableObjectMetadataRetriever
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */