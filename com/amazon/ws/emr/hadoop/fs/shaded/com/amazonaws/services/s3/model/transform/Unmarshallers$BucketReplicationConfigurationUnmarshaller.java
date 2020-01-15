package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$BucketReplicationConfigurationUnmarshaller
  implements Unmarshaller<BucketReplicationConfiguration, InputStream>
{
  public BucketReplicationConfiguration unmarshall(InputStream in)
    throws Exception
  {
    return 
      new XmlResponsesSaxParser().parseReplicationConfigurationResponse(in).getConfiguration();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketReplicationConfigurationUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */