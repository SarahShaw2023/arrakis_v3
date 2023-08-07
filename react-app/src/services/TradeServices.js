
import http from './axios-common';

export function getAllBonds(){
  return http.get("/bonds");
}
export function getAllBondsMaturity(date){
  return http.get("/bonds/maturity?date=" + date.toISOString().split('T')[0]);
}

export function getAllTrades(userID){
  return http.get("/trades?userID=" + userID);
}

export function updateUser(email, username, password){
  return http.put("/updateUser?" + "email=" + email + 
                                 "&username=" + username + 
                                 "&password=" + password);
}

export function createAcc(email, username, password, role) {
  return http.post("/createAcc?" + "email=" + email + 
                                  "&username=" + username + 
                                  "&password=" + password +
                                  "&role=" + role);
}