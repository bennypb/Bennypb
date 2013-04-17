package com.bennyp12.goldsmelter.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import com.bennyp12.goldsmelter.misc.Const;
import com.bennyp12.goldsmelter.misc.Vars;

public class BankNode extends Node {
	@Override
	public boolean activate() {
		return Vars.bankArea.contains(Players.getLocal().getLocation()) && Inventory.getCount(Const.GOLD_ORE) < 1;
	}

	@Override
	public void execute() {
		if (!Bank.isOpen()) {
			Bank.open();
		}
		if (Bank.isOpen()) {
			if (Bank.depositInventory()) {
				Vars.loads++;
			}
			if (Bank.getItemCount(Const.GOLD_ORE) < 1) {
				Keyboard.sendText("Out of ores!", false);
				Vars.error = true;
			}
			Bank.withdraw(Const.GOLD_ORE, 0);
			Bank.close();
		}
	}
}
