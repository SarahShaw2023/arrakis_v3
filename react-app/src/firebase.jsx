///@@ -0,0 +1,22 @@
// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyC14VagXFdXagJkHADBkZJ1eLBBHr2o21s",
  authDomain: "coding-challenge-4580a.firebaseapp.com",
  projectId: "coding-challenge-4580a",
  storageBucket: "coding-challenge-4580a.appspot.com",
  messagingSenderId: "901673353720",
  appId: "1:901673353720:web:fb69bfa14e57bf01e2d60d",
  measurementId: "G-SDJ64SELVK"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
export default auth;