package ivysola.voidmagic.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ivysola.voidmagic.items.VoidItems;

public class VoidTab extends CreativeTabs
{
    public VoidTab(String label)
    {
        super(label);
    }

    @Override
    public Item getTabIconItem()
    {
        return VoidItems.itemVoidShard;
    }
}
