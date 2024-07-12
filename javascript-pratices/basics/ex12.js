/**
 * Array 확장 (prototype 기반의 확장)
 * 예제 : List 함수 추가
 */

Array.prototype.remove = function(index) {
    console.log('call remove : ' + index);
}

Array.prototype.insert = function(index, value) {
    value.forEah(function(e) {
        this.splice(index++, 0, e);
    });
}

// List 함수 사용하기
var a = [1, 2, 3];
console.log(a);

a.insert(2,3)
console.log(a);

a.remove(2);
console.log(a);
