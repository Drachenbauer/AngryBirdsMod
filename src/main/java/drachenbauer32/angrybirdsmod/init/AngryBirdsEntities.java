package drachenbauer32.angrybirdsmod.init;

import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import drachenbauer32.angrybirdsmod.entities.BombEntity;
import drachenbauer32.angrybirdsmod.entities.BubblesEntity;
import drachenbauer32.angrybirdsmod.entities.ChuckEntity;
import drachenbauer32.angrybirdsmod.entities.ChuckShotEntity;
import drachenbauer32.angrybirdsmod.entities.CoralEntity;
import drachenbauer32.angrybirdsmod.entities.DahliaEntity;
import drachenbauer32.angrybirdsmod.entities.HalEntity;
import drachenbauer32.angrybirdsmod.entities.IceBirdEntity;
import drachenbauer32.angrybirdsmod.entities.LucaEntity;
import drachenbauer32.angrybirdsmod.entities.MathildaEntity;
import drachenbauer32.angrybirdsmod.entities.PoppyEntity;
import drachenbauer32.angrybirdsmod.entities.RedEntity;
import drachenbauer32.angrybirdsmod.entities.RedShotEntity;
import drachenbauer32.angrybirdsmod.entities.SilverEntity;
import drachenbauer32.angrybirdsmod.entities.StellaEntity;
import drachenbauer32.angrybirdsmod.entities.TerenceEntity;
import drachenbauer32.angrybirdsmod.entities.WillowEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class AngryBirdsEntities 
{
    public static EntityType<RedEntity> RED;
    public static EntityType<ChuckEntity> CHUCK;
    public static EntityType<BluesEntity> BLUES;
    public static EntityType<BombEntity> BOMB;
    public static EntityType<MathildaEntity> MATHILDA;
    public static EntityType<TerenceEntity> TERENCE;
    public static EntityType<SilverEntity> SILVER;
    public static EntityType<BubblesEntity> BUBBLES;
    public static EntityType<HalEntity> HAL;
    public static EntityType<StellaEntity> STELLA;
    public static EntityType<PoppyEntity> POPPY;
    public static EntityType<WillowEntity> WILLOW;
    public static EntityType<DahliaEntity> DAHLIA;
    public static EntityType<LucaEntity> LUCA;
    public static EntityType<IceBirdEntity> ICE_BIRD;
    public static EntityType<CoralEntity> CORAL;
    
    //public static EntityType<?> RED_SHOT;
    public static EntityType<RedShotEntity> RED_SHOT = register("red_shot", EntityType.Builder.<RedShotEntity>create(RedShotEntity::new, EntityClassification.MISC).size(0.5F, 0.5F));
    public static EntityType<ChuckShotEntity> CHUCK_SHOT = register("chuck_shot", EntityType.Builder.<ChuckShotEntity>create(ChuckShotEntity::new, EntityClassification.MISC).size(0.5F, 0.5F));
    
    @SuppressWarnings("deprecation")
    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder)
    {
        return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
    }
}
