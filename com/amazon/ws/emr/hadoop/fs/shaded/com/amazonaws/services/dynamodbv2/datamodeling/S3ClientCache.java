package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class S3ClientCache
{
  private final ConcurrentMap<String, AmazonS3> clientsByRegion = new ConcurrentHashMap();
  private final Map<String, TransferManager> transferManagersByRegion = new ConcurrentHashMap();
  private final AWSCredentialsProvider awscredentialsProvider;
  
  @Deprecated
  S3ClientCache(AWSCredentials credentials)
  {
    this(new StaticCredentialsProvider(credentials));
  }
  
  S3ClientCache(AWSCredentialsProvider awsCredentialsProvider)
  {
    awscredentialsProvider = awsCredentialsProvider;
  }
  
  public void useClient(AmazonS3 client)
  {
    String region = client.getRegionName();
    synchronized (transferManagersByRegion)
    {
      TransferManager tm = (TransferManager)transferManagersByRegion.remove(region);
      if (tm != null) {
        tm.shutdownNow();
      }
      clientsByRegion.put(region, client);
    }
  }
  
  public AmazonS3 getClient(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region region)
  {
    if (region == null) {
      throw new IllegalArgumentException("S3 region must be specified");
    }
    return getClient(region.toAWSRegion().getName());
  }
  
  public AmazonS3 getClient(String region)
  {
    if (region == null) {
      throw new IllegalArgumentException("S3 region must be specified");
    }
    AmazonS3 client = (AmazonS3)clientsByRegion.get(region);
    return client != null ? client : cacheClient(region);
  }
  
  private AmazonS3 cacheClient(String region)
  {
    if (awscredentialsProvider == null) {
      throw new IllegalArgumentException("No credentials provider found to connect to S3");
    }
    AmazonS3 client = new AmazonS3Client(awscredentialsProvider);
    client.setRegion(RegionUtils.getRegion(region));
    clientsByRegion.put(region, client);
    return client;
  }
  
  public TransferManager getTransferManager(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region region)
  {
    return getTransferManager(region.toAWSRegion().getName());
  }
  
  public TransferManager getTransferManager(String region)
  {
    synchronized (transferManagersByRegion)
    {
      TransferManager tm = (TransferManager)transferManagersByRegion.get(region);
      if (tm == null)
      {
        tm = new TransferManager(getClient(region));
        transferManagersByRegion.put(region, tm);
      }
      return tm;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.S3ClientCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */