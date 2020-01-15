package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlTranslation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteMarkerReplication;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptionConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ReplicationDestinationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ReplicationRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SourceSelectionCriteria;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SseKmsEncryptedObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationTagPredicate;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$BucketReplicationConfigurationHandler
  extends AbstractHandler
{
  private final BucketReplicationConfiguration bucketReplicationConfiguration = new BucketReplicationConfiguration();
  private String currentRuleId;
  private ReplicationRule currentRule;
  private ReplicationFilter currentFilter;
  private List<ReplicationFilterPredicate> andOperandsList;
  private String currentTagKey;
  private String currentTagValue;
  private DeleteMarkerReplication deleteMarkerReplication;
  private ReplicationDestinationConfig destinationConfig;
  private AccessControlTranslation accessControlTranslation;
  private EncryptionConfiguration encryptionConfiguration;
  private SourceSelectionCriteria sourceSelectionCriteria;
  private SseKmsEncryptedObjects sseKmsEncryptedObjects;
  private static final String REPLICATION_CONFIG = "ReplicationConfiguration";
  private static final String ROLE = "Role";
  private static final String RULE = "Rule";
  private static final String DESTINATION = "Destination";
  private static final String ID = "ID";
  private static final String PREFIX = "Prefix";
  private static final String FILTER = "Filter";
  private static final String AND = "And";
  private static final String TAG = "Tag";
  private static final String TAG_KEY = "Key";
  private static final String TAG_VALUE = "Value";
  private static final String DELETE_MARKER_REPLICATION = "DeleteMarkerReplication";
  private static final String PRIORITY = "Priority";
  private static final String STATUS = "Status";
  private static final String BUCKET = "Bucket";
  private static final String STORAGECLASS = "StorageClass";
  private static final String ACCOUNT = "Account";
  private static final String ACCESS_CONTROL_TRANSLATION = "AccessControlTranslation";
  private static final String OWNER = "Owner";
  private static final String ENCRYPTION_CONFIGURATION = "EncryptionConfiguration";
  private static final String REPLICA_KMS_KEY_ID = "ReplicaKmsKeyID";
  private static final String SOURCE_SELECTION_CRITERIA = "SourceSelectionCriteria";
  private static final String SSE_KMS_ENCRYPTED_OBJECTS = "SseKmsEncryptedObjects";
  
  public BucketReplicationConfiguration getConfiguration()
  {
    return bucketReplicationConfiguration;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "ReplicationConfiguration" }))
    {
      if (name.equals("Rule")) {
        currentRule = new ReplicationRule();
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule" }))
    {
      if (name.equals("Destination")) {
        destinationConfig = new ReplicationDestinationConfig();
      } else if (name.equals("SourceSelectionCriteria")) {
        sourceSelectionCriteria = new SourceSelectionCriteria();
      } else if (name.equals("DeleteMarkerReplication")) {
        deleteMarkerReplication = new DeleteMarkerReplication();
      } else if (name.equals("Filter")) {
        currentFilter = new ReplicationFilter();
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule", "Destination" }))
    {
      if (name.equals("AccessControlTranslation")) {
        accessControlTranslation = new AccessControlTranslation();
      } else if (name.equals("EncryptionConfiguration")) {
        encryptionConfiguration = new EncryptionConfiguration();
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule", "SourceSelectionCriteria" }))
    {
      if (name.equals("SseKmsEncryptedObjects")) {
        sseKmsEncryptedObjects = new SseKmsEncryptedObjects();
      }
    }
    else if ((in(new String[] { "ReplicationConfiguration", "Rule", "Filter" })) && 
      (name.equals("And"))) {
      andOperandsList = new ArrayList();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "ReplicationConfiguration" }))
    {
      if (name.equals("Rule"))
      {
        bucketReplicationConfiguration.addRule(currentRuleId, currentRule);
        
        currentRule = null;
        currentRuleId = null;
        deleteMarkerReplication = null;
        destinationConfig = null;
        sseKmsEncryptedObjects = null;
        accessControlTranslation = null;
        encryptionConfiguration = null;
      }
      else if (name.equals("Role"))
      {
        bucketReplicationConfiguration.setRoleARN(getText());
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule" }))
    {
      if (name.equals("ID"))
      {
        currentRuleId = getText();
      }
      else if (name.equals("Prefix"))
      {
        currentRule.setPrefix(getText());
      }
      else if (name.equals("Priority"))
      {
        currentRule.setPriority(Integer.valueOf(getText()));
      }
      else if (name.equals("DeleteMarkerReplication"))
      {
        currentRule.setDeleteMarkerReplication(deleteMarkerReplication);
      }
      else if (name.equals("SourceSelectionCriteria"))
      {
        currentRule.setSourceSelectionCriteria(sourceSelectionCriteria);
      }
      else if (name.equals("Filter"))
      {
        currentRule.setFilter(currentFilter);
        currentFilter = null;
      }
      else if (name.equals("Status"))
      {
        currentRule.setStatus(getText());
      }
      else if (name.equals("Destination"))
      {
        currentRule.setDestinationConfig(destinationConfig);
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule", "Filter" }))
    {
      if (name.equals("Prefix"))
      {
        currentFilter.setPredicate(new ReplicationPrefixPredicate(getText()));
      }
      else if (name.equals("Tag"))
      {
        currentFilter.setPredicate(new ReplicationTagPredicate(new Tag(currentTagKey, currentTagValue)));
        currentTagKey = null;
        currentTagValue = null;
      }
      else if (name.equals("And"))
      {
        currentFilter.setPredicate(new ReplicationAndOperator(andOperandsList));
        andOperandsList = null;
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule", "Filter", "Tag" }))
    {
      if (name.equals("Key")) {
        currentTagKey = getText();
      } else if (name.equals("Value")) {
        currentTagValue = getText();
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule", "Filter", "And" }))
    {
      if (name.equals("Prefix"))
      {
        andOperandsList.add(new ReplicationPrefixPredicate(getText()));
      }
      else if (name.equals("Tag"))
      {
        andOperandsList.add(new ReplicationTagPredicate(new Tag(currentTagKey, currentTagValue)));
        currentTagKey = null;
        currentTagValue = null;
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule", "Filter", "And", "Tag" }))
    {
      if (name.equals("Key")) {
        currentTagKey = getText();
      } else if (name.equals("Value")) {
        currentTagValue = getText();
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule", "SourceSelectionCriteria" }))
    {
      if (name.equals("SseKmsEncryptedObjects")) {
        sourceSelectionCriteria.setSseKmsEncryptedObjects(sseKmsEncryptedObjects);
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule", "SourceSelectionCriteria", "SseKmsEncryptedObjects" }))
    {
      if (name.equals("Status")) {
        sseKmsEncryptedObjects.setStatus(getText());
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule", "DeleteMarkerReplication" }))
    {
      if (name.equals("Status")) {
        deleteMarkerReplication.setStatus(getText());
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule", "Destination" }))
    {
      if (name.equals("Bucket")) {
        destinationConfig.setBucketARN(getText());
      } else if (name.equals("StorageClass")) {
        destinationConfig.setStorageClass(getText());
      } else if (name.equals("Account")) {
        destinationConfig.setAccount(getText());
      } else if (name.equals("AccessControlTranslation")) {
        destinationConfig.setAccessControlTranslation(accessControlTranslation);
      } else if (name.equals("EncryptionConfiguration")) {
        destinationConfig.setEncryptionConfiguration(encryptionConfiguration);
      }
    }
    else if (in(new String[] { "ReplicationConfiguration", "Rule", "Destination", "AccessControlTranslation" }))
    {
      if (name.equals("Owner")) {
        accessControlTranslation.setOwner(getText());
      }
    }
    else if ((in(new String[] { "ReplicationConfiguration", "Rule", "Destination", "EncryptionConfiguration" })) && 
      (name.equals("ReplicaKmsKeyID"))) {
      encryptionConfiguration.setReplicaKmsKeyID(getText());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.BucketReplicationConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */