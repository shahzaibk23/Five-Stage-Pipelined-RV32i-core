// package datapath

// import chisel3._
// import tilelink._ 
// //import chisel3.util.experimental.loadMemoryFromFile

// class MainMem extends Module{
// 	val io = IO(new Bundle{
// 		val Address = Input(UInt(32.W))
// 		val DataIn = Input(SInt(32.W))
// 		val DataOut = Output(SInt(32.W))
// 		val str = Input(UInt(1.W))
// 		val ld = Input(UInt(1.W))
// 	})

// 	val dMem = Mem(1024,UInt(32.W))
// 	io.DataOut := 0.S

// 	/*when(io.ld === 1.U){
// 		io.DataOut := (dMem(io.Address)).asSInt
// 	}.elsewhen(io.str === 1.U){
// 		dMem(io.Address) := (io.DataIn).asUInt
// 	}
// 	//loadMemoryFromFile(dMem, "/home/hellcaster/Memory.txt")
// 	*/


// 	val tLink = Module(new TileTop())

// 	tLink.io.channelA.valid := 1.B
// 	tLink.io.channelA.bits.a_param := 0.U
// 	tLink.io.channelA.bits.a_size := 2.U
// 	tLink.io.channelA.bits.a_source := 2.U
// 	tLink.io.channelA.bits.a_mask := 1.U
// 	tLink.io.channelA.bits.a_corrupt := 0.U
// 	tLink.io.channelA.bits.a_opcode := Mux(io.ld === 1.U, 4.U, Mux(io.str === 1.U, 1.U, 2.U))
// 	tLink.io.channelA.bits.a_address := io.Address
// 	tLink.io.channelA.bits.a_data := Mux(io.str === 1.U, io.DataIn.asUInt, 0.U)

// 	tLink.io.channelD.ready := 1.B

// 	io.DataOut := tLink.io.channelD.bits.d_data.asSInt

// 	// val mem = Mem(1024,SInt(32.W))
// 	// when(io.ld === 1.U){
// 	// 	io.DataOut := mem(io.Address)
// 	// }.otherwise{
// 	// 	io.DataOut := DontCare
// 	// }

	
// 	// when(io.str === 1.U){
// 	// 	mem(io.Address) := io.DataIn
// 	// }.otherwise{
// 	// 	io.DataOut := DontCare
// 	// }

// }

