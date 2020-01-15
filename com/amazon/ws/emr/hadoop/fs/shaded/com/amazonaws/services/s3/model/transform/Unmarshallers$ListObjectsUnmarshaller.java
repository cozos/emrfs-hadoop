package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$ListObjectsUnmarshaller
  implements Unmarshaller<ObjectListing, InputStream>
{
  private final boolean shouldSDKDecodeResponse;
  
  public Unmarshallers$ListObjectsUnmarshaller(boolean shouldSDKDecodeResponse)
  {
    this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
  }
  
  public ObjectListing unmarshall(InputStream in)
    throws Exception
  {
    return 
      new XmlResponsesSaxParser().parseListBucketObjectsResponse(in, shouldSDKDecodeResponse).getObjectListing();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListObjectsUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */