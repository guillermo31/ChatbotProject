package chat.controller;

import javax.swing.JOptionPane;

public class ChatController
{
	public ChatController()
	{
		
	}
	
	public void start()
	{	
		
		String userInput = " ";
		while(!userInput.equalsIgnoreCase("quit")) 
		{
			userInput = JOptionPane.showInputDialog(null, "type 'quit' to exit ");
		}
		
		
		interactWithChatBot();
	}
	
	public String interactWithChatBot()
	{
		return " ";
	}
	
	

}
