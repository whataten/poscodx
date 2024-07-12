/**
 * 자바스크립트 객체1 - object 타입
 * 1. 자바스크립트 객체는 function 타입과 object 타입 2가지가 있다.
 * 2. 보통, function 타입의 객체는 "함수"라고 부른다.
 * 3. 따라서 자바스크립트에서 객체라고 부르는 것은 object 타입의 객체를 가리킨다.
 */

// 생성 방법 1
// 생성자 함수를 사용하는 방법
// 1. Number, Boolean, String, Object, Array 내장 객체(생성자 함수)
// 2. 사용자 정의 생성자 함수
var o1 = new Object();
o1.name = 'ten';
o1.age = 26;
o1.another = new Object();
o1.another.name = 'rloxx';
o1.another.age = 26;

// 생성 방법 2
// {} literal 
var o2 = {};
o2.name = 'ten';
o2.age = 26;
o2.another = new Object();
o2.another.name = 'rloxx';
o2.another.age = 26;

// 생성 방법 3
// JavaScript Object Notation
var o3 = {
    name : "ten",
    age : 26,
    another : {
        name : "rloxx",
        age: 26
    }
};

// XmlHttpRequest 객체를 사용해서 통신(Ajax)
var response = '{name: "ten", age: 26, email: "ten@email.com"}';
var userVo = eval("("+ response + ")");
console.log(userVo.name + ":" + userVo.age + ":" + userVo.email);

/**
 * 자바스크립트 객체2 - function 타입
 */

// 일반함수(실행코드블록이 있는 함수, 관례대로 소문자로 시작한다.)
var myFunction = function() {
    console.log('일반함수');
}

// 생성자함수(관례대로 소문자로 시작한다.)
var myObject = function(name, age) {
    this.name = name;
    this.age = age;
}

class MyObject {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
}

var o1 = new MyObject("ten", 26);
var o2 = new MyObject("rloxx", 26);

console.log(o1);
console.log(o2);

/**
 * 자바스크립트 객체3 - 확장
 */

var o = {
    name: "ten",
    age: 26
};

o.another = {
    name: "rloxx",
    age: 26,
    print: function() {
        console.log(this.name + ":" + this.age);
    }
}

o.another.print();

var f = function() {
    console.log('hello world');
}