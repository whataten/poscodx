/**
 * Array 객체 함수 : Array.prototype.*
 */

var colors = ['black', 'white', 'yellow'];
var fruits = ['apple', 'mango', 'banana'];

// concat
console.log("=== concat ===");
var a1 = fruits.concat(colors);
console.log(a1);

// push, pop : stack 지원
console.log("=== stack ===");

var color = colors.pop();
console.log(colors, color);

colors.push('red');
console.log(colors);

// join
console.log("=== join ===");
var s = fruits.join(":");
console.log(s);

// reverse
console.log("=== reverse ===");

console.log(fruits);
fruits.reverse();
console.log(fruits);

// shift
console.log("=== shift ===");

var numbers = [1000, 2000, 3000, 4000, 5000, 6000];
var number = numbers.shift();
console.log(number, numbers);

// slice
console.log("=== slice ===");
number = numbers.slice(1, 3);
console.log(number);

/**
 * splice 
 * 1. index에서 count개를 삭제하고 삭제된 요소를 배열에 담아 반환
 * 2. index에서 count개를 삭제하고 replace한 후, 삭제된 요소를 배열에 담아 반환
 * 3. removeAt() 처럼 동작
 * 4. insertAt() 처럼 동작
 */

console.log("=== splice(index, count) ===");
var fruits2 = fruits.splice(0, 2);
console.log(fruits2, fruits);

console.log("=== splice(index, count, replace ===");
var a1 = [0, 1, 2, 3, 4, 5];
var a2 = a1.splice(1, 3, 10);
console.log(a2, a1);

console.log("=== removeAt ===");
var a3 = [1, 2, 3, 4, 5];
a3.splice(2, 1); // == removeAt(2)
console.log(a3);

console.log("=== insertAt ===");
var a4 = [0,1, 3, 4, 5];
a4.splice(2, 0, 2); // == insertAt(2, 2)
console.log(a4);