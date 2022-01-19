let x = 10;
let y =20;
let z = x+y;
console.log(`z : `+(x+y))
setTimeout(()=>{console.log(`Inside the callback 1001`)},1001)
console.log(`last line`)
setTimeout(()=>{console.log(`Inside the callback 1000`)},1000)
console.log("Last line 2")
setTimeout(()=>{console.log(`Inside the callback 100`)},100)
console.log("Last line 3")
setTimeout(()=>{console.log(`Inside the callback 50`)},50)
console.log("Last line 4")
setTimeout(()=>{console.log(`Inside the callback 10`)},10)
console.log("Last line 5")