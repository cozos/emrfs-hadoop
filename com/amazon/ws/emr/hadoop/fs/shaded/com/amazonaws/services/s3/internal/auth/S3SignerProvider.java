package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.RegionAwareSigner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AwsHostNameUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.net.URI;

public class S3SignerProvider
  extends SignerProvider
{
  private static Log log = LogFactory.getLog(S3SignerProvider.class);
  private final AmazonWebServiceClient awsClient;
  private Signer signer;
  
  public S3SignerProvider(AmazonWebServiceClient awsClient, Signer defaultSigner)
  {
    this.awsClient = awsClient;
    signer = defaultSigner;
  }
  
  public Signer getSigner(SignerProviderContext signerProviderContext)
  {
    URI uri = signerProviderContext.getUri();
    if ((uri == null) || (ServiceUtils.isS3AccelerateEndpoint(uri.getHost())) || (isSignerRegionOverrideSet())) {
      return signer;
    }
    if ((signer instanceof RegionAwareSigner))
    {
      RegionAwareSigner regionSigner = (RegionAwareSigner)signer;
      try
      {
        regionSigner.setRegionName(AwsHostNameUtils.parseRegionName(uri
          .getHost(), "s3"));
      }
      catch (RuntimeException e)
      {
        log.warn("Failed to parse the endpoint " + uri + ", and skip re-assigning the signer region", e);
      }
    }
    return signer;
  }
  
  private boolean isSignerRegionOverrideSet()
  {
    return (awsClient != null) && (awsClient.getSignerRegionOverride() != null);
  }
  
  public void setSigner(Signer signer)
  {
    this.signer = signer;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.auth.S3SignerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */