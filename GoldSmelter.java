package com.bennyp12.goldsmelter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections; 
import java.util.List;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Timer;

import com.bennyp12.goldsmelter.misc.Const;
import com.bennyp12.goldsmelter.misc.Methods;
import com.bennyp12.goldsmelter.misc.Vars;
import com.bennyp12.goldsmelter.nodes.BankNode;
import com.bennyp12.goldsmelter.nodes.SmeltNode;
import com.bennyp12.goldsmelter.nodes.TraverseBankNode;
import com.bennyp12.goldsmelter.nodes.TraverseFurnaceNode;

@Manifest(authors = { "Bennyp12" }, description = "Smelting gold in Al kharid and Edgeville", name = "GoldSmelter")
public class GoldSmelter extends ActiveScript implements PaintListener {

	private final List<Node> jobsCollection = Collections.synchronizedList(new ArrayList<Node>());
	private Tree jobContainer = null;

	Timer t = new Timer(0);

	@Override
	public int loop() {
		if (jobContainer != null) {
			final Node job = jobContainer.state();
			if (job != null) {
				jobContainer.set(job);
				getContainer().submit(job);
				job.join();
			}
		}
		if (Vars.error) {
			stop();
		}
		return 375;
	}

	public final void provide(final Node... jobs) {
		for (final Node job : jobs) {
			if (!jobsCollection.contains(job)) {
				jobsCollection.add(job);
			}
		}
		jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
	}

	public void onStart() {
		try {
			Vars.paintImage = Methods.getImage(Const.PAINT_URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (Const.ALK_AREA.contains(Players.getLocal().getLocation())) {
			Vars.bankArea = Const.ALK_BANK;
			Vars.smithArea = Const.ALK_SMITH;
			Vars.path = Const.ALK_PATH;
			Vars.furnace = Const.ALK_FURNACE;
		} else if (Const.EDGE_AREA.contains(Players.getLocal().getLocation())) {
			Vars.bankArea = Const.EDGE_BANK;
			Vars.smithArea = Const.EDGE_SMITH;
			Vars.path = Const.EDGE_PATH;
			Vars.furnace = Const.EDGE_FURNACE;
		}

		if (Vars.furnace == 0) {
			Keyboard.sendText("Please start infont of the Bank", false);
			Vars.error = true;
		}
		provide(new BankNode(), new TraverseBankNode(), new TraverseFurnaceNode(), new SmeltNode());
	}

	@Override
	public void onRepaint(Graphics g) {
		Vars.currentExp = Skills.getExperience(Skills.SMITHING);
		Vars.gainedExp = Vars.currentExp - Vars.StartingExp;
		Vars.expPerHour = (int) (Vars.gainedExp * 3600000D / (System.currentTimeMillis() - Const.STARTING_TIME));
		Vars.timeRan = t.toElapsedString();

		g.setColor(Color.RED);
		Point p = Mouse.getLocation();
		g.drawLine(p.x - 6, p.y, p.x + 6, p.y);
		g.drawLine(p.x, p.y - 6, p.x, p.y + 6);

		g.drawImage(Vars.paintImage, 0, 390, null);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("" + Vars.expPerHour, 124, 455);
		g.drawString("" + Vars.timeRan, 148, 470);
		g.drawString("" + Vars.loads, 166, 483);
	}
}
