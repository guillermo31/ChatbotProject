package chat.controller;
import chat.model.Chatbot;
import javax.swing.JOptionPane;

public class ChatController
{ 
	private Chatbot firstChatBot;
	
	private String userJoke;
	private String userContent;
	private String userCurrent;
	
	public ChatController()
	{
		firstChatBot = new Chatbot(userCurrent, userJoke, userContent);
	}
	
	public void start()
	{	
		//method calls
		interactWithChatBot("");
		
		//exit loop
		String keepChatting = JOptionPane.showInputDialog(null, "Do you want to keep chatting?");
		if (keepChatting.equals("yes")) 
		{
			interactWithChatBot("");
		}else if (keepChatting.equals("no"))
		{
			String userInput = " ";
			while(!userInput.equalsIgnoreCase("quit")) 
			{
				userInput = JOptionPane.showInputDialog(null, "type 'quit' to exit ");
			}
			
		}
		
	}
	
	public void interactWithChatBot(String chatbotSays)
	{	
		String currentUser = JOptionPane.showInputDialog(null, "Hi! First things first, what is your name?");
		firstChatBot.setCurrentUser(currentUser);
		
		String userInput = JOptionPane.showInputDialog(null, currentUser + ", what do you want to talk about?");
		chatbotSays = firstChatBot.processText(userInput);
		
	}
	
	public String useChatbotCheckers(String spooky)
	{	
		return spooky;
		
	}
	
	public Chatbot getChatbot()
	{
		return firstChatBot;
	}

}
