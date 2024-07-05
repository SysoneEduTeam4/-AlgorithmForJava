const fs = require('fs');
const input = fs.readFileSync('example.txt').toString().trim().split('\n');

const N = input.shift();

const inputArr = input.map((v)=>v.split(""));


let visited = Array.from({length: Number(N)},()=>Array( Number(N)).fill(0));



const dx=[1,-1,0,0];
const dy = [0,0,1,-1];

const solution =(x,y,str)=>{
    visited[x][y]=1;
    for(let i=0;i<4;i++){
        let next_x = x+dx[i];
        let next_y = y+dy[i];
        if(next_x>=0 && next_x<N 
            && next_y>=0 && next_y<N&&
            visited[next_x][next_y]===0 && inputArr[next_x][next_y]===str){
            solution(next_x,next_y,str);
        }            
    }
}
const min_solution=(x,y,str)=>{

    visited[x][y]=1;
    for(let i=0;i<4;i++){
        let next_x = x+dx[i];
        let next_y = y+dy[i];
        if(next_x>=0 && next_x<N 
            && next_y>=0 && next_y<N&&
            visited[next_x][next_y]===0 ){
                if(str==='R'||str==='G'){
                    if(inputArr[next_x][next_y]==='R'||inputArr[next_x][next_y]==='G'){
                        min_solution(next_x,next_y,inputArr[next_x][next_y]);
                    }
                }
                else if (inputArr[next_x][next_y]===str){
                    min_solution(next_x,next_y,str);
                }
           
        }    
    }
}


 

let normal=0;
let redgreen=0;
for(let i=0;i<N;i++){
   for(let j=0;j<N;j++){
    if(visited[i][j]==0){
        
       solution(i,j,inputArr[i][j]);
              normal++;
       

    }
   
   }
}

 visited = Array.from({length: Number(N)},()=>Array( Number(N)).fill(0));
for(let i=0;i<N;i++){
    for(let j=0;j<N;j++){
     if(visited[i][j]==0){
         
    
         min_solution(i,j,inputArr[i][j]);
         redgreen++;
 
     }
    
    }
 }

console.log(normal+" "+redgreen);
