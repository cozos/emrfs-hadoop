package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class ModifyInstanceGroupsResultJsonUnmarshaller
  implements Unmarshaller<ModifyInstanceGroupsResult, JsonUnmarshallerContext>
{
  private static ModifyInstanceGroupsResultJsonUnmarshaller instance;
  
  public ModifyInstanceGroupsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ModifyInstanceGroupsResult modifyInstanceGroupsResult = new ModifyInstanceGroupsResult();
    
    return modifyInstanceGroupsResult;
  }
  
  public static ModifyInstanceGroupsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ModifyInstanceGroupsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ModifyInstanceGroupsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */