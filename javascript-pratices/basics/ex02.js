/**
 * 변수와 자료형 (data type)
 * [기본 타입, primitive type]
 * - undefined
 * - number
 * - string
 * - boolean
 * [객체]
 * - object
 *  1. new 생성자 함수 사용해서 생성
 *  Number()    → object 타입의 객체
 *  String()    → object 타입의 객체
 *  Boolean()   → object 타입의 객체
 *  Object()    → object 타입의 객체
 *  Array()     → object 타입의 객체
 *  Date()      → object 타입의 객체
 *  RegExp()    → object 타입의 객체
 *  Function()  → function 타입의 객체
 *  2. {}
 *  3. []
 *  4. null
 *  
 * - function
 */

console.log("=== 기본 타입(undefined, number, string, boolean) ===");

var u;
var i = 10;
var b = true;
var s = 'hello world';
console.log("u:" + typeof(u));
console.log("i:" + typeof(i));
console.log("b:" + typeof(b));
console.log("s:" + typeof(s));

console.log("=== 객체 타입(object) ===");
function f() {

}

var o = new f();
console.log("o:" + typeof(o));

var i2 = new Number(10);
console.log("i2:" + typeof(i2));

