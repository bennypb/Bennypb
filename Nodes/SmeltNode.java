package com.bennyp12.goldsmelter.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.util.Timer;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

import com.bennyp12.goldsmelter.misc.Const;
import com.bennyp12.goldsmelter.misc.Vars;

public class SmeltNode extends Node {

	@Override
	public boolean activate() {
		return Vars.smithArea.contains(Players.getLocal().getLocation()) && !Const.SMELTING_SCREEN.validate() && !Const.SMELTING_SCREEN.isOnScreen() && Inventory.getCount(Const.GOLD_ORE) > 0 && Players.getLocal().isIdle();
	}

	@Override
	public void execute() {
		SceneObject furnace = SceneEntities.getNearest(Const.ALK_FURNACE);
		if (furnace != null) {
			if (!furnace.isOnScreen()) {
				Walking.walk(furnace);
			} else {
				Timer t = new Timer(2500);
				furnace.interact("Smelt");
				while (!Const.SMELTING_BUTTON.validate() && !Const.SMELTING_BUTTON.isOnScreen() || t.isRunning()) {
					sleep(200, 300);
				}
				if (Const.SMELTING_BUTTON.validate() && Const.SMELTING_BUTTON.isOnScreen() && Const.SMELTING_BUTTON.interact("Make")) {
					t.reset();
					while (!Const.SMELTING_SCREEN.validate() && !Const.SMELTING_SCREEN.isOnScreen() || t.isRunning()) {
						sleep(200, 300);
					}
				}
			}
		}
	}
}