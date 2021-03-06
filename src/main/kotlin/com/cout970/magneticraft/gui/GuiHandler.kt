package com.cout970.magneticraft.gui

import com.cout970.magneticraft.gui.client.blocks.GuiBattery
import com.cout970.magneticraft.gui.client.blocks.GuiElectricFurnace
import com.cout970.magneticraft.gui.client.blocks.GuiIncendiaryGenerator
import com.cout970.magneticraft.gui.common.ContainerBase
import com.cout970.magneticraft.gui.common.blocks.ContainerBattery
import com.cout970.magneticraft.gui.common.blocks.ContainerElectricFurnace
import com.cout970.magneticraft.gui.common.blocks.ContainerIncendiaryGenerator
import com.cout970.magneticraft.tileentity.electric.TileBattery
import com.cout970.magneticraft.tileentity.electric.TileElectricFurnace
import com.cout970.magneticraft.tileentity.electric.TileIncendiaryGenerator
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler

object GuiHandler : IGuiHandler {

    override fun getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Any? {
        val tile = world.getTileEntity(BlockPos(x, y, z))
        val serverElement = getServerGuiElement(ID, player, world, x, y, z) as ContainerBase
        return when (tile) {
            is TileIncendiaryGenerator -> GuiIncendiaryGenerator(serverElement)
            is TileBattery -> GuiBattery(serverElement)
            is TileElectricFurnace -> GuiElectricFurnace(serverElement)
            else -> null
        }
    }


    override fun getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): Any? {
        val tile = world.getTileEntity(BlockPos(x, y, z))
        return when (tile) {
            is TileIncendiaryGenerator -> ContainerIncendiaryGenerator(player, world, BlockPos(x, y, z))
            is TileBattery -> ContainerBattery(player, world, BlockPos(x, y, z))
            is TileElectricFurnace -> ContainerElectricFurnace(player, world, BlockPos(x, y, z))
            else -> null
        }
    }
}