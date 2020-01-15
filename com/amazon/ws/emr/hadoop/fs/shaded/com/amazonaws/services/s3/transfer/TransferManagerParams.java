package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import java.util.concurrent.ExecutorService;

@SdkInternalApi
class TransferManagerParams
{
  private AmazonS3 s3Client;
  private ExecutorService executorService;
  private Boolean shutDownThreadPools;
  private TransferManagerConfiguration configuration;
  
  public AmazonS3 getS3Client()
  {
    return s3Client;
  }
  
  public TransferManagerParams withS3Client(AmazonS3 s3Client)
  {
    this.s3Client = s3Client;
    return this;
  }
  
  public ExecutorService getExecutorService()
  {
    return executorService;
  }
  
  public TransferManagerParams withExecutorService(ExecutorService executorService)
  {
    this.executorService = executorService;
    return this;
  }
  
  public Boolean getShutDownThreadPools()
  {
    return shutDownThreadPools;
  }
  
  public TransferManagerParams withShutDownThreadPools(Boolean shutDownThreadPools)
  {
    this.shutDownThreadPools = shutDownThreadPools;
    return this;
  }
  
  public TransferManagerConfiguration getConfiguration()
  {
    return configuration;
  }
  
  public TransferManagerParams withTransferManagerConfiguration(TransferManagerConfiguration configuration)
  {
    this.configuration = configuration;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManagerParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */