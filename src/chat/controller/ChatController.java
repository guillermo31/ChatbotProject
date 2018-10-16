package chat.controller;
import chat.model.ChatBot;
import javax.swing.JOptionPane;

public class ChatController
{ 
	private ChatBot firstChatBot;
	
	private String userJoke;
	private String userContent;
	private String userCurrent;
	
	public ChatController()
	{
		firstChatBot = new ChatBot(userCurrent, userJoke, userContent);
	}
	
	public void start()
	{	
		//method calls
		interactWithChatBot();
		JOptionPane.showMessageDialog(null, firstChatBot);
		
		//exit loop
		String keepChatting = JOptionPane.showInputDialog(null, "Do you want to keep chatting?");
		if (keepChatting.equals("yes")) 
		{
			interactWithChatBot();
		}else if (keepChatting.equals("no"))
		{
			String userInput = " ";
			while(!userInput.equalsIgnoreCase("quit")) 
			{
				userInput = JOptionPane.showInputDialog(null, "type 'quit' to exit ");
			}
			
		}
		
	}
	
	public void interactWithChatBot()
	{	
		String currentUser = JOptionPane.showInputDialog(null, "Hi! First things first, what is your name?");
		firstChatBot.setCurrentUser(currentUser);

	
	}
	
	

}
