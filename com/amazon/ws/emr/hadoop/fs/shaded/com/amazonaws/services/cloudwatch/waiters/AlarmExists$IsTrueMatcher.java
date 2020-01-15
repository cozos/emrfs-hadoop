package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathEvaluationVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathExpression;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathField;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathFlatten;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathIdentity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathLengthFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.JmesPathProjection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.ObjectMapperSingleton;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmespath.OpGreaterThan;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.AcceptorPathMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

class AlarmExists$IsTrueMatcher
  extends WaiterAcceptor<DescribeAlarmsResult>
{
  private static final JsonNode expectedResult;
  
  static
  {
    try
    {
      expectedResult = ObjectMapperSingleton.getObjectMapper().readTree("true");
    }
    catch (IOException ioe)
    {
      throw new RuntimeException(ioe);
    }
  }
  
  private static final JmesPathExpression ast = new OpGreaterThan(new JmesPathLengthFunction(new JmesPathExpression[] { new JmesPathProjection(new JmesPathFlatten(new JmesPathField("MetricAlarms")), new JmesPathIdentity()) }), new JmesPathLiteral("0"));
  
  public boolean matches(DescribeAlarmsResult result)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.waiters.AlarmExists.IsTrueMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */