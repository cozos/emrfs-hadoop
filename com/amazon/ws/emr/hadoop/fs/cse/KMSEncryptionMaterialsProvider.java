package com.amazon.ws.emr.hadoop.fs.cse;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.KMSEncryptionMaterials;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import java.util.Map;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;

public class KMSEncryptionMaterialsProvider
  implements EncryptionMaterialsProvider, Configurable
{
  private Configuration conf;
  private com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider kmsEncryptionMaterialsProvider;
  
  private void initialize()
  {
    String keyId = conf.get("fs.s3.cse.kms.keyId");
    Preconditions.checkArgument(StringUtils.isNotBlank(keyId), 
      String.format("%s cannot be empty", new Object[] { "fs.s3.cse.kms.keyId" }));
    kmsEncryptionMaterialsProvider = new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider(new KMSEncryptionMaterials(keyId));
  }
  
  public EncryptionMaterials getEncryptionMaterials(Map<String, String> materialsDescription)
  {
    if (kmsEncryptionMaterialsProvider != null) {
      return kmsEncryptionMaterialsProvider.getEncryptionMaterials(materialsDescription);
    }
    throw new RuntimeException("KMSEncryptionMaterialsProvider is not initialized");
  }
  
  public EncryptionMaterials getEncryptionMaterials()
  {
    if (kmsEncryptionMaterialsProvider != null) {
      return kmsEncryptionMaterialsProvider.getEncryptionMaterials();
    }
    throw new RuntimeException("KMSEncryptionMaterialsProvider is not initialized");
  }
  
  public void refresh()
  {
    if (kmsEncryptionMaterialsProvider != null) {
      kmsEncryptionMaterialsProvider.refresh();
    }
  }
  
  public void setConf(Configuration conf)
  {
    this.conf = conf;
    initialize();
  }
  
  public Configuration getConf()
  {
    return conf;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.cse.KMSEncryptionMaterialsProvider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */