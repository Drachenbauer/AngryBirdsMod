package drachenbauer32.angrybirdsmod.init;

import drachenbauer32.angrybirdsmod.entity.EntityBlues;
import drachenbauer32.angrybirdsmod.entity.EntityBomb;
import drachenbauer32.angrybirdsmod.entity.EntityChuck;
import drachenbauer32.angrybirdsmod.entity.EntityMathilda;
import drachenbauer32.angrybirdsmod.entity.EntityRed;
import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.entity.Entity;

public class EntityInit 
{
	public static void registerEntities()
	{
		registerEntity("Red", EntityRed.class, Reference.ENTITY_RED, 50, 14614528, 14663583);
		registerEntity("Chuck", EntityChuck.class, Reference.ENTITY_CHUCK, 50, 16776960, 16777215);
		registerEntity("Blues", EntityBlues.class, Reference.ENTITY_BLUES, 50, 32767, 16711680);
		registerEntity("Bomb", EntityBomb.class, Reference.ENTITY_BOMB, 50, 4144959, 8355711);
		registerEntity("Mathilda", EntityMathilda.class, Reference.ENTITY_MATHILDA, 50, 16777215, 15969719);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		//registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, range, 1, true, color1, color2);
	}
}
