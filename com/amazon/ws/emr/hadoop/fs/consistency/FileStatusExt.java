package com.amazon.ws.emr.hadoop.fs.consistency;

import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile;
import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.State;
import com.amazon.ws.emr.hadoop.fs.consistency.exception.ConsistencyException;
import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.lite.ConsistencyExceptionThrowableObjectMetadataRetriever;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.InvalidProtocolBufferException;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.io.IOException;
import java.io.UncheckedIOException;
import lombok.NonNull;
import org.apache.hadoop.fs.FileStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileStatusExt
  extends FileStatus
{
  private static final Logger LOG = LoggerFactory.getLogger(FileStatusExt.class);
  private Entity entity;
  private EmrFsStore.MetadataFile metadataFile;
  private String etag;
  
  protected FileStatusExt() {}
  
  protected FileStatusExt(FileStatusBuilder builder)
  {
    super(sizeBytes, isDirectory, blockReplication, blockSize, modificationTime, accessTime, fsPermission, owner, group, qualifiedPath);
    
    entity = entity;
    metadataFile = (metadataFile == null ? createMetadataFile(entity) : metadataFile);
    etag = (entity == null ? null : entity.getEtag());
  }
  
  private FileStatusExt(FileStatus fileStatus)
    throws IOException
  {
    super(fileStatus);
    if ((fileStatus instanceof FileStatusExt)) {
      setMetadataFieldsFrom((FileStatusExt)fileStatus);
    }
  }
  
  public static FileStatusExt copyOf(@NonNull FileStatus fileStatus)
  {
    if (fileStatus == null) {
      throw new NullPointerException("fileStatus");
    }
    try
    {
      return new FileStatusExt(fileStatus);
    }
    catch (IOException e)
    {
      throw new UncheckedIOException(e);
    }
  }
  
  public Entity getEntity()
  {
    return entity;
  }
  
  public EmrFsStore.MetadataFile getMetadataFile()
  {
    return metadataFile;
  }
  
  public boolean getMetadataEntryExists()
  {
    return metadataFile != null;
  }
  
  private void setMetadataFieldsFrom(FileStatusExt fileStatus)
  {
    entity = fileStatus.getEntity();
    metadataFile = fileStatus.getMetadataFile();
    etag = fileStatus.getEtag();
  }
  
  private static EmrFsStore.MetadataFile createMetadataFile(Entity entity)
  {
    if (entity == null) {
      return null;
    }
    try
    {
      return EmrFsStore.MetadataFile.parseFrom(entity.getPayload());
    }
    catch (InvalidProtocolBufferException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public static FileStatusBuilder builder()
  {
    return new FileStatusBuilder();
  }
  
  protected static final class LazyFileStatusExt
    extends FileStatusExt
  {
    private long plaintextLength = -1L;
    private AmazonS3Lite s3;
    private ConsistencyExceptionThrowableObjectMetadataRetriever objectMetadataRetriever;
    
    protected LazyFileStatusExt(FileStatusBuilder builder)
    {
      super();
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
        FileStatusExt.LOG.info("Metadata Entry doesn't exist");
        return false;
      }
      EmrFsStore.MetadataFile metadataFile = getMetadataFile();
      return (metadataFile.hasState()) && (metadataFile.getState() != EmrFsStore.MetadataFile.State.DELETED);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.FileStatusExt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */