package org.devoxx4kids.forge.mods;

import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DiamondOreTrap {

	@SubscribeEvent
	public void explode(BreakEvent event) {
		if (event.state.func_177230_c() != Blocks.field_150482_ag) {
			return;
		}
		
		event.world.func_72876_a(null,
				event.pos.func_177958_n(),
				event.pos.func_177956_o(),
				event.pos.func_177952_p(),
				10, true);
	}
}
