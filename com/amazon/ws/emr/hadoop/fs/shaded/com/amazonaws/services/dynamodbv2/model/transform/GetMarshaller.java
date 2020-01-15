package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Get;
import java.util.Map;

@SdkInternalApi
public class GetMarshaller
{
  private static final MarshallingInfo<Map> KEY_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Key").build();
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<String> PROJECTIONEXPRESSION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProjectionExpression").build();
  private static final MarshallingInfo<Map> EXPRESSIONATTRIBUTENAMES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExpressionAttributeNames").build();
  private static final GetMarshaller instance = new GetMarshaller();
  
  public static GetMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Get get, ProtocolMarshaller protocolMarshaller)
  {
    if (get == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(get.getKey(), KEY_BINDING);
      protocolMarshaller.marshall(get.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(get.getProjectionExpression(), PROJECTIONEXPRESSION_BINDING);
      protocolMarshaller.marshall(get.getExpressionAttributeNames(), EXPRESSIONATTRIBUTENAMES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GetMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */