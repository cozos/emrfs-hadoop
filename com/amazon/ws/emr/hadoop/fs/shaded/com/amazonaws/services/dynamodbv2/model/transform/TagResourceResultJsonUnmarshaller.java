package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class TagResourceResultJsonUnmarshaller
  implements Unmarshaller<TagResourceResult, JsonUnmarshallerContext>
{
  private static TagResourceResultJsonUnmarshaller instance;
  
  public TagResourceResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    TagResourceResult tagResourceResult = new TagResourceResult();
    
    return tagResourceResult;
  }
  
  public static TagResourceResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new TagResourceResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TagResourceResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */