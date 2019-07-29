package drachenbauer32.angrybirdsmod.init;

import drachenbauer32.angrybirdsmod.entities.ChuckShotEntity;
import drachenbauer32.angrybirdsmod.entities.RedShotEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class AngryBirdsEntities 
{
    public static EntityType<?> RED;
    public static EntityType<?> CHUCK;
    public static EntityType<?> BLUES;
    public static EntityType<?> BOMB;
    public static EntityType<?> MATHILDA;
    public static EntityType<?> TERENCE;
    public static EntityType<?> SILVER;
    public static EntityType<?> BUBBLES;
    public static EntityType<?> BUBBLES_INFLATED;
    public static EntityType<?> HAL;
    public static EntityType<?> STELLA;
    public static EntityType<?> POPPY;
    public static EntityType<?> WILLOW;
    public static EntityType<?> DAHLIA;
    public static EntityType<?> LUCA;
    public static EntityType<?> ICE_BIRD;
    
    //public static EntityType<?> RED_SHOT;
    public static EntityType<RedShotEntity> RED_SHOT = register("red_shot", EntityType.Builder.<RedShotEntity>create(RedShotEntity::new, EntityClassification.MISC).size(0.5F, 0.5F));
    public static EntityType<ChuckShotEntity> CHUCK_SHOT = register("chuck_shot", EntityType.Builder.<ChuckShotEntity>create(ChuckShotEntity::new, EntityClassification.MISC).size(0.5F, 0.5F));
    
    @SuppressWarnings("deprecation")
    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder)
    {
        return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
    }
}
