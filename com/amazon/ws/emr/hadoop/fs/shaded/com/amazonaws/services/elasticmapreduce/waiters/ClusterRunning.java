package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathEvaluationVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathExpression;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathField;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathSubExpression;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.ObjectMapperSingleton;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.AcceptorPathMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@SdkInternalApi
class ClusterRunning
{
  static class IsRUNNINGMatcher
    extends WaiterAcceptor<DescribeClusterResult>
  {
    private static final JsonNode expectedResult;
    
    static
    {
      try
      {
        expectedResult = ObjectMapperSingleton.getObjectMapper().readTree("\"RUNNING\"");
      }
      catch (IOException ioe)
      {
        throw new RuntimeException(ioe);
      }
    }
    
    private static final JmesPathExpression ast = new JmesPathSubExpression(new JmesPathExpression[] { new JmesPathField("Cluster"), new JmesPathField("Status"), new JmesPathField("State") });
    
    public boolean matches(DescribeClusterResult result)
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
  
  static class IsWAITINGMatcher
    extends WaiterAcceptor<DescribeClusterResult>
  {
    private static final JsonNode expectedResult;
    
    static
    {
      try
      {
        expectedResult = ObjectMapperSingleton.getObjectMapper().readTree("\"WAITING\"");
      }
      catch (IOException ioe)
      {
        throw new RuntimeException(ioe);
      }
    }
    
    private static final JmesPathExpression ast = new JmesPathSubExpression(new JmesPathExpression[] { new JmesPathField("Cluster"), new JmesPathField("Status"), new JmesPathField("State") });
    
    public boolean matches(DescribeClusterResult result)
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
  
  static class IsTERMINATINGMatcher
    extends WaiterAcceptor<DescribeClusterResult>
  {
    private static final JsonNode expectedResult;
    
    static
    {
      try
      {
        expectedResult = ObjectMapperSingleton.getObjectMapper().readTree("\"TERMINATING\"");
      }
      catch (IOException ioe)
      {
        throw new RuntimeException(ioe);
      }
    }
    
    private static final JmesPathExpression ast = new JmesPathSubExpression(new JmesPathExpression[] { new JmesPathField("Cluster"), new JmesPathField("Status"), new JmesPathField("State") });
    
    public boolean matches(DescribeClusterResult result)
    {
      JsonNode queryNode = ObjectMapperSingleton.getObjectMapper().valueToTree(result);
      JsonNode finalResult = (JsonNode)ast.accept(new JmesPathEvaluationVisitor(), queryNode);
      return AcceptorPathMatcher.path(expectedResult, finalResult);
    }
    
    public WaiterState getState()
    {
      return WaiterState.FAILURE;
    }
  }
  
  static class IsTERMINATEDMatcher
    extends WaiterAcceptor<DescribeClusterResult>
  {
    private static final JsonNode expectedResult;
    
    static
    {
      try
      {
        expectedResult = ObjectMapperSingleton.getObjectMapper().readTree("\"TERMINATED\"");
      }
      catch (IOException ioe)
      {
        throw new RuntimeException(ioe);
      }
    }
    
    private static final JmesPathExpression ast = new JmesPathSubExpression(new JmesPathExpression[] { new JmesPathField("Cluster"), new JmesPathField("Status"), new JmesPathField("State") });
    
    public boolean matches(DescribeClusterResult result)
    {
      JsonNode queryNode = ObjectMapperSingleton.getObjectMapper().valueToTree(result);
      JsonNode finalResult = (JsonNode)ast.accept(new JmesPathEvaluationVisitor(), queryNode);
      return AcceptorPathMatcher.path(expectedResult, finalResult);
    }
    
    public WaiterState getState()
    {
      return WaiterState.FAILURE;
    }
  }
  
  static class IsTERMINATED_WITH_ERRORSMatcher
    extends WaiterAcceptor<DescribeClusterResult>
  {
    private static final JsonNode expectedResult;
    
    static
    {
      try
      {
        expectedResult = ObjectMapperSingleton.getObjectMapper().readTree("\"TERMINATED_WITH_ERRORS\"");
      }
      catch (IOException ioe)
      {
        throw new RuntimeException(ioe);
      }
    }
    
    private static final JmesPathExpression ast = new JmesPathSubExpression(new JmesPathExpression[] { new JmesPathField("Cluster"), new JmesPathField("Status"), new JmesPathField("State") });
    
    public boolean matches(DescribeClusterResult result)
    {
      JsonNode queryNode = ObjectMapperSingleton.getObjectMapper().valueToTree(result);
      JsonNode finalResult = (JsonNode)ast.accept(new JmesPathEvaluationVisitor(), queryNode);
      return AcceptorPathMatcher.path(expectedResult, finalResult);
    }
    
    public WaiterState getState()
    {
      return WaiterState.FAILURE;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.waiters.ClusterRunning
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */