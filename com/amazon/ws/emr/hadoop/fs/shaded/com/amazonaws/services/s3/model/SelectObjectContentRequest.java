package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SelectObjectContentRequest
  extends AmazonWebServiceRequest
  implements SSECustomerKeyProvider, Serializable, Cloneable
{
  private String bucketName;
  private String key;
  private SSECustomerKey sseCustomerKey;
  private String expression;
  private String expressionType;
  private RequestProgress requestProgress;
  private InputSerialization inputSerialization;
  private OutputSerialization outputSerialization;
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SelectObjectContentRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public SelectObjectContentRequest withKey(String key)
  {
    setKey(key);
    return this;
  }
  
  public String getExpression()
  {
    return expression;
  }
  
  public void setExpression(String expression)
  {
    this.expression = expression;
  }
  
  public SelectObjectContentRequest withExpression(String expression)
  {
    setExpression(expression);
    return this;
  }
  
  public String getExpressionType()
  {
    return expressionType;
  }
  
  public void setExpressionType(String expressionType)
  {
    this.expressionType = expressionType;
  }
  
  public SelectObjectContentRequest withExpressionType(String expressionType)
  {
    setExpressionType(expressionType);
    return this;
  }
  
  public void setExpressionType(ExpressionType expressionType)
  {
    setExpressionType(expressionType == null ? null : expressionType.toString());
  }
  
  public SelectObjectContentRequest withExpressionType(ExpressionType expressionType)
  {
    setExpressionType(expressionType);
    return this;
  }
  
  public RequestProgress getRequestProgress()
  {
    return requestProgress;
  }
  
  public void setRequestProgress(RequestProgress requestProgress)
  {
    this.requestProgress = requestProgress;
  }
  
  public SelectObjectContentRequest withRequestProgress(RequestProgress requestProgress)
  {
    setRequestProgress(requestProgress);
    return this;
  }
  
  public InputSerialization getInputSerialization()
  {
    return inputSerialization;
  }
  
  public void setInputSerialization(InputSerialization inputSerialization)
  {
    this.inputSerialization = inputSerialization;
  }
  
  public SelectObjectContentRequest withInputSerialization(InputSerialization inputSerialization)
  {
    setInputSerialization(inputSerialization);
    return this;
  }
  
  public OutputSerialization getOutputSerialization()
  {
    return outputSerialization;
  }
  
  public void setOutputSerialization(OutputSerialization outputSerialization)
  {
    this.outputSerialization = outputSerialization;
  }
  
  public SelectObjectContentRequest withOutputSerialization(OutputSerialization outputSerialization)
  {
    setOutputSerialization(outputSerialization);
    return this;
  }
  
  public SSECustomerKey getSSECustomerKey()
  {
    return sseCustomerKey;
  }
  
  public void setSSECustomerKey(SSECustomerKey sseCustomerKey)
  {
    this.sseCustomerKey = sseCustomerKey;
  }
  
  public SelectObjectContentRequest withSSECustomerKey(SSECustomerKey sseCustomerKey)
  {
    setSSECustomerKey(sseCustomerKey);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */