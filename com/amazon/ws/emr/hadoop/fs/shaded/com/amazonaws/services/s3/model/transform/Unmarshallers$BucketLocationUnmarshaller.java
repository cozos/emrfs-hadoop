package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$BucketLocationUnmarshaller
  implements Unmarshaller<String, InputStream>
{
  public String unmarshall(InputStream in)
    throws Exception
  {
    String location = new XmlResponsesSaxParser().parseBucketLocationResponse(in);
    if (location == null) {
      location = "US";
    }
    return location;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketLocationUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */