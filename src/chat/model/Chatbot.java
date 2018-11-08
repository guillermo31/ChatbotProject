package chat.model;

import java.util.ArrayList;

public class Chatbot
{
	// data members
	private String currentUser;
	private String joke;
	private String content;

	private ArrayList<String> responseList = new ArrayList<String>();
	private ArrayList<String> spookyList = new ArrayList<String>();

	// constructors

	public Chatbot()
	{
		this.currentUser = "guillermo";
		this.joke = "you";
		this.content = "hi there ";
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();

		buildLists();

	}

	public Chatbot(String content)
	{
		this.content = content;
	}

	// getters

	public String getCurrentUser()
	{
		return currentUser;
	}

	public String getJoke()
	{
		return joke;
	}

	public String getContent()
	{
		return content;
	}

	public ArrayList<String> getResponseList()
	{
		return responseList;
	}

	public ArrayList<String> getSpookyList()
	{
		return spookyList;
	}

	// setters
	public void setCurrentUser(String user)
	{
		this.currentUser = user;
	}

	public void setJoke(String joke)
	{
		this.joke = joke;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public void setResponseList(ArrayList<String> responses)
	{
		this.responseList = responses;
	}

	public void setSpookyList(ArrayList<String> spooky)
	{
		this.spookyList = spooky;
	}

	// methods

	private void buildLists()
	{
		responseList.add("Hello what's up?");
		responseList.add("See ya");
		responseList.add("NO WAY tell me more...");
		responseList.add("are you for real???");
		responseList.add("you're cool");
		responseList.add("you should not say that");
		responseList.add("you're weird");
		responseList.add("ummm ok");
		responseList.add("are you for sure?");
		responseList.add("I don't like that.");
		responseList.add("how was your day?");
		responseList.add("You're funny");
		responseList.add("hahaha");
		responseList.add("lol");
		responseList.add("do you do any sports?");
		responseList.add("tell me a joke");
		responseList.add("that was definitely NOT funny");

		spookyList.add("Halloween");
		spookyList.add("i hate christmas, halloween is way spookier");
		spookyList.add("i am not scary");
		spookyList.add("please remember to make your costume appropiately spooky");
		spookyList.add("i am not scary");
		spookyList.add("boo");
		spookyList.add("you are scary");
		spookyList.add("halloween is definintely the best holiday");
		spookyList.add("you're never too old to be spooky");
		spookyList.add("you're never too old to be spooky");
		spookyList.add("are you scared?");

	}

	public boolean legitimacyChecker(String input)
	{
		boolean isValid = true;

		if (input == null)
		{
			isValid = false;
		}
		else if (input.equals(""))
		{
			isValid = false;
		}
		else if (input.equals("asdfghjkl"))
		{
			isValid = false;
		}
		else if (input.length() > 1)
		{
			isValid = true;
		}

		return isValid;
	}

	public boolean spookyChecker(String content)
	{
		boolean isSpooky = false;

		if (content == null)
		{
			isSpooky = false;

		}
		else if (content.contains("Halloween"))
		{
			isSpooky = true;
		}
		else if (content.contains("halloween"))
		{
			isSpooky = true;
		}

		for (String spookyPhrase : spookyList)
		{
			if (content == null)
			{
				isSpooky = false;
			}
			else if (content.contains(spookyPhrase))
			{
				isSpooky = true;
			}

		}

		return isSpooky;
	}

	public boolean contentChecker(String input)
	{
		String specialContent = this.content;

		boolean hasSpecialContent = false;

		if (input == null)
		{
			hasSpecialContent = false;
		}
		else if (input.equals(specialContent))
		{
			hasSpecialContent = true;
		}
		else if (input.contains(specialContent + " "))
		{
			hasSpecialContent = true;
		}
		else if (input.contains(" " + specialContent))
		{
			hasSpecialContent = true;
		}

		return hasSpecialContent;
	}

	public String processText(String userText)
	{
		String output;
		int randomIndex = (int)(Math.random()*responseList.size());
		output = "You said: " + userText;
		output += "\n Chatbot says: " + responseList.get(randomIndex);

		if (spookyChecker(userText))
		{
			output += "\n You are spooky! ";
		}
		else if (userText == null)
		{
			output += "your input was null";
		}

		if (legitimacyChecker(userText))
		{
			output += "\n Your text is legit! ";
		}
		else
		{
			output += "your input was null or invalid";
		}

		if (contentChecker(userText))
		{
			output += "\n You said the special words ";
		}
		else if (userText == null)
		{
			output += "your input was null";
		}

		return output;
	}

}
