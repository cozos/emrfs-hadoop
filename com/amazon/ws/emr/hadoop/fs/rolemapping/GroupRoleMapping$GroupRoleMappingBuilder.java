package com.amazon.ws.emr.hadoop.fs.rolemapping;

class GroupRoleMapping$GroupRoleMappingBuilder
  extends RoleMappingBuilder
{
  GroupRoleMapping build()
  {
    return new GroupRoleMapping(super.getRoleArn(), super.getTargets(), null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.rolemapping.GroupRoleMapping.GroupRoleMappingBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */