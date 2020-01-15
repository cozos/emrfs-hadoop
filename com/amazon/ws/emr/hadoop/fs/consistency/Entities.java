package com.amazon.ws.emr.hadoop.fs.consistency;

import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile;
import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.State;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.InvalidProtocolBufferException;
import javax.annotation.Nullable;

public final class Entities
{
  private Entities()
  {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
  
  public static boolean isDirectory(@Nullable Entity entity)
    throws InvalidProtocolBufferException
  {
    return isExistentWithIsDirectory(entity, true);
  }
  
  public static boolean isFile(@Nullable Entity entity)
    throws InvalidProtocolBufferException
  {
    return isExistentWithIsDirectory(entity, false);
  }
  
  public static boolean isExistentWithIsDirectory(@Nullable Entity entity, boolean isDirectory)
    throws InvalidProtocolBufferException
  {
    if (entity == null) {
      return false;
    }
    EmrFsStore.MetadataFile metadataFile = EmrFsStore.MetadataFile.parseFrom(entity.getPayload());
    return (metadataFile.getState() != EmrFsStore.MetadataFile.State.DELETED) && 
      (metadataFile.getIsDirectory() == isDirectory);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.Entities
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */