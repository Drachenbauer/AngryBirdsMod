package drachenbauer32.angrybirdsmod.init;

import drachenbauer32.angrybirdsmod.entities.tile_entities.BlockColorsTileEntity;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AngryBirdsTileEntities
{
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Reference.MOD_ID);
    
    public static final RegistryObject<TileEntityType<BlockColorsTileEntity>> BLOCK_COLORS = TILE_ENTITY_TYPES.register("block_colors", () -> TileEntityType.Builder.create(BlockColorsTileEntity::new,
                        AngryBirdsBlocks.SLINGSHOT_ACACIA.get(),
                        AngryBirdsBlocks.SLINGSHOT_ACACIA_2.get(),
                        AngryBirdsBlocks.SLINGSHOT_BIRCH.get(),
                        AngryBirdsBlocks.SLINGSHOT_BIRCH_2.get(),
                        AngryBirdsBlocks.SLINGSHOT_DARK_OAK.get(),
                        AngryBirdsBlocks.SLINGSHOT_DARK_OAK_2.get(),
                        AngryBirdsBlocks.SLINGSHOT_JUNGLE.get(),
                        AngryBirdsBlocks.SLINGSHOT_JUNGLE_2.get(),
                        AngryBirdsBlocks.SLINGSHOT_OAK.get(),
                        AngryBirdsBlocks.SLINGSHOT_OAK_2.get(),
                        AngryBirdsBlocks.SLINGSHOT_SPRUCE.get(),
                        AngryBirdsBlocks.SLINGSHOT_SPRUCE_2.get()).build(null));
}
