package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.ExecutorFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferManagerUtils;
import java.util.concurrent.ExecutorService;

@NotThreadSafe
public final class TransferManagerBuilder
{
  private static final SdkFunction<TransferManagerParams, TransferManager> DEFAULT_TRANSFER_MANAGER_FACTORY = new SdkFunction()
  {
    public TransferManager apply(TransferManagerParams params)
    {
      return new TransferManager(params);
    }
  };
  private final SdkFunction<TransferManagerParams, TransferManager> transferManagerFactory;
  private AmazonS3 s3Client;
  private ExecutorFactory executorFactory;
  private Boolean shutDownThreadPools;
  private Long minimumUploadPartSize;
  private Long multipartUploadThreshold;
  private Long multipartCopyThreshold;
  private Long multipartCopyPartSize;
  private Boolean disableParallelDownloads;
  
  public static TransferManagerBuilder standard()
  {
    return new TransferManagerBuilder();
  }
  
  public static TransferManager defaultTransferManager()
  {
    return standard().build();
  }
  
  private TransferManagerBuilder()
  {
    this(DEFAULT_TRANSFER_MANAGER_FACTORY);
  }
  
  @SdkTestInternalApi
  TransferManagerBuilder(SdkFunction<TransferManagerParams, TransferManager> transferManagerFactory)
  {
    this.transferManagerFactory = transferManagerFactory;
  }
  
  public final AmazonS3 getS3Client()
  {
    return s3Client;
  }
  
  public final void setS3Client(AmazonS3 s3Client)
  {
    this.s3Client = s3Client;
  }
  
  public final TransferManagerBuilder withS3Client(AmazonS3 s3Client)
  {
    setS3Client(s3Client);
    return this;
  }
  
  private AmazonS3 resolveS3Client()
  {
    return s3Client == null ? AmazonS3ClientBuilder.defaultClient() : s3Client;
  }
  
  public final ExecutorFactory getExecutorFactory()
  {
    return executorFactory;
  }
  
  public final void setExecutorFactory(ExecutorFactory executorFactory)
  {
    this.executorFactory = executorFactory;
  }
  
  public final TransferManagerBuilder withExecutorFactory(ExecutorFactory executorFactory)
  {
    setExecutorFactory(executorFactory);
    return this;
  }
  
  private ExecutorService resolveExecutorService()
  {
    return executorFactory == null ? TransferManagerUtils.createDefaultExecutorService() : executorFactory
      .newExecutor();
  }
  
  public final Boolean isShutDownThreadPools()
  {
    return shutDownThreadPools;
  }
  
  public final void setShutDownThreadPools(Boolean shutDownThreadPools)
  {
    this.shutDownThreadPools = shutDownThreadPools;
  }
  
  public final TransferManagerBuilder withShutDownThreadPools(Boolean shutDownThreadPools)
  {
    setShutDownThreadPools(shutDownThreadPools);
    return this;
  }
  
  private Boolean resolveShutDownThreadPools()
  {
    return shutDownThreadPools == null ? Boolean.TRUE : shutDownThreadPools;
  }
  
  public final Long getMinimumUploadPartSize()
  {
    return minimumUploadPartSize;
  }
  
  public final void setMinimumUploadPartSize(Long minimumUploadPartSize)
  {
    this.minimumUploadPartSize = minimumUploadPartSize;
  }
  
  public final TransferManagerBuilder withMinimumUploadPartSize(Long minimumUploadPartSize)
  {
    setMinimumUploadPartSize(minimumUploadPartSize);
    return this;
  }
  
  public final Long getMultipartUploadThreshold()
  {
    return multipartUploadThreshold;
  }
  
  public final void setMultipartUploadThreshold(Long multipartUploadThreshold)
  {
    this.multipartUploadThreshold = multipartUploadThreshold;
  }
  
  public final TransferManagerBuilder withMultipartUploadThreshold(Long multipartUploadThreshold)
  {
    setMultipartUploadThreshold(multipartUploadThreshold);
    return this;
  }
  
  public final Long getMultipartCopyThreshold()
  {
    return multipartCopyThreshold;
  }
  
  public final void setMultipartCopyThreshold(Long multipartCopyThreshold)
  {
    this.multipartCopyThreshold = multipartCopyThreshold;
  }
  
  public final TransferManagerBuilder withMultipartCopyThreshold(Long multipartCopyThreshold)
  {
    setMultipartCopyThreshold(multipartCopyThreshold);
    return this;
  }
  
  public final Long getMultipartCopyPartSize()
  {
    return multipartCopyPartSize;
  }
  
  public final void setMultipartCopyPartSize(Long multipartCopyPartSize)
  {
    this.multipartCopyPartSize = multipartCopyPartSize;
  }
  
  public final TransferManagerBuilder withMultipartCopyPartSize(Long multipartCopyPartSize)
  {
    setMultipartCopyPartSize(multipartCopyPartSize);
    return this;
  }
  
  public Boolean isDisableParallelDownloads()
  {
    return disableParallelDownloads;
  }
  
  public void setDisableParallelDownloads(Boolean disableParallelDownloads)
  {
    this.disableParallelDownloads = disableParallelDownloads;
  }
  
  public TransferManagerBuilder withDisableParallelDownloads(Boolean disableParallelDownloads)
  {
    setDisableParallelDownloads(disableParallelDownloads);
    return this;
  }
  
  public TransferManagerBuilder disableParallelDownloads()
  {
    return withDisableParallelDownloads(Boolean.TRUE);
  }
  
  private TransferManagerConfiguration resolveConfiguration()
  {
    TransferManagerConfiguration configuration = new TransferManagerConfiguration();
    if (minimumUploadPartSize != null) {
      configuration.setMinimumUploadPartSize(minimumUploadPartSize.longValue());
    }
    if (multipartCopyPartSize != null) {
      configuration.setMultipartCopyPartSize(multipartCopyPartSize.longValue());
    }
    if (multipartCopyThreshold != null) {
      configuration.setMultipartCopyThreshold(multipartCopyThreshold.longValue());
    }
    if (multipartUploadThreshold != null) {
      configuration.setMultipartUploadThreshold(multipartUploadThreshold.longValue());
    }
    if (disableParallelDownloads != null) {
      configuration.setDisableParallelDownloads(disableParallelDownloads.booleanValue());
    }
    return configuration;
  }
  
  TransferManagerParams getParams()
  {
    return 
    
      new TransferManagerParams().withS3Client(resolveS3Client()).withExecutorService(resolveExecutorService()).withShutDownThreadPools(resolveShutDownThreadPools()).withTransferManagerConfiguration(resolveConfiguration());
  }
  
  public final TransferManager build()
  {
    return (TransferManager)transferManagerFactory.apply(getParams());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManagerBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */