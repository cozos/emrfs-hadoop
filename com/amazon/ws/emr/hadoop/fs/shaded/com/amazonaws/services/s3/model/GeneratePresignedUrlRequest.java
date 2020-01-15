package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.HttpMethod;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GeneratePresignedUrlRequest
  extends AmazonWebServiceRequest
  implements SSECustomerKeyProvider, Serializable
{
  private HttpMethod method;
  private String bucketName;
  private String key;
  private String versionId;
  private String contentType;
  private String contentMd5;
  private Date expiration;
  private boolean zeroByteContent;
  private Map<String, String> requestParameters = new HashMap();
  private ResponseHeaderOverrides responseHeaders;
  private SSECustomerKey sseCustomerKey;
  private String sseAlgorithm;
  private String kmsCmkId;
  
  public String getKmsCmkId()
  {
    return kmsCmkId;
  }
  
  public void setKmsCmkId(String kmsCmkId)
  {
    this.kmsCmkId = kmsCmkId;
  }
  
  public GeneratePresignedUrlRequest withKmsCmkId(String kmsCmkId)
  {
    setKmsCmkId(kmsCmkId);
    return this;
  }
  
  public String getSSEAlgorithm()
  {
    return sseAlgorithm;
  }
  
  public void setSSEAlgorithm(String sseAlgorithm)
  {
    this.sseAlgorithm = sseAlgorithm;
  }
  
  public GeneratePresignedUrlRequest withSSEAlgorithm(String sseAlgorithm)
  {
    setSSEAlgorithm(sseAlgorithm);
    return this;
  }
  
  public void setSSEAlgorithm(SSEAlgorithm sseAlgorithm)
  {
    this.sseAlgorithm = sseAlgorithm.getAlgorithm();
  }
  
  public GeneratePresignedUrlRequest withSSEAlgorithm(SSEAlgorithm sseAlgorithm)
  {
    setSSEAlgorithm(sseAlgorithm);
    return this;
  }
  
  public GeneratePresignedUrlRequest(String bucketName, String key)
  {
    this(bucketName, key, HttpMethod.GET);
  }
  
  public GeneratePresignedUrlRequest(String bucketName, String key, HttpMethod method)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.method = method;
  }
  
  public HttpMethod getMethod()
  {
    return method;
  }
  
  public void setMethod(HttpMethod method)
  {
    this.method = method;
  }
  
  public GeneratePresignedUrlRequest withMethod(HttpMethod method)
  {
    setMethod(method);
    return this;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public GeneratePresignedUrlRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public GeneratePresignedUrlRequest withKey(String key)
  {
    setKey(key);
    return this;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public GeneratePresignedUrlRequest withVersionId(String versionId)
  {
    setVersionId(versionId);
    return this;
  }
  
  public Date getExpiration()
  {
    return expiration;
  }
  
  public void setExpiration(Date expiration)
  {
    this.expiration = expiration;
  }
  
  public GeneratePresignedUrlRequest withExpiration(Date expiration)
  {
    setExpiration(expiration);
    return this;
  }
  
  public void addRequestParameter(String key, String value)
  {
    requestParameters.put(key, value);
  }
  
  public Map<String, String> getRequestParameters()
  {
    return requestParameters;
  }
  
  public ResponseHeaderOverrides getResponseHeaders()
  {
    return responseHeaders;
  }
  
  public void setResponseHeaders(ResponseHeaderOverrides responseHeaders)
  {
    this.responseHeaders = responseHeaders;
  }
  
  public GeneratePresignedUrlRequest withResponseHeaders(ResponseHeaderOverrides responseHeaders)
  {
    setResponseHeaders(responseHeaders);
    return this;
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  public void setContentType(String contentType)
  {
    this.contentType = contentType;
  }
  
  public GeneratePresignedUrlRequest withContentType(String contentType)
  {
    setContentType(contentType);
    return this;
  }
  
  public String getContentMd5()
  {
    return contentMd5;
  }
  
  public void setContentMd5(String contentMd5)
  {
    this.contentMd5 = contentMd5;
  }
  
  public GeneratePresignedUrlRequest withContentMd5(String contentMd5)
  {
    this.contentMd5 = contentMd5;
    return this;
  }
  
  public SSECustomerKey getSSECustomerKey()
  {
    return sseCustomerKey;
  }
  
  public void setSSECustomerKey(SSECustomerKey sseCustomerKey)
  {
    this.sseCustomerKey = sseCustomerKey;
  }
  
  public GeneratePresignedUrlRequest withSSECustomerKey(SSECustomerKey sseKey)
  {
    setSSECustomerKey(sseKey);
    return this;
  }
  
  public void setSSECustomerKeyAlgorithm(SSEAlgorithm sseAlgorithm)
  {
    if (sseAlgorithm == null) {
      sseCustomerKey = null;
    } else if (sseAlgorithm.getAlgorithm().equals(SSEAlgorithm.AES256.getAlgorithm())) {
      sseCustomerKey = SSECustomerKey.generateSSECustomerKeyForPresignUrl(sseAlgorithm.getAlgorithm());
    } else {
      throw new IllegalArgumentException("Currently the only supported Server Side Encryption algorithm is " + SSEAlgorithm.AES256);
    }
  }
  
  public GeneratePresignedUrlRequest withSSECustomerKeyAlgorithm(SSEAlgorithm algorithm)
  {
    setSSECustomerKeyAlgorithm(algorithm);
    return this;
  }
  
  public boolean isZeroByteContent()
  {
    return zeroByteContent;
  }
  
  public void setZeroByteContent(boolean zeroByteContent)
  {
    this.zeroByteContent = zeroByteContent;
  }
  
  public GeneratePresignedUrlRequest withZeroByteContent(boolean zeroByteContent)
  {
    setZeroByteContent(zeroByteContent);
    return this;
  }
  
  public void rejectIllegalArguments()
  {
    if (bucketName == null) {
      throw new IllegalArgumentException("The bucket name parameter must be specified when generating a pre-signed URL");
    }
    if (method == null) {
      throw new IllegalArgumentException("The HTTP method request parameter must be specified when generating a pre-signed URL");
    }
    if (sseCustomerKey != null)
    {
      if (sseAlgorithm != null) {
        throw new IllegalArgumentException("Either SSE or SSE-C can be specified but not both");
      }
      if (kmsCmkId != null) {
        throw new IllegalArgumentException("KMS CMK is not applicable for SSE-C");
      }
    }
    else if ((kmsCmkId != null) && 
      (!SSEAlgorithm.KMS.getAlgorithm().equals(sseAlgorithm)))
    {
      throw new IllegalArgumentException("For KMS server side encryption, the SSE algorithm must be set to " + SSEAlgorithm.KMS);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */