/**
 * promise 지원 비동기 함수 사용법 1 : ~ then ~ catch
 */

const{asyncFn02} = require('./async-fns');

// test : success
asyncFn02("param").then((result) => {
    console.log(result);
}).catch((error) => {
    console.error(error);
});

// test : fail
asyncFn02(null).then((result) => {
    console.log(result);
}).catch((error) => {
    console.error(error);
});

console.log('wait');