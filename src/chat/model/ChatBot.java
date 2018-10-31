package chat.model;
import java.util.ArrayList;
 

public class Chatbot
{
	//data members
	private String currentUser;
	private String joke;
	private String content;
	
	private ArrayList<String> responseList = new ArrayList<String>();
	private ArrayList<String> spookyList = new ArrayList<String>();
	
	//constructors
	public Chatbot()
	{
		
	}
	
	public Chatbot(String currentUser, String joke, String content, ArrayList<String> responseList, ArrayList<String> spookyList) 
	{
		this.currentUser = currentUser;
		this.joke = joke;
		this.content = content;
		this.responseList = responseList;
		this.spookyList = spookyList;
		
		buildLists();
		
	}
	
	//getters
	
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
	
	//setters
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
	
	//methods
	
	private void buildLists()
	{
		responseList.add("hello! what's up?");
		responseList.add("See ya");
		responseList.add("NO WAY tell me more...");
		responseList.add("are you for real???");
		responseList.add("you're cool");
		responseList.add("you should not say that");
		responseList.add("you're weird");
		responseList.add("ummm ok");
		
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
		
		if(input == null)
		{
			isValid = false;
		}else if(input.equals(""))
		{
			isValid = false;
		}else if(input.equals("asdfghjkl"))
		{
			isValid = false;
		}else if(input.length() > 1)
		{
			isValid = true;
		}
		
		
		return isValid;
	}
	
	public boolean spookyChecker(String input)
	{
		boolean isSpooky = false;
		
		if(input.contains("Halloween"))
		{
			isSpooky = true;
		}
		
		for(String spookyPhrase : spookyList)
		{
			if(spookyPhrase.contains(input))
			{
				isSpooky = true;
			}else
			{
				isSpooky = false;
			}
		}
		return isSpooky;
	}
	
	public String processText(String userText)
	{
		String output = " ";
		
		
		output += currentUser + " said: " + userText;
		
		return output;
	}
	
	
	
	
	
	
}
