package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SDKGlobalConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.CredentialsEndpointProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.EC2CredentialsUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EC2MetadataUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class InstanceProfileCredentialsProvider
  implements AWSCredentialsProvider, Closeable
{
  private static final Log LOG = LogFactory.getLog(InstanceProfileCredentialsProvider.class);
  private static final int ASYNC_REFRESH_INTERVAL_TIME_MINUTES = 1;
  private static final InstanceProfileCredentialsProvider INSTANCE = new InstanceProfileCredentialsProvider();
  private final EC2CredentialsFetcher credentialsFetcher;
  private volatile ScheduledExecutorService executor;
  private volatile boolean shouldRefresh = false;
  
  @Deprecated
  public InstanceProfileCredentialsProvider()
  {
    this(false);
  }
  
  public InstanceProfileCredentialsProvider(boolean refreshCredentialsAsync)
  {
    this(refreshCredentialsAsync, true);
  }
  
  public static InstanceProfileCredentialsProvider createAsyncRefreshingProvider(boolean eagerlyRefreshCredentialsAsync)
  {
    return new InstanceProfileCredentialsProvider(true, eagerlyRefreshCredentialsAsync);
  }
  
  private InstanceProfileCredentialsProvider(boolean refreshCredentialsAsync, boolean eagerlyRefreshCredentialsAsync)
  {
    credentialsFetcher = new EC2CredentialsFetcher(new InstanceMetadataCredentialsEndpointProvider(null));
    if ((!SDKGlobalConfiguration.isEc2MetadataDisabled()) && 
      (refreshCredentialsAsync))
    {
      executor = Executors.newScheduledThreadPool(1, new ThreadFactory()
      {
        public Thread newThread(Runnable r)
        {
          Thread t = Executors.defaultThreadFactory().newThread(r);
          t.setName("instance-profile-credentials-refresh");
          t.setDaemon(true);
          return t;
        }
      });
      executor.scheduleWithFixedDelay(new Runnable()
      {
        public void run()
        {
          try
          {
            if (shouldRefresh) {
              credentialsFetcher.getCredentials();
            }
          }
          catch (AmazonClientException ace)
          {
            InstanceProfileCredentialsProvider.this.handleError(ace);
          }
          catch (RuntimeException re)
          {
            InstanceProfileCredentialsProvider.this.handleError(re);
          }
        }
      }, 0L, 1L, TimeUnit.MINUTES);
    }
  }
  
  public static InstanceProfileCredentialsProvider getInstance()
  {
    return INSTANCE;
  }
  
  private void handleError(Throwable t)
  {
    refresh();
    LOG.error(t.getMessage(), t);
  }
  
  protected void finalize()
    throws Throwable
  {
    if (executor != null) {
      executor.shutdownNow();
    }
  }
  
  public AWSCredentials getCredentials()
  {
    if (SDKGlobalConfiguration.isEc2MetadataDisabled()) {
      throw new AmazonClientException("AWS_EC2_METADATA_DISABLED is set to true, not loading credentials from EC2 Instance Metadata service");
    }
    AWSCredentials creds = credentialsFetcher.getCredentials();
    shouldRefresh = true;
    return creds;
  }
  
  public void refresh()
  {
    if (credentialsFetcher != null) {
      credentialsFetcher.refresh();
    }
  }
  
  public void close()
    throws IOException
  {
    if (executor != null)
    {
      executor.shutdownNow();
      executor = null;
    }
  }
  
  private static class InstanceMetadataCredentialsEndpointProvider
    extends CredentialsEndpointProvider
  {
    public URI getCredentialsEndpoint()
      throws URISyntaxException, IOException
    {
      String host = EC2MetadataUtils.getHostAddressForEC2MetadataService();
      
      String securityCredentialsList = EC2CredentialsUtils.getInstance().readResource(new URI(host + "/latest/meta-data/iam/security-credentials/"));
      String[] securityCredentials = securityCredentialsList.trim().split("\n");
      if (securityCredentials.length == 0) {
        throw new SdkClientException("Unable to load credentials path");
      }
      return new URI(host + "/latest/meta-data/iam/security-credentials/" + securityCredentials[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.InstanceProfileCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */