package gregtech.common.pipelike.cable;

import gregtech.api.GTValues;
import gregtech.api.pipenet.block.material.ItemBlockMaterialPipe;
import gregtech.api.util.GTUtility;
import gregtech.api.util.LocalisationUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBlockCable extends ItemBlockMaterialPipe<Insulation, WireProperties> {

    public ItemBlockCable(BlockCable block) {
        super(block);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        WireProperties wireProperties = blockPipe.createItemProperties(stack);
        String voltageName = GTValues.VN[GTUtility.getTierByVoltage(wireProperties.voltage)];
        tooltip.add(LocalisationUtils.format("gregtech.cable.voltage", wireProperties.voltage, voltageName));
        tooltip.add(LocalisationUtils.format("gregtech.cable.amperage", wireProperties.amperage));
        tooltip.add(LocalisationUtils.format("gregtech.cable.loss_per_block", wireProperties.lossPerBlock));
    }
}
