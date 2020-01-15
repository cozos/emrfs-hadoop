package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetTerminationProtectionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class SetTerminationProtectionResultJsonUnmarshaller
  implements Unmarshaller<SetTerminationProtectionResult, JsonUnmarshallerContext>
{
  private static SetTerminationProtectionResultJsonUnmarshaller instance;
  
  public SetTerminationProtectionResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    SetTerminationProtectionResult setTerminationProtectionResult = new SetTerminationProtectionResult();
    
    return setTerminationProtectionResult;
  }
  
  public static SetTerminationProtectionResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SetTerminationProtectionResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SetTerminationProtectionResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */