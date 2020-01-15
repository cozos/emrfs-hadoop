package com.amazon.ws.emr.hadoop.fs.consistency;

import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile;
import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.Builder;
import com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.State;
import lombok.NonNull;

public final class MetadataFiles
{
  private MetadataFiles()
  {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
  
  public static final EmrFsStore.MetadataFile DISCOVERED_FILE = fileWithState(EmrFsStore.MetadataFile.State.DISCOVERED);
  public static final EmrFsStore.MetadataFile PLACED_FILE = fileWithState(EmrFsStore.MetadataFile.State.PUT);
  public static final EmrFsStore.MetadataFile DELETED_FILE = fileWithState(EmrFsStore.MetadataFile.State.DELETED);
  public static final EmrFsStore.MetadataFile DISCOVERED_DIRECTORY = directoryWithState(EmrFsStore.MetadataFile.State.DISCOVERED);
  public static final EmrFsStore.MetadataFile PLACED_DIRECTORY = directoryWithState(EmrFsStore.MetadataFile.State.PUT);
  public static final EmrFsStore.MetadataFile DELETED_DIRECTORY = directoryWithState(EmrFsStore.MetadataFile.State.DELETED);
  
  public static EmrFsStore.MetadataFile fileWithState(@NonNull EmrFsStore.MetadataFile.State state)
  {
    if (state == null) {
      throw new NullPointerException("state");
    }
    return 
    
      fileBuilder().setState(state).build();
  }
  
  public static EmrFsStore.MetadataFile directoryWithState(@NonNull EmrFsStore.MetadataFile.State state)
  {
    if (state == null) {
      throw new NullPointerException("state");
    }
    return 
    
      directoryBuilder().setState(state).build();
  }
  
  public static EmrFsStore.MetadataFile.Builder directoryBuilder()
  {
    return builder().setIsDirectory(true);
  }
  
  public static EmrFsStore.MetadataFile.Builder fileBuilder()
  {
    return builder().setIsDirectory(false);
  }
  
  private static EmrFsStore.MetadataFile.Builder builder()
  {
    return 
      EmrFsStore.MetadataFile.newBuilder().setVersion(1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.MetadataFiles
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */