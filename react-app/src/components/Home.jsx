import React, { useState, useEffect } from "react";
import { getAllBonds, getAllBondsMaturity, getAllTrades, getAllTradesWithClients } from '../services/TradeServices';
import { useNavigate } from "react-router-dom";
import DatePicker from "react-datepicker";
import 'react-datepicker/dist/react-datepicker.css'

export const Home = ({userID, setUserID}) => {
    
    const [bonds,setBonds] = useState([]);
    const [bondsMaturity,setBondsMaturity] = useState([]);
    const [trades,setTrades] = useState([]);

    const [date, setDate] = useState(new Date());
    const navigate = useNavigate();

    if(userID == 0)
        navigate("/login")

    useEffect(()=>{
        getAllBondsMaturity(date)
            .then(res => {
                console.log(res.data);
                setBondsMaturity(res.data);
                setDate(date);
            })
            .catch(err => {
                setBondsMaturity([]);
                console.log(err);
        })
    }, [date]);
    useEffect(()=>{
        getBondsFromAPI();
        getTradesFromAPI()}, 
        []
    );
    const getBondsFromAPI = ()=>{
        getAllBonds()
            .then(res => {
                console.log(res.data);
                setBonds(res.data);
            })
            .catch(err => {
                setBonds([]);
                console.log(err);
        })
    }
    const getTradesFromAPI = ()=>{
        //getAllTrades(userID)
        getAllTradesWithClients(userID)
            .then(res => {
                console.log(res.data);
                setTrades(res.data);
            })
            .catch(err => {
                setTrades([]);
                console.log(err);
        })
    }
    const statusCheck = (status) => {
        if (status === "active" || status === "open") {
            return <font color="green">{status}</font>;
        }
        return status;
    }
    const createBondRowByISIN = (data) => {     
        return <tr>
            <td>{data.isin}</td>
            <td>{data.couponPercent}</td>
            <td>{data.bondCurrency}</td>
            <td>{data.cusip}</td>
            <td>{data.faceValue}</td>
            <td>{data.issuerName}</td>
            <td>{data.bondMaturity}</td>
            <td>{statusCheck(data.status)}</td>
            <td>{data.type}</td>
        </tr>
    }
    const createBondRowByMaturity = (data) => {     
        return <tr>
            <td>{data.bondMaturity}</td>
            <td>{data.couponPercent}</td>
            <td>{data.bondCurrency}</td>
            <td>{data.cusip}</td>
            <td>{data.faceValue}</td>
            <td>{data.isin}</td>
            <td>{data.issuerName}</td>
            <td>{statusCheck(data.status)}</td>
            <td>{data.type}</td>
        </tr>
    }
    const createTradeRow = (data) => {     
        return <tr>
            <td>{data.book_id}</td>
            <td>{data.bond_id}</td>
            <td>{data.clientId}</td>
            <td>{data.clientName}</td>
            <td>{data.quantity}</td>
            <td>{data.currency}</td>
            <td>{statusCheck(data.status)}</td>
            <td>{data.type}</td>
            <td>{data.unit_price}</td>
            <td>{statusCheck(data.trade_date)}</td>
            <td>{data.settlement_date}</td>
        </tr>
    }
    const onLogoutClick = () => {
        // navigate("/home");
        window.location.replace('/home');
        // TODO: clear out/reset user login info
    }
  return (
    <>
    <div className={"containerRight"}>
        <input type="button" onClick={onLogoutClick} value={"Logout"} className={"right"} />
      </div>
    <div>
        <table style={{backgroundColor:"white"}}>
            <thead>
                <tr><th colSpan="9">Bond Overview</th></tr>
            </thead>
            <tbody>
                <tr>
                    <th>ISIN</th>
                    <th>Coupon Percent</th>
                    <th>Bond Currency</th>
                    <th>CUSIP</th>
                    <th>Face Value</th>
                    <th>Issuer Name</th>
                    <th>Bond Maturity</th>
                    <th>Status</th>
                    <th>Type</th>
                </tr>
                {bonds.map(row => createBondRowByISIN(row))}
            </tbody>
            
        </table>
        
    </div>
    <div className={"space"}></div>
    <div>
        <table style={{backgroundColor:"white"}}>
            <thead>
                <tr><th colSpan="11">All Trades</th></tr>
            </thead>
            <tbody>
                <tr>
                    <th>Book ID</th>
                    <th>Bond ID</th>
                    <th>Client ID</th>
                    <th>Client Name</th>
                    <th>Quantity</th>
                    <th>Currency</th>
                    <th>Status</th>
                    <th>Type</th>
                    <th>Unit Price</th>
                    <th>Trade Date</th>
                    <th>Settlement Date</th>
                </tr>
                {trades.map(row => createTradeRow(row))}
            </tbody>
            
        </table>
        
    </div>
    <div className={"space"}></div>
    <div>
      <DatePicker dateFormat="dd/MM/yyyy" selected={date} onChange={(d) => {console.log(d.toISOString().split('T')[0]); setDate(d)}} />
    </div>
    <div>
    <table style={{backgroundColor:"white"}}>
        <thead>
            <tr><th colSpan="9">View Bonds by Maturity</th></tr>
        </thead>
        <tbody>
            <tr>
                <th>Bond Maturity</th>
                <th>Coupon Percent</th>
                <th>Bond Currency</th>
                <th>CUSIP</th>
                <th>Face Value</th>
                <th>ISIN</th>
                <th>Issuer Name</th>
                <th>Status</th>
                <th>Type</th>
            </tr>
            {bondsMaturity.map(row => createBondRowByMaturity(row))}
        </tbody>
        
    </table>

    </div> 
    <div className={"space"}></div>
    </>
  )
}

export default Home
