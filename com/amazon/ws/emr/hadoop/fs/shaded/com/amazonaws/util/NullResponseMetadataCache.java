package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public class NullResponseMetadataCache
  implements MetadataCache
{
  public void add(Object obj, ResponseMetadata metadata) {}
  
  public ResponseMetadata get(Object obj)
  {
    throw new SdkClientException("Response metadata caching is not enabled");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.NullResponseMetadataCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */