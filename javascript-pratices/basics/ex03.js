/**
 * null과 undefined
 */

var myVar1 = undefined; // 명시적으려 undefined 대입
var myVar2;             // 암시적으로 undefined 대입
var myVar3 = null;

console.log(myVar1 + ':' + myVar2 + ':' + myVar3);

console.log(true + 10); // 11
console.log('abc' + new String('abc')); // abcabc
console.log(1 + '11') // 111
console.log('11' + 1) // 111

/**
 * 타입의 동일성
 * 타입이 같은 경우
 * 1. primitive type : 값의 동일성
 * 2. object type : 객체의 동일성
 */
console.log('4' == 4);
console.log(1 === true);
console.log('abc' === new String('abc'));
console.log(4 === 2);
console.log(new Number(10) === new Number(10));