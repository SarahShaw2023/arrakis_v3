
import http from './axios-common';



export function getAllBonds(){
  return http.get("/bonds");
}
export function getAllBondsMaturity(){
  return http.get("/bonds/maturity");
}

// export const findBonds = () => {
//   const pets = axios.get(`${hostNameUrl}/dogs`);
//   return pets;
// };