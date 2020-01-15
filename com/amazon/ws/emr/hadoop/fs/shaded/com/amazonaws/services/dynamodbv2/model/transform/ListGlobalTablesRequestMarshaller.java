package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListGlobalTablesRequest;

@SdkInternalApi
public class ListGlobalTablesRequestMarshaller
{
  private static final MarshallingInfo<String> EXCLUSIVESTARTGLOBALTABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExclusiveStartGlobalTableName").build();
  private static final MarshallingInfo<Integer> LIMIT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Limit").build();
  private static final MarshallingInfo<String> REGIONNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RegionName").build();
  private static final ListGlobalTablesRequestMarshaller instance = new ListGlobalTablesRequestMarshaller();
  
  public static ListGlobalTablesRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ListGlobalTablesRequest listGlobalTablesRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (listGlobalTablesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(listGlobalTablesRequest.getExclusiveStartGlobalTableName(), EXCLUSIVESTARTGLOBALTABLENAME_BINDING);
      protocolMarshaller.marshall(listGlobalTablesRequest.getLimit(), LIMIT_BINDING);
      protocolMarshaller.marshall(listGlobalTablesRequest.getRegionName(), REGIONNAME_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListGlobalTablesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */