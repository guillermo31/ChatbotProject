package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chat.controller.ChatController;
import chat.view.ChatFrame;
import chat.view.ChatPanel;

public class FrameTest
{
	ChatFrame testedFrame;
	
	@Before
	public void setUp() throws Exception
	{
		testedFrame = new ChatFrame(new ChatController());
	}

	@After
	public void tearDown() throws Exception
	{
		testedFrame = null;
	}

	@Test
	public void testChatFrame()
	{
		assertTrue("ChatFrame needs to have a ChatPanel inside", testedFrame.getContentPane() instanceof ChatPanel);
		assertTrue("ChatFrame's title needs more than three letters", testedFrame.getTitle().length() > 3);
	}

}
