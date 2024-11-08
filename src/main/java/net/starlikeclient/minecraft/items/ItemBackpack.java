package net.starlikeclient.minecraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.starlikeclient.minecraft.guis.inventory.BackpackInventory;

public class ItemBackpack extends Item {
    private static BackpackInventory openInventory;  

    public ItemBackpack() {
        this.setUnlocalizedName("backpack");
        this.setCreativeTab(CreativeTabs.tabMisc);
        this.maxStackSize = 1;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            System.out.println("Opening backpack...");
            
            openInventory = new BackpackInventory(itemStack);
            
            player.displayGUIChest(openInventory);
            
            System.out.println("Backpack opened.");
        }
        return itemStack;
    }

    // Add this method to handle inventory closing
    public static void onInventoryClosed() {
        if (openInventory != null) {
            openInventory.saveInventoryToNBT();
            openInventory = null;
        }
    }
}