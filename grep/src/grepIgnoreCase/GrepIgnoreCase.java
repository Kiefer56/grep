/*********************************************************
 * Name: Robert Griffin
 * Assignment 10
 * Due Date: 04/19/18
 * IT2045C/002/Spring
 * Sources
 * Description
 */
package grepIgnoreCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrepIgnoreCase
{
	public static void grepIgnoreCase(String filePath, String searchString, boolean recurse) throws IOException 
	{
		Path myPath = Paths.get(filePath);
		try (Stream<Path> entries = Files.list(myPath))
		{
			List<Path> paths = entries.collect(Collectors.toList());
			for (Path path : paths)
			{
				File myFile = new File(path.toString());
				if (myFile.isDirectory())
				{
					if (recurse) 
					{
						grepIgnoreCase(myFile.toString(), searchString, true);
					}
				} 
				else
				{
				    scanIgnoreCase(myFile, searchString);
				}
			}
		}
	}
	
	private static void scanIgnoreCase(File file, String searchString) throws IOException 
	{
	    String newSearchString = searchString.toLowerCase();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String buffer;
		int line = 1;
		while ((buffer = br.readLine()) != null)
		{
			String newBuffer = buffer.toLowerCase();
			if (newBuffer.contains(newSearchString))
			{
				System.out.println(searchString + " detected as " + buffer + " at line " + line + " in " + file.toString());
			}
			line++;
		}
		br.close();
	}
}