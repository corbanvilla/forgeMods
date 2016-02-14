package org.devoxx4kids.forge.mods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SuperJump {
	@SubscribeEvent
	public void makeJumpHigher(LivingJumpEvent event) {
		if(!(event.entity instanceof EntityPlayer)) {
			return;
		}
		BlockPos pos = new BlockPos(event.entity.field_70165_t, event.entity.field_70163_u - 1, 
				event.entity.field_70161_v);
		
		if (event.entity.field_70170_p.func_180495_p(pos).func_177230_c() != Blocks.field_150360_v) {
			return;
		}
		
		event.entity.field_70181_x *= 5;
	}

}
