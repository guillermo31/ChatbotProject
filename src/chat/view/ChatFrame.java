package chat.view;

import chat.controller.ChatController;
import chat.view.ChatPanel;
import javax.swing.*;

public class ChatFrame extends JFrame
{
	private ChatController appController;
	private ChatPanel appPanel;
	
	public ChatFrame(ChatController appController)
	{
		super();
		this.appController = appController;
		this.appPanel = new ChatPanel(appController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setSize(1024, 768);
		this.setTitle("Chatbot & Twitter");
		this.setResizable(false);
		this.setVisible(true);
	}
}
