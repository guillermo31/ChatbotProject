package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chat.controller.ChatController;

public class ControllerTest
{

	private ChatController testController;
	@Before
	public void setUp() throws Exception
	{
		testController = new ChatController();
	}

	@After
	public void tearDown() throws Exception
	{
		testController = null;
	}

	@Test
	public void testChatController()
	{
		assertNotNull("Chatbot data member not initialized", testController.getChatbot());
	}

	@Test
	public void testInteractWithChatbot()
	{
		assertNotNull("Stub method used, implement with code", testController.interactWithChatbot(""));
		assertNotNull("Null should not ever be returned", testController.interactWithChatbot(null));
		assertTrue("If null is supplied user should be notified about it", testController.interactWithChatbot(null).toLowerCase().contains("null"));
	}

	@Test
	public void testUseChatbotCheckers()
	{
		assertTrue("Spooky tester method not implemented", testController.useChatbotCheckers("spooky").contains("Halloween"));
	}

	@Test
	public void testGetChatbot()
	{
		assertNotNull("Chatbot data member not initialized", testController.getChatbot());
	}

}
