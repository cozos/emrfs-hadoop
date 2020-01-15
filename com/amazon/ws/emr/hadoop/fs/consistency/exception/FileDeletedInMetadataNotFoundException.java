package com.amazon.ws.emr.hadoop.fs.consistency.exception;

import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import java.io.FileNotFoundException;

public class FileDeletedInMetadataNotFoundException
  extends FileNotFoundException
{
  private final Entity entity;
  private final EmrFsStore.MetadataFile metadataFile;
  
  public FileDeletedInMetadataNotFoundException(String message, Entity entity, EmrFsStore.MetadataFile metadataFile)
  {
    super(message);
    this.entity = entity;
    this.metadataFile = metadataFile;
  }
  
  public Entity getEntity()
  {
    return entity;
  }
  
  public EmrFsStore.MetadataFile getMetadataFile()
  {
    return metadataFile;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.exception.FileDeletedInMetadataNotFoundException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */