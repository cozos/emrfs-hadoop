package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import java.util.Collection;
import java.util.List;

public class UpdateTableSpec
  extends AbstractSpec<UpdateTableRequest>
{
  public UpdateTableSpec()
  {
    super(new UpdateTableRequest());
  }
  
  public ProvisionedThroughput getProvisionedThroughput()
  {
    return ((UpdateTableRequest)getRequest()).getProvisionedThroughput();
  }
  
  public UpdateTableSpec withProvisionedThroughput(ProvisionedThroughput provisionedThroughput)
  {
    ((UpdateTableRequest)getRequest()).setProvisionedThroughput(provisionedThroughput);
    return this;
  }
  
  public List<AttributeDefinition> getAttributeDefinitions()
  {
    return ((UpdateTableRequest)getRequest()).getAttributeDefinitions();
  }
  
  public UpdateTableSpec withAttributeDefinitions(AttributeDefinition... attributeDefinitions)
  {
    ((UpdateTableRequest)getRequest()).withAttributeDefinitions(attributeDefinitions);
    return this;
  }
  
  public UpdateTableSpec withAttributeDefinitions(Collection<AttributeDefinition> attributeDefinitions)
  {
    ((UpdateTableRequest)getRequest()).withAttributeDefinitions(attributeDefinitions);
    return this;
  }
  
  public UpdateTableSpec withGlobalSecondaryIndexUpdates(GlobalSecondaryIndexUpdate... globalSecondaryIndexUpdates)
  {
    ((UpdateTableRequest)getRequest()).withGlobalSecondaryIndexUpdates(globalSecondaryIndexUpdates);
    
    return this;
  }
  
  public UpdateTableSpec withGlobalSecondaryIndexUpdates(Collection<GlobalSecondaryIndexUpdate> globalSecondaryIndexUpdates)
  {
    ((UpdateTableRequest)getRequest()).withGlobalSecondaryIndexUpdates(globalSecondaryIndexUpdates);
    
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.UpdateTableSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */