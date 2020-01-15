package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AdvancedConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerChainFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.AwsSdkMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonClientMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonErrorResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonErrorShapeMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonOperationMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkJsonProtocolFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.endpointdiscovery.AmazonDynamoDBEndpointCache;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.metrics.DynamoDBRequestMetric;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateBackupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateGlobalTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateGlobalTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteBackupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeBackupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeEndpointsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListBackupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListBackupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListGlobalTablesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItemsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItemsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UntagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UntagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BackupInUseExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BackupNotFoundExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ConditionalCheckFailedExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ContinuousBackupsUnavailableExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CreateBackupRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CreateBackupResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CreateGlobalTableRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CreateGlobalTableResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CreateTableRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CreateTableResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DeleteBackupRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DeleteBackupResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DeleteItemRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DeleteItemResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DeleteTableRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DeleteTableResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeBackupRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeBackupResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeContinuousBackupsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeContinuousBackupsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeEndpointsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeEndpointsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableSettingsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableSettingsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeTableRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeTableResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeTimeToLiveRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeTimeToLiveResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GetItemRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GetItemResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalTableAlreadyExistsExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalTableNotFoundExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.IdempotentParameterMismatchExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.IndexNotFoundExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.InternalServerErrorExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.InvalidRestoreTimeExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ItemCollectionSizeLimitExceededExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListBackupsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListBackupsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListGlobalTablesRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListGlobalTablesResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListTablesRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListTablesResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListTagsOfResourceRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListTagsOfResourceResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PointInTimeRecoveryUnavailableExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ProvisionedThroughputExceededExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PutItemRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PutItemResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.QueryRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.QueryResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaAlreadyExistsExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaNotFoundExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RequestLimitExceededExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ResourceInUseExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RestoreTableFromBackupRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RestoreTableFromBackupResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RestoreTableToPointInTimeRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RestoreTableToPointInTimeResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ScanRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ScanResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TableAlreadyExistsExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TableInUseExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TableNotFoundExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TagResourceRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TagResourceResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactGetItemsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactGetItemsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactWriteItemsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactWriteItemsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactionCanceledExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactionConflictExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactionInProgressExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UntagResourceRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UntagResourceResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateContinuousBackupsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateContinuousBackupsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableSettingsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableSettingsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateItemRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateItemResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateTableRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateTableResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateTimeToLiveRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateTimeToLiveResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.waiters.AmazonDynamoDBWaiters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CredentialUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ThreadSafe
public class AmazonDynamoDBClient
  extends AmazonWebServiceClient
  implements AmazonDynamoDB
{
  protected AmazonDynamoDBEndpointCache cache;
  private final boolean endpointDiscoveryEnabled;
  private final AWSCredentialsProvider awsCredentialsProvider;
  
  static
  {
    AwsSdkMetrics.addAll(Arrays.asList(DynamoDBRequestMetric.values()));
  }
  
  private static final Log log = LogFactory.getLog(AmazonDynamoDB.class);
  private static final String DEFAULT_SIGNING_NAME = "dynamodb";
  private volatile AmazonDynamoDBWaiters waiters;
  protected static final AmazonDynamoDBClientConfigurationFactory configFactory = new AmazonDynamoDBClientConfigurationFactory();
  private final AdvancedConfig advancedConfig;
  private static final SdkJsonProtocolFactory protocolFactory = new SdkJsonProtocolFactory(new JsonClientMetadata()
  
    .withProtocolVersion("1.0")
    .withSupportsCbor(false)
    .withSupportsIon(false)
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("RequestLimitExceeded").withExceptionUnmarshaller(
    RequestLimitExceededExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("GlobalTableAlreadyExistsException").withExceptionUnmarshaller(
    GlobalTableAlreadyExistsExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("ConditionalCheckFailedException").withExceptionUnmarshaller(
    ConditionalCheckFailedExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("LimitExceededException").withExceptionUnmarshaller(
    LimitExceededExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("GlobalTableNotFoundException").withExceptionUnmarshaller(
    GlobalTableNotFoundExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("ItemCollectionSizeLimitExceededException").withExceptionUnmarshaller(
    ItemCollectionSizeLimitExceededExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("ReplicaNotFoundException").withExceptionUnmarshaller(
    ReplicaNotFoundExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("BackupInUseException").withExceptionUnmarshaller(
    BackupInUseExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("ResourceNotFoundException").withExceptionUnmarshaller(
    ResourceNotFoundExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("ContinuousBackupsUnavailableException").withExceptionUnmarshaller(
    ContinuousBackupsUnavailableExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("IdempotentParameterMismatchException").withExceptionUnmarshaller(
    IdempotentParameterMismatchExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("TransactionInProgressException").withExceptionUnmarshaller(
    TransactionInProgressExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("TableInUseException").withExceptionUnmarshaller(
    TableInUseExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("ProvisionedThroughputExceededException").withExceptionUnmarshaller(
    ProvisionedThroughputExceededExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("PointInTimeRecoveryUnavailableException").withExceptionUnmarshaller(
    PointInTimeRecoveryUnavailableExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("ResourceInUseException").withExceptionUnmarshaller(
    ResourceInUseExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("TableAlreadyExistsException").withExceptionUnmarshaller(
    TableAlreadyExistsExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("TransactionConflictException").withExceptionUnmarshaller(
    TransactionConflictExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InvalidRestoreTimeException").withExceptionUnmarshaller(
    InvalidRestoreTimeExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("ReplicaAlreadyExistsException").withExceptionUnmarshaller(
    ReplicaAlreadyExistsExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("BackupNotFoundException").withExceptionUnmarshaller(
    BackupNotFoundExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("IndexNotFoundException").withExceptionUnmarshaller(
    IndexNotFoundExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("TableNotFoundException").withExceptionUnmarshaller(
    TableNotFoundExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("TransactionCanceledException").withExceptionUnmarshaller(
    TransactionCanceledExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InternalServerError").withExceptionUnmarshaller(
    InternalServerErrorExceptionUnmarshaller.getInstance()))
    .withBaseServiceExceptionClass(AmazonDynamoDBException.class));
  
  @Deprecated
  public AmazonDynamoDBClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonDynamoDBClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration);
  }
  
  @Deprecated
  public AmazonDynamoDBClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonDynamoDBClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration)
  {
    super(clientConfiguration);
    endpointDiscoveryEnabled = false;
    awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  @Deprecated
  public AmazonDynamoDBClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonDynamoDBClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, null);
  }
  
  @Deprecated
  public AmazonDynamoDBClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector)
  {
    super(clientConfiguration, requestMetricCollector);
    this.awsCredentialsProvider = awsCredentialsProvider;
    endpointDiscoveryEnabled = false;
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  public static AmazonDynamoDBClientBuilder builder()
  {
    return AmazonDynamoDBClientBuilder.standard();
  }
  
  AmazonDynamoDBClient(AwsSyncClientParams clientParams)
  {
    this(clientParams, false);
  }
  
  AmazonDynamoDBClient(AwsSyncClientParams clientParams, boolean endpointDiscoveryEnabled)
  {
    super(clientParams);
    awsCredentialsProvider = clientParams.getCredentialsProvider();
    this.endpointDiscoveryEnabled = endpointDiscoveryEnabled;
    advancedConfig = clientParams.getAdvancedConfig();
    init();
  }
  
  private void init()
  {
    if (endpointDiscoveryEnabled) {
      cache = new AmazonDynamoDBEndpointCache(this);
    }
    setServiceNameIntern("dynamodb");
    setEndpointPrefix("dynamodb");
    
    setEndpoint("https://dynamodb.us-east-1.amazonaws.com");
    HandlerChainFactory chainFactory = new HandlerChainFactory();
    requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/dynamodbv2/request.handlers"));
    requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/dynamodbv2/request.handler2s"));
    requestHandler2s.addAll(chainFactory.getGlobalHandlers());
  }
  
  public BatchGetItemResult batchGetItem(BatchGetItemRequest request)
  {
    request = (BatchGetItemRequest)beforeClientExecution(request);
    return executeBatchGetItem(request);
  }
  
  @SdkInternalApi
  final BatchGetItemResult executeBatchGetItem(BatchGetItemRequest batchGetItemRequest)
  {
    ExecutionContext executionContext = createExecutionContext(batchGetItemRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<BatchGetItemRequest> request = null;
    Response<BatchGetItemResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new BatchGetItemRequestProtocolMarshaller(protocolFactory).marshall((BatchGetItemRequest)super.beforeMarshalling(batchGetItemRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "BatchGetItem");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<BatchGetItemResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new BatchGetItemResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (BatchGetItemResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> requestItems, String returnConsumedCapacity)
  {
    return batchGetItem(new BatchGetItemRequest().withRequestItems(requestItems).withReturnConsumedCapacity(returnConsumedCapacity));
  }
  
  public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> requestItems)
  {
    return batchGetItem(new BatchGetItemRequest().withRequestItems(requestItems));
  }
  
  public BatchWriteItemResult batchWriteItem(BatchWriteItemRequest request)
  {
    request = (BatchWriteItemRequest)beforeClientExecution(request);
    return executeBatchWriteItem(request);
  }
  
  @SdkInternalApi
  final BatchWriteItemResult executeBatchWriteItem(BatchWriteItemRequest batchWriteItemRequest)
  {
    ExecutionContext executionContext = createExecutionContext(batchWriteItemRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<BatchWriteItemRequest> request = null;
    Response<BatchWriteItemResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new BatchWriteItemRequestProtocolMarshaller(protocolFactory).marshall((BatchWriteItemRequest)super.beforeMarshalling(batchWriteItemRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "BatchWriteItem");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<BatchWriteItemResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new BatchWriteItemResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (BatchWriteItemResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public BatchWriteItemResult batchWriteItem(Map<String, List<WriteRequest>> requestItems)
  {
    return batchWriteItem(new BatchWriteItemRequest().withRequestItems(requestItems));
  }
  
  public CreateBackupResult createBackup(CreateBackupRequest request)
  {
    request = (CreateBackupRequest)beforeClientExecution(request);
    return executeCreateBackup(request);
  }
  
  @SdkInternalApi
  final CreateBackupResult executeCreateBackup(CreateBackupRequest createBackupRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createBackupRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateBackupRequest> request = null;
    Response<CreateBackupResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateBackupRequestProtocolMarshaller(protocolFactory).marshall((CreateBackupRequest)super.beforeMarshalling(createBackupRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateBackup");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<CreateBackupResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateBackupResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (CreateBackupResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateGlobalTableResult createGlobalTable(CreateGlobalTableRequest request)
  {
    request = (CreateGlobalTableRequest)beforeClientExecution(request);
    return executeCreateGlobalTable(request);
  }
  
  @SdkInternalApi
  final CreateGlobalTableResult executeCreateGlobalTable(CreateGlobalTableRequest createGlobalTableRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createGlobalTableRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateGlobalTableRequest> request = null;
    Response<CreateGlobalTableResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateGlobalTableRequestProtocolMarshaller(protocolFactory).marshall((CreateGlobalTableRequest)super.beforeMarshalling(createGlobalTableRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateGlobalTable");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<CreateGlobalTableResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateGlobalTableResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (CreateGlobalTableResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateTableResult createTable(CreateTableRequest request)
  {
    request = (CreateTableRequest)beforeClientExecution(request);
    return executeCreateTable(request);
  }
  
  @SdkInternalApi
  final CreateTableResult executeCreateTable(CreateTableRequest createTableRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createTableRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateTableRequest> request = null;
    Response<CreateTableResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateTableRequestProtocolMarshaller(protocolFactory).marshall((CreateTableRequest)super.beforeMarshalling(createTableRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateTable");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<CreateTableResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateTableResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (CreateTableResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateTableResult createTable(List<AttributeDefinition> attributeDefinitions, String tableName, List<KeySchemaElement> keySchema, ProvisionedThroughput provisionedThroughput)
  {
    return createTable(new CreateTableRequest().withAttributeDefinitions(attributeDefinitions).withTableName(tableName).withKeySchema(keySchema)
      .withProvisionedThroughput(provisionedThroughput));
  }
  
  public DeleteBackupResult deleteBackup(DeleteBackupRequest request)
  {
    request = (DeleteBackupRequest)beforeClientExecution(request);
    return executeDeleteBackup(request);
  }
  
  @SdkInternalApi
  final DeleteBackupResult executeDeleteBackup(DeleteBackupRequest deleteBackupRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteBackupRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteBackupRequest> request = null;
    Response<DeleteBackupResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteBackupRequestProtocolMarshaller(protocolFactory).marshall((DeleteBackupRequest)super.beforeMarshalling(deleteBackupRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteBackup");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<DeleteBackupResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DeleteBackupResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (DeleteBackupResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteItemResult deleteItem(DeleteItemRequest request)
  {
    request = (DeleteItemRequest)beforeClientExecution(request);
    return executeDeleteItem(request);
  }
  
  @SdkInternalApi
  final DeleteItemResult executeDeleteItem(DeleteItemRequest deleteItemRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteItemRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteItemRequest> request = null;
    Response<DeleteItemResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteItemRequestProtocolMarshaller(protocolFactory).marshall((DeleteItemRequest)super.beforeMarshalling(deleteItemRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteItem");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<DeleteItemResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DeleteItemResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (DeleteItemResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteItemResult deleteItem(String tableName, Map<String, AttributeValue> key)
  {
    return deleteItem(new DeleteItemRequest().withTableName(tableName).withKey(key));
  }
  
  public DeleteItemResult deleteItem(String tableName, Map<String, AttributeValue> key, String returnValues)
  {
    return deleteItem(new DeleteItemRequest().withTableName(tableName).withKey(key).withReturnValues(returnValues));
  }
  
  public DeleteTableResult deleteTable(DeleteTableRequest request)
  {
    request = (DeleteTableRequest)beforeClientExecution(request);
    return executeDeleteTable(request);
  }
  
  @SdkInternalApi
  final DeleteTableResult executeDeleteTable(DeleteTableRequest deleteTableRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteTableRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteTableRequest> request = null;
    Response<DeleteTableResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteTableRequestProtocolMarshaller(protocolFactory).marshall((DeleteTableRequest)super.beforeMarshalling(deleteTableRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteTable");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<DeleteTableResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DeleteTableResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (DeleteTableResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteTableResult deleteTable(String tableName)
  {
    return deleteTable(new DeleteTableRequest().withTableName(tableName));
  }
  
  public DescribeBackupResult describeBackup(DescribeBackupRequest request)
  {
    request = (DescribeBackupRequest)beforeClientExecution(request);
    return executeDescribeBackup(request);
  }
  
  @SdkInternalApi
  final DescribeBackupResult executeDescribeBackup(DescribeBackupRequest describeBackupRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeBackupRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeBackupRequest> request = null;
    Response<DescribeBackupResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeBackupRequestProtocolMarshaller(protocolFactory).marshall((DescribeBackupRequest)super.beforeMarshalling(describeBackupRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeBackup");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<DescribeBackupResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeBackupResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (DescribeBackupResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeContinuousBackupsResult describeContinuousBackups(DescribeContinuousBackupsRequest request)
  {
    request = (DescribeContinuousBackupsRequest)beforeClientExecution(request);
    return executeDescribeContinuousBackups(request);
  }
  
  @SdkInternalApi
  final DescribeContinuousBackupsResult executeDescribeContinuousBackups(DescribeContinuousBackupsRequest describeContinuousBackupsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeContinuousBackupsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeContinuousBackupsRequest> request = null;
    Response<DescribeContinuousBackupsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeContinuousBackupsRequestProtocolMarshaller(protocolFactory).marshall(
          (DescribeContinuousBackupsRequest)super.beforeMarshalling(describeContinuousBackupsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeContinuousBackups");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<DescribeContinuousBackupsResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeContinuousBackupsResultJsonUnmarshaller());
      
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (DescribeContinuousBackupsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeEndpointsResult describeEndpoints(DescribeEndpointsRequest request)
  {
    request = (DescribeEndpointsRequest)beforeClientExecution(request);
    return executeDescribeEndpoints(request);
  }
  
  @SdkInternalApi
  final DescribeEndpointsResult executeDescribeEndpoints(DescribeEndpointsRequest describeEndpointsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeEndpointsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeEndpointsRequest> request = null;
    Response<DescribeEndpointsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeEndpointsRequestProtocolMarshaller(protocolFactory).marshall((DescribeEndpointsRequest)super.beforeMarshalling(describeEndpointsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeEndpoints");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeEndpointsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeEndpointsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeGlobalTableResult describeGlobalTable(DescribeGlobalTableRequest request)
  {
    request = (DescribeGlobalTableRequest)beforeClientExecution(request);
    return executeDescribeGlobalTable(request);
  }
  
  @SdkInternalApi
  final DescribeGlobalTableResult executeDescribeGlobalTable(DescribeGlobalTableRequest describeGlobalTableRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeGlobalTableRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeGlobalTableRequest> request = null;
    Response<DescribeGlobalTableResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeGlobalTableRequestProtocolMarshaller(protocolFactory).marshall((DescribeGlobalTableRequest)super.beforeMarshalling(describeGlobalTableRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeGlobalTable");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<DescribeGlobalTableResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeGlobalTableResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (DescribeGlobalTableResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeGlobalTableSettingsResult describeGlobalTableSettings(DescribeGlobalTableSettingsRequest request)
  {
    request = (DescribeGlobalTableSettingsRequest)beforeClientExecution(request);
    return executeDescribeGlobalTableSettings(request);
  }
  
  @SdkInternalApi
  final DescribeGlobalTableSettingsResult executeDescribeGlobalTableSettings(DescribeGlobalTableSettingsRequest describeGlobalTableSettingsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeGlobalTableSettingsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeGlobalTableSettingsRequest> request = null;
    Response<DescribeGlobalTableSettingsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeGlobalTableSettingsRequestProtocolMarshaller(protocolFactory).marshall(
          (DescribeGlobalTableSettingsRequest)super.beforeMarshalling(describeGlobalTableSettingsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeGlobalTableSettings");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<DescribeGlobalTableSettingsResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeGlobalTableSettingsResultJsonUnmarshaller());
      
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (DescribeGlobalTableSettingsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeLimitsResult describeLimits(DescribeLimitsRequest request)
  {
    request = (DescribeLimitsRequest)beforeClientExecution(request);
    return executeDescribeLimits(request);
  }
  
  @SdkInternalApi
  final DescribeLimitsResult executeDescribeLimits(DescribeLimitsRequest describeLimitsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeLimitsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeLimitsRequest> request = null;
    Response<DescribeLimitsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeLimitsRequestProtocolMarshaller(protocolFactory).marshall((DescribeLimitsRequest)super.beforeMarshalling(describeLimitsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeLimits");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<DescribeLimitsResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeLimitsResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (DescribeLimitsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeTableResult describeTable(DescribeTableRequest request)
  {
    request = (DescribeTableRequest)beforeClientExecution(request);
    return executeDescribeTable(request);
  }
  
  @SdkInternalApi
  final DescribeTableResult executeDescribeTable(DescribeTableRequest describeTableRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeTableRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeTableRequest> request = null;
    Response<DescribeTableResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeTableRequestProtocolMarshaller(protocolFactory).marshall((DescribeTableRequest)super.beforeMarshalling(describeTableRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeTable");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<DescribeTableResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeTableResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (DescribeTableResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeTableResult describeTable(String tableName)
  {
    return describeTable(new DescribeTableRequest().withTableName(tableName));
  }
  
  public DescribeTimeToLiveResult describeTimeToLive(DescribeTimeToLiveRequest request)
  {
    request = (DescribeTimeToLiveRequest)beforeClientExecution(request);
    return executeDescribeTimeToLive(request);
  }
  
  @SdkInternalApi
  final DescribeTimeToLiveResult executeDescribeTimeToLive(DescribeTimeToLiveRequest describeTimeToLiveRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeTimeToLiveRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeTimeToLiveRequest> request = null;
    Response<DescribeTimeToLiveResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeTimeToLiveRequestProtocolMarshaller(protocolFactory).marshall((DescribeTimeToLiveRequest)super.beforeMarshalling(describeTimeToLiveRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeTimeToLive");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<DescribeTimeToLiveResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeTimeToLiveResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (DescribeTimeToLiveResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetItemResult getItem(GetItemRequest request)
  {
    request = (GetItemRequest)beforeClientExecution(request);
    return executeGetItem(request);
  }
  
  @SdkInternalApi
  final GetItemResult executeGetItem(GetItemRequest getItemRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getItemRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetItemRequest> request = null;
    Response<GetItemResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetItemRequestProtocolMarshaller(protocolFactory).marshall((GetItemRequest)super.beforeMarshalling(getItemRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetItem");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<GetItemResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetItemResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (GetItemResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetItemResult getItem(String tableName, Map<String, AttributeValue> key)
  {
    return getItem(new GetItemRequest().withTableName(tableName).withKey(key));
  }
  
  public GetItemResult getItem(String tableName, Map<String, AttributeValue> key, Boolean consistentRead)
  {
    return getItem(new GetItemRequest().withTableName(tableName).withKey(key).withConsistentRead(consistentRead));
  }
  
  public ListBackupsResult listBackups(ListBackupsRequest request)
  {
    request = (ListBackupsRequest)beforeClientExecution(request);
    return executeListBackups(request);
  }
  
  @SdkInternalApi
  final ListBackupsResult executeListBackups(ListBackupsRequest listBackupsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listBackupsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListBackupsRequest> request = null;
    Response<ListBackupsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListBackupsRequestProtocolMarshaller(protocolFactory).marshall((ListBackupsRequest)super.beforeMarshalling(listBackupsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListBackups");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<ListBackupsResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListBackupsResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (ListBackupsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListGlobalTablesResult listGlobalTables(ListGlobalTablesRequest request)
  {
    request = (ListGlobalTablesRequest)beforeClientExecution(request);
    return executeListGlobalTables(request);
  }
  
  @SdkInternalApi
  final ListGlobalTablesResult executeListGlobalTables(ListGlobalTablesRequest listGlobalTablesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listGlobalTablesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListGlobalTablesRequest> request = null;
    Response<ListGlobalTablesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListGlobalTablesRequestProtocolMarshaller(protocolFactory).marshall((ListGlobalTablesRequest)super.beforeMarshalling(listGlobalTablesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListGlobalTables");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<ListGlobalTablesResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListGlobalTablesResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (ListGlobalTablesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListTablesResult listTables(ListTablesRequest request)
  {
    request = (ListTablesRequest)beforeClientExecution(request);
    return executeListTables(request);
  }
  
  @SdkInternalApi
  final ListTablesResult executeListTables(ListTablesRequest listTablesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listTablesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListTablesRequest> request = null;
    Response<ListTablesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListTablesRequestProtocolMarshaller(protocolFactory).marshall((ListTablesRequest)super.beforeMarshalling(listTablesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListTables");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<ListTablesResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListTablesResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (ListTablesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListTablesResult listTables()
  {
    return listTables(new ListTablesRequest());
  }
  
  public ListTablesResult listTables(String exclusiveStartTableName)
  {
    return listTables(new ListTablesRequest().withExclusiveStartTableName(exclusiveStartTableName));
  }
  
  public ListTablesResult listTables(String exclusiveStartTableName, Integer limit)
  {
    return listTables(new ListTablesRequest().withExclusiveStartTableName(exclusiveStartTableName).withLimit(limit));
  }
  
  public ListTablesResult listTables(Integer limit)
  {
    return listTables(new ListTablesRequest().withLimit(limit));
  }
  
  public ListTagsOfResourceResult listTagsOfResource(ListTagsOfResourceRequest request)
  {
    request = (ListTagsOfResourceRequest)beforeClientExecution(request);
    return executeListTagsOfResource(request);
  }
  
  @SdkInternalApi
  final ListTagsOfResourceResult executeListTagsOfResource(ListTagsOfResourceRequest listTagsOfResourceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listTagsOfResourceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListTagsOfResourceRequest> request = null;
    Response<ListTagsOfResourceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListTagsOfResourceRequestProtocolMarshaller(protocolFactory).marshall((ListTagsOfResourceRequest)super.beforeMarshalling(listTagsOfResourceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListTagsOfResource");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<ListTagsOfResourceResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListTagsOfResourceResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (ListTagsOfResourceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutItemResult putItem(PutItemRequest request)
  {
    request = (PutItemRequest)beforeClientExecution(request);
    return executePutItem(request);
  }
  
  @SdkInternalApi
  final PutItemResult executePutItem(PutItemRequest putItemRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putItemRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutItemRequest> request = null;
    Response<PutItemResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutItemRequestProtocolMarshaller(protocolFactory).marshall((PutItemRequest)super.beforeMarshalling(putItemRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutItem");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<PutItemResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new PutItemResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (PutItemResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutItemResult putItem(String tableName, Map<String, AttributeValue> item)
  {
    return putItem(new PutItemRequest().withTableName(tableName).withItem(item));
  }
  
  public PutItemResult putItem(String tableName, Map<String, AttributeValue> item, String returnValues)
  {
    return putItem(new PutItemRequest().withTableName(tableName).withItem(item).withReturnValues(returnValues));
  }
  
  public QueryResult query(QueryRequest request)
  {
    request = (QueryRequest)beforeClientExecution(request);
    return executeQuery(request);
  }
  
  @SdkInternalApi
  final QueryResult executeQuery(QueryRequest queryRequest)
  {
    ExecutionContext executionContext = createExecutionContext(queryRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<QueryRequest> request = null;
    Response<QueryResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new QueryRequestProtocolMarshaller(protocolFactory).marshall((QueryRequest)super.beforeMarshalling(queryRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "Query");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<QueryResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new QueryResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (QueryResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public RestoreTableFromBackupResult restoreTableFromBackup(RestoreTableFromBackupRequest request)
  {
    request = (RestoreTableFromBackupRequest)beforeClientExecution(request);
    return executeRestoreTableFromBackup(request);
  }
  
  @SdkInternalApi
  final RestoreTableFromBackupResult executeRestoreTableFromBackup(RestoreTableFromBackupRequest restoreTableFromBackupRequest)
  {
    ExecutionContext executionContext = createExecutionContext(restoreTableFromBackupRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<RestoreTableFromBackupRequest> request = null;
    Response<RestoreTableFromBackupResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new RestoreTableFromBackupRequestProtocolMarshaller(protocolFactory).marshall((RestoreTableFromBackupRequest)super.beforeMarshalling(restoreTableFromBackupRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RestoreTableFromBackup");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<RestoreTableFromBackupResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new RestoreTableFromBackupResultJsonUnmarshaller());
      
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (RestoreTableFromBackupResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public RestoreTableToPointInTimeResult restoreTableToPointInTime(RestoreTableToPointInTimeRequest request)
  {
    request = (RestoreTableToPointInTimeRequest)beforeClientExecution(request);
    return executeRestoreTableToPointInTime(request);
  }
  
  @SdkInternalApi
  final RestoreTableToPointInTimeResult executeRestoreTableToPointInTime(RestoreTableToPointInTimeRequest restoreTableToPointInTimeRequest)
  {
    ExecutionContext executionContext = createExecutionContext(restoreTableToPointInTimeRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<RestoreTableToPointInTimeRequest> request = null;
    Response<RestoreTableToPointInTimeResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new RestoreTableToPointInTimeRequestProtocolMarshaller(protocolFactory).marshall(
          (RestoreTableToPointInTimeRequest)super.beforeMarshalling(restoreTableToPointInTimeRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RestoreTableToPointInTime");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<RestoreTableToPointInTimeResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new RestoreTableToPointInTimeResultJsonUnmarshaller());
      
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (RestoreTableToPointInTimeResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ScanResult scan(ScanRequest request)
  {
    request = (ScanRequest)beforeClientExecution(request);
    return executeScan(request);
  }
  
  @SdkInternalApi
  final ScanResult executeScan(ScanRequest scanRequest)
  {
    ExecutionContext executionContext = createExecutionContext(scanRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ScanRequest> request = null;
    Response<ScanResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ScanRequestProtocolMarshaller(protocolFactory).marshall((ScanRequest)super.beforeMarshalling(scanRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "Scan");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<ScanResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ScanResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (ScanResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ScanResult scan(String tableName, List<String> attributesToGet)
  {
    return scan(new ScanRequest().withTableName(tableName).withAttributesToGet(attributesToGet));
  }
  
  public ScanResult scan(String tableName, Map<String, Condition> scanFilter)
  {
    return scan(new ScanRequest().withTableName(tableName).withScanFilter(scanFilter));
  }
  
  public ScanResult scan(String tableName, List<String> attributesToGet, Map<String, Condition> scanFilter)
  {
    return scan(new ScanRequest().withTableName(tableName).withAttributesToGet(attributesToGet).withScanFilter(scanFilter));
  }
  
  public TagResourceResult tagResource(TagResourceRequest request)
  {
    request = (TagResourceRequest)beforeClientExecution(request);
    return executeTagResource(request);
  }
  
  @SdkInternalApi
  final TagResourceResult executeTagResource(TagResourceRequest tagResourceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(tagResourceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<TagResourceRequest> request = null;
    Response<TagResourceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new TagResourceRequestProtocolMarshaller(protocolFactory).marshall((TagResourceRequest)super.beforeMarshalling(tagResourceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "TagResource");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<TagResourceResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new TagResourceResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (TagResourceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public TransactGetItemsResult transactGetItems(TransactGetItemsRequest request)
  {
    request = (TransactGetItemsRequest)beforeClientExecution(request);
    return executeTransactGetItems(request);
  }
  
  @SdkInternalApi
  final TransactGetItemsResult executeTransactGetItems(TransactGetItemsRequest transactGetItemsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(transactGetItemsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<TransactGetItemsRequest> request = null;
    Response<TransactGetItemsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new TransactGetItemsRequestProtocolMarshaller(protocolFactory).marshall((TransactGetItemsRequest)super.beforeMarshalling(transactGetItemsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "TransactGetItems");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<TransactGetItemsResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new TransactGetItemsResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (TransactGetItemsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public TransactWriteItemsResult transactWriteItems(TransactWriteItemsRequest request)
  {
    request = (TransactWriteItemsRequest)beforeClientExecution(request);
    return executeTransactWriteItems(request);
  }
  
  @SdkInternalApi
  final TransactWriteItemsResult executeTransactWriteItems(TransactWriteItemsRequest transactWriteItemsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(transactWriteItemsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<TransactWriteItemsRequest> request = null;
    Response<TransactWriteItemsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new TransactWriteItemsRequestProtocolMarshaller(protocolFactory).marshall((TransactWriteItemsRequest)super.beforeMarshalling(transactWriteItemsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "TransactWriteItems");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<TransactWriteItemsResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new TransactWriteItemsResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (TransactWriteItemsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UntagResourceResult untagResource(UntagResourceRequest request)
  {
    request = (UntagResourceRequest)beforeClientExecution(request);
    return executeUntagResource(request);
  }
  
  @SdkInternalApi
  final UntagResourceResult executeUntagResource(UntagResourceRequest untagResourceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(untagResourceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UntagResourceRequest> request = null;
    Response<UntagResourceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UntagResourceRequestProtocolMarshaller(protocolFactory).marshall((UntagResourceRequest)super.beforeMarshalling(untagResourceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UntagResource");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<UntagResourceResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new UntagResourceResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (UntagResourceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateContinuousBackupsResult updateContinuousBackups(UpdateContinuousBackupsRequest request)
  {
    request = (UpdateContinuousBackupsRequest)beforeClientExecution(request);
    return executeUpdateContinuousBackups(request);
  }
  
  @SdkInternalApi
  final UpdateContinuousBackupsResult executeUpdateContinuousBackups(UpdateContinuousBackupsRequest updateContinuousBackupsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateContinuousBackupsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateContinuousBackupsRequest> request = null;
    Response<UpdateContinuousBackupsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateContinuousBackupsRequestProtocolMarshaller(protocolFactory).marshall(
          (UpdateContinuousBackupsRequest)super.beforeMarshalling(updateContinuousBackupsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateContinuousBackups");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<UpdateContinuousBackupsResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new UpdateContinuousBackupsResultJsonUnmarshaller());
      
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (UpdateContinuousBackupsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateGlobalTableResult updateGlobalTable(UpdateGlobalTableRequest request)
  {
    request = (UpdateGlobalTableRequest)beforeClientExecution(request);
    return executeUpdateGlobalTable(request);
  }
  
  @SdkInternalApi
  final UpdateGlobalTableResult executeUpdateGlobalTable(UpdateGlobalTableRequest updateGlobalTableRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateGlobalTableRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateGlobalTableRequest> request = null;
    Response<UpdateGlobalTableResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateGlobalTableRequestProtocolMarshaller(protocolFactory).marshall((UpdateGlobalTableRequest)super.beforeMarshalling(updateGlobalTableRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateGlobalTable");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<UpdateGlobalTableResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new UpdateGlobalTableResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (UpdateGlobalTableResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateGlobalTableSettingsResult updateGlobalTableSettings(UpdateGlobalTableSettingsRequest request)
  {
    request = (UpdateGlobalTableSettingsRequest)beforeClientExecution(request);
    return executeUpdateGlobalTableSettings(request);
  }
  
  @SdkInternalApi
  final UpdateGlobalTableSettingsResult executeUpdateGlobalTableSettings(UpdateGlobalTableSettingsRequest updateGlobalTableSettingsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateGlobalTableSettingsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateGlobalTableSettingsRequest> request = null;
    Response<UpdateGlobalTableSettingsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateGlobalTableSettingsRequestProtocolMarshaller(protocolFactory).marshall(
          (UpdateGlobalTableSettingsRequest)super.beforeMarshalling(updateGlobalTableSettingsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateGlobalTableSettings");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<UpdateGlobalTableSettingsResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new UpdateGlobalTableSettingsResultJsonUnmarshaller());
      
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (UpdateGlobalTableSettingsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateItemResult updateItem(UpdateItemRequest request)
  {
    request = (UpdateItemRequest)beforeClientExecution(request);
    return executeUpdateItem(request);
  }
  
  @SdkInternalApi
  final UpdateItemResult executeUpdateItem(UpdateItemRequest updateItemRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateItemRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateItemRequest> request = null;
    Response<UpdateItemResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateItemRequestProtocolMarshaller(protocolFactory).marshall((UpdateItemRequest)super.beforeMarshalling(updateItemRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateItem");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<UpdateItemResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new UpdateItemResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (UpdateItemResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateItemResult updateItem(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates)
  {
    return updateItem(new UpdateItemRequest().withTableName(tableName).withKey(key).withAttributeUpdates(attributeUpdates));
  }
  
  public UpdateItemResult updateItem(String tableName, Map<String, AttributeValue> key, Map<String, AttributeValueUpdate> attributeUpdates, String returnValues)
  {
    return updateItem(new UpdateItemRequest().withTableName(tableName).withKey(key).withAttributeUpdates(attributeUpdates).withReturnValues(returnValues));
  }
  
  public UpdateTableResult updateTable(UpdateTableRequest request)
  {
    request = (UpdateTableRequest)beforeClientExecution(request);
    return executeUpdateTable(request);
  }
  
  @SdkInternalApi
  final UpdateTableResult executeUpdateTable(UpdateTableRequest updateTableRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateTableRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateTableRequest> request = null;
    Response<UpdateTableResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateTableRequestProtocolMarshaller(protocolFactory).marshall((UpdateTableRequest)super.beforeMarshalling(updateTableRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateTable");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<UpdateTableResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new UpdateTableResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (UpdateTableResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateTableResult updateTable(String tableName, ProvisionedThroughput provisionedThroughput)
  {
    return updateTable(new UpdateTableRequest().withTableName(tableName).withProvisionedThroughput(provisionedThroughput));
  }
  
  public UpdateTimeToLiveResult updateTimeToLive(UpdateTimeToLiveRequest request)
  {
    request = (UpdateTimeToLiveRequest)beforeClientExecution(request);
    return executeUpdateTimeToLive(request);
  }
  
  @SdkInternalApi
  final UpdateTimeToLiveResult executeUpdateTimeToLive(UpdateTimeToLiveRequest updateTimeToLiveRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateTimeToLiveRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateTimeToLiveRequest> request = null;
    Response<UpdateTimeToLiveResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateTimeToLiveRequestProtocolMarshaller(protocolFactory).marshall((UpdateTimeToLiveRequest)super.beforeMarshalling(updateTimeToLiveRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "DynamoDB");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateTimeToLive");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      URI cachedEndpoint = null;
      if (endpointDiscoveryEnabled) {
        cachedEndpoint = cache.get(awsCredentialsProvider.getCredentials().getAWSAccessKeyId(), false, endpoint);
      }
      HttpResponseHandler<AmazonWebServiceResponse<UpdateTimeToLiveResult>> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new UpdateTimeToLiveResultJsonUnmarshaller());
      response = invoke(request, responseHandler, executionContext, cachedEndpoint, null);
      
      return (UpdateTimeToLiveResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    return client.getResponseMetadataForRequest(request);
  }
  
  protected final boolean calculateCRC32FromCompressedData()
  {
    return true;
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
    
    HttpResponseHandler<AmazonServiceException> errorResponseHandler = protocolFactory.createErrorResponseHandler(new JsonErrorResponseMetadata());
    
    return client.execute(request, responseHandler, errorResponseHandler, executionContext);
  }
  
  @SdkInternalApi
  static SdkJsonProtocolFactory getProtocolFactory()
  {
    return protocolFactory;
  }
  
  public AmazonDynamoDBWaiters waiters()
  {
    if (waiters == null) {
      synchronized (this)
      {
        if (waiters == null) {
          waiters = new AmazonDynamoDBWaiters(this);
        }
      }
    }
    return waiters;
  }
  
  public void shutdown()
  {
    super.shutdown();
    if (waiters != null) {
      waiters.shutdown();
    }
    if (cache != null) {
      cache.shutdown();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */