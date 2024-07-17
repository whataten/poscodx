/**
 * promise 지원 비동기 함수 사용법 1 : async ~ await
 */

const{asyncFn02} = require('./async-fns');

// test : success
const fn = async (params) => {
    const result = await asyncFn02(params);
    console.log(result);
}

// test : fail
// asyncFn02(null).then((result) => {
//     console.log(result);
// }).catch((error) => {
//     console.error(error);
// });

fn('params');

console.log('wait');

const fetchEmail = () => {
    const emails = await fetch("/api/");
    setEmails(emails);
}