package com.amazon.ws.emr.hadoop.fs.s3.lite.provider;

import com.amazon.ws.emr.hadoop.fs.s3.lite.factory.S3Factory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheLoader;
import javax.annotation.Nullable;

class DefaultS3Provider$S3CacheLoader
  extends CacheLoader<String, C>
{
  S s3Configuration;
  
  DefaultS3Provider$S3CacheLoader(@Nullable S arg1)
  {
    this.s3Configuration = s3Configuration;
  }
  
  public C load(String endpoint)
  {
    C client = (AmazonS3Client)newClient().withEndpoint(endpoint);
    addRequestHandlers(client);
    return client;
  }
  
  private C newClient()
  {
    return (AmazonS3Client)DefaultS3Provider.access$000(this$0).newS3(s3Configuration);
  }
  
  private void addRequestHandlers(C s3)
  {
    for (RequestHandler2 requestHandler : DefaultS3Provider.access$100(this$0)) {
      s3.addRequestHandler(requestHandler);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.provider.DefaultS3Provider.S3CacheLoader
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */