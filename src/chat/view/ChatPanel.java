package chat.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import chat.controller.ChatController;
import chat.controller.IOController;

public class ChatPanel extends JPanel
{
	private JTextField chatField;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton loadingButton;
	private JButton savingButton;
	private SpringLayout appLayout;
	private ChatController appController;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JButton resetButton;
	
	public ChatPanel(ChatController appController)
	{
		super();
		
		this.appController = appController;
		appLayout = new SpringLayout();
		
		
		
//		this.appController = appController;
//		appLayout = new SpringLayout();
//		
//		savingButton = new JButton("Save");
//		loadingButton = new JButton("Load");
//		chatButton = new JButton("Chat");
//		checkerButton = new JButton("Check Text");
//		
//		chatField = new JTextField("Talk to the bot here", 50);
//		chatArea = new JTextArea("Chat Area", 20, 50);
//		
//		chatPane = new JScrollPane();
		setupLayout();
		setupScrollPane();
		setupPanel();
		setupListeners();
	}
	
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.GREEN);
		this.add(chatPane);
		this.add(chatButton);
		this.add(savingButton);
		this.add(loadingButton);
		this.add(checkerButton);
		this.add(chatField);
		
	}
	
	
	
	private void setupScrollPane()
	{
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = chatField.getText();
				String response = "";
				response = appController.interactWithChatbot(userText);
				chatArea.append(response);
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
				chatField.setText("");
			}
		});
		
		savingButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String chatText = chatArea.getText();
						String path = "~/Documents";
						IOController.saveText(appController, path, chatText);
						chatArea.setText("Chat saved!");
					}
						
				});
		
		loadingButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent click)
					{
						
					}
				});
		
		checkerButton.addActionListener(new ActionListener()  
				{
					public void actionPerformed(ActionEvent click)
					{
						
					}
				
				});
		
	}
	
	private void setupLayout()
	{
		savingButton = new JButton("Save");
		appLayout.putConstraint(SpringLayout.WEST, savingButton, 405, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, savingButton, -71, SpringLayout.SOUTH, this);
		
		loadingButton = new JButton("Load");
		appLayout.putConstraint(SpringLayout.SOUTH, loadingButton, -71, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, loadingButton, -15, SpringLayout.WEST, savingButton);
		
		chatButton = new JButton("Chat");
		appLayout.putConstraint(SpringLayout.NORTH, loadingButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, loadingButton, 15, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 210, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 50, SpringLayout.WEST, this);
		
		checkerButton = new JButton("Check Text");
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -71, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, savingButton, -19, SpringLayout.WEST, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 584, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, -50, SpringLayout.EAST, this);
		
		chatField = new JTextField("Talk to the bot here", 50);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 25, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, savingButton, 25, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 25, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, 99, SpringLayout.SOUTH, chatField);
		chatArea = new JTextArea("Chat Area", 20, 50);
		
		chatPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 30, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
	}
	
}
