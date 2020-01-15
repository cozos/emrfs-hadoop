package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortIncompleteMultipartUpload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlTranslation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration.NoncurrentVersionTransition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration.Rule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration.Transition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CORSRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CORSRule.AllowedMethods;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CloudFunctionConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteMarkerReplication;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptionConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Filter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.FilterRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.LambdaConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.NotificationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PublicAccessBlockConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.QueueConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RedirectRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ReplicationDestinationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ReplicationRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RoutingRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RoutingRuleCondition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3KeyFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ServerSideEncryptionByDefault;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ServerSideEncryptionConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ServerSideEncryptionRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SourceSelectionCriteria;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SseKmsEncryptedObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.TagSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.TopicConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.StorageClassAnalysis;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryEncryption;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventorySchedule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.ServerSideEncryptionKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.ServerSideEncryptionS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecyclePredicateVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsPredicateVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsTagPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CollectionUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BucketConfigurationXmlFactory
{
  public byte[] convertToXmlByteArray(BucketVersioningConfiguration versioningConfiguration)
  {
    XmlWriter xml = new XmlWriter();
    xml.start("VersioningConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    xml.start("Status").value(versioningConfiguration.getStatus()).end();
    
    Boolean mfaDeleteEnabled = versioningConfiguration.isMfaDeleteEnabled();
    if (mfaDeleteEnabled != null) {
      if (mfaDeleteEnabled.booleanValue()) {
        xml.start("MfaDelete").value("Enabled").end();
      } else {
        xml.start("MfaDelete").value("Disabled").end();
      }
    }
    xml.end();
    
    return xml.getBytes();
  }
  
  public byte[] convertToXmlByteArray(BucketAccelerateConfiguration accelerateConfiguration)
  {
    XmlWriter xml = new XmlWriter();
    xml.start("AccelerateConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    xml.start("Status").value(accelerateConfiguration.getStatus()).end();
    xml.end();
    return xml.getBytes();
  }
  
  public byte[] convertToXmlByteArray(BucketLoggingConfiguration loggingConfiguration)
  {
    String logFilePrefix = loggingConfiguration.getLogFilePrefix();
    if (logFilePrefix == null) {
      logFilePrefix = "";
    }
    XmlWriter xml = new XmlWriter();
    xml.start("BucketLoggingStatus", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    if (loggingConfiguration.isLoggingEnabled())
    {
      xml.start("LoggingEnabled");
      xml.start("TargetBucket").value(loggingConfiguration.getDestinationBucketName()).end();
      xml.start("TargetPrefix").value(loggingConfiguration.getLogFilePrefix()).end();
      xml.end();
    }
    xml.end();
    
    return xml.getBytes();
  }
  
  public byte[] convertToXmlByteArray(BucketNotificationConfiguration notificationConfiguration)
  {
    XmlWriter xml = new XmlWriter();
    xml.start("NotificationConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    
    Map<String, NotificationConfiguration> configurations = notificationConfiguration.getConfigurations();
    for (Map.Entry<String, NotificationConfiguration> entry : configurations
      .entrySet())
    {
      String configName = (String)entry.getKey();
      NotificationConfiguration config = (NotificationConfiguration)entry.getValue();
      if ((config instanceof TopicConfiguration))
      {
        xml.start("TopicConfiguration");
        xml.start("Id").value(configName).end();
        xml.start("Topic")
          .value(((TopicConfiguration)config).getTopicARN())
          .end();
        addEventsAndFilterCriteria(xml, config);
        xml.end();
      }
      else if ((config instanceof QueueConfiguration))
      {
        xml.start("QueueConfiguration");
        xml.start("Id").value(configName).end();
        xml.start("Queue")
          .value(((QueueConfiguration)config).getQueueARN())
          .end();
        addEventsAndFilterCriteria(xml, config);
        xml.end();
      }
      else if ((config instanceof CloudFunctionConfiguration))
      {
        xml.start("CloudFunctionConfiguration");
        xml.start("Id").value(configName).end();
        xml.start("InvocationRole")
          .value(((CloudFunctionConfiguration)config)
          .getInvocationRoleARN()).end();
        xml.start("CloudFunction")
          .value(((CloudFunctionConfiguration)config).getCloudFunctionARN())
          .end();
        addEventsAndFilterCriteria(xml, config);
        xml.end();
      }
      else if ((config instanceof LambdaConfiguration))
      {
        xml.start("CloudFunctionConfiguration");
        xml.start("Id").value(configName).end();
        xml.start("CloudFunction")
          .value(((LambdaConfiguration)config).getFunctionARN())
          .end();
        addEventsAndFilterCriteria(xml, config);
        xml.end();
      }
    }
    xml.end();
    return xml.getBytes();
  }
  
  private void addEventsAndFilterCriteria(XmlWriter xml, NotificationConfiguration config)
  {
    for (Iterator localIterator = config.getEvents().iterator(); localIterator.hasNext();)
    {
      event = (String)localIterator.next();
      xml.start("Event").value(event).end();
    }
    String event;
    Filter filter = config.getFilter();
    if (filter != null)
    {
      validateFilter(filter);
      xml.start("Filter");
      if (filter.getS3KeyFilter() != null)
      {
        validateS3KeyFilter(filter.getS3KeyFilter());
        xml.start("S3Key");
        for (FilterRule filterRule : filter.getS3KeyFilter().getFilterRules())
        {
          xml.start("FilterRule");
          xml.start("Name").value(filterRule.getName()).end();
          xml.start("Value").value(filterRule.getValue()).end();
          xml.end();
        }
        xml.end();
      }
      xml.end();
    }
  }
  
  private void validateFilter(Filter filter)
  {
    if (filter.getS3KeyFilter() == null) {
      throw new SdkClientException("Cannot have a Filter without any criteria");
    }
  }
  
  private void validateS3KeyFilter(S3KeyFilter s3KeyFilter)
  {
    if (CollectionUtils.isNullOrEmpty(s3KeyFilter.getFilterRules())) {
      throw new SdkClientException("Cannot have an S3KeyFilter without any filter rules");
    }
  }
  
  private void writeReplicationPrefix(XmlWriter xml, ReplicationRule rule)
  {
    if (rule.getFilter() == null) {
      xml.start("Prefix").value(rule.getPrefix() == null ? "" : rule.getPrefix()).end();
    } else if (rule.getPrefix() != null) {
      throw new IllegalArgumentException("Prefix cannot be used with Filter. Use ReplicationPrefixPredicate to create a ReplicationFilter");
    }
  }
  
  public byte[] convertToXmlByteArray(BucketReplicationConfiguration replicationConfiguration)
  {
    XmlWriter xml = new XmlWriter();
    xml.start("ReplicationConfiguration");
    
    Map<String, ReplicationRule> rules = replicationConfiguration.getRules();
    
    String role = replicationConfiguration.getRoleARN();
    xml.start("Role").value(role).end();
    for (Map.Entry<String, ReplicationRule> entry : rules
      .entrySet())
    {
      String ruleId = (String)entry.getKey();
      ReplicationRule rule = (ReplicationRule)entry.getValue();
      
      xml.start("Rule");
      xml.start("ID").value(ruleId).end();
      Integer priority = rule.getPriority();
      if (priority != null) {
        xml.start("Priority").value(Integer.toString(priority.intValue())).end();
      }
      xml.start("Status").value(rule.getStatus()).end();
      DeleteMarkerReplication deleteMarkerReplication = rule.getDeleteMarkerReplication();
      if (deleteMarkerReplication != null) {
        xml.start("DeleteMarkerReplication").start("Status").value(deleteMarkerReplication.getStatus()).end().end();
      }
      writeReplicationPrefix(xml, rule);
      writeReplicationFilter(xml, rule.getFilter());
      if (rule.getSourceSelectionCriteria() != null)
      {
        xml.start("SourceSelectionCriteria");
        SseKmsEncryptedObjects sseKmsEncryptedObjects = rule.getSourceSelectionCriteria().getSseKmsEncryptedObjects();
        if (sseKmsEncryptedObjects != null)
        {
          xml.start("SseKmsEncryptedObjects");
          BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Status", sseKmsEncryptedObjects.getStatus());
          xml.end();
        }
        xml.end();
      }
      ReplicationDestinationConfig config = rule.getDestinationConfig();
      xml.start("Destination");
      xml.start("Bucket").value(config.getBucketARN()).end();
      
      BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Account", config.getAccount());
      if (config.getStorageClass() != null) {
        xml.start("StorageClass").value(config.getStorageClass()).end();
      }
      AccessControlTranslation accessControlTranslation = config.getAccessControlTranslation();
      if (accessControlTranslation != null)
      {
        xml.start("AccessControlTranslation");
        BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Owner", accessControlTranslation.getOwner());
        xml.end();
      }
      if (config.getEncryptionConfiguration() != null)
      {
        xml.start("EncryptionConfiguration");
        BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "ReplicaKmsKeyID", config
          .getEncryptionConfiguration().getReplicaKmsKeyID());
        xml.end();
      }
      xml.end();
      
      xml.end();
    }
    xml.end();
    return xml.getBytes();
  }
  
  public byte[] convertToXmlByteArray(BucketWebsiteConfiguration websiteConfiguration)
  {
    XmlWriter xml = new XmlWriter();
    xml.start("WebsiteConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    if (websiteConfiguration.getIndexDocumentSuffix() != null)
    {
      XmlWriter indexDocumentElement = xml.start("IndexDocument");
      indexDocumentElement.start("Suffix").value(websiteConfiguration.getIndexDocumentSuffix()).end();
      indexDocumentElement.end();
    }
    if (websiteConfiguration.getErrorDocument() != null)
    {
      XmlWriter errorDocumentElement = xml.start("ErrorDocument");
      errorDocumentElement.start("Key").value(websiteConfiguration.getErrorDocument()).end();
      errorDocumentElement.end();
    }
    RedirectRule redirectAllRequestsTo = websiteConfiguration.getRedirectAllRequestsTo();
    if (redirectAllRequestsTo != null)
    {
      XmlWriter redirectAllRequestsElement = xml.start("RedirectAllRequestsTo");
      if (redirectAllRequestsTo.getprotocol() != null) {
        xml.start("Protocol").value(redirectAllRequestsTo.getprotocol()).end();
      }
      if (redirectAllRequestsTo.getHostName() != null) {
        xml.start("HostName").value(redirectAllRequestsTo.getHostName()).end();
      }
      if (redirectAllRequestsTo.getReplaceKeyPrefixWith() != null) {
        xml.start("ReplaceKeyPrefixWith").value(redirectAllRequestsTo.getReplaceKeyPrefixWith()).end();
      }
      if (redirectAllRequestsTo.getReplaceKeyWith() != null) {
        xml.start("ReplaceKeyWith").value(redirectAllRequestsTo.getReplaceKeyWith()).end();
      }
      redirectAllRequestsElement.end();
    }
    if ((websiteConfiguration.getRoutingRules() != null) && (websiteConfiguration.getRoutingRules().size() > 0))
    {
      XmlWriter routingRules = xml.start("RoutingRules");
      for (RoutingRule rule : websiteConfiguration.getRoutingRules()) {
        writeRule(routingRules, rule);
      }
      routingRules.end();
    }
    xml.end();
    return xml.getBytes();
  }
  
  public byte[] convertToXmlByteArray(BucketLifecycleConfiguration config)
    throws SdkClientException
  {
    XmlWriter xml = new XmlWriter();
    xml.start("LifecycleConfiguration");
    for (BucketLifecycleConfiguration.Rule rule : config.getRules()) {
      writeRule(xml, rule);
    }
    xml.end();
    
    return xml.getBytes();
  }
  
  public byte[] convertToXmlByteArray(BucketCrossOriginConfiguration config)
    throws SdkClientException
  {
    XmlWriter xml = new XmlWriter();
    xml.start("CORSConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    for (CORSRule rule : config.getRules()) {
      writeRule(xml, rule);
    }
    xml.end();
    
    return xml.getBytes();
  }
  
  private void writeLifecyclePrefix(XmlWriter xml, BucketLifecycleConfiguration.Rule rule)
  {
    if (rule.getFilter() == null) {
      xml.start("Prefix").value(rule.getPrefix() == null ? "" : rule.getPrefix()).end();
    } else if (rule.getPrefix() != null) {
      throw new IllegalArgumentException("Prefix cannot be used with Filter. Use LifecyclePrefixPredicate to create a LifecycleFilter");
    }
  }
  
  private void writeRule(XmlWriter xml, BucketLifecycleConfiguration.Rule rule)
  {
    xml.start("Rule");
    if (rule.getId() != null) {
      xml.start("ID").value(rule.getId()).end();
    }
    writeLifecyclePrefix(xml, rule);
    xml.start("Status").value(rule.getStatus()).end();
    writeLifecycleFilter(xml, rule.getFilter());
    
    addTransitions(xml, rule.getTransitions());
    addNoncurrentTransitions(xml, rule.getNoncurrentVersionTransitions());
    if (hasCurrentExpirationPolicy(rule))
    {
      xml.start("Expiration");
      if (rule.getExpirationInDays() != -1) {
        xml.start("Days").value("" + rule.getExpirationInDays()).end();
      }
      if (rule.getExpirationDate() != null) {
        xml.start("Date").value(ServiceUtils.formatIso8601Date(rule.getExpirationDate())).end();
      }
      if (rule.isExpiredObjectDeleteMarker() == true) {
        xml.start("ExpiredObjectDeleteMarker").value("true").end();
      }
      xml.end();
    }
    if (rule.getNoncurrentVersionExpirationInDays() != -1)
    {
      xml.start("NoncurrentVersionExpiration");
      xml.start("NoncurrentDays")
        .value(Integer.toString(rule
        .getNoncurrentVersionExpirationInDays()))
        .end();
      xml.end();
    }
    if (rule.getAbortIncompleteMultipartUpload() != null)
    {
      xml.start("AbortIncompleteMultipartUpload");
      xml.start("DaysAfterInitiation")
        .value(Integer.toString(rule.getAbortIncompleteMultipartUpload().getDaysAfterInitiation()))
        .end();
      xml.end();
    }
    xml.end();
  }
  
  private void addTransitions(XmlWriter xml, List<BucketLifecycleConfiguration.Transition> transitions)
  {
    if ((transitions == null) || (transitions.isEmpty())) {
      return;
    }
    for (BucketLifecycleConfiguration.Transition t : transitions) {
      if (t != null)
      {
        xml.start("Transition");
        if (t.getDate() != null)
        {
          xml.start("Date");
          xml.value(ServiceUtils.formatIso8601Date(t.getDate()));
          xml.end();
        }
        if (t.getDays() != -1)
        {
          xml.start("Days");
          xml.value(Integer.toString(t.getDays()));
          xml.end();
        }
        xml.start("StorageClass");
        xml.value(t.getStorageClassAsString());
        xml.end();
        xml.end();
      }
    }
  }
  
  private void addNoncurrentTransitions(XmlWriter xml, List<BucketLifecycleConfiguration.NoncurrentVersionTransition> transitions)
  {
    if ((transitions == null) || (transitions.isEmpty())) {
      return;
    }
    for (BucketLifecycleConfiguration.NoncurrentVersionTransition t : transitions) {
      if (t != null)
      {
        xml.start("NoncurrentVersionTransition");
        if (t.getDays() != -1)
        {
          xml.start("NoncurrentDays");
          xml.value(Integer.toString(t.getDays()));
          xml.end();
        }
        xml.start("StorageClass");
        xml.value(t.getStorageClassAsString());
        xml.end();
        xml.end();
      }
    }
  }
  
  private void writeLifecycleFilter(XmlWriter xml, LifecycleFilter filter)
  {
    if (filter == null) {
      return;
    }
    xml.start("Filter");
    writeLifecycleFilterPredicate(xml, filter.getPredicate());
    xml.end();
  }
  
  private void writeLifecycleFilterPredicate(XmlWriter xml, LifecycleFilterPredicate predicate)
  {
    if (predicate == null) {
      return;
    }
    predicate.accept(new LifecyclePredicateVisitorImpl(xml));
  }
  
  private void writeReplicationFilter(XmlWriter xml, ReplicationFilter filter)
  {
    if (filter == null) {
      return;
    }
    xml.start("Filter");
    writeReplicationPredicate(xml, filter.getPredicate());
    xml.end();
  }
  
  private void writeReplicationPredicate(XmlWriter xml, ReplicationFilterPredicate predicate)
  {
    if (predicate == null) {
      return;
    }
    predicate.accept(new ReplicationPredicateVisitorImpl(xml));
  }
  
  public byte[] convertToXmlByteArray(ServerSideEncryptionConfiguration sseConfig)
  {
    XmlWriter xml = new XmlWriter();
    xml.start("ServerSideEncryptionConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    for (ServerSideEncryptionRule rule : sseConfig.getRules())
    {
      xml.start("Rule");
      writeServerSideEncryptionByDefault(xml, rule.getApplyServerSideEncryptionByDefault());
      xml.end();
    }
    xml.end();
    return xml.getBytes();
  }
  
  private void writeServerSideEncryptionByDefault(XmlWriter xml, ServerSideEncryptionByDefault sseByDefault)
  {
    if (sseByDefault == null) {
      return;
    }
    xml.start("ApplyServerSideEncryptionByDefault");
    BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "SSEAlgorithm", sseByDefault.getSSEAlgorithm());
    BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "KMSMasterKeyID", sseByDefault.getKMSMasterKeyID());
    xml.end();
  }
  
  public byte[] convertToXmlByteArray(PublicAccessBlockConfiguration config)
  {
    XmlWriter xml = new XmlWriter();
    xml.start("PublicAccessBlockConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    addBooleanParameterIfNotNull(xml, "BlockPublicAcls", config.getBlockPublicAcls());
    addBooleanParameterIfNotNull(xml, "IgnorePublicAcls", config.getIgnorePublicAcls());
    addBooleanParameterIfNotNull(xml, "BlockPublicPolicy", config.getBlockPublicPolicy());
    addBooleanParameterIfNotNull(xml, "RestrictPublicBuckets", config.getRestrictPublicBuckets());
    xml.end();
    return xml.getBytes();
  }
  
  private class LifecyclePredicateVisitorImpl
    implements LifecyclePredicateVisitor
  {
    private final XmlWriter xml;
    
    public LifecyclePredicateVisitorImpl(XmlWriter xml)
    {
      this.xml = xml;
    }
    
    public void visit(LifecyclePrefixPredicate lifecyclePrefixPredicate)
    {
      BucketConfigurationXmlFactoryFunctions.writePrefix(xml, lifecyclePrefixPredicate.getPrefix());
    }
    
    public void visit(LifecycleTagPredicate lifecycleTagPredicate)
    {
      BucketConfigurationXmlFactory.this.writeTag(xml, lifecycleTagPredicate.getTag());
    }
    
    public void visit(LifecycleAndOperator lifecycleAndOperator)
    {
      xml.start("And");
      for (LifecycleFilterPredicate predicate : lifecycleAndOperator.getOperands()) {
        predicate.accept(this);
      }
      xml.end();
    }
  }
  
  private boolean hasCurrentExpirationPolicy(BucketLifecycleConfiguration.Rule rule)
  {
    return (rule.getExpirationInDays() != -1) || (rule.getExpirationDate() != null) || (rule.isExpiredObjectDeleteMarker());
  }
  
  private void writeRule(XmlWriter xml, CORSRule rule)
  {
    xml.start("CORSRule");
    if (rule.getId() != null) {
      xml.start("ID").value(rule.getId()).end();
    }
    if (rule.getAllowedOrigins() != null) {
      for (String origin : rule.getAllowedOrigins()) {
        xml.start("AllowedOrigin").value(origin).end();
      }
    }
    if (rule.getAllowedMethods() != null) {
      for (CORSRule.AllowedMethods method : rule.getAllowedMethods()) {
        xml.start("AllowedMethod").value(method.toString()).end();
      }
    }
    if (rule.getMaxAgeSeconds() != 0) {
      xml.start("MaxAgeSeconds").value(Integer.toString(rule.getMaxAgeSeconds())).end();
    }
    if (rule.getExposedHeaders() != null) {
      for (String header : rule.getExposedHeaders()) {
        xml.start("ExposeHeader").value(header).end();
      }
    }
    if (rule.getAllowedHeaders() != null) {
      for (String header : rule.getAllowedHeaders()) {
        xml.start("AllowedHeader").value(header).end();
      }
    }
    xml.end();
  }
  
  private void writeRule(XmlWriter xml, RoutingRule rule)
  {
    xml.start("RoutingRule");
    RoutingRuleCondition condition = rule.getCondition();
    if (condition != null)
    {
      xml.start("Condition");
      xml.start("KeyPrefixEquals");
      if (condition.getKeyPrefixEquals() != null) {
        xml.value(condition.getKeyPrefixEquals());
      }
      xml.end();
      if (condition.getHttpErrorCodeReturnedEquals() != null) {
        xml.start("HttpErrorCodeReturnedEquals ").value(condition.getHttpErrorCodeReturnedEquals()).end();
      }
      xml.end();
    }
    xml.start("Redirect");
    RedirectRule redirect = rule.getRedirect();
    if (redirect != null)
    {
      if (redirect.getprotocol() != null) {
        xml.start("Protocol").value(redirect.getprotocol()).end();
      }
      if (redirect.getHostName() != null) {
        xml.start("HostName").value(redirect.getHostName()).end();
      }
      if (redirect.getReplaceKeyPrefixWith() != null) {
        xml.start("ReplaceKeyPrefixWith").value(redirect.getReplaceKeyPrefixWith()).end();
      }
      if (redirect.getReplaceKeyWith() != null) {
        xml.start("ReplaceKeyWith").value(redirect.getReplaceKeyWith()).end();
      }
      if (redirect.getHttpRedirectCode() != null) {
        xml.start("HttpRedirectCode").value(redirect.getHttpRedirectCode()).end();
      }
    }
    xml.end();
    xml.end();
  }
  
  public byte[] convertToXmlByteArray(BucketTaggingConfiguration config)
    throws SdkClientException
  {
    XmlWriter xml = new XmlWriter();
    xml.start("Tagging");
    for (TagSet tagset : config.getAllTagSets()) {
      writeRule(xml, tagset);
    }
    xml.end();
    
    return xml.getBytes();
  }
  
  public byte[] convertToXmlByteArray(InventoryConfiguration config)
    throws SdkClientException
  {
    XmlWriter xml = new XmlWriter();
    xml.start("InventoryConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    
    xml.start("Id").value(config.getId()).end();
    xml.start("IsEnabled").value(String.valueOf(config.isEnabled())).end();
    xml.start("IncludedObjectVersions").value(config.getIncludedObjectVersions()).end();
    
    writeInventoryDestination(xml, config.getDestination());
    writeInventoryFilter(xml, config.getInventoryFilter());
    addInventorySchedule(xml, config.getSchedule());
    addInventoryOptionalFields(xml, config.getOptionalFields());
    
    xml.end();
    
    return xml.getBytes();
  }
  
  private void writeInventoryDestination(XmlWriter xml, InventoryDestination destination)
  {
    if (destination == null) {
      return;
    }
    xml.start("Destination");
    InventoryS3BucketDestination s3BucketDestination = destination.getS3BucketDestination();
    if (s3BucketDestination != null)
    {
      xml.start("S3BucketDestination");
      BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "AccountId", s3BucketDestination.getAccountId());
      BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Bucket", s3BucketDestination.getBucketArn());
      BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Prefix", s3BucketDestination.getPrefix());
      BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Format", s3BucketDestination.getFormat());
      writeInventoryEncryption(xml, s3BucketDestination.getEncryption());
      xml.end();
    }
    xml.end();
  }
  
  private void writeInventoryEncryption(XmlWriter xml, InventoryEncryption encryption)
  {
    if (encryption == null) {
      return;
    }
    xml.start("Encryption");
    if ((encryption instanceof ServerSideEncryptionS3))
    {
      xml.start("SSE-S3").end();
    }
    else if ((encryption instanceof ServerSideEncryptionKMS))
    {
      xml.start("SSE-KMS");
      BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "KeyId", ((ServerSideEncryptionKMS)encryption).getKeyId());
      xml.end();
    }
    xml.end();
  }
  
  private void writeInventoryFilter(XmlWriter xml, InventoryFilter inventoryFilter)
  {
    if (inventoryFilter == null) {
      return;
    }
    xml.start("Filter");
    writeInventoryFilterPredicate(xml, inventoryFilter.getPredicate());
    xml.end();
  }
  
  private void writeInventoryFilterPredicate(XmlWriter xml, InventoryFilterPredicate predicate)
  {
    if (predicate == null) {
      return;
    }
    if ((predicate instanceof InventoryPrefixPredicate)) {
      BucketConfigurationXmlFactoryFunctions.writePrefix(xml, ((InventoryPrefixPredicate)predicate).getPrefix());
    }
  }
  
  private void addInventorySchedule(XmlWriter xml, InventorySchedule schedule)
  {
    if (schedule == null) {
      return;
    }
    xml.start("Schedule");
    BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Frequency", schedule.getFrequency());
    xml.end();
  }
  
  private void addInventoryOptionalFields(XmlWriter xml, List<String> optionalFields)
  {
    if (CollectionUtils.isNullOrEmpty(optionalFields)) {
      return;
    }
    xml.start("OptionalFields");
    for (String field : optionalFields) {
      xml.start("Field").value(field).end();
    }
    xml.end();
  }
  
  private void writeRule(XmlWriter xml, TagSet tagset)
  {
    xml.start("TagSet");
    for (String key : tagset.getAllTags().keySet())
    {
      xml.start("Tag");
      xml.start("Key").value(key).end();
      xml.start("Value").value(tagset.getTag(key)).end();
      xml.end();
    }
    xml.end();
  }
  
  private boolean hasTags(TagSet tagSet)
  {
    return (tagSet != null) && (tagSet.getAllTags() != null) && (tagSet.getAllTags().size() > 0);
  }
  
  public byte[] convertToXmlByteArray(AnalyticsConfiguration config)
    throws SdkClientException
  {
    XmlWriter xml = new XmlWriter();
    
    xml.start("AnalyticsConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    
    BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Id", config.getId());
    writeAnalyticsFilter(xml, config.getFilter());
    writeStorageClassAnalysis(xml, config.getStorageClassAnalysis());
    
    xml.end();
    
    return xml.getBytes();
  }
  
  private void writeAnalyticsFilter(XmlWriter xml, AnalyticsFilter filter)
  {
    if (filter == null) {
      return;
    }
    xml.start("Filter");
    writeAnalyticsFilterPredicate(xml, filter.getPredicate());
    xml.end();
  }
  
  private void writeAnalyticsFilterPredicate(XmlWriter xml, AnalyticsFilterPredicate predicate)
  {
    if (predicate == null) {
      return;
    }
    predicate.accept(new AnalyticsPredicateVisitorImpl(xml));
  }
  
  private void writeStorageClassAnalysis(XmlWriter xml, StorageClassAnalysis storageClassAnalysis)
  {
    if (storageClassAnalysis == null) {
      return;
    }
    xml.start("StorageClassAnalysis");
    if (storageClassAnalysis.getDataExport() != null)
    {
      StorageClassAnalysisDataExport dataExport = storageClassAnalysis.getDataExport();
      
      xml.start("DataExport");
      
      BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "OutputSchemaVersion", dataExport.getOutputSchemaVersion());
      writeAnalyticsExportDestination(xml, dataExport.getDestination());
      
      xml.end();
    }
    xml.end();
  }
  
  private void writeAnalyticsExportDestination(XmlWriter xml, AnalyticsExportDestination destination)
  {
    if (destination == null) {
      return;
    }
    xml.start("Destination");
    if (destination.getS3BucketDestination() != null)
    {
      xml.start("S3BucketDestination");
      AnalyticsS3BucketDestination s3BucketDestination = destination.getS3BucketDestination();
      BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Format", s3BucketDestination.getFormat());
      BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "BucketAccountId", s3BucketDestination.getBucketAccountId());
      BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Bucket", s3BucketDestination.getBucketArn());
      BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Prefix", s3BucketDestination.getPrefix());
      xml.end();
    }
    xml.end();
  }
  
  public byte[] convertToXmlByteArray(MetricsConfiguration config)
    throws SdkClientException
  {
    XmlWriter xml = new XmlWriter();
    
    xml.start("MetricsConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    
    BucketConfigurationXmlFactoryFunctions.addParameterIfNotNull(xml, "Id", config.getId());
    writeMetricsFilter(xml, config.getFilter());
    
    xml.end();
    
    return xml.getBytes();
  }
  
  private void writeMetricsFilter(XmlWriter xml, MetricsFilter filter)
  {
    if (filter == null) {
      return;
    }
    xml.start("Filter");
    writeMetricsFilterPredicate(xml, filter.getPredicate());
    xml.end();
  }
  
  private void writeMetricsFilterPredicate(XmlWriter xml, MetricsFilterPredicate predicate)
  {
    if (predicate == null) {
      return;
    }
    predicate.accept(new MetricsPredicateVisitorImpl(xml));
  }
  
  private class MetricsPredicateVisitorImpl
    implements MetricsPredicateVisitor
  {
    private final XmlWriter xml;
    
    public MetricsPredicateVisitorImpl(XmlWriter xml)
    {
      this.xml = xml;
    }
    
    public void visit(MetricsPrefixPredicate metricsPrefixPredicate)
    {
      BucketConfigurationXmlFactoryFunctions.writePrefix(xml, metricsPrefixPredicate.getPrefix());
    }
    
    public void visit(MetricsTagPredicate metricsTagPredicate)
    {
      BucketConfigurationXmlFactory.this.writeTag(xml, metricsTagPredicate.getTag());
    }
    
    public void visit(MetricsAndOperator metricsAndOperator)
    {
      xml.start("And");
      for (MetricsFilterPredicate predicate : metricsAndOperator.getOperands()) {
        predicate.accept(this);
      }
      xml.end();
    }
  }
  
  private void addBooleanParameterIfNotNull(XmlWriter xml, String xmlTagName, Boolean value)
  {
    if (value != null) {
      xml.start(xmlTagName).value(value.toString()).end();
    }
  }
  
  private void writeTag(XmlWriter xml, Tag tag)
  {
    if (tag == null) {
      return;
    }
    xml.start("Tag");
    xml.start("Key").value(tag.getKey()).end();
    xml.start("Value").value(tag.getValue()).end();
    xml.end();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.BucketConfigurationXmlFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */