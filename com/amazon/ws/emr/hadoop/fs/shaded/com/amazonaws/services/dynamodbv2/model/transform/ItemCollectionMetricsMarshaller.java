package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ItemCollectionMetrics;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public class ItemCollectionMetricsMarshaller
{
  private static final MarshallingInfo<Map> ITEMCOLLECTIONKEY_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ItemCollectionKey").build();
  private static final MarshallingInfo<List> SIZEESTIMATERANGEGB_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SizeEstimateRangeGB").build();
  private static final ItemCollectionMetricsMarshaller instance = new ItemCollectionMetricsMarshaller();
  
  public static ItemCollectionMetricsMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ItemCollectionMetrics itemCollectionMetrics, ProtocolMarshaller protocolMarshaller)
  {
    if (itemCollectionMetrics == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(itemCollectionMetrics.getItemCollectionKey(), ITEMCOLLECTIONKEY_BINDING);
      protocolMarshaller.marshall(itemCollectionMetrics.getSizeEstimateRangeGB(), SIZEESTIMATERANGEGB_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ItemCollectionMetricsMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */