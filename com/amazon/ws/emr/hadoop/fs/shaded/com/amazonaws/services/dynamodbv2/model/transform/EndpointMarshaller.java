package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Endpoint;

@SdkInternalApi
public class EndpointMarshaller
{
  private static final MarshallingInfo<String> ADDRESS_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Address").build();
  private static final MarshallingInfo<Long> CACHEPERIODINMINUTES_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CachePeriodInMinutes").build();
  private static final EndpointMarshaller instance = new EndpointMarshaller();
  
  public static EndpointMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Endpoint endpoint, ProtocolMarshaller protocolMarshaller)
  {
    if (endpoint == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(endpoint.getAddress(), ADDRESS_BINDING);
      protocolMarshaller.marshall(endpoint.getCachePeriodInMinutes(), CACHEPERIODINMINUTES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.EndpointMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */