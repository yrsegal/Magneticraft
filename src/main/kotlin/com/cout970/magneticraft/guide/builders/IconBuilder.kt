package com.cout970.magneticraft.guide.builders

import com.cout970.magneticraft.guide.components.StackIcon
import com.cout970.magneticraft.util.vector.Vec2d
import net.minecraft.item.ItemStack

class IconBuilder {
    lateinit var position: Vec2d
    lateinit var stack: ItemStack

    fun build() = StackIcon(position, stack)
}