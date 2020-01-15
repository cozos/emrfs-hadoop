package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Put;
import java.util.Map;

@SdkInternalApi
public class PutMarshaller
{
  private static final MarshallingInfo<Map> ITEM_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Item").build();
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<String> CONDITIONEXPRESSION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ConditionExpression").build();
  private static final MarshallingInfo<Map> EXPRESSIONATTRIBUTENAMES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExpressionAttributeNames").build();
  private static final MarshallingInfo<Map> EXPRESSIONATTRIBUTEVALUES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExpressionAttributeValues").build();
  private static final MarshallingInfo<String> RETURNVALUESONCONDITIONCHECKFAILURE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReturnValuesOnConditionCheckFailure").build();
  private static final PutMarshaller instance = new PutMarshaller();
  
  public static PutMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Put put, ProtocolMarshaller protocolMarshaller)
  {
    if (put == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(put.getItem(), ITEM_BINDING);
      protocolMarshaller.marshall(put.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(put.getConditionExpression(), CONDITIONEXPRESSION_BINDING);
      protocolMarshaller.marshall(put.getExpressionAttributeNames(), EXPRESSIONATTRIBUTENAMES_BINDING);
      protocolMarshaller.marshall(put.getExpressionAttributeValues(), EXPRESSIONATTRIBUTEVALUES_BINDING);
      protocolMarshaller.marshall(put.getReturnValuesOnConditionCheckFailure(), RETURNVALUESONCONDITIONCHECKFAILURE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PutMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */