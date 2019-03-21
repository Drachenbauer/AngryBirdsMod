package drachenbauer32.angrybirdsmod.util;

import drachenbauer32.angrybirdsmod.entity.EntityBlues;
import drachenbauer32.angrybirdsmod.entity.EntityBomb;
import drachenbauer32.angrybirdsmod.entity.EntityChuck;
import drachenbauer32.angrybirdsmod.entity.EntityMathilda;
import drachenbauer32.angrybirdsmod.entity.EntityRed;
import net.minecraft.entity.EntityType;

public class AngryBirdsEntityTypes
{
	public static final EntityType<EntityRed> RED = EntityType.register("red", EntityType.Builder.create(EntityRed.class, EntityRed::new));
	public static final EntityType<EntityChuck> CHUCK = EntityType.register("chuck", EntityType.Builder.create(EntityChuck.class, EntityChuck::new));
	public static final EntityType<EntityBlues> BLUES = EntityType.register("blues", EntityType.Builder.create(EntityBlues.class, EntityBlues::new));
	public static final EntityType<EntityBomb> BOMB = EntityType.register("bomb", EntityType.Builder.create(EntityBomb.class, EntityBomb::new));
	public static final EntityType<EntityMathilda> MATHILDA = EntityType.register("mathilda", EntityType.Builder.create(EntityMathilda.class, EntityMathilda::new));
}
