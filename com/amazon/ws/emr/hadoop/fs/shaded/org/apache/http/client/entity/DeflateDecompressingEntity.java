package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;

public class DeflateDecompressingEntity
  extends DecompressingEntity
{
  public DeflateDecompressingEntity(HttpEntity entity)
  {
    super(entity, DeflateInputStreamFactory.getInstance());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.DeflateDecompressingEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */