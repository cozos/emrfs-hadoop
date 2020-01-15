package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStoreManager;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreException;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.RetriableEntityStoreException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Inject;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.hadoop.conf.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NativeDynamoDBEntityStoreManager
  implements EntityStoreManager
{
  private static final Logger LOG = LoggerFactory.getLogger(NativeDynamoDBEntityStoreManager.class);
  private final AmazonDynamoDB amazonDynamoDB;
  private final Configuration configuration;
  
  @Inject
  public NativeDynamoDBEntityStoreManager(AmazonDynamoDB amazonDynamoDB, Configuration configuration)
  {
    this.amazonDynamoDB = amazonDynamoDB;
    this.configuration = configuration;
  }
  
  public Collection<NativeDynamoDBEntityStore> describeEntityStores()
  {
    List<NativeDynamoDBEntityStore> results = new ArrayList();
    String startTableName = null;
    do
    {
      ListTablesRequest listTablesRequest = new ListTablesRequest().withExclusiveStartTableName(startTableName);
      ListTablesResult listTablesResult = amazonDynamoDB.listTables(listTablesRequest);
      for (String tableName : listTablesResult.getTableNames()) {
        try
        {
          results.add(getEntityStore(tableName, false));
        }
        catch (AmazonServiceException|EntityStoreException|RetriableEntityStoreException localAmazonServiceException) {}
      }
      startTableName = listTablesResult.getLastEvaluatedTableName();
    } while (startTableName != null);
    return results;
  }
  
  public NativeDynamoDBEntityStore getEntityStore(String name, boolean autoCreate)
  {
    NativeDynamoDBEntityStore entityStore = new NativeDynamoDBEntityStore(amazonDynamoDB).withAutoCreateTable(autoCreate).withTableName(name).withEtagVerification(ConfigurationUtils.getEtagVerificationEnabled(configuration));
    entityStore.initialize();
    return entityStore;
  }
  
  public void destroyEntityStore(String name)
  {
    DeleteTableRequest deleteTableRequest = new DeleteTableRequest().withTableName(name);
    try
    {
      amazonDynamoDB.deleteTable(deleteTableRequest);
    }
    catch (ResourceNotFoundException localResourceNotFoundException) {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBEntityStoreManager
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */