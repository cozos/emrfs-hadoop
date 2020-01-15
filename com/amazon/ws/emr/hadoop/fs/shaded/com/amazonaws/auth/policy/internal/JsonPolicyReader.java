package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Action;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Policy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.PolicyReaderOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Principal;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Principal.WebIdentityProviders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Resource;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Statement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Statement.Effect;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class JsonPolicyReader
{
  private static final String PRINCIPAL_SCHEMA_USER = "AWS";
  private static final String PRINCIPAL_SCHEMA_SERVICE = "Service";
  private static final String PRINCIPAL_SCHEMA_FEDERATED = "Federated";
  private final PolicyReaderOptions options;
  
  public JsonPolicyReader()
  {
    this(new PolicyReaderOptions());
  }
  
  public JsonPolicyReader(PolicyReaderOptions options)
  {
    this.options = options;
  }
  
  public Policy createPolicyFromJsonString(String jsonString)
  {
    if (jsonString == null) {
      throw new IllegalArgumentException("JSON string cannot be null");
    }
    Policy policy = new Policy();
    List<Statement> statements = new LinkedList();
    try
    {
      JsonNode policyNode = Jackson.jsonNodeOf(jsonString);
      
      JsonNode idNode = policyNode.get("Id");
      if (isNotNull(idNode)) {
        policy.setId(idNode.asText());
      }
      JsonNode statementsNode = policyNode.get("Statement");
      if (isNotNull(statementsNode)) {
        if (statementsNode.isObject()) {
          statements.add(statementOf(statementsNode));
        } else if (statementsNode.isArray()) {
          for (JsonNode statementNode : statementsNode) {
            statements.add(statementOf(statementNode));
          }
        }
      }
    }
    catch (Exception e)
    {
      String message = "Unable to generate policy object fron JSON string " + e.getMessage();
      throw new IllegalArgumentException(message, e);
    }
    JsonNode statementsNode;
    JsonNode idNode;
    JsonNode policyNode;
    policy.setStatements(statements);
    return policy;
  }
  
  private Statement statementOf(JsonNode jStatement)
  {
    JsonNode effectNode = jStatement.get("Effect");
    
    Statement.Effect effect = isNotNull(effectNode) ? Statement.Effect.valueOf(effectNode.asText()) : Statement.Effect.Deny;
    
    Statement statement = new Statement(effect);
    
    JsonNode id = jStatement.get("Sid");
    if (isNotNull(id)) {
      statement.setId(id.asText());
    }
    JsonNode actionNodes = jStatement.get("Action");
    if (isNotNull(actionNodes)) {
      statement.setActions(actionsOf(actionNodes));
    }
    List<Resource> resources = new LinkedList();
    JsonNode resourceNodes = jStatement.get("Resource");
    if (isNotNull(resourceNodes)) {
      resources.addAll(resourcesOf(resourceNodes, false));
    }
    JsonNode notResourceNodes = jStatement.get("NotResource");
    if (isNotNull(notResourceNodes)) {
      resources.addAll(resourcesOf(notResourceNodes, true));
    }
    if (!resources.isEmpty()) {
      statement.setResources(resources);
    }
    JsonNode conditionNodes = jStatement.get("Condition");
    if (isNotNull(conditionNodes)) {
      statement.setConditions(conditionsOf(conditionNodes));
    }
    JsonNode principalNodes = jStatement.get("Principal");
    if (isNotNull(principalNodes)) {
      statement.setPrincipals(principalOf(principalNodes));
    }
    return statement;
  }
  
  private List<Action> actionsOf(JsonNode actionNodes)
  {
    List<Action> actions = new LinkedList();
    if (actionNodes.isArray()) {
      for (JsonNode action : actionNodes) {
        actions.add(new NamedAction(action.asText()));
      }
    } else {
      actions.add(new NamedAction(actionNodes.asText()));
    }
    return actions;
  }
  
  private List<Resource> resourcesOf(JsonNode resourceNodes, boolean isNotType)
  {
    List<Resource> resources = new LinkedList();
    if (resourceNodes.isArray()) {
      for (JsonNode resource : resourceNodes) {
        resources.add(new Resource(resource.asText()).withIsNotType(isNotType));
      }
    } else {
      resources.add(new Resource(resourceNodes.asText()).withIsNotType(isNotType));
    }
    return resources;
  }
  
  private List<Principal> principalOf(JsonNode principalNodes)
  {
    List<Principal> principals = new LinkedList();
    if (principalNodes.asText().equals("*"))
    {
      principals.add(Principal.All);
      return principals;
    }
    Iterator<Map.Entry<String, JsonNode>> mapOfPrincipals = principalNodes.fields();
    while (mapOfPrincipals.hasNext())
    {
      Map.Entry<String, JsonNode> principal = (Map.Entry)mapOfPrincipals.next();
      String schema = (String)principal.getKey();
      JsonNode principalNode = (JsonNode)principal.getValue();
      if (principalNode.isArray())
      {
        Iterator<JsonNode> elements = principalNode.elements();
        while (elements.hasNext()) {
          principals.add(createPrincipal(schema, (JsonNode)elements.next()));
        }
      }
      else
      {
        principals.add(createPrincipal(schema, principalNode));
      }
    }
    return principals;
  }
  
  private Principal createPrincipal(String schema, JsonNode principalNode)
  {
    if (schema.equalsIgnoreCase("AWS")) {
      return new Principal("AWS", principalNode.asText(), options.isStripAwsPrincipalIdHyphensEnabled());
    }
    if (schema.equalsIgnoreCase("Service")) {
      return new Principal(schema, principalNode.asText());
    }
    if (schema.equalsIgnoreCase("Federated"))
    {
      if (Principal.WebIdentityProviders.fromString(principalNode.asText()) != null) {
        return new Principal(Principal.WebIdentityProviders.fromString(principalNode.asText()));
      }
      return new Principal("Federated", principalNode.asText());
    }
    throw new SdkClientException("Schema " + schema + " is not a valid value for the principal.");
  }
  
  private List<Condition> conditionsOf(JsonNode conditionNodes)
  {
    List<Condition> conditionList = new LinkedList();
    
    Iterator<Map.Entry<String, JsonNode>> mapOfConditions = conditionNodes.fields();
    while (mapOfConditions.hasNext())
    {
      Map.Entry<String, JsonNode> condition = (Map.Entry)mapOfConditions.next();
      convertConditionRecord(conditionList, (String)condition.getKey(), 
        (JsonNode)condition.getValue());
    }
    return conditionList;
  }
  
  private void convertConditionRecord(List<Condition> conditions, String conditionType, JsonNode conditionNode)
  {
    Iterator<Map.Entry<String, JsonNode>> mapOfFields = conditionNode.fields();
    while (mapOfFields.hasNext())
    {
      List<String> values = new LinkedList();
      Map.Entry<String, JsonNode> field = (Map.Entry)mapOfFields.next();
      JsonNode fieldValue = (JsonNode)field.getValue();
      if (fieldValue.isArray())
      {
        Iterator<JsonNode> elements = fieldValue.elements();
        while (elements.hasNext()) {
          values.add(((JsonNode)elements.next()).asText());
        }
      }
      values.add(fieldValue.asText());
      
      conditions.add(new Condition().withType(conditionType)
        .withConditionKey((String)field.getKey()).withValues(values));
    }
  }
  
  private static class NamedAction
    implements Action
  {
    private String actionName;
    
    public NamedAction(String actionName)
    {
      this.actionName = actionName;
    }
    
    public String getActionName()
    {
      return actionName;
    }
  }
  
  private boolean isNotNull(Object object)
  {
    return null != object;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.internal.JsonPolicyReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */