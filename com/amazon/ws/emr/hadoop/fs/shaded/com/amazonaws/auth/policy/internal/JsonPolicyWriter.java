package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Action;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Policy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Principal;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Resource;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Statement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Statement.Effect;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.PolicyUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JsonPolicyWriter
{
  private JsonGenerator generator = null;
  private Writer writer;
  private static final Log log = LogFactory.getLog("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy");
  
  public JsonPolicyWriter()
  {
    writer = new StringWriter();
    try
    {
      generator = Jackson.jsonGeneratorOf(writer);
    }
    catch (IOException ioe)
    {
      throw new SdkClientException("Unable to instantiate JsonGenerator.", ioe);
    }
  }
  
  public String writePolicyToString(Policy policy)
  {
    if (!isNotNull(policy)) {
      throw new IllegalArgumentException("Policy cannot be null");
    }
    try
    {
      return jsonStringOf(policy);
    }
    catch (Exception e)
    {
      String message = "Unable to serialize policy to JSON string: " + e.getMessage();
      throw new IllegalArgumentException(message, e);
    }
    finally
    {
      try
      {
        writer.close();
      }
      catch (Exception localException2) {}
    }
  }
  
  private String jsonStringOf(Policy policy)
    throws JsonGenerationException, IOException
  {
    generator.writeStartObject();
    
    writeJsonKeyValue("Version", policy.getVersion());
    if (isNotNull(policy.getId())) {
      writeJsonKeyValue("Id", policy.getId());
    }
    writeJsonArrayStart("Statement");
    for (Statement statement : policy.getStatements())
    {
      generator.writeStartObject();
      if (isNotNull(statement.getId())) {
        writeJsonKeyValue("Sid", statement.getId());
      }
      writeJsonKeyValue("Effect", statement
        .getEffect().toString());
      
      List<Principal> principals = statement.getPrincipals();
      if ((isNotNull(principals)) && (!principals.isEmpty())) {
        writePrincipals(principals);
      }
      List<Action> actions = statement.getActions();
      if ((isNotNull(actions)) && (!actions.isEmpty())) {
        writeActions(actions);
      }
      List<Resource> resources = statement.getResources();
      if ((isNotNull(resources)) && (!resources.isEmpty())) {
        writeResources(resources);
      }
      List<Condition> conditions = statement.getConditions();
      if ((isNotNull(conditions)) && (!conditions.isEmpty())) {
        writeConditions(conditions);
      }
      generator.writeEndObject();
    }
    writeJsonArrayEnd();
    
    generator.writeEndObject();
    
    generator.flush();
    
    return writer.toString();
  }
  
  private void writeConditions(List<Condition> conditions)
    throws JsonGenerationException, IOException
  {
    Map<String, ConditionsByKey> conditionsByType = groupConditionsByTypeAndKey(conditions);
    
    writeJsonObjectStart("Condition");
    for (Map.Entry<String, ConditionsByKey> entry : conditionsByType
      .entrySet())
    {
      ConditionsByKey conditionsByKey = (ConditionsByKey)conditionsByType.get(entry.getKey());
      
      writeJsonObjectStart((String)entry.getKey());
      for (String key : conditionsByKey.keySet()) {
        writeJsonArray(key, conditionsByKey.getConditionsByKey(key));
      }
      writeJsonObjectEnd();
    }
    writeJsonObjectEnd();
  }
  
  private void writeResources(List<Resource> resources)
    throws JsonGenerationException, IOException
  {
    PolicyUtils.validateResourceList(resources);
    List<String> resourceStrings = new ArrayList();
    for (Resource resource : resources) {
      resourceStrings.add(resource.getId());
    }
    if (((Resource)resources.get(0)).isNotType()) {
      writeJsonArray("NotResource", resourceStrings);
    } else {
      writeJsonArray("Resource", resourceStrings);
    }
  }
  
  private void writeActions(List<Action> actions)
    throws JsonGenerationException, IOException
  {
    List<String> actionStrings = new ArrayList();
    for (Action action : actions) {
      actionStrings.add(action.getActionName());
    }
    writeJsonArray("Action", actionStrings);
  }
  
  private void writePrincipals(List<Principal> principals)
    throws JsonGenerationException, IOException
  {
    if ((principals.size() == 1) && (((Principal)principals.get(0)).equals(Principal.All)))
    {
      writeJsonKeyValue("Principal", Principal.All.getId());
    }
    else
    {
      writeJsonObjectStart("Principal");
      
      Map<String, List<String>> principalsByScheme = groupPrincipalByScheme(principals);
      for (Map.Entry<String, List<String>> entry : principalsByScheme.entrySet())
      {
        List<String> principalValues = (List)principalsByScheme.get(entry.getKey());
        if (principalValues.size() == 1) {
          writeJsonKeyValue((String)entry.getKey(), (String)principalValues.get(0));
        } else {
          writeJsonArray((String)entry.getKey(), principalValues);
        }
      }
      writeJsonObjectEnd();
    }
  }
  
  private Map<String, List<String>> groupPrincipalByScheme(List<Principal> principals)
  {
    Map<String, List<String>> principalsByScheme = new LinkedHashMap();
    for (Principal principal : principals)
    {
      String provider = principal.getProvider();
      if (!principalsByScheme.containsKey(provider)) {
        principalsByScheme.put(provider, new ArrayList());
      }
      List<String> principalValues = (List)principalsByScheme.get(provider);
      principalValues.add(principal.getId());
    }
    return principalsByScheme;
  }
  
  static class ConditionsByKey
  {
    private Map<String, List<String>> conditionsByKey;
    
    public ConditionsByKey()
    {
      conditionsByKey = new LinkedHashMap();
    }
    
    public Map<String, List<String>> getConditionsByKey()
    {
      return conditionsByKey;
    }
    
    public void setConditionsByKey(Map<String, List<String>> conditionsByKey)
    {
      this.conditionsByKey = conditionsByKey;
    }
    
    public boolean containsKey(String key)
    {
      return conditionsByKey.containsKey(key);
    }
    
    public List<String> getConditionsByKey(String key)
    {
      return (List)conditionsByKey.get(key);
    }
    
    public Set<String> keySet()
    {
      return conditionsByKey.keySet();
    }
    
    public void addValuesToKey(String key, List<String> values)
    {
      List<String> conditionValues = getConditionsByKey(key);
      if (conditionValues == null) {
        conditionsByKey.put(key, new ArrayList(values));
      } else {
        conditionValues.addAll(values);
      }
    }
  }
  
  private Map<String, ConditionsByKey> groupConditionsByTypeAndKey(List<Condition> conditions)
  {
    Map<String, ConditionsByKey> conditionsByType = new LinkedHashMap();
    for (Condition condition : conditions)
    {
      String type = condition.getType();
      String key = condition.getConditionKey();
      if (!conditionsByType.containsKey(type)) {
        conditionsByType.put(type, new ConditionsByKey());
      }
      ConditionsByKey conditionsByKey = (ConditionsByKey)conditionsByType.get(type);
      conditionsByKey.addValuesToKey(key, condition.getValues());
    }
    return conditionsByType;
  }
  
  private void writeJsonArray(String arrayName, List<String> values)
    throws JsonGenerationException, IOException
  {
    writeJsonArrayStart(arrayName);
    for (String value : values) {
      generator.writeString(value);
    }
    writeJsonArrayEnd();
  }
  
  private void writeJsonObjectStart(String fieldName)
    throws JsonGenerationException, IOException
  {
    generator.writeObjectFieldStart(fieldName);
  }
  
  private void writeJsonObjectEnd()
    throws JsonGenerationException, IOException
  {
    generator.writeEndObject();
  }
  
  private void writeJsonArrayStart(String fieldName)
    throws JsonGenerationException, IOException
  {
    generator.writeArrayFieldStart(fieldName);
  }
  
  private void writeJsonArrayEnd()
    throws JsonGenerationException, IOException
  {
    generator.writeEndArray();
  }
  
  private void writeJsonKeyValue(String fieldName, String value)
    throws JsonGenerationException, IOException
  {
    generator.writeStringField(fieldName, value);
  }
  
  private boolean isNotNull(Object object)
  {
    return null != object;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.internal.JsonPolicyWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */