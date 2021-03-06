package com.cout970.magneticraft.registry

import com.cout970.magneticraft.item.*
import com.cout970.magneticraft.item.hammers.ItemIronHammer
import com.cout970.magneticraft.item.hammers.ItemStoneHammer
import net.minecraftforge.fml.common.registry.GameRegistry

val items = listOf(
        ItemGuideBook,
        ItemIronHammer,
        ItemStoneHammer,
        ItemCrushedOre,
        ItemHandSieve,
        ItemPebbles,
        ItemIngot,
        ItemCoilOfWire,
        ItemHeavyPlate,
        ItemLightPlate,
        ItemVoltmeter,
        ItemNugget,
        ItemBattery
)

fun registerItems() {
    items.forEach {
        GameRegistry.register(it)
    }
}