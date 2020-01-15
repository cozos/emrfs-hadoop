package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public class KeysAndAttributesMarshaller
{
  private static final MarshallingInfo<List> KEYS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Keys").build();
  private static final MarshallingInfo<List> ATTRIBUTESTOGET_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AttributesToGet").build();
  private static final MarshallingInfo<Boolean> CONSISTENTREAD_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ConsistentRead").build();
  private static final MarshallingInfo<String> PROJECTIONEXPRESSION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProjectionExpression").build();
  private static final MarshallingInfo<Map> EXPRESSIONATTRIBUTENAMES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExpressionAttributeNames").build();
  private static final KeysAndAttributesMarshaller instance = new KeysAndAttributesMarshaller();
  
  public static KeysAndAttributesMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(KeysAndAttributes keysAndAttributes, ProtocolMarshaller protocolMarshaller)
  {
    if (keysAndAttributes == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(keysAndAttributes.getKeys(), KEYS_BINDING);
      protocolMarshaller.marshall(keysAndAttributes.getAttributesToGet(), ATTRIBUTESTOGET_BINDING);
      protocolMarshaller.marshall(keysAndAttributes.getConsistentRead(), CONSISTENTREAD_BINDING);
      protocolMarshaller.marshall(keysAndAttributes.getProjectionExpression(), PROJECTIONEXPRESSION_BINDING);
      protocolMarshaller.marshall(keysAndAttributes.getExpressionAttributeNames(), EXPRESSIONATTRIBUTENAMES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.KeysAndAttributesMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */