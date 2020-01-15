package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLockConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$GetObjectLockConfigurationResultUnmarshaller
  implements Unmarshaller<GetObjectLockConfigurationResult, InputStream>
{
  public GetObjectLockConfigurationResult unmarshall(InputStream in)
    throws Exception
  {
    return new XmlResponsesSaxParser().parseGetObjectLockConfigurationResponse(in).getResult();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.GetObjectLockConfigurationResultUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */