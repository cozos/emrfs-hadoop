package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.Adler32;

@SdkInternalApi
public class UpdateExpressionGenerator
{
  private String generateSubstitutionTokenString(String baseToken, Long suffixCounter, Set<String> expressionAttributeNamesKeys, Set<String> expressionAttributeValuesKeys)
  {
    String hexSuffix = Long.toHexString(suffixCounter.longValue());
    String tokenBase = baseToken.substring(0, Math.min(baseToken.length(), 4)) + hexSuffix;
    if ((!expressionAttributeNamesKeys.contains(getExpressionAttributeNameSubstitutionToken(tokenBase))) && 
      (!expressionAttributeValuesKeys.contains(getExpressionAttributeValueSubstitutionToken(tokenBase)))) {
      return tokenBase;
    }
    String fullToken = baseToken + hexSuffix;
    if ((!expressionAttributeNamesKeys.contains(getExpressionAttributeNameSubstitutionToken(fullToken))) && 
      (!expressionAttributeValuesKeys.contains(getExpressionAttributeValueSubstitutionToken(fullToken)))) {
      return fullToken;
    }
    throw new DynamoDBMappingException("Failed to process update operation inside transactionWrite request due to conflict with expressionAttributeName or expressionAttributeValue token name: " + fullToken + ". Please replace this token name with a different token name.");
  }
  
  private String generateSubstitutionTokenString(String baseToken, Long suffixCounter, Set<String> expressionAttributeNamesKeys)
  {
    return generateSubstitutionTokenString(baseToken, suffixCounter, expressionAttributeNamesKeys, 
    
      Collections.emptySet());
  }
  
  public String generateUpdateExpressionAndUpdateAttributeMaps(Map<String, String> expressionAttributeNamesMap, Map<String, AttributeValue> expressionsAttributeValuesMap, Map<String, AttributeValue> nonKeyNonNullAttributeValueMap, List<String> nullValuedNonKeyAttributeNames)
  {
    StringBuilder updateExpressionSetBuilder = new StringBuilder();
    StringBuilder updateExpressionDeleteBuilder = new StringBuilder();
    
    List<String> sortedNonKeyNonNullAttributeNames = new ArrayList(nonKeyNonNullAttributeValueMap.keySet());
    Collections.sort(sortedNonKeyNonNullAttributeNames);
    
    List<String> sortedNullValuedNonKeyAttributeNames = new ArrayList(nullValuedNonKeyAttributeNames);
    Collections.sort(sortedNullValuedNonKeyAttributeNames);
    
    String baseToken = getBaseToken(sortedNonKeyNonNullAttributeNames, sortedNullValuedNonKeyAttributeNames);
    Long suffixCounter = Long.valueOf(0L);
    Object tokenKeyName;
    Object tokenValueName;
    int i;
    if (sortedNonKeyNonNullAttributeNames.size() > 0)
    {
      updateExpressionSetBuilder.append("SET ");
      List<String> updateStringSetExpressions = new ArrayList();
      for (String nonKeyAttributeName : sortedNonKeyNonNullAttributeNames)
      {
        String tokenBase = generateSubstitutionTokenString(baseToken, suffixCounter, expressionAttributeNamesMap
        
          .keySet(), expressionsAttributeValuesMap
          .keySet());
        Long localLong1 = suffixCounter;Long localLong2 = suffixCounter = Long.valueOf(suffixCounter.longValue() + 1L);
        tokenKeyName = getExpressionAttributeNameSubstitutionToken(tokenBase);
        tokenValueName = getExpressionAttributeValueSubstitutionToken(tokenBase);
        expressionAttributeNamesMap.put(tokenKeyName, nonKeyAttributeName);
        expressionsAttributeValuesMap.put(tokenValueName, nonKeyNonNullAttributeValueMap.get(nonKeyAttributeName));
        updateStringSetExpressions.add((String)tokenKeyName + " = " + (String)tokenValueName);
      }
      for (i = 0; i < updateStringSetExpressions.size() - 1; i++) {
        updateExpressionSetBuilder.append((String)updateStringSetExpressions.get(i) + ", ");
      }
      updateExpressionSetBuilder.append((String)updateStringSetExpressions.get(updateStringSetExpressions.size() - 1));
    }
    if (sortedNullValuedNonKeyAttributeNames.size() > 0)
    {
      updateExpressionDeleteBuilder.append("REMOVE ");
      List<String> updateStringDeleteExpressions = new ArrayList();
      for (String nullAttributeName : sortedNullValuedNonKeyAttributeNames)
      {
        String tokenBaseString = generateSubstitutionTokenString(baseToken, suffixCounter, expressionAttributeNamesMap
        
          .keySet());
        tokenKeyName = suffixCounter;tokenValueName = suffixCounter = Long.valueOf(suffixCounter.longValue() + 1L);
        String tokenKeyName = getExpressionAttributeNameSubstitutionToken(tokenBaseString);
        expressionAttributeNamesMap.put(tokenKeyName, nullAttributeName);
        updateStringDeleteExpressions.add(tokenKeyName);
      }
      for (int i = 0; i < updateStringDeleteExpressions.size() - 1; i++) {
        updateExpressionDeleteBuilder.append((String)updateStringDeleteExpressions.get(i) + ", ");
      }
      updateExpressionDeleteBuilder.append((String)updateStringDeleteExpressions.get(updateStringDeleteExpressions.size() - 1));
    }
    StringBuilder updateExpression = new StringBuilder();
    if (updateExpressionSetBuilder.length() > 0) {
      updateExpression.append(updateExpressionSetBuilder.toString());
    }
    if (updateExpressionDeleteBuilder.length() > 0) {
      updateExpression.append(" " + updateExpressionDeleteBuilder.toString());
    }
    return updateExpression.toString();
  }
  
  private static String getExpressionAttributeNameSubstitutionToken(String tokenBase)
  {
    return "#" + tokenBase;
  }
  
  private static String getExpressionAttributeValueSubstitutionToken(String tokenBase)
  {
    return ":" + tokenBase;
  }
  
  private String getBaseToken(List<String> sortedNonKeyNonNullAttributeNames, List<String> sortedNullValuedNonKeyAttributeNames)
  {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    try
    {
      for (String nonKeyNonNullAttributeName : sortedNonKeyNonNullAttributeNames) {
        dataOutputStream.writeUTF(nonKeyNonNullAttributeName);
      }
      for (String nullValuedNonKeyAttributeName : sortedNullValuedNonKeyAttributeNames) {
        dataOutputStream.writeUTF(nullValuedNonKeyAttributeName);
      }
    }
    catch (IOException e)
    {
      throw new DynamoDBMappingException("Failed to process update operation inside transactionWrite request due to an IOException ", e);
    }
    Adler32 adler32 = new Adler32();
    adler32.update(byteArrayOutputStream.toByteArray());
    return Long.toHexString(adler32.getValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.UpdateExpressionGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */