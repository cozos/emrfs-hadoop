package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;

public class GzipDecompressingEntity
  extends DecompressingEntity
{
  public GzipDecompressingEntity(HttpEntity entity)
  {
    super(entity, GZIPInputStreamFactory.getInstance());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.GzipDecompressingEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */