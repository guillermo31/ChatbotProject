package chat.controller;
import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class IOController 
{
	public static void saveText(ChatController app, String path, String textToSave)
	{
		try 
		{
			//Created a variable that gets the path of the file 
			String fileName = path;
			Calendar date = Calendar.getInstance();
			//Added the date to the file's path
			fileName += "/" + date.get(Calendar.MONTH) + " " + date.get(Calendar.DAY_OF_MONTH);
			fileName += "/" + date.get(Calendar.HOUR) + " " + date.get(Calendar.MINUTE);
			fileName += " chabot save.txt";
			
			//Created an instance of File
			File saveFile = new File(fileName);
			//Initialized scanner 
			Scanner textScanner = new Scanner(textToSave);
			//Created instance of PrintWriter
			PrintWriter saveText = new PrintWriter(saveFile);
			while(textScanner.hasNext())
			{
				String currentLine = textScanner.nextLine();
				saveText.println(currentLine);
			}
			
			textScanner.close();
			saveText.close();
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		catch(Exception genericError) 
		{
			app.handleErrors(genericError);
			
		}
		
	}
	
	public static String loadFile(ChatController app, String path)
	{
		String contents = "";
		
		try 
		{
			File saveFile = new File(path);
			Scanner fileScanner;
			if(saveFile.exists())
			{
				fileScanner = new Scanner(saveFile);
				while(fileScanner.hasNext())
				{
					contents += fileScanner.nextLine() + "\n";
				}
				fileScanner.close();
			}
		}
		catch(IOException error)
		{
			app.handleErrors(error);
			
		}
		catch(Exception genericError) 
		{
			app.handleErrors(genericError);
			
		}
		return contents;
	}
	
	
	
}
