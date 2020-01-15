package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy;

@Deprecated
public enum STSActions
  implements Action
{
  AssumeRole("sts:AssumeRole"),  AssumeRoleWithWebIdentity("sts:AssumeRoleWithWebIdentity");
  
  private final String action;
  
  private STSActions(String action)
  {
    this.action = action;
  }
  
  public String getActionName()
  {
    return action;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.STSActions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */