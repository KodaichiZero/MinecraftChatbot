package org.matecraft.kodaichi.MinecraftChatbot;

import java.util.ArrayList;
import java.util.Date;

import net.md_5.bungee.api.ChatColor;

public class ChatbotHelper {
	private ChatbotPlugin plugin;
	
	public ChatbotHelper(ChatbotPlugin plugin) {
		this.plugin = plugin;
	}
	
	//===========
	// CONSTANTS
	//===========
	private static String errorText = ChatColor.RED.toString();
	
	private static String[] illegalNames = {"config"};
	private static int minNameLength = 3;
	private static int maxNameLength = 16;
	
	//Creates a new bot, returns null if there is an error.
	public Bot createBot(String newName, ArrayList<String> errors) {
		//Check to see if the name matches constraints.
		if(newName.length() < minNameLength || newName.length() > maxNameLength) {
			errors.add(errorText + "Error: The bot's name needs to be between " + minNameLength + " and " + minNameLength + " characters.");
			return null;
		}
		for(String illegalName : illegalNames) {
			if(newName.equalsIgnoreCase(illegalName)) {
				errors.add(errorText + "Error: The bot can't be named \"" + illegalName + "\".");
				return null;
			}
		}
		
		//Make sure there are no bots with the same name.
		ArrayList<Bot> existingBots = plugin.getBots();
		for(Bot bot : existingBots) {
			if(bot.getName().equalsIgnoreCase(newName)) {
				errors.add(errorText + "Error: A bot named \"" + bot.getName() + "\" already exists.");
				return null;
			}
		}
		
		//Create the bot.
		Bot newBot = new Bot(newName, currentTime());
		return newBot;
	}
	
	//Get the current time in milliseconds.
	public long currentTime() {
		return new Date().getTime();
	}
}
