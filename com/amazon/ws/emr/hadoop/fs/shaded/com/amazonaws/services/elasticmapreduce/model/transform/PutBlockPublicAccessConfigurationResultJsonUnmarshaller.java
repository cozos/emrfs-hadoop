package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutBlockPublicAccessConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class PutBlockPublicAccessConfigurationResultJsonUnmarshaller
  implements Unmarshaller<PutBlockPublicAccessConfigurationResult, JsonUnmarshallerContext>
{
  private static PutBlockPublicAccessConfigurationResultJsonUnmarshaller instance;
  
  public PutBlockPublicAccessConfigurationResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    PutBlockPublicAccessConfigurationResult putBlockPublicAccessConfigurationResult = new PutBlockPublicAccessConfigurationResult();
    
    return putBlockPublicAccessConfigurationResult;
  }
  
  public static PutBlockPublicAccessConfigurationResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PutBlockPublicAccessConfigurationResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.PutBlockPublicAccessConfigurationResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */