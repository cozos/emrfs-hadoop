package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import java.util.Scanner;

public abstract class AbstractProfilesConfigFileScanner
{
  protected abstract void onEmptyOrCommentLine(String paramString1, String paramString2);
  
  protected abstract void onProfileStartingLine(String paramString1, String paramString2);
  
  protected abstract void onProfileEndingLine(String paramString);
  
  protected abstract void onEndOfFile();
  
  protected abstract void onProfileProperty(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4);
  
  protected boolean isSupportedProperty(String propertyName)
  {
    return true;
  }
  
  protected void run(Scanner scanner)
  {
    String currentProfileName = null;
    try
    {
      int lineNumber = 0;
      while (scanner.hasNextLine())
      {
        lineNumber++;
        String line = scanner.nextLine().trim();
        if ((line.isEmpty()) || (line.startsWith("#")))
        {
          onEmptyOrCommentLine(currentProfileName, line);
        }
        else
        {
          String newProfileName = parseProfileName(line);
          boolean atNewProfileStartingLine = newProfileName != null;
          if (atNewProfileStartingLine)
          {
            if (currentProfileName != null) {
              onProfileEndingLine(currentProfileName);
            }
            onProfileStartingLine(newProfileName, line);
            
            currentProfileName = newProfileName;
          }
          else
          {
            Map.Entry<String, String> property = parsePropertyLine(line, lineNumber);
            if (currentProfileName == null) {
              throw new IllegalArgumentException("Property is defined without a preceding profile name on line " + lineNumber);
            }
            onProfileProperty(currentProfileName, 
              (String)property.getKey(), 
              (String)property.getValue(), 
              isSupportedProperty((String)property.getKey()), line);
          }
        }
      }
      if (currentProfileName != null) {
        onProfileEndingLine(currentProfileName);
      }
      onEndOfFile();
    }
    finally
    {
      scanner.close();
    }
  }
  
  private static String parseProfileName(String trimmedLine)
  {
    if ((trimmedLine.startsWith("[")) && (trimmedLine.endsWith("]")))
    {
      String profileName = trimmedLine.substring(1, trimmedLine.length() - 1);
      return profileName.trim();
    }
    return null;
  }
  
  private static Map.Entry<String, String> parsePropertyLine(String propertyLine, int lineNumber)
  {
    String[] pair = propertyLine.split("=", 2);
    if (pair.length != 2) {
      throw new IllegalArgumentException("Invalid property format: no '=' character is found on line " + lineNumber);
    }
    String propertyKey = pair[0].trim();
    String propertyValue = pair[1].trim();
    
    return new AbstractMap.SimpleImmutableEntry(propertyKey, propertyValue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AbstractProfilesConfigFileScanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */