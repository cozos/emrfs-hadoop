package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$BucketLoggingConfigurationnmarshaller
  implements Unmarshaller<BucketLoggingConfiguration, InputStream>
{
  public BucketLoggingConfiguration unmarshall(InputStream in)
    throws Exception
  {
    return 
      new XmlResponsesSaxParser().parseLoggingStatusResponse(in).getBucketLoggingConfiguration();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketLoggingConfigurationnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */