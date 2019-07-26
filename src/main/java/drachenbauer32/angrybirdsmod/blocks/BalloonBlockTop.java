package drachenbauer32.angrybirdsmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BalloonBlockTop extends Block
{
    protected static final VoxelShape BALLOON_BLOCK_AABB = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public BalloonBlockTop(Properties properties) 
    {
        super(properties);
    }
    
    public VoxelShape getShape(BlockState state, IBlockReader p_196244_2_, BlockPos p_196244_3_)
    {
        return BALLOON_BLOCK_AABB;
    }
    
    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader p_196247_2_, BlockPos p_196247_3_)
    {
        return BALLOON_BLOCK_AABB;
    }
    
    public VoxelShape getCollisionShape(BlockState state, IBlockReader p_196268_2_, BlockPos p_196268_3_)
    {
        return BALLOON_BLOCK_AABB;
    }
    
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
    {
        //replaceBlock(oldState, newState, worldIn, pos, flags);
        super.onBlockHarvested(worldIn, pos, state, player);
    }
}
