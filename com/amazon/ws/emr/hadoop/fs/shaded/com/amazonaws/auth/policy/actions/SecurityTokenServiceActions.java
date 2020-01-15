package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Action;

public enum SecurityTokenServiceActions
  implements Action
{
  AllSecurityTokenServiceActions("sts:*"),  AssumeRole("sts:AssumeRole"),  AssumeRoleWithSAML("sts:AssumeRoleWithSAML"),  AssumeRoleWithWebIdentity("sts:AssumeRoleWithWebIdentity"),  DecodeAuthorizationMessage("sts:DecodeAuthorizationMessage"),  GetAccessKeyInfo("sts:GetAccessKeyInfo"),  GetCallerIdentity("sts:GetCallerIdentity"),  GetFederationToken("sts:GetFederationToken"),  GetSessionToken("sts:GetSessionToken");
  
  private final String action;
  
  private SecurityTokenServiceActions(String action)
  {
    this.action = action;
  }
  
  public String getActionName()
  {
    return action;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions.SecurityTokenServiceActions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */