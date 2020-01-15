package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$VersionListUnmarshaller
  implements Unmarshaller<VersionListing, InputStream>
{
  private final boolean shouldSDKDecodeResponse;
  
  public Unmarshallers$VersionListUnmarshaller(boolean shouldSDKDecodeResponse)
  {
    this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
  }
  
  public VersionListing unmarshall(InputStream in)
    throws Exception
  {
    return 
      new XmlResponsesSaxParser().parseListVersionsResponse(in, shouldSDKDecodeResponse).getListing();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.VersionListUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */