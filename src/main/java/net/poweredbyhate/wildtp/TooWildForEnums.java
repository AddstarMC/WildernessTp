package net.poweredbyhate.wildtp;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Lol, Gotcha qball! Stop stealin our code!
 */
public class TooWildForEnums {

    public static String NO_PERMS;
    public static String NO_SIGN_PERMS;
    public static String NO_BREAK;
    public static String NO_LOCATION;
    public static String NO_BIOME;
    public static String NO_MONEY;
    public static String YES_SIGN;
    public static String BREAK_SIGN;
    public static String COOLDOWN;
    public static String RELOADED;
    public static String WAIT_MSG;
    public static String DIDNT_WAIT;
    public static String NO_WE;

    File langFile;
    FileConfiguration langConf;

    public void loadConfig() {
        langFile = new File(WildTP.instace.getDataFolder(), "Messages.yml");
        langConf = new YamlConfiguration();
        if (!langFile.exists()) {
            try {
                langFile.createNewFile();
                langConf.load(langFile);
                langConf.set("NO_PERMS", "&4You do not have permission!");
                langConf.set("NO_SIGN_PERMS", "&4You do not have permission to make a wild sign");
                langConf.set("NO_BREAK", "&4Hey! You can not break WildTp sign!");
                langConf.set("NO_LOCATION", "&4No suitable locations found.");
                langConf.set("NO_BIOME", "&4You may not put signs in %BIOME%");
                langConf.set("YES_SIGN", "&aSuccessfully made a new WildTP sign");
                langConf.set("BREAK_SIGN", "&aYou have broken a WildTP sign");
		        langConf.set("COOLDOWN", "&4You must wait %TIME% seconds until you can use the command/sign again");
                langConf.set("RELOADED", "&aPlugin config has successfuly been reloaded.");
                langConf.set("WAIT_MSG", "&6Teleporting in {wait} seconds");
                langConf.set("DIDNT_WAIT", "&cYou need to hold still while you wait!");
                langConf.set("NO_WE", "&cWorldEdit must be installed for this command.");
                langConf.set("NO_MONEY", "&cYou are too poor to deserve a teleport at this time.");
		        langConf.save(langFile);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
        }
        setStrings();
    }

    public void setStrings() {
        NO_PERMS = gS("NO_PERMS");
        NO_SIGN_PERMS = gS("NO_SIGN_PERMS");
        NO_BREAK = gS("NO_BREAK");
        NO_LOCATION = gS("NO_LOCATION");
        NO_BIOME = gS("NO_BIOME");
        YES_SIGN = gS("YES_SIGN");
        BREAK_SIGN = gS("BREAK_SIGN");
        COOLDOWN = gS("COOLDOWN");
        RELOADED = gS("RELOADED");
        WAIT_MSG = gS("WAIT_MSG");
        DIDNT_WAIT = gS("DIDNT_WAIT");
        NO_WE = gS("NO_WE");
        NO_MONEY = gS("NO_MONEY");
    }

    public String gS(String s) {
        try {
            langConf.load(langFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return langConf.getString(s);
    }

    public static String translate(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
