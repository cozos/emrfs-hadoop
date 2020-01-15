package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$BucketLifecycleConfigurationUnmarshaller
  implements Unmarshaller<BucketLifecycleConfiguration, InputStream>
{
  public BucketLifecycleConfiguration unmarshall(InputStream in)
    throws Exception
  {
    return new XmlResponsesSaxParser().parseBucketLifecycleConfigurationResponse(in).getConfiguration();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketLifecycleConfigurationUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */