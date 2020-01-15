package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$ListObjectsV2Unmarshaller
  implements Unmarshaller<ListObjectsV2Result, InputStream>
{
  private final boolean shouldSDKDecodeResponse;
  
  public Unmarshallers$ListObjectsV2Unmarshaller(boolean shouldSDKDecodeResponse)
  {
    this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
  }
  
  public ListObjectsV2Result unmarshall(InputStream in)
    throws Exception
  {
    return 
      new XmlResponsesSaxParser().parseListObjectsV2Response(in, shouldSDKDecodeResponse).getResult();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListObjectsV2Unmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */