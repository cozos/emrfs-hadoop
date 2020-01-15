package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsAccessor;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import java.io.Serializable;
import java.util.Map;

public class StaticEncryptionMaterialsProvider
  implements EncryptionMaterialsProvider, Serializable
{
  private final EncryptionMaterials materials;
  
  public StaticEncryptionMaterialsProvider(EncryptionMaterials materials)
  {
    this.materials = materials;
  }
  
  public EncryptionMaterials getEncryptionMaterials()
  {
    return materials;
  }
  
  public void refresh() {}
  
  public EncryptionMaterials getEncryptionMaterials(Map<String, String> materialDescIn)
  {
    if (materials == null) {
      return null;
    }
    Map<String, String> materialDesc = materials.getMaterialsDescription();
    if ((materialDescIn != null) && (materialDescIn.equals(materialDesc))) {
      return materials;
    }
    EncryptionMaterialsAccessor accessor = materials.getAccessor();
    if (accessor != null)
    {
      EncryptionMaterials accessorMaterials = accessor.getEncryptionMaterials(materialDescIn);
      if (accessorMaterials != null) {
        return accessorMaterials;
      }
    }
    boolean noMaterialDescIn = (materialDescIn == null) || (materialDescIn.size() == 0);
    boolean noMaterialDesc = (materialDesc == null) || (materialDesc.size() == 0);
    return (noMaterialDescIn) && (noMaterialDesc) ? materials : null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */