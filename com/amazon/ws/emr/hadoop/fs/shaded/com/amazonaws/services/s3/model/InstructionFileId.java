package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;

@Immutable
public final class InstructionFileId
  extends S3ObjectId
{
  public static final String DEFAULT_INSTRUCTION_FILE_SUFFIX = "instruction";
  @Deprecated
  public static final String DEFAULT_INSTURCTION_FILE_SUFFIX = "instruction";
  public static final String DOT = ".";
  
  InstructionFileId(String bucket, String key, String versionId)
  {
    super(bucket, key, versionId);
  }
  
  public InstructionFileId instructionFileId()
  {
    throw new UnsupportedOperationException();
  }
  
  public InstructionFileId instructionFileId(String suffix)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InstructionFileId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */