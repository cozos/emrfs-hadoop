package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

public class AmazonWebServiceResponse<T>
{
  private T result;
  private ResponseMetadata responseMetadata;
  
  public T getResult()
  {
    return (T)result;
  }
  
  public void setResult(T result)
  {
    this.result = result;
  }
  
  public void setResponseMetadata(ResponseMetadata responseMetadata)
  {
    this.responseMetadata = responseMetadata;
  }
  
  public ResponseMetadata getResponseMetadata()
  {
    return responseMetadata;
  }
  
  public String getRequestId()
  {
    if (responseMetadata == null) {
      return null;
    }
    return responseMetadata.getRequestId();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */