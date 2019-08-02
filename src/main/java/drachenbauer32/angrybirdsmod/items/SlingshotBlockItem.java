package drachenbauer32.angrybirdsmod.items;

import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;

public class SlingshotBlockItem extends BlockItem
{
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    
    public SlingshotBlockItem(Block blockIn, Properties builder)
    {
        super(blockIn, builder);
    }
    
    @Override
    protected boolean placeBlock(BlockItemUseContext context, BlockState state)
    {
        if (context.getWorld().getBlockState(context.getPos().up()).getBlock() instanceof AirBlock)
        {
            Direction facing = state.get(FACING);
            
            switch(facing)
            {
                default:
                if (context.getWorld().getBlockState(context.getPos().east()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().west()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().east().up()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().west().up()).getBlock() instanceof AirBlock)
                {
                    return super.placeBlock(context, state);
                }
                else
                {
                    return false;
                }
                
                case EAST:
                if (context.getWorld().getBlockState(context.getPos().north()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().south()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().north().up()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().south().up()).getBlock() instanceof AirBlock)
                {
                    return super.placeBlock(context, state);
                }
                else
                {
                    return false;
                }
                
                case SOUTH:
                if (context.getWorld().getBlockState(context.getPos().east()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().west()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().east().up()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().west().up()).getBlock() instanceof AirBlock)
                {
                    return super.placeBlock(context, state);
                }
                else
                {
                    return false;
                }
                
                case WEST:
                if (context.getWorld().getBlockState(context.getPos().north()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().south()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().north().up()).getBlock() instanceof AirBlock&&
                    context.getWorld().getBlockState(context.getPos().south().up()).getBlock() instanceof AirBlock)
                {
                    return super.placeBlock(context, state);
                }
                else
                {
                    return false;
                }
            }  
        }
        else
        {
            return false;
        }
    }
}
