const fs = require('fs');
const [nm,...arr] = fs.readFileSync("example.txt").toString().trim().split("\n"); //d입력받기
const [n,m] = nm.split(' ');
const pw = new Map(); //map 생성

for(let i=0;i<n;i++){
 
    pw.set(arr[i].split(' ')[0],arr[i].split(' ')[1]);  
//시이트 주소는 key로 비밀번호는 value로 map 에 넣기
}

let result ='';

for(let i=n;i<arr.length;i++){
        result+=pw.get(arr[i])+"\n"; //map key에 맞는 value 가져오기 
}
console.log(result);