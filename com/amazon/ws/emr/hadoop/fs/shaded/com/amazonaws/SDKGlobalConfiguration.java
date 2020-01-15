package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

public class SDKGlobalConfiguration
{
  public static final String DISABLE_CERT_CHECKING_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.disableCertChecking";
  public static final String DEFAULT_METRICS_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.enableDefaultMetrics";
  public static final String ACCESS_KEY_SYSTEM_PROPERTY = "aws.accessKeyId";
  public static final String SECRET_KEY_SYSTEM_PROPERTY = "aws.secretKey";
  public static final String SESSION_TOKEN_SYSTEM_PROPERTY = "aws.sessionToken";
  public static final String AWS_REGION_SYSTEM_PROPERTY = "aws.region";
  public static final String EC2_METADATA_SERVICE_OVERRIDE_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.ec2MetadataServiceEndpointOverride";
  public static final String RETRY_THROTTLING_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.enableThrottledRetry";
  public static final String REGIONS_FILE_OVERRIDE_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils.fileOverride";
  public static final String DISABLE_REMOTE_REGIONS_FILE_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils.disableRemote";
  @Deprecated
  public static final String ENABLE_S3_SIGV4_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.enableV4";
  @Deprecated
  public static final String ENFORCE_S3_SIGV4_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.enforceV4";
  public static final String DISABLE_S3_IMPLICIT_GLOBAL_CLIENTS_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.disableImplicitGlobalClients";
  public static final String ENABLE_IN_REGION_OPTIMIZED_MODE = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.enableInRegionOptimizedMode";
  @Deprecated
  public static final String DEFAULT_S3_STREAM_BUFFER_SIZE = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.s3.defaultStreamBufferSize";
  @Deprecated
  public static final String PROFILING_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.enableRuntimeProfiling";
  public static final String DEFAULT_AWS_CSM_HOST = "127.0.0.1";
  public static final int DEFAULT_AWS_CSM_PORT = 31000;
  public static final String DEFAULT_AWS_CSM_CLIENT_ID = "";
  public static final String AWS_CSM_ENABLED_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.csm.enabled";
  public static final String AWS_CSM_HOST_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.csm.host";
  public static final String AWS_CSM_PORT_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.csm.port";
  public static final String AWS_CSM_CLIENT_ID_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.csm.clientId";
  public static final String ACCESS_KEY_ENV_VAR = "AWS_ACCESS_KEY_ID";
  public static final String ALTERNATE_ACCESS_KEY_ENV_VAR = "AWS_ACCESS_KEY";
  public static final String SECRET_KEY_ENV_VAR = "AWS_SECRET_KEY";
  public static final String ALTERNATE_SECRET_KEY_ENV_VAR = "AWS_SECRET_ACCESS_KEY";
  public static final String AWS_SESSION_TOKEN_ENV_VAR = "AWS_SESSION_TOKEN";
  public static final String AWS_WEB_IDENTITY_ENV_VAR = "AWS_WEB_IDENTITY_TOKEN_FILE";
  public static final String AWS_ROLE_ARN_ENV_VAR = "AWS_ROLE_ARN";
  public static final String AWS_ROLE_SESSION_NAME_ENV_VAR = "AWS_ROLE_SESSION_NAME";
  public static final String AWS_REGION_ENV_VAR = "AWS_REGION";
  public static final String AWS_CONFIG_FILE_ENV_VAR = "AWS_CONFIG_FILE";
  public static final String AWS_CBOR_DISABLE_ENV_VAR = "AWS_CBOR_DISABLE";
  public static final String AWS_CBOR_DISABLE_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.disableCbor";
  public static final String AWS_ION_BINARY_DISABLE_ENV_VAR = "AWS_ION_BINARY_DISABLE";
  public static final String AWS_ION_BINARY_DISABLE_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.disableIonBinary";
  public static final String AWS_EC2_METADATA_DISABLED_ENV_VAR = "AWS_EC2_METADATA_DISABLED";
  public static final String AWS_EC2_METADATA_DISABLED_SYSTEM_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.disableEc2Metadata";
  public static final String AWS_CSM_ENABLED_ENV_VAR = "AWS_CSM_ENABLED";
  public static final String AWS_CSM_HOST_ENV_VAR = "AWS_CSM_HOST";
  public static final String AWS_CSM_PORT_ENV_VAR = "AWS_CSM_PORT";
  public static final String AWS_CSM_CLIENT_ID_ENV_VAR = "AWS_CSM_CLIENT_ID";
  
  @Deprecated
  public static void setGlobalTimeOffset(int timeOffset)
  {
    SDKGlobalTime.setGlobalTimeOffset(timeOffset);
  }
  
  @Deprecated
  public static int getGlobalTimeOffset()
  {
    return SDKGlobalTime.getGlobalTimeOffset();
  }
  
  public static boolean isInRegionOptimizedModeEnabled()
  {
    return isPropertyEnabled(System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.enableInRegionOptimizedMode"));
  }
  
  public static boolean isCertCheckingDisabled()
  {
    return isPropertyEnabled(System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.disableCertChecking"));
  }
  
  public static boolean isCborDisabled()
  {
    return (isPropertyEnabled(System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.disableCbor"))) || 
      (isPropertyEnabled(System.getenv("AWS_CBOR_DISABLE")));
  }
  
  public static boolean isIonBinaryDisabled()
  {
    return (isPropertyEnabled(System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.disableIonBinary"))) || 
      (isPropertyEnabled(System.getenv("AWS_ION_BINARY_DISABLE")));
  }
  
  public static boolean isEc2MetadataDisabled()
  {
    return (isPropertyTrue(System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.disableEc2Metadata"))) || 
      (isPropertyTrue(System.getenv("AWS_EC2_METADATA_DISABLED")));
  }
  
  private static boolean isPropertyEnabled(String property)
  {
    if ((property == null) || (property.equalsIgnoreCase("false"))) {
      return false;
    }
    return true;
  }
  
  private static boolean isPropertyTrue(String property)
  {
    if ((property != null) && (property.equalsIgnoreCase("true"))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SDKGlobalConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */