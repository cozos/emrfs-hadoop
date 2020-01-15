package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListRetirableGrantsRequest;

@SdkInternalApi
public class ListRetirableGrantsRequestMarshaller
{
  private static final MarshallingInfo<Integer> LIMIT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Limit").build();
  private static final MarshallingInfo<String> MARKER_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Marker").build();
  private static final MarshallingInfo<String> RETIRINGPRINCIPAL_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RetiringPrincipal").build();
  private static final ListRetirableGrantsRequestMarshaller instance = new ListRetirableGrantsRequestMarshaller();
  
  public static ListRetirableGrantsRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ListRetirableGrantsRequest listRetirableGrantsRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (listRetirableGrantsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(listRetirableGrantsRequest.getLimit(), LIMIT_BINDING);
      protocolMarshaller.marshall(listRetirableGrantsRequest.getMarker(), MARKER_BINDING);
      protocolMarshaller.marshall(listRetirableGrantsRequest.getRetiringPrincipal(), RETIRINGPRINCIPAL_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListRetirableGrantsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */