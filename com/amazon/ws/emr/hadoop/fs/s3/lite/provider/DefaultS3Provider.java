package com.amazon.ws.emr.hadoop.fs.s3.lite.provider;

import com.amazon.ws.emr.hadoop.fs.s3.lite.factory.S3Factory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LoadingCache;
import java.util.List;
import javax.annotation.Nullable;

public final class DefaultS3Provider<C extends AmazonS3Client, S>
  implements S3Provider<C>
{
  private final S3Factory<C, S> s3Factory;
  private final List<? extends RequestHandler2> requestHandlers;
  private final LoadingCache<String, C> clientCache;
  private final LoadingCache<String, C> InitialTimeoutClientCache;
  private final boolean isInitialTimeoutSet;
  
  public DefaultS3Provider(S3Factory<C, S> s3Factory, S s3Configuration, @Nullable S initialTimeoutS3Configuration, List<? extends RequestHandler2> requestHandlers)
  {
    Preconditions.checkNotNull(s3Factory, "S3Factory is required");
    Preconditions.checkNotNull(s3Configuration, "S3Configuration is required");
    Preconditions.checkNotNull(requestHandlers, "RequestHandlers are required");
    
    this.s3Factory = s3Factory;
    this.requestHandlers = requestHandlers;
    clientCache = CacheBuilder.newBuilder().build(new S3CacheLoader(s3Configuration));
    isInitialTimeoutSet = (initialTimeoutS3Configuration != null);
    
    InitialTimeoutClientCache = (isInitialTimeoutSet ? CacheBuilder.newBuilder().build(new S3CacheLoader(initialTimeoutS3Configuration)) : null);
  }
  
  public C getS3(String endpoint)
  {
    return (AmazonS3Client)clientCache.getUnchecked(endpoint);
  }
  
  public C getS3WithInitialTimeoutOrS3Default(String endpoint)
  {
    return isInitialTimeoutSet() ? 
      (AmazonS3Client)InitialTimeoutClientCache.getUnchecked(endpoint) : 
      getS3(endpoint);
  }
  
  public boolean isInitialTimeoutSet()
  {
    return isInitialTimeoutSet;
  }
  
  private class S3CacheLoader
    extends CacheLoader<String, C>
  {
    S s3Configuration;
    
    S3CacheLoader()
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
      return (AmazonS3Client)s3Factory.newS3(s3Configuration);
    }
    
    private void addRequestHandlers(C s3)
    {
      for (RequestHandler2 requestHandler : requestHandlers) {
        s3.addRequestHandler(requestHandler);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.provider.DefaultS3Provider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */