package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Application;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public class ApplicationMarshaller
{
  private static final MarshallingInfo<String> NAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Name").build();
  private static final MarshallingInfo<String> VERSION_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Version").build();
  private static final MarshallingInfo<List> ARGS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Args").build();
  private static final MarshallingInfo<Map> ADDITIONALINFO_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("AdditionalInfo").build();
  private static final ApplicationMarshaller instance = new ApplicationMarshaller();
  
  public static ApplicationMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Application application, ProtocolMarshaller protocolMarshaller)
  {
    if (application == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(application.getName(), NAME_BINDING);
      protocolMarshaller.marshall(application.getVersion(), VERSION_BINDING);
      protocolMarshaller.marshall(application.getArgs(), ARGS_BINDING);
      protocolMarshaller.marshall(application.getAdditionalInfo(), ADDITIONALINFO_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ApplicationMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */