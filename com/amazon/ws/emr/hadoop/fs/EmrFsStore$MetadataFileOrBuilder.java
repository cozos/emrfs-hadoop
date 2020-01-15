package com.amazon.ws.emr.hadoop.fs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.MessageOrBuilder;

public abstract interface EmrFsStore$MetadataFileOrBuilder
  extends MessageOrBuilder
{
  public abstract boolean hasVersion();
  
  public abstract int getVersion();
  
  public abstract boolean hasState();
  
  public abstract EmrFsStore.MetadataFile.State getState();
  
  public abstract boolean hasIsDirectory();
  
  public abstract boolean getIsDirectory();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFileOrBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */