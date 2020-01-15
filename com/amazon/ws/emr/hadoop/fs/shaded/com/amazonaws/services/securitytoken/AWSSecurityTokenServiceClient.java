package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AdvancedConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerChainFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.StaxResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AWSSecurityTokenServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetCallerIdentityResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithSAMLRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithSAMLResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithWebIdentityRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithWebIdentityResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.DecodeAuthorizationMessageRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.DecodeAuthorizationMessageResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.ExpiredTokenExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetAccessKeyInfoRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetAccessKeyInfoResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetCallerIdentityRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetCallerIdentityResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetFederationTokenRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetFederationTokenResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetSessionTokenRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetSessionTokenResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.IDPCommunicationErrorExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.IDPRejectedClaimExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.InvalidAuthorizationMessageExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.InvalidIdentityTokenExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.MalformedPolicyDocumentExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.PackedPolicyTooLargeExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.RegionDisabledExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CredentialUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.w3c.dom.Node;

@ThreadSafe
public class AWSSecurityTokenServiceClient
  extends AmazonWebServiceClient
  implements AWSSecurityTokenService
{
  private final AWSCredentialsProvider awsCredentialsProvider;
  private static final Log log = LogFactory.getLog(AWSSecurityTokenService.class);
  private static final String DEFAULT_SIGNING_NAME = "sts";
  protected static final ClientConfigurationFactory configFactory = new ClientConfigurationFactory();
  private final AdvancedConfig advancedConfig;
  protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers = new ArrayList();
  private static final Set<String> LEGACY_ENABLED_REGIONS;
  
  static
  {
    Set<String> legacyEnabledRegions = new HashSet();
    legacyEnabledRegions.add("ap-northeast-1");
    legacyEnabledRegions.add("ap-south-1");
    legacyEnabledRegions.add("ap-southeast-1");
    legacyEnabledRegions.add("ap-southeast-2");
    legacyEnabledRegions.add("aws-global");
    legacyEnabledRegions.add("ca-central-1");
    legacyEnabledRegions.add("eu-central-1");
    legacyEnabledRegions.add("eu-north-1");
    legacyEnabledRegions.add("eu-west-1");
    legacyEnabledRegions.add("eu-west-2");
    legacyEnabledRegions.add("eu-west-3");
    legacyEnabledRegions.add("sa-east-1");
    legacyEnabledRegions.add("us-east-1");
    legacyEnabledRegions.add("us-east-2");
    legacyEnabledRegions.add("us-west-1");
    legacyEnabledRegions.add("us-west-2");
    LEGACY_ENABLED_REGIONS = Collections.unmodifiableSet(legacyEnabledRegions);
  }
  
  private static RegionalEndpointsOptionResolver REGIONAL_ENDPOINTS_OPTION_RESOLVER = new RegionalEndpointsOptionResolver();
  
  @Deprecated
  public AWSSecurityTokenServiceClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), configFactory.getConfig());
  }
  
  @Deprecated
  public AWSSecurityTokenServiceClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration);
  }
  
  @Deprecated
  public AWSSecurityTokenServiceClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, configFactory.getConfig());
  }
  
  @Deprecated
  public AWSSecurityTokenServiceClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration)
  {
    super(clientConfiguration);
    awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  @Deprecated
  public AWSSecurityTokenServiceClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, configFactory.getConfig());
  }
  
  @Deprecated
  public AWSSecurityTokenServiceClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, null);
  }
  
  @Deprecated
  public AWSSecurityTokenServiceClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector)
  {
    super(clientConfiguration, requestMetricCollector);
    this.awsCredentialsProvider = awsCredentialsProvider;
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  public static AWSSecurityTokenServiceClientBuilder builder()
  {
    return AWSSecurityTokenServiceClientBuilder.standard();
  }
  
  AWSSecurityTokenServiceClient(AwsSyncClientParams clientParams)
  {
    this(clientParams, false);
  }
  
  AWSSecurityTokenServiceClient(AwsSyncClientParams clientParams, boolean endpointDiscoveryEnabled)
  {
    super(clientParams);
    awsCredentialsProvider = clientParams.getCredentialsProvider();
    advancedConfig = clientParams.getAdvancedConfig();
    init();
  }
  
  private void init()
  {
    exceptionUnmarshallers.add(new InvalidAuthorizationMessageExceptionUnmarshaller());
    exceptionUnmarshallers.add(new ExpiredTokenExceptionUnmarshaller());
    exceptionUnmarshallers.add(new PackedPolicyTooLargeExceptionUnmarshaller());
    exceptionUnmarshallers.add(new RegionDisabledExceptionUnmarshaller());
    exceptionUnmarshallers.add(new MalformedPolicyDocumentExceptionUnmarshaller());
    exceptionUnmarshallers.add(new IDPCommunicationErrorExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidIdentityTokenExceptionUnmarshaller());
    exceptionUnmarshallers.add(new IDPRejectedClaimExceptionUnmarshaller());
    exceptionUnmarshallers.add(new StandardErrorUnmarshaller(AWSSecurityTokenServiceException.class));
    
    setServiceNameIntern("sts");
    setEndpointPrefix("sts");
    
    setEndpoint("sts.amazonaws.com");
    HandlerChainFactory chainFactory = new HandlerChainFactory();
    requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/securitytoken/request.handlers"));
    requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/securitytoken/request.handler2s"));
    requestHandler2s.addAll(chainFactory.getGlobalHandlers());
  }
  
  public AssumeRoleResult assumeRole(AssumeRoleRequest request)
  {
    request = (AssumeRoleRequest)beforeClientExecution(request);
    return executeAssumeRole(request);
  }
  
  @SdkInternalApi
  final AssumeRoleResult executeAssumeRole(AssumeRoleRequest assumeRoleRequest)
  {
    ExecutionContext executionContext = createExecutionContext(assumeRoleRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AssumeRoleRequest> request = null;
    Response<AssumeRoleResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AssumeRoleRequestMarshaller().marshall((AssumeRoleRequest)super.beforeMarshalling(assumeRoleRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "STS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssumeRole");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new AssumeRoleResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AssumeRoleResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public AssumeRoleWithSAMLResult assumeRoleWithSAML(AssumeRoleWithSAMLRequest request)
  {
    request = (AssumeRoleWithSAMLRequest)beforeClientExecution(request);
    return executeAssumeRoleWithSAML(request);
  }
  
  @SdkInternalApi
  final AssumeRoleWithSAMLResult executeAssumeRoleWithSAML(AssumeRoleWithSAMLRequest assumeRoleWithSAMLRequest)
  {
    ExecutionContext executionContext = createExecutionContext(assumeRoleWithSAMLRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AssumeRoleWithSAMLRequest> request = null;
    Response<AssumeRoleWithSAMLResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AssumeRoleWithSAMLRequestMarshaller().marshall((AssumeRoleWithSAMLRequest)super.beforeMarshalling(assumeRoleWithSAMLRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "STS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssumeRoleWithSAML");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new AssumeRoleWithSAMLResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AssumeRoleWithSAMLResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public AssumeRoleWithWebIdentityResult assumeRoleWithWebIdentity(AssumeRoleWithWebIdentityRequest request)
  {
    request = (AssumeRoleWithWebIdentityRequest)beforeClientExecution(request);
    return executeAssumeRoleWithWebIdentity(request);
  }
  
  @SdkInternalApi
  final AssumeRoleWithWebIdentityResult executeAssumeRoleWithWebIdentity(AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequest)
  {
    ExecutionContext executionContext = createExecutionContext(assumeRoleWithWebIdentityRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AssumeRoleWithWebIdentityRequest> request = null;
    Response<AssumeRoleWithWebIdentityResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AssumeRoleWithWebIdentityRequestMarshaller().marshall((AssumeRoleWithWebIdentityRequest)super.beforeMarshalling(assumeRoleWithWebIdentityRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "STS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AssumeRoleWithWebIdentity");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new AssumeRoleWithWebIdentityResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AssumeRoleWithWebIdentityResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DecodeAuthorizationMessageResult decodeAuthorizationMessage(DecodeAuthorizationMessageRequest request)
  {
    request = (DecodeAuthorizationMessageRequest)beforeClientExecution(request);
    return executeDecodeAuthorizationMessage(request);
  }
  
  @SdkInternalApi
  final DecodeAuthorizationMessageResult executeDecodeAuthorizationMessage(DecodeAuthorizationMessageRequest decodeAuthorizationMessageRequest)
  {
    ExecutionContext executionContext = createExecutionContext(decodeAuthorizationMessageRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DecodeAuthorizationMessageRequest> request = null;
    Response<DecodeAuthorizationMessageResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DecodeAuthorizationMessageRequestMarshaller().marshall((DecodeAuthorizationMessageRequest)super.beforeMarshalling(decodeAuthorizationMessageRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "STS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DecodeAuthorizationMessage");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DecodeAuthorizationMessageResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DecodeAuthorizationMessageResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetAccessKeyInfoResult getAccessKeyInfo(GetAccessKeyInfoRequest request)
  {
    request = (GetAccessKeyInfoRequest)beforeClientExecution(request);
    return executeGetAccessKeyInfo(request);
  }
  
  @SdkInternalApi
  final GetAccessKeyInfoResult executeGetAccessKeyInfo(GetAccessKeyInfoRequest getAccessKeyInfoRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getAccessKeyInfoRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetAccessKeyInfoRequest> request = null;
    Response<GetAccessKeyInfoResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetAccessKeyInfoRequestMarshaller().marshall((GetAccessKeyInfoRequest)super.beforeMarshalling(getAccessKeyInfoRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "STS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetAccessKeyInfo");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetAccessKeyInfoResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetAccessKeyInfoResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetCallerIdentityResult getCallerIdentity(GetCallerIdentityRequest request)
  {
    request = (GetCallerIdentityRequest)beforeClientExecution(request);
    return executeGetCallerIdentity(request);
  }
  
  @SdkInternalApi
  final GetCallerIdentityResult executeGetCallerIdentity(GetCallerIdentityRequest getCallerIdentityRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getCallerIdentityRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetCallerIdentityRequest> request = null;
    Response<GetCallerIdentityResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetCallerIdentityRequestMarshaller().marshall((GetCallerIdentityRequest)super.beforeMarshalling(getCallerIdentityRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "STS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetCallerIdentity");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetCallerIdentityResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetCallerIdentityResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetFederationTokenResult getFederationToken(GetFederationTokenRequest request)
  {
    request = (GetFederationTokenRequest)beforeClientExecution(request);
    return executeGetFederationToken(request);
  }
  
  @SdkInternalApi
  final GetFederationTokenResult executeGetFederationToken(GetFederationTokenRequest getFederationTokenRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getFederationTokenRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetFederationTokenRequest> request = null;
    Response<GetFederationTokenResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetFederationTokenRequestMarshaller().marshall((GetFederationTokenRequest)super.beforeMarshalling(getFederationTokenRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "STS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetFederationToken");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetFederationTokenResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetFederationTokenResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetSessionTokenResult getSessionToken(GetSessionTokenRequest request)
  {
    request = (GetSessionTokenRequest)beforeClientExecution(request);
    return executeGetSessionToken(request);
  }
  
  @SdkInternalApi
  final GetSessionTokenResult executeGetSessionToken(GetSessionTokenRequest getSessionTokenRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getSessionTokenRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetSessionTokenRequest> request = null;
    Response<GetSessionTokenResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetSessionTokenRequestMarshaller().marshall((GetSessionTokenRequest)super.beforeMarshalling(getSessionTokenRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "STS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetSessionToken");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetSessionTokenResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetSessionTokenResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetSessionTokenResult getSessionToken()
  {
    return getSessionToken(new GetSessionTokenRequest());
  }
  
  @Deprecated
  public void setRegion(Region region)
  {
    Region mappedRegion = mapToLegacyRegionIfNecessary(region);
    super.setRegion(mappedRegion);
  }
  
  private Region mapToLegacyRegionIfNecessary(Region region)
  {
    if ((legacyRegionModeEnabled()) && (LEGACY_ENABLED_REGIONS.contains(region.getName()))) {
      return RegionUtils.getRegion("aws-global");
    }
    return region;
  }
  
  private boolean legacyRegionModeEnabled()
  {
    return REGIONAL_ENDPOINTS_OPTION_RESOLVER.useLegacyMode();
  }
  
  @SdkTestInternalApi
  static void setRegionalEndpointsOptionResolver(RegionalEndpointsOptionResolver resolver)
  {
    REGIONAL_ENDPOINTS_OPTION_RESOLVER = resolver;
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    return client.getResponseMetadataForRequest(request);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext)
  {
    return invoke(request, responseHandler, executionContext, null, null);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext, URI cachedEndpoint, URI uriFromEndpointTrait)
  {
    executionContext.setCredentialsProvider(CredentialUtils.getCredentialsProvider(request.getOriginalRequest(), awsCredentialsProvider));
    
    return doInvoke(request, responseHandler, executionContext, cachedEndpoint, uriFromEndpointTrait);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> anonymousInvoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext)
  {
    return doInvoke(request, responseHandler, executionContext, null, null);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> doInvoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext, URI discoveredEndpoint, URI uriFromEndpointTrait)
  {
    if (discoveredEndpoint != null)
    {
      request.setEndpoint(discoveredEndpoint);
      request.getOriginalRequest().getRequestClientOptions().appendUserAgent("endpoint-discovery");
    }
    else if (uriFromEndpointTrait != null)
    {
      request.setEndpoint(uriFromEndpointTrait);
    }
    else
    {
      request.setEndpoint(endpoint);
    }
    request.setTimeOffset(timeOffset);
    
    DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);
    
    return client.execute(request, responseHandler, errorResponseHandler, executionContext);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */