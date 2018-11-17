import chapter05.GettersAndSetters

val gs = GettersAndSetters()
println(gs.readOnly)          // Read-only attribute acts like a val property

gs.readWrite = "I have both"  // Read-write attribute acts like a var property
println(gs.readWrite)

gs.setWriteOnly("No getter")  // Write-only properties not supported in Kotlin