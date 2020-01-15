package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$BucketVersioningConfigurationUnmarshaller
  implements Unmarshaller<BucketVersioningConfiguration, InputStream>
{
  public BucketVersioningConfiguration unmarshall(InputStream in)
    throws Exception
  {
    return 
      new XmlResponsesSaxParser().parseVersioningConfigurationResponse(in).getConfiguration();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketVersioningConfigurationUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */