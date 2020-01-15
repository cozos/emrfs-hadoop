package com.amazon.ws.emr.hadoop.fs.consistency;

import com.amazon.ws.emr.hadoop.fs.consistency.exception.ConsistencyException;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.lite.ConsistencyExceptionThrowableObjectMetadataRetriever;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsistencyExceptionThrowableObjectMetadataRetrieverImpl
  implements ConsistencyExceptionThrowableObjectMetadataRetriever
{
  private static final Logger LOG = LoggerFactory.getLogger(ConsistencyExceptionThrowableObjectMetadataRetrieverImpl.class);
  private final AmazonS3Lite s3Lite;
  
  public ConsistencyExceptionThrowableObjectMetadataRetrieverImpl(AmazonS3Lite s3)
  {
    s3Lite = s3;
  }
  
  public ObjectMetadata get(Path path)
    throws ConsistencyException
  {
    try
    {
      String bucket = EmrFsUtils.pathToBucket(path);
      String key = EmrFsUtils.pathToKey(path);
      return s3Lite.getObjectMetadata(bucket, key);
    }
    catch (AmazonServiceException ae)
    {
      if (ae.getStatusCode() == 404) {
        throw new ConsistencyException(ImmutableList.of(path));
      }
      throw ae;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.ConsistencyExceptionThrowableObjectMetadataRetrieverImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */