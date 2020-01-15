package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$BucketAccelerateConfigurationUnmarshaller
  implements Unmarshaller<BucketAccelerateConfiguration, InputStream>
{
  public BucketAccelerateConfiguration unmarshall(InputStream in)
    throws Exception
  {
    return 
      new XmlResponsesSaxParser().parseAccelerateConfigurationResponse(in).getConfiguration();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.BucketAccelerateConfigurationUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */