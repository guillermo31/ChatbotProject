package chat.controller;
import chat.model.Chatbot;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ChatController
{ 
	private Chatbot firstChatBot;
	
	private String userJoke;
	private String userContent;
	private String userCurrent;
	private ArrayList<String> firstList = new ArrayList<String>();
	private ArrayList<String> firstSpooky = new ArrayList<String>();

	
	public ChatController()
	{
		firstChatBot = new Chatbot();
	}
	
	public void start()
	{	
		//method calls
		interactWithChatbot("");
		
		
		//exit loop
		String keepChatting = JOptionPane.showInputDialog(null, "Do you want to keep chatting?");
		if (keepChatting.equals("yes")) 
		{
			interactWithChatbot("");
		}else if (keepChatting.equals("no"))
		{
			String userInput = " ";
			while(!userInput.equalsIgnoreCase("quit")) 
			{
				userInput = JOptionPane.showInputDialog(null, "type 'quit' to exit ");
			}
			
		}
		
	}
	
	public void interactWithChatbot(String chatbotSays)
	{	
		//setting user's name
		String currentUser = JOptionPane.showInputDialog(null, "Hi! First things first, what is your name?");
		firstChatBot.setCurrentUser(currentUser);
		JOptionPane.showMessageDialog(null, firstChatBot.processText(currentUser));
		
		//while loop for input
		String firstInput = JOptionPane.showInputDialog(null, currentUser + ", what do you want to talk about?");
		JOptionPane.showMessageDialog(null, firstChatBot.processText(firstInput));
		while(firstChatBot.legitimacyChecker(firstInput)) 
		{
			firstInput = JOptionPane.showInputDialog(null, currentUser + ", what do you want to talk about?");
			JOptionPane.showMessageDialog(null, firstChatBot.processText(firstInput));
			if(firstInput.contains("talk anymore"))
			{
				break;
			}

		}
			
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
