package net.bote.citybuild.addons.handeln;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.main.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class CMD_handlnn implements CommandExecutor {

	private Main plugin;
	
	private static String prefix = "§7[§bHandeln§7] ";
	
	public CMD_handlnn(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
				if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						
						if(!(target.getName() == p.getName())) {
							if(!Main.handelt.contains(p)) {
								Main.cooldown.add(p);
								sendVoteMessage(target, p);
								p.sendMessage(prefix+"§aDu hast §l" + target.getName() + " §r§azum Handel eingeladen!");
								Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
									
									@Override
									public void run() {
										
										Main.cooldown.remove(p);
										
									}
									
								}, 20*20);
							} else {
								p.sendMessage(prefix+"§cDieser Spieler handelt zur Zeit mit jemand anderem!");
							}
						} else {
							p.sendMessage(prefix+"§cDu kannst dich selbst nicht auswählen!");
						}
						
					} else {
						p.sendMessage(prefix+"§cDieser Spieler ist §4offline§c!");
					}
				} else {
					p.sendMessage(prefix+"§7Nutze: §e/handeln <Spielername>");
				}
		} else {
			System.out.println("[Handeln] Dies kann nur ein Spieler!");
		}
		return true;
	}
	
	
	
	private void sendVoteMessage(Player p, Player target) {
		
		TextComponent no = new TextComponent("§a[Akzeptieren]");
		no.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/handelnaccept " + target.getName()));
		no.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aKlicke um mit" + target.getName() + " zuhandeln.").create()));
		
		TextComponent msg = new TextComponent("§7Du wurdest von " + target.getName() + " zum Handel eingeladen! ");
		msg.addExtra(no);
		
		p.spigot().sendMessage(msg);
	}

}
