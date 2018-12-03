package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import gui.controller.GUIController;

public class ChatPanel 
{

private GUIController appController;
	
	private JButton colorButton;
	private JLabel textLabel;
	private SpringLayout appLayout;
	
	public FirstPanel(GUIController appController)
	{
		super();
		this.appController = appController;
		
		colorButton = new JButton("Click to change the color");
		textLabel = new JLabel("This is a color app");
		appLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel() 
	{
		this.setLayout(appLayout);
		this.add(textLabel);
		this.add(colorButton);
		this.setBackground(Color.ORANGE);
		
		
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, colorButton, 75, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, colorButton, -70, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, textLabel, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, textLabel, 160, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, colorButton, 46, SpringLayout.NORTH, this);
		
		JLabel lblNewLabel = new JLabel("New label");
		appLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 65, SpringLayout.SOUTH, colorButton);
		appLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 28, SpringLayout.WEST, textLabel);
		appLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -165, SpringLayout.EAST, this);
		add(lblNewLabel);
	}
	
	private void setupListeners()
	{
		colorButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent mouseClick)
					{
						changeBackgroundColor();
					}
				});
	}
}
