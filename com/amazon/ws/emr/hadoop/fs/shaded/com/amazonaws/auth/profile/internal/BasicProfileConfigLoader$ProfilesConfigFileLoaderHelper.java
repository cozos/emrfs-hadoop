package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class BasicProfileConfigLoader$ProfilesConfigFileLoaderHelper
  extends AbstractProfilesConfigFileScanner
{
  protected final Map<String, Map<String, String>> allProfileProperties = new LinkedHashMap();
  
  public Map<String, Map<String, String>> parseProfileProperties(Scanner scanner)
  {
    allProfileProperties.clear();
    run(scanner);
    return new LinkedHashMap(allProfileProperties);
  }
  
  protected void onEmptyOrCommentLine(String profileName, String line) {}
  
  protected void onProfileStartingLine(String newProfileName, String line)
  {
    allProfileProperties.put(newProfileName, new HashMap());
  }
  
  protected void onProfileEndingLine(String prevProfileName) {}
  
  protected void onProfileProperty(String profileName, String propertyKey, String propertyValue, boolean isSupportedProperty, String line)
  {
    Map<String, String> properties = (Map)allProfileProperties.get(profileName);
    if (properties.containsKey(propertyKey)) {
      throw new IllegalArgumentException("Duplicate property values for [" + propertyKey + "].");
    }
    properties.put(propertyKey, propertyValue);
  }
  
  protected void onEndOfFile() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.BasicProfileConfigLoader.ProfilesConfigFileLoaderHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */