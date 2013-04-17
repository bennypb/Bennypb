package com.bennyp12.goldsmelter.nodes;
 
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import com.bennyp12.goldsmelter.misc.Const;
import com.bennyp12.goldsmelter.misc.Vars;

public class TraverseFurnaceNode extends Node {

	@Override
	public boolean activate() {
		return !Vars.smithArea.contains(Players.getLocal().getLocation()) && Inventory.getCount(Const.GOLD_ORE) > 1;
	}

	@Override
	public void execute() {
		Walking.newTilePath(Vars.path).randomize(2, 2).traverse();
	}
}
