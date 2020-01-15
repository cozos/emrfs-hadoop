package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SimpleMaterialProvider
  implements EncryptionMaterialsProvider, Serializable
{
  private final Map<Map<String, String>, EncryptionMaterials> map = new HashMap();
  private EncryptionMaterials latest;
  
  public EncryptionMaterials getEncryptionMaterials(Map<String, String> md)
  {
    return (EncryptionMaterials)map.get(md);
  }
  
  public EncryptionMaterials getEncryptionMaterials()
  {
    return latest;
  }
  
  public SimpleMaterialProvider addMaterial(EncryptionMaterials m)
  {
    map.put(m.getMaterialsDescription(), m);
    return this;
  }
  
  public SimpleMaterialProvider withLatest(EncryptionMaterials m)
  {
    return addMaterial(latest = m);
  }
  
  public SimpleMaterialProvider removeMaterial(Map<String, String> md)
  {
    map.remove(md);
    return this;
  }
  
  public int size()
  {
    return map.size();
  }
  
  public void refresh() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SimpleMaterialProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */