package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.presign;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Presigner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CredentialUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.RuntimeHttpUtils;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Immutable
@SdkProtectedApi
public final class PresignerFacade
{
  private final AWSCredentialsProvider credentialsProvider;
  private final SignerProvider signerProvider;
  
  public PresignerFacade(PresignerParams presignerParams)
  {
    credentialsProvider = presignerParams.credentialsProvider();
    signerProvider = presignerParams.signerProvider();
  }
  
  public URL presign(Request<?> request, Date expirationDate)
  {
    Presigner presigner = (Presigner)signerProvider.getSigner(SignerProviderContext.builder()
      .withIsRedirect(false)
      .withRequest(request)
      .withUri(request.getEndpoint())
      .build());
    if (request.getOriginalRequest() != null)
    {
      addCustomQueryParams(request);
      addCustomHeaders(request);
    }
    AWSCredentialsProvider credentialsProvider = resolveCredentials(request);
    presigner.presignRequest(request, credentialsProvider.getCredentials(), expirationDate);
    return RuntimeHttpUtils.convertRequestToUrl(request, true, false);
  }
  
  private void addCustomQueryParams(Request<?> request)
  {
    Map<String, List<String>> queryParameters = request.getOriginalRequest().getCustomQueryParameters();
    if ((queryParameters == null) || (queryParameters.isEmpty())) {
      return;
    }
    for (Map.Entry<String, List<String>> param : queryParameters.entrySet()) {
      request.addParameters((String)param.getKey(), (List)param.getValue());
    }
  }
  
  private void addCustomHeaders(Request<?> request)
  {
    Map<String, String> headers = request.getOriginalRequest().getCustomRequestHeaders();
    if ((headers == null) || (headers.isEmpty())) {
      return;
    }
    for (Map.Entry<String, String> header : headers.entrySet()) {
      request.addHeader((String)header.getKey(), (String)header.getValue());
    }
  }
  
  private AWSCredentialsProvider resolveCredentials(Request<?> request)
  {
    return CredentialUtils.getCredentialsProvider(request.getOriginalRequest(), credentialsProvider);
  }
  
  public static class PresigningRequest
    extends AmazonWebServiceRequest
  {
    public PresigningRequest withRequestCredentialsProvider(AWSCredentialsProvider credentialsProvider)
    {
      setRequestCredentialsProvider(credentialsProvider);
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.presign.PresignerFacade
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */