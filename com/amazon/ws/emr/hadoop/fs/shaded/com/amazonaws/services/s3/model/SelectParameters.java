package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class SelectParameters
  implements Serializable, Cloneable
{
  private InputSerialization inputSerialization;
  private String expressionType;
  private String expression;
  private OutputSerialization outputSerialization;
  
  public InputSerialization getInputSerialization()
  {
    return inputSerialization;
  }
  
  public void setInputSerialization(InputSerialization inputSerialization)
  {
    this.inputSerialization = inputSerialization;
  }
  
  public SelectParameters withInputSerialization(InputSerialization inputSerialization)
  {
    setInputSerialization(inputSerialization);
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
  
  public SelectParameters withExpressionType(String expressionType)
  {
    setExpressionType(expressionType);
    return this;
  }
  
  public SelectParameters withExpressionType(ExpressionType expressionType)
  {
    setExpressionType(expressionType == null ? null : expressionType.toString());
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
  
  public SelectParameters withExpression(String expression)
  {
    setExpression(expression);
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
  
  public SelectParameters withOutputSerialization(OutputSerialization outputSerialization)
  {
    setOutputSerialization(outputSerialization);
    return this;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (!(obj instanceof SelectParameters))) {
      return false;
    }
    SelectParameters other = (SelectParameters)obj;
    if (((other.getInputSerialization() == null ? 1 : 0) ^ (getInputSerialization() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInputSerialization() != null) && (!other.getInputSerialization().equals(getInputSerialization()))) {
      return false;
    }
    if (((other.getExpressionType() == null ? 1 : 0) ^ (getExpressionType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpressionType() != null) && (!other.getExpressionType().equals(getExpressionType()))) {
      return false;
    }
    if (((other.getExpression() == null ? 1 : 0) ^ (getExpression() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpression() != null) && (!other.getExpression().equals(getExpression()))) {
      return false;
    }
    if (((other.getOutputSerialization() == null ? 1 : 0) ^ (getOutputSerialization() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOutputSerialization() != null) && (!other.getOutputSerialization().equals(getOutputSerialization()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getInputSerialization() == null ? 0 : getInputSerialization().hashCode());
    hashCode = 31 * hashCode + (getExpressionType() == null ? 0 : getExpressionType().hashCode());
    hashCode = 31 * hashCode + (getExpression() == null ? 0 : getExpression().hashCode());
    hashCode = 31 * hashCode + (getOutputSerialization() == null ? 0 : getOutputSerialization().hashCode());
    return hashCode;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInputSerialization() != null) {
      sb.append("InputSerialization: ").append(getInputSerialization()).append(",");
    }
    if (getExpressionType() != null) {
      sb.append("ExpressionType: ").append(getExpressionType()).append(",");
    }
    if (getExpression() != null) {
      sb.append("Expression: ").append(getExpression()).append(",");
    }
    if (getOutputSerialization() != null) {
      sb.append("OutputSerialization: ").append(getOutputSerialization());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public SelectParameters clone()
  {
    try
    {
      return (SelectParameters)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */