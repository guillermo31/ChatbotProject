package chat.controller;

import chat.model.Chatbot;
import chat.model.ChatTwitter;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.ArrayList;
import chat.view.*;

public class ChatController
{
	private Chatbot firstChatBot;
	private ChatFrame appFrame;
	private ChatPanel appPanel;
	private ChatTwitter myTwitter;

	public ChatController()
	{
		firstChatBot = new Chatbot("chingon");
		myTwitter = new ChatTwitter(this);
		this.appFrame = new ChatFrame(this);
	}
	

	public void start()
	{
		// method calls
		interactWithChatbot("");

		// exit loop

	}

	public void exitLoop()
	{
		String keepChatting = JOptionPane.showInputDialog(null, "Do you want to keep chatting?");
		if (keepChatting.equals("yes"))
		{
			interactWithChatbot("");
		}
		else if (keepChatting.equals("no"))
		{
			String userInput = " ";
			while (!userInput.equalsIgnoreCase("quit"))
			{
				userInput = JOptionPane.showInputDialog(null, "type 'quit' to exit ");
				if (userInput.equals("quit"))
				{
					System.exit(0);
				}
			}

		}
	}

	public String interactWithChatbot(String chatbotSays)
	{

		// setting user's name
//		chatbotSays = JOptionPane.showInputDialog(null, "Hi! First things first, what is your name?");
//		firstChatBot.setCurrentUser(chatbotSays);
//		JOptionPane.showMessageDialog(null, firstChatBot.processText(chatbotSays));

		// while loop for input
//		String firstInput = JOptionPane.showInputDialog(null, chatbotSays + ", what do you want to talk about?");
//		JOptionPane.showMessageDialog(null, firstChatBot.processText(firstInput));
//		while (firstChatBot.legitimacyChecker(firstInput))
//		{
//			firstInput = JOptionPane.showInputDialog(null, chatbotSays + ", what do you want to talk about?");
//			JOptionPane.showMessageDialog(null, firstChatBot.processText(firstInput));
//			if (chatbotSays == null)
//			{
//				chatbotSays = JOptionPane.showInputDialog(null, "There is null");
//			}
//
//			if (chatbotSays.equals(""))
//			{
//				chatbotSays = JOptionPane.showInputDialog(null, "This is just blank bro");
//			}
//
//			if (firstInput.contains("talk anymore"))
//			{
//				exitLoop();
//			}
//
//		}
		chatbotSays = "Hi! First things first, what is your name?";
		firstChatBot.setCurrentUser(chatbotSays);
//		chatbotSays =  firstChatBot.getCurrentUser() + ", what do you want to talk about";
		firstChatBot.processText(chatbotSays);
//		String firstInput = chatbotSays + ", what do you want to talk about?";
//		firstChatBot.processText(firstInput);
//		
//		while (firstChatBot.legitimacyChecker(firstInput))
//		{
//			firstInput = chatbotSays + ", what do you want to talk about?";
//			firstChatBot.processText(firstInput);
//			if (chatbotSays == null)
//			{
//				chatbotSays = "There is null";
//			}
//
//			if (chatbotSays.equals(""))
//			{
//				chatbotSays = "This is just blank bro";
//			}
//
//			if (firstInput.contains("talk anymore"))
//			{
//				exitLoop();
//			}
//
//		}


		return chatbotSays;
	}
	public void handleErrors(Exception error)
	{
		JOptionPane.showMessageDialog(appFrame, error.getMessage());
	}
	
	public String useChatbotCheckers(String spooky)
	{

		return spooky;

	}

	public Chatbot getChatbot()
	{
		return firstChatBot;
	}
	
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
	
	public String findWords(String user)
	{
		String results = myTwitter.getMostCommonWord(user);
		return results;
	}

}
