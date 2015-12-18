package org.matecraft.kodaichi.MinecraftChatbot;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

public class ChatbotPlugin extends JavaPlugin {
	
	//Lists
	private ArrayList<Bot> BOTS;
	private ArrayList<String> SWEARS;
	
	//References
	private ChatbotHelper helper;
	
	@Override
	public void onEnable() {
		BOTS = new ArrayList<Bot>();
		SWEARS = new ArrayList<String>();
		helper = new ChatbotHelper(this);
	}
	
	//Returns a copy of the bot array.
	@SuppressWarnings("unchecked")
	public ArrayList<Bot> getBots() {
		return (ArrayList<Bot>) BOTS.clone();
	}
	
	//Returns a copy of the swears array.
	@SuppressWarnings("unchecked")
	public ArrayList<String> getSwears() {
		return (ArrayList<String>) SWEARS.clone();
	}
}
