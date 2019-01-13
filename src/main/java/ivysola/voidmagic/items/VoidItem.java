package ivysola.voidmagic.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ivysola.voidmagic.VoidMagic;
import ivysola.voidmagic.util.FormatCodes;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

import java.util.List;
import java.util.Locale;

public abstract class VoidItem extends Item {

    protected IIcon icon;
    protected boolean canInformation;

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean advancedTooltips) {
        if(!this.canInformation) return;
        infoList.add(FormatCodes.DarkGrey.code + FormatCodes.Italic.code +
                StatCollector.translateToLocal("tooltip." + getUnlocalizedName().replace("item.", "")));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        return this.icon;
    }
}
