package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public class ScanRequestMarshaller
{
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<String> INDEXNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("IndexName").build();
  private static final MarshallingInfo<List> ATTRIBUTESTOGET_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AttributesToGet").build();
  private static final MarshallingInfo<Integer> LIMIT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Limit").build();
  private static final MarshallingInfo<String> SELECT_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Select").build();
  private static final MarshallingInfo<Map> SCANFILTER_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ScanFilter").build();
  private static final MarshallingInfo<String> CONDITIONALOPERATOR_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ConditionalOperator").build();
  private static final MarshallingInfo<Map> EXCLUSIVESTARTKEY_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExclusiveStartKey").build();
  private static final MarshallingInfo<String> RETURNCONSUMEDCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReturnConsumedCapacity").build();
  private static final MarshallingInfo<Integer> TOTALSEGMENTS_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TotalSegments").build();
  private static final MarshallingInfo<Integer> SEGMENT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Segment").build();
  private static final MarshallingInfo<String> PROJECTIONEXPRESSION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProjectionExpression").build();
  private static final MarshallingInfo<String> FILTEREXPRESSION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("FilterExpression").build();
  private static final MarshallingInfo<Map> EXPRESSIONATTRIBUTENAMES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExpressionAttributeNames").build();
  private static final MarshallingInfo<Map> EXPRESSIONATTRIBUTEVALUES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExpressionAttributeValues").build();
  private static final MarshallingInfo<Boolean> CONSISTENTREAD_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ConsistentRead").build();
  private static final ScanRequestMarshaller instance = new ScanRequestMarshaller();
  
  public static ScanRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ScanRequest scanRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (scanRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(scanRequest.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(scanRequest.getIndexName(), INDEXNAME_BINDING);
      protocolMarshaller.marshall(scanRequest.getAttributesToGet(), ATTRIBUTESTOGET_BINDING);
      protocolMarshaller.marshall(scanRequest.getLimit(), LIMIT_BINDING);
      protocolMarshaller.marshall(scanRequest.getSelect(), SELECT_BINDING);
      protocolMarshaller.marshall(scanRequest.getScanFilter(), SCANFILTER_BINDING);
      protocolMarshaller.marshall(scanRequest.getConditionalOperator(), CONDITIONALOPERATOR_BINDING);
      protocolMarshaller.marshall(scanRequest.getExclusiveStartKey(), EXCLUSIVESTARTKEY_BINDING);
      protocolMarshaller.marshall(scanRequest.getReturnConsumedCapacity(), RETURNCONSUMEDCAPACITY_BINDING);
      protocolMarshaller.marshall(scanRequest.getTotalSegments(), TOTALSEGMENTS_BINDING);
      protocolMarshaller.marshall(scanRequest.getSegment(), SEGMENT_BINDING);
      protocolMarshaller.marshall(scanRequest.getProjectionExpression(), PROJECTIONEXPRESSION_BINDING);
      protocolMarshaller.marshall(scanRequest.getFilterExpression(), FILTEREXPRESSION_BINDING);
      protocolMarshaller.marshall(scanRequest.getExpressionAttributeNames(), EXPRESSIONATTRIBUTENAMES_BINDING);
      protocolMarshaller.marshall(scanRequest.getExpressionAttributeValues(), EXPRESSIONATTRIBUTEVALUES_BINDING);
      protocolMarshaller.marshall(scanRequest.getConsistentRead(), CONSISTENTREAD_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ScanRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */