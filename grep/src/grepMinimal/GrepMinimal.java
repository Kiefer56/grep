/*********************************************************
 * Name: Robert Griffin
 * Assignment 10
 * Due Date: 04/19/18
 * IT2045C/002/Spring
 * Sources
 * Description
 */
package grepMinimal;

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

public class GrepMinimal 
{
	public static void grepMinimal(String filePath, String searchString, boolean recurse) throws IOException 
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
						grepMinimal(myFile.toString(), searchString, true);
					}
				} 
				else
				{
				    scanMinimal(myFile, searchString);
				}
			}
		}
	}
	
	private static void scanMinimal(File file, String searchString) throws IOException 
	{
	    FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String buffer;
		int line = 1;
		while ((buffer = br.readLine()) != null)
		{
			if (buffer.contains(searchString))
			{
				System.out.println(searchString + " detected at line " + line + " in " + file.toString());
			}
			line++;
		}
		br.close();
	}
}