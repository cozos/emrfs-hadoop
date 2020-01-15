package com.amazon.ws.emr.hadoop.fs.consistency;

import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.lite.ConsistencyExceptionThrowableObjectMetadataRetriever;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

class FileStatusBuilder
{
  protected long sizeBytes = 0L;
  protected boolean isDirectory = false;
  protected long blockSize = 0L;
  protected int blockReplication = 1;
  protected long modificationTime = 0L;
  protected long accessTime = 0L;
  protected FsPermission fsPermission;
  protected Path qualifiedPath;
  protected String owner;
  protected String group;
  protected Entity entity;
  protected EmrFsStore.MetadataFile metadataFile;
  protected boolean lazyLoad;
  protected boolean isPlaintextLenForCseEnabled;
  protected AmazonS3Lite s3;
  protected ConsistencyExceptionThrowableObjectMetadataRetriever objectMetadataRetriever;
  
  public FileStatusBuilder entity(Entity entity)
  {
    this.entity = entity;
    return this;
  }
  
  public FileStatusBuilder metadataFile(EmrFsStore.MetadataFile metadataFile)
  {
    this.metadataFile = metadataFile;
    return this;
  }
  
  public FileStatusBuilder sizeBytes(long sizeBytes)
  {
    this.sizeBytes = sizeBytes;
    return this;
  }
  
  public FileStatusBuilder isDirectory(boolean isDirectory)
  {
    this.isDirectory = isDirectory;
    return this;
  }
  
  public FileStatusBuilder blockSize(long blockSize)
  {
    this.blockSize = blockSize;
    return this;
  }
  
  public FileStatusBuilder blockReplication(int blockReplication)
  {
    this.blockReplication = blockReplication;
    return this;
  }
  
  public FileStatusBuilder modificationTime(long modificationTime)
  {
    this.modificationTime = modificationTime;
    return this;
  }
  
  public FileStatusBuilder accessTime(long accessTime)
  {
    this.accessTime = accessTime;
    return this;
  }
  
  public FileStatusBuilder fsPermission(FsPermission fsPermission)
  {
    this.fsPermission = fsPermission;
    return this;
  }
  
  public FileStatusBuilder qualifiedPath(Path qualifiedPath)
  {
    this.qualifiedPath = qualifiedPath;
    return this;
  }
  
  public FileStatusBuilder owner(String owner)
  {
    this.owner = owner;
    return this;
  }
  
  public FileStatusBuilder group(String group)
  {
    this.group = group;
    return this;
  }
  
  public FileStatusBuilder lazyLoad(boolean lazyLoad)
  {
    this.lazyLoad = lazyLoad;
    return this;
  }
  
  public FileStatusBuilder isPlaintextLenForCseEnabled(boolean isPlaintextLenForCseEnabled)
  {
    this.isPlaintextLenForCseEnabled = isPlaintextLenForCseEnabled;
    return this;
  }
  
  public FileStatusBuilder s3(AmazonS3Lite s3)
  {
    this.s3 = s3;
    return this;
  }
  
  public FileStatusBuilder objectMetadataRetriever(ConsistencyExceptionThrowableObjectMetadataRetriever objectMetadataRetriever)
  {
    this.objectMetadataRetriever = objectMetadataRetriever;
    return this;
  }
  
  public FileStatusExt build()
  {
    if ((modificationTime == 0L) && (entity != null)) {
      modificationTime = entity.getLastModified().longValue();
    }
    if ((lazyLoad) && (isPlaintextLenForCseEnabled)) {
      return new FileStatusExt.LazyFileStatusExt(this);
    }
    return new FileStatusExt(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.FileStatusBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */