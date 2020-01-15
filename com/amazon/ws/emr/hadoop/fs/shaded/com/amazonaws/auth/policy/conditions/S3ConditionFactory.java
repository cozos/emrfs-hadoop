package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;

public class S3ConditionFactory
{
  public static final String CANNED_ACL_CONDITION_KEY = "s3:x-amz-acl";
  public static final String LOCATION_CONSTRAINT_CONDITION_KEY = "s3:LocationConstraint";
  public static final String PREFIX_CONDITION_KEY = "s3:prefix";
  public static final String DELIMITER_CONDITION_KEY = "s3:delimiter";
  public static final String MAX_KEYS_CONDITION_KEY = "s3:max-keys";
  public static final String COPY_SOURCE_CONDITION_KEY = "s3:x-amz-copy-source";
  public static final String METADATA_DIRECTIVE_CONDITION_KEY = "s3:x-amz-metadata-directive";
  public static final String VERSION_ID_CONDITION_KEY = "s3:VersionId";
  
  public static Condition newCannedACLCondition(CannedAccessControlList cannedAcl)
  {
    return new StringCondition(StringCondition.StringComparisonType.StringEquals, "s3:x-amz-acl", cannedAcl
      .toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions.S3ConditionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */