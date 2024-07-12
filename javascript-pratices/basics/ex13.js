/**
 * string primitive 타입과 string 객체 함수 (string.prototype.*)
 */

// 배열처럼 접근이 가능하다.
var str1 = 'hello world';
for (var i = 0; i < str1.length; i++) {
    console.log(str1[i]);
}

// 문자열 합치기
var str2 = 'hello';
var str3 = 'world';
var str4 = str2 + str3;
console.log(str4);

// casting
var str5 = '5' + 5;
console.log(str5);

var str6 = 'boolean:' + true;
console.log(str6);

// 객체 함수
var str7 = 'string1 string2 string3';
var index = str7.indexOf('string2');
console.log(index);

index = str7.indexOf('string4');
console.log(index);

str7.substring(10/*firstindex*/, 13/*last index*/);
console.log();