package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import java.util.Map;

@SdkInternalApi
public class DeleteItemRequestMarshaller
{
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<Map> KEY_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Key").build();
  private static final MarshallingInfo<Map> EXPECTED_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Expected").build();
  private static final MarshallingInfo<String> CONDITIONALOPERATOR_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ConditionalOperator").build();
  private static final MarshallingInfo<String> RETURNVALUES_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReturnValues").build();
  private static final MarshallingInfo<String> RETURNCONSUMEDCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReturnConsumedCapacity").build();
  private static final MarshallingInfo<String> RETURNITEMCOLLECTIONMETRICS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReturnItemCollectionMetrics").build();
  private static final MarshallingInfo<String> CONDITIONEXPRESSION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ConditionExpression").build();
  private static final MarshallingInfo<Map> EXPRESSIONATTRIBUTENAMES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExpressionAttributeNames").build();
  private static final MarshallingInfo<Map> EXPRESSIONATTRIBUTEVALUES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExpressionAttributeValues").build();
  private static final DeleteItemRequestMarshaller instance = new DeleteItemRequestMarshaller();
  
  public static DeleteItemRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(DeleteItemRequest deleteItemRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (deleteItemRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(deleteItemRequest.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(deleteItemRequest.getKey(), KEY_BINDING);
      protocolMarshaller.marshall(deleteItemRequest.getExpected(), EXPECTED_BINDING);
      protocolMarshaller.marshall(deleteItemRequest.getConditionalOperator(), CONDITIONALOPERATOR_BINDING);
      protocolMarshaller.marshall(deleteItemRequest.getReturnValues(), RETURNVALUES_BINDING);
      protocolMarshaller.marshall(deleteItemRequest.getReturnConsumedCapacity(), RETURNCONSUMEDCAPACITY_BINDING);
      protocolMarshaller.marshall(deleteItemRequest.getReturnItemCollectionMetrics(), RETURNITEMCOLLECTIONMETRICS_BINDING);
      protocolMarshaller.marshall(deleteItemRequest.getConditionExpression(), CONDITIONEXPRESSION_BINDING);
      protocolMarshaller.marshall(deleteItemRequest.getExpressionAttributeNames(), EXPRESSIONATTRIBUTENAMES_BINDING);
      protocolMarshaller.marshall(deleteItemRequest.getExpressionAttributeValues(), EXPRESSIONATTRIBUTEVALUES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DeleteItemRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */