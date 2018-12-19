package chat.tests;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.FlowLayout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chat.controller.ChatController;
import chat.view.ChatPanel;
import javax.swing.*;


public class PanelTest
{
	ChatPanel testedPanel;

	@Before
	public void setUp() throws Exception
	{
		testedPanel = new ChatPanel(new ChatController());
	}

	@After
	public void tearDown() throws Exception
	{
		testedPanel = null;
	}

	@Test
	public void testChatPanel()
	{
		assertNotNull("ChatPanel needs a valid Layout", testedPanel.getLayout());
		assertFalse("ChatPanel needs a SpringLayout", testedPanel.getLayout() instanceof FlowLayout);
		assertTrue("ChatPanel needs a SpringLayout", testedPanel.getLayout() instanceof SpringLayout);
		assertTrue("ChatPanel needs more than 6 GUI components", testedPanel.getComponents().length >= 5);
		for(Component current : testedPanel.getComponents())
		{
			if (current instanceof JButton)
			{
				JButton testedButton = (JButton) current;
				assertNotNull("Each button must have an ActionListener", testedButton.getActionListeners());
			}
			if (current instanceof JScrollPane)
			{
				JScrollPane testedPane = (JScrollPane) current;
				assertTrue("The chatPane should hold the chatArea", testedPane.getViewport().getView() instanceof JTextArea);
				assertTrue("Vertical ScrollPane policy is as needed", testedPane.getVerticalScrollBarPolicy() == JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				JTextArea testedArea = (JTextArea) testedPane.getViewport().getView();
				assertFalse("The chatArea should not be editable", testedArea.isEditable());
			}
		}
	}

}
