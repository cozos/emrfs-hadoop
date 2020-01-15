package com.amazon.ws.emr.hadoop.fs.rolemapping;

public abstract class RoleMappingBuilder
{
  private String roleArn = null;
  private String[] targets = null;
  
  abstract RoleMapping build();
  
  RoleMappingBuilder withRoleArn(String roleArn)
  {
    this.roleArn = roleArn;
    return this;
  }
  
  RoleMappingBuilder withTargets(String[] targets)
  {
    this.targets = targets;
    return this;
  }
  
  String getRoleArn()
  {
    return roleArn;
  }
  
  String[] getTargets()
  {
    return targets;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.rolemapping.RoleMappingBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */