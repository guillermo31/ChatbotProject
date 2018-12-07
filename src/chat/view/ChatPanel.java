package chat.view;

import java.awt.*;

import javax.swing.*;

import chat.controller.ChatController;

public class ChatPanel 
{

	private ChatController appController;
	
	
	private SpringLayout appLayout;
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		
		appLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel() 
	{
		this.setLayout(appLayout);
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
