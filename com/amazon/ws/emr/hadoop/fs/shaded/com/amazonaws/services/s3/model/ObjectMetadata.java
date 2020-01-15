package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectRestoreResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class ObjectMetadata
  implements ServerSideEncryptionResult, S3RequesterChargedResult, ObjectExpirationResult, ObjectRestoreResult, Cloneable, Serializable
{
  private Map<String, String> userMetadata = new TreeMap(String.CASE_INSENSITIVE_ORDER);
  private Map<String, Object> metadata = new TreeMap(String.CASE_INSENSITIVE_ORDER);
  public static final String AES_256_SERVER_SIDE_ENCRYPTION = SSEAlgorithm.AES256
    .getAlgorithm();
  private Date httpExpiresDate;
  private Date expirationTime;
  private String expirationTimeRuleId;
  private Boolean ongoingRestore;
  private Date restoreExpirationTime;
  
  public ObjectMetadata() {}
  
  private ObjectMetadata(ObjectMetadata from)
  {
    userMetadata = (userMetadata == null ? null : new TreeMap(userMetadata));
    
    metadata = (metadata == null ? null : new TreeMap(metadata));
    
    expirationTime = DateUtils.cloneDate(expirationTime);
    expirationTimeRuleId = expirationTimeRuleId;
    httpExpiresDate = DateUtils.cloneDate(httpExpiresDate);
    ongoingRestore = ongoingRestore;
    restoreExpirationTime = DateUtils.cloneDate(restoreExpirationTime);
  }
  
  public Map<String, String> getUserMetadata()
  {
    return userMetadata;
  }
  
  public void setUserMetadata(Map<String, String> userMetadata)
  {
    this.userMetadata = userMetadata;
  }
  
  public void setHeader(String key, Object value)
  {
    metadata.put(key, value);
  }
  
  public void addUserMetadata(String key, String value)
  {
    userMetadata.put(key, value);
  }
  
  public Map<String, Object> getRawMetadata()
  {
    Map<String, Object> copy = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    copy.putAll(metadata);
    return Collections.unmodifiableMap(copy);
  }
  
  public Object getRawMetadataValue(String key)
  {
    return metadata.get(key);
  }
  
  public Date getLastModified()
  {
    return DateUtils.cloneDate((Date)metadata.get("Last-Modified"));
  }
  
  public void setLastModified(Date lastModified)
  {
    metadata.put("Last-Modified", lastModified);
  }
  
  public long getContentLength()
  {
    Long contentLength = (Long)metadata.get("Content-Length");
    if (contentLength == null) {
      return 0L;
    }
    return contentLength.longValue();
  }
  
  public long getInstanceLength()
  {
    String contentRange = (String)metadata.get("Content-Range");
    if (contentRange != null)
    {
      int pos = contentRange.lastIndexOf("/");
      if (pos >= 0) {
        return Long.parseLong(contentRange.substring(pos + 1));
      }
    }
    return getContentLength();
  }
  
  public void setContentLength(long contentLength)
  {
    metadata.put("Content-Length", Long.valueOf(contentLength));
  }
  
  public String getContentType()
  {
    return (String)metadata.get("Content-Type");
  }
  
  public void setContentType(String contentType)
  {
    metadata.put("Content-Type", contentType);
  }
  
  public String getContentLanguage()
  {
    return (String)metadata.get("Content-Language");
  }
  
  public void setContentLanguage(String contentLanguage)
  {
    metadata.put("Content-Language", contentLanguage);
  }
  
  public String getContentEncoding()
  {
    return (String)metadata.get("Content-Encoding");
  }
  
  public void setContentEncoding(String encoding)
  {
    metadata.put("Content-Encoding", encoding);
  }
  
  public String getCacheControl()
  {
    return (String)metadata.get("Cache-Control");
  }
  
  public void setCacheControl(String cacheControl)
  {
    metadata.put("Cache-Control", cacheControl);
  }
  
  public void setContentMD5(String md5Base64)
  {
    if (md5Base64 == null) {
      metadata.remove("Content-MD5");
    } else {
      metadata.put("Content-MD5", md5Base64);
    }
  }
  
  public String getContentMD5()
  {
    return (String)metadata.get("Content-MD5");
  }
  
  public void setContentDisposition(String disposition)
  {
    metadata.put("Content-Disposition", disposition);
  }
  
  public String getContentDisposition()
  {
    return (String)metadata.get("Content-Disposition");
  }
  
  public String getETag()
  {
    return (String)metadata.get("ETag");
  }
  
  public String getVersionId()
  {
    return (String)metadata.get("x-amz-version-id");
  }
  
  public String getSSEAlgorithm()
  {
    return (String)metadata.get("x-amz-server-side-encryption");
  }
  
  @Deprecated
  public String getServerSideEncryption()
  {
    return (String)metadata.get("x-amz-server-side-encryption");
  }
  
  public void setSSEAlgorithm(String algorithm)
  {
    metadata.put("x-amz-server-side-encryption", algorithm);
  }
  
  @Deprecated
  public void setServerSideEncryption(String algorithm)
  {
    metadata.put("x-amz-server-side-encryption", algorithm);
  }
  
  public String getSSECustomerAlgorithm()
  {
    return (String)metadata.get("x-amz-server-side-encryption-customer-algorithm");
  }
  
  public void setSSECustomerAlgorithm(String algorithm)
  {
    metadata.put("x-amz-server-side-encryption-customer-algorithm", algorithm);
  }
  
  public String getSSECustomerKeyMd5()
  {
    return (String)metadata.get("x-amz-server-side-encryption-customer-key-MD5");
  }
  
  public void setSSECustomerKeyMd5(String md5Digest)
  {
    metadata.put("x-amz-server-side-encryption-customer-key-MD5", md5Digest);
  }
  
  public Date getExpirationTime()
  {
    return DateUtils.cloneDate(expirationTime);
  }
  
  public void setExpirationTime(Date expirationTime)
  {
    this.expirationTime = expirationTime;
  }
  
  public String getExpirationTimeRuleId()
  {
    return expirationTimeRuleId;
  }
  
  public void setExpirationTimeRuleId(String expirationTimeRuleId)
  {
    this.expirationTimeRuleId = expirationTimeRuleId;
  }
  
  public Date getRestoreExpirationTime()
  {
    return DateUtils.cloneDate(restoreExpirationTime);
  }
  
  public void setRestoreExpirationTime(Date restoreExpirationTime)
  {
    this.restoreExpirationTime = restoreExpirationTime;
  }
  
  public void setOngoingRestore(boolean ongoingRestore)
  {
    this.ongoingRestore = Boolean.valueOf(ongoingRestore);
  }
  
  public Boolean getOngoingRestore()
  {
    return ongoingRestore;
  }
  
  public void setHttpExpiresDate(Date httpExpiresDate)
  {
    this.httpExpiresDate = httpExpiresDate;
  }
  
  public Date getHttpExpiresDate()
  {
    return DateUtils.cloneDate(httpExpiresDate);
  }
  
  public String getStorageClass()
  {
    Object storageClass = metadata.get("x-amz-storage-class");
    if (storageClass == null) {
      return null;
    }
    return storageClass.toString();
  }
  
  public String getUserMetaDataOf(String key)
  {
    return userMetadata == null ? null : (String)userMetadata.get(key);
  }
  
  public ObjectMetadata clone()
  {
    return new ObjectMetadata(this);
  }
  
  public String getSSEAwsKmsKeyId()
  {
    return 
      (String)metadata.get("x-amz-server-side-encryption-aws-kms-key-id");
  }
  
  public String getSSEAwsKmsEncryptionContext()
  {
    return 
      (String)metadata.get("x-amz-server-side-encryption-context");
  }
  
  public boolean isRequesterCharged()
  {
    return metadata.get("x-amz-request-charged") != null;
  }
  
  public void setRequesterCharged(boolean isRequesterCharged)
  {
    if (isRequesterCharged) {
      metadata.put("x-amz-request-charged", "requester");
    }
  }
  
  public Integer getPartCount()
  {
    return (Integer)metadata.get("x-amz-mp-parts-count");
  }
  
  public Long[] getContentRange()
  {
    String contentRange = (String)metadata.get("Content-Range");
    Long[] range = null;
    if (contentRange != null)
    {
      String[] tokens = contentRange.split("[ -/]+");
      try
      {
        range = new Long[] { Long.valueOf(Long.parseLong(tokens[1])), Long.valueOf(Long.parseLong(tokens[2])) };
      }
      catch (NumberFormatException nfe)
      {
        throw new SdkClientException("Unable to parse content range. Header 'Content-Range' has corrupted data" + nfe.getMessage(), nfe);
      }
    }
    return range;
  }
  
  public String getReplicationStatus()
  {
    return (String)metadata.get("x-amz-replication-status");
  }
  
  public String getObjectLockMode()
  {
    return (String)metadata.get("x-amz-object-lock-mode");
  }
  
  public Date getObjectLockRetainUntilDate()
  {
    String dateStr = (String)metadata.get("x-amz-object-lock-retain-until-date");
    if (dateStr != null) {
      return DateUtils.parseISO8601Date(dateStr);
    }
    return null;
  }
  
  public String getObjectLockLegalHoldStatus()
  {
    return (String)metadata.get("x-amz-object-lock-legal-hold");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */