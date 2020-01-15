package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeySchemaElement;

@SdkInternalApi
public class KeySchemaElementMarshaller
{
  private static final MarshallingInfo<String> ATTRIBUTENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AttributeName").build();
  private static final MarshallingInfo<String> KEYTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeyType").build();
  private static final KeySchemaElementMarshaller instance = new KeySchemaElementMarshaller();
  
  public static KeySchemaElementMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(KeySchemaElement keySchemaElement, ProtocolMarshaller protocolMarshaller)
  {
    if (keySchemaElement == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(keySchemaElement.getAttributeName(), ATTRIBUTENAME_BINDING);
      protocolMarshaller.marshall(keySchemaElement.getKeyType(), KEYTYPE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.KeySchemaElementMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */