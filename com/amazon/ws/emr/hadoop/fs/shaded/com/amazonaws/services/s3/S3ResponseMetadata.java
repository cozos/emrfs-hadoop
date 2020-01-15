package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.util.Map;

public class S3ResponseMetadata
  extends ResponseMetadata
{
  public static final String HOST_ID = "HOST_ID";
  public static final String CLOUD_FRONT_ID = "CLOUD_FRONT_ID";
  
  public S3ResponseMetadata(Map<String, String> metadata)
  {
    super(metadata);
  }
  
  public S3ResponseMetadata(ResponseMetadata originalResponseMetadata)
  {
    super(originalResponseMetadata);
  }
  
  public String getHostId()
  {
    return (String)metadata.get("HOST_ID");
  }
  
  public String getCloudFrontId()
  {
    return (String)metadata.get("CLOUD_FRONT_ID");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.S3ResponseMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */