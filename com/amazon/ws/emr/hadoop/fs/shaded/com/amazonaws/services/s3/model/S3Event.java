package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum S3Event
{
  ReducedRedundancyLostObject("s3:ReducedRedundancyLostObject"),  ObjectCreated("s3:ObjectCreated:*"),  ObjectCreatedByPut("s3:ObjectCreated:Put"),  ObjectCreatedByPost("s3:ObjectCreated:Post"),  ObjectCreatedByCopy("s3:ObjectCreated:Copy"),  ObjectCreatedByCompleteMultipartUpload("s3:ObjectCreated:CompleteMultipartUpload"),  ObjectRemoved("s3:ObjectRemoved:*"),  ObjectRemovedDelete("s3:ObjectRemoved:Delete"),  ObjectRemovedDeleteMarkerCreated("s3:ObjectRemoved:DeleteMarkerCreated"),  ObjectRestorePost("s3:ObjectRestore:Post"),  ObjectRestoreCompleted("s3:ObjectRestore:Completed");
  
  private final String event;
  private static final String S3_PREFIX = "s3:";
  
  private S3Event(String event)
  {
    this.event = event;
  }
  
  public String toString()
  {
    return event;
  }
  
  public static S3Event fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (S3Event enumEntry : values()) {
      if ((enumEntry.toString().equals(value)) || (enumEntry.toString().equals("s3:".concat(value)))) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Event
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */