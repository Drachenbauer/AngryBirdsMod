package drachenbauer32.angrybirdsmod.items;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Supplier;
import java.util.List;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class SupplierSpawnEggItem extends SpawnEggItem
{
    protected static final List<SupplierSpawnEggItem> UNADDED_EGGS = new ArrayList<>();
    
    private Supplier<? extends EntityType<?>> supplier;
    
    public SupplierSpawnEggItem(Supplier<? extends EntityType<?>> supplierIn, int primaryColorIn, int secondaryColorIn, Properties builder)
    {
        super(null, primaryColorIn, secondaryColorIn, builder);
        supplier = supplierIn;
        UNADDED_EGGS.add(this);
    }
    
    public static void initUnaddedEggs()
    {
        final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
        
        DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior()
        {
            public ItemStack dispenseStack(IBlockSource source, ItemStack stack)
            {
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                EntityType<?> entitytype = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                entitytype.spawn(source.getWorld(), stack, null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };
        
        for (final SpawnEggItem egg : UNADDED_EGGS)
        {
            EGGS.put(egg.getType(null), egg);
            DispenserBlock.registerDispenseBehavior(egg, defaultDispenseItemBehavior);
        }
        
        UNADDED_EGGS.clear();
    }
    
    @Override
    public EntityType<?> getType(CompoundNBT p_208076_1_)
    {
        return supplier.get();
    }
}
