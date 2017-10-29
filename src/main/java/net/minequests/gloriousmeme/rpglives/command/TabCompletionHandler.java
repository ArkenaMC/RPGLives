package net.minequests.gloriousmeme.rpglives.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zack on 4/6/2017.
 */
public class TabCompletionHandler implements TabCompleter {


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("rpglives") && !(args.length > 1)) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                ArrayList<String> arguments = new ArrayList<>();
                arguments.add("help");
                arguments.add("reload");
                arguments.add("shop");
                arguments.add("setregentime");
                arguments.add("giveitem");
                arguments.add("setlives");
                arguments.add("setmaxlives");


                ArrayList<String> validArguments = new ArrayList<>();

                for (String allowedArgument : arguments) {
                    if (player.hasPermission("rpglives.use")) {
                        validArguments.add(allowedArgument);
                    }
                }
                return validArguments;
            }
        }
        return null;
    }
}
