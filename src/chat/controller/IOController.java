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
			fileName += Calendar.MONTH + " " + Calendar.DAY_OF_MONTH;
			fileName += " chat save.txt";
		}
		catch(IOException error)
		{
			
		}
		catch(Exception error) 
		{
			
		}
		
	}
}
