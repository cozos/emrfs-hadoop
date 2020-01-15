package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SignerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SignerParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SignerTypeAware;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AwsHostNameUtils;
import java.net.URI;

public class DefaultSignerProvider
  extends SignerProvider
{
  private final AmazonWebServiceClient awsClient;
  private final Signer defaultSigner;
  
  public DefaultSignerProvider(AmazonWebServiceClient awsClient, Signer defaultSigner)
  {
    this.awsClient = awsClient;
    this.defaultSigner = defaultSigner;
  }
  
  public Signer getSigner(SignerProviderContext context)
  {
    Request<?> request = context.getRequest();
    if ((request == null) || (shouldUseDefaultSigner(request.getOriginalRequest())))
    {
      if (context.isRedirect()) {
        return awsClient.getSignerByURI(context.getUri());
      }
      return defaultSigner;
    }
    SignerTypeAware signerTypeAware = (SignerTypeAware)request.getOriginalRequest();
    SignerParams params = new SignerParams(awsClient.getServiceName(), getSigningRegionForRequestURI(request.getEndpoint()));
    return SignerFactory.createSigner(signerTypeAware.getSignerType(), params);
  }
  
  private boolean shouldUseDefaultSigner(AmazonWebServiceRequest originalRequest)
  {
    return (!(originalRequest instanceof SignerTypeAware)) || (isSignerOverridden());
  }
  
  private boolean isSignerOverridden()
  {
    return awsClient.getSignerOverride() != null;
  }
  
  private String getSigningRegionForRequestURI(URI uri)
  {
    String regionName = awsClient.getSignerRegionOverride();
    if (regionName == null) {
      regionName = AwsHostNameUtils.parseRegion(uri.getHost(), awsClient.getEndpointPrefix());
    }
    return regionName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.DefaultSignerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */