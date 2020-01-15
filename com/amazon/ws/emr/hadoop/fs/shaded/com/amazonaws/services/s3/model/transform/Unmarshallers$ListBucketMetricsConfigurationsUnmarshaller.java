package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$ListBucketMetricsConfigurationsUnmarshaller
  implements Unmarshaller<ListBucketMetricsConfigurationsResult, InputStream>
{
  public ListBucketMetricsConfigurationsResult unmarshall(InputStream in)
    throws Exception
  {
    return new XmlResponsesSaxParser().parseListBucketMetricsConfigurationsResponse(in).getResult();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketMetricsConfigurationsUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */