val number = 42
var approxSqrt = 1.0
var error = 1.0
while (error > 0.0001) {
  approxSqrt = 0.5 * (approxSqrt + number / approxSqrt)
  error = Math.abs((number - approxSqrt * approxSqrt) / (2 * approxSqrt))
}

println("The approximated square root is $approxSqrt.")
println("The error is $error.")