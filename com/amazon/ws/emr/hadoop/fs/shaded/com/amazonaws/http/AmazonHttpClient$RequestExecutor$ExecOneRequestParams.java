package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AWS4Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.request.HttpRequestFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.settings.HttpClientSettings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.AuthRetryParameters;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;
import java.io.IOException;
import java.net.URI;

class AmazonHttpClient$RequestExecutor$ExecOneRequestParams
{
  int requestCount;
  long lastBackoffDelay = 0L;
  SdkBaseException retriedException;
  HttpRequestBase apacheRequest;
  HttpResponse apacheResponse;
  URI redirectedURI;
  AuthRetryParameters authRetryParam;
  boolean leaveHttpConnectionOpen;
  private Signer signer;
  private URI signerURI;
  
  private AmazonHttpClient$RequestExecutor$ExecOneRequestParams(AmazonHttpClient.RequestExecutor paramRequestExecutor) {}
  
  boolean isRetry()
  {
    return (requestCount > 1) || (redirectedURI != null) || (authRetryParam != null);
  }
  
  void initPerRetry()
  {
    requestCount += 1;
    apacheRequest = null;
    apacheResponse = null;
    leaveHttpConnectionOpen = false;
  }
  
  void newSigner(Request<?> request, ExecutionContext execContext)
  {
    SignerProviderContext.Builder signerProviderContext = SignerProviderContext.builder().withRequest(request).withRequestConfig(AmazonHttpClient.RequestExecutor.access$2200(this$1));
    if (authRetryParam != null)
    {
      signerURI = authRetryParam.getEndpointForRetry();
      signer = authRetryParam.getSignerForRetry();
      
      execContext.setSigner(signer);
    }
    else if ((redirectedURI != null) && (!redirectedURI.equals(signerURI)))
    {
      signerURI = redirectedURI;
      signer = execContext.getSigner(signerProviderContext
        .withUri(signerURI)
        .withIsRedirect(true)
        .build());
      if ((signer instanceof AWS4Signer))
      {
        String regionName = ((AWS4Signer)signer).getRegionName();
        if (regionName != null) {
          request.addHandlerContext(HandlerContextKey.SIGNING_REGION, regionName);
        }
      }
    }
    else if (signer == null)
    {
      signerURI = request.getEndpoint();
      
      signer = execContext.getSigner(signerProviderContext.withUri(signerURI).build());
    }
  }
  
  HttpRequestBase newApacheRequest(HttpRequestFactory<HttpRequestBase> httpRequestFactory, Request<?> request, HttpClientSettings options)
    throws IOException
  {
    apacheRequest = ((HttpRequestBase)httpRequestFactory.create(request, options));
    if (redirectedURI != null) {
      apacheRequest.setURI(redirectedURI);
    }
    return apacheRequest;
  }
  
  void resetBeforeHttpRequest()
  {
    retriedException = null;
    authRetryParam = null;
    redirectedURI = null;
  }
  
  private Integer getStatusCode()
  {
    if ((apacheResponse == null) || (apacheResponse.getStatusLine() == null)) {
      return null;
    }
    return Integer.valueOf(apacheResponse.getStatusLine().getStatusCode());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient.RequestExecutor.ExecOneRequestParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */