package com.amazon.ws.emr.hadoop.fs.rolemapping;

class PrefixRoleMapping$PrefixRoleMappingBuilder
  extends RoleMappingBuilder
{
  PrefixRoleMapping build()
  {
    return new PrefixRoleMapping(super.getRoleArn(), super.getTargets(), null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.rolemapping.PrefixRoleMapping.PrefixRoleMappingBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */