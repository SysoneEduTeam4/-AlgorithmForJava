const fs = require('fs');
[tc,...array] = fs.readFileSync('example.txt').toString().trim().split("\n");

let clothes=[];
let count=-1; //0번째 index는 숫자이므로
for(let i=0;i<array.length;i++){
  if(isNaN(array[i]))// 숫자가 아니면 
  {

    clothes[count].push(array[i].split(" ")); //clothes배열에 옷정보 push

  }
  else{ //숫자면
    clothes.push([]); //배열을 띄어준다. 
    count ++;
  }
}
let result ="";
for(let i of clothes){
  let count =1;
  let arr =i;
  let map = new Map(); //map 생성
  for(let j =0;j<arr.length;j++){
    {map.has(arr[j][1])? 
      map.set(arr[j][1],map.get(arr[j][1])+1)://value가 map에 존재하면
      map.set(arr[j][1],1);
  }
}
for(let m of map.values()){
  count *=m+1; //선택을 안하는 경우의 수도 세워줘야하므로
}
result += (count-1)+'\n';
}
console.log(result);