package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ReadLimitInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResetException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AWS4Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AwsChunkedEncodingInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.internal.AWS4SignerRequestParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.request.S3HandlerContextKeys;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

public class AWSS3V4Signer
  extends AWS4Signer
{
  private static final String CONTENT_SHA_256 = "STREAMING-AWS4-HMAC-SHA256-PAYLOAD";
  private static final String UNSIGNED_PAYLOAD = "UNSIGNED-PAYLOAD";
  
  public AWSS3V4Signer()
  {
    super(false);
  }
  
  protected void processRequestPayload(SignableRequest<?> request, byte[] signature, byte[] signingKey, AWS4SignerRequestParams signerRequestParams)
  {
    if (useChunkEncoding(request))
    {
      AwsChunkedEncodingInputStream chunkEncodededStream = new AwsChunkedEncodingInputStream(request.getContent(), signingKey, signerRequestParams.getFormattedSigningDateTime(), signerRequestParams.getScope(), BinaryUtils.toHex(signature), this);
      request.setContent(chunkEncodededStream);
    }
  }
  
  protected String calculateContentHashPresign(SignableRequest<?> request)
  {
    return "UNSIGNED-PAYLOAD";
  }
  
  protected String calculateContentHash(SignableRequest<?> request)
  {
    request.addHeader("x-amz-content-sha256", "required");
    if (isPayloadSigningEnabled(request))
    {
      if (useChunkEncoding(request))
      {
        String contentLength = (String)request.getHeaders().get("Content-Length");
        long originalContentLength;
        if (contentLength != null) {
          originalContentLength = Long.parseLong(contentLength);
        } else {
          try
          {
            originalContentLength = getContentLength(request);
          }
          catch (IOException e)
          {
            long originalContentLength;
            throw new SdkClientException("Cannot get the content-length of the request content.", e);
          }
        }
        long originalContentLength;
        request.addHeader("x-amz-decoded-content-length", 
          Long.toString(originalContentLength));
        
        request.addHeader("Content-Length", Long.toString(
        
          AwsChunkedEncodingInputStream.calculateStreamContentLength(originalContentLength)));
        return "STREAMING-AWS4-HMAC-SHA256-PAYLOAD";
      }
      return super.calculateContentHash(request);
    }
    return "UNSIGNED-PAYLOAD";
  }
  
  private boolean useChunkEncoding(SignableRequest<?> request)
  {
    if ((!isPayloadSigningEnabled(request)) || (isChunkedEncodingDisabled(request))) {
      return false;
    }
    if (((request.getOriginalRequestObject() instanceof PutObjectRequest)) || 
      ((request.getOriginalRequestObject() instanceof UploadPartRequest))) {
      return true;
    }
    return false;
  }
  
  private boolean isChunkedEncodingDisabled(SignableRequest<?> signableRequest)
  {
    if ((signableRequest instanceof Request))
    {
      Request<?> request = (Request)signableRequest;
      
      Boolean isChunkedEncodingDisabled = (Boolean)request.getHandlerContext(S3HandlerContextKeys.IS_CHUNKED_ENCODING_DISABLED);
      return (isChunkedEncodingDisabled != null) && (isChunkedEncodingDisabled.booleanValue());
    }
    return false;
  }
  
  private boolean isPayloadSigningEnabled(SignableRequest<?> signableRequest)
  {
    if (!signableRequest.getEndpoint().getScheme().equals("https")) {
      return true;
    }
    if ((signableRequest instanceof Request))
    {
      Request<?> request = (Request)signableRequest;
      
      Boolean isPayloadSigningEnabled = (Boolean)request.getHandlerContext(S3HandlerContextKeys.IS_PAYLOAD_SIGNING_ENABLED);
      return (isPayloadSigningEnabled != null) && (isPayloadSigningEnabled.booleanValue());
    }
    return false;
  }
  
  static long getContentLength(SignableRequest<?> request)
    throws IOException
  {
    InputStream content = request.getContent();
    if (!content.markSupported()) {
      throw new IllegalStateException("Bug: request input stream must have been made mark-and-resettable at this point");
    }
    ReadLimitInfo info = request.getReadLimitInfo();
    int readLimit = info.getReadLimit();
    long contentLength = 0L;
    byte[] tmp = new byte['က'];
    
    content.mark(readLimit);
    int read;
    while ((read = content.read(tmp)) != -1) {
      contentLength += read;
    }
    try
    {
      content.reset();
    }
    catch (IOException ex)
    {
      throw new ResetException("Failed to reset the input stream", ex);
    }
    return contentLength;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.AWSS3V4Signer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */