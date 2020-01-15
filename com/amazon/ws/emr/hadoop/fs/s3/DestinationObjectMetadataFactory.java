package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;

abstract interface DestinationObjectMetadataFactory
{
  public abstract ObjectMetadata createFromSource(ObjectMetadata paramObjectMetadata);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.DestinationObjectMetadataFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */