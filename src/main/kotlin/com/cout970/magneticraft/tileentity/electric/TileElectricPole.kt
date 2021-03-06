package com.cout970.magneticraft.tileentity.electric

import com.cout970.magneticraft.api.energy.IElectricNode
import com.cout970.magneticraft.api.energy.IElectricNodeHandler
import com.cout970.magneticraft.api.energy.INodeHandler
import com.cout970.magneticraft.api.internal.energy.ElectricNode
import com.cout970.magneticraft.tileentity.electric.connectors.ElectricPoleConnector
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.Vec3i

/**
 * Created by cout970 on 03/07/2016.
 */
class TileElectricPole : TileElectricBase() {

    var mainNode = ElectricPoleConnector(ElectricNode(worldGetter = { world }, posGetter = { pos }))
    override val electricNodes: List<IElectricNode>
        get() = listOf(mainNode)

    override fun updateWiredConnections() {
        if(autoConnectWires) {
            autoConnectWires(this, world, pos.subtract(Vec3i(16, 5, 16)), pos.add(Vec3i(16, 5, 16)), mainNode)
        }
        super.updateWiredConnections()
    }

    override fun canConnectAtSide(facing: EnumFacing?): Boolean = facing == null

    override fun getRenderBoundingBox(): AxisAlignedBB = INFINITE_EXTENT_AABB

    override fun save(): NBTTagCompound = NBTTagCompound()

    override fun load(nbt: NBTTagCompound) = Unit

    override fun connectWire(handler: INodeHandler, side: EnumFacing): Boolean {
        var result = false
        if (handler == this || handler !is IElectricNodeHandler) return result
        result = connectHandlers(this, handler)
        wireRender.reset()
        return result
    }
}