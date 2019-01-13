package ivysola.voidmagic.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ivysola.voidmagic.VoidMagic;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.potions.PotionFluxTaint;

import java.util.Locale;

public class ItemVoidVortex extends VoidItem {


    public ItemVoidVortex()
    {
        super();
        VoidMagic.logger.log(Level.INFO, "Void Vortex has combined this world!");
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setCreativeTab(VoidMagic.mainTab);
        this.setUnlocalizedName("void_magic.vortex");
        this.canInformation = true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.icon = reg.registerIcon(VoidMagic.modID.toLowerCase(Locale.ENGLISH) + ":" + "itemVoidVortex");
    }

    private PotionEffect getEffect(int id, int duration, boolean ambient){
        PotionEffect potion = new PotionEffect(id, duration, 0, ambient);
        potion.getCurativeItems().clear();
        return potion;
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if(!world.isRemote && player instanceof EntityPlayerMP) {

            world.playSoundAtEntity(player,"thaumcraft:wand",0.3f,0.1f);
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_PURPLE +
                    StatCollector.translateToLocal("void_magic.chat.1")));
            ThaumcraftApiHelper.addWarpToPlayer(player, 5, false);
            player.addPotionEffect(getEffect(PotionFluxTaint.instance.id, 600, false));
            player.addPotionEffect(getEffect(Potion.hunger.id, 600, false));
            if(world.rand.nextFloat() < 0.4F) {
                player.addPotionEffect(getEffect(PotionFluxTaint.instance.id, 600, true));
            }
        }
        return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.epic;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack, int pass)
    {
        return true;
    }
}
