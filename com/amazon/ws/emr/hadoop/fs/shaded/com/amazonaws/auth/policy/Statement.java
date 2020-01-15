package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.PolicyUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Statement
{
  private String id;
  private Effect effect;
  
  public static enum Effect
  {
    Allow,  Deny;
    
    private Effect() {}
  }
  
  private List<Principal> principals = new ArrayList();
  private List<Action> actions = new ArrayList();
  private List<Resource> resources;
  private List<Condition> conditions = new ArrayList();
  
  public Statement(Effect effect)
  {
    this.effect = effect;
    id = null;
  }
  
  public String getId()
  {
    return id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public Statement withId(String id)
  {
    setId(id);
    return this;
  }
  
  public Effect getEffect()
  {
    return effect;
  }
  
  public void setEffect(Effect effect)
  {
    this.effect = effect;
  }
  
  public List<Action> getActions()
  {
    return actions;
  }
  
  public void setActions(Collection<Action> actions)
  {
    this.actions = new ArrayList(actions);
  }
  
  public Statement withActions(Action... actions)
  {
    setActions(Arrays.asList(actions));
    return this;
  }
  
  public List<Resource> getResources()
  {
    return resources;
  }
  
  public void setResources(Collection<Resource> resources)
  {
    List<Resource> resourceList = new ArrayList(resources);
    PolicyUtils.validateResourceList(resourceList);
    this.resources = resourceList;
  }
  
  public Statement withResources(Resource... resources)
  {
    setResources(Arrays.asList(resources));
    return this;
  }
  
  public List<Condition> getConditions()
  {
    return conditions;
  }
  
  public void setConditions(List<Condition> conditions)
  {
    this.conditions = conditions;
  }
  
  public Statement withConditions(Condition... conditions)
  {
    setConditions(Arrays.asList(conditions));
    return this;
  }
  
  public List<Principal> getPrincipals()
  {
    return principals;
  }
  
  public void setPrincipals(Collection<Principal> principals)
  {
    this.principals = new ArrayList(principals);
  }
  
  public void setPrincipals(Principal... principals)
  {
    setPrincipals(new ArrayList(Arrays.asList(principals)));
  }
  
  public Statement withPrincipals(Principal... principals)
  {
    setPrincipals(principals);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Statement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */