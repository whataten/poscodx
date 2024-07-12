/**
 * Array : 배열
 */

console.log("=== 배열 생성 1 : 내장개체 (생성자 함수) 사용하는 방법");
var a1 = new Array();
console.log(typeof(a1), a1 instanceof(Array), a1.length);

// 생성자 함수의 파라미터가 하나인 경우 : 배열의 크기
var a2 = new Array(10);
console.log(typeof(a2), a2 instanceof(Array), a2.length);

// 배열의 크기를 지정하는 것은 의미가 없다. → 동적으로 배열이 늘어나기 때문이다.
a2[0] = 0;
a2[5] = 5;
a2[10] = 10;

// 생성자 함수의 파라미터가 두 개 이상인 경우 : 초깃값 설정
var a3 = new Array(0, 2, 4, 6, 8);
console.log(a3, a3.length);

console.log("=== 배열 생성 2 : 리터럴을 사용하는 방법");
var a4 = [];
console.log(typeof(a4), a4 instanceof(Array), a4.length);

// 배열 요소의 타입은 동일하지 않아도 된다.
var a5 = [10, 'javascript', true, undefined, {
    name: "ten",
    age: 26
}, function() {
    console.log("hello world")
}, null];

a5[5]();

console.log("=== 배열 순회 ===");
for(var i = 0; i < a5.length; i++) {
    console.log(a5[i]);
}

console.log("=== Array vs Object ===");
var a6 = [];
a6[0] = 0;
a6['1'] = 1;
a6['2'] = 2;
console.log(a6['0'], a6[1], a6[2], a6.length);


var o6 = {};
o6[0] = 0;
o6['1'] = 1;
o6['2'] = 2;
o6.name = 'ten';
o6.age = 26;
console.log(o6['0'], o6[1], o6[2], o6.name, o6.age, o6.length);
console.log("=== for ~ in 객체 ===");
for(prop in o6) {
    console.log(prop + ":" + o6[prop]);
}