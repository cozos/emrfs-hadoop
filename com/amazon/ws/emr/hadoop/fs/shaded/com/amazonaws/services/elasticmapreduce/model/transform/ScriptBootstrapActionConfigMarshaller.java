package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScriptBootstrapActionConfig;
import java.util.List;

@SdkInternalApi
public class ScriptBootstrapActionConfigMarshaller
{
  private static final MarshallingInfo<String> PATH_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Path").build();
  private static final MarshallingInfo<List> ARGS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Args").build();
  private static final ScriptBootstrapActionConfigMarshaller instance = new ScriptBootstrapActionConfigMarshaller();
  
  public static ScriptBootstrapActionConfigMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ScriptBootstrapActionConfig scriptBootstrapActionConfig, ProtocolMarshaller protocolMarshaller)
  {
    if (scriptBootstrapActionConfig == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(scriptBootstrapActionConfig.getPath(), PATH_BINDING);
      protocolMarshaller.marshall(scriptBootstrapActionConfig.getArgs(), ARGS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScriptBootstrapActionConfigMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */