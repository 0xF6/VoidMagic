package ivysola.voidmagic.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ivysola.voidmagic.VoidMagic;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.Locale;

public class ItemVoidShard extends VoidItem {
    private IIcon icon;

    public ItemVoidShard()
    {
        super();
        this.canInformation = true;
        this.setHasSubtypes(true);
        this.setCreativeTab(VoidMagic.mainTab);
        this.setUnlocalizedName("void_magic.shard");

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.icon = reg.registerIcon(VoidMagic.modID.toLowerCase(Locale.ENGLISH) + ":" + "itemVoidShard");
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
