package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import java.util.List;

@SdkInternalApi
public class ExpectedAttributeValueMarshaller
{
  private static final MarshallingInfo<StructuredPojo> VALUE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Value").build();
  private static final MarshallingInfo<Boolean> EXISTS_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Exists").build();
  private static final MarshallingInfo<String> COMPARISONOPERATOR_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ComparisonOperator").build();
  private static final MarshallingInfo<List> ATTRIBUTEVALUELIST_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AttributeValueList").build();
  private static final ExpectedAttributeValueMarshaller instance = new ExpectedAttributeValueMarshaller();
  
  public static ExpectedAttributeValueMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ExpectedAttributeValue expectedAttributeValue, ProtocolMarshaller protocolMarshaller)
  {
    if (expectedAttributeValue == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(expectedAttributeValue.getValue(), VALUE_BINDING);
      protocolMarshaller.marshall(expectedAttributeValue.getExists(), EXISTS_BINDING);
      protocolMarshaller.marshall(expectedAttributeValue.getComparisonOperator(), COMPARISONOPERATOR_BINDING);
      protocolMarshaller.marshall(expectedAttributeValue.getAttributeValueList(), ATTRIBUTEVALUELIST_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ExpectedAttributeValueMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */