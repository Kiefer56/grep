/*********************************************************
 * Name: Robert Griffin
 * Assignment 10
 * Due Date: 04/19/18
 * IT2045C/002/Spring
 * Sources
 * Description
 */
package antiGrep;

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

public class AntiGrep
{
	public static void antiGrep(String filePath, String searchString, boolean recurse) throws IOException 
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
						antiGrep(myFile.toString(), searchString, true);
					}
				} 
				else
				{
				    antiScan(myFile, searchString);
				}
			}
		}
	}
	
	public static void antiScan(File file, String searchString) throws IOException 
	{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String buffer;
		int line = 1;
		int firstUnmatch = 1;
		while ((buffer = br.readLine()) != null)
		{
			if (buffer.contains(searchString))
			{
				;
			}
			else
			{
				if (firstUnmatch == 1)
				{
					System.out.print("No matches found in " + file + " at line(s) " + line);
					firstUnmatch = 0;
				}
				else
				{
					System.out.print(", " + line);
				}
			}
			line++;
		}
		System.out.println();
		br.close();
	}
}
