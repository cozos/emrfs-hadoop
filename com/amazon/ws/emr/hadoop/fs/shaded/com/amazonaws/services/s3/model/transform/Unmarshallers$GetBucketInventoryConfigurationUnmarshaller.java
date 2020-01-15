package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$GetBucketInventoryConfigurationUnmarshaller
  implements Unmarshaller<GetBucketInventoryConfigurationResult, InputStream>
{
  public GetBucketInventoryConfigurationResult unmarshall(InputStream in)
    throws Exception
  {
    return new XmlResponsesSaxParser().parseGetBucketInventoryConfigurationResponse(in).getResult();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.GetBucketInventoryConfigurationUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */