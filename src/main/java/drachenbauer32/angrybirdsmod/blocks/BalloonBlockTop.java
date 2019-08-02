package drachenbauer32.angrybirdsmod.blocks;

import drachenbauer32.angrybirdsmod.init.AngryBirdsBlocks;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BalloonBlockTop extends Block
{
    protected static final VoxelShape BALLOON_BLOCK_AABB = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    
    
    public BalloonBlockTop(String name, Properties properties) 
    {
        super(properties);
        setRegistryName(Reference.MOD_ID, name);
    }
    
    @Override
    public boolean isSolid(BlockState state)
    {
        return false;
    }
    
    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return BALLOON_BLOCK_AABB;
    }
    
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return BALLOON_BLOCK_AABB;
    }
    
    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return BALLOON_BLOCK_AABB;
    }
    
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
    {
        worldIn.setBlockState(pos.down(), Blocks.AIR.getDefaultState());
        super.onBlockHarvested(worldIn, pos, state, player);
    }
    
    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player)
    {
        return new ItemStack(AngryBirdsBlocks.balloon_block);
    }
}
