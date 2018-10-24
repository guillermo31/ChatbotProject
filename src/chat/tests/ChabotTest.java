package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chat.model.Chatbot;

public class ChabotTest
{
	private Chatbot testedBot;

	@Before
	public void setUp() throws Exception
	{
		testedBot = new Chatbot();
		
	}

	@After
	public void tearDown() throws Exception
	{
		testedBot = null;
	}

	@Test
	public void testChatbot()
	{
		assertNotNull("You need to initialize the content data member", testedBot.getContent() );
		assertNotNull("ArrayLists need to be initialized too", testedBot.getSpookyList());
		assertNotNull("ArrayLists need to be initialized too", testedBot.getResponseList());
		assertNotNull("Current user data member needs to be initialized", testedBot.getCurrentUser());
	}

	@Test
	public void testProcessText()
	{
		String sampleText = "What is the meaning of life?";
		assertNotNull("Even null data should not return null", testedBot.processText(null));
		assertNotNull("Empty text should not return null", testedBot.processText(""));
		assertNotNull("Random text should not return null", testedBot.processText("dsfkjadsjkghakjs"));
		assertTrue("The empty String should not be returned", testedBot.processText(null).length() > 0 );
		assertTrue("The empty String still should not be returned", testedBot.processText("").length() > 0);
		assertTrue("The text you supply should be prefixed with \"You said: \" ", testedBot.processText("").contains("You said: "));
		assertTrue("The text you supply should be prefixed with \"You said: \" ", testedBot.processText(sampleText).contains("You said: "));
		assertTrue("The text returned should indicate what the chatbot says with \"Chatbot says: \"", testedBot.processText(sampleText).contains("Chatbot says: "));
		String response = testedBot.processText(sampleText);
		assertTrue("The chatbot content should be after your content", response.indexOf("You said:") < response.indexOf("Chatbot says: "));
	}

	@Test
	public void testChatbotString()
	{
		testedBot = new Chatbot("sample content");
		assertTrue("String constructor needs to assign to the content variable", testedBot.getContent().equals("sample content"));
	}

	@Test
	public void testSpookyChecker()
	{
		assertTrue("Halloween should return true", testedBot.spookyChecker("Halloween"));
		for (String phrase : testedBot.getSpookyList())
		{
			assertTrue("Every item in the spookyList should pass the spookyChecker method", testedBot.spookyChecker(phrase));
		}
		assertFalse("Easter should return false", testedBot.spookyChecker("Easter"));
	}
	
	
	@Test
	public void testLegitimacyChecker()
	{
		assertFalse("Null should return false", testedBot.legitimacyChecker(null));
		assertFalse("Empty string should return false", testedBot.legitimacyChecker(""));
		assertFalse("Keyboard mash should return false", testedBot.legitimacyChecker("asdfghjkl"));
		assertTrue("Strings more than 1 letter should return true", testedBot.legitimacyChecker("aa"));
	}

	@Test
	public void testContentChecker()
	{
		assertTrue("The content checker should definitly find the value", testedBot.contentChecker(testedBot.getContent()));
		assertFalse("The content in middle of another word is NOT the special content", testedBot.contentChecker("text" + testedBot.getContent() + "text"));
		assertFalse("The content after another word is NOT the special content", testedBot.contentChecker("text" + testedBot.getContent()));
		assertFalse("The content in front of another word is NOT the special content", testedBot.contentChecker(testedBot.getContent() + "text"));
		assertTrue("If the content is sent to the chatbot via process text it should be noted", testedBot.processText(testedBot.getContent()).contains("You said the special words"));
	}

	@Test
	public void testGetSpookyList()
	{
		 assertNotNull("You really need to initialize the spookyList", testedBot.getSpookyList());
		 assertTrue("You need to have more than 8 items in the spookyList", testedBot.getSpookyList().size() > 8);
		 assertTrue("The first item in your list has to mention Halloween", testedBot.getSpookyList().get(0).contains("Halloween"));
	}
	
	@Test
	public void testGetResponseList()
	{
		 assertNotNull("You really need to initialize the responseList", testedBot.getResponseList());
		 assertTrue("You need to have more than 15 items in the repsonseList", testedBot.getResponseList().size() > 15);
		 assertTrue("The first item in your list has to mention Hello", testedBot.getResponseList().get(0).contains("Hello"));
	}

	@Test
	public void testBuildLists()
	{
		assertTrue("The responseList is not properly built by the constructor", testedBot.getResponseList().size() > 15);
		assertTrue("The spookyList is not properly built by the constructor", testedBot.getSpookyList().size() > 8);
	}

}
