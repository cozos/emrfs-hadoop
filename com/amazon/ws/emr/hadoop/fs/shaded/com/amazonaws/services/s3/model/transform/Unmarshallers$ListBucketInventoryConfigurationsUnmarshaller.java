package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$ListBucketInventoryConfigurationsUnmarshaller
  implements Unmarshaller<ListBucketInventoryConfigurationsResult, InputStream>
{
  public ListBucketInventoryConfigurationsResult unmarshall(InputStream in)
    throws Exception
  {
    return new XmlResponsesSaxParser().parseBucketListInventoryConfigurationsResponse(in).getResult();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketInventoryConfigurationsUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */