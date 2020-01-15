package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum StorageClass
{
  Standard("STANDARD"),  ReducedRedundancy("REDUCED_REDUNDANCY"),  Glacier("GLACIER"),  StandardInfrequentAccess("STANDARD_IA"),  OneZoneInfrequentAccess("ONEZONE_IA"),  IntelligentTiering("INTELLIGENT_TIERING"),  DeepArchive("DEEP_ARCHIVE");
  
  private final String storageClassId;
  
  public static StorageClass fromValue(String s3StorageClassString)
    throws IllegalArgumentException
  {
    for (StorageClass storageClass : ) {
      if (storageClass.toString().equals(s3StorageClassString)) {
        return storageClass;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + s3StorageClassString + " value!");
  }
  
  private StorageClass(String id)
  {
    storageClassId = id;
  }
  
  public String toString()
  {
    return storageClassId;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.StorageClass
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */