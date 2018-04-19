# grep
This my Eclipse project that consist of 3 modified grep classes with their own respective scan class. GrepMinimal is a minimalist version of grep that just displayes the word it was looking for, what what file it found it in, and at what line. GrepIgnoreCase does the same thing except for ignores case in the search string. AntiGrep displays every line of every file the does not contain the search string. 

On the main, You will need to change the filepath depending one where you put the text files. I have included a folder of textfiles to use as an example to show how the modifed grep classes work. 
To use Grep Minimal, in the main type: GrepMinimal.grepMinimal("{{Insert file path here}}", "{{Insert search string here}}", true);
To use Grep Ignore Case, in the main type: GrepIgnoreCase.grepIgnoreCase("{{Insert file path here}}", "{{Insert search string here}}", true);
To use Anti Grep, in the main type: AntiGrep.antiGrep("{{Insert file path here}}", "{{Insert search string here}}", true);
