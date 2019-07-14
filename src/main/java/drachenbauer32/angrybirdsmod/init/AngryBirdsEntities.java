package drachenbauer32.angrybirdsmod.init;

import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import drachenbauer32.angrybirdsmod.entities.BombEntity;
import drachenbauer32.angrybirdsmod.entities.ChuckEntity;
import drachenbauer32.angrybirdsmod.entities.MathildaEntity;
import drachenbauer32.angrybirdsmod.entities.RedEntity;
import drachenbauer32.angrybirdsmod.entities.SilverEntity;
import drachenbauer32.angrybirdsmod.entities.TerenceEntity;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;

public class AngryBirdsEntities 
{
	public static EntityType<?> RED_ENTITY = EntityType.Builder.create(RedEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".red_entity").setRegistryName("red_entity");
	public static EntityType<?> CHUCK_ENTITY = EntityType.Builder.create(ChuckEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".chuck_entity").setRegistryName("chuck_entity");
	public static EntityType<?> BLUES_ENTITY = EntityType.Builder.create(BluesEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".blues_entity").setRegistryName("blues_entity");
	public static EntityType<?> BOMB_ENTITY = EntityType.Builder.create(BombEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".bomb_entity").setRegistryName("bomb_entity");
	public static EntityType<?> MATHILDA_ENTITY = EntityType.Builder.create(MathildaEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".mathilda_entity").setRegistryName("mathilda_entity");
	public static EntityType<?> TERENCE_ENTITY = EntityType.Builder.create(TerenceEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".terence_entity").setRegistryName("terence_entity");
	public static EntityType<?> SILVER_ENTITY = EntityType.Builder.create(SilverEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".silver_entity").setRegistryName("silver_entity");
	
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item>event)
	{
		event.getRegistry().registerAll(AngryBirdsItems.red_entity_egg = registerEntitySpawnEgg(RED_ENTITY, 0xdf0000, 0xdfbf9f, "red_entity_egg"),
		                                AngryBirdsItems.chuck_entity_egg = registerEntitySpawnEgg(CHUCK_ENTITY, 0xffff00, 0xffffff, "chuck_entity_egg"),
		                                AngryBirdsItems.blues_entity_egg = registerEntitySpawnEgg(BLUES_ENTITY, 0x007fff, 0xff0000, "blues_entity_egg"),
		                                AngryBirdsItems.bomb_entity_egg = registerEntitySpawnEgg(BOMB_ENTITY, 0x3f3f3f, 0x7f7f7f, "bomb_entity_egg"),
		                                AngryBirdsItems.mathilda_entity_egg = registerEntitySpawnEgg(MATHILDA_ENTITY, 0xffffff, 0xffbfbf, "mathilda_entity_egg"),
		                                AngryBirdsItems.terence_entity_egg = registerEntitySpawnEgg(TERENCE_ENTITY, 0xbf002f, 0xbf9f7f, "terence_entity_egg"),
		                                AngryBirdsItems.silver_entity_egg = registerEntitySpawnEgg(SILVER_ENTITY, 0xbfbfbf, 0xffffff, "silver_entity_egg"));	    
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ItemGroup.MISC));
		item.setRegistryName(name);
		return item;
	}
}
