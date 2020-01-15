package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathEvaluationVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathExpression;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathField;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathSubExpression;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.ObjectMapperSingleton;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.AcceptorPathMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@SdkInternalApi
class TableExists
{
  static class IsACTIVEMatcher
    extends WaiterAcceptor<DescribeTableResult>
  {
    private static final JsonNode expectedResult;
    
    static
    {
      try
      {
        expectedResult = ObjectMapperSingleton.getObjectMapper().readTree("\"ACTIVE\"");
      }
      catch (IOException ioe)
      {
        throw new RuntimeException(ioe);
      }
    }
    
    private static final JmesPathExpression ast = new JmesPathSubExpression(new JmesPathExpression[] { new JmesPathField("Table"), new JmesPathField("TableStatus") });
    
    public boolean matches(DescribeTableResult result)
    {
      JsonNode queryNode = ObjectMapperSingleton.getObjectMapper().valueToTree(result);
      JsonNode finalResult = (JsonNode)ast.accept(new JmesPathEvaluationVisitor(), queryNode);
      return AcceptorPathMatcher.path(expectedResult, finalResult);
    }
    
    public WaiterState getState()
    {
      return WaiterState.SUCCESS;
    }
  }
  
  static class IsResourceNotFoundExceptionMatcher
    extends WaiterAcceptor<DescribeTableResult>
  {
    public boolean matches(AmazonServiceException e)
    {
      return "ResourceNotFoundException".equals(e.getErrorCode());
    }
    
    public WaiterState getState()
    {
      return WaiterState.RETRY;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.waiters.TableExists
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */