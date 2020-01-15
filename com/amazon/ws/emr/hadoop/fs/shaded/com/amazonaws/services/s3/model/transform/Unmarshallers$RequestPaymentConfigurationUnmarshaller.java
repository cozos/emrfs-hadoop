package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$RequestPaymentConfigurationUnmarshaller
  implements Unmarshaller<RequestPaymentConfiguration, InputStream>
{
  public RequestPaymentConfiguration unmarshall(InputStream in)
    throws Exception
  {
    return 
      new XmlResponsesSaxParser().parseRequestPaymentConfigurationResponse(in).getConfiguration();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.RequestPaymentConfigurationUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */