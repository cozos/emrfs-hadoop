package com.amazon.ws.emr.hadoop.fs.property;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

public enum AwsS3SignerType
{
  SIGV2("S3SignerType"),  SIGV4("AWSS3V4SignerType");
  
  private final String name;
  
  private AwsS3SignerType(String name)
  {
    this.name = name;
  }
  
  @Nullable
  public static String fromName(String type)
  {
    for (AwsS3SignerType signerType : ) {
      if (signerType.getName().equals(type)) {
        return type;
      }
    }
    return null;
  }
  
  public static List<String> getNames()
  {
    List<String> names = Lists.newArrayList();
    for (AwsS3SignerType signerType : values()) {
      names.add(signerType.getName());
    }
    return names;
  }
  
  public static boolean isValidName(String name)
  {
    return fromName(name) != null;
  }
  
  public String getName()
  {
    return name;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.property.AwsS3SignerType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */