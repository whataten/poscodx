/**
 * callback 지원 비동기 함수 사용법
 */
const {asyncFn01} = require('./async-fns');

// test : success
asyncFn01('param', (error, result) => {
    if(error) {
        console.error(error);
        return;
    } 

    console.log(result);

});

// test : fail
asyncFn01(null, (error, result) => {
    if(error) {
        console.error(error);
        return;
    } 

    console.log(result);
})

console.log('wait...');

