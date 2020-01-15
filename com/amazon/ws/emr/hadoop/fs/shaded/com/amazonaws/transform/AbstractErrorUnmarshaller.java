package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import java.lang.reflect.Constructor;

public abstract class AbstractErrorUnmarshaller<T>
  implements Unmarshaller<AmazonServiceException, T>
{
  protected final Class<? extends AmazonServiceException> exceptionClass;
  
  public AbstractErrorUnmarshaller()
  {
    this(AmazonServiceException.class);
  }
  
  public AbstractErrorUnmarshaller(Class<? extends AmazonServiceException> exceptionClass)
  {
    this.exceptionClass = exceptionClass;
  }
  
  protected AmazonServiceException newException(String message)
    throws Exception
  {
    Constructor<? extends AmazonServiceException> constructor = exceptionClass.getConstructor(new Class[] { String.class });
    return (AmazonServiceException)constructor.newInstance(new Object[] { message });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.AbstractErrorUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */