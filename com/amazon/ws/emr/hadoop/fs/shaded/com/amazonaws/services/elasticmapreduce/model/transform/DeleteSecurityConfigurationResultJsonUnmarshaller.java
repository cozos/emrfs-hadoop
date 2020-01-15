package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DeleteSecurityConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class DeleteSecurityConfigurationResultJsonUnmarshaller
  implements Unmarshaller<DeleteSecurityConfigurationResult, JsonUnmarshallerContext>
{
  private static DeleteSecurityConfigurationResultJsonUnmarshaller instance;
  
  public DeleteSecurityConfigurationResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DeleteSecurityConfigurationResult deleteSecurityConfigurationResult = new DeleteSecurityConfigurationResult();
    
    return deleteSecurityConfigurationResult;
  }
  
  public static DeleteSecurityConfigurationResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteSecurityConfigurationResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DeleteSecurityConfigurationResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */