package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$GetBucketAnalyticsConfigurationUnmarshaller
  implements Unmarshaller<GetBucketAnalyticsConfigurationResult, InputStream>
{
  public GetBucketAnalyticsConfigurationResult unmarshall(InputStream in)
    throws Exception
  {
    return new XmlResponsesSaxParser().parseGetBucketAnalyticsConfigurationResponse(in).getResult();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.GetBucketAnalyticsConfigurationUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */