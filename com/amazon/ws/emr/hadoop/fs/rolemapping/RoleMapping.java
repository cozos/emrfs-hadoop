package com.amazon.ws.emr.hadoop.fs.rolemapping;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Regions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class RoleMapping
{
  private static final Logger LOG = LoggerFactory.getLogger(RoleMapping.class);
  @VisibleForTesting
  static final String ARN_SEPARATOR = "=";
  static final String TARGET_SEPARATOR = ";";
  static final String MATCH_SUCCESS_TEMPLATE = "Matching {} : {} with {}";
  
  @VisibleForTesting
  static RoleMapping fromConfig(String configuredMapping)
  {
    Preconditions.checkNotNull(configuredMapping);
    String mapping = configuredMapping.trim();
    
    String arn = mapping.substring(0, mapping.indexOf("=")).trim();
    mapping = mapping.substring(mapping.indexOf("=") + 1).trim();
    
    RoleMappingType roleMappingType = null;
    for (RoleMappingType type : RoleMappingType.values())
    {
      String typeRegex = String.format("^%1$s\\s*%2$s(|[^%2$s].*)$", new Object[] {type
        .getEncoding(), ":" });
      if (mapping.toLowerCase().matches(typeRegex))
      {
        roleMappingType = type;
        
        mapping = mapping.substring(mapping.indexOf(":") + 1).trim();
      }
    }
    if (roleMappingType == null) {
      failFromConfig(configuredMapping);
    }
    String[] targets = mapping.trim().split(";");
    
    RoleMapping newMapping = roleMappingType.getBuilder().withRoleArn(arn).withTargets(targets).build();
    if (!newMapping.isValid()) {
      failFromConfig(configuredMapping);
    }
    return newMapping;
  }
  
  private static void failFromConfig(String configuredMapping)
  {
    String errorMessage = String.format("%s is invalid. Expected format: <role arn>=<u|g|p>:<user|group|prefix>;<user|group|prefix>", new Object[] { configuredMapping });
    
    throw new IllegalArgumentException(errorMessage);
  }
  
  @VisibleForTesting
  static String sanitizeS3Path(String unsanitaryPath)
  {
    String S3_BUCKET_REGEX = "^[a-zA-Z0-9.\\-_]{1,255}$";
    String ERROR_MESSAGE = unsanitaryPath + " is not a valid prefix: %s";
    if (Strings.isNullOrEmpty(unsanitaryPath)) {
      throw new IllegalArgumentException(String.format(ERROR_MESSAGE, new Object[] { "Cannot be empty!" }));
    }
    boolean shouldEndInSlash = false;
    String sanitizedPath = unsanitaryPath;
    sanitizedPath = sanitizedPath.trim();
    if (sanitizedPath.contains("://"))
    {
      int indexOfFirstCharacterAfterScheme = sanitizedPath.indexOf("://") + "://".length();
      sanitizedPath = sanitizedPath.substring(indexOfFirstCharacterAfterScheme).trim();
    }
    int indexOfFirstSlash = sanitizedPath.indexOf('/');
    if (indexOfFirstSlash != -1)
    {
      if (!sanitizedPath.substring(0, indexOfFirstSlash).matches("^[a-zA-Z0-9.\\-_]{1,255}$")) {
        throw new IllegalArgumentException(String.format(ERROR_MESSAGE, new Object[] { "Everything before first '/' must be legal bucket characters!" }));
      }
    }
    else if (!sanitizedPath.matches("^[a-zA-Z0-9.\\-_]{1,255}$")) {
      throw new IllegalArgumentException(String.format(ERROR_MESSAGE, new Object[] { "Everything before first '/' must be legal bucket characters!" }));
    }
    while (sanitizedPath.startsWith("/")) {
      sanitizedPath = sanitizedPath.substring(1).trim();
    }
    while ((sanitizedPath.endsWith("/")) || (sanitizedPath.endsWith("*")))
    {
      if ((!shouldEndInSlash) && (sanitizedPath.endsWith("/"))) {
        shouldEndInSlash = true;
      }
      sanitizedPath = sanitizedPath.substring(0, sanitizedPath.length() - 1).trim();
    }
    if (sanitizedPath.isEmpty()) {
      throw new IllegalArgumentException(String.format(ERROR_MESSAGE, new Object[] { "Prefix must have legal characters!" }));
    }
    if (shouldEndInSlash) {
      sanitizedPath = sanitizedPath + "/";
    }
    return sanitizedPath;
  }
  
  protected static boolean isRoleArnValid(String roleArn)
  {
    return roleArn.matches(buildValidIAMRoleARNRegex());
  }
  
  abstract boolean appliesTo(RoleMappingContext paramRoleMappingContext);
  
  abstract String getRoleArn();
  
  abstract RoleMappingType getType();
  
  abstract String[] getTargets();
  
  abstract boolean isValid();
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append(getRoleArn());
    sb.append("=");
    sb.append(getType().getEncoding());
    sb.append(":");
    sb.append(Joiner.on(";").join(getTargets()));
    return sb.toString();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof RoleMapping)) {
      return false;
    }
    RoleMapping otherMapping = (RoleMapping)other;
    String[] myTargets = getTargets();
    String[] otherTargets = otherMapping.getTargets();
    if (myTargets.length == otherTargets.length) {
      for (int i = 0; i < myTargets.length; i++) {
        if (!myTargets[i].equals(otherTargets[i])) {
          return false;
        }
      }
    } else {
      return false;
    }
    return (otherMapping.getClass().equals(getClass())) && 
      (otherMapping.getRoleArn().equals(getRoleArn()));
  }
  
  private static String buildValidIAMRoleARNRegex()
  {
    String regexTemplate = "arn:%s:iam::[0-9]{12}:role/.*";
    Region currentRegion = Regions.getCurrentRegion();
    if (currentRegion == null) {
      throw new RuntimeException("EmrFS role mapping is not supported outside of EC2");
    }
    return String.format("arn:%s:iam::[0-9]{12}:role/.*", new Object[] { currentRegion.getPartition() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.rolemapping.RoleMapping
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */