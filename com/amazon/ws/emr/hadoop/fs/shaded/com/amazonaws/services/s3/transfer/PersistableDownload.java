package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public final class PersistableDownload
  extends PersistableTransfer
{
  static final String TYPE = "download";
  @JsonProperty
  private final String pauseType = "download";
  @JsonProperty
  private final String bucketName;
  @JsonProperty
  private final String key;
  @JsonProperty
  private final String versionId;
  @JsonProperty
  private final long[] range;
  @JsonProperty
  private final ResponseHeaderOverrides responseHeaders;
  @JsonProperty
  private final boolean isRequesterPays;
  @JsonProperty
  private final String file;
  @JsonProperty
  private final Integer lastFullyDownloadedPartNumber;
  @JsonProperty
  private final long lastModifiedTime;
  @JsonProperty
  private final Long lastFullyDownloadedFilePosition;
  
  public PersistableDownload()
  {
    this(null, null, null, null, null, false, null, null, 0L, null);
  }
  
  public PersistableDownload(@JsonProperty("bucketName") String bucketName, @JsonProperty("key") String key, @JsonProperty("versionId") String versionId, @JsonProperty("range") long[] range, @JsonProperty("responseHeaders") ResponseHeaderOverrides responseHeaders, @JsonProperty("isRequesterPays") boolean isRequesterPays, @JsonProperty("file") String file, @JsonProperty("lastFullyDownloadedPartNumber") Integer lastFullyDownloadedPartNumber, @JsonProperty("lastModifiedTime") long lastModifiedTime, @JsonProperty("lastFullyDownloadedFilePosition") Long lastFullyDownloadedFilePosition)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.versionId = versionId;
    this.range = (range == null ? null : (long[])range.clone());
    this.responseHeaders = responseHeaders;
    this.isRequesterPays = isRequesterPays;
    this.file = file;
    this.lastFullyDownloadedPartNumber = lastFullyDownloadedPartNumber;
    this.lastModifiedTime = lastModifiedTime;
    this.lastFullyDownloadedFilePosition = lastFullyDownloadedFilePosition;
  }
  
  public PersistableDownload(String bucketName, String key, String versionId, long[] range, ResponseHeaderOverrides responseHeaders, boolean requesterPays, String absolutePath, Integer lastFullyDownloadedPartNumber, long time)
  {
    this(bucketName, key, versionId, range, responseHeaders, requesterPays, absolutePath, lastFullyDownloadedPartNumber, time, Long.valueOf(0L));
  }
  
  String getBucketName()
  {
    return bucketName;
  }
  
  String getKey()
  {
    return key;
  }
  
  String getVersionId()
  {
    return versionId;
  }
  
  long[] getRange()
  {
    return range == null ? null : (long[])range.clone();
  }
  
  ResponseHeaderOverrides getResponseHeaders()
  {
    return responseHeaders;
  }
  
  boolean isRequesterPays()
  {
    return isRequesterPays;
  }
  
  String getFile()
  {
    return file;
  }
  
  String getPauseType()
  {
    return "download";
  }
  
  Integer getLastFullyDownloadedPartNumber()
  {
    return lastFullyDownloadedPartNumber;
  }
  
  Long getlastModifiedTime()
  {
    return Long.valueOf(lastModifiedTime);
  }
  
  Long getLastFullyDownloadedFilePosition()
  {
    return lastFullyDownloadedFilePosition;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PersistableDownload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */