Five Stage Pipelined Core RV-32i with Tilelink Integrated on Data Memory (Main Memory)
=======================

## TESTING: <b style="color:green"> SUCCESS </b>

## About 
This repository contains the Five Stage Pipelined RV-32i Core.

It has **Tilelink** Bus Architecture Protocol Integrated with Data Memory, servig as a communication medium between **Core (MASTER)** and the **Data Memory (SLAVE)**.

## How to Use
Start off by cloning the repo
```ruby
git clone https://github.com/shahzaibk23/Five-Stage-Pipelined-RV32i-core
cd Five-Stage-Pipelined-RV32i-core
```

Create a **txt** File anywhere in you system

This File will be used to store the instructions which we want to run in our core

Write the machine code of your custom instruction or use the sample ones below
```ruby
00700193
00302023
00002203
004202b3
```
Copy and paste this machine code in your **txt** file.

This machine code is for the following Assembly Instructions.
```ruby
addi x3,x0,7
sw x3, 0(x0)
lw x4, 0(x0)
add x5,x4,x4
```

You can check the output of these instruction via the [RISC-V Simulator]("https://www.kvakil.me/venus/")

Then go to file
```ruby 
Five-Stage-Pipelined-RV32i-core/src/main/scala/datapath/InsMem.scala
```
On Line 14 you will find
```scala
loadMemoryFromFile(mem, "/home/kraken/Desktop/Instruction.txt")
```
Replace the string in **loadMemoryFromFile** with the complete path of your **txt** file, in the same format as it is written.

Then go to file
```ruby
Five-Stage-Pipelined-RV32i-core/src/test/scala/datapath/topTest.scala
```
Ctrl+A all the code and un-comment it (Ctrl+/)

On line 14 you will see
```scala
c.clock.step(50)
```
Adjust the clock cycles you want to see in the verilator/waveform.

**All configurations are done at this point. Let's run it now and visualize on verilator**

Open your terminal inside the main folder and run
```ruby
sbt
```

You will see
```ruby
sbt:Five-Stage-Pipelined-RV32i-core>
```

Then type the command to run execute our instructions and build verilator of it.
```ruby
sbt:Five-Stage-Pipelined-RV32i-core> testOnly datapath.topTest -- -DwriteVcd=1
```

Then inside test_run_dir folder your VCD and V files will be found. Visualize the output on GTKWave.