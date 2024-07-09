const fs = require('fs');
const input = fs.readFileSync('example.txt').toString().trim().split('\n');

const tc = input.shift();

const inputArr = input.map((v)=>v.split(" ").map(Number));


let map= [];
let a,b,c;
const dx = [0, 0, -1, 1];
const dy = [-1, 1, 0, 0];

const solution=(x,y) =>{
    map[x][y]=0;
    for(let i=0;i<4;i++){
        let next_x = x+dx[i];
        let next_y = y+dy[i];

        if(next_x>=0&&next_x<b
            &&next_y>=0&&next_y<a
            &&map[next_x][next_y]===1
        )
        {
            solution(next_x,next_y);
        }

    }
}


let answer;
for(let i=0;i<tc;i++){
    answer=0;
    [a,b,c] = inputArr.shift();
    map = Array.from(Array(b),()=>Array(a).fill(0));
    for(let j=0;j<c;j++){
        const[x,y]  =inputArr.shift();
        map[y][x]=1;
    }
    for(let j=0;j<b;j++){
        for(let k=0;k<a;k++){
            if(map[j][k]===1){
               
                solution(j,k);
                
                answer++;
            }
        }
    }
   console.log(answer);
    

}
