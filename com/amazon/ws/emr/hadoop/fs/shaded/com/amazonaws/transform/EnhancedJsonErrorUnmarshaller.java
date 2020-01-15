package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public abstract class EnhancedJsonErrorUnmarshaller
  extends JsonErrorUnmarshaller
{
  public EnhancedJsonErrorUnmarshaller(Class<? extends AmazonServiceException> exceptionClass, String handledErrorCode)
  {
    super(exceptionClass, handledErrorCode);
  }
  
  public abstract AmazonServiceException unmarshallFromContext(JsonUnmarshallerContext paramJsonUnmarshallerContext)
    throws Exception;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.EnhancedJsonErrorUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */