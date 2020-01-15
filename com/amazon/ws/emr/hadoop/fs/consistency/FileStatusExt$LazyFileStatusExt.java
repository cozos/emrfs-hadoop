package com.amazon.ws.emr.hadoop.fs.consistency;

import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile;
import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.State;
import com.amazon.ws.emr.hadoop.fs.consistency.exception.ConsistencyException;
import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.lite.ConsistencyExceptionThrowableObjectMetadataRetriever;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import org.slf4j.Logger;

public final class FileStatusExt$LazyFileStatusExt
  extends FileStatusExt
{
  private long plaintextLength = -1L;
  private AmazonS3Lite s3;
  private ConsistencyExceptionThrowableObjectMetadataRetriever objectMetadataRetriever;
  
  protected FileStatusExt$LazyFileStatusExt(FileStatusBuilder builder)
  {
    super(builder);
    s3 = s3;
    objectMetadataRetriever = objectMetadataRetriever;
  }
  
  public long getLen()
  {
    if (plaintextLength == -1L)
    {
      String bucket = EmrFsUtils.pathToBucket(getPath());
      String key = EmrFsUtils.pathToKey(getPath());
      ObjectMetadata metadata = null;
      if ((objectMetadataRetriever != null) && (existsInMetadata())) {
        try
        {
          metadata = objectMetadataRetriever.get(getPath());
        }
        catch (ConsistencyException ce)
        {
          throw new RuntimeException(ce);
        }
      }
      plaintextLength = CSEUtils.getPlaintextLength(s3, bucket, key, metadata, true);
    }
    return plaintextLength;
  }
  
  private boolean existsInMetadata()
  {
    if (!getMetadataEntryExists())
    {
      FileStatusExt.access$000().info("Metadata Entry doesn't exist");
      return false;
    }
    EmrFsStore.MetadataFile metadataFile = getMetadataFile();
    return (metadataFile.hasState()) && (metadataFile.getState() != EmrFsStore.MetadataFile.State.DELETED);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.FileStatusExt.LazyFileStatusExt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */