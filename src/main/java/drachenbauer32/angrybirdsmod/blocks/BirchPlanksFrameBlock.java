package drachenbauer32.angrybirdsmod.blocks;

import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.block.BlockState;
import net.minecraft.block.ScaffoldingBlock;

public class BirchPlanksFrameBlock extends ScaffoldingBlock
{
    public BirchPlanksFrameBlock(String name, Properties p_i49976_1_)
    {
        super(p_i49976_1_);
        setRegistryName(Reference.MOD_ID, name);
    }
    
    @Override
    public boolean isSolid(BlockState state)
    {
        return false;
    }
}
