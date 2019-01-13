package ivysola.voidmagic.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ivysola.voidmagic.VoidMagic;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import org.apache.logging.log4j.Level;

import java.util.Locale;

public class ItemYuuki extends VoidItem {
    public ItemYuuki()
    {
        super();
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setCreativeTab(VoidMagic.mainTab);
        this.setUnlocalizedName("void_magic.yuuki");
        this.canInformation = true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.icon = reg.registerIcon(VoidMagic.modID.toLowerCase(Locale.ENGLISH) + ":" + "itemYuuki");
    }
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        return this.icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.rare;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack, int pass)
    {
        return true;
    }
}
