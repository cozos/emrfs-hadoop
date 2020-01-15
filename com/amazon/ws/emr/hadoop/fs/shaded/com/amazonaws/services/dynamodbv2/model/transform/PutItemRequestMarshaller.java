package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import java.util.Map;

@SdkInternalApi
public class PutItemRequestMarshaller
{
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<Map> ITEM_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Item").build();
  private static final MarshallingInfo<Map> EXPECTED_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Expected").build();
  private static final MarshallingInfo<String> RETURNVALUES_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReturnValues").build();
  private static final MarshallingInfo<String> RETURNCONSUMEDCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReturnConsumedCapacity").build();
  private static final MarshallingInfo<String> RETURNITEMCOLLECTIONMETRICS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReturnItemCollectionMetrics").build();
  private static final MarshallingInfo<String> CONDITIONALOPERATOR_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ConditionalOperator").build();
  private static final MarshallingInfo<String> CONDITIONEXPRESSION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ConditionExpression").build();
  private static final MarshallingInfo<Map> EXPRESSIONATTRIBUTENAMES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExpressionAttributeNames").build();
  private static final MarshallingInfo<Map> EXPRESSIONATTRIBUTEVALUES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExpressionAttributeValues").build();
  private static final PutItemRequestMarshaller instance = new PutItemRequestMarshaller();
  
  public static PutItemRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(PutItemRequest putItemRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (putItemRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(putItemRequest.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(putItemRequest.getItem(), ITEM_BINDING);
      protocolMarshaller.marshall(putItemRequest.getExpected(), EXPECTED_BINDING);
      protocolMarshaller.marshall(putItemRequest.getReturnValues(), RETURNVALUES_BINDING);
      protocolMarshaller.marshall(putItemRequest.getReturnConsumedCapacity(), RETURNCONSUMEDCAPACITY_BINDING);
      protocolMarshaller.marshall(putItemRequest.getReturnItemCollectionMetrics(), RETURNITEMCOLLECTIONMETRICS_BINDING);
      protocolMarshaller.marshall(putItemRequest.getConditionalOperator(), CONDITIONALOPERATOR_BINDING);
      protocolMarshaller.marshall(putItemRequest.getConditionExpression(), CONDITIONEXPRESSION_BINDING);
      protocolMarshaller.marshall(putItemRequest.getExpressionAttributeNames(), EXPRESSIONATTRIBUTENAMES_BINDING);
      protocolMarshaller.marshall(putItemRequest.getExpressionAttributeValues(), EXPRESSIONATTRIBUTEVALUES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PutItemRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */