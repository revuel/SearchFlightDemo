package com.lastminute;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public final class CsvFiles
{
  private CsvFiles()
  {
  }

  public static List<List<String>> readAllRecords(String fileName) throws Exception
  {
    try (Stream<List<String>> records = records(fileName))
    {
      return records.collect(toList());
    }
  }

  public static Stream<List<String>> records(String fileName) throws Exception
  {
    return splitByCommaIgnoringHeader(linesOf(fileName));
  }

  private static Stream<List<String>> splitByCommaIgnoringHeader(Stream<String> lines)
  {
    return lines.skip(1)
                .map(line -> line.split(","))
                .map(Arrays::asList);
  }

  private static Stream<String> linesOf(String fileName) throws Exception
  {
    try
    {
      return new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName))).lines();
      // return Files.lines(Paths.get(fileName));
    } catch (Exception e) {
      throw new Exception("Exception: " + e);
    }
    /*catch (IOException e)
    {
      throw new UncheckedIOException("IO error accessing the CSV file " + fileName, e);
    }*/
  }
}
