package chat.model;
import java.util.ArrayList;
 

public class Chatbot
{
	//data members
	private String currentUser;
	private String joke;
	private String content;
	
	private ArrayList<String> responseList;
	private ArrayList<String> spookyList;
	
	//constructors
	public Chatbot()
	{
		
	}
	
	public Chatbot(String currentUser, String joke, String content) 
	{
		this.currentUser = currentUser;
		this.joke = joke;
		this.content = content;
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		
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
		
		spookyList.add("i hate christmas, halloween is way spookier");
		spookyList.add("i am not scary");
		spookyList.add("please remember to make your costume appropiately spooky");
		
	}
	
	public String processText(String userText)
	{
		String output = " ";
		
		
		output += currentUser + " said: " + userText;
		
		return output;
	}
	
	
	
	
	
	
}
