package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.internal.JsonPolicyReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.internal.JsonPolicyWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Policy
{
  private static final String DEFAULT_POLICY_VERSION = "2012-10-17";
  private String id;
  private String version = "2012-10-17";
  private List<Statement> statements = new ArrayList();
  
  public Policy() {}
  
  public Policy(String id)
  {
    this.id = id;
  }
  
  public Policy(String id, Collection<Statement> statements)
  {
    this(id);
    setStatements(statements);
  }
  
  public String getId()
  {
    return id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public Policy withId(String id)
  {
    setId(id);
    return this;
  }
  
  public String getVersion()
  {
    return version;
  }
  
  public Collection<Statement> getStatements()
  {
    return statements;
  }
  
  public void setStatements(Collection<Statement> statements)
  {
    this.statements = new ArrayList(statements);
    assignUniqueStatementIds();
  }
  
  public Policy withStatements(Statement... statements)
  {
    setStatements(Arrays.asList(statements));
    return this;
  }
  
  public String toJson()
  {
    return new JsonPolicyWriter().writePolicyToString(this);
  }
  
  public static Policy fromJson(String jsonString)
  {
    return fromJson(jsonString, new PolicyReaderOptions());
  }
  
  public static Policy fromJson(String jsonString, PolicyReaderOptions options)
  {
    return new JsonPolicyReader(options).createPolicyFromJsonString(jsonString);
  }
  
  private void assignUniqueStatementIds()
  {
    Set<String> usedStatementIds = new HashSet();
    for (Iterator localIterator = statements.iterator(); localIterator.hasNext();)
    {
      statement = (Statement)localIterator.next();
      if (statement.getId() != null) {
        usedStatementIds.add(statement.getId());
      }
    }
    Statement statement;
    int counter = 0;
    for (Statement statement : statements) {
      if (statement.getId() == null)
      {
        while (usedStatementIds.contains(Integer.toString(++counter))) {}
        statement.setId(Integer.toString(counter));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Policy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */