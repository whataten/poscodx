// callback 지원 비동기함수
exports.asyncFn01 = function(param, callback) { 
    // 비동기 코드
    setTimeout(() => {
        if(param !== null) {
            // 성공 (성공 시 앞에는 널을 넣어준다.)
            callback(null, {result: 'success'});
        } else {
            // 에러
            callback(new Error('fail'), null);
        }
    }, 3000);
}

// promise 지원 비동기함수
exports.asyncFn02 = function(param) {
    return new Promise((resolve, reject) => {
        // 비동기 코드
        setTimeout(() => {
            if(param !== null) {
                // 성공
                resolve({result: 'success'});
            } else {
                // 에러
                reject(new Error('fail'));
            }
        }, 3000);
    });
}