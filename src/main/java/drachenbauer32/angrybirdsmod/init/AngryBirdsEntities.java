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
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AngryBirdsEntities 
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Reference.MOD_ID);
    
    public static final RegistryObject<EntityType<RedEntity>> RED = ENTITY_TYPES.register("red", () -> EntityType.Builder.create(RedEntity::new,
                        EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".red"));
    public static final RegistryObject<EntityType<ChuckEntity>> CHUCK = ENTITY_TYPES.register("chuck", () -> EntityType.Builder.create(ChuckEntity::new,
                        EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".chuck"));
    public static final RegistryObject<EntityType<BluesEntity>> BLUES = ENTITY_TYPES.register("blues", () -> EntityType.Builder.create(BluesEntity::new,
                        EntityClassification.CREATURE).size(0.25F, 0.75F).build(Reference.MOD_ID + ".blues"));
    public static final RegistryObject<EntityType<BombEntity>> BOMB = ENTITY_TYPES.register("bomb", () -> EntityType.Builder.create(BombEntity::new,
                        EntityClassification.CREATURE).size(0.75F, 0.75F).build(Reference.MOD_ID + ".bomb"));
    public static final RegistryObject<EntityType<MathildaEntity>> MATHILDA = ENTITY_TYPES.register("mathilda", () -> EntityType.Builder.create(MathildaEntity::new,
                        EntityClassification.CREATURE).size(0.5F, 0.625F).build(Reference.MOD_ID + ".mathilda"));
    public static final RegistryObject<EntityType<TerenceEntity>> TERENCE = ENTITY_TYPES.register("terence", () -> EntityType.Builder.create(TerenceEntity::new,
                        EntityClassification.CREATURE).size(1.25F, 1.25F).build(Reference.MOD_ID + ".terence"));
    public static final RegistryObject<EntityType<SilverEntity>> SILVER = ENTITY_TYPES.register("silver", () -> EntityType.Builder.create(SilverEntity::new,
                        EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".silver"));
    public static final RegistryObject<EntityType<BubblesEntity>> BUBBLES = ENTITY_TYPES.register("bubbles", () -> EntityType.Builder.create(BubblesEntity::new,
                        EntityClassification.CREATURE).size(0.25F, 0.25F).build(Reference.MOD_ID + ".bubbles"));
    public static final RegistryObject<EntityType<HalEntity>> HAL = ENTITY_TYPES.register("hal", () -> EntityType.Builder.create(HalEntity::new,
                        EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".hal"));
    public static final RegistryObject<EntityType<StellaEntity>> STELLA = ENTITY_TYPES.register("stella", () -> EntityType.Builder.create(StellaEntity::new,
                        EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".stella"));
    public static final RegistryObject<EntityType<PoppyEntity>> POPPY = ENTITY_TYPES.register("poppy", () -> EntityType.Builder.create(PoppyEntity::new,
                        EntityClassification.CREATURE).size(0.5F, 0.625F).build(Reference.MOD_ID + ".poppy"));
    public static final RegistryObject<EntityType<WillowEntity>> WILLOW = ENTITY_TYPES.register("willow", () -> EntityType.Builder.create(WillowEntity::new,
                        EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".willow"));
    public static final RegistryObject<EntityType<DahliaEntity>> DAHLIA = ENTITY_TYPES.register("dahlia", () -> EntityType.Builder.create(DahliaEntity::new,
                        EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".dahlia"));
    public static final RegistryObject<EntityType<LucaEntity>> LUCA = ENTITY_TYPES.register("luca", () -> EntityType.Builder.create(LucaEntity::new,
                        EntityClassification.CREATURE).size(0.25F, 0.25F).build(Reference.MOD_ID + ".luca"));
    public static final RegistryObject<EntityType<IceBirdEntity>> ICE_BIRD = ENTITY_TYPES.register("ice_bird", () -> EntityType.Builder.create(IceBirdEntity::new,
                        EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".ice_bird"));
    public static final RegistryObject<EntityType<CoralEntity>> CORAL = ENTITY_TYPES.register("coral", () -> EntityType.Builder.create(CoralEntity::new,
                        EntityClassification.CREATURE).size(0.5F, 0.875F).build(Reference.MOD_ID + ".coral"));
    
    public static final RegistryObject<EntityType<RedShotEntity>> RED_SHOT = ENTITY_TYPES.register("red_shot", () -> EntityType.Builder.<RedShotEntity>create(RedShotEntity::new,
                        EntityClassification.MISC).size(0.25F, 0.25F).build(Reference.MOD_ID + ".red_shot"));
    public static final RegistryObject<EntityType<ChuckShotEntity>> CHUCK_SHOT = ENTITY_TYPES.register("chuck_shot", () -> EntityType.Builder.<ChuckShotEntity>create(ChuckShotEntity::new,
                        EntityClassification.MISC).size(0.25F, 0.25F).build(Reference.MOD_ID + ".chuck_shot"));
    
    /*public static EntityType<ChuckEntity> CHUCK;
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
    public static EntityType<CoralEntity> CORAL;*/
}
