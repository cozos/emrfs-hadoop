package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Action;

class JsonPolicyReader$NamedAction
  implements Action
{
  private String actionName;
  
  public JsonPolicyReader$NamedAction(String actionName)
  {
    this.actionName = actionName;
  }
  
  public String getActionName()
  {
    return actionName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.internal.JsonPolicyReader.NamedAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */