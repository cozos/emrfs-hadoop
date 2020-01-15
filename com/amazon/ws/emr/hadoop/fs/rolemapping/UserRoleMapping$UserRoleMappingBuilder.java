package com.amazon.ws.emr.hadoop.fs.rolemapping;

class UserRoleMapping$UserRoleMappingBuilder
  extends RoleMappingBuilder
{
  UserRoleMapping build()
  {
    return new UserRoleMapping(super.getRoleArn(), super.getTargets(), null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.rolemapping.UserRoleMapping.UserRoleMappingBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */