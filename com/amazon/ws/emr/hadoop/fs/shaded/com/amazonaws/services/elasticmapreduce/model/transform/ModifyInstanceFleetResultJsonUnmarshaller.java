package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceFleetResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class ModifyInstanceFleetResultJsonUnmarshaller
  implements Unmarshaller<ModifyInstanceFleetResult, JsonUnmarshallerContext>
{
  private static ModifyInstanceFleetResultJsonUnmarshaller instance;
  
  public ModifyInstanceFleetResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ModifyInstanceFleetResult modifyInstanceFleetResult = new ModifyInstanceFleetResult();
    
    return modifyInstanceFleetResult;
  }
  
  public static ModifyInstanceFleetResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ModifyInstanceFleetResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ModifyInstanceFleetResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */