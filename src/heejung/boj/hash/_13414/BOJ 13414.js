const fs = require('fs');
const [kl,...students] = fs.readFileSync('example.txt').toString().split("\n");
//const [kl,...students] = fs.readFileSync('/dev/stdin').toString().trim().split('\n');


const [k, l] = kl.split(' ').map((it) => Number(it));
const studentsMap = new Map();

for(const target of students) {
    if(studentsMap.has(target)){
        studentsMap.delete(target);
    }
    studentsMap.set(target);
}

let cnt =0;
let result = "";

studentsMap.forEach((_,key)=>{
    if(cnt<k) {
        cnt++
        result = result + key + "\n";
    }
    
})

console.log(result);