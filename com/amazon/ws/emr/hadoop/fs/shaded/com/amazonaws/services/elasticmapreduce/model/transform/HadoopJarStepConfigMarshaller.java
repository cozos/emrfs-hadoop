package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.HadoopJarStepConfig;
import java.util.List;

@SdkInternalApi
public class HadoopJarStepConfigMarshaller
{
  private static final MarshallingInfo<List> PROPERTIES_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Properties").build();
  private static final MarshallingInfo<String> JAR_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Jar").build();
  private static final MarshallingInfo<String> MAINCLASS_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("MainClass").build();
  private static final MarshallingInfo<List> ARGS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Args").build();
  private static final HadoopJarStepConfigMarshaller instance = new HadoopJarStepConfigMarshaller();
  
  public static HadoopJarStepConfigMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(HadoopJarStepConfig hadoopJarStepConfig, ProtocolMarshaller protocolMarshaller)
  {
    if (hadoopJarStepConfig == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(hadoopJarStepConfig.getProperties(), PROPERTIES_BINDING);
      protocolMarshaller.marshall(hadoopJarStepConfig.getJar(), JAR_BINDING);
      protocolMarshaller.marshall(hadoopJarStepConfig.getMainClass(), MAINCLASS_BINDING);
      protocolMarshaller.marshall(hadoopJarStepConfig.getArgs(), ARGS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.HadoopJarStepConfigMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */