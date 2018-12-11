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
			String fileName = path;
			Calendar date = Calendar.getInstance();
			fileName += "/" + date.get(Calendar.MONTH) + " " + date.get(Calendar.DAY_OF_MONTH);
			fileName += " chabot save.txt";
			
			File saveFile = new File(fileName);
			Scanner textScanner = new Scanner(textToSave);
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
			
		}
		catch(Exception error) 
		{
			
		}
		
	}
}
