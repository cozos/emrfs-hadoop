package com.amazon.ws.emr.hadoop.fs.guice;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStore;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBEntityStore;
import com.amazon.ws.emr.hadoop.fs.identity.FileSystemOwner;
import com.amazon.ws.emr.hadoop.fs.notification.CloudWatchNotifier;
import com.amazon.ws.emr.hadoop.fs.notification.Notifier;
import com.amazon.ws.emr.hadoop.fs.notification.SQSNotifier;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3EncryptionLite;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3LiteClientFactory;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3LiteClients;
import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3Configuration;
import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3Configuration.Builder;
import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3EncryptionConfiguration;
import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3EncryptionConfiguration.Builder;
import com.amazon.ws.emr.hadoop.fs.s3.lite.executor.S3CallOverrider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provides;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.name.Named;
import com.amazon.ws.emr.hadoop.fs.util.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.hadoop.conf.Configuration;

public class EmrFSProdModule
  extends EmrFSBaseModule
{
  public static final String NON_ENCRYPT_S3_NAME = "NonEncryptS3";
  private final ClientConfigurationFactory clientConfigurationFactory;
  private final AmazonS3LiteClientFactory clientFactory = AmazonS3LiteClients.defaultFactory();
  private final AWSCredentialsProviderFactory credsProviderFactory;
  
  public EmrFSProdModule(URI uri, Configuration configuration)
  {
    super(uri, configuration);
    credsProviderFactory = new DefaultAWSCredentialsProviderFactory();
    
    clientConfigurationFactory = new ClientConfigurationFactory(provideFileSystemOwner(), configuration, null);
  }
  
  protected void configure()
  {
    super.configure();
  }
  
  protected AWSCredentialsProvider getAwsCredentialsProvider(String service)
  {
    return credsProviderFactory.getAwsCredentialsProvider(service, uri, configuration);
  }
  
  protected AWSCredentialsProvider getAwsCredentialsProvider()
  {
    return credsProviderFactory.getAwsCredentialsProvider("s3", uri, configuration);
  }
  
  private AmazonS3Lite createAmazonS3LiteClient(FileSystemOwner fileSystemOwner)
  {
    AWSCredentialsProvider credentialsProvider = getAwsCredentialsProvider("s3");
    return clientFactory.newClient(
      createS3Configuration(credentialsProvider), 
      createS3ConfigurationInitialTimeoutOnlyIfSet(credentialsProvider), 
      EmrFsUtils.getS3Endpoint(configuration), 
      getS3CallOverriders(fileSystemOwner));
  }
  
  private S3Configuration createS3Configuration(AWSCredentialsProvider credentialsProvider)
  {
    return 
    
      (S3Configuration)((S3Configuration.Builder)((S3Configuration.Builder)S3Configuration.builder().awsCredentialsProvider(credentialsProvider)).clientConfiguration(clientConfigurationFactory.getClientConfiguration("s3", null))).build();
  }
  
  private S3Configuration createS3ConfigurationInitialTimeoutOnlyIfSet(AWSCredentialsProvider credentialsProvider)
  {
    ClientConfiguration clientConfiguration = clientConfigurationFactory.getClientConfigurationInitialTimeoutOnlyIfSet("s3", null);
    if (clientConfiguration == null) {
      return null;
    }
    return 
    
      (S3Configuration)((S3Configuration.Builder)((S3Configuration.Builder)S3Configuration.builder().awsCredentialsProvider(credentialsProvider)).clientConfiguration(clientConfiguration)).build();
  }
  
  private AmazonS3EncryptionLite createAmazonS3EncryptionLiteClient(FileSystemOwner fileSystemOwner)
  {
    AWSCredentialsProvider credentialsProvider = getAwsCredentialsProvider("s3");
    EncryptionMaterialsProvider encryptionMaterialsProvider = getEncryptionMaterialsProvider();
    return clientFactory.newEncryptionClient(
      createS3EncryptionConfiguration(credentialsProvider, encryptionMaterialsProvider), 
      createS3EncryptionConfigurationInitialTimeoutOnlyIfSet(credentialsProvider, encryptionMaterialsProvider), 
      
      EmrFsUtils.getS3Endpoint(configuration), 
      getS3CallOverriders(fileSystemOwner));
  }
  
  private S3EncryptionConfiguration createS3EncryptionConfiguration(AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider)
  {
    return 
    
      (S3EncryptionConfiguration)((S3EncryptionConfiguration.Builder)((S3EncryptionConfiguration.Builder)S3EncryptionConfiguration.builder().awsCredentialsProvider(credentialsProvider)).encryptionMaterialsProvider(encryptionMaterialsProvider).clientConfiguration(clientConfigurationFactory.getClientConfiguration("s3"))).cryptoConfiguration(getCryptoConfiguration()).build();
  }
  
  private S3EncryptionConfiguration createS3EncryptionConfigurationInitialTimeoutOnlyIfSet(AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider)
  {
    ClientConfiguration clientConfiguration = clientConfigurationFactory.getClientConfigurationInitialTimeoutOnlyIfSet("s3", null);
    if (clientConfiguration == null) {
      return null;
    }
    return 
    
      (S3EncryptionConfiguration)((S3EncryptionConfiguration.Builder)((S3EncryptionConfiguration.Builder)S3EncryptionConfiguration.builder().awsCredentialsProvider(credentialsProvider)).encryptionMaterialsProvider(encryptionMaterialsProvider).clientConfiguration(clientConfiguration)).cryptoConfiguration(getCryptoConfiguration()).build();
  }
  
  private EncryptionMaterialsProvider getEncryptionMaterialsProvider()
  {
    return ConfigurationUtils.getEncryptionMaterialsProvider(configuration);
  }
  
  private CryptoConfiguration getCryptoConfiguration()
  {
    return ConfigurationUtils.getCryptoConfiguration(configuration);
  }
  
  protected AmazonS3Lite createAmazonS3Lite(FileSystemOwner fileSystemOwner)
  {
    if (ConfigurationUtils.isClientSideEncryptionEnabled(configuration)) {
      return createAmazonS3EncryptionLiteClient(fileSystemOwner);
    }
    return createAmazonS3LiteClient(fileSystemOwner);
  }
  
  @Provides
  @Named("NonEncryptS3")
  public AmazonS3Lite createNonEncryptS3(FileSystemOwner fileSystemOwner)
  {
    return createAmazonS3LiteClient(fileSystemOwner);
  }
  
  private RetryPolicy getDynamoDBRetryPolicy(Configuration configuration)
  {
    return new RetryPolicy(new DynamoDBRetryCondition(
      createAmazonDynamoDB(null), configuration
      .get("fs.s3.consistent.metadata.tableName", "EmrManifest"), 10, configuration
      
      .getBoolean("fs.s3.consistent.metadata.capacity.autoIncrease", false), 
      ConfigurationUtils.getEtagVerificationEnabled(configuration), configuration
      .getLong("fs.s3.consistent.metadata.capacity.autoIncrease.maxRead", -1L), configuration
      .getLong("fs.s3.consistent.metadata.capacity.autoIncrease.maxWrite", -1L), configuration
      .getDouble("fs.s3.consistent.metadata.capacity.autoIncrease.factor", 0.2D)), PredefinedRetryPolicies.DYNAMODB_DEFAULT_BACKOFF_STRATEGY, Integer.MAX_VALUE, false);
  }
  
  private AmazonDynamoDB createAmazonDynamoDB(ClientConfiguration clientConfiguration)
  {
    String serviceAbbreviation = "dynamodb";
    if (clientConfiguration == null) {
      clientConfiguration = new ClientConfiguration();
    }
    AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(getAwsCredentialsProvider(serviceAbbreviation), clientConfiguration);
    
    amazonDynamoDB.setEndpoint(EmrFsUtils.getEndpoint(serviceAbbreviation, configuration));
    return amazonDynamoDB;
  }
  
  protected AmazonDynamoDB createAmazonDynamoDB()
  {
    return createAmazonDynamoDB(clientConfigurationFactory.getClientConfiguration("dynamodb", 
    
      getDynamoDBRetryPolicy(configuration)));
  }
  
  protected EntityStore<Entity> createEntityStore(AmazonDynamoDB dynamoDB)
  {
    long readCapacity = configuration.getLong("fs.s3.consistent.metadata.read.capacity", -1L);
    long writeCapacity = configuration.getLong("fs.s3.consistent.metadata.write.capacity", -1L);
    long readCapacityLimit = configuration.getLong("fs.s3.consistent.metadata.read.capacity.limit", readCapacity);
    long writeCapacityLimit = configuration.getLong("fs.s3.consistent.metadata.write.capacity.limit", writeCapacity);
    boolean prefetching = configuration.getBoolean("fs.s3.consistent.fastList.prefetchMetadata", false);
    boolean autoCreate = configuration.getBoolean("fs.s3.consistent.metadata.autoCreate", true);
    String tableName = configuration.get("fs.s3.consistent.metadata.tableName", "EmrFSMetadata");
    boolean conditional = configuration.getBoolean("fs.s3.consistent.metadata.conditional", true);
    boolean etagVerification = ConfigurationUtils.getEtagVerificationEnabled(configuration);
    
    NativeDynamoDBEntityStore nativeDynamoDBEntityStore = new NativeDynamoDBEntityStore(dynamoDB, readCapacityLimit, writeCapacityLimit).withAutoCreateTable(autoCreate).withTableName(tableName).withConditionalUpdate(conditional).withPrefetching(prefetching).withEtagVerification(etagVerification);
    if (readCapacity > 0L) {
      nativeDynamoDBEntityStore.setReadCapacityUnits(Long.valueOf(readCapacity));
    }
    if (writeCapacity > 0L) {
      nativeDynamoDBEntityStore.setWriteCapacityUnits(Long.valueOf(writeCapacity));
    }
    nativeDynamoDBEntityStore.initialize();
    return nativeDynamoDBEntityStore;
  }
  
  private AmazonCloudWatch createAmazonCloudWatch()
  {
    String serviceAbbreviation = "monitoring";
    AmazonCloudWatch amazonCloudWatch = new AmazonCloudWatchClient(getAwsCredentialsProvider(serviceAbbreviation), new ClientConfiguration());
    
    amazonCloudWatch.setEndpoint(EmrFsUtils.getEndpoint(serviceAbbreviation, configuration));
    return amazonCloudWatch;
  }
  
  private AmazonSQS createAmazonSQS()
  {
    String serviceAbbreviation = "sqs";
    AmazonSQS amazonSQS = new AmazonSQSClient(getAwsCredentialsProvider(serviceAbbreviation));
    amazonSQS.setEndpoint(EmrFsUtils.getEndpoint(serviceAbbreviation, configuration));
    return amazonSQS;
  }
  
  protected List<Notifier> getNotifiers()
  {
    List<Notifier> notifiers = new ArrayList();
    String jobFlowId = EmrFsUtils.getJobFlowId();
    if (configuration.getBoolean("fs.s3.consistent.notification.CloudWatch", false)) {
      notifiers.add(new CloudWatchNotifier(createAmazonCloudWatch(), jobFlowId));
    }
    if (configuration.getBoolean("fs.s3.consistent.notification.SQS", false))
    {
      String queueName = configuration.get("fs.s3.consistent.notification.SQS.queueName", SQSNotifier.getDefaultQueueName(jobFlowId));
      notifiers.add(new SQSNotifier(createAmazonSQS(), configuration, queueName));
    }
    return notifiers;
  }
  
  private List<S3CallOverrider> getS3CallOverriders(FileSystemOwner fileSystemOwner)
  {
    return S3CallOverridesGetter.getS3CallOverriders(configuration, fileSystemOwner);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.guice.EmrFSProdModule
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */